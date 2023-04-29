/*     */ package gnet;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class VIPAnnounce extends __VIPAnnounce__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 8045;
/*     */   public com.goldhuman.Common.Octets userid;
/*     */   public int aid;
/*     */   public int zoneid;
/*     */   public int currenttime;
/*     */   public int starttime;
/*     */   public int endtime;
/*     */   public int status;
/*     */   public int viplevel;
/*     */   public int totalcash;
/*     */   public int recenttotalcash;
/*     */   public int infolack;
/*     */   public int reserved;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  25 */     return 8045;
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
/*     */ 
/*     */ 
/*     */   public VIPAnnounce()
/*     */   {
/*  42 */     this.userid = new com.goldhuman.Common.Octets();
/*     */   }
/*     */   
/*     */   public VIPAnnounce(com.goldhuman.Common.Octets _userid_, int _aid_, int _zoneid_, int _currenttime_, int _starttime_, int _endtime_, int _status_, int _viplevel_, int _totalcash_, int _recenttotalcash_, int _infolack_, int _reserved_) {
/*  46 */     this.userid = _userid_;
/*  47 */     this.aid = _aid_;
/*  48 */     this.zoneid = _zoneid_;
/*  49 */     this.currenttime = _currenttime_;
/*  50 */     this.starttime = _starttime_;
/*  51 */     this.endtime = _endtime_;
/*  52 */     this.status = _status_;
/*  53 */     this.viplevel = _viplevel_;
/*  54 */     this.totalcash = _totalcash_;
/*  55 */     this.recenttotalcash = _recenttotalcash_;
/*  56 */     this.infolack = _infolack_;
/*  57 */     this.reserved = _reserved_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  61 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  65 */     _os_.marshal(this.userid);
/*  66 */     _os_.marshal(this.aid);
/*  67 */     _os_.marshal(this.zoneid);
/*  68 */     _os_.marshal(this.currenttime);
/*  69 */     _os_.marshal(this.starttime);
/*  70 */     _os_.marshal(this.endtime);
/*  71 */     _os_.marshal(this.status);
/*  72 */     _os_.marshal(this.viplevel);
/*  73 */     _os_.marshal(this.totalcash);
/*  74 */     _os_.marshal(this.recenttotalcash);
/*  75 */     _os_.marshal(this.infolack);
/*  76 */     _os_.marshal(this.reserved);
/*  77 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  81 */     this.userid = _os_.unmarshal_Octets();
/*  82 */     this.aid = _os_.unmarshal_int();
/*  83 */     this.zoneid = _os_.unmarshal_int();
/*  84 */     this.currenttime = _os_.unmarshal_int();
/*  85 */     this.starttime = _os_.unmarshal_int();
/*  86 */     this.endtime = _os_.unmarshal_int();
/*  87 */     this.status = _os_.unmarshal_int();
/*  88 */     this.viplevel = _os_.unmarshal_int();
/*  89 */     this.totalcash = _os_.unmarshal_int();
/*  90 */     this.recenttotalcash = _os_.unmarshal_int();
/*  91 */     this.infolack = _os_.unmarshal_int();
/*  92 */     this.reserved = _os_.unmarshal_int();
/*  93 */     if (!_validator_()) {
/*  94 */       throw new VerifyError("validator failed");
/*     */     }
/*  96 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/* 100 */     if (_o1_ == this) return true;
/* 101 */     if ((_o1_ instanceof VIPAnnounce)) {
/* 102 */       VIPAnnounce _o_ = (VIPAnnounce)_o1_;
/* 103 */       if (!this.userid.equals(_o_.userid)) return false;
/* 104 */       if (this.aid != _o_.aid) return false;
/* 105 */       if (this.zoneid != _o_.zoneid) return false;
/* 106 */       if (this.currenttime != _o_.currenttime) return false;
/* 107 */       if (this.starttime != _o_.starttime) return false;
/* 108 */       if (this.endtime != _o_.endtime) return false;
/* 109 */       if (this.status != _o_.status) return false;
/* 110 */       if (this.viplevel != _o_.viplevel) return false;
/* 111 */       if (this.totalcash != _o_.totalcash) return false;
/* 112 */       if (this.recenttotalcash != _o_.recenttotalcash) return false;
/* 113 */       if (this.infolack != _o_.infolack) return false;
/* 114 */       if (this.reserved != _o_.reserved) return false;
/* 115 */       return true;
/*     */     }
/* 117 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 121 */     int _h_ = 0;
/* 122 */     _h_ += this.userid.hashCode();
/* 123 */     _h_ += this.aid;
/* 124 */     _h_ += this.zoneid;
/* 125 */     _h_ += this.currenttime;
/* 126 */     _h_ += this.starttime;
/* 127 */     _h_ += this.endtime;
/* 128 */     _h_ += this.status;
/* 129 */     _h_ += this.viplevel;
/* 130 */     _h_ += this.totalcash;
/* 131 */     _h_ += this.recenttotalcash;
/* 132 */     _h_ += this.infolack;
/* 133 */     _h_ += this.reserved;
/* 134 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 138 */     StringBuilder _sb_ = new StringBuilder();
/* 139 */     _sb_.append("(");
/* 140 */     _sb_.append("B").append(this.userid.size()).append(",");
/* 141 */     _sb_.append(this.aid).append(",");
/* 142 */     _sb_.append(this.zoneid).append(",");
/* 143 */     _sb_.append(this.currenttime).append(",");
/* 144 */     _sb_.append(this.starttime).append(",");
/* 145 */     _sb_.append(this.endtime).append(",");
/* 146 */     _sb_.append(this.status).append(",");
/* 147 */     _sb_.append(this.viplevel).append(",");
/* 148 */     _sb_.append(this.totalcash).append(",");
/* 149 */     _sb_.append(this.recenttotalcash).append(",");
/* 150 */     _sb_.append(this.infolack).append(",");
/* 151 */     _sb_.append(this.reserved).append(",");
/* 152 */     _sb_.append(")");
/* 153 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\gnet\VIPAnnounce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */