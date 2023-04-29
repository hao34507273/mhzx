/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.achievement.main.goaltype.AbstractDoneOneEventLevelTimes.Context;
/*    */ import mzm.gsp.equipmentbless.event.EquipmentBlessLevelUpdatedArg;
/*    */ import mzm.gsp.equipmentbless.event.EquipmentBlessLevelUpdatedProcedure;
/*    */ 
/*    */ public class POnEquipmentBlessLevelUpdated
/*    */   extends EquipmentBlessLevelUpdatedProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 13 */     AbstractDoneOneEventLevelTimes.Context ctx = new AbstractDoneOneEventLevelTimes.Context(((EquipmentBlessLevelUpdatedArg)this.arg).newLevel, ((EquipmentBlessLevelUpdatedArg)this.arg).equipmentUUID);
/* 14 */     AchievementManager.updateGoalTypeState(((EquipmentBlessLevelUpdatedArg)this.arg).roleId, 3017, ctx, "POnEquipmentBlessLevelUpdated.processImp@handle EQUIPMENT_BLESS_LEVEL_COUNT success");
/*    */     
/*    */ 
/* 17 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnEquipmentBlessLevelUpdated.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */