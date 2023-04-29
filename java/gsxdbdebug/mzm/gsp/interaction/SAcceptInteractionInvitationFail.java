/*     */ package mzm.gsp.interaction;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SAcceptInteractionInvitationFail
/*     */   extends __SAcceptInteractionInvitationFail__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12622601;
/*     */   public static final int SAME_TEAM_ACTIVE_ROLE_AWAY = 1;
/*     */   public static final int DIFFERENT_TEAM_PASSIVE_ROLE_NOT_SINGLE = 2;
/*     */   public static final int TELEPORT_FAILED = 3;
/*     */   public static final int SYNC_FLY_STATUS_FAILED = 4;
/*     */   public static final int ACTIVE_ROLE_STATUS_CONFLICT = 5;
/*     */   public static final int ACTIVE_ROLE_IN_MOVING = 6;
/*     */   public int reason;
/*     */   public long active_role_id;
/*     */   public int interaction_id;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12622601;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SAcceptInteractionInvitationFail() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SAcceptInteractionInvitationFail(int _reason_, long _active_role_id_, int _interaction_id_)
/*     */   {
/*  45 */     this.reason = _reason_;
/*  46 */     this.active_role_id = _active_role_id_;
/*  47 */     this.interaction_id = _interaction_id_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  51 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  55 */     _os_.marshal(this.reason);
/*  56 */     _os_.marshal(this.active_role_id);
/*  57 */     _os_.marshal(this.interaction_id);
/*  58 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  62 */     this.reason = _os_.unmarshal_int();
/*  63 */     this.active_role_id = _os_.unmarshal_long();
/*  64 */     this.interaction_id = _os_.unmarshal_int();
/*  65 */     if (!_validator_()) {
/*  66 */       throw new VerifyError("validator failed");
/*     */     }
/*  68 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  72 */     if (_o1_ == this) return true;
/*  73 */     if ((_o1_ instanceof SAcceptInteractionInvitationFail)) {
/*  74 */       SAcceptInteractionInvitationFail _o_ = (SAcceptInteractionInvitationFail)_o1_;
/*  75 */       if (this.reason != _o_.reason) return false;
/*  76 */       if (this.active_role_id != _o_.active_role_id) return false;
/*  77 */       if (this.interaction_id != _o_.interaction_id) return false;
/*  78 */       return true;
/*     */     }
/*  80 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  84 */     int _h_ = 0;
/*  85 */     _h_ += this.reason;
/*  86 */     _h_ += (int)this.active_role_id;
/*  87 */     _h_ += this.interaction_id;
/*  88 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  92 */     StringBuilder _sb_ = new StringBuilder();
/*  93 */     _sb_.append("(");
/*  94 */     _sb_.append(this.reason).append(",");
/*  95 */     _sb_.append(this.active_role_id).append(",");
/*  96 */     _sb_.append(this.interaction_id).append(",");
/*  97 */     _sb_.append(")");
/*  98 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SAcceptInteractionInvitationFail _o_) {
/* 102 */     if (_o_ == this) return 0;
/* 103 */     int _c_ = 0;
/* 104 */     _c_ = this.reason - _o_.reason;
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = Long.signum(this.active_role_id - _o_.active_role_id);
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = this.interaction_id - _o_.interaction_id;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\interaction\SAcceptInteractionInvitationFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */