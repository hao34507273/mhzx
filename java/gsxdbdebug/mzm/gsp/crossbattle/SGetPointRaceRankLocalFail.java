/*     */ package mzm.gsp.crossbattle;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ public class SGetPointRaceRankLocalFail
/*     */   extends __SGetPointRaceRankLocalFail__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12617065;
/*     */   public static final int ERROR_ZONE_NUM = -1;
/*     */   public static final int ERROR_TIME_POINT = -2;
/*     */   public static final int ERROR_NOT_START = -3;
/*     */   public static final int ERROR_NOT_END = -4;
/*     */   public static final int ERROR_SYSTEM = -5;
/*     */   public int retcode;
/*     */   public int time_point_cfgid;
/*     */   public int activity_cfgid;
/*     */   public int zone;
/*     */   public int from;
/*     */   public int to;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12617065;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SGetPointRaceRankLocalFail() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SGetPointRaceRankLocalFail(int _retcode_, int _time_point_cfgid_, int _activity_cfgid_, int _zone_, int _from_, int _to_)
/*     */   {
/*  47 */     this.retcode = _retcode_;
/*  48 */     this.time_point_cfgid = _time_point_cfgid_;
/*  49 */     this.activity_cfgid = _activity_cfgid_;
/*  50 */     this.zone = _zone_;
/*  51 */     this.from = _from_;
/*  52 */     this.to = _to_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  56 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  60 */     _os_.marshal(this.retcode);
/*  61 */     _os_.marshal(this.time_point_cfgid);
/*  62 */     _os_.marshal(this.activity_cfgid);
/*  63 */     _os_.marshal(this.zone);
/*  64 */     _os_.marshal(this.from);
/*  65 */     _os_.marshal(this.to);
/*  66 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  70 */     this.retcode = _os_.unmarshal_int();
/*  71 */     this.time_point_cfgid = _os_.unmarshal_int();
/*  72 */     this.activity_cfgid = _os_.unmarshal_int();
/*  73 */     this.zone = _os_.unmarshal_int();
/*  74 */     this.from = _os_.unmarshal_int();
/*  75 */     this.to = _os_.unmarshal_int();
/*  76 */     if (!_validator_()) {
/*  77 */       throw new VerifyError("validator failed");
/*     */     }
/*  79 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  83 */     if (_o1_ == this) return true;
/*  84 */     if ((_o1_ instanceof SGetPointRaceRankLocalFail)) {
/*  85 */       SGetPointRaceRankLocalFail _o_ = (SGetPointRaceRankLocalFail)_o1_;
/*  86 */       if (this.retcode != _o_.retcode) return false;
/*  87 */       if (this.time_point_cfgid != _o_.time_point_cfgid) return false;
/*  88 */       if (this.activity_cfgid != _o_.activity_cfgid) return false;
/*  89 */       if (this.zone != _o_.zone) return false;
/*  90 */       if (this.from != _o_.from) return false;
/*  91 */       if (this.to != _o_.to) return false;
/*  92 */       return true;
/*     */     }
/*  94 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  98 */     int _h_ = 0;
/*  99 */     _h_ += this.retcode;
/* 100 */     _h_ += this.time_point_cfgid;
/* 101 */     _h_ += this.activity_cfgid;
/* 102 */     _h_ += this.zone;
/* 103 */     _h_ += this.from;
/* 104 */     _h_ += this.to;
/* 105 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 109 */     StringBuilder _sb_ = new StringBuilder();
/* 110 */     _sb_.append("(");
/* 111 */     _sb_.append(this.retcode).append(",");
/* 112 */     _sb_.append(this.time_point_cfgid).append(",");
/* 113 */     _sb_.append(this.activity_cfgid).append(",");
/* 114 */     _sb_.append(this.zone).append(",");
/* 115 */     _sb_.append(this.from).append(",");
/* 116 */     _sb_.append(this.to).append(",");
/* 117 */     _sb_.append(")");
/* 118 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SGetPointRaceRankLocalFail _o_) {
/* 122 */     if (_o_ == this) return 0;
/* 123 */     int _c_ = 0;
/* 124 */     _c_ = this.retcode - _o_.retcode;
/* 125 */     if (0 != _c_) return _c_;
/* 126 */     _c_ = this.time_point_cfgid - _o_.time_point_cfgid;
/* 127 */     if (0 != _c_) return _c_;
/* 128 */     _c_ = this.activity_cfgid - _o_.activity_cfgid;
/* 129 */     if (0 != _c_) return _c_;
/* 130 */     _c_ = this.zone - _o_.zone;
/* 131 */     if (0 != _c_) return _c_;
/* 132 */     _c_ = this.from - _o_.from;
/* 133 */     if (0 != _c_) return _c_;
/* 134 */     _c_ = this.to - _o_.to;
/* 135 */     if (0 != _c_) return _c_;
/* 136 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\SGetPointRaceRankLocalFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */