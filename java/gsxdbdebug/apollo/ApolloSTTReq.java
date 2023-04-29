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
/*     */ public class ApolloSTTReq
/*     */   extends __ApolloSTTReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12073;
/*     */   public Octets account;
/*     */   public long roleid;
/*     */   public Octets file_id;
/*     */   public Octets async_data;
/*     */   public int reserved1;
/*     */   public int reserved2;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12073;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public ApolloSTTReq()
/*     */   {
/*  38 */     this.account = new Octets();
/*  39 */     this.roleid = 0L;
/*  40 */     this.file_id = new Octets();
/*  41 */     this.async_data = new Octets();
/*  42 */     this.reserved1 = 0;
/*  43 */     this.reserved2 = 0;
/*     */   }
/*     */   
/*     */   public ApolloSTTReq(Octets _account_, long _roleid_, Octets _file_id_, Octets _async_data_, int _reserved1_, int _reserved2_) {
/*  47 */     this.account = _account_;
/*  48 */     this.roleid = _roleid_;
/*  49 */     this.file_id = _file_id_;
/*  50 */     this.async_data = _async_data_;
/*  51 */     this.reserved1 = _reserved1_;
/*  52 */     this.reserved2 = _reserved2_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  56 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  60 */     _os_.marshal(this.account);
/*  61 */     _os_.marshal(this.roleid);
/*  62 */     _os_.marshal(this.file_id);
/*  63 */     _os_.marshal(this.async_data);
/*  64 */     _os_.marshal(this.reserved1);
/*  65 */     _os_.marshal(this.reserved2);
/*  66 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  70 */     this.account = _os_.unmarshal_Octets();
/*  71 */     this.roleid = _os_.unmarshal_long();
/*  72 */     this.file_id = _os_.unmarshal_Octets();
/*  73 */     this.async_data = _os_.unmarshal_Octets();
/*  74 */     this.reserved1 = _os_.unmarshal_int();
/*  75 */     this.reserved2 = _os_.unmarshal_int();
/*  76 */     if (!_validator_()) {
/*  77 */       throw new VerifyError("validator failed");
/*     */     }
/*  79 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  83 */     if (_o1_ == this) return true;
/*  84 */     if ((_o1_ instanceof ApolloSTTReq)) {
/*  85 */       ApolloSTTReq _o_ = (ApolloSTTReq)_o1_;
/*  86 */       if (!this.account.equals(_o_.account)) return false;
/*  87 */       if (this.roleid != _o_.roleid) return false;
/*  88 */       if (!this.file_id.equals(_o_.file_id)) return false;
/*  89 */       if (!this.async_data.equals(_o_.async_data)) return false;
/*  90 */       if (this.reserved1 != _o_.reserved1) return false;
/*  91 */       if (this.reserved2 != _o_.reserved2) return false;
/*  92 */       return true;
/*     */     }
/*  94 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  98 */     int _h_ = 0;
/*  99 */     _h_ += this.account.hashCode();
/* 100 */     _h_ += (int)this.roleid;
/* 101 */     _h_ += this.file_id.hashCode();
/* 102 */     _h_ += this.async_data.hashCode();
/* 103 */     _h_ += this.reserved1;
/* 104 */     _h_ += this.reserved2;
/* 105 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 109 */     StringBuilder _sb_ = new StringBuilder();
/* 110 */     _sb_.append("(");
/* 111 */     _sb_.append("B").append(this.account.size()).append(",");
/* 112 */     _sb_.append(this.roleid).append(",");
/* 113 */     _sb_.append("B").append(this.file_id.size()).append(",");
/* 114 */     _sb_.append("B").append(this.async_data.size()).append(",");
/* 115 */     _sb_.append(this.reserved1).append(",");
/* 116 */     _sb_.append(this.reserved2).append(",");
/* 117 */     _sb_.append(")");
/* 118 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\apollo\ApolloSTTReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */