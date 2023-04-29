/*     */ package mzm.gsp.menpaipvp;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SSyncScore
/*     */   extends __SSyncScore__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12596225;
/*     */   public int score;
/*     */   public int win_times;
/*     */   public int lose_times;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12596225;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SSyncScore() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SSyncScore(int _score_, int _win_times_, int _lose_times_)
/*     */   {
/*  38 */     this.score = _score_;
/*  39 */     this.win_times = _win_times_;
/*  40 */     this.lose_times = _lose_times_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.score);
/*  49 */     _os_.marshal(this.win_times);
/*  50 */     _os_.marshal(this.lose_times);
/*  51 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  55 */     this.score = _os_.unmarshal_int();
/*  56 */     this.win_times = _os_.unmarshal_int();
/*  57 */     this.lose_times = _os_.unmarshal_int();
/*  58 */     if (!_validator_()) {
/*  59 */       throw new VerifyError("validator failed");
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  65 */     if (_o1_ == this) return true;
/*  66 */     if ((_o1_ instanceof SSyncScore)) {
/*  67 */       SSyncScore _o_ = (SSyncScore)_o1_;
/*  68 */       if (this.score != _o_.score) return false;
/*  69 */       if (this.win_times != _o_.win_times) return false;
/*  70 */       if (this.lose_times != _o_.lose_times) return false;
/*  71 */       return true;
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  77 */     int _h_ = 0;
/*  78 */     _h_ += this.score;
/*  79 */     _h_ += this.win_times;
/*  80 */     _h_ += this.lose_times;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.score).append(",");
/*  88 */     _sb_.append(this.win_times).append(",");
/*  89 */     _sb_.append(this.lose_times).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SSyncScore _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = this.score - _o_.score;
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = this.win_times - _o_.win_times;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = this.lose_times - _o_.lose_times;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaipvp\SSyncScore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */