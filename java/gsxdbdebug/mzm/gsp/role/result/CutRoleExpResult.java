/*    */ package mzm.gsp.role.result;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CutRoleExpResult
/*    */ {
/*    */   private boolean cutSuc;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   private Reason reason;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean isCutSuc()
/*    */   {
/* 23 */     return this.cutSuc;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean isParameterWrong()
/*    */   {
/* 33 */     return this.reason == Reason.PARAMETER_ILLEGAL;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean isOverflow()
/*    */   {
/* 43 */     return this.reason == Reason.PARAMETER_OVERFLOW;
/*    */   }
/*    */   
/*    */   public int getReasonValue()
/*    */   {
/* 48 */     return this.reason.ordinal();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setReason(Reason reason)
/*    */   {
/* 58 */     this.reason = reason;
/*    */   }
/*    */   
/*    */   public Reason getReason()
/*    */   {
/* 63 */     return this.reason;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setCutSuc(boolean cutSuc)
/*    */   {
/* 73 */     this.cutSuc = cutSuc;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static enum Reason
/*    */   {
/* 84 */     PARAMETER_ILLEGAL, 
/* 85 */     PARAMETER_OVERFLOW;
/*    */     
/*    */     private Reason() {}
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\result\CutRoleExpResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */