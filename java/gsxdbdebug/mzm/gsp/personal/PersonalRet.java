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
/*    */ public class PersonalRet
/*    */   implements Marshal, Comparable<PersonalRet>
/*    */ {
/*    */   public static final int ROLE_NOT_EXIST = 0;
/*    */   public static final int SIGN_INVALID = 1;
/*    */   public static final int SIGN_LENGTH_INVALID = 2;
/*    */   public static final int SCHOOL_INVALID = 3;
/*    */   public static final int SCHOOL_LENGTH_INVALID = 4;
/*    */   public static final int SYSTEM_ERROR = 5;
/*    */   public static final int PRAISE_SELF = 6;
/*    */   public static final int DAILY_PRAISE_SOMEONE_MAX = 7;
/*    */   public static final int DAILY_PRAISE_MAX = 8;
/*    */   public static final int PRAISE_MAX = 9;
/*    */   public static final int HEAD_IMAGE_INVALID = 10;
/*    */   public static final int GENDER_INVALID = 11;
/*    */   public static final int AGE_INVALID = 12;
/*    */   public static final int BIRTHDAY_INVALID = 13;
/*    */   public static final int ANIMAL_SIGN_INVALID = 14;
/*    */   public static final int CONSTELLATION_INVALID = 15;
/*    */   public static final int BLOOD_TYPE_INVALID = 16;
/*    */   public static final int OCCUPATION_INVALID = 17;
/*    */   public static final int LOCATION_PROVINCE_INVALID = 18;
/*    */   public static final int LOCATION_CITY_INVALID = 19;
/*    */   public static final int HOBBY_INVALID = 20;
/*    */   public static final int HOBBY_NUM_INVALID = 21;
/*    */   public static final int PHOTO_INVALID = 22;
/*    */   
/*    */   public final boolean _validator_()
/*    */   {
/* 40 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 44 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 52 */     if (_o1_ == this) return true;
/* 53 */     if ((_o1_ instanceof PersonalRet)) {
/* 54 */       return true;
/*    */     }
/* 56 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 60 */     int _h_ = 0;
/* 61 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 65 */     StringBuilder _sb_ = new StringBuilder();
/* 66 */     _sb_.append("(");
/* 67 */     _sb_.append(")");
/* 68 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(PersonalRet _o_) {
/* 72 */     if (_o_ == this) return 0;
/* 73 */     int _c_ = 0;
/* 74 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\personal\PersonalRet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */