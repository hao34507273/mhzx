/*     */ package mzm.gsp.activitypointexchange;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ public class SPointExchangeError
/*     */   extends __SPointExchangeError__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12624898;
/*     */   public static final int POINT_NOT_ENOUGH = 1;
/*     */   public static final int EXCHANGE_COUNT_MAX = 2;
/*     */   public static final int GOODS_SOLD_OUT = 3;
/*     */   public static final int ACTIVITY_CLOSED = 4;
/*     */   public static final int MALL_CLOSED = 5;
/*     */   public int errorcode;
/*     */   public int activityid;
/*     */   public int goodscfgid;
/*     */   public int count;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  25 */     return 12624898;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SPointExchangeError() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SPointExchangeError(int _errorcode_, int _activityid_, int _goodscfgid_, int _count_)
/*     */   {
/*  43 */     this.errorcode = _errorcode_;
/*  44 */     this.activityid = _activityid_;
/*  45 */     this.goodscfgid = _goodscfgid_;
/*  46 */     this.count = _count_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  50 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  54 */     _os_.marshal(this.errorcode);
/*  55 */     _os_.marshal(this.activityid);
/*  56 */     _os_.marshal(this.goodscfgid);
/*  57 */     _os_.marshal(this.count);
/*  58 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  62 */     this.errorcode = _os_.unmarshal_int();
/*  63 */     this.activityid = _os_.unmarshal_int();
/*  64 */     this.goodscfgid = _os_.unmarshal_int();
/*  65 */     this.count = _os_.unmarshal_int();
/*  66 */     if (!_validator_()) {
/*  67 */       throw new VerifyError("validator failed");
/*     */     }
/*  69 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  73 */     if (_o1_ == this) return true;
/*  74 */     if ((_o1_ instanceof SPointExchangeError)) {
/*  75 */       SPointExchangeError _o_ = (SPointExchangeError)_o1_;
/*  76 */       if (this.errorcode != _o_.errorcode) return false;
/*  77 */       if (this.activityid != _o_.activityid) return false;
/*  78 */       if (this.goodscfgid != _o_.goodscfgid) return false;
/*  79 */       if (this.count != _o_.count) return false;
/*  80 */       return true;
/*     */     }
/*  82 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  86 */     int _h_ = 0;
/*  87 */     _h_ += this.errorcode;
/*  88 */     _h_ += this.activityid;
/*  89 */     _h_ += this.goodscfgid;
/*  90 */     _h_ += this.count;
/*  91 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  95 */     StringBuilder _sb_ = new StringBuilder();
/*  96 */     _sb_.append("(");
/*  97 */     _sb_.append(this.errorcode).append(",");
/*  98 */     _sb_.append(this.activityid).append(",");
/*  99 */     _sb_.append(this.goodscfgid).append(",");
/* 100 */     _sb_.append(this.count).append(",");
/* 101 */     _sb_.append(")");
/* 102 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SPointExchangeError _o_) {
/* 106 */     if (_o_ == this) return 0;
/* 107 */     int _c_ = 0;
/* 108 */     _c_ = this.errorcode - _o_.errorcode;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     _c_ = this.activityid - _o_.activityid;
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     _c_ = this.goodscfgid - _o_.goodscfgid;
/* 113 */     if (0 != _c_) return _c_;
/* 114 */     _c_ = this.count - _o_.count;
/* 115 */     if (0 != _c_) return _c_;
/* 116 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activitypointexchange\SPointExchangeError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */