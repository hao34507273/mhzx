/*     */ package mzm.gsp.csprovider.gmt.idip;
/*     */ 
/*     */ import csprovider.DataBetweenCspAndGame_Re;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.csprovider.gmt.idip.generalcmd.AccountLimitHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.generalcmd.ActiveGraphHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.generalcmd.ActivityCloseHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.generalcmd.ActivityForceCloseHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.generalcmd.ActivityForceOpenHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.generalcmd.ActivityPauseHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.generalcmd.ActivityRejustEndTimeHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.generalcmd.AddChestHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.generalcmd.BanGraphHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.generalcmd.BanNpcServiceHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.generalcmd.ClearExecuteLoginQueueHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.generalcmd.ClearServerDropHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.generalcmd.CloseGmHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.generalcmd.CrossBattleOwnClearResultHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.generalcmd.CrossBattleOwnQueryReportResultHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.generalcmd.CrossBattleOwnRestartRoundRobinHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.generalcmd.CrossBattlePointRaceBackupHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.generalcmd.CrossBattlePointRaceReportFightHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.generalcmd.DeleteFashionHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.generalcmd.DeleteWingHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.generalcmd.DirectBufferSizeHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.generalcmd.DisableProtocolSwitchHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.generalcmd.GangClearUnrealMemberHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.generalcmd.GangDealMoreBangZhuHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.generalcmd.GangDealNoneBangZhuHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.generalcmd.GangKickOutHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.generalcmd.GangSetBangZhongDutyHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.generalcmd.GangSetBangZhuDutyHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.generalcmd.GeneralSysFunSwitchHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.generalcmd.GetExecuteLoginSizeHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.generalcmd.GetMapMsgQueueHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.generalcmd.GetMapProtocolSendQueueSizeHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.generalcmd.GetRoleNameHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.generalcmd.GroupShoppingItemSwitchHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.generalcmd.ItemBanTradeHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.generalcmd.ItemHideHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.generalcmd.ItemUnbanTradeHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.generalcmd.LoginThresholdHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.generalcmd.MaxAccountHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.generalcmd.MaxOnlineHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.generalcmd.MaxTaskPerRoleHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.generalcmd.NTimesAwardHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.generalcmd.NoneRealTimeTaskNumberHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.generalcmd.OutputDirectAllocationHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.generalcmd.PointExchangeSwitchHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.generalcmd.ReLoadAllBnyHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.generalcmd.ReLoadAllXmlHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.generalcmd.RefreshKnockOutDataHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.generalcmd.RemoveCrossLadderHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.generalcmd.RemoveLadderStatusHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.generalcmd.RemoveMapGroupByRoleIdHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.generalcmd.RepaireQiLingBugHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.generalcmd.ResetGiftCountHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.generalcmd.ResetServerLevelHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.generalcmd.RestartKnockOutHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.generalcmd.SetAllowDumpSqlLoggerStatisDetailHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.generalcmd.SetCheckpointPeriodHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.generalcmd.SetMaxQueueSizeHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.generalcmd.SetRankDBTimerHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.generalcmd.SetRemoteFlushRecordSpeedHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.generalcmd.SetRoleAchievementProgressHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.generalcmd.SetServerLevelHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.generalcmd.SetXHKPGlobalHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.generalcmd.SetXdbTraceLevelHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.generalcmd.ShutdownGsHandler;
/*     */ import mzm.gsp.csprovider.main.Retcode;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GeneralCmdHandler
/*     */   implements IdipHandler
/*     */ {
/*  81 */   private static Map<Integer, IdipHandler> generalCmdHandlerMap = new HashMap();
/*     */   
/*     */   static
/*     */   {
/*  85 */     generalCmdHandlerMap.put(Integer.valueOf(1), new DisableProtocolSwitchHandler());
/*  86 */     generalCmdHandlerMap.put(Integer.valueOf(2), new ShutdownGsHandler());
/*  87 */     generalCmdHandlerMap.put(Integer.valueOf(3), new GetRoleNameHandler());
/*  88 */     generalCmdHandlerMap.put(Integer.valueOf(4), new DirectBufferSizeHandler());
/*  89 */     generalCmdHandlerMap.put(Integer.valueOf(5), new OutputDirectAllocationHandler());
/*  90 */     generalCmdHandlerMap.put(Integer.valueOf(6), new NoneRealTimeTaskNumberHandler());
/*  91 */     generalCmdHandlerMap.put(Integer.valueOf(7), new LoginThresholdHandler());
/*  92 */     generalCmdHandlerMap.put(Integer.valueOf(8), new MaxOnlineHandler());
/*  93 */     generalCmdHandlerMap.put(Integer.valueOf(9), new AccountLimitHandler());
/*  94 */     generalCmdHandlerMap.put(Integer.valueOf(10), new MaxAccountHandler());
/*  95 */     generalCmdHandlerMap.put(Integer.valueOf(11), new ReLoadAllXmlHandler());
/*  96 */     generalCmdHandlerMap.put(Integer.valueOf(12), new ReLoadAllBnyHandler());
/*  97 */     generalCmdHandlerMap.put(Integer.valueOf(13), new MaxTaskPerRoleHandler());
/*  98 */     generalCmdHandlerMap.put(Integer.valueOf(14), new SetRankDBTimerHandler());
/*  99 */     generalCmdHandlerMap.put(Integer.valueOf(15), new GetMapMsgQueueHandler());
/* 100 */     generalCmdHandlerMap.put(Integer.valueOf(16), new GeneralSysFunSwitchHandler());
/* 101 */     generalCmdHandlerMap.put(Integer.valueOf(17), new GetMapProtocolSendQueueSizeHandler());
/* 102 */     generalCmdHandlerMap.put(Integer.valueOf(18), new ClearExecuteLoginQueueHandler());
/* 103 */     generalCmdHandlerMap.put(Integer.valueOf(19), new GetExecuteLoginSizeHandler());
/* 104 */     generalCmdHandlerMap.put(Integer.valueOf(20), new NTimesAwardHandler());
/* 105 */     generalCmdHandlerMap.put(Integer.valueOf(21), new SetServerLevelHandler());
/* 106 */     generalCmdHandlerMap.put(Integer.valueOf(22), new SetCheckpointPeriodHandler());
/* 107 */     generalCmdHandlerMap.put(Integer.valueOf(23), new SetRemoteFlushRecordSpeedHandler());
/* 108 */     generalCmdHandlerMap.put(Integer.valueOf(24), new SetAllowDumpSqlLoggerStatisDetailHandler());
/* 109 */     generalCmdHandlerMap.put(Integer.valueOf(25), new SetXdbTraceLevelHandler());
/* 110 */     generalCmdHandlerMap.put(Integer.valueOf(26), new ActivityCloseHandler());
/* 111 */     generalCmdHandlerMap.put(Integer.valueOf(27), new ActivityForceCloseHandler());
/* 112 */     generalCmdHandlerMap.put(Integer.valueOf(28), new ActivityForceOpenHandler());
/* 113 */     generalCmdHandlerMap.put(Integer.valueOf(29), new ActivityPauseHandler());
/* 114 */     generalCmdHandlerMap.put(Integer.valueOf(30), new ItemBanTradeHandler());
/* 115 */     generalCmdHandlerMap.put(Integer.valueOf(31), new ItemUnbanTradeHandler());
/* 116 */     generalCmdHandlerMap.put(Integer.valueOf(32), new CloseGmHandler());
/* 117 */     generalCmdHandlerMap.put(Integer.valueOf(33), new ActivityRejustEndTimeHandler());
/* 118 */     generalCmdHandlerMap.put(Integer.valueOf(34), new SetMaxQueueSizeHandler());
/* 119 */     generalCmdHandlerMap.put(Integer.valueOf(35), new RemoveMapGroupByRoleIdHandler());
/* 120 */     generalCmdHandlerMap.put(Integer.valueOf(36), new ResetServerLevelHandler());
/* 121 */     generalCmdHandlerMap.put(Integer.valueOf(37), new ResetGiftCountHandler());
/* 122 */     generalCmdHandlerMap.put(Integer.valueOf(38), new GangSetBangZhuDutyHandler());
/* 123 */     generalCmdHandlerMap.put(Integer.valueOf(39), new GangSetBangZhongDutyHandler());
/* 124 */     generalCmdHandlerMap.put(Integer.valueOf(40), new GangKickOutHandler());
/* 125 */     generalCmdHandlerMap.put(Integer.valueOf(41), new GangDealNoneBangZhuHandler());
/* 126 */     generalCmdHandlerMap.put(Integer.valueOf(42), new GangDealMoreBangZhuHandler());
/* 127 */     generalCmdHandlerMap.put(Integer.valueOf(43), new GangClearUnrealMemberHandler());
/* 128 */     generalCmdHandlerMap.put(Integer.valueOf(44), new BanNpcServiceHandler());
/* 129 */     generalCmdHandlerMap.put(Integer.valueOf(45), new ClearServerDropHandler());
/* 130 */     generalCmdHandlerMap.put(Integer.valueOf(46), new RemoveCrossLadderHandler());
/* 131 */     generalCmdHandlerMap.put(Integer.valueOf(47), new RemoveLadderStatusHandler());
/* 132 */     generalCmdHandlerMap.put(Integer.valueOf(48), new RepaireQiLingBugHandler());
/* 133 */     generalCmdHandlerMap.put(Integer.valueOf(49), new ActiveGraphHandler());
/* 134 */     generalCmdHandlerMap.put(Integer.valueOf(50), new AddChestHandler());
/* 135 */     generalCmdHandlerMap.put(Integer.valueOf(51), new BanGraphHandler());
/* 136 */     generalCmdHandlerMap.put(Integer.valueOf(52), new CrossBattleOwnQueryReportResultHandler());
/* 137 */     generalCmdHandlerMap.put(Integer.valueOf(53), new CrossBattleOwnClearResultHandler());
/* 138 */     generalCmdHandlerMap.put(Integer.valueOf(54), new CrossBattleOwnRestartRoundRobinHandler());
/* 139 */     generalCmdHandlerMap.put(Integer.valueOf(55), new CrossBattlePointRaceBackupHandler());
/* 140 */     generalCmdHandlerMap.put(Integer.valueOf(56), new CrossBattlePointRaceReportFightHandler());
/* 141 */     generalCmdHandlerMap.put(Integer.valueOf(57), new RestartKnockOutHandler());
/* 142 */     generalCmdHandlerMap.put(Integer.valueOf(58), new RefreshKnockOutDataHandler());
/* 143 */     generalCmdHandlerMap.put(Integer.valueOf(59), new ItemHideHandler());
/* 144 */     generalCmdHandlerMap.put(Integer.valueOf(60), new SetXHKPGlobalHandler());
/* 145 */     generalCmdHandlerMap.put(Integer.valueOf(61), new PointExchangeSwitchHandler());
/* 146 */     generalCmdHandlerMap.put(Integer.valueOf(62), new GroupShoppingItemSwitchHandler());
/* 147 */     generalCmdHandlerMap.put(Integer.valueOf(63), new SetRoleAchievementProgressHandler());
/* 148 */     generalCmdHandlerMap.put(Integer.valueOf(64), new DeleteFashionHandler());
/* 149 */     generalCmdHandlerMap.put(Integer.valueOf(65), new DeleteWingHandler());
/*     */   }
/*     */   
/*     */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp)
/*     */     throws Exception
/*     */   {
/* 155 */     String strCmdid = (String)params.remove(0);
/* 156 */     Integer generalCmdId = Integer.valueOf(strCmdid);
/*     */     
/* 158 */     IdipHandler genernalCmdHandler = (IdipHandler)generalCmdHandlerMap.get(generalCmdId);
/* 159 */     if (genernalCmdHandler == null)
/*     */     {
/* 161 */       rsp.retcode = Retcode.TEXT_CMD_GENERAL_CMD_NOT_EXIST.value;
/*     */       
/* 163 */       GameServer.logger().error(String.format("[gmt]GeneralCmdHandler.execute@execute failed|params=%s", new Object[] { params.toString() }));
/*     */       
/*     */ 
/* 166 */       return;
/*     */     }
/*     */     
/* 169 */     genernalCmdHandler.execute(params, rsp);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\GeneralCmdHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */