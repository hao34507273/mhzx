/*     */ package mzm.gsp.market;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class MarketItem implements Marshal, Comparable<MarketItem>
/*     */ {
/*     */   public long marketid;
/*     */   public int itemid;
/*     */   public int price;
/*     */   public int restnum;
/*     */   public int sellnum;
/*     */   public int state;
/*     */   public int concernrolenum;
/*     */   public long publicendtime;
/*     */   
/*     */   public MarketItem() {}
/*     */   
/*     */   public MarketItem(long _marketid_, int _itemid_, int _price_, int _restnum_, int _sellnum_, int _state_, int _concernrolenum_, long _publicendtime_)
/*     */   {
/*  22 */     this.marketid = _marketid_;
/*  23 */     this.itemid = _itemid_;
/*  24 */     this.price = _price_;
/*  25 */     this.restnum = _restnum_;
/*  26 */     this.sellnum = _sellnum_;
/*  27 */     this.state = _state_;
/*  28 */     this.concernrolenum = _concernrolenum_;
/*  29 */     this.publicendtime = _publicendtime_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  33 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  37 */     _os_.marshal(this.marketid);
/*  38 */     _os_.marshal(this.itemid);
/*  39 */     _os_.marshal(this.price);
/*  40 */     _os_.marshal(this.restnum);
/*  41 */     _os_.marshal(this.sellnum);
/*  42 */     _os_.marshal(this.state);
/*  43 */     _os_.marshal(this.concernrolenum);
/*  44 */     _os_.marshal(this.publicendtime);
/*  45 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  49 */     this.marketid = _os_.unmarshal_long();
/*  50 */     this.itemid = _os_.unmarshal_int();
/*  51 */     this.price = _os_.unmarshal_int();
/*  52 */     this.restnum = _os_.unmarshal_int();
/*  53 */     this.sellnum = _os_.unmarshal_int();
/*  54 */     this.state = _os_.unmarshal_int();
/*  55 */     this.concernrolenum = _os_.unmarshal_int();
/*  56 */     this.publicendtime = _os_.unmarshal_long();
/*  57 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  61 */     if (_o1_ == this) return true;
/*  62 */     if ((_o1_ instanceof MarketItem)) {
/*  63 */       MarketItem _o_ = (MarketItem)_o1_;
/*  64 */       if (this.marketid != _o_.marketid) return false;
/*  65 */       if (this.itemid != _o_.itemid) return false;
/*  66 */       if (this.price != _o_.price) return false;
/*  67 */       if (this.restnum != _o_.restnum) return false;
/*  68 */       if (this.sellnum != _o_.sellnum) return false;
/*  69 */       if (this.state != _o_.state) return false;
/*  70 */       if (this.concernrolenum != _o_.concernrolenum) return false;
/*  71 */       if (this.publicendtime != _o_.publicendtime) return false;
/*  72 */       return true;
/*     */     }
/*  74 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  78 */     int _h_ = 0;
/*  79 */     _h_ += (int)this.marketid;
/*  80 */     _h_ += this.itemid;
/*  81 */     _h_ += this.price;
/*  82 */     _h_ += this.restnum;
/*  83 */     _h_ += this.sellnum;
/*  84 */     _h_ += this.state;
/*  85 */     _h_ += this.concernrolenum;
/*  86 */     _h_ += (int)this.publicendtime;
/*  87 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  91 */     StringBuilder _sb_ = new StringBuilder();
/*  92 */     _sb_.append("(");
/*  93 */     _sb_.append(this.marketid).append(",");
/*  94 */     _sb_.append(this.itemid).append(",");
/*  95 */     _sb_.append(this.price).append(",");
/*  96 */     _sb_.append(this.restnum).append(",");
/*  97 */     _sb_.append(this.sellnum).append(",");
/*  98 */     _sb_.append(this.state).append(",");
/*  99 */     _sb_.append(this.concernrolenum).append(",");
/* 100 */     _sb_.append(this.publicendtime).append(",");
/* 101 */     _sb_.append(")");
/* 102 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(MarketItem _o_) {
/* 106 */     if (_o_ == this) return 0;
/* 107 */     int _c_ = 0;
/* 108 */     _c_ = Long.signum(this.marketid - _o_.marketid);
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     _c_ = this.itemid - _o_.itemid;
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     _c_ = this.price - _o_.price;
/* 113 */     if (0 != _c_) return _c_;
/* 114 */     _c_ = this.restnum - _o_.restnum;
/* 115 */     if (0 != _c_) return _c_;
/* 116 */     _c_ = this.sellnum - _o_.sellnum;
/* 117 */     if (0 != _c_) return _c_;
/* 118 */     _c_ = this.state - _o_.state;
/* 119 */     if (0 != _c_) return _c_;
/* 120 */     _c_ = this.concernrolenum - _o_.concernrolenum;
/* 121 */     if (0 != _c_) return _c_;
/* 122 */     _c_ = Long.signum(this.publicendtime - _o_.publicendtime);
/* 123 */     if (0 != _c_) return _c_;
/* 124 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\MarketItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */