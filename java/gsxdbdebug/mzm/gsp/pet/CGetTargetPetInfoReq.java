/*    */ package mzm.gsp.pet;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.pet.main.PGetTargetPetInfoReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CGetTargetPetInfoReq
/*    */   extends __CGetTargetPetInfoReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12590608;
/*    */   public long roleid;
/*    */   public long petid;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     if (roleId < 0L) {
/* 21 */       return;
/*    */     }
/* 23 */     Role.addRoleProcedure(roleId, new PGetTargetPetInfoReq(roleId, this.petid, this.roleid));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 31 */     return 12590608;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CGetTargetPetInfoReq() {}
/*    */   
/*    */ 
/*    */   public CGetTargetPetInfoReq(long _roleid_, long _petid_)
/*    */   {
/* 41 */     this.roleid = _roleid_;
/* 42 */     this.petid = _petid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.roleid);
/* 51 */     _os_.marshal(this.petid);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.roleid = _os_.unmarshal_long();
/* 57 */     this.petid = _os_.unmarshal_long();
/* 58 */     if (!_validator_()) {
/* 59 */       throw new VerifyError("validator failed");
/*    */     }
/* 61 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 65 */     if (_o1_ == this) return true;
/* 66 */     if ((_o1_ instanceof CGetTargetPetInfoReq)) {
/* 67 */       CGetTargetPetInfoReq _o_ = (CGetTargetPetInfoReq)_o1_;
/* 68 */       if (this.roleid != _o_.roleid) return false;
/* 69 */       if (this.petid != _o_.petid) return false;
/* 70 */       return true;
/*    */     }
/* 72 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 76 */     int _h_ = 0;
/* 77 */     _h_ += (int)this.roleid;
/* 78 */     _h_ += (int)this.petid;
/* 79 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 83 */     StringBuilder _sb_ = new StringBuilder();
/* 84 */     _sb_.append("(");
/* 85 */     _sb_.append(this.roleid).append(",");
/* 86 */     _sb_.append(this.petid).append(",");
/* 87 */     _sb_.append(")");
/* 88 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CGetTargetPetInfoReq _o_) {
/* 92 */     if (_o_ == this) return 0;
/* 93 */     int _c_ = 0;
/* 94 */     _c_ = Long.signum(this.roleid - _o_.roleid);
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     _c_ = Long.signum(this.petid - _o_.petid);
/* 97 */     if (0 != _c_) return _c_;
/* 98 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\CGetTargetPetInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */