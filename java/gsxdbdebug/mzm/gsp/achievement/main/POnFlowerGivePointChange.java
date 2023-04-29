/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.item.event.FlowerGivePointChangedArg;
/*    */ import mzm.gsp.item.event.FlowerGivePointChangedEventProcedure;
/*    */ 
/*    */ public class POnFlowerGivePointChange
/*    */   extends FlowerGivePointChangedEventProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */   {
/* 11 */     AchievementManager.updateGoalTypeState(((FlowerGivePointChangedArg)this.arg).roleId, 307, Integer.valueOf(((FlowerGivePointChangedArg)this.arg).totalGivePoint), "POnFlowerGivePointChange.processImp@handle GIVE_FLOWER_POINT finish");
/*    */     
/*    */ 
/* 14 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnFlowerGivePointChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */