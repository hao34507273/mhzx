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
/*     */ 
/*     */ public class SPointExchangeRsp
/*     */   extends __SPointExchangeRsp__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12622851;
/*     */   public long pointcount;
/*     */   public int pointexchangecfgid;
/*     */   public int count;
/*     */   public int available;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  25 */     return 12622851;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SPointExchangeRsp() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SPointExchangeRsp(long _pointcount_, int _pointexchangecfgid_, int _count_, int _available_)
/*     */   {
/*  37 */     this.pointcount = _pointcount_;
/*  38 */     this.pointexchangecfgid = _pointexchangecfgid_;
/*  39 */     this.count = _count_;
/*  40 */     this.available = _available_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.pointcount);
/*  49 */     _os_.marshal(this.pointexchangecfgid);
/*  50 */     _os_.marshal(this.count);
/*  51 */     _os_.marshal(this.available);
/*  52 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  56 */     this.pointcount = _os_.unmarshal_long();
/*  57 */     this.pointexchangecfgid = _os_.unmarshal_int();
/*  58 */     this.count = _os_.unmarshal_int();
/*  59 */     this.available = _os_.unmarshal_int();
/*  60 */     if (!_validator_()) {
/*  61 */       throw new VerifyError("validator failed");
/*     */     }
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  67 */     if (_o1_ == this) return true;
/*  68 */     if ((_o1_ instanceof SPointExchangeRsp)) {
/*  69 */       SPointExchangeRsp _o_ = (SPointExchangeRsp)_o1_;
/*  70 */       if (this.pointcount != _o_.pointcount) return false;
/*  71 */       if (this.pointexchangecfgid != _o_.pointexchangecfgid) return false;
/*  72 */       if (this.count != _o_.count) return false;
/*  73 */       if (this.available != _o_.available) return false;
/*  74 */       return true;
/*     */     }
/*  76 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  80 */     int _h_ = 0;
/*  81 */     _h_ += (int)this.pointcount;
/*  82 */     _h_ += this.pointexchangecfgid;
/*  83 */     _h_ += this.count;
/*  84 */     _h_ += this.available;
/*  85 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  89 */     StringBuilder _sb_ = new StringBuilder();
/*  90 */     _sb_.append("(");
/*  91 */     _sb_.append(this.pointcount).append(",");
/*  92 */     _sb_.append(this.pointexchangecfgid).append(",");
/*  93 */     _sb_.append(this.count).append(",");
/*  94 */     _sb_.append(this.available).append(",");
/*  95 */     _sb_.append(")");
/*  96 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SPointExchangeRsp _o_) {
/* 100 */     if (_o_ == this) return 0;
/* 101 */     int _c_ = 0;
/* 102 */     _c_ = Long.signum(this.pointcount - _o_.pointcount);
/* 103 */     if (0 != _c_) return _c_;
/* 104 */     _c_ = this.pointexchangecfgid - _o_.pointexchangecfgid;
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = this.count - _o_.count;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = this.available - _o_.available;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\xiaohuikuaipao\SPointExchangeRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */