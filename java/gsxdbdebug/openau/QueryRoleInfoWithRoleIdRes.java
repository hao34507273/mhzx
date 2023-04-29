/*     */ package openau;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ 
/*     */ public class QueryRoleInfoWithRoleIdRes implements Marshal
/*     */ {
/*     */   public int retcode;
/*     */   public Octets account;
/*     */   public int userid;
/*     */   public int zoneid;
/*     */   public Octets rolename;
/*     */   public int rolelevel;
/*     */   public Octets roleext;
/*     */   public int productamount;
/*     */   public Octets serverext;
/*     */   public int reserved1;
/*     */   public Octets reserved2;
/*     */   
/*     */   public QueryRoleInfoWithRoleIdRes()
/*     */   {
/*  24 */     this.retcode = 9;
/*  25 */     this.account = new Octets();
/*  26 */     this.userid = -1;
/*  27 */     this.rolename = new Octets();
/*  28 */     this.roleext = new Octets();
/*  29 */     this.serverext = new Octets();
/*  30 */     this.reserved1 = 0;
/*  31 */     this.reserved2 = new Octets();
/*     */   }
/*     */   
/*     */   public QueryRoleInfoWithRoleIdRes(int _retcode_, Octets _account_, int _userid_, int _zoneid_, Octets _rolename_, int _rolelevel_, Octets _roleext_, int _productamount_, Octets _serverext_, int _reserved1_, Octets _reserved2_) {
/*  35 */     this.retcode = _retcode_;
/*  36 */     this.account = _account_;
/*  37 */     this.userid = _userid_;
/*  38 */     this.zoneid = _zoneid_;
/*  39 */     this.rolename = _rolename_;
/*  40 */     this.rolelevel = _rolelevel_;
/*  41 */     this.roleext = _roleext_;
/*  42 */     this.productamount = _productamount_;
/*  43 */     this.serverext = _serverext_;
/*  44 */     this.reserved1 = _reserved1_;
/*  45 */     this.reserved2 = _reserved2_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  49 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  53 */     _os_.marshal(this.retcode);
/*  54 */     _os_.marshal(this.account);
/*  55 */     _os_.marshal(this.userid);
/*  56 */     _os_.marshal(this.zoneid);
/*  57 */     _os_.marshal(this.rolename);
/*  58 */     _os_.marshal(this.rolelevel);
/*  59 */     _os_.marshal(this.roleext);
/*  60 */     _os_.marshal(this.productamount);
/*  61 */     _os_.marshal(this.serverext);
/*  62 */     _os_.marshal(this.reserved1);
/*  63 */     _os_.marshal(this.reserved2);
/*  64 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  68 */     this.retcode = _os_.unmarshal_int();
/*  69 */     this.account = _os_.unmarshal_Octets();
/*  70 */     this.userid = _os_.unmarshal_int();
/*  71 */     this.zoneid = _os_.unmarshal_int();
/*  72 */     this.rolename = _os_.unmarshal_Octets();
/*  73 */     this.rolelevel = _os_.unmarshal_int();
/*  74 */     this.roleext = _os_.unmarshal_Octets();
/*  75 */     this.productamount = _os_.unmarshal_int();
/*  76 */     this.serverext = _os_.unmarshal_Octets();
/*  77 */     this.reserved1 = _os_.unmarshal_int();
/*  78 */     this.reserved2 = _os_.unmarshal_Octets();
/*  79 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  83 */     if (_o1_ == this) return true;
/*  84 */     if ((_o1_ instanceof QueryRoleInfoWithRoleIdRes)) {
/*  85 */       QueryRoleInfoWithRoleIdRes _o_ = (QueryRoleInfoWithRoleIdRes)_o1_;
/*  86 */       if (this.retcode != _o_.retcode) return false;
/*  87 */       if (!this.account.equals(_o_.account)) return false;
/*  88 */       if (this.userid != _o_.userid) return false;
/*  89 */       if (this.zoneid != _o_.zoneid) return false;
/*  90 */       if (!this.rolename.equals(_o_.rolename)) return false;
/*  91 */       if (this.rolelevel != _o_.rolelevel) return false;
/*  92 */       if (!this.roleext.equals(_o_.roleext)) return false;
/*  93 */       if (this.productamount != _o_.productamount) return false;
/*  94 */       if (!this.serverext.equals(_o_.serverext)) return false;
/*  95 */       if (this.reserved1 != _o_.reserved1) return false;
/*  96 */       if (!this.reserved2.equals(_o_.reserved2)) return false;
/*  97 */       return true;
/*     */     }
/*  99 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 103 */     int _h_ = 0;
/* 104 */     _h_ += this.retcode;
/* 105 */     _h_ += this.account.hashCode();
/* 106 */     _h_ += this.userid;
/* 107 */     _h_ += this.zoneid;
/* 108 */     _h_ += this.rolename.hashCode();
/* 109 */     _h_ += this.rolelevel;
/* 110 */     _h_ += this.roleext.hashCode();
/* 111 */     _h_ += this.productamount;
/* 112 */     _h_ += this.serverext.hashCode();
/* 113 */     _h_ += this.reserved1;
/* 114 */     _h_ += this.reserved2.hashCode();
/* 115 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 119 */     StringBuilder _sb_ = new StringBuilder();
/* 120 */     _sb_.append("(");
/* 121 */     _sb_.append(this.retcode).append(",");
/* 122 */     _sb_.append("B").append(this.account.size()).append(",");
/* 123 */     _sb_.append(this.userid).append(",");
/* 124 */     _sb_.append(this.zoneid).append(",");
/* 125 */     _sb_.append("B").append(this.rolename.size()).append(",");
/* 126 */     _sb_.append(this.rolelevel).append(",");
/* 127 */     _sb_.append("B").append(this.roleext.size()).append(",");
/* 128 */     _sb_.append(this.productamount).append(",");
/* 129 */     _sb_.append("B").append(this.serverext.size()).append(",");
/* 130 */     _sb_.append(this.reserved1).append(",");
/* 131 */     _sb_.append("B").append(this.reserved2.size()).append(",");
/* 132 */     _sb_.append(")");
/* 133 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\openau\QueryRoleInfoWithRoleIdRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */