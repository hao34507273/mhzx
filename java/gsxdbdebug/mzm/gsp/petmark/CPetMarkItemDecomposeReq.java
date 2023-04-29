/*    */ package mzm.gsp.petmark;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.petmark.main.PCPetMarkItemDecomposeReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CPetMarkItemDecomposeReq
/*    */   extends __CPetMarkItemDecomposeReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12628498;
/*    */   public int item_cfg_id;
/*    */   public byte decompose_all;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleId = Role.getRoleId(this);
/* 21 */     if (roleId < 0L) {
/* 22 */       return;
/*    */     }
/* 24 */     Role.addRoleProcedure(roleId, new PCPetMarkItemDecomposeReq(roleId, this.item_cfg_id, this.decompose_all));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 32 */     return 12628498;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CPetMarkItemDecomposeReq() {}
/*    */   
/*    */ 
/*    */   public CPetMarkItemDecomposeReq(int _item_cfg_id_, byte _decompose_all_)
/*    */   {
/* 42 */     this.item_cfg_id = _item_cfg_id_;
/* 43 */     this.decompose_all = _decompose_all_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.item_cfg_id);
/* 52 */     _os_.marshal(this.decompose_all);
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     this.item_cfg_id = _os_.unmarshal_int();
/* 58 */     this.decompose_all = _os_.unmarshal_byte();
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof CPetMarkItemDecomposeReq)) {
/* 68 */       CPetMarkItemDecomposeReq _o_ = (CPetMarkItemDecomposeReq)_o1_;
/* 69 */       if (this.item_cfg_id != _o_.item_cfg_id) return false;
/* 70 */       if (this.decompose_all != _o_.decompose_all) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += this.item_cfg_id;
/* 79 */     _h_ += this.decompose_all;
/* 80 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 84 */     StringBuilder _sb_ = new StringBuilder();
/* 85 */     _sb_.append("(");
/* 86 */     _sb_.append(this.item_cfg_id).append(",");
/* 87 */     _sb_.append(this.decompose_all).append(",");
/* 88 */     _sb_.append(")");
/* 89 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CPetMarkItemDecomposeReq _o_) {
/* 93 */     if (_o_ == this) return 0;
/* 94 */     int _c_ = 0;
/* 95 */     _c_ = this.item_cfg_id - _o_.item_cfg_id;
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     _c_ = this.decompose_all - _o_.decompose_all;
/* 98 */     if (0 != _c_) return _c_;
/* 99 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petmark\CPetMarkItemDecomposeReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */