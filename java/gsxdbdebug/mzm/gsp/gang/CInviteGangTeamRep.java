/*     */ package mzm.gsp.gang;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.gang.main.PInviteGangTeamRep;
/*     */ 
/*     */ public class CInviteGangTeamRep extends __CInviteGangTeamRep__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12589985;
/*     */   public static final int REPLY_AGREE = 0;
/*     */   public static final int REPLY_REFUSE = 1;
/*     */   public long inviter;
/*     */   public long gang_teamid;
/*     */   public int reply;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     long roleid = Role.getRoleId(this);
/*  20 */     Role.addRoleProcedure(roleid, new PInviteGangTeamRep(roleid, this.inviter, this.gang_teamid, this.reply));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  29 */     return 12589985;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public CInviteGangTeamRep() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CInviteGangTeamRep(long _inviter_, long _gang_teamid_, int _reply_)
/*     */   {
/*  43 */     this.inviter = _inviter_;
/*  44 */     this.gang_teamid = _gang_teamid_;
/*  45 */     this.reply = _reply_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  49 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  53 */     _os_.marshal(this.inviter);
/*  54 */     _os_.marshal(this.gang_teamid);
/*  55 */     _os_.marshal(this.reply);
/*  56 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  60 */     this.inviter = _os_.unmarshal_long();
/*  61 */     this.gang_teamid = _os_.unmarshal_long();
/*  62 */     this.reply = _os_.unmarshal_int();
/*  63 */     if (!_validator_()) {
/*  64 */       throw new VerifyError("validator failed");
/*     */     }
/*  66 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  70 */     if (_o1_ == this) return true;
/*  71 */     if ((_o1_ instanceof CInviteGangTeamRep)) {
/*  72 */       CInviteGangTeamRep _o_ = (CInviteGangTeamRep)_o1_;
/*  73 */       if (this.inviter != _o_.inviter) return false;
/*  74 */       if (this.gang_teamid != _o_.gang_teamid) return false;
/*  75 */       if (this.reply != _o_.reply) return false;
/*  76 */       return true;
/*     */     }
/*  78 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  82 */     int _h_ = 0;
/*  83 */     _h_ += (int)this.inviter;
/*  84 */     _h_ += (int)this.gang_teamid;
/*  85 */     _h_ += this.reply;
/*  86 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  90 */     StringBuilder _sb_ = new StringBuilder();
/*  91 */     _sb_.append("(");
/*  92 */     _sb_.append(this.inviter).append(",");
/*  93 */     _sb_.append(this.gang_teamid).append(",");
/*  94 */     _sb_.append(this.reply).append(",");
/*  95 */     _sb_.append(")");
/*  96 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CInviteGangTeamRep _o_) {
/* 100 */     if (_o_ == this) return 0;
/* 101 */     int _c_ = 0;
/* 102 */     _c_ = Long.signum(this.inviter - _o_.inviter);
/* 103 */     if (0 != _c_) return _c_;
/* 104 */     _c_ = Long.signum(this.gang_teamid - _o_.gang_teamid);
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = this.reply - _o_.reply;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\CInviteGangTeamRep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */