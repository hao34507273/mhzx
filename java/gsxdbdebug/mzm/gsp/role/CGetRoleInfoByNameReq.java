/*    */ package mzm.gsp.role;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.role.main.PCGetRoleInfoByName;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CGetRoleInfoByNameReq
/*    */   extends __CGetRoleInfoByNameReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12586036;
/*    */   public Octets name;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleId = Role.getRoleId(this);
/* 21 */     if (roleId < 0L) {
/* 22 */       return;
/*    */     }
/* 24 */     Role.addRoleProcedure(roleId, new PCGetRoleInfoByName(roleId, this.name));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 32 */     return 12586036;
/*    */   }
/*    */   
/*    */ 
/*    */   public CGetRoleInfoByNameReq()
/*    */   {
/* 38 */     this.name = new Octets();
/*    */   }
/*    */   
/*    */   public CGetRoleInfoByNameReq(Octets _name_) {
/* 42 */     this.name = _name_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.name);
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 55 */     this.name = _os_.unmarshal_Octets();
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof CGetRoleInfoByNameReq)) {
/* 65 */       CGetRoleInfoByNameReq _o_ = (CGetRoleInfoByNameReq)_o1_;
/* 66 */       if (!this.name.equals(_o_.name)) return false;
/* 67 */       return true;
/*    */     }
/* 69 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 73 */     int _h_ = 0;
/* 74 */     _h_ += this.name.hashCode();
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append("B").append(this.name.size()).append(",");
/* 82 */     _sb_.append(")");
/* 83 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\CGetRoleInfoByNameReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */