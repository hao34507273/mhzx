/*    */ package mzm.gsp.changemodelcard;
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
/*    */ public class SCardDecomposeFail
/*    */   extends __SCardDecomposeFail__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12624403;
/*    */   public static final int ROLE_LEVEL_NOT_ENOUGH = -1;
/*    */   public static final int CARD_NOT_EXIST = -2;
/*    */   public static final int ADD_SCORE_FAIL = -3;
/*    */   public int error_code;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12624403;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SCardDecomposeFail() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SCardDecomposeFail(int _error_code_)
/*    */   {
/* 40 */     this.error_code = _error_code_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.error_code);
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 53 */     this.error_code = _os_.unmarshal_int();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SCardDecomposeFail)) {
/* 63 */       SCardDecomposeFail _o_ = (SCardDecomposeFail)_o1_;
/* 64 */       if (this.error_code != _o_.error_code) return false;
/* 65 */       return true;
/*    */     }
/* 67 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 71 */     int _h_ = 0;
/* 72 */     _h_ += this.error_code;
/* 73 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 77 */     StringBuilder _sb_ = new StringBuilder();
/* 78 */     _sb_.append("(");
/* 79 */     _sb_.append(this.error_code).append(",");
/* 80 */     _sb_.append(")");
/* 81 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SCardDecomposeFail _o_) {
/* 85 */     if (_o_ == this) return 0;
/* 86 */     int _c_ = 0;
/* 87 */     _c_ = this.error_code - _o_.error_code;
/* 88 */     if (0 != _c_) return _c_;
/* 89 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\changemodelcard\SCardDecomposeFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */