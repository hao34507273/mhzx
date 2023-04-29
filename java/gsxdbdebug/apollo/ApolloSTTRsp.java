/*     */ package apollo;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ 
/*     */ public class ApolloSTTRsp extends __ApolloSTTRsp__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12074;
/*     */   public int retcode;
/*     */   public Octets account;
/*     */   public long roleid;
/*     */   public Octets file_id;
/*     */   public Octets file_text;
/*     */   public Octets async_data;
/*     */   public int reserved1;
/*     */   public int reserved2;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     mzm.gsp.apollo.main.ApolloInterface.onApolloSTTRsp(this);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  27 */     return 12074;
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
/*     */   public ApolloSTTRsp()
/*     */   {
/*  40 */     this.retcode = 9;
/*  41 */     this.account = new Octets();
/*  42 */     this.roleid = 0L;
/*  43 */     this.file_id = new Octets();
/*  44 */     this.file_text = new Octets();
/*  45 */     this.async_data = new Octets();
/*  46 */     this.reserved1 = 0;
/*  47 */     this.reserved2 = 0;
/*     */   }
/*     */   
/*     */   public ApolloSTTRsp(int _retcode_, Octets _account_, long _roleid_, Octets _file_id_, Octets _file_text_, Octets _async_data_, int _reserved1_, int _reserved2_) {
/*  51 */     this.retcode = _retcode_;
/*  52 */     this.account = _account_;
/*  53 */     this.roleid = _roleid_;
/*  54 */     this.file_id = _file_id_;
/*  55 */     this.file_text = _file_text_;
/*  56 */     this.async_data = _async_data_;
/*  57 */     this.reserved1 = _reserved1_;
/*  58 */     this.reserved2 = _reserved2_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  62 */     return true;
/*     */   }
/*     */   
/*     */   public com.goldhuman.Common.Marshal.OctetsStream marshal(com.goldhuman.Common.Marshal.OctetsStream _os_) {
/*  66 */     _os_.marshal(this.retcode);
/*  67 */     _os_.marshal(this.account);
/*  68 */     _os_.marshal(this.roleid);
/*  69 */     _os_.marshal(this.file_id);
/*  70 */     _os_.marshal(this.file_text);
/*  71 */     _os_.marshal(this.async_data);
/*  72 */     _os_.marshal(this.reserved1);
/*  73 */     _os_.marshal(this.reserved2);
/*  74 */     return _os_;
/*     */   }
/*     */   
/*     */   public com.goldhuman.Common.Marshal.OctetsStream unmarshal(com.goldhuman.Common.Marshal.OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  78 */     this.retcode = _os_.unmarshal_int();
/*  79 */     this.account = _os_.unmarshal_Octets();
/*  80 */     this.roleid = _os_.unmarshal_long();
/*  81 */     this.file_id = _os_.unmarshal_Octets();
/*  82 */     this.file_text = _os_.unmarshal_Octets();
/*  83 */     this.async_data = _os_.unmarshal_Octets();
/*  84 */     this.reserved1 = _os_.unmarshal_int();
/*  85 */     this.reserved2 = _os_.unmarshal_int();
/*  86 */     if (!_validator_()) {
/*  87 */       throw new VerifyError("validator failed");
/*     */     }
/*  89 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  93 */     if (_o1_ == this) return true;
/*  94 */     if ((_o1_ instanceof ApolloSTTRsp)) {
/*  95 */       ApolloSTTRsp _o_ = (ApolloSTTRsp)_o1_;
/*  96 */       if (this.retcode != _o_.retcode) return false;
/*  97 */       if (!this.account.equals(_o_.account)) return false;
/*  98 */       if (this.roleid != _o_.roleid) return false;
/*  99 */       if (!this.file_id.equals(_o_.file_id)) return false;
/* 100 */       if (!this.file_text.equals(_o_.file_text)) return false;
/* 101 */       if (!this.async_data.equals(_o_.async_data)) return false;
/* 102 */       if (this.reserved1 != _o_.reserved1) return false;
/* 103 */       if (this.reserved2 != _o_.reserved2) return false;
/* 104 */       return true;
/*     */     }
/* 106 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 110 */     int _h_ = 0;
/* 111 */     _h_ += this.retcode;
/* 112 */     _h_ += this.account.hashCode();
/* 113 */     _h_ += (int)this.roleid;
/* 114 */     _h_ += this.file_id.hashCode();
/* 115 */     _h_ += this.file_text.hashCode();
/* 116 */     _h_ += this.async_data.hashCode();
/* 117 */     _h_ += this.reserved1;
/* 118 */     _h_ += this.reserved2;
/* 119 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 123 */     StringBuilder _sb_ = new StringBuilder();
/* 124 */     _sb_.append("(");
/* 125 */     _sb_.append(this.retcode).append(",");
/* 126 */     _sb_.append("B").append(this.account.size()).append(",");
/* 127 */     _sb_.append(this.roleid).append(",");
/* 128 */     _sb_.append("B").append(this.file_id.size()).append(",");
/* 129 */     _sb_.append("B").append(this.file_text.size()).append(",");
/* 130 */     _sb_.append("B").append(this.async_data.size()).append(",");
/* 131 */     _sb_.append(this.reserved1).append(",");
/* 132 */     _sb_.append(this.reserved2).append(",");
/* 133 */     _sb_.append(")");
/* 134 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\apollo\ApolloSTTRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */