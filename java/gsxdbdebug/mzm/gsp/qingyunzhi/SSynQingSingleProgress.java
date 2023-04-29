/*     */ package mzm.gsp.qingyunzhi;
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
/*     */ public class SSynQingSingleProgress
/*     */   extends __SSynQingSingleProgress__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12590339;
/*     */   public int outposttype;
/*     */   public int chapter;
/*     */   public int section;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12590339;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SSynQingSingleProgress() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SSynQingSingleProgress(int _outposttype_, int _chapter_, int _section_)
/*     */   {
/*  38 */     this.outposttype = _outposttype_;
/*  39 */     this.chapter = _chapter_;
/*  40 */     this.section = _section_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.outposttype);
/*  49 */     _os_.marshal(this.chapter);
/*  50 */     _os_.marshal(this.section);
/*  51 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  55 */     this.outposttype = _os_.unmarshal_int();
/*  56 */     this.chapter = _os_.unmarshal_int();
/*  57 */     this.section = _os_.unmarshal_int();
/*  58 */     if (!_validator_()) {
/*  59 */       throw new VerifyError("validator failed");
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  65 */     if (_o1_ == this) return true;
/*  66 */     if ((_o1_ instanceof SSynQingSingleProgress)) {
/*  67 */       SSynQingSingleProgress _o_ = (SSynQingSingleProgress)_o1_;
/*  68 */       if (this.outposttype != _o_.outposttype) return false;
/*  69 */       if (this.chapter != _o_.chapter) return false;
/*  70 */       if (this.section != _o_.section) return false;
/*  71 */       return true;
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  77 */     int _h_ = 0;
/*  78 */     _h_ += this.outposttype;
/*  79 */     _h_ += this.chapter;
/*  80 */     _h_ += this.section;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.outposttype).append(",");
/*  88 */     _sb_.append(this.chapter).append(",");
/*  89 */     _sb_.append(this.section).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SSynQingSingleProgress _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = this.outposttype - _o_.outposttype;
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = this.chapter - _o_.chapter;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = this.section - _o_.section;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingyunzhi\SSynQingSingleProgress.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */