/*    */ package mzm.gsp.baitan;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SSyncMyShopingItem
/*    */   extends __SSyncMyShopingItem__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12584987;
/*    */   public int shopgridsize;
/*    */   public ArrayList<MyShoppingItem> myshoppingitemlist;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12584987;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SSyncMyShopingItem()
/*    */   {
/* 34 */     this.myshoppingitemlist = new ArrayList();
/*    */   }
/*    */   
/*    */   public SSyncMyShopingItem(int _shopgridsize_, ArrayList<MyShoppingItem> _myshoppingitemlist_) {
/* 38 */     this.shopgridsize = _shopgridsize_;
/* 39 */     this.myshoppingitemlist = _myshoppingitemlist_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     for (MyShoppingItem _v_ : this.myshoppingitemlist)
/* 44 */       if (!_v_._validator_()) return false;
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.shopgridsize);
/* 50 */     _os_.compact_uint32(this.myshoppingitemlist.size());
/* 51 */     for (MyShoppingItem _v_ : this.myshoppingitemlist) {
/* 52 */       _os_.marshal(_v_);
/*    */     }
/* 54 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 58 */     this.shopgridsize = _os_.unmarshal_int();
/* 59 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 60 */       MyShoppingItem _v_ = new MyShoppingItem();
/* 61 */       _v_.unmarshal(_os_);
/* 62 */       this.myshoppingitemlist.add(_v_);
/*    */     }
/* 64 */     if (!_validator_()) {
/* 65 */       throw new VerifyError("validator failed");
/*    */     }
/* 67 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 71 */     if (_o1_ == this) return true;
/* 72 */     if ((_o1_ instanceof SSyncMyShopingItem)) {
/* 73 */       SSyncMyShopingItem _o_ = (SSyncMyShopingItem)_o1_;
/* 74 */       if (this.shopgridsize != _o_.shopgridsize) return false;
/* 75 */       if (!this.myshoppingitemlist.equals(_o_.myshoppingitemlist)) return false;
/* 76 */       return true;
/*    */     }
/* 78 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 82 */     int _h_ = 0;
/* 83 */     _h_ += this.shopgridsize;
/* 84 */     _h_ += this.myshoppingitemlist.hashCode();
/* 85 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 89 */     StringBuilder _sb_ = new StringBuilder();
/* 90 */     _sb_.append("(");
/* 91 */     _sb_.append(this.shopgridsize).append(",");
/* 92 */     _sb_.append(this.myshoppingitemlist).append(",");
/* 93 */     _sb_.append(")");
/* 94 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\baitan\SSyncMyShopingItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */