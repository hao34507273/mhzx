/*    */ package mzm.gsp.axe;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class SAttendAxeActivityFail extends __SAttendAxeActivityFail__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12614914;
/*    */   public static final int MODULE_CLOSE_OR_ROLE_FORBIDDEN = -1;
/*    */   public static final int ROLE_STATUS_ERROR = -2;
/*    */   public static final int PARAM_ERROR = -3;
/*    */   public static final int YUAN_BAO_NUM_ERROR = -4;
/*    */   public static final int CAN_NOT_JOIN_ACTIVITY = 1;
/*    */   public static final int ITEM_NOT_ENOUGH = 2;
/*    */   public static final int YUANBAO_NOT_ENOUGH = 3;
/*    */   public static final int ADD_LOTTERY_FAIL = 4;
/*    */   public static final int GRID_NOT_ENOUGH = 5;
/*    */   public static final int ACTIVITY_IS_LOCKED = 6;
/*    */   public static final int GOLD_NOT_ENOUGH = 7;
/*    */   public static final int SILVER_NOT_ENOUGH = 8;
/*    */   public int res;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12614914;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SAttendAxeActivityFail() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SAttendAxeActivityFail(int _res_)
/*    */   {
/* 49 */     this.res = _res_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 53 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 57 */     _os_.marshal(this.res);
/* 58 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 62 */     this.res = _os_.unmarshal_int();
/* 63 */     if (!_validator_()) {
/* 64 */       throw new VerifyError("validator failed");
/*    */     }
/* 66 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 70 */     if (_o1_ == this) return true;
/* 71 */     if ((_o1_ instanceof SAttendAxeActivityFail)) {
/* 72 */       SAttendAxeActivityFail _o_ = (SAttendAxeActivityFail)_o1_;
/* 73 */       if (this.res != _o_.res) return false;
/* 74 */       return true;
/*    */     }
/* 76 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 80 */     int _h_ = 0;
/* 81 */     _h_ += this.res;
/* 82 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 86 */     StringBuilder _sb_ = new StringBuilder();
/* 87 */     _sb_.append("(");
/* 88 */     _sb_.append(this.res).append(",");
/* 89 */     _sb_.append(")");
/* 90 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SAttendAxeActivityFail _o_) {
/* 94 */     if (_o_ == this) return 0;
/* 95 */     int _c_ = 0;
/* 96 */     _c_ = this.res - _o_.res;
/* 97 */     if (0 != _c_) return _c_;
/* 98 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\axe\SAttendAxeActivityFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */