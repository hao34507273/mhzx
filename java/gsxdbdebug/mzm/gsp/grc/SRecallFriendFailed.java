/*     */ package mzm.gsp.grc;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class SRecallFriendFailed extends __SRecallFriendFailed__ {
/*     */   public static final int PROTOCOL_TYPE = 12600368;
/*     */   public static final int ERROR_RECALL_SWITCH_NOT_OPEN = -1;
/*     */   public static final int ERROR_RECALL_REPEAT_IN_ONE_PERIOD = -2;
/*     */   public static final int ERROR_RECALL_REDIS_LOCK_FAILED = -3;
/*     */   public static final int ERROR_RECALL_TODAY_FILED = -4;
/*     */   public static final int ERROR_RECALL_FRIEND_FILLED = -5;
/*     */   public static final int ERROR_RECALL_LOGIN_TIME_FIELD = -6;
/*     */   public static final int ERROR_RECALL_LOGIN_TIME = -7;
/*     */   public static final int ERROR_RECALL_MAX_LEVEL_FIELD = -8;
/*     */   public static final int ERROR_RECALL_MAX_LEVEL = -9;
/*     */   public static final int ERROR_RECALL_NET = -10;
/*     */   public static final int ERROR_RECALL_FRIEND_AWARD_FAIL = -11;
/*     */   public static final int ERROR_RECALL_NOT_FRIEND = -12;
/*     */   public int zone_id;
/*     */   public long role_id;
/*     */   public com.goldhuman.Common.Octets open_id;
/*     */   public int retcode;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType() {
/*  27 */     return 12600368;
/*     */   }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SRecallFriendFailed()
/*     */   {
/*  49 */     this.open_id = new com.goldhuman.Common.Octets();
/*     */   }
/*     */   
/*     */   public SRecallFriendFailed(int _zone_id_, long _role_id_, com.goldhuman.Common.Octets _open_id_, int _retcode_) {
/*  53 */     this.zone_id = _zone_id_;
/*  54 */     this.role_id = _role_id_;
/*  55 */     this.open_id = _open_id_;
/*  56 */     this.retcode = _retcode_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  60 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  64 */     _os_.marshal(this.zone_id);
/*  65 */     _os_.marshal(this.role_id);
/*  66 */     _os_.marshal(this.open_id);
/*  67 */     _os_.marshal(this.retcode);
/*  68 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  72 */     this.zone_id = _os_.unmarshal_int();
/*  73 */     this.role_id = _os_.unmarshal_long();
/*  74 */     this.open_id = _os_.unmarshal_Octets();
/*  75 */     this.retcode = _os_.unmarshal_int();
/*  76 */     if (!_validator_()) {
/*  77 */       throw new VerifyError("validator failed");
/*     */     }
/*  79 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  83 */     if (_o1_ == this) return true;
/*  84 */     if ((_o1_ instanceof SRecallFriendFailed)) {
/*  85 */       SRecallFriendFailed _o_ = (SRecallFriendFailed)_o1_;
/*  86 */       if (this.zone_id != _o_.zone_id) return false;
/*  87 */       if (this.role_id != _o_.role_id) return false;
/*  88 */       if (!this.open_id.equals(_o_.open_id)) return false;
/*  89 */       if (this.retcode != _o_.retcode) return false;
/*  90 */       return true;
/*     */     }
/*  92 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  96 */     int _h_ = 0;
/*  97 */     _h_ += this.zone_id;
/*  98 */     _h_ += (int)this.role_id;
/*  99 */     _h_ += this.open_id.hashCode();
/* 100 */     _h_ += this.retcode;
/* 101 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 105 */     StringBuilder _sb_ = new StringBuilder();
/* 106 */     _sb_.append("(");
/* 107 */     _sb_.append(this.zone_id).append(",");
/* 108 */     _sb_.append(this.role_id).append(",");
/* 109 */     _sb_.append("B").append(this.open_id.size()).append(",");
/* 110 */     _sb_.append(this.retcode).append(",");
/* 111 */     _sb_.append(")");
/* 112 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\SRecallFriendFailed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */