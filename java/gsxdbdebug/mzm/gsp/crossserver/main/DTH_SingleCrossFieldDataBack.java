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
/*     */ import hub.SingleCrossFieldDataBackReq;
/*     */ import hub.SingleCrossFieldDataBackRsp;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.crossfield.main.CrossFieldInterface;
/*     */ import mzm.gsp.online.main.LoginManager;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DTH_SingleCrossFieldDataBack
/*     */   extends DataTransferHandler<SingleCrossFieldDataBackReq, SingleCrossFieldDataBackRsp>
/*     */ {
/*     */   protected SingleCrossFieldDataBackReq makeReqDataBean()
/*     */   {
/*  31 */     return new SingleCrossFieldDataBackReq();
/*     */   }
/*     */   
/*     */ 
/*     */   protected SingleCrossFieldDataBackRsp makeRspDataBean()
/*     */   {
/*  37 */     return new SingleCrossFieldDataBackRsp();
/*     */   }
/*     */   
/*     */ 
/*     */   protected void onDataTransferReq(DataTransferReq req, SingleCrossFieldDataBackReq reqData)
/*     */   {
/*  43 */     DataTransferRsp rsp = new DataTransferRsp();
/*  44 */     rsp.direction = req.direction;
/*  45 */     rsp.xid = req.xid;
/*  46 */     rsp.src_id = req.dst_id;
/*  47 */     rsp.dst_id = req.src_id;
/*  48 */     rsp.data_type = req.data_type;
/*  49 */     if (!new PSingleCrossFieldDataBack(reqData.userid.getString("UTF-8"), reqData.roleid, reqData.back_reason == 0, reqData.season, reqData.result, reqData.change_point, reqData.is_mvp == 1, reqData.start_timestamp, reqData.pvp_fight_times, reqData.exchange_data_handler_info.isEmpty() ? null : (ExchangeDataHandlerInfo)reqData.exchange_data_handler_info.get(0)).call())
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  56 */       rsp.retcode = 2;
/*     */     }
/*     */     else
/*     */     {
/*  60 */       rsp.retcode = 0;
/*     */     }
/*  62 */     SingleCrossFieldDataBackRsp rspData = new SingleCrossFieldDataBackRsp();
/*  63 */     OctetsStream os = new OctetsStream();
/*  64 */     os.marshal(rspData);
/*  65 */     rsp.data.replace(os);
/*     */     
/*  67 */     GameServer.logger().info(String.format("[crossserver]DTH_SingleCrossFieldDataBack.onDataTransferReq@handle single cross field data back|req=%s|req_data=%s|rsp=%s", new Object[] { req, reqData, rsp }));
/*     */     
/*     */ 
/*     */ 
/*  71 */     GHubHelper.sendDataTransferRsp(rsp);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected void onDataTransferRsp(DataTransferReqXidWrapper reqXidWrapper, final SingleCrossFieldDataBackReq reqData, DataTransferRspXidWrapper rspXidWrapper, SingleCrossFieldDataBackRsp rspData)
/*     */   {
/*  78 */     DataTransferRsp rsp = rspXidWrapper.getProtocol();
/*  79 */     new LogicProcedure()
/*     */     {
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/*  84 */         String userid = reqData.userid.getString("UTF-8");
/*  85 */         lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*  86 */         LoginManager.getInstance().onReturnOrigianServer(userid, reqData.roleid);
/*  87 */         return true;
/*     */       }
/*  89 */     }.call();
/*  90 */     GameServer.logger().error(String.format("[crossserver]DTH_SingleCrossFieldDataBack.onDataTransferRsp@single cross field data back rsp|errorcode=%d|req_data=%s", new Object[] { Integer.valueOf(rsp.retcode), reqData.toString() }));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void onDataTransferTimeout(DataTransferReqXidWrapper reqXidWrapper, final SingleCrossFieldDataBackReq reqData, int code)
/*     */   {
/* 100 */     new LogicProcedure()
/*     */     {
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/* 105 */         String userid = reqData.userid.getString("UTF-8");
/* 106 */         lock(User.getTable(), Arrays.asList(new String[] { userid }));
/* 107 */         LoginManager.getInstance().onReturnOrigianServer(userid, reqData.roleid);
/* 108 */         return true;
/*     */       }
/* 110 */     }.call();
/* 111 */     GameServer.logger().error(String.format("[crossserver]DTH_SingleCrossFieldDataBack.onDataTransferTimeout@single cross field data back timeout|req_data=%s", new Object[] { reqData }));
/*     */   }
/*     */   
/*     */ 
/*     */   class PSingleCrossFieldDataBack
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final String userid;
/*     */     
/*     */     private final long roleid;
/*     */     
/*     */     private final boolean isActiveLeave;
/*     */     
/*     */     private final int season;
/*     */     
/*     */     private final int result;
/*     */     private final int changePoint;
/*     */     private final boolean isMVP;
/*     */     private final long startTimestamp;
/*     */     private final int pvpFightTimes;
/*     */     private final ExchangeDataHandlerInfo exchangeDataHandlerInfo;
/*     */     
/*     */     public PSingleCrossFieldDataBack(String userid, long roleid, boolean isActiveLeave, int season, int result, int changePoint, boolean isMVP, long startTimestamp, int pvpFightTimes, ExchangeDataHandlerInfo exchangeDataHandlerInfo)
/*     */     {
/* 135 */       this.userid = userid;
/* 136 */       this.roleid = roleid;
/* 137 */       this.isActiveLeave = isActiveLeave;
/* 138 */       this.season = season;
/* 139 */       this.result = result;
/* 140 */       this.changePoint = changePoint;
/* 141 */       this.isMVP = isMVP;
/* 142 */       this.startTimestamp = startTimestamp;
/* 143 */       this.pvpFightTimes = pvpFightTimes;
/* 144 */       this.exchangeDataHandlerInfo = exchangeDataHandlerInfo;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 150 */       lock(User.getTable(), Arrays.asList(new String[] { this.userid }));
/* 151 */       lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/* 152 */       return CrossFieldInterface.onDataBack(this.userid, this.roleid, this.isActiveLeave, this.season, this.result, this.changePoint, this.isMVP, this.startTimestamp, this.pvpFightTimes, this.exchangeDataHandlerInfo);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\DTH_SingleCrossFieldDataBack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */