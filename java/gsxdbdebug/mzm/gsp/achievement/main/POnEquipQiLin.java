/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.achievement.main.goaltype.AbstractDoneOneEventLevelTimes.Context;
/*    */ import mzm.gsp.item.event.EquipQiLinProcedure;
/*    */ import mzm.gsp.item.main.EquipQiLinArg;
/*    */ 
/*    */ public class POnEquipQiLin
/*    */   extends EquipQiLinProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 13 */     AbstractDoneOneEventLevelTimes.Context context = new AbstractDoneOneEventLevelTimes.Context(((EquipQiLinArg)this.arg).newStrengthLevel, ((EquipQiLinArg)this.arg).uuid);
/*    */     
/*    */ 
/* 16 */     AchievementManager.updateGoalTypeState(((EquipQiLinArg)this.arg).roleid, 3005, context, "POnEquipQiLin.processImp@EQUIPMENT_QILING_LEVEL success");
/*    */     
/*    */ 
/* 19 */     if (((EquipQiLinArg)this.arg).newStrengthLevel > ((EquipQiLinArg)this.arg).oldStrengthLevel)
/*    */     {
/*    */ 
/* 22 */       AchievementManager.updateGoalTypeState(((EquipQiLinArg)this.arg).roleid, 3006, Integer.valueOf(1), "POnEquipQiLin.processImp@handle EQUIPMENT_QILING_SUCCESS success");
/*    */       
/*    */ 
/* 25 */       AchievementManager.updateGoalTypeState(((EquipQiLinArg)this.arg).roleid, 3008, Integer.valueOf(1), "POnEquipQiLin.processImp@handle EQUIPMENT_QILING_COMBO_SUCCESS success");
/*    */       
/*    */ 
/*    */ 
/* 29 */       AchievementManager.updateGoalTypeState(((EquipQiLinArg)this.arg).roleid, 3009, Integer.valueOf(0), "POnEquipQiLin.processImp@handle EQUIPMENT_QILING_FAIL success");
/*    */ 
/*    */     }
/*    */     else
/*    */     {
/*    */ 
/* 35 */       AchievementManager.updateGoalTypeState(((EquipQiLinArg)this.arg).roleid, 3007, Integer.valueOf(1), "POnEquipQiLin.processImp@handle EQUIPMENT_QILING_FAIL success");
/*    */       
/*    */ 
/*    */ 
/* 39 */       AchievementManager.updateGoalTypeState(((EquipQiLinArg)this.arg).roleid, 3008, Integer.valueOf(0), "POnEquipQiLin.processImp@handle EQUIPMENT_QILING_COMBO_SUCCESS success");
/*    */       
/*    */ 
/*    */ 
/* 43 */       AchievementManager.updateGoalTypeState(((EquipQiLinArg)this.arg).roleid, 3009, Integer.valueOf(1), "POnEquipQiLin.processImp@handle EQUIPMENT_QILING_FAIL success");
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 49 */     AchievementManager.updateGoalTypeState(((EquipQiLinArg)this.arg).roleid, 3018, null, "POnEquipQiLin.processImp@handle EQUIPMENT_WHOLE_BODY_QILING_LEVEL success");
/*    */     
/*    */ 
/* 52 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnEquipQiLin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */