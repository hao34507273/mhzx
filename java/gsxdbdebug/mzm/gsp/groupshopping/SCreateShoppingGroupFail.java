/*     */ package mzm.gsp.groupshopping;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SCreateShoppingGroupFail
/*     */   extends __SCreateShoppingGroupFail__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12623628;
/*     */   public static final int INSUFFICIENT_YUANBAO = 1;
/*     */   public static final int SOLD_OUT = 2;
/*     */   public static final int CREATED = 3;
/*     */   public static final int REACH_BUY_LIMIT = 4;
/*     */   public static final int SYSTEM_BUSY = 5;
/*     */   public int reason;
/*     */   public int group_shopping_item_cfgid;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12623628;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SCreateShoppingGroupFail() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SCreateShoppingGroupFail(int _reason_, int _group_shopping_item_cfgid_)
/*     */   {
/*  43 */     this.reason = _reason_;
/*  44 */     this.group_shopping_item_cfgid = _group_shopping_item_cfgid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.reason);
/*  53 */     _os_.marshal(this.group_shopping_item_cfgid);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.reason = _os_.unmarshal_int();
/*  59 */     this.group_shopping_item_cfgid = _os_.unmarshal_int();
/*  60 */     if (!_validator_()) {
/*  61 */       throw new VerifyError("validator failed");
/*     */     }
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  67 */     if (_o1_ == this) return true;
/*  68 */     if ((_o1_ instanceof SCreateShoppingGroupFail)) {
/*  69 */       SCreateShoppingGroupFail _o_ = (SCreateShoppingGroupFail)_o1_;
/*  70 */       if (this.reason != _o_.reason) return false;
/*  71 */       if (this.group_shopping_item_cfgid != _o_.group_shopping_item_cfgid) return false;
/*  72 */       return true;
/*     */     }
/*  74 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  78 */     int _h_ = 0;
/*  79 */     _h_ += this.reason;
/*  80 */     _h_ += this.group_shopping_item_cfgid;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.reason).append(",");
/*  88 */     _sb_.append(this.group_shopping_item_cfgid).append(",");
/*  89 */     _sb_.append(")");
/*  90 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SCreateShoppingGroupFail _o_) {
/*  94 */     if (_o_ == this) return 0;
/*  95 */     int _c_ = 0;
/*  96 */     _c_ = this.reason - _o_.reason;
/*  97 */     if (0 != _c_) return _c_;
/*  98 */     _c_ = this.group_shopping_item_cfgid - _o_.group_shopping_item_cfgid;
/*  99 */     if (0 != _c_) return _c_;
/* 100 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\groupshopping\SCreateShoppingGroupFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */