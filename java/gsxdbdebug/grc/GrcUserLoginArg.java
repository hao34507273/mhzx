/*     */ package grc;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ 
/*     */ public class GrcUserLoginArg implements Marshal
/*     */ {
/*     */   public Octets appid;
/*     */   public Octets appkey;
/*     */   public Octets account;
/*     */   public Octets access_token;
/*     */   public GrcRoleInfo roleinfo;
/*     */   public int loginip;
/*     */   public int login_privilege;
/*     */   public int reserved1;
/*     */   public int reserved2;
/*     */   
/*     */   public GrcUserLoginArg()
/*     */   {
/*  22 */     this.appid = new Octets();
/*  23 */     this.appkey = new Octets();
/*  24 */     this.account = new Octets();
/*  25 */     this.access_token = new Octets();
/*  26 */     this.roleinfo = new GrcRoleInfo();
/*  27 */     this.login_privilege = 0;
/*  28 */     this.reserved1 = 0;
/*  29 */     this.reserved2 = 0;
/*     */   }
/*     */   
/*     */   public GrcUserLoginArg(Octets _appid_, Octets _appkey_, Octets _account_, Octets _access_token_, GrcRoleInfo _roleinfo_, int _loginip_, int _login_privilege_, int _reserved1_, int _reserved2_) {
/*  33 */     this.appid = _appid_;
/*  34 */     this.appkey = _appkey_;
/*  35 */     this.account = _account_;
/*  36 */     this.access_token = _access_token_;
/*  37 */     this.roleinfo = _roleinfo_;
/*  38 */     this.loginip = _loginip_;
/*  39 */     this.login_privilege = _login_privilege_;
/*  40 */     this.reserved1 = _reserved1_;
/*  41 */     this.reserved2 = _reserved2_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  45 */     if (!this.roleinfo._validator_()) return false;
/*  46 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  50 */     _os_.marshal(this.appid);
/*  51 */     _os_.marshal(this.appkey);
/*  52 */     _os_.marshal(this.account);
/*  53 */     _os_.marshal(this.access_token);
/*  54 */     _os_.marshal(this.roleinfo);
/*  55 */     _os_.marshal(this.loginip);
/*  56 */     _os_.marshal(this.login_privilege);
/*  57 */     _os_.marshal(this.reserved1);
/*  58 */     _os_.marshal(this.reserved2);
/*  59 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  63 */     this.appid = _os_.unmarshal_Octets();
/*  64 */     this.appkey = _os_.unmarshal_Octets();
/*  65 */     this.account = _os_.unmarshal_Octets();
/*  66 */     this.access_token = _os_.unmarshal_Octets();
/*  67 */     this.roleinfo.unmarshal(_os_);
/*  68 */     this.loginip = _os_.unmarshal_int();
/*  69 */     this.login_privilege = _os_.unmarshal_int();
/*  70 */     this.reserved1 = _os_.unmarshal_int();
/*  71 */     this.reserved2 = _os_.unmarshal_int();
/*  72 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  76 */     if (_o1_ == this) return true;
/*  77 */     if ((_o1_ instanceof GrcUserLoginArg)) {
/*  78 */       GrcUserLoginArg _o_ = (GrcUserLoginArg)_o1_;
/*  79 */       if (!this.appid.equals(_o_.appid)) return false;
/*  80 */       if (!this.appkey.equals(_o_.appkey)) return false;
/*  81 */       if (!this.account.equals(_o_.account)) return false;
/*  82 */       if (!this.access_token.equals(_o_.access_token)) return false;
/*  83 */       if (!this.roleinfo.equals(_o_.roleinfo)) return false;
/*  84 */       if (this.loginip != _o_.loginip) return false;
/*  85 */       if (this.login_privilege != _o_.login_privilege) return false;
/*  86 */       if (this.reserved1 != _o_.reserved1) return false;
/*  87 */       if (this.reserved2 != _o_.reserved2) return false;
/*  88 */       return true;
/*     */     }
/*  90 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  94 */     int _h_ = 0;
/*  95 */     _h_ += this.appid.hashCode();
/*  96 */     _h_ += this.appkey.hashCode();
/*  97 */     _h_ += this.account.hashCode();
/*  98 */     _h_ += this.access_token.hashCode();
/*  99 */     _h_ += this.roleinfo.hashCode();
/* 100 */     _h_ += this.loginip;
/* 101 */     _h_ += this.login_privilege;
/* 102 */     _h_ += this.reserved1;
/* 103 */     _h_ += this.reserved2;
/* 104 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 108 */     StringBuilder _sb_ = new StringBuilder();
/* 109 */     _sb_.append("(");
/* 110 */     _sb_.append("B").append(this.appid.size()).append(",");
/* 111 */     _sb_.append("B").append(this.appkey.size()).append(",");
/* 112 */     _sb_.append("B").append(this.account.size()).append(",");
/* 113 */     _sb_.append("B").append(this.access_token.size()).append(",");
/* 114 */     _sb_.append(this.roleinfo).append(",");
/* 115 */     _sb_.append(this.loginip).append(",");
/* 116 */     _sb_.append(this.login_privilege).append(",");
/* 117 */     _sb_.append(this.reserved1).append(",");
/* 118 */     _sb_.append(this.reserved2).append(",");
/* 119 */     _sb_.append(")");
/* 120 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\grc\GrcUserLoginArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */