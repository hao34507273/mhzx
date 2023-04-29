/*     */ package mzm.gsp.breakegg;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SBreakEggInviteFail
/*     */   extends __SBreakEggInviteFail__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12623365;
/*     */   public static final int ERROR_SYSTEM = 1;
/*     */   public static final int ERROR_USERID = 2;
/*     */   public static final int ERROR_CFG = 3;
/*     */   public static final int ERROR_PARAM = 4;
/*     */   public static final int ERROR_NO_TIMES = 5;
/*     */   public static final int ERROR_IN_INVITE = 6;
/*     */   public static final int ERROR_NOT_IN_GANG = 7;
/*     */   public int activity_id;
/*     */   public int error_code;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12623365;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SBreakEggInviteFail() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SBreakEggInviteFail(int _activity_id_, int _error_code_)
/*     */   {
/*  45 */     this.activity_id = _activity_id_;
/*  46 */     this.error_code = _error_code_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  50 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  54 */     _os_.marshal(this.activity_id);
/*  55 */     _os_.marshal(this.error_code);
/*  56 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  60 */     this.activity_id = _os_.unmarshal_int();
/*  61 */     this.error_code = _os_.unmarshal_int();
/*  62 */     if (!_validator_()) {
/*  63 */       throw new VerifyError("validator failed");
/*     */     }
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  69 */     if (_o1_ == this) return true;
/*  70 */     if ((_o1_ instanceof SBreakEggInviteFail)) {
/*  71 */       SBreakEggInviteFail _o_ = (SBreakEggInviteFail)_o1_;
/*  72 */       if (this.activity_id != _o_.activity_id) return false;
/*  73 */       if (this.error_code != _o_.error_code) return false;
/*  74 */       return true;
/*     */     }
/*  76 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  80 */     int _h_ = 0;
/*  81 */     _h_ += this.activity_id;
/*  82 */     _h_ += this.error_code;
/*  83 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  87 */     StringBuilder _sb_ = new StringBuilder();
/*  88 */     _sb_.append("(");
/*  89 */     _sb_.append(this.activity_id).append(",");
/*  90 */     _sb_.append(this.error_code).append(",");
/*  91 */     _sb_.append(")");
/*  92 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SBreakEggInviteFail _o_) {
/*  96 */     if (_o_ == this) return 0;
/*  97 */     int _c_ = 0;
/*  98 */     _c_ = this.activity_id - _o_.activity_id;
/*  99 */     if (0 != _c_) return _c_;
/* 100 */     _c_ = this.error_code - _o_.error_code;
/* 101 */     if (0 != _c_) return _c_;
/* 102 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\breakegg\SBreakEggInviteFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */