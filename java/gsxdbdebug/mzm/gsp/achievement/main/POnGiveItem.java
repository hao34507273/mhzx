/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.item.event.GiveItemArg;
/*    */ import mzm.gsp.item.event.GiveItemProcedure;
/*    */ 
/*    */ public class POnGiveItem
/*    */   extends GiveItemProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */   {
/* 11 */     AchievementManager.updateGoalTypeState(((GiveItemArg)this.arg).roleId, 321, Integer.valueOf(1), "POnGiveItem.processImp@handle GIVE_ITEM finish");
/*    */     
/*    */ 
/* 14 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnGiveItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */