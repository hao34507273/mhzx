/*     */ package mzm.gsp.idip.main;
/*     */ 
/*     */ import idip.IDIPCmd_QueryNoticeReq;
/*     */ import idip.IDIPPacket_QueryNoticeReq;
/*     */ import idip.IDIPPacket_QueryNoticeRsp;
/*     */ import idip.NoticeInfo;
/*     */ import idip.QueryNoticeReq;
/*     */ import idip.QueryNoticeRsp;
/*     */ import idip.core.IdipHeader;
/*     */ import idip.core.Utils;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServer;
/*     */ 
/*     */ public class PIDIPCmd_QueryNoticeReq extends PIDIPCmd<IDIPCmd_QueryNoticeReq>
/*     */ {
/*     */   public PIDIPCmd_QueryNoticeReq(IDIPCmd_QueryNoticeReq cmd)
/*     */   {
/*  21 */     super(cmd);
/*     */   }
/*     */   
/*     */   protected boolean handle()
/*     */     throws Exception
/*     */   {
/*  27 */     long startTime = TimeUnit.SECONDS.toMillis(((QueryNoticeReq)((IDIPPacket_QueryNoticeReq)((IDIPCmd_QueryNoticeReq)this.cmd).req).body).StartTime);
/*  28 */     long endTime = TimeUnit.SECONDS.toMillis(((QueryNoticeReq)((IDIPPacket_QueryNoticeReq)((IDIPCmd_QueryNoticeReq)this.cmd).req).body).EndTime);
/*     */     
/*  30 */     int page = ((QueryNoticeReq)((IDIPPacket_QueryNoticeReq)((IDIPCmd_QueryNoticeReq)this.cmd).req).body).PageNo;
/*  31 */     if (page <= 0)
/*     */     {
/*  33 */       onFailed(64303, "pageNo <= 0");
/*  34 */       return false;
/*     */     }
/*     */     
/*  37 */     if (startTime < 0L)
/*     */     {
/*  39 */       onFailed(64312, "startTime < 0");
/*  40 */       return false;
/*     */     }
/*  42 */     if (endTime != 0L)
/*     */     {
/*  44 */       long now = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/*  45 */       if ((endTime < now) || (endTime <= startTime))
/*     */       {
/*  47 */         onFailed(64311, "endTime invalid");
/*  48 */         return false;
/*     */       }
/*     */     }
/*     */     
/*  52 */     List<NoticeDataInfo> list = NoticeManager.queryNotices(startTime, endTime, page);
/*     */     
/*  54 */     if (list.isEmpty())
/*     */     {
/*  56 */       ((QueryNoticeRsp)((IDIPPacket_QueryNoticeRsp)((IDIPCmd_QueryNoticeReq)this.cmd).rsp).body).NoticeList_count = 0;
/*  57 */       ((QueryNoticeRsp)((IDIPPacket_QueryNoticeRsp)((IDIPCmd_QueryNoticeReq)this.cmd).rsp).body).PageNo = page;
/*     */     }
/*     */     else
/*     */     {
/*  61 */       ArrayList<NoticeInfo> noticeList = new ArrayList(list.size());
/*  62 */       int size = list.size(); for (int i = 0; i < size; i++)
/*     */       {
/*  64 */         noticeList.add(transToNoticeInfo((NoticeDataInfo)list.get(i)));
/*     */       }
/*     */       
/*  67 */       ((QueryNoticeRsp)((IDIPPacket_QueryNoticeRsp)((IDIPCmd_QueryNoticeReq)this.cmd).rsp).body).NoticeList_count = noticeList.size();
/*  68 */       ((QueryNoticeRsp)((IDIPPacket_QueryNoticeRsp)((IDIPCmd_QueryNoticeReq)this.cmd).rsp).body).PageNo = page;
/*  69 */       ((QueryNoticeRsp)((IDIPPacket_QueryNoticeRsp)((IDIPCmd_QueryNoticeReq)this.cmd).rsp).body).NoticeList = noticeList;
/*     */     }
/*     */     
/*  72 */     ((IDIPPacket_QueryNoticeRsp)((IDIPCmd_QueryNoticeReq)this.cmd).rsp).head.Result = (((QueryNoticeRsp)((IDIPPacket_QueryNoticeRsp)((IDIPCmd_QueryNoticeReq)this.cmd).rsp).body).Result = 0);
/*  73 */     ((IDIPPacket_QueryNoticeRsp)((IDIPCmd_QueryNoticeReq)this.cmd).rsp).head.RetErrMsg = (((QueryNoticeRsp)((IDIPPacket_QueryNoticeRsp)((IDIPCmd_QueryNoticeReq)this.cmd).rsp).body).RetMsg = "ok");
/*  74 */     ((IDIPCmd_QueryNoticeReq)this.cmd).sendResponse();
/*     */     
/*  76 */     GameServer.logger().info(String.format("[idip]PIDIPCmd_QueryNoticeReq.handle@query notice success|ret=%d|ret_msg=%s|area_id=%d|plat_id=%d|partition=%d|startTime=%d|endTime=%d|pageNo=%d|noticeCount=%d", new Object[] { Integer.valueOf(((IDIPPacket_QueryNoticeRsp)((IDIPCmd_QueryNoticeReq)this.cmd).rsp).head.Result), ((IDIPPacket_QueryNoticeRsp)((IDIPCmd_QueryNoticeReq)this.cmd).rsp).head.RetErrMsg, Integer.valueOf(((QueryNoticeReq)((IDIPPacket_QueryNoticeReq)((IDIPCmd_QueryNoticeReq)this.cmd).req).body).AreaId), Byte.valueOf(((QueryNoticeReq)((IDIPPacket_QueryNoticeReq)((IDIPCmd_QueryNoticeReq)this.cmd).req).body).PlatId), Integer.valueOf(((QueryNoticeReq)((IDIPPacket_QueryNoticeReq)((IDIPCmd_QueryNoticeReq)this.cmd).req).body).Partition), Long.valueOf(((QueryNoticeReq)((IDIPPacket_QueryNoticeReq)((IDIPCmd_QueryNoticeReq)this.cmd).req).body).StartTime), Long.valueOf(((QueryNoticeReq)((IDIPPacket_QueryNoticeReq)((IDIPCmd_QueryNoticeReq)this.cmd).req).body).EndTime), Integer.valueOf(((QueryNoticeReq)((IDIPPacket_QueryNoticeReq)((IDIPCmd_QueryNoticeReq)this.cmd).req).body).PageNo), Integer.valueOf(((QueryNoticeRsp)((IDIPPacket_QueryNoticeRsp)((IDIPCmd_QueryNoticeReq)this.cmd).rsp).body).NoticeList_count) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  82 */     return true;
/*     */   }
/*     */   
/*     */   private NoticeInfo transToNoticeInfo(NoticeDataInfo notice)
/*     */   {
/*  87 */     NoticeInfo result = new NoticeInfo();
/*  88 */     result.NoticeId = notice.noticeId;
/*  89 */     result.NoticeType = notice.noticeType;
/*  90 */     result.DisplayType = notice.displayType;
/*  91 */     result.HrefType = notice.hrefType;
/*  92 */     result.SendType = notice.sendType;
/*     */     try
/*     */     {
/*  95 */       result.HrefText = Utils.urlEncode1738(notice.hrefText, "UTF-8");
/*  96 */       result.HrefUrl = Utils.urlEncode1738(notice.hrefUrl, "UTF-8");
/*  97 */       result.NoticeTitle = Utils.urlEncode1738(notice.noticeTitle, "UTF-8");
/*  98 */       result.NoticeContent = Utils.urlEncode1738(notice.noticeContent, "UTF-8");
/*  99 */       result.PictureUrl = Utils.urlEncode1738(notice.pictureUrl, "UTF-8");
/*     */     }
/*     */     catch (UnsupportedEncodingException e) {}
/*     */     
/*     */ 
/*     */ 
/* 105 */     result.StartTime = TimeUnit.MILLISECONDS.toSeconds(notice.startTime);
/* 106 */     result.EndTime = TimeUnit.MILLISECONDS.toSeconds(notice.endTime);
/* 107 */     result.MinOpenServerDays = notice.minOpenServerDays;
/* 108 */     result.MaxOpenServerDays = notice.maxOpenServerDays;
/* 109 */     result.MinCreatRoleDays = notice.minCreateRoleDays;
/* 110 */     result.MaxCreatRoleDays = notice.maxCreateRoleDays;
/* 111 */     result.MinRoleLevel = notice.minRoleLevel;
/* 112 */     result.MaxRoleLevel = notice.maxRoleLevel;
/* 113 */     result.MinSaveAmt = notice.minSaveAmt;
/* 114 */     result.HighRecharge = notice.maxSaveAmt;
/* 115 */     result.NoticeTag = notice.noticeTag;
/* 116 */     result.Badge = (notice.badge ? 1 : 0);
/* 117 */     result.NoticeSortID = notice.noticeSortID;
/* 118 */     result.Partition = ((QueryNoticeReq)((IDIPPacket_QueryNoticeReq)((IDIPCmd_QueryNoticeReq)this.cmd).req).body).Partition;
/* 119 */     return result;
/*     */   }
/*     */   
/*     */   private void onFailed(int ret, String desc)
/*     */   {
/* 124 */     ((QueryNoticeRsp)((IDIPPacket_QueryNoticeRsp)((IDIPCmd_QueryNoticeReq)this.cmd).rsp).body).NoticeList_count = 0;
/* 125 */     ((IDIPPacket_QueryNoticeRsp)((IDIPCmd_QueryNoticeReq)this.cmd).rsp).head.Result = (((QueryNoticeRsp)((IDIPPacket_QueryNoticeRsp)((IDIPCmd_QueryNoticeReq)this.cmd).rsp).body).Result = ret);
/* 126 */     ((IDIPPacket_QueryNoticeRsp)((IDIPCmd_QueryNoticeReq)this.cmd).rsp).head.RetErrMsg = (((QueryNoticeRsp)((IDIPPacket_QueryNoticeRsp)((IDIPCmd_QueryNoticeReq)this.cmd).rsp).body).RetMsg = desc);
/* 127 */     ((QueryNoticeRsp)((IDIPPacket_QueryNoticeRsp)((IDIPCmd_QueryNoticeReq)this.cmd).rsp).body).PageNo = ((QueryNoticeReq)((IDIPPacket_QueryNoticeReq)((IDIPCmd_QueryNoticeReq)this.cmd).req).body).PageNo;
/* 128 */     ((IDIPCmd_QueryNoticeReq)this.cmd).sendResponse();
/*     */     
/* 130 */     GameServer.logger().error(String.format("[idip]PIDIPCmd_QueryNoticeReq.onFailed@%s|ret=%d|ret_msg=%s|area_id=%d|plat_id=%d|partition=%d|startTime=%d|endTime=%d|pageNo=%d", new Object[] { desc, Integer.valueOf(((IDIPPacket_QueryNoticeRsp)((IDIPCmd_QueryNoticeReq)this.cmd).rsp).head.Result), ((IDIPPacket_QueryNoticeRsp)((IDIPCmd_QueryNoticeReq)this.cmd).rsp).head.RetErrMsg, Integer.valueOf(((QueryNoticeReq)((IDIPPacket_QueryNoticeReq)((IDIPCmd_QueryNoticeReq)this.cmd).req).body).AreaId), Byte.valueOf(((QueryNoticeReq)((IDIPPacket_QueryNoticeReq)((IDIPCmd_QueryNoticeReq)this.cmd).req).body).PlatId), Integer.valueOf(((QueryNoticeReq)((IDIPPacket_QueryNoticeReq)((IDIPCmd_QueryNoticeReq)this.cmd).req).body).Partition), Long.valueOf(((QueryNoticeReq)((IDIPPacket_QueryNoticeReq)((IDIPCmd_QueryNoticeReq)this.cmd).req).body).StartTime), Long.valueOf(((QueryNoticeReq)((IDIPPacket_QueryNoticeReq)((IDIPCmd_QueryNoticeReq)this.cmd).req).body).EndTime), Integer.valueOf(((QueryNoticeReq)((IDIPPacket_QueryNoticeReq)((IDIPCmd_QueryNoticeReq)this.cmd).req).body).PageNo) }));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected boolean isGameServerLevelCommand()
/*     */   {
/* 141 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PIDIPCmd_QueryNoticeReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */