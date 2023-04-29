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
/*    */ public class DataBroadcastType
/*    */   implements Marshal, Comparable<DataBroadcastType>
/*    */ {
/*    */   public static final int NOTIFY_FIGHT_RECORD_START_INFO = 1;
/*    */   public static final int NOTIFY_FIGHT_RECORD_END_INFO = 2;
/*    */   public static final int NOTIFY_FIGHT_RECORD_ROUND_INFO = 3;
/*    */   public static final int NOTIFY_CROSS_BATTLE_FINAL_BULLETIN = 4;
/*    */   public static final int NOTIFY_MODIFY_ROAM_SERVER_DATE = 5;
/*    */   public static final int NOTIFY_INDIANA_AWARD_ROLE_INFO = 6;
/*    */   public static final int ALL_LOTTO_BRD_AWARD_ROLE_INFO = 7;
/*    */   public static final int NOTIFY_MODIFY_SERVER_DATE = 8;
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
/* 38 */     if ((_o1_ instanceof DataBroadcastType)) {
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
/*    */   public int compareTo(DataBroadcastType _o_) {
/* 57 */     if (_o_ == this) return 0;
/* 58 */     int _c_ = 0;
/* 59 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\DataBroadcastType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */