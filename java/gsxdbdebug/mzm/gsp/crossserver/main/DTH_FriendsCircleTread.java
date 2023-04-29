/*     */ package mzm.gsp.crossserver.main;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import hub.DataTransferReq;
/*     */ import hub.DataTransferReqXidWrapper;
/*     */ import hub.DataTransferRsp;
/*     */ import hub.DataTransferRspXidWrapper;
/*     */ import hub.FriendsCircleTreadReq;
/*     */ import hub.FriendsCircleTreadRsp;
/*     */ import hub.GHubHelper;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.friendscircle.main.FriendsCircleInterface;
/*     */ import mzm.gsp.friendscircle.main.PCTreadFriendsCircle.PUnSetCrossServerTread;
/*     */ import mzm.gsp.friendscircle.main.POnCrossServerTreadFriendsCircle;
/*     */ import mzm.gsp.friendscircle.main.POnCrossServerTreadFriendsCircleRsp;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Executor;
/*     */ import xdb.Xdb;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DTH_FriendsCircleTread
/*     */   extends DataTransferHandler<FriendsCircleTreadReq, FriendsCircleTreadRsp>
/*     */ {
/*     */   protected FriendsCircleTreadReq makeReqDataBean()
/*     */   {
/*  29 */     return new FriendsCircleTreadReq();
/*     */   }
/*     */   
/*     */ 
/*     */   protected FriendsCircleTreadRsp makeRspDataBean()
/*     */   {
/*  35 */     return new FriendsCircleTreadRsp();
/*     */   }
/*     */   
/*     */ 
/*     */   protected void onDataTransferReq(DataTransferReq req, FriendsCircleTreadReq reqData)
/*     */   {
/*  41 */     StringBuilder sBuilder = new StringBuilder();
/*  42 */     sBuilder.append("[crossserver_friendscircle]DTH_FriendsCircleTread.onDataTransferReq@get friends circle tread req");
/*  43 */     sBuilder.append("|req=").append(req);
/*  44 */     sBuilder.append("|req_data=").append(reqData);
/*     */     
/*  46 */     GameServer.logger().info(sBuilder.toString());
/*     */     
/*  48 */     POnCrossServerTreadFriendsCircle procedure = new POnCrossServerTreadFriendsCircle(reqData.active_tread_role_id, req.src_id, reqData.be_trod_role_id, reqData.is_can_get_more_treasure_box > 0, reqData.tread_serial_id);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  54 */     procedure.call();
/*     */     
/*  56 */     DataTransferRsp rsp = new DataTransferRsp();
/*  57 */     rsp.direction = req.direction;
/*  58 */     rsp.xid = req.xid;
/*  59 */     rsp.src_id = req.dst_id;
/*  60 */     rsp.dst_id = req.src_id;
/*  61 */     rsp.data_type = req.data_type;
/*  62 */     rsp.retcode = 0;
/*     */     
/*  64 */     FriendsCircleTreadRsp rspData = new FriendsCircleTreadRsp();
/*  65 */     rspData.is_trigger_box = (procedure.isTriggerBox() ? 1 : 0);
/*  66 */     rspData.result = ((byte)procedure.getTreadResult());
/*  67 */     rspData.add_popularity_value = procedure.getAddPopularity();
/*  68 */     rspData.current_total_popularity_value = procedure.getCurrentTotalPopularity();
/*  69 */     rspData.current_week_popularity_value = procedure.getCurrentWeekPopularity();
/*  70 */     rspData.own_treasure_box_num = procedure.getOwnTreasureBoxNum();
/*     */     
/*  72 */     rsp.data = new OctetsStream().marshal(rspData);
/*     */     
/*  74 */     StringBuilder rspSbLog = new StringBuilder();
/*  75 */     rspSbLog.append("|req=").append(req);
/*  76 */     rspSbLog.append("|req_data=").append(reqData);
/*  77 */     rspSbLog.append("|rsp_result=").append(rspData.result);
/*  78 */     rspSbLog.append("|is_trigger_box=").append(rspData.is_trigger_box);
/*     */     
/*  80 */     if (!GHubHelper.sendDataTransferRsp(rsp))
/*     */     {
/*  82 */       GameServer.logger().error(String.format("[crossserver_friendscircle]DTH_FriendsCircleTread.onDataTransferReq@send friends circle tread rsp failed|context=%s", new Object[] { rspSbLog }));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  88 */     GameServer.logger().info(String.format("[crossserver_friendscircle]DTH_FriendsCircleTread.onDataTransferReq@send friends circle tread rsp success|context=%s", new Object[] { rspSbLog }));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void onDataTransferTimeout(DataTransferReqXidWrapper reqXidWrapper, FriendsCircleTreadReq reqData, int code)
/*     */   {
/*  97 */     StringBuilder sBuilder = new StringBuilder();
/*  98 */     sBuilder.append("[crossserver_friendscircle]DTH_FriendsCircleTread.onDataTransferTimeout@on friends circle tread time out");
/*  99 */     sBuilder.append("|req=").append(reqXidWrapper.getProtocol());
/* 100 */     sBuilder.append("|req_data=").append(reqData);
/* 101 */     sBuilder.append("|code=").append(code);
/*     */     
/* 103 */     GameServer.logger().error(sBuilder.toString());
/*     */     
/* 105 */     new PRepeatFriendsCircleTread(reqXidWrapper, reqData).call();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected void onDataTransferRsp(DataTransferReqXidWrapper reqXidWrapper, FriendsCircleTreadReq reqData, DataTransferRspXidWrapper rspXidWrapper, FriendsCircleTreadRsp rspData)
/*     */   {
/* 112 */     DataTransferRsp rsp = rspXidWrapper.getProtocol();
/* 113 */     final long activeTreadRoleId = reqData.active_tread_role_id;
/*     */     
/* 115 */     if (rsp.retcode != 0)
/*     */     {
/* 117 */       Xdb.executor().schedule(new Runnable()
/*     */       {
/*     */ 
/*     */ 
/*     */         public void run() {
/* 122 */           new PCTreadFriendsCircle.PUnSetCrossServerTread(activeTreadRoleId).execute(); } }, 20L, TimeUnit.SECONDS);
/*     */       
/*     */ 
/*     */ 
/* 126 */       StringBuilder sBuilder = new StringBuilder();
/* 127 */       sBuilder.append("[crossserver_friendscircle]DTH_FriendsCircleTread.onDataTransferRsp@on friends circle tread rsp,error");
/* 128 */       sBuilder.append("|req_data=").append(reqData);
/* 129 */       sBuilder.append("|protocol=").append(reqXidWrapper.getProtocol());
/* 130 */       sBuilder.append("|rsp_retcode=").append(rsp.retcode);
/*     */       
/* 132 */       GameServer.logger().info(sBuilder.toString());
/* 133 */       return;
/*     */     }
/*     */     
/* 136 */     StringBuilder sBuilder = new StringBuilder();
/* 137 */     sBuilder.append("[crossserver_friendscircle]DTH_FriendsCircleTread.onDataTransferRsp@on friends circle tread rsp");
/* 138 */     sBuilder.append("|req=").append(reqXidWrapper.getProtocol());
/* 139 */     sBuilder.append("|req_data=").append(reqData);
/* 140 */     sBuilder.append("|rsp_data=").append(rspData);
/*     */     
/* 142 */     GameServer.logger().info(sBuilder.toString());
/*     */     
/* 144 */     new POnCrossServerTreadFriendsCircleRsp(rspData.result, rspData.is_trigger_box, rspData.add_popularity_value, rspData.current_week_popularity_value, rspData.current_total_popularity_value, reqData.active_tread_role_id, reqXidWrapper.getProtocol().dst_id, reqData.be_trod_role_id, reqData.tread_serial_id, rspData.own_treasure_box_num, reqData.is_auto_tread).call();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private static class PRepeatFriendsCircleTread
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final DataTransferReqXidWrapper reqXidWrapper;
/*     */     
/*     */     private final FriendsCircleTreadReq reqData;
/*     */     
/*     */ 
/*     */     public PRepeatFriendsCircleTread(DataTransferReqXidWrapper reqXidWrapper, FriendsCircleTreadReq reqData)
/*     */     {
/* 159 */       this.reqXidWrapper = reqXidWrapper;
/* 160 */       this.reqData = reqData;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 166 */       long activeTreadRoleId = this.reqData.active_tread_role_id;
/* 167 */       long serialId = this.reqData.tread_serial_id;
/*     */       
/* 169 */       if (FriendsCircleInterface.isTreadCircleNotServerReplied(activeTreadRoleId, serialId))
/*     */       {
/* 171 */         StringBuilder sBuilder = new StringBuilder();
/* 172 */         sBuilder.append("[friendscircle]DTH_FriendsCircleTread.PRepeatFriendsCircleTread.processImp@aleardy deal");
/* 173 */         sBuilder.append("|req_data=").append(this.reqData);
/*     */         
/* 175 */         GameServer.logger().info(sBuilder.toString());
/* 176 */         return false;
/*     */       }
/*     */       
/* 179 */       FriendsCircleTreadTransferReqXidWrapper xidWrapper = (FriendsCircleTreadTransferReqXidWrapper)this.reqXidWrapper;
/*     */       
/* 181 */       if (xidWrapper.repeatTimes++ > 2)
/*     */       {
/* 183 */         return false;
/*     */       }
/*     */       
/* 186 */       if (!GHubHelper.sendDataTransferReq(this.reqXidWrapper, false))
/*     */       {
/* 188 */         StringBuilder sBuilder = new StringBuilder();
/* 189 */         sBuilder.append("[friendscircle]DTH_FriendsCircleTread.PRepeatFriendsCircleTread.processImp@send fail");
/* 190 */         sBuilder.append("|req_data=").append(this.reqData);
/*     */         
/* 192 */         GameServer.logger().info(sBuilder.toString());
/*     */         
/* 194 */         return false;
/*     */       }
/* 196 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\DTH_FriendsCircleTread.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */