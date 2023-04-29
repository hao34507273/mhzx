/*    */ package mzm.gsp.grc.main;
/*    */ 
/*    */ import grc.GrcGetFriendsListArg;
/*    */ import grc.GrcGetFriendsListRes;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class POnGetFriendListReponse extends LogicProcedure
/*    */ {
/*    */   private final GrcGetFriendsListArg arg;
/*    */   private final GrcGetFriendsListRes res;
/*    */   
/*    */   public POnGetFriendListReponse(GrcGetFriendsListArg arg, GrcGetFriendsListRes res)
/*    */   {
/* 14 */     this.arg = arg;
/* 15 */     this.res = res;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 21 */     GrcManager.onGetFriendListResponse(this.arg, this.res);
/*    */     
/* 23 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\main\POnGetFriendListReponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */