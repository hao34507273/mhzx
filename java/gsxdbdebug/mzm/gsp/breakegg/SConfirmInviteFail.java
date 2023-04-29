/*     */ package mzm.gsp.breakegg;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class SConfirmInviteFail extends __SConfirmInviteFail__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12623366;
/*     */   public static final int ERROR_SYSTEM = 1;
/*     */   public static final int ERROR_USERID = 2;
/*     */   public static final int ERROR_CFG = 3;
/*     */   public static final int ERROR_PARAM = 4;
/*     */   public static final int ERROR_ALREADY_IN = 5;
/*     */   public static final int ERROR_INVITER_CANNOT_CHOOSE = 6;
/*     */   public static final int ERROR_NOT_IN_RANGE = 7;
/*     */   public static final int ERROR_TIME_OUT = 8;
/*     */   public static final int ERROR_CHOOSED_ALREADY = 9;
/*     */   public static final int ERROR_LEVEL_NOT_FIT = 10;
/*     */   public int invite_type;
/*     */   public long sessionid;
/*     */   public int error_code;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12623366;
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
/*     */   public SConfirmInviteFail() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SConfirmInviteFail(int _invite_type_, long _sessionid_, int _error_code_)
/*     */   {
/*  49 */     this.invite_type = _invite_type_;
/*  50 */     this.sessionid = _sessionid_;
/*  51 */     this.error_code = _error_code_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  55 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  59 */     _os_.marshal(this.invite_type);
/*  60 */     _os_.marshal(this.sessionid);
/*  61 */     _os_.marshal(this.error_code);
/*  62 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  66 */     this.invite_type = _os_.unmarshal_int();
/*  67 */     this.sessionid = _os_.unmarshal_long();
/*  68 */     this.error_code = _os_.unmarshal_int();
/*  69 */     if (!_validator_()) {
/*  70 */       throw new VerifyError("validator failed");
/*     */     }
/*  72 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  76 */     if (_o1_ == this) return true;
/*  77 */     if ((_o1_ instanceof SConfirmInviteFail)) {
/*  78 */       SConfirmInviteFail _o_ = (SConfirmInviteFail)_o1_;
/*  79 */       if (this.invite_type != _o_.invite_type) return false;
/*  80 */       if (this.sessionid != _o_.sessionid) return false;
/*  81 */       if (this.error_code != _o_.error_code) return false;
/*  82 */       return true;
/*     */     }
/*  84 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  88 */     int _h_ = 0;
/*  89 */     _h_ += this.invite_type;
/*  90 */     _h_ += (int)this.sessionid;
/*  91 */     _h_ += this.error_code;
/*  92 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  96 */     StringBuilder _sb_ = new StringBuilder();
/*  97 */     _sb_.append("(");
/*  98 */     _sb_.append(this.invite_type).append(",");
/*  99 */     _sb_.append(this.sessionid).append(",");
/* 100 */     _sb_.append(this.error_code).append(",");
/* 101 */     _sb_.append(")");
/* 102 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SConfirmInviteFail _o_) {
/* 106 */     if (_o_ == this) return 0;
/* 107 */     int _c_ = 0;
/* 108 */     _c_ = this.invite_type - _o_.invite_type;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     _c_ = Long.signum(this.sessionid - _o_.sessionid);
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     _c_ = this.error_code - _o_.error_code;
/* 113 */     if (0 != _c_) return _c_;
/* 114 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\breakegg\SConfirmInviteFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */