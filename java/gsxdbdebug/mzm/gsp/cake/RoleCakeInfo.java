/*     */ package mzm.gsp.cake;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class RoleCakeInfo
/*     */   implements Marshal, Comparable<RoleCakeInfo>
/*     */ {
/*     */   public int curturn;
/*     */   public int collectnum;
/*     */   public CakeDetailInfo cakeinfo;
/*     */   public int cookselfcount;
/*     */   public int cookothercount;
/*     */   public long effectfactionid;
/*     */   
/*     */   public RoleCakeInfo()
/*     */   {
/*  19 */     this.cakeinfo = new CakeDetailInfo();
/*     */   }
/*     */   
/*     */   public RoleCakeInfo(int _curturn_, int _collectnum_, CakeDetailInfo _cakeinfo_, int _cookselfcount_, int _cookothercount_, long _effectfactionid_) {
/*  23 */     this.curturn = _curturn_;
/*  24 */     this.collectnum = _collectnum_;
/*  25 */     this.cakeinfo = _cakeinfo_;
/*  26 */     this.cookselfcount = _cookselfcount_;
/*  27 */     this.cookothercount = _cookothercount_;
/*  28 */     this.effectfactionid = _effectfactionid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  32 */     if (!this.cakeinfo._validator_()) return false;
/*  33 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  37 */     _os_.marshal(this.curturn);
/*  38 */     _os_.marshal(this.collectnum);
/*  39 */     _os_.marshal(this.cakeinfo);
/*  40 */     _os_.marshal(this.cookselfcount);
/*  41 */     _os_.marshal(this.cookothercount);
/*  42 */     _os_.marshal(this.effectfactionid);
/*  43 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  47 */     this.curturn = _os_.unmarshal_int();
/*  48 */     this.collectnum = _os_.unmarshal_int();
/*  49 */     this.cakeinfo.unmarshal(_os_);
/*  50 */     this.cookselfcount = _os_.unmarshal_int();
/*  51 */     this.cookothercount = _os_.unmarshal_int();
/*  52 */     this.effectfactionid = _os_.unmarshal_long();
/*  53 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  57 */     if (_o1_ == this) return true;
/*  58 */     if ((_o1_ instanceof RoleCakeInfo)) {
/*  59 */       RoleCakeInfo _o_ = (RoleCakeInfo)_o1_;
/*  60 */       if (this.curturn != _o_.curturn) return false;
/*  61 */       if (this.collectnum != _o_.collectnum) return false;
/*  62 */       if (!this.cakeinfo.equals(_o_.cakeinfo)) return false;
/*  63 */       if (this.cookselfcount != _o_.cookselfcount) return false;
/*  64 */       if (this.cookothercount != _o_.cookothercount) return false;
/*  65 */       if (this.effectfactionid != _o_.effectfactionid) return false;
/*  66 */       return true;
/*     */     }
/*  68 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  72 */     int _h_ = 0;
/*  73 */     _h_ += this.curturn;
/*  74 */     _h_ += this.collectnum;
/*  75 */     _h_ += this.cakeinfo.hashCode();
/*  76 */     _h_ += this.cookselfcount;
/*  77 */     _h_ += this.cookothercount;
/*  78 */     _h_ += (int)this.effectfactionid;
/*  79 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  83 */     StringBuilder _sb_ = new StringBuilder();
/*  84 */     _sb_.append("(");
/*  85 */     _sb_.append(this.curturn).append(",");
/*  86 */     _sb_.append(this.collectnum).append(",");
/*  87 */     _sb_.append(this.cakeinfo).append(",");
/*  88 */     _sb_.append(this.cookselfcount).append(",");
/*  89 */     _sb_.append(this.cookothercount).append(",");
/*  90 */     _sb_.append(this.effectfactionid).append(",");
/*  91 */     _sb_.append(")");
/*  92 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(RoleCakeInfo _o_) {
/*  96 */     if (_o_ == this) return 0;
/*  97 */     int _c_ = 0;
/*  98 */     _c_ = this.curturn - _o_.curturn;
/*  99 */     if (0 != _c_) return _c_;
/* 100 */     _c_ = this.collectnum - _o_.collectnum;
/* 101 */     if (0 != _c_) return _c_;
/* 102 */     _c_ = this.cakeinfo.compareTo(_o_.cakeinfo);
/* 103 */     if (0 != _c_) return _c_;
/* 104 */     _c_ = this.cookselfcount - _o_.cookselfcount;
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = this.cookothercount - _o_.cookothercount;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = Long.signum(this.effectfactionid - _o_.effectfactionid);
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\cake\RoleCakeInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */