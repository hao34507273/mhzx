/*    */ package mzm.gsp.chat.main;
/*    */ 
/*    */ import betacat.DataBetweenBetacatAndGameServerRsp;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class POnDataBetweenBetacatAndGameServerRsp extends LogicProcedure
/*    */ {
/*    */   final DataBetweenBetacatAndGameServerRsp rsp;
/*    */   
/*    */   public POnDataBetweenBetacatAndGameServerRsp(DataBetweenBetacatAndGameServerRsp rsp)
/*    */   {
/* 12 */     this.rsp = rsp;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 18 */     BetacatChatRoomManager.onDataBetweenBetacatAndGameServerRsp(this.rsp);
/*    */     
/* 20 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\main\POnDataBetweenBetacatAndGameServerRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */