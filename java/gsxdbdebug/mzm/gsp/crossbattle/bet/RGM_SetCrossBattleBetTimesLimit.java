/*    */ package mzm.gsp.crossbattle.bet;
/*    */ 
/*    */ import mzm.gsp.crossbattle.confbean.CrossBattleConsts;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ 
/*    */ public class RGM_SetCrossBattleBetTimesLimit extends LogicRunnable
/*    */ {
/*    */   private final long gmRoleid;
/*    */   private final int limit;
/*    */   
/*    */   public RGM_SetCrossBattleBetTimesLimit(long gmRoleid, int limit)
/*    */   {
/* 14 */     this.gmRoleid = gmRoleid;
/* 15 */     this.limit = limit;
/*    */   }
/*    */   
/*    */   public void process()
/*    */     throws Exception
/*    */   {
/* 21 */     if (this.limit < 0)
/*    */     {
/* 23 */       GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("跨服战押注次数上限不能为负值|押注次数上限=%d", new Object[] { Integer.valueOf(this.limit) }));
/* 24 */       return;
/*    */     }
/* 26 */     CrossBattleConsts.getInstance().DAILY_BET_TIMES_UPPER_LIMIT = this.limit;
/*    */     
/* 28 */     GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("设置跨服战押注次数上限成功|押注次数上限=%d", new Object[] { Integer.valueOf(this.limit) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\bet\RGM_SetCrossBattleBetTimesLimit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */