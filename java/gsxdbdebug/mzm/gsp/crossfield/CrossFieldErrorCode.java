/*    */ package mzm.gsp.crossfield;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CrossFieldErrorCode
/*    */   implements Marshal, Comparable<CrossFieldErrorCode>
/*    */ {
/*    */   public static final int MODULE_CLOSE_OR_ROLE_FORBIDDEN = -1;
/*    */   public static final int ROLE_STATUS_ERROR = -2;
/*    */   public static final int PARAM_ERROR = -3;
/*    */   public static final int CHECK_NPC_SERVICE_ERROR = -4;
/*    */   public static final int DB_ERROR = -5;
/*    */   public static final int CANNOT_JOIN_ACTIVITY = 1;
/*    */   public static final int IN_TEAM = 2;
/*    */   public static final int ALREADY_JOIN_MATCH = 3;
/*    */   public static final int UNKNOWM_ERROR = 4;
/*    */   public static final int IS_NOT_MATCHING = 5;
/*    */   public static final int IS_CANCELIND_MATCH = 6;
/*    */   public static final int FORBID_MATCH = 7;
/*    */   public static final int NO_ACTIVE_SEASON = 8;
/*    */   public static final int COMMUNICATION_ERROR = 9;
/*    */   public static final int ALREADY_AWARDED = 10;
/*    */   public static final int AWARD_FAIL = 11;
/*    */   
/*    */   public final boolean _validator_()
/*    */   {
/* 33 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 37 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 41 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 45 */     if (_o1_ == this) return true;
/* 46 */     if ((_o1_ instanceof CrossFieldErrorCode)) {
/* 47 */       return true;
/*    */     }
/* 49 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 53 */     int _h_ = 0;
/* 54 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 58 */     StringBuilder _sb_ = new StringBuilder();
/* 59 */     _sb_.append("(");
/* 60 */     _sb_.append(")");
/* 61 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CrossFieldErrorCode _o_) {
/* 65 */     if (_o_ == this) return 0;
/* 66 */     int _c_ = 0;
/* 67 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossfield\CrossFieldErrorCode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */