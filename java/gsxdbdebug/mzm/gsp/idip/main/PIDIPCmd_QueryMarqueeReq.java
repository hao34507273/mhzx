/*     */ package mzm.gsp.idip.main;
/*     */ 
/*     */ import idip.IDIPCmd_QueryMarqueeReq;
/*     */ import idip.IDIPPacket_QueryMarqueeReq;
/*     */ import idip.IDIPPacket_QueryMarqueeRsp;
/*     */ import idip.MarqueeInfo;
/*     */ import idip.QueryMarqueeReq;
/*     */ import idip.QueryMarqueeRsp;
/*     */ import idip.core.IdipHeader;
/*     */ import idip.core.Utils;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServer;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class PIDIPCmd_QueryMarqueeReq extends PIDIPCmd<IDIPCmd_QueryMarqueeReq>
/*     */ {
/*     */   public PIDIPCmd_QueryMarqueeReq(IDIPCmd_QueryMarqueeReq cmd)
/*     */   {
/*  21 */     super(cmd);
/*     */   }
/*     */   
/*     */   protected boolean handle()
/*     */     throws Exception
/*     */   {
/*  27 */     long beginTime = TimeUnit.SECONDS.toMillis(((QueryMarqueeReq)((IDIPPacket_QueryMarqueeReq)((IDIPCmd_QueryMarqueeReq)this.cmd).req).body).BeginTime);
/*  28 */     long endTime = TimeUnit.SECONDS.toMillis(((QueryMarqueeReq)((IDIPPacket_QueryMarqueeReq)((IDIPCmd_QueryMarqueeReq)this.cmd).req).body).EndTime);
/*     */     
/*  30 */     int page = ((QueryMarqueeReq)((IDIPPacket_QueryMarqueeReq)((IDIPCmd_QueryMarqueeReq)this.cmd).req).body).PageNo;
/*  31 */     if (page <= 0)
/*     */     {
/*  33 */       ((IDIPPacket_QueryMarqueeRsp)((IDIPCmd_QueryMarqueeReq)this.cmd).rsp).head.Result = (((QueryMarqueeRsp)((IDIPPacket_QueryMarqueeRsp)((IDIPCmd_QueryMarqueeReq)this.cmd).rsp).body).Result = 'ﭒ');
/*  34 */       ((IDIPPacket_QueryMarqueeRsp)((IDIPCmd_QueryMarqueeReq)this.cmd).rsp).head.RetErrMsg = (((QueryMarqueeRsp)((IDIPPacket_QueryMarqueeRsp)((IDIPCmd_QueryMarqueeReq)this.cmd).rsp).body).RetMsg = "pageNo <= 0");
/*  35 */       ((IDIPCmd_QueryMarqueeReq)this.cmd).sendResponse();
/*     */       
/*  37 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_QueryMarqueeReq.handle@pageNo invalid|ret=%d|ret_msg=%s|areaId=%d|platId=%d|partition=%d|beginTime=%d|endTime=%d|pageNo=%d", new Object[] { Integer.valueOf(((IDIPPacket_QueryMarqueeReq)((IDIPCmd_QueryMarqueeReq)this.cmd).req).head.Result), ((IDIPPacket_QueryMarqueeReq)((IDIPCmd_QueryMarqueeReq)this.cmd).req).head.RetErrMsg, Integer.valueOf(((QueryMarqueeReq)((IDIPPacket_QueryMarqueeReq)((IDIPCmd_QueryMarqueeReq)this.cmd).req).body).AreaId), Byte.valueOf(((QueryMarqueeReq)((IDIPPacket_QueryMarqueeReq)((IDIPCmd_QueryMarqueeReq)this.cmd).req).body).PlatId), Integer.valueOf(((QueryMarqueeReq)((IDIPPacket_QueryMarqueeReq)((IDIPCmd_QueryMarqueeReq)this.cmd).req).body).Partition), Long.valueOf(((QueryMarqueeReq)((IDIPPacket_QueryMarqueeReq)((IDIPCmd_QueryMarqueeReq)this.cmd).req).body).BeginTime), Long.valueOf(((QueryMarqueeReq)((IDIPPacket_QueryMarqueeReq)((IDIPCmd_QueryMarqueeReq)this.cmd).req).body).EndTime), Integer.valueOf(((QueryMarqueeReq)((IDIPPacket_QueryMarqueeReq)((IDIPCmd_QueryMarqueeReq)this.cmd).req).body).PageNo) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  44 */       return false;
/*     */     }
/*     */     
/*  47 */     if (beginTime < 0L)
/*     */     {
/*  49 */       ((IDIPPacket_QueryMarqueeRsp)((IDIPCmd_QueryMarqueeReq)this.cmd).rsp).head.Result = (((QueryMarqueeRsp)((IDIPPacket_QueryMarqueeRsp)((IDIPCmd_QueryMarqueeReq)this.cmd).rsp).body).Result = 'ﭚ');
/*  50 */       ((IDIPPacket_QueryMarqueeRsp)((IDIPCmd_QueryMarqueeReq)this.cmd).rsp).head.RetErrMsg = (((QueryMarqueeRsp)((IDIPPacket_QueryMarqueeRsp)((IDIPCmd_QueryMarqueeReq)this.cmd).rsp).body).RetMsg = "begin time invalid");
/*  51 */       ((IDIPCmd_QueryMarqueeReq)this.cmd).sendResponse();
/*     */       
/*  53 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_QueryMarqueeReq.handle@begin time invalid|ret=%d|ret_msg=%s|areaId=%d|platId=%d|partition=%d|beginTime=%d|endTime=%d|pageNo=%d", new Object[] { Integer.valueOf(((IDIPPacket_QueryMarqueeReq)((IDIPCmd_QueryMarqueeReq)this.cmd).req).head.Result), ((IDIPPacket_QueryMarqueeReq)((IDIPCmd_QueryMarqueeReq)this.cmd).req).head.RetErrMsg, Integer.valueOf(((QueryMarqueeReq)((IDIPPacket_QueryMarqueeReq)((IDIPCmd_QueryMarqueeReq)this.cmd).req).body).AreaId), Byte.valueOf(((QueryMarqueeReq)((IDIPPacket_QueryMarqueeReq)((IDIPCmd_QueryMarqueeReq)this.cmd).req).body).PlatId), Integer.valueOf(((QueryMarqueeReq)((IDIPPacket_QueryMarqueeReq)((IDIPCmd_QueryMarqueeReq)this.cmd).req).body).Partition), Long.valueOf(((QueryMarqueeReq)((IDIPPacket_QueryMarqueeReq)((IDIPCmd_QueryMarqueeReq)this.cmd).req).body).BeginTime), Long.valueOf(((QueryMarqueeReq)((IDIPPacket_QueryMarqueeReq)((IDIPCmd_QueryMarqueeReq)this.cmd).req).body).EndTime), Integer.valueOf(((QueryMarqueeReq)((IDIPPacket_QueryMarqueeReq)((IDIPCmd_QueryMarqueeReq)this.cmd).req).body).PageNo) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  60 */       return false;
/*     */     }
/*     */     
/*  63 */     long now = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/*  64 */     if (endTime <= now)
/*     */     {
/*  66 */       ((IDIPPacket_QueryMarqueeRsp)((IDIPCmd_QueryMarqueeReq)this.cmd).rsp).head.Result = (((QueryMarqueeRsp)((IDIPPacket_QueryMarqueeRsp)((IDIPCmd_QueryMarqueeReq)this.cmd).rsp).body).Result = 'ﭙ');
/*  67 */       ((IDIPPacket_QueryMarqueeRsp)((IDIPCmd_QueryMarqueeReq)this.cmd).rsp).head.RetErrMsg = (((QueryMarqueeRsp)((IDIPPacket_QueryMarqueeRsp)((IDIPCmd_QueryMarqueeReq)this.cmd).rsp).body).RetMsg = "end time <= now");
/*  68 */       ((IDIPCmd_QueryMarqueeReq)this.cmd).sendResponse();
/*     */       
/*  70 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_QueryMarqueeReq.handle@endTime <= now|ret=%d|ret_msg=%s|areaId=%d|platId=%d|partition=%d|beginTime=%d|endTime=%d|pageNo=%d", new Object[] { Integer.valueOf(((IDIPPacket_QueryMarqueeReq)((IDIPCmd_QueryMarqueeReq)this.cmd).req).head.Result), ((IDIPPacket_QueryMarqueeReq)((IDIPCmd_QueryMarqueeReq)this.cmd).req).head.RetErrMsg, Integer.valueOf(((QueryMarqueeReq)((IDIPPacket_QueryMarqueeReq)((IDIPCmd_QueryMarqueeReq)this.cmd).req).body).AreaId), Byte.valueOf(((QueryMarqueeReq)((IDIPPacket_QueryMarqueeReq)((IDIPCmd_QueryMarqueeReq)this.cmd).req).body).PlatId), Integer.valueOf(((QueryMarqueeReq)((IDIPPacket_QueryMarqueeReq)((IDIPCmd_QueryMarqueeReq)this.cmd).req).body).Partition), Long.valueOf(((QueryMarqueeReq)((IDIPPacket_QueryMarqueeReq)((IDIPCmd_QueryMarqueeReq)this.cmd).req).body).BeginTime), Long.valueOf(((QueryMarqueeReq)((IDIPPacket_QueryMarqueeReq)((IDIPCmd_QueryMarqueeReq)this.cmd).req).body).EndTime), Integer.valueOf(((QueryMarqueeReq)((IDIPPacket_QueryMarqueeReq)((IDIPCmd_QueryMarqueeReq)this.cmd).req).body).PageNo) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  76 */       return false;
/*     */     }
/*     */     
/*  79 */     if (beginTime >= endTime)
/*     */     {
/*  81 */       ((IDIPPacket_QueryMarqueeRsp)((IDIPCmd_QueryMarqueeReq)this.cmd).rsp).head.Result = (((QueryMarqueeRsp)((IDIPPacket_QueryMarqueeRsp)((IDIPCmd_QueryMarqueeReq)this.cmd).rsp).body).Result = 'ﭘ');
/*  82 */       ((IDIPPacket_QueryMarqueeRsp)((IDIPCmd_QueryMarqueeReq)this.cmd).rsp).head.RetErrMsg = (((QueryMarqueeRsp)((IDIPPacket_QueryMarqueeRsp)((IDIPCmd_QueryMarqueeReq)this.cmd).rsp).body).RetMsg = "begin time >= end time");
/*  83 */       ((IDIPCmd_QueryMarqueeReq)this.cmd).sendResponse();
/*     */       
/*  85 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_QueryMarqueeReq.handle@begin time >= end time|ret=%d|ret_msg=%s|areaId=%d|platId=%d|partition=%d|beginTime=%d|endTime=%d|pageNo=%d", new Object[] { Integer.valueOf(((IDIPPacket_QueryMarqueeReq)((IDIPCmd_QueryMarqueeReq)this.cmd).req).head.Result), ((IDIPPacket_QueryMarqueeReq)((IDIPCmd_QueryMarqueeReq)this.cmd).req).head.RetErrMsg, Integer.valueOf(((QueryMarqueeReq)((IDIPPacket_QueryMarqueeReq)((IDIPCmd_QueryMarqueeReq)this.cmd).req).body).AreaId), Byte.valueOf(((QueryMarqueeReq)((IDIPPacket_QueryMarqueeReq)((IDIPCmd_QueryMarqueeReq)this.cmd).req).body).PlatId), Integer.valueOf(((QueryMarqueeReq)((IDIPPacket_QueryMarqueeReq)((IDIPCmd_QueryMarqueeReq)this.cmd).req).body).Partition), Long.valueOf(((QueryMarqueeReq)((IDIPPacket_QueryMarqueeReq)((IDIPCmd_QueryMarqueeReq)this.cmd).req).body).BeginTime), Long.valueOf(((QueryMarqueeReq)((IDIPPacket_QueryMarqueeReq)((IDIPCmd_QueryMarqueeReq)this.cmd).req).body).EndTime), Integer.valueOf(((QueryMarqueeReq)((IDIPPacket_QueryMarqueeReq)((IDIPCmd_QueryMarqueeReq)this.cmd).req).body).PageNo) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  91 */       return false;
/*     */     }
/*     */     
/*  94 */     List<MarqueeDataInfo> list = MarqueeManager.queryMarquees(beginTime, endTime, page);
/*  95 */     if (list.isEmpty())
/*     */     {
/*  97 */       ((QueryMarqueeRsp)((IDIPPacket_QueryMarqueeRsp)((IDIPCmd_QueryMarqueeReq)this.cmd).rsp).body).MarqueeList_count = 0;
/*     */     }
/*     */     else
/*     */     {
/* 101 */       int size = list.size();
/* 102 */       ArrayList<MarqueeInfo> marqueeInfos = new ArrayList(size);
/* 103 */       for (int i = 0; i < size; i++)
/*     */       {
/* 105 */         marqueeInfos.add(transToMarqueeInfo((MarqueeDataInfo)list.get(i)));
/*     */       }
/*     */       
/* 108 */       ((QueryMarqueeRsp)((IDIPPacket_QueryMarqueeRsp)((IDIPCmd_QueryMarqueeReq)this.cmd).rsp).body).MarqueeList_count = size;
/* 109 */       ((QueryMarqueeRsp)((IDIPPacket_QueryMarqueeRsp)((IDIPCmd_QueryMarqueeReq)this.cmd).rsp).body).MarqueeList = marqueeInfos;
/*     */     }
/*     */     
/* 112 */     ((QueryMarqueeRsp)((IDIPPacket_QueryMarqueeRsp)((IDIPCmd_QueryMarqueeReq)this.cmd).rsp).body).PageNo = page;
/* 113 */     ((IDIPPacket_QueryMarqueeRsp)((IDIPCmd_QueryMarqueeReq)this.cmd).rsp).head.Result = (((QueryMarqueeRsp)((IDIPPacket_QueryMarqueeRsp)((IDIPCmd_QueryMarqueeReq)this.cmd).rsp).body).Result = 0);
/* 114 */     ((IDIPPacket_QueryMarqueeRsp)((IDIPCmd_QueryMarqueeReq)this.cmd).rsp).head.RetErrMsg = (((QueryMarqueeRsp)((IDIPPacket_QueryMarqueeRsp)((IDIPCmd_QueryMarqueeReq)this.cmd).rsp).body).RetMsg = "ok");
/* 115 */     ((IDIPCmd_QueryMarqueeReq)this.cmd).sendResponse();
/*     */     
/* 117 */     GameServer.logger().info(String.format("[idip]PIDIPCmd_QueryMarqueeReq.handle@query success|ret=%d|ret_msg=%s|areaId=%d|platId=%d|partition=%d|beginTime=%d|endTime=%d|pageNo=%d|marqueeCount=%d", new Object[] { Integer.valueOf(((IDIPPacket_QueryMarqueeReq)((IDIPCmd_QueryMarqueeReq)this.cmd).req).head.Result), ((IDIPPacket_QueryMarqueeReq)((IDIPCmd_QueryMarqueeReq)this.cmd).req).head.RetErrMsg, Integer.valueOf(((QueryMarqueeReq)((IDIPPacket_QueryMarqueeReq)((IDIPCmd_QueryMarqueeReq)this.cmd).req).body).AreaId), Byte.valueOf(((QueryMarqueeReq)((IDIPPacket_QueryMarqueeReq)((IDIPCmd_QueryMarqueeReq)this.cmd).req).body).PlatId), Integer.valueOf(((QueryMarqueeReq)((IDIPPacket_QueryMarqueeReq)((IDIPCmd_QueryMarqueeReq)this.cmd).req).body).Partition), Long.valueOf(((QueryMarqueeReq)((IDIPPacket_QueryMarqueeReq)((IDIPCmd_QueryMarqueeReq)this.cmd).req).body).BeginTime), Long.valueOf(((QueryMarqueeReq)((IDIPPacket_QueryMarqueeReq)((IDIPCmd_QueryMarqueeReq)this.cmd).req).body).EndTime), Integer.valueOf(((QueryMarqueeReq)((IDIPPacket_QueryMarqueeReq)((IDIPCmd_QueryMarqueeReq)this.cmd).req).body).PageNo), Integer.valueOf(((QueryMarqueeRsp)((IDIPPacket_QueryMarqueeRsp)((IDIPCmd_QueryMarqueeReq)this.cmd).rsp).body).MarqueeList_count) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 123 */     return true;
/*     */   }
/*     */   
/*     */   private MarqueeInfo transToMarqueeInfo(MarqueeDataInfo marquee)
/*     */   {
/* 128 */     MarqueeInfo info = new MarqueeInfo();
/* 129 */     info.MarqueeId = marquee.getIndexId();
/* 130 */     info.BeginTime = TimeUnit.MILLISECONDS.toSeconds(marquee.getBeginTime());
/* 131 */     info.EndTime = TimeUnit.MILLISECONDS.toSeconds(marquee.getEndTime());
/* 132 */     info.Rollfre = marquee.getRollFre();
/* 133 */     info.Rollnum = marquee.getRollNum();
/*     */     try
/*     */     {
/* 136 */       info.MailContent = Utils.urlEncode1738(marquee.getMailContent(), "UTF-8");
/* 137 */       info.MailTitle = Utils.urlEncode1738(marquee.getMailTitle(), "UTF-8");
/*     */     }
/*     */     catch (java.io.UnsupportedEncodingException e) {}
/*     */     
/*     */ 
/*     */ 
/* 143 */     return info;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean isGameServerLevelCommand()
/*     */   {
/* 149 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PIDIPCmd_QueryMarqueeReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */