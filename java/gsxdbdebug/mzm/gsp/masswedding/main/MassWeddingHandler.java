/*     */ package mzm.gsp.masswedding.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.main.ActivityHandler.ActivityStartType;
/*     */ import mzm.gsp.activity.main.ActivityStage;
/*     */ import mzm.gsp.activity.main.ActivityStage.TimeBaseLine;
/*     */ import mzm.gsp.activity.main.ActivityStage.TimeLogic;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.marriage.main.MarriageInterface;
/*     */ import mzm.gsp.masswedding.SSynMassWeddingBeginning;
/*     */ import mzm.gsp.masswedding.SSynMassWeddingCloseEarlier;
/*     */ import mzm.gsp.masswedding.SSynMassWeddingStageChange;
/*     */ import mzm.gsp.masswedding.confbean.SMassWeddingConsts;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.team.main.JoinTeamResult;
/*     */ import mzm.gsp.team.main.JoinTeamResult.Receiver;
/*     */ import mzm.gsp.team.main.JoinTeamResult.Result;
/*     */ import mzm.gsp.team.main.JoinTeamType;
/*     */ import mzm.gsp.team.main.ReturnTeamResult;
/*     */ import mzm.gsp.team.main.TeamInfo;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.MassWedding;
/*     */ import xbean.MassWeddingRankInfo;
/*     */ import xbean.MassWeddingRankInfos;
/*     */ import xbean.MassWeddingRobRoles;
/*     */ import xdb.Executor;
/*     */ import xtable.User;
/*     */ 
/*     */ public class MassWeddingHandler implements mzm.gsp.activity.main.ActivityHandler
/*     */ {
/*     */   public List<ActivityStage> getActivityStages()
/*     */   {
/*  48 */     List<ActivityStage> activityStages = new java.util.ArrayList();
/*  49 */     ActivityStage activityStage0 = new ActivityStage(SMassWeddingConsts.getInstance().prepareMinute, ActivityStage.TimeBaseLine.BEGIN, ActivityStage.TimeLogic.FIX);
/*     */     
/*  51 */     ActivityStage activityStage1 = new ActivityStage(SMassWeddingConsts.getInstance().marryMinute, ActivityStage.TimeBaseLine.BEFORE, ActivityStage.TimeLogic.FIX);
/*     */     
/*  53 */     ActivityStage activityStage2 = new ActivityStage(SMassWeddingConsts.getInstance().robMarriageMinute, ActivityStage.TimeBaseLine.BEFORE, ActivityStage.TimeLogic.FIX);
/*     */     
/*  55 */     activityStages.add(activityStage0);
/*  56 */     activityStages.add(activityStage1);
/*  57 */     activityStages.add(activityStage2);
/*  58 */     return activityStages;
/*     */   }
/*     */   
/*     */   public AwardReason getRecommendAwardReason()
/*     */   {
/*  63 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void initData(String userid, long roleId, int turn, int activityid) {}
/*     */   
/*     */ 
/*     */   public void onActivityEnd(int activityid)
/*     */   {
/*  73 */     GameServer.logger().info(String.format("[MassWedding]MassWeddingHandler.onActivityEnd@MassWedding is end!", new Object[0]));
/*  74 */     MassWedding xMassWedding = MassWeddingManager.getMassWedding(true);
/*  75 */     if (xMassWedding == null) {
/*  76 */       GameServer.logger().info(String.format("[MassWedding]MassWeddingHandler.onActivityEnd@end error,MassWedding is null", new Object[0]));
/*     */       
/*  78 */       return;
/*     */     }
/*     */     
/*  81 */     long worldid = xMassWedding.getWorldid();
/*  82 */     List<Long> allRoles = MapInterface.getRoleList(worldid);
/*  83 */     for (Iterator i$ = allRoles.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*  84 */       NoneRealTimeTaskManager.getInstance().addTask(new RoleOnActivityEndPro(roleid));
/*     */     }
/*  86 */     TeamInterface.unRegisterJoinTeam(worldid);
/*  87 */     MapInterface.destroyWorld(worldid);
/*     */   }
/*     */   
/*     */   private static class RoleOnActivityEndPro extends LogicProcedure
/*     */   {
/*     */     private final long roleid;
/*     */     
/*     */     public RoleOnActivityEndPro(long roleid) {
/*  95 */       this.roleid = roleid;
/*     */     }
/*     */     
/*     */     protected boolean processImp() throws Exception
/*     */     {
/* 100 */       RoleStatusInterface.unsetStatus(this.roleid, 36);
/* 101 */       RoleStatusInterface.unsetStatus(this.roleid, 39);
/* 102 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void onActivityStageStart(int stage, boolean startAgain, int activityid)
/*     */   {
/* 109 */     GameServer.logger().info(String.format("[MassWedding]MassWeddingHandler.onActivityStageStart|start stage|stage=%d", new Object[] { Integer.valueOf(stage) }));
/*     */     
/* 111 */     MassWedding xMassWedding = MassWeddingManager.getMassWedding(true);
/* 112 */     if (xMassWedding == null) {
/* 113 */       GameServer.logger().info(String.format("[MassWedding]MassWeddingHandler.onActivityStageStart@stage start error,MassWedding is null", new Object[0]));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 118 */       return;
/*     */     }
/* 120 */     xMassWedding.setStage(stage);
/* 121 */     switch (stage) {
/*     */     case 1: 
/* 123 */       MassWeddingRankInfos xMassWeddingRankInfos = MassWeddingManager.getMassWeddingRankInfos(true);
/* 124 */       if (!startAgain) {
/* 125 */         if ((xMassWeddingRankInfos == null) || (xMassWeddingRankInfos.getMassweddingrankinfos().size() < SMassWeddingConsts.getInstance().minCouple))
/*     */         {
/* 127 */           if (xMassWeddingRankInfos != null) {
/* 128 */             int coupleSize = xMassWeddingRankInfos.getMassweddingrankinfos().size();
/* 129 */             for (int i = 0; i < coupleSize; i++) {
/* 130 */               MassWeddingRankInfo xMassWeddingRankInfo = (MassWeddingRankInfo)xMassWeddingRankInfos.getMassweddingrankinfos().get(i);
/*     */               
/* 132 */               tlogSignUp(xMassWeddingRankInfo, i + 1, 2);
/*     */             }
/*     */           }
/* 135 */           xMassWedding.setEndearlier(1);
/*     */           
/* 137 */           returnSignUpMoney(0, xMassWeddingRankInfos, SMassWeddingConsts.getInstance().coupleNotEnoughMailid, new TLogArg(LogReason.MASSWEDDING_SIGN_UP_COUPLE_NOT_ENOUGH_RETURN));
/*     */           
/*     */ 
/* 140 */           SSynMassWeddingCloseEarlier synMassWeddingCloseEarlier = new SSynMassWeddingCloseEarlier();
/* 141 */           long worldid = xMassWedding.getWorldid();
/* 142 */           List<Long> allRoles = MapInterface.getRoleList(worldid);
/* 143 */           for (Iterator i$ = allRoles.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 144 */             NoneRealTimeTaskManager.getInstance().addTask(new RoleOnActivityEndPro(roleid));
/*     */           }
/* 146 */           MapInterface.brocadCastInWorld(worldid, synMassWeddingCloseEarlier, true);
/* 147 */           MapInterface.destroyWorld(worldid);
/*     */         }
/*     */         else {
/* 150 */           int coupleSize = xMassWeddingRankInfos.getMassweddingrankinfos().size();
/* 151 */           int moveCoupeIndex = SMassWeddingConsts.getInstance().maxCouple;
/* 152 */           int extra = 0;
/* 153 */           for (int i = 0; i < moveCoupeIndex; i++) {
/* 154 */             if (i >= coupleSize) {
/*     */               break;
/*     */             }
/* 157 */             MassWeddingRankInfo xMassWeddingRankInfo = (MassWeddingRankInfo)xMassWeddingRankInfos.getMassweddingrankinfos().get(i);
/*     */             
/* 159 */             long roleidA = xMassWeddingRankInfo.getRoleida();
/* 160 */             long roleidB = xMassWeddingRankInfo.getRoleidb();
/* 161 */             int rank = i + 1;
/* 162 */             if ((OnlineManager.getInstance().isOfflineAfterProtect(roleidA)) || (OnlineManager.getInstance().isOfflineAfterProtect(roleidB)))
/*     */             {
/*     */ 
/* 165 */               NoneRealTimeTaskManager.getInstance().addTask(new CheckAndReturnMoneyProcedure(xMassWeddingRankInfo.toData(), SMassWeddingConsts.getInstance().leaveMailId, true));
/*     */               
/*     */ 
/* 168 */               moveCoupeIndex++;
/* 169 */               extra++;
/* 170 */               tlogSignUp(xMassWeddingRankInfo, rank, 1);
/*     */             }
/*     */             else {
/* 173 */               sendMassWeddingBegining(roleidA);
/* 174 */               sendMassWeddingBegining(roleidB);
/* 175 */               Executor.getInstance().execute(new MassWeddingBeginRunnable(roleidA, roleidB, i - extra));
/* 176 */               tlogSignUp(xMassWeddingRankInfo, rank, 0);
/*     */             } }
/* 178 */           for (int i = moveCoupeIndex; i < coupleSize; i++) {
/* 179 */             MassWeddingRankInfo xMassWeddingRankInfo = (MassWeddingRankInfo)xMassWeddingRankInfos.getMassweddingrankinfos().get(i);
/*     */             
/* 181 */             int rank = i + 1;
/* 182 */             tlogSignUp(xMassWeddingRankInfo, rank, 3);
/*     */           }
/*     */           
/* 185 */           returnSignUpMoney(moveCoupeIndex, xMassWeddingRankInfos, SMassWeddingConsts.getInstance().notInTopNMailid, new TLogArg(LogReason.MASSWEDDING_SIGN_UP_END_FAIL_RETURN));
/*     */         }
/*     */         
/*     */ 
/*     */       }
/*     */       else {
/* 191 */         returnSignUpMoney(0, xMassWeddingRankInfos, SMassWeddingConsts.getInstance().serverReasonMailid, new TLogArg(LogReason.MASSWEDDING_SIGN_UP_SERVER_REASON_RETURN));
/*     */       }
/*     */       
/*     */ 
/* 195 */       break;
/*     */     case 2: 
/* 197 */       MassWeddingRankInfos xTempMassWeddingRankInfos = MassWeddingManager.getMassWeddingRankInfos(true);
/* 198 */       if (xTempMassWeddingRankInfos != null)
/*     */       {
/* 200 */         int coupleSize = xTempMassWeddingRankInfos.getMassweddingrankinfos().size();
/* 201 */         for (int i = 0; i < SMassWeddingConsts.getInstance().maxCouple; i++) {
/* 202 */           if (i >= coupleSize) {
/*     */             break;
/*     */           }
/* 205 */           MassWeddingRankInfo xMassWeddingRankInfo = (MassWeddingRankInfo)xTempMassWeddingRankInfos.getMassweddingrankinfos().get(i);
/*     */           
/* 207 */           final long roleidA = xMassWeddingRankInfo.getRoleida();
/* 208 */           final long roleidB = xMassWeddingRankInfo.getRoleidb();
/* 209 */           NoneRealTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*     */           {
/*     */             protected boolean processImp() throws Exception
/*     */             {
/* 213 */               RoleStatusInterface.unsetStatus(roleidA, 36);
/* 214 */               return true;
/*     */             }
/* 216 */           });
/* 217 */           NoneRealTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*     */           {
/*     */             protected boolean processImp() throws Exception
/*     */             {
/* 221 */               RoleStatusInterface.unsetStatus(roleidB, 36);
/* 222 */               return true;
/*     */             }
/* 224 */           });
/* 225 */           MapInterface.removeMapGroup(mzm.gsp.map.main.group.MapGroupType.MGT_GROUP_WEDDING, xMassWeddingRankInfo.getRoleida(), Arrays.asList(new Long[] { Long.valueOf(xMassWeddingRankInfo.getRoleida()), Long.valueOf(xMassWeddingRankInfo.getRoleidb()) }));
/*     */         }
/*     */         
/* 228 */         returnSignUpMoney(0, xTempMassWeddingRankInfos, SMassWeddingConsts.getInstance().serverReasonMailid, new TLogArg(LogReason.MASSWEDDING_SIGN_UP_SERVER_REASON_RETURN));
/*     */       }
/* 230 */       break;
/*     */     
/*     */ 
/*     */ 
/*     */     case 3: 
/* 235 */       MassWeddingRankInfos xRobRelateMassWeddingRankInfos = MassWeddingManager.getMassWeddingRankInfos(true);
/*     */       
/* 237 */       xbean.MassWeddingRob xMassWeddingRob = MassWeddingManager.getMassWeddingRob(true);
/* 238 */       if ((xRobRelateMassWeddingRankInfos != null) && (xMassWeddingRob != null)) {
/* 239 */         int coupleSize = xRobRelateMassWeddingRankInfos.getMassweddingrankinfos().size();
/* 240 */         for (int i = 0; i < SMassWeddingConsts.getInstance().maxCouple; i++) {
/* 241 */           if (i >= coupleSize) {
/*     */             break;
/*     */           }
/* 244 */           MassWeddingRankInfo xMassWeddingRankInfo = (MassWeddingRankInfo)xRobRelateMassWeddingRankInfos.getMassweddingrankinfos().get(i);
/*     */           
/* 246 */           final long roleidA = xMassWeddingRankInfo.getRoleida();
/* 247 */           final long roleidB = xMassWeddingRankInfo.getRoleidb();
/* 248 */           MassWeddingRobRoles xMassWeddingRobRoles = (MassWeddingRobRoles)xMassWeddingRob.getRobmap().get(Long.valueOf(xMassWeddingRankInfo.getRoleida()));
/*     */           
/* 250 */           if (xMassWeddingRobRoles != null)
/*     */           {
/*     */ 
/* 253 */             tlogMassWeddingRobResult(roleidA, roleidB, xMassWeddingRobRoles);
/* 254 */             if (!MassWeddingManager.isRobEnd(xMassWeddingRobRoles))
/*     */             {
/*     */ 
/* 257 */               int groomSize = xMassWeddingRobRoles.getGrooms().size();
/* 258 */               int brideSize = xMassWeddingRobRoles.getBrides().size();
/* 259 */               if ((groomSize != 0) || (brideSize != 0))
/*     */               {
/*     */ 
/* 262 */                 if (groomSize > brideSize) {
/* 263 */                   MassWeddingManager.asynSendRobWinAward(xMassWeddingRobRoles.getGrooms());
/* 264 */                   MassWeddingManager.asynSendRobFailAward(xMassWeddingRobRoles.getBrides());
/*     */                   
/* 266 */                   NoneRealTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*     */                   {
/*     */                     protected boolean processImp() throws Exception {
/* 269 */                       String userid = RoleInterface.getUserId(roleidA);
/* 270 */                       lock(User.getTable(), Arrays.asList(new String[] { userid }));
/* 271 */                       AwardInterface.award(SMassWeddingConsts.getInstance().coupleAwardid, userid, roleidA, false, true, new AwardReason(LogReason.MASSWEDDING_ROB_COUPE_AWARD));
/*     */                       
/* 273 */                       return true;
/*     */                     }
/* 275 */                   });
/* 276 */                   NoneRealTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*     */                   {
/*     */                     protected boolean processImp() throws Exception {
/* 279 */                       String userid = RoleInterface.getUserId(roleidB);
/* 280 */                       lock(User.getTable(), Arrays.asList(new String[] { userid }));
/* 281 */                       AwardInterface.award(SMassWeddingConsts.getInstance().coupleAwardid, userid, roleidB, false, true, new AwardReason(LogReason.MASSWEDDING_ROB_COUPE_AWARD));
/*     */                       
/* 283 */                       return true;
/*     */                     }
/*     */                   });
/*     */                 }
/* 287 */                 else if (groomSize == brideSize) {
/* 288 */                   MassWeddingManager.asynSendRobWinAward(xMassWeddingRobRoles.getGrooms());
/* 289 */                   MassWeddingManager.asynSendRobWinAward(xMassWeddingRobRoles.getBrides());
/*     */                   
/* 291 */                   NoneRealTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*     */                   {
/*     */                     protected boolean processImp() throws Exception {
/* 294 */                       String userid = RoleInterface.getUserId(roleidA);
/* 295 */                       lock(User.getTable(), Arrays.asList(new String[] { userid }));
/* 296 */                       AwardInterface.award(SMassWeddingConsts.getInstance().coupleAwardid, userid, roleidA, false, true, new AwardReason(LogReason.MASSWEDDING_ROB_COUPE_AWARD));
/*     */                       
/* 298 */                       return true;
/*     */                     }
/* 300 */                   });
/* 301 */                   NoneRealTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*     */                   {
/*     */                     protected boolean processImp() throws Exception {
/* 304 */                       String userid = RoleInterface.getUserId(roleidB);
/* 305 */                       lock(User.getTable(), Arrays.asList(new String[] { userid }));
/* 306 */                       AwardInterface.award(SMassWeddingConsts.getInstance().coupleAwardid, userid, roleidB, false, true, new AwardReason(LogReason.MASSWEDDING_ROB_COUPE_AWARD));
/*     */                       
/* 308 */                       return true;
/*     */                     }
/*     */                   });
/*     */                 } else {
/* 312 */                   MassWeddingManager.asynSendRobWinAward(xMassWeddingRobRoles.getBrides());
/* 313 */                   MassWeddingManager.asynSendRobFailAward(xMassWeddingRobRoles.getGrooms());
/*     */                 } }
/*     */             }
/*     */           }
/*     */         } }
/* 318 */       List<Long> roleids = MapInterface.getRoleList(xMassWedding.getWorldid());
/* 319 */       MassWeddingManager.asynTriggerAddFriend(roleids);
/* 320 */       break;
/*     */     }
/*     */     
/*     */     
/*     */ 
/*     */ 
/* 326 */     SSynMassWeddingStageChange synMassWeddingStageChange = new SSynMassWeddingStageChange();
/* 327 */     synMassWeddingStageChange.stage = stage;
/* 328 */     MapInterface.brocadCastInWorld(xMassWedding.getWorldid(), synMassWeddingStageChange, true);
/*     */   }
/*     */   
/*     */   private void tlogMassWeddingRobResult(long roleidA, long roleidB, MassWeddingRobRoles xMassWeddingRobRoles) {
/* 332 */     NoneRealTimeTaskManager.getInstance().addTask(new TLogMassWeddingRobResult(roleidA, roleidB, xMassWeddingRobRoles));
/*     */   }
/*     */   
/*     */   private class TLogMassWeddingRobResult extends LogicProcedure
/*     */   {
/*     */     private final long roleidA;
/*     */     private final long roleidB;
/*     */     private final int supportGroomNum;
/*     */     private final int supportBrideNum;
/*     */     
/*     */     public TLogMassWeddingRobResult(long roleidA, long roleidB, MassWeddingRobRoles xMassWeddingRobRoles)
/*     */     {
/* 344 */       this.roleidA = roleidA;
/* 345 */       this.roleidB = roleidB;
/* 346 */       this.supportGroomNum = xMassWeddingRobRoles.getGrooms().size();
/* 347 */       this.supportBrideNum = xMassWeddingRobRoles.getBrides().size();
/*     */     }
/*     */     
/*     */     protected boolean processImp() throws Exception
/*     */     {
/* 352 */       MassWeddingManager.tlogMassWeddingRobResult(RoleInterface.getUserId(this.roleidA), this.roleidA, RoleInterface.getUserId(this.roleidB), this.roleidB, this.supportGroomNum, this.supportBrideNum);
/*     */       
/* 354 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   private static void tlogSignUp(MassWeddingRankInfo xMassWeddingRankInfo, int rank, int state)
/*     */   {
/* 360 */     long roleidA = xMassWeddingRankInfo.getRoleida();
/* 361 */     long roleidB = xMassWeddingRankInfo.getRoleidb();
/* 362 */     int totalMoney = xMassWeddingRankInfo.getRoleaoffer() + xMassWeddingRankInfo.getRoleidboffer();
/*     */     
/* 364 */     NoneRealTimeTaskManager.getInstance().addTask(new MassWeddingManager.TLogMassWeddingSignUp(roleidA, rank, xMassWeddingRankInfo.getRoleaoffer(), totalMoney, state));
/*     */     
/*     */ 
/*     */ 
/* 368 */     NoneRealTimeTaskManager.getInstance().addTask(new MassWeddingManager.TLogMassWeddingSignUp(roleidB, rank, xMassWeddingRankInfo.getRoleidboffer(), totalMoney, state));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 373 */     TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.masswedding.event.MassWeddingPriceRank(), new mzm.gsp.masswedding.event.MassWeddingPriceRankArg(roleidA, roleidB, rank));
/*     */   }
/*     */   
/*     */   private void sendMassWeddingBegining(long roleid) {
/* 377 */     SSynMassWeddingBeginning synMassWeddingBeginning = new SSynMassWeddingBeginning();
/* 378 */     OnlineManager.getInstance().send(roleid, synMassWeddingBeginning);
/*     */   }
/*     */   
/*     */   private void returnSignUpMoney(int from, MassWeddingRankInfos xMassWeddingRankInfos, int mailCfgid, TLogArg tlogArg) {
/* 382 */     if (xMassWeddingRankInfos == null) {
/* 383 */       return;
/*     */     }
/* 385 */     int size = xMassWeddingRankInfos.getMassweddingrankinfos().size();
/* 386 */     if (from >= size) {
/* 387 */       return;
/*     */     }
/* 389 */     for (int i = from; i < size; i++) {
/* 390 */       MassWeddingRankInfo xMassWeddingRankInfo = (MassWeddingRankInfo)xMassWeddingRankInfos.getMassweddingrankinfos().get(i);
/* 391 */       NoneRealTimeTaskManager.getInstance().addTask(new CheckAndReturnMoneyProcedure(xMassWeddingRankInfo.toData(), mailCfgid, tlogArg));
/*     */     }
/*     */   }
/*     */   
/*     */   public static final class CheckAndReturnMoneyProcedure
/*     */     extends LogicProcedure
/*     */   {
/*     */     private MassWeddingRankInfo xMassWeddingRankInfo;
/*     */     private int mailCfgid;
/* 400 */     private boolean mustDel = false;
/*     */     private TLogArg tLogArg;
/*     */     
/*     */     public CheckAndReturnMoneyProcedure(MassWeddingRankInfo xMassWeddingRankInfo, int mailCfgid, TLogArg tLogArg)
/*     */     {
/* 405 */       this.xMassWeddingRankInfo = xMassWeddingRankInfo;
/* 406 */       this.mailCfgid = mailCfgid;
/* 407 */       this.tLogArg = tLogArg;
/*     */     }
/*     */     
/*     */     public CheckAndReturnMoneyProcedure(MassWeddingRankInfo xMassWeddingRankInfo, int mailCfgid, boolean mustDel)
/*     */     {
/* 412 */       this.xMassWeddingRankInfo = xMassWeddingRankInfo;
/* 413 */       this.mailCfgid = mailCfgid;
/* 414 */       this.mustDel = mustDel;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 420 */       long roleA = this.xMassWeddingRankInfo.getRoleida();
/* 421 */       long roleB = this.xMassWeddingRankInfo.getRoleidb();
/* 422 */       lock(xtable.Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(roleA), Long.valueOf(roleB) }));
/* 423 */       MassWeddingRankInfos xMassWeddingRankInfos = MassWeddingManager.getMassWeddingRankInfos(true);
/* 424 */       if (xMassWeddingRankInfos.getNotbackcoinsroleids().contains(Long.valueOf(roleA))) {
/* 425 */         GameServer.logger().info(String.format("[MassWedding]ReturnMoneyProcedure.processImp@already return back gold|roleida=%d|roleidb=%d", new Object[] { Long.valueOf(roleA), Long.valueOf(roleB) }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 432 */         return false;
/*     */       }
/* 434 */       Integer index = (Integer)xMassWeddingRankInfos.getRoleid2index().get(Long.valueOf(roleA));
/* 435 */       if (index == null) {
/* 436 */         GameServer.logger().info(String.format("[MassWedding]ReturnMoneyProcedure.processImp@already return back gold|roleida=%d|roleidb=%d", new Object[] { Long.valueOf(roleA), Long.valueOf(roleB) }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 443 */         return false;
/*     */       }
/*     */       
/* 446 */       xMassWeddingRankInfos.getNotbackcoinsroleids().add(Long.valueOf(roleA));
/* 447 */       xMassWeddingRankInfos.getNotbackcoinsroleids().add(Long.valueOf(roleB));
/*     */       
/* 449 */       int roleAOffer = this.xMassWeddingRankInfo.getRoleaoffer();
/* 450 */       int roleBOffer = this.xMassWeddingRankInfo.getRoleidboffer();
/* 451 */       if (roleAOffer > 0) {
/* 452 */         MassWeddingManager.sendMail(roleA, roleAOffer, this.mailCfgid, this.tLogArg);
/*     */       }
/* 454 */       if (roleBOffer > 0) {
/* 455 */         MassWeddingManager.sendMail(roleB, roleBOffer, this.mailCfgid, this.tLogArg);
/*     */       }
/* 457 */       GameServer.logger().info(String.format("[MassWedding]ReturnMoneyProcedure.processImp@return back gold|roleida=%d|roleidb=%d", new Object[] { Long.valueOf(roleA), Long.valueOf(roleB) }));
/*     */       
/*     */ 
/*     */ 
/* 461 */       if ((index.intValue() >= SMassWeddingConsts.getInstance().maxCouple) || (this.mustDel)) {
/* 462 */         MassWeddingSignUpChartManager.getInstance().delete(Long.valueOf(roleA));
/* 463 */         MassWeddingManager.saveRankInfos(xMassWeddingRankInfos);
/*     */       }
/*     */       
/* 466 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void onActivityStart(ActivityHandler.ActivityStartType activityStartType, int activityid)
/*     */   {
/* 473 */     GameServer.logger().info(String.format("[MassWedding]MassWeddingHandler.onActivityStart@activity start!!", new Object[0]));
/* 474 */     MassWedding xMassWedding = MassWeddingManager.getMassWedding(true);
/* 475 */     long localid = mzm.gsp.GameServerInfoManager.getLocalId();
/* 476 */     if (xMassWedding == null) {
/* 477 */       xMassWedding = xbean.Pod.newMassWedding();
/* 478 */       xtable.Masswedding.insert(Long.valueOf(localid), xMassWedding);
/*     */     }
/* 480 */     if (activityStartType == ActivityHandler.ActivityStartType.START_AGAIN) {
/* 481 */       if (xMassWedding.getEndearlier() != 1) {}
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 486 */       MassWeddingSignUpChartManager.getInstance().clear();
/* 487 */       xtable.Massweddingrank.remove(Long.valueOf(localid));
/* 488 */       xtable.Massweddingbless.remove(Long.valueOf(localid));
/* 489 */       xtable.Massweddingrob.remove(Long.valueOf(localid));
/* 490 */       xtable.Massweddingrobsubscribe.remove(Long.valueOf(localid));
/*     */     }
/* 492 */     xMassWedding.setStage(0);
/* 493 */     long worldid = MapInterface.createWorld(Arrays.asList(new Integer[] { Integer.valueOf(SMassWeddingConsts.getInstance().mapid) }));
/* 494 */     xMassWedding.setWorldid(worldid);
/* 495 */     xMassWedding.setEndearlier(0);
/*     */     
/*     */ 
/* 498 */     new AwardObserver();
/*     */     
/*     */ 
/* 501 */     new RedGiftObserver();
/*     */     
/*     */ 
/* 504 */     new MapRedGiftObserver();
/*     */     
/* 506 */     TeamInterface.registerJoinTeam(worldid, new mzm.gsp.team.main.JoinTeamCheckHandler()
/*     */     {
/*     */       public ReturnTeamResult canReturnTeam(TeamInfo teamInfo, long roleId, long leaderWorldId, long roleWorldId)
/*     */       {
/* 510 */         ReturnTeamResult returnTeamResult = new ReturnTeamResult();
/*     */         
/* 512 */         if (leaderWorldId == roleWorldId) {
/* 513 */           returnTeamResult.setSucceed(true);
/* 514 */           return returnTeamResult;
/*     */         }
/* 516 */         returnTeamResult.setSucceed(false);
/* 517 */         returnTeamResult.setResult(new mzm.gsp.team.main.ReturnTeamResult.Result(3030, new String[0]));
/*     */         
/* 519 */         return returnTeamResult;
/*     */       }
/*     */       
/*     */ 
/*     */       public JoinTeamResult canJoinTeam(TeamInfo teamInfo, long roleId, long leaderWorldId, long roleWorldId, boolean tf2LeaderAftJoin, JoinTeamType joinTeamType)
/*     */       {
/* 525 */         JoinTeamResult joinTeamResult = new JoinTeamResult();
/* 526 */         long leaderRoleid = teamInfo.getLeaderId();
/* 527 */         long leaderMarryRoleid = MarriageInterface.getMarriedRoleid(leaderRoleid);
/* 528 */         long memberMarryRoleid = MarriageInterface.getMarriedRoleid(roleId);
/* 529 */         MassWeddingRankInfos xMassWeddingRankInfos = MassWeddingManager.getMassWeddingRankInfos(true);
/* 530 */         if (xMassWeddingRankInfos != null)
/*     */         {
/* 532 */           Integer leaderIndex = (Integer)xMassWeddingRankInfos.getRoleid2index().get(Long.valueOf(leaderRoleid));
/* 533 */           if (leaderIndex == null) {
/* 534 */             leaderIndex = (Integer)xMassWeddingRankInfos.getRoleid2index().get(Long.valueOf(leaderMarryRoleid));
/*     */           }
/* 536 */           if (leaderIndex != null) {
/* 537 */             MassWeddingRankInfo xMassWeddingRankInfo = (MassWeddingRankInfo)xMassWeddingRankInfos.getMassweddingrankinfos().get(leaderIndex.intValue());
/*     */             
/* 539 */             if ((xMassWeddingRankInfo.getRoleida() != roleId) && (xMassWeddingRankInfo.getRoleidb() != roleId)) {
/* 540 */               joinTeamResult.setSucceed(false);
/* 541 */               if (joinTeamType == JoinTeamType.JOIN_TEAM__APPLY) {
/* 542 */                 JoinTeamResult.Result result = new JoinTeamResult.Result(163, new String[0]);
/*     */                 
/* 544 */                 joinTeamResult.addResult(JoinTeamResult.Receiver.Leader, result);
/* 545 */               } else if (joinTeamType == JoinTeamType.JOIN_TEAM__INVITE) {
/* 546 */                 JoinTeamResult.Result result = new JoinTeamResult.Result(164, new String[0]);
/*     */                 
/* 548 */                 joinTeamResult.addResult(JoinTeamResult.Receiver.Member, result);
/*     */               }
/* 550 */               return joinTeamResult;
/*     */             }
/*     */           }
/*     */           
/* 554 */           Integer memberIndex = (Integer)xMassWeddingRankInfos.getRoleid2index().get(Long.valueOf(roleId));
/* 555 */           if (memberIndex == null) {
/* 556 */             memberIndex = (Integer)xMassWeddingRankInfos.getRoleid2index().get(Long.valueOf(memberMarryRoleid));
/*     */           }
/* 558 */           if (memberIndex != null) {
/* 559 */             MassWeddingRankInfo xMassWeddingRankInfo = (MassWeddingRankInfo)xMassWeddingRankInfos.getMassweddingrankinfos().get(memberIndex.intValue());
/*     */             
/* 561 */             if ((xMassWeddingRankInfo.getRoleida() != leaderRoleid) && (xMassWeddingRankInfo.getRoleidb() != leaderRoleid))
/*     */             {
/* 563 */               joinTeamResult.setSucceed(false);
/* 564 */               if (joinTeamType == JoinTeamType.JOIN_TEAM__APPLY) {
/* 565 */                 JoinTeamResult.Result result = new JoinTeamResult.Result(165, new String[0]);
/*     */                 
/* 567 */                 joinTeamResult.addResult(JoinTeamResult.Receiver.Leader, result);
/* 568 */               } else if (joinTeamType == JoinTeamType.JOIN_TEAM__INVITE) {
/* 569 */                 JoinTeamResult.Result result = new JoinTeamResult.Result(166, new String[0]);
/*     */                 
/* 571 */                 joinTeamResult.addResult(JoinTeamResult.Receiver.Member, result);
/*     */               }
/* 573 */               return joinTeamResult;
/*     */             }
/*     */           }
/*     */         }
/* 577 */         if (leaderWorldId == roleWorldId) {
/* 578 */           joinTeamResult.setSucceed(true);
/* 579 */           return joinTeamResult;
/*     */         }
/* 581 */         joinTeamResult.setSucceed(false);
/* 582 */         if (joinTeamType == JoinTeamType.JOIN_TEAM__APPLY) {
/* 583 */           JoinTeamResult.Result result = new JoinTeamResult.Result(161, new String[0]);
/*     */           
/* 585 */           joinTeamResult.addResult(JoinTeamResult.Receiver.Leader, result);
/* 586 */         } else if (joinTeamType == JoinTeamType.JOIN_TEAM__INVITE) {
/* 587 */           JoinTeamResult.Result result = new JoinTeamResult.Result(162, new String[0]);
/*     */           
/* 589 */           joinTeamResult.addResult(JoinTeamResult.Receiver.Member, result);
/*     */         }
/* 591 */         return joinTeamResult;
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\masswedding\main\MassWeddingHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */