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
/*    */ public class CrossBattlePointRet
/*    */   implements Marshal, Comparable<CrossBattlePointRet>
/*    */ {
/*    */   public static final int ACTIVITY_NOT_OPEN = 1;
/*    */   public static final int ACTIVITY_STAGE_ERROR = 2;
/*    */   public static final int STATUS_CAN_NOT_DO_ACTION = 3;
/*    */   public static final int ACTIVITY_NOT_CAN_JOIN = 4;
/*    */   public static final int CORPS_NOT_EXIST = 5;
/*    */   public static final int CORPS_PROMOTION_FAIL = 6;
/*    */   public static final int CFG_NOT_EXIST = 7;
/*    */   public static final int SYSTEM_ERROR = 8;
/*    */   
/*    */   public final boolean _validator_()
/*    */   {
/* 25 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 29 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 33 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 37 */     if (_o1_ == this) return true;
/* 38 */     if ((_o1_ instanceof CrossBattlePointRet)) {
/* 39 */       return true;
/*    */     }
/* 41 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 45 */     int _h_ = 0;
/* 46 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 50 */     StringBuilder _sb_ = new StringBuilder();
/* 51 */     _sb_.append("(");
/* 52 */     _sb_.append(")");
/* 53 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CrossBattlePointRet _o_) {
/* 57 */     if (_o_ == this) return 0;
/* 58 */     int _c_ = 0;
/* 59 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\CrossBattlePointRet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */