/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.huanhun.event.HelpAddHuanHunItemArg;
/*    */ import mzm.gsp.huanhun.event.HelpAddHuanHunItemProcedure;
/*    */ 
/*    */ public class POnHelpAddHuanHunItem
/*    */   extends HelpAddHuanHunItemProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */   {
/* 11 */     AchievementManager.updateGoalTypeState(((HelpAddHuanHunItemArg)this.arg).getRoleId(), 910, Integer.valueOf(1), "POnHelpAddHuanHunItem.processImp@handle GANG_HUANHUN_HELP success");
/*    */     
/*    */ 
/* 14 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnHelpAddHuanHunItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */