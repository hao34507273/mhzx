/*    */ package mzm.gsp.pet.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.event.TriggerEventsManger;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.pet.SSyncPetStateChange;
/*    */ import mzm.gsp.pet.event.PetEventArg;
/*    */ import mzm.gsp.pet.event.PlayerShowPetChange;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.Pet;
/*    */ import xbean.PetBag;
/*    */ import xtable.Role2petbag;
/*    */ 
/*    */ 
/*    */ public class PHideReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final long petId;
/*    */   
/*    */   public PHideReq(long roleId, long petId)
/*    */   {
/* 24 */     this.roleId = roleId;
/* 25 */     this.petId = petId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 32 */     PetBag xPetBag = Role2petbag.get(Long.valueOf(this.roleId));
/* 33 */     if (xPetBag == null)
/*    */     {
/* 35 */       return false;
/*    */     }
/* 37 */     Pet xPet = (Pet)xPetBag.getPetmap().get(Long.valueOf(this.petId));
/* 38 */     if (xPet == null)
/*    */     {
/* 40 */       return false;
/*    */     }
/* 42 */     if (xPetBag.getShowpet() != this.petId)
/*    */     {
/* 44 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 48 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 18, true))
/*    */     {
/* 50 */       return false;
/*    */     }
/*    */     
/* 53 */     xPetBag.setShowpet(-1L);
/* 54 */     SSyncPetStateChange sSyncPetStateChange = new SSyncPetStateChange();
/* 55 */     sSyncPetStateChange.petid = this.petId;
/* 56 */     sSyncPetStateChange.state = 4;
/* 57 */     OnlineManager.getInstance().send(this.roleId, sSyncPetStateChange);
/*    */     
/* 59 */     PlayerShowPetChange change = new PlayerShowPetChange();
/* 60 */     PetEventArg arg = new PetEventArg();
/* 61 */     arg.petId = this.petId;
/* 62 */     arg.roleId = this.roleId;
/* 63 */     TriggerEventsManger.getInstance().triggerEvent(change, arg);
/* 64 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\PHideReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */