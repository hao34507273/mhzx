/*    */ package mzm.gsp.cat;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CatRet
/*    */   implements Marshal, Comparable<CatRet>
/*    */ {
/*    */   public static final int ERROR_SYSTEM = 1;
/*    */   public static final int ERROR_INVALID_PARAM = 2;
/*    */   public static final int ERROR_GET_FEED_AWARD = 3;
/*    */   public static final int ERROR_CAT_NOT_EXIST = 4;
/*    */   public static final int ERROR_CAT_STATE = 5;
/*    */   public static final int ERROR_HOME_LAND_NOT_EXIST = 6;
/*    */   public static final int ERROR_GET_EXPLORE_AWARD_FAILED = 7;
/*    */   public static final int ERROR_ADD_CAT_ITEM = 8;
/*    */   public static final int ERROR_REMOVE_CAT_ITEM = 9;
/*    */   public static final int ERROR_HOME_LAND_CAT_MAX = 10;
/*    */   public static final int ERROR_WOLRD_ID_NOT_EXIST = 11;
/*    */   public static final int ERROR_FUN_NOT_OPEN = 12;
/*    */   public static final int ERROR_CHANGE_PARTNER_COST_INVALID = 13;
/*    */   public static final int ERROR_LEVEL_TO_CAT_CFG = 14;
/*    */   public static final int ERROR_CAT_LEVEL_CFG = 15;
/*    */   
/*    */   public final boolean _validator_()
/*    */   {
/* 32 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 36 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 40 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 44 */     if (_o1_ == this) return true;
/* 45 */     if ((_o1_ instanceof CatRet)) {
/* 46 */       return true;
/*    */     }
/* 48 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 52 */     int _h_ = 0;
/* 53 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 57 */     StringBuilder _sb_ = new StringBuilder();
/* 58 */     _sb_.append("(");
/* 59 */     _sb_.append(")");
/* 60 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CatRet _o_) {
/* 64 */     if (_o_ == this) return 0;
/* 65 */     int _c_ = 0;
/* 66 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\cat\CatRet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */