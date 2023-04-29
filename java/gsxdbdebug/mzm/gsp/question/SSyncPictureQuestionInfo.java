/*     */ package mzm.gsp.question;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SSyncPictureQuestionInfo
/*     */   extends __SSyncPictureQuestionInfo__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12594733;
/*     */   public long answerroleid;
/*     */   public int remainhelpercount;
/*     */   public int difficultylevelid;
/*     */   public int rightcount;
/*     */   public int totalcount;
/*     */   public PictureQuestionInfo info;
/*     */   public int endtime;
/*     */   public ArrayList<AnswerInfo> answerlist;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12594733;
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
/*     */   public SSyncPictureQuestionInfo()
/*     */   {
/*  40 */     this.info = new PictureQuestionInfo();
/*  41 */     this.answerlist = new ArrayList();
/*     */   }
/*     */   
/*     */   public SSyncPictureQuestionInfo(long _answerroleid_, int _remainhelpercount_, int _difficultylevelid_, int _rightcount_, int _totalcount_, PictureQuestionInfo _info_, int _endtime_, ArrayList<AnswerInfo> _answerlist_) {
/*  45 */     this.answerroleid = _answerroleid_;
/*  46 */     this.remainhelpercount = _remainhelpercount_;
/*  47 */     this.difficultylevelid = _difficultylevelid_;
/*  48 */     this.rightcount = _rightcount_;
/*  49 */     this.totalcount = _totalcount_;
/*  50 */     this.info = _info_;
/*  51 */     this.endtime = _endtime_;
/*  52 */     this.answerlist = _answerlist_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  56 */     if (!this.info._validator_()) return false;
/*  57 */     for (AnswerInfo _v_ : this.answerlist)
/*  58 */       if (!_v_._validator_()) return false;
/*  59 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  63 */     _os_.marshal(this.answerroleid);
/*  64 */     _os_.marshal(this.remainhelpercount);
/*  65 */     _os_.marshal(this.difficultylevelid);
/*  66 */     _os_.marshal(this.rightcount);
/*  67 */     _os_.marshal(this.totalcount);
/*  68 */     _os_.marshal(this.info);
/*  69 */     _os_.marshal(this.endtime);
/*  70 */     _os_.compact_uint32(this.answerlist.size());
/*  71 */     for (AnswerInfo _v_ : this.answerlist) {
/*  72 */       _os_.marshal(_v_);
/*     */     }
/*  74 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  78 */     this.answerroleid = _os_.unmarshal_long();
/*  79 */     this.remainhelpercount = _os_.unmarshal_int();
/*  80 */     this.difficultylevelid = _os_.unmarshal_int();
/*  81 */     this.rightcount = _os_.unmarshal_int();
/*  82 */     this.totalcount = _os_.unmarshal_int();
/*  83 */     this.info.unmarshal(_os_);
/*  84 */     this.endtime = _os_.unmarshal_int();
/*  85 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  86 */       AnswerInfo _v_ = new AnswerInfo();
/*  87 */       _v_.unmarshal(_os_);
/*  88 */       this.answerlist.add(_v_);
/*     */     }
/*  90 */     if (!_validator_()) {
/*  91 */       throw new VerifyError("validator failed");
/*     */     }
/*  93 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  97 */     if (_o1_ == this) return true;
/*  98 */     if ((_o1_ instanceof SSyncPictureQuestionInfo)) {
/*  99 */       SSyncPictureQuestionInfo _o_ = (SSyncPictureQuestionInfo)_o1_;
/* 100 */       if (this.answerroleid != _o_.answerroleid) return false;
/* 101 */       if (this.remainhelpercount != _o_.remainhelpercount) return false;
/* 102 */       if (this.difficultylevelid != _o_.difficultylevelid) return false;
/* 103 */       if (this.rightcount != _o_.rightcount) return false;
/* 104 */       if (this.totalcount != _o_.totalcount) return false;
/* 105 */       if (!this.info.equals(_o_.info)) return false;
/* 106 */       if (this.endtime != _o_.endtime) return false;
/* 107 */       if (!this.answerlist.equals(_o_.answerlist)) return false;
/* 108 */       return true;
/*     */     }
/* 110 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 114 */     int _h_ = 0;
/* 115 */     _h_ += (int)this.answerroleid;
/* 116 */     _h_ += this.remainhelpercount;
/* 117 */     _h_ += this.difficultylevelid;
/* 118 */     _h_ += this.rightcount;
/* 119 */     _h_ += this.totalcount;
/* 120 */     _h_ += this.info.hashCode();
/* 121 */     _h_ += this.endtime;
/* 122 */     _h_ += this.answerlist.hashCode();
/* 123 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 127 */     StringBuilder _sb_ = new StringBuilder();
/* 128 */     _sb_.append("(");
/* 129 */     _sb_.append(this.answerroleid).append(",");
/* 130 */     _sb_.append(this.remainhelpercount).append(",");
/* 131 */     _sb_.append(this.difficultylevelid).append(",");
/* 132 */     _sb_.append(this.rightcount).append(",");
/* 133 */     _sb_.append(this.totalcount).append(",");
/* 134 */     _sb_.append(this.info).append(",");
/* 135 */     _sb_.append(this.endtime).append(",");
/* 136 */     _sb_.append(this.answerlist).append(",");
/* 137 */     _sb_.append(")");
/* 138 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\SSyncPictureQuestionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */