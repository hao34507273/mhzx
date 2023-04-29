/*    */ package mzm.gsp.activitycompensate;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ public class SActivityCompensateNormalResult
/*    */   extends __SActivityCompensateNormalResult__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12627457;
/*    */   public static final int GET_AWARD__INVALID_LEFT_TIMES = 1;
/*    */   public static final int GET_AWARD__LACK_GOLD = 2;
/*    */   public static final int GET_AWARD__LACK_YUANBAO = 3;
/*    */   public static final int GET_AWARD__NO_LEFT_TIMES = 4;
/*    */   public static final int GET_AWARD__ACTIVITY_CLOSED = 5;
/*    */   public static final int GET_ALL_AWARD__LACK_GOLD = 21;
/*    */   public static final int GET_ALL_AWARD__LACK_YUANBAO = 22;
/*    */   public static final int GET_ALL_AWARD__NO_AWARD = 23;
/*    */   public int result;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12627457;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SActivityCompensateNormalResult() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SActivityCompensateNormalResult(int _result_)
/*    */   {
/* 43 */     this.result = _result_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.result);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.result = _os_.unmarshal_int();
/* 57 */     if (!_validator_()) {
/* 58 */       throw new VerifyError("validator failed");
/*    */     }
/* 60 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 64 */     if (_o1_ == this) return true;
/* 65 */     if ((_o1_ instanceof SActivityCompensateNormalResult)) {
/* 66 */       SActivityCompensateNormalResult _o_ = (SActivityCompensateNormalResult)_o1_;
/* 67 */       if (this.result != _o_.result) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += this.result;
/* 76 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 80 */     StringBuilder _sb_ = new StringBuilder();
/* 81 */     _sb_.append("(");
/* 82 */     _sb_.append(this.result).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SActivityCompensateNormalResult _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = this.result - _o_.result;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activitycompensate\SActivityCompensateNormalResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */