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
/*    */ public class ChildhoodRet
/*    */   implements Marshal, Comparable<ChildhoodRet>
/*    */ {
/*    */   public static final int ERROR_SYSTEM = 1;
/*    */   public static final int ERROR_INVALID_STATUS = 2;
/*    */   public static final int ERROR_NEVER_CHOOSE_INTEREST = 3;
/*    */   public static final int ERROR_LEARN_COURSE_STATUS = 4;
/*    */   public static final int ERROR_CFG = 5;
/*    */   public static final int ERROR_COST_INVALID = 6;
/*    */   public static final int ERROR_YUANBAO_INCONSISTENT = 7;
/*    */   public static final int ERROR_HOME_NOT_EXIST = 8;
/*    */   public static final int ERROR_HOME_WORLD_NOT_EXIST = 9;
/*    */   public static final int ERROR_CHILD_NOT_EXIST = 10;
/*    */   public static final int ERROR_CHILD_OWNER = 11;
/*    */   public static final int ERROR_USERID = 12;
/*    */   public static final int ERROR_NOT_LEARN_COURSE = 13;
/*    */   
/*    */   public final boolean _validator_()
/*    */   {
/* 30 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 34 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 38 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 42 */     if (_o1_ == this) return true;
/* 43 */     if ((_o1_ instanceof ChildhoodRet)) {
/* 44 */       return true;
/*    */     }
/* 46 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 50 */     int _h_ = 0;
/* 51 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 55 */     StringBuilder _sb_ = new StringBuilder();
/* 56 */     _sb_.append("(");
/* 57 */     _sb_.append(")");
/* 58 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(ChildhoodRet _o_) {
/* 62 */     if (_o_ == this) return 0;
/* 63 */     int _c_ = 0;
/* 64 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\ChildhoodRet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */