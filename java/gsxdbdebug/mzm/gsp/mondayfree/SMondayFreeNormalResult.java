/*    */ package mzm.gsp.mondayfree;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class SMondayFreeNormalResult
/*    */   extends __SMondayFreeNormalResult__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12626183;
/*    */   public static final int MondayFree__NOT_OPEN = 1;
/*    */   public static final int GetSundayAward__TIME_INVALID = 11;
/*    */   public static final int GetSundayAward__ALREADY = 12;
/*    */   public static final int GetMondayAward__TIME_INVALID = 21;
/*    */   public static final int GetMondayAward__ALREADY = 22;
/*    */   public static final int FinishShimen__TIME_INVALID = 31;
/*    */   public static final int FinishShimen__ALREADY = 32;
/*    */   public static final int FinishShimen__FAIL = 33;
/*    */   public static final int FinishBaotu__TIME_INVALID = 41;
/*    */   public static final int FinishBaotu__ALREADY = 42;
/*    */   public static final int FinishBaotu__FAIL = 43;
/*    */   public int result;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12626183;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SMondayFreeNormalResult() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SMondayFreeNormalResult(int _result_)
/*    */   {
/* 48 */     this.result = _result_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 52 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 56 */     _os_.marshal(this.result);
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 61 */     this.result = _os_.unmarshal_int();
/* 62 */     if (!_validator_()) {
/* 63 */       throw new VerifyError("validator failed");
/*    */     }
/* 65 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 69 */     if (_o1_ == this) return true;
/* 70 */     if ((_o1_ instanceof SMondayFreeNormalResult)) {
/* 71 */       SMondayFreeNormalResult _o_ = (SMondayFreeNormalResult)_o1_;
/* 72 */       if (this.result != _o_.result) return false;
/* 73 */       return true;
/*    */     }
/* 75 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 79 */     int _h_ = 0;
/* 80 */     _h_ += this.result;
/* 81 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 85 */     StringBuilder _sb_ = new StringBuilder();
/* 86 */     _sb_.append("(");
/* 87 */     _sb_.append(this.result).append(",");
/* 88 */     _sb_.append(")");
/* 89 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SMondayFreeNormalResult _o_) {
/* 93 */     if (_o_ == this) return 0;
/* 94 */     int _c_ = 0;
/* 95 */     _c_ = this.result - _o_.result;
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mondayfree\SMondayFreeNormalResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */