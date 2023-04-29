/*     */ package mzm.gsp.shitu;
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
/*     */ public class SReplyPayRespect
/*     */   extends __SReplyPayRespect__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12601629;
/*     */   public int operator;
/*     */   public long master_role_id;
/*     */   public long apprentice_role_id;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12601629;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SReplyPayRespect() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SReplyPayRespect(int _operator_, long _master_role_id_, long _apprentice_role_id_)
/*     */   {
/*  38 */     this.operator = _operator_;
/*  39 */     this.master_role_id = _master_role_id_;
/*  40 */     this.apprentice_role_id = _apprentice_role_id_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.operator);
/*  49 */     _os_.marshal(this.master_role_id);
/*  50 */     _os_.marshal(this.apprentice_role_id);
/*  51 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  55 */     this.operator = _os_.unmarshal_int();
/*  56 */     this.master_role_id = _os_.unmarshal_long();
/*  57 */     this.apprentice_role_id = _os_.unmarshal_long();
/*  58 */     if (!_validator_()) {
/*  59 */       throw new VerifyError("validator failed");
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  65 */     if (_o1_ == this) return true;
/*  66 */     if ((_o1_ instanceof SReplyPayRespect)) {
/*  67 */       SReplyPayRespect _o_ = (SReplyPayRespect)_o1_;
/*  68 */       if (this.operator != _o_.operator) return false;
/*  69 */       if (this.master_role_id != _o_.master_role_id) return false;
/*  70 */       if (this.apprentice_role_id != _o_.apprentice_role_id) return false;
/*  71 */       return true;
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  77 */     int _h_ = 0;
/*  78 */     _h_ += this.operator;
/*  79 */     _h_ += (int)this.master_role_id;
/*  80 */     _h_ += (int)this.apprentice_role_id;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.operator).append(",");
/*  88 */     _sb_.append(this.master_role_id).append(",");
/*  89 */     _sb_.append(this.apprentice_role_id).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SReplyPayRespect _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = this.operator - _o_.operator;
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = Long.signum(this.master_role_id - _o_.master_role_id);
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = Long.signum(this.apprentice_role_id - _o_.apprentice_role_id);
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\SReplyPayRespect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */