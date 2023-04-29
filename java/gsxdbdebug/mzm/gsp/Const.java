/*    */ package mzm.gsp;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Const
/*    */   implements Marshal, Comparable<Const>
/*    */ {
/*    */   public static final int ERR_GM_KICKOUT = 2049;
/*    */   public static final int ERR_MAX_ACCOUNT_KICKOUT = 2050;
/*    */   public static final int ERR_MAX_LOAD_NUM_KICKOUT = 2051;
/*    */   public static final int AQIDIP_UPDATE_CASH = 2052;
/*    */   public static final int ERR_SERVER_SHUTDOWN = 2053;
/*    */   public static final int ERR_LONG_IN_MAXTIME = 2054;
/*    */   public static final int ERR_FORCE_KICKOUT = 2055;
/*    */   public static final int ERR_CROSS_SERVER_FORCE_KICKOUT = 2056;
/*    */   public static final int ERR_RETURN_ORIGINAL_SERVER_FORCE_KICKOUT = 2057;
/*    */   public static final int ERR_ADDICTION = 2058;
/*    */   public static final int ERR_FORCE_RECONNECT = 2059;
/*    */   public static final int ERR_BAN_LOGIN = 8013;
/*    */   
/*    */   public final boolean _validator_()
/*    */   {
/* 27 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 31 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 35 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 39 */     if (_o1_ == this) return true;
/* 40 */     if ((_o1_ instanceof Const)) {
/* 41 */       return true;
/*    */     }
/* 43 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 47 */     int _h_ = 0;
/* 48 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 52 */     StringBuilder _sb_ = new StringBuilder();
/* 53 */     _sb_.append("(");
/* 54 */     _sb_.append(")");
/* 55 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(Const _o_) {
/* 59 */     if (_o_ == this) return 0;
/* 60 */     int _c_ = 0;
/* 61 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\Const.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */