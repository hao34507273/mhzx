/*     */ package mzm.gsp.breakegg;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.breakegg.invite.PCConfirmRep;
/*     */ 
/*     */ public class CConfirmInviteRep
/*     */   extends __CConfirmInviteRep__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12623370;
/*     */   public static final int REPLY_ACCEPT = 1;
/*     */   public static final int REPLY_REFUSE = 2;
/*     */   public int invite_type;
/*     */   public long sessionid;
/*     */   public int reply;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleId = Role.getRoleId(this);
/*  21 */     if (roleId < 0L)
/*     */     {
/*  23 */       return;
/*     */     }
/*  25 */     Role.addRoleProcedure(roleId, new PCConfirmRep(roleId, this.invite_type, this.sessionid, this.reply));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  33 */     return 12623370;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public CConfirmInviteRep() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CConfirmInviteRep(int _invite_type_, long _sessionid_, int _reply_)
/*     */   {
/*  47 */     this.invite_type = _invite_type_;
/*  48 */     this.sessionid = _sessionid_;
/*  49 */     this.reply = _reply_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  53 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  57 */     _os_.marshal(this.invite_type);
/*  58 */     _os_.marshal(this.sessionid);
/*  59 */     _os_.marshal(this.reply);
/*  60 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  64 */     this.invite_type = _os_.unmarshal_int();
/*  65 */     this.sessionid = _os_.unmarshal_long();
/*  66 */     this.reply = _os_.unmarshal_int();
/*  67 */     if (!_validator_()) {
/*  68 */       throw new VerifyError("validator failed");
/*     */     }
/*  70 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  74 */     if (_o1_ == this) return true;
/*  75 */     if ((_o1_ instanceof CConfirmInviteRep)) {
/*  76 */       CConfirmInviteRep _o_ = (CConfirmInviteRep)_o1_;
/*  77 */       if (this.invite_type != _o_.invite_type) return false;
/*  78 */       if (this.sessionid != _o_.sessionid) return false;
/*  79 */       if (this.reply != _o_.reply) return false;
/*  80 */       return true;
/*     */     }
/*  82 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  86 */     int _h_ = 0;
/*  87 */     _h_ += this.invite_type;
/*  88 */     _h_ += (int)this.sessionid;
/*  89 */     _h_ += this.reply;
/*  90 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  94 */     StringBuilder _sb_ = new StringBuilder();
/*  95 */     _sb_.append("(");
/*  96 */     _sb_.append(this.invite_type).append(",");
/*  97 */     _sb_.append(this.sessionid).append(",");
/*  98 */     _sb_.append(this.reply).append(",");
/*  99 */     _sb_.append(")");
/* 100 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CConfirmInviteRep _o_) {
/* 104 */     if (_o_ == this) return 0;
/* 105 */     int _c_ = 0;
/* 106 */     _c_ = this.invite_type - _o_.invite_type;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = Long.signum(this.sessionid - _o_.sessionid);
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     _c_ = this.reply - _o_.reply;
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\breakegg\CConfirmInviteRep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */