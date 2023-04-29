/*    */ package mzm.gsp.indiana;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IndianaErrorCode
/*    */   implements Marshal, Comparable<IndianaErrorCode>
/*    */ {
/*    */   public static final int MODULE_CLOSE_OR_ROLE_FORBIDDEN = -1;
/*    */   public static final int ROLE_STATUS_ERROR = -2;
/*    */   public static final int PARAM_ERROR = -3;
/*    */   public static final int CHECK_NPC_SERVICE_ERROR = -4;
/*    */   public static final int DB_ERROR = -5;
/*    */   public static final int ALREADY_GET_AWARD_NUMBER = -6;
/*    */   public static final int AWARD_STATE_ERROR = -7;
/*    */   public static final int BRD_NUMBERS_EMPTY = -8;
/*    */   public static final int CANNOT_JOIN_ACTIVITY = 1;
/*    */   public static final int NOT_CURRENT_TURN = 2;
/*    */   public static final int ALREADY_ATTENDED = 3;
/*    */   public static final int ITEM_NUM_NOT_MATCH = 4;
/*    */   public static final int ITEM_PRICE_ERROR = 5;
/*    */   public static final int YUANBAO_NUM_NOT_MATCH = 6;
/*    */   public static final int COST_ITEM_FAIL = 7;
/*    */   public static final int COST_MONEY_FAIL = 8;
/*    */   public static final int SEND_MAIL_FAIL = 9;
/*    */   public static final int COMMUNICATION_ERROR = 10;
/*    */   public static final int GRC_TIMEOUT = 11;
/*    */   public static final int GRC_FAIL = 12;
/*    */   public static final int TURN_NOT_END = 13;
/*    */   public static final int NOT_GOT_AWARD_NUMBER = 14;
/*    */   
/*    */   public final boolean _validator_()
/*    */   {
/* 39 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 43 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 47 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 51 */     if (_o1_ == this) return true;
/* 52 */     if ((_o1_ instanceof IndianaErrorCode)) {
/* 53 */       return true;
/*    */     }
/* 55 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 59 */     int _h_ = 0;
/* 60 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 64 */     StringBuilder _sb_ = new StringBuilder();
/* 65 */     _sb_.append("(");
/* 66 */     _sb_.append(")");
/* 67 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(IndianaErrorCode _o_) {
/* 71 */     if (_o_ == this) return 0;
/* 72 */     int _c_ = 0;
/* 73 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\indiana\IndianaErrorCode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */