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
/*     */ public class SAnswerQYXTQuestionRes
/*     */   extends __SAnswerQYXTQuestionRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12594745;
/*     */   public int newquestionid;
/*     */   public int rightanswer;
/*     */   public long session_id;
/*     */   public ArrayList<Integer> answer_sequence;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12594745;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SAnswerQYXTQuestionRes()
/*     */   {
/*  36 */     this.answer_sequence = new ArrayList();
/*     */   }
/*     */   
/*     */   public SAnswerQYXTQuestionRes(int _newquestionid_, int _rightanswer_, long _session_id_, ArrayList<Integer> _answer_sequence_) {
/*  40 */     this.newquestionid = _newquestionid_;
/*  41 */     this.rightanswer = _rightanswer_;
/*  42 */     this.session_id = _session_id_;
/*  43 */     this.answer_sequence = _answer_sequence_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  47 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  51 */     _os_.marshal(this.newquestionid);
/*  52 */     _os_.marshal(this.rightanswer);
/*  53 */     _os_.marshal(this.session_id);
/*  54 */     _os_.compact_uint32(this.answer_sequence.size());
/*  55 */     for (Integer _v_ : this.answer_sequence) {
/*  56 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  58 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  62 */     this.newquestionid = _os_.unmarshal_int();
/*  63 */     this.rightanswer = _os_.unmarshal_int();
/*  64 */     this.session_id = _os_.unmarshal_long();
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
/*  78 */     if ((_o1_ instanceof SAnswerQYXTQuestionRes)) {
/*  79 */       SAnswerQYXTQuestionRes _o_ = (SAnswerQYXTQuestionRes)_o1_;
/*  80 */       if (this.newquestionid != _o_.newquestionid) return false;
/*  81 */       if (this.rightanswer != _o_.rightanswer) return false;
/*  82 */       if (this.session_id != _o_.session_id) return false;
/*  83 */       if (!this.answer_sequence.equals(_o_.answer_sequence)) return false;
/*  84 */       return true;
/*     */     }
/*  86 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  90 */     int _h_ = 0;
/*  91 */     _h_ += this.newquestionid;
/*  92 */     _h_ += this.rightanswer;
/*  93 */     _h_ += (int)this.session_id;
/*  94 */     _h_ += this.answer_sequence.hashCode();
/*  95 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  99 */     StringBuilder _sb_ = new StringBuilder();
/* 100 */     _sb_.append("(");
/* 101 */     _sb_.append(this.newquestionid).append(",");
/* 102 */     _sb_.append(this.rightanswer).append(",");
/* 103 */     _sb_.append(this.session_id).append(",");
/* 104 */     _sb_.append(this.answer_sequence).append(",");
/* 105 */     _sb_.append(")");
/* 106 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\SAnswerQYXTQuestionRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */