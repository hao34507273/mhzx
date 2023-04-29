/*    */ package mzm.gsp.idip.main;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import idip.DataBetweenIDIPAndGameReq;
/*    */ import idip.core.IDIPCmd;
/*    */ 
/*    */ public class IDIPCmdManager
/*    */ {
/*    */   public static final String TLOG_IDIP_DO_UPDATE_YUANBAO = "IDIPDoUpdateYuanbao";
/*    */   public static final String TLOG_IDIP_DO_UPDATE_MONEY = "IDIPDoUpdateMoney";
/*    */   public static final String TLOG_IDIP_DO_UPDATE_SILVER = "IDIPDoUpdateSilver";
/*    */   public static final String TLOG_IDIP_DO_UPDATE_VIGOR = "IDIPDoUpdateVitality";
/*    */   public static final String TLOG_IDIP_DO_UPDATE_HIS_CONTRIBUTION = "IDIPDoUpdateHisContribution";
/*    */   public static final String TLOG_IDIP_DO_UPDATE_XIA_YI = "IDIPDoUpdateChivalrous";
/*    */   public static final String TLOG_IDIP_DO_UPDATE_REPUTATION = "IDIPDoUpdateReputation";
/*    */   public static final String TLOG_IDIP_DO_UPDATE_BANG_GONG = "IDIPDoUpdateGangContribution";
/*    */   public static final String TLOG_IDIP_DO_UPDATE_COMPETITIVE_POINT = "IDIPDoUpdateCompetitivePoint";
/*    */   public static final String TLOG_IDIP_DO_UPDATE_EXP = "IDIPDoUpdateExp";
/*    */   public static final String TLOG_IDIP_DO_SEND_ITEM = "IDIPDoSendItem";
/*    */   public static final String TLOG_IDIP_DO_DEL_ITEM = "IDIPDoDelItem";
/*    */   public static final String TLOG_IDIP_SEND_ITEM_BY_SYSTEM_MAIL = "IDIPDoSendItemBySystemMail";
/*    */   public static final String TLOG_IDIP_SEND_MORE_ITEM_BY_SYSTEM_MAIL = "IDIPDoSendMoreItemBySystemMail";
/*    */   public static final String TLOG_AQIDIP_DO_UPDATE_YUANBAO = "AqIDIPDoUpdateYuanbao";
/*    */   public static final String TLOG_AQIDIP_DO_UPDATE_MONEY = "AqIDIPDoUpdateMoney";
/*    */   public static final String TLOG_AQIDIP_DO_UPDATE_OTHER_CASH = "AqIDIPDoUpdateOtherCash";
/*    */   public static final String TLOG_IDIP_DO_UPDATE_GOLD_Ingot = "IDIPDoUpdateGoldIngot";
/*    */   public static final String TLOG_IDIP_SecTalkFlow = "SecTalkFlow";
/*    */   public static final String TLOG_IDIP_SecBusinessShopShowFlow = "SecBusinessShopShowFlow";
/*    */   public static final String TLOG_IDIP_SecBusinessShopDealFlow = "SecBusinessShopDealFlow";
/*    */   public static final String TLOG_IDIP_SecBusinessShopP2PFlow = "SecBusinessShopP2PFlow";
/*    */   public static final String TLOG_IDIP_SecBlackListFlow = "SecBlackListFlow";
/*    */   public static final String TLOG_IDIP_SecBattleFlow = "SecBattleFlow";
/*    */   public static final String TLOG_IDIP_SEC_PLAYER_ADD_FRIEND = "SecPlayerAddFriend";
/*    */   public static final String TLOG_AQIDIP_Do_Ban_Usr = "AqIDIPDoBanUsr";
/*    */   public static final String TLOG_AQIDIP_Do_Ban_Join_Rank = "AqIDIPDoBanjoinRank";
/*    */   public static final String TLOG_AQIDIP_Do_Maskchat_Usr = "AqIDIPDoMaskchatUsr";
/*    */   public static final String TLOG_AQIDIP_Do_Init_Account = "AqIDIPDoInitAccount";
/*    */   public static final String TLOG_AQIDIP_Do_Rolelist_Data = "AqIDIPDoRolelistData";
/*    */   public static final String TLOG_AQIDIP_Do_Set_UsrInfo = "AqIDIPDoSetUsrInfo";
/*    */   public static final String TLOG_AQIDIP_Do_Ban_Assign_Play = "AqIDIPDoBanAssignPlay";
/*    */   public static final String TLOG_AQIDIP_Do_Clear_Say = "AqIDIPDoClearSay";
/*    */   public static final String TLOG_AQIDIP_Do_ZeroProfit = "AqIDIPDoZeroProfit";
/*    */   public static final String TLOG_AQIDIP_Do_Send_Msg = "AqIDIPDoSendMsg";
/*    */   public static final String TLOG_AQIDIP_Do_Relieve_Punish = "AqIDIPDoRelievePunish";
/*    */   public static final String TLOG_AQIDIP_DO_BAN_ADD_FRIEND = "AqIDIPDoBanAddFriend";
/*    */   public static final String TLOG_IDIP_DO_ADD_RECHARGE_INTEGRAL = "IDIPDoAddRechargeIntegral";
/*    */   
/*    */   public static final void handIDIPRequest(DataBetweenIDIPAndGameReq req)
/*    */   {
/* 50 */     String reqdata = null;
/*    */     try
/*    */     {
/* 53 */       reqdata = req.reqdata.getString("UTF-8");
/* 54 */       IDIPCmd<?, ?> cmd = IDIPCmd.parseIdipCmd(req.reqtype, req.xid, req.proxyid, req.zoneid, reqdata);
/* 55 */       if (cmd == null)
/*    */       {
/* 57 */         return;
/*    */       }
/*    */       
/* 60 */       cmd.process();
/*    */     }
/*    */     catch (Exception e)
/*    */     {
/* 64 */       IDIPCmd.sendBadResponse(req.reqtype, req.xid, req.proxyid, req.zoneid, -1, String.format("system error:%s.", new Object[] { e.getMessage() }));
/*    */       
/*    */ 
/* 67 */       mzm.gsp.GameServer.logger().error(String.format("[idip]IDIPCmdManager.handIDIPRequest@direction=%d|zoneid=%d|xid=%d|proxyid=%d|req_type=%d|req_data=%s", new Object[] { Byte.valueOf(req.direction), Integer.valueOf(req.zoneid), Integer.valueOf(req.xid), Integer.valueOf(req.proxyid), Integer.valueOf(req.reqtype), reqdata }), e);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\IDIPCmdManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */