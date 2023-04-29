/*    */ package mzm.gsp.grc.main;
/*    */ 
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.online.event.PlayerOfflineProcedure;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ 
/*    */ public class POnRoleLogoff extends PlayerOfflineProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     if (GameServerInfoManager.isRoamServer())
/*    */     {
/* 13 */       return false;
/*    */     }
/*    */     
/* 16 */     long roleid = ((Long)this.arg).longValue();
/* 17 */     String userid = RoleInterface.getUserId(roleid);
/* 18 */     if (userid == null)
/*    */     {
/* 20 */       return false;
/*    */     }
/*    */     
/* 23 */     GrcManager.uninstallPrivilegeBuff(userid, roleid);
/*    */     
/* 25 */     GrcManager.removeQQVipInfos(userid);
/*    */     
/* 27 */     GrcManager.clearQQVipLostObserver(userid);
/*    */     
/* 29 */     new POnRoleLogoffForReportRoles(userid).execute();
/*    */     
/* 31 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\main\POnRoleLogoff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */