/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.masswedding.event.MassWeddingJoinArg;
/*    */ import mzm.gsp.masswedding.event.MassWeddingJoinProcedure;
/*    */ 
/*    */ public class POnMassWeddingJoin
/*    */   extends MassWeddingJoinProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 13 */     AchievementManager.collectLocks(Arrays.asList(new Long[] { Long.valueOf(((MassWeddingJoinArg)this.arg).roleid1), Long.valueOf(((MassWeddingJoinArg)this.arg).roleid2) }));
/*    */     
/*    */ 
/* 16 */     AchievementManager.updateGoalTypeState(((MassWeddingJoinArg)this.arg).roleid1, 313, Integer.valueOf(1), "POnMassWeddingJoin.processImp@handle MASS_WEDDING_COUNT success");
/*    */     
/* 18 */     AchievementManager.updateGoalTypeState(((MassWeddingJoinArg)this.arg).roleid2, 313, Integer.valueOf(1), "POnMassWeddingJoin.processImp@handle MASS_WEDDING_COUNT success");
/*    */     
/*    */ 
/* 21 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnMassWeddingJoin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */