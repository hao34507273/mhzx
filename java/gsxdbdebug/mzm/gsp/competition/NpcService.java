/*    */ package mzm.gsp.competition;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class NpcService
/*    */   implements Marshal, Comparable<NpcService>
/*    */ {
/*    */   public static final int ENTER_COMPETITION_MAP = 150205301;
/*    */   public static final int LEAVE_COMPETITION_MAP = 150205302;
/*    */   
/*    */   public final boolean _validator_()
/*    */   {
/* 17 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 21 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 25 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 29 */     if (_o1_ == this) return true;
/* 30 */     if ((_o1_ instanceof NpcService)) {
/* 31 */       return true;
/*    */     }
/* 33 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 37 */     int _h_ = 0;
/* 38 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 42 */     StringBuilder _sb_ = new StringBuilder();
/* 43 */     _sb_.append("(");
/* 44 */     _sb_.append(")");
/* 45 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(NpcService _o_) {
/* 49 */     if (_o_ == this) return 0;
/* 50 */     int _c_ = 0;
/* 51 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\competition\NpcService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */