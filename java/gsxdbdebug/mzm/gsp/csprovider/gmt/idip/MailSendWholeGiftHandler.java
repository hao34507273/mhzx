/*     */ package mzm.gsp.csprovider.gmt.idip;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import csprovider.DataBetweenCspAndGame_Re;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.compensate.main.CompensateInfo;
/*     */ import mzm.gsp.compensate.main.CompensateInterface;
/*     */ import mzm.gsp.csprovider.gmt.GmtCmdManager;
/*     */ import mzm.gsp.csprovider.main.Retcode;
/*     */ import mzm.gsp.item.confbean.SItemCfg;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class MailSendWholeGiftHandler
/*     */   implements IdipHandler
/*     */ {
/*     */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp)
/*     */     throws Exception
/*     */   {
/*  28 */     long beginTime = TimeUnit.SECONDS.toMillis(Long.parseLong((String)params.get(0)));
/*  29 */     long endTime = TimeUnit.SECONDS.toMillis(Long.parseLong((String)params.get(1)));
/*     */     
/*  31 */     int minLevel = Integer.parseInt((String)params.get(2));
/*  32 */     int maxLevel = Integer.parseInt((String)params.get(3));
/*     */     
/*  34 */     String title = (String)params.get(4);
/*  35 */     String content = (String)params.get(5);
/*     */     
/*  37 */     int itemCfgid = Integer.parseInt((String)params.get(6));
/*  38 */     int itemNum = Integer.parseInt((String)params.get(7));
/*  39 */     int moneyType1 = Integer.parseInt((String)params.get(8));
/*  40 */     int moneyNum1 = Integer.parseInt((String)params.get(9));
/*  41 */     int moneyType2 = Integer.parseInt((String)params.get(10));
/*  42 */     int moneyNum2 = Integer.parseInt((String)params.get(11));
/*  43 */     int moneyType3 = Integer.parseInt((String)params.get(12));
/*  44 */     int moneyNum3 = Integer.parseInt((String)params.get(13));
/*     */     
/*  46 */     long minCreateRoleTime = 0L;
/*  47 */     String minCreateRoleTimeStr = (String)params.get(14);
/*  48 */     if ((minCreateRoleTimeStr != null) && (!minCreateRoleTimeStr.isEmpty()))
/*     */     {
/*  50 */       minCreateRoleTime = TimeUnit.SECONDS.toMillis(Integer.parseInt(minCreateRoleTimeStr));
/*     */     }
/*     */     
/*  53 */     long maxCreateRoleTime = 0L;
/*  54 */     String maxCreateRoleTimeStr = (String)params.get(15);
/*  55 */     if ((maxCreateRoleTimeStr != null) && (!maxCreateRoleTimeStr.isEmpty()))
/*     */     {
/*  57 */       maxCreateRoleTime = TimeUnit.SECONDS.toMillis(Integer.parseInt(maxCreateRoleTimeStr));
/*     */     }
/*     */     
/*  60 */     int tagid = 0;
/*  61 */     String tagidStr = (String)params.get(16);
/*  62 */     if ((tagidStr != null) && (!tagidStr.isEmpty()))
/*     */     {
/*  64 */       tagid = Integer.parseInt(tagidStr);
/*     */     }
/*     */     
/*  67 */     if (beginTime < 0L)
/*     */     {
/*  69 */       int retcode = Retcode.MAIL_SEND_WHOLE_GIFT_BEGIN_TIME_INVALID.value;
/*  70 */       rsp.retcode = retcode;
/*  71 */       Response response = IdipGmtUtil.getResponse(retcode, "begin time < 0");
/*  72 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  74 */       GameServer.logger().error(String.format("[gmt]MailSendWholeGiftHandler.execute@begin time < 0|begin_time=%d|end_time=%d|min_level=%d|max_level=%d|title=%s|content=%s|item_cfgid=%d|item_num=%d|money_type1=%d|money_num1=%d|money_type2=%d|money_num2=%d|money_type3=%d|money_num3=%d", new Object[] { Long.valueOf(beginTime), Long.valueOf(endTime), Integer.valueOf(minLevel), Integer.valueOf(maxLevel), title, content, Integer.valueOf(itemCfgid), Integer.valueOf(itemNum), Integer.valueOf(moneyType1), Integer.valueOf(moneyNum1), Integer.valueOf(moneyType2), Integer.valueOf(moneyNum2), Integer.valueOf(moneyType3), Integer.valueOf(moneyNum3) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  79 */       return;
/*     */     }
/*     */     
/*  82 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*  83 */     if (endTime <= now)
/*     */     {
/*  85 */       int retcode = Retcode.MAIL_SEND_WHOLE_GIFT_END_TIME_LESS_THAN_NOW.value;
/*  86 */       rsp.retcode = retcode;
/*  87 */       Response response = IdipGmtUtil.getResponse(retcode, "end time <= now");
/*  88 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  90 */       GameServer.logger().error(String.format("[gmt]MailSendWholeGiftHandler.execute@end time <= now|begin_time=%d|end_time=%d|min_level=%d|max_level=%d|title=%s|content=%s|item_cfgid=%d|item_num=%d|money_type1=%d|money_num1=%d|money_type2=%d|money_num2=%d|money_type3=%d|money_num3=%d", new Object[] { Long.valueOf(beginTime), Long.valueOf(endTime), Integer.valueOf(minLevel), Integer.valueOf(maxLevel), title, content, Integer.valueOf(itemCfgid), Integer.valueOf(itemNum), Integer.valueOf(moneyType1), Integer.valueOf(moneyNum1), Integer.valueOf(moneyType2), Integer.valueOf(moneyNum2), Integer.valueOf(moneyType3), Integer.valueOf(moneyNum3) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  95 */       return;
/*     */     }
/*     */     
/*  98 */     if (beginTime >= endTime)
/*     */     {
/* 100 */       int retcode = Retcode.MAIL_SEND_WHOLE_GIFT_BEGIN_TIME_GREATER_THAN_END_TIME.value;
/* 101 */       rsp.retcode = retcode;
/* 102 */       Response response = IdipGmtUtil.getResponse(retcode, "begin time >= end time");
/* 103 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/* 105 */       GameServer.logger().error(String.format("[gmt]MailSendWholeGiftHandler.execute@begin time >= end time|begin_time=%d|end_time=%d|min_level=%d|max_level=%d|title=%s|content=%s|item_cfgid=%d|item_num=%d|money_type1=%d|money_num1=%d|money_type2=%d|money_num2=%d|money_type3=%d|money_num3=%d", new Object[] { Long.valueOf(beginTime), Long.valueOf(endTime), Integer.valueOf(minLevel), Integer.valueOf(maxLevel), title, content, Integer.valueOf(itemCfgid), Integer.valueOf(itemNum), Integer.valueOf(moneyType1), Integer.valueOf(moneyNum1), Integer.valueOf(moneyType2), Integer.valueOf(moneyNum2), Integer.valueOf(moneyType3), Integer.valueOf(moneyNum3) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 110 */       return;
/*     */     }
/*     */     
/* 113 */     if (minLevel < 0)
/*     */     {
/* 115 */       int retcode = Retcode.MAIL_SEND_WHOLE_GIFT_MIN_LEVEL_INVALID.value;
/* 116 */       rsp.retcode = retcode;
/* 117 */       Response response = IdipGmtUtil.getResponse(retcode, "min level < 0");
/* 118 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/* 120 */       GameServer.logger().error(String.format("[gmt]MailSendWholeGiftHandler.execute@min level < 0|begin_time=%d|end_time=%d|min_level=%d|max_level=%d|title=%s|content=%s|item_cfgid=%d|item_num=%d|money_type1=%d|money_num1=%d|money_type2=%d|money_num2=%d|money_type3=%d|money_num3=%d", new Object[] { Long.valueOf(beginTime), Long.valueOf(endTime), Integer.valueOf(minLevel), Integer.valueOf(maxLevel), title, content, Integer.valueOf(itemCfgid), Integer.valueOf(itemNum), Integer.valueOf(moneyType1), Integer.valueOf(moneyNum1), Integer.valueOf(moneyType2), Integer.valueOf(moneyNum2), Integer.valueOf(moneyType3), Integer.valueOf(moneyNum3) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 125 */       return;
/*     */     }
/*     */     
/* 128 */     if (minLevel > maxLevel)
/*     */     {
/* 130 */       int retcode = Retcode.MAIL_SEND_WHOLE_GIFT_MIN_LEVEL_GREATER_THAN_MAX_LEVEL.value;
/* 131 */       rsp.retcode = retcode;
/* 132 */       Response response = IdipGmtUtil.getResponse(retcode, "min level > max level");
/* 133 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/* 135 */       GameServer.logger().error(String.format("[gmt]MailSendWholeGiftHandler.execute@min level > max level|begin_time=%d|end_time=%d|min_level=%d|max_level=%d|title=%s|content=%s|item_cfgid=%d|item_num=%d|money_type1=%d|money_num1=%d|money_type2=%d|money_num2=%d|money_type3=%d|money_num3=%d", new Object[] { Long.valueOf(beginTime), Long.valueOf(endTime), Integer.valueOf(minLevel), Integer.valueOf(maxLevel), title, content, Integer.valueOf(itemCfgid), Integer.valueOf(itemNum), Integer.valueOf(moneyType1), Integer.valueOf(moneyNum1), Integer.valueOf(moneyType2), Integer.valueOf(moneyNum2), Integer.valueOf(moneyType3), Integer.valueOf(moneyNum3) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 140 */       return;
/*     */     }
/*     */     
/* 143 */     if ((minLevel == 0) && (maxLevel == 0))
/*     */     {
/* 145 */       int retcode = Retcode.MAIL_SEND_WHOLE_GIFT_LEVEL_EQUALS_ZERO.value;
/* 146 */       rsp.retcode = retcode;
/* 147 */       Response response = IdipGmtUtil.getResponse(retcode, "level == 0");
/* 148 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/* 150 */       GameServer.logger().error(String.format("[gmt]MailSendWholeGiftHandler.execute@level == 0|begin_time=%d|end_time=%d|min_level=%d|max_level=%d|title=%s|content=%s|item_cfgid=%d|item_num=%d|money_type1=%d|money_num1=%d|money_type2=%d|money_num2=%d|money_type3=%d|money_num3=%d", new Object[] { Long.valueOf(beginTime), Long.valueOf(endTime), Integer.valueOf(minLevel), Integer.valueOf(maxLevel), title, content, Integer.valueOf(itemCfgid), Integer.valueOf(itemNum), Integer.valueOf(moneyType1), Integer.valueOf(moneyNum1), Integer.valueOf(moneyType2), Integer.valueOf(moneyNum2), Integer.valueOf(moneyType3), Integer.valueOf(moneyNum3) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 155 */       return;
/*     */     }
/*     */     
/* 158 */     if (title.isEmpty())
/*     */     {
/* 160 */       int retcode = Retcode.MAIL_SEND_WHOLE_GIFT_TITLE_EMPTY.value;
/* 161 */       rsp.retcode = retcode;
/* 162 */       Response response = IdipGmtUtil.getResponse(retcode, "title is empty");
/* 163 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/* 165 */       GameServer.logger().error(String.format("[gmt]MailSendWholeGiftHandler.execute@title is empty|begin_time=%d|end_time=%d|min_level=%d|max_level=%d|title=%s|content=%s|item_cfgid=%d|item_num=%d|money_type1=%d|money_num1=%d|money_type2=%d|money_num2=%d|money_type3=%d|money_num3=%d", new Object[] { Long.valueOf(beginTime), Long.valueOf(endTime), Integer.valueOf(minLevel), Integer.valueOf(maxLevel), title, content, Integer.valueOf(itemCfgid), Integer.valueOf(itemNum), Integer.valueOf(moneyType1), Integer.valueOf(moneyNum1), Integer.valueOf(moneyType2), Integer.valueOf(moneyNum2), Integer.valueOf(moneyType3), Integer.valueOf(moneyNum3) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 170 */       return;
/*     */     }
/* 172 */     if (title.length() > 120)
/*     */     {
/* 174 */       int retcode = Retcode.MAIL_SEND_WHOLE_GIFT_TITLE_TOO_LONG.value;
/* 175 */       rsp.retcode = retcode;
/* 176 */       Response response = IdipGmtUtil.getResponse(retcode, "title length > MAX_MAIL_TITLE_LEN");
/* 177 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/* 179 */       GameServer.logger().error(String.format("[gmt]MailSendWholeGiftHandler.execute@title length > MAX_MAIL_TITLE_LEN|begin_time=%d|end_time=%d|min_level=%d|max_level=%d|title=%s|content=%s|item_cfgid=%d|item_num=%d|money_type1=%d|money_num1=%d|money_type2=%d|money_num2=%d|money_type3=%d|money_num3=%d", new Object[] { Long.valueOf(beginTime), Long.valueOf(endTime), Integer.valueOf(minLevel), Integer.valueOf(maxLevel), title, content, Integer.valueOf(itemCfgid), Integer.valueOf(itemNum), Integer.valueOf(moneyType1), Integer.valueOf(moneyNum1), Integer.valueOf(moneyType2), Integer.valueOf(moneyNum2), Integer.valueOf(moneyType3), Integer.valueOf(moneyNum3) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 184 */       return;
/*     */     }
/*     */     
/* 187 */     if (content.isEmpty())
/*     */     {
/* 189 */       int retcode = Retcode.MAIL_SEND_WHOLE_GIFT_CONTENT_EMPTY.value;
/* 190 */       rsp.retcode = retcode;
/* 191 */       Response response = IdipGmtUtil.getResponse(retcode, "content is empty");
/* 192 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/* 194 */       GameServer.logger().error(String.format("[gmt]MailSendWholeGiftHandler.execute@content length is empty|begin_time=%d|end_time=%d|min_level=%d|max_level=%d|title=%s|content=%s|item_cfgid=%d|item_num=%d|money_type1=%d|money_num1=%d|money_type2=%d|money_num2=%d|money_type3=%d|money_num3=%d", new Object[] { Long.valueOf(beginTime), Long.valueOf(endTime), Integer.valueOf(minLevel), Integer.valueOf(maxLevel), title, content, Integer.valueOf(itemCfgid), Integer.valueOf(itemNum), Integer.valueOf(moneyType1), Integer.valueOf(moneyNum1), Integer.valueOf(moneyType2), Integer.valueOf(moneyNum2), Integer.valueOf(moneyType3), Integer.valueOf(moneyNum3) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 199 */       return;
/*     */     }
/* 201 */     if (content.length() > 3200)
/*     */     {
/* 203 */       int retcode = Retcode.MAIL_SEND_WHOLE_GIFT_CONTENT_TOO_LONG.value;
/* 204 */       rsp.retcode = retcode;
/* 205 */       Response response = IdipGmtUtil.getResponse(retcode, "content length > MAX_MAIL_CONTENT_LEN");
/* 206 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/* 208 */       GameServer.logger().error(String.format("[gmt]MailSendWholeGiftHandler.execute@content length > MAX_MAIL_TITLE_LEN|begin_time=%d|end_time=%d|min_level=%d|max_level=%d|title=%s|content=%s|item_cfgid=%d|item_num=%d|money_type1=%d|money_num1=%d|money_type2=%d|money_num2=%d|money_type3=%d|money_num3=%d", new Object[] { Long.valueOf(beginTime), Long.valueOf(endTime), Integer.valueOf(minLevel), Integer.valueOf(maxLevel), title, content, Integer.valueOf(itemCfgid), Integer.valueOf(itemNum), Integer.valueOf(moneyType1), Integer.valueOf(moneyNum1), Integer.valueOf(moneyType2), Integer.valueOf(moneyNum2), Integer.valueOf(moneyType3), Integer.valueOf(moneyNum3) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 213 */       return;
/*     */     }
/*     */     
/* 216 */     Map<Integer, Integer> items = new HashMap();
/* 217 */     if (!itemCheck(items, itemCfgid, itemNum))
/*     */     {
/* 219 */       int retcode = Retcode.MAIL_SEND_WHOLE_GIFT_ITEM_CHECK_FAILED.value;
/* 220 */       rsp.retcode = retcode;
/* 221 */       Response response = IdipGmtUtil.getResponse(retcode, "item check failed");
/* 222 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/* 224 */       GameServer.logger().error(String.format("[gmt]MailSendWholeGiftHandler.execute@item check failed|begin_time=%d|end_time=%d|min_level=%d|max_level=%d|title=%s|content=%s|item_cfgid=%d|item_num=%d|money_type1=%d|money_num1=%d|money_type2=%d|money_num2=%d|money_type3=%d|money_num3=%d", new Object[] { Long.valueOf(beginTime), Long.valueOf(endTime), Integer.valueOf(minLevel), Integer.valueOf(maxLevel), title, content, Integer.valueOf(itemCfgid), Integer.valueOf(itemNum), Integer.valueOf(moneyType1), Integer.valueOf(moneyNum1), Integer.valueOf(moneyType2), Integer.valueOf(moneyNum2), Integer.valueOf(moneyType3), Integer.valueOf(moneyNum3) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 229 */       return;
/*     */     }
/*     */     
/* 232 */     Map<Integer, Integer> currencies = new HashMap();
/* 233 */     if (!parseCurrency(currencies, moneyType1, moneyNum1))
/*     */     {
/* 235 */       int retcode = Retcode.MAIL_SEND_WHOLE_GIFT_MONEY_TYPE.value;
/* 236 */       rsp.retcode = retcode;
/* 237 */       Response response = IdipGmtUtil.getResponse(retcode, "check money_type1 failed");
/* 238 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/* 240 */       GameServer.logger().error(String.format("[gmt]MailSendWholeGiftHandler.execute@parse currency failed|begin_time=%d|end_time=%d|min_level=%d|max_level=%d|title=%s|content=%s|item_cfgid=%d|item_num=%d|money_type1=%d|money_num1=%d|money_type2=%d|money_num2=%d|money_type3=%d|money_num3=%d", new Object[] { Long.valueOf(beginTime), Long.valueOf(endTime), Integer.valueOf(minLevel), Integer.valueOf(maxLevel), title, content, Integer.valueOf(itemCfgid), Integer.valueOf(itemNum), Integer.valueOf(moneyType1), Integer.valueOf(moneyNum1), Integer.valueOf(moneyType2), Integer.valueOf(moneyNum2), Integer.valueOf(moneyType3), Integer.valueOf(moneyNum3) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 245 */       return;
/*     */     }
/* 247 */     if (!parseCurrency(currencies, moneyType2, moneyNum2))
/*     */     {
/* 249 */       int retcode = Retcode.MAIL_SEND_WHOLE_GIFT_MONEY_TYPE.value;
/* 250 */       rsp.retcode = retcode;
/* 251 */       Response response = IdipGmtUtil.getResponse(retcode, "check money_type2 failed");
/* 252 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/* 254 */       GameServer.logger().error(String.format("[gmt]MailSendWholeGiftHandler.execute@parse currency failed|begin_time=%d|end_time=%d|min_level=%d|max_level=%d|title=%s|content=%s|item_cfgid=%d|item_num=%d|money_type1=%d|money_num1=%d|money_type2=%d|money_num2=%d|money_type3=%d|money_num3=%d", new Object[] { Long.valueOf(beginTime), Long.valueOf(endTime), Integer.valueOf(minLevel), Integer.valueOf(maxLevel), title, content, Integer.valueOf(itemCfgid), Integer.valueOf(itemNum), Integer.valueOf(moneyType1), Integer.valueOf(moneyNum1), Integer.valueOf(moneyType2), Integer.valueOf(moneyNum2), Integer.valueOf(moneyType3), Integer.valueOf(moneyNum3) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 259 */       return;
/*     */     }
/* 261 */     if (!parseCurrency(currencies, moneyType3, moneyNum3))
/*     */     {
/* 263 */       int retcode = Retcode.MAIL_SEND_WHOLE_GIFT_BEGIN_TIME_INVALID.value;
/* 264 */       rsp.retcode = retcode;
/* 265 */       Response response = IdipGmtUtil.getResponse(retcode, "check money_type3 failed");
/* 266 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/* 268 */       GameServer.logger().error(String.format("[gmt]MailSendWholeGiftHandler.execute@parse currency failed|begin_time=%d|end_time=%d|min_level=%d|max_level=%d|title=%s|content=%s|item_cfgid=%d|item_num=%d|money_type1=%d|money_num1=%d|money_type2=%d|money_num2=%d|money_type3=%d|money_num3=%d", new Object[] { Long.valueOf(beginTime), Long.valueOf(endTime), Integer.valueOf(minLevel), Integer.valueOf(maxLevel), title, content, Integer.valueOf(itemCfgid), Integer.valueOf(itemNum), Integer.valueOf(moneyType1), Integer.valueOf(moneyNum1), Integer.valueOf(moneyType2), Integer.valueOf(moneyNum2), Integer.valueOf(moneyType3), Integer.valueOf(moneyNum3) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 273 */       return;
/*     */     }
/*     */     
/* 276 */     if ((items.size() == 0) && (currencies.size() == 0))
/*     */     {
/* 278 */       int retcode = Retcode.MAIL_SEND_WHOLE_GIFT_EMPTY.value;
/* 279 */       rsp.retcode = retcode;
/* 280 */       Response response = IdipGmtUtil.getResponse(retcode, "attachment empty");
/* 281 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/* 283 */       GameServer.logger().error(String.format("[gmt]MailSendWholeGiftHandler.execute@attachment empty|begin_time=%d|end_time=%d|min_level=%d|max_level=%d|title=%s|content=%s|item_cfgid=%d|item_num=%d|money_type1=%d|money_num1=%d|money_type2=%d|money_num2=%d|money_type3=%d|money_num3=%d", new Object[] { Long.valueOf(beginTime), Long.valueOf(endTime), Integer.valueOf(minLevel), Integer.valueOf(maxLevel), title, content, Integer.valueOf(itemCfgid), Integer.valueOf(itemNum), Integer.valueOf(moneyType1), Integer.valueOf(moneyNum1), Integer.valueOf(moneyType2), Integer.valueOf(moneyNum2), Integer.valueOf(moneyType3), Integer.valueOf(moneyNum3) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 288 */       return;
/*     */     }
/*     */     
/* 291 */     if (minCreateRoleTime < 0L)
/*     */     {
/* 293 */       int retcode = Retcode.MAIL_SEND_WHOLE_GIFT_MIN_CREATE_ROLE_INVALID.value;
/* 294 */       rsp.retcode = retcode;
/* 295 */       Response response = IdipGmtUtil.getResponse(retcode, "min create role time invalid");
/* 296 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/* 298 */       GameServer.logger().error(String.format("[gmt]MailSendWholeGiftHandler.execute@min create role time invalid|begin_time=%d|end_time=%d|min_level=%d|max_level=%d|title=%s|content=%s|item_cfgid=%d|item_num=%d|money_type1=%d|money_num1=%d|money_type2=%d|money_num2=%d|money_type3=%d|money_num3=%d|min_create_role_time=%d", new Object[] { Long.valueOf(beginTime), Long.valueOf(endTime), Integer.valueOf(minLevel), Integer.valueOf(maxLevel), title, content, Integer.valueOf(itemCfgid), Integer.valueOf(itemNum), Integer.valueOf(moneyType1), Integer.valueOf(moneyNum1), Integer.valueOf(moneyType2), Integer.valueOf(moneyNum2), Integer.valueOf(moneyType3), Integer.valueOf(moneyNum3), Long.valueOf(minCreateRoleTime) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 303 */       return;
/*     */     }
/* 305 */     if (minCreateRoleTime > 0L)
/*     */     {
/* 307 */       if (minCreateRoleTime >= endTime)
/*     */       {
/* 309 */         int retcode = Retcode.MAIL_SEND_WHOLE_GIFT_MIN_CREATE_ROLE_INVALID.value;
/* 310 */         rsp.retcode = retcode;
/* 311 */         Response response = IdipGmtUtil.getResponse(retcode, "min create role time invalid");
/* 312 */         rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */         
/* 314 */         GameServer.logger().error(String.format("[gmt]MailSendWholeGiftHandler.execute@min create role time invalid|begin_time=%d|end_time=%d|min_level=%d|max_level=%d|title=%s|content=%s|item_cfgid=%d|item_num=%d|money_type1=%d|money_num1=%d|money_type2=%d|money_num2=%d|money_type3=%d|money_num3=%d|min_create_role_time=%d", new Object[] { Long.valueOf(beginTime), Long.valueOf(endTime), Integer.valueOf(minLevel), Integer.valueOf(maxLevel), title, content, Integer.valueOf(itemCfgid), Integer.valueOf(itemNum), Integer.valueOf(moneyType1), Integer.valueOf(moneyNum1), Integer.valueOf(moneyType2), Integer.valueOf(moneyNum2), Integer.valueOf(moneyType3), Integer.valueOf(moneyNum3), Long.valueOf(minCreateRoleTime) }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 319 */         return;
/*     */       }
/*     */     }
/*     */     
/* 323 */     if (maxCreateRoleTime < 0L)
/*     */     {
/* 325 */       int retcode = Retcode.MAIL_SEND_WHOLE_GIFT_MAX_CREATE_ROLE_INVALID.value;
/* 326 */       rsp.retcode = retcode;
/* 327 */       Response response = IdipGmtUtil.getResponse(retcode, "max create role time invalid");
/* 328 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/* 330 */       GameServer.logger().error(String.format("[gmt]MailSendWholeGiftHandler.execute@max create role time invalid|begin_time=%d|end_time=%d|min_level=%d|max_level=%d|title=%s|content=%s|item_cfgid=%d|item_num=%d|money_type1=%d|money_num1=%d|money_type2=%d|money_num2=%d|money_type3=%d|money_num3=%d|max_create_role_time=%d", new Object[] { Long.valueOf(beginTime), Long.valueOf(endTime), Integer.valueOf(minLevel), Integer.valueOf(maxLevel), title, content, Integer.valueOf(itemCfgid), Integer.valueOf(itemNum), Integer.valueOf(moneyType1), Integer.valueOf(moneyNum1), Integer.valueOf(moneyType2), Integer.valueOf(moneyNum2), Integer.valueOf(moneyType3), Integer.valueOf(moneyNum3), Long.valueOf(maxCreateRoleTime) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 335 */       return;
/*     */     }
/* 337 */     if (maxCreateRoleTime > 0L)
/*     */     {
/* 339 */       if (maxCreateRoleTime <= beginTime)
/*     */       {
/* 341 */         int retcode = Retcode.MAIL_SEND_WHOLE_GIFT_MAX_CREATE_ROLE_INVALID.value;
/* 342 */         rsp.retcode = retcode;
/* 343 */         Response response = IdipGmtUtil.getResponse(retcode, "max create role time invalid");
/* 344 */         rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */         
/* 346 */         GameServer.logger().error(String.format("[gmt]MailSendWholeGiftHandler.execute@max create role time invalid|begin_time=%d|end_time=%d|min_level=%d|max_level=%d|title=%s|content=%s|item_cfgid=%d|item_num=%d|money_type1=%d|money_num1=%d|money_type2=%d|money_num2=%d|money_type3=%d|money_num3=%d|max_create_role_time=%d", new Object[] { Long.valueOf(beginTime), Long.valueOf(endTime), Integer.valueOf(minLevel), Integer.valueOf(maxLevel), title, content, Integer.valueOf(itemCfgid), Integer.valueOf(itemNum), Integer.valueOf(moneyType1), Integer.valueOf(moneyNum1), Integer.valueOf(moneyType2), Integer.valueOf(moneyNum2), Integer.valueOf(moneyType3), Integer.valueOf(moneyNum3), Long.valueOf(maxCreateRoleTime) }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 351 */         return;
/*     */       }
/* 353 */       if (minCreateRoleTime >= maxCreateRoleTime)
/*     */       {
/* 355 */         int retcode = Retcode.MAIL_SEND_WHOLE_GIFT_MIN_CREATE_ROLE_GREATER_THAN_MAX.value;
/* 356 */         rsp.retcode = retcode;
/* 357 */         Response response = IdipGmtUtil.getResponse(retcode, "mix create time >= max create time");
/* 358 */         rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */         
/* 360 */         GameServer.logger().error(String.format("[gmt]MailSendWholeGiftHandler.execute@max create role time invalid|begin_time=%d|end_time=%d|min_level=%d|max_level=%d|title=%s|content=%s|item_cfgid=%d|item_num=%d|money_type1=%d|money_num1=%d|money_type2=%d|money_num2=%d|money_type3=%d|money_num3=%d|min_create_role_time=%d|max_create_role_time=%d", new Object[] { Long.valueOf(beginTime), Long.valueOf(endTime), Integer.valueOf(minLevel), Integer.valueOf(maxLevel), title, content, Integer.valueOf(itemCfgid), Integer.valueOf(itemNum), Integer.valueOf(moneyType1), Integer.valueOf(moneyNum1), Integer.valueOf(moneyType2), Integer.valueOf(moneyNum2), Integer.valueOf(moneyType3), Integer.valueOf(moneyNum3), Long.valueOf(minCreateRoleTime), Long.valueOf(maxCreateRoleTime) }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 365 */         return;
/*     */       }
/*     */     }
/*     */     
/* 369 */     if (tagid < 0)
/*     */     {
/* 371 */       int retcode = Retcode.MAIL_SEND_WHOLE_GIFT_TAG_INVALID.value;
/* 372 */       rsp.retcode = retcode;
/* 373 */       Response response = IdipGmtUtil.getResponse(retcode, "tagid invalid");
/* 374 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/* 376 */       GameServer.logger().error(String.format("[gmt]MailSendWholeGiftHandler.execute@max create role time invalid|begin_time=%d|end_time=%d|min_level=%d|max_level=%d|title=%s|content=%s|item_cfgid=%d|item_num=%d|money_type1=%d|money_num1=%d|money_type2=%d|money_num2=%d|money_type3=%d|money_num3=%d|min_create_role_time=%d|max_create_role_time=%d|tagid=%d", new Object[] { Long.valueOf(beginTime), Long.valueOf(endTime), Integer.valueOf(minLevel), Integer.valueOf(maxLevel), title, content, Integer.valueOf(itemCfgid), Integer.valueOf(itemNum), Integer.valueOf(moneyType1), Integer.valueOf(moneyNum1), Integer.valueOf(moneyType2), Integer.valueOf(moneyNum2), Integer.valueOf(moneyType3), Integer.valueOf(moneyNum3), Long.valueOf(minCreateRoleTime), Long.valueOf(maxCreateRoleTime), Integer.valueOf(tagid) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 381 */       return;
/*     */     }
/*     */     
/* 384 */     CompensateInfo compensateInfo = new CompensateInfo(1, minLevel, maxLevel, beginTime, endTime, title, content, items, currencies, minCreateRoleTime, maxCreateRoleTime, tagid);
/*     */     
/*     */ 
/* 387 */     if (!CompensateInterface.addCompensate(compensateInfo))
/*     */     {
/* 389 */       int retcode = Retcode.MAIL_SEND_WHOLE_GIFT_FAILED.value;
/* 390 */       rsp.retcode = retcode;
/* 391 */       Response response = IdipGmtUtil.getResponse(retcode, "add compensate failed");
/* 392 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/* 394 */       GameServer.logger().error(String.format("[gmt]MailSendWholeGiftHandler.execute@add compensate failed|begin_time=%d|end_time=%d|min_level=%d|max_level=%d|title=%s|content=%s|item_cfgid=%d|item_num=%d|money_type1=%d|money_num1=%d|money_type2=%d|money_num2=%d|money_type3=%d|money_num3=%d|min_create_role_time=%d|max_create_role_time=%d|tagid=%d", new Object[] { Long.valueOf(beginTime), Long.valueOf(endTime), Integer.valueOf(minLevel), Integer.valueOf(maxLevel), title, content, Integer.valueOf(itemCfgid), Integer.valueOf(itemNum), Integer.valueOf(moneyType1), Integer.valueOf(moneyNum1), Integer.valueOf(moneyType2), Integer.valueOf(moneyNum2), Integer.valueOf(moneyType3), Integer.valueOf(moneyNum3), Long.valueOf(minCreateRoleTime), Long.valueOf(maxCreateRoleTime), Integer.valueOf(tagid) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 399 */       return;
/*     */     }
/*     */     
/*     */ 
/* 403 */     mailSendWholeGiftTLog(new Object[] { Long.valueOf(beginTime), Long.valueOf(endTime), Integer.valueOf(minLevel), Integer.valueOf(maxLevel), title, content, Integer.valueOf(itemCfgid), Integer.valueOf(itemNum), Integer.valueOf(moneyType1), Integer.valueOf(moneyNum1), Integer.valueOf(moneyType2), Integer.valueOf(moneyNum2), Integer.valueOf(moneyType3), Integer.valueOf(moneyNum3), Long.valueOf(minCreateRoleTime), Long.valueOf(maxCreateRoleTime), Integer.valueOf(tagid) });
/*     */     
/*     */ 
/* 406 */     rsp.retcode = Retcode.SUCCESS.value;
/* 407 */     Response response = new Response();
/* 408 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */     
/* 410 */     GameServer.logger().info(String.format("[gmt]MailSendWholeGiftHandler.execute@mail send whole gift success|begin_time=%d|end_time=%d|min_level=%d|max_level=%d|title=%s|content=%s|item_cfgid=%d|item_num=%d|money_type1=%d|money_num1=%d|money_type2=%d|money_num2=%d|money_type3=%d|money_num3=%d|min_create_role_time=%d|max_create_role_time=%d|tagid=%d", new Object[] { Long.valueOf(beginTime), Long.valueOf(endTime), Integer.valueOf(minLevel), Integer.valueOf(maxLevel), title, content, Integer.valueOf(itemCfgid), Integer.valueOf(itemNum), Integer.valueOf(moneyType1), Integer.valueOf(moneyNum1), Integer.valueOf(moneyType2), Integer.valueOf(moneyNum2), Integer.valueOf(moneyType3), Integer.valueOf(moneyNum3), Long.valueOf(minCreateRoleTime), Long.valueOf(maxCreateRoleTime), Integer.valueOf(tagid) }));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private final boolean parseCurrency(Map<Integer, Integer> currencies, int currencyType, int currencyNum)
/*     */   {
/* 419 */     if ((currencyType > 0) && (currencyNum > 0))
/*     */     {
/* 421 */       if (currencyType == 1)
/*     */       {
/* 423 */         return false;
/*     */       }
/*     */       
/* 426 */       if ((currencyType < 1) || (currencyType > 14))
/*     */       {
/* 428 */         return false;
/*     */       }
/*     */       
/* 431 */       Integer oldNum = (Integer)currencies.get(Integer.valueOf(currencyType));
/* 432 */       if (oldNum == null)
/*     */       {
/* 434 */         currencies.put(Integer.valueOf(currencyType), Integer.valueOf(currencyNum));
/*     */       }
/*     */       else
/*     */       {
/* 438 */         currencies.put(Integer.valueOf(currencyType), Integer.valueOf(oldNum.intValue() + currencyNum));
/*     */       }
/*     */     }
/* 441 */     return true;
/*     */   }
/*     */   
/*     */   private boolean itemCheck(Map<Integer, Integer> items, int itemid, int num)
/*     */   {
/* 446 */     if ((itemid <= 0) || (num <= 0))
/*     */     {
/* 448 */       return true;
/*     */     }
/*     */     
/* 451 */     SItemCfg itemCfg = ItemInterface.getSItemCfg(itemid);
/* 452 */     if (itemCfg == null)
/*     */     {
/* 454 */       return false;
/*     */     }
/*     */     
/* 457 */     Integer oldNum = (Integer)items.get(Integer.valueOf(itemid));
/* 458 */     if (oldNum == null)
/*     */     {
/* 460 */       items.put(Integer.valueOf(itemid), Integer.valueOf(num));
/*     */     }
/*     */     else
/*     */     {
/* 464 */       items.put(Integer.valueOf(itemid), Integer.valueOf(oldNum.intValue() + num));
/*     */     }
/* 466 */     return true;
/*     */   }
/*     */   
/*     */   private void mailSendWholeGiftTLog(Object... params)
/*     */   {
/* 471 */     String GameSvrId = String.valueOf(GameServerInfoManager.getZoneId());
/* 472 */     SimpleDateFormat sdf = DateTimeUtils.getSimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/* 473 */     long time = DateTimeUtils.getCurrTimeInMillis();
/* 474 */     String dtEventTime = sdf.format(Long.valueOf(time));
/*     */     
/* 476 */     String vGameAppid = "0";
/* 477 */     int PlatID = -1;
/* 478 */     int iZoneAreaID = GameServerInfoManager.getZoneId();
/* 479 */     String vopenid = "0";
/*     */     
/* 481 */     StringBuffer sb = new StringBuffer();
/* 482 */     sb.append(GameSvrId).append('|');
/* 483 */     sb.append(dtEventTime).append('|');
/* 484 */     sb.append("0").append('|');
/* 485 */     sb.append(-1).append('|');
/* 486 */     sb.append(iZoneAreaID).append('|');
/* 487 */     sb.append("0");
/*     */     
/* 489 */     for (Object colum : params)
/*     */     {
/* 491 */       sb.append("|").append(colum);
/*     */     }
/*     */     
/* 494 */     TLogManager.getInstance().addLog("GMTMailSendWholeGift", sb.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\MailSendWholeGiftHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */