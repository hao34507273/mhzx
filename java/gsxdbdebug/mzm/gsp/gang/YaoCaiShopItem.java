/*    */ package mzm.gsp.gang;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ public class YaoCaiShopItem
/*    */   implements Marshal, Comparable<YaoCaiShopItem>
/*    */ {
/*    */   public int itemid;
/*    */   public int itemnum;
/*    */   
/*    */   public YaoCaiShopItem() {}
/*    */   
/*    */   public YaoCaiShopItem(int _itemid_, int _itemnum_)
/*    */   {
/* 18 */     this.itemid = _itemid_;
/* 19 */     this.itemnum = _itemnum_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 23 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 27 */     _os_.marshal(this.itemid);
/* 28 */     _os_.marshal(this.itemnum);
/* 29 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 33 */     this.itemid = _os_.unmarshal_int();
/* 34 */     this.itemnum = _os_.unmarshal_int();
/* 35 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 39 */     if (_o1_ == this) return true;
/* 40 */     if ((_o1_ instanceof YaoCaiShopItem)) {
/* 41 */       YaoCaiShopItem _o_ = (YaoCaiShopItem)_o1_;
/* 42 */       if (this.itemid != _o_.itemid) return false;
/* 43 */       if (this.itemnum != _o_.itemnum) return false;
/* 44 */       return true;
/*    */     }
/* 46 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 50 */     int _h_ = 0;
/* 51 */     _h_ += this.itemid;
/* 52 */     _h_ += this.itemnum;
/* 53 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 57 */     StringBuilder _sb_ = new StringBuilder();
/* 58 */     _sb_.append("(");
/* 59 */     _sb_.append(this.itemid).append(",");
/* 60 */     _sb_.append(this.itemnum).append(",");
/* 61 */     _sb_.append(")");
/* 62 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(YaoCaiShopItem _o_) {
/* 66 */     if (_o_ == this) return 0;
/* 67 */     int _c_ = 0;
/* 68 */     _c_ = this.itemid - _o_.itemid;
/* 69 */     if (0 != _c_) return _c_;
/* 70 */     _c_ = this.itemnum - _o_.itemnum;
/* 71 */     if (0 != _c_) return _c_;
/* 72 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\YaoCaiShopItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */