/*    */ package mzm.gsp.petmark;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.petmark.main.PCEquipPetMarkReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CEquipPetMarkReq
/*    */   extends __CEquipPetMarkReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12628491;
/*    */   public long pet_mark_id;
/*    */   public long pet_id;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleId = Role.getRoleId(this);
/* 21 */     if (roleId < 0L) {
/* 22 */       return;
/*    */     }
/* 24 */     Role.addRoleProcedure(roleId, new PCEquipPetMarkReq(roleId, this.pet_mark_id, this.pet_id));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 32 */     return 12628491;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CEquipPetMarkReq() {}
/*    */   
/*    */ 
/*    */   public CEquipPetMarkReq(long _pet_mark_id_, long _pet_id_)
/*    */   {
/* 42 */     this.pet_mark_id = _pet_mark_id_;
/* 43 */     this.pet_id = _pet_id_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.pet_mark_id);
/* 52 */     _os_.marshal(this.pet_id);
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     this.pet_mark_id = _os_.unmarshal_long();
/* 58 */     this.pet_id = _os_.unmarshal_long();
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof CEquipPetMarkReq)) {
/* 68 */       CEquipPetMarkReq _o_ = (CEquipPetMarkReq)_o1_;
/* 69 */       if (this.pet_mark_id != _o_.pet_mark_id) return false;
/* 70 */       if (this.pet_id != _o_.pet_id) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += (int)this.pet_mark_id;
/* 79 */     _h_ += (int)this.pet_id;
/* 80 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 84 */     StringBuilder _sb_ = new StringBuilder();
/* 85 */     _sb_.append("(");
/* 86 */     _sb_.append(this.pet_mark_id).append(",");
/* 87 */     _sb_.append(this.pet_id).append(",");
/* 88 */     _sb_.append(")");
/* 89 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CEquipPetMarkReq _o_) {
/* 93 */     if (_o_ == this) return 0;
/* 94 */     int _c_ = 0;
/* 95 */     _c_ = Long.signum(this.pet_mark_id - _o_.pet_mark_id);
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     _c_ = Long.signum(this.pet_id - _o_.pet_id);
/* 98 */     if (0 != _c_) return _c_;
/* 99 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petmark\CEquipPetMarkReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */