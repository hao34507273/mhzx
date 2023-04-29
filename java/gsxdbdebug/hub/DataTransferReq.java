/*     */ package hub;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class DataTransferReq extends __DataTransferReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 14008;
/*     */   public byte direction;
/*     */   public int xid;
/*     */   public int src_id;
/*     */   public int dst_id;
/*     */   public int data_type;
/*     */   public com.goldhuman.Common.Octets data;
/*     */   public int reserved1;
/*     */   public int reserved2;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     GHubHelper.onDataTransferReq(this);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  27 */     return 14008;
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
/*     */   public DataTransferReq()
/*     */   {
/*  40 */     this.direction = 0;
/*  41 */     this.data = new com.goldhuman.Common.Octets();
/*  42 */     this.reserved1 = 0;
/*  43 */     this.reserved2 = 0;
/*     */   }
/*     */   
/*     */   public DataTransferReq(byte _direction_, int _xid_, int _src_id_, int _dst_id_, int _data_type_, com.goldhuman.Common.Octets _data_, int _reserved1_, int _reserved2_) {
/*  47 */     this.direction = _direction_;
/*  48 */     this.xid = _xid_;
/*  49 */     this.src_id = _src_id_;
/*  50 */     this.dst_id = _dst_id_;
/*  51 */     this.data_type = _data_type_;
/*  52 */     this.data = _data_;
/*  53 */     this.reserved1 = _reserved1_;
/*  54 */     this.reserved2 = _reserved2_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  58 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  62 */     _os_.marshal(this.direction);
/*  63 */     _os_.marshal(this.xid);
/*  64 */     _os_.marshal(this.src_id);
/*  65 */     _os_.marshal(this.dst_id);
/*  66 */     _os_.marshal(this.data_type);
/*  67 */     _os_.marshal(this.data);
/*  68 */     _os_.marshal(this.reserved1);
/*  69 */     _os_.marshal(this.reserved2);
/*  70 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  74 */     this.direction = _os_.unmarshal_byte();
/*  75 */     this.xid = _os_.unmarshal_int();
/*  76 */     this.src_id = _os_.unmarshal_int();
/*  77 */     this.dst_id = _os_.unmarshal_int();
/*  78 */     this.data_type = _os_.unmarshal_int();
/*  79 */     this.data = _os_.unmarshal_Octets();
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
/*  90 */     if ((_o1_ instanceof DataTransferReq)) {
/*  91 */       DataTransferReq _o_ = (DataTransferReq)_o1_;
/*  92 */       if (this.direction != _o_.direction) return false;
/*  93 */       if (this.xid != _o_.xid) return false;
/*  94 */       if (this.src_id != _o_.src_id) return false;
/*  95 */       if (this.dst_id != _o_.dst_id) return false;
/*  96 */       if (this.data_type != _o_.data_type) return false;
/*  97 */       if (!this.data.equals(_o_.data)) return false;
/*  98 */       if (this.reserved1 != _o_.reserved1) return false;
/*  99 */       if (this.reserved2 != _o_.reserved2) return false;
/* 100 */       return true;
/*     */     }
/* 102 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 106 */     int _h_ = 0;
/* 107 */     _h_ += this.direction;
/* 108 */     _h_ += this.xid;
/* 109 */     _h_ += this.src_id;
/* 110 */     _h_ += this.dst_id;
/* 111 */     _h_ += this.data_type;
/* 112 */     _h_ += this.data.hashCode();
/* 113 */     _h_ += this.reserved1;
/* 114 */     _h_ += this.reserved2;
/* 115 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 119 */     StringBuilder _sb_ = new StringBuilder();
/* 120 */     _sb_.append("(");
/* 121 */     _sb_.append(this.direction).append(",");
/* 122 */     _sb_.append(this.xid).append(",");
/* 123 */     _sb_.append(this.src_id).append(",");
/* 124 */     _sb_.append(this.dst_id).append(",");
/* 125 */     _sb_.append(this.data_type).append(",");
/* 126 */     _sb_.append("B").append(this.data.size()).append(",");
/* 127 */     _sb_.append(this.reserved1).append(",");
/* 128 */     _sb_.append(this.reserved2).append(",");
/* 129 */     _sb_.append(")");
/* 130 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\DataTransferReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */