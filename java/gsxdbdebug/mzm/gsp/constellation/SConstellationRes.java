/*     */ package mzm.gsp.constellation;
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
/*     */ public class SConstellationRes
/*     */   extends __SConstellationRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12612104;
/*     */   public int constellation;
/*     */   public int set_times;
/*     */   public int sum_exp;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12612104;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SConstellationRes() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SConstellationRes(int _constellation_, int _set_times_, int _sum_exp_)
/*     */   {
/*  38 */     this.constellation = _constellation_;
/*  39 */     this.set_times = _set_times_;
/*  40 */     this.sum_exp = _sum_exp_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.constellation);
/*  49 */     _os_.marshal(this.set_times);
/*  50 */     _os_.marshal(this.sum_exp);
/*  51 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  55 */     this.constellation = _os_.unmarshal_int();
/*  56 */     this.set_times = _os_.unmarshal_int();
/*  57 */     this.sum_exp = _os_.unmarshal_int();
/*  58 */     if (!_validator_()) {
/*  59 */       throw new VerifyError("validator failed");
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  65 */     if (_o1_ == this) return true;
/*  66 */     if ((_o1_ instanceof SConstellationRes)) {
/*  67 */       SConstellationRes _o_ = (SConstellationRes)_o1_;
/*  68 */       if (this.constellation != _o_.constellation) return false;
/*  69 */       if (this.set_times != _o_.set_times) return false;
/*  70 */       if (this.sum_exp != _o_.sum_exp) return false;
/*  71 */       return true;
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  77 */     int _h_ = 0;
/*  78 */     _h_ += this.constellation;
/*  79 */     _h_ += this.set_times;
/*  80 */     _h_ += this.sum_exp;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.constellation).append(",");
/*  88 */     _sb_.append(this.set_times).append(",");
/*  89 */     _sb_.append(this.sum_exp).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SConstellationRes _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = this.constellation - _o_.constellation;
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = this.set_times - _o_.set_times;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = this.sum_exp - _o_.sum_exp;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\constellation\SConstellationRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */