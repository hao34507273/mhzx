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
/*    */ public class GrcGetUserReceiveGiftInfoList
/*    */   extends __GrcGetUserReceiveGiftInfoList__
/*    */ {
/*    */   protected void onServer() {}
/*    */   
/*    */   protected void onClient()
/*    */   {
/* 22 */     GrcInterface.onGetReceiveGiftListResponse((GrcGetUserReceiveGiftInfoListArg)getArgument(), (GrcGetUserReceiveGiftInfoListRes)getResult());
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeout(int code)
/*    */   {
/* 28 */     GrcInterface.onGetReceiveGiftListTimeout((GrcGetUserReceiveGiftInfoListArg)getArgument(), (GrcGetUserReceiveGiftInfoListRes)getResult());
/*    */   }
/*    */   
/*    */ 
/*    */   public int getType()
/*    */   {
/* 34 */     return 10004;
/*    */   }
/*    */   
/*    */   public GrcGetUserReceiveGiftInfoList() {
/* 38 */     super.setArgument(new GrcGetUserReceiveGiftInfoListArg());
/* 39 */     super.setResult(new GrcGetUserReceiveGiftInfoListRes());
/*    */   }
/*    */   
/*    */   public GrcGetUserReceiveGiftInfoList(GrcGetUserReceiveGiftInfoListArg argument) {
/* 43 */     super.setArgument(argument);
/* 44 */     super.setResult(new GrcGetUserReceiveGiftInfoListRes());
/*    */   }
/*    */   
/*    */   public int getTimeout() {
/* 48 */     return 30000;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\grc\GrcGetUserReceiveGiftInfoList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */