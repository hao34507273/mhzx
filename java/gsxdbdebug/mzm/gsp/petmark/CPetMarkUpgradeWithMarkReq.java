/*    */ package mzm.gsp.petmark;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.petmark.main.PCPetMarkUpgradeWithMarkReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CPetMarkUpgradeWithMarkReq
/*    */   extends __CPetMarkUpgradeWithMarkReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12628505;
/*    */   public long main_pet_mark_id;
/*    */   public long cost_pet_mark_id;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleId = Role.getRoleId(this);
/* 21 */     if (roleId < 0L) {
/* 22 */       return;
/*    */     }
/* 24 */     Role.addRoleProcedure(roleId, new PCPetMarkUpgradeWithMarkReq(roleId, this.main_pet_mark_id, this.cost_pet_mark_id));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 32 */     return 12628505;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CPetMarkUpgradeWithMarkReq() {}
/*    */   
/*    */ 
/*    */   public CPetMarkUpgradeWithMarkReq(long _main_pet_mark_id_, long _cost_pet_mark_id_)
/*    */   {
/* 42 */     this.main_pet_mark_id = _main_pet_mark_id_;
/* 43 */     this.cost_pet_mark_id = _cost_pet_mark_id_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.main_pet_mark_id);
/* 52 */     _os_.marshal(this.cost_pet_mark_id);
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     this.main_pet_mark_id = _os_.unmarshal_long();
/* 58 */     this.cost_pet_mark_id = _os_.unmarshal_long();
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof CPetMarkUpgradeWithMarkReq)) {
/* 68 */       CPetMarkUpgradeWithMarkReq _o_ = (CPetMarkUpgradeWithMarkReq)_o1_;
/* 69 */       if (this.main_pet_mark_id != _o_.main_pet_mark_id) return false;
/* 70 */       if (this.cost_pet_mark_id != _o_.cost_pet_mark_id) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += (int)this.main_pet_mark_id;
/* 79 */     _h_ += (int)this.cost_pet_mark_id;
/* 80 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 84 */     StringBuilder _sb_ = new StringBuilder();
/* 85 */     _sb_.append("(");
/* 86 */     _sb_.append(this.main_pet_mark_id).append(",");
/* 87 */     _sb_.append(this.cost_pet_mark_id).append(",");
/* 88 */     _sb_.append(")");
/* 89 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CPetMarkUpgradeWithMarkReq _o_) {
/* 93 */     if (_o_ == this) return 0;
/* 94 */     int _c_ = 0;
/* 95 */     _c_ = Long.signum(this.main_pet_mark_id - _o_.main_pet_mark_id);
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     _c_ = Long.signum(this.cost_pet_mark_id - _o_.cost_pet_mark_id);
/* 98 */     if (0 != _c_) return _c_;
/* 99 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petmark\CPetMarkUpgradeWithMarkReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */