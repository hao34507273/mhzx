/*    */ package mzm.gsp.grc.main;
/*    */ 
/*    */ import grc.DataBetweenGameAndGrcArg;
/*    */ import grc.DataBetweenGameAndGrcRes;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class POnGetInviteFriendsGiftTimesResp extends LogicProcedure
/*    */ {
/*    */   private final DataBetweenGameAndGrcArg arg;
/*    */   private final DataBetweenGameAndGrcRes res;
/*    */   
/*    */   public POnGetInviteFriendsGiftTimesResp(DataBetweenGameAndGrcArg arg, DataBetweenGameAndGrcRes res)
/*    */   {
/* 14 */     this.arg = arg;
/* 15 */     this.res = res;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 21 */     return InviteFriendsManager.onGetInviteFriendsGiftTimesResp(this.arg, this.res);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\main\POnGetInviteFriendsGiftTimesResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */