/*     */ package hub;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class DataTransferRsp extends __DataTransferRsp__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 14009;
/*     */   public byte direction;
/*     */   public int xid;
/*     */   public int src_id;
/*     */   public int dst_id;
/*     */   public int data_type;
/*     */   public com.goldhuman.Common.Octets data;
/*     */   public int retcode;
/*     */   public int reserved1;
/*     */   public int reserved2;
/*     */   
/*     */   protected void process() {
/*  19 */     GHubHelper.onDataTransferRsp(this);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  27 */     return 14009;
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
/*     */   public DataTransferRsp()
/*     */   {
/*  41 */     this.direction = 0;
/*  42 */     this.data = new com.goldhuman.Common.Octets();
/*  43 */     this.retcode = 2;
/*  44 */     this.reserved1 = 0;
/*  45 */     this.reserved2 = 0;
/*     */   }
/*     */   
/*     */   public DataTransferRsp(byte _direction_, int _xid_, int _src_id_, int _dst_id_, int _data_type_, com.goldhuman.Common.Octets _data_, int _retcode_, int _reserved1_, int _reserved2_) {
/*  49 */     this.direction = _direction_;
/*  50 */     this.xid = _xid_;
/*  51 */     this.src_id = _src_id_;
/*  52 */     this.dst_id = _dst_id_;
/*  53 */     this.data_type = _data_type_;
/*  54 */     this.data = _data_;
/*  55 */     this.retcode = _retcode_;
/*  56 */     this.reserved1 = _reserved1_;
/*  57 */     this.reserved2 = _reserved2_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  61 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  65 */     _os_.marshal(this.direction);
/*  66 */     _os_.marshal(this.xid);
/*  67 */     _os_.marshal(this.src_id);
/*  68 */     _os_.marshal(this.dst_id);
/*  69 */     _os_.marshal(this.data_type);
/*  70 */     _os_.marshal(this.data);
/*  71 */     _os_.marshal(this.retcode);
/*  72 */     _os_.marshal(this.reserved1);
/*  73 */     _os_.marshal(this.reserved2);
/*  74 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  78 */     this.direction = _os_.unmarshal_byte();
/*  79 */     this.xid = _os_.unmarshal_int();
/*  80 */     this.src_id = _os_.unmarshal_int();
/*  81 */     this.dst_id = _os_.unmarshal_int();
/*  82 */     this.data_type = _os_.unmarshal_int();
/*  83 */     this.data = _os_.unmarshal_Octets();
/*  84 */     this.retcode = _os_.unmarshal_int();
/*  85 */     this.reserved1 = _os_.unmarshal_int();
/*  86 */     this.reserved2 = _os_.unmarshal_int();
/*  87 */     if (!_validator_()) {
/*  88 */       throw new VerifyError("validator failed");
/*     */     }
/*  90 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  94 */     if (_o1_ == this) return true;
/*  95 */     if ((_o1_ instanceof DataTransferRsp)) {
/*  96 */       DataTransferRsp _o_ = (DataTransferRsp)_o1_;
/*  97 */       if (this.direction != _o_.direction) return false;
/*  98 */       if (this.xid != _o_.xid) return false;
/*  99 */       if (this.src_id != _o_.src_id) return false;
/* 100 */       if (this.dst_id != _o_.dst_id) return false;
/* 101 */       if (this.data_type != _o_.data_type) return false;
/* 102 */       if (!this.data.equals(_o_.data)) return false;
/* 103 */       if (this.retcode != _o_.retcode) return false;
/* 104 */       if (this.reserved1 != _o_.reserved1) return false;
/* 105 */       if (this.reserved2 != _o_.reserved2) return false;
/* 106 */       return true;
/*     */     }
/* 108 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 112 */     int _h_ = 0;
/* 113 */     _h_ += this.direction;
/* 114 */     _h_ += this.xid;
/* 115 */     _h_ += this.src_id;
/* 116 */     _h_ += this.dst_id;
/* 117 */     _h_ += this.data_type;
/* 118 */     _h_ += this.data.hashCode();
/* 119 */     _h_ += this.retcode;
/* 120 */     _h_ += this.reserved1;
/* 121 */     _h_ += this.reserved2;
/* 122 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 126 */     StringBuilder _sb_ = new StringBuilder();
/* 127 */     _sb_.append("(");
/* 128 */     _sb_.append(this.direction).append(",");
/* 129 */     _sb_.append(this.xid).append(",");
/* 130 */     _sb_.append(this.src_id).append(",");
/* 131 */     _sb_.append(this.dst_id).append(",");
/* 132 */     _sb_.append(this.data_type).append(",");
/* 133 */     _sb_.append("B").append(this.data.size()).append(",");
/* 134 */     _sb_.append(this.retcode).append(",");
/* 135 */     _sb_.append(this.reserved1).append(",");
/* 136 */     _sb_.append(this.reserved2).append(",");
/* 137 */     _sb_.append(")");
/* 138 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\DataTransferRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */