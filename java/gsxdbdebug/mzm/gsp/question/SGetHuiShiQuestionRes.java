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
/*     */ public class SGetHuiShiQuestionRes
/*     */   extends __SGetHuiShiQuestionRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12594705;
/*     */   public int questionid;
/*     */   public int alreadyanswer;
/*     */   public int rightanswer;
/*     */   public int totaladdtime;
/*     */   public int starttime;
/*     */   public long sessionid;
/*     */   public ArrayList<Integer> answer_sequence;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12594705;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SGetHuiShiQuestionRes()
/*     */   {
/*  39 */     this.answer_sequence = new ArrayList();
/*     */   }
/*     */   
/*     */   public SGetHuiShiQuestionRes(int _questionid_, int _alreadyanswer_, int _rightanswer_, int _totaladdtime_, int _starttime_, long _sessionid_, ArrayList<Integer> _answer_sequence_) {
/*  43 */     this.questionid = _questionid_;
/*  44 */     this.alreadyanswer = _alreadyanswer_;
/*  45 */     this.rightanswer = _rightanswer_;
/*  46 */     this.totaladdtime = _totaladdtime_;
/*  47 */     this.starttime = _starttime_;
/*  48 */     this.sessionid = _sessionid_;
/*  49 */     this.answer_sequence = _answer_sequence_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  53 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  57 */     _os_.marshal(this.questionid);
/*  58 */     _os_.marshal(this.alreadyanswer);
/*  59 */     _os_.marshal(this.rightanswer);
/*  60 */     _os_.marshal(this.totaladdtime);
/*  61 */     _os_.marshal(this.starttime);
/*  62 */     _os_.marshal(this.sessionid);
/*  63 */     _os_.compact_uint32(this.answer_sequence.size());
/*  64 */     for (Integer _v_ : this.answer_sequence) {
/*  65 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  71 */     this.questionid = _os_.unmarshal_int();
/*  72 */     this.alreadyanswer = _os_.unmarshal_int();
/*  73 */     this.rightanswer = _os_.unmarshal_int();
/*  74 */     this.totaladdtime = _os_.unmarshal_int();
/*  75 */     this.starttime = _os_.unmarshal_int();
/*  76 */     this.sessionid = _os_.unmarshal_long();
/*  77 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  79 */       int _v_ = _os_.unmarshal_int();
/*  80 */       this.answer_sequence.add(Integer.valueOf(_v_));
/*     */     }
/*  82 */     if (!_validator_()) {
/*  83 */       throw new VerifyError("validator failed");
/*     */     }
/*  85 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  89 */     if (_o1_ == this) return true;
/*  90 */     if ((_o1_ instanceof SGetHuiShiQuestionRes)) {
/*  91 */       SGetHuiShiQuestionRes _o_ = (SGetHuiShiQuestionRes)_o1_;
/*  92 */       if (this.questionid != _o_.questionid) return false;
/*  93 */       if (this.alreadyanswer != _o_.alreadyanswer) return false;
/*  94 */       if (this.rightanswer != _o_.rightanswer) return false;
/*  95 */       if (this.totaladdtime != _o_.totaladdtime) return false;
/*  96 */       if (this.starttime != _o_.starttime) return false;
/*  97 */       if (this.sessionid != _o_.sessionid) return false;
/*  98 */       if (!this.answer_sequence.equals(_o_.answer_sequence)) return false;
/*  99 */       return true;
/*     */     }
/* 101 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 105 */     int _h_ = 0;
/* 106 */     _h_ += this.questionid;
/* 107 */     _h_ += this.alreadyanswer;
/* 108 */     _h_ += this.rightanswer;
/* 109 */     _h_ += this.totaladdtime;
/* 110 */     _h_ += this.starttime;
/* 111 */     _h_ += (int)this.sessionid;
/* 112 */     _h_ += this.answer_sequence.hashCode();
/* 113 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 117 */     StringBuilder _sb_ = new StringBuilder();
/* 118 */     _sb_.append("(");
/* 119 */     _sb_.append(this.questionid).append(",");
/* 120 */     _sb_.append(this.alreadyanswer).append(",");
/* 121 */     _sb_.append(this.rightanswer).append(",");
/* 122 */     _sb_.append(this.totaladdtime).append(",");
/* 123 */     _sb_.append(this.starttime).append(",");
/* 124 */     _sb_.append(this.sessionid).append(",");
/* 125 */     _sb_.append(this.answer_sequence).append(",");
/* 126 */     _sb_.append(")");
/* 127 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\SGetHuiShiQuestionRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */