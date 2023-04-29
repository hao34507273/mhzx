/*    */ package mzm.gsp.pk;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.pk.main.PRevengeItemAssignRole;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CRevengeItemAssignRoleReq
/*    */   extends __CRevengeItemAssignRoleReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12619779;
/*    */   public int bag_id;
/*    */   public int grid;
/*    */   public String role_id_or_name;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleId = Role.getRoleId(this);
/* 21 */     Role.addRoleProcedure(roleId, new PRevengeItemAssignRole(roleId, this.bag_id, this.grid, this.role_id_or_name));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 30 */     return 12619779;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public CRevengeItemAssignRoleReq()
/*    */   {
/* 38 */     this.role_id_or_name = "";
/*    */   }
/*    */   
/*    */   public CRevengeItemAssignRoleReq(int _bag_id_, int _grid_, String _role_id_or_name_) {
/* 42 */     this.bag_id = _bag_id_;
/* 43 */     this.grid = _grid_;
/* 44 */     this.role_id_or_name = _role_id_or_name_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 48 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 52 */     _os_.marshal(this.bag_id);
/* 53 */     _os_.marshal(this.grid);
/* 54 */     _os_.marshal(this.role_id_or_name, "UTF-16LE");
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 59 */     this.bag_id = _os_.unmarshal_int();
/* 60 */     this.grid = _os_.unmarshal_int();
/* 61 */     this.role_id_or_name = _os_.unmarshal_String("UTF-16LE");
/* 62 */     if (!_validator_()) {
/* 63 */       throw new VerifyError("validator failed");
/*    */     }
/* 65 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 69 */     if (_o1_ == this) return true;
/* 70 */     if ((_o1_ instanceof CRevengeItemAssignRoleReq)) {
/* 71 */       CRevengeItemAssignRoleReq _o_ = (CRevengeItemAssignRoleReq)_o1_;
/* 72 */       if (this.bag_id != _o_.bag_id) return false;
/* 73 */       if (this.grid != _o_.grid) return false;
/* 74 */       if (!this.role_id_or_name.equals(_o_.role_id_or_name)) return false;
/* 75 */       return true;
/*    */     }
/* 77 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 81 */     int _h_ = 0;
/* 82 */     _h_ += this.bag_id;
/* 83 */     _h_ += this.grid;
/* 84 */     _h_ += this.role_id_or_name.hashCode();
/* 85 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 89 */     StringBuilder _sb_ = new StringBuilder();
/* 90 */     _sb_.append("(");
/* 91 */     _sb_.append(this.bag_id).append(",");
/* 92 */     _sb_.append(this.grid).append(",");
/* 93 */     _sb_.append("T").append(this.role_id_or_name.length()).append(",");
/* 94 */     _sb_.append(")");
/* 95 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pk\CRevengeItemAssignRoleReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */