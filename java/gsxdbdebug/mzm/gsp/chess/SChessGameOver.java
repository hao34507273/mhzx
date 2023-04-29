/*     */ package mzm.gsp.chess;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SChessGameOver
/*     */   extends __SChessGameOver__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12619021;
/*     */   public static final int WIN = 1;
/*     */   public static final int LOSE = 2;
/*     */   public static final int DRAW = 3;
/*     */   public static final int WIPE_OUT_ALL = 1;
/*     */   public static final int SURRENDER = 2;
/*     */   public static final int TIME_UP_DRAW = 3;
/*     */   public static final int QUANTITY_COMPARE = 4;
/*     */   public static final int NO_OPERATE_LOSE = 5;
/*     */   public int result;
/*     */   public int reason;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12619021;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SChessGameOver() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SChessGameOver(int _result_, int _reason_)
/*     */   {
/*  46 */     this.result = _result_;
/*  47 */     this.reason = _reason_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  51 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  55 */     _os_.marshal(this.result);
/*  56 */     _os_.marshal(this.reason);
/*  57 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  61 */     this.result = _os_.unmarshal_int();
/*  62 */     this.reason = _os_.unmarshal_int();
/*  63 */     if (!_validator_()) {
/*  64 */       throw new VerifyError("validator failed");
/*     */     }
/*  66 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  70 */     if (_o1_ == this) return true;
/*  71 */     if ((_o1_ instanceof SChessGameOver)) {
/*  72 */       SChessGameOver _o_ = (SChessGameOver)_o1_;
/*  73 */       if (this.result != _o_.result) return false;
/*  74 */       if (this.reason != _o_.reason) return false;
/*  75 */       return true;
/*     */     }
/*  77 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  81 */     int _h_ = 0;
/*  82 */     _h_ += this.result;
/*  83 */     _h_ += this.reason;
/*  84 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  88 */     StringBuilder _sb_ = new StringBuilder();
/*  89 */     _sb_.append("(");
/*  90 */     _sb_.append(this.result).append(",");
/*  91 */     _sb_.append(this.reason).append(",");
/*  92 */     _sb_.append(")");
/*  93 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SChessGameOver _o_) {
/*  97 */     if (_o_ == this) return 0;
/*  98 */     int _c_ = 0;
/*  99 */     _c_ = this.result - _o_.result;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = this.reason - _o_.reason;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chess\SChessGameOver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */