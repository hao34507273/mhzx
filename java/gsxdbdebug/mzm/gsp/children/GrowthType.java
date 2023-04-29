/*    */ package mzm.gsp.children;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GrowthType
/*    */   implements Marshal, Comparable<GrowthType>
/*    */ {
/*    */   public static final int GROW_TYPE_BABY_BREED = 0;
/*    */   public static final int GROW_TYPE_CHANGE_NAME = 1;
/*    */   public static final int GROW_TYPE_CHOOSE_INTEREST = 2;
/*    */   public static final int GROW_TYPE_LEARN_COURSE = 3;
/*    */   public static final int GROW_TYPE_AUTO_BREED = 4;
/*    */   public static final int GROW_TYPE_ADULT_SELECT_OCCUPATION = 20;
/*    */   public static final int GROW_TYPE_ADULT_STUDY_SKILL = 21;
/*    */   public static final int GROW_TYPE_ADULT_CHANGE_OCCUPATION = 22;
/*    */   public static final int GROW_TYPE_ADULT_ADD_APT = 23;
/*    */   public static final int GROW_TYPE_ADULT_ADD_GROWTH = 24;
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
/* 40 */     if ((_o1_ instanceof GrowthType)) {
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
/*    */   public int compareTo(GrowthType _o_) {
/* 59 */     if (_o_ == this) return 0;
/* 60 */     int _c_ = 0;
/* 61 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\GrowthType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */