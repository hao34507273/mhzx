/*    */ package mzm.gsp.crossbattle;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CrossBattleBetErrorCode
/*    */   implements Marshal, Comparable<CrossBattleBetErrorCode>
/*    */ {
/*    */   public static final int MODULE_CLOSE_OR_ROLE_FORBIDDEN = -1;
/*    */   public static final int ROLE_STATUS_ERROR = -2;
/*    */   public static final int PARAM_ERROR = -3;
/*    */   public static final int CHECK_NPC_SERVICE_ERROR = -4;
/*    */   public static final int DB_ERROR = -5;
/*    */   public static final int ACTIVITY_NOT_OPEN = 1;
/*    */   public static final int ACTIVITY_STAGE_ERROR = 2;
/*    */   public static final int FIGHT_END = 3;
/*    */   public static final int FIGHT_NOT_EXIST = 4;
/*    */   public static final int FIGHT_NOT_END = 5;
/*    */   public static final int NOT_BET = 6;
/*    */   public static final int HAS_GOT_MAIL = 7;
/*    */   public static final int SEND_MAIL_FAIL = 8;
/*    */   public static final int STAGE_NOT_END = 9;
/*    */   public static final int COMMUNICATION_ERROR = 10;
/*    */   public static final int GET_STAGE_DATA_FAIL = 11;
/*    */   public static final int GET_STAGE_BET_DATA_FAIL = 12;
/*    */   public static final int ALREADY_AWARDED = 13;
/*    */   
/*    */   public final boolean _validator_()
/*    */   {
/* 35 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 39 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 43 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 47 */     if (_o1_ == this) return true;
/* 48 */     if ((_o1_ instanceof CrossBattleBetErrorCode)) {
/* 49 */       return true;
/*    */     }
/* 51 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 55 */     int _h_ = 0;
/* 56 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 60 */     StringBuilder _sb_ = new StringBuilder();
/* 61 */     _sb_.append("(");
/* 62 */     _sb_.append(")");
/* 63 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CrossBattleBetErrorCode _o_) {
/* 67 */     if (_o_ == this) return 0;
/* 68 */     int _c_ = 0;
/* 69 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\CrossBattleBetErrorCode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */