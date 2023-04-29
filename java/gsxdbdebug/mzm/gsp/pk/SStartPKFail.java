/*     */ package mzm.gsp.pk;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class SStartPKFail extends __SStartPKFail__ {
/*     */   public static final int PROTOCOL_TYPE = 12619788;
/*     */   public static final int UNKNOWN = -1;
/*     */   public static final int PK_NOT_ENABLED = 1;
/*     */   public static final int LEVEL_TOO_LOW = 2;
/*     */   public static final int TEAM_CHANGED_AFTER_CONFIRMATION = 3;
/*     */   public static final int TARGET_TOO_FAR_AWAY = 4;
/*     */   public static final int IN_COMBAT = 5;
/*     */   public static final int TARGET_IN_SAFE_MAP = 6;
/*     */   public static final int IN_PROTECTION = 7;
/*     */   public static final int IN_FORCE_PROTECTION = 8;
/*     */   public static final int OTHER_STATUS_CONFLICT = 9;
/*     */   public static final int TARGET_IN_ABNORMAL_TEAM_STATE = 10;
/*     */   public static final int IN_OUT_PRISON_PROTECTION = 11;
/*     */   public static final int REACH_MAX_PK_TIMES = 12;
/*     */   public static final int ZERO_MORAL_VALUE = 13;
/*     */   public int retcode;
/*     */   public int role_type;
/*     */   public com.goldhuman.Common.Octets role_name;
/*     */   
/*     */   protected void process() {}
/*     */   
/*  27 */   public int getType() { return 12619788; }
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
/*     */ 
/*     */ 
/*     */   public SStartPKFail()
/*     */   {
/*  50 */     this.role_name = new com.goldhuman.Common.Octets();
/*     */   }
/*     */   
/*     */   public SStartPKFail(int _retcode_, int _role_type_, com.goldhuman.Common.Octets _role_name_) {
/*  54 */     this.retcode = _retcode_;
/*  55 */     this.role_type = _role_type_;
/*  56 */     this.role_name = _role_name_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  60 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  64 */     _os_.marshal(this.retcode);
/*  65 */     _os_.marshal(this.role_type);
/*  66 */     _os_.marshal(this.role_name);
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  71 */     this.retcode = _os_.unmarshal_int();
/*  72 */     this.role_type = _os_.unmarshal_int();
/*  73 */     this.role_name = _os_.unmarshal_Octets();
/*  74 */     if (!_validator_()) {
/*  75 */       throw new VerifyError("validator failed");
/*     */     }
/*  77 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  81 */     if (_o1_ == this) return true;
/*  82 */     if ((_o1_ instanceof SStartPKFail)) {
/*  83 */       SStartPKFail _o_ = (SStartPKFail)_o1_;
/*  84 */       if (this.retcode != _o_.retcode) return false;
/*  85 */       if (this.role_type != _o_.role_type) return false;
/*  86 */       if (!this.role_name.equals(_o_.role_name)) return false;
/*  87 */       return true;
/*     */     }
/*  89 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  93 */     int _h_ = 0;
/*  94 */     _h_ += this.retcode;
/*  95 */     _h_ += this.role_type;
/*  96 */     _h_ += this.role_name.hashCode();
/*  97 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 101 */     StringBuilder _sb_ = new StringBuilder();
/* 102 */     _sb_.append("(");
/* 103 */     _sb_.append(this.retcode).append(",");
/* 104 */     _sb_.append(this.role_type).append(",");
/* 105 */     _sb_.append("B").append(this.role_name.size()).append(",");
/* 106 */     _sb_.append(")");
/* 107 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pk\SStartPKFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */