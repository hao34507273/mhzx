/*     */ package mzm.gsp.csprovider.gmt.idip;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import csprovider.DataBetweenCspAndGame_Re;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.csprovider.gmt.GmtCmdManager;
/*     */ import mzm.gsp.csprovider.main.Retcode;
/*     */ import mzm.gsp.idip.main.IDIPCurrencyType;
/*     */ import mzm.gsp.item.confbean.SItemCfg;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.mail.main.MailAttachment;
/*     */ import mzm.gsp.mail.main.MailInterface;
/*     */ import mzm.gsp.mail.main.SendMailRet;
/*     */ import mzm.gsp.mail.main.SendMailRet.RetEnum;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class DoSendItemBySystemMailHandler implements IdipHandler
/*     */ {
/*     */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp) throws Exception
/*     */   {
/*  28 */     String userId = (String)params.get(0);
/*  29 */     long roleid = IdipGmtUtil.getRoleid((String)params.get(1));
/*     */     
/*  31 */     String mailTitle = (String)params.get(2);
/*  32 */     String mailContent = (String)params.get(3);
/*     */     
/*  34 */     int moneyType1 = Integer.parseInt((String)params.get(4));
/*  35 */     int moneyNum1 = Integer.parseInt((String)params.get(5));
/*     */     
/*  37 */     int moneyType2 = Integer.parseInt((String)params.get(6));
/*  38 */     int moneyNum2 = Integer.parseInt((String)params.get(7));
/*     */     
/*  40 */     int moneyType3 = Integer.parseInt((String)params.get(8));
/*  41 */     int moneyNum3 = Integer.parseInt((String)params.get(9));
/*     */     
/*  43 */     int itemCfgid1 = Integer.parseInt((String)params.get(10));
/*  44 */     int itemNum1 = Integer.parseInt((String)params.get(11));
/*     */     
/*  46 */     int itemCfgid2 = Integer.parseInt((String)params.get(12));
/*  47 */     int itemNum2 = Integer.parseInt((String)params.get(13));
/*     */     
/*  49 */     int itemCfgid3 = Integer.parseInt((String)params.get(14));
/*  50 */     int itemNum3 = Integer.parseInt((String)params.get(15));
/*     */     
/*  52 */     int itemCfgid4 = Integer.parseInt((String)params.get(16));
/*  53 */     int itemNum4 = Integer.parseInt((String)params.get(17));
/*     */     
/*  55 */     int tagid = 0;
/*  56 */     String tagParam = (String)params.get(18);
/*  57 */     if ((tagParam != null) && (!tagParam.isEmpty()))
/*     */     {
/*  59 */       tagid = Integer.parseInt(tagParam);
/*     */     }
/*     */     
/*  62 */     xbean.User xUser = xtable.User.get(userId);
/*  63 */     if (null == xUser)
/*     */     {
/*  65 */       int retcode = Retcode.ACCOUNT_NOT_EXIST.value;
/*  66 */       rsp.retcode = retcode;
/*  67 */       Response response = IdipGmtUtil.getResponse(retcode, "user not found");
/*  68 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  70 */       GameServer.logger().error(String.format("[gmt]DoSendItemBySystemMailHandler.execute@user not found|userid=%s|roleid=%d|title=%s|content=%s|money_type1=%d|money_num1=%d|money_type2=%d|money_num2=%d|money_type3=%d|money_num3=%d|item_cfgid1=%d|item_num1=%d|item_cfgid2=%d|item_num2=%d|item_cfgid3=%d|item_num3=%d|item_cfgid4=%d|item_num4=%d", new Object[] { userId, Long.valueOf(roleid), mailTitle, mailContent, Integer.valueOf(moneyType1), Integer.valueOf(moneyNum1), Integer.valueOf(moneyType2), Integer.valueOf(moneyNum2), Integer.valueOf(moneyType3), Integer.valueOf(moneyNum3), Integer.valueOf(itemCfgid1), Integer.valueOf(itemNum1), Integer.valueOf(itemCfgid2), Integer.valueOf(itemNum2), Integer.valueOf(itemCfgid3), Integer.valueOf(itemNum3), Integer.valueOf(itemCfgid4), Integer.valueOf(itemNum4) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  75 */       return;
/*     */     }
/*     */     
/*  78 */     if ((!RoleInterface.isRoleExist(roleid, true)) || (!xUser.getRoleids().contains(Long.valueOf(roleid))))
/*     */     {
/*  80 */       int retcode = Retcode.ROLE_NOT_EXIST.value;
/*  81 */       rsp.retcode = retcode;
/*  82 */       Response response = IdipGmtUtil.getResponse(retcode, "role not found");
/*  83 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  85 */       GameServer.logger().error(String.format("[gmt]DoSendItemBySystemMailHandler.execute@role not found|userid=%s|user_role_list=%s|roleid=%d|title=%s|content=%s|money_type1=%d|money_num1=%d|money_type2=%d|money_num2=%d|money_type3=%d|money_num3=%d|item_cfgid1=%d|item_num1=%d|item_cfgid2=%d|item_num2=%d|item_cfgid3=%d|item_num3=%d|item_cfgid4=%d|item_num4=%d", new Object[] { userId, xUser.getRoleids().toString(), Long.valueOf(roleid), mailTitle, mailContent, Integer.valueOf(moneyType1), Integer.valueOf(moneyNum1), Integer.valueOf(moneyType2), Integer.valueOf(moneyNum2), Integer.valueOf(moneyType3), Integer.valueOf(moneyNum3), Integer.valueOf(itemCfgid1), Integer.valueOf(itemNum1), Integer.valueOf(itemCfgid2), Integer.valueOf(itemNum2), Integer.valueOf(itemCfgid3), Integer.valueOf(itemNum3), Integer.valueOf(itemCfgid4), Integer.valueOf(itemNum4) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  91 */       return;
/*     */     }
/*     */     
/*  94 */     if (mailTitle.isEmpty())
/*     */     {
/*  96 */       int retcode = Retcode.DO_SEND_ITEM_BY_SYSTEM_MAIL_TITLE_EMPTY.value;
/*  97 */       rsp.retcode = retcode;
/*  98 */       Response response = IdipGmtUtil.getResponse(retcode, "mail title is empty");
/*  99 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/* 101 */       GameServer.logger().error(String.format("[gmt]DoSendItemBySystemMailHandler.execute@mail title is empty|userid=%s|roleid=%d|title=%s|content=%s|money_type1=%d|money_num1=%d|money_type2=%d|money_num2=%d|money_type3=%d|money_num3=%d|item_cfgid1=%d|item_num1=%d|item_cfgid2=%d|item_num2=%d|item_cfgid3=%d|item_num3=%d|item_cfgid4=%d|item_num4=%d", new Object[] { userId, Long.valueOf(roleid), mailTitle, mailContent, Integer.valueOf(moneyType1), Integer.valueOf(moneyNum1), Integer.valueOf(moneyType2), Integer.valueOf(moneyNum2), Integer.valueOf(moneyType3), Integer.valueOf(moneyNum3), Integer.valueOf(itemCfgid1), Integer.valueOf(itemNum1), Integer.valueOf(itemCfgid2), Integer.valueOf(itemNum2), Integer.valueOf(itemCfgid3), Integer.valueOf(itemNum3), Integer.valueOf(itemCfgid4), Integer.valueOf(itemNum4) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 106 */       return;
/*     */     }
/* 108 */     if (mailTitle.length() > 120)
/*     */     {
/* 110 */       int retcode = Retcode.DO_SEND_ITEM_BY_SYSTEM_MAIL_TITLE_MAX_LEN.value;
/* 111 */       rsp.retcode = retcode;
/* 112 */       Response response = IdipGmtUtil.getResponse(retcode, String.format("mail title len > %d", new Object[] { Integer.valueOf(120) }));
/*     */       
/* 114 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/* 116 */       GameServer.logger().error(String.format("[gmt]DoSendItemBySystemMailHandler.execute@title length > MAX_MAIL_TITLE_LEN|userid=%s|roleid=%d|title=%s|content=%s|money_type1=%d|money_num1=%d|money_type2=%d|money_num2=%d|money_type3=%d|money_num3=%d|item_cfgid1=%d|item_num1=%d|item_cfgid2=%d|item_num2=%d|item_cfgid3=%d|item_num3=%d|item_cfgid4=%d|item_num4=%d", new Object[] { userId, Long.valueOf(roleid), mailTitle, mailContent, Integer.valueOf(moneyType1), Integer.valueOf(moneyNum1), Integer.valueOf(moneyType2), Integer.valueOf(moneyNum2), Integer.valueOf(moneyType3), Integer.valueOf(moneyNum3), Integer.valueOf(itemCfgid1), Integer.valueOf(itemNum1), Integer.valueOf(itemCfgid2), Integer.valueOf(itemNum2), Integer.valueOf(itemCfgid3), Integer.valueOf(itemNum3), Integer.valueOf(itemCfgid4), Integer.valueOf(itemNum4) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 121 */       return;
/*     */     }
/*     */     
/* 124 */     if (mailContent.isEmpty())
/*     */     {
/* 126 */       int retcode = Retcode.DO_SEND_ITEM_BY_SYSTEM_MAIL_CONTENT_EMPTY.value;
/* 127 */       rsp.retcode = retcode;
/* 128 */       Response response = IdipGmtUtil.getResponse(retcode, "mail content is empty");
/* 129 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/* 131 */       GameServer.logger().error(String.format("[gmt]DoSendItemBySystemMailHandler.execute@content is empty|userid=%s|roleid=%d|title=%s|content=%s|money_type1=%d|money_num1=%d|money_type2=%d|money_num2=%d|money_type3=%d|money_num3=%d|item_cfgid1=%d|item_num1=%d|item_cfgid2=%d|item_num2=%d|item_cfgid3=%d|item_num3=%d|item_cfgid4=%d|item_num4=%d", new Object[] { userId, Long.valueOf(roleid), mailTitle, mailContent, Integer.valueOf(moneyType1), Integer.valueOf(moneyNum1), Integer.valueOf(moneyType2), Integer.valueOf(moneyNum2), Integer.valueOf(moneyType3), Integer.valueOf(moneyNum3), Integer.valueOf(itemCfgid1), Integer.valueOf(itemNum1), Integer.valueOf(itemCfgid2), Integer.valueOf(itemNum2), Integer.valueOf(itemCfgid3), Integer.valueOf(itemNum3), Integer.valueOf(itemCfgid4), Integer.valueOf(itemNum4) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 136 */       return;
/*     */     }
/* 138 */     if (mailContent.length() > 3200)
/*     */     {
/* 140 */       int retcode = Retcode.DO_SEND_ITEM_BY_SYSTEM_MAIL_CONTENT_MAX_LEN.value;
/* 141 */       rsp.retcode = retcode;
/* 142 */       Response response = IdipGmtUtil.getResponse(retcode, String.format("mail content len > %d", new Object[] { Integer.valueOf(3200) }));
/*     */       
/* 144 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/* 146 */       GameServer.logger().error(String.format("[gmt]DoSendItemBySystemMailHandler.execute@content length > MAX_MAIL_CONTENT_LEN|userid=%s|roleid=%d|title=%s|content=%s|money_type1=%d|money_num1=%d|money_type2=%d|money_num2=%d|money_type3=%d|money_num3=%d|item_cfgid1=%d|item_num1=%d|item_cfgid2=%d|item_num2=%d|item_cfgid3=%d|item_num3=%d|item_cfgid4=%d|item_num4=%d", new Object[] { userId, Long.valueOf(roleid), mailTitle, mailContent, Integer.valueOf(moneyType1), Integer.valueOf(moneyNum1), Integer.valueOf(moneyType2), Integer.valueOf(moneyNum2), Integer.valueOf(moneyType3), Integer.valueOf(moneyNum3), Integer.valueOf(itemCfgid1), Integer.valueOf(itemNum1), Integer.valueOf(itemCfgid2), Integer.valueOf(itemNum2), Integer.valueOf(itemCfgid3), Integer.valueOf(itemNum3), Integer.valueOf(itemCfgid4), Integer.valueOf(itemNum4) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 151 */       return;
/*     */     }
/*     */     
/*     */ 
/* 155 */     Map<Integer, Integer> items = new HashMap();
/* 156 */     if (!itemCheck(items, itemCfgid1, itemNum1))
/*     */     {
/* 158 */       int retcode = Retcode.DO_SEND_ITEM_BY_SYSTEM_MAIL_ITEM_CHECK_FAILED.value;
/* 159 */       rsp.retcode = retcode;
/* 160 */       Response response = IdipGmtUtil.getResponse(retcode, "item1 check failed");
/* 161 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/* 163 */       GameServer.logger().error(String.format("[gmt]DoSendItemBySystemMailHandler.execute@item check failed|userid=%s|roleid=%d|title=%s|content=%s|money_type1=%d|money_num1=%d|money_type2=%d|money_num2=%d|money_type3=%d|money_num3=%d|item_cfgid1=%d|item_num1=%d|item_cfgid2=%d|item_num2=%d|item_cfgid3=%d|item_num3=%d|item_cfgid4=%d|item_num4=%d", new Object[] { userId, Long.valueOf(roleid), mailTitle, mailContent, Integer.valueOf(moneyType1), Integer.valueOf(moneyNum1), Integer.valueOf(moneyType2), Integer.valueOf(moneyNum2), Integer.valueOf(moneyType3), Integer.valueOf(moneyNum3), Integer.valueOf(itemCfgid1), Integer.valueOf(itemNum1), Integer.valueOf(itemCfgid2), Integer.valueOf(itemNum2), Integer.valueOf(itemCfgid3), Integer.valueOf(itemNum3), Integer.valueOf(itemCfgid4), Integer.valueOf(itemNum4) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 168 */       return;
/*     */     }
/* 170 */     if (!itemCheck(items, itemCfgid2, itemNum2))
/*     */     {
/* 172 */       int retcode = Retcode.DO_SEND_ITEM_BY_SYSTEM_MAIL_ITEM_CHECK_FAILED.value;
/* 173 */       rsp.retcode = retcode;
/* 174 */       Response response = IdipGmtUtil.getResponse(retcode, "item2 check failed");
/* 175 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/* 177 */       GameServer.logger().error(String.format("[gmt]DoSendItemBySystemMailHandler.execute@item check failed|userid=%s|roleid=%d|title=%s|content=%s|money_type1=%d|money_num1=%d|money_type2=%d|money_num2=%d|money_type3=%d|money_num3=%d|item_cfgid1=%d|item_num1=%d|item_cfgid2=%d|item_num2=%d|item_cfgid3=%d|item_num3=%d|item_cfgid4=%d|item_num4=%d", new Object[] { userId, Long.valueOf(roleid), mailTitle, mailContent, Integer.valueOf(moneyType1), Integer.valueOf(moneyNum1), Integer.valueOf(moneyType2), Integer.valueOf(moneyNum2), Integer.valueOf(moneyType3), Integer.valueOf(moneyNum3), Integer.valueOf(itemCfgid1), Integer.valueOf(itemNum1), Integer.valueOf(itemCfgid2), Integer.valueOf(itemNum2), Integer.valueOf(itemCfgid3), Integer.valueOf(itemNum3), Integer.valueOf(itemCfgid4), Integer.valueOf(itemNum4) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 182 */       return;
/*     */     }
/* 184 */     if (!itemCheck(items, itemCfgid3, itemNum3))
/*     */     {
/* 186 */       int retcode = Retcode.DO_SEND_ITEM_BY_SYSTEM_MAIL_ITEM_CHECK_FAILED.value;
/* 187 */       rsp.retcode = retcode;
/* 188 */       Response response = IdipGmtUtil.getResponse(retcode, "item3 check failed");
/* 189 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/* 191 */       GameServer.logger().error(String.format("[gmt]DoSendItemBySystemMailHandler.execute@item check failed|userid=%s|roleid=%d|title=%s|content=%s|money_type1=%d|money_num1=%d|money_type2=%d|money_num2=%d|money_type3=%d|money_num3=%d|item_cfgid1=%d|item_num1=%d|item_cfgid2=%d|item_num2=%d|item_cfgid3=%d|item_num3=%d|item_cfgid4=%d|item_num4=%d", new Object[] { userId, Long.valueOf(roleid), mailTitle, mailContent, Integer.valueOf(moneyType1), Integer.valueOf(moneyNum1), Integer.valueOf(moneyType2), Integer.valueOf(moneyNum2), Integer.valueOf(moneyType3), Integer.valueOf(moneyNum3), Integer.valueOf(itemCfgid1), Integer.valueOf(itemNum1), Integer.valueOf(itemCfgid2), Integer.valueOf(itemNum2), Integer.valueOf(itemCfgid3), Integer.valueOf(itemNum3), Integer.valueOf(itemCfgid4), Integer.valueOf(itemNum4) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 196 */       return;
/*     */     }
/* 198 */     if (!itemCheck(items, itemCfgid4, itemNum4))
/*     */     {
/* 200 */       int retcode = Retcode.DO_SEND_ITEM_BY_SYSTEM_MAIL_ITEM_CHECK_FAILED.value;
/* 201 */       rsp.retcode = retcode;
/* 202 */       Response response = IdipGmtUtil.getResponse(retcode, "item4 check failed");
/* 203 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/* 205 */       GameServer.logger().error(String.format("[gmt]DoSendItemBySystemMailHandler.execute@item check failed|userid=%s|roleid=%d|title=%s|content=%s|money_type1=%d|money_num1=%d|money_type2=%d|money_num2=%d|money_type3=%d|money_num3=%d|item_cfgid1=%d|item_num1=%d|item_cfgid2=%d|item_num2=%d|item_cfgid3=%d|item_num3=%d|item_cfgid4=%d|item_num4=%d", new Object[] { userId, Long.valueOf(roleid), mailTitle, mailContent, Integer.valueOf(moneyType1), Integer.valueOf(moneyNum1), Integer.valueOf(moneyType2), Integer.valueOf(moneyNum2), Integer.valueOf(moneyType3), Integer.valueOf(moneyNum3), Integer.valueOf(itemCfgid1), Integer.valueOf(itemNum1), Integer.valueOf(itemCfgid2), Integer.valueOf(itemNum2), Integer.valueOf(itemCfgid3), Integer.valueOf(itemNum3), Integer.valueOf(itemCfgid4), Integer.valueOf(itemNum4) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 210 */       return;
/*     */     }
/*     */     
/* 213 */     Map<Integer, Integer> currencies = new HashMap();
/* 214 */     if (!parseCurrency(currencies, moneyType1, moneyNum1, "MoneyType1"))
/*     */     {
/* 216 */       int retcode = Retcode.DO_SEND_ITEM_BY_SYSTEM_MAIL_MONEY_TYPE.value;
/* 217 */       rsp.retcode = retcode;
/* 218 */       Response response = IdipGmtUtil.getResponse(retcode, "money type1 check failed");
/* 219 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/* 221 */       GameServer.logger().error(String.format("[gmt]DoSendItemBySystemMailHandler.execute@currency check failed|userid=%s|roleid=%d|title=%s|content=%s|money_type1=%d|money_num1=%d|money_type2=%d|money_num2=%d|money_type3=%d|money_num3=%d|item_cfgid1=%d|item_num1=%d|item_cfgid2=%d|item_num2=%d|item_cfgid3=%d|item_num3=%d|item_cfgid4=%d|item_num4=%d", new Object[] { userId, Long.valueOf(roleid), mailTitle, mailContent, Integer.valueOf(moneyType1), Integer.valueOf(moneyNum1), Integer.valueOf(moneyType2), Integer.valueOf(moneyNum2), Integer.valueOf(moneyType3), Integer.valueOf(moneyNum3), Integer.valueOf(itemCfgid1), Integer.valueOf(itemNum1), Integer.valueOf(itemCfgid2), Integer.valueOf(itemNum2), Integer.valueOf(itemCfgid3), Integer.valueOf(itemNum3), Integer.valueOf(itemCfgid4), Integer.valueOf(itemNum4) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 226 */       return;
/*     */     }
/* 228 */     if (!parseCurrency(currencies, moneyType2, moneyNum2, "MoneyType2"))
/*     */     {
/* 230 */       int retcode = Retcode.DO_SEND_ITEM_BY_SYSTEM_MAIL_MONEY_TYPE.value;
/* 231 */       rsp.retcode = retcode;
/* 232 */       Response response = IdipGmtUtil.getResponse(retcode, "money type2 check failed");
/* 233 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/* 235 */       GameServer.logger().error(String.format("[gmt]DoSendItemBySystemMailHandler.execute@currency check failed|userid=%s|roleid=%d|title=%s|content=%s|money_type1=%d|money_num1=%d|money_type2=%d|money_num2=%d|money_type3=%d|money_num3=%d|item_cfgid1=%d|item_num1=%d|item_cfgid2=%d|item_num2=%d|item_cfgid3=%d|item_num3=%d|item_cfgid4=%d|item_num4=%d", new Object[] { userId, Long.valueOf(roleid), mailTitle, mailContent, Integer.valueOf(moneyType1), Integer.valueOf(moneyNum1), Integer.valueOf(moneyType2), Integer.valueOf(moneyNum2), Integer.valueOf(moneyType3), Integer.valueOf(moneyNum3), Integer.valueOf(itemCfgid1), Integer.valueOf(itemNum1), Integer.valueOf(itemCfgid2), Integer.valueOf(itemNum2), Integer.valueOf(itemCfgid3), Integer.valueOf(itemNum3), Integer.valueOf(itemCfgid4), Integer.valueOf(itemNum4) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 240 */       return;
/*     */     }
/* 242 */     if (!parseCurrency(currencies, moneyType3, moneyNum3, "MoneyType3"))
/*     */     {
/* 244 */       int retcode = Retcode.DO_SEND_ITEM_BY_SYSTEM_MAIL_MONEY_TYPE.value;
/* 245 */       rsp.retcode = retcode;
/* 246 */       Response response = IdipGmtUtil.getResponse(retcode, "money type3 check failed");
/* 247 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/* 249 */       GameServer.logger().error(String.format("[gmt]DoSendItemBySystemMailHandler.execute@currency check failed|userid=%s|roleid=%d|title=%s|content=%s|money_type1=%d|money_num1=%d|money_type2=%d|money_num2=%d|money_type3=%d|money_num3=%d|item_cfgid1=%d|item_num1=%d|item_cfgid2=%d|item_num2=%d|item_cfgid3=%d|item_num3=%d|item_cfgid4=%d|item_num4=%d", new Object[] { userId, Long.valueOf(roleid), mailTitle, mailContent, Integer.valueOf(moneyType1), Integer.valueOf(moneyNum1), Integer.valueOf(moneyType2), Integer.valueOf(moneyNum2), Integer.valueOf(moneyType3), Integer.valueOf(moneyNum3), Integer.valueOf(itemCfgid1), Integer.valueOf(itemNum1), Integer.valueOf(itemCfgid2), Integer.valueOf(itemNum2), Integer.valueOf(itemCfgid3), Integer.valueOf(itemNum3), Integer.valueOf(itemCfgid4), Integer.valueOf(itemNum4) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 254 */       return;
/*     */     }
/*     */     
/* 257 */     if ((items.size() == 0) && (currencies.size() == 0))
/*     */     {
/* 259 */       int retcode = Retcode.DO_SEND_ITEM_BY_SYSTEM_MAIL_ITEM_EMPTY.value;
/* 260 */       rsp.retcode = retcode;
/* 261 */       Response response = IdipGmtUtil.getResponse(retcode, "item and currency empty");
/* 262 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/* 264 */       GameServer.logger().error(String.format("[gmt]DoSendItemBySystemMailHandler.execute@invalid data|userid=%s|roleid=%d|title=%s|content=%s|money_type1=%d|money_num1=%d|money_type2=%d|money_num2=%d|money_type3=%d|money_num3=%d|item_cfgid1=%d|item_num1=%d|item_cfgid2=%d|item_num2=%d|item_cfgid3=%d|item_num3=%d|item_cfgid4=%d|item_num4=%d", new Object[] { userId, Long.valueOf(roleid), mailTitle, mailContent, Integer.valueOf(moneyType1), Integer.valueOf(moneyNum1), Integer.valueOf(moneyType2), Integer.valueOf(moneyNum2), Integer.valueOf(moneyType3), Integer.valueOf(moneyNum3), Integer.valueOf(itemCfgid1), Integer.valueOf(itemNum1), Integer.valueOf(itemCfgid2), Integer.valueOf(itemNum2), Integer.valueOf(itemCfgid3), Integer.valueOf(itemNum3), Integer.valueOf(itemCfgid4), Integer.valueOf(itemNum4) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 269 */       return;
/*     */     }
/*     */     
/* 272 */     String tag = "";
/* 273 */     if (tagid != 0)
/*     */     {
/* 275 */       tag = "P2_" + tagid;
/*     */     }
/*     */     
/* 278 */     MailAttachment mailAttachment = MailInterface.createMailAttachment();
/* 279 */     mailAttachment.addItemMap(items);
/* 280 */     IDIPCurrencyType.fillMailCurrencyAttachment(mailAttachment, currencies);
/*     */     
/* 282 */     TLogArg tLogArg = new TLogArg(LogReason.GMT_DO_SEND_ITEM_BY_SYSTEM_MAIL);
/* 283 */     SendMailRet sendMailRet = MailInterface.synBuildAndSendMail(roleid, 1, mailTitle, mailContent, mailAttachment, tLogArg, tag);
/*     */     
/* 285 */     if (!sendMailRet.isOK())
/*     */     {
/* 287 */       int retcode = Retcode.DO_SEND_ITEM_BY_SYSTEM_MAIL_FAILED.value;
/* 288 */       rsp.retcode = retcode;
/* 289 */       Response response = IdipGmtUtil.getResponse(retcode, sendMailRet.getRetEnum().retMsg);
/* 290 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/* 292 */       GameServer.logger().error(String.format("[gmt]DoSendItemBySystemMailHandler.execute@send item by system mail failed|ret=%d|ret_msg=%s|userid=%s|roleid=%d|title=%s|content=%s|money_type1=%d|money_num1=%d|money_type2=%d|money_num2=%d|money_type3=%d|money_num3=%d|item_cfgid1=%d|item_num1=%d|item_cfgid2=%d|item_num2=%d|item_cfgid3=%d|item_num3=%d|item_cfgid4=%d|item_num4=%d|tagid=%d", new Object[] { Integer.valueOf(sendMailRet.getRetEnum().ret), sendMailRet.getRetEnum().retMsg, userId, Long.valueOf(roleid), mailTitle, mailContent, Integer.valueOf(moneyType1), Integer.valueOf(moneyNum1), Integer.valueOf(moneyType2), Integer.valueOf(moneyNum2), Integer.valueOf(moneyType3), Integer.valueOf(moneyNum3), Integer.valueOf(itemCfgid1), Integer.valueOf(itemNum1), Integer.valueOf(itemCfgid2), Integer.valueOf(itemNum2), Integer.valueOf(itemCfgid3), Integer.valueOf(itemNum3), Integer.valueOf(itemCfgid4), Integer.valueOf(itemNum4), Integer.valueOf(tagid) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 298 */       return;
/*     */     }
/*     */     
/* 301 */     rsp.retcode = Retcode.SUCCESS.value;
/* 302 */     Response response = new Response();
/* 303 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */     
/*     */ 
/* 306 */     TLogManager.getInstance().addLog(userId, "GMTDoSendItemBySystemMail", new Object[] { userId, Long.valueOf(roleid), Integer.valueOf(moneyType1), Integer.valueOf(moneyNum1), Integer.valueOf(moneyType2), Integer.valueOf(moneyNum2), Integer.valueOf(moneyType3), Integer.valueOf(moneyNum3), Integer.valueOf(itemCfgid1), Integer.valueOf(itemNum1), Integer.valueOf(itemCfgid2), Integer.valueOf(itemNum2), Integer.valueOf(itemCfgid3), Integer.valueOf(itemNum3), Integer.valueOf(itemCfgid4), Integer.valueOf(itemNum4), Integer.valueOf(tagid) });
/*     */     
/*     */ 
/*     */ 
/* 310 */     GameServer.logger().info(String.format("[gmt]DoSendItemBySystemMailHandler.execute@send item by system mail success|userid=%s|roleid=%d|title=%s|content=%s|money_type1=%d|money_num1=%d|money_type2=%d|money_num2=%d|money_type3=%d|money_num3=%d|item_cfgid1=%d|item_num1=%d|item_cfgid2=%d|item_num2=%d|item_cfgid3=%d|item_num3=%d|item_cfgid4=%d|item_num4=%d|tagid=%d", new Object[] { userId, Long.valueOf(roleid), mailTitle, mailContent, Integer.valueOf(moneyType1), Integer.valueOf(moneyNum1), Integer.valueOf(moneyType2), Integer.valueOf(moneyNum2), Integer.valueOf(moneyType3), Integer.valueOf(moneyNum3), Integer.valueOf(itemCfgid1), Integer.valueOf(itemNum1), Integer.valueOf(itemCfgid2), Integer.valueOf(itemNum2), Integer.valueOf(itemCfgid3), Integer.valueOf(itemNum3), Integer.valueOf(itemCfgid4), Integer.valueOf(itemNum4), Integer.valueOf(tagid) }));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private final boolean parseCurrency(Map<Integer, Integer> currencies, int currencyType, int currencyNum, String fieldName)
/*     */   {
/* 321 */     if ((currencyType > 0) && (currencyNum > 0))
/*     */     {
/* 323 */       if ((currencyType < 1) || (currencyType > 14))
/*     */       {
/* 325 */         return false;
/*     */       }
/* 327 */       Integer oldCurrencyNum = (Integer)currencies.get(Integer.valueOf(currencyType));
/* 328 */       if (oldCurrencyNum == null)
/*     */       {
/* 330 */         currencies.put(Integer.valueOf(currencyType), Integer.valueOf(currencyNum));
/*     */       }
/*     */       else
/*     */       {
/* 334 */         currencies.put(Integer.valueOf(currencyType), Integer.valueOf(oldCurrencyNum.intValue() + currencyNum));
/*     */       }
/*     */     }
/* 337 */     return true;
/*     */   }
/*     */   
/*     */   private boolean itemCheck(Map<Integer, Integer> items, int itemid, int num)
/*     */   {
/* 342 */     if ((itemid <= 0) || (num <= 0))
/*     */     {
/* 344 */       return true;
/*     */     }
/*     */     
/* 347 */     SItemCfg itemCfg = ItemInterface.getSItemCfg(itemid);
/* 348 */     if (itemCfg == null)
/*     */     {
/* 350 */       return false;
/*     */     }
/*     */     
/* 353 */     Integer oldNum = (Integer)items.get(Integer.valueOf(itemid));
/* 354 */     if (oldNum == null)
/*     */     {
/* 356 */       items.put(Integer.valueOf(itemid), Integer.valueOf(num));
/*     */     }
/*     */     else
/*     */     {
/* 360 */       items.put(Integer.valueOf(itemid), Integer.valueOf(oldNum.intValue() + num));
/*     */     }
/* 362 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\DoSendItemBySystemMailHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */