/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.pet.event.PetEventArg;
/*    */ import mzm.gsp.pet.event.PetHuaShengProcedure;
/*    */ 
/*    */ public class POnPetHuaSheng
/*    */   extends PetHuaShengProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     AchievementManager.updateGoalTypeState(((PetEventArg)this.arg).roleId, 4, Integer.valueOf(1), "PetHuaSheng.updateState@handle PET_HUASHENG success");
/*    */     
/*    */ 
/*    */ 
/* 15 */     AchievementManager.updateGoalTypeState(((PetEventArg)this.arg).roleId, 5404, Long.valueOf(((PetEventArg)this.arg).petId), "POnPetHuaSheng.processImp@handle PET_SKILL_NUM success");
/*    */     
/* 17 */     AchievementManager.updateGoalTypeState(((PetEventArg)this.arg).roleId, 5405, Long.valueOf(((PetEventArg)this.arg).petId), "POnPetHuaSheng.processImp@handle PET_TYPE_SKILL_NUM success");
/*    */     
/*    */ 
/* 20 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnPetHuaSheng.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */