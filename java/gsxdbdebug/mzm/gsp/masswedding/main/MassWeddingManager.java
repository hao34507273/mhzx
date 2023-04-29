/*     */ package mzm.gsp.masswedding.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import java.util.TreeMap;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.award.SSendDefaultAwardInfo;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.awardpool.main.AwardPoolResultData;
/*     */ import mzm.gsp.mail.main.MailAttachment;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.masswedding.CoupleInfo;
/*     */ import mzm.gsp.masswedding.SBrocastLuckyBlesserToAll;
/*     */ import mzm.gsp.masswedding.SMassWeddingRedGiftPreciousItemBrd;
/*     */ import mzm.gsp.masswedding.SMassWeddingSignUpInfo;
/*     */ import mzm.gsp.masswedding.SNotifyLuckyBlesser;
/*     */ import mzm.gsp.masswedding.SRandomLuckyBlesserRes;
/*     */ import mzm.gsp.masswedding.SSynMassWeddingStage;
/*     */ import mzm.gsp.masswedding.SignUpInfo;
/*     */ import mzm.gsp.masswedding.confbean.SMassWeddingAwardCfg;
/*     */ import mzm.gsp.masswedding.confbean.SMassWeddingConsts;
/*     */ import mzm.gsp.masswedding.confbean.SMassWeddingPlayCfg;
/*     */ import mzm.gsp.masswedding.confbean.SMassWeddingRandomRedGiftCfg;
/*     */ import mzm.gsp.masswedding.confbean.SMassWeddingRedGiftCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.LogicRunnable;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.BlessRoles;
/*     */ import xbean.MassWedding;
/*     */ import xbean.MassWeddingBless;
/*     */ import xbean.MassWeddingRankInfo;
/*     */ import xbean.MassWeddingRankInfos;
/*     */ import xbean.MassWeddingRedgift;
/*     */ import xbean.MassWeddingRob;
/*     */ import xbean.MassWeddingRobRoles;
/*     */ import xbean.MassWeddingRobSubscribe;
/*     */ import xbean.MassWeddingRobSubscribeRoles;
/*     */ import xdb.Executor;
/*     */ import xdb.Xdb;
/*     */ import xtable.Role2lucksession;
/*     */ import xtable.Role2massweddingredgift;
/*     */ import xtable.User;
/*     */ 
/*     */ class MassWeddingManager
/*     */ {
/*     */   static final int RANDOM = 10000;
/*     */   static final int ENTER = 1;
/*     */   static final int LEAVE = 2;
/*     */   static final int SIGNUP_NORMAL = 0;
/*     */   static final int SIGNUP_OFFLINE_WHEN_START = 1;
/*     */   static final int SIGNUP_ACTIVITY_CLOSE_EARLIER = 2;
/*     */   static final int OUT_OF_RANK = 3;
/*     */   
/*     */   static MassWedding getMassWedding(boolean retainLock)
/*     */   {
/*  71 */     long localid = GameServerInfoManager.getLocalId();
/*  72 */     if (retainLock) {
/*  73 */       return xtable.Masswedding.get(Long.valueOf(localid));
/*     */     }
/*  75 */     return xtable.Masswedding.select(Long.valueOf(localid));
/*     */   }
/*     */   
/*     */   static MassWeddingBless getMassWeddingBless(boolean retainLock)
/*     */   {
/*  80 */     long localid = GameServerInfoManager.getLocalId();
/*  81 */     if (retainLock) {
/*  82 */       return xtable.Massweddingbless.get(Long.valueOf(localid));
/*     */     }
/*  84 */     return xtable.Massweddingbless.select(Long.valueOf(localid));
/*     */   }
/*     */   
/*     */   static MassWeddingRob getMassWeddingRob(boolean retainLock)
/*     */   {
/*  89 */     long localid = GameServerInfoManager.getLocalId();
/*  90 */     if (retainLock) {
/*  91 */       return xtable.Massweddingrob.get(Long.valueOf(localid));
/*     */     }
/*  93 */     return xtable.Massweddingrob.select(Long.valueOf(localid));
/*     */   }
/*     */   
/*     */   static MassWeddingRobSubscribe getMassWeddingRobSubScribe(boolean retainLock)
/*     */   {
/*  98 */     long localid = GameServerInfoManager.getLocalId();
/*  99 */     if (retainLock) {
/* 100 */       return xtable.Massweddingrobsubscribe.get(Long.valueOf(localid));
/*     */     }
/* 102 */     return xtable.Massweddingrobsubscribe.select(Long.valueOf(localid));
/*     */   }
/*     */   
/*     */   static MassWeddingRankInfos getMassWeddingRankInfos(boolean retainLock)
/*     */   {
/* 107 */     long localid = GameServerInfoManager.getLocalId();
/* 108 */     if (retainLock) {
/* 109 */       return xtable.Massweddingrank.get(Long.valueOf(localid));
/*     */     }
/* 111 */     return xtable.Massweddingrank.select(Long.valueOf(localid));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void asynSendOutOfRankMail(MassWeddingSignUpChart chart)
/*     */   {
/* 121 */     if (chart.roleAPrice > 0) {
/* 122 */       NoneRealTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*     */       {
/*     */         protected boolean processImp() throws Exception
/*     */         {
/* 126 */           MassWeddingManager.sendMail(this.val$chart.roleidA, this.val$chart.roleAPrice, SMassWeddingConsts.getInstance().outOfRankMailid, new TLogArg(LogReason.MASSWEDDING_SIGN_UP_RETURN));
/*     */           
/* 128 */           return true;
/*     */         }
/*     */       });
/*     */     }
/* 132 */     if (chart.roleBPrice > 0) {
/* 133 */       NoneRealTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*     */       {
/*     */         protected boolean processImp() throws Exception
/*     */         {
/* 137 */           MassWeddingManager.sendMail(this.val$chart.roleidB, this.val$chart.roleBPrice, SMassWeddingConsts.getInstance().outOfRankMailid, new TLogArg(LogReason.MASSWEDDING_SIGN_UP_RETURN));
/*     */           
/* 139 */           return true;
/*     */         }
/*     */       });
/*     */     }
/*     */   }
/*     */   
/*     */   static void sendMail(long roleid, int gold, int mailCfgid, TLogArg tLogArg)
/*     */   {
/* 147 */     MailAttachment mailAttachment = new MailAttachment();
/* 148 */     mailAttachment.setGold(gold);
/* 149 */     List<String> temp = null;
/* 150 */     mzm.gsp.mail.main.MailInterface.synBuildAndSendMail(roleid, mailCfgid, temp, temp, mailAttachment, tLogArg);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void asynSendMassWeddingSignUpInfo(final List<Long> roleids, int myPrice, final int rank)
/*     */   {
/* 160 */     Executor.getInstance().execute(new LogicRunnable()
/*     */     {
/*     */       public void process() throws Exception
/*     */       {
/* 164 */         SMassWeddingSignUpInfo massWeddingSignUpInfo = new SMassWeddingSignUpInfo();
/* 165 */         massWeddingSignUpInfo.myprice = this.val$myPrice;
/* 166 */         massWeddingSignUpInfo.rank = rank;
/* 167 */         List<MassWeddingSignUpChart> charts = MassWeddingSignUpChartManager.getInstance().getRankObjs(0, SMassWeddingConsts.getInstance().maxCouple - 1);
/*     */         
/* 169 */         for (MassWeddingSignUpChart chart : charts) {
/* 170 */           SignUpInfo signUpInfo = new SignUpInfo();
/* 171 */           MassWeddingManager.fillSignUpInfo(signUpInfo, chart);
/* 172 */           massWeddingSignUpInfo.signupinfos.add(signUpInfo);
/*     */         }
/* 174 */         OnlineManager.getInstance().sendMultiAtOnce(massWeddingSignUpInfo, roleids);
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void fillSignUpInfo(SignUpInfo signUpInfo, MassWeddingSignUpChart chart)
/*     */   {
/* 187 */     signUpInfo.price = (chart.roleAPrice + chart.roleBPrice);
/* 188 */     signUpInfo.roleid1 = chart.roleidA;
/* 189 */     signUpInfo.rolename1 = RoleInterface.getName(chart.roleidA);
/* 190 */     signUpInfo.roleid2 = chart.roleidB;
/* 191 */     signUpInfo.rolename2 = RoleInterface.getName(chart.roleidB);
/*     */   }
/*     */   
/*     */   static void saveRankInfos(MassWeddingRankInfos xMassWeddingRankInfos) {
/* 195 */     int i = 0;
/* 196 */     xMassWeddingRankInfos.getMassweddingrankinfos().clear();
/* 197 */     xMassWeddingRankInfos.getRoleid2index().clear();
/* 198 */     for (MassWeddingSignUpChart chart : MassWeddingSignUpChartManager.getInstance().getAllChartObjs()) {
/* 199 */       MassWeddingRankInfo xMassWeddingRankInfo = xbean.Pod.newMassWeddingRankInfo();
/* 200 */       xMassWeddingRankInfo.setRoleida(chart.roleidA);
/* 201 */       xMassWeddingRankInfo.setRoleaoffer(chart.roleAPrice);
/* 202 */       xMassWeddingRankInfo.setRoleidb(chart.roleidB);
/* 203 */       xMassWeddingRankInfo.setRoleidboffer(chart.roleBPrice);
/* 204 */       xMassWeddingRankInfos.getMassweddingrankinfos().add(xMassWeddingRankInfo);
/* 205 */       xMassWeddingRankInfos.getRoleid2index().put(Long.valueOf(chart.roleidA), Integer.valueOf(i));
/* 206 */       i++;
/*     */     }
/*     */   }
/*     */   
/*     */   static void onRoleLeaveInSignUp(long roleid, long marryRoleid, MassWeddingRankInfos xMassWeddingRankInfos) {
/* 211 */     if (xMassWeddingRankInfos == null) {
/* 212 */       return;
/*     */     }
/* 214 */     MassWeddingSignUpChart massWeddingSignUpChart = (MassWeddingSignUpChart)MassWeddingSignUpChartManager.getInstance().getObjByKey(Long.valueOf(roleid));
/* 215 */     if (massWeddingSignUpChart == null) {
/* 216 */       massWeddingSignUpChart = (MassWeddingSignUpChart)MassWeddingSignUpChartManager.getInstance().getObjByKey(Long.valueOf(marryRoleid));
/*     */     }
/* 218 */     if (massWeddingSignUpChart != null)
/*     */     {
/* 220 */       if (massWeddingSignUpChart.roleAPrice > 0) {
/* 221 */         sendMail(massWeddingSignUpChart.roleidA, massWeddingSignUpChart.roleAPrice, SMassWeddingConsts.getInstance().leaveMailId, new TLogArg(LogReason.MASSWEDDING_SIGN_UP_LEAVE_SCENE_RETURN));
/*     */       }
/*     */       
/*     */ 
/* 225 */       if (massWeddingSignUpChart.roleBPrice > 0) {
/* 226 */         sendMail(massWeddingSignUpChart.roleidB, massWeddingSignUpChart.roleBPrice, SMassWeddingConsts.getInstance().leaveMailId, new TLogArg(LogReason.MASSWEDDING_SIGN_UP_LEAVE_SCENE_RETURN));
/*     */       }
/*     */       
/*     */ 
/* 230 */       MassWeddingSignUpChartManager.getInstance().delete(Long.valueOf(massWeddingSignUpChart.roleidA));
/* 231 */       saveRankInfos(xMassWeddingRankInfos);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isNeedCheckReturnSignupMoneyWhenStart()
/*     */   {
/* 243 */     return !mzm.gsp.activity.main.ActivityInterface.isActivityOpen(SMassWeddingConsts.getInstance().activityid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getNextListenPointNum(int curNum)
/*     */   {
/* 254 */     for (Map.Entry<Integer, SMassWeddingPlayCfg> entry : SMassWeddingPlayCfg.getAll().entrySet()) {
/* 255 */       SMassWeddingPlayCfg massWeddingPlayCfg = (SMassWeddingPlayCfg)entry.getValue();
/* 256 */       int num = ((Integer)entry.getKey()).intValue();
/* 257 */       if ((num > curNum) && (
/* 258 */         (massWeddingPlayCfg.controlid > 0) || (massWeddingPlayCfg.trigger != 0))) {
/* 259 */         return num;
/*     */       }
/*     */     }
/*     */     
/* 263 */     return -1;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static LocationToSeq getPointSeqsBetween(int curNum, int nextNum)
/*     */   {
/* 274 */     LocationToSeq locationToSeq = new LocationToSeq();
/*     */     
/* 276 */     for (Map.Entry<Integer, SMassWeddingPlayCfg> entry : SMassWeddingPlayCfg.getAll().entrySet()) {
/* 277 */       int num = ((Integer)entry.getKey()).intValue();
/* 278 */       if (num > curNum)
/*     */       {
/*     */ 
/* 281 */         if (num > nextNum) {
/*     */           break;
/*     */         }
/* 284 */         mzm.gsp.map.Location location = new mzm.gsp.map.Location(((SMassWeddingPlayCfg)entry.getValue()).x, ((SMassWeddingPlayCfg)entry.getValue()).y);
/* 285 */         locationToSeq.pathList.add(location);
/* 286 */         locationToSeq.seqs.add(entry.getKey());
/*     */       } }
/* 288 */     return locationToSeq;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void onMassWeddingMoveFinish(String useridA, String useridB, long roleidA, long roleidB, MassWedding xMassWedding, MassWeddingRankInfos xMassWeddingRankInfos)
/*     */   {
/* 299 */     xMassWeddingRankInfos.getNotbackcoinsroleids().add(Long.valueOf(roleidA));
/* 300 */     xMassWeddingRankInfos.getNotbackcoinsroleids().add(Long.valueOf(roleidB));
/* 301 */     mzm.gsp.status.main.RoleStatusInterface.unsetStatus(roleidA, 36);
/* 302 */     mzm.gsp.status.main.RoleStatusInterface.unsetStatus(roleidB, 36);
/* 303 */     MapInterface.removeMapGroup(mzm.gsp.map.main.group.MapGroupType.MGT_GROUP_WEDDING, roleidA, Arrays.asList(new Long[] { Long.valueOf(roleidA), Long.valueOf(roleidB) }));
/*     */     
/* 305 */     mzm.gsp.masswedding.SSynBeginRandomLuckyOne synBeginRandomLuckyOne = new mzm.gsp.masswedding.SSynBeginRandomLuckyOne();
/* 306 */     OnlineManager.getInstance().sendMulti(synBeginRandomLuckyOne, Arrays.asList(new Long[] { Long.valueOf(roleidA), Long.valueOf(roleidB) }));
/*     */     
/* 308 */     Session sessionA = new LuckOneSession(SMassWeddingConsts.getInstance().luckyBlesserSec, roleidA);
/* 309 */     Session sessionB = new LuckOneSession(SMassWeddingConsts.getInstance().luckyBlesserSec, roleidB);
/* 310 */     Role2lucksession.remove(Long.valueOf(roleidA));
/* 311 */     Role2lucksession.remove(Long.valueOf(roleidB));
/* 312 */     Role2lucksession.insert(Long.valueOf(roleidA), Long.valueOf(sessionA.getSessionId()));
/* 313 */     Role2lucksession.insert(Long.valueOf(roleidB), Long.valueOf(sessionB.getSessionId()));
/*     */     
/*     */ 
/* 316 */     mzm.gsp.buff.main.BuffInterface.installBuff(roleidA, SMassWeddingConsts.getInstance().massweddingBuffid);
/* 317 */     mzm.gsp.buff.main.BuffInterface.installBuff(roleidB, SMassWeddingConsts.getInstance().massweddingBuffid);
/*     */     
/* 319 */     Integer index = (Integer)xMassWeddingRankInfos.getRoleid2index().get(Long.valueOf(roleidA));
/* 320 */     if (index == null) {
/* 321 */       index = (Integer)xMassWeddingRankInfos.getRoleid2index().get(Long.valueOf(roleidB));
/*     */     }
/*     */     
/* 324 */     if (index == null) {
/* 325 */       GameServer.logger().error(String.format("[MassWedding]MassWeddingManager.onMassWeddingMoveFinish@rolea and roleb do not have rank|roleidA=%d|roleidB=%d", new Object[] { Long.valueOf(roleidA), Long.valueOf(roleidB) }));
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/*     */ 
/* 331 */       int awardRank = index.intValue() + 1;
/* 332 */       int fixAwardId = getMassWeddingAward(awardRank);
/* 333 */       if (fixAwardId > 0)
/*     */       {
/* 335 */         AwardInterface.awardFixAward(fixAwardId, useridA, roleidA, false, true, new AwardReason(LogReason.MASSWEDDING_AWARD, awardRank));
/*     */         
/* 337 */         AwardInterface.awardFixAward(fixAwardId, useridB, roleidB, false, true, new AwardReason(LogReason.MASSWEDDING_AWARD, awardRank));
/*     */       }
/*     */       else {
/* 340 */         GameServer.logger().info(String.format("[MassWedding]MassWeddingManager.onMassWeddingMoveFinish@rolea and roleb do not have rank award|roleidA=%d|roleidB=%d|rankIndex=%d", new Object[] { Long.valueOf(roleidA), Long.valueOf(roleidB), Integer.valueOf(awardRank) }));
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 349 */     if (isMarryPlayEnd(xMassWedding, xMassWeddingRankInfos)) {
/* 350 */       mzm.gsp.masswedding.SMassWeddingPlayEndRes massWeddingPlayEndRes = new mzm.gsp.masswedding.SMassWeddingPlayEndRes();
/* 351 */       MapInterface.brocadCastInWorld(xMassWedding.getWorldid(), massWeddingPlayEndRes, true);
/*     */     }
/*     */   }
/*     */   
/*     */   private static int getMassWeddingAward(int awardRank) {
/* 356 */     Map<Integer, SMassWeddingAwardCfg> awardMap = SMassWeddingAwardCfg.getAll();
/* 357 */     if ((awardMap instanceof TreeMap)) {
/* 358 */       TreeMap<Integer, SMassWeddingAwardCfg> tempMap = (TreeMap)awardMap;
/* 359 */       Map.Entry<Integer, SMassWeddingAwardCfg> entry = tempMap.ceilingEntry(Integer.valueOf(awardRank));
/* 360 */       if (entry != null) {
/* 361 */         return ((SMassWeddingAwardCfg)entry.getValue()).fixAwardid;
/*     */       }
/* 363 */       return 0;
/*     */     }
/*     */     
/* 366 */     for (Map.Entry<Integer, SMassWeddingAwardCfg> entry : SMassWeddingAwardCfg.getAll().entrySet()) {
/* 367 */       if (((Integer)entry.getKey()).intValue() >= awardRank) {
/* 368 */         return ((SMassWeddingAwardCfg)entry.getValue()).fixAwardid;
/*     */       }
/*     */     }
/* 371 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */   static void commonAward(MassWedding xMassWedding)
/*     */   {
/* 377 */     long worldid = xMassWedding.getWorldid();
/* 378 */     List<Long> roleids = MapInterface.getRoleList(worldid);
/* 379 */     AwardInterface.awardToAllNoneRealTime(roleids, SMassWeddingConsts.getInstance().rainAwardid, -1, false, true, new AwardReason(LogReason.MASSWEDDING_RAIN_AWARD));
/*     */   }
/*     */   
/*     */   static void fillCoupleInfo(CoupleInfo coupleinfo, long roleidA, long roleidB)
/*     */   {
/* 384 */     fillRoleInfo(coupleinfo.roleinfo1, roleidA);
/* 385 */     fillRoleInfo(coupleinfo.roleinfo2, roleidB);
/*     */   }
/*     */   
/*     */   private static void fillRoleInfo(mzm.gsp.masswedding.RoleInfo roleinfo1, long roleid) {
/* 389 */     roleinfo1.roleid = roleid;
/* 390 */     roleinfo1.rolename = RoleInterface.getName(roleid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static void onRoleEnterMassWeddingWorld(List<Long> roleList, MassWedding xMassWedding, MassWeddingRankInfos xMassWeddingRankInfos, MassWeddingBless xMassWeddingBless, MassWeddingRob xMassWeddingRob)
/*     */   {
/* 397 */     if (xMassWedding == null) {
/* 398 */       return;
/*     */     }
/* 400 */     int marryEndEnum = 0;
/* 401 */     boolean isMarryEnd = isMarryPlayEnd(xMassWedding, xMassWeddingRankInfos);
/* 402 */     if (isMarryEnd) {
/* 403 */       marryEndEnum = 1;
/*     */     }
/* 405 */     for (Iterator i$ = roleList.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 406 */       SSynMassWeddingStage synMassWeddingStage = new SSynMassWeddingStage();
/* 407 */       int blessed = 0;
/* 408 */       if (xMassWeddingBless != null) {
/* 409 */         blessed = isBlessed(xMassWeddingBless, roleid);
/*     */       }
/* 411 */       if (xMassWeddingRob != null) {
/* 412 */         synMassWeddingStage.supportset.addAll(robedRoleids(xMassWeddingRob, xMassWeddingRankInfos, roleid));
/*     */       }
/* 414 */       synMassWeddingStage.stage = xMassWedding.getStage();
/* 415 */       synMassWeddingStage.blessed = blessed;
/* 416 */       synMassWeddingStage.massweddingplayend = marryEndEnum;
/* 417 */       synMassWeddingStage.supportset.addAll(robedRoleids(xMassWeddingRob, xMassWeddingRankInfos, roleid));
/* 418 */       OnlineManager.getInstance().send(roleid, synMassWeddingStage);
/*     */     }
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
/*     */   static Set<Long> robedRoleids(MassWeddingRob xMassWeddingRob, MassWeddingRankInfos xMassWeddingRankInfos, long roleid)
/*     */   {
/* 432 */     if ((xMassWeddingRankInfos == null) || (xMassWeddingRob == null)) {
/* 433 */       return new HashSet(1);
/*     */     }
/* 435 */     Set<Long> roleids = new HashSet();
/* 436 */     for (Map.Entry<Long, MassWeddingRobRoles> entry : xMassWeddingRob.getRobmap().entrySet()) {
/* 437 */       MassWeddingRobRoles robRoles = (MassWeddingRobRoles)entry.getValue();
/* 438 */       if (robRoles.getBrides().contains(Long.valueOf(roleid))) {
/* 439 */         long marryRoleid = ((Long)entry.getKey()).longValue();
/* 440 */         Integer index = (Integer)xMassWeddingRankInfos.getRoleid2index().get(Long.valueOf(marryRoleid));
/* 441 */         if (index != null) {
/* 442 */           MassWeddingRankInfo xMassWeddingRankInfo = (MassWeddingRankInfo)xMassWeddingRankInfos.getMassweddingrankinfos().get(index.intValue());
/*     */           
/* 444 */           if (xMassWeddingRankInfo == null) {
/* 445 */             GameServer.logger().error(String.format("[MassWedding]MassWeddingManager.robedRoleid@rank info is null|roleid=%d|index=%d|rankdatas=%s", new Object[] { Long.valueOf(marryRoleid), index, xMassWeddingRankInfos.toString() }));
/*     */ 
/*     */           }
/*     */           else
/*     */           {
/*     */ 
/* 451 */             roleids.add(Long.valueOf(xMassWeddingRankInfo.getRoleidb()));
/*     */           }
/*     */         }
/*     */       }
/*     */       
/* 456 */       if (robRoles.getGrooms().contains(Long.valueOf(roleid))) {
/* 457 */         roleids.add(entry.getKey());
/*     */       }
/*     */     }
/* 460 */     return roleids;
/*     */   }
/*     */   
/*     */   static int isBlessed(MassWeddingBless xMassWeddingBless, long roleid) {
/* 464 */     for (BlessRoles xBlessRoles : xMassWeddingBless.getBlessmap().values()) {
/* 465 */       if (xBlessRoles.getBlessroles().contains(Long.valueOf(roleid))) {
/* 466 */         return 1;
/*     */       }
/*     */     }
/* 469 */     return 0;
/*     */   }
/*     */   
/*     */   static boolean isRobEnd(MassWeddingRobRoles xMassWeddingRobRoles) {
/* 473 */     return Math.abs(xMassWeddingRobRoles.getBrides().size() - xMassWeddingRobRoles.getGrooms().size()) >= SMassWeddingConsts.getInstance().supportSub;
/*     */   }
/*     */   
/*     */   static void asynSendRobWinAward(Set<Long> grooms)
/*     */   {
/* 478 */     for (Iterator i$ = grooms.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 479 */       NoneRealTimeTaskManager.getInstance().addTask(new RoleAwardProcedure(roleid, SMassWeddingConsts.getInstance().robWinAwardid));
/*     */     }
/*     */   }
/*     */   
/*     */   static class RoleAwardProcedure extends LogicProcedure
/*     */   {
/*     */     private long roleid;
/*     */     private int awardid;
/*     */     
/*     */     RoleAwardProcedure(long roleid, int awardid)
/*     */     {
/* 490 */       this.roleid = roleid;
/* 491 */       this.awardid = awardid;
/*     */     }
/*     */     
/*     */     protected boolean processImp() throws Exception
/*     */     {
/* 496 */       String userid = RoleInterface.getUserId(this.roleid);
/* 497 */       lock(User.getTable(), Arrays.asList(new String[] { userid }));
/* 498 */       lock(xtable.Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/* 499 */       AwardInterface.award(this.awardid, userid, this.roleid, false, true, new AwardReason(LogReason.MASSWEDDING_ROB_PLAYER_AWARD));
/*     */       
/* 501 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   static void asynSendRobFailAward(Set<Long> brides)
/*     */   {
/* 507 */     for (Iterator i$ = brides.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 508 */       NoneRealTimeTaskManager.getInstance().addTask(new RoleAwardProcedure(roleid, SMassWeddingConsts.getInstance().robFailAwardid));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void redGigtAward(MassWedding xMassWedding)
/*     */   {
/* 520 */     long worldid = xMassWedding.getWorldid();
/* 521 */     List<Long> allRoles = MapInterface.getRoleList(worldid);
/* 522 */     if (allRoles.size() <= 0) {
/* 523 */       GameServer.logger().info("[MassWedding]MassWeddingManage.redGigtAward@role size is zero");
/* 524 */       return;
/*     */     }
/* 526 */     SMassWeddingRandomRedGiftCfg massWeddingRandomRedGiftCfg = SMassWeddingRandomRedGiftCfg.get(SMassWeddingConsts.getInstance().randomRedGiftCfgid);
/*     */     
/* 528 */     int redGiftCfgid = 0;
/* 529 */     int p = Xdb.random().nextInt(10000);
/* 530 */     for (Map.Entry<Integer, Integer> entry : massWeddingRandomRedGiftCfg.rate2RedgiftCfgid.entrySet()) {
/* 531 */       if (p < ((Integer)entry.getKey()).intValue()) {
/* 532 */         redGiftCfgid = ((Integer)entry.getValue()).intValue();
/* 533 */         break;
/*     */       }
/*     */     }
/* 536 */     if (redGiftCfgid == 0) {
/* 537 */       GameServer.logger().error(String.format("[MassWedding]MassWeddingManager.redGigtAward@redGiftCfgid is zero|p=%d|randomCfgid=%d", new Object[] { Integer.valueOf(p), Integer.valueOf(SMassWeddingConsts.getInstance().randomRedGiftCfgid) }));
/*     */       
/*     */ 
/*     */ 
/* 541 */       return;
/*     */     }
/* 543 */     for (Iterator i$ = allRoles.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 544 */       awardRedGigt(roleid, redGiftCfgid);
/*     */     }
/* 546 */     mzm.gsp.masswedding.SSynClientRedGift synClientRedGift = new mzm.gsp.masswedding.SSynClientRedGift();
/* 547 */     synClientRedGift.redgiftcfgid = redGiftCfgid;
/* 548 */     OnlineManager.getInstance().sendMulti(synClientRedGift, allRoles);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void awardRedGigt(long roleid, int redGiftCfgid)
/*     */   {
/* 558 */     NoneRealTimeTaskManager.getInstance().addTask(new RedGiftProcedure(roleid, redGiftCfgid));
/*     */   }
/*     */   
/*     */   static class RedGiftProcedure extends LogicProcedure
/*     */   {
/*     */     private long roleid;
/*     */     private int redGiftCfgid;
/*     */     
/*     */     public RedGiftProcedure(long roleid, int redGiftCfgid) {
/* 567 */       this.roleid = roleid;
/* 568 */       this.redGiftCfgid = redGiftCfgid;
/*     */     }
/*     */     
/*     */     protected boolean processImp() throws Exception
/*     */     {
/* 573 */       String userid = RoleInterface.getUserId(this.roleid);
/* 574 */       lock(User.getTable(), Arrays.asList(new String[] { userid }));
/* 575 */       MassWeddingRedgift xMassWeddingRedgift = Role2massweddingredgift.get(Long.valueOf(this.roleid));
/* 576 */       if (xMassWeddingRedgift == null) {
/* 577 */         xMassWeddingRedgift = xbean.Pod.newMassWeddingRedgift();
/* 578 */         Role2massweddingredgift.insert(Long.valueOf(this.roleid), xMassWeddingRedgift);
/*     */       }
/* 580 */       else if (xMassWeddingRedgift.getTaken() == 0) {
/* 581 */         SMassWeddingRedGiftCfg massWeddingRedGiftCfg = SMassWeddingRedGiftCfg.get(xMassWeddingRedgift.getRedgiftcfgid());
/*     */         
/* 583 */         if (massWeddingRedGiftCfg != null) {
/* 584 */           MassWeddingManager.redGiftAward(userid, this.roleid, massWeddingRedGiftCfg);
/*     */         }
/*     */       }
/*     */       
/* 588 */       xMassWeddingRedgift.setRedgiftcfgid(this.redGiftCfgid);
/* 589 */       xMassWeddingRedgift.setTaken(0);
/* 590 */       new MassWeddingManager.RedGiftAwardSession(SMassWeddingConsts.getInstance().autoGetRedGiftSec, this.roleid, this.redGiftCfgid);
/* 591 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   static class RedGiftAwardSession extends Session
/*     */   {
/*     */     private int redGiftCfgid;
/*     */     
/*     */     public RedGiftAwardSession(long interval, long roleId, int redGiftCfgid) {
/* 600 */       super(roleId);
/* 601 */       this.redGiftCfgid = redGiftCfgid;
/*     */     }
/*     */     
/*     */     protected void onTimeOut()
/*     */     {
/* 606 */       NoneRealTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*     */       {
/*     */         protected boolean processImp() throws Exception
/*     */         {
/* 610 */           long roleid = MassWeddingManager.RedGiftAwardSession.this.getOwerId();
/* 611 */           String userid = RoleInterface.getUserId(roleid);
/* 612 */           lock(User.getTable(), Arrays.asList(new String[] { userid }));
/* 613 */           MassWeddingRedgift xMassWeddingRedgift = Role2massweddingredgift.get(Long.valueOf(roleid));
/* 614 */           if (xMassWeddingRedgift == null) {
/* 615 */             return false;
/*     */           }
/* 617 */           return MassWeddingManager.checkAndAwardRedGift(roleid, userid, MassWeddingManager.RedGiftAwardSession.this.redGiftCfgid, xMassWeddingRedgift);
/*     */         }
/*     */       });
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static boolean checkAndAwardRedGift(long roleid, String userid, int redGiftCfgid, MassWeddingRedgift xMassWeddingRedgift)
/*     */   {
/* 627 */     if (xMassWeddingRedgift.getRedgiftcfgid() != redGiftCfgid) {
/* 628 */       return false;
/*     */     }
/* 630 */     if (xMassWeddingRedgift.getTaken() == 1) {
/* 631 */       return false;
/*     */     }
/* 633 */     SMassWeddingRedGiftCfg massWeddingRedGiftCfg = SMassWeddingRedGiftCfg.get(xMassWeddingRedgift.getRedgiftcfgid());
/*     */     
/* 635 */     if (massWeddingRedGiftCfg != null) {
/* 636 */       redGiftAward(userid, roleid, massWeddingRedGiftCfg);
/* 637 */       xMassWeddingRedgift.setTaken(1);
/*     */     } else {
/* 639 */       return false;
/*     */     }
/* 641 */     return true;
/*     */   }
/*     */   
/*     */   static void redGiftAward(String userid, long roleid, SMassWeddingRedGiftCfg massWeddingRedGiftCfg) {
/* 645 */     AwardPoolResultData awardPoolResultData = mzm.gsp.awardpool.main.AwardPoolInterface.getAwardPoolData(massWeddingRedGiftCfg.awardpoolid, roleid, RoleInterface.getLevel(roleid));
/*     */     
/* 647 */     mzm.gsp.awardpool.main.AwardPoolInterface.doAward(userid, roleid, awardPoolResultData, new TLogArg(LogReason.MASSWEDDING_RED_GIFT_AWARD));
/*     */     
/* 649 */     SMassWeddingRedGiftPreciousItemBrd massWeddingRedGiftPreciousItemBrd = new SMassWeddingRedGiftPreciousItemBrd();
/* 650 */     for (Map.Entry<Integer, Integer> item2numEntry : awardPoolResultData.getItemMap().entrySet()) {
/* 651 */       int itemid = ((Integer)item2numEntry.getKey()).intValue();
/* 652 */       if (mzm.gsp.itembulletin.main.ItemBulletinInterface.needBulletin(itemid)) {
/* 653 */         massWeddingRedGiftPreciousItemBrd.item2num.put(Integer.valueOf(itemid), item2numEntry.getValue());
/*     */       }
/*     */     }
/* 656 */     if (massWeddingRedGiftPreciousItemBrd.item2num.size() > 0) {
/* 657 */       massWeddingRedGiftPreciousItemBrd.rolename = RoleInterface.getName(roleid);
/* 658 */       OnlineManager.getInstance().sendAll(massWeddingRedGiftPreciousItemBrd);
/*     */     }
/*     */     
/*     */ 
/* 662 */     SSendDefaultAwardInfo sendDefaultAwardInfo = new SSendDefaultAwardInfo();
/* 663 */     AwardInterface.fillAwardBean(sendDefaultAwardInfo.awardinfo, mzm.gsp.award.main.AwardModel.getAwardModel(awardPoolResultData));
/* 664 */     OnlineManager.getInstance().send(roleid, sendDefaultAwardInfo);
/*     */   }
/*     */   
/*     */   static void randomBlesser(long roleid, long marryroleid, MassWedding xMassWedding, MassWeddingBless xMassWeddingBless)
/*     */   {
/* 669 */     final long worldid = xMassWedding.getWorldid();
/* 670 */     Role2lucksession.remove(Long.valueOf(roleid));
/* 671 */     List<Long> roleids = new ArrayList();
/* 672 */     BlessRoles xBlessRoles = (BlessRoles)xMassWeddingBless.getBlessmap().get(Long.valueOf(roleid));
/* 673 */     if (xBlessRoles == null) {
/* 674 */       xBlessRoles = (BlessRoles)xMassWeddingBless.getBlessmap().get(Long.valueOf(marryroleid));
/*     */     }
/* 676 */     if (xBlessRoles != null) {
/* 677 */       roleids.addAll(xBlessRoles.getBlessroles());
/*     */     }
/* 679 */     if (roleids.size() <= 0) {
/* 680 */       for (BlessRoles xtempBlessRoles : xMassWeddingBless.getBlessmap().values()) {
/* 681 */         roleids.addAll(xtempBlessRoles.getBlessroles());
/*     */       }
/*     */     }
/* 684 */     List<Long> outList = new ArrayList();
/* 685 */     if (roleids.size() > 0) {
/* 686 */       mzm.gsp.util.CommonUtils.randomList(roleids, 1, outList);
/*     */     }
/* 688 */     if (outList.size() > 0) {
/* 689 */       long luckRoleid = ((Long)outList.get(0)).longValue();
/* 690 */       Executor.getInstance().execute(new LogicRunnable()
/*     */       {
/*     */         public void process() throws Exception
/*     */         {
/* 694 */           SRandomLuckyBlesserRes randomLuckyBlesserRes = new SRandomLuckyBlesserRes();
/* 695 */           MassWeddingManager.fillRoleInfo(randomLuckyBlesserRes.roleinfo, this.val$luckRoleid);
/* 696 */           OnlineManager.getInstance().sendAtOnce(this.val$roleid, randomLuckyBlesserRes);
/*     */         }
/*     */         
/* 699 */       });
/* 700 */       NoneRealTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*     */       {
/*     */         protected boolean processImp() throws Exception
/*     */         {
/* 704 */           String userid = RoleInterface.getUserId(this.val$luckRoleid);
/* 705 */           lock(User.getTable(), Arrays.asList(new String[] { userid }));
/* 706 */           lock(Role2lucksession.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.val$luckRoleid), Long.valueOf(worldid) }));
/*     */           
/* 708 */           AwardReason awardReason = new AwardReason(LogReason.MASSWEDDING_LUCKEY_ONE_AWARD);
/* 709 */           mzm.gsp.award.main.AwardModel awardModel = AwardInterface.getRoleAwardModel(SMassWeddingConsts.getInstance().luckyBlesserAwardid, this.val$luckRoleid, -1, awardReason);
/*     */           
/* 711 */           MailAttachment mailAttachment = AwardInterface.getMailAttachmentBy(awardModel);
/* 712 */           List<String> temp = null;
/* 713 */           mzm.gsp.mail.main.MailInterface.synBuildAndSendMail(this.val$luckRoleid, SMassWeddingConsts.getInstance().lukeyBlesserMailid, temp, temp, mailAttachment, new TLogArg(LogReason.MASSWEDDING_LUCKEY_ONE_AWARD));
/*     */           
/*     */ 
/* 716 */           SNotifyLuckyBlesser notifyLuckyBlesser = new SNotifyLuckyBlesser();
/* 717 */           MassWeddingManager.fillRoleInfo(notifyLuckyBlesser.roleinfo, worldid);
/* 718 */           OnlineManager.getInstance().send(this.val$luckRoleid, notifyLuckyBlesser);
/*     */           
/* 720 */           SBrocastLuckyBlesserToAll brocastLuckyBlesserToAll = new SBrocastLuckyBlesserToAll();
/* 721 */           MassWeddingManager.fillRoleInfo(brocastLuckyBlesserToAll.luckyroleinfo, this.val$luckRoleid);
/* 722 */           MassWeddingManager.fillRoleInfo(brocastLuckyBlesserToAll.operroleinfo, worldid);
/* 723 */           MapInterface.brocadCastInWorld(this.val$worldid, brocastLuckyBlesserToAll, true);
/* 724 */           return true;
/*     */         }
/*     */       });
/*     */     } else {
/* 728 */       mzm.gsp.masswedding.SRandomLuckyBlesserErrorRes rankBlesserErrorRes = new mzm.gsp.masswedding.SRandomLuckyBlesserErrorRes();
/* 729 */       rankBlesserErrorRes.result = 1;
/* 730 */       OnlineManager.getInstance().sendAtOnce(roleid, rankBlesserErrorRes);
/*     */     }
/*     */   }
/*     */   
/*     */   static void asynTriggerAddFriend(List<Long> roleids) {
/* 735 */     NoneRealTimeTaskManager.getInstance().addTask(new LogicRunnable()
/*     */     {
/*     */       public void process() throws Exception
/*     */       {
/* 739 */         List<Long> males = new ArrayList();
/* 740 */         List<Long> females = new ArrayList();
/* 741 */         for (Iterator i$ = this.val$roleids.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 742 */           if (OnlineManager.getInstance().isOnline(roleid))
/*     */           {
/*     */ 
/*     */ 
/* 746 */             if (!mzm.gsp.marriage.main.MarriageInterface.isMarried(roleid)) {
/* 747 */               if (RoleInterface.getGender(roleid) == 1) {
/* 748 */                 males.add(Long.valueOf(roleid));
/*     */               } else
/* 750 */                 females.add(Long.valueOf(roleid));
/*     */             }
/*     */           }
/*     */         }
/* 754 */         for (int i = 0; i < males.size(); i++) {
/* 755 */           long maleRoleid = ((Long)males.get(i)).longValue();
/* 756 */           NoneRealTimeTaskManager.getInstance().addTask(new MassWeddingManager.RSpecialAddFriend(maleRoleid, females));
/*     */         }
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   static final class RSpecialAddFriend extends LogicRunnable {
/*     */     private List<Long> allRoles;
/*     */     private long maleRoleid;
/*     */     
/*     */     RSpecialAddFriend(long maleRoleid, List<Long> allRoles) {
/* 767 */       this.maleRoleid = maleRoleid;
/* 768 */       this.allRoles = allRoles;
/*     */     }
/*     */     
/*     */     public void process() throws Exception
/*     */     {
/* 773 */       List<Long> randomList = new ArrayList(this.allRoles);
/* 774 */       while (randomList.size() > 0) {
/* 775 */         int index = Xdb.random().nextInt(randomList.size());
/* 776 */         long roleid = ((Long)randomList.remove(index)).longValue();
/* 777 */         if (!mzm.gsp.friend.main.FriendInterface.isFriend(this.maleRoleid, roleid, false)) {
/* 778 */           mzm.gsp.friend.main.FriendInterface.sendSpecialAddFriend(this.maleRoleid, roleid, 1, null);
/*     */           
/* 780 */           MassWeddingManager.tlogMassWeddingAddFriend(RoleInterface.getUserId(this.maleRoleid), this.maleRoleid, RoleInterface.getUserId(roleid), roleid);
/*     */           
/* 782 */           this.allRoles.remove(Long.valueOf(roleid));
/* 783 */           break;
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   static void unSubScribe(MassWeddingRobSubscribe xMassWeddingRobSubscribe, long roleid)
/*     */   {
/* 791 */     if (xMassWeddingRobSubscribe == null) {
/* 792 */       return;
/*     */     }
/* 794 */     for (MassWeddingRobSubscribeRoles xMassWeddingRobSubscribeRoles : xMassWeddingRobSubscribe.getRobsubscribemap().values())
/*     */     {
/* 796 */       xMassWeddingRobSubscribeRoles.getRoleids().remove(Long.valueOf(roleid));
/*     */     }
/*     */   }
/*     */   
/*     */   static boolean isMarryPlayEnd(MassWedding xMassWedding, MassWeddingRankInfos xMassWeddingRankInfos) {
/* 801 */     if (xMassWedding == null) {
/* 802 */       return true;
/*     */     }
/* 804 */     if (xMassWedding.getStage() > 1) {
/* 805 */       return true;
/*     */     }
/* 807 */     if (xMassWeddingRankInfos == null) {
/* 808 */       return false;
/*     */     }
/* 810 */     int size = xMassWeddingRankInfos.getMassweddingrankinfos().size();
/* 811 */     if (size > 0) {
/* 812 */       MassWeddingRankInfo xMassWeddingRankInfo = (MassWeddingRankInfo)xMassWeddingRankInfos.getMassweddingrankinfos().get(size - 1);
/*     */       
/* 814 */       return xMassWeddingRankInfos.getNotbackcoinsroleids().contains(Long.valueOf(xMassWeddingRankInfo.getRoleida()));
/*     */     }
/* 816 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void tlogMassWeddingAttend(String userid, long roleid, int level, int enterOrLeave)
/*     */   {
/* 827 */     String logStr = String.format("%s|%d|%d|%d", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(level), Integer.valueOf(enterOrLeave) });
/* 828 */     TLogManager.getInstance().addLog(roleid, "MassWeddingAttend", logStr);
/*     */   }
/*     */   
/*     */ 
/*     */   static class TLogMassWeddingSignUp
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final long roleid;
/*     */     
/*     */     private final int rank;
/*     */     
/*     */     private final int money;
/*     */     private final int totalMoney;
/*     */     private final int state;
/*     */     
/*     */     public TLogMassWeddingSignUp(long roleid, int rank, int money, int totalMoney, int state)
/*     */     {
/* 845 */       this.roleid = roleid;
/* 846 */       this.rank = rank;
/* 847 */       this.money = money;
/* 848 */       this.totalMoney = totalMoney;
/* 849 */       this.state = state;
/*     */     }
/*     */     
/*     */     protected boolean processImp() throws Exception
/*     */     {
/* 854 */       MassWeddingManager.tlogMassWeddingSignUp(RoleInterface.getUserId(this.roleid), this.roleid, RoleInterface.getLevel(this.roleid), this.rank, this.money, this.totalMoney, this.state);
/*     */       
/* 856 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   static void tlogMassWeddingSignUp(String userid, long roleid, int level, int rank, int money, int totalMoney, int state)
/*     */   {
/* 863 */     String logStr = String.format("%s|%d|%d|%d|%d|%d|%d", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(level), Integer.valueOf(rank), Integer.valueOf(money), Integer.valueOf(totalMoney), Integer.valueOf(state) });
/* 864 */     TLogManager.getInstance().addLog(roleid, "MassWeddingSignUp", logStr);
/*     */   }
/*     */   
/*     */   static void tlogMassWeddingBless(String userid, long roleid, int level, long roleidA, long roleidB, String content)
/*     */   {
/* 869 */     String logStr = String.format("%s|%d|%d|%d|%d|%s", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(level), Long.valueOf(roleidA), Long.valueOf(roleidB), content });
/* 870 */     TLogManager.getInstance().addLog(roleid, "MassWeddingBless", logStr);
/*     */   }
/*     */   
/*     */   static void tlogMassWeddingRob(String userid, long roleid, int level, long roleidA, long roleidB, long supportRoleid)
/*     */   {
/* 875 */     String logStr = String.format("%s|%d|%d|%d|%d|%d", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(level), Long.valueOf(roleidA), Long.valueOf(roleidB), Long.valueOf(supportRoleid) });
/* 876 */     TLogManager.getInstance().addLog(roleid, "MassWeddingRob", logStr);
/*     */   }
/*     */   
/*     */ 
/*     */   static void tlogMassWeddingRobResult(String useridA, long roleidA, String useridB, long roleidB, int supportGroomNum, int supportBrideNum)
/*     */   {
/* 882 */     String logStr = String.format("%s|%d|%s|%d|%d|%d", new Object[] { useridA, Long.valueOf(roleidA), useridB, Long.valueOf(roleidB), Integer.valueOf(supportGroomNum), Integer.valueOf(supportBrideNum) });
/*     */     
/* 884 */     TLogManager.getInstance().addLog(roleidA, "MassWeddingRobResult", logStr);
/*     */   }
/*     */   
/*     */   static void tlogMassWeddingAddFriend(String useridA, long roleidA, String useridB, long roleidB)
/*     */   {
/* 889 */     String logStr = String.format("%s|%d|%s|%d", new Object[] { useridA, Long.valueOf(roleidA), useridB, Long.valueOf(roleidB) });
/* 890 */     TLogManager.getInstance().addLog(roleidA, "MassWeddingAddFriend", logStr);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\masswedding\main\MassWeddingManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */