/*     */ package mzm.gsp.question;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.question.main.PCCAnswerQYXTQuestion;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CAnswerQYXTQuestionReq
/*     */   extends __CAnswerQYXTQuestionReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12594746;
/*     */   public int questionid;
/*     */   public int answeridx;
/*     */   public long session_id;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleid = Role.getRoleId(this);
/*  21 */     if (roleid < 0L)
/*     */     {
/*  23 */       return;
/*     */     }
/*  25 */     Role.addRoleProcedure(roleid, new PCCAnswerQYXTQuestion(roleid, this.questionid, this.answeridx, this.session_id));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  33 */     return 12594746;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CAnswerQYXTQuestionReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CAnswerQYXTQuestionReq(int _questionid_, int _answeridx_, long _session_id_)
/*     */   {
/*  44 */     this.questionid = _questionid_;
/*  45 */     this.answeridx = _answeridx_;
/*  46 */     this.session_id = _session_id_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  50 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  54 */     _os_.marshal(this.questionid);
/*  55 */     _os_.marshal(this.answeridx);
/*  56 */     _os_.marshal(this.session_id);
/*  57 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  61 */     this.questionid = _os_.unmarshal_int();
/*  62 */     this.answeridx = _os_.unmarshal_int();
/*  63 */     this.session_id = _os_.unmarshal_long();
/*  64 */     if (!_validator_()) {
/*  65 */       throw new VerifyError("validator failed");
/*     */     }
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  71 */     if (_o1_ == this) return true;
/*  72 */     if ((_o1_ instanceof CAnswerQYXTQuestionReq)) {
/*  73 */       CAnswerQYXTQuestionReq _o_ = (CAnswerQYXTQuestionReq)_o1_;
/*  74 */       if (this.questionid != _o_.questionid) return false;
/*  75 */       if (this.answeridx != _o_.answeridx) return false;
/*  76 */       if (this.session_id != _o_.session_id) return false;
/*  77 */       return true;
/*     */     }
/*  79 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  83 */     int _h_ = 0;
/*  84 */     _h_ += this.questionid;
/*  85 */     _h_ += this.answeridx;
/*  86 */     _h_ += (int)this.session_id;
/*  87 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  91 */     StringBuilder _sb_ = new StringBuilder();
/*  92 */     _sb_.append("(");
/*  93 */     _sb_.append(this.questionid).append(",");
/*  94 */     _sb_.append(this.answeridx).append(",");
/*  95 */     _sb_.append(this.session_id).append(",");
/*  96 */     _sb_.append(")");
/*  97 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CAnswerQYXTQuestionReq _o_) {
/* 101 */     if (_o_ == this) return 0;
/* 102 */     int _c_ = 0;
/* 103 */     _c_ = this.questionid - _o_.questionid;
/* 104 */     if (0 != _c_) return _c_;
/* 105 */     _c_ = this.answeridx - _o_.answeridx;
/* 106 */     if (0 != _c_) return _c_;
/* 107 */     _c_ = Long.signum(this.session_id - _o_.session_id);
/* 108 */     if (0 != _c_) return _c_;
/* 109 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\CAnswerQYXTQuestionReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */