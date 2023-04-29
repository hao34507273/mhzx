/*    */ package mzm.gsp.groupshopping;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SBroadcastGroupShoppingCompleted
/*    */   extends __SBroadcastGroupShoppingCompleted__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12623635;
/*    */   public int group_shopping_item_cfgid;
/*    */   public long creator_role_id;
/*    */   public Octets creator_name;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12623635;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SBroadcastGroupShoppingCompleted()
/*    */   {
/* 35 */     this.creator_name = new Octets();
/*    */   }
/*    */   
/*    */   public SBroadcastGroupShoppingCompleted(int _group_shopping_item_cfgid_, long _creator_role_id_, Octets _creator_name_) {
/* 39 */     this.group_shopping_item_cfgid = _group_shopping_item_cfgid_;
/* 40 */     this.creator_role_id = _creator_role_id_;
/* 41 */     this.creator_name = _creator_name_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.group_shopping_item_cfgid);
/* 50 */     _os_.marshal(this.creator_role_id);
/* 51 */     _os_.marshal(this.creator_name);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.group_shopping_item_cfgid = _os_.unmarshal_int();
/* 57 */     this.creator_role_id = _os_.unmarshal_long();
/* 58 */     this.creator_name = _os_.unmarshal_Octets();
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof SBroadcastGroupShoppingCompleted)) {
/* 68 */       SBroadcastGroupShoppingCompleted _o_ = (SBroadcastGroupShoppingCompleted)_o1_;
/* 69 */       if (this.group_shopping_item_cfgid != _o_.group_shopping_item_cfgid) return false;
/* 70 */       if (this.creator_role_id != _o_.creator_role_id) return false;
/* 71 */       if (!this.creator_name.equals(_o_.creator_name)) return false;
/* 72 */       return true;
/*    */     }
/* 74 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 78 */     int _h_ = 0;
/* 79 */     _h_ += this.group_shopping_item_cfgid;
/* 80 */     _h_ += (int)this.creator_role_id;
/* 81 */     _h_ += this.creator_name.hashCode();
/* 82 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 86 */     StringBuilder _sb_ = new StringBuilder();
/* 87 */     _sb_.append("(");
/* 88 */     _sb_.append(this.group_shopping_item_cfgid).append(",");
/* 89 */     _sb_.append(this.creator_role_id).append(",");
/* 90 */     _sb_.append("B").append(this.creator_name.size()).append(",");
/* 91 */     _sb_.append(")");
/* 92 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\groupshopping\SBroadcastGroupShoppingCompleted.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */