/*     */ package openau;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ 
/*     */ public class QueryRoleInfoWithRoleIdArg implements Marshal
/*     */ {
/*     */   public long roleid;
/*     */   public Octets platid;
/*     */   public Octets payplatid;
/*     */   public Octets platorderid;
/*     */   public Octets gameorderid;
/*     */   public Octets productid;
/*     */   public int reserved1;
/*     */   public Octets reserved2;
/*     */   
/*     */   public QueryRoleInfoWithRoleIdArg()
/*     */   {
/*  21 */     this.platid = new Octets();
/*  22 */     this.payplatid = new Octets();
/*  23 */     this.platorderid = new Octets();
/*  24 */     this.gameorderid = new Octets();
/*  25 */     this.productid = new Octets();
/*  26 */     this.reserved1 = 0;
/*  27 */     this.reserved2 = new Octets();
/*     */   }
/*     */   
/*     */   public QueryRoleInfoWithRoleIdArg(long _roleid_, Octets _platid_, Octets _payplatid_, Octets _platorderid_, Octets _gameorderid_, Octets _productid_, int _reserved1_, Octets _reserved2_) {
/*  31 */     this.roleid = _roleid_;
/*  32 */     this.platid = _platid_;
/*  33 */     this.payplatid = _payplatid_;
/*  34 */     this.platorderid = _platorderid_;
/*  35 */     this.gameorderid = _gameorderid_;
/*  36 */     this.productid = _productid_;
/*  37 */     this.reserved1 = _reserved1_;
/*  38 */     this.reserved2 = _reserved2_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  42 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  46 */     _os_.marshal(this.roleid);
/*  47 */     _os_.marshal(this.platid);
/*  48 */     _os_.marshal(this.payplatid);
/*  49 */     _os_.marshal(this.platorderid);
/*  50 */     _os_.marshal(this.gameorderid);
/*  51 */     _os_.marshal(this.productid);
/*  52 */     _os_.marshal(this.reserved1);
/*  53 */     _os_.marshal(this.reserved2);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.roleid = _os_.unmarshal_long();
/*  59 */     this.platid = _os_.unmarshal_Octets();
/*  60 */     this.payplatid = _os_.unmarshal_Octets();
/*  61 */     this.platorderid = _os_.unmarshal_Octets();
/*  62 */     this.gameorderid = _os_.unmarshal_Octets();
/*  63 */     this.productid = _os_.unmarshal_Octets();
/*  64 */     this.reserved1 = _os_.unmarshal_int();
/*  65 */     this.reserved2 = _os_.unmarshal_Octets();
/*  66 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  70 */     if (_o1_ == this) return true;
/*  71 */     if ((_o1_ instanceof QueryRoleInfoWithRoleIdArg)) {
/*  72 */       QueryRoleInfoWithRoleIdArg _o_ = (QueryRoleInfoWithRoleIdArg)_o1_;
/*  73 */       if (this.roleid != _o_.roleid) return false;
/*  74 */       if (!this.platid.equals(_o_.platid)) return false;
/*  75 */       if (!this.payplatid.equals(_o_.payplatid)) return false;
/*  76 */       if (!this.platorderid.equals(_o_.platorderid)) return false;
/*  77 */       if (!this.gameorderid.equals(_o_.gameorderid)) return false;
/*  78 */       if (!this.productid.equals(_o_.productid)) return false;
/*  79 */       if (this.reserved1 != _o_.reserved1) return false;
/*  80 */       if (!this.reserved2.equals(_o_.reserved2)) return false;
/*  81 */       return true;
/*     */     }
/*  83 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  87 */     int _h_ = 0;
/*  88 */     _h_ += (int)this.roleid;
/*  89 */     _h_ += this.platid.hashCode();
/*  90 */     _h_ += this.payplatid.hashCode();
/*  91 */     _h_ += this.platorderid.hashCode();
/*  92 */     _h_ += this.gameorderid.hashCode();
/*  93 */     _h_ += this.productid.hashCode();
/*  94 */     _h_ += this.reserved1;
/*  95 */     _h_ += this.reserved2.hashCode();
/*  96 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 100 */     StringBuilder _sb_ = new StringBuilder();
/* 101 */     _sb_.append("(");
/* 102 */     _sb_.append(this.roleid).append(",");
/* 103 */     _sb_.append("B").append(this.platid.size()).append(",");
/* 104 */     _sb_.append("B").append(this.payplatid.size()).append(",");
/* 105 */     _sb_.append("B").append(this.platorderid.size()).append(",");
/* 106 */     _sb_.append("B").append(this.gameorderid.size()).append(",");
/* 107 */     _sb_.append("B").append(this.productid.size()).append(",");
/* 108 */     _sb_.append(this.reserved1).append(",");
/* 109 */     _sb_.append("B").append(this.reserved2.size()).append(",");
/* 110 */     _sb_.append(")");
/* 111 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\openau\QueryRoleInfoWithRoleIdArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */