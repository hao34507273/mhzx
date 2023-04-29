/*     */ package mzm.gsp.fabaolingqi;
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
/*     */ public class SImproveArtifactSuccess
/*     */   extends __SImproveArtifactSuccess__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12618246;
/*     */   public int class_id;
/*     */   public int property_type;
/*     */   public int property_value;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12618246;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SImproveArtifactSuccess() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SImproveArtifactSuccess(int _class_id_, int _property_type_, int _property_value_)
/*     */   {
/*  38 */     this.class_id = _class_id_;
/*  39 */     this.property_type = _property_type_;
/*  40 */     this.property_value = _property_value_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.class_id);
/*  49 */     _os_.marshal(this.property_type);
/*  50 */     _os_.marshal(this.property_value);
/*  51 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  55 */     this.class_id = _os_.unmarshal_int();
/*  56 */     this.property_type = _os_.unmarshal_int();
/*  57 */     this.property_value = _os_.unmarshal_int();
/*  58 */     if (!_validator_()) {
/*  59 */       throw new VerifyError("validator failed");
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  65 */     if (_o1_ == this) return true;
/*  66 */     if ((_o1_ instanceof SImproveArtifactSuccess)) {
/*  67 */       SImproveArtifactSuccess _o_ = (SImproveArtifactSuccess)_o1_;
/*  68 */       if (this.class_id != _o_.class_id) return false;
/*  69 */       if (this.property_type != _o_.property_type) return false;
/*  70 */       if (this.property_value != _o_.property_value) return false;
/*  71 */       return true;
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  77 */     int _h_ = 0;
/*  78 */     _h_ += this.class_id;
/*  79 */     _h_ += this.property_type;
/*  80 */     _h_ += this.property_value;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.class_id).append(",");
/*  88 */     _sb_.append(this.property_type).append(",");
/*  89 */     _sb_.append(this.property_value).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SImproveArtifactSuccess _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = this.class_id - _o_.class_id;
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = this.property_type - _o_.property_type;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = this.property_value - _o_.property_value;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabaolingqi\SImproveArtifactSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */