/*    */ package mzm.gsp.baitan;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.item.ItemInfo;
/*    */ 
/*    */ public class MyShoppingItem
/*    */   implements Marshal
/*    */ {
/*    */   public static final int STATE_SELL = 0;
/*    */   public static final int STATE_SELLED = 1;
/*    */   public static final int STATE_EXPIRE = 2;
/*    */   public long shoppingid;
/*    */   public ItemInfo item;
/*    */   public int price;
/*    */   public int sellnum;
/*    */   public int state;
/*    */   
/*    */   public MyShoppingItem()
/*    */   {
/* 22 */     this.item = new ItemInfo();
/*    */   }
/*    */   
/*    */   public MyShoppingItem(long _shoppingid_, ItemInfo _item_, int _price_, int _sellnum_, int _state_) {
/* 26 */     this.shoppingid = _shoppingid_;
/* 27 */     this.item = _item_;
/* 28 */     this.price = _price_;
/* 29 */     this.sellnum = _sellnum_;
/* 30 */     this.state = _state_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 34 */     if (!this.item._validator_()) return false;
/* 35 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 39 */     _os_.marshal(this.shoppingid);
/* 40 */     _os_.marshal(this.item);
/* 41 */     _os_.marshal(this.price);
/* 42 */     _os_.marshal(this.sellnum);
/* 43 */     _os_.marshal(this.state);
/* 44 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 48 */     this.shoppingid = _os_.unmarshal_long();
/* 49 */     this.item.unmarshal(_os_);
/* 50 */     this.price = _os_.unmarshal_int();
/* 51 */     this.sellnum = _os_.unmarshal_int();
/* 52 */     this.state = _os_.unmarshal_int();
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 57 */     if (_o1_ == this) return true;
/* 58 */     if ((_o1_ instanceof MyShoppingItem)) {
/* 59 */       MyShoppingItem _o_ = (MyShoppingItem)_o1_;
/* 60 */       if (this.shoppingid != _o_.shoppingid) return false;
/* 61 */       if (!this.item.equals(_o_.item)) return false;
/* 62 */       if (this.price != _o_.price) return false;
/* 63 */       if (this.sellnum != _o_.sellnum) return false;
/* 64 */       if (this.state != _o_.state) return false;
/* 65 */       return true;
/*    */     }
/* 67 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 71 */     int _h_ = 0;
/* 72 */     _h_ += (int)this.shoppingid;
/* 73 */     _h_ += this.item.hashCode();
/* 74 */     _h_ += this.price;
/* 75 */     _h_ += this.sellnum;
/* 76 */     _h_ += this.state;
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.shoppingid).append(",");
/* 84 */     _sb_.append(this.item).append(",");
/* 85 */     _sb_.append(this.price).append(",");
/* 86 */     _sb_.append(this.sellnum).append(",");
/* 87 */     _sb_.append(this.state).append(",");
/* 88 */     _sb_.append(")");
/* 89 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\baitan\MyShoppingItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */