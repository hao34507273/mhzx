/*     */ package mzm.gsp.wing;
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
/*     */ public class SAddWingExpRep
/*     */   extends __SAddWingExpRep__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12596537;
/*     */   public int curexp;
/*     */   public int oldlv;
/*     */   public int newlv;
/*     */   public int addexp;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12596537;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SAddWingExpRep() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SAddWingExpRep(int _curexp_, int _oldlv_, int _newlv_, int _addexp_)
/*     */   {
/*  39 */     this.curexp = _curexp_;
/*  40 */     this.oldlv = _oldlv_;
/*  41 */     this.newlv = _newlv_;
/*  42 */     this.addexp = _addexp_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  50 */     _os_.marshal(this.curexp);
/*  51 */     _os_.marshal(this.oldlv);
/*  52 */     _os_.marshal(this.newlv);
/*  53 */     _os_.marshal(this.addexp);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.curexp = _os_.unmarshal_int();
/*  59 */     this.oldlv = _os_.unmarshal_int();
/*  60 */     this.newlv = _os_.unmarshal_int();
/*  61 */     this.addexp = _os_.unmarshal_int();
/*  62 */     if (!_validator_()) {
/*  63 */       throw new VerifyError("validator failed");
/*     */     }
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  69 */     if (_o1_ == this) return true;
/*  70 */     if ((_o1_ instanceof SAddWingExpRep)) {
/*  71 */       SAddWingExpRep _o_ = (SAddWingExpRep)_o1_;
/*  72 */       if (this.curexp != _o_.curexp) return false;
/*  73 */       if (this.oldlv != _o_.oldlv) return false;
/*  74 */       if (this.newlv != _o_.newlv) return false;
/*  75 */       if (this.addexp != _o_.addexp) return false;
/*  76 */       return true;
/*     */     }
/*  78 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  82 */     int _h_ = 0;
/*  83 */     _h_ += this.curexp;
/*  84 */     _h_ += this.oldlv;
/*  85 */     _h_ += this.newlv;
/*  86 */     _h_ += this.addexp;
/*  87 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  91 */     StringBuilder _sb_ = new StringBuilder();
/*  92 */     _sb_.append("(");
/*  93 */     _sb_.append(this.curexp).append(",");
/*  94 */     _sb_.append(this.oldlv).append(",");
/*  95 */     _sb_.append(this.newlv).append(",");
/*  96 */     _sb_.append(this.addexp).append(",");
/*  97 */     _sb_.append(")");
/*  98 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SAddWingExpRep _o_) {
/* 102 */     if (_o_ == this) return 0;
/* 103 */     int _c_ = 0;
/* 104 */     _c_ = this.curexp - _o_.curexp;
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = this.oldlv - _o_.oldlv;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = this.newlv - _o_.newlv;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     _c_ = this.addexp - _o_.addexp;
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\SAddWingExpRep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */