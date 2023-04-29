/*    */ package mzm.gsp.baitan;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.baitan.main.PFressRefreshShoppingListReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CFreeRefreshShopingListReq
/*    */   extends __CFreeRefreshShopingListReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12584970;
/*    */   public int subtype;
/*    */   public int param;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     if (roleId < 0L) {
/* 21 */       return;
/*    */     }
/* 23 */     Role.addRoleProcedure(roleId, new PFressRefreshShoppingListReq(roleId, this.subtype, this.param));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 31 */     return 12584970;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CFreeRefreshShopingListReq() {}
/*    */   
/*    */ 
/*    */   public CFreeRefreshShopingListReq(int _subtype_, int _param_)
/*    */   {
/* 41 */     this.subtype = _subtype_;
/* 42 */     this.param = _param_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.subtype);
/* 51 */     _os_.marshal(this.param);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.subtype = _os_.unmarshal_int();
/* 57 */     this.param = _os_.unmarshal_int();
/* 58 */     if (!_validator_()) {
/* 59 */       throw new VerifyError("validator failed");
/*    */     }
/* 61 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 65 */     if (_o1_ == this) return true;
/* 66 */     if ((_o1_ instanceof CFreeRefreshShopingListReq)) {
/* 67 */       CFreeRefreshShopingListReq _o_ = (CFreeRefreshShopingListReq)_o1_;
/* 68 */       if (this.subtype != _o_.subtype) return false;
/* 69 */       if (this.param != _o_.param) return false;
/* 70 */       return true;
/*    */     }
/* 72 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 76 */     int _h_ = 0;
/* 77 */     _h_ += this.subtype;
/* 78 */     _h_ += this.param;
/* 79 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 83 */     StringBuilder _sb_ = new StringBuilder();
/* 84 */     _sb_.append("(");
/* 85 */     _sb_.append(this.subtype).append(",");
/* 86 */     _sb_.append(this.param).append(",");
/* 87 */     _sb_.append(")");
/* 88 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CFreeRefreshShopingListReq _o_) {
/* 92 */     if (_o_ == this) return 0;
/* 93 */     int _c_ = 0;
/* 94 */     _c_ = this.subtype - _o_.subtype;
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     _c_ = this.param - _o_.param;
/* 97 */     if (0 != _c_) return _c_;
/* 98 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\baitan\CFreeRefreshShopingListReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */