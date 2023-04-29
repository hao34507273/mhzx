/*    */ package mzm.gsp.pet;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.pet.main.PCDeletePetModel;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CDeletePetModel
/*    */   extends __CDeletePetModel__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12590710;
/*    */   public long pet_id;
/*    */   public int item_cfg_id;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     if (roleId < 0L) {
/* 21 */       return;
/*    */     }
/* 23 */     Role.addRoleProcedure(roleId, new PCDeletePetModel(roleId, this.pet_id, this.item_cfg_id));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 31 */     return 12590710;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CDeletePetModel() {}
/*    */   
/*    */ 
/*    */   public CDeletePetModel(long _pet_id_, int _item_cfg_id_)
/*    */   {
/* 41 */     this.pet_id = _pet_id_;
/* 42 */     this.item_cfg_id = _item_cfg_id_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.pet_id);
/* 51 */     _os_.marshal(this.item_cfg_id);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.pet_id = _os_.unmarshal_long();
/* 57 */     this.item_cfg_id = _os_.unmarshal_int();
/* 58 */     if (!_validator_()) {
/* 59 */       throw new VerifyError("validator failed");
/*    */     }
/* 61 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 65 */     if (_o1_ == this) return true;
/* 66 */     if ((_o1_ instanceof CDeletePetModel)) {
/* 67 */       CDeletePetModel _o_ = (CDeletePetModel)_o1_;
/* 68 */       if (this.pet_id != _o_.pet_id) return false;
/* 69 */       if (this.item_cfg_id != _o_.item_cfg_id) return false;
/* 70 */       return true;
/*    */     }
/* 72 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 76 */     int _h_ = 0;
/* 77 */     _h_ += (int)this.pet_id;
/* 78 */     _h_ += this.item_cfg_id;
/* 79 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 83 */     StringBuilder _sb_ = new StringBuilder();
/* 84 */     _sb_.append("(");
/* 85 */     _sb_.append(this.pet_id).append(",");
/* 86 */     _sb_.append(this.item_cfg_id).append(",");
/* 87 */     _sb_.append(")");
/* 88 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CDeletePetModel _o_) {
/* 92 */     if (_o_ == this) return 0;
/* 93 */     int _c_ = 0;
/* 94 */     _c_ = Long.signum(this.pet_id - _o_.pet_id);
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     _c_ = this.item_cfg_id - _o_.item_cfg_id;
/* 97 */     if (0 != _c_) return _c_;
/* 98 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\CDeletePetModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */