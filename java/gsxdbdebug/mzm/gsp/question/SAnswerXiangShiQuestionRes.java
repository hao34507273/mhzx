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
/*     */ public class SAnswerXiangShiQuestionRes
/*     */   extends __SAnswerXiangShiQuestionRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12594712;
/*     */   public int newquestionid;
/*     */   public int alreadyanswer;
/*     */   public int rightanswer;
/*     */   public long sessionid;
/*     */   public ArrayList<Integer> answer_sequence;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12594712;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SAnswerXiangShiQuestionRes()
/*     */   {
/*  37 */     this.answer_sequence = new ArrayList();
/*     */   }
/*     */   
/*     */   public SAnswerXiangShiQuestionRes(int _newquestionid_, int _alreadyanswer_, int _rightanswer_, long _sessionid_, ArrayList<Integer> _answer_sequence_) {
/*  41 */     this.newquestionid = _newquestionid_;
/*  42 */     this.alreadyanswer = _alreadyanswer_;
/*  43 */     this.rightanswer = _rightanswer_;
/*  44 */     this.sessionid = _sessionid_;
/*  45 */     this.answer_sequence = _answer_sequence_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  49 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  53 */     _os_.marshal(this.newquestionid);
/*  54 */     _os_.marshal(this.alreadyanswer);
/*  55 */     _os_.marshal(this.rightanswer);
/*  56 */     _os_.marshal(this.sessionid);
/*  57 */     _os_.compact_uint32(this.answer_sequence.size());
/*  58 */     for (Integer _v_ : this.answer_sequence) {
/*  59 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  65 */     this.newquestionid = _os_.unmarshal_int();
/*  66 */     this.alreadyanswer = _os_.unmarshal_int();
/*  67 */     this.rightanswer = _os_.unmarshal_int();
/*  68 */     this.sessionid = _os_.unmarshal_long();
/*  69 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  71 */       int _v_ = _os_.unmarshal_int();
/*  72 */       this.answer_sequence.add(Integer.valueOf(_v_));
/*     */     }
/*  74 */     if (!_validator_()) {
/*  75 */       throw new VerifyError("validator failed");
/*     */     }
/*  77 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  81 */     if (_o1_ == this) return true;
/*  82 */     if ((_o1_ instanceof SAnswerXiangShiQuestionRes)) {
/*  83 */       SAnswerXiangShiQuestionRes _o_ = (SAnswerXiangShiQuestionRes)_o1_;
/*  84 */       if (this.newquestionid != _o_.newquestionid) return false;
/*  85 */       if (this.alreadyanswer != _o_.alreadyanswer) return false;
/*  86 */       if (this.rightanswer != _o_.rightanswer) return false;
/*  87 */       if (this.sessionid != _o_.sessionid) return false;
/*  88 */       if (!this.answer_sequence.equals(_o_.answer_sequence)) return false;
/*  89 */       return true;
/*     */     }
/*  91 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  95 */     int _h_ = 0;
/*  96 */     _h_ += this.newquestionid;
/*  97 */     _h_ += this.alreadyanswer;
/*  98 */     _h_ += this.rightanswer;
/*  99 */     _h_ += (int)this.sessionid;
/* 100 */     _h_ += this.answer_sequence.hashCode();
/* 101 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 105 */     StringBuilder _sb_ = new StringBuilder();
/* 106 */     _sb_.append("(");
/* 107 */     _sb_.append(this.newquestionid).append(",");
/* 108 */     _sb_.append(this.alreadyanswer).append(",");
/* 109 */     _sb_.append(this.rightanswer).append(",");
/* 110 */     _sb_.append(this.sessionid).append(",");
/* 111 */     _sb_.append(this.answer_sequence).append(",");
/* 112 */     _sb_.append(")");
/* 113 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\SAnswerXiangShiQuestionRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */