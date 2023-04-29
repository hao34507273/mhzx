/*    */ package mzm.gsp.drawandguess;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.drawandguess.main.PCAnswerDrawAndGuessQuestionReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CAnswerDrawAndGuessQuestionReq
/*    */   extends __CAnswerDrawAndGuessQuestionReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12617234;
/*    */   public long sessionid;
/*    */   public String answer;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleId = Role.getRoleId(this);
/* 21 */     if (roleId < 1L)
/*    */     {
/* 23 */       return;
/*    */     }
/* 25 */     Role.addRoleProcedure(roleId, new PCAnswerDrawAndGuessQuestionReq(roleId, this.answer, this.sessionid));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 33 */     return 12617234;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CAnswerDrawAndGuessQuestionReq()
/*    */   {
/* 40 */     this.answer = "";
/*    */   }
/*    */   
/*    */   public CAnswerDrawAndGuessQuestionReq(long _sessionid_, String _answer_) {
/* 44 */     this.sessionid = _sessionid_;
/* 45 */     this.answer = _answer_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 49 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 53 */     _os_.marshal(this.sessionid);
/* 54 */     _os_.marshal(this.answer, "UTF-16LE");
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 59 */     this.sessionid = _os_.unmarshal_long();
/* 60 */     this.answer = _os_.unmarshal_String("UTF-16LE");
/* 61 */     if (!_validator_()) {
/* 62 */       throw new VerifyError("validator failed");
/*    */     }
/* 64 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 68 */     if (_o1_ == this) return true;
/* 69 */     if ((_o1_ instanceof CAnswerDrawAndGuessQuestionReq)) {
/* 70 */       CAnswerDrawAndGuessQuestionReq _o_ = (CAnswerDrawAndGuessQuestionReq)_o1_;
/* 71 */       if (this.sessionid != _o_.sessionid) return false;
/* 72 */       if (!this.answer.equals(_o_.answer)) return false;
/* 73 */       return true;
/*    */     }
/* 75 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 79 */     int _h_ = 0;
/* 80 */     _h_ += (int)this.sessionid;
/* 81 */     _h_ += this.answer.hashCode();
/* 82 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 86 */     StringBuilder _sb_ = new StringBuilder();
/* 87 */     _sb_.append("(");
/* 88 */     _sb_.append(this.sessionid).append(",");
/* 89 */     _sb_.append("T").append(this.answer.length()).append(",");
/* 90 */     _sb_.append(")");
/* 91 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\drawandguess\CAnswerDrawAndGuessQuestionReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */