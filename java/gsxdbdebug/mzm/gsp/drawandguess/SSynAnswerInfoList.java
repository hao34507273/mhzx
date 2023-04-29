/*    */ package mzm.gsp.drawandguess;
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
/*    */ 
/*    */ 
/*    */ public class SSynAnswerInfoList
/*    */   extends __SSynAnswerInfoList__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12617252;
/*    */   public ArrayList<AnswerInfo> answerinfo_list;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12617252;
/*    */   }
/*    */   
/*    */ 
/*    */   public SSynAnswerInfoList()
/*    */   {
/* 33 */     this.answerinfo_list = new ArrayList();
/*    */   }
/*    */   
/*    */   public SSynAnswerInfoList(ArrayList<AnswerInfo> _answerinfo_list_) {
/* 37 */     this.answerinfo_list = _answerinfo_list_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     for (AnswerInfo _v_ : this.answerinfo_list)
/* 42 */       if (!_v_._validator_()) return false;
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.compact_uint32(this.answerinfo_list.size());
/* 48 */     for (AnswerInfo _v_ : this.answerinfo_list) {
/* 49 */       _os_.marshal(_v_);
/*    */     }
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 55 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 56 */       AnswerInfo _v_ = new AnswerInfo();
/* 57 */       _v_.unmarshal(_os_);
/* 58 */       this.answerinfo_list.add(_v_);
/*    */     }
/* 60 */     if (!_validator_()) {
/* 61 */       throw new VerifyError("validator failed");
/*    */     }
/* 63 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 67 */     if (_o1_ == this) return true;
/* 68 */     if ((_o1_ instanceof SSynAnswerInfoList)) {
/* 69 */       SSynAnswerInfoList _o_ = (SSynAnswerInfoList)_o1_;
/* 70 */       if (!this.answerinfo_list.equals(_o_.answerinfo_list)) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += this.answerinfo_list.hashCode();
/* 79 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 83 */     StringBuilder _sb_ = new StringBuilder();
/* 84 */     _sb_.append("(");
/* 85 */     _sb_.append(this.answerinfo_list).append(",");
/* 86 */     _sb_.append(")");
/* 87 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\drawandguess\SSynAnswerInfoList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */