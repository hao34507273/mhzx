/*    */ package mzm.gsp.market.event;
/*    */ 
/*    */ public class SellPetArg
/*    */ {
/*    */   public final long roleid;
/*    */   public final long petId;
/*    */   public final int petCfgId;
/*    */   public final int price;
/*    */   
/*    */   public SellPetArg(long roleid, long petId, int petCfgId, int price)
/*    */   {
/* 12 */     this.roleid = roleid;
/* 13 */     this.petId = petId;
/* 14 */     this.petCfgId = petCfgId;
/* 15 */     this.price = price;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\event\SellPetArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */