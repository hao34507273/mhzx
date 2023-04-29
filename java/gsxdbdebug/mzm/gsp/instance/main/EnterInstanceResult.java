/*    */ package mzm.gsp.instance.main;
/*    */ 
/*    */ 
/*    */ public class EnterInstanceResult
/*    */ {
/*    */   public final boolean canJoin;
/*    */   private Reason reason;
/*    */   private long roleid;
/*    */   
/*    */   public EnterInstanceResult(boolean canJoin)
/*    */   {
/* 12 */     this.canJoin = canJoin;
/*    */   }
/*    */   
/*    */   public Reason getReason() {
/* 16 */     return this.reason;
/*    */   }
/*    */   
/*    */   public void setReason(Reason reason) {
/* 20 */     this.reason = reason;
/*    */   }
/*    */   
/*    */   public boolean isRoleLevelWrong() {
/* 24 */     return this.reason == Reason.RoleLevel;
/*    */   }
/*    */   
/*    */   public boolean isPerSonCountWrong() {
/* 28 */     return this.reason == Reason.PersonCount;
/*    */   }
/*    */   
/*    */   public boolean isItemNotEnough() {
/* 32 */     return this.reason == Reason.ItemNotEnough;
/*    */   }
/*    */   
/*    */   public long getRoleid() {
/* 36 */     return this.roleid;
/*    */   }
/*    */   
/*    */   public void setRoleid(long roleid) {
/* 40 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static enum Reason
/*    */   {
/* 49 */     RoleLevel, 
/* 50 */     PersonCount, 
/* 51 */     UNKNOW, 
/* 52 */     ItemNotEnough;
/*    */     
/*    */     private Reason() {}
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\instance\main\EnterInstanceResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */