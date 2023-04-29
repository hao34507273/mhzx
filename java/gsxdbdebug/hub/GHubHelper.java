/*     */ package hub;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.crossserver.main.CrossServerInterface;
/*     */ import mzm.gsp.util.XidProtocolSender;
/*     */ import org.apache.log4j.Logger;
/*     */ import xio.Xio;
/*     */ 
/*     */ 
/*     */ public class GHubHelper
/*     */ {
/*     */   public static void regisGameServer(Xio xio)
/*     */   {
/*  17 */     GHubClientManager mgr = GHubClientManager.getInstance();
/*  18 */     if (mgr == null)
/*     */     {
/*  20 */       return;
/*     */     }
/*     */     
/*  23 */     int zoneid = GameServerInfoManager.getZoneId();
/*  24 */     List<Integer> zoneids = GameServerInfoManager.getZoneIds();
/*  25 */     RegisterGameServerReq req = new RegisterGameServerReq();
/*  26 */     req.serverid = zoneid;
/*  27 */     req.serverids.addAll(zoneids);
/*  28 */     if (!req.send(xio))
/*     */     {
/*  30 */       GameServer.logger().warn(String.format("[hub]GHubHelper.regisGameServer@send register game server request failed|zoneid=%d|zone_ids=%s", new Object[] { Integer.valueOf(zoneid), zoneids.toString() }));
/*     */       
/*     */ 
/*     */ 
/*  34 */       return;
/*     */     }
/*     */     
/*  37 */     GameServer.logger().info(String.format("[hub]GHubHelper.regisGameServer@send register game server request success|zoneid=%d|zone_ids=%s", new Object[] { Integer.valueOf(zoneid), zoneids.toString() }));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void onRegisGameServerRsp(RegisterGameServerRsp rsp)
/*     */   {
/*  45 */     int retcode = GHubClientManager.getInstance().onRegisGameServerRsp(rsp);
/*  46 */     if (retcode == 0)
/*     */     {
/*  48 */       KeepAliveManager.getInstance().addXio(rsp.getConnection());
/*     */     }
/*     */   }
/*     */   
/*     */   public static boolean sendDataTransferRsp(DataTransferRsp rsp)
/*     */   {
/*  54 */     return GHubClientManager.getInstance().send(rsp);
/*     */   }
/*     */   
/*     */   public static boolean sendDataTransferReq(DataTransferReq req, boolean repeatSendOnTimeout)
/*     */   {
/*  59 */     return sendDataTransferReq(req, repeatSendOnTimeout, 0);
/*     */   }
/*     */   
/*     */ 
/*     */   public static boolean sendDataTransferReq(DataTransferReq req, boolean repeatSendOnTimeout, int maxRepeatSendCount)
/*     */   {
/*  65 */     if (req == null)
/*     */     {
/*  67 */       return false;
/*     */     }
/*     */     
/*  70 */     Xio to = GHubClientManager.getInstance().getRouteXio();
/*  71 */     if (to == null)
/*     */     {
/*  73 */       return false;
/*     */     }
/*     */     
/*  76 */     DataTransferReqXidWrapper wrapper = new DataTransferReqXidWrapper(req);
/*  77 */     XidProtocolSender sender = new XidProtocolSender(wrapper, repeatSendOnTimeout, maxRepeatSendCount);
/*     */     
/*  79 */     return sender.send(to);
/*     */   }
/*     */   
/*     */   public static boolean sendDataTransferReq(DataTransferReqXidWrapper reqXidWrapper, boolean repeatSendOnTimeout)
/*     */   {
/*  84 */     return sendDataTransferReq(reqXidWrapper, repeatSendOnTimeout, 0);
/*     */   }
/*     */   
/*     */ 
/*     */   public static boolean sendDataTransferReq(DataTransferReqXidWrapper reqXidWrapper, boolean repeatSendOnTimeout, int maxRepeatSendCount)
/*     */   {
/*  90 */     if (reqXidWrapper == null)
/*     */     {
/*  92 */       return false;
/*     */     }
/*     */     
/*  95 */     DataTransferReq req = reqXidWrapper.getProtocol();
/*  96 */     if (req == null)
/*     */     {
/*  98 */       return false;
/*     */     }
/*     */     
/* 101 */     Xio to = GHubClientManager.getInstance().getRouteXio();
/* 102 */     if (to == null)
/*     */     {
/* 104 */       return false;
/*     */     }
/*     */     
/* 107 */     XidProtocolSender sender = new XidProtocolSender(reqXidWrapper, repeatSendOnTimeout, maxRepeatSendCount);
/*     */     
/* 109 */     return sender.send(to);
/*     */   }
/*     */   
/*     */   public static void onDataTransferReq(DataTransferReq req)
/*     */   {
/* 114 */     CrossServerInterface.onDataTransferReq(req);
/*     */   }
/*     */   
/*     */   public static void onDataTransferRsp(DataTransferRsp rsp)
/*     */   {
/* 119 */     DataTransferRspXidWrapper wrapper = new DataTransferRspXidWrapper(rsp);
/* 120 */     XidProtocolSender.onXidProtocolResponse(wrapper);
/*     */   }
/*     */   
/*     */   public static void broadcast(DataBroadcast broadcast)
/*     */   {
/* 125 */     GHubBroadcastManager.getInstance().broadcast(broadcast);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\GHubHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */