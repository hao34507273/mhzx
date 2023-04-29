/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.item.event.ExtendBagArg;
/*    */ import mzm.gsp.item.event.ExtendBagEventProcedure;
/*    */ 
/*    */ public class POnExtendBag
/*    */   extends ExtendBagEventProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 12 */     AchievementManager.updateGoalTypeState(((ExtendBagArg)this.arg).roleId, 4800, Integer.valueOf(1), "POnExtendBag.processImp@handle EXTEND_ROLE_BAG success");
/*    */     
/*    */ 
/*    */ 
/* 16 */     AchievementManager.updateGoalTypeState(((ExtendBagArg)this.arg).roleId, 4801, Integer.valueOf(((ExtendBagArg)this.arg).newCapacity), "POnExtendBag.processImp@handle BagGridCount success");
/*    */     
/*    */ 
/* 19 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnExtendBag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */