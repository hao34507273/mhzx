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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SGetSmallGroupShoppingItemInfoRes
/*     */   extends __SGetSmallGroupShoppingItemInfoRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12623625;
/*     */   public int group_shopping_item_cfgid;
/*     */   public int remaining_num;
/*     */   public int bought_num;
/*     */   public int shopping_group_num;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12623625;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SGetSmallGroupShoppingItemInfoRes() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SGetSmallGroupShoppingItemInfoRes(int _group_shopping_item_cfgid_, int _remaining_num_, int _bought_num_, int _shopping_group_num_)
/*     */   {
/*  39 */     this.group_shopping_item_cfgid = _group_shopping_item_cfgid_;
/*  40 */     this.remaining_num = _remaining_num_;
/*  41 */     this.bought_num = _bought_num_;
/*  42 */     this.shopping_group_num = _shopping_group_num_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  50 */     _os_.marshal(this.group_shopping_item_cfgid);
/*  51 */     _os_.marshal(this.remaining_num);
/*  52 */     _os_.marshal(this.bought_num);
/*  53 */     _os_.marshal(this.shopping_group_num);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.group_shopping_item_cfgid = _os_.unmarshal_int();
/*  59 */     this.remaining_num = _os_.unmarshal_int();
/*  60 */     this.bought_num = _os_.unmarshal_int();
/*  61 */     this.shopping_group_num = _os_.unmarshal_int();
/*  62 */     if (!_validator_()) {
/*  63 */       throw new VerifyError("validator failed");
/*     */     }
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  69 */     if (_o1_ == this) return true;
/*  70 */     if ((_o1_ instanceof SGetSmallGroupShoppingItemInfoRes)) {
/*  71 */       SGetSmallGroupShoppingItemInfoRes _o_ = (SGetSmallGroupShoppingItemInfoRes)_o1_;
/*  72 */       if (this.group_shopping_item_cfgid != _o_.group_shopping_item_cfgid) return false;
/*  73 */       if (this.remaining_num != _o_.remaining_num) return false;
/*  74 */       if (this.bought_num != _o_.bought_num) return false;
/*  75 */       if (this.shopping_group_num != _o_.shopping_group_num) return false;
/*  76 */       return true;
/*     */     }
/*  78 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  82 */     int _h_ = 0;
/*  83 */     _h_ += this.group_shopping_item_cfgid;
/*  84 */     _h_ += this.remaining_num;
/*  85 */     _h_ += this.bought_num;
/*  86 */     _h_ += this.shopping_group_num;
/*  87 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  91 */     StringBuilder _sb_ = new StringBuilder();
/*  92 */     _sb_.append("(");
/*  93 */     _sb_.append(this.group_shopping_item_cfgid).append(",");
/*  94 */     _sb_.append(this.remaining_num).append(",");
/*  95 */     _sb_.append(this.bought_num).append(",");
/*  96 */     _sb_.append(this.shopping_group_num).append(",");
/*  97 */     _sb_.append(")");
/*  98 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SGetSmallGroupShoppingItemInfoRes _o_) {
/* 102 */     if (_o_ == this) return 0;
/* 103 */     int _c_ = 0;
/* 104 */     _c_ = this.group_shopping_item_cfgid - _o_.group_shopping_item_cfgid;
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = this.remaining_num - _o_.remaining_num;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = this.bought_num - _o_.bought_num;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     _c_ = this.shopping_group_num - _o_.shopping_group_num;
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\groupshopping\SGetSmallGroupShoppingItemInfoRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */