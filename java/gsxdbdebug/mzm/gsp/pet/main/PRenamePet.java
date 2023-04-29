/*    */ package mzm.gsp.pet.main;
/*    */ 
/*    */ import mzm.event.TriggerEventsManger;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.pet.SPetNormalResult;
/*    */ import mzm.gsp.pet.confbean.PetConstants;
/*    */ import mzm.gsp.pet.event.PetEventArg;
/*    */ import mzm.gsp.pet.event.PlayerPetRename;
/*    */ import mzm.gsp.server.main.AvailableStringArgs;
/*    */ import xbean.Pet;
/*    */ import xbean.PetBag;
/*    */ 
/*    */ public class PRenamePet extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long petId;
/*    */   private final long roleId;
/*    */   private final String name;
/*    */   
/*    */   public PRenamePet(long petId, long roleId, String name)
/*    */   {
/* 21 */     this.petId = petId;
/* 22 */     this.roleId = roleId;
/* 23 */     this.name = name.trim();
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 29 */     if (!PetManager.isPetSwitchOpenForRole(this.roleId)) {
/* 30 */       return false;
/*    */     }
/*    */     
/* 33 */     PetBag xPetBag = xtable.Role2petbag.get(Long.valueOf(this.roleId));
/* 34 */     if (xPetBag == null) {
/* 35 */       return false;
/*    */     }
/*    */     
/* 38 */     Pet xPet = (Pet)xPetBag.getPetmap().get(Long.valueOf(this.petId));
/* 39 */     if (xPet == null) {
/* 40 */       return false;
/*    */     }
/* 42 */     int length = (int)Math.ceil(mzm.gsp.util.CommonUtils.getUTF16Length(this.name) / 2.0D);
/* 43 */     if ((length < PetConstants.getInstance().MIN_PET_NAME_LEN) || (length > PetConstants.getInstance().MAX_PET_NAME_LEN))
/*    */     {
/* 45 */       SPetNormalResult renamePetProtocol = new SPetNormalResult();
/* 46 */       renamePetProtocol.result = 5;
/* 47 */       OnlineManager.getInstance().sendAtOnce(this.roleId, renamePetProtocol);
/* 48 */       return false;
/*    */     }
/* 50 */     if ((mzm.gsp.sensitive.main.SensitiveInterface.isNameSensitive(this.name)) || (!AvailableStringArgs.getInstance().isStringUsable(this.name)) || (this.name.matches("\\d+"))) {
/* 51 */       SPetNormalResult renamePetProtocol = new SPetNormalResult();
/* 52 */       renamePetProtocol.result = 4;
/* 53 */       OnlineManager.getInstance().sendAtOnce(this.roleId, renamePetProtocol);
/* 54 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 58 */     xPet.setPetname(this.name);
/*    */     
/* 60 */     PetOutFightObj pet = new PetOutFightObj(this.roleId, xPet);
/* 61 */     pet.syncPetInfo();
/*    */     
/* 63 */     SPetNormalResult result = new SPetNormalResult();
/* 64 */     result.result = 18;
/* 65 */     OnlineManager.getInstance().send(this.roleId, result);
/*    */     
/* 67 */     PlayerPetRename rename = new PlayerPetRename();
/* 68 */     PetEventArg arg = new PetEventArg();
/* 69 */     arg.petId = this.petId;
/* 70 */     arg.roleId = this.roleId;
/* 71 */     TriggerEventsManger.getInstance().triggerEvent(rename, arg);
/* 72 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\PRenamePet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */