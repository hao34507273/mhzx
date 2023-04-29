/*    */ package mzm.gsp.planttree;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class SAddPointFail extends __SAddPointFail__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12611594;
/*    */   public static final int MODULE_CLOSE_OR_ROLE_FORBIDDEN = -1;
/*    */   public static final int ROLE_STATUS_ERROR = -2;
/*    */   public static final int PARAM_ERROR = -3;
/*    */   public static final int DB_ERROR = -4;
/*    */   public static final int CAN_NOT_JOIN_ACTIVITY = 1;
/*    */   public static final int ADD_POINT_TO_LIMIT = 2;
/*    */   public static final int ACTIVITY_POINT_FULL = 3;
/*    */   public static final int MONEY_NOT_MATCH = 4;
/*    */   public static final int MONEY_NOT_ENOUGH = 5;
/*    */   public static final int COST_MONEY_FAIL = 6;
/*    */   public static final int IN_SPECIAL_STATE = 7;
/*    */   public static final int DAILY_REWARD_POINT_TO_LIMIT = 8;
/*    */   public static final int NOT_ONLINE = 9;
/*    */   public int res;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12611594;
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
/*    */   public SAddPointFail() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SAddPointFail(int _res_)
/*    */   {
/* 50 */     this.res = _res_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 54 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 58 */     _os_.marshal(this.res);
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 63 */     this.res = _os_.unmarshal_int();
/* 64 */     if (!_validator_()) {
/* 65 */       throw new VerifyError("validator failed");
/*    */     }
/* 67 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 71 */     if (_o1_ == this) return true;
/* 72 */     if ((_o1_ instanceof SAddPointFail)) {
/* 73 */       SAddPointFail _o_ = (SAddPointFail)_o1_;
/* 74 */       if (this.res != _o_.res) return false;
/* 75 */       return true;
/*    */     }
/* 77 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 81 */     int _h_ = 0;
/* 82 */     _h_ += this.res;
/* 83 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 87 */     StringBuilder _sb_ = new StringBuilder();
/* 88 */     _sb_.append("(");
/* 89 */     _sb_.append(this.res).append(",");
/* 90 */     _sb_.append(")");
/* 91 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SAddPointFail _o_) {
/* 95 */     if (_o_ == this) return 0;
/* 96 */     int _c_ = 0;
/* 97 */     _c_ = this.res - _o_.res;
/* 98 */     if (0 != _c_) return _c_;
/* 99 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\planttree\SAddPointFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */