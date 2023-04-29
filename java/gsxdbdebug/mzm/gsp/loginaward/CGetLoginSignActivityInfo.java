/*    */ package mzm.gsp.loginaward;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.loginaward.main.PCGetLoginSignActivityInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CGetLoginSignActivityInfo
/*    */   extends __CGetLoginSignActivityInfo__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12604685;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     if (roleId < 1L)
/*    */     {
/* 22 */       return;
/*    */     }
/* 24 */     Role.addRoleProcedure(roleId, new PCGetLoginSignActivityInfo(roleId));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 32 */     return 12604685;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public final boolean _validator_()
/*    */   {
/* 40 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 44 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 48 */     if (!_validator_()) {
/* 49 */       throw new VerifyError("validator failed");
/*    */     }
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 55 */     if (_o1_ == this) return true;
/* 56 */     if ((_o1_ instanceof CGetLoginSignActivityInfo)) {
/* 57 */       return true;
/*    */     }
/* 59 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 63 */     int _h_ = 0;
/* 64 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 68 */     StringBuilder _sb_ = new StringBuilder();
/* 69 */     _sb_.append("(");
/* 70 */     _sb_.append(")");
/* 71 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CGetLoginSignActivityInfo _o_) {
/* 75 */     if (_o_ == this) return 0;
/* 76 */     int _c_ = 0;
/* 77 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\loginaward\CGetLoginSignActivityInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */