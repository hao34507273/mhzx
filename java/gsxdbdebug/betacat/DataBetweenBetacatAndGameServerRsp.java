/*     */ package betacat;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class DataBetweenBetacatAndGameServerRsp extends __DataBetweenBetacatAndGameServerRsp__ {
/*     */   public static final int PROTOCOL_TYPE = 13004;
/*     */   public byte direction;
/*     */   public long xid;
/*     */   public com.goldhuman.Common.Octets account;
/*     */   public int zoneid;
/*     */   public long roleid;
/*     */   public int data_type;
/*     */   public com.goldhuman.Common.Octets data;
/*     */   public int retcode;
/*     */   public int reserved1;
/*     */   public int reserved2;
/*     */   
/*     */   protected void process() {
/*  19 */     mzm.gsp.chat.main.ChatInterface.onDataBetweenBetacatAndGameServerRsp(this);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  27 */     return 13004;
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
/*     */   public DataBetweenBetacatAndGameServerRsp()
/*     */   {
/*  42 */     this.direction = 1;
/*  43 */     this.account = new com.goldhuman.Common.Octets();
/*  44 */     this.data_type = -1;
/*  45 */     this.data = new com.goldhuman.Common.Octets();
/*  46 */     this.retcode = 60;
/*  47 */     this.reserved1 = 0;
/*  48 */     this.reserved2 = 0;
/*     */   }
/*     */   
/*     */   public DataBetweenBetacatAndGameServerRsp(byte _direction_, long _xid_, com.goldhuman.Common.Octets _account_, int _zoneid_, long _roleid_, int _data_type_, com.goldhuman.Common.Octets _data_, int _retcode_, int _reserved1_, int _reserved2_) {
/*  52 */     this.direction = _direction_;
/*  53 */     this.xid = _xid_;
/*  54 */     this.account = _account_;
/*  55 */     this.zoneid = _zoneid_;
/*  56 */     this.roleid = _roleid_;
/*  57 */     this.data_type = _data_type_;
/*  58 */     this.data = _data_;
/*  59 */     this.retcode = _retcode_;
/*  60 */     this.reserved1 = _reserved1_;
/*  61 */     this.reserved2 = _reserved2_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  65 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  69 */     _os_.marshal(this.direction);
/*  70 */     _os_.marshal(this.xid);
/*  71 */     _os_.marshal(this.account);
/*  72 */     _os_.marshal(this.zoneid);
/*  73 */     _os_.marshal(this.roleid);
/*  74 */     _os_.marshal(this.data_type);
/*  75 */     _os_.marshal(this.data);
/*  76 */     _os_.marshal(this.retcode);
/*  77 */     _os_.marshal(this.reserved1);
/*  78 */     _os_.marshal(this.reserved2);
/*  79 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  83 */     this.direction = _os_.unmarshal_byte();
/*  84 */     this.xid = _os_.unmarshal_long();
/*  85 */     this.account = _os_.unmarshal_Octets();
/*  86 */     this.zoneid = _os_.unmarshal_int();
/*  87 */     this.roleid = _os_.unmarshal_long();
/*  88 */     this.data_type = _os_.unmarshal_int();
/*  89 */     this.data = _os_.unmarshal_Octets();
/*  90 */     this.retcode = _os_.unmarshal_int();
/*  91 */     this.reserved1 = _os_.unmarshal_int();
/*  92 */     this.reserved2 = _os_.unmarshal_int();
/*  93 */     if (!_validator_()) {
/*  94 */       throw new VerifyError("validator failed");
/*     */     }
/*  96 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/* 100 */     if (_o1_ == this) return true;
/* 101 */     if ((_o1_ instanceof DataBetweenBetacatAndGameServerRsp)) {
/* 102 */       DataBetweenBetacatAndGameServerRsp _o_ = (DataBetweenBetacatAndGameServerRsp)_o1_;
/* 103 */       if (this.direction != _o_.direction) return false;
/* 104 */       if (this.xid != _o_.xid) return false;
/* 105 */       if (!this.account.equals(_o_.account)) return false;
/* 106 */       if (this.zoneid != _o_.zoneid) return false;
/* 107 */       if (this.roleid != _o_.roleid) return false;
/* 108 */       if (this.data_type != _o_.data_type) return false;
/* 109 */       if (!this.data.equals(_o_.data)) return false;
/* 110 */       if (this.retcode != _o_.retcode) return false;
/* 111 */       if (this.reserved1 != _o_.reserved1) return false;
/* 112 */       if (this.reserved2 != _o_.reserved2) return false;
/* 113 */       return true;
/*     */     }
/* 115 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 119 */     int _h_ = 0;
/* 120 */     _h_ += this.direction;
/* 121 */     _h_ += (int)this.xid;
/* 122 */     _h_ += this.account.hashCode();
/* 123 */     _h_ += this.zoneid;
/* 124 */     _h_ += (int)this.roleid;
/* 125 */     _h_ += this.data_type;
/* 126 */     _h_ += this.data.hashCode();
/* 127 */     _h_ += this.retcode;
/* 128 */     _h_ += this.reserved1;
/* 129 */     _h_ += this.reserved2;
/* 130 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 134 */     StringBuilder _sb_ = new StringBuilder();
/* 135 */     _sb_.append("(");
/* 136 */     _sb_.append(this.direction).append(",");
/* 137 */     _sb_.append(this.xid).append(",");
/* 138 */     _sb_.append("B").append(this.account.size()).append(",");
/* 139 */     _sb_.append(this.zoneid).append(",");
/* 140 */     _sb_.append(this.roleid).append(",");
/* 141 */     _sb_.append(this.data_type).append(",");
/* 142 */     _sb_.append("B").append(this.data.size()).append(",");
/* 143 */     _sb_.append(this.retcode).append(",");
/* 144 */     _sb_.append(this.reserved1).append(",");
/* 145 */     _sb_.append(this.reserved2).append(",");
/* 146 */     _sb_.append(")");
/* 147 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\betacat\DataBetweenBetacatAndGameServerRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */