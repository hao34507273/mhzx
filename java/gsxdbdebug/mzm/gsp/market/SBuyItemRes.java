/*     */ package mzm.gsp.market;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SBuyItemRes
/*     */   extends __SBuyItemRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12601361;
/*     */   public long marketid;
/*     */   public int itemid;
/*     */   public int price;
/*     */   public int buynum;
/*     */   public int restnum;
/*     */   public int usemoney;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  25 */     return 12601361;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SBuyItemRes() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SBuyItemRes(long _marketid_, int _itemid_, int _price_, int _buynum_, int _restnum_, int _usemoney_)
/*     */   {
/*  39 */     this.marketid = _marketid_;
/*  40 */     this.itemid = _itemid_;
/*  41 */     this.price = _price_;
/*  42 */     this.buynum = _buynum_;
/*  43 */     this.restnum = _restnum_;
/*  44 */     this.usemoney = _usemoney_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.marketid);
/*  53 */     _os_.marshal(this.itemid);
/*  54 */     _os_.marshal(this.price);
/*  55 */     _os_.marshal(this.buynum);
/*  56 */     _os_.marshal(this.restnum);
/*  57 */     _os_.marshal(this.usemoney);
/*  58 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  62 */     this.marketid = _os_.unmarshal_long();
/*  63 */     this.itemid = _os_.unmarshal_int();
/*  64 */     this.price = _os_.unmarshal_int();
/*  65 */     this.buynum = _os_.unmarshal_int();
/*  66 */     this.restnum = _os_.unmarshal_int();
/*  67 */     this.usemoney = _os_.unmarshal_int();
/*  68 */     if (!_validator_()) {
/*  69 */       throw new VerifyError("validator failed");
/*     */     }
/*  71 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  75 */     if (_o1_ == this) return true;
/*  76 */     if ((_o1_ instanceof SBuyItemRes)) {
/*  77 */       SBuyItemRes _o_ = (SBuyItemRes)_o1_;
/*  78 */       if (this.marketid != _o_.marketid) return false;
/*  79 */       if (this.itemid != _o_.itemid) return false;
/*  80 */       if (this.price != _o_.price) return false;
/*  81 */       if (this.buynum != _o_.buynum) return false;
/*  82 */       if (this.restnum != _o_.restnum) return false;
/*  83 */       if (this.usemoney != _o_.usemoney) return false;
/*  84 */       return true;
/*     */     }
/*  86 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  90 */     int _h_ = 0;
/*  91 */     _h_ += (int)this.marketid;
/*  92 */     _h_ += this.itemid;
/*  93 */     _h_ += this.price;
/*  94 */     _h_ += this.buynum;
/*  95 */     _h_ += this.restnum;
/*  96 */     _h_ += this.usemoney;
/*  97 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 101 */     StringBuilder _sb_ = new StringBuilder();
/* 102 */     _sb_.append("(");
/* 103 */     _sb_.append(this.marketid).append(",");
/* 104 */     _sb_.append(this.itemid).append(",");
/* 105 */     _sb_.append(this.price).append(",");
/* 106 */     _sb_.append(this.buynum).append(",");
/* 107 */     _sb_.append(this.restnum).append(",");
/* 108 */     _sb_.append(this.usemoney).append(",");
/* 109 */     _sb_.append(")");
/* 110 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SBuyItemRes _o_) {
/* 114 */     if (_o_ == this) return 0;
/* 115 */     int _c_ = 0;
/* 116 */     _c_ = Long.signum(this.marketid - _o_.marketid);
/* 117 */     if (0 != _c_) return _c_;
/* 118 */     _c_ = this.itemid - _o_.itemid;
/* 119 */     if (0 != _c_) return _c_;
/* 120 */     _c_ = this.price - _o_.price;
/* 121 */     if (0 != _c_) return _c_;
/* 122 */     _c_ = this.buynum - _o_.buynum;
/* 123 */     if (0 != _c_) return _c_;
/* 124 */     _c_ = this.restnum - _o_.restnum;
/* 125 */     if (0 != _c_) return _c_;
/* 126 */     _c_ = this.usemoney - _o_.usemoney;
/* 127 */     if (0 != _c_) return _c_;
/* 128 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\SBuyItemRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */