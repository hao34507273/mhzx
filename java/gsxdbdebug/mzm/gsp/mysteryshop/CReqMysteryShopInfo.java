/*    */ package mzm.gsp.mysteryshop;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.mysteryshop.main.PSynMysteryShopInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CReqMysteryShopInfo
/*    */   extends __CReqMysteryShopInfo__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12614403;
/*    */   public int shoptype;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     if (roleId <= 0L)
/*    */     {
/* 22 */       return;
/*    */     }
/* 24 */     Role.addRoleProcedure(roleId, new PSynMysteryShopInfo(roleId, this.shoptype));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 32 */     return 12614403;
/*    */   }
/*    */   
/*    */ 
/*    */   public CReqMysteryShopInfo() {}
/*    */   
/*    */ 
/*    */   public CReqMysteryShopInfo(int _shoptype_)
/*    */   {
/* 41 */     this.shoptype = _shoptype_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.shoptype);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.shoptype = _os_.unmarshal_int();
/* 55 */     if (!_validator_()) {
/* 56 */       throw new VerifyError("validator failed");
/*    */     }
/* 58 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 62 */     if (_o1_ == this) return true;
/* 63 */     if ((_o1_ instanceof CReqMysteryShopInfo)) {
/* 64 */       CReqMysteryShopInfo _o_ = (CReqMysteryShopInfo)_o1_;
/* 65 */       if (this.shoptype != _o_.shoptype) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.shoptype;
/* 74 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 78 */     StringBuilder _sb_ = new StringBuilder();
/* 79 */     _sb_.append("(");
/* 80 */     _sb_.append(this.shoptype).append(",");
/* 81 */     _sb_.append(")");
/* 82 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CReqMysteryShopInfo _o_) {
/* 86 */     if (_o_ == this) return 0;
/* 87 */     int _c_ = 0;
/* 88 */     _c_ = this.shoptype - _o_.shoptype;
/* 89 */     if (0 != _c_) return _c_;
/* 90 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mysteryshop\CReqMysteryShopInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */