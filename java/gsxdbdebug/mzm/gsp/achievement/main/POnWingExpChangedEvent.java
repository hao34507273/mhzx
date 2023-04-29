/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.wing.event.WingExpChangedArg;
/*    */ import mzm.gsp.wing.event.WingExpChangedEventProcedure;
/*    */ 
/*    */ public class POnWingExpChangedEvent
/*    */   extends WingExpChangedEventProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 12 */     if (((WingExpChangedArg)this.arg).lvUp())
/*    */     {
/* 14 */       AchievementManager.updateGoalTypeState(((WingExpChangedArg)this.arg).getRoleId(), 3901, Integer.valueOf(((WingExpChangedArg)this.arg).getNewLv()), "POnWingExpChangedEvent.processImp@handle WING_SHENGJI success");
/*    */     }
/*    */     
/* 17 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnWingExpChangedEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */