/*    */ package mzm.gsp.crossfield;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CrossFieldMatchProcess
/*    */   implements Marshal, Comparable<CrossFieldMatchProcess>
/*    */ {
/*    */   public static final int PROCESS_MATCHING = 0;
/*    */   public static final int PROCESS_MATCHED = 1;
/*    */   public static final int PROCESS_GEN_TOKEN_SUC = 2;
/*    */   public static final int PROCESS_TRANSFOR_DATA_SUC = 3;
/*    */   public static final int PROCESS_ROAM_LOGIN = 4;
/*    */   
/*    */   public final boolean _validator_()
/*    */   {
/* 22 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 26 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 30 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 34 */     if (_o1_ == this) return true;
/* 35 */     if ((_o1_ instanceof CrossFieldMatchProcess)) {
/* 36 */       return true;
/*    */     }
/* 38 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 42 */     int _h_ = 0;
/* 43 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 47 */     StringBuilder _sb_ = new StringBuilder();
/* 48 */     _sb_.append("(");
/* 49 */     _sb_.append(")");
/* 50 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CrossFieldMatchProcess _o_) {
/* 54 */     if (_o_ == this) return 0;
/* 55 */     int _c_ = 0;
/* 56 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossfield\CrossFieldMatchProcess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */