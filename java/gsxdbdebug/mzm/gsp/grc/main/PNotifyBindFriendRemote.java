/*    */ package mzm.gsp.grc.main;
/*    */ 
/*    */ import hub.RecallNotifyBindFriendReq;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PNotifyBindFriendRemote
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final RecallNotifyBindFriendReq reqData;
/* 10 */   private int retcode = 0;
/*    */   
/*    */   public PNotifyBindFriendRemote(RecallNotifyBindFriendReq reqData)
/*    */   {
/* 14 */     this.reqData = reqData;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 20 */     this.retcode = RecallFriendManager.notifyBindFriend(this.reqData);
/* 21 */     return this.retcode == 0;
/*    */   }
/*    */   
/*    */   public int getRetcode()
/*    */   {
/* 26 */     return this.retcode;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\main\PNotifyBindFriendRemote.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */