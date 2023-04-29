/*     */ package mzm.gsp.interaction;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SNotifyStartInteraction
/*     */   extends __SNotifyStartInteraction__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12622597;
/*     */   public long active_role_id;
/*     */   public long passive_role_id;
/*     */   public long inviter_role_id;
/*     */   public long invitee_role_id;
/*     */   public int interaction_id;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12622597;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SNotifyStartInteraction() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SNotifyStartInteraction(long _active_role_id_, long _passive_role_id_, long _inviter_role_id_, long _invitee_role_id_, int _interaction_id_)
/*     */   {
/*  40 */     this.active_role_id = _active_role_id_;
/*  41 */     this.passive_role_id = _passive_role_id_;
/*  42 */     this.inviter_role_id = _inviter_role_id_;
/*  43 */     this.invitee_role_id = _invitee_role_id_;
/*  44 */     this.interaction_id = _interaction_id_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.active_role_id);
/*  53 */     _os_.marshal(this.passive_role_id);
/*  54 */     _os_.marshal(this.inviter_role_id);
/*  55 */     _os_.marshal(this.invitee_role_id);
/*  56 */     _os_.marshal(this.interaction_id);
/*  57 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  61 */     this.active_role_id = _os_.unmarshal_long();
/*  62 */     this.passive_role_id = _os_.unmarshal_long();
/*  63 */     this.inviter_role_id = _os_.unmarshal_long();
/*  64 */     this.invitee_role_id = _os_.unmarshal_long();
/*  65 */     this.interaction_id = _os_.unmarshal_int();
/*  66 */     if (!_validator_()) {
/*  67 */       throw new VerifyError("validator failed");
/*     */     }
/*  69 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  73 */     if (_o1_ == this) return true;
/*  74 */     if ((_o1_ instanceof SNotifyStartInteraction)) {
/*  75 */       SNotifyStartInteraction _o_ = (SNotifyStartInteraction)_o1_;
/*  76 */       if (this.active_role_id != _o_.active_role_id) return false;
/*  77 */       if (this.passive_role_id != _o_.passive_role_id) return false;
/*  78 */       if (this.inviter_role_id != _o_.inviter_role_id) return false;
/*  79 */       if (this.invitee_role_id != _o_.invitee_role_id) return false;
/*  80 */       if (this.interaction_id != _o_.interaction_id) return false;
/*  81 */       return true;
/*     */     }
/*  83 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  87 */     int _h_ = 0;
/*  88 */     _h_ += (int)this.active_role_id;
/*  89 */     _h_ += (int)this.passive_role_id;
/*  90 */     _h_ += (int)this.inviter_role_id;
/*  91 */     _h_ += (int)this.invitee_role_id;
/*  92 */     _h_ += this.interaction_id;
/*  93 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  97 */     StringBuilder _sb_ = new StringBuilder();
/*  98 */     _sb_.append("(");
/*  99 */     _sb_.append(this.active_role_id).append(",");
/* 100 */     _sb_.append(this.passive_role_id).append(",");
/* 101 */     _sb_.append(this.inviter_role_id).append(",");
/* 102 */     _sb_.append(this.invitee_role_id).append(",");
/* 103 */     _sb_.append(this.interaction_id).append(",");
/* 104 */     _sb_.append(")");
/* 105 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SNotifyStartInteraction _o_) {
/* 109 */     if (_o_ == this) return 0;
/* 110 */     int _c_ = 0;
/* 111 */     _c_ = Long.signum(this.active_role_id - _o_.active_role_id);
/* 112 */     if (0 != _c_) return _c_;
/* 113 */     _c_ = Long.signum(this.passive_role_id - _o_.passive_role_id);
/* 114 */     if (0 != _c_) return _c_;
/* 115 */     _c_ = Long.signum(this.inviter_role_id - _o_.inviter_role_id);
/* 116 */     if (0 != _c_) return _c_;
/* 117 */     _c_ = Long.signum(this.invitee_role_id - _o_.invitee_role_id);
/* 118 */     if (0 != _c_) return _c_;
/* 119 */     _c_ = this.interaction_id - _o_.interaction_id;
/* 120 */     if (0 != _c_) return _c_;
/* 121 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\interaction\SNotifyStartInteraction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */