/*    */ package mzm.gsp.role;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.role.main.PConfirmUseDrug;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CConfirmUseDrugResult
/*    */   extends __CConfirmUseDrugResult__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12586014;
/*    */   public int itemkey;
/*    */   public int bagid;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     if (roleId < 0L) {
/* 21 */       return;
/*    */     }
/* 23 */     Role.addRoleProcedure(roleId, new PConfirmUseDrug(roleId, this.itemkey, this.bagid));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 31 */     return 12586014;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CConfirmUseDrugResult() {}
/*    */   
/*    */ 
/*    */   public CConfirmUseDrugResult(int _itemkey_, int _bagid_)
/*    */   {
/* 41 */     this.itemkey = _itemkey_;
/* 42 */     this.bagid = _bagid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.itemkey);
/* 51 */     _os_.marshal(this.bagid);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.itemkey = _os_.unmarshal_int();
/* 57 */     this.bagid = _os_.unmarshal_int();
/* 58 */     if (!_validator_()) {
/* 59 */       throw new VerifyError("validator failed");
/*    */     }
/* 61 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 65 */     if (_o1_ == this) return true;
/* 66 */     if ((_o1_ instanceof CConfirmUseDrugResult)) {
/* 67 */       CConfirmUseDrugResult _o_ = (CConfirmUseDrugResult)_o1_;
/* 68 */       if (this.itemkey != _o_.itemkey) return false;
/* 69 */       if (this.bagid != _o_.bagid) return false;
/* 70 */       return true;
/*    */     }
/* 72 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 76 */     int _h_ = 0;
/* 77 */     _h_ += this.itemkey;
/* 78 */     _h_ += this.bagid;
/* 79 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 83 */     StringBuilder _sb_ = new StringBuilder();
/* 84 */     _sb_.append("(");
/* 85 */     _sb_.append(this.itemkey).append(",");
/* 86 */     _sb_.append(this.bagid).append(",");
/* 87 */     _sb_.append(")");
/* 88 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CConfirmUseDrugResult _o_) {
/* 92 */     if (_o_ == this) return 0;
/* 93 */     int _c_ = 0;
/* 94 */     _c_ = this.itemkey - _o_.itemkey;
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     _c_ = this.bagid - _o_.bagid;
/* 97 */     if (0 != _c_) return _c_;
/* 98 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\CConfirmUseDrugResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */