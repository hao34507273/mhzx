/*     */ package mzm.gsp.xiaohuikuaipao;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SPointExchangeError
/*     */   extends __SPointExchangeError__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12622863;
/*     */   public static final int POINT_NOT_ENOUGH = 1;
/*     */   public static final int EXCHANGE_COUNT_MAX = 2;
/*     */   public int errorcode;
/*     */   public int pointexchangecfgid;
/*     */   public int count;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  25 */     return 12622863;
/*     */   }
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
/*     */   public SPointExchangeError(int _errorcode_, int _pointexchangecfgid_, int _count_)
/*     */   {
/*  39 */     this.errorcode = _errorcode_;
/*  40 */     this.pointexchangecfgid = _pointexchangecfgid_;
/*  41 */     this.count = _count_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  45 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  49 */     _os_.marshal(this.errorcode);
/*  50 */     _os_.marshal(this.pointexchangecfgid);
/*  51 */     _os_.marshal(this.count);
/*  52 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  56 */     this.errorcode = _os_.unmarshal_int();
/*  57 */     this.pointexchangecfgid = _os_.unmarshal_int();
/*  58 */     this.count = _os_.unmarshal_int();
/*  59 */     if (!_validator_()) {
/*  60 */       throw new VerifyError("validator failed");
/*     */     }
/*  62 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  66 */     if (_o1_ == this) return true;
/*  67 */     if ((_o1_ instanceof SPointExchangeError)) {
/*  68 */       SPointExchangeError _o_ = (SPointExchangeError)_o1_;
/*  69 */       if (this.errorcode != _o_.errorcode) return false;
/*  70 */       if (this.pointexchangecfgid != _o_.pointexchangecfgid) return false;
/*  71 */       if (this.count != _o_.count) return false;
/*  72 */       return true;
/*     */     }
/*  74 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  78 */     int _h_ = 0;
/*  79 */     _h_ += this.errorcode;
/*  80 */     _h_ += this.pointexchangecfgid;
/*  81 */     _h_ += this.count;
/*  82 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  86 */     StringBuilder _sb_ = new StringBuilder();
/*  87 */     _sb_.append("(");
/*  88 */     _sb_.append(this.errorcode).append(",");
/*  89 */     _sb_.append(this.pointexchangecfgid).append(",");
/*  90 */     _sb_.append(this.count).append(",");
/*  91 */     _sb_.append(")");
/*  92 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SPointExchangeError _o_) {
/*  96 */     if (_o_ == this) return 0;
/*  97 */     int _c_ = 0;
/*  98 */     _c_ = this.errorcode - _o_.errorcode;
/*  99 */     if (0 != _c_) return _c_;
/* 100 */     _c_ = this.pointexchangecfgid - _o_.pointexchangecfgid;
/* 101 */     if (0 != _c_) return _c_;
/* 102 */     _c_ = this.count - _o_.count;
/* 103 */     if (0 != _c_) return _c_;
/* 104 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\xiaohuikuaipao\SPointExchangeError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */