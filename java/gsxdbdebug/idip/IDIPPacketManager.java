/*     */ package idip;
/*     */ 
/*     */ import idip.core.IDIPPacket;
/*     */ import idip.core.IDIPPacketCreator;
/*     */ import java.util.Map;
/*     */ 
/*     */ public class IDIPPacketManager
/*     */ {
/*   9 */   private static final IDIPPacketManager instance = new IDIPPacketManager();
/*     */   
/*     */   public static IDIPPacketManager getInstance()
/*     */   {
/*  13 */     return instance;
/*     */   }
/*     */   
/*  16 */   private final Map<Integer, IDIPPacketCreator> creators = new java.util.HashMap();
/*     */   
/*     */   public IDIPPacketManager()
/*     */   {
/*  20 */     this.creators.put(Integer.valueOf(4207), new IDIPPacket_QueryOwnXianlvReq.Creator());
/*  21 */     this.creators.put(Integer.valueOf(4119), new IDIPPacket_DoDelItemReq.Creator());
/*  22 */     this.creators.put(Integer.valueOf(4181), new IDIPPacket_AqDoBanAssignPlayReq.Creator());
/*  23 */     this.creators.put(Integer.valueOf(4138), new IDIPPacket_AqDoSendMsgRsp.Creator());
/*  24 */     this.creators.put(Integer.valueOf(4192), new IDIPPacket_DoDeleteNoticeRsp.Creator());
/*  25 */     this.creators.put(Integer.valueOf(4098), new IDIPPacket_DoUpdateCashRsp.Creator());
/*  26 */     this.creators.put(Integer.valueOf(4134), new IDIPPacket_DoSendItemBySystemMailRsp.Creator());
/*  27 */     this.creators.put(Integer.valueOf(4163), new IDIPPacket_AqDoZeroprofitReq.Creator());
/*  28 */     this.creators.put(Integer.valueOf(4114), new IDIPPacket_DoUpdateCompetitivePointRsp.Creator());
/*  29 */     this.creators.put(Integer.valueOf(4113), new IDIPPacket_DoUpdateCompetitivePointReq.Creator());
/*  30 */     this.creators.put(Integer.valueOf(4212), new IDIPPacket_QueryGuildMemberInfoRsp.Creator());
/*  31 */     this.creators.put(Integer.valueOf(4158), new IDIPPacket_AqDoMaskchatUsrRsp.Creator());
/*  32 */     this.creators.put(Integer.valueOf(4170), new IDIPPacket_SysFunSwitchRsp.Creator());
/*  33 */     this.creators.put(Integer.valueOf(4189), new IDIPPacket_DoUpdateNoticeReq.Creator());
/*  34 */     this.creators.put(Integer.valueOf(4099), new IDIPPacket_DoUpdateMoneyReq.Creator());
/*  35 */     this.creators.put(Integer.valueOf(4172), new IDIPPacket_ChannelSignLimitFunRsp.Creator());
/*  36 */     this.creators.put(Integer.valueOf(4175), new IDIPPacket_GeneralCommandReq.Creator());
/*  37 */     this.creators.put(Integer.valueOf(4118), new IDIPPacket_DoSendItemRsp.Creator());
/*  38 */     this.creators.put(Integer.valueOf(4199), new IDIPPacket_AqDoBanAddFriendReq.Creator());
/*  39 */     this.creators.put(Integer.valueOf(4112), new IDIPPacket_DoUpdateGangContributionRsp.Creator());
/*  40 */     this.creators.put(Integer.valueOf(4135), new IDIPPacket_AqQueryUsrInfoReq.Creator());
/*  41 */     this.creators.put(Integer.valueOf(4142), new IDIPPacket_AqDoUpdateCashRsp.Creator());
/*  42 */     this.creators.put(Integer.valueOf(4190), new IDIPPacket_DoUpdateNoticeRsp.Creator());
/*  43 */     this.creators.put(Integer.valueOf(4145), new IDIPPacket_AqDoSetUsrInfoReq.Creator());
/*  44 */     this.creators.put(Integer.valueOf(4215), new IDIPPacket_DoSendMoreItemBySystemMailReq.Creator());
/*  45 */     this.creators.put(Integer.valueOf(4111), new IDIPPacket_DoUpdateGangContributionReq.Creator());
/*  46 */     this.creators.put(Integer.valueOf(4121), new IDIPPacket_DoActiveUsrReq.Creator());
/*  47 */     this.creators.put(Integer.valueOf(4154), new IDIPPacket_AqDoRolelistDataRsp.Creator());
/*  48 */     this.creators.put(Integer.valueOf(4225), new IDIPPacket_QueryMailReq.Creator());
/*  49 */     this.creators.put(Integer.valueOf(4156), new IDIPPacket_AqDoBanUsrRsp.Creator());
/*  50 */     this.creators.put(Integer.valueOf(4227), new IDIPPacket_DoDelMailReq.Creator());
/*  51 */     this.creators.put(Integer.valueOf(4205), new IDIPPacket_QuerySxianlvNumReq.Creator());
/*  52 */     this.creators.put(Integer.valueOf(4162), new IDIPPacket_AqDoInitAccountRsp.Creator());
/*  53 */     this.creators.put(Integer.valueOf(4131), new IDIPPacket_QueryPetInfoReq.Creator());
/*  54 */     this.creators.put(Integer.valueOf(4136), new IDIPPacket_AqQueryUsrInfoRsp.Creator());
/*  55 */     this.creators.put(Integer.valueOf(4167), new IDIPPacket_WhiteListSwitchReq.Creator());
/*  56 */     this.creators.put(Integer.valueOf(4116), new IDIPPacket_DoUpdateExpRsp.Creator());
/*  57 */     this.creators.put(Integer.valueOf(4123), new IDIPPacket_DoBanUsrReq.Creator());
/*  58 */     this.creators.put(Integer.valueOf(4104), new IDIPPacket_DoUpdateVitalityRsp.Creator());
/*  59 */     this.creators.put(Integer.valueOf(4194), new IDIPPacket_QueryMarqueeRsp.Creator());
/*  60 */     this.creators.put(Integer.valueOf(4122), new IDIPPacket_DoActiveUsrRsp.Creator());
/*  61 */     this.creators.put(Integer.valueOf(4174), new IDIPPacket_MailSendWholeGiftRsp.Creator());
/*  62 */     this.creators.put(Integer.valueOf(4183), new IDIPPacket_DoUpdateGoldReq.Creator());
/*  63 */     this.creators.put(Integer.valueOf(4224), new IDIPPacket_QueryRoleArchivementRsp.Creator());
/*  64 */     this.creators.put(Integer.valueOf(4143), new IDIPPacket_AqDoUpdateOtherCashReq.Creator());
/*  65 */     this.creators.put(Integer.valueOf(4124), new IDIPPacket_DoBanUsrRsp.Creator());
/*  66 */     this.creators.put(Integer.valueOf(4128), new IDIPPacket_QueryUsrInfoRsp.Creator());
/*  67 */     this.creators.put(Integer.valueOf(4139), new IDIPPacket_AqDoUpdateMoneyReq.Creator());
/*  68 */     this.creators.put(Integer.valueOf(4160), new IDIPPacket_AqDoRelievePunishRsp.Creator());
/*  69 */     this.creators.put(Integer.valueOf(4171), new IDIPPacket_ChannelSignLimitFunReq.Creator());
/*  70 */     this.creators.put(Integer.valueOf(4188), new IDIPPacket_QueryNoticeRsp.Creator());
/*  71 */     this.creators.put(Integer.valueOf(4219), new IDIPPacket_DoAddRechargeIntegralReq.Creator());
/*  72 */     this.creators.put(Integer.valueOf(4126), new IDIPPacket_DoUnbanUsrRsp.Creator());
/*  73 */     this.creators.put(Integer.valueOf(4165), new IDIPPacket_AqDoCleartSayReq.Creator());
/*  74 */     this.creators.put(Integer.valueOf(4206), new IDIPPacket_QuerySxianlvNumRsp.Creator());
/*  75 */     this.creators.put(Integer.valueOf(4220), new IDIPPacket_DoAddRechargeIntegralRsp.Creator());
/*  76 */     this.creators.put(Integer.valueOf(4169), new IDIPPacket_SysFunSwitchReq.Creator());
/*  77 */     this.creators.put(Integer.valueOf(4195), new IDIPPacket_DoUpdateMarqueeReq.Creator());
/*  78 */     this.creators.put(Integer.valueOf(4149), new IDIPPacket_QueryRolelistInfoReq.Creator());
/*  79 */     this.creators.put(Integer.valueOf(4144), new IDIPPacket_AqDoUpdateOtherCashRsp.Creator());
/*  80 */     this.creators.put(Integer.valueOf(4201), new IDIPPacket_QueryRoleActivityParticipationReq.Creator());
/*  81 */     this.creators.put(Integer.valueOf(4125), new IDIPPacket_DoUnbanUsrReq.Creator());
/*  82 */     this.creators.put(Integer.valueOf(4153), new IDIPPacket_AqDoRolelistDataReq.Creator());
/*  83 */     this.creators.put(Integer.valueOf(4230), new IDIPPacket_QueryAllPrizeRsp.Creator());
/*  84 */     this.creators.put(Integer.valueOf(4164), new IDIPPacket_AqDoZeroprofitRsp.Creator());
/*  85 */     this.creators.put(Integer.valueOf(4097), new IDIPPacket_DoUpdateCashReq.Creator());
/*  86 */     this.creators.put(Integer.valueOf(4186), new IDIPPacket_DoSendNoticeRsp.Creator());
/*  87 */     this.creators.put(Integer.valueOf(4233), new IDIPPacket_DoDelAllMailReq.Creator());
/*  88 */     this.creators.put(Integer.valueOf(4222), new IDIPPacket_QueryFunctionSwitchRsp.Creator());
/*  89 */     this.creators.put(Integer.valueOf(4223), new IDIPPacket_QueryRoleArchivementReq.Creator());
/*  90 */     this.creators.put(Integer.valueOf(4202), new IDIPPacket_QueryRoleActivityParticipationRsp.Creator());
/*  91 */     this.creators.put(Integer.valueOf(4180), new IDIPPacket_DoDeleteMarqueeRsp.Creator());
/*  92 */     this.creators.put(Integer.valueOf(4120), new IDIPPacket_DoDelItemRsp.Creator());
/*  93 */     this.creators.put(Integer.valueOf(4208), new IDIPPacket_QueryOwnXianlvRsp.Creator());
/*  94 */     this.creators.put(Integer.valueOf(4161), new IDIPPacket_AqDoInitAccountReq.Creator());
/*  95 */     this.creators.put(Integer.valueOf(4102), new IDIPPacket_DoUpdateSilverRsp.Creator());
/*  96 */     this.creators.put(Integer.valueOf(4211), new IDIPPacket_QueryGuildMemberInfoReq.Creator());
/*  97 */     this.creators.put(Integer.valueOf(4185), new IDIPPacket_DoSendNoticeReq.Creator());
/*  98 */     this.creators.put(Integer.valueOf(4196), new IDIPPacket_DoUpdateMarqueeRsp.Creator());
/*  99 */     this.creators.put(Integer.valueOf(4109), new IDIPPacket_DoUpdateReputationReq.Creator());
/* 100 */     this.creators.put(Integer.valueOf(4178), new IDIPPacket_DoSendMarqueeRsp.Creator());
/* 101 */     this.creators.put(Integer.valueOf(4106), new IDIPPacket_DoUpdateHisContributionRsp.Creator());
/* 102 */     this.creators.put(Integer.valueOf(4229), new IDIPPacket_QueryAllPrizeReq.Creator());
/* 103 */     this.creators.put(Integer.valueOf(4107), new IDIPPacket_DoUpdateChivalrousReq.Creator());
/* 104 */     this.creators.put(Integer.valueOf(4193), new IDIPPacket_QueryMarqueeReq.Creator());
/* 105 */     this.creators.put(Integer.valueOf(4101), new IDIPPacket_DoUpdateSilverReq.Creator());
/* 106 */     this.creators.put(Integer.valueOf(4103), new IDIPPacket_DoUpdateVitalityReq.Creator());
/* 107 */     this.creators.put(Integer.valueOf(4184), new IDIPPacket_DoUpdateGoldRsp.Creator());
/* 108 */     this.creators.put(Integer.valueOf(4130), new IDIPPacket_QueryRoleInfoRsp.Creator());
/* 109 */     this.creators.put(Integer.valueOf(4213), new IDIPPacket_DoRechangeAgentReq.Creator());
/* 110 */     this.creators.put(Integer.valueOf(4137), new IDIPPacket_AqDoSendMsgReq.Creator());
/* 111 */     this.creators.put(Integer.valueOf(4214), new IDIPPacket_DoRechangeAgentRsp.Creator());
/* 112 */     this.creators.put(Integer.valueOf(4132), new IDIPPacket_QueryPetInfoRsp.Creator());
/* 113 */     this.creators.put(Integer.valueOf(4159), new IDIPPacket_AqDoRelievePunishReq.Creator());
/* 114 */     this.creators.put(Integer.valueOf(4228), new IDIPPacket_DoDelMailRsp.Creator());
/* 115 */     this.creators.put(Integer.valueOf(4179), new IDIPPacket_DoDeleteMarqueeReq.Creator());
/* 116 */     this.creators.put(Integer.valueOf(4217), new IDIPPacket_DoMonitorBanLoginReq.Creator());
/* 117 */     this.creators.put(Integer.valueOf(4127), new IDIPPacket_QueryUsrInfoReq.Creator());
/* 118 */     this.creators.put(Integer.valueOf(4151), new IDIPPacket_AqDoBanJoinrankReq.Creator());
/* 119 */     this.creators.put(Integer.valueOf(4155), new IDIPPacket_AqDoBanUsrReq.Creator());
/* 120 */     this.creators.put(Integer.valueOf(4140), new IDIPPacket_AqDoUpdateMoneyRsp.Creator());
/* 121 */     this.creators.put(Integer.valueOf(4100), new IDIPPacket_DoUpdateMoneyRsp.Creator());
/* 122 */     this.creators.put(Integer.valueOf(4141), new IDIPPacket_AqDoUpdateCashReq.Creator());
/* 123 */     this.creators.put(Integer.valueOf(4234), new IDIPPacket_DoDelAllMailRsp.Creator());
/* 124 */     this.creators.put(Integer.valueOf(4221), new IDIPPacket_QueryFunctionSwitchReq.Creator());
/* 125 */     this.creators.put(Integer.valueOf(4200), new IDIPPacket_AqDoBanAddFriendRsp.Creator());
/* 126 */     this.creators.put(Integer.valueOf(4150), new IDIPPacket_QueryRolelistInfoRsp.Creator());
/* 127 */     this.creators.put(Integer.valueOf(4157), new IDIPPacket_AqDoMaskchatUsrReq.Creator());
/* 128 */     this.creators.put(Integer.valueOf(4226), new IDIPPacket_QueryMailRsp.Creator());
/* 129 */     this.creators.put(Integer.valueOf(4129), new IDIPPacket_QueryRoleInfoReq.Creator());
/* 130 */     this.creators.put(Integer.valueOf(4203), new IDIPPacket_QueryRoleSocialReq.Creator());
/* 131 */     this.creators.put(Integer.valueOf(4187), new IDIPPacket_QueryNoticeReq.Creator());
/* 132 */     this.creators.put(Integer.valueOf(4176), new IDIPPacket_GeneralCommandRsp.Creator());
/* 133 */     this.creators.put(Integer.valueOf(4117), new IDIPPacket_DoSendItemReq.Creator());
/* 134 */     this.creators.put(Integer.valueOf(4191), new IDIPPacket_DoDeleteNoticeReq.Creator());
/* 135 */     this.creators.put(Integer.valueOf(4204), new IDIPPacket_QueryRoleSocialRsp.Creator());
/* 136 */     this.creators.put(Integer.valueOf(4152), new IDIPPacket_AqDoBanJoinrankRsp.Creator());
/* 137 */     this.creators.put(Integer.valueOf(4182), new IDIPPacket_AqDoBanAssignPlayRsp.Creator());
/* 138 */     this.creators.put(Integer.valueOf(4173), new IDIPPacket_MailSendWholeGiftReq.Creator());
/* 139 */     this.creators.put(Integer.valueOf(4209), new IDIPPacket_QueryGuildInfoReq.Creator());
/* 140 */     this.creators.put(Integer.valueOf(4146), new IDIPPacket_AqDoSetUsrInfoRsp.Creator());
/* 141 */     this.creators.put(Integer.valueOf(4216), new IDIPPacket_DoSendMoreItemBySystemMailRsp.Creator());
/* 142 */     this.creators.put(Integer.valueOf(4105), new IDIPPacket_DoUpdateHisContributionReq.Creator());
/* 143 */     this.creators.put(Integer.valueOf(4168), new IDIPPacket_WhiteListSwitchRsp.Creator());
/* 144 */     this.creators.put(Integer.valueOf(4110), new IDIPPacket_DoUpdateReputationRsp.Creator());
/* 145 */     this.creators.put(Integer.valueOf(4108), new IDIPPacket_DoUpdateChivalrousRsp.Creator());
/* 146 */     this.creators.put(Integer.valueOf(4210), new IDIPPacket_QueryGuildInfoRsp.Creator());
/* 147 */     this.creators.put(Integer.valueOf(4166), new IDIPPacket_AqDoCleartSayRsp.Creator());
/* 148 */     this.creators.put(Integer.valueOf(4177), new IDIPPacket_DoSendMarqueeReq.Creator());
/* 149 */     this.creators.put(Integer.valueOf(4133), new IDIPPacket_DoSendItemBySystemMailReq.Creator());
/* 150 */     this.creators.put(Integer.valueOf(4115), new IDIPPacket_DoUpdateExpReq.Creator());
/* 151 */     this.creators.put(Integer.valueOf(4218), new IDIPPacket_DoMonitorBanLoginRsp.Creator());
/*     */   }
/*     */   
/*     */   public final IDIPPacket<?> createPacket(int id)
/*     */   {
/* 156 */     IDIPPacketCreator creator = (IDIPPacketCreator)this.creators.get(Integer.valueOf(id));
/* 157 */     if (creator == null)
/*     */     {
/* 159 */       return null;
/*     */     }
/*     */     
/* 162 */     return creator.create();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacketManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */