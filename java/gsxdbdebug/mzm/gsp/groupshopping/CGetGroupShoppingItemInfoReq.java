/*    */ package mzm.gsp.groupshopping;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.groupshopping.main.GroupShoppingTaskManager;
/*    */ import mzm.gsp.groupshopping.main.PGetGroupShoppingItemInfo;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ 
/*    */ 
/*    */ public class CGetGroupShoppingItemInfoReq
/*    */   extends __CGetGroupShoppingItemInfoReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12623624;
/*    */   public int group_shopping_item_cfgid;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     boolean r = GroupShoppingTaskManager.addTask(new PGetGroupShoppingItemInfo(roleId, this.group_shopping_item_cfgid));
/*    */     
/* 22 */     if (!r)
/*    */     {
/* 24 */       SGetGroupShoppingItemInfoFail fail = new SGetGroupShoppingItemInfoFail();
/*    */       
/* 26 */       fail.group_shopping_item_cfgid = this.group_shopping_item_cfgid;
/* 27 */       fail.reason = 1;
/* 28 */       OnlineManager.getInstance().send(roleId, fail);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 37 */     return 12623624;
/*    */   }
/*    */   
/*    */ 
/*    */   public CGetGroupShoppingItemInfoReq() {}
/*    */   
/*    */ 
/*    */   public CGetGroupShoppingItemInfoReq(int _group_shopping_item_cfgid_)
/*    */   {
/* 46 */     this.group_shopping_item_cfgid = _group_shopping_item_cfgid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 50 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 54 */     _os_.marshal(this.group_shopping_item_cfgid);
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 59 */     this.group_shopping_item_cfgid = _os_.unmarshal_int();
/* 60 */     if (!_validator_()) {
/* 61 */       throw new VerifyError("validator failed");
/*    */     }
/* 63 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 67 */     if (_o1_ == this) return true;
/* 68 */     if ((_o1_ instanceof CGetGroupShoppingItemInfoReq)) {
/* 69 */       CGetGroupShoppingItemInfoReq _o_ = (CGetGroupShoppingItemInfoReq)_o1_;
/* 70 */       if (this.group_shopping_item_cfgid != _o_.group_shopping_item_cfgid) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += this.group_shopping_item_cfgid;
/* 79 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 83 */     StringBuilder _sb_ = new StringBuilder();
/* 84 */     _sb_.append("(");
/* 85 */     _sb_.append(this.group_shopping_item_cfgid).append(",");
/* 86 */     _sb_.append(")");
/* 87 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CGetGroupShoppingItemInfoReq _o_) {
/* 91 */     if (_o_ == this) return 0;
/* 92 */     int _c_ = 0;
/* 93 */     _c_ = this.group_shopping_item_cfgid - _o_.group_shopping_item_cfgid;
/* 94 */     if (0 != _c_) return _c_;
/* 95 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\groupshopping\CGetGroupShoppingItemInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */