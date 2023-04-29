/*    */ package mzm.gsp.pet.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.event.TriggerEventsManger;
/*    */ import mzm.gsp.children.main.ChildrenInterface;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.pet.SSyncPetStateChange;
/*    */ import mzm.gsp.pet.event.PetEventArg;
/*    */ import mzm.gsp.pet.event.PlayerShowPetChange;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.Pet;
/*    */ import xbean.PetBag;
/*    */ import xtable.Role2petbag;
/*    */ 
/*    */ public class PShowPet
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long petId;
/*    */   private final long roleId;
/*    */   
/*    */   public PShowPet(long petId, long roleId)
/*    */   {
/* 25 */     this.petId = petId;
/* 26 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 32 */     PetBag xPetBag = Role2petbag.get(Long.valueOf(this.roleId));
/* 33 */     if (xPetBag == null) {
/* 34 */       return false;
/*    */     }
/* 36 */     Pet xPet = (Pet)xPetBag.getPetmap().get(Long.valueOf(this.petId));
/* 37 */     if (xPet == null) {
/* 38 */       return false;
/*    */     }
/* 40 */     PetCfg petCfg = PetManager.getInstance().getPetCfg(xPet.getTemplateid());
/* 41 */     if (petCfg == null) {
/* 42 */       return false;
/*    */     }
/* 44 */     if (petCfg.getCarrayLevel() > RoleInterface.getLevel(this.roleId)) {
/* 45 */       return false;
/*    */     }
/*    */     
/* 48 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 18, true)) {
/* 49 */       return false;
/*    */     }
/* 51 */     long oldShowPet = xPetBag.getShowpet();
/* 52 */     xPetBag.setShowpet(this.petId);
/*    */     
/* 54 */     ChildrenInterface.hideChild(this.roleId, false);
/*    */     
/* 56 */     if (xPetBag.getPetmap().containsKey(Long.valueOf(oldShowPet))) {
/* 57 */       SSyncPetStateChange sSyncPetStateChange = new SSyncPetStateChange();
/* 58 */       sSyncPetStateChange.petid = oldShowPet;
/* 59 */       sSyncPetStateChange.state = 3;
/*    */     }
/*    */     
/* 62 */     SSyncPetStateChange sSyncPetStateChange = new SSyncPetStateChange();
/* 63 */     sSyncPetStateChange.petid = this.petId;
/* 64 */     sSyncPetStateChange.state = 1;
/* 65 */     OnlineManager.getInstance().send(this.roleId, sSyncPetStateChange);
/*    */     
/* 67 */     PlayerShowPetChange change = new PlayerShowPetChange();
/* 68 */     PetEventArg arg = new PetEventArg();
/* 69 */     arg.roleId = this.roleId;
/* 70 */     arg.petId = this.petId;
/* 71 */     TriggerEventsManger.getInstance().triggerEvent(change, arg);
/*    */     
/* 73 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\PShowPet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */