/*     */ package mzm.gsp.fabaolingqi;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.fabaolingqi.main.PImproveArtifact;
/*     */ 
/*     */ public class CImproveArtifactReq
/*     */   extends __CImproveArtifactReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12618252;
/*     */   public int class_id;
/*     */   public int property_type;
/*     */   public int use_yuanbao;
/*     */   public long client_yuanbao;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     long roleId = Role.getRoleId(this);
/*  20 */     if (roleId < 0L)
/*  21 */       return;
/*  22 */     Role.addRoleProcedure(roleId, new PImproveArtifact(roleId, this.class_id, this.property_type, this.use_yuanbao != 0, this.client_yuanbao));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  31 */     return 12618252;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CImproveArtifactReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CImproveArtifactReq(int _class_id_, int _property_type_, int _use_yuanbao_, long _client_yuanbao_)
/*     */   {
/*  43 */     this.class_id = _class_id_;
/*  44 */     this.property_type = _property_type_;
/*  45 */     this.use_yuanbao = _use_yuanbao_;
/*  46 */     this.client_yuanbao = _client_yuanbao_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  50 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  54 */     _os_.marshal(this.class_id);
/*  55 */     _os_.marshal(this.property_type);
/*  56 */     _os_.marshal(this.use_yuanbao);
/*  57 */     _os_.marshal(this.client_yuanbao);
/*  58 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  62 */     this.class_id = _os_.unmarshal_int();
/*  63 */     this.property_type = _os_.unmarshal_int();
/*  64 */     this.use_yuanbao = _os_.unmarshal_int();
/*  65 */     this.client_yuanbao = _os_.unmarshal_long();
/*  66 */     if (!_validator_()) {
/*  67 */       throw new VerifyError("validator failed");
/*     */     }
/*  69 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  73 */     if (_o1_ == this) return true;
/*  74 */     if ((_o1_ instanceof CImproveArtifactReq)) {
/*  75 */       CImproveArtifactReq _o_ = (CImproveArtifactReq)_o1_;
/*  76 */       if (this.class_id != _o_.class_id) return false;
/*  77 */       if (this.property_type != _o_.property_type) return false;
/*  78 */       if (this.use_yuanbao != _o_.use_yuanbao) return false;
/*  79 */       if (this.client_yuanbao != _o_.client_yuanbao) return false;
/*  80 */       return true;
/*     */     }
/*  82 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  86 */     int _h_ = 0;
/*  87 */     _h_ += this.class_id;
/*  88 */     _h_ += this.property_type;
/*  89 */     _h_ += this.use_yuanbao;
/*  90 */     _h_ += (int)this.client_yuanbao;
/*  91 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  95 */     StringBuilder _sb_ = new StringBuilder();
/*  96 */     _sb_.append("(");
/*  97 */     _sb_.append(this.class_id).append(",");
/*  98 */     _sb_.append(this.property_type).append(",");
/*  99 */     _sb_.append(this.use_yuanbao).append(",");
/* 100 */     _sb_.append(this.client_yuanbao).append(",");
/* 101 */     _sb_.append(")");
/* 102 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CImproveArtifactReq _o_) {
/* 106 */     if (_o_ == this) return 0;
/* 107 */     int _c_ = 0;
/* 108 */     _c_ = this.class_id - _o_.class_id;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     _c_ = this.property_type - _o_.property_type;
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     _c_ = this.use_yuanbao - _o_.use_yuanbao;
/* 113 */     if (0 != _c_) return _c_;
/* 114 */     _c_ = Long.signum(this.client_yuanbao - _o_.client_yuanbao);
/* 115 */     if (0 != _c_) return _c_;
/* 116 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabaolingqi\CImproveArtifactReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */