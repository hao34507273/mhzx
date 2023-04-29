/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.mibao.event.DrawMiBaoLotteryArg;
/*    */ import mzm.gsp.mibao.event.DrawMiBaoLotteryProcedure;
/*    */ 
/*    */ public class POnDrawMiBaoLottery
/*    */   extends DrawMiBaoLotteryProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */   {
/* 11 */     AchievementManager.updateGoalTypeState(((DrawMiBaoLotteryArg)this.arg).roleId, 5201, Integer.valueOf(((DrawMiBaoLotteryArg)this.arg).drawTimes), "POnDrawMiBaoLottery.processImp@handle MIBAO_DRAW_COUNT success");
/*    */     
/*    */ 
/*    */ 
/* 15 */     AchievementManager.updateGoalTypeState(((DrawMiBaoLotteryArg)this.arg).roleId, 5203, Integer.valueOf(((DrawMiBaoLotteryArg)this.arg).addMiBaoScore), "POnDrawMiBaoLottery.processImp@handle MIBAO_SCORE_GET success");
/*    */     
/*    */ 
/*    */ 
/* 19 */     AchievementManager.updateGoalTypeState(((DrawMiBaoLotteryArg)this.arg).roleId, 5202, Integer.valueOf(((DrawMiBaoLotteryArg)this.arg).nowMiBaoScore), "POnDrawMiBaoLottery.processImp@handle MIBAO_SCORE_OWN success");
/*    */     
/*    */ 
/* 22 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnDrawMiBaoLottery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */