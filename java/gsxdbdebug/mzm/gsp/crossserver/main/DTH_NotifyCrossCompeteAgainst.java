/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import hub.CrossCompeteAgainst;
/*    */ import hub.DataTransferReq;
/*    */ import hub.DataTransferReqXidWrapper;
/*    */ import hub.DataTransferRsp;
/*    */ import hub.DataTransferRspXidWrapper;
/*    */ import hub.GHubHelper;
/*    */ import hub.NotifyCrossCompeteAgainstReq;
/*    */ import hub.NotifyCrossCompeteAgainstRsp;
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.crosscompete.roam.PBuildRoamAgainst;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class DTH_NotifyCrossCompeteAgainst
/*    */   extends DataTransferHandler<NotifyCrossCompeteAgainstReq, NotifyCrossCompeteAgainstRsp>
/*    */ {
/*    */   protected NotifyCrossCompeteAgainstReq makeReqDataBean()
/*    */   {
/* 23 */     return new NotifyCrossCompeteAgainstReq();
/*    */   }
/*    */   
/*    */   protected NotifyCrossCompeteAgainstRsp makeRspDataBean()
/*    */   {
/* 28 */     return new NotifyCrossCompeteAgainstRsp();
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onDataTransferReq(DataTransferReq req, NotifyCrossCompeteAgainstReq reqData)
/*    */   {
/* 34 */     if (!GameServerInfoManager.isRoamServer()) {
/* 35 */       GameServer.logger().error(String.format("[crosscompete]DTH_NotifyCrossCompeteAgainst.onDataTransferReq@not roam server|req=%s|req_data=%s", new Object[] { req, reqData }));
/*    */       
/*    */ 
/*    */ 
/* 39 */       return;
/*    */     }
/*    */     
/* 42 */     DataTransferRsp rsp = new DataTransferRsp();
/* 43 */     rsp.direction = req.direction;
/* 44 */     rsp.xid = req.xid;
/* 45 */     rsp.src_id = req.dst_id;
/* 46 */     rsp.dst_id = req.src_id;
/* 47 */     rsp.data_type = req.data_type;
/*    */     
/* 49 */     rsp.retcode = 0;
/*    */     
/* 51 */     NotifyCrossCompeteAgainstRsp rspData = new NotifyCrossCompeteAgainstRsp();
/* 52 */     rspData.start_millis = reqData.start_millis;
/*    */     
/* 54 */     for (CrossCompeteAgainst against : reqData.againsts) {
/* 55 */       boolean ret = new PBuildRoamAgainst(against.front_faction, against.behind_faction, against.compete_index).call();
/*    */       
/* 57 */       if (!ret) {
/* 58 */         rsp.retcode = 6;
/* 59 */         GameServer.logger().error(String.format("[crosscompete]DTH_NotifyCrossCompeteAgainst.onDataTransferReq@build roam against err|req=%s|against=%s", new Object[] { req, against }));
/*    */ 
/*    */       }
/*    */       else
/*    */       {
/*    */ 
/* 65 */         rspData.compete_list.add(Integer.valueOf(against.compete_index));
/* 66 */         GameServer.logger().info(String.format("[crosscompete]DTH_NotifyCrossCompeteAgainst.onDataTransferReq@build roam against succeed|against=%s", new Object[] { against }));
/*    */       }
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 73 */     OctetsStream os = new OctetsStream();
/* 74 */     os.marshal(rspData);
/* 75 */     rsp.data = os;
/*    */     
/* 77 */     GHubHelper.sendDataTransferRsp(rsp);
/*    */   }
/*    */   
/*    */   protected void onDataTransferRsp(DataTransferReqXidWrapper reqXidWrapper, NotifyCrossCompeteAgainstReq reqData, DataTransferRspXidWrapper rspXidWrapper, NotifyCrossCompeteAgainstRsp rspData) {}
/*    */   
/*    */   protected void onDataTransferTimeout(DataTransferReqXidWrapper reqXidWrapper, NotifyCrossCompeteAgainstReq reqData, int code) {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\DTH_NotifyCrossCompeteAgainst.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */