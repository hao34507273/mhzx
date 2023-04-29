/*     */ package mzm.gsp.idip.main;
/*     */ 
/*     */ import idip.DoSendNoticeReq;
/*     */ import idip.DoSendNoticeRsp;
/*     */ import idip.IDIPCmd_DoSendNoticeReq;
/*     */ import idip.IDIPPacket_DoSendNoticeReq;
/*     */ import idip.IDIPPacket_DoSendNoticeRsp;
/*     */ import idip.core.IdipHeader;
/*     */ import idip.core.Utils;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ 
/*     */ public class PIDIPCmd_DoSendNoticeReq extends PIDIPCmd<IDIPCmd_DoSendNoticeReq>
/*     */ {
/*     */   public PIDIPCmd_DoSendNoticeReq(IDIPCmd_DoSendNoticeReq cmd)
/*     */   {
/*  17 */     super(cmd);
/*     */   }
/*     */   
/*     */   protected boolean handle()
/*     */     throws Exception
/*     */   {
/*  23 */     long noticeId = ((DoSendNoticeReq)((IDIPPacket_DoSendNoticeReq)((IDIPCmd_DoSendNoticeReq)this.cmd).req).body).NoticeId;
/*  24 */     if (NoticeManager.containsNotice(noticeId))
/*     */     {
/*  26 */       onFailed(64295, "notice id duplicated");
/*  27 */       return false;
/*     */     }
/*     */     
/*  30 */     long startTime = TimeUnit.SECONDS.toMillis(((DoSendNoticeReq)((IDIPPacket_DoSendNoticeReq)((IDIPCmd_DoSendNoticeReq)this.cmd).req).body).StartTime);
/*  31 */     long endTime = TimeUnit.SECONDS.toMillis(((DoSendNoticeReq)((IDIPPacket_DoSendNoticeReq)((IDIPCmd_DoSendNoticeReq)this.cmd).req).body).EndTime);
/*     */     
/*  33 */     int noticeType = ((DoSendNoticeReq)((IDIPPacket_DoSendNoticeReq)((IDIPCmd_DoSendNoticeReq)this.cmd).req).body).NoticeType;
/*  34 */     if (noticeType <= 0)
/*     */     {
/*  36 */       onFailed(64316, "noticeType <= 0");
/*  37 */       return false;
/*     */     }
/*     */     
/*  40 */     int displayType = ((DoSendNoticeReq)((IDIPPacket_DoSendNoticeReq)((IDIPCmd_DoSendNoticeReq)this.cmd).req).body).DisplayType;
/*  41 */     if (displayType <= 0)
/*     */     {
/*  43 */       onFailed(64315, "displaType <= 0");
/*  44 */       return false;
/*     */     }
/*     */     
/*  47 */     int hrefType = ((DoSendNoticeReq)((IDIPPacket_DoSendNoticeReq)((IDIPCmd_DoSendNoticeReq)this.cmd).req).body).HrefType;
/*  48 */     if (hrefType <= 0)
/*     */     {
/*  50 */       onFailed(64314, "hrefType <= 0");
/*  51 */       return false;
/*     */     }
/*     */     
/*  54 */     int sendType = ((DoSendNoticeReq)((IDIPPacket_DoSendNoticeReq)((IDIPCmd_DoSendNoticeReq)this.cmd).req).body).SendType;
/*  55 */     if (sendType <= 0)
/*     */     {
/*  57 */       onFailed(64313, "sendType <= 0");
/*  58 */       return false;
/*     */     }
/*     */     
/*  61 */     String noticeTitle = Utils.urlDecode1738(((DoSendNoticeReq)((IDIPPacket_DoSendNoticeReq)((IDIPCmd_DoSendNoticeReq)this.cmd).req).body).NoticeTitle);
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
/*  74 */     String noticeContent = Utils.urlDecode1738(((DoSendNoticeReq)((IDIPPacket_DoSendNoticeReq)((IDIPCmd_DoSendNoticeReq)this.cmd).req).body).NoticeContent);
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
/*  87 */     String hrefText = Utils.urlDecode1738(((DoSendNoticeReq)((IDIPPacket_DoSendNoticeReq)((IDIPCmd_DoSendNoticeReq)this.cmd).req).body).HrefText);
/*  88 */     if (hrefText.length() > 64)
/*     */     {
/*  90 */       onFailed(64298, String.format("hrefText length > %d", new Object[] { Integer.valueOf(64) }));
/*     */       
/*  92 */       return false;
/*     */     }
/*     */     
/*  95 */     String hrefUrl = Utils.urlDecode1738(((DoSendNoticeReq)((IDIPPacket_DoSendNoticeReq)((IDIPCmd_DoSendNoticeReq)this.cmd).req).body).HrefUrl);
/*  96 */     if (hrefUrl.length() > 512)
/*     */     {
/*  98 */       onFailed(64297, String.format("hrefUrl length > %d", new Object[] { Integer.valueOf(512) }));
/*     */       
/* 100 */       return false;
/*     */     }
/*     */     
/* 103 */     String pictureUrl = Utils.urlDecode1738(((DoSendNoticeReq)((IDIPPacket_DoSendNoticeReq)((IDIPCmd_DoSendNoticeReq)this.cmd).req).body).PictureUrl);
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
/* 116 */     long now = DateTimeUtils.getCurrTimeInMillis();
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
/* 133 */     int minOpenServerDays = ((DoSendNoticeReq)((IDIPPacket_DoSendNoticeReq)((IDIPCmd_DoSendNoticeReq)this.cmd).req).body).MinOpenServerDays;
/* 134 */     int maxOpenServerDays = ((DoSendNoticeReq)((IDIPPacket_DoSendNoticeReq)((IDIPCmd_DoSendNoticeReq)this.cmd).req).body).MaxOpenServerDays;
/* 135 */     if ((minOpenServerDays < 0) || (maxOpenServerDays < 0) || (minOpenServerDays > maxOpenServerDays))
/*     */     {
/* 137 */       onFailed(64310, "open server days invalid");
/* 138 */       return false;
/*     */     }
/*     */     
/* 141 */     int minCreateRoleDays = ((DoSendNoticeReq)((IDIPPacket_DoSendNoticeReq)((IDIPCmd_DoSendNoticeReq)this.cmd).req).body).MinCreatRoleDays;
/* 142 */     int maxCreateRoleDays = ((DoSendNoticeReq)((IDIPPacket_DoSendNoticeReq)((IDIPCmd_DoSendNoticeReq)this.cmd).req).body).MaxCreatRoleDays;
/* 143 */     if ((minCreateRoleDays < 0) || (maxCreateRoleDays < 0) || (minCreateRoleDays > maxCreateRoleDays))
/*     */     {
/* 145 */       onFailed(64309, "create role days invalid");
/* 146 */       return false;
/*     */     }
/*     */     
/* 149 */     int minRoleLevel = ((DoSendNoticeReq)((IDIPPacket_DoSendNoticeReq)((IDIPCmd_DoSendNoticeReq)this.cmd).req).body).MinRoleLevel;
/* 150 */     int maxRoleLevel = ((DoSendNoticeReq)((IDIPPacket_DoSendNoticeReq)((IDIPCmd_DoSendNoticeReq)this.cmd).req).body).MaxRoleLevel;
/* 151 */     if ((minRoleLevel < 0) || (maxRoleLevel < 0) || (minRoleLevel > maxRoleLevel))
/*     */     {
/* 153 */       onFailed(64308, "role level invalid");
/* 154 */       return false;
/*     */     }
/*     */     
/* 157 */     long minSaveAmt = ((DoSendNoticeReq)((IDIPPacket_DoSendNoticeReq)((IDIPCmd_DoSendNoticeReq)this.cmd).req).body).MinSaveAmt;
/* 158 */     long maxSaveAmt = ((DoSendNoticeReq)((IDIPPacket_DoSendNoticeReq)((IDIPCmd_DoSendNoticeReq)this.cmd).req).body).MaxSaveAmt;
/* 159 */     if ((minSaveAmt < 0L) || (maxSaveAmt < 0L) || (minSaveAmt > maxSaveAmt))
/*     */     {
/* 161 */       onFailed(64307, "saveAmt invalid");
/* 162 */       return false;
/*     */     }
/*     */     
/* 165 */     int noticeTag = ((DoSendNoticeReq)((IDIPPacket_DoSendNoticeReq)((IDIPCmd_DoSendNoticeReq)this.cmd).req).body).NoticeTag;
/* 166 */     if (noticeTag <= 0)
/*     */     {
/* 168 */       onFailed(64306, "noticeTag <= 0");
/* 169 */       return false;
/*     */     }
/*     */     
/* 172 */     boolean badge = ((DoSendNoticeReq)((IDIPPacket_DoSendNoticeReq)((IDIPCmd_DoSendNoticeReq)this.cmd).req).body).Badge > 0;
/* 173 */     int noticeSortId = ((DoSendNoticeReq)((IDIPPacket_DoSendNoticeReq)((IDIPCmd_DoSendNoticeReq)this.cmd).req).body).NoticeSortID;
/* 174 */     if (noticeSortId < 0)
/*     */     {
/* 176 */       onFailed(64305, "notice sortId < 0");
/* 177 */       return false;
/*     */     }
/*     */     
/* 180 */     NoticeDataInfo notice = new NoticeDataInfo();
/* 181 */     notice.noticeType = noticeType;
/* 182 */     notice.displayType = displayType;
/* 183 */     notice.hrefType = hrefType;
/* 184 */     notice.hrefText = hrefText;
/* 185 */     notice.hrefUrl = hrefUrl;
/* 186 */     notice.sendType = sendType;
/* 187 */     notice.noticeTitle = noticeTitle;
/* 188 */     notice.noticeContent = noticeContent;
/* 189 */     notice.pictureUrl = pictureUrl;
/* 190 */     notice.startTime = startTime;
/* 191 */     notice.endTime = endTime;
/* 192 */     notice.minOpenServerDays = minOpenServerDays;
/* 193 */     notice.maxOpenServerDays = maxOpenServerDays;
/* 194 */     notice.minCreateRoleDays = minCreateRoleDays;
/* 195 */     notice.maxCreateRoleDays = maxCreateRoleDays;
/* 196 */     notice.minRoleLevel = minRoleLevel;
/* 197 */     notice.maxRoleLevel = maxRoleLevel;
/* 198 */     notice.minSaveAmt = minSaveAmt;
/* 199 */     notice.maxSaveAmt = maxSaveAmt;
/* 200 */     notice.noticeTag = noticeTag;
/* 201 */     notice.badge = badge;
/* 202 */     notice.noticeSortID = noticeSortId;
/* 203 */     notice.noticeId = noticeId;
/* 204 */     notice.partition = ((DoSendNoticeReq)((IDIPPacket_DoSendNoticeReq)((IDIPCmd_DoSendNoticeReq)this.cmd).req).body).Partition;
/*     */     
/* 206 */     if (!NoticeManager.addNotice(notice))
/*     */     {
/* 208 */       onFailed(64295, "notice id duplicated");
/* 209 */       return false;
/*     */     }
/*     */     
/* 212 */     String startDesc = "";
/* 213 */     if (startTime <= now)
/*     */     {
/* 215 */       startDesc = Utils.urlEncode1738("公告已经生效", "UTF-8");
/*     */     }
/*     */     else
/*     */     {
/* 219 */       startDesc = Utils.urlEncode1738(String.format("公告将于%s生效，现在时间%s", new Object[] { DateTimeUtils.formatTimestamp(startTime), DateTimeUtils.formatTimestamp(now) }), "UTF-8");
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 224 */     ((DoSendNoticeRsp)((IDIPPacket_DoSendNoticeRsp)((IDIPCmd_DoSendNoticeReq)this.cmd).rsp).body).NoticeId = notice.noticeId;
/* 225 */     ((IDIPPacket_DoSendNoticeRsp)((IDIPCmd_DoSendNoticeReq)this.cmd).rsp).head.Result = (((DoSendNoticeRsp)((IDIPPacket_DoSendNoticeRsp)((IDIPCmd_DoSendNoticeReq)this.cmd).rsp).body).Result = 0);
/* 226 */     ((IDIPPacket_DoSendNoticeRsp)((IDIPCmd_DoSendNoticeReq)this.cmd).rsp).head.RetErrMsg = (((DoSendNoticeRsp)((IDIPPacket_DoSendNoticeRsp)((IDIPCmd_DoSendNoticeReq)this.cmd).rsp).body).RetMsg = startDesc);
/* 227 */     ((IDIPCmd_DoSendNoticeReq)this.cmd).sendResponse();
/*     */     
/* 229 */     mzm.gsp.GameServer.logger().info(String.format("[idip]PIDIPCmd_DoSendNoticeReq.handle@send notice success|ret=%d|ret_msg=%s|area_id=%d|plat_id=%d|partition=%d|notice_type=%d|display_type=%d|href_type=%d|href_text=%s|href_url=%s|send_type=%d|notice_title=%s|notice_content=%s|picture_url=%s|start_time=%d|end_time=%d|MinOpenServerDays=%d|MaxOpenServerDays=%d|MinCreatRoleDays=%d|MaxCreatRoleDays=%d|MinRoleLevel=%d|MaxRoleLevel=%d|MinSaveAmt=%d|MaxSaveAmt=%d|NoticeTag=%d|Badge=%d|NoticeSortID=%d|noticeId=%d", new Object[] { Integer.valueOf(((IDIPPacket_DoSendNoticeRsp)((IDIPCmd_DoSendNoticeReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoSendNoticeRsp)((IDIPCmd_DoSendNoticeReq)this.cmd).rsp).head.RetErrMsg, Integer.valueOf(((DoSendNoticeReq)((IDIPPacket_DoSendNoticeReq)((IDIPCmd_DoSendNoticeReq)this.cmd).req).body).AreaId), Byte.valueOf(((DoSendNoticeReq)((IDIPPacket_DoSendNoticeReq)((IDIPCmd_DoSendNoticeReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoSendNoticeReq)((IDIPPacket_DoSendNoticeReq)((IDIPCmd_DoSendNoticeReq)this.cmd).req).body).Partition), Integer.valueOf(((DoSendNoticeReq)((IDIPPacket_DoSendNoticeReq)((IDIPCmd_DoSendNoticeReq)this.cmd).req).body).NoticeType), Integer.valueOf(((DoSendNoticeReq)((IDIPPacket_DoSendNoticeReq)((IDIPCmd_DoSendNoticeReq)this.cmd).req).body).DisplayType), Integer.valueOf(((DoSendNoticeReq)((IDIPPacket_DoSendNoticeReq)((IDIPCmd_DoSendNoticeReq)this.cmd).req).body).HrefType), ((DoSendNoticeReq)((IDIPPacket_DoSendNoticeReq)((IDIPCmd_DoSendNoticeReq)this.cmd).req).body).HrefText, ((DoSendNoticeReq)((IDIPPacket_DoSendNoticeReq)((IDIPCmd_DoSendNoticeReq)this.cmd).req).body).HrefUrl, Integer.valueOf(((DoSendNoticeReq)((IDIPPacket_DoSendNoticeReq)((IDIPCmd_DoSendNoticeReq)this.cmd).req).body).SendType), ((DoSendNoticeReq)((IDIPPacket_DoSendNoticeReq)((IDIPCmd_DoSendNoticeReq)this.cmd).req).body).NoticeTitle, ((DoSendNoticeReq)((IDIPPacket_DoSendNoticeReq)((IDIPCmd_DoSendNoticeReq)this.cmd).req).body).NoticeContent, ((DoSendNoticeReq)((IDIPPacket_DoSendNoticeReq)((IDIPCmd_DoSendNoticeReq)this.cmd).req).body).PictureUrl, Long.valueOf(((DoSendNoticeReq)((IDIPPacket_DoSendNoticeReq)((IDIPCmd_DoSendNoticeReq)this.cmd).req).body).StartTime), Long.valueOf(((DoSendNoticeReq)((IDIPPacket_DoSendNoticeReq)((IDIPCmd_DoSendNoticeReq)this.cmd).req).body).EndTime), Integer.valueOf(((DoSendNoticeReq)((IDIPPacket_DoSendNoticeReq)((IDIPCmd_DoSendNoticeReq)this.cmd).req).body).MinOpenServerDays), Integer.valueOf(((DoSendNoticeReq)((IDIPPacket_DoSendNoticeReq)((IDIPCmd_DoSendNoticeReq)this.cmd).req).body).MaxOpenServerDays), Integer.valueOf(((DoSendNoticeReq)((IDIPPacket_DoSendNoticeReq)((IDIPCmd_DoSendNoticeReq)this.cmd).req).body).MinCreatRoleDays), Integer.valueOf(((DoSendNoticeReq)((IDIPPacket_DoSendNoticeReq)((IDIPCmd_DoSendNoticeReq)this.cmd).req).body).MaxCreatRoleDays), Integer.valueOf(((DoSendNoticeReq)((IDIPPacket_DoSendNoticeReq)((IDIPCmd_DoSendNoticeReq)this.cmd).req).body).MinRoleLevel), Integer.valueOf(((DoSendNoticeReq)((IDIPPacket_DoSendNoticeReq)((IDIPCmd_DoSendNoticeReq)this.cmd).req).body).MaxRoleLevel), Long.valueOf(((DoSendNoticeReq)((IDIPPacket_DoSendNoticeReq)((IDIPCmd_DoSendNoticeReq)this.cmd).req).body).MinSaveAmt), Long.valueOf(((DoSendNoticeReq)((IDIPPacket_DoSendNoticeReq)((IDIPCmd_DoSendNoticeReq)this.cmd).req).body).MaxSaveAmt), Integer.valueOf(((DoSendNoticeReq)((IDIPPacket_DoSendNoticeReq)((IDIPCmd_DoSendNoticeReq)this.cmd).req).body).NoticeTag), Integer.valueOf(((DoSendNoticeReq)((IDIPPacket_DoSendNoticeReq)((IDIPCmd_DoSendNoticeReq)this.cmd).req).body).Badge), Integer.valueOf(((DoSendNoticeReq)((IDIPPacket_DoSendNoticeReq)((IDIPCmd_DoSendNoticeReq)this.cmd).req).body).NoticeSortID), Long.valueOf(notice.noticeId) }));
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
/* 242 */     return true;
/*     */   }
/*     */   
/*     */   private void onFailed(int ret, String error)
/*     */   {
/* 247 */     ((IDIPPacket_DoSendNoticeRsp)((IDIPCmd_DoSendNoticeReq)this.cmd).rsp).head.Result = (((DoSendNoticeRsp)((IDIPPacket_DoSendNoticeRsp)((IDIPCmd_DoSendNoticeReq)this.cmd).rsp).body).Result = ret);
/* 248 */     ((IDIPPacket_DoSendNoticeRsp)((IDIPCmd_DoSendNoticeReq)this.cmd).rsp).head.RetErrMsg = (((DoSendNoticeRsp)((IDIPPacket_DoSendNoticeRsp)((IDIPCmd_DoSendNoticeReq)this.cmd).rsp).body).RetMsg = error);
/* 249 */     ((IDIPCmd_DoSendNoticeReq)this.cmd).sendResponse();
/*     */     
/* 251 */     mzm.gsp.GameServer.logger().error(String.format("[idip]PIDIPCmd_DoSendNoticeReq.onFailed@%s|ret=%d|ret_msg=%s|area_id=%d|plat_id=%d|partition=%d|notice_type=%d|display_type=%d|href_type=%d|href_text=%s|href_url=%s|send_type=%d|notice_title=%s|notice_content=%s|picture_url=%s|start_time=%d|end_time=%d|MinOpenServerDays=%d|MaxOpenServerDays=%d|MinCreatRoleDays=%d|MaxCreatRoleDays=%d|MinRoleLevel=%d|MaxRoleLevel=%d|MinSaveAmt=%d|MaxSaveAmt=%d|NoticeTag=%d|Badge=%d|NoticeSortID=%d", new Object[] { error, Integer.valueOf(((IDIPPacket_DoSendNoticeRsp)((IDIPCmd_DoSendNoticeReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoSendNoticeRsp)((IDIPCmd_DoSendNoticeReq)this.cmd).rsp).head.RetErrMsg, Integer.valueOf(((DoSendNoticeReq)((IDIPPacket_DoSendNoticeReq)((IDIPCmd_DoSendNoticeReq)this.cmd).req).body).AreaId), Byte.valueOf(((DoSendNoticeReq)((IDIPPacket_DoSendNoticeReq)((IDIPCmd_DoSendNoticeReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoSendNoticeReq)((IDIPPacket_DoSendNoticeReq)((IDIPCmd_DoSendNoticeReq)this.cmd).req).body).Partition), Integer.valueOf(((DoSendNoticeReq)((IDIPPacket_DoSendNoticeReq)((IDIPCmd_DoSendNoticeReq)this.cmd).req).body).NoticeType), Integer.valueOf(((DoSendNoticeReq)((IDIPPacket_DoSendNoticeReq)((IDIPCmd_DoSendNoticeReq)this.cmd).req).body).DisplayType), Integer.valueOf(((DoSendNoticeReq)((IDIPPacket_DoSendNoticeReq)((IDIPCmd_DoSendNoticeReq)this.cmd).req).body).HrefType), ((DoSendNoticeReq)((IDIPPacket_DoSendNoticeReq)((IDIPCmd_DoSendNoticeReq)this.cmd).req).body).HrefText, ((DoSendNoticeReq)((IDIPPacket_DoSendNoticeReq)((IDIPCmd_DoSendNoticeReq)this.cmd).req).body).HrefUrl, Integer.valueOf(((DoSendNoticeReq)((IDIPPacket_DoSendNoticeReq)((IDIPCmd_DoSendNoticeReq)this.cmd).req).body).SendType), ((DoSendNoticeReq)((IDIPPacket_DoSendNoticeReq)((IDIPCmd_DoSendNoticeReq)this.cmd).req).body).NoticeTitle, ((DoSendNoticeReq)((IDIPPacket_DoSendNoticeReq)((IDIPCmd_DoSendNoticeReq)this.cmd).req).body).NoticeContent, ((DoSendNoticeReq)((IDIPPacket_DoSendNoticeReq)((IDIPCmd_DoSendNoticeReq)this.cmd).req).body).PictureUrl, Long.valueOf(((DoSendNoticeReq)((IDIPPacket_DoSendNoticeReq)((IDIPCmd_DoSendNoticeReq)this.cmd).req).body).StartTime), Long.valueOf(((DoSendNoticeReq)((IDIPPacket_DoSendNoticeReq)((IDIPCmd_DoSendNoticeReq)this.cmd).req).body).EndTime), Integer.valueOf(((DoSendNoticeReq)((IDIPPacket_DoSendNoticeReq)((IDIPCmd_DoSendNoticeReq)this.cmd).req).body).MinOpenServerDays), Integer.valueOf(((DoSendNoticeReq)((IDIPPacket_DoSendNoticeReq)((IDIPCmd_DoSendNoticeReq)this.cmd).req).body).MaxOpenServerDays), Integer.valueOf(((DoSendNoticeReq)((IDIPPacket_DoSendNoticeReq)((IDIPCmd_DoSendNoticeReq)this.cmd).req).body).MinCreatRoleDays), Integer.valueOf(((DoSendNoticeReq)((IDIPPacket_DoSendNoticeReq)((IDIPCmd_DoSendNoticeReq)this.cmd).req).body).MaxCreatRoleDays), Integer.valueOf(((DoSendNoticeReq)((IDIPPacket_DoSendNoticeReq)((IDIPCmd_DoSendNoticeReq)this.cmd).req).body).MinRoleLevel), Integer.valueOf(((DoSendNoticeReq)((IDIPPacket_DoSendNoticeReq)((IDIPCmd_DoSendNoticeReq)this.cmd).req).body).MaxRoleLevel), Long.valueOf(((DoSendNoticeReq)((IDIPPacket_DoSendNoticeReq)((IDIPCmd_DoSendNoticeReq)this.cmd).req).body).MinSaveAmt), Long.valueOf(((DoSendNoticeReq)((IDIPPacket_DoSendNoticeReq)((IDIPCmd_DoSendNoticeReq)this.cmd).req).body).MaxSaveAmt), Integer.valueOf(((DoSendNoticeReq)((IDIPPacket_DoSendNoticeReq)((IDIPCmd_DoSendNoticeReq)this.cmd).req).body).NoticeTag), Integer.valueOf(((DoSendNoticeReq)((IDIPPacket_DoSendNoticeReq)((IDIPCmd_DoSendNoticeReq)this.cmd).req).body).Badge), Integer.valueOf(((DoSendNoticeReq)((IDIPPacket_DoSendNoticeReq)((IDIPCmd_DoSendNoticeReq)this.cmd).req).body).NoticeSortID) }));
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
/*     */   protected boolean isGameServerLevelCommand()
/*     */   {
/* 268 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PIDIPCmd_DoSendNoticeReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */