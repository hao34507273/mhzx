/*     */ package mzm.gsp.makeup.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity4.confbean.SMakeUpActivityCfg;
/*     */ import mzm.gsp.activity4.confbean.STMakeUpQuestionCfg;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.makeup.RoleMakeUpInfo;
/*     */ import mzm.gsp.makeup.SStartMakeUpQuestion;
/*     */ import mzm.gsp.makeup.SSynMakeupInfo;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.Pair;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.FactionMakeUpRecord;
/*     */ import xbean.GlobalMakeUpInfo;
/*     */ import xbean.MakeUpInfo;
/*     */ import xbean.MakeUpRecord;
/*     */ import xbean.Pod;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Gangmakeup;
/*     */ import xtable.Globalmakeup;
/*     */ import xtable.Role2makeupinfo;
/*     */ import xtable.User;
/*     */ 
/*     */ public class MakeUpManager
/*     */ {
/*     */   private static final String loggerTag = "[makeup]";
/*     */   
/*     */   static void startMakeup(int activityid, SMakeUpActivityCfg cfg)
/*     */   {
/*  46 */     onMakeUpStart(activityid, cfg, -1);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void reStartMakeup(int activityid, SMakeUpActivityCfg cfg)
/*     */   {
/*  58 */     if (!OpenInterface.getOpenStatus(cfg.switchId))
/*     */     {
/*  60 */       loggerInfo("MakeUpManager.startMakeup@ not open!|activityId=%d", new Object[] { Integer.valueOf(activityid) });
/*  61 */       return;
/*     */     }
/*     */     
/*  64 */     long curTime = DateTimeUtils.getCurrTimeInMillis();
/*  65 */     long startTime = ActivityInterface.getActivityStartTime(activityid);
/*  66 */     if ((startTime == 0L) || (startTime > curTime))
/*     */     {
/*  68 */       return;
/*     */     }
/*     */     
/*  71 */     if (curTime - startTime < cfg.prepareTime * 1000L)
/*     */     {
/*     */ 
/*  74 */       onMakeUpStart(activityid, cfg, (int)((curTime - startTime) / 1000L));
/*  75 */       return;
/*     */     }
/*     */     
/*  78 */     GlobalMakeUpInfo xGlobalMakeUpInfo = getGlobalMakeupInfoIfAbsent(activityid);
/*  79 */     long questionOrgTime = startTime + cfg.prepareTime * 1000L;
/*  80 */     int misTurn = (int)((curTime - questionOrgTime) / (cfg.turnTime * 1000L));
/*  81 */     if (misTurn >= cfg.turn - 1)
/*     */     {
/*     */ 
/*  84 */       xGlobalMakeUpInfo.setQuetioning(false);
/*  85 */       return;
/*     */     }
/*     */     
/*  88 */     xGlobalMakeUpInfo.setTurn(misTurn);
/*  89 */     xGlobalMakeUpInfo.setQuetioning(true);
/*     */     
/*  91 */     int nextTurnTime = (int)((questionOrgTime + (misTurn + 1) * (cfg.turnTime * 1000L) - curTime) / 1000L);
/*     */     
/*  93 */     long sessionId = new PrepareSession(nextTurnTime, activityid, PrepareSession.PrepareReason.ACTIVITY_RECOVERY).getSessionId();
/*  94 */     xGlobalMakeUpInfo.setPreparesessionid(sessionId);
/*     */   }
/*     */   
/*     */   static void onMakeUpStart(int activityid, SMakeUpActivityCfg cfg, int sessionInterval)
/*     */   {
/*  99 */     Set<Long> allFactionIds = GangInterface.getAllGangIdSet();
/*     */     
/* 101 */     GlobalMakeUpInfo xGlobalMakeUpInfo = getGlobalMakeupInfoIfAbsent(activityid);
/*     */     
/* 103 */     xGlobalMakeUpInfo.setTurn(0);
/* 104 */     xGlobalMakeUpInfo.setQuetioning(true);
/*     */     
/* 106 */     for (Iterator i$ = allFactionIds.iterator(); i$.hasNext();) { long factionId = ((Long)i$.next()).longValue();
/*     */       
/* 108 */       asynInitGactionData(factionId, activityid);
/*     */     }
/*     */     
/* 111 */     if (!OpenInterface.getOpenStatus(cfg.switchId))
/*     */     {
/* 113 */       loggerInfo("MakeUpManager.startMakeup@ not open!|activityId=%d", new Object[] { Integer.valueOf(activityid) });
/* 114 */       return;
/*     */     }
/*     */     
/* 117 */     long sessionId = new PrepareSession(sessionInterval >= 0 ? sessionInterval : cfg.prepareTime, activityid, PrepareSession.PrepareReason.ACTIVITY_PREPARE).getSessionId();
/*     */     
/* 119 */     xGlobalMakeUpInfo.setPreparesessionid(sessionId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void asynInitGactionData(long factionId, int activityId)
/*     */   {
/* 130 */     new LogicProcedure()
/*     */     {
/*     */ 
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/* 136 */         xbean.FactionMakeUpInfo xFactionMakeUpInfo = Gangmakeup.get(Long.valueOf(this.val$factionId));
/* 137 */         if (xFactionMakeUpInfo == null)
/*     */         {
/* 139 */           return false;
/*     */         }
/* 141 */         xFactionMakeUpInfo.getActivityid2record().remove(Integer.valueOf(this.val$activityId));
/* 142 */         return true;
/*     */       }
/*     */     }.execute();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static MakeUpRecord getXMakeUpRecordIfAbsent(long roleId, int activityId)
/*     */   {
/* 156 */     MakeUpInfo xMakeUpInfo = Role2makeupinfo.get(Long.valueOf(roleId));
/* 157 */     if (xMakeUpInfo == null)
/*     */     {
/* 159 */       Role2makeupinfo.insert(Long.valueOf(roleId), xMakeUpInfo = Pod.newMakeUpInfo());
/*     */     }
/* 161 */     MakeUpRecord xMakeUpRecord = (MakeUpRecord)xMakeUpInfo.getActivityid2record().get(Integer.valueOf(activityId));
/* 162 */     if (xMakeUpRecord == null)
/*     */     {
/* 164 */       xMakeUpInfo.getActivityid2record().put(Integer.valueOf(activityId), xMakeUpRecord = Pod.newMakeUpRecord());
/*     */     }
/* 166 */     return xMakeUpRecord;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static GlobalMakeUpInfo getGlobalMakeupInfoIfAbsent(int activityid)
/*     */   {
/* 177 */     long key = GameServerInfoManager.toGlobalId(activityid);
/* 178 */     GlobalMakeUpInfo xGlobalMakeUpInfo = Globalmakeup.get(Long.valueOf(key));
/* 179 */     if (xGlobalMakeUpInfo == null)
/*     */     {
/* 181 */       Globalmakeup.insert(Long.valueOf(key), xGlobalMakeUpInfo = Pod.newGlobalMakeUpInfo());
/*     */     }
/* 183 */     return xGlobalMakeUpInfo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static GlobalMakeUpInfo getGlobalMakeupInfo(int activityid)
/*     */   {
/* 194 */     return Globalmakeup.get(Long.valueOf(GameServerInfoManager.toGlobalId(activityid)));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static FactionMakeUpRecord getFactionActivityInfoIfAbsent(long factionId, int activityId)
/*     */   {
/* 206 */     xbean.FactionMakeUpInfo xFactionMakeUpInfo = Gangmakeup.get(Long.valueOf(factionId));
/* 207 */     if (xFactionMakeUpInfo == null)
/*     */     {
/* 209 */       Gangmakeup.insert(Long.valueOf(factionId), xFactionMakeUpInfo = Pod.newFactionMakeUpInfo());
/*     */     }
/* 211 */     FactionMakeUpRecord xFactionMakeUpRecord = (FactionMakeUpRecord)xFactionMakeUpInfo.getActivityid2record().get(Integer.valueOf(activityId));
/* 212 */     if (xFactionMakeUpRecord == null)
/*     */     {
/* 214 */       xFactionMakeUpInfo.getActivityid2record().put(Integer.valueOf(activityId), xFactionMakeUpRecord = Pod.newFactionMakeUpRecord());
/*     */     }
/* 216 */     return xFactionMakeUpRecord;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static FactionMakeUpRecord getFactionActivityInfo(long factionId, int activityId)
/*     */   {
/* 228 */     xbean.FactionMakeUpInfo xFactionMakeUpInfo = Gangmakeup.get(Long.valueOf(factionId));
/* 229 */     if (xFactionMakeUpInfo == null)
/*     */     {
/* 231 */       return null;
/*     */     }
/* 233 */     return (FactionMakeUpRecord)xFactionMakeUpInfo.getActivityid2record().get(Integer.valueOf(activityId));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void sendQuestion(int activityId, final PrepareSession.PrepareReason reason)
/*     */   {
/* 244 */     xdb.Procedure.execute(new LogicProcedure()
/*     */     {
/*     */ 
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/* 250 */         for (Iterator i$ = GangInterface.getAllGangIdSet().iterator(); i$.hasNext();) { long factionId = ((Long)i$.next()).longValue();
/*     */           
/* 252 */           MakeUpManager.asynSendQuestionPerFaction(factionId, this.val$activityId, reason);
/*     */         }
/* 254 */         return true;
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   private static void asynSendQuestionPerFaction(long factionId, int activityId, final PrepareSession.PrepareReason reason)
/*     */   {
/* 261 */     new LogicProcedure()
/*     */     {
/*     */ 
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/* 267 */         return MakeUpManager.sendQuestion(this.val$factionId, reason, this.val$reason);
/*     */       }
/*     */     }.execute();
/*     */   }
/*     */   
/*     */ 
/*     */   static boolean sendQuestion(long factionId, int activityId, PrepareSession.PrepareReason reason)
/*     */   {
/* 275 */     boolean needTurnAward = true;
/* 276 */     if ((reason == PrepareSession.PrepareReason.ACTIVITY_RECOVERY) || (reason == PrepareSession.PrepareReason.ACTIVITY_PREPARE))
/*     */     {
/* 278 */       needTurnAward = false;
/*     */     }
/* 280 */     SMakeUpActivityCfg cfg = SMakeUpActivityCfg.get(activityId);
/* 281 */     if (cfg == null)
/*     */     {
/* 283 */       return false;
/*     */     }
/*     */     
/* 286 */     FactionMakeUpRecord xFactionMakeUpRecord = getFactionActivityInfoIfAbsent(factionId, activityId);
/*     */     
/* 288 */     GlobalMakeUpInfo xGlobalMakeupInfo = getGlobalMakeupInfo(activityId);
/* 289 */     if (xGlobalMakeupInfo == null)
/*     */     {
/* 291 */       return false;
/*     */     }
/*     */     
/* 294 */     if (needTurnAward)
/*     */     {
/* 296 */       doTurnAward(factionId, activityId, cfg, xFactionMakeUpRecord);
/*     */     }
/*     */     
/* 299 */     initFactionRecord(cfg.noneRepeatTurn, xFactionMakeUpRecord);
/*     */     
/* 301 */     setNewQuestion(activityId, cfg, xFactionMakeUpRecord, xGlobalMakeupInfo, factionId);
/* 302 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private static void setNewQuestion(int activityId, SMakeUpActivityCfg cfg, FactionMakeUpRecord xFactionMakeUpRecord, GlobalMakeUpInfo xGlobalMakeupInfo, long factionId)
/*     */   {
/* 308 */     if ((!xGlobalMakeupInfo.getQuetioning()) || (xGlobalMakeupInfo.getTurn() > cfg.turn))
/*     */     {
/* 310 */       return;
/*     */     }
/*     */     
/* 313 */     xFactionMakeUpRecord.setCurturn(xGlobalMakeupInfo.getTurn());
/* 314 */     Pair<Integer, Integer> question = getQuestion(activityId, xFactionMakeUpRecord);
/*     */     
/* 316 */     xFactionMakeUpRecord.setQuestionid(((Integer)question.first).intValue());
/*     */     
/* 318 */     ArrayList<Integer> options = new ArrayList();
/* 319 */     ArrayList<Integer> allOptionIds = new ArrayList(mzm.gsp.activity4.confbean.SMakeUpOptionCfg.getAll().keySet());
/* 320 */     allOptionIds.remove(question.second);
/* 321 */     mzm.gsp.util.CommonUtils.regionRandomByMutableArray(allOptionIds, cfg.optionNum, options);
/* 322 */     options.add(question.second);
/* 323 */     java.util.Collections.shuffle(options);
/*     */     
/* 325 */     xFactionMakeUpRecord.getOptionids().addAll(options);
/*     */     
/* 327 */     long curTime = DateTimeUtils.getCurrTimeInMillis();
/* 328 */     xFactionMakeUpRecord.setStarttime(curTime);
/*     */     
/* 330 */     SStartMakeUpQuestion p = new SStartMakeUpQuestion();
/* 331 */     fillFactionMakeUpInfo(p.makeupinfo, xFactionMakeUpRecord, activityId);
/* 332 */     GangInterface.brocastInGang(p, factionId);
/*     */   }
/*     */   
/*     */   static void fillFactionMakeUpInfo(mzm.gsp.makeup.FactionMakeUpInfo p, FactionMakeUpRecord xFactionMakeUpRecord, int activityId)
/*     */   {
/* 337 */     p.activityid = activityId;
/* 338 */     p.curturn = xFactionMakeUpRecord.getCurturn();
/* 339 */     p.questionid = xFactionMakeUpRecord.getQuestionid();
/* 340 */     p.optionids.addAll(xFactionMakeUpRecord.getOptionids());
/* 341 */     p.starttime = (xFactionMakeUpRecord.getStarttime() / 1000L);
/*     */   }
/*     */   
/*     */   private static Pair<Integer, Integer> getQuestion(int activityId, FactionMakeUpRecord xFactionMakeUpRecord)
/*     */   {
/* 346 */     int questionId = -1;
/* 347 */     STMakeUpQuestionCfg questionCfg = STMakeUpQuestionCfg.get(activityId);
/* 348 */     if (questionCfg == null)
/*     */     {
/* 350 */       return null;
/*     */     }
/* 352 */     List<Integer> allQuestionIds = new ArrayList(questionCfg.questionInfos.keySet());
/* 353 */     allQuestionIds.removeAll(xFactionMakeUpRecord.getHistoryquestions());
/* 354 */     if (allQuestionIds.size() == 0)
/*     */     {
/*     */ 
/* 357 */       questionId = ((Integer)questionCfg.questionInfos.keySet().iterator().next()).intValue();
/*     */     }
/*     */     else
/*     */     {
/* 361 */       questionId = ((Integer)allQuestionIds.get(xdb.Xdb.random().nextInt(allQuestionIds.size()))).intValue();
/*     */     }
/* 363 */     return new Pair(Integer.valueOf(questionId), questionCfg.questionInfos.get(Integer.valueOf(questionId)));
/*     */   }
/*     */   
/*     */   private static void initFactionRecord(int noneRepeatTurn, FactionMakeUpRecord xFactionMakeUpRecord)
/*     */   {
/* 368 */     xFactionMakeUpRecord.setRightnum(0);
/* 369 */     xFactionMakeUpRecord.getJoinroleids().clear();
/* 370 */     xFactionMakeUpRecord.getOptionids().clear();
/*     */     
/* 372 */     if (xFactionMakeUpRecord.getHistoryquestions().size() >= noneRepeatTurn)
/*     */     {
/* 374 */       xFactionMakeUpRecord.getHistoryquestions().remove(0);
/*     */     }
/* 376 */     xFactionMakeUpRecord.getHistoryquestions().add(Integer.valueOf(xFactionMakeUpRecord.getQuestionid()));
/* 377 */     xFactionMakeUpRecord.setQuestionid(0);
/*     */   }
/*     */   
/*     */ 
/*     */   private static void doTurnAward(long factionId, int activityId, SMakeUpActivityCfg cfg, FactionMakeUpRecord xFactionMakeUpRecord)
/*     */   {
/* 383 */     int rightNum = xFactionMakeUpRecord.getJoinroleids().size();
/* 384 */     GangInterface.brocastInGang(new mzm.gsp.makeup.SMakeUpTurnOver(activityId, xFactionMakeUpRecord.getCurturn(), xFactionMakeUpRecord.getRightnum()), factionId);
/*     */     
/*     */ 
/* 387 */     if (rightNum == 0)
/*     */     {
/*     */ 
/* 390 */       return;
/*     */     }
/* 392 */     boolean isSpecial = xFactionMakeUpRecord.getRightnum() >= cfg.specialAwardNeedNum;
/* 393 */     for (Iterator i$ = xFactionMakeUpRecord.getJoinroleids().iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/* 395 */       new DoTurn2Role(roleId, activityId, isSpecial ? cfg.specialAwardId : cfg.normalAwardId, isSpecial).execute();
/*     */     }
/*     */   }
/*     */   
/*     */   static class DoTurn2Role
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final long roleId;
/*     */     private final int activityId;
/*     */     private final int awardId;
/*     */     private final boolean isSpecial;
/*     */     
/*     */     public DoTurn2Role(long roleId, int activityId, int awardId, boolean isSpecial)
/*     */     {
/* 409 */       this.roleId = roleId;
/* 410 */       this.awardId = awardId;
/* 411 */       this.activityId = activityId;
/* 412 */       this.isSpecial = isSpecial;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 418 */       String userId = RoleInterface.getUserId(this.roleId);
/* 419 */       lock(User.getTable(), Arrays.asList(new String[] { userId }));
/* 420 */       lock(xtable.Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/*     */       
/* 422 */       mzm.gsp.award.main.AwardModel awardModel = mzm.gsp.award.main.AwardInterface.award(this.awardId, userId, this.roleId, false, true, getAwardReason(this.activityId, this.isSpecial));
/*     */       
/* 424 */       if (awardModel == null)
/*     */       {
/* 426 */         MakeUpManager.loggerError("PrepareSession.asynDoTurnAwardToRole@ award err!|roleId=%d|awardId=%d|activityId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.awardId), Integer.valueOf(this.activityId) });
/*     */         
/*     */ 
/* 429 */         return false;
/*     */       }
/* 431 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     private AwardReason getAwardReason(int activityId, boolean isSpecial)
/*     */     {
/*     */       AwardReason reason;
/*     */       
/*     */ 
/*     */       AwardReason reason;
/*     */       
/*     */ 
/* 444 */       if (isSpecial)
/*     */       {
/* 446 */         reason = new AwardReason(LogReason.MAKE_UP_TURN_SPECIAL_AWARD, activityId);
/*     */       }
/*     */       else
/*     */       {
/* 450 */         reason = new AwardReason(LogReason.MAKE_UP_TURN_SPECIAL_AWARD, activityId);
/*     */       }
/* 452 */       return reason;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   static void synAllMakeupInfo(long roleId)
/*     */   {
/* 459 */     for (Iterator i$ = SMakeUpActivityCfg.getAll().keySet().iterator(); i$.hasNext();) { int activityId = ((Integer)i$.next()).intValue();
/*     */       
/* 461 */       new LogicProcedure()
/*     */       {
/*     */ 
/*     */         protected boolean processImp()
/*     */           throws Exception
/*     */         {
/* 467 */           return MakeUpManager.handleEachActivity(this.val$roleId, this.val$activityId);
/*     */         }
/*     */       }.execute();
/*     */     }
/*     */   }
/*     */   
/*     */   private static boolean handleEachActivity(long roleId, int activityId)
/*     */   {
/* 475 */     if (!ActivityInterface.isActivityOpen(activityId))
/*     */     {
/* 477 */       return false;
/*     */     }
/* 479 */     String userId = RoleInterface.getUserId(roleId);
/*     */     
/* 481 */     Lockeys.lock(User.getTable(), Arrays.asList(new String[] { userId }));
/*     */     
/* 483 */     MakeUpRecord xMakeUpRecord = getXMakeUpRecordIfAbsent(roleId, activityId);
/* 484 */     SSynMakeupInfo p = new SSynMakeupInfo();
/*     */     
/* 486 */     fillPFactionMakeUpInfo(p.factionmakeupinfo, GangInterface.getGangId(roleId), activityId);
/* 487 */     p.rolemakeupinfo.record.putAll(xMakeUpRecord.getTurn2optionid());
/* 488 */     OnlineManager.getInstance().send(roleId, p);
/* 489 */     return true;
/*     */   }
/*     */   
/*     */   private static void fillPFactionMakeUpInfo(mzm.gsp.makeup.FactionMakeUpInfo pInfo, long factionId, int activityId)
/*     */   {
/* 494 */     pInfo.activityid = activityId;
/* 495 */     if (factionId < 0L)
/*     */     {
/* 497 */       return;
/*     */     }
/*     */     
/* 500 */     FactionMakeUpRecord xFactionMakeUpRecord = getFactionActivityInfo(factionId, activityId);
/* 501 */     if (xFactionMakeUpRecord == null)
/*     */     {
/* 503 */       return;
/*     */     }
/*     */     
/* 506 */     GlobalMakeUpInfo xGlobalMakeupInfo = getGlobalMakeupInfo(activityId);
/* 507 */     if (xGlobalMakeupInfo == null)
/*     */     {
/* 509 */       return;
/*     */     }
/* 511 */     if (!xGlobalMakeupInfo.getQuetioning())
/*     */     {
/* 513 */       return;
/*     */     }
/* 515 */     if (xFactionMakeUpRecord.getCurturn() == xGlobalMakeupInfo.getTurn())
/*     */     {
/* 517 */       fillFactionMakeUpInfo(pInfo, xFactionMakeUpRecord, activityId);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void loggerError(String format, Object... args)
/*     */   {
/* 526 */     GameServer.logger().error("[makeup]" + String.format(format, args));
/*     */   }
/*     */   
/*     */   static void loggerInfo(String format, Object... args)
/*     */   {
/* 531 */     GameServer.logger().info("[makeup]" + String.format(format, args));
/*     */   }
/*     */   
/*     */   static void loggerDebug(String format, Object... args)
/*     */   {
/* 536 */     if (!GameServer.logger().isDebugEnabled())
/*     */     {
/* 538 */       return;
/*     */     }
/* 540 */     GameServer.logger().debug("[makeup]" + String.format(format, args));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\makeup\main\MakeUpManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */