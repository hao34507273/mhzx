/*     */ package apollo;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ApolloJoinVoipRoomReq
/*     */   extends __ApolloJoinVoipRoomReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12013;
/*     */   public Octets account;
/*     */   public long roleid;
/*     */   public long room_id;
/*     */   public VoipRoomUser user;
/*     */   public Octets async_data;
/*     */   public int reserved1;
/*     */   public int reserved2;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12013;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public ApolloJoinVoipRoomReq()
/*     */   {
/*  39 */     this.account = new Octets();
/*  40 */     this.roleid = 0L;
/*  41 */     this.room_id = 0L;
/*  42 */     this.user = new VoipRoomUser();
/*  43 */     this.async_data = new Octets();
/*  44 */     this.reserved1 = 0;
/*  45 */     this.reserved2 = 0;
/*     */   }
/*     */   
/*     */   public ApolloJoinVoipRoomReq(Octets _account_, long _roleid_, long _room_id_, VoipRoomUser _user_, Octets _async_data_, int _reserved1_, int _reserved2_) {
/*  49 */     this.account = _account_;
/*  50 */     this.roleid = _roleid_;
/*  51 */     this.room_id = _room_id_;
/*  52 */     this.user = _user_;
/*  53 */     this.async_data = _async_data_;
/*  54 */     this.reserved1 = _reserved1_;
/*  55 */     this.reserved2 = _reserved2_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  59 */     if (!this.user._validator_()) return false;
/*  60 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  64 */     _os_.marshal(this.account);
/*  65 */     _os_.marshal(this.roleid);
/*  66 */     _os_.marshal(this.room_id);
/*  67 */     _os_.marshal(this.user);
/*  68 */     _os_.marshal(this.async_data);
/*  69 */     _os_.marshal(this.reserved1);
/*  70 */     _os_.marshal(this.reserved2);
/*  71 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  75 */     this.account = _os_.unmarshal_Octets();
/*  76 */     this.roleid = _os_.unmarshal_long();
/*  77 */     this.room_id = _os_.unmarshal_long();
/*  78 */     this.user.unmarshal(_os_);
/*  79 */     this.async_data = _os_.unmarshal_Octets();
/*  80 */     this.reserved1 = _os_.unmarshal_int();
/*  81 */     this.reserved2 = _os_.unmarshal_int();
/*  82 */     if (!_validator_()) {
/*  83 */       throw new VerifyError("validator failed");
/*     */     }
/*  85 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  89 */     if (_o1_ == this) return true;
/*  90 */     if ((_o1_ instanceof ApolloJoinVoipRoomReq)) {
/*  91 */       ApolloJoinVoipRoomReq _o_ = (ApolloJoinVoipRoomReq)_o1_;
/*  92 */       if (!this.account.equals(_o_.account)) return false;
/*  93 */       if (this.roleid != _o_.roleid) return false;
/*  94 */       if (this.room_id != _o_.room_id) return false;
/*  95 */       if (!this.user.equals(_o_.user)) return false;
/*  96 */       if (!this.async_data.equals(_o_.async_data)) return false;
/*  97 */       if (this.reserved1 != _o_.reserved1) return false;
/*  98 */       if (this.reserved2 != _o_.reserved2) return false;
/*  99 */       return true;
/*     */     }
/* 101 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 105 */     int _h_ = 0;
/* 106 */     _h_ += this.account.hashCode();
/* 107 */     _h_ += (int)this.roleid;
/* 108 */     _h_ += (int)this.room_id;
/* 109 */     _h_ += this.user.hashCode();
/* 110 */     _h_ += this.async_data.hashCode();
/* 111 */     _h_ += this.reserved1;
/* 112 */     _h_ += this.reserved2;
/* 113 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 117 */     StringBuilder _sb_ = new StringBuilder();
/* 118 */     _sb_.append("(");
/* 119 */     _sb_.append("B").append(this.account.size()).append(",");
/* 120 */     _sb_.append(this.roleid).append(",");
/* 121 */     _sb_.append(this.room_id).append(",");
/* 122 */     _sb_.append(this.user).append(",");
/* 123 */     _sb_.append("B").append(this.async_data.size()).append(",");
/* 124 */     _sb_.append(this.reserved1).append(",");
/* 125 */     _sb_.append(this.reserved2).append(",");
/* 126 */     _sb_.append(")");
/* 127 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\apollo\ApolloJoinVoipRoomReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */