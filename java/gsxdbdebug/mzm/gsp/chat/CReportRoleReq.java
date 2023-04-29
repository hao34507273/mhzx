/*     */ package mzm.gsp.chat;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.chat.main.PCReportRole;
/*     */ 
/*     */ public class CReportRoleReq
/*     */   extends __CReportRoleReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12585245;
/*     */   public long targetroleid;
/*     */   public Octets explain;
/*     */   public int reasonid;
/*     */   public Octets basis;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleId = Role.getRoleId(this);
/*  21 */     if (roleId < 0L) {
/*  22 */       return;
/*     */     }
/*  24 */     Role.addRoleProcedure(roleId, new PCReportRole(roleId, this.targetroleid, this.explain, this.reasonid, this.basis));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  32 */     return 12585245;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public CReportRoleReq()
/*     */   {
/*  41 */     this.explain = new Octets();
/*  42 */     this.basis = new Octets();
/*     */   }
/*     */   
/*     */   public CReportRoleReq(long _targetroleid_, Octets _explain_, int _reasonid_, Octets _basis_) {
/*  46 */     this.targetroleid = _targetroleid_;
/*  47 */     this.explain = _explain_;
/*  48 */     this.reasonid = _reasonid_;
/*  49 */     this.basis = _basis_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  53 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  57 */     _os_.marshal(this.targetroleid);
/*  58 */     _os_.marshal(this.explain);
/*  59 */     _os_.marshal(this.reasonid);
/*  60 */     _os_.marshal(this.basis);
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  65 */     this.targetroleid = _os_.unmarshal_long();
/*  66 */     this.explain = _os_.unmarshal_Octets();
/*  67 */     this.reasonid = _os_.unmarshal_int();
/*  68 */     this.basis = _os_.unmarshal_Octets();
/*  69 */     if (!_validator_()) {
/*  70 */       throw new VerifyError("validator failed");
/*     */     }
/*  72 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  76 */     if (_o1_ == this) return true;
/*  77 */     if ((_o1_ instanceof CReportRoleReq)) {
/*  78 */       CReportRoleReq _o_ = (CReportRoleReq)_o1_;
/*  79 */       if (this.targetroleid != _o_.targetroleid) return false;
/*  80 */       if (!this.explain.equals(_o_.explain)) return false;
/*  81 */       if (this.reasonid != _o_.reasonid) return false;
/*  82 */       if (!this.basis.equals(_o_.basis)) return false;
/*  83 */       return true;
/*     */     }
/*  85 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  89 */     int _h_ = 0;
/*  90 */     _h_ += (int)this.targetroleid;
/*  91 */     _h_ += this.explain.hashCode();
/*  92 */     _h_ += this.reasonid;
/*  93 */     _h_ += this.basis.hashCode();
/*  94 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  98 */     StringBuilder _sb_ = new StringBuilder();
/*  99 */     _sb_.append("(");
/* 100 */     _sb_.append(this.targetroleid).append(",");
/* 101 */     _sb_.append("B").append(this.explain.size()).append(",");
/* 102 */     _sb_.append(this.reasonid).append(",");
/* 103 */     _sb_.append("B").append(this.basis.size()).append(",");
/* 104 */     _sb_.append(")");
/* 105 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\CReportRoleReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */