/*     */ package mzm.gsp.crossserver.main;
/*     */ 
/*     */ import mzm.gsp.crossbattle.knockout.KnockOutRoamRoleDataFailArg;
/*     */ import mzm.gsp.crossbattle.knockout.KnockOutRoamRoleDataSuccessArg;
/*     */ import mzm.gsp.crossbattle.point.PointRaceInfo;
/*     */ import mzm.gsp.crosscompete.main.EnterContext;
/*     */ import mzm.gsp.crossserver.event.CrossCompeteRoamRoleDataFailArg;
/*     */ import mzm.gsp.crossserver.event.CrossCompeteRoamRoleDataSucceedArg;
/*     */ import mzm.gsp.crossserver.event.LadderRoamRoleDataFailArg;
/*     */ import mzm.gsp.crossserver.event.PointRaceRoamRoleDataFailArg;
/*     */ import mzm.gsp.crossserver.event.PointRaceRoamRoleDataSucceedArg;
/*     */ import mzm.gsp.crossserver.event.RoamRoleDataFailArg;
/*     */ import mzm.gsp.crossserver.event.RoamRoleDataSucceedArg;
/*     */ import mzm.gsp.crossserver.event.SingleCrossFieldRoamRoleDataFailArg;
/*     */ import mzm.gsp.crossserver.event.SingleCrossFieldRoamRoleDataSucceedArg;
/*     */ 
/*     */ public class RoamRoleDataEventCreator
/*     */ {
/*     */   public static final RoamRoleDataFailArg createRoamRoleDataFailArg(RoamContext roamContext)
/*     */   {
/*  21 */     switch (roamContext.getRoamType())
/*     */     {
/*     */ 
/*     */     case LADDER: 
/*  25 */       MatchContext context = (MatchContext)roamContext;
/*  26 */       return new LadderRoamRoleDataFailArg(context.getRoamType(), context.contextid, context.leaderid, context.roleMatchMarkingInfos, context.activityContext, context.getCreateTime());
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     case CROSS_COMPETE: 
/*  32 */       EnterContext context = (EnterContext)roamContext;
/*  33 */       return new CrossCompeteRoamRoleDataFailArg(context);
/*     */     
/*     */ 
/*     */     case CROSS_BATTLE_POINT: 
/*  37 */       PointRaceContext context = (PointRaceContext)roamContext;
/*  38 */       return new PointRaceRoamRoleDataFailArg(context.getRoamType(), context.contextid, context.corpsid, context.leaderid, context.rolePointRaceMarkingInfos, context.pointRaceInfo.getActivityCfgid());
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     case CROSS_BATTLE_SELECTION_FINAL: 
/*  44 */       KnockOutContext context = (KnockOutContext)roamContext;
/*  45 */       return new KnockOutRoamRoleDataFailArg(context.getRoamType(), context.gameServerContextId, context.leaderRoleId, context.crossBattleTeamInfo, context.selectionFinalProcessContext, context.fightIndexId, context.createTime);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     case SINGLE_CROSS_FIELD: 
/*  52 */       SingleCrossFieldContext context = (SingleCrossFieldContext)roamContext;
/*  53 */       return new SingleCrossFieldRoamRoleDataFailArg(context.getRoamType(), context);
/*     */     }
/*     */     
/*  56 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */   public static final RoamRoleDataSucceedArg createRoamRoleDataSucceedArg(RoamContext roamContext)
/*     */   {
/*  62 */     switch (roamContext.getRoamType())
/*     */     {
/*     */ 
/*     */     case LADDER: 
/*  66 */       MatchContext context = (MatchContext)roamContext;
/*  67 */       return new mzm.gsp.crossserver.event.LadderRoamRoleDataSucceedArg(context.getRoamType(), context.contextid, context.leaderid, context.roleMatchMarkingInfos, context.getOpponentLeaderid(), context.getOpponentRoleMatchMarkingInfos(), context.activityContext, context.getRoamZoneid(), context.getRoamRoomInstanceid(), context.getCreateTime());
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     case CROSS_COMPETE: 
/*  75 */       EnterContext context = (EnterContext)roamContext;
/*  76 */       return new CrossCompeteRoamRoleDataSucceedArg(context);
/*     */     
/*     */ 
/*     */     case CROSS_BATTLE_POINT: 
/*  80 */       PointRaceContext context = (PointRaceContext)roamContext;
/*  81 */       return new PointRaceRoamRoleDataSucceedArg(context.getRoamType(), context.contextid, context.corpsid, context.leaderid, context.rolePointRaceMarkingInfos, context.getRoamZoneid(), context.pointRaceInfo.getActivityCfgid());
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     case CROSS_BATTLE_SELECTION_FINAL: 
/*  88 */       KnockOutContext context = (KnockOutContext)roamContext;
/*  89 */       return new KnockOutRoamRoleDataSuccessArg(context.getRoamType(), context.gameServerContextId, context.leaderRoleId, context.crossBattleTeamInfo, context.selectionFinalProcessContext, context.fightIndexId, context.fightType, context.createTime, context.getRoamZoneid());
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     case SINGLE_CROSS_FIELD: 
/*  97 */       SingleCrossFieldContext context = (SingleCrossFieldContext)roamContext;
/*  98 */       return new SingleCrossFieldRoamRoleDataSucceedArg(context.getRoamType(), context);
/*     */     }
/*     */     
/* 101 */     return null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\RoamRoleDataEventCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */