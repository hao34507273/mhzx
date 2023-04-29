/*    */ package mzm.gsp.grc.main;
/*    */ 
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class POnRoleLogoffForReportRoles extends LogicProcedure
/*    */ {
/*    */   private final String userid;
/*    */   
/*    */   public POnRoleLogoffForReportRoles(String userid)
/*    */   {
/* 12 */     this.userid = userid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 18 */     if (GameServerInfoManager.isRoamServer())
/*    */     {
/* 20 */       return false;
/*    */     }
/*    */     
/* 23 */     return GrcManager.reportRoles(this.userid);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\main\POnRoleLogoffForReportRoles.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */