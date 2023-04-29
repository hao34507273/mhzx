/*     */ package apollo;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class ApolloJoinVoipRoomRsp extends __ApolloJoinVoipRoomRsp__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12014;
/*     */   public int retcode;
/*     */   public com.goldhuman.Common.Octets account;
/*     */   public long roleid;
/*     */   public long room_id;
/*     */   public VoipRoomUserAccess user_access;
/*     */   public com.goldhuman.Common.Octets async_data;
/*     */   public int reserved1;
/*     */   public int reserved2;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     mzm.gsp.apollo.main.ApolloInterface.onApolloJoinVoipRoomRsp(this);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  27 */     return 12014;
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
/*     */   public ApolloJoinVoipRoomRsp()
/*     */   {
/*  40 */     this.retcode = 9;
/*  41 */     this.account = new com.goldhuman.Common.Octets();
/*  42 */     this.roleid = 0L;
/*  43 */     this.room_id = 0L;
/*  44 */     this.user_access = new VoipRoomUserAccess();
/*  45 */     this.async_data = new com.goldhuman.Common.Octets();
/*  46 */     this.reserved1 = 0;
/*  47 */     this.reserved2 = 0;
/*     */   }
/*     */   
/*     */   public ApolloJoinVoipRoomRsp(int _retcode_, com.goldhuman.Common.Octets _account_, long _roleid_, long _room_id_, VoipRoomUserAccess _user_access_, com.goldhuman.Common.Octets _async_data_, int _reserved1_, int _reserved2_) {
/*  51 */     this.retcode = _retcode_;
/*  52 */     this.account = _account_;
/*  53 */     this.roleid = _roleid_;
/*  54 */     this.room_id = _room_id_;
/*  55 */     this.user_access = _user_access_;
/*  56 */     this.async_data = _async_data_;
/*  57 */     this.reserved1 = _reserved1_;
/*  58 */     this.reserved2 = _reserved2_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  62 */     if (!this.user_access._validator_()) return false;
/*  63 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  67 */     _os_.marshal(this.retcode);
/*  68 */     _os_.marshal(this.account);
/*  69 */     _os_.marshal(this.roleid);
/*  70 */     _os_.marshal(this.room_id);
/*  71 */     _os_.marshal(this.user_access);
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
/*  82 */     this.room_id = _os_.unmarshal_long();
/*  83 */     this.user_access.unmarshal(_os_);
/*  84 */     this.async_data = _os_.unmarshal_Octets();
/*  85 */     this.reserved1 = _os_.unmarshal_int();
/*  86 */     this.reserved2 = _os_.unmarshal_int();
/*  87 */     if (!_validator_()) {
/*  88 */       throw new VerifyError("validator failed");
/*     */     }
/*  90 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  94 */     if (_o1_ == this) return true;
/*  95 */     if ((_o1_ instanceof ApolloJoinVoipRoomRsp)) {
/*  96 */       ApolloJoinVoipRoomRsp _o_ = (ApolloJoinVoipRoomRsp)_o1_;
/*  97 */       if (this.retcode != _o_.retcode) return false;
/*  98 */       if (!this.account.equals(_o_.account)) return false;
/*  99 */       if (this.roleid != _o_.roleid) return false;
/* 100 */       if (this.room_id != _o_.room_id) return false;
/* 101 */       if (!this.user_access.equals(_o_.user_access)) return false;
/* 102 */       if (!this.async_data.equals(_o_.async_data)) return false;
/* 103 */       if (this.reserved1 != _o_.reserved1) return false;
/* 104 */       if (this.reserved2 != _o_.reserved2) return false;
/* 105 */       return true;
/*     */     }
/* 107 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 111 */     int _h_ = 0;
/* 112 */     _h_ += this.retcode;
/* 113 */     _h_ += this.account.hashCode();
/* 114 */     _h_ += (int)this.roleid;
/* 115 */     _h_ += (int)this.room_id;
/* 116 */     _h_ += this.user_access.hashCode();
/* 117 */     _h_ += this.async_data.hashCode();
/* 118 */     _h_ += this.reserved1;
/* 119 */     _h_ += this.reserved2;
/* 120 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 124 */     StringBuilder _sb_ = new StringBuilder();
/* 125 */     _sb_.append("(");
/* 126 */     _sb_.append(this.retcode).append(",");
/* 127 */     _sb_.append("B").append(this.account.size()).append(",");
/* 128 */     _sb_.append(this.roleid).append(",");
/* 129 */     _sb_.append(this.room_id).append(",");
/* 130 */     _sb_.append(this.user_access).append(",");
/* 131 */     _sb_.append("B").append(this.async_data.size()).append(",");
/* 132 */     _sb_.append(this.reserved1).append(",");
/* 133 */     _sb_.append(this.reserved2).append(",");
/* 134 */     _sb_.append(")");
/* 135 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\apollo\ApolloJoinVoipRoomRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */