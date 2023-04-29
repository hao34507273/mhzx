/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.achievement.main.goaltype.GetColorEquipment.Context;
/*    */ import mzm.gsp.item.event.GainItemEventProcedure;
/*    */ import mzm.gsp.item.event.GainItemeArg;
/*    */ import mzm.gsp.item.main.ItemOperateResult;
/*    */ 
/*    */ public class POnGainItemEvent extends GainItemEventProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 12 */     GetColorEquipment.Context context = new GetColorEquipment.Context(((GainItemeArg)this.arg).itemOperateResult.getItemChangeMap());
/* 13 */     AchievementManager.updateGoalTypeState(((GainItemeArg)this.arg).roleId, 3004, context, "POnGainItemEvent.processImp@handle GET_COLOR_EQUIPMENT success");
/*    */     
/*    */ 
/* 16 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnGainItemEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */