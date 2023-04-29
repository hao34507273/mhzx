/*    */ package mzm.gsp.drawandguess;
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
/*    */ 
/*    */ 
/*    */ public class SSynAnswerDrawAndGuessFinished
/*    */   extends __SSynAnswerDrawAndGuessFinished__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12617257;
/*    */   public String rightanswer;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12617257;
/*    */   }
/*    */   
/*    */ 
/*    */   public SSynAnswerDrawAndGuessFinished()
/*    */   {
/* 33 */     this.rightanswer = "";
/*    */   }
/*    */   
/*    */   public SSynAnswerDrawAndGuessFinished(String _rightanswer_) {
/* 37 */     this.rightanswer = _rightanswer_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 45 */     _os_.marshal(this.rightanswer, "UTF-16LE");
/* 46 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 50 */     this.rightanswer = _os_.unmarshal_String("UTF-16LE");
/* 51 */     if (!_validator_()) {
/* 52 */       throw new VerifyError("validator failed");
/*    */     }
/* 54 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 58 */     if (_o1_ == this) return true;
/* 59 */     if ((_o1_ instanceof SSynAnswerDrawAndGuessFinished)) {
/* 60 */       SSynAnswerDrawAndGuessFinished _o_ = (SSynAnswerDrawAndGuessFinished)_o1_;
/* 61 */       if (!this.rightanswer.equals(_o_.rightanswer)) return false;
/* 62 */       return true;
/*    */     }
/* 64 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 68 */     int _h_ = 0;
/* 69 */     _h_ += this.rightanswer.hashCode();
/* 70 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 74 */     StringBuilder _sb_ = new StringBuilder();
/* 75 */     _sb_.append("(");
/* 76 */     _sb_.append("T").append(this.rightanswer.length()).append(",");
/* 77 */     _sb_.append(")");
/* 78 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\drawandguess\SSynAnswerDrawAndGuessFinished.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */