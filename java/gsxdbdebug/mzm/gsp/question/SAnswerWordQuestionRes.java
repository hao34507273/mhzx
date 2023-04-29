/*     */ package mzm.gsp.question;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SAnswerWordQuestionRes
/*     */   extends __SAnswerWordQuestionRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12594738;
/*     */   public int isright;
/*     */   public int nextquestionid;
/*     */   public long sessionid;
/*     */   public ArrayList<Integer> answer_sequence;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12594738;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SAnswerWordQuestionRes()
/*     */   {
/*  36 */     this.answer_sequence = new ArrayList();
/*     */   }
/*     */   
/*     */   public SAnswerWordQuestionRes(int _isright_, int _nextquestionid_, long _sessionid_, ArrayList<Integer> _answer_sequence_) {
/*  40 */     this.isright = _isright_;
/*  41 */     this.nextquestionid = _nextquestionid_;
/*  42 */     this.sessionid = _sessionid_;
/*  43 */     this.answer_sequence = _answer_sequence_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  47 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  51 */     _os_.marshal(this.isright);
/*  52 */     _os_.marshal(this.nextquestionid);
/*  53 */     _os_.marshal(this.sessionid);
/*  54 */     _os_.compact_uint32(this.answer_sequence.size());
/*  55 */     for (Integer _v_ : this.answer_sequence) {
/*  56 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  58 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  62 */     this.isright = _os_.unmarshal_int();
/*  63 */     this.nextquestionid = _os_.unmarshal_int();
/*  64 */     this.sessionid = _os_.unmarshal_long();
/*  65 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  67 */       int _v_ = _os_.unmarshal_int();
/*  68 */       this.answer_sequence.add(Integer.valueOf(_v_));
/*     */     }
/*  70 */     if (!_validator_()) {
/*  71 */       throw new VerifyError("validator failed");
/*     */     }
/*  73 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  77 */     if (_o1_ == this) return true;
/*  78 */     if ((_o1_ instanceof SAnswerWordQuestionRes)) {
/*  79 */       SAnswerWordQuestionRes _o_ = (SAnswerWordQuestionRes)_o1_;
/*  80 */       if (this.isright != _o_.isright) return false;
/*  81 */       if (this.nextquestionid != _o_.nextquestionid) return false;
/*  82 */       if (this.sessionid != _o_.sessionid) return false;
/*  83 */       if (!this.answer_sequence.equals(_o_.answer_sequence)) return false;
/*  84 */       return true;
/*     */     }
/*  86 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  90 */     int _h_ = 0;
/*  91 */     _h_ += this.isright;
/*  92 */     _h_ += this.nextquestionid;
/*  93 */     _h_ += (int)this.sessionid;
/*  94 */     _h_ += this.answer_sequence.hashCode();
/*  95 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  99 */     StringBuilder _sb_ = new StringBuilder();
/* 100 */     _sb_.append("(");
/* 101 */     _sb_.append(this.isright).append(",");
/* 102 */     _sb_.append(this.nextquestionid).append(",");
/* 103 */     _sb_.append(this.sessionid).append(",");
/* 104 */     _sb_.append(this.answer_sequence).append(",");
/* 105 */     _sb_.append(")");
/* 106 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\SAnswerWordQuestionRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */