/*    */ package mzm.gsp.genius;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GeniusRet
/*    */   implements Marshal, Comparable<GeniusRet>
/*    */ {
/*    */   public static final int ERROR_SYSTEM = 1;
/*    */   public static final int ERROR_USERID = 2;
/*    */   public static final int ERROR_CFG = 3;
/*    */   public static final int ERROR_LEVEL = 4;
/*    */   public static final int ERROR_GENIUS_EMPTY = 5;
/*    */   public static final int ERROR_SWITCH_GENIUS_SERIES = 6;
/*    */   public static final int ERROR_GENIU_PLAN_PARAM_INVALID = 7;
/*    */   public static final int ERROR_GENIU_POINT_OVER_FLOW = 8;
/*    */   public static final int ERROR_PREVIOUS_GENIUS_POINT_NOT_ENOUGH = 9;
/*    */   public static final int ERROR_PREVIOUS_POINT_NOT_ENOUGH = 10;
/*    */   public static final int ERROR_GENIUS_IGNORE = 11;
/*    */   
/*    */   public final boolean _validator_()
/*    */   {
/* 28 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 32 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 36 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 40 */     if (_o1_ == this) return true;
/* 41 */     if ((_o1_ instanceof GeniusRet)) {
/* 42 */       return true;
/*    */     }
/* 44 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 48 */     int _h_ = 0;
/* 49 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 53 */     StringBuilder _sb_ = new StringBuilder();
/* 54 */     _sb_.append("(");
/* 55 */     _sb_.append(")");
/* 56 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(GeniusRet _o_) {
/* 60 */     if (_o_ == this) return 0;
/* 61 */     int _c_ = 0;
/* 62 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\genius\GeniusRet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */