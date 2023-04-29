/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.achievement.main.goaltype.AbstractConditionalDoneOneEventTimes.Context;
/*    */ import mzm.gsp.item.event.EquipSkillGetArg;
/*    */ import mzm.gsp.item.event.EquipSkillGetProcedure;
/*    */ 
/*    */ public class POnEquipSkillGet
/*    */   extends EquipSkillGetProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */   {
/* 12 */     AbstractConditionalDoneOneEventTimes.Context context = new AbstractConditionalDoneOneEventTimes.Context(((EquipSkillGetArg)this.arg).equipSkillId, 1);
/* 13 */     AchievementManager.updateGoalTypeState(((EquipSkillGetArg)this.arg).roleId, 3011, context, "POnChildGiveBirth.processImp@handle CHILD_COUNT finish");
/*    */     
/*    */ 
/* 16 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnEquipSkillGet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */