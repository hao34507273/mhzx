/*    */ package mzm.gsp.groupshopping;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.groupshopping.main.PGroupShoppingDirectBuy;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CGroupShoppingDirectBuyReq
/*    */   extends __CGroupShoppingDirectBuyReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12623633;
/*    */   public int group_shopping_item_cfgid;
/*    */   public long current_yuanbao;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     Role.addRoleProcedure(roleId, new PGroupShoppingDirectBuy(roleId, this.group_shopping_item_cfgid, this.current_yuanbao));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 29 */     return 12623633;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CGroupShoppingDirectBuyReq() {}
/*    */   
/*    */ 
/*    */   public CGroupShoppingDirectBuyReq(int _group_shopping_item_cfgid_, long _current_yuanbao_)
/*    */   {
/* 39 */     this.group_shopping_item_cfgid = _group_shopping_item_cfgid_;
/* 40 */     this.current_yuanbao = _current_yuanbao_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.group_shopping_item_cfgid);
/* 49 */     _os_.marshal(this.current_yuanbao);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.group_shopping_item_cfgid = _os_.unmarshal_int();
/* 55 */     this.current_yuanbao = _os_.unmarshal_long();
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof CGroupShoppingDirectBuyReq)) {
/* 65 */       CGroupShoppingDirectBuyReq _o_ = (CGroupShoppingDirectBuyReq)_o1_;
/* 66 */       if (this.group_shopping_item_cfgid != _o_.group_shopping_item_cfgid) return false;
/* 67 */       if (this.current_yuanbao != _o_.current_yuanbao) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += this.group_shopping_item_cfgid;
/* 76 */     _h_ += (int)this.current_yuanbao;
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.group_shopping_item_cfgid).append(",");
/* 84 */     _sb_.append(this.current_yuanbao).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CGroupShoppingDirectBuyReq _o_) {
/* 90 */     if (_o_ == this) return 0;
/* 91 */     int _c_ = 0;
/* 92 */     _c_ = this.group_shopping_item_cfgid - _o_.group_shopping_item_cfgid;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     _c_ = Long.signum(this.current_yuanbao - _o_.current_yuanbao);
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\groupshopping\CGroupShoppingDirectBuyReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */