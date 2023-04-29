/*     */ package mzm.gsp.shanghui;
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
/*     */ public class SGetSellItemPriceRes
/*     */   extends __SGetSellItemPriceRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12592650;
/*     */   public int bagid;
/*     */   public int itemkey;
/*     */   public int itemid;
/*     */   public int price;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12592650;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SGetSellItemPriceRes() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SGetSellItemPriceRes(int _bagid_, int _itemkey_, int _itemid_, int _price_)
/*     */   {
/*  39 */     this.bagid = _bagid_;
/*  40 */     this.itemkey = _itemkey_;
/*  41 */     this.itemid = _itemid_;
/*  42 */     this.price = _price_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  50 */     _os_.marshal(this.bagid);
/*  51 */     _os_.marshal(this.itemkey);
/*  52 */     _os_.marshal(this.itemid);
/*  53 */     _os_.marshal(this.price);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.bagid = _os_.unmarshal_int();
/*  59 */     this.itemkey = _os_.unmarshal_int();
/*  60 */     this.itemid = _os_.unmarshal_int();
/*  61 */     this.price = _os_.unmarshal_int();
/*  62 */     if (!_validator_()) {
/*  63 */       throw new VerifyError("validator failed");
/*     */     }
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  69 */     if (_o1_ == this) return true;
/*  70 */     if ((_o1_ instanceof SGetSellItemPriceRes)) {
/*  71 */       SGetSellItemPriceRes _o_ = (SGetSellItemPriceRes)_o1_;
/*  72 */       if (this.bagid != _o_.bagid) return false;
/*  73 */       if (this.itemkey != _o_.itemkey) return false;
/*  74 */       if (this.itemid != _o_.itemid) return false;
/*  75 */       if (this.price != _o_.price) return false;
/*  76 */       return true;
/*     */     }
/*  78 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  82 */     int _h_ = 0;
/*  83 */     _h_ += this.bagid;
/*  84 */     _h_ += this.itemkey;
/*  85 */     _h_ += this.itemid;
/*  86 */     _h_ += this.price;
/*  87 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  91 */     StringBuilder _sb_ = new StringBuilder();
/*  92 */     _sb_.append("(");
/*  93 */     _sb_.append(this.bagid).append(",");
/*  94 */     _sb_.append(this.itemkey).append(",");
/*  95 */     _sb_.append(this.itemid).append(",");
/*  96 */     _sb_.append(this.price).append(",");
/*  97 */     _sb_.append(")");
/*  98 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SGetSellItemPriceRes _o_) {
/* 102 */     if (_o_ == this) return 0;
/* 103 */     int _c_ = 0;
/* 104 */     _c_ = this.bagid - _o_.bagid;
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = this.itemkey - _o_.itemkey;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = this.itemid - _o_.itemid;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     _c_ = this.price - _o_.price;
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shanghui\SGetSellItemPriceRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */