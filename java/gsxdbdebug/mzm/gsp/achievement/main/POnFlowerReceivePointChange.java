/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.item.event.FlowerReceivePointChangedArg;
/*    */ import mzm.gsp.item.event.FlowerReceivePointChangedEventProcedure;
/*    */ 
/*    */ public class POnFlowerReceivePointChange
/*    */   extends FlowerReceivePointChangedEventProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */   {
/* 11 */     AchievementManager.updateGoalTypeState(((FlowerReceivePointChangedArg)this.arg).roleId, 308, Integer.valueOf(((FlowerReceivePointChangedArg)this.arg).totalReceivePoint), "POnFlowerReceivePointChange.processImp@handle RECEIEVE_FLOWER_POINT finish");
/*    */     
/*    */ 
/* 14 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnFlowerReceivePointChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */