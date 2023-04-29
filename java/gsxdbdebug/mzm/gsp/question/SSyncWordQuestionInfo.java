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
/*     */ public class SSyncWordQuestionInfo
/*     */   extends __SSyncWordQuestionInfo__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12594740;
/*     */   public int levelcfgid;
/*     */   public int rightnum;
/*     */   public int wrongnum;
/*     */   public int curquestionid;
/*     */   public int endtime;
/*     */   public long sessionid;
/*     */   public ArrayList<Integer> answer_sequence;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12594740;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSyncWordQuestionInfo()
/*     */   {
/*  39 */     this.answer_sequence = new ArrayList();
/*     */   }
/*     */   
/*     */   public SSyncWordQuestionInfo(int _levelcfgid_, int _rightnum_, int _wrongnum_, int _curquestionid_, int _endtime_, long _sessionid_, ArrayList<Integer> _answer_sequence_) {
/*  43 */     this.levelcfgid = _levelcfgid_;
/*  44 */     this.rightnum = _rightnum_;
/*  45 */     this.wrongnum = _wrongnum_;
/*  46 */     this.curquestionid = _curquestionid_;
/*  47 */     this.endtime = _endtime_;
/*  48 */     this.sessionid = _sessionid_;
/*  49 */     this.answer_sequence = _answer_sequence_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  53 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  57 */     _os_.marshal(this.levelcfgid);
/*  58 */     _os_.marshal(this.rightnum);
/*  59 */     _os_.marshal(this.wrongnum);
/*  60 */     _os_.marshal(this.curquestionid);
/*  61 */     _os_.marshal(this.endtime);
/*  62 */     _os_.marshal(this.sessionid);
/*  63 */     _os_.compact_uint32(this.answer_sequence.size());
/*  64 */     for (Integer _v_ : this.answer_sequence) {
/*  65 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  71 */     this.levelcfgid = _os_.unmarshal_int();
/*  72 */     this.rightnum = _os_.unmarshal_int();
/*  73 */     this.wrongnum = _os_.unmarshal_int();
/*  74 */     this.curquestionid = _os_.unmarshal_int();
/*  75 */     this.endtime = _os_.unmarshal_int();
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
/*  90 */     if ((_o1_ instanceof SSyncWordQuestionInfo)) {
/*  91 */       SSyncWordQuestionInfo _o_ = (SSyncWordQuestionInfo)_o1_;
/*  92 */       if (this.levelcfgid != _o_.levelcfgid) return false;
/*  93 */       if (this.rightnum != _o_.rightnum) return false;
/*  94 */       if (this.wrongnum != _o_.wrongnum) return false;
/*  95 */       if (this.curquestionid != _o_.curquestionid) return false;
/*  96 */       if (this.endtime != _o_.endtime) return false;
/*  97 */       if (this.sessionid != _o_.sessionid) return false;
/*  98 */       if (!this.answer_sequence.equals(_o_.answer_sequence)) return false;
/*  99 */       return true;
/*     */     }
/* 101 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 105 */     int _h_ = 0;
/* 106 */     _h_ += this.levelcfgid;
/* 107 */     _h_ += this.rightnum;
/* 108 */     _h_ += this.wrongnum;
/* 109 */     _h_ += this.curquestionid;
/* 110 */     _h_ += this.endtime;
/* 111 */     _h_ += (int)this.sessionid;
/* 112 */     _h_ += this.answer_sequence.hashCode();
/* 113 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 117 */     StringBuilder _sb_ = new StringBuilder();
/* 118 */     _sb_.append("(");
/* 119 */     _sb_.append(this.levelcfgid).append(",");
/* 120 */     _sb_.append(this.rightnum).append(",");
/* 121 */     _sb_.append(this.wrongnum).append(",");
/* 122 */     _sb_.append(this.curquestionid).append(",");
/* 123 */     _sb_.append(this.endtime).append(",");
/* 124 */     _sb_.append(this.sessionid).append(",");
/* 125 */     _sb_.append(this.answer_sequence).append(",");
/* 126 */     _sb_.append(")");
/* 127 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\SSyncWordQuestionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */