/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import hub.DataTransferReq;
/*    */ import hub.DataTransferReqXidWrapper;
/*    */ 
/*    */ public class NotifyBindFriendTransferReqXidWrapper extends DataTransferReqXidWrapper
/*    */ {
/*    */   public final String userid;
/*    */   public final long roleid;
/*    */   
/*    */   public NotifyBindFriendTransferReqXidWrapper(DataTransferReq proto, String userid, long roleid)
/*    */   {
/* 13 */     super(proto);
/*    */     
/* 15 */     this.userid = userid;
/* 16 */     this.roleid = roleid;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\NotifyBindFriendTransferReqXidWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */