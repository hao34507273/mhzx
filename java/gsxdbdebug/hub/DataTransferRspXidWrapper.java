/*    */ package hub;
/*    */ 
/*    */ import mzm.gsp.util.XidProtocolRsp;
/*    */ 
/*    */ public class DataTransferRspXidWrapper implements XidProtocolRsp
/*    */ {
/*    */   private final DataTransferRsp proto;
/*    */   
/*    */   public DataTransferRspXidWrapper(DataTransferRsp proto)
/*    */   {
/* 11 */     this.proto = proto;
/*    */   }
/*    */   
/*    */ 
/*    */   public DataTransferRsp getProtocol()
/*    */   {
/* 17 */     return this.proto;
/*    */   }
/*    */   
/*    */ 
/*    */   public int getXid()
/*    */   {
/* 23 */     return this.proto.xid;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\DataTransferRspXidWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */