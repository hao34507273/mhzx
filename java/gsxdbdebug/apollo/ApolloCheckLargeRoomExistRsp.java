/*     */ package apollo;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class ApolloCheckLargeRoomExistRsp extends __ApolloCheckLargeRoomExistRsp__ {
/*     */   public static final int PROTOCOL_TYPE = 12058;
/*     */   public int retcode;
/*     */   public com.goldhuman.Common.Octets account;
/*     */   public long roleid;
/*     */   public long roomid;
/*     */   public long roomkey;
/*     */   public long gid;
/*     */   public int exist;
/*     */   public com.goldhuman.Common.Octets async_data;
/*     */   public int reserved1;
/*     */   public int reserved2;
/*     */   
/*     */   protected void process() {
/*  19 */     mzm.gsp.apollo.main.ApolloInterface.onApolloCheckLargeRoomExistRsp(this);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  27 */     return 12058;
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
/*     */   public ApolloCheckLargeRoomExistRsp()
/*     */   {
/*  42 */     this.retcode = 9;
/*  43 */     this.account = new com.goldhuman.Common.Octets();
/*  44 */     this.roleid = 0L;
/*  45 */     this.roomid = 0L;
/*  46 */     this.roomkey = 0L;
/*  47 */     this.gid = 0L;
/*  48 */     this.exist = 0;
/*  49 */     this.async_data = new com.goldhuman.Common.Octets();
/*  50 */     this.reserved1 = 0;
/*  51 */     this.reserved2 = 0;
/*     */   }
/*     */   
/*     */   public ApolloCheckLargeRoomExistRsp(int _retcode_, com.goldhuman.Common.Octets _account_, long _roleid_, long _roomid_, long _roomkey_, long _gid_, int _exist_, com.goldhuman.Common.Octets _async_data_, int _reserved1_, int _reserved2_) {
/*  55 */     this.retcode = _retcode_;
/*  56 */     this.account = _account_;
/*  57 */     this.roleid = _roleid_;
/*  58 */     this.roomid = _roomid_;
/*  59 */     this.roomkey = _roomkey_;
/*  60 */     this.gid = _gid_;
/*  61 */     this.exist = _exist_;
/*  62 */     this.async_data = _async_data_;
/*  63 */     this.reserved1 = _reserved1_;
/*  64 */     this.reserved2 = _reserved2_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  68 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  72 */     _os_.marshal(this.retcode);
/*  73 */     _os_.marshal(this.account);
/*  74 */     _os_.marshal(this.roleid);
/*  75 */     _os_.marshal(this.roomid);
/*  76 */     _os_.marshal(this.roomkey);
/*  77 */     _os_.marshal(this.gid);
/*  78 */     _os_.marshal(this.exist);
/*  79 */     _os_.marshal(this.async_data);
/*  80 */     _os_.marshal(this.reserved1);
/*  81 */     _os_.marshal(this.reserved2);
/*  82 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  86 */     this.retcode = _os_.unmarshal_int();
/*  87 */     this.account = _os_.unmarshal_Octets();
/*  88 */     this.roleid = _os_.unmarshal_long();
/*  89 */     this.roomid = _os_.unmarshal_long();
/*  90 */     this.roomkey = _os_.unmarshal_long();
/*  91 */     this.gid = _os_.unmarshal_long();
/*  92 */     this.exist = _os_.unmarshal_int();
/*  93 */     this.async_data = _os_.unmarshal_Octets();
/*  94 */     this.reserved1 = _os_.unmarshal_int();
/*  95 */     this.reserved2 = _os_.unmarshal_int();
/*  96 */     if (!_validator_()) {
/*  97 */       throw new VerifyError("validator failed");
/*     */     }
/*  99 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/* 103 */     if (_o1_ == this) return true;
/* 104 */     if ((_o1_ instanceof ApolloCheckLargeRoomExistRsp)) {
/* 105 */       ApolloCheckLargeRoomExistRsp _o_ = (ApolloCheckLargeRoomExistRsp)_o1_;
/* 106 */       if (this.retcode != _o_.retcode) return false;
/* 107 */       if (!this.account.equals(_o_.account)) return false;
/* 108 */       if (this.roleid != _o_.roleid) return false;
/* 109 */       if (this.roomid != _o_.roomid) return false;
/* 110 */       if (this.roomkey != _o_.roomkey) return false;
/* 111 */       if (this.gid != _o_.gid) return false;
/* 112 */       if (this.exist != _o_.exist) return false;
/* 113 */       if (!this.async_data.equals(_o_.async_data)) return false;
/* 114 */       if (this.reserved1 != _o_.reserved1) return false;
/* 115 */       if (this.reserved2 != _o_.reserved2) return false;
/* 116 */       return true;
/*     */     }
/* 118 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 122 */     int _h_ = 0;
/* 123 */     _h_ += this.retcode;
/* 124 */     _h_ += this.account.hashCode();
/* 125 */     _h_ += (int)this.roleid;
/* 126 */     _h_ += (int)this.roomid;
/* 127 */     _h_ += (int)this.roomkey;
/* 128 */     _h_ += (int)this.gid;
/* 129 */     _h_ += this.exist;
/* 130 */     _h_ += this.async_data.hashCode();
/* 131 */     _h_ += this.reserved1;
/* 132 */     _h_ += this.reserved2;
/* 133 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 137 */     StringBuilder _sb_ = new StringBuilder();
/* 138 */     _sb_.append("(");
/* 139 */     _sb_.append(this.retcode).append(",");
/* 140 */     _sb_.append("B").append(this.account.size()).append(",");
/* 141 */     _sb_.append(this.roleid).append(",");
/* 142 */     _sb_.append(this.roomid).append(",");
/* 143 */     _sb_.append(this.roomkey).append(",");
/* 144 */     _sb_.append(this.gid).append(",");
/* 145 */     _sb_.append(this.exist).append(",");
/* 146 */     _sb_.append("B").append(this.async_data.size()).append(",");
/* 147 */     _sb_.append(this.reserved1).append(",");
/* 148 */     _sb_.append(this.reserved2).append(",");
/* 149 */     _sb_.append(")");
/* 150 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\apollo\ApolloCheckLargeRoomExistRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */