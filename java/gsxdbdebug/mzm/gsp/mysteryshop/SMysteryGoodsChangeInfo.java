/*     */ package mzm.gsp.mysteryshop;
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
/*     */ public class SMysteryGoodsChangeInfo
/*     */   extends __SMysteryGoodsChangeInfo__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12614401;
/*     */   public int shoptype;
/*     */   public int goods_index;
/*     */   public int goods_id;
/*     */   public int count;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12614401;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SMysteryGoodsChangeInfo() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SMysteryGoodsChangeInfo(int _shoptype_, int _goods_index_, int _goods_id_, int _count_)
/*     */   {
/*  39 */     this.shoptype = _shoptype_;
/*  40 */     this.goods_index = _goods_index_;
/*  41 */     this.goods_id = _goods_id_;
/*  42 */     this.count = _count_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  50 */     _os_.marshal(this.shoptype);
/*  51 */     _os_.marshal(this.goods_index);
/*  52 */     _os_.marshal(this.goods_id);
/*  53 */     _os_.marshal(this.count);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.shoptype = _os_.unmarshal_int();
/*  59 */     this.goods_index = _os_.unmarshal_int();
/*  60 */     this.goods_id = _os_.unmarshal_int();
/*  61 */     this.count = _os_.unmarshal_int();
/*  62 */     if (!_validator_()) {
/*  63 */       throw new VerifyError("validator failed");
/*     */     }
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  69 */     if (_o1_ == this) return true;
/*  70 */     if ((_o1_ instanceof SMysteryGoodsChangeInfo)) {
/*  71 */       SMysteryGoodsChangeInfo _o_ = (SMysteryGoodsChangeInfo)_o1_;
/*  72 */       if (this.shoptype != _o_.shoptype) return false;
/*  73 */       if (this.goods_index != _o_.goods_index) return false;
/*  74 */       if (this.goods_id != _o_.goods_id) return false;
/*  75 */       if (this.count != _o_.count) return false;
/*  76 */       return true;
/*     */     }
/*  78 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  82 */     int _h_ = 0;
/*  83 */     _h_ += this.shoptype;
/*  84 */     _h_ += this.goods_index;
/*  85 */     _h_ += this.goods_id;
/*  86 */     _h_ += this.count;
/*  87 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  91 */     StringBuilder _sb_ = new StringBuilder();
/*  92 */     _sb_.append("(");
/*  93 */     _sb_.append(this.shoptype).append(",");
/*  94 */     _sb_.append(this.goods_index).append(",");
/*  95 */     _sb_.append(this.goods_id).append(",");
/*  96 */     _sb_.append(this.count).append(",");
/*  97 */     _sb_.append(")");
/*  98 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SMysteryGoodsChangeInfo _o_) {
/* 102 */     if (_o_ == this) return 0;
/* 103 */     int _c_ = 0;
/* 104 */     _c_ = this.shoptype - _o_.shoptype;
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = this.goods_index - _o_.goods_index;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = this.goods_id - _o_.goods_id;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     _c_ = this.count - _o_.count;
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mysteryshop\SMysteryGoodsChangeInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */