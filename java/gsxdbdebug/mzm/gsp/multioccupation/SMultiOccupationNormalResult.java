/*    */ package mzm.gsp.multioccupation;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SMultiOccupationNormalResult
/*    */   extends __SMultiOccupationNormalResult__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12606983;
/*    */   public static final int ACTIVATE__LEVEL_LIMIT = 1;
/*    */   public static final int ACTIVATE__LACK_YUANBAO = 2;
/*    */   public static final int ACTIVATE__IN_TEAM = 3;
/*    */   public static final int ACTIVATE__COOL_DOWN = 4;
/*    */   public static final int ACTIVATE__LACK_GOLD = 5;
/*    */   public static final int SWITCH__LACK_GOLD = 11;
/*    */   public static final int SWITCH__IN_TEAM = 12;
/*    */   public static final int SWITCH__COOL_DOWN = 13;
/*    */   public int result;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12606983;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SMultiOccupationNormalResult() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SMultiOccupationNormalResult(int _result_)
/*    */   {
/* 45 */     this.result = _result_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 49 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 53 */     _os_.marshal(this.result);
/* 54 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 58 */     this.result = _os_.unmarshal_int();
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof SMultiOccupationNormalResult)) {
/* 68 */       SMultiOccupationNormalResult _o_ = (SMultiOccupationNormalResult)_o1_;
/* 69 */       if (this.result != _o_.result) return false;
/* 70 */       return true;
/*    */     }
/* 72 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 76 */     int _h_ = 0;
/* 77 */     _h_ += this.result;
/* 78 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 82 */     StringBuilder _sb_ = new StringBuilder();
/* 83 */     _sb_.append("(");
/* 84 */     _sb_.append(this.result).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SMultiOccupationNormalResult _o_) {
/* 90 */     if (_o_ == this) return 0;
/* 91 */     int _c_ = 0;
/* 92 */     _c_ = this.result - _o_.result;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\multioccupation\SMultiOccupationNormalResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */