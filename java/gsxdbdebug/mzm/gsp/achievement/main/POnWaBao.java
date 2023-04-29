/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.baotu.event.WaBaoArg;
/*    */ import mzm.gsp.baotu.event.WaBaoProcedure;
/*    */ import xbean.LotteryResult;
/*    */ 
/*    */ public class POnWaBao extends WaBaoProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 12 */     LotteryResult xLotteryResult = ((WaBaoArg)this.arg).xLotteryResult;
/* 13 */     Integer ControllerId = (Integer)xLotteryResult.getMap().get(Integer.valueOf(7));
/*    */     int baotuCfgId;
/* 15 */     int baotuCfgId; if ((null == ControllerId) || (ControllerId.intValue() == 0))
/*    */     {
/* 17 */       baotuCfgId = -1;
/*    */     }
/*    */     else
/*    */     {
/* 21 */       baotuCfgId = ((WaBaoArg)this.arg).xLotteryResult.getUseditemid();
/*    */     }
/* 23 */     AchievementManager.updateGoalTypeState(((WaBaoArg)this.arg).roleId, 2411, Integer.valueOf(baotuCfgId), "POnWaBao.processImp@handle BAOTU_COMBO_TRIGGER_CONTROLLER success");
/*    */     
/*    */ 
/* 26 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnWaBao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */