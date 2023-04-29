/*     */ package mzm.gsp.activitypointexchange;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SPointExchangeRsp
/*     */   extends __SPointExchangeRsp__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12624904;
/*     */   public int activityid;
/*     */   public int activitypointexchangemallcfgid;
/*     */   public long pointcount;
/*     */   public int goodscfgid;
/*     */   public int count;
/*     */   public int available;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  25 */     return 12624904;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SPointExchangeRsp() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SPointExchangeRsp(int _activityid_, int _activitypointexchangemallcfgid_, long _pointcount_, int _goodscfgid_, int _count_, int _available_)
/*     */   {
/*  39 */     this.activityid = _activityid_;
/*  40 */     this.activitypointexchangemallcfgid = _activitypointexchangemallcfgid_;
/*  41 */     this.pointcount = _pointcount_;
/*  42 */     this.goodscfgid = _goodscfgid_;
/*  43 */     this.count = _count_;
/*  44 */     this.available = _available_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.activityid);
/*  53 */     _os_.marshal(this.activitypointexchangemallcfgid);
/*  54 */     _os_.marshal(this.pointcount);
/*  55 */     _os_.marshal(this.goodscfgid);
/*  56 */     _os_.marshal(this.count);
/*  57 */     _os_.marshal(this.available);
/*  58 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  62 */     this.activityid = _os_.unmarshal_int();
/*  63 */     this.activitypointexchangemallcfgid = _os_.unmarshal_int();
/*  64 */     this.pointcount = _os_.unmarshal_long();
/*  65 */     this.goodscfgid = _os_.unmarshal_int();
/*  66 */     this.count = _os_.unmarshal_int();
/*  67 */     this.available = _os_.unmarshal_int();
/*  68 */     if (!_validator_()) {
/*  69 */       throw new VerifyError("validator failed");
/*     */     }
/*  71 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  75 */     if (_o1_ == this) return true;
/*  76 */     if ((_o1_ instanceof SPointExchangeRsp)) {
/*  77 */       SPointExchangeRsp _o_ = (SPointExchangeRsp)_o1_;
/*  78 */       if (this.activityid != _o_.activityid) return false;
/*  79 */       if (this.activitypointexchangemallcfgid != _o_.activitypointexchangemallcfgid) return false;
/*  80 */       if (this.pointcount != _o_.pointcount) return false;
/*  81 */       if (this.goodscfgid != _o_.goodscfgid) return false;
/*  82 */       if (this.count != _o_.count) return false;
/*  83 */       if (this.available != _o_.available) return false;
/*  84 */       return true;
/*     */     }
/*  86 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  90 */     int _h_ = 0;
/*  91 */     _h_ += this.activityid;
/*  92 */     _h_ += this.activitypointexchangemallcfgid;
/*  93 */     _h_ += (int)this.pointcount;
/*  94 */     _h_ += this.goodscfgid;
/*  95 */     _h_ += this.count;
/*  96 */     _h_ += this.available;
/*  97 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 101 */     StringBuilder _sb_ = new StringBuilder();
/* 102 */     _sb_.append("(");
/* 103 */     _sb_.append(this.activityid).append(",");
/* 104 */     _sb_.append(this.activitypointexchangemallcfgid).append(",");
/* 105 */     _sb_.append(this.pointcount).append(",");
/* 106 */     _sb_.append(this.goodscfgid).append(",");
/* 107 */     _sb_.append(this.count).append(",");
/* 108 */     _sb_.append(this.available).append(",");
/* 109 */     _sb_.append(")");
/* 110 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SPointExchangeRsp _o_) {
/* 114 */     if (_o_ == this) return 0;
/* 115 */     int _c_ = 0;
/* 116 */     _c_ = this.activityid - _o_.activityid;
/* 117 */     if (0 != _c_) return _c_;
/* 118 */     _c_ = this.activitypointexchangemallcfgid - _o_.activitypointexchangemallcfgid;
/* 119 */     if (0 != _c_) return _c_;
/* 120 */     _c_ = Long.signum(this.pointcount - _o_.pointcount);
/* 121 */     if (0 != _c_) return _c_;
/* 122 */     _c_ = this.goodscfgid - _o_.goodscfgid;
/* 123 */     if (0 != _c_) return _c_;
/* 124 */     _c_ = this.count - _o_.count;
/* 125 */     if (0 != _c_) return _c_;
/* 126 */     _c_ = this.available - _o_.available;
/* 127 */     if (0 != _c_) return _c_;
/* 128 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activitypointexchange\SPointExchangeRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */