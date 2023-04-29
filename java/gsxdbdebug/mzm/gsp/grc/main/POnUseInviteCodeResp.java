/*    */ package mzm.gsp.grc.main;
/*    */ 
/*    */ import grc.DataBetweenGameAndGrcArg;
/*    */ import grc.DataBetweenGameAndGrcRes;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ class POnUseInviteCodeResp extends LogicProcedure
/*    */ {
/*    */   private final DataBetweenGameAndGrcArg arg;
/*    */   private final DataBetweenGameAndGrcRes res;
/*    */   
/*    */   public POnUseInviteCodeResp(DataBetweenGameAndGrcArg arg, DataBetweenGameAndGrcRes res)
/*    */   {
/* 14 */     this.arg = arg;
/* 15 */     this.res = res;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 21 */     return InviteFriendsManager.onUseInviteCodeResp(this.arg, this.res);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\main\POnUseInviteCodeResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */