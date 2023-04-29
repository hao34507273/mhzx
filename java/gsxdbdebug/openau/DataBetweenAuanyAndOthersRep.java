/*     */ package openau;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ 
/*     */ public class DataBetweenAuanyAndOthersRep extends __DataBetweenAuanyAndOthersRep__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 8911;
/*     */   public byte direction;
/*     */   public Octets account;
/*     */   public int zoneid;
/*     */   public long roleid;
/*     */   public int reqtype;
/*     */   public Octets reqdata;
/*     */   public int retcode;
/*     */   public Octets repdata;
/*     */   public int reserved1;
/*     */   public Octets reserved2;
/*     */   
/*     */   protected void process() {
/*  20 */     mzm.gsp.qingfu.main.QingfuInterface.onDataBetweenAuanyAndOthersRep(this);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  28 */     return 8911;
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
/*     */   public DataBetweenAuanyAndOthersRep()
/*     */   {
/*  43 */     this.direction = 4;
/*  44 */     this.account = new Octets();
/*  45 */     this.reqdata = new Octets();
/*  46 */     this.repdata = new Octets();
/*  47 */     this.reserved1 = 0;
/*  48 */     this.reserved2 = new Octets();
/*     */   }
/*     */   
/*     */   public DataBetweenAuanyAndOthersRep(byte _direction_, Octets _account_, int _zoneid_, long _roleid_, int _reqtype_, Octets _reqdata_, int _retcode_, Octets _repdata_, int _reserved1_, Octets _reserved2_) {
/*  52 */     this.direction = _direction_;
/*  53 */     this.account = _account_;
/*  54 */     this.zoneid = _zoneid_;
/*  55 */     this.roleid = _roleid_;
/*  56 */     this.reqtype = _reqtype_;
/*  57 */     this.reqdata = _reqdata_;
/*  58 */     this.retcode = _retcode_;
/*  59 */     this.repdata = _repdata_;
/*  60 */     this.reserved1 = _reserved1_;
/*  61 */     this.reserved2 = _reserved2_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  65 */     return true;
/*     */   }
/*     */   
/*     */   public com.goldhuman.Common.Marshal.OctetsStream marshal(com.goldhuman.Common.Marshal.OctetsStream _os_) {
/*  69 */     _os_.marshal(this.direction);
/*  70 */     _os_.marshal(this.account);
/*  71 */     _os_.marshal(this.zoneid);
/*  72 */     _os_.marshal(this.roleid);
/*  73 */     _os_.marshal(this.reqtype);
/*  74 */     _os_.marshal(this.reqdata);
/*  75 */     _os_.marshal(this.retcode);
/*  76 */     _os_.marshal(this.repdata);
/*  77 */     _os_.marshal(this.reserved1);
/*  78 */     _os_.marshal(this.reserved2);
/*  79 */     return _os_;
/*     */   }
/*     */   
/*     */   public com.goldhuman.Common.Marshal.OctetsStream unmarshal(com.goldhuman.Common.Marshal.OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  83 */     this.direction = _os_.unmarshal_byte();
/*  84 */     this.account = _os_.unmarshal_Octets();
/*  85 */     this.zoneid = _os_.unmarshal_int();
/*  86 */     this.roleid = _os_.unmarshal_long();
/*  87 */     this.reqtype = _os_.unmarshal_int();
/*  88 */     this.reqdata = _os_.unmarshal_Octets();
/*  89 */     this.retcode = _os_.unmarshal_int();
/*  90 */     this.repdata = _os_.unmarshal_Octets();
/*  91 */     this.reserved1 = _os_.unmarshal_int();
/*  92 */     this.reserved2 = _os_.unmarshal_Octets();
/*  93 */     if (!_validator_()) {
/*  94 */       throw new VerifyError("validator failed");
/*     */     }
/*  96 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/* 100 */     if (_o1_ == this) return true;
/* 101 */     if ((_o1_ instanceof DataBetweenAuanyAndOthersRep)) {
/* 102 */       DataBetweenAuanyAndOthersRep _o_ = (DataBetweenAuanyAndOthersRep)_o1_;
/* 103 */       if (this.direction != _o_.direction) return false;
/* 104 */       if (!this.account.equals(_o_.account)) return false;
/* 105 */       if (this.zoneid != _o_.zoneid) return false;
/* 106 */       if (this.roleid != _o_.roleid) return false;
/* 107 */       if (this.reqtype != _o_.reqtype) return false;
/* 108 */       if (!this.reqdata.equals(_o_.reqdata)) return false;
/* 109 */       if (this.retcode != _o_.retcode) return false;
/* 110 */       if (!this.repdata.equals(_o_.repdata)) return false;
/* 111 */       if (this.reserved1 != _o_.reserved1) return false;
/* 112 */       if (!this.reserved2.equals(_o_.reserved2)) return false;
/* 113 */       return true;
/*     */     }
/* 115 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 119 */     int _h_ = 0;
/* 120 */     _h_ += this.direction;
/* 121 */     _h_ += this.account.hashCode();
/* 122 */     _h_ += this.zoneid;
/* 123 */     _h_ += (int)this.roleid;
/* 124 */     _h_ += this.reqtype;
/* 125 */     _h_ += this.reqdata.hashCode();
/* 126 */     _h_ += this.retcode;
/* 127 */     _h_ += this.repdata.hashCode();
/* 128 */     _h_ += this.reserved1;
/* 129 */     _h_ += this.reserved2.hashCode();
/* 130 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 134 */     StringBuilder _sb_ = new StringBuilder();
/* 135 */     _sb_.append("(");
/* 136 */     _sb_.append(this.direction).append(",");
/* 137 */     _sb_.append("B").append(this.account.size()).append(",");
/* 138 */     _sb_.append(this.zoneid).append(",");
/* 139 */     _sb_.append(this.roleid).append(",");
/* 140 */     _sb_.append(this.reqtype).append(",");
/* 141 */     _sb_.append("B").append(this.reqdata.size()).append(",");
/* 142 */     _sb_.append(this.retcode).append(",");
/* 143 */     _sb_.append("B").append(this.repdata.size()).append(",");
/* 144 */     _sb_.append(this.reserved1).append(",");
/* 145 */     _sb_.append("B").append(this.reserved2.size()).append(",");
/* 146 */     _sb_.append(")");
/* 147 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\openau\DataBetweenAuanyAndOthersRep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */