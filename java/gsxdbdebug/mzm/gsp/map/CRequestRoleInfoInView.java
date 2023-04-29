/*    */ package mzm.gsp.map;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.map.main.PRequestRoleInfoInView;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CRequestRoleInfoInView
/*    */   extends __CRequestRoleInfoInView__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12590863;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     Role role = Role.getRole(this);
/* 20 */     if (role == null) {
/* 21 */       return;
/*    */     }
/* 23 */     role.addProcedure(new PRequestRoleInfoInView(role.getRoleid()));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 31 */     return 12590863;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public final boolean _validator_()
/*    */   {
/* 39 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 43 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 47 */     if (!_validator_()) {
/* 48 */       throw new VerifyError("validator failed");
/*    */     }
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 54 */     if (_o1_ == this) return true;
/* 55 */     if ((_o1_ instanceof CRequestRoleInfoInView)) {
/* 56 */       return true;
/*    */     }
/* 58 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 62 */     int _h_ = 0;
/* 63 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 67 */     StringBuilder _sb_ = new StringBuilder();
/* 68 */     _sb_.append("(");
/* 69 */     _sb_.append(")");
/* 70 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CRequestRoleInfoInView _o_) {
/* 74 */     if (_o_ == this) return 0;
/* 75 */     int _c_ = 0;
/* 76 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\CRequestRoleInfoInView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */