/*    */ package mzm.gsp.crossbattle;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RoundRobinRoundStage
/*    */   implements Marshal, Comparable<RoundRobinRoundStage>
/*    */ {
/*    */   public static final int STAGE_NOT_START = -1;
/*    */   public static final int STAGE_PREPARE = 0;
/*    */   public static final int STAGE_FIGHT = 1;
/*    */   public static final int STAGE_END = 2;
/*    */   
/*    */   public final boolean _validator_()
/*    */   {
/* 21 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 25 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 29 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 33 */     if (_o1_ == this) return true;
/* 34 */     if ((_o1_ instanceof RoundRobinRoundStage)) {
/* 35 */       return true;
/*    */     }
/* 37 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 41 */     int _h_ = 0;
/* 42 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 46 */     StringBuilder _sb_ = new StringBuilder();
/* 47 */     _sb_.append("(");
/* 48 */     _sb_.append(")");
/* 49 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(RoundRobinRoundStage _o_) {
/* 53 */     if (_o_ == this) return 0;
/* 54 */     int _c_ = 0;
/* 55 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\RoundRobinRoundStage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */