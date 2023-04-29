/*    */ package mzm.gsp.singlebattle.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import xbean.RoleSingleBattle;
/*    */ 
/*    */ public class PCLeaveBattle extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PCLeaveBattle(long roleId)
/*    */   {
/* 12 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 19 */     RoleSingleBattle xRoleBattle = xtable.Role2singlebattle.get(Long.valueOf(this.roleId));
/* 20 */     if (xRoleBattle == null)
/*    */     {
/* 22 */       GameServer.logger().error(String.format("[singlebattle]PCTryFight.processImp@ no RoleSingleBattle! |roleId=%d", new Object[] { Long.valueOf(this.roleId) }));
/*    */       
/* 24 */       return false;
/*    */     }
/* 26 */     BattleTaskOneByOne.getInstance().addLogicRunnable(Long.valueOf(xRoleBattle.getBattleid()), new RCTryLeaveBattle(this.roleId, xRoleBattle.getBattleid(), xRoleBattle.getBattlecfgid()));
/*    */     
/* 28 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\main\PCLeaveBattle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */