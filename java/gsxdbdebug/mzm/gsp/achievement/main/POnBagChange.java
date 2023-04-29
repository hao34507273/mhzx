/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.item.event.PlayerBagChangeProcedure;
/*    */ import mzm.gsp.item.main.ItemEventArg;
/*    */ 
/*    */ public class POnBagChange
/*    */   extends PlayerBagChangeProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */   {
/* 11 */     AchievementManager.updateGoalTypeState(((ItemEventArg)this.arg).roleid, 4203, null, "POnBagChange.processImp@handle FABAO_SPECIFIC_STAR success");
/*    */     
/* 13 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnBagChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */