/*     */ package mzm.gsp.mysteryshop;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ 
/*     */ public class CBuyMysteryGoodsReq extends __CBuyMysteryGoodsReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12614406;
/*     */   public int shoptype;
/*     */   public int goods_index;
/*     */   public int goods_id;
/*     */   public int count;
/*     */   public int client_cost_type;
/*     */   public long client_cost_num;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     long roleId = Role.getRoleId(this);
/*  20 */     if (roleId <= 0L)
/*     */     {
/*  22 */       return;
/*     */     }
/*  24 */     Role.addRoleProcedure(roleId, new mzm.gsp.mysteryshop.main.PBuyMysteryGoods(roleId, this.shoptype, this.goods_index - 1, this.goods_id, this.count, this.client_cost_type, this.client_cost_num));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  32 */     return 12614406;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public CBuyMysteryGoodsReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CBuyMysteryGoodsReq(int _shoptype_, int _goods_index_, int _goods_id_, int _count_, int _client_cost_type_, long _client_cost_num_)
/*     */   {
/*  46 */     this.shoptype = _shoptype_;
/*  47 */     this.goods_index = _goods_index_;
/*  48 */     this.goods_id = _goods_id_;
/*  49 */     this.count = _count_;
/*  50 */     this.client_cost_type = _client_cost_type_;
/*  51 */     this.client_cost_num = _client_cost_num_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  55 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  59 */     _os_.marshal(this.shoptype);
/*  60 */     _os_.marshal(this.goods_index);
/*  61 */     _os_.marshal(this.goods_id);
/*  62 */     _os_.marshal(this.count);
/*  63 */     _os_.marshal(this.client_cost_type);
/*  64 */     _os_.marshal(this.client_cost_num);
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  69 */     this.shoptype = _os_.unmarshal_int();
/*  70 */     this.goods_index = _os_.unmarshal_int();
/*  71 */     this.goods_id = _os_.unmarshal_int();
/*  72 */     this.count = _os_.unmarshal_int();
/*  73 */     this.client_cost_type = _os_.unmarshal_int();
/*  74 */     this.client_cost_num = _os_.unmarshal_long();
/*  75 */     if (!_validator_()) {
/*  76 */       throw new VerifyError("validator failed");
/*     */     }
/*  78 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  82 */     if (_o1_ == this) return true;
/*  83 */     if ((_o1_ instanceof CBuyMysteryGoodsReq)) {
/*  84 */       CBuyMysteryGoodsReq _o_ = (CBuyMysteryGoodsReq)_o1_;
/*  85 */       if (this.shoptype != _o_.shoptype) return false;
/*  86 */       if (this.goods_index != _o_.goods_index) return false;
/*  87 */       if (this.goods_id != _o_.goods_id) return false;
/*  88 */       if (this.count != _o_.count) return false;
/*  89 */       if (this.client_cost_type != _o_.client_cost_type) return false;
/*  90 */       if (this.client_cost_num != _o_.client_cost_num) return false;
/*  91 */       return true;
/*     */     }
/*  93 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  97 */     int _h_ = 0;
/*  98 */     _h_ += this.shoptype;
/*  99 */     _h_ += this.goods_index;
/* 100 */     _h_ += this.goods_id;
/* 101 */     _h_ += this.count;
/* 102 */     _h_ += this.client_cost_type;
/* 103 */     _h_ += (int)this.client_cost_num;
/* 104 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 108 */     StringBuilder _sb_ = new StringBuilder();
/* 109 */     _sb_.append("(");
/* 110 */     _sb_.append(this.shoptype).append(",");
/* 111 */     _sb_.append(this.goods_index).append(",");
/* 112 */     _sb_.append(this.goods_id).append(",");
/* 113 */     _sb_.append(this.count).append(",");
/* 114 */     _sb_.append(this.client_cost_type).append(",");
/* 115 */     _sb_.append(this.client_cost_num).append(",");
/* 116 */     _sb_.append(")");
/* 117 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CBuyMysteryGoodsReq _o_) {
/* 121 */     if (_o_ == this) return 0;
/* 122 */     int _c_ = 0;
/* 123 */     _c_ = this.shoptype - _o_.shoptype;
/* 124 */     if (0 != _c_) return _c_;
/* 125 */     _c_ = this.goods_index - _o_.goods_index;
/* 126 */     if (0 != _c_) return _c_;
/* 127 */     _c_ = this.goods_id - _o_.goods_id;
/* 128 */     if (0 != _c_) return _c_;
/* 129 */     _c_ = this.count - _o_.count;
/* 130 */     if (0 != _c_) return _c_;
/* 131 */     _c_ = this.client_cost_type - _o_.client_cost_type;
/* 132 */     if (0 != _c_) return _c_;
/* 133 */     _c_ = Long.signum(this.client_cost_num - _o_.client_cost_num);
/* 134 */     if (0 != _c_) return _c_;
/* 135 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mysteryshop\CBuyMysteryGoodsReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */