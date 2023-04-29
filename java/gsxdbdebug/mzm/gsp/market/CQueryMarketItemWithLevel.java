/*     */ package mzm.gsp.market;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.market.main.PQueryMarketItemWithLevel;
/*     */ 
/*     */ public class CQueryMarketItemWithLevel
/*     */   extends __CQueryMarketItemWithLevel__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12601393;
/*     */   public int subid;
/*     */   public int pricesort;
/*     */   public int level;
/*     */   public int puborsell;
/*     */   public int pageindex;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleId = Role.getRoleId(this);
/*  21 */     if (roleId < 0L) {
/*  22 */       return;
/*     */     }
/*  24 */     Role.addRoleProcedure(roleId, new PQueryMarketItemWithLevel(roleId, this.subid, this.pricesort, this.level, this.puborsell, this.pageindex));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  33 */     return 12601393;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CQueryMarketItemWithLevel() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CQueryMarketItemWithLevel(int _subid_, int _pricesort_, int _level_, int _puborsell_, int _pageindex_)
/*     */   {
/*  46 */     this.subid = _subid_;
/*  47 */     this.pricesort = _pricesort_;
/*  48 */     this.level = _level_;
/*  49 */     this.puborsell = _puborsell_;
/*  50 */     this.pageindex = _pageindex_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  54 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  58 */     _os_.marshal(this.subid);
/*  59 */     _os_.marshal(this.pricesort);
/*  60 */     _os_.marshal(this.level);
/*  61 */     _os_.marshal(this.puborsell);
/*  62 */     _os_.marshal(this.pageindex);
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  67 */     this.subid = _os_.unmarshal_int();
/*  68 */     this.pricesort = _os_.unmarshal_int();
/*  69 */     this.level = _os_.unmarshal_int();
/*  70 */     this.puborsell = _os_.unmarshal_int();
/*  71 */     this.pageindex = _os_.unmarshal_int();
/*  72 */     if (!_validator_()) {
/*  73 */       throw new VerifyError("validator failed");
/*     */     }
/*  75 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  79 */     if (_o1_ == this) return true;
/*  80 */     if ((_o1_ instanceof CQueryMarketItemWithLevel)) {
/*  81 */       CQueryMarketItemWithLevel _o_ = (CQueryMarketItemWithLevel)_o1_;
/*  82 */       if (this.subid != _o_.subid) return false;
/*  83 */       if (this.pricesort != _o_.pricesort) return false;
/*  84 */       if (this.level != _o_.level) return false;
/*  85 */       if (this.puborsell != _o_.puborsell) return false;
/*  86 */       if (this.pageindex != _o_.pageindex) return false;
/*  87 */       return true;
/*     */     }
/*  89 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  93 */     int _h_ = 0;
/*  94 */     _h_ += this.subid;
/*  95 */     _h_ += this.pricesort;
/*  96 */     _h_ += this.level;
/*  97 */     _h_ += this.puborsell;
/*  98 */     _h_ += this.pageindex;
/*  99 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 103 */     StringBuilder _sb_ = new StringBuilder();
/* 104 */     _sb_.append("(");
/* 105 */     _sb_.append(this.subid).append(",");
/* 106 */     _sb_.append(this.pricesort).append(",");
/* 107 */     _sb_.append(this.level).append(",");
/* 108 */     _sb_.append(this.puborsell).append(",");
/* 109 */     _sb_.append(this.pageindex).append(",");
/* 110 */     _sb_.append(")");
/* 111 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CQueryMarketItemWithLevel _o_) {
/* 115 */     if (_o_ == this) return 0;
/* 116 */     int _c_ = 0;
/* 117 */     _c_ = this.subid - _o_.subid;
/* 118 */     if (0 != _c_) return _c_;
/* 119 */     _c_ = this.pricesort - _o_.pricesort;
/* 120 */     if (0 != _c_) return _c_;
/* 121 */     _c_ = this.level - _o_.level;
/* 122 */     if (0 != _c_) return _c_;
/* 123 */     _c_ = this.puborsell - _o_.puborsell;
/* 124 */     if (0 != _c_) return _c_;
/* 125 */     _c_ = this.pageindex - _o_.pageindex;
/* 126 */     if (0 != _c_) return _c_;
/* 127 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\CQueryMarketItemWithLevel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */