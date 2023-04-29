/*     */ package mzm.gsp.item;
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
/*     */ public class SResUseDoublePoint
/*     */   extends __SResUseDoublePoint__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12584728;
/*     */   public int itemid;
/*     */   public int result;
/*     */   public int canusecount;
/*     */   public int daycanusecount;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  25 */     return 12584728;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SResUseDoublePoint() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SResUseDoublePoint(int _itemid_, int _result_, int _canusecount_, int _daycanusecount_)
/*     */   {
/*  37 */     this.itemid = _itemid_;
/*  38 */     this.result = _result_;
/*  39 */     this.canusecount = _canusecount_;
/*  40 */     this.daycanusecount = _daycanusecount_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.itemid);
/*  49 */     _os_.marshal(this.result);
/*  50 */     _os_.marshal(this.canusecount);
/*  51 */     _os_.marshal(this.daycanusecount);
/*  52 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  56 */     this.itemid = _os_.unmarshal_int();
/*  57 */     this.result = _os_.unmarshal_int();
/*  58 */     this.canusecount = _os_.unmarshal_int();
/*  59 */     this.daycanusecount = _os_.unmarshal_int();
/*  60 */     if (!_validator_()) {
/*  61 */       throw new VerifyError("validator failed");
/*     */     }
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  67 */     if (_o1_ == this) return true;
/*  68 */     if ((_o1_ instanceof SResUseDoublePoint)) {
/*  69 */       SResUseDoublePoint _o_ = (SResUseDoublePoint)_o1_;
/*  70 */       if (this.itemid != _o_.itemid) return false;
/*  71 */       if (this.result != _o_.result) return false;
/*  72 */       if (this.canusecount != _o_.canusecount) return false;
/*  73 */       if (this.daycanusecount != _o_.daycanusecount) return false;
/*  74 */       return true;
/*     */     }
/*  76 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  80 */     int _h_ = 0;
/*  81 */     _h_ += this.itemid;
/*  82 */     _h_ += this.result;
/*  83 */     _h_ += this.canusecount;
/*  84 */     _h_ += this.daycanusecount;
/*  85 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  89 */     StringBuilder _sb_ = new StringBuilder();
/*  90 */     _sb_.append("(");
/*  91 */     _sb_.append(this.itemid).append(",");
/*  92 */     _sb_.append(this.result).append(",");
/*  93 */     _sb_.append(this.canusecount).append(",");
/*  94 */     _sb_.append(this.daycanusecount).append(",");
/*  95 */     _sb_.append(")");
/*  96 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SResUseDoublePoint _o_) {
/* 100 */     if (_o_ == this) return 0;
/* 101 */     int _c_ = 0;
/* 102 */     _c_ = this.itemid - _o_.itemid;
/* 103 */     if (0 != _c_) return _c_;
/* 104 */     _c_ = this.result - _o_.result;
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = this.canusecount - _o_.canusecount;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = this.daycanusecount - _o_.daycanusecount;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\SResUseDoublePoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */