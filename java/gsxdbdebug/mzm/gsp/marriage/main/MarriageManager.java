/*     */ package mzm.gsp.marriage.main;
/*     */ 
/*     */ import gnet.link.Onlines;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.NavigableMap;
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import java.util.TreeMap;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.buff.main.BuffInterface;
/*     */ import mzm.gsp.children.main.ChildrenInterface;
/*     */ import mzm.gsp.friend.main.FriendInterface;
/*     */ import mzm.gsp.mail.main.MailInterface;
/*     */ import mzm.gsp.map.Location;
/*     */ import mzm.gsp.map.main.ControllerInterface;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.map.main.group.MapGroupType;
/*     */ import mzm.gsp.marriage.ParadeRoleInfo;
/*     */ import mzm.gsp.marriage.RoleInfo;
/*     */ import mzm.gsp.marriage.SBrocastEndParade;
/*     */ import mzm.gsp.marriage.SBrocastStartParade;
/*     */ import mzm.gsp.marriage.SMarriageNormalResult;
/*     */ import mzm.gsp.marriage.SParadeAttackErrorRes;
/*     */ import mzm.gsp.marriage.SSynMarriageInfo;
/*     */ import mzm.gsp.marriage.confbean.ParadeNumCfg;
/*     */ import mzm.gsp.marriage.confbean.SMarriageConsts;
/*     */ import mzm.gsp.marriage.confbean.SMarriageParadeCfg;
/*     */ import mzm.gsp.marriage.confbean.SMarriageParadeRobConsts;
/*     */ import mzm.gsp.marriage.confbean.SMarriageTitileCfg;
/*     */ import mzm.gsp.marriage.confbean.SParadeControlCfg;
/*     */ import mzm.gsp.marriage.confbean.SWeddingPlayMap;
/*     */ import mzm.gsp.marriage.event.DivorceArg;
/*     */ import mzm.gsp.marriage.event.DivorceEvent;
/*     */ import mzm.gsp.marriage.event.MarrySkillChange;
/*     */ import mzm.gsp.marriage.event.MarrySkillChangeArg;
/*     */ import mzm.gsp.monster.main.MonsterInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.skill.confbean.MarrySkillCfg;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.title.main.TitleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.LogicRunnable;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.MarriageParade;
/*     */ import xbean.MarriageParades;
/*     */ import xbean.MarriageSkill;
/*     */ import xbean.Pod;
/*     */ import xdb.Xdb;
/*     */ import xtable.Role2marriage;
/*     */ import xtable.Role2marriageskill;
/*     */ 
/*     */ class MarriageManager
/*     */ {
/*     */   static final int DIVORCE_NORMAL = 0;
/*     */   static final int DIVORCE_FORCE = 1;
/*     */   
/*     */   static void init() {}
/*     */   
/*     */   static boolean isInForceDivorce(long roleid)
/*     */   {
/*  76 */     Long marriageId = Role2marriage.select(Long.valueOf(roleid));
/*  77 */     if (marriageId == null) {
/*  78 */       return false;
/*     */     }
/*  80 */     xbean.Marriage marriage = xtable.Marriage.select(marriageId);
/*  81 */     if (marriage == null) {
/*  82 */       GameServer.logger().error(String.format("[Marriage]MarriageInterface.getMarriedRoleid@marriage date error bug|marriage=%d|roleid=%d", new Object[] { marriageId, Long.valueOf(roleid) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  87 */       return false;
/*     */     }
/*  89 */     return marriage.getParammap().containsKey(Integer.valueOf(2));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static long getMarriedRoleid(long roleid)
/*     */   {
/*  99 */     return getMarriedRoleid(roleid, false);
/*     */   }
/*     */   
/*     */   static boolean onForceDivorce(long marriageId, xbean.Marriage marriage) {
/* 103 */     long roleidA = marriage.getRoleida();
/* 104 */     long roleidB = marriage.getRoleidb();
/* 105 */     Role2marriage.remove(Long.valueOf(marriage.getRoleida()));
/* 106 */     Role2marriage.remove(Long.valueOf(marriage.getRoleidb()));
/* 107 */     boolean ret = xtable.Marriage.remove(Long.valueOf(marriageId));
/* 108 */     int friendValue = FriendInterface.getRelationValue(roleidA, roleidB, true);
/* 109 */     int cutValue = friendValue - SMarriageConsts.getInstance().forceDivorceFriendValue;
/* 110 */     if (cutValue > 0) {
/* 111 */       FriendInterface.cutFriendValue(roleidA, roleidB, cutValue);
/*     */     }
/* 113 */     afterDivorce(marriageId, marriage);
/* 114 */     long marriageTime = marriage.getMarrytime();
/* 115 */     long curTime = DateTimeUtils.getCurrTimeInMillis();
/* 116 */     int intervalMill = (int)(curTime - marriageTime);
/* 117 */     tlogDivorce(roleidA, roleidB, 1, intervalMill);
/* 118 */     tlogDivorce(roleidB, roleidA, 1, intervalMill);
/*     */     
/* 120 */     MailInterface.synBuildAndSendMail(roleidA, SMarriageConsts.getInstance().divorceMail, new ArrayList(), Arrays.asList(new String[] { RoleInterface.getName(roleidB) }), new TLogArg(LogReason.MARRIAGE_FORCE_DIVORCE_EFFECT));
/*     */     
/* 122 */     MailInterface.synBuildAndSendMail(roleidB, SMarriageConsts.getInstance().divorceMail, new ArrayList(), Arrays.asList(new String[] { RoleInterface.getName(roleidA) }), new TLogArg(LogReason.MARRIAGE_FORCE_DIVORCE_EFFECT));
/*     */     
/* 124 */     return ret;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void afterDivorce(long marriageid, xbean.Marriage marriage)
/*     */   {
/* 133 */     long roleid = marriage.getRoleida();
/* 134 */     long otherRoleid = marriage.getRoleidb();
/* 135 */     int genderReq = RoleInterface.getGender(roleid);
/* 136 */     SMarriageTitileCfg marriageTitileCfg = SMarriageTitileCfg.get(marriage.getMarriagetitle());
/* 137 */     if (marriageTitileCfg != null) {
/* 138 */       if (genderReq == 2) {
/* 139 */         TitleInterface.removeAppllation(roleid, marriageTitileCfg.womenTitle);
/* 140 */         TitleInterface.removeAppllation(otherRoleid, marriageTitileCfg.manTitle);
/*     */       } else {
/* 142 */         TitleInterface.removeAppllation(roleid, marriageTitileCfg.manTitle);
/* 143 */         TitleInterface.removeAppllation(otherRoleid, marriageTitileCfg.womenTitle);
/*     */       }
/*     */     }
/* 146 */     BuffInterface.uninstallBuf(roleid, SMarriageConsts.getInstance().marriageBuffid1);
/* 147 */     BuffInterface.uninstallBuf(roleid, SMarriageConsts.getInstance().womenModelBuff);
/*     */     
/* 149 */     BuffInterface.uninstallBuf(otherRoleid, SMarriageConsts.getInstance().marriageBuffid1);
/* 150 */     BuffInterface.uninstallBuf(otherRoleid, SMarriageConsts.getInstance().manModelBuff);
/*     */     
/* 152 */     BuffInterface.uninstallBuf(roleid, SMarriageConsts.getInstance().coupleInteamBuffid);
/* 153 */     BuffInterface.uninstallBuf(otherRoleid, SMarriageConsts.getInstance().coupleInteamBuffid);
/*     */     
/* 155 */     Role2marriageskill.remove(Long.valueOf(roleid));
/* 156 */     Role2marriageskill.remove(Long.valueOf(otherRoleid));
/*     */     
/*     */ 
/* 159 */     MarrySkillChangeArg marrySkillChangeArg1 = new MarrySkillChangeArg(roleid);
/* 160 */     TriggerEventsManger.getInstance().triggerEvent(new MarrySkillChange(), marrySkillChangeArg1);
/*     */     
/* 162 */     MarrySkillChangeArg marrySkillChangeArg2 = new MarrySkillChangeArg(otherRoleid);
/* 163 */     TriggerEventsManger.getInstance().triggerEvent(new MarrySkillChange(), marrySkillChangeArg2);
/*     */     
/* 165 */     boolean isSendChildAbortion = (marriage.getGive_birth_score_enough_time() != 0L) || (marriage.getChild_belong_role_id() != 0L);
/*     */     
/*     */ 
/* 168 */     ChildrenInterface.onDivorce(marriageid, roleid, otherRoleid, isSendChildAbortion);
/*     */     
/* 170 */     TriggerEventsManger.getInstance().triggerEvent(new DivorceEvent(), new DivorceArg(roleid, otherRoleid, marriageid));
/*     */   }
/*     */   
/*     */   static Integer getWeddingPlayCfg(int level, int step)
/*     */   {
/* 175 */     SWeddingPlayMap weddingMap = SWeddingPlayMap.get(level);
/* 176 */     if (weddingMap == null) {
/* 177 */       return null;
/*     */     }
/* 179 */     return (Integer)weddingMap.step2Time.get(Integer.valueOf(step));
/*     */   }
/*     */   
/*     */   static void tlogMarriage(long roleid, long roleid1, int marriageLevelCfg, int timeMil) {
/* 183 */     String userid = RoleInterface.getUserId(roleid);
/* 184 */     int rolelevel = RoleInterface.getLevel(roleid);
/* 185 */     int rolelevel1 = RoleInterface.getLevel(roleid1);
/* 186 */     String userid1 = RoleInterface.getUserId(roleid1);
/* 187 */     String openid1 = Onlines.getInstance().findOpenid(userid1);
/*     */     
/*     */ 
/* 190 */     String logStr = String.format("%s|%d|%d|%s|%d|%d|%d|%d", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(rolelevel), openid1, Long.valueOf(roleid1), Integer.valueOf(rolelevel1), Integer.valueOf(timeMil), Integer.valueOf(marriageLevelCfg) });
/*     */     
/* 192 */     TLogManager.getInstance().addLog(userid, "Marriage", logStr);
/*     */   }
/*     */   
/*     */   static void tlogDivorce(long roleid, long roleid1, int divorceStyle, int timeMil) {
/* 196 */     String userid = RoleInterface.getUserId(roleid);
/* 197 */     int rolelevel = RoleInterface.getLevel(roleid);
/* 198 */     int rolelevel1 = RoleInterface.getLevel(roleid1);
/* 199 */     String userid1 = RoleInterface.getUserId(roleid1);
/* 200 */     String openid1 = Onlines.getInstance().findOpenid(userid1);
/*     */     
/*     */ 
/* 203 */     String logStr = String.format("%s|%d|%d|%s|%d|%d|%d|%d", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(rolelevel), openid1, Long.valueOf(roleid1), Integer.valueOf(rolelevel1), Integer.valueOf(timeMil), Integer.valueOf(divorceStyle) });
/*     */     
/* 205 */     TLogManager.getInstance().addLog(userid, "Divorce", logStr);
/*     */   }
/*     */   
/*     */   static void sendNormalResult(long roleid, int ret, String... args) {
/* 209 */     SMarriageNormalResult normalResult = new SMarriageNormalResult();
/* 210 */     fillNormalResult(normalResult, ret, args);
/* 211 */     OnlineManager.getInstance().sendAtOnce(roleid, normalResult);
/*     */   }
/*     */   
/*     */   static void sendNormalResult(Collection<Long> roleids, int ret, String... args) {
/* 215 */     SMarriageNormalResult normalResult = new SMarriageNormalResult();
/* 216 */     fillNormalResult(normalResult, ret, args);
/* 217 */     OnlineManager.getInstance().sendMultiAtOnce(normalResult, roleids);
/*     */   }
/*     */   
/*     */   private static void fillNormalResult(SMarriageNormalResult normalResult, int ret, String... args) {
/* 221 */     normalResult.result = ret;
/* 222 */     for (String arg : args) {
/* 223 */       normalResult.args.add(arg);
/*     */     }
/*     */   }
/*     */   
/*     */   static void sendNormalResult(long roleid, int ret, List<String> args) {
/* 228 */     SMarriageNormalResult normalResult = new SMarriageNormalResult();
/* 229 */     normalResult.result = ret;
/* 230 */     if (args != null) {
/* 231 */       normalResult.args.addAll(args);
/*     */     }
/* 233 */     OnlineManager.getInstance().sendAtOnce(roleid, normalResult);
/*     */   }
/*     */   
/*     */   static void fillInMarriageInfo(SSynMarriageInfo sSynMarriageInfo, xbean.Marriage marriage, long roleid) {
/* 237 */     sSynMarriageInfo.marriagetitleid = marriage.getMarriagetitle();
/* 238 */     sSynMarriageInfo.marrrytimesec = ((int)(marriage.getMarrytime() / 1000L));
/* 239 */     fillInRoleInfo(sSynMarriageInfo.roleinfo, roleid);
/* 240 */     Integer divorceValue = (Integer)marriage.getParammap().get(Integer.valueOf(2));
/* 241 */     if (divorceValue != null) {
/* 242 */       if (divorceValue.intValue() == 1) {
/* 243 */         sSynMarriageInfo.roleid = marriage.getRoleida();
/*     */       } else {
/* 245 */         sSynMarriageInfo.roleid = marriage.getRoleidb();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   static void fillInRoleInfo(RoleInfo roleInfo, long roleid) {
/* 251 */     roleInfo.roleid = roleid;
/* 252 */     roleInfo.rolename = RoleInterface.getName(roleid);
/*     */   }
/*     */   
/*     */   static void fillInParadeRoleInfo(ParadeRoleInfo paradeRoleInfo, long roleid) {
/* 256 */     paradeRoleInfo.roleid = roleid;
/* 257 */     paradeRoleInfo.rolename = RoleInterface.getName(roleid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static List<Integer> randomParadeControlCfg(int paradeLevelCfgid, int count, int except)
/*     */   {
/* 267 */     List<Integer> ret = new ArrayList();
/* 268 */     SParadeControlCfg paradeControlCfg = SParadeControlCfg.get(paradeLevelCfgid);
/* 269 */     List<Integer> randomList = new ArrayList(paradeControlCfg.num2CfgMap.keySet());
/* 270 */     randomList.remove(new Integer(except));
/* 271 */     if (count >= randomList.size()) {
/* 272 */       return randomList;
/*     */     }
/* 274 */     for (int i = 0; i < count; i++) {
/* 275 */       int size = randomList.size();
/* 276 */       int index = Xdb.random().nextInt(size);
/* 277 */       ret.add(randomList.remove(index));
/*     */     }
/* 279 */     return ret;
/*     */   }
/*     */   
/*     */   public static List<Integer> randomRobSeqsParadeControlCfg(int paradeCfgid, int count, int except) {
/* 283 */     List<Integer> ret = new ArrayList();
/* 284 */     SParadeControlCfg paradeControlCfg = SParadeControlCfg.get(paradeCfgid);
/* 285 */     List<Integer> randomList = new ArrayList(paradeControlCfg.robSeqNums);
/* 286 */     randomList.remove(new Integer(except));
/* 287 */     if (count >= randomList.size()) {
/* 288 */       return randomList;
/*     */     }
/* 290 */     for (int i = 0; i < count; i++) {
/* 291 */       int size = randomList.size();
/* 292 */       int index = Xdb.random().nextInt(size);
/* 293 */       ret.add(randomList.remove(index));
/*     */     }
/* 295 */     return ret;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static List<Location> getPointSeqsLessOrEqual(int paradecfgid, int seq)
/*     */   {
/* 308 */     List<Location> ret = new ArrayList();
/* 309 */     SParadeControlCfg paradeControlCfg = SParadeControlCfg.get(paradecfgid);
/* 310 */     NavigableMap<Integer, ParadeNumCfg> paradeNumCfgMap = paradeControlCfg.num2CfgMap.headMap(Integer.valueOf(seq), true);
/* 311 */     for (Map.Entry<Integer, ParadeNumCfg> entry : paradeNumCfgMap.entrySet()) {
/* 312 */       Location location = new Location(((ParadeNumCfg)entry.getValue()).x, ((ParadeNumCfg)entry.getValue()).y);
/* 313 */       ret.add(location);
/*     */     }
/* 315 */     return ret;
/*     */   }
/*     */   
/*     */   static class LocationToSeq {
/* 319 */     List<Location> pathList = new ArrayList();
/* 320 */     List<Integer> seqs = new ArrayList();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static LocationToSeq getPointSeqsBetween(int paradecfgid, int seq1, int seq2)
/*     */   {
/* 335 */     LocationToSeq locationToSeq = new LocationToSeq();
/* 336 */     SParadeControlCfg paradeControlCfg = SParadeControlCfg.get(paradecfgid);
/* 337 */     NavigableMap<Integer, ParadeNumCfg> paradeNumCfgMap = paradeControlCfg.num2CfgMap.subMap(Integer.valueOf(seq1), false, Integer.valueOf(seq2), true);
/*     */     
/* 339 */     for (Map.Entry<Integer, ParadeNumCfg> entry : paradeNumCfgMap.entrySet()) {
/* 340 */       Location location = new Location(((ParadeNumCfg)entry.getValue()).x, ((ParadeNumCfg)entry.getValue()).y);
/* 341 */       locationToSeq.pathList.add(location);
/* 342 */       locationToSeq.seqs.add(entry.getKey());
/*     */     }
/* 344 */     return locationToSeq;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getPointSeqBigger(int seq, Set<Integer> seqs)
/*     */   {
/* 354 */     int ret = -1;
/* 355 */     for (Iterator i$ = seqs.iterator(); i$.hasNext();) { int temp = ((Integer)i$.next()).intValue();
/* 356 */       if ((temp > seq) && (
/* 357 */         (ret == -1) || (temp < ret))) {
/* 358 */         ret = temp;
/*     */       }
/*     */     }
/*     */     
/* 362 */     return ret;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean startMarriageParade(MarriageParade xMarriageParade)
/*     */   {
/* 373 */     final int paracfgid = xMarriageParade.getLevel();
/* 374 */     SMarriageParadeCfg marriageParadeCfg = SMarriageParadeCfg.get(paracfgid);
/* 375 */     Set<Integer> allSeqs = new HashSet();
/* 376 */     allSeqs.addAll(xMarriageParade.getStoppointseqs());
/* 377 */     allSeqs.addAll(xMarriageParade.getGivemoneypointseqs());
/* 378 */     allSeqs.addAll(xMarriageParade.getRobseqs());
/* 379 */     int ret = getPointSeqBigger(1, allSeqs);
/*     */     
/* 381 */     if (ret >= 0) {
/* 382 */       long roleid1 = xMarriageParade.getRoleid1();
/* 383 */       long roleid2 = xMarriageParade.getRoleid2();
/*     */       
/* 385 */       new ParadeCheckSession(marriageParadeCfg.paradeMaxTimeSec, xMarriageParade.getTimemil(), roleid1);
/*     */       
/*     */ 
/* 388 */       NoneRealTimeTaskManager.getInstance().addTask(new LogicRunnable()
/*     */       {
/*     */         public void process() throws Exception
/*     */         {
/* 392 */           SBrocastStartParade sBrocastStartParade = new SBrocastStartParade();
/* 393 */           sBrocastStartParade.role1info.roleid = this.val$roleid1;
/* 394 */           sBrocastStartParade.role1info.rolename = RoleInterface.getName(this.val$roleid1);
/* 395 */           sBrocastStartParade.role2info.roleid = paracfgid;
/* 396 */           sBrocastStartParade.role2info.rolename = RoleInterface.getName(paracfgid);
/* 397 */           sBrocastStartParade.paradecfgid = this.val$paracfgid;
/* 398 */           OnlineManager.getInstance().sendAllAtOnce(sBrocastStartParade);
/*     */         }
/*     */         
/* 401 */       });
/* 402 */       long timeMil = xMarriageParade.getTimemil();
/* 403 */       MapInterface.addMapGroup(MapGroupType.MGT_MARRIAGE, timeMil, Arrays.asList(new Long[] { Long.valueOf(roleid1), Long.valueOf(roleid2) }), marriageParadeCfg.paradeSpeed, getMarriageParadeExtraMap(marriageParadeCfg, xMarriageParade));
/*     */       
/*     */ 
/*     */ 
/* 407 */       LocationToSeq locationToSeq = getPointSeqsBetween(paracfgid, -1, ret);
/* 408 */       GameServer.logger().info(String.format("[Marraige]PonArrivalPointSeq.nextSeq@seq=%d|marriagemil=%d", new Object[] { Integer.valueOf(ret), Long.valueOf(xMarriageParade.getTimemil()) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 413 */       Location location = (Location)locationToSeq.pathList.get(locationToSeq.pathList.size() - 1);
/* 414 */       int mapid = MapInterface.getRoleMapId(roleid1);
/*     */       
/* 416 */       MarriageParadeZoneForm marriageParadeZoneForm = new MarriageParadeZoneForm(location.x, location.y, ret, roleid1, mapid, timeMil, marriageParadeCfg.pathPointScale);
/*     */       
/*     */ 
/* 419 */       MapInterface.registerZoneEvent(mapid, marriageParadeZoneForm, 3, new MarriageParadeZoneListener(), new RegisterZoneCallBack(marriageParadeZoneForm));
/*     */       
/* 421 */       if (marriageParadeCfg.prepareSec > 0) {
/* 422 */         new ParadePrepareSession(marriageParadeCfg.prepareSec, timeMil, locationToSeq.pathList);
/*     */       } else {
/* 424 */         MapInterface.groupMove(MapGroupType.MGT_MARRIAGE, timeMil, locationToSeq.pathList);
/* 425 */         if (GameServer.logger().isDebugEnabled()) {
/* 426 */           StringBuffer stringBuffer = new StringBuffer();
/* 427 */           for (Location location2 : locationToSeq.pathList) {
/* 428 */             stringBuffer.append(location2.x).append(",").append(location2.y).append("|");
/*     */           }
/* 430 */           GameServer.logger().debug(String.format("[Marriage]MarriageMarriage.startMarriageParade@location|path=%s", new Object[] { stringBuffer.toString() }));
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 436 */       return true;
/*     */     }
/* 438 */     GameServer.logger().info(String.format("[Marriage]MarriageManager.startMarriageParade@map path config error|pathsize=%d|levelcfgid=%d", new Object[] { Integer.valueOf(allSeqs.size()), Integer.valueOf(xMarriageParade.getLevel()) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 443 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void stopMarraigeParade(MarriageParade xMarriageParade)
/*     */   {
/* 453 */     long roleid1 = xMarriageParade.getRoleid1();
/* 454 */     long roleid2 = xMarriageParade.getRoleid2();
/*     */     
/* 456 */     MapInterface.removeMapGroup(MapGroupType.MGT_MARRIAGE, xMarriageParade.getTimemil(), Arrays.asList(new Long[] { Long.valueOf(roleid1), Long.valueOf(roleid2) }));
/*     */     
/*     */ 
/*     */ 
/* 460 */     xdb.Procedure.execute(new LogicProcedure()
/*     */     {
/*     */       protected boolean processImp() throws Exception
/*     */       {
/* 464 */         List<Long> roleList = Arrays.asList(new Long[] { Long.valueOf(this.val$roleid1), Long.valueOf(this.val$roleid2) });
/* 465 */         lock(xtable.Role2properties.getTable(), roleList);
/* 466 */         RoleStatusInterface.unsetStatus(roleList, 29);
/* 467 */         SBrocastEndParade brocastEndParade = new SBrocastEndParade();
/* 468 */         brocastEndParade.role1info.roleid = this.val$roleid1;
/* 469 */         brocastEndParade.role1info.rolename = RoleInterface.getName(this.val$roleid1);
/* 470 */         brocastEndParade.role2info.roleid = this.val$roleid2;
/* 471 */         brocastEndParade.role2info.rolename = RoleInterface.getName(this.val$roleid2);
/* 472 */         OnlineManager.getInstance().sendAll(brocastEndParade);
/* 473 */         return true;
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */ 
/*     */   static Map<Integer, Integer> getMarriageParadeExtraMap(SMarriageParadeCfg marriageParadeCfg, MarriageParade xMarriageParade)
/*     */   {
/* 481 */     Map<Integer, Integer> extraMap = new HashMap();
/* 482 */     extraMap.put(Integer.valueOf(200), Integer.valueOf(xMarriageParade.getLevel()));
/* 483 */     if (marriageParadeCfg.prepareSec > 0) {
/* 484 */       int prepareEndSec = (int)(marriageParadeCfg.prepareSec + DateTimeUtils.getCurrTimeInMillis() / 1000L);
/* 485 */       extraMap.put(Integer.valueOf(201), Integer.valueOf(prepareEndSec));
/*     */     }
/* 487 */     return extraMap;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean nextSeq(int curSeq, MarriageParade xMarriageParade)
/*     */   {
/* 500 */     Set<Integer> allSeqs = new HashSet();
/* 501 */     allSeqs.addAll(xMarriageParade.getStoppointseqs());
/* 502 */     allSeqs.addAll(xMarriageParade.getGivemoneypointseqs());
/* 503 */     allSeqs.addAll(xMarriageParade.getRobseqs());
/* 504 */     int ret = getPointSeqBigger(curSeq, allSeqs);
/* 505 */     LocationToSeq locationToSeq = null;
/* 506 */     int paradecfgid = xMarriageParade.getLevel();
/* 507 */     SMarriageParadeCfg marriageParadeCfg = SMarriageParadeCfg.get(paradecfgid);
/* 508 */     if (ret >= 0) {
/* 509 */       locationToSeq = getPointSeqsBetween(paradecfgid, curSeq, ret);
/*     */     }
/*     */     else {
/* 512 */       locationToSeq = getPointSeqsBetween(paradecfgid, curSeq, Integer.MAX_VALUE);
/*     */     }
/* 514 */     if ((locationToSeq == null) || (locationToSeq.pathList.size() <= 0))
/*     */     {
/* 516 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 524 */     Location location = (Location)locationToSeq.pathList.get(locationToSeq.pathList.size() - 1);
/* 525 */     long roleid1 = xMarriageParade.getRoleid1();
/* 526 */     int mapid = MapInterface.getRoleMapId(roleid1);
/*     */     
/* 528 */     MarriageParadeZoneForm marriageParadeZoneForm = new MarriageParadeZoneForm(location.x, location.y, ((Integer)locationToSeq.seqs.get(locationToSeq.seqs.size() - 1)).intValue(), roleid1, mapid, xMarriageParade.getTimemil(), marriageParadeCfg.pathPointScale);
/*     */     
/*     */ 
/*     */ 
/* 532 */     MapInterface.registerZoneEvent(mapid, marriageParadeZoneForm, 3, new MarriageParadeZoneListener(), new RegisterZoneCallBack(marriageParadeZoneForm));
/*     */     
/*     */ 
/* 535 */     MapInterface.groupMove(MapGroupType.MGT_MARRIAGE, xMarriageParade.getTimemil(), locationToSeq.pathList);
/*     */     
/* 537 */     if (GameServer.logger().isDebugEnabled()) {
/* 538 */       StringBuffer stringBuffer = new StringBuffer();
/* 539 */       for (Location location2 : locationToSeq.pathList) {
/* 540 */         stringBuffer.append(location2.x).append(",").append(location2.y).append("|");
/*     */       }
/*     */       
/* 543 */       GameServer.logger().debug(String.format("[Marriage]MarriageMarriage.nextSeq@location|path=%s", new Object[] { stringBuffer.toString() }));
/*     */     }
/*     */     
/* 546 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void stopAndDoNextTurn(MarriageParades xMarriageParades, MarriageParade xMarriageParade)
/*     */   {
/* 556 */     SParadeControlCfg paradeControlCfg = SParadeControlCfg.get(xMarriageParade.getLevel());
/* 557 */     if (paradeControlCfg != null) {
/* 558 */       for (ParadeNumCfg paradeNumCfg : paradeControlCfg.num2CfgMap.values()) {
/* 559 */         if (paradeNumCfg.protectControlid > 0) {
/* 560 */           ControllerInterface.collectController(paradeNumCfg.protectControlid);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 565 */     xMarriageParades.getMarriageparades().remove(0);
/* 566 */     stopMarraigeParade(xMarriageParade);
/*     */     
/* 568 */     while (xMarriageParades.getMarriageparades().size() > 0) {
/* 569 */       boolean ret = startMarriageParade((MarriageParade)xMarriageParades.getMarriageparades().get(0));
/* 570 */       if (ret) {
/*     */         break;
/*     */       }
/* 573 */       xMarriageParades.getMarriageparades().remove(0);
/* 574 */       stopMarraigeParade(xMarriageParade);
/*     */     }
/*     */   }
/*     */   
/*     */   static long getMarriedRoleid(long roleid, boolean retainLock)
/*     */   {
/* 580 */     Long marriageId = null;
/* 581 */     if (retainLock) {
/* 582 */       marriageId = Role2marriage.get(Long.valueOf(roleid));
/*     */     } else {
/* 584 */       marriageId = Role2marriage.select(Long.valueOf(roleid));
/*     */     }
/*     */     
/* 587 */     if (marriageId == null) {
/* 588 */       return -1L;
/*     */     }
/* 590 */     xbean.Marriage marriage = null;
/* 591 */     if (retainLock) {
/* 592 */       marriage = xtable.Marriage.get(marriageId);
/*     */     } else {
/* 594 */       marriage = xtable.Marriage.select(marriageId);
/*     */     }
/* 596 */     if (marriage == null) {
/* 597 */       GameServer.logger().error(String.format("[Marriage]MarriageInterface.getMarriedRoleid@marriage date error bug|marriage=%d|roleid=%d", new Object[] { marriageId, Long.valueOf(roleid) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 602 */       return -1L;
/*     */     }
/* 604 */     if (roleid == marriage.getRoleida()) {
/* 605 */       return marriage.getRoleidb();
/*     */     }
/* 607 */     return marriage.getRoleida();
/*     */   }
/*     */   
/*     */   static void sendAttackParadeError(long roleid, int errorid, String... args)
/*     */   {
/* 612 */     SParadeAttackErrorRes paradeAttackErrorRes = getAndFillParadeAttackError(errorid, args);
/* 613 */     OnlineManager.getInstance().sendAtOnce(roleid, paradeAttackErrorRes);
/*     */   }
/*     */   
/*     */   static void sendAttackParadeError(List<Long> roleids, int errorid, String... args) {
/* 617 */     SParadeAttackErrorRes paradeAttackErrorRes = getAndFillParadeAttackError(errorid, args);
/* 618 */     OnlineManager.getInstance().sendMultiAtOnce(paradeAttackErrorRes, roleids);
/*     */   }
/*     */   
/*     */   private static SParadeAttackErrorRes getAndFillParadeAttackError(int errorid, String... args) {
/* 622 */     SParadeAttackErrorRes paradeAttackErrorRes = new SParadeAttackErrorRes();
/* 623 */     paradeAttackErrorRes.result = errorid;
/* 624 */     for (String arg : args) {
/* 625 */       paradeAttackErrorRes.args.add(arg);
/*     */     }
/* 627 */     return paradeAttackErrorRes;
/*     */   }
/*     */   
/*     */   static int setFightStatus(int setFightStatus, int originalStatus) {
/* 631 */     return setFightStatus | originalStatus;
/*     */   }
/*     */   
/*     */   static int unsetFightState(int unsetFightStatus, int originalStatus) {
/* 635 */     return originalStatus & (unsetFightStatus ^ 0xFFFFFFFF);
/*     */   }
/*     */   
/*     */   static boolean containsStatus(int fightStatus, int status) {
/* 639 */     return (fightStatus & status) > 0;
/*     */   }
/*     */   
/*     */   static void paradeCheckAndMoveOn(MarriageParades xMarriageParades, MarriageParade xMarriageParade) {
/* 643 */     int fight1Status = xMarriageParade.getBridefightstatus();
/* 644 */     int fight2Status = xMarriageParade.getGroomfightstatus();
/*     */     
/* 646 */     boolean fight1NotInFight = fight1Status == 0;
/* 647 */     boolean fight1FightEnd = (containsStatus(fight1Status, 2)) && (containsStatus(fight1Status, 4));
/*     */     
/* 649 */     boolean fight2NotInFight = fight2Status == 0;
/* 650 */     boolean fight2FightEnd = (containsStatus(fight2Status, 2)) && (containsStatus(fight2Status, 4));
/*     */     
/*     */ 
/* 653 */     boolean fight1OK = (fight1NotInFight) || (fight1FightEnd);
/* 654 */     boolean fight2OK = (fight2NotInFight) || (fight2FightEnd);
/*     */     
/* 656 */     if ((!xMarriageParade.getCanrob()) && (fight1OK) && (fight2OK)) {
/* 657 */       int curSeq = getMaxSeq(xMarriageParade.getArriveseqs());
/* 658 */       if (!nextSeq(curSeq, xMarriageParade)) {
/* 659 */         stopAndDoNextTurn(xMarriageParades, xMarriageParade);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   static int getMaxSeq(Set<Integer> arriveseqs) {
/* 665 */     int maxSeq = -1;
/* 666 */     for (Iterator i$ = arriveseqs.iterator(); i$.hasNext();) { int seq = ((Integer)i$.next()).intValue();
/* 667 */       if (maxSeq < 0) {
/* 668 */         maxSeq = seq;
/*     */       }
/* 670 */       else if (seq > maxSeq) {
/* 671 */         maxSeq = seq;
/*     */       }
/*     */     }
/*     */     
/* 675 */     return maxSeq;
/*     */   }
/*     */   
/*     */   static boolean isParadeRobMonsterCfgid(int monsterCfgid) {
/* 679 */     int categoryid = MonsterInterface.getMonsterCategoryId(monsterCfgid);
/* 680 */     return categoryid == SMarriageParadeRobConsts.getInstance().protectMonsterCategory;
/*     */   }
/*     */   
/*     */   static void getMarriageSkill(Map<Integer, Integer> skillMap, int friendValue)
/*     */   {
/* 685 */     for (MarrySkillCfg cfg : MarrySkillCfg.getAll().values()) {
/* 686 */       if (friendValue >= cfg.needFriendValue) {
/* 687 */         int level = (friendValue - cfg.factorA) / cfg.factorB;
/* 688 */         if (level > 0) {
/* 689 */           skillMap.put(Integer.valueOf(cfg.skillid), Integer.valueOf(level));
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static Map<Integer, Integer> initMarrySkill(long reqRoleid, long otherRoleid)
/*     */   {
/* 703 */     int friendValue = FriendInterface.getRelationValue(reqRoleid, otherRoleid, true);
/* 704 */     Map<Integer, Integer> skillMap = new HashMap();
/* 705 */     getMarriageSkill(skillMap, friendValue);
/* 706 */     MarriageSkill xReqMarriageSkill = Role2marriageskill.get(Long.valueOf(reqRoleid));
/* 707 */     if (xReqMarriageSkill == null) {
/* 708 */       xReqMarriageSkill = Pod.newMarriageSkill();
/* 709 */       Role2marriageskill.insert(Long.valueOf(reqRoleid), xReqMarriageSkill);
/*     */     }
/* 711 */     xReqMarriageSkill.getSkills().clear();
/* 712 */     xReqMarriageSkill.getSkills().putAll(skillMap);
/*     */     
/* 714 */     MarriageSkill xOtherMarriageSkill = Role2marriageskill.get(Long.valueOf(otherRoleid));
/* 715 */     if (xOtherMarriageSkill == null) {
/* 716 */       xOtherMarriageSkill = Pod.newMarriageSkill();
/* 717 */       Role2marriageskill.insert(Long.valueOf(otherRoleid), xOtherMarriageSkill);
/*     */     }
/* 719 */     xOtherMarriageSkill.getSkills().clear();
/* 720 */     xOtherMarriageSkill.getSkills().putAll(skillMap);
/* 721 */     return skillMap;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\marriage\main\MarriageManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */