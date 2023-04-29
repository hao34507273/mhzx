/*    */ package mzm.gsp.market.event;
/*    */ 
/*    */ 
/*    */ public class BuyPetArg
/*    */ {
/*    */   public final long roleid;
/*    */   
/*    */   public final long petId;
/*    */   public final int petCfgId;
/*    */   public final int price;
/*    */   
/*    */   public BuyPetArg(long roleid, long petId, int petCfgId, int price)
/*    */   {
/* 14 */     this.roleid = roleid;
/* 15 */     this.petId = petId;
/* 16 */     this.petCfgId = petCfgId;
/* 17 */     this.price = price;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\event\BuyPetArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */