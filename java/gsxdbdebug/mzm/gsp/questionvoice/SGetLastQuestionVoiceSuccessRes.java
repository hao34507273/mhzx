/*    */ package mzm.gsp.questionvoice;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SGetLastQuestionVoiceSuccessRes
/*    */   extends __SGetLastQuestionVoiceSuccessRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12620808;
/*    */   public int activity_id;
/*    */   public int question_id;
/*    */   public String answer;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12620808;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SGetLastQuestionVoiceSuccessRes()
/*    */   {
/* 35 */     this.answer = "";
/*    */   }
/*    */   
/*    */   public SGetLastQuestionVoiceSuccessRes(int _activity_id_, int _question_id_, String _answer_) {
/* 39 */     this.activity_id = _activity_id_;
/* 40 */     this.question_id = _question_id_;
/* 41 */     this.answer = _answer_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.activity_id);
/* 50 */     _os_.marshal(this.question_id);
/* 51 */     _os_.marshal(this.answer, "UTF-16LE");
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.activity_id = _os_.unmarshal_int();
/* 57 */     this.question_id = _os_.unmarshal_int();
/* 58 */     this.answer = _os_.unmarshal_String("UTF-16LE");
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof SGetLastQuestionVoiceSuccessRes)) {
/* 68 */       SGetLastQuestionVoiceSuccessRes _o_ = (SGetLastQuestionVoiceSuccessRes)_o1_;
/* 69 */       if (this.activity_id != _o_.activity_id) return false;
/* 70 */       if (this.question_id != _o_.question_id) return false;
/* 71 */       if (!this.answer.equals(_o_.answer)) return false;
/* 72 */       return true;
/*    */     }
/* 74 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 78 */     int _h_ = 0;
/* 79 */     _h_ += this.activity_id;
/* 80 */     _h_ += this.question_id;
/* 81 */     _h_ += this.answer.hashCode();
/* 82 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 86 */     StringBuilder _sb_ = new StringBuilder();
/* 87 */     _sb_.append("(");
/* 88 */     _sb_.append(this.activity_id).append(",");
/* 89 */     _sb_.append(this.question_id).append(",");
/* 90 */     _sb_.append("T").append(this.answer.length()).append(",");
/* 91 */     _sb_.append(")");
/* 92 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\questionvoice\SGetLastQuestionVoiceSuccessRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */