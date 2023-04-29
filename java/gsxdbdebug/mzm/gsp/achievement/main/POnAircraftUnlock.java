/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.aircraft.event.UnlockAircraftArg;
/*    */ import mzm.gsp.aircraft.event.UnlockAircraftProcedure;
/*    */ 
/*    */ public class POnAircraftUnlock
/*    */   extends UnlockAircraftProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     AchievementManager.updateGoalTypeState(((UnlockAircraftArg)this.arg).roleId, 3014, null, "POnAircraftUnlock.processImp@handle AIRCRAFT_OWN finish");
/*    */     
/*    */ 
/*    */ 
/* 15 */     AchievementManager.updateGoalTypeState(((UnlockAircraftArg)this.arg).roleId, 3013, null, "POnAircraftUnlock.processImp@handle AIRCRAFT_SPECIFIC_OWN finish");
/*    */     
/*    */ 
/* 18 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnAircraftUnlock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */