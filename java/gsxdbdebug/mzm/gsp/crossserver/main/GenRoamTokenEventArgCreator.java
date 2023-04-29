/*     */ package mzm.gsp.crossserver.main;
/*     */ 
/*     */ import mzm.gsp.crossbattle.knockout.KnockOutGenRoamTokenFailArg;
/*     */ import mzm.gsp.crossbattle.point.PointRaceInfo;
/*     */ import mzm.gsp.crosscompete.main.EnterContext;
/*     */ import mzm.gsp.crossserver.event.CrossCompeteGenRoamTokenFailArg;
/*     */ import mzm.gsp.crossserver.event.CrossCompeteGenRoamTokenSucceedArg;
/*     */ import mzm.gsp.crossserver.event.GenRoamTokenFailArg;
/*     */ import mzm.gsp.crossserver.event.GenRoamTokenSucceedArg;
/*     */ import mzm.gsp.crossserver.event.LadderGenRoamTokenFailArg;
/*     */ import mzm.gsp.crossserver.event.LadderGenRoamTokenSucceedArg;
/*     */ import mzm.gsp.crossserver.event.PointRaceGenRoamTokenFailArg;
/*     */ import mzm.gsp.crossserver.event.PointRaceGenRoamTokenSucceedArg;
/*     */ import mzm.gsp.crossserver.event.SingleCrossFieldGenRoamTokenFailArg;
/*     */ import mzm.gsp.crossserver.event.SingleCrossFieldGenRoamTokenSucceedArg;
/*     */ 
/*     */ public class GenRoamTokenEventArgCreator
/*     */ {
/*     */   public static final GenRoamTokenFailArg createGenRoamTokenFailArg(RoamContext roamContext)
/*     */   {
/*  21 */     switch (roamContext.getRoamType())
/*     */     {
/*     */ 
/*     */     case LADDER: 
/*  25 */       MatchContext context = (MatchContext)roamContext;
/*     */       
/*  27 */       return new LadderGenRoamTokenFailArg(context.getRoamType(), context.contextid, context.leaderid, context.roleMatchMarkingInfos, context.activityContext, context.getCreateTime());
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     case CROSS_COMPETE: 
/*  33 */       EnterContext context = (EnterContext)roamContext;
/*     */       
/*  35 */       return new CrossCompeteGenRoamTokenFailArg(context);
/*     */     
/*     */ 
/*     */     case CROSS_BATTLE_POINT: 
/*  39 */       PointRaceContext context = (PointRaceContext)roamContext;
/*  40 */       return new PointRaceGenRoamTokenFailArg(context.getRoamType(), context.contextid, context.corpsid, context.leaderid, context.rolePointRaceMarkingInfos, context.pointRaceInfo.getActivityCfgid());
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     case CROSS_BATTLE_SELECTION_FINAL: 
/*  46 */       KnockOutContext context = (KnockOutContext)roamContext;
/*  47 */       return new KnockOutGenRoamTokenFailArg(context.getRoamType(), context.gameServerContextId, context.leaderRoleId, context.crossBattleTeamInfo, context.selectionFinalProcessContext, context.fightIndexId, context.getCreateTime());
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     case SINGLE_CROSS_FIELD: 
/*  54 */       SingleCrossFieldContext context = (SingleCrossFieldContext)roamContext;
/*  55 */       return new SingleCrossFieldGenRoamTokenFailArg(context.getRoamType(), context);
/*     */     }
/*     */     
/*  58 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */   public static final GenRoamTokenSucceedArg createGenRoamTokenSucceedArg(RoamContext roamContext)
/*     */   {
/*  64 */     switch (roamContext.getRoamType())
/*     */     {
/*     */ 
/*     */     case LADDER: 
/*  68 */       MatchContext context = (MatchContext)roamContext;
/*     */       
/*  70 */       return new LadderGenRoamTokenSucceedArg(context.getRoamType(), context.contextid, context.leaderid, context.roleMatchMarkingInfos, context.getOpponentLeaderid(), context.getOpponentRoleMatchMarkingInfos(), context.activityContext, context.getRoamZoneid(), context.getRoamRoomInstanceid(), context.getCreateTime());
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     case CROSS_COMPETE: 
/*  78 */       EnterContext context = (EnterContext)roamContext;
/*     */       
/*  80 */       return new CrossCompeteGenRoamTokenSucceedArg(context);
/*     */     
/*     */ 
/*     */     case CROSS_BATTLE_POINT: 
/*  84 */       PointRaceContext context = (PointRaceContext)roamContext;
/*  85 */       return new PointRaceGenRoamTokenSucceedArg(context.getRoamType(), context.contextid, context.corpsid, context.leaderid, context.rolePointRaceMarkingInfos, context.pointRaceInfo.getActivityCfgid());
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     case CROSS_BATTLE_SELECTION_FINAL: 
/*  91 */       KnockOutContext context = (KnockOutContext)roamContext;
/*  92 */       return new mzm.gsp.crossbattle.knockout.KnockOutGenTokenSuccessArg(context.getRoamType(), context.gameServerContextId, context.leaderRoleId, context.crossBattleTeamInfo, context.selectionFinalProcessContext, context.fightIndexId, context.fightType, context.getCreateTime());
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     case SINGLE_CROSS_FIELD: 
/*  99 */       SingleCrossFieldContext context = (SingleCrossFieldContext)roamContext;
/* 100 */       return new SingleCrossFieldGenRoamTokenSucceedArg(context.getRoamType(), context);
/*     */     }
/*     */     
/* 103 */     return null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\GenRoamTokenEventArgCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */