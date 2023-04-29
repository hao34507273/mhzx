/*    */ package hub;
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
/*    */   public static final int ERROR_NETWORK_TIMEOUT = 1;
/*    */   public static final int ERROR_OTHERS = 2;
/*    */   public static final int ERROR_ARGS_INVALID = 3;
/*    */   public static final int ERROR_ACCOUNT_INVALID = 4;
/*    */   public static final int ERROR_TOKEN_INVALID = 5;
/*    */   public static final int ERROR_XDB_STORE = 6;
/*    */   public static final int ERROR_REDIS_LOCK = 7;
/*    */   public static final int ERROR_REDIS_STORE = 8;
/*    */   public static final int ERROR_XIO_INVALID = 11;
/*    */   public static final int ERROR_GS_ZONEID_INVALID = 12;
/*    */   public static final int ERROR_GS_MULTIP_REGISTER = 13;
/*    */   public static final int ERROR_DS_ZONEID_INVALID = 14;
/*    */   public static final int ERROR_DS_MULTIP_REGISTER = 15;
/*    */   public static final int ERROR_MS_ID_INVALID = 16;
/*    */   public static final int ERROR_MS_MULTIP_REGISTER = 17;
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
/* 46 */     if ((_o1_ instanceof ErrorCodes)) {
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
/*    */   public int compareTo(ErrorCodes _o_) {
/* 65 */     if (_o_ == this) return 0;
/* 66 */     int _c_ = 0;
/* 67 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\ErrorCodes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */