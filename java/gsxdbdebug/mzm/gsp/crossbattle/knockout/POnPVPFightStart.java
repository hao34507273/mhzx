/*    */ package mzm.gsp.crossbattle.knockout;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.crossserver.main.CrossServerInterface;
/*    */ import mzm.gsp.crossserver.main.RoamedKnockOutContext;
/*    */ import mzm.gsp.crossserver.main.RoamedKnockOutTeamInfo;
/*    */ import mzm.gsp.fight.event.PVPFightStartArg;
/*    */ import mzm.gsp.fight.event.PVPFightStartProcedure;
/*    */ 
/*    */ public class POnPVPFightStart extends PVPFightStartProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 14 */     if (!(((PVPFightStartArg)this.arg).context instanceof KnockOutFightContext))
/*    */     {
/* 16 */       return false;
/*    */     }
/*    */     
/* 19 */     KnockOutFightContext selectionFightContext = (KnockOutFightContext)((PVPFightStartArg)this.arg).context;
/*    */     
/* 21 */     RoamedKnockOutContext roamedContext = selectionFightContext.roamedCrossBattleContext;
/*    */     
/* 23 */     RoamedKnockOutTeamInfo ownTeamInfo = roamedContext.crossBattleTeamInfo;
/*    */     
/* 25 */     CrossServerInterface.notifySelectionFightBeign(ownTeamInfo.getCorpsId(), ownTeamInfo.getPhysZoneId(), roamedContext.fightType, roamedContext.fightStage, roamedContext.fightIndexId, ((PVPFightStartArg)this.arg).recordid);
/*    */     
/*    */ 
/* 28 */     RoamedKnockOutTeamInfo opponentTeamInfo = roamedContext.opponentCrossBattleTeamInfo;
/* 29 */     CrossServerInterface.notifySelectionFightBeign(opponentTeamInfo.getCorpsId(), opponentTeamInfo.getPhysZoneId(), roamedContext.fightType, roamedContext.fightStage, roamedContext.fightIndexId, ((PVPFightStartArg)this.arg).recordid);
/*    */     
/*    */ 
/* 32 */     StringBuilder sBuilder = new StringBuilder();
/* 33 */     sBuilder.append("[crossbattle_knockout]POnPVPFightStart.processImp@knock out fight start");
/* 34 */     sBuilder.append("|active_roles=").append(((PVPFightStartArg)this.arg).activeRoles);
/* 35 */     sBuilder.append("|passive_roles=").append(((PVPFightStartArg)this.arg).passiveRoles);
/* 36 */     sBuilder.append("|roam_context=").append(roamedContext);
/*    */     
/* 38 */     GameServer.logger().info(sBuilder.toString());
/* 39 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\knockout\POnPVPFightStart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */