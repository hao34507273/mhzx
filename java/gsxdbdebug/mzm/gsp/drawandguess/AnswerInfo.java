/*    */ package mzm.gsp.drawandguess;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class AnswerInfo implements Marshal
/*    */ {
/*    */   public long member_roleid;
/*    */   public String answer;
/*    */   public int result;
/*    */   
/*    */   public AnswerInfo()
/*    */   {
/* 14 */     this.answer = "";
/*    */   }
/*    */   
/*    */   public AnswerInfo(long _member_roleid_, String _answer_, int _result_) {
/* 18 */     this.member_roleid = _member_roleid_;
/* 19 */     this.answer = _answer_;
/* 20 */     this.result = _result_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 24 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 28 */     _os_.marshal(this.member_roleid);
/* 29 */     _os_.marshal(this.answer, "UTF-16LE");
/* 30 */     _os_.marshal(this.result);
/* 31 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 35 */     this.member_roleid = _os_.unmarshal_long();
/* 36 */     this.answer = _os_.unmarshal_String("UTF-16LE");
/* 37 */     this.result = _os_.unmarshal_int();
/* 38 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 42 */     if (_o1_ == this) return true;
/* 43 */     if ((_o1_ instanceof AnswerInfo)) {
/* 44 */       AnswerInfo _o_ = (AnswerInfo)_o1_;
/* 45 */       if (this.member_roleid != _o_.member_roleid) return false;
/* 46 */       if (!this.answer.equals(_o_.answer)) return false;
/* 47 */       if (this.result != _o_.result) return false;
/* 48 */       return true;
/*    */     }
/* 50 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 54 */     int _h_ = 0;
/* 55 */     _h_ += (int)this.member_roleid;
/* 56 */     _h_ += this.answer.hashCode();
/* 57 */     _h_ += this.result;
/* 58 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 62 */     StringBuilder _sb_ = new StringBuilder();
/* 63 */     _sb_.append("(");
/* 64 */     _sb_.append(this.member_roleid).append(",");
/* 65 */     _sb_.append("T").append(this.answer.length()).append(",");
/* 66 */     _sb_.append(this.result).append(",");
/* 67 */     _sb_.append(")");
/* 68 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\drawandguess\AnswerInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */