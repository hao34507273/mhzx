/*    */ package grc;
/*    */ 
/*    */ import mzm.gsp.grc.main.GrcInterface;
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
/*    */ public class DataBetweenGameAndGrc
/*    */   extends __DataBetweenGameAndGrc__
/*    */ {
/*    */   protected void onServer() {}
/*    */   
/*    */   protected void onClient()
/*    */   {
/* 22 */     GrcInterface.onDataBetweenGameAndGrcResponse((DataBetweenGameAndGrcArg)getArgument(), (DataBetweenGameAndGrcRes)getResult());
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeout(int code)
/*    */   {
/* 28 */     GrcInterface.onDataBetweenGameAndGrcTimeout((DataBetweenGameAndGrcArg)getArgument(), (DataBetweenGameAndGrcRes)getResult());
/*    */   }
/*    */   
/*    */ 
/*    */   public int getType()
/*    */   {
/* 34 */     return 10010;
/*    */   }
/*    */   
/*    */   public DataBetweenGameAndGrc() {
/* 38 */     super.setArgument(new DataBetweenGameAndGrcArg());
/* 39 */     super.setResult(new DataBetweenGameAndGrcRes());
/*    */   }
/*    */   
/*    */   public DataBetweenGameAndGrc(DataBetweenGameAndGrcArg argument) {
/* 43 */     super.setArgument(argument);
/* 44 */     super.setResult(new DataBetweenGameAndGrcRes());
/*    */   }
/*    */   
/*    */   public int getTimeout() {
/* 48 */     return 30000;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\grc\DataBetweenGameAndGrc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */