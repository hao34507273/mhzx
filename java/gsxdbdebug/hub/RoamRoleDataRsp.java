/*    */ package hub;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RoamRoleDataRsp
/*    */   implements Marshal, Comparable<RoamRoleDataRsp>
/*    */ {
/*    */   public final boolean _validator_()
/*    */   {
/* 16 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 20 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 24 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 28 */     if (_o1_ == this) return true;
/* 29 */     if ((_o1_ instanceof RoamRoleDataRsp)) {
/* 30 */       return true;
/*    */     }
/* 32 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 36 */     int _h_ = 0;
/* 37 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 41 */     StringBuilder _sb_ = new StringBuilder();
/* 42 */     _sb_.append("(");
/* 43 */     _sb_.append(")");
/* 44 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(RoamRoleDataRsp _o_) {
/* 48 */     if (_o_ == this) return 0;
/* 49 */     int _c_ = 0;
/* 50 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\RoamRoleDataRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */