/*     */ package mzm.gsp.children;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.children.preparepregnancy.PCAnswerAttendPreparePregnancyInvite;
/*     */ 
/*     */ public class CAnswerAttendPreparePregnancyInvite
/*     */   extends __CAnswerAttendPreparePregnancyInvite__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12609343;
/*     */   public static final int AGREE = 1;
/*     */   public static final int REFUSE = 2;
/*     */   public int answer;
/*     */   public long inviterid;
/*     */   public long sessionid;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleid = Role.getRoleId(this);
/*  21 */     if (roleid < 0L)
/*  22 */       return;
/*  23 */     Role.addRoleProcedure(roleid, new PCAnswerAttendPreparePregnancyInvite(this.inviterid, roleid, this.sessionid, this.answer));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  33 */     return 12609343;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public CAnswerAttendPreparePregnancyInvite() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CAnswerAttendPreparePregnancyInvite(int _answer_, long _inviterid_, long _sessionid_)
/*     */   {
/*  47 */     this.answer = _answer_;
/*  48 */     this.inviterid = _inviterid_;
/*  49 */     this.sessionid = _sessionid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  53 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  57 */     _os_.marshal(this.answer);
/*  58 */     _os_.marshal(this.inviterid);
/*  59 */     _os_.marshal(this.sessionid);
/*  60 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  64 */     this.answer = _os_.unmarshal_int();
/*  65 */     this.inviterid = _os_.unmarshal_long();
/*  66 */     this.sessionid = _os_.unmarshal_long();
/*  67 */     if (!_validator_()) {
/*  68 */       throw new VerifyError("validator failed");
/*     */     }
/*  70 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  74 */     if (_o1_ == this) return true;
/*  75 */     if ((_o1_ instanceof CAnswerAttendPreparePregnancyInvite)) {
/*  76 */       CAnswerAttendPreparePregnancyInvite _o_ = (CAnswerAttendPreparePregnancyInvite)_o1_;
/*  77 */       if (this.answer != _o_.answer) return false;
/*  78 */       if (this.inviterid != _o_.inviterid) return false;
/*  79 */       if (this.sessionid != _o_.sessionid) return false;
/*  80 */       return true;
/*     */     }
/*  82 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  86 */     int _h_ = 0;
/*  87 */     _h_ += this.answer;
/*  88 */     _h_ += (int)this.inviterid;
/*  89 */     _h_ += (int)this.sessionid;
/*  90 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  94 */     StringBuilder _sb_ = new StringBuilder();
/*  95 */     _sb_.append("(");
/*  96 */     _sb_.append(this.answer).append(",");
/*  97 */     _sb_.append(this.inviterid).append(",");
/*  98 */     _sb_.append(this.sessionid).append(",");
/*  99 */     _sb_.append(")");
/* 100 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CAnswerAttendPreparePregnancyInvite _o_) {
/* 104 */     if (_o_ == this) return 0;
/* 105 */     int _c_ = 0;
/* 106 */     _c_ = this.answer - _o_.answer;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = Long.signum(this.inviterid - _o_.inviterid);
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     _c_ = Long.signum(this.sessionid - _o_.sessionid);
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\CAnswerAttendPreparePregnancyInvite.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */