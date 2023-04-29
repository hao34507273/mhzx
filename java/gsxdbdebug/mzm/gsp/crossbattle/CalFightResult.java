/*    */ package mzm.gsp.crossbattle;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CalFightResult
/*    */   implements Marshal, Comparable<CalFightResult>
/*    */ {
/*    */   public static final int STATE_NOT_START = 0;
/*    */   public static final int A_FIGHT_WIN = 1;
/*    */   public static final int A_FIGHT_LOSE = 2;
/*    */   public static final int A_ABSTAIN_WIN = 3;
/*    */   public static final int A_ABSTAIN_LOSE = 4;
/*    */   public static final int A_BYE_WIN = 5;
/*    */   public static final int B_BYE_WIN = 6;
/*    */   public static final int ALL_ABSTAIN = 7;
/*    */   public static final int ALL_BYE = 8;
/*    */   
/*    */   public final boolean _validator_()
/*    */   {
/* 24 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 28 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 32 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 36 */     if (_o1_ == this) return true;
/* 37 */     if ((_o1_ instanceof CalFightResult)) {
/* 38 */       return true;
/*    */     }
/* 40 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 44 */     int _h_ = 0;
/* 45 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 49 */     StringBuilder _sb_ = new StringBuilder();
/* 50 */     _sb_.append("(");
/* 51 */     _sb_.append(")");
/* 52 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CalFightResult _o_) {
/* 56 */     if (_o_ == this) return 0;
/* 57 */     int _c_ = 0;
/* 58 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\CalFightResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */