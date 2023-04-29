/*     */ package mzm.gsp.petarena.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.ListIterator;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import java.util.TreeMap;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.common.confbean.STimeCommonCfg;
/*     */ import mzm.gsp.mall.main.JifenOperateResult;
/*     */ import mzm.gsp.mall.main.MallInterface;
/*     */ import mzm.gsp.monster.confbean.SMonsterCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.pet.main.PetFightInterface;
/*     */ import mzm.gsp.petarena.SFightEndSuccess;
/*     */ import mzm.gsp.petarena.SGetPetArenaInfoSuccess;
/*     */ import mzm.gsp.petarena.SyncOpponentInfos;
/*     */ import mzm.gsp.petarena.confbean.PetTypeInfo;
/*     */ import mzm.gsp.petarena.confbean.SPetArenaConst;
/*     */ import mzm.gsp.petarena.confbean.SPetArenaFormationToRobotCfg;
/*     */ import mzm.gsp.petarena.confbean.SPetArenaRankSectionCfg;
/*     */ import mzm.gsp.petarena.confbean.SPetArenaRobotAttributeCfg;
/*     */ import mzm.gsp.petarena.confbean.SPetArenaRobotCfg;
/*     */ import mzm.gsp.petarena.confbean.SectionInfo;
/*     */ import mzm.gsp.petarena.confbean.TypeToRobotPetInfo;
/*     */ import mzm.gsp.qingfu.main.CostResult;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.Role;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.server.main.ServerInterface;
/*     */ import mzm.gsp.timer.main.Observer;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.PetArenaFightAward;
/*     */ import xbean.PetArenaFightRecordInfo;
/*     */ import xbean.PetArenaRank;
/*     */ import xbean.PetArenaRankBackup;
/*     */ import xbean.PetArenaRankInfo;
/*     */ import xbean.Pod;
/*     */ import xdb.Lockeys;
/*     */ import xdb.Xdb;
/*     */ import xtable.Petarenarank;
/*     */ import xtable.Petarenarankbackup;
/*     */ import xtable.Role2petarenaawardobserver;
/*     */ import xtable.Role2petarenainfo;
/*     */ 
/*     */ public class PetArenaManager
/*     */ {
/*     */   static final String ENCODING = "UTF-8";
/*     */   
/*     */   static void init()
/*     */   {
/*  70 */     ActivityInterface.registerActivityByLogicType(139, new PetArenaActivityHandler(), false);
/*  71 */     if (GameServerInfoManager.isRoamServer())
/*     */     {
/*  73 */       return;
/*     */     }
/*     */     
/*     */ 
/*  77 */     new PPetArenaInit(null).call();
/*  78 */     PetArenaChartManager.init();
/*     */   }
/*     */   
/*     */   private static class PPetArenaInit
/*     */     extends LogicProcedure
/*     */   {
/*     */     protected boolean processImp() throws Exception
/*     */     {
/*  86 */       long key = GameServerInfoManager.getLocalId();
/*  87 */       PetArenaRank xPetArenaRank = Petarenarank.get(Long.valueOf(key));
/*  88 */       if (xPetArenaRank == null)
/*     */       {
/*  90 */         xPetArenaRank = Pod.newPetArenaRank();
/*  91 */         Petarenarank.insert(Long.valueOf(key), xPetArenaRank);
/*     */       }
/*     */       
/*     */ 
/*  95 */       Set<Long> refreshOpponents = new java.util.HashSet();
/*  96 */       refreshOpponents.addAll(xPetArenaRank.getMerged_roles());
/*  97 */       xPetArenaRank.getMerged_roles().clear();
/*     */       
/*  99 */       int max = SPetArenaConst.getInstance().ROBOT_NUM;
/* 100 */       List<PetArenaRankInfo> xPetArenaRankInfos = xPetArenaRank.getRanks();
/* 101 */       int size = xPetArenaRankInfos.size();
/* 102 */       if (size < max)
/*     */       {
/* 104 */         for (int i = size; i < max; i++)
/*     */         {
/* 106 */           PetArenaRankInfo xPetArenaRankInfo = Pod.newPetArenaRankInfo();
/* 107 */           xPetArenaRankInfo.setRank(i + 1);
/* 108 */           xPetArenaRankInfos.add(i, xPetArenaRankInfo);
/*     */         }
/*     */         
/* 111 */       } else if (size > max)
/*     */       {
/* 113 */         for (int i = max; i < size; i++)
/*     */         {
/* 115 */           PetArenaRankInfo xPetArenaRankInfo = (PetArenaRankInfo)xPetArenaRankInfos.remove(max);
/* 116 */           if (xPetArenaRankInfo != null)
/*     */           {
/* 118 */             long roleid = xPetArenaRankInfo.getRoleid();
/* 119 */             if (roleid > 0L)
/*     */             {
/* 121 */               xPetArenaRank.getRoles().remove(Long.valueOf(roleid));
/* 122 */               refreshOpponents.add(Long.valueOf(roleid));
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 129 */       for (int i = 0; i < xPetArenaRankInfos.size(); i++)
/*     */       {
/* 131 */         PetArenaRankInfo xPetArenaRankInfo = (PetArenaRankInfo)xPetArenaRankInfos.get(i);
/* 132 */         int rank = i + 1;
/* 133 */         RankInfo rankInfo = new RankInfo(rank, xPetArenaRankInfo.getRoleid());
/* 134 */         PetArenaRankManager.getInstance().addRank(rank, rankInfo);
/*     */       }
/*     */       
/*     */ 
/* 138 */       long now = DateTimeUtils.getCurrTimeInMillis();
/* 139 */       STimeCommonCfg timeCommonCfg = mzm.gsp.common.TimeCommonUtil.getCommonCfg(SPetArenaConst.getInstance().AWARD_TIME_CFG_ID);
/* 140 */       long todayResetTime = DateTimeUtils.getDailyResetTime(now, timeCommonCfg.activeHour, timeCommonCfg.activeMinute);
/*     */       
/* 142 */       long nextUpdateTime = now < todayResetTime ? todayResetTime : todayResetTime + 86400000L;
/*     */       
/* 144 */       long delaySeconds = TimeUnit.MILLISECONDS.toSeconds(nextUpdateTime - now + 999L);
/* 145 */       new PetArenaAwardObserver(delaySeconds, 86400L);
/*     */       
/*     */ 
/* 148 */       for (Iterator i$ = refreshOpponents.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */         
/* 150 */         NoneRealTimeTaskManager.getInstance().addTask(new PRefreshOpponent(roleid));
/*     */       }
/*     */       
/*     */ 
/* 154 */       PetArenaRankBackup xPetArenaRankBackup = Petarenarankbackup.get(Long.valueOf(key));
/* 155 */       if (xPetArenaRankBackup == null)
/*     */       {
/* 157 */         xPetArenaRankBackup = Pod.newPetArenaRankBackup();
/* 158 */         Petarenarankbackup.insert(Long.valueOf(key), xPetArenaRankBackup);
/*     */       }
/* 160 */       if (xPetArenaRankBackup.getAward_time() == 0L)
/*     */       {
/* 162 */         xPetArenaRankBackup.setAward_time(now);
/*     */       }
/* 164 */       for (Map.Entry<Long, Integer> xEntry : xPetArenaRankBackup.getAwards().entrySet())
/*     */       {
/* 166 */         long roleid = ((Long)xEntry.getKey()).longValue();
/* 167 */         int rank = ((Integer)xEntry.getValue()).intValue();
/* 168 */         NoneRealTimeTaskManager.getInstance().addTask(new PDailyRankAward(roleid, rank));
/*     */       }
/*     */       
/* 171 */       Map<Long, Integer> roles = new HashMap(xPetArenaRank.getRoles());
/* 172 */       NoneRealTimeTaskManager.getInstance().addTask(new PCheckRankAndBackUp(roles, now));
/*     */       
/* 174 */       GameServer.logger().info("[petarena]PPetArenaInit.processImp@success");
/* 175 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   static boolean isFunOpen()
/*     */   {
/* 181 */     return OpenInterface.getOpenStatus(562);
/*     */   }
/*     */   
/*     */   static boolean isBanPlay(long roleid)
/*     */   {
/* 186 */     return OpenInterface.isBanPlay(roleid, 562);
/*     */   }
/*     */   
/*     */   static boolean isFunOpen(long roleid)
/*     */   {
/* 191 */     if (!OpenInterface.getOpenStatus(562))
/*     */     {
/* 193 */       GameServer.logger().error("[petarena]PetArenaManager.isFunOpen@fun not open");
/* 194 */       return false;
/*     */     }
/* 196 */     if (OpenInterface.isBanPlay(roleid, 562))
/*     */     {
/* 198 */       OpenInterface.sendBanPlayMsg(roleid, 562);
/* 199 */       return false;
/*     */     }
/* 201 */     return true;
/*     */   }
/*     */   
/*     */   static boolean isChartFunOpen(long roleid)
/*     */   {
/* 206 */     if (!OpenInterface.getOpenStatus(569))
/*     */     {
/* 208 */       GameServer.logger().error("[petarena]PetArenaManager.isChartFunOpen@fun not open");
/* 209 */       return false;
/*     */     }
/* 211 */     if (OpenInterface.isBanPlay(roleid, 569))
/*     */     {
/* 213 */       OpenInterface.sendBanPlayMsg(roleid, 569);
/* 214 */       return false;
/*     */     }
/* 216 */     return true;
/*     */   }
/*     */   
/*     */   static boolean canDoAction(long roleid, int action)
/*     */   {
/* 221 */     return mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(roleid, action, true);
/*     */   }
/*     */   
/*     */ 
/*     */   static void initData(long roleid) {}
/*     */   
/*     */ 
/*     */   static void checkData(xbean.PetArenaInfo xPetArenaInfo)
/*     */   {
/* 230 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 231 */     if (DateTimeUtils.needDailyReset(xPetArenaInfo.getInit_time(), now, 0, 0))
/*     */     {
/* 233 */       xPetArenaInfo.setToday_point(0);
/* 234 */       xPetArenaInfo.setChallenge_count(0);
/* 235 */       xPetArenaInfo.setBuy_count(0);
/* 236 */       xPetArenaInfo.setInit_time(now);
/*     */     }
/*     */   }
/*     */   
/*     */   static xbean.PetArenaInfo checkAndInitData(long roleid)
/*     */   {
/* 242 */     xbean.PetArenaInfo xPetArenaInfo = Role2petarenainfo.get(Long.valueOf(roleid));
/* 243 */     if (xPetArenaInfo == null)
/*     */     {
/* 245 */       xPetArenaInfo = Pod.newPetArenaInfo();
/* 246 */       Role2petarenainfo.insert(Long.valueOf(roleid), xPetArenaInfo);
/*     */     }
/* 248 */     checkData(xPetArenaInfo);
/* 249 */     return xPetArenaInfo;
/*     */   }
/*     */   
/*     */ 
/*     */   static void fillPetArenaInfo(mzm.gsp.petarena.PetArenaInfo petArenaInfo, long roleid, int rank, xbean.PetArenaInfo xPetArenaInfo)
/*     */   {
/* 255 */     petArenaInfo.rank = rank;
/* 256 */     petArenaInfo.point = ((int)MallInterface.getJifen(roleid, 14));
/* 257 */     petArenaInfo.buy_count = xPetArenaInfo.getBuy_count();
/* 258 */     petArenaInfo.challenge_count = xPetArenaInfo.getChallenge_count();
/* 259 */     petArenaInfo.refresh_time = ((int)TimeUnit.MILLISECONDS.toSeconds(xPetArenaInfo.getRefresh_time()));
/* 260 */     petArenaInfo.today_point = xPetArenaInfo.getToday_point();
/*     */   }
/*     */   
/*     */   static void sendOpponentsInfos(long roleid, List<RankInfo> rankInfos, int serial)
/*     */   {
/* 265 */     Map<Integer, PetTeamInfo> petTeamInfos = PetArenaTeamManager.getInstance().getPetTeamInfos(rankInfos);
/* 266 */     if (petTeamInfos != null)
/*     */     {
/* 268 */       sendSyncOpponentInfos(roleid, petTeamInfos, serial);
/*     */     }
/*     */     else
/*     */     {
/* 272 */       PetArenaTeamManager.asyncBuildAndSendTeamInfo(roleid, rankInfos, serial);
/*     */     }
/*     */   }
/*     */   
/*     */   static void sendSyncOpponentInfos(long roleid, Map<Integer, PetTeamInfo> petTeamInfos, int serial)
/*     */   {
/* 278 */     SyncOpponentInfos msg = new SyncOpponentInfos();
/* 279 */     for (Map.Entry<Integer, PetTeamInfo> entry : petTeamInfos.entrySet())
/*     */     {
/* 281 */       mzm.gsp.petarena.OpponentInfo opponentInfo = ((PetTeamInfo)entry.getValue()).getOpponentInfo();
/* 282 */       opponentInfo.rank = ((Integer)entry.getKey()).intValue();
/* 283 */       msg.opponent_infos.add(opponentInfo);
/*     */     }
/* 285 */     msg.serial = serial;
/* 286 */     OnlineManager.getInstance().send(roleid, msg);
/*     */   }
/*     */   
/*     */   static List<Integer> getOpponentRanks(int rank)
/*     */   {
/* 291 */     TreeMap<Integer, SPetArenaRankSectionCfg> cfgs = (TreeMap)SPetArenaRankSectionCfg.getAll();
/* 292 */     int minRank = ((Integer)cfgs.firstKey()).intValue();
/* 293 */     List<Integer> result = new ArrayList();
/* 294 */     if (rank < minRank)
/*     */     {
/* 296 */       int randomNum = SPetArenaConst.getInstance().TOP_NUM + SPetArenaConst.getInstance().LOW_NUM + 1;
/* 297 */       int[] randoms = random(1, minRank - 1, randomNum);
/* 298 */       int add = 0;
/* 299 */       int tmpNum = randomNum - 1;
/* 300 */       for (int target : randoms)
/*     */       {
/* 302 */         if (target != rank)
/*     */         {
/*     */ 
/*     */ 
/* 306 */           result.add(Integer.valueOf(target));
/* 307 */           add++; if (add == tmpNum) {
/*     */             break;
/*     */           }
/*     */         }
/*     */       }
/* 312 */       return result;
/*     */     }
/*     */     
/* 315 */     Map.Entry<Integer, SPetArenaRankSectionCfg> entry = cfgs.floorEntry(Integer.valueOf(rank));
/* 316 */     if (entry == null)
/*     */     {
/* 318 */       GameServer.logger().error(String.format("[petarena]PetArenaManager.getOpponentRanks@cfg is null|rank=%d", new Object[] { Integer.valueOf(rank) }));
/* 319 */       return Collections.emptyList();
/*     */     }
/*     */     
/* 322 */     int num = 1;
/* 323 */     int maxRank = SPetArenaConst.getInstance().ROBOT_NUM;
/*     */     
/* 325 */     SPetArenaRankSectionCfg sectionCfg = (SPetArenaRankSectionCfg)entry.getValue();
/* 326 */     List<SectionInfo> sectionInfos = sectionCfg.sectionInfos;
/* 327 */     ListIterator<SectionInfo> listIt = sectionInfos.listIterator(sectionInfos.size());
/* 328 */     while (listIt.hasPrevious())
/*     */     {
/* 330 */       SectionInfo sectionInfo = (SectionInfo)listIt.previous();
/*     */       
/* 332 */       int fromIndex = rank * sectionInfo.minSectionOpponent / 10000;
/* 333 */       if (fromIndex > maxRank)
/*     */       {
/* 335 */         num++;
/*     */       }
/*     */       else {
/* 338 */         int endIndex = rank * sectionInfo.maxSectionOpponent / 10000 - 1;
/* 339 */         if (endIndex > maxRank)
/*     */         {
/* 341 */           endIndex = maxRank;
/*     */         }
/* 343 */         if ((fromIndex == endIndex) && (fromIndex == rank))
/*     */         {
/* 345 */           num++;
/*     */         }
/*     */         else
/*     */         {
/* 349 */           int[] randoms = null;
/* 350 */           if ((fromIndex > rank) || (endIndex < rank))
/*     */           {
/* 352 */             randoms = random(fromIndex, endIndex, num);
/*     */           }
/*     */           else
/*     */           {
/* 356 */             randoms = random(fromIndex, endIndex, num + 1);
/*     */           }
/*     */           
/* 359 */           int add = 0;
/* 360 */           int tmpNum = num;
/* 361 */           for (int target : randoms)
/*     */           {
/* 363 */             if (target != rank)
/*     */             {
/*     */ 
/*     */ 
/* 367 */               result.add(Integer.valueOf(target));
/* 368 */               num--;
/* 369 */               add++;
/* 370 */               if (add == tmpNum) {
/*     */                 break;
/*     */               }
/*     */             }
/*     */           }
/* 375 */           num++;
/*     */         }
/*     */       } }
/* 378 */     Collections.sort(result);
/* 379 */     return result;
/*     */   }
/*     */   
/*     */   private static int[] random(int fromIndex, int endIndex, int num)
/*     */   {
/* 384 */     if (fromIndex == endIndex)
/*     */     {
/* 386 */       int[] result = { fromIndex };
/* 387 */       return result;
/*     */     }
/* 389 */     if (num == 1)
/*     */     {
/* 391 */       Random random = Xdb.random();
/* 392 */       int r = random.nextInt(endIndex - fromIndex + 1) + fromIndex;
/* 393 */       int[] result = { r };
/* 394 */       return result;
/*     */     }
/*     */     
/*     */ 
/* 398 */     int len = endIndex - fromIndex + 1;
/* 399 */     if (len <= num)
/*     */     {
/* 401 */       int[] result = new int[len];
/* 402 */       for (int i = 0; i < len; i++)
/*     */       {
/* 404 */         result[i] = (fromIndex + i);
/*     */       }
/* 406 */       return result;
/*     */     }
/*     */     
/* 409 */     int[] source = new int[len];
/* 410 */     for (int i = 0; i < len; i++)
/*     */     {
/* 412 */       source[i] = (fromIndex + i);
/*     */     }
/*     */     
/* 415 */     int[] result = new int[num];
/* 416 */     Random random = Xdb.random();
/*     */     
/* 418 */     for (int i = 0; i < num; i++)
/*     */     {
/* 420 */       int index = random.nextInt(len);
/* 421 */       result[i] = source[index];
/* 422 */       source[index] = source[(--len)];
/*     */     }
/* 424 */     return result;
/*     */   }
/*     */   
/*     */ 
/*     */   static int getAwardPoint(int rank)
/*     */   {
/* 430 */     double maxPoint = SPetArenaConst.getInstance().MAX_POINT * 1.0D;
/* 431 */     double maxNum = SPetArenaConst.getInstance().ROBOT_NUM * 1.0D;
/* 432 */     int param = SPetArenaConst.getInstance().FORMATION_PARAM;
/*     */     
/* 434 */     double d1 = maxPoint / Math.log10(rank * 1.0D + param);
/* 435 */     double d2 = maxPoint * (Math.log10(rank * 1.0D) / Math.log10(maxNum)) / Math.log10(maxNum + param);
/* 436 */     return (int)(d1 - d2);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static PetArenaFightRecordInfo buildFightRecordInfo(long recordid, int type, boolean win, int oldRank, int newRank, long opponentRoleid, long time, List<PetArenaFightInfo> activeInfos, List<PetArenaFightInfo> passiveInfos, Map<Long, Integer> damages)
/*     */   {
/* 444 */     PetArenaFightRecordInfo xFightRecordInfo = Pod.newPetArenaFightRecordInfo();
/* 445 */     xFightRecordInfo.setIs_win(win ? 1 : 0);
/* 446 */     xFightRecordInfo.setNew_rank(newRank);
/* 447 */     xFightRecordInfo.setOld_rank(oldRank);
/* 448 */     xFightRecordInfo.setRecord_type(type);
/* 449 */     xFightRecordInfo.setRecordid(recordid);
/* 450 */     xFightRecordInfo.setRoleid(opponentRoleid);
/* 451 */     xFightRecordInfo.setTime(time);
/* 452 */     xFightRecordInfo.setRoleid(opponentRoleid);
/* 453 */     if (opponentRoleid > 0L)
/*     */     {
/* 455 */       Role role = RoleInterface.getRole(opponentRoleid, true);
/* 456 */       xFightRecordInfo.setGender(role.getGender());
/* 457 */       xFightRecordInfo.setOccupation(role.getOccupationId());
/* 458 */       xFightRecordInfo.setName(role.getName());
/* 459 */       xFightRecordInfo.setAvatar(mzm.gsp.avatar.main.AvatarInterface.getCurrentAvatar(opponentRoleid, true));
/* 460 */       xFightRecordInfo.setAvatar_frame(mzm.gsp.avatar.frame.AvatarFrameInterface.getCurrentAvatarFrameId(opponentRoleid, true));
/*     */     }
/*     */     else
/*     */     {
/* 464 */       xFightRecordInfo.setName(SPetArenaConst.getInstance().ROBOT_NAME);
/*     */     }
/* 466 */     for (PetArenaFightInfo fightInfo : activeInfos)
/*     */     {
/* 468 */       xbean.PetArenaFightInfo xPetArenaFightInfo = buildPetArenaFightInfo(fightInfo, damages);
/* 469 */       xFightRecordInfo.getActivie_pet_infos().add(xPetArenaFightInfo);
/*     */     }
/* 471 */     for (PetArenaFightInfo fightInfo : passiveInfos)
/*     */     {
/* 473 */       xbean.PetArenaFightInfo xPetArenaFightInfo = buildPetArenaFightInfo(fightInfo, damages);
/* 474 */       xFightRecordInfo.getPassive_pet_infos().add(xPetArenaFightInfo);
/*     */     }
/* 476 */     return xFightRecordInfo;
/*     */   }
/*     */   
/*     */ 
/*     */   private static xbean.PetArenaFightInfo buildPetArenaFightInfo(PetArenaFightInfo fightInfo, Map<Long, Integer> damages)
/*     */   {
/* 482 */     xbean.PetArenaFightInfo xPetArenaFightInfo = Pod.newPetArenaFightInfo();
/* 483 */     long petid = fightInfo.petid;
/* 484 */     Integer damage = (Integer)damages.get(Long.valueOf(petid));
/* 485 */     if (damage != null)
/*     */     {
/* 487 */       xPetArenaFightInfo.setDamage(damage.intValue());
/*     */     }
/* 489 */     xPetArenaFightInfo.setMonster_cfgid(fightInfo.monsterCfgid);
/* 490 */     xPetArenaFightInfo.setName(fightInfo.name);
/* 491 */     xPetArenaFightInfo.setPet_cfgid(fightInfo.petCfgid);
/* 492 */     xPetArenaFightInfo.setPetid(petid);
/* 493 */     xPetArenaFightInfo.setPosition(fightInfo.position);
/* 494 */     return xPetArenaFightInfo;
/*     */   }
/*     */   
/*     */   static RobotPetTeamInfo randomRobotPetTeam(int rank)
/*     */   {
/* 499 */     TreeMap<Integer, SPetArenaRobotCfg> cfgs = (TreeMap)SPetArenaRobotCfg.getAll();
/* 500 */     Map.Entry<Integer, SPetArenaRobotCfg> entry = cfgs.floorEntry(Integer.valueOf(rank));
/* 501 */     if (entry == null)
/*     */     {
/* 503 */       GameServer.logger().error(String.format("[petarena]PetArenaManager.randomRobotPetTeam@cfg is null|rank=%d", new Object[] { Integer.valueOf(rank) }));
/* 504 */       return null;
/*     */     }
/*     */     
/* 507 */     SPetArenaRobotCfg robotCfg = (SPetArenaRobotCfg)entry.getValue();
/* 508 */     if (robotCfg.formationCfgids.isEmpty())
/*     */     {
/* 510 */       GameServer.logger().error(String.format("[petarena]PetArenaManager.randomRobotPetTeam@formation empty|rank=%d|key=%d", new Object[] { Integer.valueOf(rank), entry.getKey() }));
/*     */       
/*     */ 
/* 513 */       return null;
/*     */     }
/*     */     
/* 516 */     int index = random(robotCfg.formationCfgids.size());
/* 517 */     int formation = ((Integer)robotCfg.formationCfgids.get(index)).intValue();
/* 518 */     SPetArenaFormationToRobotCfg petArenaFormationToRobotCfg = SPetArenaFormationToRobotCfg.get(formation);
/* 519 */     if (petArenaFormationToRobotCfg == null)
/*     */     {
/* 521 */       GameServer.logger().error(String.format("[petarena]PetArenaManager.randomRobotPetTeam@cfg is null|rank=%d|formation=%d", new Object[] { Integer.valueOf(rank), Integer.valueOf(formation) }));
/*     */       
/*     */ 
/* 524 */       return null;
/*     */     }
/* 526 */     if (robotCfg.positions.size() != petArenaFormationToRobotCfg.positions.size())
/*     */     {
/* 528 */       GameServer.logger().error(String.format("[petarena]PetArenaManager.randomRobotPetTeam@position not match|rank=%d|formation=%d", new Object[] { Integer.valueOf(rank), Integer.valueOf(formation) }));
/*     */       
/*     */ 
/* 531 */       return null;
/*     */     }
/* 533 */     List<Integer> gridPositions = PetFightInterface.getAvailableGridsFromFormation(formation);
/* 534 */     if (robotCfg.positions.size() != gridPositions.size())
/*     */     {
/* 536 */       GameServer.logger().error(String.format("[petarena]PetArenaManager.randomRobotPetTeam@grid position not match|rank=%d|formation=%d", new Object[] { Integer.valueOf(rank), Integer.valueOf(formation) }));
/*     */       
/*     */ 
/* 539 */       return null;
/*     */     }
/*     */     
/* 542 */     int serverLevel = ServerInterface.getCurrentServerLevel();
/* 543 */     Map<Integer, RobotPetPositionInfo> positionInfos = new HashMap();
/* 544 */     Map<Long, RobotPetInfo> robotPetInfos = new HashMap();
/* 545 */     for (int i = 0; i < robotCfg.positions.size(); i++)
/*     */     {
/* 547 */       int position = i + 1;
/* 548 */       PetTypeInfo petTypeInfo = (PetTypeInfo)petArenaFormationToRobotCfg.positions.get(Integer.valueOf(position));
/* 549 */       if ((petTypeInfo == null) || (petTypeInfo.petTypes.isEmpty()))
/*     */       {
/* 551 */         GameServer.logger().error(String.format("[petarena]PetArenaManager.randomRobotPetTeam@pet type info invalid|rank=%d|formation=%d|position=%d", new Object[] { Integer.valueOf(rank), Integer.valueOf(formation), Integer.valueOf(position) }));
/*     */         
/*     */ 
/*     */ 
/* 555 */         return null;
/*     */       }
/* 557 */       if (petTypeInfo.petTypes.isEmpty())
/*     */       {
/* 559 */         GameServer.logger().error(String.format("[petarena]PetArenaManager.randomRobotPetTeam@pet type info empty|rank=%d|formation=%d|position=%d", new Object[] { Integer.valueOf(rank), Integer.valueOf(formation), Integer.valueOf(position) }));
/*     */         
/*     */ 
/*     */ 
/* 563 */         return null;
/*     */       }
/* 565 */       int petType = ((Integer)petTypeInfo.petTypes.get(random(petTypeInfo.petTypes.size()))).intValue();
/* 566 */       int robotTypeid = ((Integer)robotCfg.positions.get(i)).intValue();
/* 567 */       mzm.gsp.petarena.confbean.RobotPetInfo robotPetInfo = getRobotPetInfo(serverLevel, robotTypeid, petType);
/* 568 */       if (robotPetInfo == null)
/*     */       {
/* 570 */         GameServer.logger().error(String.format("[petarena]PetArenaManager.randomRobotPetTeam@robot pet info is null|rank=%d|formation=%d|position=%d|pet_type=%d|typeid=%d|server_level=%d", new Object[] { Integer.valueOf(rank), Integer.valueOf(formation), Integer.valueOf(position), Integer.valueOf(petType), Integer.valueOf(robotTypeid), Integer.valueOf(serverLevel) }));
/*     */         
/*     */ 
/*     */ 
/* 574 */         return null;
/*     */       }
/*     */       
/* 577 */       int monsterCfgid = robotPetInfo.monsterCfgid;
/* 578 */       SMonsterCfg monsterCfg = SMonsterCfg.get(monsterCfgid);
/* 579 */       if (monsterCfg == null)
/*     */       {
/* 581 */         GameServer.logger().error(String.format("[petarena]PetArenaManager.randomRobotPetTeam@monster cfg is null|rank=%d|formation=%d|position=%d|pet_type=%d|typeid=%d|server_level=%d|monster=%d", new Object[] { Integer.valueOf(rank), Integer.valueOf(formation), Integer.valueOf(position), Integer.valueOf(petType), Integer.valueOf(robotTypeid), Integer.valueOf(serverLevel), Integer.valueOf(monsterCfgid) }));
/*     */         
/*     */ 
/*     */ 
/* 585 */         return null;
/*     */       }
/*     */       
/* 588 */       int grid = ((Integer)gridPositions.get(i)).intValue();
/* 589 */       positionInfos.put(Integer.valueOf(grid), new RobotPetPositionInfo(i, position, 0, null));
/* 590 */       robotPetInfos.put(Long.valueOf(i), new RobotPetInfo(monsterCfgid, robotPetInfo.petFightModelRatio, 0, robotPetInfo.petYaoLiLevel, robotPetInfo.petScore, monsterCfg.name));
/*     */     }
/*     */     
/*     */ 
/* 594 */     return new RobotPetTeamInfo(formation, robotCfg.formationLevel, positionInfos, robotPetInfos, serverLevel + SPetArenaConst.getInstance().ROBOT_LEVEL);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private static mzm.gsp.petarena.confbean.RobotPetInfo getRobotPetInfo(int serverLevel, int typeid, int petType)
/*     */   {
/* 601 */     SPetArenaRobotAttributeCfg petArenaRobotAttributeCfg = SPetArenaRobotAttributeCfg.get(serverLevel);
/* 602 */     if (petArenaRobotAttributeCfg == null)
/*     */     {
/* 604 */       return null;
/*     */     }
/* 606 */     TypeToRobotPetInfo typeToRobotPetInfo = (TypeToRobotPetInfo)petArenaRobotAttributeCfg.typeids.get(Integer.valueOf(typeid));
/* 607 */     if (typeToRobotPetInfo == null)
/*     */     {
/* 609 */       return null;
/*     */     }
/* 611 */     return (mzm.gsp.petarena.confbean.RobotPetInfo)typeToRobotPetInfo.type2pet.get(Integer.valueOf(petType));
/*     */   }
/*     */   
/*     */   private static int random(int bound)
/*     */   {
/* 616 */     Random random = Xdb.random();
/* 617 */     return random.nextInt(bound);
/*     */   }
/*     */   
/*     */   static boolean cost(String userid, long roleid, int type, int num, TLogArg tLogArg)
/*     */   {
/* 622 */     boolean result = true;
/* 623 */     switch (type)
/*     */     {
/*     */     case 1: 
/* 626 */       CostResult costResult = QingfuInterface.costYuanbao(userid, roleid, num, CostType.COST_BIND_FIRST_PET_ARENA_BUY_COUNT, tLogArg);
/*     */       
/* 628 */       if (costResult != CostResult.Success)
/*     */       {
/* 630 */         result = false;
/* 631 */         GameServer.logger().error(String.format("[petarena]PetArenaManager.cost@cost yuanbao failed|userid=%s|roleid=%d|num=%d|code=%d|desc=%s", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(num), Integer.valueOf(costResult.code), costResult.desc }));
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */       break;
/*     */     case 2: 
/* 638 */       result = RoleInterface.cutGold(roleid, num, tLogArg);
/* 639 */       break;
/*     */     case 3: 
/* 641 */       result = RoleInterface.cutSilver(roleid, num, tLogArg);
/* 642 */       break;
/*     */     case 5: 
/* 644 */       result = RoleInterface.cutGoldIngot(roleid, num, tLogArg);
/* 645 */       break;
/*     */     case 0: 
/* 647 */       result = false;
/* 648 */       break;
/*     */     
/*     */     case 4: 
/* 651 */       result = false;
/* 652 */       break;
/*     */     default: 
/* 654 */       result = false;
/*     */     }
/*     */     
/* 657 */     if (!result)
/*     */     {
/* 659 */       GameServer.logger().error(String.format("[petarena]PetArenaManager.cost@cost money failed|userid=%s|roleid=%d|money_type=%d|num=%d", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(type), Integer.valueOf(num) }));
/*     */     }
/*     */     
/*     */ 
/* 663 */     return result;
/*     */   }
/*     */   
/*     */   static void addTLog(long roleid, String logName, Object... logColumns)
/*     */   {
/* 668 */     String vGameIp = GameServerInfoManager.getHostIP();
/* 669 */     int roleLevel = RoleInterface.getLevel(roleid);
/* 670 */     String userid = RoleInterface.getUserId(roleid);
/*     */     
/* 672 */     StringBuilder logStr = new StringBuilder();
/* 673 */     logStr.append(vGameIp);
/* 674 */     logStr.append("|").append(userid);
/* 675 */     logStr.append("|").append(roleid);
/* 676 */     logStr.append("|").append(roleLevel);
/*     */     
/* 678 */     for (Object colum : logColumns)
/*     */     {
/* 680 */       logStr.append("|").append(colum);
/*     */     }
/*     */     
/* 683 */     TLogManager.getInstance().addLog(roleid, logName, logStr.toString());
/*     */   }
/*     */   
/*     */   static void startPetAwardObserver(long roleid)
/*     */   {
/* 688 */     xbean.PetArenaAwardObserver xPetArenaAwardObserver = Role2petarenaawardobserver.get(Long.valueOf(roleid));
/* 689 */     if (xPetArenaAwardObserver == null)
/*     */     {
/* 691 */       xPetArenaAwardObserver = Pod.newPetArenaAwardObserver();
/* 692 */       Role2petarenaawardobserver.insert(Long.valueOf(roleid), xPetArenaAwardObserver);
/*     */     }
/* 694 */     if (xPetArenaAwardObserver.getObserver() != null)
/*     */     {
/* 696 */       xPetArenaAwardObserver.getObserver().stopTimer();
/*     */     }
/* 698 */     int maxMinutes = SPetArenaConst.getInstance().PET_ARENA_FIGHT_MAX_TIME;
/* 699 */     xPetArenaAwardObserver.setObserver(new FightEndAwardObserver(TimeUnit.MINUTES.toSeconds(maxMinutes), roleid));
/*     */   }
/*     */   
/*     */   static void cancelPetAwardObserver(long roleid)
/*     */   {
/* 704 */     xbean.PetArenaAwardObserver xPetArenaAwardObserver = Role2petarenaawardobserver.get(Long.valueOf(roleid));
/* 705 */     if (xPetArenaAwardObserver != null)
/*     */     {
/* 707 */       Observer observer = xPetArenaAwardObserver.getObserver();
/* 708 */       if (observer != null)
/*     */       {
/* 710 */         observer.stopTimer();
/* 711 */         xPetArenaAwardObserver.setObserver(null);
/*     */       }
/*     */     }
/* 714 */     Role2petarenaawardobserver.remove(Long.valueOf(roleid));
/*     */   }
/*     */   
/*     */ 
/*     */   static boolean getPetArenaAward(long roleid)
/*     */   {
/* 720 */     String userid = RoleInterface.getUserId(roleid);
/* 721 */     Lockeys.lock(Lockeys.get(xtable.User.getTable(), userid));
/* 722 */     Lockeys.lock(Lockeys.get(xtable.Basic.getTable(), Long.valueOf(roleid)));
/*     */     
/* 724 */     xbean.PetArenaInfo xPetArenaInfo = Role2petarenainfo.get(Long.valueOf(roleid));
/* 725 */     if (xPetArenaInfo == null)
/*     */     {
/* 727 */       GameServer.logger().error(String.format("[petarena]PetArenaManager.getPetArenaAward@xbean is null|roleid=%d", new Object[] { Long.valueOf(roleid) }));
/*     */       
/* 729 */       return false;
/*     */     }
/* 731 */     checkData(xPetArenaInfo);
/*     */     
/*     */ 
/* 734 */     int awardid = xPetArenaInfo.getAward().getAwardid();
/* 735 */     int modifyCfgid = xPetArenaInfo.getAward().getModify_cfgid();
/* 736 */     int addPoint = xPetArenaInfo.getAward().getPoint();
/* 737 */     if ((awardid == 0) && (modifyCfgid == 0) && (addPoint == 0))
/*     */     {
/* 739 */       GameServer.logger().error(String.format("[petarena]PetArenaManager.getPetArenaAward@award is empty|roleid=%d", new Object[] { Long.valueOf(roleid) }));
/*     */       
/* 741 */       return false;
/*     */     }
/*     */     
/* 744 */     if (awardid > 0)
/*     */     {
/* 746 */       AwardReason awardReason = new AwardReason(LogReason.PET_ARENA_FIGHT_END, awardid);
/* 747 */       mzm.gsp.award.main.AwardModel awardModel = mzm.gsp.award.main.AwardInterface.award(awardid, userid, roleid, modifyCfgid, false, true, awardReason);
/* 748 */       if (awardModel == null)
/*     */       {
/* 750 */         GameServer.logger().error(String.format("[petarena]PetArenaManager.getPetArenaAward@award failed|roleid=%d|award=%d|modify_cfgid=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(awardid), Integer.valueOf(modifyCfgid) }));
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 757 */     if (addPoint > 0)
/*     */     {
/* 759 */       TLogArg logArg = new TLogArg(LogReason.PET_ARENA_FIGHT_END);
/* 760 */       JifenOperateResult res = MallInterface.addJifen(roleid, addPoint, 14, true, logArg);
/* 761 */       if (!res.isSuccess())
/*     */       {
/* 763 */         GameServer.logger().error(String.format("[petarena]PetArenaManager.getPetArenaAward@add jifen failed|roleid=%d|add_point=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(addPoint) }));
/*     */       }
/*     */       
/*     */ 
/* 767 */       xPetArenaInfo.setToday_point(xPetArenaInfo.getToday_point() + addPoint);
/*     */     }
/*     */     
/*     */ 
/* 771 */     cancelPetAwardObserver(roleid);
/*     */     
/*     */ 
/* 774 */     xPetArenaInfo.getAward().setAwardid(0);
/* 775 */     xPetArenaInfo.getAward().setModify_cfgid(0);
/* 776 */     xPetArenaInfo.getAward().setPoint(0);
/*     */     
/* 778 */     SFightEndSuccess msg = new SFightEndSuccess();
/* 779 */     msg.point = ((int)MallInterface.getJifen(roleid, 14));
/* 780 */     msg.today_point = xPetArenaInfo.getToday_point();
/* 781 */     msg.add_point = addPoint;
/* 782 */     OnlineManager.getInstance().send(roleid, msg);
/*     */     
/* 784 */     GameServer.logger().info(String.format("[petarena]PetArenaManager.getPetArenaAward@success|roleid=%d|add_point=%d|award=%d|modify_cfgid=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(addPoint), Integer.valueOf(awardid), Integer.valueOf(modifyCfgid) }));
/*     */     
/*     */ 
/*     */ 
/* 788 */     return true;
/*     */   }
/*     */   
/*     */   static void sendPetAreanInfoMsg(long roleid, xbean.PetArenaInfo xPetArenaInfo)
/*     */   {
/* 793 */     int rank = PetArenaRankManager.getInstance().getRank(roleid);
/* 794 */     List<PetArenaRankInfo> xPetArenaRankInfos = xPetArenaInfo.getOpponent_ranks();
/* 795 */     if (xPetArenaRankInfos.isEmpty())
/*     */     {
/* 797 */       int randomRank = rank;
/* 798 */       if (randomRank <= 0)
/*     */       {
/* 800 */         randomRank = SPetArenaConst.getInstance().ROBOT_NUM + 1;
/*     */       }
/* 802 */       List<Integer> ranks = getOpponentRanks(randomRank);
/* 803 */       List<RankInfo> rankInfos = PetArenaRankManager.getInstance().getRankInfos(ranks);
/* 804 */       for (RankInfo rankInfo : rankInfos)
/*     */       {
/* 806 */         PetArenaRankInfo xPetArenaRankInfo = Pod.newPetArenaRankInfo();
/* 807 */         xPetArenaRankInfo.setRank(rankInfo.rank);
/* 808 */         xPetArenaRankInfo.setRoleid(rankInfo.roleid);
/* 809 */         xPetArenaRankInfos.add(xPetArenaRankInfo);
/*     */       }
/* 811 */       sendOpponentsInfos(roleid, rankInfos, xPetArenaInfo.getOpponent_serial());
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 816 */       List<Integer> ranks = new ArrayList();
/* 817 */       for (PetArenaRankInfo xPetArenaRankInfo : xPetArenaRankInfos)
/*     */       {
/* 819 */         ranks.add(Integer.valueOf(xPetArenaRankInfo.getRank()));
/*     */       }
/* 821 */       List<RankInfo> rankInfos = PetArenaRankManager.getInstance().getRankInfos(ranks);
/* 822 */       xPetArenaRankInfos.clear();
/* 823 */       for (RankInfo rankInfo : rankInfos)
/*     */       {
/* 825 */         PetArenaRankInfo xPetArenaRankInfo = Pod.newPetArenaRankInfo();
/* 826 */         xPetArenaRankInfo.setRank(rankInfo.rank);
/* 827 */         xPetArenaRankInfo.setRoleid(rankInfo.roleid);
/* 828 */         xPetArenaRankInfos.add(xPetArenaRankInfo);
/*     */       }
/* 830 */       sendOpponentsInfos(roleid, rankInfos, xPetArenaInfo.getOpponent_serial());
/*     */     }
/*     */     
/* 833 */     SGetPetArenaInfoSuccess rsp = new SGetPetArenaInfoSuccess();
/* 834 */     fillPetArenaInfo(rsp.pet_arena_info, roleid, rank, xPetArenaInfo);
/* 835 */     OnlineManager.getInstance().send(roleid, rsp);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petarena\main\PetArenaManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */