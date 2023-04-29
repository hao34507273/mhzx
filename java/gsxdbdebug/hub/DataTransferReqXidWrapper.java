/*    */ package hub;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.crossserver.main.CrossServerInterface;
/*    */ import mzm.gsp.util.XidProtocolReq;
/*    */ import mzm.gsp.util.XidProtocolRsp;
/*    */ 
/*    */ public class DataTransferReqXidWrapper implements XidProtocolReq
/*    */ {
/*    */   private final DataTransferReq proto;
/*    */   
/*    */   public DataTransferReqXidWrapper(DataTransferReq proto)
/*    */   {
/* 14 */     this.proto = proto;
/*    */   }
/*    */   
/*    */ 
/*    */   public final DataTransferReq getProtocol()
/*    */   {
/* 20 */     return this.proto;
/*    */   }
/*    */   
/*    */ 
/*    */   public final void setXid(int xid)
/*    */   {
/* 26 */     this.proto.xid = xid;
/*    */   }
/*    */   
/*    */ 
/*    */   public final void onTimeout(int code)
/*    */   {
/* 32 */     CrossServerInterface.onDataTransferTimeout(this, code);
/*    */   }
/*    */   
/*    */ 
/*    */   public final void onResponse(XidProtocolRsp rsp)
/*    */   {
/* 38 */     if ((rsp instanceof DataTransferRspXidWrapper))
/*    */     {
/* 40 */       CrossServerInterface.onDataTransferRsp(this, (DataTransferRspXidWrapper)rsp);
/*    */     }
/*    */     else
/*    */     {
/* 44 */       GameServer.logger().error("[hub]DataTransferReqXidWrapper.onResponse@xid protocol rsp MUST BE \"DataTransferRspXidWrapper\"");
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\DataTransferReqXidWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */