/*    */ package mzm.gsp.market;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class AuctionPet implements Marshal, Comparable<AuctionPet>
/*    */ {
/*    */   public MarketPet marketpet;
/*    */   public int ismaxprice;
/*    */   
/*    */   public AuctionPet()
/*    */   {
/* 13 */     this.marketpet = new MarketPet();
/*    */   }
/*    */   
/*    */   public AuctionPet(MarketPet _marketpet_, int _ismaxprice_) {
/* 17 */     this.marketpet = _marketpet_;
/* 18 */     this.ismaxprice = _ismaxprice_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 22 */     if (!this.marketpet._validator_()) return false;
/* 23 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 27 */     _os_.marshal(this.marketpet);
/* 28 */     _os_.marshal(this.ismaxprice);
/* 29 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 33 */     this.marketpet.unmarshal(_os_);
/* 34 */     this.ismaxprice = _os_.unmarshal_int();
/* 35 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 39 */     if (_o1_ == this) return true;
/* 40 */     if ((_o1_ instanceof AuctionPet)) {
/* 41 */       AuctionPet _o_ = (AuctionPet)_o1_;
/* 42 */       if (!this.marketpet.equals(_o_.marketpet)) return false;
/* 43 */       if (this.ismaxprice != _o_.ismaxprice) return false;
/* 44 */       return true;
/*    */     }
/* 46 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 50 */     int _h_ = 0;
/* 51 */     _h_ += this.marketpet.hashCode();
/* 52 */     _h_ += this.ismaxprice;
/* 53 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 57 */     StringBuilder _sb_ = new StringBuilder();
/* 58 */     _sb_.append("(");
/* 59 */     _sb_.append(this.marketpet).append(",");
/* 60 */     _sb_.append(this.ismaxprice).append(",");
/* 61 */     _sb_.append(")");
/* 62 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(AuctionPet _o_) {
/* 66 */     if (_o_ == this) return 0;
/* 67 */     int _c_ = 0;
/* 68 */     _c_ = this.marketpet.compareTo(_o_.marketpet);
/* 69 */     if (0 != _c_) return _c_;
/* 70 */     _c_ = this.ismaxprice - _o_.ismaxprice;
/* 71 */     if (0 != _c_) return _c_;
/* 72 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\AuctionPet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */