/*    */ package mzm.gsp.petmark.event;
/*    */ 
/*    */ public class PetMarkAddArg
/*    */ {
/*    */   public final long roleId;
/*    */   public final long petMarkId;
/*    */   public final long petMarkCfgId;
/*    */   public final long petMarkLevel;
/*    */   
/*    */   public PetMarkAddArg(long roleId, long petMarkId, long petMarkCfgId, long petMarkLevel)
/*    */   {
/* 12 */     this.roleId = roleId;
/* 13 */     this.petMarkId = petMarkId;
/* 14 */     this.petMarkCfgId = petMarkCfgId;
/* 15 */     this.petMarkLevel = petMarkLevel;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petmark\event\PetMarkAddArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */