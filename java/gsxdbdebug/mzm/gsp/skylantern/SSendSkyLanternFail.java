/*     */ package mzm.gsp.skylantern;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ public class SSendSkyLanternFail
/*     */   extends __SSendSkyLanternFail__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12624130;
/*     */   public static final int ERROR_SYSTEM = 1;
/*     */   public static final int ERROR_USERID = 2;
/*     */   public static final int ERROR_CFG = 3;
/*     */   public static final int ERROR_PARAM = 4;
/*     */   public static final int ERROR_NOT_IN_SEND_POSITION = 5;
/*     */   public static final int ERROR_CAN_NOT_JOIN_ACTIVITY = 6;
/*     */   public static final int ERROR_WRONG_TYPE = 7;
/*     */   public static final int ERROR_WRONG_CHANNEL = 8;
/*     */   public static final int ERROR_NOT_IN_GANG = 9;
/*     */   public int activity_id;
/*     */   public int error_code;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12624130;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSendSkyLanternFail() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSendSkyLanternFail(int _activity_id_, int _error_code_)
/*     */   {
/*  47 */     this.activity_id = _activity_id_;
/*  48 */     this.error_code = _error_code_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  52 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  56 */     _os_.marshal(this.activity_id);
/*  57 */     _os_.marshal(this.error_code);
/*  58 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  62 */     this.activity_id = _os_.unmarshal_int();
/*  63 */     this.error_code = _os_.unmarshal_int();
/*  64 */     if (!_validator_()) {
/*  65 */       throw new VerifyError("validator failed");
/*     */     }
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  71 */     if (_o1_ == this) return true;
/*  72 */     if ((_o1_ instanceof SSendSkyLanternFail)) {
/*  73 */       SSendSkyLanternFail _o_ = (SSendSkyLanternFail)_o1_;
/*  74 */       if (this.activity_id != _o_.activity_id) return false;
/*  75 */       if (this.error_code != _o_.error_code) return false;
/*  76 */       return true;
/*     */     }
/*  78 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  82 */     int _h_ = 0;
/*  83 */     _h_ += this.activity_id;
/*  84 */     _h_ += this.error_code;
/*  85 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  89 */     StringBuilder _sb_ = new StringBuilder();
/*  90 */     _sb_.append("(");
/*  91 */     _sb_.append(this.activity_id).append(",");
/*  92 */     _sb_.append(this.error_code).append(",");
/*  93 */     _sb_.append(")");
/*  94 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SSendSkyLanternFail _o_) {
/*  98 */     if (_o_ == this) return 0;
/*  99 */     int _c_ = 0;
/* 100 */     _c_ = this.activity_id - _o_.activity_id;
/* 101 */     if (0 != _c_) return _c_;
/* 102 */     _c_ = this.error_code - _o_.error_code;
/* 103 */     if (0 != _c_) return _c_;
/* 104 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\skylantern\SSendSkyLanternFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */