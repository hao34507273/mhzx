/*    */ package mzm.gsp.map.main;
/*    */ 
/*    */ import mzm.gsp.map.main.message.MMH_OnPetUnModelChange;
/*    */ import mzm.gsp.pet.event.PetUnChangeModelEventArg;
/*    */ 
/*    */ public class POnPetUnChangeModel extends mzm.gsp.pet.event.PetUnChangeModelEventProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 10 */     long roleid = ((PetUnChangeModelEventArg)this.arg).roleId;
/* 11 */     long petid = ((PetUnChangeModelEventArg)this.arg).petId;
/*    */     
/* 13 */     new MMH_OnPetUnModelChange(roleid, petid).execute();
/*    */     
/* 15 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\POnPetUnChangeModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */