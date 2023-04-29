/*     */ package mzm.gsp.luckybag;
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
/*     */ public class SExchangeScoreSuccess
/*     */   extends __SExchangeScoreSuccess__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12607495;
/*     */   public int score;
/*     */   public int lucky_bag_score_cfgid;
/*     */   public int num;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12607495;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SExchangeScoreSuccess() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SExchangeScoreSuccess(int _score_, int _lucky_bag_score_cfgid_, int _num_)
/*     */   {
/*  38 */     this.score = _score_;
/*  39 */     this.lucky_bag_score_cfgid = _lucky_bag_score_cfgid_;
/*  40 */     this.num = _num_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.score);
/*  49 */     _os_.marshal(this.lucky_bag_score_cfgid);
/*  50 */     _os_.marshal(this.num);
/*  51 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  55 */     this.score = _os_.unmarshal_int();
/*  56 */     this.lucky_bag_score_cfgid = _os_.unmarshal_int();
/*  57 */     this.num = _os_.unmarshal_int();
/*  58 */     if (!_validator_()) {
/*  59 */       throw new VerifyError("validator failed");
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  65 */     if (_o1_ == this) return true;
/*  66 */     if ((_o1_ instanceof SExchangeScoreSuccess)) {
/*  67 */       SExchangeScoreSuccess _o_ = (SExchangeScoreSuccess)_o1_;
/*  68 */       if (this.score != _o_.score) return false;
/*  69 */       if (this.lucky_bag_score_cfgid != _o_.lucky_bag_score_cfgid) return false;
/*  70 */       if (this.num != _o_.num) return false;
/*  71 */       return true;
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  77 */     int _h_ = 0;
/*  78 */     _h_ += this.score;
/*  79 */     _h_ += this.lucky_bag_score_cfgid;
/*  80 */     _h_ += this.num;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.score).append(",");
/*  88 */     _sb_.append(this.lucky_bag_score_cfgid).append(",");
/*  89 */     _sb_.append(this.num).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SExchangeScoreSuccess _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = this.score - _o_.score;
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = this.lucky_bag_score_cfgid - _o_.lucky_bag_score_cfgid;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = this.num - _o_.num;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\luckybag\SExchangeScoreSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */