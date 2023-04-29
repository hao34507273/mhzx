/*    */ package csprovider;
/*    */ 
/*    */ import mzm.gsp.csprovider.main.POnUseActivateCardAck;
/*    */ import mzm.gsp.csprovider.main.POnUseActivateCardTimeout;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ActiveCardUse
/*    */   extends __ActiveCardUse__
/*    */ {
/*    */   protected void onServer() {}
/*    */   
/*    */   protected void onClient()
/*    */   {
/* 19 */     new POnUseActivateCardAck((ActiveCardUseArg)getArgument(), (ActiveCardUseRes)getResult()).execute();
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeout(int code)
/*    */   {
/* 25 */     new POnUseActivateCardTimeout((ActiveCardUseArg)getArgument()).execute();
/*    */   }
/*    */   
/*    */ 
/*    */   public int getType()
/*    */   {
/* 31 */     return 10013;
/*    */   }
/*    */   
/*    */   public ActiveCardUse() {
/* 35 */     super.setArgument(new ActiveCardUseArg());
/* 36 */     super.setResult(new ActiveCardUseRes());
/*    */   }
/*    */   
/*    */   public ActiveCardUse(ActiveCardUseArg argument) {
/* 40 */     super.setArgument(argument);
/* 41 */     super.setResult(new ActiveCardUseRes());
/*    */   }
/*    */   
/*    */   public int getTimeout() {
/* 45 */     return 20000;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\csprovider\ActiveCardUse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */