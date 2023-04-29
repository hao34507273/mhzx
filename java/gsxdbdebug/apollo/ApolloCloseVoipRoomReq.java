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
/*     */ public class ApolloCloseVoipRoomReq
/*     */   extends __ApolloCloseVoipRoomReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12017;
/*     */   public Octets account;
/*     */   public long roleid;
/*     */   public long room_id;
/*     */   public int close_type;
/*     */   public Octets async_data;
/*     */   public int reserved1;
/*     */   public int reserved2;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12017;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public ApolloCloseVoipRoomReq()
/*     */   {
/*  39 */     this.account = new Octets();
/*  40 */     this.roleid = 0L;
/*  41 */     this.room_id = 0L;
/*  42 */     this.close_type = 1;
/*  43 */     this.async_data = new Octets();
/*  44 */     this.reserved1 = 0;
/*  45 */     this.reserved2 = 0;
/*     */   }
/*     */   
/*     */   public ApolloCloseVoipRoomReq(Octets _account_, long _roleid_, long _room_id_, int _close_type_, Octets _async_data_, int _reserved1_, int _reserved2_) {
/*  49 */     this.account = _account_;
/*  50 */     this.roleid = _roleid_;
/*  51 */     this.room_id = _room_id_;
/*  52 */     this.close_type = _close_type_;
/*  53 */     this.async_data = _async_data_;
/*  54 */     this.reserved1 = _reserved1_;
/*  55 */     this.reserved2 = _reserved2_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  59 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  63 */     _os_.marshal(this.account);
/*  64 */     _os_.marshal(this.roleid);
/*  65 */     _os_.marshal(this.room_id);
/*  66 */     _os_.marshal(this.close_type);
/*  67 */     _os_.marshal(this.async_data);
/*  68 */     _os_.marshal(this.reserved1);
/*  69 */     _os_.marshal(this.reserved2);
/*  70 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  74 */     this.account = _os_.unmarshal_Octets();
/*  75 */     this.roleid = _os_.unmarshal_long();
/*  76 */     this.room_id = _os_.unmarshal_long();
/*  77 */     this.close_type = _os_.unmarshal_int();
/*  78 */     this.async_data = _os_.unmarshal_Octets();
/*  79 */     this.reserved1 = _os_.unmarshal_int();
/*  80 */     this.reserved2 = _os_.unmarshal_int();
/*  81 */     if (!_validator_()) {
/*  82 */       throw new VerifyError("validator failed");
/*     */     }
/*  84 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  88 */     if (_o1_ == this) return true;
/*  89 */     if ((_o1_ instanceof ApolloCloseVoipRoomReq)) {
/*  90 */       ApolloCloseVoipRoomReq _o_ = (ApolloCloseVoipRoomReq)_o1_;
/*  91 */       if (!this.account.equals(_o_.account)) return false;
/*  92 */       if (this.roleid != _o_.roleid) return false;
/*  93 */       if (this.room_id != _o_.room_id) return false;
/*  94 */       if (this.close_type != _o_.close_type) return false;
/*  95 */       if (!this.async_data.equals(_o_.async_data)) return false;
/*  96 */       if (this.reserved1 != _o_.reserved1) return false;
/*  97 */       if (this.reserved2 != _o_.reserved2) return false;
/*  98 */       return true;
/*     */     }
/* 100 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 104 */     int _h_ = 0;
/* 105 */     _h_ += this.account.hashCode();
/* 106 */     _h_ += (int)this.roleid;
/* 107 */     _h_ += (int)this.room_id;
/* 108 */     _h_ += this.close_type;
/* 109 */     _h_ += this.async_data.hashCode();
/* 110 */     _h_ += this.reserved1;
/* 111 */     _h_ += this.reserved2;
/* 112 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 116 */     StringBuilder _sb_ = new StringBuilder();
/* 117 */     _sb_.append("(");
/* 118 */     _sb_.append("B").append(this.account.size()).append(",");
/* 119 */     _sb_.append(this.roleid).append(",");
/* 120 */     _sb_.append(this.room_id).append(",");
/* 121 */     _sb_.append(this.close_type).append(",");
/* 122 */     _sb_.append("B").append(this.async_data.size()).append(",");
/* 123 */     _sb_.append(this.reserved1).append(",");
/* 124 */     _sb_.append(this.reserved2).append(",");
/* 125 */     _sb_.append(")");
/* 126 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\apollo\ApolloCloseVoipRoomReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */