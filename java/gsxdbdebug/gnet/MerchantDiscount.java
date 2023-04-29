/*    */ package gnet;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class MerchantDiscount implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public int id;
/*    */   public com.goldhuman.Common.Octets name;
/*    */   public int reserved;
/*    */   public ArrayList<DiscountGrade> discount;
/*    */   
/*    */   public MerchantDiscount()
/*    */   {
/* 15 */     this.name = new com.goldhuman.Common.Octets();
/* 16 */     this.discount = new ArrayList();
/*    */   }
/*    */   
/*    */   public MerchantDiscount(int _id_, com.goldhuman.Common.Octets _name_, int _reserved_, ArrayList<DiscountGrade> _discount_) {
/* 20 */     this.id = _id_;
/* 21 */     this.name = _name_;
/* 22 */     this.reserved = _reserved_;
/* 23 */     this.discount = _discount_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 27 */     for (DiscountGrade _v_ : this.discount)
/* 28 */       if (!_v_._validator_()) return false;
/* 29 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 33 */     _os_.marshal(this.id);
/* 34 */     _os_.marshal(this.name);
/* 35 */     _os_.marshal(this.reserved);
/* 36 */     _os_.compact_uint32(this.discount.size());
/* 37 */     for (DiscountGrade _v_ : this.discount) {
/* 38 */       _os_.marshal(_v_);
/*    */     }
/* 40 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 44 */     this.id = _os_.unmarshal_int();
/* 45 */     this.name = _os_.unmarshal_Octets();
/* 46 */     this.reserved = _os_.unmarshal_int();
/* 47 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 48 */       DiscountGrade _v_ = new DiscountGrade();
/* 49 */       _v_.unmarshal(_os_);
/* 50 */       this.discount.add(_v_);
/*    */     }
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 56 */     if (_o1_ == this) return true;
/* 57 */     if ((_o1_ instanceof MerchantDiscount)) {
/* 58 */       MerchantDiscount _o_ = (MerchantDiscount)_o1_;
/* 59 */       if (this.id != _o_.id) return false;
/* 60 */       if (!this.name.equals(_o_.name)) return false;
/* 61 */       if (this.reserved != _o_.reserved) return false;
/* 62 */       if (!this.discount.equals(_o_.discount)) return false;
/* 63 */       return true;
/*    */     }
/* 65 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 69 */     int _h_ = 0;
/* 70 */     _h_ += this.id;
/* 71 */     _h_ += this.name.hashCode();
/* 72 */     _h_ += this.reserved;
/* 73 */     _h_ += this.discount.hashCode();
/* 74 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 78 */     StringBuilder _sb_ = new StringBuilder();
/* 79 */     _sb_.append("(");
/* 80 */     _sb_.append(this.id).append(",");
/* 81 */     _sb_.append("B").append(this.name.size()).append(",");
/* 82 */     _sb_.append(this.reserved).append(",");
/* 83 */     _sb_.append(this.discount).append(",");
/* 84 */     _sb_.append(")");
/* 85 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\gnet\MerchantDiscount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */