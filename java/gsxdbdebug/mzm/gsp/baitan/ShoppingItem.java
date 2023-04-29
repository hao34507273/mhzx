/*    */ package mzm.gsp.baitan;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ public class ShoppingItem
/*    */   implements Marshal, Comparable<ShoppingItem>
/*    */ {
/*    */   public int index;
/*    */   public int itemid;
/*    */   public int num;
/*    */   public int price;
/*    */   public int isneed;
/*    */   
/*    */   public ShoppingItem() {}
/*    */   
/*    */   public ShoppingItem(int _index_, int _itemid_, int _num_, int _price_, int _isneed_)
/*    */   {
/* 21 */     this.index = _index_;
/* 22 */     this.itemid = _itemid_;
/* 23 */     this.num = _num_;
/* 24 */     this.price = _price_;
/* 25 */     this.isneed = _isneed_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 29 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 33 */     _os_.marshal(this.index);
/* 34 */     _os_.marshal(this.itemid);
/* 35 */     _os_.marshal(this.num);
/* 36 */     _os_.marshal(this.price);
/* 37 */     _os_.marshal(this.isneed);
/* 38 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 42 */     this.index = _os_.unmarshal_int();
/* 43 */     this.itemid = _os_.unmarshal_int();
/* 44 */     this.num = _os_.unmarshal_int();
/* 45 */     this.price = _os_.unmarshal_int();
/* 46 */     this.isneed = _os_.unmarshal_int();
/* 47 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 51 */     if (_o1_ == this) return true;
/* 52 */     if ((_o1_ instanceof ShoppingItem)) {
/* 53 */       ShoppingItem _o_ = (ShoppingItem)_o1_;
/* 54 */       if (this.index != _o_.index) return false;
/* 55 */       if (this.itemid != _o_.itemid) return false;
/* 56 */       if (this.num != _o_.num) return false;
/* 57 */       if (this.price != _o_.price) return false;
/* 58 */       if (this.isneed != _o_.isneed) return false;
/* 59 */       return true;
/*    */     }
/* 61 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 65 */     int _h_ = 0;
/* 66 */     _h_ += this.index;
/* 67 */     _h_ += this.itemid;
/* 68 */     _h_ += this.num;
/* 69 */     _h_ += this.price;
/* 70 */     _h_ += this.isneed;
/* 71 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 75 */     StringBuilder _sb_ = new StringBuilder();
/* 76 */     _sb_.append("(");
/* 77 */     _sb_.append(this.index).append(",");
/* 78 */     _sb_.append(this.itemid).append(",");
/* 79 */     _sb_.append(this.num).append(",");
/* 80 */     _sb_.append(this.price).append(",");
/* 81 */     _sb_.append(this.isneed).append(",");
/* 82 */     _sb_.append(")");
/* 83 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(ShoppingItem _o_) {
/* 87 */     if (_o_ == this) return 0;
/* 88 */     int _c_ = 0;
/* 89 */     _c_ = this.index - _o_.index;
/* 90 */     if (0 != _c_) return _c_;
/* 91 */     _c_ = this.itemid - _o_.itemid;
/* 92 */     if (0 != _c_) return _c_;
/* 93 */     _c_ = this.num - _o_.num;
/* 94 */     if (0 != _c_) return _c_;
/* 95 */     _c_ = this.price - _o_.price;
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     _c_ = this.isneed - _o_.isneed;
/* 98 */     if (0 != _c_) return _c_;
/* 99 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\baitan\ShoppingItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */