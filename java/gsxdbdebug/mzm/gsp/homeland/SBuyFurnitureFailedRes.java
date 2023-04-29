/*     */ package mzm.gsp.homeland;
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
/*     */ public class SBuyFurnitureFailedRes
/*     */   extends __SBuyFurnitureFailedRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12605497;
/*     */   public int furnitureid;
/*     */   public int buynum;
/*     */   public int restcanbuynum;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  25 */     return 12605497;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SBuyFurnitureFailedRes() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SBuyFurnitureFailedRes(int _furnitureid_, int _buynum_, int _restcanbuynum_)
/*     */   {
/*  36 */     this.furnitureid = _furnitureid_;
/*  37 */     this.buynum = _buynum_;
/*  38 */     this.restcanbuynum = _restcanbuynum_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  42 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  46 */     _os_.marshal(this.furnitureid);
/*  47 */     _os_.marshal(this.buynum);
/*  48 */     _os_.marshal(this.restcanbuynum);
/*  49 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  53 */     this.furnitureid = _os_.unmarshal_int();
/*  54 */     this.buynum = _os_.unmarshal_int();
/*  55 */     this.restcanbuynum = _os_.unmarshal_int();
/*  56 */     if (!_validator_()) {
/*  57 */       throw new VerifyError("validator failed");
/*     */     }
/*  59 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  63 */     if (_o1_ == this) return true;
/*  64 */     if ((_o1_ instanceof SBuyFurnitureFailedRes)) {
/*  65 */       SBuyFurnitureFailedRes _o_ = (SBuyFurnitureFailedRes)_o1_;
/*  66 */       if (this.furnitureid != _o_.furnitureid) return false;
/*  67 */       if (this.buynum != _o_.buynum) return false;
/*  68 */       if (this.restcanbuynum != _o_.restcanbuynum) return false;
/*  69 */       return true;
/*     */     }
/*  71 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  75 */     int _h_ = 0;
/*  76 */     _h_ += this.furnitureid;
/*  77 */     _h_ += this.buynum;
/*  78 */     _h_ += this.restcanbuynum;
/*  79 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  83 */     StringBuilder _sb_ = new StringBuilder();
/*  84 */     _sb_.append("(");
/*  85 */     _sb_.append(this.furnitureid).append(",");
/*  86 */     _sb_.append(this.buynum).append(",");
/*  87 */     _sb_.append(this.restcanbuynum).append(",");
/*  88 */     _sb_.append(")");
/*  89 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SBuyFurnitureFailedRes _o_) {
/*  93 */     if (_o_ == this) return 0;
/*  94 */     int _c_ = 0;
/*  95 */     _c_ = this.furnitureid - _o_.furnitureid;
/*  96 */     if (0 != _c_) return _c_;
/*  97 */     _c_ = this.buynum - _o_.buynum;
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = this.restcanbuynum - _o_.restcanbuynum;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\SBuyFurnitureFailedRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */