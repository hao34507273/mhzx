/*     */ package mzm.gsp.question;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.question.main.PAnswerWordQuestionReq;
/*     */ 
/*     */ 
/*     */ public class CAnswerWordQuestionReq
/*     */   extends __CAnswerWordQuestionReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12594739;
/*     */   public int answeridx;
/*     */   public int curquestionid;
/*     */   public long sessionid;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     long roleId = Role.getRoleId(this);
/*  20 */     if (roleId < 0L) {
/*  21 */       return;
/*     */     }
/*  23 */     Role.addRoleProcedure(roleId, new PAnswerWordQuestionReq(roleId, this.answeridx, this.curquestionid, this.sessionid));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  31 */     return 12594739;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CAnswerWordQuestionReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CAnswerWordQuestionReq(int _answeridx_, int _curquestionid_, long _sessionid_)
/*     */   {
/*  42 */     this.answeridx = _answeridx_;
/*  43 */     this.curquestionid = _curquestionid_;
/*  44 */     this.sessionid = _sessionid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.answeridx);
/*  53 */     _os_.marshal(this.curquestionid);
/*  54 */     _os_.marshal(this.sessionid);
/*  55 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  59 */     this.answeridx = _os_.unmarshal_int();
/*  60 */     this.curquestionid = _os_.unmarshal_int();
/*  61 */     this.sessionid = _os_.unmarshal_long();
/*  62 */     if (!_validator_()) {
/*  63 */       throw new VerifyError("validator failed");
/*     */     }
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  69 */     if (_o1_ == this) return true;
/*  70 */     if ((_o1_ instanceof CAnswerWordQuestionReq)) {
/*  71 */       CAnswerWordQuestionReq _o_ = (CAnswerWordQuestionReq)_o1_;
/*  72 */       if (this.answeridx != _o_.answeridx) return false;
/*  73 */       if (this.curquestionid != _o_.curquestionid) return false;
/*  74 */       if (this.sessionid != _o_.sessionid) return false;
/*  75 */       return true;
/*     */     }
/*  77 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  81 */     int _h_ = 0;
/*  82 */     _h_ += this.answeridx;
/*  83 */     _h_ += this.curquestionid;
/*  84 */     _h_ += (int)this.sessionid;
/*  85 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  89 */     StringBuilder _sb_ = new StringBuilder();
/*  90 */     _sb_.append("(");
/*  91 */     _sb_.append(this.answeridx).append(",");
/*  92 */     _sb_.append(this.curquestionid).append(",");
/*  93 */     _sb_.append(this.sessionid).append(",");
/*  94 */     _sb_.append(")");
/*  95 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CAnswerWordQuestionReq _o_) {
/*  99 */     if (_o_ == this) return 0;
/* 100 */     int _c_ = 0;
/* 101 */     _c_ = this.answeridx - _o_.answeridx;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     _c_ = this.curquestionid - _o_.curquestionid;
/* 104 */     if (0 != _c_) return _c_;
/* 105 */     _c_ = Long.signum(this.sessionid - _o_.sessionid);
/* 106 */     if (0 != _c_) return _c_;
/* 107 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\CAnswerWordQuestionReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */