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
/*    */ public class GrcGetFriendsList
/*    */   extends __GrcGetFriendsList__
/*    */ {
/*    */   protected void onServer() {}
/*    */   
/*    */   protected void onClient()
/*    */   {
/* 22 */     GrcInterface.onGetFriendListResponse((GrcGetFriendsListArg)getArgument(), (GrcGetFriendsListRes)getResult());
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeout(int code)
/*    */   {
/* 28 */     GrcInterface.onGetFriendListTimeout((GrcGetFriendsListArg)getArgument(), (GrcGetFriendsListRes)getResult());
/*    */   }
/*    */   
/*    */ 
/*    */   public int getType()
/*    */   {
/* 34 */     return 10009;
/*    */   }
/*    */   
/*    */   public GrcGetFriendsList() {
/* 38 */     super.setArgument(new GrcGetFriendsListArg());
/* 39 */     super.setResult(new GrcGetFriendsListRes());
/*    */   }
/*    */   
/*    */   public GrcGetFriendsList(GrcGetFriendsListArg argument) {
/* 43 */     super.setArgument(argument);
/* 44 */     super.setResult(new GrcGetFriendsListRes());
/*    */   }
/*    */   
/*    */   public int getTimeout() {
/* 48 */     return 30000;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\grc\GrcGetFriendsList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */