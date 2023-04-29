/*     */ package mzm.gsp.question;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SJoinLunHuiQuestionRes
/*     */   extends __SJoinLunHuiQuestionRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12594691;
/*     */   public int answerednum;
/*     */   public int questionid;
/*     */   public long money;
/*     */   public long exp;
/*     */   public int nextpageindex;
/*     */   public int usehelpnum;
/*     */   public long sessionid;
/*     */   public ArrayList<Integer> answer_sequence;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12594691;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SJoinLunHuiQuestionRes()
/*     */   {
/*  40 */     this.answer_sequence = new ArrayList();
/*     */   }
/*     */   
/*     */   public SJoinLunHuiQuestionRes(int _answerednum_, int _questionid_, long _money_, long _exp_, int _nextpageindex_, int _usehelpnum_, long _sessionid_, ArrayList<Integer> _answer_sequence_) {
/*  44 */     this.answerednum = _answerednum_;
/*  45 */     this.questionid = _questionid_;
/*  46 */     this.money = _money_;
/*  47 */     this.exp = _exp_;
/*  48 */     this.nextpageindex = _nextpageindex_;
/*  49 */     this.usehelpnum = _usehelpnum_;
/*  50 */     this.sessionid = _sessionid_;
/*  51 */     this.answer_sequence = _answer_sequence_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  55 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  59 */     _os_.marshal(this.answerednum);
/*  60 */     _os_.marshal(this.questionid);
/*  61 */     _os_.marshal(this.money);
/*  62 */     _os_.marshal(this.exp);
/*  63 */     _os_.marshal(this.nextpageindex);
/*  64 */     _os_.marshal(this.usehelpnum);
/*  65 */     _os_.marshal(this.sessionid);
/*  66 */     _os_.compact_uint32(this.answer_sequence.size());
/*  67 */     for (Integer _v_ : this.answer_sequence) {
/*  68 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  70 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  74 */     this.answerednum = _os_.unmarshal_int();
/*  75 */     this.questionid = _os_.unmarshal_int();
/*  76 */     this.money = _os_.unmarshal_long();
/*  77 */     this.exp = _os_.unmarshal_long();
/*  78 */     this.nextpageindex = _os_.unmarshal_int();
/*  79 */     this.usehelpnum = _os_.unmarshal_int();
/*  80 */     this.sessionid = _os_.unmarshal_long();
/*  81 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  83 */       int _v_ = _os_.unmarshal_int();
/*  84 */       this.answer_sequence.add(Integer.valueOf(_v_));
/*     */     }
/*  86 */     if (!_validator_()) {
/*  87 */       throw new VerifyError("validator failed");
/*     */     }
/*  89 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  93 */     if (_o1_ == this) return true;
/*  94 */     if ((_o1_ instanceof SJoinLunHuiQuestionRes)) {
/*  95 */       SJoinLunHuiQuestionRes _o_ = (SJoinLunHuiQuestionRes)_o1_;
/*  96 */       if (this.answerednum != _o_.answerednum) return false;
/*  97 */       if (this.questionid != _o_.questionid) return false;
/*  98 */       if (this.money != _o_.money) return false;
/*  99 */       if (this.exp != _o_.exp) return false;
/* 100 */       if (this.nextpageindex != _o_.nextpageindex) return false;
/* 101 */       if (this.usehelpnum != _o_.usehelpnum) return false;
/* 102 */       if (this.sessionid != _o_.sessionid) return false;
/* 103 */       if (!this.answer_sequence.equals(_o_.answer_sequence)) return false;
/* 104 */       return true;
/*     */     }
/* 106 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 110 */     int _h_ = 0;
/* 111 */     _h_ += this.answerednum;
/* 112 */     _h_ += this.questionid;
/* 113 */     _h_ += (int)this.money;
/* 114 */     _h_ += (int)this.exp;
/* 115 */     _h_ += this.nextpageindex;
/* 116 */     _h_ += this.usehelpnum;
/* 117 */     _h_ += (int)this.sessionid;
/* 118 */     _h_ += this.answer_sequence.hashCode();
/* 119 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 123 */     StringBuilder _sb_ = new StringBuilder();
/* 124 */     _sb_.append("(");
/* 125 */     _sb_.append(this.answerednum).append(",");
/* 126 */     _sb_.append(this.questionid).append(",");
/* 127 */     _sb_.append(this.money).append(",");
/* 128 */     _sb_.append(this.exp).append(",");
/* 129 */     _sb_.append(this.nextpageindex).append(",");
/* 130 */     _sb_.append(this.usehelpnum).append(",");
/* 131 */     _sb_.append(this.sessionid).append(",");
/* 132 */     _sb_.append(this.answer_sequence).append(",");
/* 133 */     _sb_.append(")");
/* 134 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\SJoinLunHuiQuestionRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */