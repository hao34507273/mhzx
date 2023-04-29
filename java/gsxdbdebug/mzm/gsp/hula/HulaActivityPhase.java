/*    */ package mzm.gsp.hula;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class HulaActivityPhase
/*    */   implements Marshal, Comparable<HulaActivityPhase>
/*    */ {
/*    */   public static final int STAGE_PREPARE = 0;
/*    */   public static final int STAGE_DOUDOU_COMEONT = 1;
/*    */   public static final int STAGE_DOUDOU_DELETE = 2;
/*    */   
/*    */   public final boolean _validator_()
/*    */   {
/* 18 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 22 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 26 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 30 */     if (_o1_ == this) return true;
/* 31 */     if ((_o1_ instanceof HulaActivityPhase)) {
/* 32 */       return true;
/*    */     }
/* 34 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 38 */     int _h_ = 0;
/* 39 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 43 */     StringBuilder _sb_ = new StringBuilder();
/* 44 */     _sb_.append("(");
/* 45 */     _sb_.append(")");
/* 46 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(HulaActivityPhase _o_) {
/* 50 */     if (_o_ == this) return 0;
/* 51 */     int _c_ = 0;
/* 52 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\hula\HulaActivityPhase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */