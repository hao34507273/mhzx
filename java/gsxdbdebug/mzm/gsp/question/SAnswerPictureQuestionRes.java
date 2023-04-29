/*     */ package mzm.gsp.question;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SAnswerPictureQuestionRes
/*     */   extends __SAnswerPictureQuestionRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12594728;
/*     */   public int questionitemid;
/*     */   public int isright;
/*     */   public long nextanswerroleid;
/*     */   public int rightnum;
/*     */   public int totalnum;
/*     */   public int lastanswer;
/*     */   public PictureQuestionInfo nextquestioninfo;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12594728;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SAnswerPictureQuestionRes()
/*     */   {
/*  39 */     this.nextquestioninfo = new PictureQuestionInfo();
/*     */   }
/*     */   
/*     */   public SAnswerPictureQuestionRes(int _questionitemid_, int _isright_, long _nextanswerroleid_, int _rightnum_, int _totalnum_, int _lastanswer_, PictureQuestionInfo _nextquestioninfo_) {
/*  43 */     this.questionitemid = _questionitemid_;
/*  44 */     this.isright = _isright_;
/*  45 */     this.nextanswerroleid = _nextanswerroleid_;
/*  46 */     this.rightnum = _rightnum_;
/*  47 */     this.totalnum = _totalnum_;
/*  48 */     this.lastanswer = _lastanswer_;
/*  49 */     this.nextquestioninfo = _nextquestioninfo_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  53 */     if (!this.nextquestioninfo._validator_()) return false;
/*  54 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  58 */     _os_.marshal(this.questionitemid);
/*  59 */     _os_.marshal(this.isright);
/*  60 */     _os_.marshal(this.nextanswerroleid);
/*  61 */     _os_.marshal(this.rightnum);
/*  62 */     _os_.marshal(this.totalnum);
/*  63 */     _os_.marshal(this.lastanswer);
/*  64 */     _os_.marshal(this.nextquestioninfo);
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  69 */     this.questionitemid = _os_.unmarshal_int();
/*  70 */     this.isright = _os_.unmarshal_int();
/*  71 */     this.nextanswerroleid = _os_.unmarshal_long();
/*  72 */     this.rightnum = _os_.unmarshal_int();
/*  73 */     this.totalnum = _os_.unmarshal_int();
/*  74 */     this.lastanswer = _os_.unmarshal_int();
/*  75 */     this.nextquestioninfo.unmarshal(_os_);
/*  76 */     if (!_validator_()) {
/*  77 */       throw new VerifyError("validator failed");
/*     */     }
/*  79 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  83 */     if (_o1_ == this) return true;
/*  84 */     if ((_o1_ instanceof SAnswerPictureQuestionRes)) {
/*  85 */       SAnswerPictureQuestionRes _o_ = (SAnswerPictureQuestionRes)_o1_;
/*  86 */       if (this.questionitemid != _o_.questionitemid) return false;
/*  87 */       if (this.isright != _o_.isright) return false;
/*  88 */       if (this.nextanswerroleid != _o_.nextanswerroleid) return false;
/*  89 */       if (this.rightnum != _o_.rightnum) return false;
/*  90 */       if (this.totalnum != _o_.totalnum) return false;
/*  91 */       if (this.lastanswer != _o_.lastanswer) return false;
/*  92 */       if (!this.nextquestioninfo.equals(_o_.nextquestioninfo)) return false;
/*  93 */       return true;
/*     */     }
/*  95 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  99 */     int _h_ = 0;
/* 100 */     _h_ += this.questionitemid;
/* 101 */     _h_ += this.isright;
/* 102 */     _h_ += (int)this.nextanswerroleid;
/* 103 */     _h_ += this.rightnum;
/* 104 */     _h_ += this.totalnum;
/* 105 */     _h_ += this.lastanswer;
/* 106 */     _h_ += this.nextquestioninfo.hashCode();
/* 107 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 111 */     StringBuilder _sb_ = new StringBuilder();
/* 112 */     _sb_.append("(");
/* 113 */     _sb_.append(this.questionitemid).append(",");
/* 114 */     _sb_.append(this.isright).append(",");
/* 115 */     _sb_.append(this.nextanswerroleid).append(",");
/* 116 */     _sb_.append(this.rightnum).append(",");
/* 117 */     _sb_.append(this.totalnum).append(",");
/* 118 */     _sb_.append(this.lastanswer).append(",");
/* 119 */     _sb_.append(this.nextquestioninfo).append(",");
/* 120 */     _sb_.append(")");
/* 121 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\SAnswerPictureQuestionRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */