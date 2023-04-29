/*    */ package gnet;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ public class DiscountGrade implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public int amount_begin;
/*    */   public int discount;
/*    */   public int reserved1;
/*    */   public Octets reserved2;
/*    */   
/*    */   public DiscountGrade()
/*    */   {
/* 15 */     this.reserved2 = new Octets();
/*    */   }
/*    */   
/*    */   public DiscountGrade(int _amount_begin_, int _discount_, int _reserved1_, Octets _reserved2_) {
/* 19 */     this.amount_begin = _amount_begin_;
/* 20 */     this.discount = _discount_;
/* 21 */     this.reserved1 = _reserved1_;
/* 22 */     this.reserved2 = _reserved2_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 26 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 30 */     _os_.marshal(this.amount_begin);
/* 31 */     _os_.marshal(this.discount);
/* 32 */     _os_.marshal(this.reserved1);
/* 33 */     _os_.marshal(this.reserved2);
/* 34 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 38 */     this.amount_begin = _os_.unmarshal_int();
/* 39 */     this.discount = _os_.unmarshal_int();
/* 40 */     this.reserved1 = _os_.unmarshal_int();
/* 41 */     this.reserved2 = _os_.unmarshal_Octets();
/* 42 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 46 */     if (_o1_ == this) return true;
/* 47 */     if ((_o1_ instanceof DiscountGrade)) {
/* 48 */       DiscountGrade _o_ = (DiscountGrade)_o1_;
/* 49 */       if (this.amount_begin != _o_.amount_begin) return false;
/* 50 */       if (this.discount != _o_.discount) return false;
/* 51 */       if (this.reserved1 != _o_.reserved1) return false;
/* 52 */       if (!this.reserved2.equals(_o_.reserved2)) return false;
/* 53 */       return true;
/*    */     }
/* 55 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 59 */     int _h_ = 0;
/* 60 */     _h_ += this.amount_begin;
/* 61 */     _h_ += this.discount;
/* 62 */     _h_ += this.reserved1;
/* 63 */     _h_ += this.reserved2.hashCode();
/* 64 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 68 */     StringBuilder _sb_ = new StringBuilder();
/* 69 */     _sb_.append("(");
/* 70 */     _sb_.append(this.amount_begin).append(",");
/* 71 */     _sb_.append(this.discount).append(",");
/* 72 */     _sb_.append(this.reserved1).append(",");
/* 73 */     _sb_.append("B").append(this.reserved2.size()).append(",");
/* 74 */     _sb_.append(")");
/* 75 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\gnet\DiscountGrade.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */