/*    */ package openau;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ErrorCodes
/*    */   implements Marshal, Comparable<ErrorCodes>
/*    */ {
/*    */   public static final int ERROR_SUCCEED = 0;
/*    */   public static final int ERROR_INVALID = 1;
/*    */   public static final int ERROR_PLAT_ARGS = 2;
/*    */   public static final int ERROR_PLAT_TRANS = 3;
/*    */   public static final int ERROR_XDB_STORE = 4;
/*    */   public static final int ERROR_INVALID_ACCOUNT = 5;
/*    */   public static final int ERROR_INVALID_PASSWORD = 6;
/*    */   public static final int ERROR_SDK_BUSY = 7;
/*    */   public static final int ERROR_NETWORK_TIMEOUT = 8;
/*    */   public static final int ERROR_OTHERS = 9;
/*    */   public static final int ERROR_APPID_INVALID = 10;
/*    */   public static final int ERROR_ORDER_INVALID = 11;
/*    */   public static final int ERROR_ORDER_STATUS_INVALID = 12;
/*    */   public static final int ERROR_ORDER_INFO_INVALID = 13;
/*    */   public static final int ERROR_TENCENT_TOKEN_INVALID = 14;
/*    */   public static final int ERROR_TENCENT_PAY_FAILED_AND_DELTE_UNISDK_ORDER_INFO = 15;
/*    */   public static final int ERROR_TENCENT_GET_BALANCE_FAILED = 16;
/*    */   public static final int ERROR_TENCENT_PAY_FAILED = 17;
/*    */   public static final int ERROR_TENCENT_ORDER_PENDING = 18;
/*    */   public static final int ERROR_ZONE_ID_NOT_MATCH = 19;
/*    */   public static final int ERROR_SN_NOT_MATCH = 20;
/*    */   public static final int ERROR_USER_NOT_FOUND = 1000;
/*    */   public static final int ERROR_CHECK_STATUS_INVALID = 1001;
/*    */   public static final int ERROR_BILLNO_DUPLICATE = 1002;
/*    */   public static final int ERROR_BALANCE_NOT_ENOUGH = 1003;
/*    */   public static final int ERROR_BAN_LOGIN = 1004;
/*    */   public static final int ERROR_SKIP_SANDBOX_ORDER = 65536;
/*    */   
/*    */   public final boolean _validator_()
/*    */   {
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 56 */     if (_o1_ == this) return true;
/* 57 */     if ((_o1_ instanceof ErrorCodes)) {
/* 58 */       return true;
/*    */     }
/* 60 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 64 */     int _h_ = 0;
/* 65 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 69 */     StringBuilder _sb_ = new StringBuilder();
/* 70 */     _sb_.append("(");
/* 71 */     _sb_.append(")");
/* 72 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(ErrorCodes _o_) {
/* 76 */     if (_o_ == this) return 0;
/* 77 */     int _c_ = 0;
/* 78 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\openau\ErrorCodes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */