/*    */ package mzm.gsp.homeland;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class SAttendMysteryVisitorFail extends __SAttendMysteryVisitorFail__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12605506;
/*    */   public static final int MODULE_CLOSE_OR_ROLE_FORBIDDEN = -1;
/*    */   public static final int ROLE_STATUS_ERROR = -2;
/*    */   public static final int CHECK_NPC_SERVICE_ERROR = -3;
/*    */   public static final int PARAM_ERROR = -4;
/*    */   public static final int CAN_NOT_JOIN_ACTIVITY = 1;
/*    */   public static final int AWARD_FAIL = 2;
/*    */   public static final int NOT_SET_MYSTERY_VISITOR_CFG_ID = 3;
/*    */   public static final int DO_NOT_HAVE_COURTYARD = 4;
/*    */   public static final int MARRIAGE_STATE_CHANGED = 5;
/*    */   public static final int ALREADY_SET_MYSTERY_VISITOR_CFG_ID = 6;
/*    */   public static final int SEND_MAIL_FAIL = 7;
/*    */   public static final int HAVE_COURTYARD = 8;
/*    */   public static final int IS_TASK_TYPE = 9;
/*    */   public int res;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12605506;
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
/*    */   public SAttendMysteryVisitorFail() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SAttendMysteryVisitorFail(int _res_)
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
/* 72 */     if ((_o1_ instanceof SAttendMysteryVisitorFail)) {
/* 73 */       SAttendMysteryVisitorFail _o_ = (SAttendMysteryVisitorFail)_o1_;
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
/*    */   public int compareTo(SAttendMysteryVisitorFail _o_) {
/* 95 */     if (_o_ == this) return 0;
/* 96 */     int _c_ = 0;
/* 97 */     _c_ = this.res - _o_.res;
/* 98 */     if (0 != _c_) return _c_;
/* 99 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\SAttendMysteryVisitorFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */