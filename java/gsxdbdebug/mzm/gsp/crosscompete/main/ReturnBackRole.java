/*    */ package mzm.gsp.crosscompete.main;
/*    */ 
/*    */ class ReturnBackRole
/*    */ {
/*    */   public final long roleid;
/*  6 */   private volatile boolean bLogin = false;
/*  7 */   private volatile boolean bTeamRestore = false;
/*    */   
/*    */   ReturnBackRole(long roleid) {
/* 10 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   boolean isLogin() {
/* 14 */     return this.bLogin;
/*    */   }
/*    */   
/*    */   boolean setLogin() {
/* 18 */     if (this.bLogin == true) {
/* 19 */       return false;
/*    */     }
/* 21 */     this.bLogin = true;
/* 22 */     return true;
/*    */   }
/*    */   
/*    */   boolean isTeamRestore() {
/* 26 */     return this.bTeamRestore;
/*    */   }
/*    */   
/*    */   void setTeamRestore() {
/* 30 */     this.bTeamRestore = true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\main\ReturnBackRole.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */