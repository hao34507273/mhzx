/*    */ package mzm.gsp.pet.main;
/*    */ 
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.pet.SGetPetItemLimitRes;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.Pet;
/*    */ import xbean.PetBag;
/*    */ import xtable.Role2petbag;
/*    */ 
/*    */ public class PCGetPetItemLimitReq extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final long petId;
/*    */   
/*    */   public PCGetPetItemLimitReq(long roleId, long petId)
/*    */   {
/* 17 */     this.roleId = roleId;
/* 18 */     this.petId = petId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 25 */     PetBag xPetBag = Role2petbag.get(Long.valueOf(this.roleId));
/* 26 */     if (xPetBag == null) {
/* 27 */       return false;
/*    */     }
/* 29 */     Pet xPet = (Pet)xPetBag.getPetmap().get(Long.valueOf(this.petId));
/* 30 */     if (xPet == null) {
/* 31 */       return false;
/*    */     }
/*    */     
/* 34 */     PetCfg petCfg = PetInterface.getPetCfgByCfgId(xPet.getTemplateid());
/* 35 */     if (petCfg == null) {
/* 36 */       return false;
/*    */     }
/*    */     
/* 39 */     SGetPetItemLimitRes sGetPetItemLimitRes = new SGetPetItemLimitRes();
/* 40 */     sGetPetItemLimitRes.petid = this.petId;
/* 41 */     if (xPet.getLianguitemusenum() <= petCfg.getLianguItemLimit()) {
/* 42 */       sGetPetItemLimitRes.lianguitemleft = (petCfg.getLianguItemLimit() - xPet.getLianguitemusenum());
/*    */     } else {
/* 44 */       sGetPetItemLimitRes.lianguitemleft = 0;
/*    */     }
/* 46 */     if (xPet.getGrowitemusenum() <= petCfg.getGrowItemLimit()) {
/* 47 */       sGetPetItemLimitRes.growitemleft = (petCfg.getGrowItemLimit() - xPet.getGrowitemusenum());
/*    */     } else {
/* 49 */       sGetPetItemLimitRes.growitemleft = 0;
/*    */     }
/* 51 */     OnlineManager.getInstance().send(this.roleId, sGetPetItemLimitRes);
/* 52 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\PCGetPetItemLimitReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */