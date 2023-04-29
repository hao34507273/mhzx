/*     */ package openau;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ 
/*     */ public class DataBetweenAuanyAndOthersReq extends __DataBetweenAuanyAndOthersReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 8910;
/*     */   public byte direction;
/*     */   public Octets account;
/*     */   public int zoneid;
/*     */   public long roleid;
/*     */   public int reqtype;
/*     */   public Octets reqdata;
/*     */   public int reserved1;
/*     */   public Octets reserved2;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     mzm.gsp.qingfu.main.QingfuInterface.onDataBetweenAuanyAndOthersReq(this);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  28 */     return 8910;
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
/*     */   public DataBetweenAuanyAndOthersReq()
/*     */   {
/*  41 */     this.direction = 4;
/*  42 */     this.account = new Octets();
/*  43 */     this.reqdata = new Octets();
/*  44 */     this.reserved1 = 0;
/*  45 */     this.reserved2 = new Octets();
/*     */   }
/*     */   
/*     */   public DataBetweenAuanyAndOthersReq(byte _direction_, Octets _account_, int _zoneid_, long _roleid_, int _reqtype_, Octets _reqdata_, int _reserved1_, Octets _reserved2_) {
/*  49 */     this.direction = _direction_;
/*  50 */     this.account = _account_;
/*  51 */     this.zoneid = _zoneid_;
/*  52 */     this.roleid = _roleid_;
/*  53 */     this.reqtype = _reqtype_;
/*  54 */     this.reqdata = _reqdata_;
/*  55 */     this.reserved1 = _reserved1_;
/*  56 */     this.reserved2 = _reserved2_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  60 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  64 */     _os_.marshal(this.direction);
/*  65 */     _os_.marshal(this.account);
/*  66 */     _os_.marshal(this.zoneid);
/*  67 */     _os_.marshal(this.roleid);
/*  68 */     _os_.marshal(this.reqtype);
/*  69 */     _os_.marshal(this.reqdata);
/*  70 */     _os_.marshal(this.reserved1);
/*  71 */     _os_.marshal(this.reserved2);
/*  72 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  76 */     this.direction = _os_.unmarshal_byte();
/*  77 */     this.account = _os_.unmarshal_Octets();
/*  78 */     this.zoneid = _os_.unmarshal_int();
/*  79 */     this.roleid = _os_.unmarshal_long();
/*  80 */     this.reqtype = _os_.unmarshal_int();
/*  81 */     this.reqdata = _os_.unmarshal_Octets();
/*  82 */     this.reserved1 = _os_.unmarshal_int();
/*  83 */     this.reserved2 = _os_.unmarshal_Octets();
/*  84 */     if (!_validator_()) {
/*  85 */       throw new VerifyError("validator failed");
/*     */     }
/*  87 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  91 */     if (_o1_ == this) return true;
/*  92 */     if ((_o1_ instanceof DataBetweenAuanyAndOthersReq)) {
/*  93 */       DataBetweenAuanyAndOthersReq _o_ = (DataBetweenAuanyAndOthersReq)_o1_;
/*  94 */       if (this.direction != _o_.direction) return false;
/*  95 */       if (!this.account.equals(_o_.account)) return false;
/*  96 */       if (this.zoneid != _o_.zoneid) return false;
/*  97 */       if (this.roleid != _o_.roleid) return false;
/*  98 */       if (this.reqtype != _o_.reqtype) return false;
/*  99 */       if (!this.reqdata.equals(_o_.reqdata)) return false;
/* 100 */       if (this.reserved1 != _o_.reserved1) return false;
/* 101 */       if (!this.reserved2.equals(_o_.reserved2)) return false;
/* 102 */       return true;
/*     */     }
/* 104 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 108 */     int _h_ = 0;
/* 109 */     _h_ += this.direction;
/* 110 */     _h_ += this.account.hashCode();
/* 111 */     _h_ += this.zoneid;
/* 112 */     _h_ += (int)this.roleid;
/* 113 */     _h_ += this.reqtype;
/* 114 */     _h_ += this.reqdata.hashCode();
/* 115 */     _h_ += this.reserved1;
/* 116 */     _h_ += this.reserved2.hashCode();
/* 117 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 121 */     StringBuilder _sb_ = new StringBuilder();
/* 122 */     _sb_.append("(");
/* 123 */     _sb_.append(this.direction).append(",");
/* 124 */     _sb_.append("B").append(this.account.size()).append(",");
/* 125 */     _sb_.append(this.zoneid).append(",");
/* 126 */     _sb_.append(this.roleid).append(",");
/* 127 */     _sb_.append(this.reqtype).append(",");
/* 128 */     _sb_.append("B").append(this.reqdata.size()).append(",");
/* 129 */     _sb_.append(this.reserved1).append(",");
/* 130 */     _sb_.append("B").append(this.reserved2.size()).append(",");
/* 131 */     _sb_.append(")");
/* 132 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\openau\DataBetweenAuanyAndOthersReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */