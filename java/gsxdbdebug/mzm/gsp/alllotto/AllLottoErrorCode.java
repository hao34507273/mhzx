/*    */ package mzm.gsp.alllotto;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AllLottoErrorCode
/*    */   implements Marshal, Comparable<AllLottoErrorCode>
/*    */ {
/*    */   public static final int MODULE_CLOSE_OR_ROLE_FORBIDDEN = -1;
/*    */   public static final int ROLE_STATUS_ERROR = -2;
/*    */   public static final int PARAM_ERROR = -3;
/*    */   public static final int CHECK_NPC_SERVICE_ERROR = -4;
/*    */   public static final int DB_ERROR = -5;
/*    */   public static final int SERVER_LEVEL_NOT_ENOUGH = -6;
/*    */   public static final int NO_ONLINE_ROLE = -7;
/*    */   public static final int NO_CANDIDATE = -8;
/*    */   public static final int ALREADY_GOT_AWARD_ROLE_INFO = -9;
/*    */   public static final int AWARD_STATE_ERROR = -10;
/*    */   public static final int CANNOT_JOIN_ACTIVITY = 1;
/*    */   public static final int NOT_IN_AWARD_TIME = 2;
/*    */   public static final int ALREADY_GOT_AWARD = 3;
/*    */   public static final int AWARD_FAIL = 4;
/*    */   
/*    */   public final boolean _validator_()
/*    */   {
/* 31 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 35 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 39 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 43 */     if (_o1_ == this) return true;
/* 44 */     if ((_o1_ instanceof AllLottoErrorCode)) {
/* 45 */       return true;
/*    */     }
/* 47 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 51 */     int _h_ = 0;
/* 52 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 56 */     StringBuilder _sb_ = new StringBuilder();
/* 57 */     _sb_.append("(");
/* 58 */     _sb_.append(")");
/* 59 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(AllLottoErrorCode _o_) {
/* 63 */     if (_o_ == this) return 0;
/* 64 */     int _c_ = 0;
/* 65 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\alllotto\AllLottoErrorCode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */