/*     */ package mzm.gsp.question;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.question.main.PAnswerLunHuiQuestionReq;
/*     */ 
/*     */ public class CAnswerLunHuiQuestionReq
/*     */   extends __CAnswerLunHuiQuestionReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12594694;
/*     */   public int answericonid;
/*     */   public int questionid;
/*     */   public int pageindex;
/*     */   public long sessionid;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     long roleId = Role.getRoleId(this);
/*  20 */     if (roleId < 0L) {
/*  21 */       return;
/*     */     }
/*  23 */     Role.addRoleProcedure(roleId, new PAnswerLunHuiQuestionReq(roleId, this.answericonid, this.questionid, this.pageindex, this.sessionid));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  31 */     return 12594694;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CAnswerLunHuiQuestionReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CAnswerLunHuiQuestionReq(int _answericonid_, int _questionid_, int _pageindex_, long _sessionid_)
/*     */   {
/*  43 */     this.answericonid = _answericonid_;
/*  44 */     this.questionid = _questionid_;
/*  45 */     this.pageindex = _pageindex_;
/*  46 */     this.sessionid = _sessionid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  50 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  54 */     _os_.marshal(this.answericonid);
/*  55 */     _os_.marshal(this.questionid);
/*  56 */     _os_.marshal(this.pageindex);
/*  57 */     _os_.marshal(this.sessionid);
/*  58 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  62 */     this.answericonid = _os_.unmarshal_int();
/*  63 */     this.questionid = _os_.unmarshal_int();
/*  64 */     this.pageindex = _os_.unmarshal_int();
/*  65 */     this.sessionid = _os_.unmarshal_long();
/*  66 */     if (!_validator_()) {
/*  67 */       throw new VerifyError("validator failed");
/*     */     }
/*  69 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  73 */     if (_o1_ == this) return true;
/*  74 */     if ((_o1_ instanceof CAnswerLunHuiQuestionReq)) {
/*  75 */       CAnswerLunHuiQuestionReq _o_ = (CAnswerLunHuiQuestionReq)_o1_;
/*  76 */       if (this.answericonid != _o_.answericonid) return false;
/*  77 */       if (this.questionid != _o_.questionid) return false;
/*  78 */       if (this.pageindex != _o_.pageindex) return false;
/*  79 */       if (this.sessionid != _o_.sessionid) return false;
/*  80 */       return true;
/*     */     }
/*  82 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  86 */     int _h_ = 0;
/*  87 */     _h_ += this.answericonid;
/*  88 */     _h_ += this.questionid;
/*  89 */     _h_ += this.pageindex;
/*  90 */     _h_ += (int)this.sessionid;
/*  91 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  95 */     StringBuilder _sb_ = new StringBuilder();
/*  96 */     _sb_.append("(");
/*  97 */     _sb_.append(this.answericonid).append(",");
/*  98 */     _sb_.append(this.questionid).append(",");
/*  99 */     _sb_.append(this.pageindex).append(",");
/* 100 */     _sb_.append(this.sessionid).append(",");
/* 101 */     _sb_.append(")");
/* 102 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CAnswerLunHuiQuestionReq _o_) {
/* 106 */     if (_o_ == this) return 0;
/* 107 */     int _c_ = 0;
/* 108 */     _c_ = this.answericonid - _o_.answericonid;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     _c_ = this.questionid - _o_.questionid;
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     _c_ = this.pageindex - _o_.pageindex;
/* 113 */     if (0 != _c_) return _c_;
/* 114 */     _c_ = Long.signum(this.sessionid - _o_.sessionid);
/* 115 */     if (0 != _c_) return _c_;
/* 116 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\CAnswerLunHuiQuestionReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */