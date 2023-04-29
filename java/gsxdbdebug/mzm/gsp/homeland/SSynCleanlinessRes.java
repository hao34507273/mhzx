/*     */ package mzm.gsp.homeland;
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
/*     */ 
/*     */ 
/*     */ public class SSynCleanlinessRes
/*     */   extends __SSynCleanlinessRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12605452;
/*     */   public int daycleancount;
/*     */   public int cleanliness;
/*     */   public int area;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12605452;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SSynCleanlinessRes() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SSynCleanlinessRes(int _daycleancount_, int _cleanliness_, int _area_)
/*     */   {
/*  38 */     this.daycleancount = _daycleancount_;
/*  39 */     this.cleanliness = _cleanliness_;
/*  40 */     this.area = _area_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.daycleancount);
/*  49 */     _os_.marshal(this.cleanliness);
/*  50 */     _os_.marshal(this.area);
/*  51 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  55 */     this.daycleancount = _os_.unmarshal_int();
/*  56 */     this.cleanliness = _os_.unmarshal_int();
/*  57 */     this.area = _os_.unmarshal_int();
/*  58 */     if (!_validator_()) {
/*  59 */       throw new VerifyError("validator failed");
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  65 */     if (_o1_ == this) return true;
/*  66 */     if ((_o1_ instanceof SSynCleanlinessRes)) {
/*  67 */       SSynCleanlinessRes _o_ = (SSynCleanlinessRes)_o1_;
/*  68 */       if (this.daycleancount != _o_.daycleancount) return false;
/*  69 */       if (this.cleanliness != _o_.cleanliness) return false;
/*  70 */       if (this.area != _o_.area) return false;
/*  71 */       return true;
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  77 */     int _h_ = 0;
/*  78 */     _h_ += this.daycleancount;
/*  79 */     _h_ += this.cleanliness;
/*  80 */     _h_ += this.area;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.daycleancount).append(",");
/*  88 */     _sb_.append(this.cleanliness).append(",");
/*  89 */     _sb_.append(this.area).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SSynCleanlinessRes _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = this.daycleancount - _o_.daycleancount;
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = this.cleanliness - _o_.cleanliness;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = this.area - _o_.area;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\SSynCleanlinessRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */