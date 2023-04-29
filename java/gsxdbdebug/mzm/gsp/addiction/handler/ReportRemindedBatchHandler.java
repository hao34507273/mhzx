/*    */ package mzm.gsp.addiction.handler;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ import jsonio.JsonStream;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.addiction.pro.core.CommRsp;
/*    */ import mzm.gsp.grc.main.GrcInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class ReportRemindedBatchHandler
/*    */   implements Handler
/*    */ {
/*    */   public void handle(String data)
/*    */   {
/* 17 */     CommRsp commRsp = new CommRsp();
/* 18 */     JsonStream js = new JsonStream(data);
/* 19 */     js.unmarshal("comm_rsp", commRsp);
/*    */     
/* 21 */     if (commRsp.ret == 0)
/*    */     {
/* 23 */       return;
/*    */     }
/*    */     
/* 26 */     GameServer.logger().error(String.format("[addiction]ReportRemindedBatchHandler.handle@error|ret=%d|error_msg=%s", new Object[] { Integer.valueOf(commRsp.ret), commRsp.err_msg }));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void onFailed(int retCode, String queryInfo, Octets context)
/*    */   {
/* 34 */     OctetsStream stream = new OctetsStream(context);
/* 35 */     int count = 0;
/*    */     try
/*    */     {
/* 38 */       count = stream.unmarshal_int();
/*    */     }
/*    */     catch (MarshalException e) {}
/*    */     
/*    */ 
/*    */ 
/* 44 */     if (count == 0)
/*    */     {
/* 46 */       stream.clear();
/* 47 */       stream.marshal(1);
/* 48 */       GrcInterface.antiAddictProxy(queryInfo, stream);
/*    */     }
/* 50 */     GameServer.logger().error(String.format("[addiction]ReportRemindedBatchHandler.onFailed@handle failed|count=%d|retcode=%d|query_info=%s", new Object[] { Integer.valueOf(count), Integer.valueOf(retCode), queryInfo }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\addiction\handler\ReportRemindedBatchHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */