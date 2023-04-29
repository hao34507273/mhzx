/*     */ package mzm.gsp.fabaolingqi;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SImproveArtifactFail
/*     */   extends __SImproveArtifactFail__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12618247;
/*     */   public static final int NOT_IMPROVABLE = 1;
/*     */   public static final int REACH_MAXIMUM = 2;
/*     */   public static final int ITEM_NOT_EXISTS = 3;
/*     */   public static final int ITEM_NUM_NOT_ENOUGH = 4;
/*     */   public static final int INSUFFICIENT_YUANBAO = 5;
/*     */   public int retcode;
/*     */   public int class_id;
/*     */   public int property_type;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12618247;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SImproveArtifactFail() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SImproveArtifactFail(int _retcode_, int _class_id_, int _property_type_)
/*     */   {
/*  44 */     this.retcode = _retcode_;
/*  45 */     this.class_id = _class_id_;
/*  46 */     this.property_type = _property_type_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  50 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  54 */     _os_.marshal(this.retcode);
/*  55 */     _os_.marshal(this.class_id);
/*  56 */     _os_.marshal(this.property_type);
/*  57 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  61 */     this.retcode = _os_.unmarshal_int();
/*  62 */     this.class_id = _os_.unmarshal_int();
/*  63 */     this.property_type = _os_.unmarshal_int();
/*  64 */     if (!_validator_()) {
/*  65 */       throw new VerifyError("validator failed");
/*     */     }
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  71 */     if (_o1_ == this) return true;
/*  72 */     if ((_o1_ instanceof SImproveArtifactFail)) {
/*  73 */       SImproveArtifactFail _o_ = (SImproveArtifactFail)_o1_;
/*  74 */       if (this.retcode != _o_.retcode) return false;
/*  75 */       if (this.class_id != _o_.class_id) return false;
/*  76 */       if (this.property_type != _o_.property_type) return false;
/*  77 */       return true;
/*     */     }
/*  79 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  83 */     int _h_ = 0;
/*  84 */     _h_ += this.retcode;
/*  85 */     _h_ += this.class_id;
/*  86 */     _h_ += this.property_type;
/*  87 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  91 */     StringBuilder _sb_ = new StringBuilder();
/*  92 */     _sb_.append("(");
/*  93 */     _sb_.append(this.retcode).append(",");
/*  94 */     _sb_.append(this.class_id).append(",");
/*  95 */     _sb_.append(this.property_type).append(",");
/*  96 */     _sb_.append(")");
/*  97 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SImproveArtifactFail _o_) {
/* 101 */     if (_o_ == this) return 0;
/* 102 */     int _c_ = 0;
/* 103 */     _c_ = this.retcode - _o_.retcode;
/* 104 */     if (0 != _c_) return _c_;
/* 105 */     _c_ = this.class_id - _o_.class_id;
/* 106 */     if (0 != _c_) return _c_;
/* 107 */     _c_ = this.property_type - _o_.property_type;
/* 108 */     if (0 != _c_) return _c_;
/* 109 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabaolingqi\SImproveArtifactFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */