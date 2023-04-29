/*    */ package mzm.gsp.children;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GrowthSubType
/*    */   implements Marshal, Comparable<GrowthSubType>
/*    */ {
/*    */   public static final int BAO_SHI = 0;
/*    */   public static final int MOOD = 1;
/*    */   public static final int CLEAN = 2;
/*    */   public static final int TIRED = 3;
/*    */   public static final int BABY_BREED_OPERAT = 4;
/*    */   public static final int OLD_NAME = 0;
/*    */   public static final int NEW_NAME = 1;
/*    */   public static final int DRAW_LOTS_CFG_ID = 0;
/*    */   public static final int COURSE_TYPE = 0;
/*    */   public static final int IS_CRIT = 1;
/*    */   public static final int ADULT_SELECT_OCCUPATION_OCCU = 0;
/*    */   public static final int ADULT_STUDY_SKILL_ORIGINAL = 0;
/*    */   public static final int ADULT_STUDY_SKILL_NOW = 1;
/*    */   public static final int ADULT_CHANGE_OCCUPATION_ORIGINAL = 0;
/*    */   public static final int ADULT_CHANGE_OCCUPATION_NOW = 1;
/*    */   public static final int ADULT_ADD_APT_TYPE = 0;
/*    */   public static final int ADULT_ADD_APT_CHANGE = 1;
/*    */   public static final int ADULT_ADD_GROWTH_CHANGE = 0;
/*    */   
/*    */   public final boolean _validator_()
/*    */   {
/* 33 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 37 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 41 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 45 */     if (_o1_ == this) return true;
/* 46 */     if ((_o1_ instanceof GrowthSubType)) {
/* 47 */       return true;
/*    */     }
/* 49 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 53 */     int _h_ = 0;
/* 54 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 58 */     StringBuilder _sb_ = new StringBuilder();
/* 59 */     _sb_.append("(");
/* 60 */     _sb_.append(")");
/* 61 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(GrowthSubType _o_) {
/* 65 */     if (_o_ == this) return 0;
/* 66 */     int _c_ = 0;
/* 67 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\GrowthSubType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */