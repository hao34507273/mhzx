/*     */ package mzm.gsp.idip.main;
/*     */ 
/*     */ import idip.DoSendMarqueeReq;
/*     */ import idip.DoSendMarqueeRsp;
/*     */ import idip.IDIPCmd_DoSendMarqueeReq;
/*     */ import idip.IDIPPacket_DoSendMarqueeReq;
/*     */ import idip.IDIPPacket_DoSendMarqueeRsp;
/*     */ import idip.core.IdipHeader;
/*     */ import idip.core.Utils;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServer;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class PIDIPCmd_DoSendMarqueeReq extends PIDIPCmd<IDIPCmd_DoSendMarqueeReq>
/*     */ {
/*     */   public PIDIPCmd_DoSendMarqueeReq(IDIPCmd_DoSendMarqueeReq cmd)
/*     */   {
/*  18 */     super(cmd);
/*     */   }
/*     */   
/*     */   protected boolean handle()
/*     */     throws Exception
/*     */   {
/*  24 */     long indexId = ((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).MarqueeId;
/*  25 */     if (MarqueeIndexCache.getInstance().contains(indexId))
/*     */     {
/*  27 */       ((IDIPPacket_DoSendMarqueeRsp)((IDIPCmd_DoSendMarqueeReq)this.cmd).rsp).head.Result = (((DoSendMarqueeRsp)((IDIPPacket_DoSendMarqueeRsp)((IDIPCmd_DoSendMarqueeReq)this.cmd).rsp).body).Result = 'ﭑ');
/*  28 */       ((IDIPPacket_DoSendMarqueeRsp)((IDIPCmd_DoSendMarqueeReq)this.cmd).rsp).head.RetErrMsg = (((DoSendMarqueeRsp)((IDIPPacket_DoSendMarqueeRsp)((IDIPCmd_DoSendMarqueeReq)this.cmd).rsp).body).RetMsg = "marqueeid duplicate");
/*  29 */       ((IDIPCmd_DoSendMarqueeReq)this.cmd).sendResponse();
/*     */       
/*  31 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoSendMarqueeReq.handle@indexid duplicate|ret=%d|ret_msg=%s|area_id=%d|plat_id=%d|partition=%d|indexId=%d|BeginTime=%d|EndTime=%d|MailTitle=%s|MailContent=%s|Rollfre=%d|Rollnum=%d|Source=%d", new Object[] { Integer.valueOf(((IDIPPacket_DoSendMarqueeRsp)((IDIPCmd_DoSendMarqueeReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoSendMarqueeRsp)((IDIPCmd_DoSendMarqueeReq)this.cmd).rsp).head.RetErrMsg, Integer.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).AreaId), Byte.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).Partition), Long.valueOf(indexId), Long.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).BeginTime), Long.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).EndTime), ((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).MailTitle, ((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).MailContent, Integer.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).Rollfre), Integer.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).Rollnum), Integer.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).Source) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  38 */       return false;
/*     */     }
/*     */     
/*  41 */     if (indexId <= 0L)
/*     */     {
/*  43 */       ((IDIPPacket_DoSendMarqueeRsp)((IDIPCmd_DoSendMarqueeReq)this.cmd).rsp).head.Result = (((DoSendMarqueeRsp)((IDIPPacket_DoSendMarqueeRsp)((IDIPCmd_DoSendMarqueeReq)this.cmd).rsp).body).Result = 1);
/*  44 */       ((IDIPPacket_DoSendMarqueeRsp)((IDIPCmd_DoSendMarqueeReq)this.cmd).rsp).head.RetErrMsg = (((DoSendMarqueeRsp)((IDIPPacket_DoSendMarqueeRsp)((IDIPCmd_DoSendMarqueeReq)this.cmd).rsp).body).RetMsg = "marqueeid <= 0");
/*  45 */       ((IDIPCmd_DoSendMarqueeReq)this.cmd).sendResponse();
/*     */       
/*  47 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoSendMarqueeReq.handle@indexid <= 0|ret=%d|ret_msg=%s|area_id=%d|plat_id=%d|partition=%d|indexId=%d|BeginTime=%d|EndTime=%d|MailTitle=%s|MailContent=%s|Rollfre=%d|Rollnum=%d|Source=%d", new Object[] { Integer.valueOf(((IDIPPacket_DoSendMarqueeRsp)((IDIPCmd_DoSendMarqueeReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoSendMarqueeRsp)((IDIPCmd_DoSendMarqueeReq)this.cmd).rsp).head.RetErrMsg, Integer.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).AreaId), Byte.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).Partition), Long.valueOf(indexId), Long.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).BeginTime), Long.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).EndTime), ((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).MailTitle, ((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).MailContent, Integer.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).Rollfre), Integer.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).Rollnum), Integer.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).Source) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  54 */       return false;
/*     */     }
/*     */     
/*  57 */     long beginTime = TimeUnit.SECONDS.toMillis(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).BeginTime);
/*  58 */     if (beginTime < 0L)
/*     */     {
/*  60 */       ((IDIPPacket_DoSendMarqueeRsp)((IDIPCmd_DoSendMarqueeReq)this.cmd).rsp).head.Result = (((DoSendMarqueeRsp)((IDIPPacket_DoSendMarqueeRsp)((IDIPCmd_DoSendMarqueeReq)this.cmd).rsp).body).Result = 'ﭚ');
/*  61 */       ((IDIPPacket_DoSendMarqueeRsp)((IDIPCmd_DoSendMarqueeReq)this.cmd).rsp).head.RetErrMsg = (((DoSendMarqueeRsp)((IDIPPacket_DoSendMarqueeRsp)((IDIPCmd_DoSendMarqueeReq)this.cmd).rsp).body).RetMsg = "begin time < 0");
/*  62 */       ((IDIPCmd_DoSendMarqueeReq)this.cmd).sendResponse();
/*     */       
/*  64 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoSendMarqueeReq.handle@begin time < 0|ret=%d|ret_msg=%s|area_id=%d|plat_id=%d|partition=%d|indexId=%d|BeginTime=%d|EndTime=%d|MailTitle=%s|MailContent=%s|Rollfre=%d|Rollnum=%d|Source=%d", new Object[] { Integer.valueOf(((IDIPPacket_DoSendMarqueeRsp)((IDIPCmd_DoSendMarqueeReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoSendMarqueeRsp)((IDIPCmd_DoSendMarqueeReq)this.cmd).rsp).head.RetErrMsg, Integer.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).AreaId), Byte.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).Partition), Long.valueOf(indexId), Long.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).BeginTime), Long.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).EndTime), ((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).MailTitle, ((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).MailContent, Integer.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).Rollfre), Integer.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).Rollnum), Integer.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).Source) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  71 */       return false;
/*     */     }
/*     */     
/*  74 */     long endTime = TimeUnit.SECONDS.toMillis(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).EndTime);
/*  75 */     long now = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/*  76 */     if (endTime <= now)
/*     */     {
/*  78 */       ((IDIPPacket_DoSendMarqueeRsp)((IDIPCmd_DoSendMarqueeReq)this.cmd).rsp).head.Result = (((DoSendMarqueeRsp)((IDIPPacket_DoSendMarqueeRsp)((IDIPCmd_DoSendMarqueeReq)this.cmd).rsp).body).Result = 'ﭙ');
/*  79 */       ((IDIPPacket_DoSendMarqueeRsp)((IDIPCmd_DoSendMarqueeReq)this.cmd).rsp).head.RetErrMsg = (((DoSendMarqueeRsp)((IDIPPacket_DoSendMarqueeRsp)((IDIPCmd_DoSendMarqueeReq)this.cmd).rsp).body).RetMsg = "end time <= now");
/*  80 */       ((IDIPCmd_DoSendMarqueeReq)this.cmd).sendResponse();
/*     */       
/*  82 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoSendMarqueeReq.handle@end time <= now|ret=%d|ret_msg=%s|area_id=%d|plat_id=%d|partition=%d|indexId=%d|BeginTime=%d|EndTime=%d|MailTitle=%s|MailContent=%s|Rollfre=%d|Rollnum=%d|Source=%d", new Object[] { Integer.valueOf(((IDIPPacket_DoSendMarqueeRsp)((IDIPCmd_DoSendMarqueeReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoSendMarqueeRsp)((IDIPCmd_DoSendMarqueeReq)this.cmd).rsp).head.RetErrMsg, Integer.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).AreaId), Byte.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).Partition), Long.valueOf(indexId), Long.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).BeginTime), Long.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).EndTime), ((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).MailTitle, ((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).MailContent, Integer.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).Rollfre), Integer.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).Rollnum), Integer.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).Source) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  89 */       return false;
/*     */     }
/*     */     
/*  92 */     if (beginTime >= endTime)
/*     */     {
/*  94 */       ((IDIPPacket_DoSendMarqueeRsp)((IDIPCmd_DoSendMarqueeReq)this.cmd).rsp).head.Result = (((DoSendMarqueeRsp)((IDIPPacket_DoSendMarqueeRsp)((IDIPCmd_DoSendMarqueeReq)this.cmd).rsp).body).Result = 'ﭘ');
/*  95 */       ((IDIPPacket_DoSendMarqueeRsp)((IDIPCmd_DoSendMarqueeReq)this.cmd).rsp).head.RetErrMsg = (((DoSendMarqueeRsp)((IDIPPacket_DoSendMarqueeRsp)((IDIPCmd_DoSendMarqueeReq)this.cmd).rsp).body).RetMsg = "begin time >= end time");
/*  96 */       ((IDIPCmd_DoSendMarqueeReq)this.cmd).sendResponse();
/*     */       
/*  98 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoSendMarqueeReq.handle@begin time >= end time|ret=%d|ret_msg=%s|area_id=%d|plat_id=%d|partition=%d|indexId=%d|BeginTime=%d|EndTime=%d|MailTitle=%s|MailContent=%s|Rollfre=%d|Rollnum=%d|Source=%d", new Object[] { Integer.valueOf(((IDIPPacket_DoSendMarqueeRsp)((IDIPCmd_DoSendMarqueeReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoSendMarqueeRsp)((IDIPCmd_DoSendMarqueeReq)this.cmd).rsp).head.RetErrMsg, Integer.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).AreaId), Byte.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).Partition), Long.valueOf(indexId), Long.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).BeginTime), Long.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).EndTime), ((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).MailTitle, ((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).MailContent, Integer.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).Rollfre), Integer.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).Rollnum), Integer.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).Source) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 105 */       return false;
/*     */     }
/*     */     
/* 108 */     String mailTitle = Utils.urlDecode1738(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).MailTitle);
/* 109 */     if (mailTitle.isEmpty())
/*     */     {
/* 111 */       ((IDIPPacket_DoSendMarqueeRsp)((IDIPCmd_DoSendMarqueeReq)this.cmd).rsp).head.Result = (((DoSendMarqueeRsp)((IDIPPacket_DoSendMarqueeRsp)((IDIPCmd_DoSendMarqueeReq)this.cmd).rsp).body).Result = 'ﭗ');
/* 112 */       ((IDIPPacket_DoSendMarqueeRsp)((IDIPCmd_DoSendMarqueeReq)this.cmd).rsp).head.RetErrMsg = (((DoSendMarqueeRsp)((IDIPPacket_DoSendMarqueeRsp)((IDIPCmd_DoSendMarqueeReq)this.cmd).rsp).body).RetMsg = "mail title is empty");
/* 113 */       ((IDIPCmd_DoSendMarqueeReq)this.cmd).sendResponse();
/*     */       
/* 115 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoSendMarqueeReq.handle@mail title is empty|ret=%d|ret_msg=%s|area_id=%d|plat_id=%d|partition=%d|indexId=%d|BeginTime=%d|EndTime=%d|MailTitle=%s|MailContent=%s|Rollfre=%d|Rollnum=%d|Source=%d", new Object[] { Integer.valueOf(((IDIPPacket_DoSendMarqueeRsp)((IDIPCmd_DoSendMarqueeReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoSendMarqueeRsp)((IDIPCmd_DoSendMarqueeReq)this.cmd).rsp).head.RetErrMsg, Integer.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).AreaId), Byte.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).Partition), Long.valueOf(indexId), Long.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).BeginTime), Long.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).EndTime), ((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).MailTitle, ((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).MailContent, Integer.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).Rollfre), Integer.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).Rollnum), Integer.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).Source) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 122 */       return false;
/*     */     }
/* 124 */     if (mailTitle.length() > 120)
/*     */     {
/* 126 */       ((IDIPPacket_DoSendMarqueeRsp)((IDIPCmd_DoSendMarqueeReq)this.cmd).rsp).head.Result = (((DoSendMarqueeRsp)((IDIPPacket_DoSendMarqueeRsp)((IDIPCmd_DoSendMarqueeReq)this.cmd).rsp).body).Result = 'ﭗ');
/* 127 */       ((IDIPPacket_DoSendMarqueeRsp)((IDIPCmd_DoSendMarqueeReq)this.cmd).rsp).head.RetErrMsg = (((DoSendMarqueeRsp)((IDIPPacket_DoSendMarqueeRsp)((IDIPCmd_DoSendMarqueeReq)this.cmd).rsp).body).RetMsg = String.format("mail title length > %d", new Object[] { Integer.valueOf(120) }));
/*     */       
/* 129 */       ((IDIPCmd_DoSendMarqueeReq)this.cmd).sendResponse();
/*     */       
/* 131 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoSendMarqueeReq.handle@mail title length > MAX_MAILTITLE_LEN|ret=%d|ret_msg=%s|area_id=%d|plat_id=%d|partition=%d|indexId=%d|BeginTime=%d|EndTime=%d|MailTitle=%s|MailContent=%s|Rollfre=%d|Rollnum=%d|Source=%d", new Object[] { Integer.valueOf(((IDIPPacket_DoSendMarqueeRsp)((IDIPCmd_DoSendMarqueeReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoSendMarqueeRsp)((IDIPCmd_DoSendMarqueeReq)this.cmd).rsp).head.RetErrMsg, Integer.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).AreaId), Byte.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).Partition), Long.valueOf(indexId), Long.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).BeginTime), Long.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).EndTime), ((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).MailTitle, ((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).MailContent, Integer.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).Rollfre), Integer.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).Rollnum), Integer.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).Source) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 138 */       return false;
/*     */     }
/*     */     
/* 141 */     String mailContent = Utils.urlDecode1738(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).MailContent);
/* 142 */     if (mailContent.isEmpty())
/*     */     {
/* 144 */       ((IDIPPacket_DoSendMarqueeRsp)((IDIPCmd_DoSendMarqueeReq)this.cmd).rsp).head.Result = (((DoSendMarqueeRsp)((IDIPPacket_DoSendMarqueeRsp)((IDIPCmd_DoSendMarqueeReq)this.cmd).rsp).body).Result = 'ﭖ');
/* 145 */       ((IDIPPacket_DoSendMarqueeRsp)((IDIPCmd_DoSendMarqueeReq)this.cmd).rsp).head.RetErrMsg = (((DoSendMarqueeRsp)((IDIPPacket_DoSendMarqueeRsp)((IDIPCmd_DoSendMarqueeReq)this.cmd).rsp).body).RetMsg = "mail content is empty");
/* 146 */       ((IDIPCmd_DoSendMarqueeReq)this.cmd).sendResponse();
/*     */       
/* 148 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoSendMarqueeReq.handle@mail content is empty|ret=%d|ret_msg=%s|area_id=%d|plat_id=%d|partition=%d|indexId=%d|BeginTime=%d|EndTime=%d|MailTitle=%s|MailContent=%s|Rollfre=%d|Rollnum=%d|Source=%d", new Object[] { Integer.valueOf(((IDIPPacket_DoSendMarqueeRsp)((IDIPCmd_DoSendMarqueeReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoSendMarqueeRsp)((IDIPCmd_DoSendMarqueeReq)this.cmd).rsp).head.RetErrMsg, Integer.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).AreaId), Byte.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).Partition), Long.valueOf(indexId), Long.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).BeginTime), Long.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).EndTime), ((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).MailTitle, ((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).MailContent, Integer.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).Rollfre), Integer.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).Rollnum), Integer.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).Source) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 155 */       return false;
/*     */     }
/* 157 */     if (mailContent.length() > 3200)
/*     */     {
/* 159 */       ((IDIPPacket_DoSendMarqueeRsp)((IDIPCmd_DoSendMarqueeReq)this.cmd).rsp).head.Result = (((DoSendMarqueeRsp)((IDIPPacket_DoSendMarqueeRsp)((IDIPCmd_DoSendMarqueeReq)this.cmd).rsp).body).Result = 'ﭖ');
/* 160 */       ((IDIPPacket_DoSendMarqueeRsp)((IDIPCmd_DoSendMarqueeReq)this.cmd).rsp).head.RetErrMsg = (((DoSendMarqueeRsp)((IDIPPacket_DoSendMarqueeRsp)((IDIPCmd_DoSendMarqueeReq)this.cmd).rsp).body).RetMsg = String.format("mail content length > %d", new Object[] { Integer.valueOf(3200) }));
/*     */       
/* 162 */       ((IDIPCmd_DoSendMarqueeReq)this.cmd).sendResponse();
/*     */       
/* 164 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoSendMarqueeReq.handle@mail content length > MAX_MAILCONTENT_LEN|ret=%d|ret_msg=%s|area_id=%d|plat_id=%d|partition=%d|indexId=%d|BeginTime=%d|EndTime=%d|MailTitle=%s|MailContent=%s|Rollfre=%d|Rollnum=%d|Source=%d", new Object[] { Integer.valueOf(((IDIPPacket_DoSendMarqueeRsp)((IDIPCmd_DoSendMarqueeReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoSendMarqueeRsp)((IDIPCmd_DoSendMarqueeReq)this.cmd).rsp).head.RetErrMsg, Integer.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).AreaId), Byte.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).Partition), Long.valueOf(indexId), Long.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).BeginTime), Long.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).EndTime), ((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).MailTitle, ((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).MailContent, Integer.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).Rollfre), Integer.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).Rollnum), Integer.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).Source) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 171 */       return false;
/*     */     }
/*     */     
/* 174 */     int rollfre = ((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).Rollfre;
/* 175 */     if (rollfre <= 0)
/*     */     {
/* 177 */       ((IDIPPacket_DoSendMarqueeRsp)((IDIPCmd_DoSendMarqueeReq)this.cmd).rsp).head.Result = (((DoSendMarqueeRsp)((IDIPPacket_DoSendMarqueeRsp)((IDIPCmd_DoSendMarqueeReq)this.cmd).rsp).body).Result = 'ﭕ');
/* 178 */       ((IDIPPacket_DoSendMarqueeRsp)((IDIPCmd_DoSendMarqueeReq)this.cmd).rsp).head.RetErrMsg = (((DoSendMarqueeRsp)((IDIPPacket_DoSendMarqueeRsp)((IDIPCmd_DoSendMarqueeReq)this.cmd).rsp).body).RetMsg = "rollfre <= 0");
/* 179 */       ((IDIPCmd_DoSendMarqueeReq)this.cmd).sendResponse();
/*     */       
/* 181 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoSendMarqueeReq.handle@rollfre <= 0|ret=%d|ret_msg=%s|area_id=%d|plat_id=%d|partition=%d|indexId=%d|BeginTime=%d|EndTime=%d|MailTitle=%s|MailContent=%s|Rollfre=%d|Rollnum=%d|Source=%d", new Object[] { Integer.valueOf(((IDIPPacket_DoSendMarqueeRsp)((IDIPCmd_DoSendMarqueeReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoSendMarqueeRsp)((IDIPCmd_DoSendMarqueeReq)this.cmd).rsp).head.RetErrMsg, Integer.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).AreaId), Byte.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).Partition), Long.valueOf(indexId), Long.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).BeginTime), Long.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).EndTime), ((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).MailTitle, ((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).MailContent, Integer.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).Rollfre), Integer.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).Rollnum), Integer.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).Source) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 188 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 192 */     int rollNum = ((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).Rollnum;
/* 193 */     if ((rollNum == 0) || (rollNum < -1))
/*     */     {
/* 195 */       ((IDIPPacket_DoSendMarqueeRsp)((IDIPCmd_DoSendMarqueeReq)this.cmd).rsp).head.Result = (((DoSendMarqueeRsp)((IDIPPacket_DoSendMarqueeRsp)((IDIPCmd_DoSendMarqueeReq)this.cmd).rsp).body).Result = 'ﭔ');
/* 196 */       ((IDIPPacket_DoSendMarqueeRsp)((IDIPCmd_DoSendMarqueeReq)this.cmd).rsp).head.RetErrMsg = (((DoSendMarqueeRsp)((IDIPPacket_DoSendMarqueeRsp)((IDIPCmd_DoSendMarqueeReq)this.cmd).rsp).body).RetMsg = "rollNum invalid");
/* 197 */       ((IDIPCmd_DoSendMarqueeReq)this.cmd).sendResponse();
/*     */       
/* 199 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoSendMarqueeReq.handle@rollNum == 0 OR rollNum < -1|ret=%d|ret_msg=%s|area_id=%d|plat_id=%d|partition=%d|indexId=%d|BeginTime=%d|EndTime=%d|MailTitle=%s|MailContent=%s|Rollfre=%d|Rollnum=%d|Source=%d", new Object[] { Integer.valueOf(((IDIPPacket_DoSendMarqueeRsp)((IDIPCmd_DoSendMarqueeReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoSendMarqueeRsp)((IDIPCmd_DoSendMarqueeReq)this.cmd).rsp).head.RetErrMsg, Integer.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).AreaId), Byte.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).Partition), Long.valueOf(indexId), Long.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).BeginTime), Long.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).EndTime), ((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).MailTitle, ((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).MailContent, Integer.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).Rollfre), Integer.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).Rollnum), Integer.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).Source) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 206 */       return false;
/*     */     }
/*     */     
/* 209 */     MarqueeDataInfo marquee = new MarqueeDataInfo(beginTime, endTime, mailTitle, mailContent, rollfre, rollNum, indexId);
/*     */     
/* 211 */     MarqueeManager.addMarquee(marquee);
/*     */     
/* 213 */     String retDesc = "";
/* 214 */     if (beginTime <= now)
/*     */     {
/* 216 */       retDesc = Utils.urlEncode1738("跑马灯已经生效", "UTF-8");
/*     */     }
/*     */     else
/*     */     {
/* 220 */       retDesc = Utils.urlEncode1738(String.format("跑马灯将于%s生效，现在时间%s", new Object[] { mzm.gsp.util.DateTimeUtils.formatTimestamp(beginTime), mzm.gsp.util.DateTimeUtils.formatTimestamp(now) }), "UTF-8");
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 225 */     ((IDIPPacket_DoSendMarqueeRsp)((IDIPCmd_DoSendMarqueeReq)this.cmd).rsp).head.Result = (((DoSendMarqueeRsp)((IDIPPacket_DoSendMarqueeRsp)((IDIPCmd_DoSendMarqueeReq)this.cmd).rsp).body).Result = 0);
/* 226 */     ((IDIPPacket_DoSendMarqueeRsp)((IDIPCmd_DoSendMarqueeReq)this.cmd).rsp).head.RetErrMsg = (((DoSendMarqueeRsp)((IDIPPacket_DoSendMarqueeRsp)((IDIPCmd_DoSendMarqueeReq)this.cmd).rsp).body).RetMsg = retDesc);
/* 227 */     ((DoSendMarqueeRsp)((IDIPPacket_DoSendMarqueeRsp)((IDIPCmd_DoSendMarqueeReq)this.cmd).rsp).body).MarqueeId = indexId;
/* 228 */     ((IDIPCmd_DoSendMarqueeReq)this.cmd).sendResponse();
/*     */     
/* 230 */     GameServer.logger().info(String.format("[idip]PIDIPCmd_DoSendMarqueeReq.handle@do send marquee done|ret=%d|ret_msg=%s|area_id=%d|plat_id=%d|partition=%d|Source=%d|indexId=%d|BeginTime=%d|EndTime=%d|MailTitle=%s|MailContent=%s|Rollfre=%d|Rollnum=%d|marqueeId=%d", new Object[] { Integer.valueOf(((IDIPPacket_DoSendMarqueeRsp)((IDIPCmd_DoSendMarqueeReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoSendMarqueeRsp)((IDIPCmd_DoSendMarqueeReq)this.cmd).rsp).head.RetErrMsg, Integer.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).AreaId), Byte.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).Partition), Integer.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).Source), Long.valueOf(indexId), Long.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).BeginTime), Long.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).EndTime), ((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).MailTitle, ((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).MailContent, Integer.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).Rollfre), Integer.valueOf(((DoSendMarqueeReq)((IDIPPacket_DoSendMarqueeReq)((IDIPCmd_DoSendMarqueeReq)this.cmd).req).body).Rollnum), Long.valueOf(marquee.getMarqueeId()) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 239 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean isGameServerLevelCommand()
/*     */   {
/* 245 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PIDIPCmd_DoSendMarqueeReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */