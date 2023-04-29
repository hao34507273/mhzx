/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.pet.event.PetEventArg;
/*    */ import mzm.gsp.pet.event.PetSkillChangeProcedure;
/*    */ import mzm.gsp.pet.main.PetSkillChangeLogEnum;
/*    */ 
/*    */ public class POnPetSkillChange
/*    */   extends PetSkillChangeProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 12 */     if ((((PetEventArg)this.arg).enventType == PetSkillChangeLogEnum.AUTOLEARN.value) || (((PetEventArg)this.arg).enventType == PetSkillChangeLogEnum.AUTOLEVELUP.value))
/*    */     {
/* 14 */       AchievementManager.updateGoalTypeState(((PetEventArg)this.arg).roleId, 5407, Integer.valueOf(1), "POnPetSkillChange.updateState@handle PET_AUTO_LEARN_SKILL success");
/*    */     }
/*    */     
/*    */ 
/* 18 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnPetSkillChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */