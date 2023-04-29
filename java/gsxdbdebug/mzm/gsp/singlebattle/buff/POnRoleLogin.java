/*    */ package mzm.gsp.singlebattle.buff;
/*    */ 
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import mzm.gsp.singlebattle.main.SingleBattleInterface;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnRoleLogin
/*    */   extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 15 */     long roleid = ((Long)this.arg).longValue();
/*    */     
/* 17 */     long battleid = SingleBattleInterface.getBattleId(roleid, true);
/* 18 */     if (battleid < 0L)
/*    */     {
/* 20 */       return false;
/*    */     }
/* 22 */     BuffManager.refreshRoleBuffInfo(roleid, true);
/* 23 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\buff\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */