/*     */ package mzm.gsp.shitu;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.shitu.main.PCReplyPayRespect;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CReplyPayRespect
/*     */   extends __CReplyPayRespect__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12601628;
/*     */   public int operator;
/*     */   public long apprentice_role_id;
/*     */   public long session_id;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleId = Role.getRoleId(this);
/*  21 */     if (roleId < 0L) {
/*  22 */       return;
/*     */     }
/*  24 */     Role.addRoleProcedure(roleId, new PCReplyPayRespect(this.operator, roleId, this.apprentice_role_id, this.session_id));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  32 */     return 12601628;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CReplyPayRespect() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CReplyPayRespect(int _operator_, long _apprentice_role_id_, long _session_id_)
/*     */   {
/*  43 */     this.operator = _operator_;
/*  44 */     this.apprentice_role_id = _apprentice_role_id_;
/*  45 */     this.session_id = _session_id_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  49 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  53 */     _os_.marshal(this.operator);
/*  54 */     _os_.marshal(this.apprentice_role_id);
/*  55 */     _os_.marshal(this.session_id);
/*  56 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  60 */     this.operator = _os_.unmarshal_int();
/*  61 */     this.apprentice_role_id = _os_.unmarshal_long();
/*  62 */     this.session_id = _os_.unmarshal_long();
/*  63 */     if (!_validator_()) {
/*  64 */       throw new VerifyError("validator failed");
/*     */     }
/*  66 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  70 */     if (_o1_ == this) return true;
/*  71 */     if ((_o1_ instanceof CReplyPayRespect)) {
/*  72 */       CReplyPayRespect _o_ = (CReplyPayRespect)_o1_;
/*  73 */       if (this.operator != _o_.operator) return false;
/*  74 */       if (this.apprentice_role_id != _o_.apprentice_role_id) return false;
/*  75 */       if (this.session_id != _o_.session_id) return false;
/*  76 */       return true;
/*     */     }
/*  78 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  82 */     int _h_ = 0;
/*  83 */     _h_ += this.operator;
/*  84 */     _h_ += (int)this.apprentice_role_id;
/*  85 */     _h_ += (int)this.session_id;
/*  86 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  90 */     StringBuilder _sb_ = new StringBuilder();
/*  91 */     _sb_.append("(");
/*  92 */     _sb_.append(this.operator).append(",");
/*  93 */     _sb_.append(this.apprentice_role_id).append(",");
/*  94 */     _sb_.append(this.session_id).append(",");
/*  95 */     _sb_.append(")");
/*  96 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CReplyPayRespect _o_) {
/* 100 */     if (_o_ == this) return 0;
/* 101 */     int _c_ = 0;
/* 102 */     _c_ = this.operator - _o_.operator;
/* 103 */     if (0 != _c_) return _c_;
/* 104 */     _c_ = Long.signum(this.apprentice_role_id - _o_.apprentice_role_id);
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = Long.signum(this.session_id - _o_.session_id);
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\CReplyPayRespect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */