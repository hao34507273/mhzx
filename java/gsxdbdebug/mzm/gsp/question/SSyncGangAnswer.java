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
/*     */ 
/*     */ 
/*     */ public class SSyncGangAnswer
/*     */   extends __SSyncGangAnswer__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12594696;
/*     */   public int questionid;
/*     */   public int pageindex;
/*     */   public long roleid;
/*     */   public String answerstring;
/*     */   public long answerroleid;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12594696;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSyncGangAnswer()
/*     */   {
/*  37 */     this.answerstring = "";
/*     */   }
/*     */   
/*     */   public SSyncGangAnswer(int _questionid_, int _pageindex_, long _roleid_, String _answerstring_, long _answerroleid_) {
/*  41 */     this.questionid = _questionid_;
/*  42 */     this.pageindex = _pageindex_;
/*  43 */     this.roleid = _roleid_;
/*  44 */     this.answerstring = _answerstring_;
/*  45 */     this.answerroleid = _answerroleid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  49 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  53 */     _os_.marshal(this.questionid);
/*  54 */     _os_.marshal(this.pageindex);
/*  55 */     _os_.marshal(this.roleid);
/*  56 */     _os_.marshal(this.answerstring, "UTF-16LE");
/*  57 */     _os_.marshal(this.answerroleid);
/*  58 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  62 */     this.questionid = _os_.unmarshal_int();
/*  63 */     this.pageindex = _os_.unmarshal_int();
/*  64 */     this.roleid = _os_.unmarshal_long();
/*  65 */     this.answerstring = _os_.unmarshal_String("UTF-16LE");
/*  66 */     this.answerroleid = _os_.unmarshal_long();
/*  67 */     if (!_validator_()) {
/*  68 */       throw new VerifyError("validator failed");
/*     */     }
/*  70 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  74 */     if (_o1_ == this) return true;
/*  75 */     if ((_o1_ instanceof SSyncGangAnswer)) {
/*  76 */       SSyncGangAnswer _o_ = (SSyncGangAnswer)_o1_;
/*  77 */       if (this.questionid != _o_.questionid) return false;
/*  78 */       if (this.pageindex != _o_.pageindex) return false;
/*  79 */       if (this.roleid != _o_.roleid) return false;
/*  80 */       if (!this.answerstring.equals(_o_.answerstring)) return false;
/*  81 */       if (this.answerroleid != _o_.answerroleid) return false;
/*  82 */       return true;
/*     */     }
/*  84 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  88 */     int _h_ = 0;
/*  89 */     _h_ += this.questionid;
/*  90 */     _h_ += this.pageindex;
/*  91 */     _h_ += (int)this.roleid;
/*  92 */     _h_ += this.answerstring.hashCode();
/*  93 */     _h_ += (int)this.answerroleid;
/*  94 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  98 */     StringBuilder _sb_ = new StringBuilder();
/*  99 */     _sb_.append("(");
/* 100 */     _sb_.append(this.questionid).append(",");
/* 101 */     _sb_.append(this.pageindex).append(",");
/* 102 */     _sb_.append(this.roleid).append(",");
/* 103 */     _sb_.append("T").append(this.answerstring.length()).append(",");
/* 104 */     _sb_.append(this.answerroleid).append(",");
/* 105 */     _sb_.append(")");
/* 106 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\SSyncGangAnswer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */