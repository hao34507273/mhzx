/*     */ package mzm.gsp.interaction;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ public class SInviteInteractionFail
/*     */   extends __SInviteInteractionFail__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12622593;
/*     */   public static final int ACTIVE_ROLE_BANNED = 1;
/*     */   public static final int ACTIVE_ROLE_LEVEL_TOO_LOW = 2;
/*     */   public static final int PASSIVE_ROLE_LEVEL_TOO_LOW = 3;
/*     */   public static final int UNAVAILABLE_TO_SAME_GENDER = 4;
/*     */   public static final int PASSIVE_ROLE_NOT_TEAMMATE_NOT_SINGLE = 5;
/*     */   public static final int ACTIVE_ROLE_IN_INVITING = 6;
/*     */   public static final int ACTIVE_ROLE_BEING_INVITED = 7;
/*     */   public static final int PASSIVE_ROLE_IN_INVITING = 8;
/*     */   public static final int PASSIVE_ROLE_BEING_INVITED = 9;
/*     */   public static final int IN_DIFFERENT_SCENE = 10;
/*     */   public static final int PASSIVE_ROLE_OFFLINE = 11;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12622593;
/*     */   }
/*     */   
/*     */ 
/*     */   public static final int PASSIVE_ROLE_IN_COMBAT = 12;
/*     */   
/*     */   public static final int PASSIVE_ROLE_IN_WATCHING_MOON = 13;
/*     */   
/*     */   public static final int PASSIVE_ROLE_IN_ESCORTING = 14;
/*     */   
/*     */   public static final int PASSIVE_ROLE_IN_MARRIAGE_PARADE = 15;
/*     */   
/*     */   public static final int PASSIVE_ROLE_IN_PRISON = 16;
/*     */   
/*     */   public static final int PASSIVE_ROLE_IN_OBSERVING_FIGHT = 17;
/*     */   
/*     */   public static final int ACTIVE_ROLE_IN_MOVING = 18;
/*     */   
/*     */   public static final int ACTIVE_ROLE_ON_MULTI_ROLE_MOUNT = 19;
/*     */   
/*     */   public static final int PASSIVE_ROLE_ON_MULTI_ROLE_MOUNT = 20;
/*     */   
/*     */   public static final int ACTIVE_ROLE_NOT_LEADER_PASSIVE_ROLE_NOT_TEAMMATE = 21;
/*     */   
/*     */   public int reason;
/*     */   
/*     */   public long passive_role_id;
/*     */   
/*     */   public int interaction_id;
/*     */   public SInviteInteractionFail() {}
/*     */   
/*     */   public SInviteInteractionFail(int _reason_, long _passive_role_id_, int _interaction_id_)
/*     */   {
/*  60 */     this.reason = _reason_;
/*  61 */     this.passive_role_id = _passive_role_id_;
/*  62 */     this.interaction_id = _interaction_id_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  66 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  70 */     _os_.marshal(this.reason);
/*  71 */     _os_.marshal(this.passive_role_id);
/*  72 */     _os_.marshal(this.interaction_id);
/*  73 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  77 */     this.reason = _os_.unmarshal_int();
/*  78 */     this.passive_role_id = _os_.unmarshal_long();
/*  79 */     this.interaction_id = _os_.unmarshal_int();
/*  80 */     if (!_validator_()) {
/*  81 */       throw new VerifyError("validator failed");
/*     */     }
/*  83 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  87 */     if (_o1_ == this) return true;
/*  88 */     if ((_o1_ instanceof SInviteInteractionFail)) {
/*  89 */       SInviteInteractionFail _o_ = (SInviteInteractionFail)_o1_;
/*  90 */       if (this.reason != _o_.reason) return false;
/*  91 */       if (this.passive_role_id != _o_.passive_role_id) return false;
/*  92 */       if (this.interaction_id != _o_.interaction_id) return false;
/*  93 */       return true;
/*     */     }
/*  95 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  99 */     int _h_ = 0;
/* 100 */     _h_ += this.reason;
/* 101 */     _h_ += (int)this.passive_role_id;
/* 102 */     _h_ += this.interaction_id;
/* 103 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 107 */     StringBuilder _sb_ = new StringBuilder();
/* 108 */     _sb_.append("(");
/* 109 */     _sb_.append(this.reason).append(",");
/* 110 */     _sb_.append(this.passive_role_id).append(",");
/* 111 */     _sb_.append(this.interaction_id).append(",");
/* 112 */     _sb_.append(")");
/* 113 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SInviteInteractionFail _o_) {
/* 117 */     if (_o_ == this) return 0;
/* 118 */     int _c_ = 0;
/* 119 */     _c_ = this.reason - _o_.reason;
/* 120 */     if (0 != _c_) return _c_;
/* 121 */     _c_ = Long.signum(this.passive_role_id - _o_.passive_role_id);
/* 122 */     if (0 != _c_) return _c_;
/* 123 */     _c_ = this.interaction_id - _o_.interaction_id;
/* 124 */     if (0 != _c_) return _c_;
/* 125 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\interaction\SInviteInteractionFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */