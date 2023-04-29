/*    */ package mzm.gsp.groupshopping;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SGroupShoppingDirectBuyFail
/*    */   extends __SGroupShoppingDirectBuyFail__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12623626;
/*    */   public static final int INSUFFICIENT_YUANBAO = 1;
/*    */   public static final int REACH_BUY_LIMIT = 2;
/*    */   public static final int NOT_STARTED = 3;
/*    */   public static final int FULL_BAG = 4;
/*    */   public int reason;
/*    */   public int group_shopping_item_cfgid;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12623626;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SGroupShoppingDirectBuyFail() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SGroupShoppingDirectBuyFail(int _reason_, int _group_shopping_item_cfgid_)
/*    */   {
/* 42 */     this.reason = _reason_;
/* 43 */     this.group_shopping_item_cfgid = _group_shopping_item_cfgid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.reason);
/* 52 */     _os_.marshal(this.group_shopping_item_cfgid);
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     this.reason = _os_.unmarshal_int();
/* 58 */     this.group_shopping_item_cfgid = _os_.unmarshal_int();
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof SGroupShoppingDirectBuyFail)) {
/* 68 */       SGroupShoppingDirectBuyFail _o_ = (SGroupShoppingDirectBuyFail)_o1_;
/* 69 */       if (this.reason != _o_.reason) return false;
/* 70 */       if (this.group_shopping_item_cfgid != _o_.group_shopping_item_cfgid) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += this.reason;
/* 79 */     _h_ += this.group_shopping_item_cfgid;
/* 80 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 84 */     StringBuilder _sb_ = new StringBuilder();
/* 85 */     _sb_.append("(");
/* 86 */     _sb_.append(this.reason).append(",");
/* 87 */     _sb_.append(this.group_shopping_item_cfgid).append(",");
/* 88 */     _sb_.append(")");
/* 89 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SGroupShoppingDirectBuyFail _o_) {
/* 93 */     if (_o_ == this) return 0;
/* 94 */     int _c_ = 0;
/* 95 */     _c_ = this.reason - _o_.reason;
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     _c_ = this.group_shopping_item_cfgid - _o_.group_shopping_item_cfgid;
/* 98 */     if (0 != _c_) return _c_;
/* 99 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\groupshopping\SGroupShoppingDirectBuyFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */