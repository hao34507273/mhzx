/*    */ package mzm.gsp.baitan;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class PageInfo implements Marshal
/*    */ {
/*    */   public int pageindex;
/*    */   public int totalpagenum;
/*    */   public int subtype;
/*    */   public int param;
/*    */   public ArrayList<ShoppingItem> shoppingitemlist;
/*    */   
/*    */   public PageInfo()
/*    */   {
/* 18 */     this.shoppingitemlist = new ArrayList();
/*    */   }
/*    */   
/*    */   public PageInfo(int _pageindex_, int _totalpagenum_, int _subtype_, int _param_, ArrayList<ShoppingItem> _shoppingitemlist_) {
/* 22 */     this.pageindex = _pageindex_;
/* 23 */     this.totalpagenum = _totalpagenum_;
/* 24 */     this.subtype = _subtype_;
/* 25 */     this.param = _param_;
/* 26 */     this.shoppingitemlist = _shoppingitemlist_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 30 */     for (ShoppingItem _v_ : this.shoppingitemlist)
/* 31 */       if (!_v_._validator_()) return false;
/* 32 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 36 */     _os_.marshal(this.pageindex);
/* 37 */     _os_.marshal(this.totalpagenum);
/* 38 */     _os_.marshal(this.subtype);
/* 39 */     _os_.marshal(this.param);
/* 40 */     _os_.compact_uint32(this.shoppingitemlist.size());
/* 41 */     for (ShoppingItem _v_ : this.shoppingitemlist) {
/* 42 */       _os_.marshal(_v_);
/*    */     }
/* 44 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 48 */     this.pageindex = _os_.unmarshal_int();
/* 49 */     this.totalpagenum = _os_.unmarshal_int();
/* 50 */     this.subtype = _os_.unmarshal_int();
/* 51 */     this.param = _os_.unmarshal_int();
/* 52 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 53 */       ShoppingItem _v_ = new ShoppingItem();
/* 54 */       _v_.unmarshal(_os_);
/* 55 */       this.shoppingitemlist.add(_v_);
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof PageInfo)) {
/* 63 */       PageInfo _o_ = (PageInfo)_o1_;
/* 64 */       if (this.pageindex != _o_.pageindex) return false;
/* 65 */       if (this.totalpagenum != _o_.totalpagenum) return false;
/* 66 */       if (this.subtype != _o_.subtype) return false;
/* 67 */       if (this.param != _o_.param) return false;
/* 68 */       if (!this.shoppingitemlist.equals(_o_.shoppingitemlist)) return false;
/* 69 */       return true;
/*    */     }
/* 71 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 75 */     int _h_ = 0;
/* 76 */     _h_ += this.pageindex;
/* 77 */     _h_ += this.totalpagenum;
/* 78 */     _h_ += this.subtype;
/* 79 */     _h_ += this.param;
/* 80 */     _h_ += this.shoppingitemlist.hashCode();
/* 81 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 85 */     StringBuilder _sb_ = new StringBuilder();
/* 86 */     _sb_.append("(");
/* 87 */     _sb_.append(this.pageindex).append(",");
/* 88 */     _sb_.append(this.totalpagenum).append(",");
/* 89 */     _sb_.append(this.subtype).append(",");
/* 90 */     _sb_.append(this.param).append(",");
/* 91 */     _sb_.append(this.shoppingitemlist).append(",");
/* 92 */     _sb_.append(")");
/* 93 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\baitan\PageInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */