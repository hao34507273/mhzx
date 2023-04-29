/*     */ package mzm.gsp.crossbattle;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class SCanvassInCrossBattleFail
/*     */   extends __SCanvassInCrossBattleFail__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12616983;
/*     */   public static final int MODULE_CLOSE_OR_ROLE_FORBIDDEN = -1;
/*     */   public static final int ROLE_STATUS_ERROR = -2;
/*     */   public static final int PARAM_ERROR = -3;
/*     */   public static final int CHECK_NPC_SERVICE_ERROR = -4;
/*     */   public static final int ACTIVITY_NOT_OPEN = 1;
/*     */   public static final int ACTIVITY_STAGE_ERROR = 2;
/*     */   public static final int NOT_IN_CORPS = 3;
/*     */   public static final int CORPS_NOT_REGISTER = 4;
/*     */   public static final int CHAT_IN_TRUMPET_FAIL = 5;
/*     */   public static final int IN_COOLDOWN_TIME = 6;
/*     */   public int res;
/*     */   public int canvass_timestamp;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12616983;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SCanvassInCrossBattleFail() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SCanvassInCrossBattleFail(int _res_, int _canvass_timestamp_)
/*     */   {
/*  48 */     this.res = _res_;
/*  49 */     this.canvass_timestamp = _canvass_timestamp_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  53 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  57 */     _os_.marshal(this.res);
/*  58 */     _os_.marshal(this.canvass_timestamp);
/*  59 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  63 */     this.res = _os_.unmarshal_int();
/*  64 */     this.canvass_timestamp = _os_.unmarshal_int();
/*  65 */     if (!_validator_()) {
/*  66 */       throw new VerifyError("validator failed");
/*     */     }
/*  68 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  72 */     if (_o1_ == this) return true;
/*  73 */     if ((_o1_ instanceof SCanvassInCrossBattleFail)) {
/*  74 */       SCanvassInCrossBattleFail _o_ = (SCanvassInCrossBattleFail)_o1_;
/*  75 */       if (this.res != _o_.res) return false;
/*  76 */       if (this.canvass_timestamp != _o_.canvass_timestamp) return false;
/*  77 */       return true;
/*     */     }
/*  79 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  83 */     int _h_ = 0;
/*  84 */     _h_ += this.res;
/*  85 */     _h_ += this.canvass_timestamp;
/*  86 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  90 */     StringBuilder _sb_ = new StringBuilder();
/*  91 */     _sb_.append("(");
/*  92 */     _sb_.append(this.res).append(",");
/*  93 */     _sb_.append(this.canvass_timestamp).append(",");
/*  94 */     _sb_.append(")");
/*  95 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SCanvassInCrossBattleFail _o_) {
/*  99 */     if (_o_ == this) return 0;
/* 100 */     int _c_ = 0;
/* 101 */     _c_ = this.res - _o_.res;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     _c_ = this.canvass_timestamp - _o_.canvass_timestamp;
/* 104 */     if (0 != _c_) return _c_;
/* 105 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\SCanvassInCrossBattleFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */