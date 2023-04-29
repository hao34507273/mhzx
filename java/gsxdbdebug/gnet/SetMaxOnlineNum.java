/*    */ package gnet;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SetMaxOnlineNum
/*    */   extends __SetMaxOnlineNum__
/*    */ {
/*    */   protected void onServer() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void onClient() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void onTimeout(int code) {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 30 */     return 205;
/*    */   }
/*    */   
/*    */   public SetMaxOnlineNum() {
/* 34 */     super.setArgument(new SetMaxOnlineNumArg());
/* 35 */     super.setResult(new SetMaxOnlineNumRes());
/*    */   }
/*    */   
/*    */   public SetMaxOnlineNum(SetMaxOnlineNumArg argument) {
/* 39 */     super.setArgument(argument);
/* 40 */     super.setResult(new SetMaxOnlineNumRes());
/*    */   }
/*    */   
/*    */   public int getTimeout() {
/* 44 */     return 20000;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\gnet\SetMaxOnlineNum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */