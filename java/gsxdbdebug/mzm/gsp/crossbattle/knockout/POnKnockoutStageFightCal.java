/*    */ package mzm.gsp.crossbattle.knockout;
/*    */ 
/*    */ import mzm.gsp.crossbattle.confbean.CrossBattleConsts;
/*    */ import mzm.gsp.crossbattle.event.KnockOutStageFightCalProcedure;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ 
/*    */ public class POnKnockoutStageFightCal
/*    */   extends KnockOutStageFightCalProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 13 */     long currentTimeMillis = DateTimeUtils.getCurrTimeInMillis();
/* 14 */     int currentActivityCfgId = CrossBattleConsts.getInstance().CURRENT_ACTIVITY_CFG_ID;
/*    */     
/*    */ 
/* 17 */     long lastFinalStageFightBeginTime = CrossBattleKnockoutInterface.getCrossBattleKnockOutLastStageEnterTime(currentActivityCfgId, 2);
/*    */     
/* 19 */     if (currentTimeMillis > lastFinalStageFightBeginTime)
/*    */     {
/* 21 */       CrossBattleKnockoutManager.clearCanJoinNowStageKnockOutCorpsIdSet();
/*    */     }
/*    */     else
/*    */     {
/* 25 */       CrossBattleKnockoutManager.checkCanJoinNowStageKnockOut(-1L, -1L);
/*    */     }
/*    */     
/* 28 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\knockout\POnKnockoutStageFightCal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */