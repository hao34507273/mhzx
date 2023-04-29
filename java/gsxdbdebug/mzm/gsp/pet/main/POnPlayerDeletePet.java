/*    */ package mzm.gsp.pet.main;
/*    */ 
/*    */ import mzm.gsp.pet.event.PetEventArg;
/*    */ import mzm.gsp.pet.event.PlayerDeletePetProcedure;
/*    */ 
/*    */ public class POnPlayerDeletePet extends PlayerDeletePetProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 10 */     PetYaoLiChartRankManager.getInstance().deletRealTimeRank(((PetEventArg)this.arg).petId);
/*    */     
/*    */ 
/* 13 */     long petId = ((PetEventArg)this.arg).petId;
/* 14 */     final long roleId = ((PetEventArg)this.arg).roleId;
/* 15 */     new POnDeletePetOutFightBean(roleId, petId).execute();
/*    */     
/*    */ 
/* 18 */     new mzm.gsp.util.LogicProcedure()
/*    */     {
/*    */       protected boolean processImp()
/*    */         throws Exception
/*    */       {
/* 23 */         PetFightInterface.clearPetFightDataForCertainPet(roleId, this.val$petId);
/* 24 */         return true;
/*    */       }
/*    */       
/* 27 */     }.execute();
/* 28 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\POnPlayerDeletePet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */