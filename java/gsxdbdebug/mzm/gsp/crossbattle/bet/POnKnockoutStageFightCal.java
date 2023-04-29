/*    */ package mzm.gsp.crossbattle.bet;
/*    */ 
/*    */ import mzm.gsp.crossbattle.event.KnockOutStageFightCalArg;
/*    */ import mzm.gsp.crossbattle.event.KnockOutStageFightCalProcedure;
/*    */ import mzm.gsp.crossbattle.main.CrossBattleOneByOneManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnKnockoutStageFightCal
/*    */   extends KnockOutStageFightCalProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 15 */     for (int fightZoneid = 1; fightZoneid <= CrossBattleBetManager.getKnockoutFightZoneNum(((KnockOutStageFightCalArg)this.arg).knockOutType); fightZoneid++)
/*    */     {
/* 17 */       CrossBattleOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(((KnockOutStageFightCalArg)this.arg).activityCfgId), new PTrySettleKnockoutStageBet(((KnockOutStageFightCalArg)this.arg).activityCfgId, ((KnockOutStageFightCalArg)this.arg).knockOutType, fightZoneid, ((KnockOutStageFightCalArg)this.arg).fightStage, 1));
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 22 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\bet\POnKnockoutStageFightCal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */