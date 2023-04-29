/*     */ package mzm.gsp.csprovider.gmt.idip;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import csprovider.DataBetweenCspAndGame_Re;
/*     */ import idip.MarqueeInfo;
/*     */ import idip.QueryMarqueeRsp;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.csprovider.gmt.GmtCmdManager;
/*     */ import mzm.gsp.csprovider.main.Retcode;
/*     */ import mzm.gsp.idip.main.MarqueeDataInfo;
/*     */ import mzm.gsp.idip.main.MarqueeInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class QueryMarqueeHandler
/*     */   implements IdipHandler
/*     */ {
/*     */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp) throws Exception
/*     */   {
/*  23 */     long beginTime = TimeUnit.SECONDS.toMillis(Long.parseLong((String)params.get(0)));
/*  24 */     long endTime = TimeUnit.SECONDS.toMillis(Long.parseLong((String)params.get(1)));
/*  25 */     int page = Integer.parseInt((String)params.get(2));
/*     */     
/*  27 */     if (page <= 0)
/*     */     {
/*  29 */       int retcode = Retcode.QUERY_MARQUEE_PAGE_INVALID.value;
/*  30 */       rsp.retcode = retcode;
/*  31 */       Response response = IdipGmtUtil.getResponse(retcode, "page <= 0");
/*  32 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  34 */       GameServer.logger().error(String.format("[gmt]QueryMarqueeHandler.execute@pageNo invalid|begin_time=%d|end_time=%d|page=%d", new Object[] { Long.valueOf(beginTime), Long.valueOf(endTime), Integer.valueOf(page) }));
/*     */       
/*     */ 
/*  37 */       return;
/*     */     }
/*     */     
/*  40 */     if (beginTime < 0L)
/*     */     {
/*  42 */       int retcode = Retcode.QUERY_MARQUEE_BEGIN_TIME_LESS_THAN_ZERO.value;
/*  43 */       rsp.retcode = retcode;
/*  44 */       Response response = IdipGmtUtil.getResponse(retcode, "begin time < 0");
/*  45 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  47 */       GameServer.logger().error(String.format("[gmt]QueryMarqueeHandler.execute@begin time < 0|begin_time=%d|end_time=%d|page=%d", new Object[] { Long.valueOf(beginTime), Long.valueOf(endTime), Integer.valueOf(page) }));
/*     */       
/*     */ 
/*  50 */       return;
/*     */     }
/*     */     
/*  53 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*  54 */     if (endTime <= now)
/*     */     {
/*  56 */       int retcode = Retcode.QUERY_MARQUEE_END_TIME_LESS_THAN_NOW.value;
/*  57 */       rsp.retcode = retcode;
/*  58 */       Response response = IdipGmtUtil.getResponse(retcode, "end time <= now");
/*  59 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  61 */       GameServer.logger().error(String.format("[gmt]QueryMarqueeHandler.execute@end time <= now|begin_time=%d|end_time=%d|page=%d", new Object[] { Long.valueOf(beginTime), Long.valueOf(endTime), Integer.valueOf(page) }));
/*     */       
/*     */ 
/*  64 */       return;
/*     */     }
/*     */     
/*  67 */     if (beginTime >= endTime)
/*     */     {
/*  69 */       int retcode = Retcode.QUERY_MARQUEE_BEGIN_TIME_GREATER_THAN_END_TIME.value;
/*  70 */       rsp.retcode = retcode;
/*  71 */       Response response = IdipGmtUtil.getResponse(retcode, "begin time >= end time");
/*  72 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  74 */       GameServer.logger().error(String.format("[gmt]QueryMarqueeHandler.execute@begin time >= end time|begin_time=%d|end_time=%d|page=%d", new Object[] { Long.valueOf(beginTime), Long.valueOf(endTime), Integer.valueOf(page) }));
/*     */       
/*     */ 
/*  77 */       return;
/*     */     }
/*     */     
/*  80 */     QueryMarqueeRsp queryMarqueeRsp = new QueryMarqueeRsp();
/*  81 */     queryMarqueeRsp.PageNo = page;
/*  82 */     List<MarqueeDataInfo> list = MarqueeInterface.queryMarquees(beginTime, endTime, page);
/*  83 */     if (list.isEmpty())
/*     */     {
/*  85 */       queryMarqueeRsp.MarqueeList_count = 0;
/*     */     }
/*     */     else
/*     */     {
/*  89 */       int size = list.size();
/*  90 */       ArrayList<MarqueeInfo> marqueeInfos = new ArrayList(size);
/*  91 */       for (int i = 0; i < size; i++)
/*     */       {
/*  93 */         marqueeInfos.add(transToMarqueeInfo((MarqueeDataInfo)list.get(i)));
/*     */       }
/*  95 */       queryMarqueeRsp.MarqueeList_count = size;
/*  96 */       queryMarqueeRsp.MarqueeList = marqueeInfos;
/*     */     }
/*     */     
/*  99 */     rsp.retcode = Retcode.SUCCESS.value;
/* 100 */     Response response = new Response();
/* 101 */     response.data = queryMarqueeRsp;
/* 102 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */     
/* 104 */     GameServer.logger().info(String.format("[gmt]QueryMarqueeHandler.execute@query success|begin_time=%d|end_time=%d|page=%d", new Object[] { Long.valueOf(beginTime), Long.valueOf(endTime), Integer.valueOf(page) }));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private MarqueeInfo transToMarqueeInfo(MarqueeDataInfo marquee)
/*     */   {
/* 111 */     MarqueeInfo info = new MarqueeInfo();
/* 112 */     info.MarqueeId = marquee.getIndexId();
/* 113 */     info.BeginTime = TimeUnit.MILLISECONDS.toSeconds(marquee.getBeginTime());
/* 114 */     info.EndTime = TimeUnit.MILLISECONDS.toSeconds(marquee.getEndTime());
/* 115 */     info.Rollfre = marquee.getRollFre();
/* 116 */     info.Rollnum = marquee.getRollNum();
/* 117 */     info.MailContent = marquee.getMailContent();
/* 118 */     info.MailTitle = marquee.getMailTitle();
/* 119 */     return info;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\QueryMarqueeHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */