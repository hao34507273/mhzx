/*    */ package mzm.gsp.moneytree;
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
/*    */ public class SAttendMoneyTreeFail
/*    */   extends __SAttendMoneyTreeFail__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12611331;
/*    */   public static final int MODULE_CLOSE_OR_ROLE_FORBIDDEN = -1;
/*    */   public static final int ROLE_STATUS_ERROR = -2;
/*    */   public static final int CHECK_NPC_SERVICE_ERROR = -3;
/*    */   public static final int CAN_NOT_JOIN_ACTIVITY = 1;
/*    */   public static final int AWARD_FAIL = 2;
/*    */   public int res;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12611331;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SAttendMoneyTreeFail() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SAttendMoneyTreeFail(int _res_)
/*    */   {
/* 42 */     this.res = _res_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.res);
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 55 */     this.res = _os_.unmarshal_int();
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof SAttendMoneyTreeFail)) {
/* 65 */       SAttendMoneyTreeFail _o_ = (SAttendMoneyTreeFail)_o1_;
/* 66 */       if (this.res != _o_.res) return false;
/* 67 */       return true;
/*    */     }
/* 69 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 73 */     int _h_ = 0;
/* 74 */     _h_ += this.res;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.res).append(",");
/* 82 */     _sb_.append(")");
/* 83 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SAttendMoneyTreeFail _o_) {
/* 87 */     if (_o_ == this) return 0;
/* 88 */     int _c_ = 0;
/* 89 */     _c_ = this.res - _o_.res;
/* 90 */     if (0 != _c_) return _c_;
/* 91 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\moneytree\SAttendMoneyTreeFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */