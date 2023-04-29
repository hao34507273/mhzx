/*     */ package apollo;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ 
/*     */ public class ApolloEnterLargeRoomRsp extends __ApolloEnterLargeRoomRsp__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12056;
/*     */   public int retcode;
/*     */   public Octets account;
/*     */   public long roleid;
/*     */   public java.util.LinkedList<LargeEnterRspInfo> rsp_infos;
/*     */   public Octets async_data;
/*     */   public int reserved1;
/*     */   public int reserved2;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     mzm.gsp.apollo.main.ApolloInterface.onApolloEnterLargeRoomRsp(this);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  27 */     return 12056;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public ApolloEnterLargeRoomRsp()
/*     */   {
/*  39 */     this.retcode = 9;
/*  40 */     this.account = new Octets();
/*  41 */     this.roleid = 0L;
/*  42 */     this.rsp_infos = new java.util.LinkedList();
/*  43 */     this.async_data = new Octets();
/*  44 */     this.reserved1 = 0;
/*  45 */     this.reserved2 = 0;
/*     */   }
/*     */   
/*     */   public ApolloEnterLargeRoomRsp(int _retcode_, Octets _account_, long _roleid_, java.util.LinkedList<LargeEnterRspInfo> _rsp_infos_, Octets _async_data_, int _reserved1_, int _reserved2_) {
/*  49 */     this.retcode = _retcode_;
/*  50 */     this.account = _account_;
/*  51 */     this.roleid = _roleid_;
/*  52 */     this.rsp_infos = _rsp_infos_;
/*  53 */     this.async_data = _async_data_;
/*  54 */     this.reserved1 = _reserved1_;
/*  55 */     this.reserved2 = _reserved2_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  59 */     for (LargeEnterRspInfo _v_ : this.rsp_infos)
/*  60 */       if (!_v_._validator_()) return false;
/*  61 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  65 */     _os_.marshal(this.retcode);
/*  66 */     _os_.marshal(this.account);
/*  67 */     _os_.marshal(this.roleid);
/*  68 */     _os_.compact_uint32(this.rsp_infos.size());
/*  69 */     for (LargeEnterRspInfo _v_ : this.rsp_infos) {
/*  70 */       _os_.marshal(_v_);
/*     */     }
/*  72 */     _os_.marshal(this.async_data);
/*  73 */     _os_.marshal(this.reserved1);
/*  74 */     _os_.marshal(this.reserved2);
/*  75 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  79 */     this.retcode = _os_.unmarshal_int();
/*  80 */     this.account = _os_.unmarshal_Octets();
/*  81 */     this.roleid = _os_.unmarshal_long();
/*  82 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  83 */       LargeEnterRspInfo _v_ = new LargeEnterRspInfo();
/*  84 */       _v_.unmarshal(_os_);
/*  85 */       this.rsp_infos.add(_v_);
/*     */     }
/*  87 */     this.async_data = _os_.unmarshal_Octets();
/*  88 */     this.reserved1 = _os_.unmarshal_int();
/*  89 */     this.reserved2 = _os_.unmarshal_int();
/*  90 */     if (!_validator_()) {
/*  91 */       throw new VerifyError("validator failed");
/*     */     }
/*  93 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  97 */     if (_o1_ == this) return true;
/*  98 */     if ((_o1_ instanceof ApolloEnterLargeRoomRsp)) {
/*  99 */       ApolloEnterLargeRoomRsp _o_ = (ApolloEnterLargeRoomRsp)_o1_;
/* 100 */       if (this.retcode != _o_.retcode) return false;
/* 101 */       if (!this.account.equals(_o_.account)) return false;
/* 102 */       if (this.roleid != _o_.roleid) return false;
/* 103 */       if (!this.rsp_infos.equals(_o_.rsp_infos)) return false;
/* 104 */       if (!this.async_data.equals(_o_.async_data)) return false;
/* 105 */       if (this.reserved1 != _o_.reserved1) return false;
/* 106 */       if (this.reserved2 != _o_.reserved2) return false;
/* 107 */       return true;
/*     */     }
/* 109 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 113 */     int _h_ = 0;
/* 114 */     _h_ += this.retcode;
/* 115 */     _h_ += this.account.hashCode();
/* 116 */     _h_ += (int)this.roleid;
/* 117 */     _h_ += this.rsp_infos.hashCode();
/* 118 */     _h_ += this.async_data.hashCode();
/* 119 */     _h_ += this.reserved1;
/* 120 */     _h_ += this.reserved2;
/* 121 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 125 */     StringBuilder _sb_ = new StringBuilder();
/* 126 */     _sb_.append("(");
/* 127 */     _sb_.append(this.retcode).append(",");
/* 128 */     _sb_.append("B").append(this.account.size()).append(",");
/* 129 */     _sb_.append(this.roleid).append(",");
/* 130 */     _sb_.append(this.rsp_infos).append(",");
/* 131 */     _sb_.append("B").append(this.async_data.size()).append(",");
/* 132 */     _sb_.append(this.reserved1).append(",");
/* 133 */     _sb_.append(this.reserved2).append(",");
/* 134 */     _sb_.append(")");
/* 135 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\apollo\ApolloEnterLargeRoomRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */