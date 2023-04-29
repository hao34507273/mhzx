/*    */ package mzm.gsp.pet.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.Pet;
/*    */ import xtable.Role2petdepot;
/*    */ 
/*    */ 
/*    */ public class PetDepot
/*    */ {
/*    */   private long roleId;
/*    */   private xbean.PetDepot xPetDepot;
/*    */   
/*    */   public PetDepot(long roleId, boolean retrantLock)
/*    */   {
/* 15 */     this.roleId = roleId;
/* 16 */     if (retrantLock) {
/* 17 */       this.xPetDepot = Role2petdepot.get(Long.valueOf(roleId));
/*    */     } else {
/* 19 */       this.xPetDepot = Role2petdepot.select(Long.valueOf(roleId));
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public Pet removePet(int pos)
/*    */   {
/* 29 */     return (Pet)this.xPetDepot.getPetmap().remove(Integer.valueOf(pos));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getDepotSize()
/*    */   {
/* 37 */     return this.xPetDepot.getDepotsize();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public int getPetSize()
/*    */   {
/* 44 */     return this.xPetDepot.getPetmap().size();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\PetDepot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */