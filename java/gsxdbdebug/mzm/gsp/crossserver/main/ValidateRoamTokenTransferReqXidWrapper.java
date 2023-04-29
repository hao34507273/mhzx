/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import mzm.gsp.online.main.LoginManager.CheckCrossServer;
/*    */ 
/*    */ public class ValidateRoamTokenTransferReqXidWrapper extends hub.DataTransferReqXidWrapper
/*    */ {
/*    */   private final LoginManager.CheckCrossServer context;
/*    */   
/*    */   public ValidateRoamTokenTransferReqXidWrapper(hub.DataTransferReq proto, LoginManager.CheckCrossServer context)
/*    */   {
/* 11 */     super(proto);
/* 12 */     this.context = context;
/*    */   }
/*    */   
/*    */   public final LoginManager.CheckCrossServer getContext() {
/* 16 */     return this.context;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\ValidateRoamTokenTransferReqXidWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */