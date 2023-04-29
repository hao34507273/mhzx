/*     */ package mzm.gsp.market;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SPetMaxPriceRes
/*     */   extends __SPetMaxPriceRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12601452;
/*     */   public long marketid;
/*     */   public int petcfgid;
/*     */   public int maxprice;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  25 */     return 12601452;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SPetMaxPriceRes() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SPetMaxPriceRes(long _marketid_, int _petcfgid_, int _maxprice_)
/*     */   {
/*  36 */     this.marketid = _marketid_;
/*  37 */     this.petcfgid = _petcfgid_;
/*  38 */     this.maxprice = _maxprice_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  42 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  46 */     _os_.marshal(this.marketid);
/*  47 */     _os_.marshal(this.petcfgid);
/*  48 */     _os_.marshal(this.maxprice);
/*  49 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  53 */     this.marketid = _os_.unmarshal_long();
/*  54 */     this.petcfgid = _os_.unmarshal_int();
/*  55 */     this.maxprice = _os_.unmarshal_int();
/*  56 */     if (!_validator_()) {
/*  57 */       throw new VerifyError("validator failed");
/*     */     }
/*  59 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  63 */     if (_o1_ == this) return true;
/*  64 */     if ((_o1_ instanceof SPetMaxPriceRes)) {
/*  65 */       SPetMaxPriceRes _o_ = (SPetMaxPriceRes)_o1_;
/*  66 */       if (this.marketid != _o_.marketid) return false;
/*  67 */       if (this.petcfgid != _o_.petcfgid) return false;
/*  68 */       if (this.maxprice != _o_.maxprice) return false;
/*  69 */       return true;
/*     */     }
/*  71 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  75 */     int _h_ = 0;
/*  76 */     _h_ += (int)this.marketid;
/*  77 */     _h_ += this.petcfgid;
/*  78 */     _h_ += this.maxprice;
/*  79 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  83 */     StringBuilder _sb_ = new StringBuilder();
/*  84 */     _sb_.append("(");
/*  85 */     _sb_.append(this.marketid).append(",");
/*  86 */     _sb_.append(this.petcfgid).append(",");
/*  87 */     _sb_.append(this.maxprice).append(",");
/*  88 */     _sb_.append(")");
/*  89 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SPetMaxPriceRes _o_) {
/*  93 */     if (_o_ == this) return 0;
/*  94 */     int _c_ = 0;
/*  95 */     _c_ = Long.signum(this.marketid - _o_.marketid);
/*  96 */     if (0 != _c_) return _c_;
/*  97 */     _c_ = this.petcfgid - _o_.petcfgid;
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = this.maxprice - _o_.maxprice;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\SPetMaxPriceRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */