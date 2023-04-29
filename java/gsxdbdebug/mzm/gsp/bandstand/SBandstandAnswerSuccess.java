/*     */ package mzm.gsp.bandstand;
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
/*     */ public class SBandstandAnswerSuccess
/*     */   extends __SBandstandAnswerSuccess__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12627972;
/*     */   public byte result;
/*     */   public int answer_index;
/*     */   public byte get_reward;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12627972;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SBandstandAnswerSuccess() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SBandstandAnswerSuccess(byte _result_, int _answer_index_, byte _get_reward_)
/*     */   {
/*  38 */     this.result = _result_;
/*  39 */     this.answer_index = _answer_index_;
/*  40 */     this.get_reward = _get_reward_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.result);
/*  49 */     _os_.marshal(this.answer_index);
/*  50 */     _os_.marshal(this.get_reward);
/*  51 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  55 */     this.result = _os_.unmarshal_byte();
/*  56 */     this.answer_index = _os_.unmarshal_int();
/*  57 */     this.get_reward = _os_.unmarshal_byte();
/*  58 */     if (!_validator_()) {
/*  59 */       throw new VerifyError("validator failed");
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  65 */     if (_o1_ == this) return true;
/*  66 */     if ((_o1_ instanceof SBandstandAnswerSuccess)) {
/*  67 */       SBandstandAnswerSuccess _o_ = (SBandstandAnswerSuccess)_o1_;
/*  68 */       if (this.result != _o_.result) return false;
/*  69 */       if (this.answer_index != _o_.answer_index) return false;
/*  70 */       if (this.get_reward != _o_.get_reward) return false;
/*  71 */       return true;
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  77 */     int _h_ = 0;
/*  78 */     _h_ += this.result;
/*  79 */     _h_ += this.answer_index;
/*  80 */     _h_ += this.get_reward;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.result).append(",");
/*  88 */     _sb_.append(this.answer_index).append(",");
/*  89 */     _sb_.append(this.get_reward).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SBandstandAnswerSuccess _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = this.result - _o_.result;
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = this.answer_index - _o_.answer_index;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = this.get_reward - _o_.get_reward;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bandstand\SBandstandAnswerSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */