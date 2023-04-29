/*    */ package mzm.gsp.pet.event;
/*    */ 
/*    */ 
/*    */ public class PetMallBuyEventArg
/*    */ {
/*    */   public final long roleId;
/*    */   
/*    */   public final int petCfgId;
/*    */   public final long petId;
/*    */   
/*    */   public PetMallBuyEventArg(long roleId, int petCfgId, long petId)
/*    */   {
/* 13 */     this.roleId = roleId;
/* 14 */     this.petCfgId = petCfgId;
/* 15 */     this.petId = petId;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\event\PetMallBuyEventArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */