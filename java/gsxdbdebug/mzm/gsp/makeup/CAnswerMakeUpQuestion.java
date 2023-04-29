/*    */ package mzm.gsp.makeup;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.makeup.main.PCAnswerMakeUpQuestion;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CAnswerMakeUpQuestion
/*    */   extends __CAnswerMakeUpQuestion__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12625922;
/*    */   public int activityid;
/*    */   public int optionid;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     if (roleId < 0L)
/*    */     {
/* 22 */       return;
/*    */     }
/* 24 */     Role.addRoleProcedure(roleId, new PCAnswerMakeUpQuestion(roleId, this.activityid, this.optionid));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 32 */     return 12625922;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CAnswerMakeUpQuestion() {}
/*    */   
/*    */ 
/*    */   public CAnswerMakeUpQuestion(int _activityid_, int _optionid_)
/*    */   {
/* 42 */     this.activityid = _activityid_;
/* 43 */     this.optionid = _optionid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.activityid);
/* 52 */     _os_.marshal(this.optionid);
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     this.activityid = _os_.unmarshal_int();
/* 58 */     this.optionid = _os_.unmarshal_int();
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof CAnswerMakeUpQuestion)) {
/* 68 */       CAnswerMakeUpQuestion _o_ = (CAnswerMakeUpQuestion)_o1_;
/* 69 */       if (this.activityid != _o_.activityid) return false;
/* 70 */       if (this.optionid != _o_.optionid) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += this.activityid;
/* 79 */     _h_ += this.optionid;
/* 80 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 84 */     StringBuilder _sb_ = new StringBuilder();
/* 85 */     _sb_.append("(");
/* 86 */     _sb_.append(this.activityid).append(",");
/* 87 */     _sb_.append(this.optionid).append(",");
/* 88 */     _sb_.append(")");
/* 89 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CAnswerMakeUpQuestion _o_) {
/* 93 */     if (_o_ == this) return 0;
/* 94 */     int _c_ = 0;
/* 95 */     _c_ = this.activityid - _o_.activityid;
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     _c_ = this.optionid - _o_.optionid;
/* 98 */     if (0 != _c_) return _c_;
/* 99 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\makeup\CAnswerMakeUpQuestion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */