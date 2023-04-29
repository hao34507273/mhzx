/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.pet.event.PetEventArg;
/*    */ import mzm.gsp.pet.event.UseSkillBookProcedure;
/*    */ 
/*    */ public class POnUseSkillBook
/*    */   extends UseSkillBookProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 12 */     AchievementManager.updateGoalTypeState(((PetEventArg)this.arg).roleId, 6, Integer.valueOf(((PetEventArg)this.arg).enventType), "POnUseSkillBook.processImp@handle PET_LEARN_SKILL success");
/*    */     
/*    */ 
/*    */ 
/* 16 */     AchievementManager.updateGoalTypeState(((PetEventArg)this.arg).roleId, 5404, Long.valueOf(((PetEventArg)this.arg).petId), "POnUseSkillBook.processImp@handle PET_SKILL_NUM success");
/*    */     
/* 18 */     AchievementManager.updateGoalTypeState(((PetEventArg)this.arg).roleId, 5405, Long.valueOf(((PetEventArg)this.arg).petId), "POnUseSkillBook.processImp@handle PET_TYPE_SKILL_NUM success");
/*    */     
/*    */ 
/* 21 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnUseSkillBook.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */