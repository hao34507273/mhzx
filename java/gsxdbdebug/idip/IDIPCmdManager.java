/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPCmd;
/*    */ import idip.core.IDIPCmdCreator;
/*    */ import java.util.Map;
/*    */ 
/*    */ public class IDIPCmdManager
/*    */ {
/*  9 */   private static final IDIPCmdManager instance = new IDIPCmdManager();
/*    */   
/*    */   public static IDIPCmdManager getInstance()
/*    */   {
/* 13 */     return instance;
/*    */   }
/*    */   
/* 16 */   private final Map<Integer, IDIPCmdCreator<?, ?>> creators = new java.util.HashMap();
/*    */   
/*    */   public IDIPCmdManager()
/*    */   {
/* 20 */     this.creators.put(Integer.valueOf(4161), new IDIPCmd_AqDoInitAccountReq.Creator());
/* 21 */     this.creators.put(Integer.valueOf(4163), new IDIPCmd_AqDoZeroprofitReq.Creator());
/* 22 */     this.creators.put(Integer.valueOf(4151), new IDIPCmd_AqDoBanJoinrankReq.Creator());
/* 23 */     this.creators.put(Integer.valueOf(4185), new IDIPCmd_DoSendNoticeReq.Creator());
/* 24 */     this.creators.put(Integer.valueOf(4133), new IDIPCmd_DoSendItemBySystemMailReq.Creator());
/* 25 */     this.creators.put(Integer.valueOf(4139), new IDIPCmd_AqDoUpdateMoneyReq.Creator());
/* 26 */     this.creators.put(Integer.valueOf(4131), new IDIPCmd_QueryPetInfoReq.Creator());
/* 27 */     this.creators.put(Integer.valueOf(4129), new IDIPCmd_QueryRoleInfoReq.Creator());
/* 28 */     this.creators.put(Integer.valueOf(4135), new IDIPCmd_AqQueryUsrInfoReq.Creator());
/* 29 */     this.creators.put(Integer.valueOf(4189), new IDIPCmd_DoUpdateNoticeReq.Creator());
/* 30 */     this.creators.put(Integer.valueOf(4191), new IDIPCmd_DoDeleteNoticeReq.Creator());
/* 31 */     this.creators.put(Integer.valueOf(4187), new IDIPCmd_QueryNoticeReq.Creator());
/* 32 */     this.creators.put(Integer.valueOf(4205), new IDIPCmd_QuerySxianlvNumReq.Creator());
/* 33 */     this.creators.put(Integer.valueOf(4207), new IDIPCmd_QueryOwnXianlvReq.Creator());
/* 34 */     this.creators.put(Integer.valueOf(4201), new IDIPCmd_QueryRoleActivityParticipationReq.Creator());
/* 35 */     this.creators.put(Integer.valueOf(4203), new IDIPCmd_QueryRoleSocialReq.Creator());
/* 36 */     this.creators.put(Integer.valueOf(4167), new IDIPCmd_WhiteListSwitchReq.Creator());
/* 37 */     this.creators.put(Integer.valueOf(4153), new IDIPCmd_AqDoRolelistDataReq.Creator());
/* 38 */     this.creators.put(Integer.valueOf(4165), new IDIPCmd_AqDoCleartSayReq.Creator());
/* 39 */     this.creators.put(Integer.valueOf(4145), new IDIPCmd_AqDoSetUsrInfoReq.Creator());
/* 40 */     this.creators.put(Integer.valueOf(4211), new IDIPCmd_QueryGuildMemberInfoReq.Creator());
/* 41 */     this.creators.put(Integer.valueOf(4149), new IDIPCmd_QueryRolelistInfoReq.Creator());
/* 42 */     this.creators.put(Integer.valueOf(4209), new IDIPCmd_QueryGuildInfoReq.Creator());
/* 43 */     this.creators.put(Integer.valueOf(4141), new IDIPCmd_AqDoUpdateCashReq.Creator());
/* 44 */     this.creators.put(Integer.valueOf(4143), new IDIPCmd_AqDoUpdateOtherCashReq.Creator());
/* 45 */     this.creators.put(Integer.valueOf(4213), new IDIPCmd_DoRechangeAgentReq.Creator());
/* 46 */     this.creators.put(Integer.valueOf(4159), new IDIPCmd_AqDoRelievePunishReq.Creator());
/* 47 */     this.creators.put(Integer.valueOf(4137), new IDIPCmd_AqDoSendMsgReq.Creator());
/* 48 */     this.creators.put(Integer.valueOf(4155), new IDIPCmd_AqDoBanUsrReq.Creator());
/* 49 */     this.creators.put(Integer.valueOf(4215), new IDIPCmd_DoSendMoreItemBySystemMailReq.Creator());
/* 50 */     this.creators.put(Integer.valueOf(4217), new IDIPCmd_DoMonitorBanLoginReq.Creator());
/* 51 */     this.creators.put(Integer.valueOf(4219), new IDIPCmd_DoAddRechargeIntegralReq.Creator());
/* 52 */     this.creators.put(Integer.valueOf(4221), new IDIPCmd_QueryFunctionSwitchReq.Creator());
/* 53 */     this.creators.put(Integer.valueOf(4223), new IDIPCmd_QueryRoleArchivementReq.Creator());
/* 54 */     this.creators.put(Integer.valueOf(4225), new IDIPCmd_QueryMailReq.Creator());
/* 55 */     this.creators.put(Integer.valueOf(4227), new IDIPCmd_DoDelMailReq.Creator());
/* 56 */     this.creators.put(Integer.valueOf(4229), new IDIPCmd_QueryAllPrizeReq.Creator());
/* 57 */     this.creators.put(Integer.valueOf(4199), new IDIPCmd_AqDoBanAddFriendReq.Creator());
/* 58 */     this.creators.put(Integer.valueOf(4175), new IDIPCmd_GeneralCommandReq.Creator());
/* 59 */     this.creators.put(Integer.valueOf(4103), new IDIPCmd_DoUpdateVitalityReq.Creator());
/* 60 */     this.creators.put(Integer.valueOf(4173), new IDIPCmd_MailSendWholeGiftReq.Creator());
/* 61 */     this.creators.put(Integer.valueOf(4105), new IDIPCmd_DoUpdateHisContributionReq.Creator());
/* 62 */     this.creators.put(Integer.valueOf(4171), new IDIPCmd_ChannelSignLimitFunReq.Creator());
/* 63 */     this.creators.put(Integer.valueOf(4099), new IDIPCmd_DoUpdateMoneyReq.Creator());
/* 64 */     this.creators.put(Integer.valueOf(4169), new IDIPCmd_SysFunSwitchReq.Creator());
/* 65 */     this.creators.put(Integer.valueOf(4101), new IDIPCmd_DoUpdateSilverReq.Creator());
/* 66 */     this.creators.put(Integer.valueOf(4183), new IDIPCmd_DoUpdateGoldReq.Creator());
/* 67 */     this.creators.put(Integer.valueOf(4233), new IDIPCmd_DoDelAllMailReq.Creator());
/* 68 */     this.creators.put(Integer.valueOf(4181), new IDIPCmd_AqDoBanAssignPlayReq.Creator());
/* 69 */     this.creators.put(Integer.valueOf(4097), new IDIPCmd_DoUpdateCashReq.Creator());
/* 70 */     this.creators.put(Integer.valueOf(4179), new IDIPCmd_DoDeleteMarqueeReq.Creator());
/* 71 */     this.creators.put(Integer.valueOf(4177), new IDIPCmd_DoSendMarqueeReq.Creator());
/* 72 */     this.creators.put(Integer.valueOf(4195), new IDIPCmd_DoUpdateMarqueeReq.Creator());
/* 73 */     this.creators.put(Integer.valueOf(4193), new IDIPCmd_QueryMarqueeReq.Creator());
/* 74 */     this.creators.put(Integer.valueOf(4115), new IDIPCmd_DoUpdateExpReq.Creator());
/* 75 */     this.creators.put(Integer.valueOf(4109), new IDIPCmd_DoUpdateReputationReq.Creator());
/* 76 */     this.creators.put(Integer.valueOf(4107), new IDIPCmd_DoUpdateChivalrousReq.Creator());
/* 77 */     this.creators.put(Integer.valueOf(4113), new IDIPCmd_DoUpdateCompetitivePointReq.Creator());
/* 78 */     this.creators.put(Integer.valueOf(4111), new IDIPCmd_DoUpdateGangContributionReq.Creator());
/* 79 */     this.creators.put(Integer.valueOf(4157), new IDIPCmd_AqDoMaskchatUsrReq.Creator());
/* 80 */     this.creators.put(Integer.valueOf(4121), new IDIPCmd_DoActiveUsrReq.Creator());
/* 81 */     this.creators.put(Integer.valueOf(4123), new IDIPCmd_DoBanUsrReq.Creator());
/* 82 */     this.creators.put(Integer.valueOf(4125), new IDIPCmd_DoUnbanUsrReq.Creator());
/* 83 */     this.creators.put(Integer.valueOf(4127), new IDIPCmd_QueryUsrInfoReq.Creator());
/* 84 */     this.creators.put(Integer.valueOf(4117), new IDIPCmd_DoSendItemReq.Creator());
/* 85 */     this.creators.put(Integer.valueOf(4119), new IDIPCmd_DoDelItemReq.Creator());
/*    */   }
/*    */   
/*    */   public final IDIPCmd<?, ?> createCmd(int id)
/*    */   {
/* 90 */     IDIPCmdCreator<?, ?> creator = (IDIPCmdCreator)this.creators.get(Integer.valueOf(id));
/* 91 */     if (creator == null)
/*    */     {
/* 93 */       return null;
/*    */     }
/*    */     
/* 96 */     return creator.create();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPCmdManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */