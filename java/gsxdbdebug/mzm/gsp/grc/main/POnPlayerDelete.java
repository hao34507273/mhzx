/*    */ package mzm.gsp.grc.main;
/*    */ 
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.online.event.PlayerDeleteProcedure;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ 
/*    */ public class POnPlayerDelete extends PlayerDeleteProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     if (GameServerInfoManager.isRoamServer())
/*    */     {
/* 13 */       return false;
/*    */     }
/*    */     
/* 16 */     String userid = RoleInterface.getUserId(((Long)this.arg).longValue());
/* 17 */     if (userid != null)
/*    */     {
/* 19 */       GrcManager.resetTopRole(userid);
/*    */     }
/*    */     
/* 22 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\main\POnPlayerDelete.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */