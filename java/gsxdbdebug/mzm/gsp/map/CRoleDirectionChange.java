/*    */ package mzm.gsp.map;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.map.main.PCRoleDirectionChange;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CRoleDirectionChange
/*    */   extends __CRoleDirectionChange__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12590849;
/*    */   public int direction;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     Role role = Role.getRole(this);
/* 20 */     if (role == null)
/*    */     {
/* 22 */       return;
/*    */     }
/* 24 */     long roleid = role.getRoleid();
/* 25 */     Role.addRoleProcedure(roleid, new PCRoleDirectionChange(roleid, this.direction));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 33 */     return 12590849;
/*    */   }
/*    */   
/*    */ 
/*    */   public CRoleDirectionChange() {}
/*    */   
/*    */ 
/*    */   public CRoleDirectionChange(int _direction_)
/*    */   {
/* 42 */     this.direction = _direction_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.direction);
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 55 */     this.direction = _os_.unmarshal_int();
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof CRoleDirectionChange)) {
/* 65 */       CRoleDirectionChange _o_ = (CRoleDirectionChange)_o1_;
/* 66 */       if (this.direction != _o_.direction) return false;
/* 67 */       return true;
/*    */     }
/* 69 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 73 */     int _h_ = 0;
/* 74 */     _h_ += this.direction;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.direction).append(",");
/* 82 */     _sb_.append(")");
/* 83 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CRoleDirectionChange _o_) {
/* 87 */     if (_o_ == this) return 0;
/* 88 */     int _c_ = 0;
/* 89 */     _c_ = this.direction - _o_.direction;
/* 90 */     if (0 != _c_) return _c_;
/* 91 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\CRoleDirectionChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */