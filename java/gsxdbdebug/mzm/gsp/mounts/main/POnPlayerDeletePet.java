/*    */ package mzm.gsp.mounts.main;
/*    */ 
/*    */ import mzm.gsp.pet.event.PetEventArg;
/*    */ import mzm.gsp.pet.event.PlayerDeletePetProcedure;
/*    */ import mzm.gsp.pet.main.PetDeleteTLogEnum;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import xtable.User;
/*    */ 
/*    */ public class POnPlayerDeletePet extends PlayerDeletePetProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     long roleId = ((PetEventArg)this.arg).roleId;
/* 14 */     long petId = ((PetEventArg)this.arg).petId;
/*    */     
/* 16 */     if (((PetEventArg)this.arg).enventType == PetDeleteTLogEnum.FANSHENG.value)
/*    */     {
/* 18 */       return false;
/*    */     }
/* 20 */     String userId = RoleInterface.getUserId(roleId);
/* 21 */     lock(xdb.Lockeys.get(User.getTable(), userId));
/*    */     
/* 23 */     MountsManager.onPetRemoveFromBag(userId, roleId, petId, "POnPlayerDeletePet");
/*    */     
/* 25 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mounts\main\POnPlayerDeletePet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */