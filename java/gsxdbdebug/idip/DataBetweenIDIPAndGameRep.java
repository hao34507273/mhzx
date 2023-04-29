/*     */ package idip;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DataBetweenIDIPAndGameRep
/*     */   extends __DataBetweenIDIPAndGameRep__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 8963;
/*     */   public byte direction;
/*     */   public int xid;
/*     */   public int proxyid;
/*     */   public int zoneid;
/*     */   public int retcode;
/*     */   public Octets repdata;
/*     */   public int reserved1;
/*     */   public int reserved2;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 8963;
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
/*     */   public DataBetweenIDIPAndGameRep()
/*     */   {
/*  40 */     this.direction = 1;
/*  41 */     this.retcode = 60;
/*  42 */     this.repdata = new Octets();
/*  43 */     this.reserved1 = 0;
/*  44 */     this.reserved2 = 0;
/*     */   }
/*     */   
/*     */   public DataBetweenIDIPAndGameRep(byte _direction_, int _xid_, int _proxyid_, int _zoneid_, int _retcode_, Octets _repdata_, int _reserved1_, int _reserved2_) {
/*  48 */     this.direction = _direction_;
/*  49 */     this.xid = _xid_;
/*  50 */     this.proxyid = _proxyid_;
/*  51 */     this.zoneid = _zoneid_;
/*  52 */     this.retcode = _retcode_;
/*  53 */     this.repdata = _repdata_;
/*  54 */     this.reserved1 = _reserved1_;
/*  55 */     this.reserved2 = _reserved2_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  59 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  63 */     _os_.marshal(this.direction);
/*  64 */     _os_.marshal(this.xid);
/*  65 */     _os_.marshal(this.proxyid);
/*  66 */     _os_.marshal(this.zoneid);
/*  67 */     _os_.marshal(this.retcode);
/*  68 */     _os_.marshal(this.repdata);
/*  69 */     _os_.marshal(this.reserved1);
/*  70 */     _os_.marshal(this.reserved2);
/*  71 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  75 */     this.direction = _os_.unmarshal_byte();
/*  76 */     this.xid = _os_.unmarshal_int();
/*  77 */     this.proxyid = _os_.unmarshal_int();
/*  78 */     this.zoneid = _os_.unmarshal_int();
/*  79 */     this.retcode = _os_.unmarshal_int();
/*  80 */     this.repdata = _os_.unmarshal_Octets();
/*  81 */     this.reserved1 = _os_.unmarshal_int();
/*  82 */     this.reserved2 = _os_.unmarshal_int();
/*  83 */     if (!_validator_()) {
/*  84 */       throw new VerifyError("validator failed");
/*     */     }
/*  86 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  90 */     if (_o1_ == this) return true;
/*  91 */     if ((_o1_ instanceof DataBetweenIDIPAndGameRep)) {
/*  92 */       DataBetweenIDIPAndGameRep _o_ = (DataBetweenIDIPAndGameRep)_o1_;
/*  93 */       if (this.direction != _o_.direction) return false;
/*  94 */       if (this.xid != _o_.xid) return false;
/*  95 */       if (this.proxyid != _o_.proxyid) return false;
/*  96 */       if (this.zoneid != _o_.zoneid) return false;
/*  97 */       if (this.retcode != _o_.retcode) return false;
/*  98 */       if (!this.repdata.equals(_o_.repdata)) return false;
/*  99 */       if (this.reserved1 != _o_.reserved1) return false;
/* 100 */       if (this.reserved2 != _o_.reserved2) return false;
/* 101 */       return true;
/*     */     }
/* 103 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 107 */     int _h_ = 0;
/* 108 */     _h_ += this.direction;
/* 109 */     _h_ += this.xid;
/* 110 */     _h_ += this.proxyid;
/* 111 */     _h_ += this.zoneid;
/* 112 */     _h_ += this.retcode;
/* 113 */     _h_ += this.repdata.hashCode();
/* 114 */     _h_ += this.reserved1;
/* 115 */     _h_ += this.reserved2;
/* 116 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 120 */     StringBuilder _sb_ = new StringBuilder();
/* 121 */     _sb_.append("(");
/* 122 */     _sb_.append(this.direction).append(",");
/* 123 */     _sb_.append(this.xid).append(",");
/* 124 */     _sb_.append(this.proxyid).append(",");
/* 125 */     _sb_.append(this.zoneid).append(",");
/* 126 */     _sb_.append(this.retcode).append(",");
/* 127 */     _sb_.append("B").append(this.repdata.size()).append(",");
/* 128 */     _sb_.append(this.reserved1).append(",");
/* 129 */     _sb_.append(this.reserved2).append(",");
/* 130 */     _sb_.append(")");
/* 131 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\DataBetweenIDIPAndGameRep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */