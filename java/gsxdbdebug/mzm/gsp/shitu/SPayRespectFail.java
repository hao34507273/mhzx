/*    */ package mzm.gsp.shitu;
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
/*    */ public class SPayRespectFail
/*    */   extends __SPayRespectFail__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12601630;
/*    */   public static final int NO_RESPECT_TIMES_LEFT = 1;
/*    */   public static final int WAIT_FOR_MASTER = 2;
/*    */   public static final int MASTER_NOT_ONLINE = 3;
/*    */   public static final int MASTER_IS_IN_PAY_RESPECT = 4;
/*    */   public static final int APPRENTICE_NOT_ONLINE = 5;
/*    */   public int result;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12601630;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SPayRespectFail() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SPayRespectFail(int _result_)
/*    */   {
/* 42 */     this.result = _result_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.result);
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 55 */     this.result = _os_.unmarshal_int();
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof SPayRespectFail)) {
/* 65 */       SPayRespectFail _o_ = (SPayRespectFail)_o1_;
/* 66 */       if (this.result != _o_.result) return false;
/* 67 */       return true;
/*    */     }
/* 69 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 73 */     int _h_ = 0;
/* 74 */     _h_ += this.result;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.result).append(",");
/* 82 */     _sb_.append(")");
/* 83 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SPayRespectFail _o_) {
/* 87 */     if (_o_ == this) return 0;
/* 88 */     int _c_ = 0;
/* 89 */     _c_ = this.result - _o_.result;
/* 90 */     if (0 != _c_) return _c_;
/* 91 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\SPayRespectFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */