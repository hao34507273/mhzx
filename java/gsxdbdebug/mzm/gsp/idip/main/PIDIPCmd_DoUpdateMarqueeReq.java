/*     */ package mzm.gsp.idip.main;
/*     */ 
/*     */ import idip.DoUpdateMarqueeReq;
/*     */ import idip.DoUpdateMarqueeRsp;
/*     */ import idip.IDIPCmd_DoUpdateMarqueeReq;
/*     */ import idip.IDIPPacket_DoUpdateMarqueeReq;
/*     */ import idip.IDIPPacket_DoUpdateMarqueeRsp;
/*     */ import idip.core.IdipHeader;
/*     */ import idip.core.Utils;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServer;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class PIDIPCmd_DoUpdateMarqueeReq extends PIDIPCmd<IDIPCmd_DoUpdateMarqueeReq>
/*     */ {
/*     */   public PIDIPCmd_DoUpdateMarqueeReq(IDIPCmd_DoUpdateMarqueeReq cmd)
/*     */   {
/*  18 */     super(cmd);
/*     */   }
/*     */   
/*     */   protected boolean handle()
/*     */     throws Exception
/*     */   {
/*  24 */     long beginTime = TimeUnit.SECONDS.toMillis(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).BeginTime);
/*  25 */     if (beginTime < 0L)
/*     */     {
/*  27 */       ((IDIPPacket_DoUpdateMarqueeRsp)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).rsp).head.Result = (((DoUpdateMarqueeRsp)((IDIPPacket_DoUpdateMarqueeRsp)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).rsp).body).Result = 'ﭚ');
/*  28 */       ((IDIPPacket_DoUpdateMarqueeRsp)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).rsp).head.RetErrMsg = (((DoUpdateMarqueeRsp)((IDIPPacket_DoUpdateMarqueeRsp)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).rsp).body).RetMsg = "begin time < 0");
/*  29 */       ((IDIPCmd_DoUpdateMarqueeReq)this.cmd).sendResponse();
/*     */       
/*  31 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoUpdateMarqueeReq.handle@begin time < 0|ret=%d|ret_msg=%s|area_id=%d|plat_id=%d|partition=%d|Source=%d|BeginTime=%d|EndTime=%d|MailTitle=%s|MailContent=%s|Rollfre=%d|Rollnum=%d|index_id=%d", new Object[] { Integer.valueOf(((IDIPPacket_DoUpdateMarqueeRsp)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoUpdateMarqueeRsp)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).rsp).head.RetErrMsg, Integer.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).AreaId), Byte.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).Partition), Integer.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).Source), Long.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).BeginTime), Long.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).EndTime), ((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).MailTitle, ((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).MailContent, Integer.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).Rollfre), Integer.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).Rollnum), Long.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).MarqueeId) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  39 */       return false;
/*     */     }
/*     */     
/*  42 */     long endTime = TimeUnit.SECONDS.toMillis(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).EndTime);
/*  43 */     long now = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/*  44 */     if (endTime <= now)
/*     */     {
/*  46 */       ((IDIPPacket_DoUpdateMarqueeRsp)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).rsp).head.Result = (((DoUpdateMarqueeRsp)((IDIPPacket_DoUpdateMarqueeRsp)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).rsp).body).Result = 'ﭙ');
/*  47 */       ((IDIPPacket_DoUpdateMarqueeRsp)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).rsp).head.RetErrMsg = (((DoUpdateMarqueeRsp)((IDIPPacket_DoUpdateMarqueeRsp)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).rsp).body).RetMsg = "end time <= now");
/*  48 */       ((IDIPCmd_DoUpdateMarqueeReq)this.cmd).sendResponse();
/*     */       
/*  50 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoUpdateMarqueeReq.handle@end time <= now|ret=%d|ret_msg=%s|area_id=%d|plat_id=%d|partition=%d|Source=%d|BeginTime=%d|EndTime=%d|MailTitle=%s|MailContent=%s|Rollfre=%d|Rollnum=%d|index_id=%d", new Object[] { Integer.valueOf(((IDIPPacket_DoUpdateMarqueeRsp)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoUpdateMarqueeRsp)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).rsp).head.RetErrMsg, Integer.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).AreaId), Byte.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).Partition), Integer.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).Source), Long.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).BeginTime), Long.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).EndTime), ((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).MailTitle, ((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).MailContent, Integer.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).Rollfre), Integer.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).Rollnum), Long.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).MarqueeId) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  58 */       return false;
/*     */     }
/*     */     
/*  61 */     if (beginTime >= endTime)
/*     */     {
/*  63 */       ((IDIPPacket_DoUpdateMarqueeRsp)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).rsp).head.Result = (((DoUpdateMarqueeRsp)((IDIPPacket_DoUpdateMarqueeRsp)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).rsp).body).Result = 'ﭘ');
/*  64 */       ((IDIPPacket_DoUpdateMarqueeRsp)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).rsp).head.RetErrMsg = (((DoUpdateMarqueeRsp)((IDIPPacket_DoUpdateMarqueeRsp)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).rsp).body).RetMsg = "begin time >= end time");
/*  65 */       ((IDIPCmd_DoUpdateMarqueeReq)this.cmd).sendResponse();
/*     */       
/*  67 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoUpdateMarqueeReq.handle@begin time >= end time|ret=%d|ret_msg=%s|area_id=%d|plat_id=%d|partition=%d|Source=%d|BeginTime=%d|EndTime=%d|MailTitle=%s|MailContent=%s|Rollfre=%d|Rollnum=%d|index_id=%d", new Object[] { Integer.valueOf(((IDIPPacket_DoUpdateMarqueeRsp)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoUpdateMarqueeRsp)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).rsp).head.RetErrMsg, Integer.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).AreaId), Byte.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).Partition), Integer.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).Source), Long.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).BeginTime), Long.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).EndTime), ((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).MailTitle, ((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).MailContent, Integer.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).Rollfre), Integer.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).Rollnum), Long.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).MarqueeId) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  75 */       return false;
/*     */     }
/*     */     
/*  78 */     String mailTitle = Utils.urlDecode1738(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).MailTitle);
/*  79 */     if (mailTitle.isEmpty())
/*     */     {
/*  81 */       ((IDIPPacket_DoUpdateMarqueeRsp)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).rsp).head.Result = (((DoUpdateMarqueeRsp)((IDIPPacket_DoUpdateMarqueeRsp)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).rsp).body).Result = 'ﭗ');
/*  82 */       ((IDIPPacket_DoUpdateMarqueeRsp)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).rsp).head.RetErrMsg = (((DoUpdateMarqueeRsp)((IDIPPacket_DoUpdateMarqueeRsp)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).rsp).body).RetMsg = "mail title is empty");
/*  83 */       ((IDIPCmd_DoUpdateMarqueeReq)this.cmd).sendResponse();
/*     */       
/*  85 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoUpdateMarqueeReq.handle@mail title is empty|ret=%d|ret_msg=%s|area_id=%d|plat_id=%d|partition=%d|Source=%d|BeginTime=%d|EndTime=%d|MailTitle=%s|MailContent=%s|Rollfre=%d|Rollnum=%d|index_id=%d", new Object[] { Integer.valueOf(((IDIPPacket_DoUpdateMarqueeRsp)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoUpdateMarqueeRsp)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).rsp).head.RetErrMsg, Integer.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).AreaId), Byte.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).Partition), Integer.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).Source), Long.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).BeginTime), Long.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).EndTime), ((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).MailTitle, ((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).MailContent, Integer.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).Rollfre), Integer.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).Rollnum), Long.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).MarqueeId) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  93 */       return false;
/*     */     }
/*  95 */     if (mailTitle.length() > 120)
/*     */     {
/*  97 */       ((IDIPPacket_DoUpdateMarqueeRsp)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).rsp).head.Result = (((DoUpdateMarqueeRsp)((IDIPPacket_DoUpdateMarqueeRsp)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).rsp).body).Result = 'ﭗ');
/*  98 */       ((IDIPPacket_DoUpdateMarqueeRsp)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).rsp).head.RetErrMsg = (((DoUpdateMarqueeRsp)((IDIPPacket_DoUpdateMarqueeRsp)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).rsp).body).RetMsg = String.format("mail title length > %d", new Object[] { Integer.valueOf(120) }));
/*     */       
/* 100 */       ((IDIPCmd_DoUpdateMarqueeReq)this.cmd).sendResponse();
/*     */       
/* 102 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoUpdateMarqueeReq.handle@mail title length > MAX_MAILTITILE_LEN|ret=%d|ret_msg=%s|area_id=%d|plat_id=%d|partition=%d|Source=%d|BeginTime=%d|EndTime=%d|MailTitle=%s|MailContent=%s|Rollfre=%d|Rollnum=%d|index_id=%d", new Object[] { Integer.valueOf(((IDIPPacket_DoUpdateMarqueeRsp)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoUpdateMarqueeRsp)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).rsp).head.RetErrMsg, Integer.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).AreaId), Byte.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).Partition), Integer.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).Source), Long.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).BeginTime), Long.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).EndTime), ((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).MailTitle, ((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).MailContent, Integer.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).Rollfre), Integer.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).Rollnum), Long.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).MarqueeId) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 110 */       return false;
/*     */     }
/*     */     
/* 113 */     String mailContent = Utils.urlDecode1738(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).MailContent);
/* 114 */     if (mailContent.isEmpty())
/*     */     {
/* 116 */       ((IDIPPacket_DoUpdateMarqueeRsp)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).rsp).head.Result = (((DoUpdateMarqueeRsp)((IDIPPacket_DoUpdateMarqueeRsp)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).rsp).body).Result = 'ﭖ');
/* 117 */       ((IDIPPacket_DoUpdateMarqueeRsp)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).rsp).head.RetErrMsg = (((DoUpdateMarqueeRsp)((IDIPPacket_DoUpdateMarqueeRsp)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).rsp).body).RetMsg = "mail content is empty");
/* 118 */       ((IDIPCmd_DoUpdateMarqueeReq)this.cmd).sendResponse();
/*     */       
/* 120 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoUpdateMarqueeReq.handle@mail content is empty|ret=%d|ret_msg=%s|area_id=%d|plat_id=%d|partition=%d|Source=%d|BeginTime=%d|EndTime=%d|MailTitle=%s|MailContent=%s|Rollfre=%d|Rollnum=%d|index_id=%d", new Object[] { Integer.valueOf(((IDIPPacket_DoUpdateMarqueeRsp)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoUpdateMarqueeRsp)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).rsp).head.RetErrMsg, Integer.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).AreaId), Byte.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).Partition), Integer.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).Source), Long.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).BeginTime), Long.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).EndTime), ((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).MailTitle, ((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).MailContent, Integer.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).Rollfre), Integer.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).Rollnum), Long.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).MarqueeId) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 128 */       return false;
/*     */     }
/* 130 */     if (mailContent.length() > 3200)
/*     */     {
/* 132 */       ((IDIPPacket_DoUpdateMarqueeRsp)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).rsp).head.Result = (((DoUpdateMarqueeRsp)((IDIPPacket_DoUpdateMarqueeRsp)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).rsp).body).Result = 'ﭖ');
/* 133 */       ((IDIPPacket_DoUpdateMarqueeRsp)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).rsp).head.RetErrMsg = (((DoUpdateMarqueeRsp)((IDIPPacket_DoUpdateMarqueeRsp)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).rsp).body).RetMsg = String.format("mail content length > %d", new Object[] { Integer.valueOf(3200) }));
/*     */       
/* 135 */       ((IDIPCmd_DoUpdateMarqueeReq)this.cmd).sendResponse();
/*     */       
/* 137 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoSendMarqueeReq.handle@mail content length > MAX_MAILCONTENT_LEN|ret=%d|ret_msg=%s|area_id=%d|plat_id=%d|partition=%d|BeginTime=%d|EndTime=%d|MailTitle=%s|MailContent=%s|Rollfre=%d|Rollnum=%d|Source=%d|index_id=%d", new Object[] { Integer.valueOf(((IDIPPacket_DoUpdateMarqueeRsp)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoUpdateMarqueeRsp)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).rsp).head.RetErrMsg, Integer.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).AreaId), Byte.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).Partition), Long.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).BeginTime), Long.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).EndTime), ((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).MailTitle, ((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).MailContent, Integer.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).Rollfre), Integer.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).Rollnum), Integer.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).Source), Long.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).MarqueeId) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 145 */       return false;
/*     */     }
/*     */     
/* 148 */     int rollfre = ((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).Rollfre;
/* 149 */     if (rollfre <= 0)
/*     */     {
/* 151 */       ((IDIPPacket_DoUpdateMarqueeRsp)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).rsp).head.Result = (((DoUpdateMarqueeRsp)((IDIPPacket_DoUpdateMarqueeRsp)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).rsp).body).Result = 'ﭕ');
/* 152 */       ((IDIPPacket_DoUpdateMarqueeRsp)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).rsp).head.RetErrMsg = (((DoUpdateMarqueeRsp)((IDIPPacket_DoUpdateMarqueeRsp)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).rsp).body).RetMsg = "rollfre <= 0");
/* 153 */       ((IDIPCmd_DoUpdateMarqueeReq)this.cmd).sendResponse();
/*     */       
/* 155 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoUpdateMarqueeReq.handle@rollfre <= 0|ret=%d|ret_msg=%s|area_id=%d|plat_id=%d|partition=%d|Source=%d|BeginTime=%d|EndTime=%d|MailTitle=%s|MailContent=%s|Rollfre=%d|Rollnum=%d|index_id=%d", new Object[] { Integer.valueOf(((IDIPPacket_DoUpdateMarqueeRsp)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoUpdateMarqueeRsp)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).rsp).head.RetErrMsg, Integer.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).AreaId), Byte.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).Partition), Integer.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).Source), Long.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).BeginTime), Long.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).EndTime), ((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).MailTitle, ((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).MailContent, Integer.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).Rollfre), Integer.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).Rollnum), Long.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).MarqueeId) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 163 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 167 */     int rollNum = ((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).Rollnum;
/* 168 */     if ((rollNum == 0) || (rollNum < -1))
/*     */     {
/* 170 */       ((IDIPPacket_DoUpdateMarqueeRsp)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).rsp).head.Result = (((DoUpdateMarqueeRsp)((IDIPPacket_DoUpdateMarqueeRsp)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).rsp).body).Result = 'ﭔ');
/* 171 */       ((IDIPPacket_DoUpdateMarqueeRsp)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).rsp).head.RetErrMsg = (((DoUpdateMarqueeRsp)((IDIPPacket_DoUpdateMarqueeRsp)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).rsp).body).RetMsg = "rollNum invalid");
/* 172 */       ((IDIPCmd_DoUpdateMarqueeReq)this.cmd).sendResponse();
/*     */       
/* 174 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoUpdateMarqueeReq.handle@rollNum == 0 OR rollNum < -1|ret=%d|ret_msg=%s|area_id=%d|plat_id=%d|partition=%d|Source=%d|BeginTime=%d|EndTime=%d|MailTitle=%s|MailContent=%s|Rollfre=%d|Rollnum=%d|index_id=%d", new Object[] { Integer.valueOf(((IDIPPacket_DoUpdateMarqueeRsp)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoUpdateMarqueeRsp)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).rsp).head.RetErrMsg, Integer.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).AreaId), Byte.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).Partition), Integer.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).Source), Long.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).BeginTime), Long.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).EndTime), ((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).MailTitle, ((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).MailContent, Integer.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).Rollfre), Integer.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).Rollnum), Long.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).MarqueeId) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 182 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 186 */     long indexId = ((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).MarqueeId;
/* 187 */     Long marqueeId = MarqueeIndexCache.getInstance().get(indexId);
/* 188 */     if (marqueeId == null)
/*     */     {
/* 190 */       ((IDIPPacket_DoUpdateMarqueeRsp)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).rsp).head.Result = (((DoUpdateMarqueeRsp)((IDIPPacket_DoUpdateMarqueeRsp)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).rsp).body).Result = 'ﭓ');
/* 191 */       ((IDIPPacket_DoUpdateMarqueeRsp)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).rsp).head.RetErrMsg = (((DoUpdateMarqueeRsp)((IDIPPacket_DoUpdateMarqueeRsp)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).rsp).body).RetMsg = "marquee not exist");
/* 192 */       ((IDIPCmd_DoUpdateMarqueeReq)this.cmd).sendResponse();
/*     */       
/* 194 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoUpdateMarqueeReq.handle@marquee not exist|ret=%d|ret_msg=%s|area_id=%d|plat_id=%d|partition=%d|Source=%d|BeginTime=%d|EndTime=%d|MailTitle=%s|MailContent=%s|Rollfre=%d|Rollnum=%d|index_id=%d", new Object[] { Integer.valueOf(((IDIPPacket_DoUpdateMarqueeRsp)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoUpdateMarqueeRsp)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).rsp).head.RetErrMsg, Integer.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).AreaId), Byte.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).Partition), Integer.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).Source), Long.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).BeginTime), Long.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).EndTime), ((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).MailTitle, ((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).MailContent, Integer.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).Rollfre), Integer.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).Rollnum), Long.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).MarqueeId) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 202 */       return false;
/*     */     }
/*     */     
/* 205 */     MarqueeDataInfo newMarquee = new MarqueeDataInfo(beginTime, endTime, mailTitle, mailContent, rollfre, rollNum, indexId);
/*     */     
/* 207 */     newMarquee.setMarqueeId(marqueeId.longValue());
/* 208 */     boolean success = MarqueeManager.updateMarquee(marqueeId.longValue(), newMarquee);
/* 209 */     if (!success)
/*     */     {
/* 211 */       ((IDIPPacket_DoUpdateMarqueeRsp)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).rsp).head.Result = (((DoUpdateMarqueeRsp)((IDIPPacket_DoUpdateMarqueeRsp)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).rsp).body).Result = 'ﭓ');
/* 212 */       ((IDIPPacket_DoUpdateMarqueeRsp)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).rsp).head.RetErrMsg = (((DoUpdateMarqueeRsp)((IDIPPacket_DoUpdateMarqueeRsp)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).rsp).body).RetMsg = "marquee not exist");
/* 213 */       ((IDIPCmd_DoUpdateMarqueeReq)this.cmd).sendResponse();
/*     */       
/* 215 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoUpdateMarqueeReq.handle@marquee not exist|ret=%d|ret_msg=%s|area_id=%d|plat_id=%d|partition=%d|Source=%d|BeginTime=%d|EndTime=%d|MailTitle=%s|MailContent=%s|Rollfre=%d|Rollnum=%d|index_id=%d|MarqueeId=%d", new Object[] { Integer.valueOf(((IDIPPacket_DoUpdateMarqueeRsp)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoUpdateMarqueeRsp)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).rsp).head.RetErrMsg, Integer.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).AreaId), Byte.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).Partition), Integer.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).Source), Long.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).BeginTime), Long.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).EndTime), ((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).MailTitle, ((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).MailContent, Integer.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).Rollfre), Integer.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).Rollnum), Long.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).MarqueeId), marqueeId }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 223 */       return false;
/*     */     }
/*     */     
/* 226 */     String retDesc = "";
/* 227 */     if (beginTime <= now)
/*     */     {
/* 229 */       retDesc = Utils.urlEncode1738("跑马灯已经生效", "UTF-8");
/*     */     }
/*     */     else
/*     */     {
/* 233 */       retDesc = Utils.urlEncode1738(String.format("跑马灯将于%s生效，现在时间%s", new Object[] { mzm.gsp.util.DateTimeUtils.formatTimestamp(beginTime), mzm.gsp.util.DateTimeUtils.formatTimestamp(now) }), "UTF-8");
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 238 */     ((DoUpdateMarqueeRsp)((IDIPPacket_DoUpdateMarqueeRsp)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).rsp).body).MarqueeId = indexId;
/* 239 */     ((IDIPPacket_DoUpdateMarqueeRsp)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).rsp).head.Result = (((DoUpdateMarqueeRsp)((IDIPPacket_DoUpdateMarqueeRsp)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).rsp).body).Result = 0);
/* 240 */     ((IDIPPacket_DoUpdateMarqueeRsp)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).rsp).head.RetErrMsg = (((DoUpdateMarqueeRsp)((IDIPPacket_DoUpdateMarqueeRsp)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).rsp).body).RetMsg = retDesc);
/* 241 */     ((IDIPCmd_DoUpdateMarqueeReq)this.cmd).sendResponse();
/*     */     
/* 243 */     GameServer.logger().info(String.format("[idip]PIDIPCmd_DoUpdateMarqueeReq.handle@update marquee done|ret=%d|ret_msg=%s|area_id=%d|plat_id=%d|partition=%d|Source=%d|BeginTime=%d|EndTime=%d|MailTitle=%s|MailContent=%s|Rollfre=%d|Rollnum=%d|index_id=%d|marqueeId=%d", new Object[] { Integer.valueOf(((IDIPPacket_DoUpdateMarqueeRsp)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoUpdateMarqueeRsp)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).rsp).head.RetErrMsg, Integer.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).AreaId), Byte.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).Partition), Integer.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).Source), Long.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).BeginTime), Long.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).EndTime), ((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).MailTitle, ((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).MailContent, Integer.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).Rollfre), Integer.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).Rollnum), Long.valueOf(((DoUpdateMarqueeReq)((IDIPPacket_DoUpdateMarqueeReq)((IDIPCmd_DoUpdateMarqueeReq)this.cmd).req).body).MarqueeId), marqueeId }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 252 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean isGameServerLevelCommand()
/*     */   {
/* 258 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PIDIPCmd_DoUpdateMarqueeReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */