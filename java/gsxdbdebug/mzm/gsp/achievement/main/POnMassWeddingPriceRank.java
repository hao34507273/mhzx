/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.achievement.main.goaltype.AbstractConditionalDoneOneEventTimes.Context;
/*    */ import mzm.gsp.masswedding.event.MassWeddingPriceRankArg;
/*    */ import mzm.gsp.masswedding.event.MassWeddingPriceRankProcedure;
/*    */ 
/*    */ public class POnMassWeddingPriceRank
/*    */   extends MassWeddingPriceRankProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 14 */     AchievementManager.collectLocks(Arrays.asList(new Long[] { Long.valueOf(((MassWeddingPriceRankArg)this.arg).roleid1), Long.valueOf(((MassWeddingPriceRankArg)this.arg).roleid2) }));
/*    */     
/*    */ 
/* 17 */     AbstractConditionalDoneOneEventTimes.Context ctx = new AbstractConditionalDoneOneEventTimes.Context(((MassWeddingPriceRankArg)this.arg).rank, 1);
/* 18 */     AchievementManager.updateGoalTypeState(((MassWeddingPriceRankArg)this.arg).roleid1, 314, ctx, "POnMassWeddingPriceRank.processImp@handle MASS_WEDDING_PRICE_RANK success");
/*    */     
/* 20 */     AchievementManager.updateGoalTypeState(((MassWeddingPriceRankArg)this.arg).roleid2, 314, ctx, "POnMassWeddingPriceRank.processImp@handle MASS_WEDDING_PRICE_RANK success");
/*    */     
/*    */ 
/* 23 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnMassWeddingPriceRank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */