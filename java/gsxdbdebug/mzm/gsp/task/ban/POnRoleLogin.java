/*    */ package mzm.gsp.task.ban;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class POnRoleLogin extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public POnRoleLogin(long roleId)
/*    */   {
/* 11 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 17 */     if (this.roleId <= 0L)
/*    */     {
/* 19 */       return false;
/*    */     }
/* 21 */     GraphBanManager.synAllBanGraphsToRole(this.roleId);
/* 22 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\ban\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */