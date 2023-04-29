/*    */ package mzm.gsp.shitu;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ShiTuConst
/*    */   implements Marshal, Comparable<ShiTuConst>
/*    */ {
/*    */   public static final int REFUSE_SHOUTU = 0;
/*    */   public static final int AGREE_SHOUTU = 1;
/*    */   public static final int OFF_LINE = 0;
/*    */   public static final int ON_LINE = 1;
/*    */   public static final int MASTER = 0;
/*    */   public static final int APPRENTICE = 1;
/*    */   public static final int FAIL = 0;
/*    */   public static final int SUCCESS = 1;
/*    */   public static final int NO_CHU_SHI = 0;
/*    */   public static final int YES_CHU_SHI = 1;
/*    */   public static final int NO_PAY_RESPECT = 0;
/*    */   public static final int YES_PAY_RESPECT = 1;
/*    */   public static final int PAY_RESPECT_TIME_OUT = 2;
/*    */   public static final int REFUSE_RECOMMEND = 0;
/*    */   public static final int AGREE_RECOMMEND = 1;
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
/* 43 */     if ((_o1_ instanceof ShiTuConst)) {
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
/*    */   public int compareTo(ShiTuConst _o_) {
/* 62 */     if (_o_ == this) return 0;
/* 63 */     int _c_ = 0;
/* 64 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\ShiTuConst.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */