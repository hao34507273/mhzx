/*     */ package mzm.gsp.question;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.question.main.PAnswerXiangShiQuestionReq;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CAnswerXiangShiQuestionReq
/*     */   extends __CAnswerXiangShiQuestionReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12594714;
/*     */   public int questionid;
/*     */   public int answeridx;
/*     */   public long sessionid;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     new PAnswerXiangShiQuestionReq(this);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  27 */     return 12594714;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CAnswerXiangShiQuestionReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CAnswerXiangShiQuestionReq(int _questionid_, int _answeridx_, long _sessionid_)
/*     */   {
/*  38 */     this.questionid = _questionid_;
/*  39 */     this.answeridx = _answeridx_;
/*  40 */     this.sessionid = _sessionid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.questionid);
/*  49 */     _os_.marshal(this.answeridx);
/*  50 */     _os_.marshal(this.sessionid);
/*  51 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  55 */     this.questionid = _os_.unmarshal_int();
/*  56 */     this.answeridx = _os_.unmarshal_int();
/*  57 */     this.sessionid = _os_.unmarshal_long();
/*  58 */     if (!_validator_()) {
/*  59 */       throw new VerifyError("validator failed");
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  65 */     if (_o1_ == this) return true;
/*  66 */     if ((_o1_ instanceof CAnswerXiangShiQuestionReq)) {
/*  67 */       CAnswerXiangShiQuestionReq _o_ = (CAnswerXiangShiQuestionReq)_o1_;
/*  68 */       if (this.questionid != _o_.questionid) return false;
/*  69 */       if (this.answeridx != _o_.answeridx) return false;
/*  70 */       if (this.sessionid != _o_.sessionid) return false;
/*  71 */       return true;
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  77 */     int _h_ = 0;
/*  78 */     _h_ += this.questionid;
/*  79 */     _h_ += this.answeridx;
/*  80 */     _h_ += (int)this.sessionid;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.questionid).append(",");
/*  88 */     _sb_.append(this.answeridx).append(",");
/*  89 */     _sb_.append(this.sessionid).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CAnswerXiangShiQuestionReq _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = this.questionid - _o_.questionid;
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = this.answeridx - _o_.answeridx;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = Long.signum(this.sessionid - _o_.sessionid);
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\CAnswerXiangShiQuestionReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */