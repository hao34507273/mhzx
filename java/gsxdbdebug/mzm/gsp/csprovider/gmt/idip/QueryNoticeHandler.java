/*     */ package mzm.gsp.csprovider.gmt.idip;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import csprovider.DataBetweenCspAndGame_Re;
/*     */ import idip.NoticeInfo;
/*     */ import idip.QueryNoticeRsp;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.csprovider.gmt.GmtCmdManager;
/*     */ import mzm.gsp.csprovider.main.Retcode;
/*     */ import mzm.gsp.idip.main.NoticeDataInfo;
/*     */ import mzm.gsp.idip.main.NoticeInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class QueryNoticeHandler
/*     */   implements IdipHandler
/*     */ {
/*     */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp) throws Exception
/*     */   {
/*  23 */     long startTime = TimeUnit.SECONDS.toMillis(Long.parseLong((String)params.get(0)));
/*  24 */     long endTime = TimeUnit.SECONDS.toMillis(Long.parseLong((String)params.get(1)));
/*  25 */     int page = Integer.parseInt((String)params.get(2));
/*     */     
/*  27 */     if (page <= 0)
/*     */     {
/*  29 */       int retcode = Retcode.NOTICE_QUERY_PAGE_INVALID.value;
/*  30 */       rsp.retcode = retcode;
/*  31 */       Response response = IdipGmtUtil.getResponse(retcode, "page <= 0");
/*  32 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  34 */       GameServer.logger().error(String.format("[gmt]QueryNoticeHandler.execute@pageNo invalid|start_time=%d|end_time=%d|page=%d", new Object[] { Long.valueOf(startTime), Long.valueOf(endTime), Integer.valueOf(page) }));
/*     */       
/*     */ 
/*  37 */       return;
/*     */     }
/*     */     
/*  40 */     if (startTime < 0L)
/*     */     {
/*  42 */       int retcode = Retcode.NOTICE_QUERY_START_TIME_LESS_THAN_ZERO.value;
/*  43 */       rsp.retcode = retcode;
/*  44 */       Response response = IdipGmtUtil.getResponse(retcode, "start time < 0");
/*  45 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  47 */       GameServer.logger().error(String.format("[gmt]QueryNoticeHandler.execute@start time < 0|start_time=%d|end_time=%d|page=%d", new Object[] { Long.valueOf(startTime), Long.valueOf(endTime), Integer.valueOf(page) }));
/*     */       
/*     */ 
/*  50 */       return;
/*     */     }
/*     */     
/*  53 */     if (endTime != 0L)
/*     */     {
/*  55 */       long now = DateTimeUtils.getCurrTimeInMillis();
/*  56 */       if (endTime <= now)
/*     */       {
/*  58 */         int retcode = Retcode.NOTICE_QUERY_END_TIME_LESS_THAN_NOW.value;
/*  59 */         rsp.retcode = retcode;
/*  60 */         Response response = IdipGmtUtil.getResponse(retcode, "end time <= now");
/*  61 */         rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */         
/*  63 */         GameServer.logger().error(String.format("[gmt]QueryNoticeHandler.execute@end time <= now|start_time=%d|end_time=%d|page=%d", new Object[] { Long.valueOf(startTime), Long.valueOf(endTime), Integer.valueOf(page) }));
/*     */         
/*     */ 
/*  66 */         return;
/*     */       }
/*     */       
/*  69 */       if (startTime >= endTime)
/*     */       {
/*  71 */         int retcode = Retcode.NOTICE_QUERY_START_TIME_GREATER_THAN_END_TIME.value;
/*  72 */         rsp.retcode = retcode;
/*  73 */         Response response = IdipGmtUtil.getResponse(retcode, "start time >= end time");
/*  74 */         rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */         
/*  76 */         GameServer.logger().error(String.format("[gmt]QueryMarqueeHandler.execute@start time >= end time|start_time=%d|end_time=%d|page=%d", new Object[] { Long.valueOf(startTime), Long.valueOf(endTime), Integer.valueOf(page) }));
/*     */         
/*     */ 
/*     */ 
/*  80 */         return;
/*     */       }
/*     */     }
/*     */     
/*  84 */     QueryNoticeRsp queryNoticeRsp = new QueryNoticeRsp();
/*  85 */     List<NoticeDataInfo> list = NoticeInterface.query(startTime, endTime, page);
/*  86 */     if (list.isEmpty())
/*     */     {
/*  88 */       queryNoticeRsp.NoticeList_count = 0;
/*  89 */       queryNoticeRsp.PageNo = page;
/*     */     }
/*     */     else
/*     */     {
/*  93 */       ArrayList<NoticeInfo> noticeList = new ArrayList(list.size());
/*  94 */       int size = list.size(); for (int i = 0; i < size; i++)
/*     */       {
/*  96 */         noticeList.add(transToNoticeInfo((NoticeDataInfo)list.get(i)));
/*     */       }
/*     */       
/*  99 */       queryNoticeRsp.NoticeList_count = noticeList.size();
/* 100 */       queryNoticeRsp.PageNo = page;
/* 101 */       queryNoticeRsp.NoticeList = noticeList;
/*     */     }
/*     */     
/* 104 */     rsp.retcode = Retcode.SUCCESS.value;
/* 105 */     Response response = new Response();
/* 106 */     response.data = queryNoticeRsp;
/* 107 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */     
/* 109 */     GameServer.logger().info(String.format("[gmt]QueryMarqueeHandler.execute@query success|start_time=%d|end_time=%d|page=%d|size=%d", new Object[] { Long.valueOf(startTime), Long.valueOf(endTime), Integer.valueOf(page), Integer.valueOf(queryNoticeRsp.NoticeList_count) }));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private NoticeInfo transToNoticeInfo(NoticeDataInfo notice)
/*     */   {
/* 116 */     NoticeInfo result = new NoticeInfo();
/* 117 */     result.NoticeId = notice.noticeId;
/* 118 */     result.NoticeType = notice.noticeType;
/* 119 */     result.DisplayType = notice.displayType;
/* 120 */     result.HrefType = notice.hrefType;
/* 121 */     result.SendType = notice.sendType;
/* 122 */     result.HrefText = notice.hrefText;
/* 123 */     result.HrefUrl = notice.hrefUrl;
/* 124 */     result.NoticeTitle = notice.noticeTitle;
/* 125 */     result.NoticeContent = notice.noticeContent;
/* 126 */     result.PictureUrl = notice.pictureUrl;
/* 127 */     result.StartTime = TimeUnit.MILLISECONDS.toSeconds(notice.startTime);
/* 128 */     result.EndTime = TimeUnit.MILLISECONDS.toSeconds(notice.endTime);
/* 129 */     result.MinOpenServerDays = notice.minOpenServerDays;
/* 130 */     result.MaxOpenServerDays = notice.maxOpenServerDays;
/* 131 */     result.MinCreatRoleDays = notice.minCreateRoleDays;
/* 132 */     result.MaxCreatRoleDays = notice.maxCreateRoleDays;
/* 133 */     result.MinRoleLevel = notice.minRoleLevel;
/* 134 */     result.MaxRoleLevel = notice.maxRoleLevel;
/* 135 */     result.MinSaveAmt = notice.minSaveAmt;
/* 136 */     result.HighRecharge = notice.maxSaveAmt;
/* 137 */     result.NoticeTag = notice.noticeTag;
/* 138 */     result.Badge = (notice.badge ? 1 : 0);
/* 139 */     result.NoticeSortID = notice.noticeSortID;
/* 140 */     return result;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\QueryNoticeHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */