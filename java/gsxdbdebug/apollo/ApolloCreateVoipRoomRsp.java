/*     */ package apollo;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ 
/*     */ public class ApolloCreateVoipRoomRsp extends __ApolloCreateVoipRoomRsp__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12012;
/*     */   public int retcode;
/*     */   public Octets account;
/*     */   public long roleid;
/*     */   public long room_id;
/*     */   public Octets async_data;
/*     */   public int reserved1;
/*     */   public int reserved2;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     mzm.gsp.apollo.main.ApolloInterface.onApolloCreateVoipRoomRsp(this);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  27 */     return 12012;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public ApolloCreateVoipRoomRsp()
/*     */   {
/*  39 */     this.retcode = 9;
/*  40 */     this.account = new Octets();
/*  41 */     this.roleid = 0L;
/*  42 */     this.room_id = 0L;
/*  43 */     this.async_data = new Octets();
/*  44 */     this.reserved1 = 0;
/*  45 */     this.reserved2 = 0;
/*     */   }
/*     */   
/*     */   public ApolloCreateVoipRoomRsp(int _retcode_, Octets _account_, long _roleid_, long _room_id_, Octets _async_data_, int _reserved1_, int _reserved2_) {
/*  49 */     this.retcode = _retcode_;
/*  50 */     this.account = _account_;
/*  51 */     this.roleid = _roleid_;
/*  52 */     this.room_id = _room_id_;
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
/*  63 */     _os_.marshal(this.retcode);
/*  64 */     _os_.marshal(this.account);
/*  65 */     _os_.marshal(this.roleid);
/*  66 */     _os_.marshal(this.room_id);
/*  67 */     _os_.marshal(this.async_data);
/*  68 */     _os_.marshal(this.reserved1);
/*  69 */     _os_.marshal(this.reserved2);
/*  70 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  74 */     this.retcode = _os_.unmarshal_int();
/*  75 */     this.account = _os_.unmarshal_Octets();
/*  76 */     this.roleid = _os_.unmarshal_long();
/*  77 */     this.room_id = _os_.unmarshal_long();
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
/*  89 */     if ((_o1_ instanceof ApolloCreateVoipRoomRsp)) {
/*  90 */       ApolloCreateVoipRoomRsp _o_ = (ApolloCreateVoipRoomRsp)_o1_;
/*  91 */       if (this.retcode != _o_.retcode) return false;
/*  92 */       if (!this.account.equals(_o_.account)) return false;
/*  93 */       if (this.roleid != _o_.roleid) return false;
/*  94 */       if (this.room_id != _o_.room_id) return false;
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
/* 105 */     _h_ += this.retcode;
/* 106 */     _h_ += this.account.hashCode();
/* 107 */     _h_ += (int)this.roleid;
/* 108 */     _h_ += (int)this.room_id;
/* 109 */     _h_ += this.async_data.hashCode();
/* 110 */     _h_ += this.reserved1;
/* 111 */     _h_ += this.reserved2;
/* 112 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 116 */     StringBuilder _sb_ = new StringBuilder();
/* 117 */     _sb_.append("(");
/* 118 */     _sb_.append(this.retcode).append(",");
/* 119 */     _sb_.append("B").append(this.account.size()).append(",");
/* 120 */     _sb_.append(this.roleid).append(",");
/* 121 */     _sb_.append(this.room_id).append(",");
/* 122 */     _sb_.append("B").append(this.async_data.size()).append(",");
/* 123 */     _sb_.append(this.reserved1).append(",");
/* 124 */     _sb_.append(this.reserved2).append(",");
/* 125 */     _sb_.append(")");
/* 126 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\apollo\ApolloCreateVoipRoomRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */