/*    */ package mzm.gsp.fabaolingqi;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.fabaolingqi.main.PUseArtifactItem;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CUseExchangeItemReq
/*    */   extends __CUseExchangeItemReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12618241;
/*    */   public int item_key;
/*    */   public int use_all_items;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     if (roleId < 0L)
/* 21 */       return;
/* 22 */     boolean useAllItems = this.use_all_items == 1;
/* 23 */     Role.addRoleProcedure(roleId, new PUseArtifactItem(roleId, this.item_key, useAllItems));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 31 */     return 12618241;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CUseExchangeItemReq() {}
/*    */   
/*    */ 
/*    */   public CUseExchangeItemReq(int _item_key_, int _use_all_items_)
/*    */   {
/* 41 */     this.item_key = _item_key_;
/* 42 */     this.use_all_items = _use_all_items_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.item_key);
/* 51 */     _os_.marshal(this.use_all_items);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.item_key = _os_.unmarshal_int();
/* 57 */     this.use_all_items = _os_.unmarshal_int();
/* 58 */     if (!_validator_()) {
/* 59 */       throw new VerifyError("validator failed");
/*    */     }
/* 61 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 65 */     if (_o1_ == this) return true;
/* 66 */     if ((_o1_ instanceof CUseExchangeItemReq)) {
/* 67 */       CUseExchangeItemReq _o_ = (CUseExchangeItemReq)_o1_;
/* 68 */       if (this.item_key != _o_.item_key) return false;
/* 69 */       if (this.use_all_items != _o_.use_all_items) return false;
/* 70 */       return true;
/*    */     }
/* 72 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 76 */     int _h_ = 0;
/* 77 */     _h_ += this.item_key;
/* 78 */     _h_ += this.use_all_items;
/* 79 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 83 */     StringBuilder _sb_ = new StringBuilder();
/* 84 */     _sb_.append("(");
/* 85 */     _sb_.append(this.item_key).append(",");
/* 86 */     _sb_.append(this.use_all_items).append(",");
/* 87 */     _sb_.append(")");
/* 88 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CUseExchangeItemReq _o_) {
/* 92 */     if (_o_ == this) return 0;
/* 93 */     int _c_ = 0;
/* 94 */     _c_ = this.item_key - _o_.item_key;
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     _c_ = this.use_all_items - _o_.use_all_items;
/* 97 */     if (0 != _c_) return _c_;
/* 98 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabaolingqi\CUseExchangeItemReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */