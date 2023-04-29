/*     */ package mzm.gsp.market;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class MarketPet implements Marshal, Comparable<MarketPet>
/*     */ {
/*     */   public long marketid;
/*     */   public int petcfgid;
/*     */   public int petlevel;
/*     */   public int price;
/*     */   public int state;
/*     */   public int concernrolenum;
/*     */   public long publicendtime;
/*     */   
/*     */   public MarketPet() {}
/*     */   
/*     */   public MarketPet(long _marketid_, int _petcfgid_, int _petlevel_, int _price_, int _state_, int _concernrolenum_, long _publicendtime_)
/*     */   {
/*  21 */     this.marketid = _marketid_;
/*  22 */     this.petcfgid = _petcfgid_;
/*  23 */     this.petlevel = _petlevel_;
/*  24 */     this.price = _price_;
/*  25 */     this.state = _state_;
/*  26 */     this.concernrolenum = _concernrolenum_;
/*  27 */     this.publicendtime = _publicendtime_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  31 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  35 */     _os_.marshal(this.marketid);
/*  36 */     _os_.marshal(this.petcfgid);
/*  37 */     _os_.marshal(this.petlevel);
/*  38 */     _os_.marshal(this.price);
/*  39 */     _os_.marshal(this.state);
/*  40 */     _os_.marshal(this.concernrolenum);
/*  41 */     _os_.marshal(this.publicendtime);
/*  42 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  46 */     this.marketid = _os_.unmarshal_long();
/*  47 */     this.petcfgid = _os_.unmarshal_int();
/*  48 */     this.petlevel = _os_.unmarshal_int();
/*  49 */     this.price = _os_.unmarshal_int();
/*  50 */     this.state = _os_.unmarshal_int();
/*  51 */     this.concernrolenum = _os_.unmarshal_int();
/*  52 */     this.publicendtime = _os_.unmarshal_long();
/*  53 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  57 */     if (_o1_ == this) return true;
/*  58 */     if ((_o1_ instanceof MarketPet)) {
/*  59 */       MarketPet _o_ = (MarketPet)_o1_;
/*  60 */       if (this.marketid != _o_.marketid) return false;
/*  61 */       if (this.petcfgid != _o_.petcfgid) return false;
/*  62 */       if (this.petlevel != _o_.petlevel) return false;
/*  63 */       if (this.price != _o_.price) return false;
/*  64 */       if (this.state != _o_.state) return false;
/*  65 */       if (this.concernrolenum != _o_.concernrolenum) return false;
/*  66 */       if (this.publicendtime != _o_.publicendtime) return false;
/*  67 */       return true;
/*     */     }
/*  69 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  73 */     int _h_ = 0;
/*  74 */     _h_ += (int)this.marketid;
/*  75 */     _h_ += this.petcfgid;
/*  76 */     _h_ += this.petlevel;
/*  77 */     _h_ += this.price;
/*  78 */     _h_ += this.state;
/*  79 */     _h_ += this.concernrolenum;
/*  80 */     _h_ += (int)this.publicendtime;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.marketid).append(",");
/*  88 */     _sb_.append(this.petcfgid).append(",");
/*  89 */     _sb_.append(this.petlevel).append(",");
/*  90 */     _sb_.append(this.price).append(",");
/*  91 */     _sb_.append(this.state).append(",");
/*  92 */     _sb_.append(this.concernrolenum).append(",");
/*  93 */     _sb_.append(this.publicendtime).append(",");
/*  94 */     _sb_.append(")");
/*  95 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(MarketPet _o_) {
/*  99 */     if (_o_ == this) return 0;
/* 100 */     int _c_ = 0;
/* 101 */     _c_ = Long.signum(this.marketid - _o_.marketid);
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     _c_ = this.petcfgid - _o_.petcfgid;
/* 104 */     if (0 != _c_) return _c_;
/* 105 */     _c_ = this.petlevel - _o_.petlevel;
/* 106 */     if (0 != _c_) return _c_;
/* 107 */     _c_ = this.price - _o_.price;
/* 108 */     if (0 != _c_) return _c_;
/* 109 */     _c_ = this.state - _o_.state;
/* 110 */     if (0 != _c_) return _c_;
/* 111 */     _c_ = this.concernrolenum - _o_.concernrolenum;
/* 112 */     if (0 != _c_) return _c_;
/* 113 */     _c_ = Long.signum(this.publicendtime - _o_.publicendtime);
/* 114 */     if (0 != _c_) return _c_;
/* 115 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\MarketPet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */