/*     */ package apollo;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class ApolloGetAuthKeyRsp extends __ApolloGetAuthKeyRsp__ { public static final int PROTOCOL_TYPE = 12072;
/*     */   public int retcode;
/*     */   public com.goldhuman.Common.Octets account;
/*     */   public long roleid;
/*     */   public long main_svr_id;
/*     */   public java.util.ArrayList<ServerUrlInfo> main_svr_urls;
/*     */   public long slave_svr_id;
/*     */   public java.util.ArrayList<ServerUrlInfo> slave_svr_urls;
/*     */   public com.goldhuman.Common.Octets auth_key;
/*     */   public int expire_in;
/*     */   public com.goldhuman.Common.Octets async_data;
/*     */   public int reserved1;
/*     */   public int reserved2;
/*     */   
/*  19 */   protected void process() { mzm.gsp.apollo.main.ApolloInterface.onApolloGetAuthKeyRsp(this); }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  27 */     return 12072;
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
/*     */ 
/*     */ 
/*     */   public ApolloGetAuthKeyRsp()
/*     */   {
/*  44 */     this.retcode = 9;
/*  45 */     this.account = new com.goldhuman.Common.Octets();
/*  46 */     this.roleid = 0L;
/*  47 */     this.main_svr_id = 0L;
/*  48 */     this.main_svr_urls = new java.util.ArrayList();
/*  49 */     this.slave_svr_id = 0L;
/*  50 */     this.slave_svr_urls = new java.util.ArrayList();
/*  51 */     this.auth_key = new com.goldhuman.Common.Octets();
/*  52 */     this.expire_in = 0;
/*  53 */     this.async_data = new com.goldhuman.Common.Octets();
/*  54 */     this.reserved1 = 0;
/*  55 */     this.reserved2 = 0;
/*     */   }
/*     */   
/*     */   public ApolloGetAuthKeyRsp(int _retcode_, com.goldhuman.Common.Octets _account_, long _roleid_, long _main_svr_id_, java.util.ArrayList<ServerUrlInfo> _main_svr_urls_, long _slave_svr_id_, java.util.ArrayList<ServerUrlInfo> _slave_svr_urls_, com.goldhuman.Common.Octets _auth_key_, int _expire_in_, com.goldhuman.Common.Octets _async_data_, int _reserved1_, int _reserved2_) {
/*  59 */     this.retcode = _retcode_;
/*  60 */     this.account = _account_;
/*  61 */     this.roleid = _roleid_;
/*  62 */     this.main_svr_id = _main_svr_id_;
/*  63 */     this.main_svr_urls = _main_svr_urls_;
/*  64 */     this.slave_svr_id = _slave_svr_id_;
/*  65 */     this.slave_svr_urls = _slave_svr_urls_;
/*  66 */     this.auth_key = _auth_key_;
/*  67 */     this.expire_in = _expire_in_;
/*  68 */     this.async_data = _async_data_;
/*  69 */     this.reserved1 = _reserved1_;
/*  70 */     this.reserved2 = _reserved2_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  74 */     for (ServerUrlInfo _v_ : this.main_svr_urls)
/*  75 */       if (!_v_._validator_()) return false;
/*  76 */     for (ServerUrlInfo _v_ : this.slave_svr_urls)
/*  77 */       if (!_v_._validator_()) return false;
/*  78 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  82 */     _os_.marshal(this.retcode);
/*  83 */     _os_.marshal(this.account);
/*  84 */     _os_.marshal(this.roleid);
/*  85 */     _os_.marshal(this.main_svr_id);
/*  86 */     _os_.compact_uint32(this.main_svr_urls.size());
/*  87 */     for (ServerUrlInfo _v_ : this.main_svr_urls) {
/*  88 */       _os_.marshal(_v_);
/*     */     }
/*  90 */     _os_.marshal(this.slave_svr_id);
/*  91 */     _os_.compact_uint32(this.slave_svr_urls.size());
/*  92 */     for (ServerUrlInfo _v_ : this.slave_svr_urls) {
/*  93 */       _os_.marshal(_v_);
/*     */     }
/*  95 */     _os_.marshal(this.auth_key);
/*  96 */     _os_.marshal(this.expire_in);
/*  97 */     _os_.marshal(this.async_data);
/*  98 */     _os_.marshal(this.reserved1);
/*  99 */     _os_.marshal(this.reserved2);
/* 100 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 104 */     this.retcode = _os_.unmarshal_int();
/* 105 */     this.account = _os_.unmarshal_Octets();
/* 106 */     this.roleid = _os_.unmarshal_long();
/* 107 */     this.main_svr_id = _os_.unmarshal_long();
/* 108 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 109 */       ServerUrlInfo _v_ = new ServerUrlInfo();
/* 110 */       _v_.unmarshal(_os_);
/* 111 */       this.main_svr_urls.add(_v_);
/*     */     }
/* 113 */     this.slave_svr_id = _os_.unmarshal_long();
/* 114 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 115 */       ServerUrlInfo _v_ = new ServerUrlInfo();
/* 116 */       _v_.unmarshal(_os_);
/* 117 */       this.slave_svr_urls.add(_v_);
/*     */     }
/* 119 */     this.auth_key = _os_.unmarshal_Octets();
/* 120 */     this.expire_in = _os_.unmarshal_int();
/* 121 */     this.async_data = _os_.unmarshal_Octets();
/* 122 */     this.reserved1 = _os_.unmarshal_int();
/* 123 */     this.reserved2 = _os_.unmarshal_int();
/* 124 */     if (!_validator_()) {
/* 125 */       throw new VerifyError("validator failed");
/*     */     }
/* 127 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/* 131 */     if (_o1_ == this) return true;
/* 132 */     if ((_o1_ instanceof ApolloGetAuthKeyRsp)) {
/* 133 */       ApolloGetAuthKeyRsp _o_ = (ApolloGetAuthKeyRsp)_o1_;
/* 134 */       if (this.retcode != _o_.retcode) return false;
/* 135 */       if (!this.account.equals(_o_.account)) return false;
/* 136 */       if (this.roleid != _o_.roleid) return false;
/* 137 */       if (this.main_svr_id != _o_.main_svr_id) return false;
/* 138 */       if (!this.main_svr_urls.equals(_o_.main_svr_urls)) return false;
/* 139 */       if (this.slave_svr_id != _o_.slave_svr_id) return false;
/* 140 */       if (!this.slave_svr_urls.equals(_o_.slave_svr_urls)) return false;
/* 141 */       if (!this.auth_key.equals(_o_.auth_key)) return false;
/* 142 */       if (this.expire_in != _o_.expire_in) return false;
/* 143 */       if (!this.async_data.equals(_o_.async_data)) return false;
/* 144 */       if (this.reserved1 != _o_.reserved1) return false;
/* 145 */       if (this.reserved2 != _o_.reserved2) return false;
/* 146 */       return true;
/*     */     }
/* 148 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 152 */     int _h_ = 0;
/* 153 */     _h_ += this.retcode;
/* 154 */     _h_ += this.account.hashCode();
/* 155 */     _h_ += (int)this.roleid;
/* 156 */     _h_ += (int)this.main_svr_id;
/* 157 */     _h_ += this.main_svr_urls.hashCode();
/* 158 */     _h_ += (int)this.slave_svr_id;
/* 159 */     _h_ += this.slave_svr_urls.hashCode();
/* 160 */     _h_ += this.auth_key.hashCode();
/* 161 */     _h_ += this.expire_in;
/* 162 */     _h_ += this.async_data.hashCode();
/* 163 */     _h_ += this.reserved1;
/* 164 */     _h_ += this.reserved2;
/* 165 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 169 */     StringBuilder _sb_ = new StringBuilder();
/* 170 */     _sb_.append("(");
/* 171 */     _sb_.append(this.retcode).append(",");
/* 172 */     _sb_.append("B").append(this.account.size()).append(",");
/* 173 */     _sb_.append(this.roleid).append(",");
/* 174 */     _sb_.append(this.main_svr_id).append(",");
/* 175 */     _sb_.append(this.main_svr_urls).append(",");
/* 176 */     _sb_.append(this.slave_svr_id).append(",");
/* 177 */     _sb_.append(this.slave_svr_urls).append(",");
/* 178 */     _sb_.append("B").append(this.auth_key.size()).append(",");
/* 179 */     _sb_.append(this.expire_in).append(",");
/* 180 */     _sb_.append("B").append(this.async_data.size()).append(",");
/* 181 */     _sb_.append(this.reserved1).append(",");
/* 182 */     _sb_.append(this.reserved2).append(",");
/* 183 */     _sb_.append(")");
/* 184 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\apollo\ApolloGetAuthKeyRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */