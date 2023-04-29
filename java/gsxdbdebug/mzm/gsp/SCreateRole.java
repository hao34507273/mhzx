/*     */ package mzm.gsp;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class SCreateRole extends __SCreateRole__ {
/*     */   public static final int PROTOCOL_TYPE = 12590081;
/*     */   public static final int ERR_SUCCESS = 0;
/*     */   public static final int ERR_HAVE_ROLE = 1;
/*     */   public static final int ERR_DUPLICATENAME = 2;
/*     */   public static final int ERR_SENSITIVENAME = 3;
/*     */   public static final int ERR_WRONGNAME = 4;
/*     */   public static final int ERR_USER_FORBID = 5;
/*     */   public static final int ERR_NO_CONFIG = 6;
/*     */   public static final int ERR_UNKNOWN = 7;
/*     */   public static final int ERR_WRONGSTATUS = 8;
/*     */   public static final int ERR_FORBID_CREATE = 9;
/*     */   public static final int ERR_REQUIRE_ACTIVATE = 10;
/*     */   public static final int ERR_HAS_ROLE_IN_DELETE_STATE = 11;
/*     */   public static final int ERR_ACCOUNT_NUM_LIMIT = 12;
/*     */   public static final int ERR_CHANNEL_FORBID_CREATE = 13;
/*     */   public static final int ERR_ROLE_NOT_OPEN = 14;
/*     */   public int result;
/*     */   public RoleInfo roleinfo;
/*     */   
/*     */   protected void process() {}
/*     */   
/*  27 */   public int getType() { return 12590081; }
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
/*     */   public SCreateRole()
/*     */   {
/*  50 */     this.roleinfo = new RoleInfo();
/*     */   }
/*     */   
/*     */   public SCreateRole(int _result_, RoleInfo _roleinfo_) {
/*  54 */     this.result = _result_;
/*  55 */     this.roleinfo = _roleinfo_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  59 */     if (!this.roleinfo._validator_()) return false;
/*  60 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  64 */     _os_.marshal(this.result);
/*  65 */     _os_.marshal(this.roleinfo);
/*  66 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  70 */     this.result = _os_.unmarshal_int();
/*  71 */     this.roleinfo.unmarshal(_os_);
/*  72 */     if (!_validator_()) {
/*  73 */       throw new VerifyError("validator failed");
/*     */     }
/*  75 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  79 */     if (_o1_ == this) return true;
/*  80 */     if ((_o1_ instanceof SCreateRole)) {
/*  81 */       SCreateRole _o_ = (SCreateRole)_o1_;
/*  82 */       if (this.result != _o_.result) return false;
/*  83 */       if (!this.roleinfo.equals(_o_.roleinfo)) return false;
/*  84 */       return true;
/*     */     }
/*  86 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  90 */     int _h_ = 0;
/*  91 */     _h_ += this.result;
/*  92 */     _h_ += this.roleinfo.hashCode();
/*  93 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  97 */     StringBuilder _sb_ = new StringBuilder();
/*  98 */     _sb_.append("(");
/*  99 */     _sb_.append(this.result).append(",");
/* 100 */     _sb_.append(this.roleinfo).append(",");
/* 101 */     _sb_.append(")");
/* 102 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\SCreateRole.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */