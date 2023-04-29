/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import mzm.gsp.gangrace.event.GangRaceEndArg;
/*    */ import mzm.gsp.gangrace.event.GangRaceEndRunnable;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class ROnGangRaceEnd extends GangRaceEndRunnable
/*    */ {
/*    */   public void process()
/*    */   {
/* 12 */     updateWinAchievement(((GangRaceEndArg)this.arg).winnerRoleId);
/*    */     
/*    */ 
/* 15 */     for (Iterator i$ = ((GangRaceEndArg)this.arg).voteRoleIds.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */       
/* 17 */       updateVoteAchievement(roleId);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   private void updateWinAchievement(final long roleId)
/*    */   {
/* 24 */     if (roleId <= 0L)
/*    */     {
/* 26 */       return;
/*    */     }
/* 28 */     new LogicProcedure()
/*    */     {
/*    */       protected boolean processImp()
/*    */         throws Exception
/*    */       {
/* 33 */         AchievementManager.updateGoalTypeState(roleId, 2408, Integer.valueOf(1), "ROnGangRaceEnd.updateWinAchievement@handle GANG_RACE_WIN success");
/*    */         
/* 35 */         return true;
/*    */       }
/*    */     }.call();
/*    */   }
/*    */   
/*    */   private void updateVoteAchievement(final long roleId)
/*    */   {
/* 42 */     new LogicProcedure()
/*    */     {
/*    */       protected boolean processImp()
/*    */         throws Exception
/*    */       {
/* 47 */         AchievementManager.updateGoalTypeState(roleId, 2409, Integer.valueOf(1), "ROnGangRaceEnd.updateWinAchievement@handle GANG_RACE_VOTE_WINNER success");
/*    */         
/* 49 */         return true;
/*    */       }
/*    */     }.call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\ROnGangRaceEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */