/*     */ package mzm.gsp.baitan;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SBuyItemRes
/*     */   extends __SBuyItemRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12584968;
/*     */   public static final int SUCCESS = 0;
/*     */   public static final int ALL_SELLED = 1;
/*     */   public static final int NOT_IN_SELL = 3;
/*     */   public int buy_res;
/*     */   public int index;
/*     */   public int itemid;
/*     */   public int num;
/*     */   public int price;
/*     */   public int usemoney;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12584968;
/*     */   }
/*     */   
/*     */ 
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
/*     */ 
/*     */ 
/*     */   public SBuyItemRes(int _buy_res_, int _index_, int _itemid_, int _num_, int _price_, int _usemoney_)
/*     */   {
/*  45 */     this.buy_res = _buy_res_;
/*  46 */     this.index = _index_;
/*  47 */     this.itemid = _itemid_;
/*  48 */     this.num = _num_;
/*  49 */     this.price = _price_;
/*  50 */     this.usemoney = _usemoney_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  54 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  58 */     _os_.marshal(this.buy_res);
/*  59 */     _os_.marshal(this.index);
/*  60 */     _os_.marshal(this.itemid);
/*  61 */     _os_.marshal(this.num);
/*  62 */     _os_.marshal(this.price);
/*  63 */     _os_.marshal(this.usemoney);
/*  64 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  68 */     this.buy_res = _os_.unmarshal_int();
/*  69 */     this.index = _os_.unmarshal_int();
/*  70 */     this.itemid = _os_.unmarshal_int();
/*  71 */     this.num = _os_.unmarshal_int();
/*  72 */     this.price = _os_.unmarshal_int();
/*  73 */     this.usemoney = _os_.unmarshal_int();
/*  74 */     if (!_validator_()) {
/*  75 */       throw new VerifyError("validator failed");
/*     */     }
/*  77 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  81 */     if (_o1_ == this) return true;
/*  82 */     if ((_o1_ instanceof SBuyItemRes)) {
/*  83 */       SBuyItemRes _o_ = (SBuyItemRes)_o1_;
/*  84 */       if (this.buy_res != _o_.buy_res) return false;
/*  85 */       if (this.index != _o_.index) return false;
/*  86 */       if (this.itemid != _o_.itemid) return false;
/*  87 */       if (this.num != _o_.num) return false;
/*  88 */       if (this.price != _o_.price) return false;
/*  89 */       if (this.usemoney != _o_.usemoney) return false;
/*  90 */       return true;
/*     */     }
/*  92 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  96 */     int _h_ = 0;
/*  97 */     _h_ += this.buy_res;
/*  98 */     _h_ += this.index;
/*  99 */     _h_ += this.itemid;
/* 100 */     _h_ += this.num;
/* 101 */     _h_ += this.price;
/* 102 */     _h_ += this.usemoney;
/* 103 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 107 */     StringBuilder _sb_ = new StringBuilder();
/* 108 */     _sb_.append("(");
/* 109 */     _sb_.append(this.buy_res).append(",");
/* 110 */     _sb_.append(this.index).append(",");
/* 111 */     _sb_.append(this.itemid).append(",");
/* 112 */     _sb_.append(this.num).append(",");
/* 113 */     _sb_.append(this.price).append(",");
/* 114 */     _sb_.append(this.usemoney).append(",");
/* 115 */     _sb_.append(")");
/* 116 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SBuyItemRes _o_) {
/* 120 */     if (_o_ == this) return 0;
/* 121 */     int _c_ = 0;
/* 122 */     _c_ = this.buy_res - _o_.buy_res;
/* 123 */     if (0 != _c_) return _c_;
/* 124 */     _c_ = this.index - _o_.index;
/* 125 */     if (0 != _c_) return _c_;
/* 126 */     _c_ = this.itemid - _o_.itemid;
/* 127 */     if (0 != _c_) return _c_;
/* 128 */     _c_ = this.num - _o_.num;
/* 129 */     if (0 != _c_) return _c_;
/* 130 */     _c_ = this.price - _o_.price;
/* 131 */     if (0 != _c_) return _c_;
/* 132 */     _c_ = this.usemoney - _o_.usemoney;
/* 133 */     if (0 != _c_) return _c_;
/* 134 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\baitan\SBuyItemRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */