/*     */ package gnet.link;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SetLogin
/*     */   extends __SetLogin__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 1048583;
/*     */   public static final int eLogout = 0;
/*     */   public static final int eLogin = 1;
/*     */   public int linksid;
/*     */   public int login;
/*     */   public long roleid;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  25 */     return 1048583;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SetLogin() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SetLogin(int _linksid_, int _login_, long _roleid_)
/*     */   {
/*  39 */     this.linksid = _linksid_;
/*  40 */     this.login = _login_;
/*  41 */     this.roleid = _roleid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  45 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  49 */     _os_.marshal(this.linksid);
/*  50 */     _os_.marshal(this.login);
/*  51 */     _os_.marshal(this.roleid);
/*  52 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  56 */     this.linksid = _os_.unmarshal_int();
/*  57 */     this.login = _os_.unmarshal_int();
/*  58 */     this.roleid = _os_.unmarshal_long();
/*  59 */     if (!_validator_()) {
/*  60 */       throw new VerifyError("validator failed");
/*     */     }
/*  62 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  66 */     if (_o1_ == this) return true;
/*  67 */     if ((_o1_ instanceof SetLogin)) {
/*  68 */       SetLogin _o_ = (SetLogin)_o1_;
/*  69 */       if (this.linksid != _o_.linksid) return false;
/*  70 */       if (this.login != _o_.login) return false;
/*  71 */       if (this.roleid != _o_.roleid) return false;
/*  72 */       return true;
/*     */     }
/*  74 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  78 */     int _h_ = 0;
/*  79 */     _h_ += this.linksid;
/*  80 */     _h_ += this.login;
/*  81 */     _h_ += (int)this.roleid;
/*  82 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  86 */     StringBuilder _sb_ = new StringBuilder();
/*  87 */     _sb_.append("(");
/*  88 */     _sb_.append(this.linksid).append(",");
/*  89 */     _sb_.append(this.login).append(",");
/*  90 */     _sb_.append(this.roleid).append(",");
/*  91 */     _sb_.append(")");
/*  92 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SetLogin _o_) {
/*  96 */     if (_o_ == this) return 0;
/*  97 */     int _c_ = 0;
/*  98 */     _c_ = this.linksid - _o_.linksid;
/*  99 */     if (0 != _c_) return _c_;
/* 100 */     _c_ = this.login - _o_.login;
/* 101 */     if (0 != _c_) return _c_;
/* 102 */     _c_ = Long.signum(this.roleid - _o_.roleid);
/* 103 */     if (0 != _c_) return _c_;
/* 104 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\gnet\link\SetLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */