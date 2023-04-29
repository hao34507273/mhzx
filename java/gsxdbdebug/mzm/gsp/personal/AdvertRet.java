/*    */ package mzm.gsp.personal;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AdvertRet
/*    */   implements Marshal, Comparable<AdvertRet>
/*    */ {
/*    */   public static final int ERROR_ADVERT_TYPE = 0;
/*    */   public static final int ERROR_CONTENT_MIN_LEN = 1;
/*    */   public static final int ERROR_CONTENT_MAX_LEN = 2;
/*    */   public static final int ERROR_CONTENT_INVALID = 3;
/*    */   public static final int ERROR_ADVERT_RELEASED = 4;
/*    */   public static final int ERROR_ADVERT_TIME_LIMIT = 5;
/*    */   public static final int ERROR_SYSTEM = 6;
/*    */   public static final int ERROR_ADVERT_NOT_EXIST = 7;
/*    */   public static final int ERROR_PAGE_NUM_WRONG = 8;
/*    */   public static final int ERROR_LEVLE_INVALID = 9;
/*    */   public static final int ERROR_LOCATION_INVALID = 10;
/*    */   public static final int ERROR_GENDER_INVALID = 11;
/*    */   public static final int ERROR_REFRESH_INVALID = 12;
/*    */   public static final int ERROR_ROLE_LEVLE_INVALID = 13;
/*    */   public static final int ERROR_SEARCH_TO_MUCH = 14;
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
/* 45 */     if ((_o1_ instanceof AdvertRet)) {
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
/*    */   public int compareTo(AdvertRet _o_) {
/* 64 */     if (_o_ == this) return 0;
/* 65 */     int _c_ = 0;
/* 66 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\personal\AdvertRet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */