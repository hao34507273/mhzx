/*     */ package apollo;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ApolloCheckLargeRoomExistReq
/*     */   extends __ApolloCheckLargeRoomExistReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12057;
/*     */   public Octets account;
/*     */   public long roleid;
/*     */   public long roomid;
/*     */   public long roomkey;
/*     */   public long gid;
/*     */   public Octets async_data;
/*     */   public int reserved1;
/*     */   public int reserved2;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12057;
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
/*     */   public ApolloCheckLargeRoomExistReq()
/*     */   {
/*  40 */     this.account = new Octets();
/*  41 */     this.roleid = 0L;
/*  42 */     this.roomid = 0L;
/*  43 */     this.roomkey = 0L;
/*  44 */     this.gid = 0L;
/*  45 */     this.async_data = new Octets();
/*  46 */     this.reserved1 = 0;
/*  47 */     this.reserved2 = 0;
/*     */   }
/*     */   
/*     */   public ApolloCheckLargeRoomExistReq(Octets _account_, long _roleid_, long _roomid_, long _roomkey_, long _gid_, Octets _async_data_, int _reserved1_, int _reserved2_) {
/*  51 */     this.account = _account_;
/*  52 */     this.roleid = _roleid_;
/*  53 */     this.roomid = _roomid_;
/*  54 */     this.roomkey = _roomkey_;
/*  55 */     this.gid = _gid_;
/*  56 */     this.async_data = _async_data_;
/*  57 */     this.reserved1 = _reserved1_;
/*  58 */     this.reserved2 = _reserved2_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  62 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  66 */     _os_.marshal(this.account);
/*  67 */     _os_.marshal(this.roleid);
/*  68 */     _os_.marshal(this.roomid);
/*  69 */     _os_.marshal(this.roomkey);
/*  70 */     _os_.marshal(this.gid);
/*  71 */     _os_.marshal(this.async_data);
/*  72 */     _os_.marshal(this.reserved1);
/*  73 */     _os_.marshal(this.reserved2);
/*  74 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  78 */     this.account = _os_.unmarshal_Octets();
/*  79 */     this.roleid = _os_.unmarshal_long();
/*  80 */     this.roomid = _os_.unmarshal_long();
/*  81 */     this.roomkey = _os_.unmarshal_long();
/*  82 */     this.gid = _os_.unmarshal_long();
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
/*  94 */     if ((_o1_ instanceof ApolloCheckLargeRoomExistReq)) {
/*  95 */       ApolloCheckLargeRoomExistReq _o_ = (ApolloCheckLargeRoomExistReq)_o1_;
/*  96 */       if (!this.account.equals(_o_.account)) return false;
/*  97 */       if (this.roleid != _o_.roleid) return false;
/*  98 */       if (this.roomid != _o_.roomid) return false;
/*  99 */       if (this.roomkey != _o_.roomkey) return false;
/* 100 */       if (this.gid != _o_.gid) return false;
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
/* 111 */     _h_ += this.account.hashCode();
/* 112 */     _h_ += (int)this.roleid;
/* 113 */     _h_ += (int)this.roomid;
/* 114 */     _h_ += (int)this.roomkey;
/* 115 */     _h_ += (int)this.gid;
/* 116 */     _h_ += this.async_data.hashCode();
/* 117 */     _h_ += this.reserved1;
/* 118 */     _h_ += this.reserved2;
/* 119 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 123 */     StringBuilder _sb_ = new StringBuilder();
/* 124 */     _sb_.append("(");
/* 125 */     _sb_.append("B").append(this.account.size()).append(",");
/* 126 */     _sb_.append(this.roleid).append(",");
/* 127 */     _sb_.append(this.roomid).append(",");
/* 128 */     _sb_.append(this.roomkey).append(",");
/* 129 */     _sb_.append(this.gid).append(",");
/* 130 */     _sb_.append("B").append(this.async_data.size()).append(",");
/* 131 */     _sb_.append(this.reserved1).append(",");
/* 132 */     _sb_.append(this.reserved2).append(",");
/* 133 */     _sb_.append(")");
/* 134 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\apollo\ApolloCheckLargeRoomExistReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */