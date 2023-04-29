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
/*    */ public class ChildFashionRet
/*    */   implements Marshal, Comparable<ChildFashionRet>
/*    */ {
/*    */   public static final int ERROR_SYSTEM = 1;
/*    */   public static final int ERROR_CFG = 2;
/*    */   public static final int ERROR_FAHION_EXIST = 3;
/*    */   public static final int ERROR_USERID = 4;
/*    */   public static final int ERROR_CHILD_NOT_EXIST = 5;
/*    */   public static final int ERROR_CHILD_OWNER = 6;
/*    */   public static final int ERROR_FASHION_NOT_HAVE = 7;
/*    */   public static final int ERROR_PHASE = 8;
/*    */   public static final int ERROR_DRESSED_FASHION = 9;
/*    */   public static final int ERROR_NOT_WEAR_FASHION = 10;
/*    */   public static final int ERROR_DRESSED_FASHION_NOT_MATCH = 11;
/*    */   public static final int ERROR_CHILD_FASHION_GENDER_NOT_MATCH = 12;
/*    */   
/*    */   public final boolean _validator_()
/*    */   {
/* 29 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 33 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 37 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 41 */     if (_o1_ == this) return true;
/* 42 */     if ((_o1_ instanceof ChildFashionRet)) {
/* 43 */       return true;
/*    */     }
/* 45 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 49 */     int _h_ = 0;
/* 50 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 54 */     StringBuilder _sb_ = new StringBuilder();
/* 55 */     _sb_.append("(");
/* 56 */     _sb_.append(")");
/* 57 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(ChildFashionRet _o_) {
/* 61 */     if (_o_ == this) return 0;
/* 62 */     int _c_ = 0;
/* 63 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\ChildFashionRet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */