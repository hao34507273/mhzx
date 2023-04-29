/*     */ package mzm.gsp.questionvoice;
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
/*     */ public class SAnswerQuestionVoiceSuccessRes
/*     */   extends __SAnswerQuestionVoiceSuccessRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12620806;
/*     */   public int activity_id;
/*     */   public int question_id;
/*     */   public int answer_result;
/*     */   public int right_index;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12620806;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SAnswerQuestionVoiceSuccessRes() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SAnswerQuestionVoiceSuccessRes(int _activity_id_, int _question_id_, int _answer_result_, int _right_index_)
/*     */   {
/*  39 */     this.activity_id = _activity_id_;
/*  40 */     this.question_id = _question_id_;
/*  41 */     this.answer_result = _answer_result_;
/*  42 */     this.right_index = _right_index_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  50 */     _os_.marshal(this.activity_id);
/*  51 */     _os_.marshal(this.question_id);
/*  52 */     _os_.marshal(this.answer_result);
/*  53 */     _os_.marshal(this.right_index);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.activity_id = _os_.unmarshal_int();
/*  59 */     this.question_id = _os_.unmarshal_int();
/*  60 */     this.answer_result = _os_.unmarshal_int();
/*  61 */     this.right_index = _os_.unmarshal_int();
/*  62 */     if (!_validator_()) {
/*  63 */       throw new VerifyError("validator failed");
/*     */     }
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  69 */     if (_o1_ == this) return true;
/*  70 */     if ((_o1_ instanceof SAnswerQuestionVoiceSuccessRes)) {
/*  71 */       SAnswerQuestionVoiceSuccessRes _o_ = (SAnswerQuestionVoiceSuccessRes)_o1_;
/*  72 */       if (this.activity_id != _o_.activity_id) return false;
/*  73 */       if (this.question_id != _o_.question_id) return false;
/*  74 */       if (this.answer_result != _o_.answer_result) return false;
/*  75 */       if (this.right_index != _o_.right_index) return false;
/*  76 */       return true;
/*     */     }
/*  78 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  82 */     int _h_ = 0;
/*  83 */     _h_ += this.activity_id;
/*  84 */     _h_ += this.question_id;
/*  85 */     _h_ += this.answer_result;
/*  86 */     _h_ += this.right_index;
/*  87 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  91 */     StringBuilder _sb_ = new StringBuilder();
/*  92 */     _sb_.append("(");
/*  93 */     _sb_.append(this.activity_id).append(",");
/*  94 */     _sb_.append(this.question_id).append(",");
/*  95 */     _sb_.append(this.answer_result).append(",");
/*  96 */     _sb_.append(this.right_index).append(",");
/*  97 */     _sb_.append(")");
/*  98 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SAnswerQuestionVoiceSuccessRes _o_) {
/* 102 */     if (_o_ == this) return 0;
/* 103 */     int _c_ = 0;
/* 104 */     _c_ = this.activity_id - _o_.activity_id;
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = this.question_id - _o_.question_id;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = this.answer_result - _o_.answer_result;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     _c_ = this.right_index - _o_.right_index;
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\questionvoice\SAnswerQuestionVoiceSuccessRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */