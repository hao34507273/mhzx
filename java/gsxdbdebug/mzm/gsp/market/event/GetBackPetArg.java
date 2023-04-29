/*    */ package mzm.gsp.market.event;
/*    */ 
/*    */ public class GetBackPetArg
/*    */ {
/*    */   public final long roleid;
/*    */   public final long petId;
/*    */   public final int petCfgId;
/*    */   
/*    */   public GetBackPetArg(long roleid, long petId, int petCfgId)
/*    */   {
/* 11 */     this.roleid = roleid;
/* 12 */     this.petId = petId;
/* 13 */     this.petCfgId = petCfgId;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\event\GetBackPetArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */