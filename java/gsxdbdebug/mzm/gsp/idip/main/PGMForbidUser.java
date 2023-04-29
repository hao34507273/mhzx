/*    */ package mzm.gsp.idip.main;
/*    */ 
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ 
/*    */ public class PGMForbidUser extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private long uid;
/*    */   private int forbidTime;
/*    */   private String reason;
/*    */   
/*    */   public PGMForbidUser(long uid, int forbidTime, String reason)
/*    */   {
/* 13 */     this.uid = uid;
/* 14 */     this.forbidTime = forbidTime;
/* 15 */     this.reason = reason;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception {
/* 19 */     if (this.forbidTime <= 0) {
/* 20 */       return false;
/*    */     }
/* 22 */     String var1 = RoleInterface.getUserId(this.uid);
/* 23 */     if (var1 == null) {
/* 24 */       return false;
/*    */     }
/* 26 */     mzm.gsp.online.main.ForbidInfoManager.forbidUser(var1, this.forbidTime * 86400, this.reason);
/* 27 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PGMForbidUser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */