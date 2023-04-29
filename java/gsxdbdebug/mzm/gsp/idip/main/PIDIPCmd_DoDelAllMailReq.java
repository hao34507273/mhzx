/*     */ package mzm.gsp.idip.main;
/*     */ 
/*     */ import idip.DoDelAllMailReq;
/*     */ import idip.DoDelAllMailRsp;
/*     */ import idip.IDIPCmd_DoDelAllMailReq;
/*     */ import idip.IDIPPacket_DoDelAllMailReq;
/*     */ import idip.IDIPPacket_DoDelAllMailRsp;
/*     */ import idip.core.IdipHeader;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.compensate.main.CompensateInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class PIDIPCmd_DoDelAllMailReq extends PIDIPCmd<IDIPCmd_DoDelAllMailReq>
/*     */ {
/*     */   public PIDIPCmd_DoDelAllMailReq(IDIPCmd_DoDelAllMailReq cmd)
/*     */   {
/*  18 */     super(cmd);
/*     */   }
/*     */   
/*     */   protected boolean handle()
/*     */     throws Exception
/*     */   {
/*  24 */     int tagid = ((DoDelAllMailReq)((IDIPPacket_DoDelAllMailReq)((IDIPCmd_DoDelAllMailReq)this.cmd).req).body).TagId;
/*  25 */     String mailid = ((DoDelAllMailReq)((IDIPPacket_DoDelAllMailReq)((IDIPCmd_DoDelAllMailReq)this.cmd).req).body).MailId;
/*  26 */     if ((tagid <= 0) && (mailid.isEmpty()))
/*     */     {
/*  28 */       ((IDIPPacket_DoDelAllMailRsp)((IDIPCmd_DoDelAllMailReq)this.cmd).rsp).head.Result = (((DoDelAllMailRsp)((IDIPPacket_DoDelAllMailRsp)((IDIPCmd_DoDelAllMailReq)this.cmd).rsp).body).Result = '器');
/*  29 */       ((IDIPPacket_DoDelAllMailRsp)((IDIPCmd_DoDelAllMailReq)this.cmd).rsp).head.RetErrMsg = (((DoDelAllMailRsp)((IDIPPacket_DoDelAllMailRsp)((IDIPCmd_DoDelAllMailReq)this.cmd).rsp).body).RetMsg = "params invalid");
/*  30 */       ((IDIPCmd_DoDelAllMailReq)this.cmd).sendResponse();
/*     */       
/*  32 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_QueryAllPrizeReq.handle@params invalid|ret=%d|ret_msg=%s|area_id=%d|plat_id=%d|partition=%d|tagid=%d|mailid=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoDelAllMailRsp)((IDIPCmd_DoDelAllMailReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoDelAllMailRsp)((IDIPCmd_DoDelAllMailReq)this.cmd).rsp).head.RetErrMsg, Integer.valueOf(((DoDelAllMailReq)((IDIPPacket_DoDelAllMailReq)((IDIPCmd_DoDelAllMailReq)this.cmd).req).body).AreaId), Byte.valueOf(((DoDelAllMailReq)((IDIPPacket_DoDelAllMailReq)((IDIPCmd_DoDelAllMailReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoDelAllMailReq)((IDIPPacket_DoDelAllMailReq)((IDIPCmd_DoDelAllMailReq)this.cmd).req).body).Partition), Integer.valueOf(tagid), mailid }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  37 */       return false;
/*     */     }
/*     */     
/*  40 */     boolean result = false;
/*  41 */     if (mailid.isEmpty())
/*     */     {
/*  43 */       result = CompensateInterface.removeCompensate(tagid);
/*     */     }
/*     */     else
/*     */     {
/*  47 */       long id = 0L;
/*     */       try
/*     */       {
/*  50 */         id = Long.parseLong(mailid);
/*  51 */         result = CompensateInterface.removeCompensate(id, tagid);
/*     */       }
/*     */       catch (NumberFormatException e) {}
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  59 */     if (!result)
/*     */     {
/*  61 */       ((IDIPPacket_DoDelAllMailRsp)((IDIPCmd_DoDelAllMailReq)this.cmd).rsp).head.Result = (((DoDelAllMailRsp)((IDIPPacket_DoDelAllMailRsp)((IDIPCmd_DoDelAllMailReq)this.cmd).rsp).body).Result = '嘆');
/*  62 */       ((IDIPPacket_DoDelAllMailRsp)((IDIPCmd_DoDelAllMailReq)this.cmd).rsp).head.RetErrMsg = (((DoDelAllMailRsp)((IDIPPacket_DoDelAllMailRsp)((IDIPCmd_DoDelAllMailReq)this.cmd).rsp).body).RetMsg = "del failed");
/*  63 */       ((IDIPCmd_DoDelAllMailReq)this.cmd).sendResponse();
/*     */       
/*  65 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_QueryAllPrizeReq.handle@del failed|ret=%d|ret_msg=%s|area_id=%d|plat_id=%d|partition=%d|tagid=%d|mailid=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoDelAllMailRsp)((IDIPCmd_DoDelAllMailReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoDelAllMailRsp)((IDIPCmd_DoDelAllMailReq)this.cmd).rsp).head.RetErrMsg, Integer.valueOf(((DoDelAllMailReq)((IDIPPacket_DoDelAllMailReq)((IDIPCmd_DoDelAllMailReq)this.cmd).req).body).AreaId), Byte.valueOf(((DoDelAllMailReq)((IDIPPacket_DoDelAllMailReq)((IDIPCmd_DoDelAllMailReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoDelAllMailReq)((IDIPPacket_DoDelAllMailReq)((IDIPCmd_DoDelAllMailReq)this.cmd).req).body).Partition), Integer.valueOf(tagid), mailid }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  70 */       return false;
/*     */     }
/*     */     
/*  73 */     ((IDIPPacket_DoDelAllMailRsp)((IDIPCmd_DoDelAllMailReq)this.cmd).rsp).head.Result = (((DoDelAllMailRsp)((IDIPPacket_DoDelAllMailRsp)((IDIPCmd_DoDelAllMailReq)this.cmd).rsp).body).Result = 0);
/*  74 */     ((IDIPPacket_DoDelAllMailRsp)((IDIPCmd_DoDelAllMailReq)this.cmd).rsp).head.RetErrMsg = (((DoDelAllMailRsp)((IDIPPacket_DoDelAllMailRsp)((IDIPCmd_DoDelAllMailReq)this.cmd).rsp).body).RetMsg = "ok");
/*  75 */     ((IDIPCmd_DoDelAllMailReq)this.cmd).sendResponse();
/*     */     
/*  77 */     addTLog();
/*     */     
/*  79 */     GameServer.logger().info(String.format("[idip]PIDIPCmd_QueryAllPrizeReq.handle@do del mail done|ret=%d|ret_msg=%s|area_id=%d|plat_id=%d|partition=%d|tagid=%d|mailid=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoDelAllMailRsp)((IDIPCmd_DoDelAllMailReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoDelAllMailRsp)((IDIPCmd_DoDelAllMailReq)this.cmd).rsp).head.RetErrMsg, Integer.valueOf(((DoDelAllMailReq)((IDIPPacket_DoDelAllMailReq)((IDIPCmd_DoDelAllMailReq)this.cmd).req).body).AreaId), Byte.valueOf(((DoDelAllMailReq)((IDIPPacket_DoDelAllMailReq)((IDIPCmd_DoDelAllMailReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoDelAllMailReq)((IDIPPacket_DoDelAllMailReq)((IDIPCmd_DoDelAllMailReq)this.cmd).req).body).Partition), Integer.valueOf(tagid), mailid }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  84 */     return true;
/*     */   }
/*     */   
/*     */   private void addTLog()
/*     */   {
/*  89 */     String GameSvrId = String.valueOf(GameServerInfoManager.getZoneId());
/*  90 */     java.text.SimpleDateFormat sdf = mzm.gsp.util.DateTimeUtils.getSimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/*  91 */     long time = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/*  92 */     String dtEventTime = sdf.format(Long.valueOf(time));
/*     */     
/*  94 */     String vGameAppid = "0";
/*  95 */     int PlatID = -1;
/*  96 */     int iZoneAreaID = GameServerInfoManager.getZoneId();
/*  97 */     String vopenid = "0";
/*     */     
/*  99 */     StringBuffer sb = new StringBuffer();
/* 100 */     sb.append(GameSvrId).append('|');
/* 101 */     sb.append(dtEventTime).append('|');
/* 102 */     sb.append("0").append('|');
/* 103 */     sb.append(-1).append('|');
/* 104 */     sb.append(iZoneAreaID).append('|');
/* 105 */     sb.append("0").append('|');
/*     */     
/* 107 */     sb.append(((DoDelAllMailReq)((IDIPPacket_DoDelAllMailReq)((IDIPCmd_DoDelAllMailReq)this.cmd).req).body).TagId).append('|');
/* 108 */     sb.append(((DoDelAllMailReq)((IDIPPacket_DoDelAllMailReq)((IDIPCmd_DoDelAllMailReq)this.cmd).req).body).MailId);
/*     */     
/* 110 */     mzm.gsp.tlog.TLogManager.getInstance().addLog("DelWholeGiftMailForServer", sb.toString());
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean isGameServerLevelCommand()
/*     */   {
/* 116 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PIDIPCmd_DoDelAllMailReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */