/*    */ package mzm.gsp.questionvoice;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SGetQuestionVoiceSuccessRes
/*    */   extends __SGetQuestionVoiceSuccessRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12620804;
/*    */   public int activity_id;
/*    */   public int question_id;
/*    */   public ArrayList<String> answer_list;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12620804;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SGetQuestionVoiceSuccessRes()
/*    */   {
/* 35 */     this.answer_list = new ArrayList();
/*    */   }
/*    */   
/*    */   public SGetQuestionVoiceSuccessRes(int _activity_id_, int _question_id_, ArrayList<String> _answer_list_) {
/* 39 */     this.activity_id = _activity_id_;
/* 40 */     this.question_id = _question_id_;
/* 41 */     this.answer_list = _answer_list_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.activity_id);
/* 50 */     _os_.marshal(this.question_id);
/* 51 */     _os_.compact_uint32(this.answer_list.size());
/* 52 */     for (String _v_ : this.answer_list) {
/* 53 */       _os_.marshal(_v_, "UTF-16LE");
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 59 */     this.activity_id = _os_.unmarshal_int();
/* 60 */     this.question_id = _os_.unmarshal_int();
/* 61 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 63 */       String _v_ = _os_.unmarshal_String("UTF-16LE");
/* 64 */       this.answer_list.add(_v_);
/*    */     }
/* 66 */     if (!_validator_()) {
/* 67 */       throw new VerifyError("validator failed");
/*    */     }
/* 69 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 73 */     if (_o1_ == this) return true;
/* 74 */     if ((_o1_ instanceof SGetQuestionVoiceSuccessRes)) {
/* 75 */       SGetQuestionVoiceSuccessRes _o_ = (SGetQuestionVoiceSuccessRes)_o1_;
/* 76 */       if (this.activity_id != _o_.activity_id) return false;
/* 77 */       if (this.question_id != _o_.question_id) return false;
/* 78 */       if (!this.answer_list.equals(_o_.answer_list)) return false;
/* 79 */       return true;
/*    */     }
/* 81 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 85 */     int _h_ = 0;
/* 86 */     _h_ += this.activity_id;
/* 87 */     _h_ += this.question_id;
/* 88 */     _h_ += this.answer_list.hashCode();
/* 89 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 93 */     StringBuilder _sb_ = new StringBuilder();
/* 94 */     _sb_.append("(");
/* 95 */     _sb_.append(this.activity_id).append(",");
/* 96 */     _sb_.append(this.question_id).append(",");
/* 97 */     _sb_.append(this.answer_list).append(",");
/* 98 */     _sb_.append(")");
/* 99 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\questionvoice\SGetQuestionVoiceSuccessRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */