/*     */ package mzm.gsp.idip.main;
/*     */ 
/*     */ import idip.GeneralCommandReq;
/*     */ import idip.GeneralCommandRsp;
/*     */ import idip.IDIPCmd_GeneralCommandReq;
/*     */ import idip.IDIPPacket_GeneralCommandReq;
/*     */ import idip.IDIPPacket_GeneralCommandRsp;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ public abstract class PIDIPCmd_GeneralCommandReq
/*     */   extends PIDIPCmd<IDIPCmd_GeneralCommandReq>
/*     */ {
/*  19 */   static final Map<Long, PIDIPCmd_GeneralCommandReqCreator> creaters = new HashMap();
/*     */   
/*     */   static {
/*  22 */     creaters.put(Long.valueOf(1L), PIDIPCmd_DisableProtocolSwitchReq.creater());
/*  23 */     creaters.put(Long.valueOf(2L), PIDIPCmd_ShutdownGsReq.creater());
/*  24 */     creaters.put(Long.valueOf(3L), PIDIPCmd_GetRoleNameReq.creater());
/*  25 */     creaters.put(Long.valueOf(4L), PIDIPCmd_DirectBufferSizeReq.creater());
/*  26 */     creaters.put(Long.valueOf(5L), PIDIPCmd_OutputDirectAllocationReq.creater());
/*  27 */     creaters.put(Long.valueOf(6L), PIDIPCmd_NoneRealTimeTaskNumberReq.creater());
/*  28 */     creaters.put(Long.valueOf(7L), PIDIPCmd_LoginThresholdReq.creater());
/*  29 */     creaters.put(Long.valueOf(8L), PIDIPCmd_MaxOnlineReq.creater());
/*  30 */     creaters.put(Long.valueOf(9L), PIDIPCmd_AccountLimitReq.creater());
/*  31 */     creaters.put(Long.valueOf(10L), PIDIPCmd_MaxAccountReq.creater());
/*  32 */     creaters.put(Long.valueOf(11L), PIDIPCmd_ReLoadAllXmlReq.creater());
/*  33 */     creaters.put(Long.valueOf(12L), PIDIPCmd_ReLoadAllBnyReq.creater());
/*  34 */     creaters.put(Long.valueOf(13L), PIDIPCmd_MaxTaskPerRoleReq.creater());
/*  35 */     creaters.put(Long.valueOf(14L), PIDIPCmd_SetRankDBTimerReq.creater());
/*  36 */     creaters.put(Long.valueOf(15L), PIDIPCmd_GetMapMsgQueueReq.creater());
/*  37 */     creaters.put(Long.valueOf(16L), PIDIPCmd_GeneralSysFunSwitchReq.creater());
/*  38 */     creaters.put(Long.valueOf(17L), PIDIPCmd_GetMapProtocolSendQueueSizeReq.creater());
/*  39 */     creaters.put(Long.valueOf(18L), PIDIPCmd_ClearExecuteLoginQueueReq.creater());
/*  40 */     creaters.put(Long.valueOf(19L), PIDIPCmd_GetExecuteLoginSizeReq.creater());
/*  41 */     creaters.put(Long.valueOf(20L), PIDIPCmd_NTimesAwardReq.creater());
/*  42 */     creaters.put(Long.valueOf(21L), PIDIPCmd_SetServerLevelReq.creater());
/*  43 */     creaters.put(Long.valueOf(22L), PIDIPCmd_SetCheckpointPeriodReq.creater());
/*  44 */     creaters.put(Long.valueOf(23L), PIDIPCmd_SetRemoteFlushRecordSpeedReq.creater());
/*  45 */     creaters.put(Long.valueOf(24L), PIDIPCmd_SetAllowDumpSqlLoggerStatisDetailReq.creater());
/*  46 */     creaters.put(Long.valueOf(25L), PIDIPCmd_SetXdbTraceLevelReq.creater());
/*  47 */     creaters.put(Long.valueOf(26L), PIDIPCmd_ActivityClose.creater());
/*  48 */     creaters.put(Long.valueOf(27L), PIDIPCmd_ActivityForceClose.creater());
/*  49 */     creaters.put(Long.valueOf(28L), PIDIPCmd_ActivityForceOpen.creater());
/*  50 */     creaters.put(Long.valueOf(29L), PIDIPCmd_ActivityPause.creater());
/*  51 */     creaters.put(Long.valueOf(30L), PIDIPCmd_ItemBanTrade.creater());
/*  52 */     creaters.put(Long.valueOf(31L), PIDIPCmd_ItemUnBanTrade.creater());
/*  53 */     creaters.put(Long.valueOf(32L), PIDIPCmd_CloseGmReq.creater());
/*  54 */     creaters.put(Long.valueOf(33L), PIDIPCmd_ActivityRejustEndTime.creater());
/*  55 */     creaters.put(Long.valueOf(34L), PIDIPCmd_SetMaxQueueSizeReq.creater());
/*  56 */     creaters.put(Long.valueOf(35L), PIDIPCmd_RemoveMapGroupByRoleIdReq.creater());
/*  57 */     creaters.put(Long.valueOf(36L), PIDIPCmd_ResetServerLevelReq.creater());
/*  58 */     creaters.put(Long.valueOf(37L), PIDIPCmd_ResetGiftCountReq.creater());
/*  59 */     creaters.put(Long.valueOf(38L), PIDIPCmd_GangSetBangZhuDuty.creater());
/*  60 */     creaters.put(Long.valueOf(39L), PIDIPCmd_GangSetBangZhongDuty.creater());
/*  61 */     creaters.put(Long.valueOf(40L), PIDIPCmd_GangKickOut.creater());
/*  62 */     creaters.put(Long.valueOf(41L), PIDIPCmd_GangDealNoneBangZhu.creater());
/*  63 */     creaters.put(Long.valueOf(42L), PIDIPCmd_GangDealMoreBangZhu.creater());
/*  64 */     creaters.put(Long.valueOf(43L), PIDIPCmd_GangClearUnrealMember.creater());
/*  65 */     creaters.put(Long.valueOf(44L), PIDIPCmd_BanNpcService.creater());
/*  66 */     creaters.put(Long.valueOf(45L), PIDIPCmd_ClearServerDropReq.creater());
/*  67 */     creaters.put(Long.valueOf(46L), PIDIPCmd_RemoveCrossLadder.creater());
/*  68 */     creaters.put(Long.valueOf(47L), PIDIPCmd_RemoveLadderStatus.creater());
/*  69 */     creaters.put(Long.valueOf(48L), PIDIPCmd_RepaireQiLinBug.creater());
/*  70 */     creaters.put(Long.valueOf(49L), PIDIPCmd_ActiveGraphReq.creater());
/*  71 */     creaters.put(Long.valueOf(50L), PIDIPCmd_AddChestReq.creater());
/*  72 */     creaters.put(Long.valueOf(51L), PIDIPCmd_BanGraphReq.creater());
/*  73 */     creaters.put(Long.valueOf(52L), PIDIPCmd_CrossBattleOwnQueryReportResultReq.creater());
/*  74 */     creaters.put(Long.valueOf(53L), PIDIPCmd_CrossBattleOwnClearResultReq.creater());
/*  75 */     creaters.put(Long.valueOf(54L), PIDIPCmd_CrossBattleOwnRestartRoundRobinReq.creater());
/*  76 */     creaters.put(Long.valueOf(55L), PIDIPCmd_CrossBattlePointRaceBackupReq.creater());
/*  77 */     creaters.put(Long.valueOf(56L), PIDIPCmd_CrossBattlePointReportFightReq.creater());
/*  78 */     creaters.put(Long.valueOf(57L), PIDIPCmd_RestartKnockOut.creater());
/*  79 */     creaters.put(Long.valueOf(58L), PIDIPCmd_RefreshKnockOutData.creater());
/*  80 */     creaters.put(Long.valueOf(59L), PIDIPCmd_ItemHide.creater());
/*  81 */     creaters.put(Long.valueOf(60L), PIDIPCmd_SetXHKPGlobal.creater());
/*  82 */     creaters.put(Long.valueOf(61L), PIDIPCmd_PointExchangeSwitch.creater());
/*  83 */     creaters.put(Long.valueOf(62L), PIDIPCmd_GroupShoppingItemSwitch.creater());
/*  84 */     creaters.put(Long.valueOf(63L), PIDIPCmd_SetRoleAchievementProgress.creater());
/*  85 */     creaters.put(Long.valueOf(64L), PIDIPCmd_DeleteFashion.creater());
/*  86 */     creaters.put(Long.valueOf(65L), PIDIPCmd_DeleteWing.creater());
/*  87 */     creaters.put(Long.valueOf(66L), PIDIPCmd_GetServerLevelTime.creater());
/*  88 */     creaters.put(Long.valueOf(67L), PIDIPCmd_ResetServerLevelTime.creater());
/*  89 */     creaters.put(Long.valueOf(68L), PIDIPCmd_QueryRoleStatus.creater());
/*  90 */     creaters.put(Long.valueOf(69L), PIDIPCmd_RemoveRoleChange.creater());
/*  91 */     creaters.put(Long.valueOf(70L), PIDIPCmd_DeleteAircraft.creater());
/*  92 */     creaters.put(Long.valueOf(71L), PIDIPCmd_DeleteMagicMark.creater());
/*  93 */     creaters.put(Long.valueOf(72L), PIDIPCmd_DeleteChangeModelCard.creater());
/*  94 */     creaters.put(Long.valueOf(73L), PIDIPCmd_DeleteMounts.creater());
/*  95 */     creaters.put(Long.valueOf(74L), PIDIPCmd_DeleteAppellation.creater());
/*  96 */     creaters.put(Long.valueOf(75L), PIDIPCmd_DeleteFabaoArtifact.creater());
/*  97 */     creaters.put(Long.valueOf(76L), PIDIPCmd_DeleteAvatar.creater());
/*  98 */     creaters.put(Long.valueOf(77L), PIDIPCmd_DeleteAvatarFrame.creater());
/*  99 */     creaters.put(Long.valueOf(78L), PIDIPCmd_DeleteChatBubble.creater());
/* 100 */     creaters.put(Long.valueOf(79L), PIDIPCmd_DeletePet.creater());
/* 101 */     creaters.put(Long.valueOf(80L), PIDIPCmd_DeleteWuShi.creater());
/* 102 */     creaters.put(Long.valueOf(84L), PIDIPCmd_DrawCarnivalSetExtraRate.creater());
/* 103 */     creaters.put(Long.valueOf(85L), PIDIPCmd_DrawCarnivalSetAmt.creater());
/* 104 */     creaters.put(Long.valueOf(86L), PIDIPCmd_SetRoleStatus.creater());
/* 105 */     creaters.put(Long.valueOf(87L), PIDIPCmd_DrawCarnivalAddJackPot.creater());
/*     */   }
/*     */   
/*     */   public static PIDIPCmd_GeneralCommandReq getGeneralCommandReqProcedure(IDIPCmd_GeneralCommandReq cmd)
/*     */   {
/* 110 */     long cmdId = ((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)cmd.req).body).CommandID;
/* 111 */     PIDIPCmd_GeneralCommandReqCreator creator = (PIDIPCmd_GeneralCommandReqCreator)creaters.get(Long.valueOf(cmdId));
/* 112 */     if (creator == null)
/*     */     {
/* 114 */       ((IDIPPacket_GeneralCommandRsp)cmd.rsp).head.Result = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)cmd.rsp).body).Result = -1);
/* 115 */       ((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)cmd.rsp).body).RetMsg = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)cmd.rsp).body).RetMsg = "system error: general command id unsupport");
/* 116 */       cmd.sendResponse();
/*     */       
/* 118 */       GameServer.logger().warn(String.format("[idip]PIDIPCmd_GeneralCommandReq.getGeneralCommandReqProcedure@general command id unsupport|area_id=%d|plat_id=%d|partition=%d|cmdid=%d|parameter1=%d|parameter2=%d|parameter3=%d|parameter4=%d|parameter5=%d|parameter6=%d|parameter7=%d|parameter8=%d|parameter9=%d|parameter10=%d", new Object[] { Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)cmd.req).body).AreaId), Byte.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)cmd.req).body).PlatId), Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)cmd.req).body).Partition), Long.valueOf(cmdId), Long.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)cmd.req).body).parameter1), Long.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)cmd.req).body).parameter2), Long.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)cmd.req).body).parameter3), Long.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)cmd.req).body).parameter4), Long.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)cmd.req).body).parameter5), Long.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)cmd.req).body).parameter6), Long.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)cmd.req).body).parameter7), Long.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)cmd.req).body).parameter8), Long.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)cmd.req).body).parameter9), Long.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)cmd.req).body).parameter10) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 126 */       return null;
/*     */     }
/*     */     
/* 129 */     return creator.create(cmd);
/*     */   }
/*     */   
/*     */   public PIDIPCmd_GeneralCommandReq(IDIPCmd_GeneralCommandReq cmd)
/*     */   {
/* 134 */     super(cmd);
/*     */   }
/*     */   
/*     */   protected boolean handle()
/*     */     throws Exception
/*     */   {
/* 140 */     List<Long> params = new ArrayList();
/* 141 */     params.add(Long.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).parameter1));
/* 142 */     params.add(Long.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).parameter2));
/* 143 */     params.add(Long.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).parameter3));
/* 144 */     params.add(Long.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).parameter4));
/* 145 */     params.add(Long.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).parameter5));
/* 146 */     params.add(Long.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).parameter6));
/* 147 */     params.add(Long.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).parameter7));
/* 148 */     params.add(Long.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).parameter8));
/* 149 */     params.add(Long.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).parameter9));
/* 150 */     params.add(Long.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).parameter10));
/*     */     
/* 152 */     return executeCmd(params);
/*     */   }
/*     */   
/*     */   protected abstract boolean executeCmd(List<Long> paramList)
/*     */     throws Exception;
/*     */   
/*     */   public static abstract interface PIDIPCmd_GeneralCommandReqCreator
/*     */   {
/*     */     public abstract PIDIPCmd_GeneralCommandReq create(IDIPCmd_GeneralCommandReq paramIDIPCmd_GeneralCommandReq);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PIDIPCmd_GeneralCommandReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */