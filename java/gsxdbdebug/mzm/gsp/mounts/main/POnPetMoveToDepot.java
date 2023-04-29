/*    */ package mzm.gsp.mounts.main;
/*    */ 
/*    */ import mzm.gsp.pet.event.PetEventArg;
/*    */ import mzm.gsp.pet.event.PetMoveToDepotProcedure;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import xtable.User;
/*    */ 
/*    */ public class POnPetMoveToDepot extends PetMoveToDepotProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 12 */     long roleId = ((PetEventArg)this.arg).roleId;
/* 13 */     long petId = ((PetEventArg)this.arg).petId;
/*    */     
/* 15 */     String userId = RoleInterface.getUserId(roleId);
/* 16 */     lock(xdb.Lockeys.get(User.getTable(), userId));
/*    */     
/* 18 */     MountsManager.onPetRemoveFromBag(userId, roleId, petId, "POnPetMoveToDepot");
/* 19 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mounts\main\POnPetMoveToDepot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */