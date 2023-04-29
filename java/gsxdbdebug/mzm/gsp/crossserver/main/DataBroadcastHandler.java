/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ import hub.DataBroadcast;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public abstract class DataBroadcastHandler<Data extends Marshal>
/*    */ {
/* 12 */   private static final Logger logger = Logger.getLogger(DataBroadcastHandler.class);
/*    */   
/*    */   public final void onDataBroadcast(DataBroadcast broadcast, Octets data) throws MarshalException
/*    */   {
/* 16 */     Data dataBean = makeDataBean();
/* 17 */     if ((dataBean != null) && (data.size() > 0))
/*    */     {
/* 19 */       OctetsStream os = new OctetsStream(data);
/* 20 */       dataBean.unmarshal(os);
/*    */     }
/*    */     
/* 23 */     if (logger.isDebugEnabled())
/*    */     {
/* 25 */       logger.debug(String.format("[crossserver]DataBroadcastHandler.onProcessDataBroadcast@dump info|broadcast=%s|data=%s", new Object[] { broadcast, dataBean }));
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 30 */     onDataBroadcast(broadcast, dataBean);
/*    */   }
/*    */   
/*    */   protected abstract Data makeDataBean();
/*    */   
/*    */   protected abstract void onDataBroadcast(DataBroadcast paramDataBroadcast, Data paramData);
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\DataBroadcastHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */