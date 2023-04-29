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
/*     */ public class SAnswerLunHuiResultRes
/*     */   extends __SAnswerLunHuiResultRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12594689;
/*     */   public int nextquestionid;
/*     */   public int nextpageindex;
/*     */   public int islastanswerright;
/*     */   public long money;
/*     */   public long exp;
/*     */   public long sessionid;
/*     */   public ArrayList<Integer> answer_sequence;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12594689;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SAnswerLunHuiResultRes()
/*     */   {
/*  39 */     this.answer_sequence = new ArrayList();
/*     */   }
/*     */   
/*     */   public SAnswerLunHuiResultRes(int _nextquestionid_, int _nextpageindex_, int _islastanswerright_, long _money_, long _exp_, long _sessionid_, ArrayList<Integer> _answer_sequence_) {
/*  43 */     this.nextquestionid = _nextquestionid_;
/*  44 */     this.nextpageindex = _nextpageindex_;
/*  45 */     this.islastanswerright = _islastanswerright_;
/*  46 */     this.money = _money_;
/*  47 */     this.exp = _exp_;
/*  48 */     this.sessionid = _sessionid_;
/*  49 */     this.answer_sequence = _answer_sequence_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  53 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  57 */     _os_.marshal(this.nextquestionid);
/*  58 */     _os_.marshal(this.nextpageindex);
/*  59 */     _os_.marshal(this.islastanswerright);
/*  60 */     _os_.marshal(this.money);
/*  61 */     _os_.marshal(this.exp);
/*  62 */     _os_.marshal(this.sessionid);
/*  63 */     _os_.compact_uint32(this.answer_sequence.size());
/*  64 */     for (Integer _v_ : this.answer_sequence) {
/*  65 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  71 */     this.nextquestionid = _os_.unmarshal_int();
/*  72 */     this.nextpageindex = _os_.unmarshal_int();
/*  73 */     this.islastanswerright = _os_.unmarshal_int();
/*  74 */     this.money = _os_.unmarshal_long();
/*  75 */     this.exp = _os_.unmarshal_long();
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
/*  90 */     if ((_o1_ instanceof SAnswerLunHuiResultRes)) {
/*  91 */       SAnswerLunHuiResultRes _o_ = (SAnswerLunHuiResultRes)_o1_;
/*  92 */       if (this.nextquestionid != _o_.nextquestionid) return false;
/*  93 */       if (this.nextpageindex != _o_.nextpageindex) return false;
/*  94 */       if (this.islastanswerright != _o_.islastanswerright) return false;
/*  95 */       if (this.money != _o_.money) return false;
/*  96 */       if (this.exp != _o_.exp) return false;
/*  97 */       if (this.sessionid != _o_.sessionid) return false;
/*  98 */       if (!this.answer_sequence.equals(_o_.answer_sequence)) return false;
/*  99 */       return true;
/*     */     }
/* 101 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 105 */     int _h_ = 0;
/* 106 */     _h_ += this.nextquestionid;
/* 107 */     _h_ += this.nextpageindex;
/* 108 */     _h_ += this.islastanswerright;
/* 109 */     _h_ += (int)this.money;
/* 110 */     _h_ += (int)this.exp;
/* 111 */     _h_ += (int)this.sessionid;
/* 112 */     _h_ += this.answer_sequence.hashCode();
/* 113 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 117 */     StringBuilder _sb_ = new StringBuilder();
/* 118 */     _sb_.append("(");
/* 119 */     _sb_.append(this.nextquestionid).append(",");
/* 120 */     _sb_.append(this.nextpageindex).append(",");
/* 121 */     _sb_.append(this.islastanswerright).append(",");
/* 122 */     _sb_.append(this.money).append(",");
/* 123 */     _sb_.append(this.exp).append(",");
/* 124 */     _sb_.append(this.sessionid).append(",");
/* 125 */     _sb_.append(this.answer_sequence).append(",");
/* 126 */     _sb_.append(")");
/* 127 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\SAnswerLunHuiResultRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */