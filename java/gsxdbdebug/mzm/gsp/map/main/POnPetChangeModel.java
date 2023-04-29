/*    */ package mzm.gsp.map.main;
/*    */ 
/*    */ import mzm.gsp.map.main.message.MMH_OnPetModelChange;
/*    */ import mzm.gsp.pet.event.PetChangeModelEventArg;
/*    */ 
/*    */ public class POnPetChangeModel extends mzm.gsp.pet.event.PetChangeModelEventProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 10 */     long roleid = ((PetChangeModelEventArg)this.arg).roleId;
/* 11 */     long petid = ((PetChangeModelEventArg)this.arg).petId;
/* 12 */     int exteriorId = ((PetChangeModelEventArg)this.arg).changeModelId;
/* 13 */     int exteriorColorId = ((PetChangeModelEventArg)this.arg).colorId;
/* 14 */     int outlookId = ((PetChangeModelEventArg)this.arg).outlookId;
/*    */     
/* 16 */     new MMH_OnPetModelChange(roleid, petid, exteriorId, exteriorColorId, outlookId).execute();
/*    */     
/* 18 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\POnPetChangeModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */