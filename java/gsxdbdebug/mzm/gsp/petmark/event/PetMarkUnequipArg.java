/*    */ package mzm.gsp.petmark.event;
/*    */ 
/*    */ 
/*    */ public class PetMarkUnequipArg
/*    */ {
/*    */   public final long roleId;
/*    */   
/*    */   public final long petId;
/*    */   
/*    */   public final long petMarkId;
/*    */   
/*    */   public final int petMarkCfgId;
/*    */   
/*    */   public final int petMarkLevel;
/*    */   
/*    */ 
/*    */   public PetMarkUnequipArg(long roleId, long petId, long petMarkId, int petMarkCfgId, int petMarkLevel)
/*    */   {
/* 19 */     this.roleId = roleId;
/* 20 */     this.petId = petId;
/* 21 */     this.petMarkId = petMarkId;
/* 22 */     this.petMarkCfgId = petMarkCfgId;
/* 23 */     this.petMarkLevel = petMarkLevel;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petmark\event\PetMarkUnequipArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */