/*    */ package mzm.gsp.indiana;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AwardState
/*    */   implements Marshal, Comparable<AwardState>
/*    */ {
/*    */   public static final int NOT_AWARDED = 0;
/*    */   public static final int AWARDED = 1;
/*    */   public static final int OTERT_SERVER = 2;
/*    */   
/*    */   public final boolean _validator_()
/*    */   {
/* 20 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 24 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 28 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 32 */     if (_o1_ == this) return true;
/* 33 */     if ((_o1_ instanceof AwardState)) {
/* 34 */       return true;
/*    */     }
/* 36 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 40 */     int _h_ = 0;
/* 41 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 45 */     StringBuilder _sb_ = new StringBuilder();
/* 46 */     _sb_.append("(");
/* 47 */     _sb_.append(")");
/* 48 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(AwardState _o_) {
/* 52 */     if (_o_ == this) return 0;
/* 53 */     int _c_ = 0;
/* 54 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\indiana\AwardState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */