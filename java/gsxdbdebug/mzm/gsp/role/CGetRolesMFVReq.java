/*    */ package mzm.gsp.role;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.role.main.PCGetRolesMFVReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CGetRolesMFVReq
/*    */   extends __CGetRolesMFVReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12586031;
/*    */   public ArrayList<Long> roleids;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     if (roleId < 0L) {
/* 21 */       return;
/*    */     }
/* 23 */     Role.addRoleProcedure(roleId, new PCGetRolesMFVReq(roleId, this.roleids));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 31 */     return 12586031;
/*    */   }
/*    */   
/*    */ 
/*    */   public CGetRolesMFVReq()
/*    */   {
/* 37 */     this.roleids = new ArrayList();
/*    */   }
/*    */   
/*    */   public CGetRolesMFVReq(ArrayList<Long> _roleids_) {
/* 41 */     this.roleids = _roleids_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.compact_uint32(this.roleids.size());
/* 50 */     for (Long _v_ : this.roleids) {
/* 51 */       _os_.marshal(_v_.longValue());
/*    */     }
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 59 */       long _v_ = _os_.unmarshal_long();
/* 60 */       this.roleids.add(Long.valueOf(_v_));
/*    */     }
/* 62 */     if (!_validator_()) {
/* 63 */       throw new VerifyError("validator failed");
/*    */     }
/* 65 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 69 */     if (_o1_ == this) return true;
/* 70 */     if ((_o1_ instanceof CGetRolesMFVReq)) {
/* 71 */       CGetRolesMFVReq _o_ = (CGetRolesMFVReq)_o1_;
/* 72 */       if (!this.roleids.equals(_o_.roleids)) return false;
/* 73 */       return true;
/*    */     }
/* 75 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 79 */     int _h_ = 0;
/* 80 */     _h_ += this.roleids.hashCode();
/* 81 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 85 */     StringBuilder _sb_ = new StringBuilder();
/* 86 */     _sb_.append("(");
/* 87 */     _sb_.append(this.roleids).append(",");
/* 88 */     _sb_.append(")");
/* 89 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\CGetRolesMFVReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */