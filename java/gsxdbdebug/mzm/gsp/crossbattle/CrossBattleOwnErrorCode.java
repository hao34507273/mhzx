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
/*    */ public class CrossBattleOwnErrorCode
/*    */   implements Marshal, Comparable<CrossBattleOwnErrorCode>
/*    */ {
/*    */   public static final int MODULE_CLOSE_OR_ROLE_FORBIDDEN = -1;
/*    */   public static final int CORPS_ALREADY_REGISTER = 1;
/*    */   public static final int CORPS_NOT_REGISTER = 2;
/*    */   public static final int CORPS_MEMBER_NUM_SATISFIED = 3;
/*    */   public static final int ACTIVITY_NOT_OPEN = 4;
/*    */   public static final int ACTIVITY_STAGE_ERROR = 5;
/*    */   public static final int ROUND_ROBIN_ROUND_END = 6;
/*    */   public static final int ROUND_ROBIN_ROUND_INDEX_ERROR = 7;
/*    */   public static final int ROUND_ROBIN_FIGHT_END = 8;
/*    */   public static final int ROUND_ROBIN_FIGHT_NO_ATTEND_ROLE = 9;
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
/* 40 */     if ((_o1_ instanceof CrossBattleOwnErrorCode)) {
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
/*    */   public int compareTo(CrossBattleOwnErrorCode _o_) {
/* 59 */     if (_o_ == this) return 0;
/* 60 */     int _c_ = 0;
/* 61 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\CrossBattleOwnErrorCode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */