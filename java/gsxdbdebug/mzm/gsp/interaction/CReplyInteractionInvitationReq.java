/*     */ package mzm.gsp.interaction;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ 
/*     */ public class CReplyInteractionInvitationReq extends __CReplyInteractionInvitationReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12622598;
/*     */   public static final int USER = 0;
/*     */   public static final int ROLE_MODEL_NOT_COMPATIBLE = 1;
/*     */   public long active_role_id;
/*     */   public int interaction_id;
/*     */   public int is_accepted;
/*     */   public int reason;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     long passiveRoleId = Role.getRoleId(this);
/*  20 */     if (this.is_accepted != 0)
/*     */     {
/*  22 */       Role.addRoleProcedure(passiveRoleId, new mzm.gsp.interaction.main.PAcceptInteractionInvitation(this.interaction_id, this.active_role_id, passiveRoleId));
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/*  27 */       Role.addRoleProcedure(passiveRoleId, new mzm.gsp.interaction.main.PDeclineInteractionInvitation(this.interaction_id, this.active_role_id, passiveRoleId, this.reason));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  37 */     return 12622598;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public CReplyInteractionInvitationReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public CReplyInteractionInvitationReq(long _active_role_id_, int _interaction_id_, int _is_accepted_, int _reason_)
/*     */   {
/*  52 */     this.active_role_id = _active_role_id_;
/*  53 */     this.interaction_id = _interaction_id_;
/*  54 */     this.is_accepted = _is_accepted_;
/*  55 */     this.reason = _reason_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  59 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  63 */     _os_.marshal(this.active_role_id);
/*  64 */     _os_.marshal(this.interaction_id);
/*  65 */     _os_.marshal(this.is_accepted);
/*  66 */     _os_.marshal(this.reason);
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  71 */     this.active_role_id = _os_.unmarshal_long();
/*  72 */     this.interaction_id = _os_.unmarshal_int();
/*  73 */     this.is_accepted = _os_.unmarshal_int();
/*  74 */     this.reason = _os_.unmarshal_int();
/*  75 */     if (!_validator_()) {
/*  76 */       throw new VerifyError("validator failed");
/*     */     }
/*  78 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  82 */     if (_o1_ == this) return true;
/*  83 */     if ((_o1_ instanceof CReplyInteractionInvitationReq)) {
/*  84 */       CReplyInteractionInvitationReq _o_ = (CReplyInteractionInvitationReq)_o1_;
/*  85 */       if (this.active_role_id != _o_.active_role_id) return false;
/*  86 */       if (this.interaction_id != _o_.interaction_id) return false;
/*  87 */       if (this.is_accepted != _o_.is_accepted) return false;
/*  88 */       if (this.reason != _o_.reason) return false;
/*  89 */       return true;
/*     */     }
/*  91 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  95 */     int _h_ = 0;
/*  96 */     _h_ += (int)this.active_role_id;
/*  97 */     _h_ += this.interaction_id;
/*  98 */     _h_ += this.is_accepted;
/*  99 */     _h_ += this.reason;
/* 100 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 104 */     StringBuilder _sb_ = new StringBuilder();
/* 105 */     _sb_.append("(");
/* 106 */     _sb_.append(this.active_role_id).append(",");
/* 107 */     _sb_.append(this.interaction_id).append(",");
/* 108 */     _sb_.append(this.is_accepted).append(",");
/* 109 */     _sb_.append(this.reason).append(",");
/* 110 */     _sb_.append(")");
/* 111 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CReplyInteractionInvitationReq _o_) {
/* 115 */     if (_o_ == this) return 0;
/* 116 */     int _c_ = 0;
/* 117 */     _c_ = Long.signum(this.active_role_id - _o_.active_role_id);
/* 118 */     if (0 != _c_) return _c_;
/* 119 */     _c_ = this.interaction_id - _o_.interaction_id;
/* 120 */     if (0 != _c_) return _c_;
/* 121 */     _c_ = this.is_accepted - _o_.is_accepted;
/* 122 */     if (0 != _c_) return _c_;
/* 123 */     _c_ = this.reason - _o_.reason;
/* 124 */     if (0 != _c_) return _c_;
/* 125 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\interaction\CReplyInteractionInvitationReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */