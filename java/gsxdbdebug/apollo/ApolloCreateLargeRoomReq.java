/*     */ package apollo;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ 
/*     */ public class ApolloCreateLargeRoomReq
/*     */   extends __ApolloCreateLargeRoomReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12051;
/*     */   public Octets account;
/*     */   public long roleid;
/*     */   public long roomid;
/*     */   public long roomkey;
/*     */   public int user_openid;
/*     */   public int cycle_report_switch;
/*     */   public int encrypt_size;
/*     */   public Octets uuid;
/*     */   public Octets async_data;
/*     */   public int reserved1;
/*     */   public int reserved2;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12051;
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
/*     */   public ApolloCreateLargeRoomReq()
/*     */   {
/*  43 */     this.account = new Octets();
/*  44 */     this.roleid = 0L;
/*  45 */     this.roomid = 0L;
/*  46 */     this.roomkey = 0L;
/*  47 */     this.user_openid = 0;
/*  48 */     this.cycle_report_switch = 0;
/*  49 */     this.encrypt_size = 0;
/*  50 */     this.uuid = new Octets();
/*  51 */     this.async_data = new Octets();
/*  52 */     this.reserved1 = 0;
/*  53 */     this.reserved2 = 0;
/*     */   }
/*     */   
/*     */   public ApolloCreateLargeRoomReq(Octets _account_, long _roleid_, long _roomid_, long _roomkey_, int _user_openid_, int _cycle_report_switch_, int _encrypt_size_, Octets _uuid_, Octets _async_data_, int _reserved1_, int _reserved2_) {
/*  57 */     this.account = _account_;
/*  58 */     this.roleid = _roleid_;
/*  59 */     this.roomid = _roomid_;
/*  60 */     this.roomkey = _roomkey_;
/*  61 */     this.user_openid = _user_openid_;
/*  62 */     this.cycle_report_switch = _cycle_report_switch_;
/*  63 */     this.encrypt_size = _encrypt_size_;
/*  64 */     this.uuid = _uuid_;
/*  65 */     this.async_data = _async_data_;
/*  66 */     this.reserved1 = _reserved1_;
/*  67 */     this.reserved2 = _reserved2_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  71 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  75 */     _os_.marshal(this.account);
/*  76 */     _os_.marshal(this.roleid);
/*  77 */     _os_.marshal(this.roomid);
/*  78 */     _os_.marshal(this.roomkey);
/*  79 */     _os_.marshal(this.user_openid);
/*  80 */     _os_.marshal(this.cycle_report_switch);
/*  81 */     _os_.marshal(this.encrypt_size);
/*  82 */     _os_.marshal(this.uuid);
/*  83 */     _os_.marshal(this.async_data);
/*  84 */     _os_.marshal(this.reserved1);
/*  85 */     _os_.marshal(this.reserved2);
/*  86 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  90 */     this.account = _os_.unmarshal_Octets();
/*  91 */     this.roleid = _os_.unmarshal_long();
/*  92 */     this.roomid = _os_.unmarshal_long();
/*  93 */     this.roomkey = _os_.unmarshal_long();
/*  94 */     this.user_openid = _os_.unmarshal_int();
/*  95 */     this.cycle_report_switch = _os_.unmarshal_int();
/*  96 */     this.encrypt_size = _os_.unmarshal_int();
/*  97 */     this.uuid = _os_.unmarshal_Octets();
/*  98 */     this.async_data = _os_.unmarshal_Octets();
/*  99 */     this.reserved1 = _os_.unmarshal_int();
/* 100 */     this.reserved2 = _os_.unmarshal_int();
/* 101 */     if (!_validator_()) {
/* 102 */       throw new VerifyError("validator failed");
/*     */     }
/* 104 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/* 108 */     if (_o1_ == this) return true;
/* 109 */     if ((_o1_ instanceof ApolloCreateLargeRoomReq)) {
/* 110 */       ApolloCreateLargeRoomReq _o_ = (ApolloCreateLargeRoomReq)_o1_;
/* 111 */       if (!this.account.equals(_o_.account)) return false;
/* 112 */       if (this.roleid != _o_.roleid) return false;
/* 113 */       if (this.roomid != _o_.roomid) return false;
/* 114 */       if (this.roomkey != _o_.roomkey) return false;
/* 115 */       if (this.user_openid != _o_.user_openid) return false;
/* 116 */       if (this.cycle_report_switch != _o_.cycle_report_switch) return false;
/* 117 */       if (this.encrypt_size != _o_.encrypt_size) return false;
/* 118 */       if (!this.uuid.equals(_o_.uuid)) return false;
/* 119 */       if (!this.async_data.equals(_o_.async_data)) return false;
/* 120 */       if (this.reserved1 != _o_.reserved1) return false;
/* 121 */       if (this.reserved2 != _o_.reserved2) return false;
/* 122 */       return true;
/*     */     }
/* 124 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 128 */     int _h_ = 0;
/* 129 */     _h_ += this.account.hashCode();
/* 130 */     _h_ += (int)this.roleid;
/* 131 */     _h_ += (int)this.roomid;
/* 132 */     _h_ += (int)this.roomkey;
/* 133 */     _h_ += this.user_openid;
/* 134 */     _h_ += this.cycle_report_switch;
/* 135 */     _h_ += this.encrypt_size;
/* 136 */     _h_ += this.uuid.hashCode();
/* 137 */     _h_ += this.async_data.hashCode();
/* 138 */     _h_ += this.reserved1;
/* 139 */     _h_ += this.reserved2;
/* 140 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 144 */     StringBuilder _sb_ = new StringBuilder();
/* 145 */     _sb_.append("(");
/* 146 */     _sb_.append("B").append(this.account.size()).append(",");
/* 147 */     _sb_.append(this.roleid).append(",");
/* 148 */     _sb_.append(this.roomid).append(",");
/* 149 */     _sb_.append(this.roomkey).append(",");
/* 150 */     _sb_.append(this.user_openid).append(",");
/* 151 */     _sb_.append(this.cycle_report_switch).append(",");
/* 152 */     _sb_.append(this.encrypt_size).append(",");
/* 153 */     _sb_.append("B").append(this.uuid.size()).append(",");
/* 154 */     _sb_.append("B").append(this.async_data.size()).append(",");
/* 155 */     _sb_.append(this.reserved1).append(",");
/* 156 */     _sb_.append(this.reserved2).append(",");
/* 157 */     _sb_.append(")");
/* 158 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\apollo\ApolloCreateLargeRoomReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */