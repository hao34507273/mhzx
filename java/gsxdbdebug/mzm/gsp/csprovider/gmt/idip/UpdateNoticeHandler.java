/*     */ package mzm.gsp.csprovider.gmt.idip;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import csprovider.DataBetweenCspAndGame_Re;
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
/*     */ public class UpdateNoticeHandler
/*     */   implements IdipHandler
/*     */ {
/*     */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp)
/*     */     throws Exception
/*     */   {
/*  21 */     long noticeid = Long.parseLong((String)params.get(0));
/*  22 */     int noticeType = Integer.parseInt((String)params.get(1));
/*  23 */     int displayType = Integer.parseInt((String)params.get(2));
/*     */     
/*  25 */     int hrefType = Integer.parseInt((String)params.get(3));
/*  26 */     String hrefText = (String)params.get(4);
/*  27 */     String hrefUrl = (String)params.get(5);
/*  28 */     int sendType = Integer.parseInt((String)params.get(6));
/*  29 */     String noticeTitle = (String)params.get(7);
/*  30 */     String noticeContent = (String)params.get(8);
/*     */     
/*  32 */     String pictureUrl = (String)params.get(9);
/*     */     
/*  34 */     long startTime = TimeUnit.SECONDS.toMillis(Long.parseLong((String)params.get(10)));
/*  35 */     long endTime = TimeUnit.SECONDS.toMillis(Long.parseLong((String)params.get(11)));
/*     */     
/*  37 */     int minOpenServerDays = Integer.parseInt((String)params.get(12));
/*  38 */     int maxOpenServerDays = Integer.parseInt((String)params.get(13));
/*     */     
/*  40 */     int minCreateRoleDays = Integer.parseInt((String)params.get(14));
/*  41 */     int maxCreateRoleDays = Integer.parseInt((String)params.get(15));
/*     */     
/*  43 */     int minRoleLevel = Integer.parseInt((String)params.get(16));
/*  44 */     int maxRoleLevel = Integer.parseInt((String)params.get(17));
/*     */     
/*  46 */     long minSaveAmt = Integer.parseInt((String)params.get(18));
/*  47 */     long maxSaveAmt = Integer.parseInt((String)params.get(19));
/*     */     
/*  49 */     int noticeTag = Integer.parseInt((String)params.get(20));
/*  50 */     int badge = Integer.parseInt((String)params.get(21));
/*  51 */     int noticeSortId = Integer.parseInt((String)params.get(22));
/*     */     
/*  53 */     if (!NoticeInterface.contains(noticeid))
/*     */     {
/*  55 */       int retcode = Retcode.NOTICE_NOTICE_NOT_EXIST.value;
/*  56 */       rsp.retcode = retcode;
/*  57 */       Response response = IdipGmtUtil.getResponse(retcode, "notice not exist");
/*  58 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  60 */       GameServer.logger().error(String.format("[gmt]UpdateNoticeHandler.execute@notice not exist|noticeid=%d|notice_type=%d|display_type=%d|href_type=%d|href_text=%s|href_url=%s|send_type=%d|notice_title=%s|notice_content=%s|picture_url=%s|start_time=%d|end_time=%d|min_open_server_days=%d|max_open_server_days=%d|min_create_role_days=%d|max_create_role_days=%d|min_role_level=%d|max_role_level=%d|min_save_amt=%d|max_save_amt=%d|notice_tag=%d|badge=%d|notice_sortid=%d", new Object[] { Long.valueOf(noticeid), Integer.valueOf(noticeType), Integer.valueOf(displayType), Integer.valueOf(hrefType), hrefText, hrefUrl, Integer.valueOf(sendType), noticeTitle, noticeContent, pictureUrl, Long.valueOf(startTime), Long.valueOf(endTime), Integer.valueOf(minOpenServerDays), Integer.valueOf(maxOpenServerDays), Integer.valueOf(minCreateRoleDays), Integer.valueOf(maxCreateRoleDays), Integer.valueOf(minRoleLevel), Integer.valueOf(maxRoleLevel), Long.valueOf(minSaveAmt), Long.valueOf(maxSaveAmt), Integer.valueOf(noticeTag), Integer.valueOf(badge), Integer.valueOf(noticeSortId) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  67 */       return;
/*     */     }
/*     */     
/*  70 */     if (noticeType <= 0)
/*     */     {
/*  72 */       int retcode = Retcode.NOTICE_NOTICE_TYPE_INVALID.value;
/*  73 */       rsp.retcode = retcode;
/*  74 */       Response response = IdipGmtUtil.getResponse(retcode, "notice type invalid");
/*  75 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  77 */       GameServer.logger().error(String.format("[gmt]UpdateNoticeHandler.execute@notice type invalid|noticeid=%d|notice_type=%d|display_type=%d|href_type=%d|href_text=%s|href_url=%s|send_type=%d|notice_title=%s|notice_content=%s|picture_url=%s|start_time=%d|end_time=%d|min_open_server_days=%d|max_open_server_days=%d|min_create_role_days=%d|max_create_role_days=%d|min_role_level=%d|max_role_level=%d|min_save_amt=%d|max_save_amt=%d|notice_tag=%d|badge=%d|notice_sortid=%d", new Object[] { Long.valueOf(noticeid), Integer.valueOf(noticeType), Integer.valueOf(displayType), Integer.valueOf(hrefType), hrefText, hrefUrl, Integer.valueOf(sendType), noticeTitle, noticeContent, pictureUrl, Long.valueOf(startTime), Long.valueOf(endTime), Integer.valueOf(minOpenServerDays), Integer.valueOf(maxOpenServerDays), Integer.valueOf(minCreateRoleDays), Integer.valueOf(maxCreateRoleDays), Integer.valueOf(minRoleLevel), Integer.valueOf(maxRoleLevel), Long.valueOf(minSaveAmt), Long.valueOf(maxSaveAmt), Integer.valueOf(noticeTag), Integer.valueOf(badge), Integer.valueOf(noticeSortId) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  84 */       return;
/*     */     }
/*  86 */     if (displayType <= 0)
/*     */     {
/*  88 */       int retcode = Retcode.NOTICE_DISPLAY_TYPE_INVALID.value;
/*  89 */       rsp.retcode = retcode;
/*  90 */       Response response = IdipGmtUtil.getResponse(retcode, "display type invalid");
/*  91 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  93 */       GameServer.logger().error(String.format("[gmt]UpdateNoticeHandler.execute@display type invalid|noticeid=%d|notice_type=%d|display_type=%d|href_type=%d|href_text=%s|href_url=%s|send_type=%d|notice_title=%s|notice_content=%s|picture_url=%s|start_time=%d|end_time=%d|min_open_server_days=%d|max_open_server_days=%d|min_create_role_days=%d|max_create_role_days=%d|min_role_level=%d|max_role_level=%d|min_save_amt=%d|max_save_amt=%d|notice_tag=%d|badge=%d|notice_sortid=%d", new Object[] { Long.valueOf(noticeid), Integer.valueOf(noticeType), Integer.valueOf(displayType), Integer.valueOf(hrefType), hrefText, hrefUrl, Integer.valueOf(sendType), noticeTitle, noticeContent, pictureUrl, Long.valueOf(startTime), Long.valueOf(endTime), Integer.valueOf(minOpenServerDays), Integer.valueOf(maxOpenServerDays), Integer.valueOf(minCreateRoleDays), Integer.valueOf(maxCreateRoleDays), Integer.valueOf(minRoleLevel), Integer.valueOf(maxRoleLevel), Long.valueOf(minSaveAmt), Long.valueOf(maxSaveAmt), Integer.valueOf(noticeTag), Integer.valueOf(badge), Integer.valueOf(noticeSortId) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 100 */       return;
/*     */     }
/* 102 */     if (hrefType <= 0)
/*     */     {
/* 104 */       int retcode = Retcode.NOTICE_HREF_TYPE_INVALID.value;
/* 105 */       rsp.retcode = retcode;
/* 106 */       Response response = IdipGmtUtil.getResponse(retcode, "href type invalid");
/* 107 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/* 109 */       GameServer.logger().error(String.format("[gmt]UpdateNoticeHandler.execute@href type invalid|noticeid=%d|notice_type=%d|display_type=%d|href_type=%d|href_text=%s|href_url=%s|send_type=%d|notice_title=%s|notice_content=%s|picture_url=%s|start_time=%d|end_time=%d|min_open_server_days=%d|max_open_server_days=%d|min_create_role_days=%d|max_create_role_days=%d|min_role_level=%d|max_role_level=%d|min_save_amt=%d|max_save_amt=%d|notice_tag=%d|badge=%d|notice_sortid=%d", new Object[] { Long.valueOf(noticeid), Integer.valueOf(noticeType), Integer.valueOf(displayType), Integer.valueOf(hrefType), hrefText, hrefUrl, Integer.valueOf(sendType), noticeTitle, noticeContent, pictureUrl, Long.valueOf(startTime), Long.valueOf(endTime), Integer.valueOf(minOpenServerDays), Integer.valueOf(maxOpenServerDays), Integer.valueOf(minCreateRoleDays), Integer.valueOf(maxCreateRoleDays), Integer.valueOf(minRoleLevel), Integer.valueOf(maxRoleLevel), Long.valueOf(minSaveAmt), Long.valueOf(maxSaveAmt), Integer.valueOf(noticeTag), Integer.valueOf(badge), Integer.valueOf(noticeSortId) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 116 */       return;
/*     */     }
/*     */     
/* 119 */     if (hrefText.length() > 64)
/*     */     {
/* 121 */       int retcode = Retcode.NOTICE_HREF_TEXT_LEN_INVALID.value;
/* 122 */       rsp.retcode = retcode;
/* 123 */       Response response = IdipGmtUtil.getResponse(retcode, "href text length invalid");
/* 124 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/* 126 */       GameServer.logger().error(String.format("[gmt]UpdateNoticeHandler.execute@href text length invalid|noticeid=%d|notice_type=%d|display_type=%d|href_type=%d|href_text=%s|href_url=%s|send_type=%d|notice_title=%s|notice_content=%s|picture_url=%s|start_time=%d|end_time=%d|min_open_server_days=%d|max_open_server_days=%d|min_create_role_days=%d|max_create_role_days=%d|min_role_level=%d|max_role_level=%d|min_save_amt=%d|max_save_amt=%d|notice_tag=%d|badge=%d|notice_sortid=%d", new Object[] { Long.valueOf(noticeid), Integer.valueOf(noticeType), Integer.valueOf(displayType), Integer.valueOf(hrefType), hrefText, hrefUrl, Integer.valueOf(sendType), noticeTitle, noticeContent, pictureUrl, Long.valueOf(startTime), Long.valueOf(endTime), Integer.valueOf(minOpenServerDays), Integer.valueOf(maxOpenServerDays), Integer.valueOf(minCreateRoleDays), Integer.valueOf(maxCreateRoleDays), Integer.valueOf(minRoleLevel), Integer.valueOf(maxRoleLevel), Long.valueOf(minSaveAmt), Long.valueOf(maxSaveAmt), Integer.valueOf(noticeTag), Integer.valueOf(badge), Integer.valueOf(noticeSortId) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 133 */       return;
/*     */     }
/*     */     
/* 136 */     if (hrefUrl.length() > 512)
/*     */     {
/* 138 */       int retcode = Retcode.NOTICE_HREF_URL_LEN_INVALID.value;
/* 139 */       rsp.retcode = retcode;
/* 140 */       Response response = IdipGmtUtil.getResponse(retcode, "hrefurl length invalid");
/* 141 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/* 143 */       GameServer.logger().error(String.format("[gmt]UpdateNoticeHandler.execute@href url length invalid|noticeid=%d|notice_type=%d|display_type=%d|href_type=%d|href_text=%s|href_url=%s|send_type=%d|notice_title=%s|notice_content=%s|picture_url=%s|start_time=%d|end_time=%d|min_open_server_days=%d|max_open_server_days=%d|min_create_role_days=%d|max_create_role_days=%d|min_role_level=%d|max_role_level=%d|min_save_amt=%d|max_save_amt=%d|notice_tag=%d|badge=%d|notice_sortid=%d", new Object[] { Long.valueOf(noticeid), Integer.valueOf(noticeType), Integer.valueOf(displayType), Integer.valueOf(hrefType), hrefText, hrefUrl, Integer.valueOf(sendType), noticeTitle, noticeContent, pictureUrl, Long.valueOf(startTime), Long.valueOf(endTime), Integer.valueOf(minOpenServerDays), Integer.valueOf(maxOpenServerDays), Integer.valueOf(minCreateRoleDays), Integer.valueOf(maxCreateRoleDays), Integer.valueOf(minRoleLevel), Integer.valueOf(maxRoleLevel), Long.valueOf(minSaveAmt), Long.valueOf(maxSaveAmt), Integer.valueOf(noticeTag), Integer.valueOf(badge), Integer.valueOf(noticeSortId) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 150 */       return;
/*     */     }
/*     */     
/* 153 */     if (sendType <= 0)
/*     */     {
/* 155 */       int retcode = Retcode.NOTICE_SEND_TYPE_INVALID.value;
/* 156 */       rsp.retcode = retcode;
/* 157 */       Response response = IdipGmtUtil.getResponse(retcode, "send type invalid");
/* 158 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/* 160 */       GameServer.logger().error(String.format("[gmt]UpdateNoticeHandler.execute@send type invalid|noticeid=%d|notice_type=%d|display_type=%d|href_type=%d|href_text=%s|href_url=%s|send_type=%d|notice_title=%s|notice_content=%s|picture_url=%s|start_time=%d|end_time=%d|min_open_server_days=%d|max_open_server_days=%d|min_create_role_days=%d|max_create_role_days=%d|min_role_level=%d|max_role_level=%d|min_save_amt=%d|max_save_amt=%d|notice_tag=%d|badge=%d|notice_sortid=%d", new Object[] { Long.valueOf(noticeid), Integer.valueOf(noticeType), Integer.valueOf(displayType), Integer.valueOf(hrefType), hrefText, hrefUrl, Integer.valueOf(sendType), noticeTitle, noticeContent, pictureUrl, Long.valueOf(startTime), Long.valueOf(endTime), Integer.valueOf(minOpenServerDays), Integer.valueOf(maxOpenServerDays), Integer.valueOf(minCreateRoleDays), Integer.valueOf(maxCreateRoleDays), Integer.valueOf(minRoleLevel), Integer.valueOf(maxRoleLevel), Long.valueOf(minSaveAmt), Long.valueOf(maxSaveAmt), Integer.valueOf(noticeTag), Integer.valueOf(badge), Integer.valueOf(noticeSortId) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 167 */       return;
/*     */     }
/*     */     
/* 170 */     if (noticeTitle.isEmpty())
/*     */     {
/* 172 */       int retcode = Retcode.NOTICE_TITLE_LEN_INVALID.value;
/* 173 */       rsp.retcode = retcode;
/* 174 */       Response response = IdipGmtUtil.getResponse(retcode, "notice title length invalid");
/* 175 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/* 177 */       GameServer.logger().error(String.format("[gmt]UpdateNoticeHandler.execute@title length invalid|noticeid=%d|notice_type=%d|display_type=%d|href_type=%d|href_text=%s|href_url=%s|send_type=%d|notice_title=%s|notice_content=%s|picture_url=%s|start_time=%d|end_time=%d|min_open_server_days=%d|max_open_server_days=%d|min_create_role_days=%d|max_create_role_days=%d|min_role_level=%d|max_role_level=%d|min_save_amt=%d|max_save_amt=%d|notice_tag=%d|badge=%d|notice_sortid=%d", new Object[] { Long.valueOf(noticeid), Integer.valueOf(noticeType), Integer.valueOf(displayType), Integer.valueOf(hrefType), hrefText, hrefUrl, Integer.valueOf(sendType), noticeTitle, noticeContent, pictureUrl, Long.valueOf(startTime), Long.valueOf(endTime), Integer.valueOf(minOpenServerDays), Integer.valueOf(maxOpenServerDays), Integer.valueOf(minCreateRoleDays), Integer.valueOf(maxCreateRoleDays), Integer.valueOf(minRoleLevel), Integer.valueOf(maxRoleLevel), Long.valueOf(minSaveAmt), Long.valueOf(maxSaveAmt), Integer.valueOf(noticeTag), Integer.valueOf(badge), Integer.valueOf(noticeSortId) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 184 */       return;
/*     */     }
/* 186 */     if (noticeTitle.length() > 256)
/*     */     {
/* 188 */       int retcode = Retcode.NOTICE_TITLE_LEN_INVALID.value;
/* 189 */       rsp.retcode = retcode;
/* 190 */       Response response = IdipGmtUtil.getResponse(retcode, "notie title length invalid");
/* 191 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/* 193 */       GameServer.logger().error(String.format("[gmt]UpdateNoticeHandler.execute@title length invalid|noticeid=%d|notice_type=%d|display_type=%d|href_type=%d|href_text=%s|href_url=%s|send_type=%d|notice_title=%s|notice_content=%s|picture_url=%s|start_time=%d|end_time=%d|min_open_server_days=%d|max_open_server_days=%d|min_create_role_days=%d|max_create_role_days=%d|min_role_level=%d|max_role_level=%d|min_save_amt=%d|max_save_amt=%d|notice_tag=%d|badge=%d|notice_sortid=%d", new Object[] { Long.valueOf(noticeid), Integer.valueOf(noticeType), Integer.valueOf(displayType), Integer.valueOf(hrefType), hrefText, hrefUrl, Integer.valueOf(sendType), noticeTitle, noticeContent, pictureUrl, Long.valueOf(startTime), Long.valueOf(endTime), Integer.valueOf(minOpenServerDays), Integer.valueOf(maxOpenServerDays), Integer.valueOf(minCreateRoleDays), Integer.valueOf(maxCreateRoleDays), Integer.valueOf(minRoleLevel), Integer.valueOf(maxRoleLevel), Long.valueOf(minSaveAmt), Long.valueOf(maxSaveAmt), Integer.valueOf(noticeTag), Integer.valueOf(badge), Integer.valueOf(noticeSortId) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 200 */       return;
/*     */     }
/*     */     
/* 203 */     if (noticeContent.isEmpty())
/*     */     {
/* 205 */       int retcode = Retcode.NOTICE_CONTENT_LEN_INVALID.value;
/* 206 */       rsp.retcode = retcode;
/* 207 */       Response response = IdipGmtUtil.getResponse(retcode, "notice content length invalid");
/* 208 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/* 210 */       GameServer.logger().error(String.format("[gmt]UpdateNoticeHandler.execute@content length invalid|noticeid=%d|notice_type=%d|display_type=%d|href_type=%d|href_text=%s|href_url=%s|send_type=%d|notice_title=%s|notice_content=%s|picture_url=%s|start_time=%d|end_time=%d|min_open_server_days=%d|max_open_server_days=%d|min_create_role_days=%d|max_create_role_days=%d|min_role_level=%d|max_role_level=%d|min_save_amt=%d|max_save_amt=%d|notice_tag=%d|badge=%d|notice_sortid=%d", new Object[] { Long.valueOf(noticeid), Integer.valueOf(noticeType), Integer.valueOf(displayType), Integer.valueOf(hrefType), hrefText, hrefUrl, Integer.valueOf(sendType), noticeTitle, noticeContent, pictureUrl, Long.valueOf(startTime), Long.valueOf(endTime), Integer.valueOf(minOpenServerDays), Integer.valueOf(maxOpenServerDays), Integer.valueOf(minCreateRoleDays), Integer.valueOf(maxCreateRoleDays), Integer.valueOf(minRoleLevel), Integer.valueOf(maxRoleLevel), Long.valueOf(minSaveAmt), Long.valueOf(maxSaveAmt), Integer.valueOf(noticeTag), Integer.valueOf(badge), Integer.valueOf(noticeSortId) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 217 */       return;
/*     */     }
/* 219 */     if (noticeContent.length() > 3072)
/*     */     {
/* 221 */       int retcode = Retcode.NOTICE_CONTENT_LEN_INVALID.value;
/* 222 */       rsp.retcode = retcode;
/* 223 */       Response response = IdipGmtUtil.getResponse(retcode, "notice content length invalid");
/* 224 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/* 226 */       GameServer.logger().error(String.format("[gmt]UpdateNoticeHandler.execute@content length invalid|noticeid=%d|notice_type=%d|display_type=%d|href_type=%d|href_text=%s|href_url=%s|send_type=%d|notice_title=%s|notice_content=%s|picture_url=%s|start_time=%d|end_time=%d|min_open_server_days=%d|max_open_server_days=%d|min_create_role_days=%d|max_create_role_days=%d|min_role_level=%d|max_role_level=%d|min_save_amt=%d|max_save_amt=%d|notice_tag=%d|badge=%d|notice_sortid=%d", new Object[] { Long.valueOf(noticeid), Integer.valueOf(noticeType), Integer.valueOf(displayType), Integer.valueOf(hrefType), hrefText, hrefUrl, Integer.valueOf(sendType), noticeTitle, noticeContent, pictureUrl, Long.valueOf(startTime), Long.valueOf(endTime), Integer.valueOf(minOpenServerDays), Integer.valueOf(maxOpenServerDays), Integer.valueOf(minCreateRoleDays), Integer.valueOf(maxCreateRoleDays), Integer.valueOf(minRoleLevel), Integer.valueOf(maxRoleLevel), Long.valueOf(minSaveAmt), Long.valueOf(maxSaveAmt), Integer.valueOf(noticeTag), Integer.valueOf(badge), Integer.valueOf(noticeSortId) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 233 */       return;
/*     */     }
/*     */     
/* 236 */     if (pictureUrl.length() > 512)
/*     */     {
/* 238 */       int retcode = Retcode.NOTICE_PICTURE_URL_LEN_INVALID.value;
/* 239 */       rsp.retcode = retcode;
/* 240 */       Response response = IdipGmtUtil.getResponse(retcode, "picture url length invalid");
/* 241 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/* 243 */       GameServer.logger().error(String.format("[gmt]UpdateNoticeHandler.execute@picture url length invalid|noticeid=%d|notice_type=%d|display_type=%d|href_type=%d|href_text=%s|href_url=%s|send_type=%d|notice_title=%s|notice_content=%s|picture_url=%s|start_time=%d|end_time=%d|min_open_server_days=%d|max_open_server_days=%d|min_create_role_days=%d|max_create_role_days=%d|min_role_level=%d|max_role_level=%d|min_save_amt=%d|max_save_amt=%d|notice_tag=%d|badge=%d|notice_sortid=%d", new Object[] { Long.valueOf(noticeid), Integer.valueOf(noticeType), Integer.valueOf(displayType), Integer.valueOf(hrefType), hrefText, hrefUrl, Integer.valueOf(sendType), noticeTitle, noticeContent, pictureUrl, Long.valueOf(startTime), Long.valueOf(endTime), Integer.valueOf(minOpenServerDays), Integer.valueOf(maxOpenServerDays), Integer.valueOf(minCreateRoleDays), Integer.valueOf(maxCreateRoleDays), Integer.valueOf(minRoleLevel), Integer.valueOf(maxRoleLevel), Long.valueOf(minSaveAmt), Long.valueOf(maxSaveAmt), Integer.valueOf(noticeTag), Integer.valueOf(badge), Integer.valueOf(noticeSortId) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 250 */       return;
/*     */     }
/*     */     
/* 253 */     if (startTime < 0L)
/*     */     {
/* 255 */       int retcode = Retcode.NOTICE_START_TIME_INVALID.value;
/* 256 */       rsp.retcode = retcode;
/* 257 */       Response response = IdipGmtUtil.getResponse(retcode, "start time < 0");
/* 258 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/* 260 */       GameServer.logger().error(String.format("[gmt]UpdateNoticeHandler.execute@start time < 0|noticeid=%d|notice_type=%d|display_type=%d|href_type=%d|href_text=%s|href_url=%s|send_type=%d|notice_title=%s|notice_content=%s|picture_url=%s|start_time=%d|end_time=%d|min_open_server_days=%d|max_open_server_days=%d|min_create_role_days=%d|max_create_role_days=%d|min_role_level=%d|max_role_level=%d|min_save_amt=%d|max_save_amt=%d|notice_tag=%d|badge=%d|notice_sortid=%d", new Object[] { Long.valueOf(noticeid), Integer.valueOf(noticeType), Integer.valueOf(displayType), Integer.valueOf(hrefType), hrefText, hrefUrl, Integer.valueOf(sendType), noticeTitle, noticeContent, pictureUrl, Long.valueOf(startTime), Long.valueOf(endTime), Integer.valueOf(minOpenServerDays), Integer.valueOf(maxOpenServerDays), Integer.valueOf(minCreateRoleDays), Integer.valueOf(maxCreateRoleDays), Integer.valueOf(minRoleLevel), Integer.valueOf(maxRoleLevel), Long.valueOf(minSaveAmt), Long.valueOf(maxSaveAmt), Integer.valueOf(noticeTag), Integer.valueOf(badge), Integer.valueOf(noticeSortId) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 267 */       return;
/*     */     }
/* 269 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 270 */     if (endTime != 0L)
/*     */     {
/* 272 */       if ((endTime <= now) || (endTime <= startTime))
/*     */       {
/* 274 */         int retcode = Retcode.NOTICE_END_TIME_INVALID.value;
/* 275 */         rsp.retcode = retcode;
/* 276 */         Response response = IdipGmtUtil.getResponse(retcode, "end time invalid");
/* 277 */         rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */         
/* 279 */         GameServer.logger().error(String.format("[gmt]UpdateNoticeHandler.execute@end time invalid|noticeid=%d|notice_type=%d|display_type=%d|href_type=%d|href_text=%s|href_url=%s|send_type=%d|notice_title=%s|notice_content=%s|picture_url=%s|start_time=%d|end_time=%d|min_open_server_days=%d|max_open_server_days=%d|min_create_role_days=%d|max_create_role_days=%d|min_role_level=%d|max_role_level=%d|min_save_amt=%d|max_save_amt=%d|notice_tag=%d|badge=%d|notice_sortid=%d", new Object[] { Long.valueOf(noticeid), Integer.valueOf(noticeType), Integer.valueOf(displayType), Integer.valueOf(hrefType), hrefText, hrefUrl, Integer.valueOf(sendType), noticeTitle, noticeContent, pictureUrl, Long.valueOf(startTime), Long.valueOf(endTime), Integer.valueOf(minOpenServerDays), Integer.valueOf(maxOpenServerDays), Integer.valueOf(minCreateRoleDays), Integer.valueOf(maxCreateRoleDays), Integer.valueOf(minRoleLevel), Integer.valueOf(maxRoleLevel), Long.valueOf(minSaveAmt), Long.valueOf(maxSaveAmt), Integer.valueOf(noticeTag), Integer.valueOf(badge), Integer.valueOf(noticeSortId) }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 286 */         return;
/*     */       }
/*     */       
/* 289 */       long duration = NoticeInterface.getMinDuration();
/* 290 */       if ((endTime - startTime < duration) || (endTime - now < duration))
/*     */       {
/* 292 */         int retcode = Retcode.NOTICE_DURATION_INVALID.value;
/* 293 */         rsp.retcode = retcode;
/* 294 */         Response response = IdipGmtUtil.getResponse(retcode, "notice duration invalid");
/* 295 */         rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */         
/* 297 */         GameServer.logger().error(String.format("[gmt]UpdateNoticeHandler.execute@duration invalid|noticeid=%d|notice_type=%d|display_type=%d|href_type=%d|href_text=%s|href_url=%s|send_type=%d|notice_title=%s|notice_content=%s|picture_url=%s|start_time=%d|end_time=%d|min_open_server_days=%d|max_open_server_days=%d|min_create_role_days=%d|max_create_role_days=%d|min_role_level=%d|max_role_level=%d|min_save_amt=%d|max_save_amt=%d|notice_tag=%d|badge=%d|notice_sortid=%d", new Object[] { Long.valueOf(noticeid), Integer.valueOf(noticeType), Integer.valueOf(displayType), Integer.valueOf(hrefType), hrefText, hrefUrl, Integer.valueOf(sendType), noticeTitle, noticeContent, pictureUrl, Long.valueOf(startTime), Long.valueOf(endTime), Integer.valueOf(minOpenServerDays), Integer.valueOf(maxOpenServerDays), Integer.valueOf(minCreateRoleDays), Integer.valueOf(maxCreateRoleDays), Integer.valueOf(minRoleLevel), Integer.valueOf(maxRoleLevel), Long.valueOf(minSaveAmt), Long.valueOf(maxSaveAmt), Integer.valueOf(noticeTag), Integer.valueOf(badge), Integer.valueOf(noticeSortId) }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 304 */         return;
/*     */       }
/*     */     }
/*     */     
/* 308 */     if ((minOpenServerDays < 0) || (maxOpenServerDays < 0) || (minOpenServerDays > maxOpenServerDays))
/*     */     {
/* 310 */       int retcode = Retcode.NOTICE_OPEN_SERVER_DAYS_INVALID.value;
/* 311 */       rsp.retcode = retcode;
/* 312 */       Response response = IdipGmtUtil.getResponse(retcode, "open server days invalid");
/* 313 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/* 315 */       GameServer.logger().error(String.format("[gmt]UpdateNoticeHandler.execute@open server days invalid|noticeid=%d|notice_type=%d|display_type=%d|href_type=%d|href_text=%s|href_url=%s|send_type=%d|notice_title=%s|notice_content=%s|picture_url=%s|start_time=%d|end_time=%d|min_open_server_days=%d|max_open_server_days=%d|min_create_role_days=%d|max_create_role_days=%d|min_role_level=%d|max_role_level=%d|min_save_amt=%d|max_save_amt=%d|notice_tag=%d|badge=%d|notice_sortid=%d", new Object[] { Long.valueOf(noticeid), Integer.valueOf(noticeType), Integer.valueOf(displayType), Integer.valueOf(hrefType), hrefText, hrefUrl, Integer.valueOf(sendType), noticeTitle, noticeContent, pictureUrl, Long.valueOf(startTime), Long.valueOf(endTime), Integer.valueOf(minOpenServerDays), Integer.valueOf(maxOpenServerDays), Integer.valueOf(minCreateRoleDays), Integer.valueOf(maxCreateRoleDays), Integer.valueOf(minRoleLevel), Integer.valueOf(maxRoleLevel), Long.valueOf(minSaveAmt), Long.valueOf(maxSaveAmt), Integer.valueOf(noticeTag), Integer.valueOf(badge), Integer.valueOf(noticeSortId) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 322 */       return;
/*     */     }
/*     */     
/* 325 */     if ((minCreateRoleDays < 0) || (maxCreateRoleDays < 0) || (minCreateRoleDays > maxCreateRoleDays))
/*     */     {
/* 327 */       int retcode = Retcode.NOTICE_CREAT_ROLE_DAYS_INVALID.value;
/* 328 */       rsp.retcode = retcode;
/* 329 */       Response response = IdipGmtUtil.getResponse(retcode, "create role days invalid");
/* 330 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/* 332 */       GameServer.logger().error(String.format("[gmt]UpdateNoticeHandler.execute@create role days invalid|noticeid=%d|notice_type=%d|display_type=%d|href_type=%d|href_text=%s|href_url=%s|send_type=%d|notice_title=%s|notice_content=%s|picture_url=%s|start_time=%d|end_time=%d|min_open_server_days=%d|max_open_server_days=%d|min_create_role_days=%d|max_create_role_days=%d|min_role_level=%d|max_role_level=%d|min_save_amt=%d|max_save_amt=%d|notice_tag=%d|badge=%d|notice_sortid=%d", new Object[] { Long.valueOf(noticeid), Integer.valueOf(noticeType), Integer.valueOf(displayType), Integer.valueOf(hrefType), hrefText, hrefUrl, Integer.valueOf(sendType), noticeTitle, noticeContent, pictureUrl, Long.valueOf(startTime), Long.valueOf(endTime), Integer.valueOf(minOpenServerDays), Integer.valueOf(maxOpenServerDays), Integer.valueOf(minCreateRoleDays), Integer.valueOf(maxCreateRoleDays), Integer.valueOf(minRoleLevel), Integer.valueOf(maxRoleLevel), Long.valueOf(minSaveAmt), Long.valueOf(maxSaveAmt), Integer.valueOf(noticeTag), Integer.valueOf(badge), Integer.valueOf(noticeSortId) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 339 */       return;
/*     */     }
/*     */     
/* 342 */     if ((minRoleLevel < 0) || (maxRoleLevel < 0) || (minRoleLevel > maxRoleLevel))
/*     */     {
/* 344 */       int retcode = Retcode.NOTICE_ROLE_LEVEL_INVALID.value;
/* 345 */       rsp.retcode = retcode;
/* 346 */       Response response = IdipGmtUtil.getResponse(retcode, "role level invalid");
/* 347 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/* 349 */       GameServer.logger().error(String.format("[gmt]UpdateNoticeHandler.execute@role level invalid|noticeid=%d|notice_type=%d|display_type=%d|href_type=%d|href_text=%s|href_url=%s|send_type=%d|notice_title=%s|notice_content=%s|picture_url=%s|start_time=%d|end_time=%d|min_open_server_days=%d|max_open_server_days=%d|min_create_role_days=%d|max_create_role_days=%d|min_role_level=%d|max_role_level=%d|min_save_amt=%d|max_save_amt=%d|notice_tag=%d|badge=%d|notice_sortid=%d", new Object[] { Long.valueOf(noticeid), Integer.valueOf(noticeType), Integer.valueOf(displayType), Integer.valueOf(hrefType), hrefText, hrefUrl, Integer.valueOf(sendType), noticeTitle, noticeContent, pictureUrl, Long.valueOf(startTime), Long.valueOf(endTime), Integer.valueOf(minOpenServerDays), Integer.valueOf(maxOpenServerDays), Integer.valueOf(minCreateRoleDays), Integer.valueOf(maxCreateRoleDays), Integer.valueOf(minRoleLevel), Integer.valueOf(maxRoleLevel), Long.valueOf(minSaveAmt), Long.valueOf(maxSaveAmt), Integer.valueOf(noticeTag), Integer.valueOf(badge), Integer.valueOf(noticeSortId) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 356 */       return;
/*     */     }
/*     */     
/* 359 */     if ((minSaveAmt < 0L) || (maxSaveAmt < 0L) || (minSaveAmt > maxSaveAmt))
/*     */     {
/* 361 */       int retcode = Retcode.NOTICE_SAVE_AMT_INVALID.value;
/* 362 */       rsp.retcode = retcode;
/* 363 */       Response response = IdipGmtUtil.getResponse(retcode, "save amt invalid");
/* 364 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/* 366 */       GameServer.logger().error(String.format("[gmt]UpdateNoticeHandler.execute@save amt invalid|noticeid=%d|notice_type=%d|display_type=%d|href_type=%d|href_text=%s|href_url=%s|send_type=%d|notice_title=%s|notice_content=%s|picture_url=%s|start_time=%d|end_time=%d|min_open_server_days=%d|max_open_server_days=%d|min_create_role_days=%d|max_create_role_days=%d|min_role_level=%d|max_role_level=%d|min_save_amt=%d|max_save_amt=%d|notice_tag=%d|badge=%d|notice_sortid=%d", new Object[] { Long.valueOf(noticeid), Integer.valueOf(noticeType), Integer.valueOf(displayType), Integer.valueOf(hrefType), hrefText, hrefUrl, Integer.valueOf(sendType), noticeTitle, noticeContent, pictureUrl, Long.valueOf(startTime), Long.valueOf(endTime), Integer.valueOf(minOpenServerDays), Integer.valueOf(maxOpenServerDays), Integer.valueOf(minCreateRoleDays), Integer.valueOf(maxCreateRoleDays), Integer.valueOf(minRoleLevel), Integer.valueOf(maxRoleLevel), Long.valueOf(minSaveAmt), Long.valueOf(maxSaveAmt), Integer.valueOf(noticeTag), Integer.valueOf(badge), Integer.valueOf(noticeSortId) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 373 */       return;
/*     */     }
/*     */     
/* 376 */     if (noticeTag <= 0)
/*     */     {
/* 378 */       int retcode = Retcode.NOTICE_TAG_INVALID.value;
/* 379 */       rsp.retcode = retcode;
/* 380 */       Response response = IdipGmtUtil.getResponse(retcode, "notice tag <= 0");
/* 381 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/* 383 */       GameServer.logger().error(String.format("[gmt]UpdateNoticeHandler.execute@notice tag invalid|noticeid=%d|notice_type=%d|display_type=%d|href_type=%d|href_text=%s|href_url=%s|send_type=%d|notice_title=%s|notice_content=%s|picture_url=%s|start_time=%d|end_time=%d|min_open_server_days=%d|max_open_server_days=%d|min_create_role_days=%d|max_create_role_days=%d|min_role_level=%d|max_role_level=%d|min_save_amt=%d|max_save_amt=%d|notice_tag=%d|badge=%d|notice_sortid=%d", new Object[] { Long.valueOf(noticeid), Integer.valueOf(noticeType), Integer.valueOf(displayType), Integer.valueOf(hrefType), hrefText, hrefUrl, Integer.valueOf(sendType), noticeTitle, noticeContent, pictureUrl, Long.valueOf(startTime), Long.valueOf(endTime), Integer.valueOf(minOpenServerDays), Integer.valueOf(maxOpenServerDays), Integer.valueOf(minCreateRoleDays), Integer.valueOf(maxCreateRoleDays), Integer.valueOf(minRoleLevel), Integer.valueOf(maxRoleLevel), Long.valueOf(minSaveAmt), Long.valueOf(maxSaveAmt), Integer.valueOf(noticeTag), Integer.valueOf(badge), Integer.valueOf(noticeSortId) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 390 */       return;
/*     */     }
/*     */     
/* 393 */     if (noticeSortId < 0)
/*     */     {
/* 395 */       int retcode = Retcode.NOTICE_SORTID_INVALID.value;
/* 396 */       rsp.retcode = retcode;
/* 397 */       Response response = IdipGmtUtil.getResponse(retcode, "notice sortid < 0");
/* 398 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/* 400 */       GameServer.logger().error(String.format("[gmt]UpdateNoticeHandler.execute@notice sortid invalid|noticeid=%d|notice_type=%d|display_type=%d|href_type=%d|href_text=%s|href_url=%s|send_type=%d|notice_title=%s|notice_content=%s|picture_url=%s|start_time=%d|end_time=%d|min_open_server_days=%d|max_open_server_days=%d|min_create_role_days=%d|max_create_role_days=%d|min_role_level=%d|max_role_level=%d|min_save_amt=%d|max_save_amt=%d|notice_tag=%d|badge=%d|notice_sortid=%d", new Object[] { Long.valueOf(noticeid), Integer.valueOf(noticeType), Integer.valueOf(displayType), Integer.valueOf(hrefType), hrefText, hrefUrl, Integer.valueOf(sendType), noticeTitle, noticeContent, pictureUrl, Long.valueOf(startTime), Long.valueOf(endTime), Integer.valueOf(minOpenServerDays), Integer.valueOf(maxOpenServerDays), Integer.valueOf(minCreateRoleDays), Integer.valueOf(maxCreateRoleDays), Integer.valueOf(minRoleLevel), Integer.valueOf(maxRoleLevel), Long.valueOf(minSaveAmt), Long.valueOf(maxSaveAmt), Integer.valueOf(noticeTag), Integer.valueOf(badge), Integer.valueOf(noticeSortId) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 407 */       return;
/*     */     }
/*     */     
/* 410 */     NoticeDataInfo newNotice = new NoticeDataInfo();
/* 411 */     newNotice.noticeType = noticeType;
/* 412 */     newNotice.displayType = displayType;
/* 413 */     newNotice.hrefType = hrefType;
/* 414 */     newNotice.hrefText = hrefText;
/* 415 */     newNotice.hrefUrl = hrefUrl;
/* 416 */     newNotice.sendType = sendType;
/* 417 */     newNotice.noticeTitle = noticeTitle;
/* 418 */     newNotice.noticeContent = noticeContent;
/* 419 */     newNotice.pictureUrl = pictureUrl;
/* 420 */     newNotice.startTime = startTime;
/* 421 */     newNotice.endTime = endTime;
/* 422 */     newNotice.minOpenServerDays = minOpenServerDays;
/* 423 */     newNotice.maxOpenServerDays = maxOpenServerDays;
/* 424 */     newNotice.minCreateRoleDays = minCreateRoleDays;
/* 425 */     newNotice.maxCreateRoleDays = maxCreateRoleDays;
/* 426 */     newNotice.minRoleLevel = minRoleLevel;
/* 427 */     newNotice.maxRoleLevel = maxRoleLevel;
/* 428 */     newNotice.minSaveAmt = minSaveAmt;
/* 429 */     newNotice.maxSaveAmt = maxSaveAmt;
/* 430 */     newNotice.noticeTag = noticeTag;
/* 431 */     newNotice.badge = (badge == 1);
/* 432 */     newNotice.noticeSortID = noticeSortId;
/* 433 */     newNotice.noticeId = noticeid;
/*     */     
/* 435 */     if (!NoticeInterface.update(noticeid, newNotice))
/*     */     {
/* 437 */       int retcode = Retcode.NOTICE_UPDATE_FAILED.value;
/* 438 */       rsp.retcode = retcode;
/* 439 */       Response response = IdipGmtUtil.getResponse(retcode, "update notice failed");
/* 440 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/* 442 */       GameServer.logger().error(String.format("[gmt]UpdateNoticeHandler.execute@update notice failed|noticeid=%d|notice_type=%d|display_type=%d|href_type=%d|href_text=%s|href_url=%s|send_type=%d|notice_title=%s|notice_content=%s|picture_url=%s|start_time=%d|end_time=%d|min_open_server_days=%d|max_open_server_days=%d|min_create_role_days=%d|max_create_role_days=%d|min_role_level=%d|max_role_level=%d|min_save_amt=%d|max_save_amt=%d|notice_tag=%d|badge=%d|notice_sortid=%d", new Object[] { Long.valueOf(noticeid), Integer.valueOf(noticeType), Integer.valueOf(displayType), Integer.valueOf(hrefType), hrefText, hrefUrl, Integer.valueOf(sendType), noticeTitle, noticeContent, pictureUrl, Long.valueOf(startTime), Long.valueOf(endTime), Integer.valueOf(minOpenServerDays), Integer.valueOf(maxOpenServerDays), Integer.valueOf(minCreateRoleDays), Integer.valueOf(maxCreateRoleDays), Integer.valueOf(minRoleLevel), Integer.valueOf(maxRoleLevel), Long.valueOf(minSaveAmt), Long.valueOf(maxSaveAmt), Integer.valueOf(noticeTag), Integer.valueOf(badge), Integer.valueOf(noticeSortId) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 449 */       return;
/*     */     }
/*     */     
/* 452 */     String startDesc = "";
/* 453 */     if (startTime <= now)
/*     */     {
/* 455 */       startDesc = "公告已经生效";
/*     */     }
/*     */     else
/*     */     {
/* 459 */       startDesc = String.format("公告将于%s生效，现在时间%s", new Object[] { DateTimeUtils.formatTimestamp(startTime), DateTimeUtils.formatTimestamp(now) });
/*     */     }
/*     */     
/*     */ 
/* 463 */     rsp.retcode = Retcode.SUCCESS.value;
/* 464 */     Response response = new Response();
/* 465 */     response.msg = startDesc;
/* 466 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */     
/* 468 */     GameServer.logger().info(String.format("[gmt]UpdateNoticeHandler.execute@update notice success|noticeid=%d|notice_type=%d|display_type=%d|href_type=%d|href_text=%s|href_url=%s|send_type=%d|notice_title=%s|notice_content=%s|picture_url=%s|start_time=%d|end_time=%d|min_open_server_days=%d|max_open_server_days=%d|min_create_role_days=%d|max_create_role_days=%d|min_role_level=%d|max_role_level=%d|min_save_amt=%d|max_save_amt=%d|notice_tag=%d|badge=%d|notice_sortid=%d", new Object[] { Long.valueOf(noticeid), Integer.valueOf(noticeType), Integer.valueOf(displayType), Integer.valueOf(hrefType), hrefText, hrefUrl, Integer.valueOf(sendType), noticeTitle, noticeContent, pictureUrl, Long.valueOf(startTime), Long.valueOf(endTime), Integer.valueOf(minOpenServerDays), Integer.valueOf(maxOpenServerDays), Integer.valueOf(minCreateRoleDays), Integer.valueOf(maxCreateRoleDays), Integer.valueOf(minRoleLevel), Integer.valueOf(maxRoleLevel), Long.valueOf(minSaveAmt), Long.valueOf(maxSaveAmt), Integer.valueOf(noticeTag), Integer.valueOf(badge), Integer.valueOf(noticeSortId) }));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\UpdateNoticeHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */