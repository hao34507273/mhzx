/*     */ package mzm.gsp.apollo;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SGetAuthKeyRsp
/*     */   extends __SGetAuthKeyRsp__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12602640;
/*     */   public int retcode;
/*     */   public long main_svr_id;
/*     */   public ArrayList<ServerUrlInfo> main_svr_urls;
/*     */   public long slave_svr_id;
/*     */   public ArrayList<ServerUrlInfo> slave_svr_urls;
/*     */   public Octets auth_key;
/*     */   public int expire_in;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12602640;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SGetAuthKeyRsp()
/*     */   {
/*  39 */     this.retcode = 9;
/*  40 */     this.main_svr_id = 0L;
/*  41 */     this.main_svr_urls = new ArrayList();
/*  42 */     this.slave_svr_id = 0L;
/*  43 */     this.slave_svr_urls = new ArrayList();
/*  44 */     this.auth_key = new Octets();
/*  45 */     this.expire_in = 0;
/*     */   }
/*     */   
/*     */   public SGetAuthKeyRsp(int _retcode_, long _main_svr_id_, ArrayList<ServerUrlInfo> _main_svr_urls_, long _slave_svr_id_, ArrayList<ServerUrlInfo> _slave_svr_urls_, Octets _auth_key_, int _expire_in_) {
/*  49 */     this.retcode = _retcode_;
/*  50 */     this.main_svr_id = _main_svr_id_;
/*  51 */     this.main_svr_urls = _main_svr_urls_;
/*  52 */     this.slave_svr_id = _slave_svr_id_;
/*  53 */     this.slave_svr_urls = _slave_svr_urls_;
/*  54 */     this.auth_key = _auth_key_;
/*  55 */     this.expire_in = _expire_in_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  59 */     for (ServerUrlInfo _v_ : this.main_svr_urls)
/*  60 */       if (!_v_._validator_()) return false;
/*  61 */     for (ServerUrlInfo _v_ : this.slave_svr_urls)
/*  62 */       if (!_v_._validator_()) return false;
/*  63 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  67 */     _os_.marshal(this.retcode);
/*  68 */     _os_.marshal(this.main_svr_id);
/*  69 */     _os_.compact_uint32(this.main_svr_urls.size());
/*  70 */     for (ServerUrlInfo _v_ : this.main_svr_urls) {
/*  71 */       _os_.marshal(_v_);
/*     */     }
/*  73 */     _os_.marshal(this.slave_svr_id);
/*  74 */     _os_.compact_uint32(this.slave_svr_urls.size());
/*  75 */     for (ServerUrlInfo _v_ : this.slave_svr_urls) {
/*  76 */       _os_.marshal(_v_);
/*     */     }
/*  78 */     _os_.marshal(this.auth_key);
/*  79 */     _os_.marshal(this.expire_in);
/*  80 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  84 */     this.retcode = _os_.unmarshal_int();
/*  85 */     this.main_svr_id = _os_.unmarshal_long();
/*  86 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  87 */       ServerUrlInfo _v_ = new ServerUrlInfo();
/*  88 */       _v_.unmarshal(_os_);
/*  89 */       this.main_svr_urls.add(_v_);
/*     */     }
/*  91 */     this.slave_svr_id = _os_.unmarshal_long();
/*  92 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  93 */       ServerUrlInfo _v_ = new ServerUrlInfo();
/*  94 */       _v_.unmarshal(_os_);
/*  95 */       this.slave_svr_urls.add(_v_);
/*     */     }
/*  97 */     this.auth_key = _os_.unmarshal_Octets();
/*  98 */     this.expire_in = _os_.unmarshal_int();
/*  99 */     if (!_validator_()) {
/* 100 */       throw new VerifyError("validator failed");
/*     */     }
/* 102 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/* 106 */     if (_o1_ == this) return true;
/* 107 */     if ((_o1_ instanceof SGetAuthKeyRsp)) {
/* 108 */       SGetAuthKeyRsp _o_ = (SGetAuthKeyRsp)_o1_;
/* 109 */       if (this.retcode != _o_.retcode) return false;
/* 110 */       if (this.main_svr_id != _o_.main_svr_id) return false;
/* 111 */       if (!this.main_svr_urls.equals(_o_.main_svr_urls)) return false;
/* 112 */       if (this.slave_svr_id != _o_.slave_svr_id) return false;
/* 113 */       if (!this.slave_svr_urls.equals(_o_.slave_svr_urls)) return false;
/* 114 */       if (!this.auth_key.equals(_o_.auth_key)) return false;
/* 115 */       if (this.expire_in != _o_.expire_in) return false;
/* 116 */       return true;
/*     */     }
/* 118 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 122 */     int _h_ = 0;
/* 123 */     _h_ += this.retcode;
/* 124 */     _h_ += (int)this.main_svr_id;
/* 125 */     _h_ += this.main_svr_urls.hashCode();
/* 126 */     _h_ += (int)this.slave_svr_id;
/* 127 */     _h_ += this.slave_svr_urls.hashCode();
/* 128 */     _h_ += this.auth_key.hashCode();
/* 129 */     _h_ += this.expire_in;
/* 130 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 134 */     StringBuilder _sb_ = new StringBuilder();
/* 135 */     _sb_.append("(");
/* 136 */     _sb_.append(this.retcode).append(",");
/* 137 */     _sb_.append(this.main_svr_id).append(",");
/* 138 */     _sb_.append(this.main_svr_urls).append(",");
/* 139 */     _sb_.append(this.slave_svr_id).append(",");
/* 140 */     _sb_.append(this.slave_svr_urls).append(",");
/* 141 */     _sb_.append("B").append(this.auth_key.size()).append(",");
/* 142 */     _sb_.append(this.expire_in).append(",");
/* 143 */     _sb_.append(")");
/* 144 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\apollo\SGetAuthKeyRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */