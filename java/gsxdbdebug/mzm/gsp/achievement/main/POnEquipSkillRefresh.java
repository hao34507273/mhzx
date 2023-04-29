/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.item.event.EquipSkillRefreshArg;
/*    */ import mzm.gsp.item.event.EquipSkillRefreshProcedure;
/*    */ 
/*    */ public class POnEquipSkillRefresh
/*    */   extends EquipSkillRefreshProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */   {
/* 11 */     AchievementManager.updateGoalTypeState(((EquipSkillRefreshArg)this.arg).roleId, 3010, Integer.valueOf(1), "POnEquipSkillRefresh.processImp@handle EQUIPMENT_SKILL_REFRESH finish");
/*    */     
/*    */ 
/* 14 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnEquipSkillRefresh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */