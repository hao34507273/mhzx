/*    */ package mzm.gsp.pet.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.Pet;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class petaddPoint
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long role;
/*    */   private final int point;
/*    */   
/*    */   public petaddPoint(long role, int point)
/*    */   {
/* 17 */     this.role = role;
/* 18 */     this.point = point;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception {
/* 22 */     long fightPetId = PetInterface.getFightPetId(this.role);
/* 23 */     Pet xPet = PetInterface.getXPetById(this.role, fightPetId, true);
/* 24 */     PetOutFightObj pet = PetInterface.getPetOutFightObjById(this.role, fightPetId);
/* 25 */     if (xPet == null) {
/* 26 */       return false;
/*    */     }
/* 28 */     int potentialpoint = xPet.getPotentialpoint();
/* 29 */     potentialpoint += this.point;
/* 30 */     xPet.setPotentialpoint(potentialpoint);
/* 31 */     pet.syncPetInfo();
/* 32 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\petaddPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */