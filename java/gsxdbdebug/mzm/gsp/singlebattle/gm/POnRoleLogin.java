/*    */ package mzm.gsp.singlebattle.gm;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import xbean.RoleSingleBattle;
/*    */ import xtable.Role2singlebattle;
/*    */ 
/*    */ public class POnRoleLogin extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 12 */     long roleId = ((Long)this.arg).longValue();
/*    */     
/* 14 */     RoleSingleBattle xRoleBattleData = Role2singlebattle.select(Long.valueOf(roleId));
/* 15 */     if (xRoleBattleData == null)
/*    */     {
/* 17 */       GameServer.logger().error(String.format("[singlebattle-gm]POnRoleLogin.processImp@ no RoleSingleBattle! |roleId=%d", new Object[] { Long.valueOf(roleId) }));
/*    */       
/* 19 */       return false;
/*    */     }
/* 21 */     mzm.gsp.singlebattle.main.SingleBattleInterface.joinBattle(xRoleBattleData.getBattleid(), roleId);
/* 22 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\gm\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */