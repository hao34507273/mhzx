/*    */ package mzm.gsp.crossbattle.knockout;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.crossserver.event.SelectionOrFinalAllRoamedRoleReadyArg;
/*    */ import mzm.gsp.crossserver.event.SelectionOrFinalAllRoamedRoleReadyProcedure;
/*    */ import mzm.gsp.crossserver.main.RoamedKnockOutContext;
/*    */ import mzm.gsp.crossserver.main.RoamedKnockOutRoleInfo;
/*    */ import mzm.gsp.crossserver.main.RoamedKnockOutTeamInfo;
/*    */ import mzm.gsp.fight.main.FightInterface;
/*    */ import mzm.gsp.fight.main.FightReason;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ public class POnAllRoamedRoleReady
/*    */   extends SelectionOrFinalAllRoamedRoleReadyProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 22 */     RoamedKnockOutContext roamedCrossBattleContext = ((SelectionOrFinalAllRoamedRoleReadyArg)this.arg).roamedCrossBattleContext;
/*    */     
/* 24 */     KnockOutFightContext selectionFightContext = new KnockOutFightContext(roamedCrossBattleContext);
/* 25 */     List<Long> activeRoles = new ArrayList();
/* 26 */     List<Long> passiveRoles = new ArrayList();
/* 27 */     for (RoamedKnockOutRoleInfo roamedRoleCrossBattleInfo : roamedCrossBattleContext.crossBattleTeamInfo.getCrossBattleRoleInfoList())
/*    */     {
/* 29 */       activeRoles.add(Long.valueOf(roamedRoleCrossBattleInfo.getRoleid()));
/*    */     }
/*    */     
/* 32 */     for (RoamedKnockOutRoleInfo roamedRoleCrossBattleInfo : roamedCrossBattleContext.opponentCrossBattleTeamInfo.getCrossBattleRoleInfoList())
/*    */     {
/* 34 */       passiveRoles.add(Long.valueOf(roamedRoleCrossBattleInfo.getRoleid()));
/*    */     }
/*    */     
/* 37 */     FightReason fightReason = roamedCrossBattleContext.fightType == 1 ? FightReason.CROSS_BATTLE_SELECTION : FightReason.CROSS_BATTLE_FINAL;
/*    */     
/*    */ 
/* 40 */     int fightType = roamedCrossBattleContext.fightType == 1 ? 21 : 22;
/*    */     
/*    */ 
/* 43 */     FightInterface.startPVPFightWithTeamDisposition(activeRoles, passiveRoles, selectionFightContext, fightType, fightReason);
/*    */     
/*    */ 
/* 46 */     List<Long> allRoleList = new ArrayList();
/* 47 */     allRoleList.addAll(activeRoles);
/* 48 */     allRoleList.addAll(passiveRoles);
/*    */     
/*    */ 
/*    */ 
/* 52 */     CrossBattleMatchRomaContextManager.getInstance().putKeys(allRoleList, roamedCrossBattleContext);
/*    */     
/* 54 */     GameServer.logger().info(String.format("[crossbattle_selection]POnAllRoamedRoleReady.processImp@all roles|activeRoleids=%s|passiveRoleids=%s", new Object[] { activeRoles, passiveRoles }));
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 59 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\knockout\POnAllRoamedRoleReady.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */