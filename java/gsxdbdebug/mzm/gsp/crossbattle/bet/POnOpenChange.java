/*    */ package mzm.gsp.crossbattle.bet;
/*    */ 
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.crossbattle.confbean.CrossBattleFinalBetModuleidCfg;
/*    */ import mzm.gsp.crossbattle.confbean.CrossBattleRoundRobinBetModuleidCfg;
/*    */ import mzm.gsp.crossbattle.confbean.CrossBattleSelectionBetModuleidCfg;
/*    */ import mzm.gsp.crossbattle.knockout.CrossBattleKnockoutInterface;
/*    */ import mzm.gsp.crossbattle.main.CrossBattleOneByOneManager;
/*    */ import mzm.gsp.open.event.OpenChangeComplexArg;
/*    */ import mzm.gsp.open.event.OpenChangeProcedure;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnOpenChange
/*    */   extends OpenChangeProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 23 */     if (!CrossBattleBetManager.postInitFlag)
/*    */     {
/* 25 */       return false;
/*    */     }
/* 27 */     if (GameServerInfoManager.isRoamServer())
/*    */     {
/* 29 */       return false;
/*    */     }
/* 31 */     boolean isOpen = ((OpenChangeComplexArg)this.arg).isOpen();
/* 32 */     int type = ((OpenChangeComplexArg)this.arg).getType();
/* 33 */     if (CrossBattleRoundRobinBetModuleidCfg.get(type) != null)
/*    */     {
/* 35 */       if (isOpen)
/*    */       {
/* 37 */         CrossBattleOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(CrossBattleRoundRobinBetModuleidCfg.get(type).activity_cfg_id), new PTrySettleRoundRobinBet(CrossBattleRoundRobinBetModuleidCfg.get(type).activity_cfg_id));
/*    */       }
/*    */     }
/*    */     
/*    */ 
/* 42 */     if (CrossBattleSelectionBetModuleidCfg.get(type) != null)
/*    */     {
/* 44 */       int activityCfgid = CrossBattleSelectionBetModuleidCfg.get(type).activity_cfg_id;
/* 45 */       if (isOpen)
/*    */       {
/* 47 */         for (int fightZoneid = 1; fightZoneid <= CrossBattleBetManager.getKnockoutFightZoneNum(1); fightZoneid++)
/*    */         {
/* 49 */           for (int stage = 1; stage <= CrossBattleKnockoutInterface.getKnockOutStageSize(activityCfgid, 1); 
/* 50 */               stage++)
/*    */           {
/* 52 */             if (DateTimeUtils.getCurrTimeInMillis() >= CrossBattleKnockoutInterface.getCrossBattleKnockOutStageCalTime(activityCfgid, 1, stage))
/*    */             {
/*    */ 
/* 55 */               CrossBattleOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(activityCfgid), new PTrySettleKnockoutStageBet(activityCfgid, 1, fightZoneid, stage, 1));
/*    */             }
/*    */           }
/*    */         }
/*    */       }
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 64 */     if (CrossBattleFinalBetModuleidCfg.get(type) != null)
/*    */     {
/* 66 */       int activityCfgid = CrossBattleFinalBetModuleidCfg.get(type).activity_cfg_id;
/* 67 */       if (isOpen)
/*    */       {
/* 69 */         for (int fightZoneid = 1; fightZoneid <= CrossBattleBetManager.getKnockoutFightZoneNum(2); fightZoneid++)
/*    */         {
/* 71 */           for (int stage = 1; stage <= CrossBattleKnockoutInterface.getKnockOutStageSize(activityCfgid, 2); 
/* 72 */               stage++)
/*    */           {
/* 74 */             if (DateTimeUtils.getCurrTimeInMillis() >= CrossBattleKnockoutInterface.getCrossBattleKnockOutStageCalTime(activityCfgid, 2, stage))
/*    */             {
/*    */ 
/* 77 */               CrossBattleOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(activityCfgid), new PTrySettleKnockoutStageBet(activityCfgid, 2, fightZoneid, stage, 1));
/*    */             }
/*    */           }
/*    */         }
/*    */       }
/*    */     }
/*    */     
/*    */ 
/* 85 */     if ((type == 485) && (isOpen))
/*    */     {
/* 87 */       CrossBattleBetChartManager.getInstance().checkAndGetRemoteRank();
/* 88 */       CrossBattleBetChartManager.getInstance().checkAndSendAward();
/*    */     }
/* 90 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\bet\POnOpenChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */