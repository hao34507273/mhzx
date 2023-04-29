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
/*     */ 
/*     */ 
/*     */ public class SNotifyDeclineInteractionInvitation
/*     */   extends __SNotifyDeclineInteractionInvitation__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12622600;
/*     */   public long passive_role_id;
/*     */   public int interaction_id;
/*     */   public int reason;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12622600;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SNotifyDeclineInteractionInvitation() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SNotifyDeclineInteractionInvitation(long _passive_role_id_, int _interaction_id_, int _reason_)
/*     */   {
/*  38 */     this.passive_role_id = _passive_role_id_;
/*  39 */     this.interaction_id = _interaction_id_;
/*  40 */     this.reason = _reason_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.passive_role_id);
/*  49 */     _os_.marshal(this.interaction_id);
/*  50 */     _os_.marshal(this.reason);
/*  51 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  55 */     this.passive_role_id = _os_.unmarshal_long();
/*  56 */     this.interaction_id = _os_.unmarshal_int();
/*  57 */     this.reason = _os_.unmarshal_int();
/*  58 */     if (!_validator_()) {
/*  59 */       throw new VerifyError("validator failed");
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  65 */     if (_o1_ == this) return true;
/*  66 */     if ((_o1_ instanceof SNotifyDeclineInteractionInvitation)) {
/*  67 */       SNotifyDeclineInteractionInvitation _o_ = (SNotifyDeclineInteractionInvitation)_o1_;
/*  68 */       if (this.passive_role_id != _o_.passive_role_id) return false;
/*  69 */       if (this.interaction_id != _o_.interaction_id) return false;
/*  70 */       if (this.reason != _o_.reason) return false;
/*  71 */       return true;
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  77 */     int _h_ = 0;
/*  78 */     _h_ += (int)this.passive_role_id;
/*  79 */     _h_ += this.interaction_id;
/*  80 */     _h_ += this.reason;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.passive_role_id).append(",");
/*  88 */     _sb_.append(this.interaction_id).append(",");
/*  89 */     _sb_.append(this.reason).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SNotifyDeclineInteractionInvitation _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = Long.signum(this.passive_role_id - _o_.passive_role_id);
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = this.interaction_id - _o_.interaction_id;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = this.reason - _o_.reason;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\interaction\SNotifyDeclineInteractionInvitation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */