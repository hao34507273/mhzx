/*     */ package idip;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class DataBetweenIDIPAndGameReq extends __DataBetweenIDIPAndGameReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 8962;
/*     */   public byte direction;
/*     */   public int xid;
/*     */   public int proxyid;
/*     */   public int zoneid;
/*     */   public int reqtype;
/*     */   public com.goldhuman.Common.Octets reqdata;
/*     */   public int reserved1;
/*     */   public int reserved2;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     mzm.gsp.idip.main.IDIPCmdManager.handIDIPRequest(this);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  27 */     return 8962;
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
/*     */   public DataBetweenIDIPAndGameReq()
/*     */   {
/*  40 */     this.direction = 1;
/*  41 */     this.reqdata = new com.goldhuman.Common.Octets();
/*  42 */     this.reserved1 = 0;
/*  43 */     this.reserved2 = 0;
/*     */   }
/*     */   
/*     */   public DataBetweenIDIPAndGameReq(byte _direction_, int _xid_, int _proxyid_, int _zoneid_, int _reqtype_, com.goldhuman.Common.Octets _reqdata_, int _reserved1_, int _reserved2_) {
/*  47 */     this.direction = _direction_;
/*  48 */     this.xid = _xid_;
/*  49 */     this.proxyid = _proxyid_;
/*  50 */     this.zoneid = _zoneid_;
/*  51 */     this.reqtype = _reqtype_;
/*  52 */     this.reqdata = _reqdata_;
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
/*  64 */     _os_.marshal(this.proxyid);
/*  65 */     _os_.marshal(this.zoneid);
/*  66 */     _os_.marshal(this.reqtype);
/*  67 */     _os_.marshal(this.reqdata);
/*  68 */     _os_.marshal(this.reserved1);
/*  69 */     _os_.marshal(this.reserved2);
/*  70 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  74 */     this.direction = _os_.unmarshal_byte();
/*  75 */     this.xid = _os_.unmarshal_int();
/*  76 */     this.proxyid = _os_.unmarshal_int();
/*  77 */     this.zoneid = _os_.unmarshal_int();
/*  78 */     this.reqtype = _os_.unmarshal_int();
/*  79 */     this.reqdata = _os_.unmarshal_Octets();
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
/*  90 */     if ((_o1_ instanceof DataBetweenIDIPAndGameReq)) {
/*  91 */       DataBetweenIDIPAndGameReq _o_ = (DataBetweenIDIPAndGameReq)_o1_;
/*  92 */       if (this.direction != _o_.direction) return false;
/*  93 */       if (this.xid != _o_.xid) return false;
/*  94 */       if (this.proxyid != _o_.proxyid) return false;
/*  95 */       if (this.zoneid != _o_.zoneid) return false;
/*  96 */       if (this.reqtype != _o_.reqtype) return false;
/*  97 */       if (!this.reqdata.equals(_o_.reqdata)) return false;
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
/* 109 */     _h_ += this.proxyid;
/* 110 */     _h_ += this.zoneid;
/* 111 */     _h_ += this.reqtype;
/* 112 */     _h_ += this.reqdata.hashCode();
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
/* 123 */     _sb_.append(this.proxyid).append(",");
/* 124 */     _sb_.append(this.zoneid).append(",");
/* 125 */     _sb_.append(this.reqtype).append(",");
/* 126 */     _sb_.append("B").append(this.reqdata.size()).append(",");
/* 127 */     _sb_.append(this.reserved1).append(",");
/* 128 */     _sb_.append(this.reserved2).append(",");
/* 129 */     _sb_.append(")");
/* 130 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\DataBetweenIDIPAndGameReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */