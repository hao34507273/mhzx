/*    */ package gnet;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SetServerAttr
/*    */   extends __SetServerAttr__
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
/* 30 */     return 204;
/*    */   }
/*    */   
/*    */   public SetServerAttr() {
/* 34 */     super.setArgument(new SetServerAttrArg());
/* 35 */     super.setResult(new SetServerAttrRes());
/*    */   }
/*    */   
/*    */   public SetServerAttr(SetServerAttrArg argument) {
/* 39 */     super.setArgument(argument);
/* 40 */     super.setResult(new SetServerAttrRes());
/*    */   }
/*    */   
/*    */   public int getTimeout() {
/* 44 */     return 20000;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\gnet\SetServerAttr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */