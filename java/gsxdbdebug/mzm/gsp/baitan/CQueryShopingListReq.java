/*    */ package mzm.gsp.baitan;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.baitan.main.PQueryShoppingListReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CQueryShopingListReq
/*    */   extends __CQueryShopingListReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12584988;
/*    */   public int subtype;
/*    */   public int param;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleId = Role.getRoleId(this);
/* 21 */     if (roleId < 0L) {
/* 22 */       return;
/*    */     }
/* 24 */     Role.addRoleProcedure(roleId, new PQueryShoppingListReq(roleId, this.subtype, this.param));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 32 */     return 12584988;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CQueryShopingListReq() {}
/*    */   
/*    */ 
/*    */   public CQueryShopingListReq(int _subtype_, int _param_)
/*    */   {
/* 42 */     this.subtype = _subtype_;
/* 43 */     this.param = _param_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.subtype);
/* 52 */     _os_.marshal(this.param);
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     this.subtype = _os_.unmarshal_int();
/* 58 */     this.param = _os_.unmarshal_int();
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof CQueryShopingListReq)) {
/* 68 */       CQueryShopingListReq _o_ = (CQueryShopingListReq)_o1_;
/* 69 */       if (this.subtype != _o_.subtype) return false;
/* 70 */       if (this.param != _o_.param) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += this.subtype;
/* 79 */     _h_ += this.param;
/* 80 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 84 */     StringBuilder _sb_ = new StringBuilder();
/* 85 */     _sb_.append("(");
/* 86 */     _sb_.append(this.subtype).append(",");
/* 87 */     _sb_.append(this.param).append(",");
/* 88 */     _sb_.append(")");
/* 89 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CQueryShopingListReq _o_) {
/* 93 */     if (_o_ == this) return 0;
/* 94 */     int _c_ = 0;
/* 95 */     _c_ = this.subtype - _o_.subtype;
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     _c_ = this.param - _o_.param;
/* 98 */     if (0 != _c_) return _c_;
/* 99 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\baitan\CQueryShopingListReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */