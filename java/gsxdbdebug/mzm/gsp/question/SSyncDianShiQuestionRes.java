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
/*     */ public class SSyncDianShiQuestionRes
/*     */   extends __SSyncDianShiQuestionRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12594706;
/*     */   public int questionid;
/*     */   public int alreadyanswer;
/*     */   public int rightanswer;
/*     */   public int totaladdtime;
/*     */   public long sessionid;
/*     */   public ArrayList<Integer> answer_sequence;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12594706;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSyncDianShiQuestionRes()
/*     */   {
/*  38 */     this.answer_sequence = new ArrayList();
/*     */   }
/*     */   
/*     */   public SSyncDianShiQuestionRes(int _questionid_, int _alreadyanswer_, int _rightanswer_, int _totaladdtime_, long _sessionid_, ArrayList<Integer> _answer_sequence_) {
/*  42 */     this.questionid = _questionid_;
/*  43 */     this.alreadyanswer = _alreadyanswer_;
/*  44 */     this.rightanswer = _rightanswer_;
/*  45 */     this.totaladdtime = _totaladdtime_;
/*  46 */     this.sessionid = _sessionid_;
/*  47 */     this.answer_sequence = _answer_sequence_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  51 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  55 */     _os_.marshal(this.questionid);
/*  56 */     _os_.marshal(this.alreadyanswer);
/*  57 */     _os_.marshal(this.rightanswer);
/*  58 */     _os_.marshal(this.totaladdtime);
/*  59 */     _os_.marshal(this.sessionid);
/*  60 */     _os_.compact_uint32(this.answer_sequence.size());
/*  61 */     for (Integer _v_ : this.answer_sequence) {
/*  62 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  64 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  68 */     this.questionid = _os_.unmarshal_int();
/*  69 */     this.alreadyanswer = _os_.unmarshal_int();
/*  70 */     this.rightanswer = _os_.unmarshal_int();
/*  71 */     this.totaladdtime = _os_.unmarshal_int();
/*  72 */     this.sessionid = _os_.unmarshal_long();
/*  73 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  75 */       int _v_ = _os_.unmarshal_int();
/*  76 */       this.answer_sequence.add(Integer.valueOf(_v_));
/*     */     }
/*  78 */     if (!_validator_()) {
/*  79 */       throw new VerifyError("validator failed");
/*     */     }
/*  81 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  85 */     if (_o1_ == this) return true;
/*  86 */     if ((_o1_ instanceof SSyncDianShiQuestionRes)) {
/*  87 */       SSyncDianShiQuestionRes _o_ = (SSyncDianShiQuestionRes)_o1_;
/*  88 */       if (this.questionid != _o_.questionid) return false;
/*  89 */       if (this.alreadyanswer != _o_.alreadyanswer) return false;
/*  90 */       if (this.rightanswer != _o_.rightanswer) return false;
/*  91 */       if (this.totaladdtime != _o_.totaladdtime) return false;
/*  92 */       if (this.sessionid != _o_.sessionid) return false;
/*  93 */       if (!this.answer_sequence.equals(_o_.answer_sequence)) return false;
/*  94 */       return true;
/*     */     }
/*  96 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 100 */     int _h_ = 0;
/* 101 */     _h_ += this.questionid;
/* 102 */     _h_ += this.alreadyanswer;
/* 103 */     _h_ += this.rightanswer;
/* 104 */     _h_ += this.totaladdtime;
/* 105 */     _h_ += (int)this.sessionid;
/* 106 */     _h_ += this.answer_sequence.hashCode();
/* 107 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 111 */     StringBuilder _sb_ = new StringBuilder();
/* 112 */     _sb_.append("(");
/* 113 */     _sb_.append(this.questionid).append(",");
/* 114 */     _sb_.append(this.alreadyanswer).append(",");
/* 115 */     _sb_.append(this.rightanswer).append(",");
/* 116 */     _sb_.append(this.totaladdtime).append(",");
/* 117 */     _sb_.append(this.sessionid).append(",");
/* 118 */     _sb_.append(this.answer_sequence).append(",");
/* 119 */     _sb_.append(")");
/* 120 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\SSyncDianShiQuestionRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */