/*    */ package mzm.gsp.breakegg.randomreward;
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
/* 12 */   DEFAULT(new IRandomPolicyArgs());
/*    */   
/*    */ 
/*    */   private final IRandomPolicyArgs args;
/*    */   
/*    */ 
/*    */   private SingletonArgs(IRandomPolicyArgs args)
/*    */   {
/* 20 */     this.args = args;
/*    */   }
/*    */   
/*    */   public IRandomPolicyArgs getArgs()
/*    */   {
/* 25 */     return this.args;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\breakegg\randomreward\SingletonArgs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */