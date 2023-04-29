/*    */ package mzm.gsp.mall.event;
/*    */ 
/*    */ 
/*    */ public class BuyItemArg
/*    */ {
/*    */   public final long roleId;
/*    */   public final int itemId;
/*    */   public final int num;
/*    */   public final int price;
/*    */   public final int malltype;
/*    */   
/*    */   public BuyItemArg(long roleId, int itemId, int num, int price, int malltype)
/*    */   {
/* 14 */     this.roleId = roleId;
/* 15 */     this.itemId = itemId;
/* 16 */     this.num = num;
/* 17 */     this.price = price;
/* 18 */     this.malltype = malltype;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mall\event\BuyItemArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */