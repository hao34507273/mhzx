/*    */ package mzm.gsp.questionvoice.main.choosepolicy;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */  enum SingletonArgs
/*    */ {
/* 12 */   DEFAULT(new IChoosePolicyArgs());
/*    */   
/*    */ 
/*    */   private final IChoosePolicyArgs args;
/*    */   
/*    */ 
/*    */   private SingletonArgs(IChoosePolicyArgs args)
/*    */   {
/* 20 */     this.args = args;
/*    */   }
/*    */   
/*    */   public IChoosePolicyArgs getArgs()
/*    */   {
/* 25 */     return this.args;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\questionvoice\main\choosepolicy\SingletonArgs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */