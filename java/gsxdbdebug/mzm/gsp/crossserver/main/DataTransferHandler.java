/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ import hub.DataTransferReq;
/*    */ import hub.DataTransferReqXidWrapper;
/*    */ import hub.DataTransferRspXidWrapper;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class DataTransferHandler<ReqData extends Marshal, RspData extends Marshal>
/*    */ {
/* 16 */   private static final Logger logger = Logger.getLogger(DataTransferHandler.class);
/*    */   
/*    */   public final void onDataTransferReq(DataTransferReq req, Octets reqData) throws MarshalException
/*    */   {
/* 20 */     ReqData reqDataBean = makeReqDataBean();
/* 21 */     if ((reqDataBean != null) && (reqData.size() > 0))
/*    */     {
/* 23 */       OctetsStream os = new OctetsStream(reqData);
/* 24 */       reqDataBean.unmarshal(os);
/*    */     }
/*    */     
/* 27 */     if (logger.isDebugEnabled())
/*    */     {
/* 29 */       logger.debug(String.format("[crossserver]DataTransferHandler.onDataTransferReq@dump info|req=%s|req_data=%s", new Object[] { req, reqDataBean }));
/*    */     }
/*    */     
/*    */ 
/* 33 */     onDataTransferReq(req, reqDataBean);
/*    */   }
/*    */   
/*    */   public final void onDataTransferTimeout(DataTransferReqXidWrapper reqXidWrapper, Octets reqData, int code)
/*    */     throws MarshalException
/*    */   {
/* 39 */     ReqData reqDataBean = makeReqDataBean();
/* 40 */     if ((reqDataBean != null) && (reqData.size() > 0))
/*    */     {
/* 42 */       OctetsStream os = new OctetsStream(reqData);
/* 43 */       reqDataBean.unmarshal(os);
/*    */     }
/*    */     
/* 46 */     if (logger.isDebugEnabled())
/*    */     {
/* 48 */       logger.debug(String.format("[crossserver]DataTransferHandler.onDataTransferTimeout@dump info|code=%d|req=%s|req_data=%s", new Object[] { Integer.valueOf(code), reqXidWrapper.getProtocol(), reqDataBean }));
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 53 */     onDataTransferTimeout(reqXidWrapper, reqDataBean, code);
/*    */   }
/*    */   
/*    */   public final void onDataTransferRsp(DataTransferReqXidWrapper reqXidWrapper, Octets reqData, DataTransferRspXidWrapper rspXidWrapper, Octets rspData)
/*    */     throws MarshalException
/*    */   {
/* 59 */     ReqData reqDataBean = makeReqDataBean();
/* 60 */     if ((reqDataBean != null) && (reqData.size() > 0))
/*    */     {
/* 62 */       OctetsStream os = new OctetsStream(reqData);
/* 63 */       reqDataBean.unmarshal(os);
/*    */     }
/*    */     
/* 66 */     RspData rspDataBean = makeRspDataBean();
/* 67 */     if ((rspDataBean != null) && (rspData.size() > 0))
/*    */     {
/* 69 */       OctetsStream os = new OctetsStream(rspData);
/* 70 */       rspDataBean.unmarshal(os);
/*    */     }
/*    */     
/* 73 */     if (logger.isDebugEnabled())
/*    */     {
/* 75 */       logger.debug(String.format("[crossserver]DataTransferHandler.onDataTransferReq@dump info|req=%s|req_data=%s|rsp=%s|rsp_data=%s", new Object[] { reqXidWrapper.getProtocol(), reqDataBean, rspXidWrapper.getProtocol(), rspDataBean }));
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 80 */     onDataTransferRsp(reqXidWrapper, reqDataBean, rspXidWrapper, rspDataBean);
/*    */   }
/*    */   
/*    */   protected abstract ReqData makeReqDataBean();
/*    */   
/*    */   protected abstract RspData makeRspDataBean();
/*    */   
/*    */   protected abstract void onDataTransferReq(DataTransferReq paramDataTransferReq, ReqData paramReqData);
/*    */   
/*    */   protected abstract void onDataTransferTimeout(DataTransferReqXidWrapper paramDataTransferReqXidWrapper, ReqData paramReqData, int paramInt);
/*    */   
/*    */   protected abstract void onDataTransferRsp(DataTransferReqXidWrapper paramDataTransferReqXidWrapper, ReqData paramReqData, DataTransferRspXidWrapper paramDataTransferRspXidWrapper, RspData paramRspData);
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\DataTransferHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */