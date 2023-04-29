/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.pet.event.PetMallBuyEventArg;
/*    */ import mzm.gsp.pet.event.PetMallBuyEventProcedure;
/*    */ 
/*    */ public class POnPetMallBuy
/*    */   extends PetMallBuyEventProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */   {
/* 11 */     AchievementManager.updateGoalTypeState(((PetMallBuyEventArg)this.arg).roleId, 5402, Integer.valueOf(((PetMallBuyEventArg)this.arg).petCfgId), "POnPetMallBuy.updateState@handle PET_ACCUMULATE_BUY success");
/*    */     
/*    */ 
/* 14 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnPetMallBuy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */