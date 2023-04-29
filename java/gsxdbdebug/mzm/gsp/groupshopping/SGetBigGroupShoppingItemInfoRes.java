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
/*     */ public class SGetBigGroupShoppingItemInfoRes
/*     */   extends __SGetBigGroupShoppingItemInfoRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12623637;
/*     */   public int group_shopping_item_cfgid;
/*     */   public int remaining_num;
/*     */   public int bought_num;
/*     */   public long group_id;
/*     */   public int member_num;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12623637;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SGetBigGroupShoppingItemInfoRes() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SGetBigGroupShoppingItemInfoRes(int _group_shopping_item_cfgid_, int _remaining_num_, int _bought_num_, long _group_id_, int _member_num_)
/*     */   {
/*  40 */     this.group_shopping_item_cfgid = _group_shopping_item_cfgid_;
/*  41 */     this.remaining_num = _remaining_num_;
/*  42 */     this.bought_num = _bought_num_;
/*  43 */     this.group_id = _group_id_;
/*  44 */     this.member_num = _member_num_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.group_shopping_item_cfgid);
/*  53 */     _os_.marshal(this.remaining_num);
/*  54 */     _os_.marshal(this.bought_num);
/*  55 */     _os_.marshal(this.group_id);
/*  56 */     _os_.marshal(this.member_num);
/*  57 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  61 */     this.group_shopping_item_cfgid = _os_.unmarshal_int();
/*  62 */     this.remaining_num = _os_.unmarshal_int();
/*  63 */     this.bought_num = _os_.unmarshal_int();
/*  64 */     this.group_id = _os_.unmarshal_long();
/*  65 */     this.member_num = _os_.unmarshal_int();
/*  66 */     if (!_validator_()) {
/*  67 */       throw new VerifyError("validator failed");
/*     */     }
/*  69 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  73 */     if (_o1_ == this) return true;
/*  74 */     if ((_o1_ instanceof SGetBigGroupShoppingItemInfoRes)) {
/*  75 */       SGetBigGroupShoppingItemInfoRes _o_ = (SGetBigGroupShoppingItemInfoRes)_o1_;
/*  76 */       if (this.group_shopping_item_cfgid != _o_.group_shopping_item_cfgid) return false;
/*  77 */       if (this.remaining_num != _o_.remaining_num) return false;
/*  78 */       if (this.bought_num != _o_.bought_num) return false;
/*  79 */       if (this.group_id != _o_.group_id) return false;
/*  80 */       if (this.member_num != _o_.member_num) return false;
/*  81 */       return true;
/*     */     }
/*  83 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  87 */     int _h_ = 0;
/*  88 */     _h_ += this.group_shopping_item_cfgid;
/*  89 */     _h_ += this.remaining_num;
/*  90 */     _h_ += this.bought_num;
/*  91 */     _h_ += (int)this.group_id;
/*  92 */     _h_ += this.member_num;
/*  93 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  97 */     StringBuilder _sb_ = new StringBuilder();
/*  98 */     _sb_.append("(");
/*  99 */     _sb_.append(this.group_shopping_item_cfgid).append(",");
/* 100 */     _sb_.append(this.remaining_num).append(",");
/* 101 */     _sb_.append(this.bought_num).append(",");
/* 102 */     _sb_.append(this.group_id).append(",");
/* 103 */     _sb_.append(this.member_num).append(",");
/* 104 */     _sb_.append(")");
/* 105 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SGetBigGroupShoppingItemInfoRes _o_) {
/* 109 */     if (_o_ == this) return 0;
/* 110 */     int _c_ = 0;
/* 111 */     _c_ = this.group_shopping_item_cfgid - _o_.group_shopping_item_cfgid;
/* 112 */     if (0 != _c_) return _c_;
/* 113 */     _c_ = this.remaining_num - _o_.remaining_num;
/* 114 */     if (0 != _c_) return _c_;
/* 115 */     _c_ = this.bought_num - _o_.bought_num;
/* 116 */     if (0 != _c_) return _c_;
/* 117 */     _c_ = Long.signum(this.group_id - _o_.group_id);
/* 118 */     if (0 != _c_) return _c_;
/* 119 */     _c_ = this.member_num - _o_.member_num;
/* 120 */     if (0 != _c_) return _c_;
/* 121 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\groupshopping\SGetBigGroupShoppingItemInfoRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */