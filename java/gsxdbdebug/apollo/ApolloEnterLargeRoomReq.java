/*     */ package apollo;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.LinkedList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ApolloEnterLargeRoomReq
/*     */   extends __ApolloEnterLargeRoomReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12055;
/*     */   public Octets account;
/*     */   public long roleid;
/*     */   public LinkedList<LargeEnterReqInfo> req_infos;
/*     */   public Octets async_data;
/*     */   public int reserved1;
/*     */   public int reserved2;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12055;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public ApolloEnterLargeRoomReq()
/*     */   {
/*  38 */     this.account = new Octets();
/*  39 */     this.roleid = 0L;
/*  40 */     this.req_infos = new LinkedList();
/*  41 */     this.async_data = new Octets();
/*  42 */     this.reserved1 = 0;
/*  43 */     this.reserved2 = 0;
/*     */   }
/*     */   
/*     */   public ApolloEnterLargeRoomReq(Octets _account_, long _roleid_, LinkedList<LargeEnterReqInfo> _req_infos_, Octets _async_data_, int _reserved1_, int _reserved2_) {
/*  47 */     this.account = _account_;
/*  48 */     this.roleid = _roleid_;
/*  49 */     this.req_infos = _req_infos_;
/*  50 */     this.async_data = _async_data_;
/*  51 */     this.reserved1 = _reserved1_;
/*  52 */     this.reserved2 = _reserved2_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  56 */     for (LargeEnterReqInfo _v_ : this.req_infos)
/*  57 */       if (!_v_._validator_()) return false;
/*  58 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  62 */     _os_.marshal(this.account);
/*  63 */     _os_.marshal(this.roleid);
/*  64 */     _os_.compact_uint32(this.req_infos.size());
/*  65 */     for (LargeEnterReqInfo _v_ : this.req_infos) {
/*  66 */       _os_.marshal(_v_);
/*     */     }
/*  68 */     _os_.marshal(this.async_data);
/*  69 */     _os_.marshal(this.reserved1);
/*  70 */     _os_.marshal(this.reserved2);
/*  71 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  75 */     this.account = _os_.unmarshal_Octets();
/*  76 */     this.roleid = _os_.unmarshal_long();
/*  77 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  78 */       LargeEnterReqInfo _v_ = new LargeEnterReqInfo();
/*  79 */       _v_.unmarshal(_os_);
/*  80 */       this.req_infos.add(_v_);
/*     */     }
/*  82 */     this.async_data = _os_.unmarshal_Octets();
/*  83 */     this.reserved1 = _os_.unmarshal_int();
/*  84 */     this.reserved2 = _os_.unmarshal_int();
/*  85 */     if (!_validator_()) {
/*  86 */       throw new VerifyError("validator failed");
/*     */     }
/*  88 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  92 */     if (_o1_ == this) return true;
/*  93 */     if ((_o1_ instanceof ApolloEnterLargeRoomReq)) {
/*  94 */       ApolloEnterLargeRoomReq _o_ = (ApolloEnterLargeRoomReq)_o1_;
/*  95 */       if (!this.account.equals(_o_.account)) return false;
/*  96 */       if (this.roleid != _o_.roleid) return false;
/*  97 */       if (!this.req_infos.equals(_o_.req_infos)) return false;
/*  98 */       if (!this.async_data.equals(_o_.async_data)) return false;
/*  99 */       if (this.reserved1 != _o_.reserved1) return false;
/* 100 */       if (this.reserved2 != _o_.reserved2) return false;
/* 101 */       return true;
/*     */     }
/* 103 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 107 */     int _h_ = 0;
/* 108 */     _h_ += this.account.hashCode();
/* 109 */     _h_ += (int)this.roleid;
/* 110 */     _h_ += this.req_infos.hashCode();
/* 111 */     _h_ += this.async_data.hashCode();
/* 112 */     _h_ += this.reserved1;
/* 113 */     _h_ += this.reserved2;
/* 114 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 118 */     StringBuilder _sb_ = new StringBuilder();
/* 119 */     _sb_.append("(");
/* 120 */     _sb_.append("B").append(this.account.size()).append(",");
/* 121 */     _sb_.append(this.roleid).append(",");
/* 122 */     _sb_.append(this.req_infos).append(",");
/* 123 */     _sb_.append("B").append(this.async_data.size()).append(",");
/* 124 */     _sb_.append(this.reserved1).append(",");
/* 125 */     _sb_.append(this.reserved2).append(",");
/* 126 */     _sb_.append(")");
/* 127 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\apollo\ApolloEnterLargeRoomReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */