/*     */ package mzm.gsp.question;
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
/*     */ public class SSyncHelpAnswerPictureQuestion
/*     */   extends __SSyncHelpAnswerPictureQuestion__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12594735;
/*     */   public long answerproviderid;
/*     */   public int questionitemid;
/*     */   public int answer;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12594735;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SSyncHelpAnswerPictureQuestion() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SSyncHelpAnswerPictureQuestion(long _answerproviderid_, int _questionitemid_, int _answer_)
/*     */   {
/*  38 */     this.answerproviderid = _answerproviderid_;
/*  39 */     this.questionitemid = _questionitemid_;
/*  40 */     this.answer = _answer_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.answerproviderid);
/*  49 */     _os_.marshal(this.questionitemid);
/*  50 */     _os_.marshal(this.answer);
/*  51 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  55 */     this.answerproviderid = _os_.unmarshal_long();
/*  56 */     this.questionitemid = _os_.unmarshal_int();
/*  57 */     this.answer = _os_.unmarshal_int();
/*  58 */     if (!_validator_()) {
/*  59 */       throw new VerifyError("validator failed");
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  65 */     if (_o1_ == this) return true;
/*  66 */     if ((_o1_ instanceof SSyncHelpAnswerPictureQuestion)) {
/*  67 */       SSyncHelpAnswerPictureQuestion _o_ = (SSyncHelpAnswerPictureQuestion)_o1_;
/*  68 */       if (this.answerproviderid != _o_.answerproviderid) return false;
/*  69 */       if (this.questionitemid != _o_.questionitemid) return false;
/*  70 */       if (this.answer != _o_.answer) return false;
/*  71 */       return true;
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  77 */     int _h_ = 0;
/*  78 */     _h_ += (int)this.answerproviderid;
/*  79 */     _h_ += this.questionitemid;
/*  80 */     _h_ += this.answer;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.answerproviderid).append(",");
/*  88 */     _sb_.append(this.questionitemid).append(",");
/*  89 */     _sb_.append(this.answer).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SSyncHelpAnswerPictureQuestion _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = Long.signum(this.answerproviderid - _o_.answerproviderid);
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = this.questionitemid - _o_.questionitemid;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = this.answer - _o_.answer;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\SSyncHelpAnswerPictureQuestion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */