/*     */ package betacat;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class DataBetweenBetacatAndGameServerReq extends __DataBetweenBetacatAndGameServerReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 13003;
/*     */   public byte direction;
/*     */   public long xid;
/*     */   public com.goldhuman.Common.Octets account;
/*     */   public int zoneid;
/*     */   public long roleid;
/*     */   public int data_type;
/*     */   public com.goldhuman.Common.Octets data;
/*     */   public int reserved1;
/*     */   public int reserved2;
/*     */   
/*     */   protected void process() {
/*  19 */     mzm.gsp.chat.main.ChatInterface.onDataBetweenBetacatAndGameServerReq(this);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  27 */     return 13003;
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
/*     */   public DataBetweenBetacatAndGameServerReq()
/*     */   {
/*  41 */     this.direction = 1;
/*  42 */     this.account = new com.goldhuman.Common.Octets();
/*  43 */     this.data_type = -1;
/*  44 */     this.data = new com.goldhuman.Common.Octets();
/*  45 */     this.reserved1 = 0;
/*  46 */     this.reserved2 = 0;
/*     */   }
/*     */   
/*     */   public DataBetweenBetacatAndGameServerReq(byte _direction_, long _xid_, com.goldhuman.Common.Octets _account_, int _zoneid_, long _roleid_, int _data_type_, com.goldhuman.Common.Octets _data_, int _reserved1_, int _reserved2_) {
/*  50 */     this.direction = _direction_;
/*  51 */     this.xid = _xid_;
/*  52 */     this.account = _account_;
/*  53 */     this.zoneid = _zoneid_;
/*  54 */     this.roleid = _roleid_;
/*  55 */     this.data_type = _data_type_;
/*  56 */     this.data = _data_;
/*  57 */     this.reserved1 = _reserved1_;
/*  58 */     this.reserved2 = _reserved2_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  62 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  66 */     _os_.marshal(this.direction);
/*  67 */     _os_.marshal(this.xid);
/*  68 */     _os_.marshal(this.account);
/*  69 */     _os_.marshal(this.zoneid);
/*  70 */     _os_.marshal(this.roleid);
/*  71 */     _os_.marshal(this.data_type);
/*  72 */     _os_.marshal(this.data);
/*  73 */     _os_.marshal(this.reserved1);
/*  74 */     _os_.marshal(this.reserved2);
/*  75 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  79 */     this.direction = _os_.unmarshal_byte();
/*  80 */     this.xid = _os_.unmarshal_long();
/*  81 */     this.account = _os_.unmarshal_Octets();
/*  82 */     this.zoneid = _os_.unmarshal_int();
/*  83 */     this.roleid = _os_.unmarshal_long();
/*  84 */     this.data_type = _os_.unmarshal_int();
/*  85 */     this.data = _os_.unmarshal_Octets();
/*  86 */     this.reserved1 = _os_.unmarshal_int();
/*  87 */     this.reserved2 = _os_.unmarshal_int();
/*  88 */     if (!_validator_()) {
/*  89 */       throw new VerifyError("validator failed");
/*     */     }
/*  91 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  95 */     if (_o1_ == this) return true;
/*  96 */     if ((_o1_ instanceof DataBetweenBetacatAndGameServerReq)) {
/*  97 */       DataBetweenBetacatAndGameServerReq _o_ = (DataBetweenBetacatAndGameServerReq)_o1_;
/*  98 */       if (this.direction != _o_.direction) return false;
/*  99 */       if (this.xid != _o_.xid) return false;
/* 100 */       if (!this.account.equals(_o_.account)) return false;
/* 101 */       if (this.zoneid != _o_.zoneid) return false;
/* 102 */       if (this.roleid != _o_.roleid) return false;
/* 103 */       if (this.data_type != _o_.data_type) return false;
/* 104 */       if (!this.data.equals(_o_.data)) return false;
/* 105 */       if (this.reserved1 != _o_.reserved1) return false;
/* 106 */       if (this.reserved2 != _o_.reserved2) return false;
/* 107 */       return true;
/*     */     }
/* 109 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 113 */     int _h_ = 0;
/* 114 */     _h_ += this.direction;
/* 115 */     _h_ += (int)this.xid;
/* 116 */     _h_ += this.account.hashCode();
/* 117 */     _h_ += this.zoneid;
/* 118 */     _h_ += (int)this.roleid;
/* 119 */     _h_ += this.data_type;
/* 120 */     _h_ += this.data.hashCode();
/* 121 */     _h_ += this.reserved1;
/* 122 */     _h_ += this.reserved2;
/* 123 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 127 */     StringBuilder _sb_ = new StringBuilder();
/* 128 */     _sb_.append("(");
/* 129 */     _sb_.append(this.direction).append(",");
/* 130 */     _sb_.append(this.xid).append(",");
/* 131 */     _sb_.append("B").append(this.account.size()).append(",");
/* 132 */     _sb_.append(this.zoneid).append(",");
/* 133 */     _sb_.append(this.roleid).append(",");
/* 134 */     _sb_.append(this.data_type).append(",");
/* 135 */     _sb_.append("B").append(this.data.size()).append(",");
/* 136 */     _sb_.append(this.reserved1).append(",");
/* 137 */     _sb_.append(this.reserved2).append(",");
/* 138 */     _sb_.append(")");
/* 139 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\betacat\DataBetweenBetacatAndGameServerReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */