/*    */ package mzm.gsp.market;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class AuctionItem implements Marshal, Comparable<AuctionItem>
/*    */ {
/*    */   public MarketItem marketitem;
/*    */   public int ismaxprice;
/*    */   
/*    */   public AuctionItem()
/*    */   {
/* 13 */     this.marketitem = new MarketItem();
/*    */   }
/*    */   
/*    */   public AuctionItem(MarketItem _marketitem_, int _ismaxprice_) {
/* 17 */     this.marketitem = _marketitem_;
/* 18 */     this.ismaxprice = _ismaxprice_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 22 */     if (!this.marketitem._validator_()) return false;
/* 23 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 27 */     _os_.marshal(this.marketitem);
/* 28 */     _os_.marshal(this.ismaxprice);
/* 29 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 33 */     this.marketitem.unmarshal(_os_);
/* 34 */     this.ismaxprice = _os_.unmarshal_int();
/* 35 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 39 */     if (_o1_ == this) return true;
/* 40 */     if ((_o1_ instanceof AuctionItem)) {
/* 41 */       AuctionItem _o_ = (AuctionItem)_o1_;
/* 42 */       if (!this.marketitem.equals(_o_.marketitem)) return false;
/* 43 */       if (this.ismaxprice != _o_.ismaxprice) return false;
/* 44 */       return true;
/*    */     }
/* 46 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 50 */     int _h_ = 0;
/* 51 */     _h_ += this.marketitem.hashCode();
/* 52 */     _h_ += this.ismaxprice;
/* 53 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 57 */     StringBuilder _sb_ = new StringBuilder();
/* 58 */     _sb_.append("(");
/* 59 */     _sb_.append(this.marketitem).append(",");
/* 60 */     _sb_.append(this.ismaxprice).append(",");
/* 61 */     _sb_.append(")");
/* 62 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(AuctionItem _o_) {
/* 66 */     if (_o_ == this) return 0;
/* 67 */     int _c_ = 0;
/* 68 */     _c_ = this.marketitem.compareTo(_o_.marketitem);
/* 69 */     if (0 != _c_) return _c_;
/* 70 */     _c_ = this.ismaxprice - _o_.ismaxprice;
/* 71 */     if (0 != _c_) return _c_;
/* 72 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\AuctionItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */