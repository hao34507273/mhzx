/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.item.event.PlayerEquipChangeProcedure;
/*    */ import mzm.gsp.item.main.EquipChangeArg;
/*    */ 
/*    */ public class POnPlayerEquipChange
/*    */   extends PlayerEquipChangeProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     AchievementManager.updateGoalTypeState(((EquipChangeArg)this.arg).roleId, 3018, null, "POnPlayerEquipChange.processImp@handle EQUIPMENT_WHOLE_BODY_QILING_LEVEL success");
/*    */     
/*    */ 
/* 14 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnPlayerEquipChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */