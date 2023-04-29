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
/*     */ 
/*     */ 
/*     */ public class ApolloCreateVoipRoomReq
/*     */   extends __ApolloCreateVoipRoomReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12011;
/*     */   public Octets account;
/*     */   public long roleid;
/*     */   public Octets async_data;
/*     */   public int reserved1;
/*     */   public int reserved2;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12011;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public ApolloCreateVoipRoomReq()
/*     */   {
/*  37 */     this.account = new Octets();
/*  38 */     this.roleid = 0L;
/*  39 */     this.async_data = new Octets();
/*  40 */     this.reserved1 = 0;
/*  41 */     this.reserved2 = 0;
/*     */   }
/*     */   
/*     */   public ApolloCreateVoipRoomReq(Octets _account_, long _roleid_, Octets _async_data_, int _reserved1_, int _reserved2_) {
/*  45 */     this.account = _account_;
/*  46 */     this.roleid = _roleid_;
/*  47 */     this.async_data = _async_data_;
/*  48 */     this.reserved1 = _reserved1_;
/*  49 */     this.reserved2 = _reserved2_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  53 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  57 */     _os_.marshal(this.account);
/*  58 */     _os_.marshal(this.roleid);
/*  59 */     _os_.marshal(this.async_data);
/*  60 */     _os_.marshal(this.reserved1);
/*  61 */     _os_.marshal(this.reserved2);
/*  62 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  66 */     this.account = _os_.unmarshal_Octets();
/*  67 */     this.roleid = _os_.unmarshal_long();
/*  68 */     this.async_data = _os_.unmarshal_Octets();
/*  69 */     this.reserved1 = _os_.unmarshal_int();
/*  70 */     this.reserved2 = _os_.unmarshal_int();
/*  71 */     if (!_validator_()) {
/*  72 */       throw new VerifyError("validator failed");
/*     */     }
/*  74 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  78 */     if (_o1_ == this) return true;
/*  79 */     if ((_o1_ instanceof ApolloCreateVoipRoomReq)) {
/*  80 */       ApolloCreateVoipRoomReq _o_ = (ApolloCreateVoipRoomReq)_o1_;
/*  81 */       if (!this.account.equals(_o_.account)) return false;
/*  82 */       if (this.roleid != _o_.roleid) return false;
/*  83 */       if (!this.async_data.equals(_o_.async_data)) return false;
/*  84 */       if (this.reserved1 != _o_.reserved1) return false;
/*  85 */       if (this.reserved2 != _o_.reserved2) return false;
/*  86 */       return true;
/*     */     }
/*  88 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  92 */     int _h_ = 0;
/*  93 */     _h_ += this.account.hashCode();
/*  94 */     _h_ += (int)this.roleid;
/*  95 */     _h_ += this.async_data.hashCode();
/*  96 */     _h_ += this.reserved1;
/*  97 */     _h_ += this.reserved2;
/*  98 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 102 */     StringBuilder _sb_ = new StringBuilder();
/* 103 */     _sb_.append("(");
/* 104 */     _sb_.append("B").append(this.account.size()).append(",");
/* 105 */     _sb_.append(this.roleid).append(",");
/* 106 */     _sb_.append("B").append(this.async_data.size()).append(",");
/* 107 */     _sb_.append(this.reserved1).append(",");
/* 108 */     _sb_.append(this.reserved2).append(",");
/* 109 */     _sb_.append(")");
/* 110 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\apollo\ApolloCreateVoipRoomReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */