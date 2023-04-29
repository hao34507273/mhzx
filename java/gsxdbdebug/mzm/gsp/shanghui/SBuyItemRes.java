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
/*     */ public class SBuyItemRes
/*     */   extends __SBuyItemRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12592645;
/*     */   public int buynum;
/*     */   public long costgold;
/*     */   public int canbuynum;
/*     */   public ShoppingItem iteminfo;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12592645;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SBuyItemRes()
/*     */   {
/*  36 */     this.iteminfo = new ShoppingItem();
/*     */   }
/*     */   
/*     */   public SBuyItemRes(int _buynum_, long _costgold_, int _canbuynum_, ShoppingItem _iteminfo_) {
/*  40 */     this.buynum = _buynum_;
/*  41 */     this.costgold = _costgold_;
/*  42 */     this.canbuynum = _canbuynum_;
/*  43 */     this.iteminfo = _iteminfo_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  47 */     if (!this.iteminfo._validator_()) return false;
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.buynum);
/*  53 */     _os_.marshal(this.costgold);
/*  54 */     _os_.marshal(this.canbuynum);
/*  55 */     _os_.marshal(this.iteminfo);
/*  56 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  60 */     this.buynum = _os_.unmarshal_int();
/*  61 */     this.costgold = _os_.unmarshal_long();
/*  62 */     this.canbuynum = _os_.unmarshal_int();
/*  63 */     this.iteminfo.unmarshal(_os_);
/*  64 */     if (!_validator_()) {
/*  65 */       throw new VerifyError("validator failed");
/*     */     }
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  71 */     if (_o1_ == this) return true;
/*  72 */     if ((_o1_ instanceof SBuyItemRes)) {
/*  73 */       SBuyItemRes _o_ = (SBuyItemRes)_o1_;
/*  74 */       if (this.buynum != _o_.buynum) return false;
/*  75 */       if (this.costgold != _o_.costgold) return false;
/*  76 */       if (this.canbuynum != _o_.canbuynum) return false;
/*  77 */       if (!this.iteminfo.equals(_o_.iteminfo)) return false;
/*  78 */       return true;
/*     */     }
/*  80 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  84 */     int _h_ = 0;
/*  85 */     _h_ += this.buynum;
/*  86 */     _h_ += (int)this.costgold;
/*  87 */     _h_ += this.canbuynum;
/*  88 */     _h_ += this.iteminfo.hashCode();
/*  89 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  93 */     StringBuilder _sb_ = new StringBuilder();
/*  94 */     _sb_.append("(");
/*  95 */     _sb_.append(this.buynum).append(",");
/*  96 */     _sb_.append(this.costgold).append(",");
/*  97 */     _sb_.append(this.canbuynum).append(",");
/*  98 */     _sb_.append(this.iteminfo).append(",");
/*  99 */     _sb_.append(")");
/* 100 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SBuyItemRes _o_) {
/* 104 */     if (_o_ == this) return 0;
/* 105 */     int _c_ = 0;
/* 106 */     _c_ = this.buynum - _o_.buynum;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = Long.signum(this.costgold - _o_.costgold);
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     _c_ = this.canbuynum - _o_.canbuynum;
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     _c_ = this.iteminfo.compareTo(_o_.iteminfo);
/* 113 */     if (0 != _c_) return _c_;
/* 114 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shanghui\SBuyItemRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */