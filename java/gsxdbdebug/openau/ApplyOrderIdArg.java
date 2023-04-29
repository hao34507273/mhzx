/*     */ package openau;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ 
/*     */ public class ApplyOrderIdArg implements Marshal
/*     */ {
/*     */   public Octets appid;
/*     */   public Octets account;
/*     */   public long roleid;
/*     */   public int zoneid;
/*     */   public Octets productid;
/*     */   public int productamount;
/*     */   public Octets clientext;
/*     */   public Octets serverext;
/*     */   public int reserved1;
/*     */   public Octets reserved2;
/*     */   
/*     */   public ApplyOrderIdArg()
/*     */   {
/*  23 */     this.appid = new Octets();
/*  24 */     this.account = new Octets();
/*  25 */     this.productid = new Octets();
/*  26 */     this.clientext = new Octets();
/*  27 */     this.serverext = new Octets();
/*  28 */     this.reserved1 = 0;
/*  29 */     this.reserved2 = new Octets();
/*     */   }
/*     */   
/*     */   public ApplyOrderIdArg(Octets _appid_, Octets _account_, long _roleid_, int _zoneid_, Octets _productid_, int _productamount_, Octets _clientext_, Octets _serverext_, int _reserved1_, Octets _reserved2_) {
/*  33 */     this.appid = _appid_;
/*  34 */     this.account = _account_;
/*  35 */     this.roleid = _roleid_;
/*  36 */     this.zoneid = _zoneid_;
/*  37 */     this.productid = _productid_;
/*  38 */     this.productamount = _productamount_;
/*  39 */     this.clientext = _clientext_;
/*  40 */     this.serverext = _serverext_;
/*  41 */     this.reserved1 = _reserved1_;
/*  42 */     this.reserved2 = _reserved2_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  50 */     _os_.marshal(this.appid);
/*  51 */     _os_.marshal(this.account);
/*  52 */     _os_.marshal(this.roleid);
/*  53 */     _os_.marshal(this.zoneid);
/*  54 */     _os_.marshal(this.productid);
/*  55 */     _os_.marshal(this.productamount);
/*  56 */     _os_.marshal(this.clientext);
/*  57 */     _os_.marshal(this.serverext);
/*  58 */     _os_.marshal(this.reserved1);
/*  59 */     _os_.marshal(this.reserved2);
/*  60 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  64 */     this.appid = _os_.unmarshal_Octets();
/*  65 */     this.account = _os_.unmarshal_Octets();
/*  66 */     this.roleid = _os_.unmarshal_long();
/*  67 */     this.zoneid = _os_.unmarshal_int();
/*  68 */     this.productid = _os_.unmarshal_Octets();
/*  69 */     this.productamount = _os_.unmarshal_int();
/*  70 */     this.clientext = _os_.unmarshal_Octets();
/*  71 */     this.serverext = _os_.unmarshal_Octets();
/*  72 */     this.reserved1 = _os_.unmarshal_int();
/*  73 */     this.reserved2 = _os_.unmarshal_Octets();
/*  74 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  78 */     if (_o1_ == this) return true;
/*  79 */     if ((_o1_ instanceof ApplyOrderIdArg)) {
/*  80 */       ApplyOrderIdArg _o_ = (ApplyOrderIdArg)_o1_;
/*  81 */       if (!this.appid.equals(_o_.appid)) return false;
/*  82 */       if (!this.account.equals(_o_.account)) return false;
/*  83 */       if (this.roleid != _o_.roleid) return false;
/*  84 */       if (this.zoneid != _o_.zoneid) return false;
/*  85 */       if (!this.productid.equals(_o_.productid)) return false;
/*  86 */       if (this.productamount != _o_.productamount) return false;
/*  87 */       if (!this.clientext.equals(_o_.clientext)) return false;
/*  88 */       if (!this.serverext.equals(_o_.serverext)) return false;
/*  89 */       if (this.reserved1 != _o_.reserved1) return false;
/*  90 */       if (!this.reserved2.equals(_o_.reserved2)) return false;
/*  91 */       return true;
/*     */     }
/*  93 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  97 */     int _h_ = 0;
/*  98 */     _h_ += this.appid.hashCode();
/*  99 */     _h_ += this.account.hashCode();
/* 100 */     _h_ += (int)this.roleid;
/* 101 */     _h_ += this.zoneid;
/* 102 */     _h_ += this.productid.hashCode();
/* 103 */     _h_ += this.productamount;
/* 104 */     _h_ += this.clientext.hashCode();
/* 105 */     _h_ += this.serverext.hashCode();
/* 106 */     _h_ += this.reserved1;
/* 107 */     _h_ += this.reserved2.hashCode();
/* 108 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 112 */     StringBuilder _sb_ = new StringBuilder();
/* 113 */     _sb_.append("(");
/* 114 */     _sb_.append("B").append(this.appid.size()).append(",");
/* 115 */     _sb_.append("B").append(this.account.size()).append(",");
/* 116 */     _sb_.append(this.roleid).append(",");
/* 117 */     _sb_.append(this.zoneid).append(",");
/* 118 */     _sb_.append("B").append(this.productid.size()).append(",");
/* 119 */     _sb_.append(this.productamount).append(",");
/* 120 */     _sb_.append("B").append(this.clientext.size()).append(",");
/* 121 */     _sb_.append("B").append(this.serverext.size()).append(",");
/* 122 */     _sb_.append(this.reserved1).append(",");
/* 123 */     _sb_.append("B").append(this.reserved2.size()).append(",");
/* 124 */     _sb_.append(")");
/* 125 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\openau\ApplyOrderIdArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */