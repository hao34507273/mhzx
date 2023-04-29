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
/*     */ public class SImproveArtifactUseAllSuccess
/*     */   extends __SImproveArtifactUseAllSuccess__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12618261;
/*     */   public int class_id;
/*     */   public int property_type;
/*     */   public int property_value;
/*     */   public int consumed_item_num;
/*     */   public int consumed_yuanbao;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12618261;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SImproveArtifactUseAllSuccess() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SImproveArtifactUseAllSuccess(int _class_id_, int _property_type_, int _property_value_, int _consumed_item_num_, int _consumed_yuanbao_)
/*     */   {
/*  40 */     this.class_id = _class_id_;
/*  41 */     this.property_type = _property_type_;
/*  42 */     this.property_value = _property_value_;
/*  43 */     this.consumed_item_num = _consumed_item_num_;
/*  44 */     this.consumed_yuanbao = _consumed_yuanbao_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.class_id);
/*  53 */     _os_.marshal(this.property_type);
/*  54 */     _os_.marshal(this.property_value);
/*  55 */     _os_.marshal(this.consumed_item_num);
/*  56 */     _os_.marshal(this.consumed_yuanbao);
/*  57 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  61 */     this.class_id = _os_.unmarshal_int();
/*  62 */     this.property_type = _os_.unmarshal_int();
/*  63 */     this.property_value = _os_.unmarshal_int();
/*  64 */     this.consumed_item_num = _os_.unmarshal_int();
/*  65 */     this.consumed_yuanbao = _os_.unmarshal_int();
/*  66 */     if (!_validator_()) {
/*  67 */       throw new VerifyError("validator failed");
/*     */     }
/*  69 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  73 */     if (_o1_ == this) return true;
/*  74 */     if ((_o1_ instanceof SImproveArtifactUseAllSuccess)) {
/*  75 */       SImproveArtifactUseAllSuccess _o_ = (SImproveArtifactUseAllSuccess)_o1_;
/*  76 */       if (this.class_id != _o_.class_id) return false;
/*  77 */       if (this.property_type != _o_.property_type) return false;
/*  78 */       if (this.property_value != _o_.property_value) return false;
/*  79 */       if (this.consumed_item_num != _o_.consumed_item_num) return false;
/*  80 */       if (this.consumed_yuanbao != _o_.consumed_yuanbao) return false;
/*  81 */       return true;
/*     */     }
/*  83 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  87 */     int _h_ = 0;
/*  88 */     _h_ += this.class_id;
/*  89 */     _h_ += this.property_type;
/*  90 */     _h_ += this.property_value;
/*  91 */     _h_ += this.consumed_item_num;
/*  92 */     _h_ += this.consumed_yuanbao;
/*  93 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  97 */     StringBuilder _sb_ = new StringBuilder();
/*  98 */     _sb_.append("(");
/*  99 */     _sb_.append(this.class_id).append(",");
/* 100 */     _sb_.append(this.property_type).append(",");
/* 101 */     _sb_.append(this.property_value).append(",");
/* 102 */     _sb_.append(this.consumed_item_num).append(",");
/* 103 */     _sb_.append(this.consumed_yuanbao).append(",");
/* 104 */     _sb_.append(")");
/* 105 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SImproveArtifactUseAllSuccess _o_) {
/* 109 */     if (_o_ == this) return 0;
/* 110 */     int _c_ = 0;
/* 111 */     _c_ = this.class_id - _o_.class_id;
/* 112 */     if (0 != _c_) return _c_;
/* 113 */     _c_ = this.property_type - _o_.property_type;
/* 114 */     if (0 != _c_) return _c_;
/* 115 */     _c_ = this.property_value - _o_.property_value;
/* 116 */     if (0 != _c_) return _c_;
/* 117 */     _c_ = this.consumed_item_num - _o_.consumed_item_num;
/* 118 */     if (0 != _c_) return _c_;
/* 119 */     _c_ = this.consumed_yuanbao - _o_.consumed_yuanbao;
/* 120 */     if (0 != _c_) return _c_;
/* 121 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabaolingqi\SImproveArtifactUseAllSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */