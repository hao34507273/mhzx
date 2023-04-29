/*    */ package mzm.gsp.mondayfree.main;
/*    */ 
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import xbean.MondayFree;
/*    */ 
/*    */ public class POnRoleLogin
/*    */   extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 12 */     long roleid = ((Long)this.arg).longValue();
/* 13 */     MondayFree xMondayFree = MondayFreeManager.createXMondayFreeIfNotExist(roleid);
/*    */     
/* 15 */     MondayFreeManager.syncMondayFree(roleid, xMondayFree);
/*    */     
/* 17 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mondayfree\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */