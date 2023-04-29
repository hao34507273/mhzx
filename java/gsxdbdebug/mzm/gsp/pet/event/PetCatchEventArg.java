/*    */ package mzm.gsp.pet.event;
/*    */ 
/*    */ 
/*    */ public class PetCatchEventArg
/*    */ {
/*    */   public final long roleId;
/*    */   public final int petCfgId;
/*    */   public final int petLevel;
/*    */   public final boolean isCatched;
/*    */   
/*    */   public PetCatchEventArg(long roleId, int petCfgId, int petLevel)
/*    */   {
/* 13 */     this.roleId = roleId;
/* 14 */     this.petCfgId = petCfgId;
/* 15 */     this.petLevel = petLevel;
/* 16 */     this.isCatched = true;
/*    */   }
/*    */   
/*    */   public PetCatchEventArg(long roleId, int petCfgId, int petLevel, boolean isSuccess) {
/* 20 */     this.roleId = roleId;
/* 21 */     this.petCfgId = petCfgId;
/* 22 */     this.petLevel = petLevel;
/* 23 */     this.isCatched = isSuccess;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\event\PetCatchEventArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */