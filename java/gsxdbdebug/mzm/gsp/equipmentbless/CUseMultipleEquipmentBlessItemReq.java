/*    */ package mzm.gsp.equipmentbless;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.equipmentbless.main.PUseEquipmentBlessItem;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CUseMultipleEquipmentBlessItemReq
/*    */   extends __CUseMultipleEquipmentBlessItemReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12626433;
/*    */   public long equipment_uuid;
/*    */   public int bless_item_cfgid;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     Role.addRoleProcedure(roleId, new PUseEquipmentBlessItem(roleId, this.equipment_uuid, this.bless_item_cfgid, true));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 29 */     return 12626433;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CUseMultipleEquipmentBlessItemReq() {}
/*    */   
/*    */ 
/*    */   public CUseMultipleEquipmentBlessItemReq(long _equipment_uuid_, int _bless_item_cfgid_)
/*    */   {
/* 39 */     this.equipment_uuid = _equipment_uuid_;
/* 40 */     this.bless_item_cfgid = _bless_item_cfgid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.equipment_uuid);
/* 49 */     _os_.marshal(this.bless_item_cfgid);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.equipment_uuid = _os_.unmarshal_long();
/* 55 */     this.bless_item_cfgid = _os_.unmarshal_int();
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof CUseMultipleEquipmentBlessItemReq)) {
/* 65 */       CUseMultipleEquipmentBlessItemReq _o_ = (CUseMultipleEquipmentBlessItemReq)_o1_;
/* 66 */       if (this.equipment_uuid != _o_.equipment_uuid) return false;
/* 67 */       if (this.bless_item_cfgid != _o_.bless_item_cfgid) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += (int)this.equipment_uuid;
/* 76 */     _h_ += this.bless_item_cfgid;
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.equipment_uuid).append(",");
/* 84 */     _sb_.append(this.bless_item_cfgid).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CUseMultipleEquipmentBlessItemReq _o_) {
/* 90 */     if (_o_ == this) return 0;
/* 91 */     int _c_ = 0;
/* 92 */     _c_ = Long.signum(this.equipment_uuid - _o_.equipment_uuid);
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     _c_ = this.bless_item_cfgid - _o_.bless_item_cfgid;
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\equipmentbless\CUseMultipleEquipmentBlessItemReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */