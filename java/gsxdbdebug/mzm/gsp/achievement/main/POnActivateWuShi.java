/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.superequipment.wushi.event.ActivateWuShiArg;
/*    */ import mzm.gsp.superequipment.wushi.event.ActivateWuShiProcedure;
/*    */ 
/*    */ public class POnActivateWuShi
/*    */   extends ActivateWuShiProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     AchievementManager.updateGoalTypeState(((ActivateWuShiArg)this.arg).roleId, 3016, null, "POnActivateWuShi.processImp@handle WUSHI_OWN finish");
/*    */     
/*    */ 
/*    */ 
/* 15 */     AchievementManager.updateGoalTypeState(((ActivateWuShiArg)this.arg).roleId, 3015, null, "POnActivateWuShi.processImp@handle WUSHI_SPECIFIC_OWN finish");
/*    */     
/*    */ 
/* 18 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnActivateWuShi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */