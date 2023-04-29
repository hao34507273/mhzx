/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.baitan.event.ShangJiaArg;
/*    */ import mzm.gsp.baitan.event.ShangJiaEventProcedure;
/*    */ 
/*    */ public class POnShangJiaEvent
/*    */   extends ShangJiaEventProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     AchievementManager.updateGoalTypeState(((ShangJiaArg)this.arg).roleId, 1507, Integer.valueOf(((ShangJiaArg)this.arg).num), "POnShangJiaEvent.processImp@handle EXCHANGE_BAI_TAN_SHANG_JIA_ITEM_NUM success");
/*    */     
/*    */ 
/* 14 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnShangJiaEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */