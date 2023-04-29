/*     */ package mzm.gsp.crossserver.main;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import hub.DataTransferReq;
/*     */ import hub.DataTransferReqXidWrapper;
/*     */ import hub.DataTransferRsp;
/*     */ import hub.DataTransferRspXidWrapper;
/*     */ import hub.ExchangeDataHandlerInfo;
/*     */ import hub.GHubHelper;
/*     */ import hub.PointRaceDataBackReq;
/*     */ import hub.PointRaceDataBackRsp;
/*     */ import hub.PointRaceUserDataBack;
/*     */ import java.util.ArrayList;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.crossbattle.point.PPointRaceBack;
/*     */ import mzm.gsp.crossbattle.point.PointRaceBackContext;
/*     */ import mzm.gsp.crossbattle.point.PointRaceUserBackData;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class DTH_PointRaceDataBack extends DataTransferHandler<PointRaceDataBackReq, PointRaceDataBackRsp>
/*     */ {
/*     */   protected PointRaceDataBackReq makeReqDataBean()
/*     */   {
/*  25 */     return new PointRaceDataBackReq();
/*     */   }
/*     */   
/*     */ 
/*     */   protected PointRaceDataBackRsp makeRspDataBean()
/*     */   {
/*  31 */     return new PointRaceDataBackRsp();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected void onDataTransferReq(DataTransferReq req, PointRaceDataBackReq reqData)
/*     */   {
/*  38 */     PointRaceBackContext backContext = new PointRaceBackContext(reqData.activity_cfgid, reqData.time_point_cfgid, reqData.pvp_fight);
/*     */     
/*  40 */     for (PointRaceUserDataBack userDataBack : reqData.user_back_datas)
/*     */     {
/*  42 */       String userid = userDataBack.userid.getString("UTF-8");
/*  43 */       ExchangeDataHandlerInfo exchangeDataDandlerInfo = userDataBack.exchange_data_handler_info.isEmpty() ? null : (ExchangeDataHandlerInfo)userDataBack.exchange_data_handler_info.get(0);
/*     */       
/*  45 */       PointRaceUserBackData dataBack = new PointRaceUserBackData(userid, userDataBack.roleid, userDataBack.user_token, exchangeDataDandlerInfo);
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  50 */       backContext.userDatas.add(dataBack);
/*     */     }
/*  52 */     hub.PointRaceCorpsInfo corpsInfo = reqData.corps_info;
/*  53 */     backContext.corpsInfo.setCorpsid(corpsInfo.corpsid);
/*  54 */     backContext.corpsInfo.setLose(corpsInfo.lose);
/*  55 */     backContext.corpsInfo.setPoint(corpsInfo.point);
/*  56 */     backContext.corpsInfo.setUpdateTime(corpsInfo.update_time);
/*  57 */     backContext.corpsInfo.setWin(corpsInfo.win);
/*     */     
/*  59 */     boolean ret = new PPointRaceBack(backContext).call();
/*  60 */     if (!ret)
/*     */     {
/*     */ 
/*  63 */       GameServer.logger().error("[DTH_PointRaceDataBack]DTH_PointRaceDataBack.onDataTransferReq@procedure is wrong");
/*     */     }
/*     */     
/*  66 */     DataTransferRsp rsp = new DataTransferRsp();
/*  67 */     rsp.direction = req.direction;
/*  68 */     rsp.xid = req.xid;
/*  69 */     rsp.src_id = req.dst_id;
/*  70 */     rsp.dst_id = req.src_id;
/*  71 */     rsp.data_type = req.data_type;
/*  72 */     rsp.retcode = 0;
/*  73 */     PointRaceDataBackRsp pointRaceDataBackRsp = new PointRaceDataBackRsp();
/*  74 */     OctetsStream os = new OctetsStream();
/*  75 */     pointRaceDataBackRsp.marshal(os);
/*  76 */     rsp.data = os;
/*  77 */     GHubHelper.sendDataTransferRsp(rsp);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void onDataTransferTimeout(DataTransferReqXidWrapper reqXidWrapper, PointRaceDataBackReq reqData, int code)
/*     */   {
/*  85 */     GameServer.logger().error(String.format("[crossbattlepoint]DTH_PointRaceDataBack.onDataTransferTimeout@time out now|des=%s", new Object[] { reqData.toString() }));
/*     */     
/*     */ 
/*     */ 
/*  89 */     for (PointRaceUserDataBack userDataBack : reqData.user_back_datas)
/*     */     {
/*  91 */       new PPointRaceReturnOrigianServer(userDataBack.roleid).call();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void onDataTransferRsp(DataTransferReqXidWrapper reqXidWrapper, PointRaceDataBackReq reqData, DataTransferRspXidWrapper rspXidWrapper, PointRaceDataBackRsp rspData)
/*     */   {
/* 100 */     DataTransferRsp rsp = rspXidWrapper.getProtocol();
/* 101 */     if (rsp.retcode != 0)
/*     */     {
/* 103 */       GameServer.logger().error(String.format("[crossbattlepoint]DTH_PointRaceDataBack.onDataTransferRsp@ret code is error|errorcode=%d|desc=%s", new Object[] { Integer.valueOf(rsp.retcode), reqData.toString() }));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 109 */     for (PointRaceUserDataBack userDataBack : reqData.user_back_datas)
/*     */     {
/* 111 */       new PPointRaceReturnOrigianServer(userDataBack.roleid).call();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\DTH_PointRaceDataBack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */