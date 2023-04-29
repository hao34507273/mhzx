/*     */ package apollo;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ApolloExitVoipRoomReq
/*     */   extends __ApolloExitVoipRoomReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12015;
/*     */   public Octets account;
/*     */   public long roleid;
/*     */   public long room_id;
/*     */   public int member_id;
/*     */   public Octets user_open_id;
/*     */   public int exit_type;
/*     */   public Octets async_data;
/*     */   public int reserved1;
/*     */   public int reserved2;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12015;
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
/*     */   public ApolloExitVoipRoomReq()
/*     */   {
/*  41 */     this.account = new Octets();
/*  42 */     this.roleid = 0L;
/*  43 */     this.room_id = 0L;
/*  44 */     this.member_id = 0;
/*  45 */     this.user_open_id = new Octets();
/*  46 */     this.exit_type = 0;
/*  47 */     this.async_data = new Octets();
/*  48 */     this.reserved1 = 0;
/*  49 */     this.reserved2 = 0;
/*     */   }
/*     */   
/*     */   public ApolloExitVoipRoomReq(Octets _account_, long _roleid_, long _room_id_, int _member_id_, Octets _user_open_id_, int _exit_type_, Octets _async_data_, int _reserved1_, int _reserved2_) {
/*  53 */     this.account = _account_;
/*  54 */     this.roleid = _roleid_;
/*  55 */     this.room_id = _room_id_;
/*  56 */     this.member_id = _member_id_;
/*  57 */     this.user_open_id = _user_open_id_;
/*  58 */     this.exit_type = _exit_type_;
/*  59 */     this.async_data = _async_data_;
/*  60 */     this.reserved1 = _reserved1_;
/*  61 */     this.reserved2 = _reserved2_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  65 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  69 */     _os_.marshal(this.account);
/*  70 */     _os_.marshal(this.roleid);
/*  71 */     _os_.marshal(this.room_id);
/*  72 */     _os_.marshal(this.member_id);
/*  73 */     _os_.marshal(this.user_open_id);
/*  74 */     _os_.marshal(this.exit_type);
/*  75 */     _os_.marshal(this.async_data);
/*  76 */     _os_.marshal(this.reserved1);
/*  77 */     _os_.marshal(this.reserved2);
/*  78 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  82 */     this.account = _os_.unmarshal_Octets();
/*  83 */     this.roleid = _os_.unmarshal_long();
/*  84 */     this.room_id = _os_.unmarshal_long();
/*  85 */     this.member_id = _os_.unmarshal_int();
/*  86 */     this.user_open_id = _os_.unmarshal_Octets();
/*  87 */     this.exit_type = _os_.unmarshal_int();
/*  88 */     this.async_data = _os_.unmarshal_Octets();
/*  89 */     this.reserved1 = _os_.unmarshal_int();
/*  90 */     this.reserved2 = _os_.unmarshal_int();
/*  91 */     if (!_validator_()) {
/*  92 */       throw new VerifyError("validator failed");
/*     */     }
/*  94 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  98 */     if (_o1_ == this) return true;
/*  99 */     if ((_o1_ instanceof ApolloExitVoipRoomReq)) {
/* 100 */       ApolloExitVoipRoomReq _o_ = (ApolloExitVoipRoomReq)_o1_;
/* 101 */       if (!this.account.equals(_o_.account)) return false;
/* 102 */       if (this.roleid != _o_.roleid) return false;
/* 103 */       if (this.room_id != _o_.room_id) return false;
/* 104 */       if (this.member_id != _o_.member_id) return false;
/* 105 */       if (!this.user_open_id.equals(_o_.user_open_id)) return false;
/* 106 */       if (this.exit_type != _o_.exit_type) return false;
/* 107 */       if (!this.async_data.equals(_o_.async_data)) return false;
/* 108 */       if (this.reserved1 != _o_.reserved1) return false;
/* 109 */       if (this.reserved2 != _o_.reserved2) return false;
/* 110 */       return true;
/*     */     }
/* 112 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 116 */     int _h_ = 0;
/* 117 */     _h_ += this.account.hashCode();
/* 118 */     _h_ += (int)this.roleid;
/* 119 */     _h_ += (int)this.room_id;
/* 120 */     _h_ += this.member_id;
/* 121 */     _h_ += this.user_open_id.hashCode();
/* 122 */     _h_ += this.exit_type;
/* 123 */     _h_ += this.async_data.hashCode();
/* 124 */     _h_ += this.reserved1;
/* 125 */     _h_ += this.reserved2;
/* 126 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 130 */     StringBuilder _sb_ = new StringBuilder();
/* 131 */     _sb_.append("(");
/* 132 */     _sb_.append("B").append(this.account.size()).append(",");
/* 133 */     _sb_.append(this.roleid).append(",");
/* 134 */     _sb_.append(this.room_id).append(",");
/* 135 */     _sb_.append(this.member_id).append(",");
/* 136 */     _sb_.append("B").append(this.user_open_id.size()).append(",");
/* 137 */     _sb_.append(this.exit_type).append(",");
/* 138 */     _sb_.append("B").append(this.async_data.size()).append(",");
/* 139 */     _sb_.append(this.reserved1).append(",");
/* 140 */     _sb_.append(this.reserved2).append(",");
/* 141 */     _sb_.append(")");
/* 142 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\apollo\ApolloExitVoipRoomReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */