/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.competition.event.CompetitionResultArg;
/*    */ 
/*    */ public class ROnCompetitionResult extends mzm.gsp.competition.event.CompetitionResultRunnable
/*    */ {
/*    */   public void process()
/*    */   {
/* 11 */     for (Iterator i$ = ((CompetitionResultArg)this.arg).members1.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */       
/* 13 */       updateAchievement(roleId, ((CompetitionResultArg)this.arg).isFaction1Winner());
/*    */     }
/* 15 */     for (Iterator i$ = ((CompetitionResultArg)this.arg).members2.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */       
/* 17 */       updateAchievement(roleId, ((CompetitionResultArg)this.arg).isFaction2Winner());
/*    */     }
/*    */   }
/*    */   
/*    */   private void updateAchievement(final long roleId, boolean win)
/*    */   {
/* 23 */     new mzm.gsp.util.LogicProcedure()
/*    */     {
/*    */ 
/*    */       protected boolean processImp()
/*    */         throws Exception
/*    */       {
/* 29 */         AchievementManager.updateGoalTypeState(roleId, 906, Integer.valueOf(1), "ROnCompetitionResult.updateAchievement@handle COMPETITION_JOIN success");
/*    */         
/*    */ 
/*    */ 
/* 33 */         if (this.val$win)
/*    */         {
/* 35 */           AchievementManager.updateGoalTypeState(roleId, 907, Integer.valueOf(1), "ROnCompetitionResult.updateAchievement@handle COMPETITION_WIN success");
/*    */ 
/*    */         }
/*    */         else
/*    */         {
/* 40 */           AchievementManager.updateGoalTypeState(roleId, 908, Integer.valueOf(1), "ROnCompetitionResult.updateAchievement@handle COMPETITION_LOSE success");
/*    */         }
/*    */         
/*    */ 
/* 44 */         return true;
/*    */       }
/*    */     }.call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\ROnCompetitionResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */