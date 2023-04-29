/*     */ package mzm.gsp;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SLoginRole
/*     */   extends __SLoginRole__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12590083;
/*     */   public static final int ERR_LOGIN_SUCCESS = 0;
/*     */   public static final int ERR_LOGIN_NOT_EXIST = 1;
/*     */   public static final int ERR_LOGIN_ALREADY = 2;
/*     */   public static final int ERR_LOGIN_ROLE_FORBIDE = 3;
/*     */   public static final int ERR_LOGIN_USER_FORBIDE = 4;
/*     */   public int result;
/*     */   public long roleid;
/*     */   public long expire_time;
/*     */   public Octets reason;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12590083;
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
/*     */   public SLoginRole()
/*     */   {
/*  42 */     this.reason = new Octets();
/*     */   }
/*     */   
/*     */   public SLoginRole(int _result_, long _roleid_, long _expire_time_, Octets _reason_) {
/*  46 */     this.result = _result_;
/*  47 */     this.roleid = _roleid_;
/*  48 */     this.expire_time = _expire_time_;
/*  49 */     this.reason = _reason_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  53 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  57 */     _os_.marshal(this.result);
/*  58 */     _os_.marshal(this.roleid);
/*  59 */     _os_.marshal(this.expire_time);
/*  60 */     _os_.marshal(this.reason);
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  65 */     this.result = _os_.unmarshal_int();
/*  66 */     this.roleid = _os_.unmarshal_long();
/*  67 */     this.expire_time = _os_.unmarshal_long();
/*  68 */     this.reason = _os_.unmarshal_Octets();
/*  69 */     if (!_validator_()) {
/*  70 */       throw new VerifyError("validator failed");
/*     */     }
/*  72 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  76 */     if (_o1_ == this) return true;
/*  77 */     if ((_o1_ instanceof SLoginRole)) {
/*  78 */       SLoginRole _o_ = (SLoginRole)_o1_;
/*  79 */       if (this.result != _o_.result) return false;
/*  80 */       if (this.roleid != _o_.roleid) return false;
/*  81 */       if (this.expire_time != _o_.expire_time) return false;
/*  82 */       if (!this.reason.equals(_o_.reason)) return false;
/*  83 */       return true;
/*     */     }
/*  85 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  89 */     int _h_ = 0;
/*  90 */     _h_ += this.result;
/*  91 */     _h_ += (int)this.roleid;
/*  92 */     _h_ += (int)this.expire_time;
/*  93 */     _h_ += this.reason.hashCode();
/*  94 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  98 */     StringBuilder _sb_ = new StringBuilder();
/*  99 */     _sb_.append("(");
/* 100 */     _sb_.append(this.result).append(",");
/* 101 */     _sb_.append(this.roleid).append(",");
/* 102 */     _sb_.append(this.expire_time).append(",");
/* 103 */     _sb_.append("B").append(this.reason.size()).append(",");
/* 104 */     _sb_.append(")");
/* 105 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\SLoginRole.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */