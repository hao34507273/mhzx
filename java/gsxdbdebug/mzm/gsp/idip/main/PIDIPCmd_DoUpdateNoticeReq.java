/*     */ package mzm.gsp.idip.main;
/*     */ 
/*     */ import idip.DoUpdateNoticeReq;
/*     */ import idip.DoUpdateNoticeRsp;
/*     */ import idip.IDIPCmd_DoUpdateNoticeReq;
/*     */ import idip.IDIPPacket_DoUpdateNoticeReq;
/*     */ import idip.IDIPPacket_DoUpdateNoticeRsp;
/*     */ import idip.core.IdipHeader;
/*     */ import idip.core.Utils;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServer;
/*     */ 
/*     */ public class PIDIPCmd_DoUpdateNoticeReq extends PIDIPCmd<IDIPCmd_DoUpdateNoticeReq>
/*     */ {
/*     */   public PIDIPCmd_DoUpdateNoticeReq(IDIPCmd_DoUpdateNoticeReq cmd)
/*     */   {
/*  17 */     super(cmd);
/*     */   }
/*     */   
/*     */   protected boolean handle()
/*     */     throws Exception
/*     */   {
/*  23 */     long noticeId = ((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).NoticeId;
/*  24 */     if (!NoticeManager.containsNotice(noticeId))
/*     */     {
/*  26 */       onFailed(64304, "notice not exist");
/*  27 */       return false;
/*     */     }
/*     */     
/*  30 */     long startTime = TimeUnit.SECONDS.toMillis(((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).StartTime);
/*  31 */     long endTime = TimeUnit.SECONDS.toMillis(((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).EndTime);
/*     */     
/*  33 */     int noticeType = ((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).NoticeType;
/*  34 */     if (noticeType <= 0)
/*     */     {
/*  36 */       onFailed(64316, "noticeType <= 0");
/*  37 */       return false;
/*     */     }
/*     */     
/*  40 */     int displayType = ((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).DisplayType;
/*  41 */     if (displayType <= 0)
/*     */     {
/*  43 */       onFailed(64315, "displaType <= 0");
/*  44 */       return false;
/*     */     }
/*     */     
/*  47 */     int hrefType = ((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).HrefType;
/*  48 */     if (hrefType <= 0)
/*     */     {
/*  50 */       onFailed(64314, "hrefType <= 0");
/*  51 */       return false;
/*     */     }
/*     */     
/*  54 */     int sendType = ((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).SendType;
/*  55 */     if (sendType <= 0)
/*     */     {
/*  57 */       onFailed(64313, "sendType <= 0");
/*  58 */       return false;
/*     */     }
/*     */     
/*  61 */     String noticeTitle = Utils.urlDecode1738(((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).NoticeTitle);
/*  62 */     if (noticeTitle.isEmpty())
/*     */     {
/*  64 */       onFailed(64300, "notice title is empty");
/*  65 */       return false;
/*     */     }
/*  67 */     if (noticeTitle.length() > 256)
/*     */     {
/*  69 */       onFailed(64300, String.format("notice title length > %d", new Object[] { Integer.valueOf(256) }));
/*     */       
/*  71 */       return false;
/*     */     }
/*     */     
/*  74 */     String noticeContent = Utils.urlDecode1738(((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).NoticeContent);
/*  75 */     if (noticeContent.isEmpty())
/*     */     {
/*  77 */       onFailed(64299, "notice content is empty");
/*  78 */       return false;
/*     */     }
/*  80 */     if (noticeContent.length() > 3072)
/*     */     {
/*  82 */       onFailed(64299, String.format("notice content > %d", new Object[] { Integer.valueOf(3072) }));
/*     */       
/*  84 */       return false;
/*     */     }
/*     */     
/*  87 */     String hrefText = Utils.urlDecode1738(((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).HrefText);
/*  88 */     if (hrefText.length() > 64)
/*     */     {
/*  90 */       onFailed(64298, String.format("hrefText length > %d", new Object[] { Integer.valueOf(64) }));
/*     */       
/*  92 */       return false;
/*     */     }
/*     */     
/*  95 */     String hrefUrl = Utils.urlDecode1738(((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).HrefUrl);
/*  96 */     if (hrefUrl.length() > 512)
/*     */     {
/*  98 */       onFailed(64297, String.format("hrefUrl length > %d", new Object[] { Integer.valueOf(512) }));
/*     */       
/* 100 */       return false;
/*     */     }
/*     */     
/* 103 */     String pictureUrl = Utils.urlDecode1738(((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).PictureUrl);
/* 104 */     if (pictureUrl.length() > 512)
/*     */     {
/* 106 */       onFailed(64296, String.format("pictureUrl length > %d", new Object[] { Integer.valueOf(512) }));
/*     */       
/* 108 */       return false;
/*     */     }
/*     */     
/* 111 */     if (startTime < 0L)
/*     */     {
/* 113 */       onFailed(64312, "startTime < 0");
/* 114 */       return false;
/*     */     }
/* 116 */     long now = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/* 117 */     if (endTime != 0L)
/*     */     {
/* 119 */       if ((endTime <= now) || (endTime <= startTime))
/*     */       {
/* 121 */         onFailed(64311, "endTime invalid");
/* 122 */         return false;
/*     */       }
/*     */       
/* 125 */       if ((endTime - startTime < NoticeManager.DURATION_MILLI_SECONDS) || (endTime - now < NoticeManager.DURATION_MILLI_SECONDS))
/*     */       {
/*     */ 
/* 128 */         onFailed(64301, "duration invalid");
/* 129 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 133 */     int minOpenServerDays = ((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).MinOpenServerDays;
/* 134 */     int maxOpenServerDays = ((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).MaxOpenServerDays;
/* 135 */     if ((minOpenServerDays < 0) || (maxOpenServerDays < 0) || (minOpenServerDays > maxOpenServerDays))
/*     */     {
/* 137 */       onFailed(64310, "open server days invalid");
/* 138 */       return false;
/*     */     }
/*     */     
/* 141 */     int minCreateRoleDays = ((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).MinCreatRoleDays;
/* 142 */     int maxCreateRoleDays = ((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).MaxCreatRoleDays;
/* 143 */     if ((minCreateRoleDays < 0) || (maxCreateRoleDays < 0) || (minCreateRoleDays > maxCreateRoleDays))
/*     */     {
/* 145 */       onFailed(64309, "create role days invalid");
/* 146 */       return false;
/*     */     }
/*     */     
/* 149 */     int minRoleLevel = ((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).MinRoleLevel;
/* 150 */     int maxRoleLevel = ((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).MaxRoleLevel;
/* 151 */     if ((minRoleLevel < 0) || (maxRoleLevel < 0) || (minRoleLevel > maxRoleLevel))
/*     */     {
/* 153 */       onFailed(64308, "role level invalid");
/* 154 */       return false;
/*     */     }
/*     */     
/* 157 */     long minSaveAmt = ((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).MinSaveAmt;
/* 158 */     long maxSaveAmt = ((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).MaxSaveAmt;
/* 159 */     if ((minSaveAmt < 0L) || (maxSaveAmt < 0L) || (minSaveAmt > maxSaveAmt))
/*     */     {
/* 161 */       onFailed(64307, "saveAmt invalid");
/* 162 */       return false;
/*     */     }
/*     */     
/* 165 */     int noticeTag = ((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).NoticeTag;
/* 166 */     if (noticeTag <= 0)
/*     */     {
/* 168 */       onFailed(64306, "noticeTag <= 0");
/* 169 */       return false;
/*     */     }
/*     */     
/* 172 */     boolean badge = ((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).Badge > 0;
/* 173 */     int noticeSortId = ((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).NoticeSortID;
/* 174 */     if (noticeSortId < 0)
/*     */     {
/* 176 */       onFailed(64305, "notice sortId < 0");
/* 177 */       return false;
/*     */     }
/*     */     
/* 180 */     NoticeDataInfo newNotice = new NoticeDataInfo();
/* 181 */     newNotice.noticeType = noticeType;
/* 182 */     newNotice.displayType = displayType;
/* 183 */     newNotice.hrefType = hrefType;
/* 184 */     newNotice.hrefText = hrefText;
/* 185 */     newNotice.hrefUrl = hrefUrl;
/* 186 */     newNotice.sendType = sendType;
/* 187 */     newNotice.noticeTitle = noticeTitle;
/* 188 */     newNotice.noticeContent = noticeContent;
/* 189 */     newNotice.pictureUrl = pictureUrl;
/* 190 */     newNotice.startTime = startTime;
/* 191 */     newNotice.endTime = endTime;
/* 192 */     newNotice.minOpenServerDays = minOpenServerDays;
/* 193 */     newNotice.maxOpenServerDays = maxOpenServerDays;
/* 194 */     newNotice.minCreateRoleDays = minCreateRoleDays;
/* 195 */     newNotice.maxCreateRoleDays = maxCreateRoleDays;
/* 196 */     newNotice.minRoleLevel = minRoleLevel;
/* 197 */     newNotice.maxRoleLevel = maxRoleLevel;
/* 198 */     newNotice.minSaveAmt = minSaveAmt;
/* 199 */     newNotice.maxSaveAmt = maxSaveAmt;
/* 200 */     newNotice.noticeTag = noticeTag;
/* 201 */     newNotice.badge = badge;
/* 202 */     newNotice.noticeSortID = noticeSortId;
/* 203 */     newNotice.noticeId = noticeId;
/* 204 */     newNotice.partition = ((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).Partition;
/*     */     
/* 206 */     boolean success = NoticeManager.updateNoitce(noticeId, newNotice);
/* 207 */     if (!success)
/*     */     {
/* 209 */       ((DoUpdateNoticeRsp)((IDIPPacket_DoUpdateNoticeRsp)((IDIPCmd_DoUpdateNoticeReq)this.cmd).rsp).body).NoticeId = ((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).NoticeId;
/* 210 */       ((IDIPPacket_DoUpdateNoticeRsp)((IDIPCmd_DoUpdateNoticeReq)this.cmd).rsp).head.Result = (((DoUpdateNoticeRsp)((IDIPPacket_DoUpdateNoticeRsp)((IDIPCmd_DoUpdateNoticeReq)this.cmd).rsp).body).Result = 'אַ');
/* 211 */       ((IDIPPacket_DoUpdateNoticeRsp)((IDIPCmd_DoUpdateNoticeReq)this.cmd).rsp).head.RetErrMsg = (((DoUpdateNoticeRsp)((IDIPPacket_DoUpdateNoticeRsp)((IDIPCmd_DoUpdateNoticeReq)this.cmd).rsp).body).RetMsg = "system error");
/* 212 */       ((IDIPCmd_DoUpdateNoticeReq)this.cmd).sendResponse();
/*     */       
/* 214 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoUpdateNoticeReq.handle@update notice failed|ret=%d|ret_msg=%s|area_id=%d|plat_id=%d|partition=%d|noticeId=%d|notice_type=%d|display_type=%d|href_type=%d|href_text=%s|href_url=%s|send_type=%d|notice_title=%s|notice_content=%s|picture_url=%s|start_time=%d|end_time=%d|MinOpenServerDays=%d|MaxOpenServerDays=%d|MinCreatRoleDays=%d|MaxCreatRoleDays=%d|MinRoleLevel=%d|MaxRoleLevel=%d|MinSaveAmt=%d|MaxSaveAmt=%d|NoticeTag=%d|Badge=%d|NoticeSortID=%d|NoticeId=%d", new Object[] { Integer.valueOf(((IDIPPacket_DoUpdateNoticeRsp)((IDIPCmd_DoUpdateNoticeReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoUpdateNoticeRsp)((IDIPCmd_DoUpdateNoticeReq)this.cmd).rsp).head.RetErrMsg, Integer.valueOf(((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).AreaId), Byte.valueOf(((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).Partition), Long.valueOf(((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).NoticeId), Integer.valueOf(((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).NoticeType), Integer.valueOf(((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).DisplayType), Integer.valueOf(((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).HrefType), ((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).HrefText, ((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).HrefUrl, Integer.valueOf(((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).SendType), ((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).NoticeTitle, ((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).NoticeContent, ((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).PictureUrl, Long.valueOf(((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).StartTime), Long.valueOf(((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).EndTime), Integer.valueOf(((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).MinOpenServerDays), Integer.valueOf(((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).MaxOpenServerDays), Integer.valueOf(((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).MinCreatRoleDays), Integer.valueOf(((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).MaxCreatRoleDays), Integer.valueOf(((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).MinRoleLevel), Integer.valueOf(((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).MaxRoleLevel), Long.valueOf(((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).MinSaveAmt), Long.valueOf(((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).MaxSaveAmt), Integer.valueOf(((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).NoticeTag), Integer.valueOf(((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).Badge), Integer.valueOf(((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).NoticeSortID), Long.valueOf(noticeId) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 227 */       return false;
/*     */     }
/*     */     
/* 230 */     String startDesc = "";
/* 231 */     if (startTime <= now)
/*     */     {
/* 233 */       startDesc = Utils.urlEncode1738("公告已经生效", "UTF-8");
/*     */     }
/*     */     else
/*     */     {
/* 237 */       startDesc = Utils.urlEncode1738(String.format("公告将于%s生效，现在时间%s", new Object[] { mzm.gsp.util.DateTimeUtils.formatTimestamp(startTime), mzm.gsp.util.DateTimeUtils.formatTimestamp(now) }), "UTF-8");
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 242 */     ((DoUpdateNoticeRsp)((IDIPPacket_DoUpdateNoticeRsp)((IDIPCmd_DoUpdateNoticeReq)this.cmd).rsp).body).NoticeId = noticeId;
/* 243 */     ((IDIPPacket_DoUpdateNoticeRsp)((IDIPCmd_DoUpdateNoticeReq)this.cmd).rsp).head.Result = (((DoUpdateNoticeRsp)((IDIPPacket_DoUpdateNoticeRsp)((IDIPCmd_DoUpdateNoticeReq)this.cmd).rsp).body).Result = 0);
/* 244 */     ((IDIPPacket_DoUpdateNoticeRsp)((IDIPCmd_DoUpdateNoticeReq)this.cmd).rsp).head.RetErrMsg = (((DoUpdateNoticeRsp)((IDIPPacket_DoUpdateNoticeRsp)((IDIPCmd_DoUpdateNoticeReq)this.cmd).rsp).body).RetMsg = startDesc);
/* 245 */     ((IDIPCmd_DoUpdateNoticeReq)this.cmd).sendResponse();
/*     */     
/* 247 */     GameServer.logger().info(String.format("[idip]PIDIPCmd_DoUpdateNoticeReq.handle@update notice success|ret=%d|ret_msg=%s|area_id=%d|plat_id=%d|partition=%d|notice_type=%d|display_type=%d|href_type=%d|href_text=%s|href_url=%s|send_type=%d|notice_title=%s|notice_content=%s|picture_url=%s|start_time=%d|end_time=%d|MinOpenServerDays=%d|MaxOpenServerDays=%d|MinCreatRoleDays=%d|MaxCreatRoleDays=%d|MinRoleLevel=%d|MaxRoleLevel=%d|MinSaveAmt=%d|MaxSaveAmt=%d|NoticeTag=%d|Badge=%d|NoticeSortID=%d|noticeId=%d", new Object[] { Integer.valueOf(((IDIPPacket_DoUpdateNoticeRsp)((IDIPCmd_DoUpdateNoticeReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoUpdateNoticeRsp)((IDIPCmd_DoUpdateNoticeReq)this.cmd).rsp).head.RetErrMsg, Integer.valueOf(((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).AreaId), Byte.valueOf(((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).Partition), Integer.valueOf(((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).NoticeType), Integer.valueOf(((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).DisplayType), Integer.valueOf(((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).HrefType), ((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).HrefText, ((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).HrefUrl, Integer.valueOf(((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).SendType), ((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).NoticeTitle, ((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).NoticeContent, ((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).PictureUrl, Long.valueOf(((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).StartTime), Long.valueOf(((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).EndTime), Integer.valueOf(((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).MinOpenServerDays), Integer.valueOf(((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).MaxOpenServerDays), Integer.valueOf(((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).MinCreatRoleDays), Integer.valueOf(((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).MaxCreatRoleDays), Integer.valueOf(((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).MinRoleLevel), Integer.valueOf(((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).MaxRoleLevel), Long.valueOf(((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).MinSaveAmt), Long.valueOf(((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).MaxSaveAmt), Integer.valueOf(((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).NoticeTag), Integer.valueOf(((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).Badge), Integer.valueOf(((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).NoticeSortID), Long.valueOf(noticeId) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 260 */     return true;
/*     */   }
/*     */   
/*     */   private void onFailed(int ret, String error)
/*     */   {
/* 265 */     ((DoUpdateNoticeRsp)((IDIPPacket_DoUpdateNoticeRsp)((IDIPCmd_DoUpdateNoticeReq)this.cmd).rsp).body).NoticeId = ((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).NoticeId;
/* 266 */     ((IDIPPacket_DoUpdateNoticeRsp)((IDIPCmd_DoUpdateNoticeReq)this.cmd).rsp).head.Result = (((DoUpdateNoticeRsp)((IDIPPacket_DoUpdateNoticeRsp)((IDIPCmd_DoUpdateNoticeReq)this.cmd).rsp).body).Result = ret);
/* 267 */     ((IDIPPacket_DoUpdateNoticeRsp)((IDIPCmd_DoUpdateNoticeReq)this.cmd).rsp).head.RetErrMsg = (((DoUpdateNoticeRsp)((IDIPPacket_DoUpdateNoticeRsp)((IDIPCmd_DoUpdateNoticeReq)this.cmd).rsp).body).RetMsg = error);
/* 268 */     ((IDIPCmd_DoUpdateNoticeReq)this.cmd).sendResponse();
/*     */     
/* 270 */     GameServer.logger().error(String.format("[idip]PIDIPCmd_DoUpdateNoticeReq.onFailed@%s|ret=%d|ret_msg=%s|area_id=%d|plat_id=%d|partition=%d|noticeId=%d|notice_type=%d|display_type=%d|href_type=%d|href_text=%s|href_url=%s|send_type=%d|notice_title=%s|notice_content=%s|picture_url=%s|start_time=%d|end_time=%d|MinOpenServerDays=%d|MaxOpenServerDays=%d|MinCreatRoleDays=%d|MaxCreatRoleDays=%d|MinRoleLevel=%d|MaxRoleLevel=%d|MinSaveAmt=%d|MaxSaveAmt=%d|NoticeTag=%d|Badge=%d|NoticeSortID=%d|NoticeId=%d", new Object[] { error, Integer.valueOf(((IDIPPacket_DoUpdateNoticeRsp)((IDIPCmd_DoUpdateNoticeReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoUpdateNoticeRsp)((IDIPCmd_DoUpdateNoticeReq)this.cmd).rsp).head.RetErrMsg, Integer.valueOf(((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).AreaId), Byte.valueOf(((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).Partition), Long.valueOf(((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).NoticeId), Integer.valueOf(((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).NoticeType), Integer.valueOf(((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).DisplayType), Integer.valueOf(((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).HrefType), ((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).HrefText, ((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).HrefUrl, Integer.valueOf(((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).SendType), ((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).NoticeTitle, ((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).NoticeContent, ((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).PictureUrl, Long.valueOf(((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).StartTime), Long.valueOf(((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).EndTime), Integer.valueOf(((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).MinOpenServerDays), Integer.valueOf(((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).MaxOpenServerDays), Integer.valueOf(((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).MinCreatRoleDays), Integer.valueOf(((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).MaxCreatRoleDays), Integer.valueOf(((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).MinRoleLevel), Integer.valueOf(((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).MaxRoleLevel), Long.valueOf(((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).MinSaveAmt), Long.valueOf(((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).MaxSaveAmt), Integer.valueOf(((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).NoticeTag), Integer.valueOf(((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).Badge), Integer.valueOf(((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).NoticeSortID), Long.valueOf(((DoUpdateNoticeReq)((IDIPPacket_DoUpdateNoticeReq)((IDIPCmd_DoUpdateNoticeReq)this.cmd).req).body).NoticeId) }));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected boolean isGameServerLevelCommand()
/*     */   {
/* 288 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PIDIPCmd_DoUpdateNoticeReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */