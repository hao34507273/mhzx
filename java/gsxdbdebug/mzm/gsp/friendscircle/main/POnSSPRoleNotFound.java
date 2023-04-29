/*    */ package mzm.gsp.friendscircle.main;
/*    */ 
/*    */ import mzm.gsp.csprovider.ssp.SSPContext;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class POnSSPRoleNotFound
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final long passiveRoleId;
/*    */   
/*    */   public POnSSPRoleNotFound(long roleId, long passiveRoleId)
/*    */   {
/* 14 */     this.roleId = roleId;
/* 15 */     this.passiveRoleId = passiveRoleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 21 */     FriendsCircleManager.reportRoleInfo(this.roleId, new RoleNotFoundReportRoleContext(this.passiveRoleId));
/* 22 */     return true;
/*    */   }
/*    */   
/*    */   public class RoleNotFoundReportRoleContext extends SSPRepeatTimesContext implements SSPContext
/*    */   {
/*    */     public final long passiveRoleId;
/*    */     
/*    */     public RoleNotFoundReportRoleContext(long passiveRoleId)
/*    */     {
/* 31 */       this.passiveRoleId = passiveRoleId;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friendscircle\main\POnSSPRoleNotFound.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */