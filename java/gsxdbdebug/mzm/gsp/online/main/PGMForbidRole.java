/*    */ package mzm.gsp.online.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGMForbidRole extends LogicProcedure {
/*    */   private long uid;
/*    */   private int forbidTime;
/*    */   private String reason;
/*    */   
/*    */   public PGMForbidRole(long uid, int forbidTime, String reason) {
/* 11 */     this.uid = uid;
/* 12 */     this.forbidTime = forbidTime;
/* 13 */     this.reason = reason;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception {
/* 17 */     if (this.forbidTime <= 0) {
/* 18 */       return false;
/*    */     }
/* 20 */     ForbidInfoManager.forbidRole(this.uid, this.forbidTime * 86400, this.reason);
/* 21 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\online\main\PGMForbidRole.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */