/*     */ package mzm.gsp.idip.main;
/*     */ 
/*     */ import idip.DoSendMoreItemBySystemMailReq;
/*     */ import idip.DoSendMoreItemBySystemMailRsp;
/*     */ import idip.IDIPCmd_DoSendMoreItemBySystemMailReq;
/*     */ import idip.IDIPPacket_DoSendMoreItemBySystemMailReq;
/*     */ import idip.IDIPPacket_DoSendMoreItemBySystemMailRsp;
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
/*     */ public class PIDIPCmd_DoSendMoreItemBySystemMailReq extends PIDIPCmd<IDIPCmd_DoSendMoreItemBySystemMailReq>
/*     */ {
/*     */   public PIDIPCmd_DoSendMoreItemBySystemMailReq(IDIPCmd_DoSendMoreItemBySystemMailReq cmd)
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
/*  38 */         ((IDIPPacket_DoSendMoreItemBySystemMailRsp)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).rsp).head.Result = (((DoSendMoreItemBySystemMailRsp)((IDIPPacket_DoSendMoreItemBySystemMailRsp)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).rsp).body).Result = 'ﯧ');
/*  39 */         ((IDIPPacket_DoSendMoreItemBySystemMailRsp)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).rsp).head.RetErrMsg = (((DoSendMoreItemBySystemMailRsp)((IDIPPacket_DoSendMoreItemBySystemMailRsp)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).rsp).body).RetMsg = String.format("%s invalid", new Object[] { fieldName }));
/*  40 */         ((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).sendResponse();
/*     */         
/*  42 */         GameServer.logger().error(String.format("[idip]PIDIPCmd_DoSendMoreItemBySystemMailReq.parseCurrency@|ret=%d|ret_msg=%s|open_id=%s|partition_id=%d|area_id=%d|plat_id=%d|source=%d|role_id=%s|item_id1=%d|item_num1=%d|item_id2=%d|item_num2=%d|item_id3=%d|item_num3=%d|item_id4=%d|item_num4=%d|money_type1=%d|money_num1=%d|money_type2=%d|money_num2=%d|money_type3=%d|money_num3=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoSendMoreItemBySystemMailRsp)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoSendMoreItemBySystemMailRsp)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).rsp).head.RetErrMsg, ((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).OpenId, Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).Partition), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).AreaId), Byte.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).Source), ((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).RoleId, Long.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).ItemId1), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).ItemNum1), Long.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).ItemId2), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).ItemNum2), Long.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).ItemId3), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).ItemNum3), Long.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).ItemId4), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).ItemNum4), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).MoneyType1), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).MoneyNum1), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).MoneyType2), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).MoneyNum2), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).MoneyType3), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).MoneyNum3), ((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).Serial }));
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
/*  53 */         return false;
/*     */       }
/*  55 */       Integer oldCurrencyNum = (Integer)currencies.get(Integer.valueOf(currencyType));
/*  56 */       if (oldCurrencyNum == null)
/*     */       {
/*  58 */         currencies.put(Integer.valueOf(currencyType), Integer.valueOf(currencyNum));
/*     */       }
/*     */       else
/*     */       {
/*  62 */         currencies.put(Integer.valueOf(currencyType), Integer.valueOf(oldCurrencyNum.intValue() + currencyNum));
/*     */       }
/*     */     }
/*     */     
/*  66 */     return true;
/*     */   }
/*     */   
/*     */   protected boolean handle()
/*     */     throws Exception
/*     */   {
/*  72 */     String openId = ((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).OpenId;
/*  73 */     int areaId = ((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).AreaId;
/*  74 */     int partition = ((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).Partition;
/*     */     
/*  76 */     String userId = Utils.getUserId(openId, areaId, partition);
/*  77 */     xbean.User xUser = xtable.User.get(userId);
/*  78 */     if (null == xUser)
/*     */     {
/*  80 */       ((IDIPPacket_DoSendMoreItemBySystemMailRsp)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).rsp).head.Result = 1;
/*  81 */       ((IDIPPacket_DoSendMoreItemBySystemMailRsp)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).rsp).head.RetErrMsg = "query userid empty";
/*  82 */       ((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).sendResponse();
/*     */       
/*  84 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoSendMoreItemBySystemMailReq.handle@user not found|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|source=%d|role_id=%s|item_id1=%d|item_num1=%d|item_id2=%d|item_num2=%d|item_id3=%d|item_num3=%d|item_id4=%d|item_num4=%d|money_type1=%d|money_num1=%d|money_type2=%d|money_num2=%d|money_type3=%d|money_num3=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoSendMoreItemBySystemMailRsp)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoSendMoreItemBySystemMailRsp)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).Source), ((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).RoleId, Long.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).ItemId1), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).ItemNum1), Long.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).ItemId2), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).ItemNum2), Long.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).ItemId3), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).ItemNum3), Long.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).ItemId4), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).ItemNum4), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).MoneyType1), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).MoneyNum1), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).MoneyType2), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).MoneyNum2), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).MoneyType3), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).MoneyNum3), ((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  94 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  98 */     if (((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).RoleId.length() > 32)
/*     */     {
/* 100 */       ((IDIPPacket_DoSendMoreItemBySystemMailRsp)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).rsp).head.Result = (((DoSendMoreItemBySystemMailRsp)((IDIPPacket_DoSendMoreItemBySystemMailRsp)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).rsp).body).Result = 1);
/* 101 */       ((IDIPPacket_DoSendMoreItemBySystemMailRsp)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).rsp).head.RetErrMsg = (((DoSendMoreItemBySystemMailRsp)((IDIPPacket_DoSendMoreItemBySystemMailRsp)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).rsp).body).RetMsg = String.format("roleid length > %d", new Object[] { Integer.valueOf(32) }));
/*     */       
/* 103 */       ((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).sendResponse();
/*     */       
/* 105 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoSendMoreItemBySystemMailReq.handle@roleId length > MAX_ROLEID_LEN|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|source=%d|role_id=%s|item_id1=%d|item_num1=%d|item_id2=%d|item_num2=%d|item_id3=%d|item_num3=%d|item_id4=%d|item_num4=%d|money_type1=%d|money_num1=%d|money_type2=%d|money_num2=%d|money_type3=%d|money_num3=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoSendMoreItemBySystemMailRsp)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoSendMoreItemBySystemMailRsp)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).Source), ((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).RoleId, Long.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).ItemId1), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).ItemNum1), Long.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).ItemId2), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).ItemNum2), Long.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).ItemId3), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).ItemNum3), Long.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).ItemId4), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).ItemNum4), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).MoneyType1), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).MoneyNum1), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).MoneyType2), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).MoneyNum2), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).MoneyType3), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).MoneyNum3), ((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 115 */       return false;
/*     */     }
/*     */     
/* 118 */     long roleId = -1L;
/*     */     try
/*     */     {
/* 121 */       roleId = Long.parseLong(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).RoleId);
/*     */     }
/*     */     catch (NumberFormatException e)
/*     */     {
/* 125 */       ((IDIPPacket_DoSendMoreItemBySystemMailRsp)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).rsp).head.Result = (((DoSendMoreItemBySystemMailRsp)((IDIPPacket_DoSendMoreItemBySystemMailRsp)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).rsp).body).Result = 1);
/* 126 */       ((IDIPPacket_DoSendMoreItemBySystemMailRsp)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).rsp).head.RetErrMsg = (((DoSendMoreItemBySystemMailRsp)((IDIPPacket_DoSendMoreItemBySystemMailRsp)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).rsp).body).RetMsg = "roleid format error");
/* 127 */       ((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).sendResponse();
/*     */       
/* 129 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoSendMoreItemBySystemMailReq.handle@role not found|ret=%d|ret_msg=%s|user_id=%s|user_role_list=%s|area_id=%d|plat_id=%d|source=%d|role_id=%s|item_id1=%d|item_num1=%d|item_id2=%d|item_num2=%d|item_id3=%d|item_num3=%d|item_id4=%d|item_num4=%d|money_type1=%d|money_num1=%d|money_type2=%d|money_num2=%d|money_type3=%d|money_num3=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoSendMoreItemBySystemMailRsp)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoSendMoreItemBySystemMailRsp)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).rsp).head.RetErrMsg, userId, xUser.getRoleids().toString(), Integer.valueOf(areaId), Byte.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).Source), ((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).RoleId, Long.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).ItemId1), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).ItemNum1), Long.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).ItemId2), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).ItemNum2), Long.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).ItemId3), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).ItemNum3), Long.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).ItemId4), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).ItemNum4), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).MoneyType1), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).MoneyNum1), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).MoneyType2), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).MoneyNum2), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).MoneyType3), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).MoneyNum3), ((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 139 */       return false;
/*     */     }
/*     */     
/* 142 */     if ((!mzm.gsp.role.main.RoleInterface.isRoleExist(roleId, true)) || (!xUser.getRoleids().contains(Long.valueOf(roleId))))
/*     */     {
/* 144 */       ((IDIPPacket_DoSendMoreItemBySystemMailRsp)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).rsp).head.Result = 1;
/* 145 */       ((IDIPPacket_DoSendMoreItemBySystemMailRsp)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).rsp).head.RetErrMsg = "query roleid empty";
/* 146 */       ((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).sendResponse();
/*     */       
/* 148 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoSendMoreItemBySystemMailReq.handle@role not found|ret=%d|ret_msg=%s|user_id=%s|user_role_list=%s|area_id=%d|plat_id=%d|source=%d|role_id=%s|item_id1=%d|item_num1=%d|item_id2=%d|item_num2=%d|item_id3=%d|item_num3=%d|item_id4=%d|item_num4=%d|money_type1=%d|money_num1=%d|money_type2=%d|money_num2=%d|money_type3=%d|money_num3=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoSendMoreItemBySystemMailRsp)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoSendMoreItemBySystemMailRsp)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).rsp).head.RetErrMsg, userId, xUser.getRoleids().toString(), Integer.valueOf(areaId), Byte.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).Source), ((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).RoleId, Long.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).ItemId1), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).ItemNum1), Long.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).ItemId2), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).ItemNum2), Long.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).ItemId3), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).ItemNum3), Long.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).ItemId4), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).ItemNum4), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).MoneyType1), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).MoneyNum1), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).MoneyType2), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).MoneyNum2), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).MoneyType3), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).MoneyNum3), ((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 158 */       return false;
/*     */     }
/*     */     
/* 161 */     String mailTitle = Utils.urlDecode1738(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).MailTitle);
/* 162 */     String mailContent = Utils.urlDecode1738(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).MailContent);
/* 163 */     if (mailTitle.isEmpty())
/*     */     {
/* 165 */       ((IDIPPacket_DoSendMoreItemBySystemMailRsp)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).rsp).head.Result = 64491;
/* 166 */       ((IDIPPacket_DoSendMoreItemBySystemMailRsp)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).rsp).head.RetErrMsg = "send mail title not empty";
/* 167 */       ((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).sendResponse();
/*     */       
/* 169 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoSendMoreItemBySystemMailReq.handle@title is empty|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|source=%d|role_id=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoSendMoreItemBySystemMailRsp)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoSendMoreItemBySystemMailRsp)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).Source), Long.valueOf(roleId), getSerialNo() }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 174 */       return false;
/*     */     }
/* 176 */     if (mailTitle.length() > 120)
/*     */     {
/* 178 */       ((IDIPPacket_DoSendMoreItemBySystemMailRsp)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).rsp).head.Result = 64491;
/* 179 */       ((IDIPPacket_DoSendMoreItemBySystemMailRsp)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).rsp).head.RetErrMsg = String.format("send mail title length > %d", new Object[] { Integer.valueOf(120) });
/* 180 */       ((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).sendResponse();
/*     */       
/* 182 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoSendMoreItemBySystemMailReq.handle@title length > MAX_MAILTITLE_LEN|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|source=%d|role_id=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoSendMoreItemBySystemMailRsp)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoSendMoreItemBySystemMailRsp)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).Source), Long.valueOf(roleId), getSerialNo() }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 187 */       return false;
/*     */     }
/*     */     
/* 190 */     if (mailContent.isEmpty())
/*     */     {
/* 192 */       ((IDIPPacket_DoSendMoreItemBySystemMailRsp)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).rsp).head.Result = 64490;
/* 193 */       ((IDIPPacket_DoSendMoreItemBySystemMailRsp)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).rsp).head.RetErrMsg = "send mail content not empty";
/* 194 */       ((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).sendResponse();
/*     */       
/* 196 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoSendMoreItemBySystemMailReq.handle@content is empty|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|source=%d|role_id=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoSendMoreItemBySystemMailRsp)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoSendMoreItemBySystemMailRsp)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).Source), Long.valueOf(roleId), getSerialNo() }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 201 */       return false;
/*     */     }
/* 203 */     if (mailContent.length() > 3200)
/*     */     {
/* 205 */       ((IDIPPacket_DoSendMoreItemBySystemMailRsp)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).rsp).head.Result = 64490;
/* 206 */       ((IDIPPacket_DoSendMoreItemBySystemMailRsp)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).rsp).head.RetErrMsg = String.format("send mail content > %d", new Object[] { Integer.valueOf(3200) });
/*     */       
/* 208 */       ((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).sendResponse();
/*     */       
/* 210 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoSendMoreItemBySystemMailReq.handle@content length > MAX_MAILCONTENT_LEN|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|source=%d|role_id=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoSendMoreItemBySystemMailRsp)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoSendMoreItemBySystemMailRsp)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).Source), Long.valueOf(roleId), getSerialNo() }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 215 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 219 */     Map<Integer, Integer> items = new HashMap();
/* 220 */     if (!itemCheck(items, (int)((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).ItemId1, ((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).ItemNum1))
/*     */     {
/* 222 */       return false;
/*     */     }
/* 224 */     if (!itemCheck(items, (int)((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).ItemId2, ((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).ItemNum2))
/*     */     {
/* 226 */       return false;
/*     */     }
/* 228 */     if (!itemCheck(items, (int)((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).ItemId3, ((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).ItemNum3))
/*     */     {
/* 230 */       return false;
/*     */     }
/* 232 */     if (!itemCheck(items, (int)((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).ItemId4, ((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).ItemNum4))
/*     */     {
/* 234 */       return false;
/*     */     }
/*     */     
/* 237 */     Map<Integer, Integer> currencies = new HashMap();
/* 238 */     if (!parseCurrency(currencies, ((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).MoneyType1, ((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).MoneyNum1, "MoneyType1"))
/*     */     {
/* 240 */       return false;
/*     */     }
/* 242 */     if (!parseCurrency(currencies, ((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).MoneyType2, ((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).MoneyNum2, "MoneyType2"))
/*     */     {
/* 244 */       return false;
/*     */     }
/* 246 */     if (!parseCurrency(currencies, ((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).MoneyType3, ((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).MoneyNum3, "MoneyType3"))
/*     */     {
/* 248 */       return false;
/*     */     }
/*     */     
/* 251 */     if ((items.size() == 0) && (currencies.size() == 0))
/*     */     {
/* 253 */       ((IDIPPacket_DoSendMoreItemBySystemMailRsp)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).rsp).head.Result = 64488;
/* 254 */       ((IDIPPacket_DoSendMoreItemBySystemMailRsp)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).rsp).head.RetErrMsg = "mail has no valid data";
/* 255 */       ((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).sendResponse();
/*     */       
/* 257 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoSendMoreItemBySystemMailReq.handle@no valid data|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|source=%d|role_id=%d|item_id1=%d|item_num1=%d|item_id2=%d|item_num2=%d|item_id3=%d|item_num3=%d|item_id4=%d|item_num4=%d|money_type1=%d|money_num1=%d|money_type2=%d|money_num2=%d|money_type3=%d|money_num3=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoSendMoreItemBySystemMailRsp)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoSendMoreItemBySystemMailRsp)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).Source), Long.valueOf(roleId), Long.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).ItemId1), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).ItemNum1), Long.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).ItemId2), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).ItemNum2), Long.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).ItemId3), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).ItemNum3), Long.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).ItemId4), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).ItemNum4), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).MoneyType1), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).MoneyNum1), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).MoneyType2), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).MoneyNum2), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).MoneyType3), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).MoneyNum3), ((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 267 */       return false;
/*     */     }
/*     */     
/* 270 */     MailAttachment mailAttachment = MailInterface.createMailAttachment();
/* 271 */     mailAttachment.addItemMap(items);
/* 272 */     IDIPCurrencyType.fillMailCurrencyAttachment(mailAttachment, currencies);
/*     */     
/* 274 */     TLogArg tLogArg = new TLogArg(LogReason.IDIP_ADD);
/* 275 */     String tag = "";
/* 276 */     int tagid = ((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).TagId;
/* 277 */     if (tagid != 0)
/*     */     {
/* 279 */       tag = "P2_" + tagid;
/*     */     }
/* 281 */     SendMailRet sendMailRet = MailInterface.synBuildAndSendMail(roleId, 1, mailTitle, mailContent, mailAttachment, tLogArg, tag);
/*     */     
/*     */ 
/* 284 */     if (!sendMailRet.isOK())
/*     */     {
/* 286 */       ((IDIPPacket_DoSendMoreItemBySystemMailRsp)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).rsp).head.Result = sendMailRet.getRetEnum().ret;
/* 287 */       ((IDIPPacket_DoSendMoreItemBySystemMailRsp)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).rsp).head.RetErrMsg = sendMailRet.getRetEnum().retMsg;
/* 288 */       ((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).sendResponse();
/*     */       
/* 290 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoSendMoreItemBySystemMailReq.handle@send item by system mail failed|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|source=%d|role_id=%d|item_id1=%d|item_num1=%d|item_id2=%d|item_num2=%d|item_id3=%d|item_num3=%d|item_id4=%d|item_num4=%d|money_type1=%d|money_num1=%d|money_type2=%d|money_num2=%d|money_type3=%d|money_num3=%d|serial=%s|tagid=%d", new Object[] { Integer.valueOf(((IDIPPacket_DoSendMoreItemBySystemMailRsp)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoSendMoreItemBySystemMailRsp)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).Source), Long.valueOf(roleId), Long.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).ItemId1), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).ItemNum1), Long.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).ItemId2), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).ItemNum2), Long.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).ItemId3), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).ItemNum3), Long.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).ItemId4), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).ItemNum4), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).MoneyType1), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).MoneyNum1), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).MoneyType2), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).MoneyNum2), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).MoneyType3), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).MoneyNum3), ((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).Serial, Integer.valueOf(tagid) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 300 */       return false;
/*     */     }
/*     */     
/* 303 */     StringBuilder logStr = new StringBuilder();
/*     */     
/* 305 */     logStr.append(((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).head.SendTime).append("|");
/* 306 */     logStr.append(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).OpenId).append("|");
/* 307 */     logStr.append(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).AreaId).append("|");
/* 308 */     logStr.append(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).Partition).append("|");
/*     */     
/* 310 */     logStr.append(0).append("|");
/* 311 */     logStr.append(0).append("|");
/*     */     
/* 313 */     logStr.append(((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).head.Cmdid).append("|");
/* 314 */     logStr.append(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).Serial).append("|");
/* 315 */     logStr.append(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).Source).append("|");
/* 316 */     logStr.append(0).append("|");
/* 317 */     logStr.append(0).append("|");
/* 318 */     logStr.append(sendMailRet.getRetEnum().ret).append("|");
/* 319 */     logStr.append(sendMailRet.getRetEnum().retMsg).append("|");
/* 320 */     logStr.append(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).MoneyType1).append("|");
/* 321 */     logStr.append(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).MoneyNum1).append("|");
/* 322 */     logStr.append(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).MoneyType2).append("|");
/* 323 */     logStr.append(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).MoneyNum2).append("|");
/* 324 */     logStr.append(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).MoneyType3).append("|");
/* 325 */     logStr.append(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).MoneyNum3).append("|");
/* 326 */     logStr.append(roleId).append("|");
/*     */     
/* 328 */     logStr.append(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).ItemId1).append("|");
/* 329 */     logStr.append(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).ItemNum1).append("|");
/* 330 */     logStr.append(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).ItemId2).append("|");
/* 331 */     logStr.append(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).ItemNum2).append("|");
/* 332 */     logStr.append(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).ItemId3).append("|");
/* 333 */     logStr.append(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).ItemNum3).append("|");
/* 334 */     logStr.append(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).ItemId4).append("|");
/* 335 */     logStr.append(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).ItemNum4).append("|");
/* 336 */     logStr.append(tagid);
/*     */     
/* 338 */     TLogManager.getInstance().addLog(roleId, "IDIPDoSendMoreItemBySystemMail", logStr.toString());
/*     */     
/* 340 */     ((IDIPPacket_DoSendMoreItemBySystemMailRsp)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).rsp).head.Result = 0;
/* 341 */     ((IDIPPacket_DoSendMoreItemBySystemMailRsp)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).rsp).head.RetErrMsg = "ok";
/* 342 */     ((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).sendResponse();
/*     */     
/* 344 */     GameServer.logger().info(String.format("[idip]PIDIPCmd_DoSendMoreItemBySystemMailReq.handle@send item by system mail success|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|source=%d|role_id=%d|item_id1=%d|item_num1=%d|item_id2=%d|item_num2=%d|item_id3=%d|item_num3=%d|item_id4=%d|item_num4=%d|money_type1=%d|money_num1=%d|money_type2=%d|money_num2=%d|money_type3=%d|money_num3=%d|serial=%s|tagid=%d", new Object[] { Integer.valueOf(((IDIPPacket_DoSendMoreItemBySystemMailRsp)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoSendMoreItemBySystemMailRsp)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).Source), Long.valueOf(roleId), Long.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).ItemId1), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).ItemNum1), Long.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).ItemId2), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).ItemNum2), Long.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).ItemId3), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).ItemNum3), Long.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).ItemId4), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).ItemNum4), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).MoneyType1), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).MoneyNum1), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).MoneyType2), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).MoneyNum2), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).MoneyType3), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).MoneyNum3), ((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).Serial, Integer.valueOf(tagid) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 354 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   protected String getSerialNo()
/*     */   {
/* 360 */     return ((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).Serial;
/*     */   }
/*     */   
/*     */   private boolean itemCheck(Map<Integer, Integer> items, int itemid, int num)
/*     */   {
/* 365 */     if ((itemid <= 0) || (num <= 0))
/*     */     {
/* 367 */       return true;
/*     */     }
/*     */     
/* 370 */     SItemCfg itemCfg = ItemInterface.getSItemCfg(itemid);
/* 371 */     if (itemCfg == null)
/*     */     {
/* 373 */       ((IDIPPacket_DoSendMoreItemBySystemMailRsp)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).rsp).head.Result = 64494;
/* 374 */       ((IDIPPacket_DoSendMoreItemBySystemMailRsp)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).rsp).head.RetErrMsg = "send item not exist";
/* 375 */       ((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).sendResponse();
/*     */       
/* 377 */       onFailedForItem(itemid);
/* 378 */       return false;
/*     */     }
/*     */     
/* 381 */     Integer oldNum = (Integer)items.get(Integer.valueOf(itemid));
/* 382 */     if (oldNum == null)
/*     */     {
/* 384 */       items.put(Integer.valueOf(itemid), Integer.valueOf(num));
/*     */     }
/*     */     else
/*     */     {
/* 388 */       items.put(Integer.valueOf(itemid), Integer.valueOf(oldNum.intValue() + num));
/*     */     }
/* 390 */     return true;
/*     */   }
/*     */   
/*     */   private void onFailedForItem(int itemid)
/*     */   {
/* 395 */     GameServer.logger().error(String.format("[idip]PIDIPCmd_DoSendMoreItemBySystemMailReq.handle@item not exist in config|ret=%d|ret_msg=%s|open_id=%s|area_id=%d|plat_id=%d|source=%d|role_id=%s|item_id=%d", new Object[] { Integer.valueOf(((IDIPPacket_DoSendMoreItemBySystemMailRsp)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoSendMoreItemBySystemMailRsp)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).rsp).head.RetErrMsg, ((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).OpenId, Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).AreaId), Byte.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).Source), ((DoSendMoreItemBySystemMailReq)((IDIPPacket_DoSendMoreItemBySystemMailReq)((IDIPCmd_DoSendMoreItemBySystemMailReq)this.cmd).req).body).RoleId, Integer.valueOf(itemid) }));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PIDIPCmd_DoSendMoreItemBySystemMailReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */