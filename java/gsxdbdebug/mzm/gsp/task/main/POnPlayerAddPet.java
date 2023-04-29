/*    */ package mzm.gsp.task.main;
/*    */ 
/*    */ import mzm.gsp.pet.event.PetEventArg;
/*    */ import mzm.gsp.pet.event.PlayerAddPetProcedure;
/*    */ 
/*    */ public class POnPlayerAddPet
/*    */   extends PlayerAddPetProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     long roleId = ((PetEventArg)this.arg).roleId;
/* 12 */     TaskInterface.updateTaskCondition(roleId, 10, new Object());
/* 13 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\main\POnPlayerAddPet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */