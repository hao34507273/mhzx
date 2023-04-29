/*    */ package mzm.gsp.coupledaily;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CoupleDailyConst
/*    */   implements Marshal, Comparable<CoupleDailyConst>
/*    */ {
/*    */   public static final int REFUSE = 0;
/*    */   public static final int AGREE = 1;
/*    */   public static final int A_SELECTOR = 0;
/*    */   public static final int B_SELECTOR = 1;
/*    */   public static final int NOT_MATCH = 0;
/*    */   public static final int YES_MATCH = 1;
/*    */   public static final int NOT_AWARD = 0;
/*    */   public static final int YES_AWARD = 1;
/*    */   
/*    */   public final boolean _validator_()
/*    */   {
/* 23 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 27 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 31 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 35 */     if (_o1_ == this) return true;
/* 36 */     if ((_o1_ instanceof CoupleDailyConst)) {
/* 37 */       return true;
/*    */     }
/* 39 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 43 */     int _h_ = 0;
/* 44 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 48 */     StringBuilder _sb_ = new StringBuilder();
/* 49 */     _sb_.append("(");
/* 50 */     _sb_.append(")");
/* 51 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CoupleDailyConst _o_) {
/* 55 */     if (_o_ == this) return 0;
/* 56 */     int _c_ = 0;
/* 57 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\coupledaily\CoupleDailyConst.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */