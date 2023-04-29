/*    */ package mzm.gsp.menpaistar;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MenPaiStarRet
/*    */   implements Marshal, Comparable<MenPaiStarRet>
/*    */ {
/*    */   public static final int ERROR_SYSTEM = 1;
/*    */   public static final int ERROR_USERID = 2;
/*    */   public static final int ERROR_CFG = 3;
/*    */   public static final int ERROR_YUANBAO_INCONSISTENT = 4;
/*    */   public static final int ERROR_NPC_SERVICE = 5;
/*    */   public static final int ERROR_CAMPAIGN = 6;
/*    */   public static final int ERROR_VOTE = 7;
/*    */   public static final int ERROR_ROLE_IS_NOT_CAMPAIGN = 8;
/*    */   public static final int ERROR_ROLE_IS_NOT_VOTE = 9;
/*    */   public static final int ERROR_ROLE_NOT_IN_GANG = 10;
/*    */   public static final int ERROR_GANG_INCONSISTENT = 11;
/*    */   public static final int ERROR_GANG_CHAT = 12;
/*    */   public static final int ERROR_CAMPAIGN_FIGHT_TIME_OUT = 13;
/*    */   public static final int ERROR_VOTE_FIGHT_TIME_OUT = 14;
/*    */   public static final int ERROR_VOTE_TIME_OUT = 15;
/*    */   public static final int ERROR_CANVASS_TIME_OUT = 16;
/*    */   public static final int ERROR_CAN_NOT_JOIN_ACTIVITY = 17;
/*    */   public static final int ERROR_ACTIVITY_IN_AWARD = 18;
/*    */   public static final int ERROR_NOT_IN_CAMPAIGN_RANK = 19;
/*    */   
/*    */   public final boolean _validator_()
/*    */   {
/* 36 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 40 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 44 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 48 */     if (_o1_ == this) return true;
/* 49 */     if ((_o1_ instanceof MenPaiStarRet)) {
/* 50 */       return true;
/*    */     }
/* 52 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 56 */     int _h_ = 0;
/* 57 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 61 */     StringBuilder _sb_ = new StringBuilder();
/* 62 */     _sb_.append("(");
/* 63 */     _sb_.append(")");
/* 64 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(MenPaiStarRet _o_) {
/* 68 */     if (_o_ == this) return 0;
/* 69 */     int _c_ = 0;
/* 70 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaistar\MenPaiStarRet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */