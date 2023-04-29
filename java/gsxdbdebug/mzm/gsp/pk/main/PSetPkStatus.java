/*    */ package mzm.gsp.pk.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PSetPkStatus extends LogicProcedure {
/*    */   final long roleId;
/*    */   final boolean isEnable;
/*    */   
/*    */   public PSetPkStatus(long roleId, boolean isEnable) {
/* 10 */     this.roleId = roleId;
/* 11 */     this.isEnable = isEnable;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 16 */     if (this.isEnable) {
/* 17 */       PKStatusManager.setPKEnabled(this.roleId);
/*    */     } else {
/* 19 */       PKStatusManager.unsetPKEnabled(this.roleId);
/*    */     }
/* 21 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pk\main\PSetPkStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */