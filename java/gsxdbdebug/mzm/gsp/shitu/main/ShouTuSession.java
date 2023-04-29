/*    */ package mzm.gsp.shitu.main;
/*    */ 
/*    */ import mzm.gsp.timer.main.Session;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class ShouTuSession
/*    */   extends Session
/*    */ {
/*    */   private final long apprenticeRoleId;
/*    */   
/*    */   public ShouTuSession(long interval, long masterRoleId, long apprenticeRoleId)
/*    */   {
/* 15 */     super(interval, masterRoleId);
/* 16 */     this.apprenticeRoleId = apprenticeRoleId;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected void onTimeOut() {}
/*    */   
/*    */ 
/*    */   public long getApprenticeRoleId()
/*    */   {
/* 26 */     return this.apprenticeRoleId;
/*    */   }
/*    */   
/*    */   public long getRoleid()
/*    */   {
/* 31 */     return getOwerId();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\main\ShouTuSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */