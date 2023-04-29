/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.pet.event.PetFanShengEventArg;
/*    */ import mzm.gsp.pet.event.PetFanShengProcedure;
/*    */ 
/*    */ public class POnPetFanSheng
/*    */   extends PetFanShengProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     AchievementManager.updateGoalTypeState(((PetFanShengEventArg)this.arg).roleId, 3, Integer.valueOf(1), "PetHuaSheng.updateState@handle PET_FANSHENG success");
/*    */     
/*    */ 
/*    */ 
/* 15 */     AchievementManager.updateGoalTypeState(((PetFanShengEventArg)this.arg).roleId, 5404, Long.valueOf(((PetFanShengEventArg)this.arg).newPetId), "POnPetHuaSheng.processImp@handle PET_SKILL_NUM success");
/*    */     
/* 17 */     AchievementManager.updateGoalTypeState(((PetFanShengEventArg)this.arg).roleId, 5405, Long.valueOf(((PetFanShengEventArg)this.arg).newPetId), "POnPetHuaSheng.processImp@handle PET_TYPE_SKILL_NUM success");
/*    */     
/* 19 */     AchievementManager.updateGoalTypeState(((PetFanShengEventArg)this.arg).roleId, 5408, Long.valueOf(((PetFanShengEventArg)this.arg).newPetId), "POnPetHuaSheng.processImp@handle PET_COMBO_FANSHENG_WITH_SKILL_NUM success");
/*    */     
/*    */ 
/* 22 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnPetFanSheng.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */