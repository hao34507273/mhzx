/*     */ package mzm.gsp.crossserver.main;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import hub.DataTransferReq;
/*     */ import hub.DataTransferReqXidWrapper;
/*     */ import hub.DataTransferRsp;
/*     */ import hub.DataTransferRspXidWrapper;
/*     */ import hub.GHubHelper;
/*     */ import hub.GenRoamTokenReq;
/*     */ import hub.GenRoamTokenRsp;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.crossserver.event.GenRoamTokenFail;
/*     */ import mzm.gsp.crossserver.event.GenRoamTokenFailArg;
/*     */ import mzm.gsp.crossserver.event.GenRoamTokenSucceed;
/*     */ import mzm.gsp.crossserver.event.GenRoamTokenSucceedArg;
/*     */ import mzm.gsp.crossserver.event.RoamRoleDataFail;
/*     */ import mzm.gsp.crossserver.event.RoamRoleDataFailArg;
/*     */ import mzm.gsp.online.main.LoginManager.UserCrossToken;
/*     */ import mzm.gsp.util.CommonUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ public class DTH_GenRoamToken
/*     */   extends DataTransferHandler<GenRoamTokenReq, GenRoamTokenRsp>
/*     */ {
/*     */   protected GenRoamTokenReq makeReqDataBean()
/*     */   {
/*  31 */     return new GenRoamTokenReq();
/*     */   }
/*     */   
/*     */ 
/*     */   protected GenRoamTokenRsp makeRspDataBean()
/*     */   {
/*  37 */     return new GenRoamTokenRsp();
/*     */   }
/*     */   
/*     */ 
/*     */   protected void onDataTransferReq(DataTransferReq req, GenRoamTokenReq reqData)
/*     */   {
/*  43 */     String userid = reqData.userid.getString("UTF-8");
/*     */     
/*  45 */     DataTransferRsp rsp = new DataTransferRsp();
/*  46 */     rsp.direction = 0;
/*  47 */     rsp.xid = req.xid;
/*  48 */     rsp.src_id = GameServerInfoManager.getZoneId();
/*  49 */     rsp.dst_id = CommonUtils.getZoneId(userid);
/*  50 */     rsp.data_type = req.data_type;
/*     */     
/*  52 */     GenRoamTokenRsp genRoamTokenRsp = new GenRoamTokenRsp();
/*  53 */     genRoamTokenRsp.token = reqData.token;
/*  54 */     OctetsStream os = new OctetsStream();
/*  55 */     genRoamTokenRsp.marshal(os);
/*  56 */     rsp.data = os;
/*  57 */     LoginManager.UserCrossToken userCrossToken = new LoginManager.UserCrossToken(userid, reqData.roleid, reqData.token);
/*  58 */     if (new PSaveRoamTokenInfo(userCrossToken).call())
/*     */     {
/*  60 */       rsp.retcode = 0;
/*     */     }
/*     */     else
/*     */     {
/*  64 */       rsp.retcode = 2;
/*     */     }
/*     */     
/*  67 */     GameServer.logger().info(String.format("[crossserver]DTH_GenRoamToken.onDataTransferReq@handle gen roam token request|req=%s|req_data=%s|rsp=%s|rsp_data=%s", new Object[] { req, reqData, rsp, genRoamTokenRsp }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  72 */     GHubHelper.sendDataTransferRsp(rsp);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected void onDataTransferTimeout(DataTransferReqXidWrapper reqXidWrapper, GenRoamTokenReq reqData, int code)
/*     */   {
/*  79 */     GenRoamTokenTransferReqXidWrapper genRoamTokenReqXidWrapper = (GenRoamTokenTransferReqXidWrapper)reqXidWrapper;
/*  80 */     RoamContext context = genRoamTokenReqXidWrapper.getContext();
/*     */     
/*  82 */     GameServer.logger().error(String.format("[crossserver]DTH_GenRoamToken.onDataTransferTimeout@gen roam token time out|req=%s|req_data=%s|code=%d|roam_context=%s", new Object[] { reqXidWrapper.getProtocol(), reqData, Integer.valueOf(code), context }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  87 */     GenRoamTokenFail event = new GenRoamTokenFail();
/*  88 */     GenRoamTokenFailArg arg = GenRoamTokenEventArgCreator.createGenRoamTokenFailArg(context);
/*  89 */     TriggerEventsManger.getInstance().triggerEvent(event, arg);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected void onDataTransferRsp(DataTransferReqXidWrapper reqXidWrapper, GenRoamTokenReq reqData, DataTransferRspXidWrapper rspXidWrapper, GenRoamTokenRsp rspData)
/*     */   {
/*  96 */     GenRoamTokenTransferReqXidWrapper genRoamTokenReqXidWrapper = (GenRoamTokenTransferReqXidWrapper)reqXidWrapper;
/*  97 */     RoamContext context = genRoamTokenReqXidWrapper.getContext();
/*  98 */     DataTransferRsp rsp = rspXidWrapper.getProtocol();
/*     */     
/* 100 */     GameServer.logger().info(String.format("[crossserver]DTH_GenRoamToken.onDataTransferRsp@gen roam token done|req=%s|req_data=%s|rsp=%s|rsp_data=%s|roam_context=%s", new Object[] { reqXidWrapper.getProtocol(), reqData, rspXidWrapper.getProtocol(), rspData, context }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 105 */     if (rsp.retcode != 0)
/*     */     {
/* 107 */       GenRoamTokenFail event = new GenRoamTokenFail();
/* 108 */       GenRoamTokenFailArg arg = GenRoamTokenEventArgCreator.createGenRoamTokenFailArg(context);
/* 109 */       TriggerEventsManger.getInstance().triggerEvent(event, arg);
/*     */     }
/*     */     else
/*     */     {
/* 113 */       if (!context.addToken(reqData.roleid, rspData.token))
/*     */       {
/* 115 */         return;
/*     */       }
/*     */       
/* 118 */       if (!context.isGenTokenDone())
/*     */       {
/* 120 */         return;
/*     */       }
/*     */       
/*     */ 
/* 124 */       GenRoamTokenSucceed event = new GenRoamTokenSucceed();
/* 125 */       GenRoamTokenSucceedArg arg = GenRoamTokenEventArgCreator.createGenRoamTokenSucceedArg(context);
/* 126 */       TriggerEventsManger.getInstance().triggerEvent(event, arg);
/*     */       
/*     */ 
/* 129 */       if (!CrossServerManager.roamRole(context))
/*     */       {
/* 131 */         RoamRoleDataFail event = new RoamRoleDataFail();
/* 132 */         RoamRoleDataFailArg arg = RoamRoleDataEventCreator.createRoamRoleDataFailArg(context);
/* 133 */         TriggerEventsManger.getInstance().triggerEvent(event, arg);
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\DTH_GenRoamToken.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */