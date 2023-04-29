/*     */ package apollo;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class ApolloCreateLargeRoomRsp extends __ApolloCreateLargeRoomRsp__ { public static final int PROTOCOL_TYPE = 12052;
/*     */   public int retcode;
/*     */   public com.goldhuman.Common.Octets account;
/*     */   public long roleid;
/*     */   public long gid;
/*     */   public long roomid;
/*     */   public long roomkey;
/*     */   public int user_openid;
/*     */   public com.goldhuman.Common.Octets uuid;
/*     */   public int business_id;
/*     */   public com.goldhuman.Common.Octets async_data;
/*     */   public int reserved1;
/*     */   public int reserved2;
/*     */   
/*  19 */   protected void process() { mzm.gsp.apollo.main.ApolloInterface.onApolloCreateLargeRoomRsp(this); }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  27 */     return 12052;
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
/*     */   public ApolloCreateLargeRoomRsp()
/*     */   {
/*  44 */     this.retcode = 9;
/*  45 */     this.account = new com.goldhuman.Common.Octets();
/*  46 */     this.roleid = 0L;
/*  47 */     this.gid = 0L;
/*  48 */     this.roomid = 0L;
/*  49 */     this.roomkey = 0L;
/*  50 */     this.user_openid = 0;
/*  51 */     this.uuid = new com.goldhuman.Common.Octets();
/*  52 */     this.business_id = 0;
/*  53 */     this.async_data = new com.goldhuman.Common.Octets();
/*  54 */     this.reserved1 = 0;
/*  55 */     this.reserved2 = 0;
/*     */   }
/*     */   
/*     */   public ApolloCreateLargeRoomRsp(int _retcode_, com.goldhuman.Common.Octets _account_, long _roleid_, long _gid_, long _roomid_, long _roomkey_, int _user_openid_, com.goldhuman.Common.Octets _uuid_, int _business_id_, com.goldhuman.Common.Octets _async_data_, int _reserved1_, int _reserved2_) {
/*  59 */     this.retcode = _retcode_;
/*  60 */     this.account = _account_;
/*  61 */     this.roleid = _roleid_;
/*  62 */     this.gid = _gid_;
/*  63 */     this.roomid = _roomid_;
/*  64 */     this.roomkey = _roomkey_;
/*  65 */     this.user_openid = _user_openid_;
/*  66 */     this.uuid = _uuid_;
/*  67 */     this.business_id = _business_id_;
/*  68 */     this.async_data = _async_data_;
/*  69 */     this.reserved1 = _reserved1_;
/*  70 */     this.reserved2 = _reserved2_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  74 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  78 */     _os_.marshal(this.retcode);
/*  79 */     _os_.marshal(this.account);
/*  80 */     _os_.marshal(this.roleid);
/*  81 */     _os_.marshal(this.gid);
/*  82 */     _os_.marshal(this.roomid);
/*  83 */     _os_.marshal(this.roomkey);
/*  84 */     _os_.marshal(this.user_openid);
/*  85 */     _os_.marshal(this.uuid);
/*  86 */     _os_.marshal(this.business_id);
/*  87 */     _os_.marshal(this.async_data);
/*  88 */     _os_.marshal(this.reserved1);
/*  89 */     _os_.marshal(this.reserved2);
/*  90 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  94 */     this.retcode = _os_.unmarshal_int();
/*  95 */     this.account = _os_.unmarshal_Octets();
/*  96 */     this.roleid = _os_.unmarshal_long();
/*  97 */     this.gid = _os_.unmarshal_long();
/*  98 */     this.roomid = _os_.unmarshal_long();
/*  99 */     this.roomkey = _os_.unmarshal_long();
/* 100 */     this.user_openid = _os_.unmarshal_int();
/* 101 */     this.uuid = _os_.unmarshal_Octets();
/* 102 */     this.business_id = _os_.unmarshal_int();
/* 103 */     this.async_data = _os_.unmarshal_Octets();
/* 104 */     this.reserved1 = _os_.unmarshal_int();
/* 105 */     this.reserved2 = _os_.unmarshal_int();
/* 106 */     if (!_validator_()) {
/* 107 */       throw new VerifyError("validator failed");
/*     */     }
/* 109 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/* 113 */     if (_o1_ == this) return true;
/* 114 */     if ((_o1_ instanceof ApolloCreateLargeRoomRsp)) {
/* 115 */       ApolloCreateLargeRoomRsp _o_ = (ApolloCreateLargeRoomRsp)_o1_;
/* 116 */       if (this.retcode != _o_.retcode) return false;
/* 117 */       if (!this.account.equals(_o_.account)) return false;
/* 118 */       if (this.roleid != _o_.roleid) return false;
/* 119 */       if (this.gid != _o_.gid) return false;
/* 120 */       if (this.roomid != _o_.roomid) return false;
/* 121 */       if (this.roomkey != _o_.roomkey) return false;
/* 122 */       if (this.user_openid != _o_.user_openid) return false;
/* 123 */       if (!this.uuid.equals(_o_.uuid)) return false;
/* 124 */       if (this.business_id != _o_.business_id) return false;
/* 125 */       if (!this.async_data.equals(_o_.async_data)) return false;
/* 126 */       if (this.reserved1 != _o_.reserved1) return false;
/* 127 */       if (this.reserved2 != _o_.reserved2) return false;
/* 128 */       return true;
/*     */     }
/* 130 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 134 */     int _h_ = 0;
/* 135 */     _h_ += this.retcode;
/* 136 */     _h_ += this.account.hashCode();
/* 137 */     _h_ += (int)this.roleid;
/* 138 */     _h_ += (int)this.gid;
/* 139 */     _h_ += (int)this.roomid;
/* 140 */     _h_ += (int)this.roomkey;
/* 141 */     _h_ += this.user_openid;
/* 142 */     _h_ += this.uuid.hashCode();
/* 143 */     _h_ += this.business_id;
/* 144 */     _h_ += this.async_data.hashCode();
/* 145 */     _h_ += this.reserved1;
/* 146 */     _h_ += this.reserved2;
/* 147 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 151 */     StringBuilder _sb_ = new StringBuilder();
/* 152 */     _sb_.append("(");
/* 153 */     _sb_.append(this.retcode).append(",");
/* 154 */     _sb_.append("B").append(this.account.size()).append(",");
/* 155 */     _sb_.append(this.roleid).append(",");
/* 156 */     _sb_.append(this.gid).append(",");
/* 157 */     _sb_.append(this.roomid).append(",");
/* 158 */     _sb_.append(this.roomkey).append(",");
/* 159 */     _sb_.append(this.user_openid).append(",");
/* 160 */     _sb_.append("B").append(this.uuid.size()).append(",");
/* 161 */     _sb_.append(this.business_id).append(",");
/* 162 */     _sb_.append("B").append(this.async_data.size()).append(",");
/* 163 */     _sb_.append(this.reserved1).append(",");
/* 164 */     _sb_.append(this.reserved2).append(",");
/* 165 */     _sb_.append(")");
/* 166 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\apollo\ApolloCreateLargeRoomRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */