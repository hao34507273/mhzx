/*    */ package mzm.gsp.question;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.question.main.PHelpAnswerPictureQuestionReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CHelpAnswerPictureQuestionReq
/*    */   extends __CHelpAnswerPictureQuestionReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12594732;
/*    */   public int answer;
/*    */   public int questionid;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     if (roleId < 0L) return;
/* 21 */     Role.addRoleProcedure(roleId, new PHelpAnswerPictureQuestionReq(roleId, this.answer, this.questionid));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 29 */     return 12594732;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CHelpAnswerPictureQuestionReq() {}
/*    */   
/*    */ 
/*    */   public CHelpAnswerPictureQuestionReq(int _answer_, int _questionid_)
/*    */   {
/* 39 */     this.answer = _answer_;
/* 40 */     this.questionid = _questionid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.answer);
/* 49 */     _os_.marshal(this.questionid);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.answer = _os_.unmarshal_int();
/* 55 */     this.questionid = _os_.unmarshal_int();
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof CHelpAnswerPictureQuestionReq)) {
/* 65 */       CHelpAnswerPictureQuestionReq _o_ = (CHelpAnswerPictureQuestionReq)_o1_;
/* 66 */       if (this.answer != _o_.answer) return false;
/* 67 */       if (this.questionid != _o_.questionid) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += this.answer;
/* 76 */     _h_ += this.questionid;
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.answer).append(",");
/* 84 */     _sb_.append(this.questionid).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CHelpAnswerPictureQuestionReq _o_) {
/* 90 */     if (_o_ == this) return 0;
/* 91 */     int _c_ = 0;
/* 92 */     _c_ = this.answer - _o_.answer;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     _c_ = this.questionid - _o_.questionid;
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\CHelpAnswerPictureQuestionReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */