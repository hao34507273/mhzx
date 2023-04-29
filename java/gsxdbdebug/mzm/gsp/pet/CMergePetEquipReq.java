/*    */ package mzm.gsp.pet;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.pet.main.PMergePetEquipReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CMergePetEquipReq
/*    */   extends __CMergePetEquipReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12590633;
/*    */   public int itemkey1;
/*    */   public int itemkey2;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     if (roleId < 0L) {
/* 21 */       return;
/*    */     }
/* 23 */     Role.addRoleProcedure(roleId, new PMergePetEquipReq(roleId, this.itemkey1, this.itemkey2));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 31 */     return 12590633;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CMergePetEquipReq() {}
/*    */   
/*    */ 
/*    */   public CMergePetEquipReq(int _itemkey1_, int _itemkey2_)
/*    */   {
/* 41 */     this.itemkey1 = _itemkey1_;
/* 42 */     this.itemkey2 = _itemkey2_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.itemkey1);
/* 51 */     _os_.marshal(this.itemkey2);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.itemkey1 = _os_.unmarshal_int();
/* 57 */     this.itemkey2 = _os_.unmarshal_int();
/* 58 */     if (!_validator_()) {
/* 59 */       throw new VerifyError("validator failed");
/*    */     }
/* 61 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 65 */     if (_o1_ == this) return true;
/* 66 */     if ((_o1_ instanceof CMergePetEquipReq)) {
/* 67 */       CMergePetEquipReq _o_ = (CMergePetEquipReq)_o1_;
/* 68 */       if (this.itemkey1 != _o_.itemkey1) return false;
/* 69 */       if (this.itemkey2 != _o_.itemkey2) return false;
/* 70 */       return true;
/*    */     }
/* 72 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 76 */     int _h_ = 0;
/* 77 */     _h_ += this.itemkey1;
/* 78 */     _h_ += this.itemkey2;
/* 79 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 83 */     StringBuilder _sb_ = new StringBuilder();
/* 84 */     _sb_.append("(");
/* 85 */     _sb_.append(this.itemkey1).append(",");
/* 86 */     _sb_.append(this.itemkey2).append(",");
/* 87 */     _sb_.append(")");
/* 88 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CMergePetEquipReq _o_) {
/* 92 */     if (_o_ == this) return 0;
/* 93 */     int _c_ = 0;
/* 94 */     _c_ = this.itemkey1 - _o_.itemkey1;
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     _c_ = this.itemkey2 - _o_.itemkey2;
/* 97 */     if (0 != _c_) return _c_;
/* 98 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\CMergePetEquipReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */