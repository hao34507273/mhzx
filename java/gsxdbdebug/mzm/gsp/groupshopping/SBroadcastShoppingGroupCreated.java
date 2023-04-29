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
/*    */ public class SBroadcastShoppingGroupCreated
/*    */   extends __SBroadcastShoppingGroupCreated__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12623621;
/*    */   public long group_id;
/*    */   public int group_shopping_item_cfgid;
/*    */   public long creator_role_id;
/*    */   public Octets creator_name;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12623621;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SBroadcastShoppingGroupCreated()
/*    */   {
/* 36 */     this.creator_name = new Octets();
/*    */   }
/*    */   
/*    */   public SBroadcastShoppingGroupCreated(long _group_id_, int _group_shopping_item_cfgid_, long _creator_role_id_, Octets _creator_name_) {
/* 40 */     this.group_id = _group_id_;
/* 41 */     this.group_shopping_item_cfgid = _group_shopping_item_cfgid_;
/* 42 */     this.creator_role_id = _creator_role_id_;
/* 43 */     this.creator_name = _creator_name_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.group_id);
/* 52 */     _os_.marshal(this.group_shopping_item_cfgid);
/* 53 */     _os_.marshal(this.creator_role_id);
/* 54 */     _os_.marshal(this.creator_name);
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 59 */     this.group_id = _os_.unmarshal_long();
/* 60 */     this.group_shopping_item_cfgid = _os_.unmarshal_int();
/* 61 */     this.creator_role_id = _os_.unmarshal_long();
/* 62 */     this.creator_name = _os_.unmarshal_Octets();
/* 63 */     if (!_validator_()) {
/* 64 */       throw new VerifyError("validator failed");
/*    */     }
/* 66 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 70 */     if (_o1_ == this) return true;
/* 71 */     if ((_o1_ instanceof SBroadcastShoppingGroupCreated)) {
/* 72 */       SBroadcastShoppingGroupCreated _o_ = (SBroadcastShoppingGroupCreated)_o1_;
/* 73 */       if (this.group_id != _o_.group_id) return false;
/* 74 */       if (this.group_shopping_item_cfgid != _o_.group_shopping_item_cfgid) return false;
/* 75 */       if (this.creator_role_id != _o_.creator_role_id) return false;
/* 76 */       if (!this.creator_name.equals(_o_.creator_name)) return false;
/* 77 */       return true;
/*    */     }
/* 79 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 83 */     int _h_ = 0;
/* 84 */     _h_ += (int)this.group_id;
/* 85 */     _h_ += this.group_shopping_item_cfgid;
/* 86 */     _h_ += (int)this.creator_role_id;
/* 87 */     _h_ += this.creator_name.hashCode();
/* 88 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 92 */     StringBuilder _sb_ = new StringBuilder();
/* 93 */     _sb_.append("(");
/* 94 */     _sb_.append(this.group_id).append(",");
/* 95 */     _sb_.append(this.group_shopping_item_cfgid).append(",");
/* 96 */     _sb_.append(this.creator_role_id).append(",");
/* 97 */     _sb_.append("B").append(this.creator_name.size()).append(",");
/* 98 */     _sb_.append(")");
/* 99 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\groupshopping\SBroadcastShoppingGroupCreated.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */