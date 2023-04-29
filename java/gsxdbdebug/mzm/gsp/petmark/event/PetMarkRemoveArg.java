/*    */ package mzm.gsp.petmark.event;
/*    */ 
/*    */ import mzm.gsp.petmark.main.PetMarkManager.RemovePetMarkReason;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PetMarkRemoveArg
/*    */ {
/*    */   public final long roleId;
/*    */   public final long petMarkId;
/*    */   public final PetMarkManager.RemovePetMarkReason reason;
/*    */   
/*    */   public PetMarkRemoveArg(long roleId, long petMarkId, PetMarkManager.RemovePetMarkReason reason)
/*    */   {
/* 16 */     this.roleId = roleId;
/* 17 */     this.petMarkId = petMarkId;
/* 18 */     this.reason = reason;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petmark\event\PetMarkRemoveArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */