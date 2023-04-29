/*     */ package mzm.gsp.crossserver.main;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import hub.DataTransferReq;
/*     */ import hub.DataTransferReqXidWrapper;
/*     */ import hub.DataTransferRsp;
/*     */ import hub.DataTransferRspXidWrapper;
/*     */ import hub.GHubHelper;
/*     */ import hub.PointRaceCorpsInfo;
/*     */ import hub.RoamPointRaceDataReq;
/*     */ import hub.RoamPointRaceDataRsp;
/*     */ import hub.RolePointRaceMarkingInfo;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.crossbattle.point.PointRaceCorpsCurInfo;
/*     */ import mzm.gsp.crossbattle.point.PointRaceInfo;
/*     */ import mzm.gsp.crossserver.event.JoinPointRaceFail;
/*     */ import mzm.gsp.crossserver.event.JoinPointRaceFailArg;
/*     */ import mzm.gsp.crossserver.event.JoinPointRaceSuccess;
/*     */ import mzm.gsp.crossserver.event.JoinPointRaceSuccessArg;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DTH_RoamPointRaceData
/*     */   extends DataTransferHandler<RoamPointRaceDataReq, RoamPointRaceDataRsp>
/*     */ {
/*     */   protected RoamPointRaceDataReq makeReqDataBean()
/*     */   {
/*  32 */     return new RoamPointRaceDataReq();
/*     */   }
/*     */   
/*     */ 
/*     */   protected RoamPointRaceDataRsp makeRspDataBean()
/*     */   {
/*  38 */     return new RoamPointRaceDataRsp();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected void onDataTransferReq(DataTransferReq req, RoamPointRaceDataReq reqData)
/*     */   {
/*  45 */     DataTransferRsp rsp = new DataTransferRsp();
/*  46 */     rsp.direction = req.direction;
/*  47 */     rsp.xid = req.xid;
/*  48 */     rsp.src_id = req.dst_id;
/*  49 */     rsp.dst_id = req.src_id;
/*  50 */     rsp.data_type = req.data_type;
/*     */     
/*  52 */     long worldid = reqData.roam_room_instanceid;
/*  53 */     PointRaceCorpsInfo pointRaceCorpsInfo = reqData.corps_info;
/*  54 */     long corpsid = pointRaceCorpsInfo.corpsid;
/*  55 */     PointRaceCorpsCurInfo curInfo = new PointRaceCorpsCurInfo(req.src_id, pointRaceCorpsInfo.win, pointRaceCorpsInfo.lose, pointRaceCorpsInfo.point, pointRaceCorpsInfo.update_time);
/*     */     
/*     */ 
/*     */ 
/*  59 */     List<RoamedRolePointRaceMarkingInfo> roamedInfos = new ArrayList();
/*  60 */     for (RolePointRaceMarkingInfo info : reqData.role_infos)
/*     */     {
/*  62 */       RoamedRolePointRaceMarkingInfo roamedRolePointRaceMarkingInfo = new RoamedRolePointRaceMarkingInfo(info);
/*  63 */       roamedInfos.add(roamedRolePointRaceMarkingInfo);
/*     */     }
/*     */     
/*  66 */     boolean ret = new PRoamPointRaceData(worldid, corpsid, roamedInfos, curInfo).call();
/*  67 */     if (ret)
/*     */     {
/*  69 */       rsp.retcode = 0;
/*     */     }
/*     */     else
/*     */     {
/*  73 */       rsp.retcode = 2;
/*     */     }
/*     */     
/*  76 */     RoamPointRaceDataRsp rspData = new RoamPointRaceDataRsp();
/*     */     
/*  78 */     OctetsStream os = new OctetsStream();
/*  79 */     os.marshal(rspData);
/*  80 */     rsp.data = os;
/*     */     
/*     */ 
/*  83 */     GHubHelper.sendDataTransferRsp(rsp);
/*     */     
/*  85 */     GameServer.logger().info(String.format("[crossserver]DTH_RoamPointRaceData.onDataTransferReq@handle roam point race data request|req=%s|req_data=%s|rsp=%s|rsp_data=%s", new Object[] { req, reqData, rsp, rspData }));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void onDataTransferTimeout(DataTransferReqXidWrapper reqXidWrapper, RoamPointRaceDataReq reqData, int code)
/*     */   {
/*  96 */     RoamPointRaceDataTransferReqXidWrapper xidWrapper = (RoamPointRaceDataTransferReqXidWrapper)reqXidWrapper;
/*  97 */     PointRaceContext context = xidWrapper.getContext();
/*     */     
/*  99 */     JoinPointRaceFail event = new JoinPointRaceFail();
/* 100 */     JoinPointRaceFailArg arg = new JoinPointRaceFailArg(context.contextid, context.corpsid, context.leaderid, context.rolePointRaceMarkingInfos, context.pointRaceInfo.getActivityCfgid());
/*     */     
/*     */ 
/* 103 */     TriggerEventsManger.getInstance().triggerEvent(event, arg);
/*     */     
/* 105 */     GameServer.logger().error(String.format("[crossserver]DTH_RoamPointRaceData.onDataTransferTimeout@roam point race data timeout|req=%s|req_data=%s|code=%d|context=%s", new Object[] { reqXidWrapper.getProtocol(), reqData, Integer.valueOf(code), context }));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void onDataTransferRsp(DataTransferReqXidWrapper reqXidWrapper, RoamPointRaceDataReq reqData, DataTransferRspXidWrapper rspXidWrapper, RoamPointRaceDataRsp rspData)
/*     */   {
/* 116 */     RoamPointRaceDataTransferReqXidWrapper xidWrapper = (RoamPointRaceDataTransferReqXidWrapper)reqXidWrapper;
/* 117 */     PointRaceContext context = xidWrapper.getContext();
/* 118 */     boolean isSucceed = rspXidWrapper.getProtocol().retcode == 0;
/* 119 */     if (isSucceed)
/*     */     {
/* 121 */       JoinPointRaceSuccess event = new JoinPointRaceSuccess();
/* 122 */       JoinPointRaceSuccessArg arg = new JoinPointRaceSuccessArg(context.contextid, context.corpsid, context.leaderid, context.rolePointRaceMarkingInfos, context.pointRaceInfo.getActivityCfgid());
/*     */       
/*     */ 
/*     */ 
/* 126 */       TriggerEventsManger.getInstance().triggerEvent(event, arg);
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 131 */       JoinPointRaceFail event = new JoinPointRaceFail();
/* 132 */       JoinPointRaceFailArg arg = new JoinPointRaceFailArg(context.contextid, context.corpsid, context.leaderid, context.rolePointRaceMarkingInfos, context.pointRaceInfo.getActivityCfgid());
/*     */       
/*     */ 
/* 135 */       TriggerEventsManger.getInstance().triggerEvent(event, arg);
/*     */       
/* 137 */       GameServer.logger().error(String.format("[crossserver]DTH_RoamPointRaceData.onDataTransferRsp@roam point race data failed|req=%s|req_data=%s|context=%s", new Object[] { reqXidWrapper.getProtocol(), reqData, context }));
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\DTH_RoamPointRaceData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */