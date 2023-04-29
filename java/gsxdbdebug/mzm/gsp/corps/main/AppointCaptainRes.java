/*    */ package mzm.gsp.corps.main;
/*    */ 
/*    */ public class AppointCaptainRes {
/*    */   private AppointCaptianErrReason errReason;
/*    */   private boolean suc;
/*    */   
/*  7 */   public AppointCaptainRes() { this.suc = true; }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static enum AppointCaptianErrReason
/*    */   {
/* 17 */     CorpsNotExist, 
/* 18 */     StateForbidAppoint, 
/* 19 */     StateForbidBeCaptain, 
/* 20 */     AlreadyCaptain, 
/* 21 */     NotOpen, 
/* 22 */     NotInCorps, 
/* 23 */     Other;
/*    */     
/*    */ 
/*    */ 
/*    */     private AppointCaptianErrReason() {}
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public AppointCaptianErrReason getErrReason()
/*    */   {
/* 34 */     return this.errReason;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean isSuc()
/*    */   {
/* 44 */     return this.suc;
/*    */   }
/*    */   
/*    */   void setSuc(boolean suc)
/*    */   {
/* 49 */     this.suc = suc;
/*    */   }
/*    */   
/*    */   void setErrReason(AppointCaptianErrReason errReason)
/*    */   {
/* 54 */     setSuc(false);
/* 55 */     this.errReason = errReason;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\main\AppointCaptainRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */