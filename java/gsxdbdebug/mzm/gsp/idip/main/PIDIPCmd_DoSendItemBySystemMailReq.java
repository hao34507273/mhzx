/*     */ package mzm.gsp.idip.main;
/*     */ 
/*     */ import idip.DoSendItemBySystemMailReq;
/*     */ import idip.DoSendItemBySystemMailRsp;
/*     */ import idip.IDIPCmd_DoSendItemBySystemMailReq;
/*     */ import idip.IDIPPacket_DoSendItemBySystemMailReq;
/*     */ import idip.IDIPPacket_DoSendItemBySystemMailRsp;
/*     */ import idip.core.IdipHeader;
/*     */ import idip.core.Utils;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.item.confbean.SItemCfg;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.mail.main.MailAttachment;
/*     */ import mzm.gsp.mail.main.MailInterface;
/*     */ import mzm.gsp.mail.main.SendMailRet;
/*     */ import mzm.gsp.mail.main.SendMailRet.RetEnum;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class PIDIPCmd_DoSendItemBySystemMailReq extends PIDIPCmd<IDIPCmd_DoSendItemBySystemMailReq>
/*     */ {
/*     */   public PIDIPCmd_DoSendItemBySystemMailReq(IDIPCmd_DoSendItemBySystemMailReq cmd)
/*     */   {
/*  28 */     super(cmd);
/*     */   }
/*     */   
/*     */ 
/*     */   private final boolean parseCurrency(Map<Integer, Integer> currencies, int currencyType, int currencyNum, String fieldName)
/*     */   {
/*  34 */     if ((currencyType > 0) && (currencyNum > 0))
/*     */     {
/*  36 */       if ((currencyType < 1) || (currencyType > 14))
/*     */       {
/*  38 */         ((IDIPPacket_DoSendItemBySystemMailRsp)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).rsp).head.Result = (((DoSendItemBySystemMailRsp)((IDIPPacket_DoSendItemBySystemMailRsp)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).rsp).body).Result = 'ﯧ');
/*  39 */         ((IDIPPacket_DoSendItemBySystemMailRsp)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).rsp).head.RetErrMsg = (((DoSendItemBySystemMailRsp)((IDIPPacket_DoSendItemBySystemMailRsp)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).rsp).body).RetMsg = String.format("%s invalid", new Object[] { fieldName }));
/*  40 */         ((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).sendResponse();
/*     */         
/*  42 */         GameServer.logger().error(String.format("[idip]PIDIPCmd_DoSendItemBySystemMailReq.parseCurrency@|ret=%d|ret_msg=%s|open_id=%s|partition_id=%d|ared_id=%d|plat_id=%d|source=%d|role_id=%s|item_id=%d|item_num=%d|money_type1=%d|money_num1=%d|money_type2=%d|money_num2=%d|money_type3=%d|money_num3=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoSendItemBySystemMailRsp)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoSendItemBySystemMailRsp)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).rsp).head.RetErrMsg, ((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).OpenId, Integer.valueOf(((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).Partition), Integer.valueOf(((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).AreaId), Byte.valueOf(((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).Source), ((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).RoleId, Long.valueOf(((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).ItemId), Integer.valueOf(((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).Num), Integer.valueOf(((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).MoneyType1), Integer.valueOf(((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).MoneyNum1), Integer.valueOf(((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).MoneyType2), Integer.valueOf(((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).MoneyNum2), Integer.valueOf(((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).MoneyType3), Integer.valueOf(((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).MoneyNum3), ((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).Serial }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  51 */         return false;
/*     */       }
/*  53 */       Integer oldCurrencyNum = (Integer)currencies.get(Integer.valueOf(currencyType));
/*  54 */       if (oldCurrencyNum == null)
/*     */       {
/*  56 */         currencies.put(Integer.valueOf(currencyType), Integer.valueOf(currencyNum));
/*     */       }
/*     */       else
/*     */       {
/*  60 */         currencies.put(Integer.valueOf(currencyType), Integer.valueOf(oldCurrencyNum.intValue() + currencyNum));
/*     */       }
/*     */     }
/*     */     
/*  64 */     return true;
/*     */   }
/*     */   
/*     */   protected boolean handle()
/*     */     throws Exception
/*     */   {
/*  70 */     String openId = ((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).OpenId;
/*  71 */     int areaId = ((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).AreaId;
/*  72 */     int partition = ((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).Partition;
/*     */     
/*  74 */     String userId = Utils.getUserId(openId, areaId, partition);
/*  75 */     xbean.User xUser = xtable.User.get(userId);
/*  76 */     if (null == xUser)
/*     */     {
/*  78 */       ((IDIPPacket_DoSendItemBySystemMailRsp)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).rsp).head.Result = 1;
/*  79 */       ((IDIPPacket_DoSendItemBySystemMailRsp)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).rsp).head.RetErrMsg = "query userid empty";
/*  80 */       ((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).sendResponse();
/*     */       
/*  82 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoSendItemBySystemMailReq.handle@user not found|ret=%d|ret_msg=%s|user_id=%s|ared_id=%d|plat_id=%d|source=%d|role_id=%s|item_id=%d|item_num=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoSendItemBySystemMailRsp)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoSendItemBySystemMailRsp)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).Source), ((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).RoleId, Long.valueOf(((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).ItemId), Integer.valueOf(((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).Num), ((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  88 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  92 */     if (((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).RoleId.length() > 32)
/*     */     {
/*  94 */       ((IDIPPacket_DoSendItemBySystemMailRsp)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).rsp).head.Result = (((DoSendItemBySystemMailRsp)((IDIPPacket_DoSendItemBySystemMailRsp)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).rsp).body).Result = 1);
/*  95 */       ((IDIPPacket_DoSendItemBySystemMailRsp)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).rsp).head.RetErrMsg = (((DoSendItemBySystemMailRsp)((IDIPPacket_DoSendItemBySystemMailRsp)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).rsp).body).RetMsg = String.format("roleid length > %d", new Object[] { Integer.valueOf(32) }));
/*     */       
/*  97 */       ((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).sendResponse();
/*     */       
/*  99 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoSendItemBySystemMailReq.handle@roleId length > MAX_ROLEID_LEN|ret=%d|ret_msg=%s|user_id=%s|ared_id=%d|plat_id=%d|source=%d|role_id=%s|item_id=%d|item_num=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoSendItemBySystemMailRsp)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoSendItemBySystemMailRsp)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).Source), ((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).RoleId, Long.valueOf(((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).ItemId), Integer.valueOf(((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).Num), ((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 105 */       return false;
/*     */     }
/*     */     
/* 108 */     long roleId = -1L;
/*     */     try
/*     */     {
/* 111 */       roleId = Long.parseLong(((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).RoleId);
/*     */     }
/*     */     catch (NumberFormatException e)
/*     */     {
/* 115 */       ((IDIPPacket_DoSendItemBySystemMailRsp)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).rsp).head.Result = (((DoSendItemBySystemMailRsp)((IDIPPacket_DoSendItemBySystemMailRsp)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).rsp).body).Result = 1);
/* 116 */       ((IDIPPacket_DoSendItemBySystemMailRsp)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).rsp).head.RetErrMsg = (((DoSendItemBySystemMailRsp)((IDIPPacket_DoSendItemBySystemMailRsp)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).rsp).body).RetMsg = "roleid format error");
/* 117 */       ((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).sendResponse();
/*     */       
/* 119 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoSendItemBySystemMailReq.handle@role not found|ret=%d|ret_msg=%s|user_id=%s|user_role_list=%s|plat_id=%d|ared_id=%d|role_id=%s|item_id=%d|item_num=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoSendItemBySystemMailRsp)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoSendItemBySystemMailRsp)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).rsp).head.RetErrMsg, userId, xUser.getRoleids().toString(), Byte.valueOf(((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).PlatId), Integer.valueOf(areaId), ((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).RoleId, Long.valueOf(((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).ItemId), Integer.valueOf(((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).Num), getSerialNo() }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 125 */       return false;
/*     */     }
/*     */     
/* 128 */     if ((!mzm.gsp.role.main.RoleInterface.isRoleExist(roleId, true)) || (!xUser.getRoleids().contains(Long.valueOf(roleId))))
/*     */     {
/* 130 */       ((IDIPPacket_DoSendItemBySystemMailRsp)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).rsp).head.Result = 1;
/* 131 */       ((IDIPPacket_DoSendItemBySystemMailRsp)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).rsp).head.RetErrMsg = "query roleid empty";
/* 132 */       ((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).sendResponse();
/*     */       
/* 134 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoSendItemBySystemMailReq.handle@role not found|ret=%d|ret_msg=%s|user_id=%s|user_role_list=%s|plat_id=%d|ared_id=%d|role_id=%d|item_id=%d|item_num=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoSendItemBySystemMailRsp)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoSendItemBySystemMailRsp)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).rsp).head.RetErrMsg, userId, xUser.getRoleids().toString(), Byte.valueOf(((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).PlatId), Integer.valueOf(areaId), Long.valueOf(roleId), Long.valueOf(((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).ItemId), Integer.valueOf(((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).Num), getSerialNo() }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 140 */       return false;
/*     */     }
/*     */     
/* 143 */     String mailTitle = Utils.urlDecode1738(((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).MailTitle);
/* 144 */     String mailContent = Utils.urlDecode1738(((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).MailContent);
/* 145 */     if (mailTitle.isEmpty())
/*     */     {
/* 147 */       ((IDIPPacket_DoSendItemBySystemMailRsp)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).rsp).head.Result = 64491;
/* 148 */       ((IDIPPacket_DoSendItemBySystemMailRsp)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).rsp).head.RetErrMsg = "send mail title not empty";
/* 149 */       ((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).sendResponse();
/*     */       
/* 151 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoSendItemBySystemMailReq.handle@title is empty|ret=%d|ret_msg=%s|user_id=%s|ared_id=%d|plat_id=%d|source=%d|role_id=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoSendItemBySystemMailRsp)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoSendItemBySystemMailRsp)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).Source), Long.valueOf(roleId), getSerialNo() }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 156 */       return false;
/*     */     }
/* 158 */     if (mailTitle.length() > 120)
/*     */     {
/* 160 */       ((IDIPPacket_DoSendItemBySystemMailRsp)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).rsp).head.Result = 64491;
/* 161 */       ((IDIPPacket_DoSendItemBySystemMailRsp)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).rsp).head.RetErrMsg = String.format("send mail title length > %d", new Object[] { Integer.valueOf(120) });
/* 162 */       ((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).sendResponse();
/*     */       
/* 164 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoSendItemBySystemMailReq.handle@title length > MAX_MAILTITLE_LEN|ret=%d|ret_msg=%s|user_id=%s|ared_id=%d|plat_id=%d|source=%d|role_id=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoSendItemBySystemMailRsp)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoSendItemBySystemMailRsp)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).Source), Long.valueOf(roleId), getSerialNo() }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 169 */       return false;
/*     */     }
/*     */     
/* 172 */     if (mailContent.isEmpty())
/*     */     {
/* 174 */       ((IDIPPacket_DoSendItemBySystemMailRsp)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).rsp).head.Result = 64490;
/* 175 */       ((IDIPPacket_DoSendItemBySystemMailRsp)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).rsp).head.RetErrMsg = "send mail content not empty";
/* 176 */       ((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).sendResponse();
/*     */       
/* 178 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoSendItemBySystemMailReq.handle@content is empty|ret=%d|ret_msg=%s|user_id=%s|ared_id=%d|plat_id=%d|source=%d|role_id=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoSendItemBySystemMailRsp)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoSendItemBySystemMailRsp)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).Source), Long.valueOf(roleId), getSerialNo() }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 183 */       return false;
/*     */     }
/* 185 */     if (mailContent.length() > 3200)
/*     */     {
/* 187 */       ((IDIPPacket_DoSendItemBySystemMailRsp)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).rsp).head.Result = 64490;
/* 188 */       ((IDIPPacket_DoSendItemBySystemMailRsp)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).rsp).head.RetErrMsg = String.format("send mail content > %d", new Object[] { Integer.valueOf(3200) });
/*     */       
/* 190 */       ((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).sendResponse();
/*     */       
/* 192 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoSendItemBySystemMailReq.handle@content length > MAX_MAILCONTENT_LEN|ret=%d|ret_msg=%s|user_id=%s|ared_id=%d|plat_id=%d|source=%d|role_id=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoSendItemBySystemMailRsp)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoSendItemBySystemMailRsp)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).Source), Long.valueOf(roleId), getSerialNo() }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 197 */       return false;
/*     */     }
/*     */     
/* 200 */     int sendItemId = (int)((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).ItemId;
/* 201 */     int sendItemNum = ((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).Num;
/* 202 */     Map<Integer, Integer> items = new HashMap();
/* 203 */     if ((((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).ItemId > 0L) && (((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).Num > 0))
/*     */     {
/* 205 */       SItemCfg itemCfg = ItemInterface.getSItemCfg(sendItemId);
/* 206 */       if (itemCfg == null)
/*     */       {
/* 208 */         ((IDIPPacket_DoSendItemBySystemMailRsp)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).rsp).head.Result = 64494;
/* 209 */         ((IDIPPacket_DoSendItemBySystemMailRsp)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).rsp).head.RetErrMsg = "send item not exist";
/* 210 */         ((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).sendResponse();
/*     */         
/* 212 */         GameServer.logger().error(String.format("[idip]PIDIPCmd_DoSendItemBySystemMailReq.handle@item not exist in config|ret=%d|ret_msg=%s|user_id=%s|ared_id=%d|plat_id=%d|source=%d|role_id=%s|item_id=%d|item_num=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoSendItemBySystemMailRsp)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoSendItemBySystemMailRsp)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).AreaId), Byte.valueOf(((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).Source), ((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).RoleId, Integer.valueOf(sendItemId), Integer.valueOf(sendItemNum), getSerialNo() }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 218 */         return false;
/*     */       }
/* 220 */       items.put(Integer.valueOf((int)((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).ItemId), Integer.valueOf(((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).Num));
/*     */     }
/*     */     
/* 223 */     Map<Integer, Integer> currencies = new HashMap();
/* 224 */     if (!parseCurrency(currencies, ((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).MoneyType1, ((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).MoneyNum1, "MoneyType1"))
/*     */     {
/* 226 */       return false;
/*     */     }
/* 228 */     if (!parseCurrency(currencies, ((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).MoneyType2, ((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).MoneyNum2, "MoneyType2"))
/*     */     {
/* 230 */       return false;
/*     */     }
/* 232 */     if (!parseCurrency(currencies, ((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).MoneyType3, ((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).MoneyNum3, "MoneyType3"))
/*     */     {
/* 234 */       return false;
/*     */     }
/*     */     
/* 237 */     if ((items.size() == 0) && (currencies.size() == 0))
/*     */     {
/* 239 */       ((IDIPPacket_DoSendItemBySystemMailRsp)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).rsp).head.Result = 64488;
/* 240 */       ((IDIPPacket_DoSendItemBySystemMailRsp)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).rsp).head.RetErrMsg = "mail has no valid data";
/* 241 */       ((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).sendResponse();
/*     */       
/* 243 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoSendItemBySystemMailReq.handle@no valid data|ret=%d|ret_msg=%s|user_id=%s|ared_id=%d|plat_id=%d|source=%d|role_id=%d|item_id=%d|item_num=%d|money_type1=%d|money_num1=%d|money_type2=%d|money_num2=%d|money_type3=%d|money_num3=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoSendItemBySystemMailRsp)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoSendItemBySystemMailRsp)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).Source), Long.valueOf(roleId), Long.valueOf(((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).ItemId), Integer.valueOf(((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).Num), Integer.valueOf(((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).MoneyType1), Integer.valueOf(((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).MoneyNum1), Integer.valueOf(((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).MoneyType2), Integer.valueOf(((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).MoneyNum2), Integer.valueOf(((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).MoneyType3), Integer.valueOf(((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).MoneyNum3), getSerialNo() }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 251 */       return false;
/*     */     }
/*     */     
/* 254 */     MailAttachment mailAttachment = MailInterface.createMailAttachment();
/* 255 */     mailAttachment.addItemMap(items);
/* 256 */     IDIPCurrencyType.fillMailCurrencyAttachment(mailAttachment, currencies);
/*     */     
/* 258 */     TLogArg tLogArg = new TLogArg(LogReason.IDIP_ADD);
/* 259 */     String tag = "";
/* 260 */     int tagid = ((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).TagId;
/* 261 */     if (tagid != 0)
/*     */     {
/* 263 */       tag = "P1_" + tagid;
/*     */     }
/* 265 */     SendMailRet sendMailRet = MailInterface.synBuildAndSendMail(roleId, 1, mailTitle, mailContent, mailAttachment, tLogArg, tag);
/*     */     
/*     */ 
/* 268 */     if (!sendMailRet.isOK())
/*     */     {
/* 270 */       ((IDIPPacket_DoSendItemBySystemMailRsp)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).rsp).head.Result = sendMailRet.getRetEnum().ret;
/* 271 */       ((IDIPPacket_DoSendItemBySystemMailRsp)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).rsp).head.RetErrMsg = sendMailRet.getRetEnum().retMsg;
/* 272 */       ((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).sendResponse();
/*     */       
/* 274 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoSendItemBySystemMailReq.handle@send item by system mail failed|ret=%d|ret_msg=%s|user_id=%s|ared_id=%d|plat_id=%d|source=%d|role_id=%d|item_id=%d|item_num=%d|serial=%s|tagid=%d", new Object[] { Integer.valueOf(((IDIPPacket_DoSendItemBySystemMailRsp)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoSendItemBySystemMailRsp)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).Source), Long.valueOf(roleId), Integer.valueOf(sendItemId), Integer.valueOf(sendItemNum), getSerialNo(), Integer.valueOf(tagid) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 279 */       return false;
/*     */     }
/*     */     
/* 282 */     StringBuilder logStr = new StringBuilder();
/*     */     
/* 284 */     logStr.append(((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).head.SendTime).append("|");
/* 285 */     logStr.append(((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).OpenId).append("|");
/* 286 */     logStr.append(((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).AreaId).append("|");
/* 287 */     logStr.append(((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).Partition).append("|");
/* 288 */     logStr.append(((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).ItemId).append("|");
/* 289 */     logStr.append(((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).Num).append("|");
/* 290 */     logStr.append(((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).head.Cmdid).append("|");
/* 291 */     logStr.append(((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).Serial).append("|");
/* 292 */     logStr.append(((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).Source).append("|");
/* 293 */     logStr.append(0).append("|");
/* 294 */     logStr.append(0).append("|");
/* 295 */     logStr.append(sendMailRet.getRetEnum().ret).append("|");
/* 296 */     logStr.append(sendMailRet.getRetEnum().retMsg).append("|");
/* 297 */     logStr.append(((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).MoneyType1).append("|");
/* 298 */     logStr.append(((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).MoneyNum1).append("|");
/* 299 */     logStr.append(((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).MoneyType2).append("|");
/* 300 */     logStr.append(((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).MoneyNum2).append("|");
/* 301 */     logStr.append(((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).MoneyType3).append("|");
/* 302 */     logStr.append(((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).MoneyNum3).append("|");
/* 303 */     logStr.append(roleId).append("|");
/* 304 */     logStr.append(tagid);
/*     */     
/* 306 */     TLogManager.getInstance().addLog(roleId, "IDIPDoSendItemBySystemMail", logStr.toString());
/*     */     
/* 308 */     ((IDIPPacket_DoSendItemBySystemMailRsp)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).rsp).head.Result = 0;
/* 309 */     ((IDIPPacket_DoSendItemBySystemMailRsp)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).rsp).head.RetErrMsg = "ok";
/* 310 */     ((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).sendResponse();
/*     */     
/* 312 */     GameServer.logger().info(String.format("[idip]PIDIPCmd_DoSendItemBySystemMailReq.handle@send item by system mail success|ret=%d|ret_msg=%s|user_id=%s|ared_id=%d|plat_id=%d|source=%d|role_id=%d|item_id=%d|item_num=%d|money_type1=%d|money_num1=%d|money_type2=%d|money_num2=%d|money_type3=%d|money_num3=%d|serial=%s|tagid=%d", new Object[] { Integer.valueOf(((IDIPPacket_DoSendItemBySystemMailRsp)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoSendItemBySystemMailRsp)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).Source), Long.valueOf(roleId), Integer.valueOf(sendItemId), Integer.valueOf(sendItemNum), Integer.valueOf(((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).MoneyType1), Integer.valueOf(((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).MoneyNum1), Integer.valueOf(((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).MoneyType2), Integer.valueOf(((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).MoneyNum2), Integer.valueOf(((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).MoneyType3), Integer.valueOf(((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).MoneyNum3), getSerialNo(), Integer.valueOf(tagid) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 319 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   protected String getSerialNo()
/*     */   {
/* 325 */     return ((DoSendItemBySystemMailReq)((IDIPPacket_DoSendItemBySystemMailReq)((IDIPCmd_DoSendItemBySystemMailReq)this.cmd).req).body).Serial;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PIDIPCmd_DoSendItemBySystemMailReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */