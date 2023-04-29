/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.cat.event.CatExploreEndArg;
/*    */ import mzm.gsp.cat.event.CatExploreEndProcedure;
/*    */ 
/*    */ public class PRestoreCatIntoYardOnExploreEnd
/*    */   extends CatExploreEndProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     AchievementManager.updateGoalTypeState(((CatExploreEndArg)this.arg).roleid, 5607, Integer.valueOf(1), "PRestoreCatIntoYardOnExploreEnd.processImp@handle CAT_EXPLORE_COUNT finish");
/*    */     
/*    */ 
/*    */ 
/* 15 */     AchievementManager.updateGoalTypeState(((CatExploreEndArg)this.arg).roleid, 5606, null, "PRestoreCatIntoYardOnExploreEnd.processImp@handle CAT_GET_BIRD_COUNT finish");
/*    */     
/*    */ 
/* 18 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\PRestoreCatIntoYardOnExploreEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */