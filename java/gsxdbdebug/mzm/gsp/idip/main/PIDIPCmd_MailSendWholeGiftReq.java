/*     */ package mzm.gsp.idip.main;
/*     */ 
/*     */ import idip.IDIPCmd_MailSendWholeGiftReq;
/*     */ import idip.IDIPPacket_MailSendWholeGiftReq;
/*     */ import idip.IDIPPacket_MailSendWholeGiftRsp;
/*     */ import idip.MailSendWholeGiftReq;
/*     */ import idip.MailSendWholeGiftRsp;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.compensate.main.CompensateInfo;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ 
/*     */ public class PIDIPCmd_MailSendWholeGiftReq extends PIDIPCmd<IDIPCmd_MailSendWholeGiftReq>
/*     */ {
/*     */   public PIDIPCmd_MailSendWholeGiftReq(IDIPCmd_MailSendWholeGiftReq cmd)
/*     */   {
/*  19 */     super(cmd);
/*     */   }
/*     */   
/*     */   protected String getSerialNo()
/*     */   {
/*  24 */     return ((MailSendWholeGiftReq)((IDIPPacket_MailSendWholeGiftReq)((IDIPCmd_MailSendWholeGiftReq)this.cmd).req).body).Serial;
/*     */   }
/*     */   
/*     */ 
/*     */   private final boolean parseCurrency(Map<Integer, Integer> currencies, int currencyType, int currencyNum, String fieldName)
/*     */   {
/*  30 */     if ((currencyType > 0) && (currencyNum > 0))
/*     */     {
/*  32 */       if (currencyType == 1)
/*     */       {
/*  34 */         ((IDIPPacket_MailSendWholeGiftRsp)((IDIPCmd_MailSendWholeGiftReq)this.cmd).rsp).head.Result = (((MailSendWholeGiftRsp)((IDIPPacket_MailSendWholeGiftRsp)((IDIPCmd_MailSendWholeGiftReq)this.cmd).rsp).body).Result = -1);
/*  35 */         ((IDIPPacket_MailSendWholeGiftRsp)((IDIPCmd_MailSendWholeGiftReq)this.cmd).rsp).head.RetErrMsg = (((MailSendWholeGiftRsp)((IDIPPacket_MailSendWholeGiftRsp)((IDIPCmd_MailSendWholeGiftReq)this.cmd).rsp).body).RetMsg = String.format("%s unsupported currency type", new Object[] { fieldName }));
/*     */         
/*  37 */         ((IDIPCmd_MailSendWholeGiftReq)this.cmd).sendResponse();
/*     */         
/*  39 */         return false;
/*     */       }
/*     */       
/*  42 */       if ((currencyType < 1) || (currencyType > 14))
/*     */       {
/*  44 */         ((IDIPPacket_MailSendWholeGiftRsp)((IDIPCmd_MailSendWholeGiftReq)this.cmd).rsp).head.Result = (((MailSendWholeGiftRsp)((IDIPPacket_MailSendWholeGiftRsp)((IDIPCmd_MailSendWholeGiftReq)this.cmd).rsp).body).Result = -1);
/*  45 */         ((IDIPPacket_MailSendWholeGiftRsp)((IDIPCmd_MailSendWholeGiftReq)this.cmd).rsp).head.RetErrMsg = (((MailSendWholeGiftRsp)((IDIPPacket_MailSendWholeGiftRsp)((IDIPCmd_MailSendWholeGiftReq)this.cmd).rsp).body).RetMsg = String.format("%s invalid", new Object[] { fieldName }));
/*  46 */         ((IDIPCmd_MailSendWholeGiftReq)this.cmd).sendResponse();
/*     */         
/*  48 */         return false;
/*     */       }
/*     */       
/*  51 */       Integer oldNum = (Integer)currencies.get(Integer.valueOf(currencyType));
/*  52 */       if (oldNum == null)
/*     */       {
/*  54 */         currencies.put(Integer.valueOf(currencyType), Integer.valueOf(currencyNum));
/*     */       }
/*     */       else
/*     */       {
/*  58 */         currencies.put(Integer.valueOf(currencyType), Integer.valueOf(oldNum.intValue() + currencyNum));
/*     */       }
/*     */     }
/*     */     
/*  62 */     return true;
/*     */   }
/*     */   
/*     */   private void boxItems(Map<Integer, Integer> items, int itemCfgid, int num)
/*     */   {
/*  67 */     Integer oldNum = (Integer)items.get(Integer.valueOf(itemCfgid));
/*  68 */     if (oldNum == null)
/*     */     {
/*  70 */       items.put(Integer.valueOf(itemCfgid), Integer.valueOf(num));
/*     */     }
/*     */     else
/*     */     {
/*  74 */       items.put(Integer.valueOf(itemCfgid), Integer.valueOf(oldNum.intValue() + num));
/*     */     }
/*     */   }
/*     */   
/*     */   protected boolean handle()
/*     */     throws Exception
/*     */   {
/*  81 */     String mailTitle = idip.core.Utils.urlDecode1738(((MailSendWholeGiftReq)((IDIPPacket_MailSendWholeGiftReq)((IDIPCmd_MailSendWholeGiftReq)this.cmd).req).body).MailTitle);
/*  82 */     String mailContent = idip.core.Utils.urlDecode1738(((MailSendWholeGiftReq)((IDIPPacket_MailSendWholeGiftReq)((IDIPCmd_MailSendWholeGiftReq)this.cmd).req).body).MailContent);
/*  83 */     long mailStart = ((MailSendWholeGiftReq)((IDIPPacket_MailSendWholeGiftReq)((IDIPCmd_MailSendWholeGiftReq)this.cmd).req).body).MailStart * 1000L;
/*  84 */     long mailEnd = ((MailSendWholeGiftReq)((IDIPPacket_MailSendWholeGiftReq)((IDIPCmd_MailSendWholeGiftReq)this.cmd).req).body).MailEnd * 1000L;
/*     */     
/*  86 */     long currTime = DateTimeUtils.getCurrTimeInMillis();
/*  87 */     if ((mailStart >= mailEnd) || (mailEnd < currTime))
/*     */     {
/*  89 */       ((IDIPPacket_MailSendWholeGiftRsp)((IDIPCmd_MailSendWholeGiftReq)this.cmd).rsp).head.Result = (((MailSendWholeGiftRsp)((IDIPPacket_MailSendWholeGiftRsp)((IDIPCmd_MailSendWholeGiftReq)this.cmd).rsp).body).Result = -1);
/*  90 */       ((IDIPPacket_MailSendWholeGiftRsp)((IDIPCmd_MailSendWholeGiftReq)this.cmd).rsp).head.RetErrMsg = (((MailSendWholeGiftRsp)((IDIPPacket_MailSendWholeGiftRsp)((IDIPCmd_MailSendWholeGiftReq)this.cmd).rsp).body).RetMsg = "MailStart MUST be less than MailEnd, or MailEnd MUST be greater than currtime");
/*  91 */       ((IDIPCmd_MailSendWholeGiftReq)this.cmd).sendResponse();
/*     */       
/*  93 */       dumpFailedLog(mailStart, mailEnd, mailTitle, mailContent, "MailStart MUST be less than MailEnd, or MailEnd MUST be greater than currtime");
/*     */       
/*     */ 
/*  96 */       return false;
/*     */     }
/*     */     
/*  99 */     if (((MailSendWholeGiftReq)((IDIPPacket_MailSendWholeGiftReq)((IDIPCmd_MailSendWholeGiftReq)this.cmd).req).body).MinLevel > ((MailSendWholeGiftReq)((IDIPPacket_MailSendWholeGiftReq)((IDIPCmd_MailSendWholeGiftReq)this.cmd).req).body).MaxLevel)
/*     */     {
/* 101 */       ((IDIPPacket_MailSendWholeGiftRsp)((IDIPCmd_MailSendWholeGiftReq)this.cmd).rsp).head.Result = (((MailSendWholeGiftRsp)((IDIPPacket_MailSendWholeGiftRsp)((IDIPCmd_MailSendWholeGiftReq)this.cmd).rsp).body).Result = -1);
/* 102 */       ((IDIPPacket_MailSendWholeGiftRsp)((IDIPCmd_MailSendWholeGiftReq)this.cmd).rsp).head.RetErrMsg = (((MailSendWholeGiftRsp)((IDIPPacket_MailSendWholeGiftRsp)((IDIPCmd_MailSendWholeGiftReq)this.cmd).rsp).body).RetMsg = "MinLevel MUST be less than MaxLevel");
/* 103 */       ((IDIPCmd_MailSendWholeGiftReq)this.cmd).sendResponse();
/*     */       
/* 105 */       dumpFailedLog(mailStart, mailEnd, mailTitle, mailContent, "MinLevel MUST be less than MaxLevel");
/*     */       
/* 107 */       return false;
/*     */     }
/*     */     
/* 110 */     if (mailTitle.isEmpty())
/*     */     {
/* 112 */       ((IDIPPacket_MailSendWholeGiftRsp)((IDIPCmd_MailSendWholeGiftReq)this.cmd).rsp).head.Result = (((MailSendWholeGiftRsp)((IDIPPacket_MailSendWholeGiftRsp)((IDIPCmd_MailSendWholeGiftReq)this.cmd).rsp).body).Result = -1);
/* 113 */       ((IDIPPacket_MailSendWholeGiftRsp)((IDIPCmd_MailSendWholeGiftReq)this.cmd).rsp).head.RetErrMsg = (((MailSendWholeGiftRsp)((IDIPPacket_MailSendWholeGiftRsp)((IDIPCmd_MailSendWholeGiftReq)this.cmd).rsp).body).RetMsg = "MailTitle is empty");
/* 114 */       ((IDIPCmd_MailSendWholeGiftReq)this.cmd).sendResponse();
/*     */       
/* 116 */       dumpFailedLog(mailStart, mailEnd, mailTitle, mailContent, "MailTitle is empty");
/*     */       
/* 118 */       return false;
/*     */     }
/* 120 */     if (mailTitle.length() > 120)
/*     */     {
/* 122 */       ((IDIPPacket_MailSendWholeGiftRsp)((IDIPCmd_MailSendWholeGiftReq)this.cmd).rsp).head.Result = (((MailSendWholeGiftRsp)((IDIPPacket_MailSendWholeGiftRsp)((IDIPCmd_MailSendWholeGiftReq)this.cmd).rsp).body).Result = -1);
/* 123 */       ((IDIPPacket_MailSendWholeGiftRsp)((IDIPCmd_MailSendWholeGiftReq)this.cmd).rsp).head.RetErrMsg = (((MailSendWholeGiftRsp)((IDIPPacket_MailSendWholeGiftRsp)((IDIPCmd_MailSendWholeGiftReq)this.cmd).rsp).body).RetMsg = String.format("MailTitle length > %d", new Object[] { Integer.valueOf(120) }));
/*     */       
/* 125 */       ((IDIPCmd_MailSendWholeGiftReq)this.cmd).sendResponse();
/*     */       
/* 127 */       dumpFailedLog(mailStart, mailEnd, mailTitle, mailContent, "MailTitle length > MAX_MAILTITILE_LEN");
/*     */       
/* 129 */       return false;
/*     */     }
/*     */     
/* 132 */     if (mailContent.isEmpty())
/*     */     {
/* 134 */       ((IDIPPacket_MailSendWholeGiftRsp)((IDIPCmd_MailSendWholeGiftReq)this.cmd).rsp).head.Result = (((MailSendWholeGiftRsp)((IDIPPacket_MailSendWholeGiftRsp)((IDIPCmd_MailSendWholeGiftReq)this.cmd).rsp).body).Result = -1);
/* 135 */       ((IDIPPacket_MailSendWholeGiftRsp)((IDIPCmd_MailSendWholeGiftReq)this.cmd).rsp).head.RetErrMsg = (((MailSendWholeGiftRsp)((IDIPPacket_MailSendWholeGiftRsp)((IDIPCmd_MailSendWholeGiftReq)this.cmd).rsp).body).RetMsg = "MailContent is empty");
/* 136 */       ((IDIPCmd_MailSendWholeGiftReq)this.cmd).sendResponse();
/*     */       
/* 138 */       dumpFailedLog(mailStart, mailEnd, mailTitle, mailContent, "MailContent is empty");
/*     */       
/* 140 */       return false;
/*     */     }
/* 142 */     if (mailContent.length() > 3200)
/*     */     {
/* 144 */       ((IDIPPacket_MailSendWholeGiftRsp)((IDIPCmd_MailSendWholeGiftReq)this.cmd).rsp).head.Result = (((MailSendWholeGiftRsp)((IDIPPacket_MailSendWholeGiftRsp)((IDIPCmd_MailSendWholeGiftReq)this.cmd).rsp).body).Result = -1);
/* 145 */       ((IDIPPacket_MailSendWholeGiftRsp)((IDIPCmd_MailSendWholeGiftReq)this.cmd).rsp).head.RetErrMsg = (((MailSendWholeGiftRsp)((IDIPPacket_MailSendWholeGiftRsp)((IDIPCmd_MailSendWholeGiftReq)this.cmd).rsp).body).RetMsg = String.format("MailContent length > %d", new Object[] { Integer.valueOf(3200) }));
/*     */       
/* 147 */       ((IDIPCmd_MailSendWholeGiftReq)this.cmd).sendResponse();
/*     */       
/* 149 */       dumpFailedLog(mailStart, mailEnd, mailTitle, mailContent, "MailContent length > MAX_MAILCONTENT_LEN");
/*     */       
/* 151 */       return false;
/*     */     }
/*     */     
/* 154 */     Map<Integer, Integer> items = new HashMap();
/* 155 */     if ((((MailSendWholeGiftReq)((IDIPPacket_MailSendWholeGiftReq)((IDIPCmd_MailSendWholeGiftReq)this.cmd).req).body).OptionsID > 0) && (((MailSendWholeGiftReq)((IDIPPacket_MailSendWholeGiftReq)((IDIPCmd_MailSendWholeGiftReq)this.cmd).req).body).OptionsNum > 0))
/*     */     {
/* 157 */       boxItems(items, ((MailSendWholeGiftReq)((IDIPPacket_MailSendWholeGiftReq)((IDIPCmd_MailSendWholeGiftReq)this.cmd).req).body).OptionsID, ((MailSendWholeGiftReq)((IDIPPacket_MailSendWholeGiftReq)((IDIPCmd_MailSendWholeGiftReq)this.cmd).req).body).OptionsNum);
/*     */     }
/* 159 */     if ((((MailSendWholeGiftReq)((IDIPPacket_MailSendWholeGiftReq)((IDIPCmd_MailSendWholeGiftReq)this.cmd).req).body).Options2ID > 0) && (((MailSendWholeGiftReq)((IDIPPacket_MailSendWholeGiftReq)((IDIPCmd_MailSendWholeGiftReq)this.cmd).req).body).Options2Num > 0))
/*     */     {
/* 161 */       boxItems(items, ((MailSendWholeGiftReq)((IDIPPacket_MailSendWholeGiftReq)((IDIPCmd_MailSendWholeGiftReq)this.cmd).req).body).Options2ID, ((MailSendWholeGiftReq)((IDIPPacket_MailSendWholeGiftReq)((IDIPCmd_MailSendWholeGiftReq)this.cmd).req).body).Options2Num);
/*     */     }
/* 163 */     if ((((MailSendWholeGiftReq)((IDIPPacket_MailSendWholeGiftReq)((IDIPCmd_MailSendWholeGiftReq)this.cmd).req).body).Options3ID > 0) && (((MailSendWholeGiftReq)((IDIPPacket_MailSendWholeGiftReq)((IDIPCmd_MailSendWholeGiftReq)this.cmd).req).body).Options3Num > 0))
/*     */     {
/* 165 */       boxItems(items, ((MailSendWholeGiftReq)((IDIPPacket_MailSendWholeGiftReq)((IDIPCmd_MailSendWholeGiftReq)this.cmd).req).body).Options3ID, ((MailSendWholeGiftReq)((IDIPPacket_MailSendWholeGiftReq)((IDIPCmd_MailSendWholeGiftReq)this.cmd).req).body).Options3Num);
/*     */     }
/*     */     
/* 168 */     Map<Integer, Integer> currencies = new HashMap();
/* 169 */     if (!parseCurrency(currencies, ((MailSendWholeGiftReq)((IDIPPacket_MailSendWholeGiftReq)((IDIPCmd_MailSendWholeGiftReq)this.cmd).req).body).MoneyType1, ((MailSendWholeGiftReq)((IDIPPacket_MailSendWholeGiftReq)((IDIPCmd_MailSendWholeGiftReq)this.cmd).req).body).MoneyNum1, "MoneyType1"))
/*     */     {
/* 171 */       dumpFailedLog(mailStart, mailEnd, mailTitle, mailContent, "MoneyType1 invalid");
/*     */       
/* 173 */       return false;
/*     */     }
/* 175 */     if (!parseCurrency(currencies, ((MailSendWholeGiftReq)((IDIPPacket_MailSendWholeGiftReq)((IDIPCmd_MailSendWholeGiftReq)this.cmd).req).body).MoneyType2, ((MailSendWholeGiftReq)((IDIPPacket_MailSendWholeGiftReq)((IDIPCmd_MailSendWholeGiftReq)this.cmd).req).body).MoneyNum2, "MoneyType2"))
/*     */     {
/* 177 */       dumpFailedLog(mailStart, mailEnd, mailTitle, mailContent, "MoneyType2 invalid");
/*     */       
/* 179 */       return false;
/*     */     }
/* 181 */     if (!parseCurrency(currencies, ((MailSendWholeGiftReq)((IDIPPacket_MailSendWholeGiftReq)((IDIPCmd_MailSendWholeGiftReq)this.cmd).req).body).MoneyType3, ((MailSendWholeGiftReq)((IDIPPacket_MailSendWholeGiftReq)((IDIPCmd_MailSendWholeGiftReq)this.cmd).req).body).MoneyNum3, "MoneyType3"))
/*     */     {
/* 183 */       dumpFailedLog(mailStart, mailEnd, mailTitle, mailContent, "MoneyType3 invalid");
/*     */       
/* 185 */       return false;
/*     */     }
/*     */     
/* 188 */     if ((items.size() == 0) && (currencies.size() == 0))
/*     */     {
/* 190 */       ((IDIPPacket_MailSendWholeGiftRsp)((IDIPCmd_MailSendWholeGiftReq)this.cmd).rsp).head.Result = (((MailSendWholeGiftRsp)((IDIPPacket_MailSendWholeGiftRsp)((IDIPCmd_MailSendWholeGiftReq)this.cmd).rsp).body).Result = -1);
/* 191 */       ((IDIPPacket_MailSendWholeGiftRsp)((IDIPCmd_MailSendWholeGiftReq)this.cmd).rsp).head.RetErrMsg = (((MailSendWholeGiftRsp)((IDIPPacket_MailSendWholeGiftRsp)((IDIPCmd_MailSendWholeGiftReq)this.cmd).rsp).body).RetMsg = "mail not contain gift info");
/* 192 */       ((IDIPCmd_MailSendWholeGiftReq)this.cmd).sendResponse();
/*     */       
/* 194 */       dumpFailedLog(mailStart, mailEnd, mailTitle, mailContent, "mail not contain gift info");
/*     */       
/* 196 */       return false;
/*     */     }
/*     */     
/* 199 */     long minCreateRoleTime = TimeUnit.SECONDS.toMillis(((MailSendWholeGiftReq)((IDIPPacket_MailSendWholeGiftReq)((IDIPCmd_MailSendWholeGiftReq)this.cmd).req).body).FirstCreateTime);
/* 200 */     if (minCreateRoleTime < 0L)
/*     */     {
/* 202 */       ((IDIPPacket_MailSendWholeGiftRsp)((IDIPCmd_MailSendWholeGiftReq)this.cmd).rsp).head.Result = (((MailSendWholeGiftRsp)((IDIPPacket_MailSendWholeGiftRsp)((IDIPCmd_MailSendWholeGiftReq)this.cmd).rsp).body).Result = -1);
/* 203 */       ((IDIPPacket_MailSendWholeGiftRsp)((IDIPCmd_MailSendWholeGiftReq)this.cmd).rsp).head.RetErrMsg = (((MailSendWholeGiftRsp)((IDIPPacket_MailSendWholeGiftRsp)((IDIPCmd_MailSendWholeGiftReq)this.cmd).rsp).body).RetMsg = "first creat time invalid");
/* 204 */       ((IDIPCmd_MailSendWholeGiftReq)this.cmd).sendResponse();
/*     */       
/* 206 */       dumpFailedLog(mailStart, mailEnd, mailTitle, mailContent, "first create time invalid");
/* 207 */       return false;
/*     */     }
/* 209 */     if (minCreateRoleTime > 0L)
/*     */     {
/* 211 */       if (minCreateRoleTime >= mailEnd)
/*     */       {
/* 213 */         ((IDIPPacket_MailSendWholeGiftRsp)((IDIPCmd_MailSendWholeGiftReq)this.cmd).rsp).head.Result = (((MailSendWholeGiftRsp)((IDIPPacket_MailSendWholeGiftRsp)((IDIPCmd_MailSendWholeGiftReq)this.cmd).rsp).body).Result = -1);
/* 214 */         ((IDIPPacket_MailSendWholeGiftRsp)((IDIPCmd_MailSendWholeGiftReq)this.cmd).rsp).head.RetErrMsg = (((MailSendWholeGiftRsp)((IDIPPacket_MailSendWholeGiftRsp)((IDIPCmd_MailSendWholeGiftReq)this.cmd).rsp).body).RetMsg = "first create time invalid");
/* 215 */         ((IDIPCmd_MailSendWholeGiftReq)this.cmd).sendResponse();
/*     */         
/* 217 */         dumpFailedLog(mailStart, mailEnd, mailTitle, mailContent, "first create time invalid");
/* 218 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 222 */     long maxCreateRoleTime = TimeUnit.SECONDS.toMillis(((MailSendWholeGiftReq)((IDIPPacket_MailSendWholeGiftReq)((IDIPCmd_MailSendWholeGiftReq)this.cmd).req).body).LastCreateTime);
/* 223 */     if (maxCreateRoleTime < 0L)
/*     */     {
/* 225 */       ((IDIPPacket_MailSendWholeGiftRsp)((IDIPCmd_MailSendWholeGiftReq)this.cmd).rsp).head.Result = (((MailSendWholeGiftRsp)((IDIPPacket_MailSendWholeGiftRsp)((IDIPCmd_MailSendWholeGiftReq)this.cmd).rsp).body).Result = -1);
/* 226 */       ((IDIPPacket_MailSendWholeGiftRsp)((IDIPCmd_MailSendWholeGiftReq)this.cmd).rsp).head.RetErrMsg = (((MailSendWholeGiftRsp)((IDIPPacket_MailSendWholeGiftRsp)((IDIPCmd_MailSendWholeGiftReq)this.cmd).rsp).body).RetMsg = "last create time invalid");
/* 227 */       ((IDIPCmd_MailSendWholeGiftReq)this.cmd).sendResponse();
/* 228 */       dumpFailedLog(mailStart, mailEnd, mailTitle, mailContent, "last create time invalid");
/* 229 */       return false;
/*     */     }
/* 231 */     if (maxCreateRoleTime > 0L)
/*     */     {
/* 233 */       if (minCreateRoleTime > maxCreateRoleTime)
/*     */       {
/* 235 */         ((IDIPPacket_MailSendWholeGiftRsp)((IDIPCmd_MailSendWholeGiftReq)this.cmd).rsp).head.Result = (((MailSendWholeGiftRsp)((IDIPPacket_MailSendWholeGiftRsp)((IDIPCmd_MailSendWholeGiftReq)this.cmd).rsp).body).Result = -1);
/* 236 */         ((IDIPPacket_MailSendWholeGiftRsp)((IDIPCmd_MailSendWholeGiftReq)this.cmd).rsp).head.RetErrMsg = (((MailSendWholeGiftRsp)((IDIPPacket_MailSendWholeGiftRsp)((IDIPCmd_MailSendWholeGiftReq)this.cmd).rsp).body).RetMsg = "first create time > last create time");
/* 237 */         ((IDIPCmd_MailSendWholeGiftReq)this.cmd).sendResponse();
/* 238 */         dumpFailedLog(mailStart, mailEnd, mailTitle, mailContent, "first create time > last create time");
/* 239 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 243 */     int tagid = ((MailSendWholeGiftReq)((IDIPPacket_MailSendWholeGiftReq)((IDIPCmd_MailSendWholeGiftReq)this.cmd).req).body).TagId;
/* 244 */     if (tagid < 0)
/*     */     {
/* 246 */       ((IDIPPacket_MailSendWholeGiftRsp)((IDIPCmd_MailSendWholeGiftReq)this.cmd).rsp).head.Result = (((MailSendWholeGiftRsp)((IDIPPacket_MailSendWholeGiftRsp)((IDIPCmd_MailSendWholeGiftReq)this.cmd).rsp).body).Result = -1);
/* 247 */       ((IDIPPacket_MailSendWholeGiftRsp)((IDIPCmd_MailSendWholeGiftReq)this.cmd).rsp).head.RetErrMsg = (((MailSendWholeGiftRsp)((IDIPPacket_MailSendWholeGiftRsp)((IDIPCmd_MailSendWholeGiftReq)this.cmd).rsp).body).RetMsg = "tagid invalid");
/* 248 */       ((IDIPCmd_MailSendWholeGiftReq)this.cmd).sendResponse();
/*     */       
/* 250 */       dumpFailedLog(mailStart, mailEnd, mailTitle, mailContent, "tagid invalid");
/* 251 */       return false;
/*     */     }
/*     */     
/* 254 */     CompensateInfo compensateInfo = new CompensateInfo(1, ((MailSendWholeGiftReq)((IDIPPacket_MailSendWholeGiftReq)((IDIPCmd_MailSendWholeGiftReq)this.cmd).req).body).MinLevel, ((MailSendWholeGiftReq)((IDIPPacket_MailSendWholeGiftReq)((IDIPCmd_MailSendWholeGiftReq)this.cmd).req).body).MaxLevel, mailStart, mailEnd, mailTitle, mailContent, items, currencies, minCreateRoleTime, maxCreateRoleTime, tagid);
/*     */     
/*     */ 
/*     */ 
/* 258 */     boolean result = mzm.gsp.compensate.main.CompensateInterface.addCompensate(compensateInfo);
/* 259 */     int retcode = 0;
/* 260 */     String retMsg = "OK";
/* 261 */     if (!result)
/*     */     {
/* 263 */       retcode = -1;
/* 264 */       retMsg = "system errr:add compensate failed";
/*     */     }
/* 266 */     ((IDIPPacket_MailSendWholeGiftRsp)((IDIPCmd_MailSendWholeGiftReq)this.cmd).rsp).head.Result = (((MailSendWholeGiftRsp)((IDIPPacket_MailSendWholeGiftRsp)((IDIPCmd_MailSendWholeGiftReq)this.cmd).rsp).body).Result = retcode);
/* 267 */     ((IDIPPacket_MailSendWholeGiftRsp)((IDIPCmd_MailSendWholeGiftReq)this.cmd).rsp).head.RetErrMsg = (((MailSendWholeGiftRsp)((IDIPPacket_MailSendWholeGiftRsp)((IDIPCmd_MailSendWholeGiftReq)this.cmd).rsp).body).RetMsg = retMsg);
/* 268 */     ((IDIPCmd_MailSendWholeGiftReq)this.cmd).sendResponse();
/*     */     
/* 270 */     GameServer.logger().info(String.format("[idip]PIDIPCmd_MailSendWholeGiftReq.handle@add compensate done|result=%b|min_level=%d|max_level=%d|mail_start=%s|mail_end=%s|mail_title=%s|mail_content=%s|itemid=%d|itemnum=%d|moneytype1=%d|moneynum1=%d|moneytype2=%d|moneynum2=%d|moneytype3=%d|moneynum3=%d|itemid2=%d|item_num2=%d|itemid3=%d|item_num3=%d|min_create_role_time=%d|max_create_role_time=%d|tagid=%d", new Object[] { Boolean.valueOf(result), Integer.valueOf(((MailSendWholeGiftReq)((IDIPPacket_MailSendWholeGiftReq)((IDIPCmd_MailSendWholeGiftReq)this.cmd).req).body).MinLevel), Integer.valueOf(((MailSendWholeGiftReq)((IDIPPacket_MailSendWholeGiftReq)((IDIPCmd_MailSendWholeGiftReq)this.cmd).req).body).MaxLevel), DateTimeUtils.formatTimestamp(mailStart), DateTimeUtils.formatTimestamp(mailEnd), mailTitle, mailContent, Integer.valueOf(((MailSendWholeGiftReq)((IDIPPacket_MailSendWholeGiftReq)((IDIPCmd_MailSendWholeGiftReq)this.cmd).req).body).OptionsID), Integer.valueOf(((MailSendWholeGiftReq)((IDIPPacket_MailSendWholeGiftReq)((IDIPCmd_MailSendWholeGiftReq)this.cmd).req).body).OptionsNum), Integer.valueOf(((MailSendWholeGiftReq)((IDIPPacket_MailSendWholeGiftReq)((IDIPCmd_MailSendWholeGiftReq)this.cmd).req).body).MoneyType1), Integer.valueOf(((MailSendWholeGiftReq)((IDIPPacket_MailSendWholeGiftReq)((IDIPCmd_MailSendWholeGiftReq)this.cmd).req).body).MoneyNum1), Integer.valueOf(((MailSendWholeGiftReq)((IDIPPacket_MailSendWholeGiftReq)((IDIPCmd_MailSendWholeGiftReq)this.cmd).req).body).MoneyType2), Integer.valueOf(((MailSendWholeGiftReq)((IDIPPacket_MailSendWholeGiftReq)((IDIPCmd_MailSendWholeGiftReq)this.cmd).req).body).MoneyNum2), Integer.valueOf(((MailSendWholeGiftReq)((IDIPPacket_MailSendWholeGiftReq)((IDIPCmd_MailSendWholeGiftReq)this.cmd).req).body).MoneyType3), Integer.valueOf(((MailSendWholeGiftReq)((IDIPPacket_MailSendWholeGiftReq)((IDIPCmd_MailSendWholeGiftReq)this.cmd).req).body).MoneyNum3), Integer.valueOf(((MailSendWholeGiftReq)((IDIPPacket_MailSendWholeGiftReq)((IDIPCmd_MailSendWholeGiftReq)this.cmd).req).body).Options2ID), Integer.valueOf(((MailSendWholeGiftReq)((IDIPPacket_MailSendWholeGiftReq)((IDIPCmd_MailSendWholeGiftReq)this.cmd).req).body).Options2Num), Integer.valueOf(((MailSendWholeGiftReq)((IDIPPacket_MailSendWholeGiftReq)((IDIPCmd_MailSendWholeGiftReq)this.cmd).req).body).Options3ID), Integer.valueOf(((MailSendWholeGiftReq)((IDIPPacket_MailSendWholeGiftReq)((IDIPCmd_MailSendWholeGiftReq)this.cmd).req).body).Options3Num), Long.valueOf(minCreateRoleTime), Long.valueOf(maxCreateRoleTime), Integer.valueOf(tagid) }));
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
/* 281 */     return result;
/*     */   }
/*     */   
/*     */ 
/*     */   private final void dumpFailedLog(long mailStart, long mailEnd, String mailTitle, String mailContent, String msg)
/*     */   {
/* 287 */     GameServer.logger().error(String.format("[idip]PIDIPCmd_MailSendWholeGiftReq.dumpFailedLog@%s|min_level=%d|max_level=%d|mail_start=%s|mail_end=%s|mail_title=%s|mail_content=%s|itemid=%d|itemnum=%d|moneytype1=%d|moneynum1=%d|moneytype2=%d|moneynum2=%d|moneytype3=%d|moneynum3=%d|itemid2=%d|item_num2=%d|itemid3=%d|item_num3=%d|min_create_role_time=%d|max_create_role_time=%d|tagid=%d", new Object[] { msg, Integer.valueOf(((MailSendWholeGiftReq)((IDIPPacket_MailSendWholeGiftReq)((IDIPCmd_MailSendWholeGiftReq)this.cmd).req).body).MinLevel), Integer.valueOf(((MailSendWholeGiftReq)((IDIPPacket_MailSendWholeGiftReq)((IDIPCmd_MailSendWholeGiftReq)this.cmd).req).body).MaxLevel), DateTimeUtils.formatTimestamp(mailStart), DateTimeUtils.formatTimestamp(mailEnd), mailTitle, mailContent, Integer.valueOf(((MailSendWholeGiftReq)((IDIPPacket_MailSendWholeGiftReq)((IDIPCmd_MailSendWholeGiftReq)this.cmd).req).body).OptionsID), Integer.valueOf(((MailSendWholeGiftReq)((IDIPPacket_MailSendWholeGiftReq)((IDIPCmd_MailSendWholeGiftReq)this.cmd).req).body).OptionsNum), Integer.valueOf(((MailSendWholeGiftReq)((IDIPPacket_MailSendWholeGiftReq)((IDIPCmd_MailSendWholeGiftReq)this.cmd).req).body).MoneyType1), Integer.valueOf(((MailSendWholeGiftReq)((IDIPPacket_MailSendWholeGiftReq)((IDIPCmd_MailSendWholeGiftReq)this.cmd).req).body).MoneyNum1), Integer.valueOf(((MailSendWholeGiftReq)((IDIPPacket_MailSendWholeGiftReq)((IDIPCmd_MailSendWholeGiftReq)this.cmd).req).body).MoneyType2), Integer.valueOf(((MailSendWholeGiftReq)((IDIPPacket_MailSendWholeGiftReq)((IDIPCmd_MailSendWholeGiftReq)this.cmd).req).body).MoneyNum2), Integer.valueOf(((MailSendWholeGiftReq)((IDIPPacket_MailSendWholeGiftReq)((IDIPCmd_MailSendWholeGiftReq)this.cmd).req).body).MoneyType3), Integer.valueOf(((MailSendWholeGiftReq)((IDIPPacket_MailSendWholeGiftReq)((IDIPCmd_MailSendWholeGiftReq)this.cmd).req).body).MoneyNum3), Integer.valueOf(((MailSendWholeGiftReq)((IDIPPacket_MailSendWholeGiftReq)((IDIPCmd_MailSendWholeGiftReq)this.cmd).req).body).Options2ID), Integer.valueOf(((MailSendWholeGiftReq)((IDIPPacket_MailSendWholeGiftReq)((IDIPCmd_MailSendWholeGiftReq)this.cmd).req).body).Options2Num), Integer.valueOf(((MailSendWholeGiftReq)((IDIPPacket_MailSendWholeGiftReq)((IDIPCmd_MailSendWholeGiftReq)this.cmd).req).body).Options3ID), Integer.valueOf(((MailSendWholeGiftReq)((IDIPPacket_MailSendWholeGiftReq)((IDIPCmd_MailSendWholeGiftReq)this.cmd).req).body).Options3Num), Integer.valueOf(((MailSendWholeGiftReq)((IDIPPacket_MailSendWholeGiftReq)((IDIPCmd_MailSendWholeGiftReq)this.cmd).req).body).FirstCreateTime), Integer.valueOf(((MailSendWholeGiftReq)((IDIPPacket_MailSendWholeGiftReq)((IDIPCmd_MailSendWholeGiftReq)this.cmd).req).body).LastCreateTime), Integer.valueOf(((MailSendWholeGiftReq)((IDIPPacket_MailSendWholeGiftReq)((IDIPCmd_MailSendWholeGiftReq)this.cmd).req).body).TagId) }));
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
/*     */   protected boolean isGameServerLevelCommand()
/*     */   {
/* 302 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PIDIPCmd_MailSendWholeGiftReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */