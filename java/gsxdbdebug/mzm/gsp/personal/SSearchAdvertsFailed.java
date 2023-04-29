/*     */ package mzm.gsp.personal;
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
/*     */ public class SSearchAdvertsFailed
/*     */   extends __SSearchAdvertsFailed__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12603660;
/*     */   public int adverttype;
/*     */   public int page;
/*     */   public int retcode;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12603660;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SSearchAdvertsFailed() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SSearchAdvertsFailed(int _adverttype_, int _page_, int _retcode_)
/*     */   {
/*  38 */     this.adverttype = _adverttype_;
/*  39 */     this.page = _page_;
/*  40 */     this.retcode = _retcode_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.adverttype);
/*  49 */     _os_.marshal(this.page);
/*  50 */     _os_.marshal(this.retcode);
/*  51 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  55 */     this.adverttype = _os_.unmarshal_int();
/*  56 */     this.page = _os_.unmarshal_int();
/*  57 */     this.retcode = _os_.unmarshal_int();
/*  58 */     if (!_validator_()) {
/*  59 */       throw new VerifyError("validator failed");
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  65 */     if (_o1_ == this) return true;
/*  66 */     if ((_o1_ instanceof SSearchAdvertsFailed)) {
/*  67 */       SSearchAdvertsFailed _o_ = (SSearchAdvertsFailed)_o1_;
/*  68 */       if (this.adverttype != _o_.adverttype) return false;
/*  69 */       if (this.page != _o_.page) return false;
/*  70 */       if (this.retcode != _o_.retcode) return false;
/*  71 */       return true;
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  77 */     int _h_ = 0;
/*  78 */     _h_ += this.adverttype;
/*  79 */     _h_ += this.page;
/*  80 */     _h_ += this.retcode;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.adverttype).append(",");
/*  88 */     _sb_.append(this.page).append(",");
/*  89 */     _sb_.append(this.retcode).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SSearchAdvertsFailed _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = this.adverttype - _o_.adverttype;
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = this.page - _o_.page;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = this.retcode - _o_.retcode;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\personal\SSearchAdvertsFailed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */