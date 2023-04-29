/*    */ package betacat;
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
/*    */   public static final int ERROR_ALREADY_CREATE_NODE_CONNECTOR = 2;
/*    */   public static final int ERROR_NODE_ALREADY_CONNECTED = 3;
/*    */   public static final int ERROR_NODE_ALREADY_REGISTERED = 4;
/*    */   public static final int ERROR_ZONEID_INVALID = 5;
/*    */   public static final int ERROR_ZONEID_ALREADY_REGISTED = 6;
/*    */   public static final int ERROR_NODEID_INVALID = 7;
/*    */   public static final int ERROR_NODE_ALREADY_REGISTED = 8;
/*    */   public static final int ERROR_ZONEID_NOT_MATCH_ANY_NODE = 9;
/*    */   public static final int ERROR_NODE_CANNOT_REACH = 10;
/*    */   public static final int ERROR_ZONE_NOT_MATCH_NODE = 11;
/*    */   public static final int ERROR_CAN_NOT_PROVIDE_SERVICE = 12;
/*    */   public static final int ERROR_REDIS_LOCK = 13;
/*    */   public static final int ERROR_ALREADY_JOIN_ROOM = 14;
/*    */   public static final int ERROR_NOT_JOIN_ROOM = 15;
/*    */   public static final int ERROR_OTHERS = 60;
/*    */   
/*    */   public final boolean _validator_()
/*    */   {
/* 34 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 38 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 42 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 46 */     if (_o1_ == this) return true;
/* 47 */     if ((_o1_ instanceof ErrorCodes)) {
/* 48 */       return true;
/*    */     }
/* 50 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 54 */     int _h_ = 0;
/* 55 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 59 */     StringBuilder _sb_ = new StringBuilder();
/* 60 */     _sb_.append("(");
/* 61 */     _sb_.append(")");
/* 62 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(ErrorCodes _o_) {
/* 66 */     if (_o_ == this) return 0;
/* 67 */     int _c_ = 0;
/* 68 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\betacat\ErrorCodes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */