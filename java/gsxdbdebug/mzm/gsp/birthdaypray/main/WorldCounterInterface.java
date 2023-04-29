/*    */ package mzm.gsp.birthdaypray.main;
/*    */ 
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WorldCounterInterface
/*    */ {
/*    */   static long addWorldCounterTimes(int index_1, int index_2, int changeTimes)
/*    */   {
/* 26 */     return BirthdayPrayManager.addWorldCounterTimes(index_1, index_2, changeTimes);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static long getWorldCounterTimes(int index_1, int index_2, boolean retainLock)
/*    */   {
/* 44 */     return BirthdayPrayManager.getWorldCounterTimes(index_1, index_2, retainLock);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static List<Integer> getWorldCounterRewardStages(long roleId, int index_1, int index_2)
/*    */   {
/* 59 */     return BirthdayPrayManager.getWorldCounterRewardStages(roleId, index_1, index_2);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static List<Integer> addWorldCounterRewardStages(long roleId, int index_1, int index_2, int stageId)
/*    */   {
/* 74 */     return BirthdayPrayManager.addWorldCounterRewardStages(roleId, index_1, index_2, stageId);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\birthdaypray\main\WorldCounterInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */