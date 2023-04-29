/*    */ package mzm.gsp.pet.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.pet.SSyncPetStateChange;
/*    */ import xbean.Pet;
/*    */ import xbean.PetDepot;
/*    */ 
/*    */ public class PGM_ClearPetBag extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public PGM_ClearPetBag(long roleid)
/*    */   {
/* 15 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 20 */     xbean.PetBag xPetBag = xtable.Role2petbag.get(Long.valueOf(this.roleid));
/* 21 */     PetDepot xPetDepot = xtable.Role2petdepot.get(Long.valueOf(this.roleid));
/* 22 */     if (xPetBag != null) {
/* 23 */       for (Pet xPet : xPetBag.getPetmap().values()) {
/* 24 */         SSyncPetStateChange change = new SSyncPetStateChange();
/* 25 */         change.petid = xPet.getId();
/* 26 */         change.state = 2;
/* 27 */         OnlineManager.getInstance().send(this.roleid, change);
/*    */       }
/* 29 */       xPetBag.getPetmap().clear();
/*    */     }
/*    */     
/* 32 */     if (xPetDepot != null) {
/* 33 */       for (Pet xPet : xPetDepot.getPetmap().values()) {
/* 34 */         SSyncPetStateChange change = new SSyncPetStateChange();
/* 35 */         change.petid = xPet.getId();
/* 36 */         change.state = 2;
/* 37 */         OnlineManager.getInstance().send(this.roleid, change);
/*    */       }
/* 39 */       xPetDepot.getPetmap().clear();
/*    */     }
/* 41 */     xtable.Role2petoutfightbean.remove(Long.valueOf(this.roleid));
/* 42 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\PGM_ClearPetBag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */