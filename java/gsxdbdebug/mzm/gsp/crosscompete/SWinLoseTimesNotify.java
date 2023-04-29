/*     */ package mzm.gsp.crosscompete;
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
/*     */ public class SWinLoseTimesNotify
/*     */   extends __SWinLoseTimesNotify__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12616744;
/*     */   public int win_times;
/*     */   public int lose_times;
/*     */   public int win_streak;
/*     */   public int escape_times;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12616744;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SWinLoseTimesNotify() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SWinLoseTimesNotify(int _win_times_, int _lose_times_, int _win_streak_, int _escape_times_)
/*     */   {
/*  39 */     this.win_times = _win_times_;
/*  40 */     this.lose_times = _lose_times_;
/*  41 */     this.win_streak = _win_streak_;
/*  42 */     this.escape_times = _escape_times_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  50 */     _os_.marshal(this.win_times);
/*  51 */     _os_.marshal(this.lose_times);
/*  52 */     _os_.marshal(this.win_streak);
/*  53 */     _os_.marshal(this.escape_times);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.win_times = _os_.unmarshal_int();
/*  59 */     this.lose_times = _os_.unmarshal_int();
/*  60 */     this.win_streak = _os_.unmarshal_int();
/*  61 */     this.escape_times = _os_.unmarshal_int();
/*  62 */     if (!_validator_()) {
/*  63 */       throw new VerifyError("validator failed");
/*     */     }
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  69 */     if (_o1_ == this) return true;
/*  70 */     if ((_o1_ instanceof SWinLoseTimesNotify)) {
/*  71 */       SWinLoseTimesNotify _o_ = (SWinLoseTimesNotify)_o1_;
/*  72 */       if (this.win_times != _o_.win_times) return false;
/*  73 */       if (this.lose_times != _o_.lose_times) return false;
/*  74 */       if (this.win_streak != _o_.win_streak) return false;
/*  75 */       if (this.escape_times != _o_.escape_times) return false;
/*  76 */       return true;
/*     */     }
/*  78 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  82 */     int _h_ = 0;
/*  83 */     _h_ += this.win_times;
/*  84 */     _h_ += this.lose_times;
/*  85 */     _h_ += this.win_streak;
/*  86 */     _h_ += this.escape_times;
/*  87 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  91 */     StringBuilder _sb_ = new StringBuilder();
/*  92 */     _sb_.append("(");
/*  93 */     _sb_.append(this.win_times).append(",");
/*  94 */     _sb_.append(this.lose_times).append(",");
/*  95 */     _sb_.append(this.win_streak).append(",");
/*  96 */     _sb_.append(this.escape_times).append(",");
/*  97 */     _sb_.append(")");
/*  98 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SWinLoseTimesNotify _o_) {
/* 102 */     if (_o_ == this) return 0;
/* 103 */     int _c_ = 0;
/* 104 */     _c_ = this.win_times - _o_.win_times;
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = this.lose_times - _o_.lose_times;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = this.win_streak - _o_.win_streak;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     _c_ = this.escape_times - _o_.escape_times;
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\SWinLoseTimesNotify.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */