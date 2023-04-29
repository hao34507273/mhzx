/*    */ package mzm.gsp.drawandguess;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DrawAndGuessConst
/*    */   implements Marshal, Comparable<DrawAndGuessConst>
/*    */ {
/*    */   public static final int REFUSE = 0;
/*    */   public static final int AGREE = 1;
/*    */   public static final int WRONG = 0;
/*    */   public static final int RIGHT = 1;
/*    */   public static final int MAX_TOTAL_POINT = 40960;
/*    */   public static final int MAX_CACHE_ANSWER = 30;
/*    */   public static final int MAX_ANSWER_LENGTH = 40;
/*    */   public static final int ANSWER_CD = 1;
/*    */   public static final int LOGIN = 0;
/*    */   public static final int NEW = 1;
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
/* 38 */     if ((_o1_ instanceof DrawAndGuessConst)) {
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
/*    */   public int compareTo(DrawAndGuessConst _o_) {
/* 57 */     if (_o_ == this) return 0;
/* 58 */     int _c_ = 0;
/* 59 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\drawandguess\DrawAndGuessConst.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */