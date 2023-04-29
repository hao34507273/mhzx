/*     */ package mzm.gsp.corps;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.corps.main.PCInviteCorpsRep;
/*     */ 
/*     */ public class CInviteCorpsRep extends __CInviteCorpsRep__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12617474;
/*     */   public static final int REPLY_ACCEPT = 1;
/*     */   public static final int REPLY_REFUSE = 2;
/*     */   public long inviter;
/*     */   public long sessionid;
/*     */   public int reply;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     long roleId = Role.getRoleId(this);
/*  20 */     if (roleId < 0L) {
/*  21 */       return;
/*     */     }
/*  23 */     Role.addRoleProcedure(roleId, new PCInviteCorpsRep(roleId, this.inviter, this.sessionid, this.reply));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  31 */     return 12617474;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public CInviteCorpsRep() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CInviteCorpsRep(long _inviter_, long _sessionid_, int _reply_)
/*     */   {
/*  45 */     this.inviter = _inviter_;
/*  46 */     this.sessionid = _sessionid_;
/*  47 */     this.reply = _reply_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  51 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  55 */     _os_.marshal(this.inviter);
/*  56 */     _os_.marshal(this.sessionid);
/*  57 */     _os_.marshal(this.reply);
/*  58 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  62 */     this.inviter = _os_.unmarshal_long();
/*  63 */     this.sessionid = _os_.unmarshal_long();
/*  64 */     this.reply = _os_.unmarshal_int();
/*  65 */     if (!_validator_()) {
/*  66 */       throw new VerifyError("validator failed");
/*     */     }
/*  68 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  72 */     if (_o1_ == this) return true;
/*  73 */     if ((_o1_ instanceof CInviteCorpsRep)) {
/*  74 */       CInviteCorpsRep _o_ = (CInviteCorpsRep)_o1_;
/*  75 */       if (this.inviter != _o_.inviter) return false;
/*  76 */       if (this.sessionid != _o_.sessionid) return false;
/*  77 */       if (this.reply != _o_.reply) return false;
/*  78 */       return true;
/*     */     }
/*  80 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  84 */     int _h_ = 0;
/*  85 */     _h_ += (int)this.inviter;
/*  86 */     _h_ += (int)this.sessionid;
/*  87 */     _h_ += this.reply;
/*  88 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  92 */     StringBuilder _sb_ = new StringBuilder();
/*  93 */     _sb_.append("(");
/*  94 */     _sb_.append(this.inviter).append(",");
/*  95 */     _sb_.append(this.sessionid).append(",");
/*  96 */     _sb_.append(this.reply).append(",");
/*  97 */     _sb_.append(")");
/*  98 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CInviteCorpsRep _o_) {
/* 102 */     if (_o_ == this) return 0;
/* 103 */     int _c_ = 0;
/* 104 */     _c_ = Long.signum(this.inviter - _o_.inviter);
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = Long.signum(this.sessionid - _o_.sessionid);
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = this.reply - _o_.reply;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\CInviteCorpsRep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */