/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import mzm.gsp.online.main.LoginManager;
/*    */ import mzm.gsp.online.main.LoginManager.UserCrossToken;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ class PSaveRoamTokenInfo extends LogicProcedure
/*    */ {
/*    */   private final LoginManager.UserCrossToken userCrossToken;
/*    */   
/*    */   PSaveRoamTokenInfo(LoginManager.UserCrossToken userCrossToken)
/*    */   {
/* 13 */     this.userCrossToken = userCrossToken;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 19 */     LoginManager.saveCrossToken(this.userCrossToken);
/*    */     
/* 21 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\PSaveRoamTokenInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */