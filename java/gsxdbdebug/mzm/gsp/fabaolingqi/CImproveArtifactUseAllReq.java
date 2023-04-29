/*     */ package mzm.gsp.fabaolingqi;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.fabaolingqi.main.PImproveArtifactUseAll;
/*     */ 
/*     */ public class CImproveArtifactUseAllReq
/*     */   extends __CImproveArtifactUseAllReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12618260;
/*     */   public int class_id;
/*     */   public int property_type;
/*     */   public int use_yuanbao;
/*     */   public long client_yuanbao;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     long roleId = Role.getRoleId(this);
/*  20 */     Role.addRoleProcedure(roleId, new PImproveArtifactUseAll(roleId, this.class_id, this.property_type, this.use_yuanbao != 0, this.client_yuanbao));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  29 */     return 12618260;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CImproveArtifactUseAllReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CImproveArtifactUseAllReq(int _class_id_, int _property_type_, int _use_yuanbao_, long _client_yuanbao_)
/*     */   {
/*  41 */     this.class_id = _class_id_;
/*  42 */     this.property_type = _property_type_;
/*  43 */     this.use_yuanbao = _use_yuanbao_;
/*  44 */     this.client_yuanbao = _client_yuanbao_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.class_id);
/*  53 */     _os_.marshal(this.property_type);
/*  54 */     _os_.marshal(this.use_yuanbao);
/*  55 */     _os_.marshal(this.client_yuanbao);
/*  56 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  60 */     this.class_id = _os_.unmarshal_int();
/*  61 */     this.property_type = _os_.unmarshal_int();
/*  62 */     this.use_yuanbao = _os_.unmarshal_int();
/*  63 */     this.client_yuanbao = _os_.unmarshal_long();
/*  64 */     if (!_validator_()) {
/*  65 */       throw new VerifyError("validator failed");
/*     */     }
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  71 */     if (_o1_ == this) return true;
/*  72 */     if ((_o1_ instanceof CImproveArtifactUseAllReq)) {
/*  73 */       CImproveArtifactUseAllReq _o_ = (CImproveArtifactUseAllReq)_o1_;
/*  74 */       if (this.class_id != _o_.class_id) return false;
/*  75 */       if (this.property_type != _o_.property_type) return false;
/*  76 */       if (this.use_yuanbao != _o_.use_yuanbao) return false;
/*  77 */       if (this.client_yuanbao != _o_.client_yuanbao) return false;
/*  78 */       return true;
/*     */     }
/*  80 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  84 */     int _h_ = 0;
/*  85 */     _h_ += this.class_id;
/*  86 */     _h_ += this.property_type;
/*  87 */     _h_ += this.use_yuanbao;
/*  88 */     _h_ += (int)this.client_yuanbao;
/*  89 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  93 */     StringBuilder _sb_ = new StringBuilder();
/*  94 */     _sb_.append("(");
/*  95 */     _sb_.append(this.class_id).append(",");
/*  96 */     _sb_.append(this.property_type).append(",");
/*  97 */     _sb_.append(this.use_yuanbao).append(",");
/*  98 */     _sb_.append(this.client_yuanbao).append(",");
/*  99 */     _sb_.append(")");
/* 100 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CImproveArtifactUseAllReq _o_) {
/* 104 */     if (_o_ == this) return 0;
/* 105 */     int _c_ = 0;
/* 106 */     _c_ = this.class_id - _o_.class_id;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = this.property_type - _o_.property_type;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     _c_ = this.use_yuanbao - _o_.use_yuanbao;
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     _c_ = Long.signum(this.client_yuanbao - _o_.client_yuanbao);
/* 113 */     if (0 != _c_) return _c_;
/* 114 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabaolingqi\CImproveArtifactUseAllReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */