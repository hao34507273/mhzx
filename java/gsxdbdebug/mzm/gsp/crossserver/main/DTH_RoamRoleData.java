/*     */ package mzm.gsp.crossserver.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import hub.DataTransferReq;
/*     */ import hub.DataTransferReqXidWrapper;
/*     */ import hub.DataTransferRsp;
/*     */ import hub.DataTransferRspXidWrapper;
/*     */ import hub.GHubHelper;
/*     */ import hub.RoamRoleDataReq;
/*     */ import hub.RoamRoleDataRsp;
/*     */ import java.util.List;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.crossbattle.point.PointRaceManager;
/*     */ import mzm.gsp.crossbattle.point.PointRaceZoneManager;
/*     */ import mzm.gsp.crosscompete.roam.PBuildRoamRole;
/*     */ import mzm.gsp.crosscompete.roam.RoamEnterContext;
/*     */ import mzm.gsp.crosscompete.roam.RoamEnterContextManager;
/*     */ import mzm.gsp.crossserver.event.RoamRoleDataFail;
/*     */ import mzm.gsp.crossserver.event.RoamRoleDataFailArg;
/*     */ import mzm.gsp.crossserver.event.RoamRoleDataSucceed;
/*     */ import mzm.gsp.crossserver.event.RoamRoleDataSucceedArg;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DTH_RoamRoleData
/*     */   extends DataTransferHandler<RoamRoleDataReq, RoamRoleDataRsp>
/*     */ {
/*     */   protected RoamRoleDataReq makeReqDataBean()
/*     */   {
/*  33 */     return new RoamRoleDataReq();
/*     */   }
/*     */   
/*     */ 
/*     */   protected RoamRoleDataRsp makeRspDataBean()
/*     */   {
/*  39 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */   protected void onDataTransferReq(DataTransferReq req, RoamRoleDataReq reqData)
/*     */   {
/*  45 */     DataTransferRsp rsp = new DataTransferRsp();
/*  46 */     rsp.direction = req.direction;
/*  47 */     rsp.xid = req.xid;
/*  48 */     rsp.src_id = req.dst_id;
/*  49 */     rsp.dst_id = req.src_id;
/*  50 */     rsp.data_type = req.data_type;
/*  51 */     String userid = reqData.userid.getString("UTF-8");
/*  52 */     long roleid = reqData.roleid;
/*     */     
/*  54 */     RoamType roamType = RoamType.values()[reqData.roam_type];
/*  55 */     if (roamType == RoamType.LADDER)
/*     */     {
/*  57 */       RoamedMatchContext context = RoamedMatchContextManager.getInstance().getRoamedMathContext(reqData.roam_room_instanceid);
/*     */       
/*  59 */       if (context == null)
/*     */       {
/*  61 */         rsp.retcode = 2;
/*     */ 
/*     */ 
/*     */       }
/*  65 */       else if (saveRoamRoleData(userid, roleid, reqData.xtables))
/*     */       {
/*  67 */         context.setDataPrepared(roleid);
/*  68 */         rsp.retcode = 0;
/*     */       }
/*     */       else
/*     */       {
/*  72 */         rsp.retcode = 2;
/*     */       }
/*     */       
/*     */     }
/*  76 */     else if (roamType == RoamType.CROSS_BATTLE_POINT)
/*     */     {
/*  78 */       PointRaceZoneManager zoneManager = PointRaceManager.getInstance().getZoneManager(reqData.roam_room_instanceid);
/*  79 */       if (zoneManager == null)
/*     */       {
/*  81 */         rsp.retcode = 2;
/*     */       }
/*     */       else
/*     */       {
/*  85 */         RoamedPointRaceContext context = zoneManager.getRoamedContextByRoleid(roleid);
/*  86 */         if (context == null)
/*     */         {
/*  88 */           rsp.retcode = 2;
/*     */ 
/*     */ 
/*     */         }
/*  92 */         else if (saveRoamRoleData(userid, roleid, reqData.xtables))
/*     */         {
/*  94 */           context.setDataPrepared(roleid);
/*  95 */           rsp.retcode = 0;
/*     */         }
/*     */         else
/*     */         {
/*  99 */           rsp.retcode = 2;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/* 104 */     else if (roamType == RoamType.CROSS_BATTLE_SELECTION_FINAL)
/*     */     {
/* 106 */       RoamedKnockOutContext context = RoamedKnockOutContextManager.getInstance().getRoamedMathContext(reqData.roam_room_instanceid);
/*     */       
/* 108 */       if (context == null)
/*     */       {
/* 110 */         rsp.retcode = 2;
/*     */ 
/*     */ 
/*     */       }
/* 114 */       else if (saveRoamRoleData(userid, roleid, reqData.xtables))
/*     */       {
/* 116 */         context.setDataPrepared(roleid);
/* 117 */         rsp.retcode = 0;
/*     */       }
/*     */       else
/*     */       {
/* 121 */         rsp.retcode = 2;
/*     */       }
/*     */       
/*     */     }
/* 125 */     else if (roamType == RoamType.CROSS_COMPETE)
/*     */     {
/* 127 */       RoamEnterContext competeContext = RoamEnterContextManager.getInstance().getContext(reqData.roam_room_instanceid);
/* 128 */       if (competeContext == null)
/*     */       {
/* 130 */         rsp.retcode = 2;
/*     */       }
/*     */       
/* 133 */       if (saveRoamRoleData(userid, roleid, reqData.xtables))
/*     */       {
/*     */ 
/* 136 */         if (!competeContext.setDataPrepared(roleid))
/*     */         {
/* 138 */           GameServer.logger().error(String.format("[crossserver]DTH_RoamRoleData.onDataTransferReq@set data prepared failed|roleid=%d|roam_room_instanceid=%d|req=%s|req_data=%s|rsp=%s", new Object[] { Long.valueOf(roleid), Long.valueOf(reqData.roam_room_instanceid), req, reqData, rsp }));
/*     */           
/*     */ 
/*     */ 
/* 142 */           rsp.retcode = 2;
/*     */         }
/*     */         else
/*     */         {
/* 146 */           PBuildRoamRole pBuild = new PBuildRoamRole(userid, roleid, competeContext.factionid, reqData.roam_room_instanceid);
/*     */           
/* 148 */           if (!pBuild.call())
/*     */           {
/* 150 */             GameServer.logger().error(String.format("[crossserver]DTH_RoamRoleData.onDataTransferReq@build roam cross compete role failed|roleid=%d|roam_room_instanceid=%d|req=%s|req_data=%s|rsp=%s", new Object[] { Long.valueOf(roleid), Long.valueOf(reqData.roam_room_instanceid), req, reqData, rsp }));
/*     */             
/*     */ 
/*     */ 
/* 154 */             rsp.retcode = 2;
/*     */           }
/*     */           else
/*     */           {
/* 158 */             rsp.retcode = 0;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       else {
/* 164 */         rsp.retcode = 2;
/*     */       }
/*     */     }
/* 167 */     else if (roamType == RoamType.SINGLE_CROSS_FIELD)
/*     */     {
/* 169 */       SingleCrossFieldRoamedContext context = SingleCrossFieldRoamedContextManager.getInstance().getContext(reqData.roam_room_instanceid);
/*     */       
/* 171 */       if (context == null)
/*     */       {
/* 173 */         rsp.retcode = 2;
/*     */ 
/*     */ 
/*     */       }
/* 177 */       else if (saveRoamRoleData(userid, roleid, reqData.xtables))
/*     */       {
/* 179 */         context.setDataPrepared(roleid);
/* 180 */         rsp.retcode = 0;
/*     */       }
/*     */       else
/*     */       {
/* 184 */         rsp.retcode = 2;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 189 */     GameServer.logger().info(String.format("[crossserver]DTH_RoamRoleData.onDataTransferReq@handle roam role data request|req=%s|req_data=%s|rsp=%s", new Object[] { req, reqData, rsp }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 194 */     GHubHelper.sendDataTransferRsp(rsp);
/*     */   }
/*     */   
/*     */   private final boolean saveRoamRoleData(String userid, long roleid, List<Octets> xtables)
/*     */   {
/* 199 */     return (new PCleanRoamRoleData(userid, roleid).call()) && (new PSaveRoamRoleData(userid, roleid, xtables).call());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected void onDataTransferTimeout(DataTransferReqXidWrapper reqXidWrapper, RoamRoleDataReq reqData, int code)
/*     */   {
/* 206 */     RoamRoleDataTransferReqXidWrapper roamRoleDataReqXidWrapper = (RoamRoleDataTransferReqXidWrapper)reqXidWrapper;
/* 207 */     RoamContext context = roamRoleDataReqXidWrapper.getContext();
/*     */     
/* 209 */     GameServer.logger().error(String.format("[crossserver]DTH_RoamRoleData.onDataTransferTimeout@roam role data timeout|req=%s|req_data=%s|code=%d", new Object[] { reqXidWrapper.getProtocol(), reqData, Integer.valueOf(code) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 214 */     RoamRoleDataFail event = new RoamRoleDataFail();
/* 215 */     RoamRoleDataFailArg arg = RoamRoleDataEventCreator.createRoamRoleDataFailArg(context);
/* 216 */     TriggerEventsManger.getInstance().triggerEvent(event, arg);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected void onDataTransferRsp(DataTransferReqXidWrapper reqXidWrapper, RoamRoleDataReq reqData, DataTransferRspXidWrapper rspXidWrapper, RoamRoleDataRsp rspData)
/*     */   {
/* 223 */     RoamRoleDataTransferReqXidWrapper roamRoleDataReqXidWrapper = (RoamRoleDataTransferReqXidWrapper)reqXidWrapper;
/* 224 */     RoamContext context = roamRoleDataReqXidWrapper.getContext();
/* 225 */     DataTransferRsp rsp = rspXidWrapper.getProtocol();
/*     */     
/* 227 */     GameServer.logger().info(String.format("[crossserver]DTH_RoamRoleData.onDataTransferRsp@roam role data done|req=%s|req_data=%s|rsp=%s|rsp_data=%s", new Object[] { reqXidWrapper.getProtocol(), reqData, rspXidWrapper.getProtocol(), rspData }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 232 */     if (rsp.retcode != 0)
/*     */     {
/* 234 */       RoamRoleDataFail event = new RoamRoleDataFail();
/* 235 */       RoamRoleDataFailArg arg = RoamRoleDataEventCreator.createRoamRoleDataFailArg(context);
/* 236 */       TriggerEventsManger.getInstance().triggerEvent(event, arg);
/*     */     }
/*     */     else
/*     */     {
/* 240 */       if (!context.setRoamed(reqData.roleid))
/*     */       {
/* 242 */         return;
/*     */       }
/*     */       
/* 245 */       if (!context.isRoamDone())
/*     */       {
/* 247 */         return;
/*     */       }
/*     */       
/* 250 */       RoamRoleDataSucceed event = new RoamRoleDataSucceed();
/* 251 */       RoamRoleDataSucceedArg arg = RoamRoleDataEventCreator.createRoamRoleDataSucceedArg(context);
/* 252 */       TriggerEventsManger.getInstance().triggerEvent(event, arg);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\DTH_RoamRoleData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */