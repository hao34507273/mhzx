/*     */ package mzm.gsp.team;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.team.main.PApplyTeamRep;
/*     */ 
/*     */ public class CApplyTeamRep
/*     */   extends __CApplyTeamRep__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12588293;
/*     */   public static final int REPLY_ACCEPT = 1;
/*     */   public static final int REPLY_REFUSE = 2;
/*     */   public long applicant;
/*     */   public int reply;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     long roleid = Role.getRoleId(this);
/*  20 */     if (roleid < 0L) {
/*  21 */       return;
/*     */     }
/*  23 */     Role.addRoleProcedure(roleid, new PApplyTeamRep(roleid, this.applicant, this.reply));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  31 */     return 12588293;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CApplyTeamRep() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CApplyTeamRep(long _applicant_, int _reply_)
/*     */   {
/*  44 */     this.applicant = _applicant_;
/*  45 */     this.reply = _reply_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  49 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  53 */     _os_.marshal(this.applicant);
/*  54 */     _os_.marshal(this.reply);
/*  55 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  59 */     this.applicant = _os_.unmarshal_long();
/*  60 */     this.reply = _os_.unmarshal_int();
/*  61 */     if (!_validator_()) {
/*  62 */       throw new VerifyError("validator failed");
/*     */     }
/*  64 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  68 */     if (_o1_ == this) return true;
/*  69 */     if ((_o1_ instanceof CApplyTeamRep)) {
/*  70 */       CApplyTeamRep _o_ = (CApplyTeamRep)_o1_;
/*  71 */       if (this.applicant != _o_.applicant) return false;
/*  72 */       if (this.reply != _o_.reply) return false;
/*  73 */       return true;
/*     */     }
/*  75 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  79 */     int _h_ = 0;
/*  80 */     _h_ += (int)this.applicant;
/*  81 */     _h_ += this.reply;
/*  82 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  86 */     StringBuilder _sb_ = new StringBuilder();
/*  87 */     _sb_.append("(");
/*  88 */     _sb_.append(this.applicant).append(",");
/*  89 */     _sb_.append(this.reply).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CApplyTeamRep _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = Long.signum(this.applicant - _o_.applicant);
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = this.reply - _o_.reply;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\CApplyTeamRep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */