/*    */ package mzm.gsp.fight.main;
/*    */ 
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract interface ObserveFightChecker
/*    */ {
/*    */   public abstract CheckResult observeFightCheck(long paramLong1, long paramLong2, long paramLong3, long paramLong4);
/*    */   
/*    */   public static class CheckResult
/*    */   {
/*    */     public final int result;
/*    */     private List<String> args;
/*    */     
/*    */     public CheckResult(int result)
/*    */     {
/* 29 */       this.result = result;
/*    */     }
/*    */     
/*    */     public CheckResult(int result, List<String> args) {
/* 33 */       this.result = result;
/* 34 */       this.args = args;
/*    */     }
/*    */     
/*    */     List<String> getArgs() {
/* 38 */       return this.args;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\ObserveFightChecker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */