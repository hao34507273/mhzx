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
/*     */ 
/*     */ 
/*     */ public class SUnDisplayCourtYardFurnitureRes
/*     */   extends __SUnDisplayCourtYardFurnitureRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12605513;
/*     */   public long furnitureuuid;
/*     */   public int furnitureid;
/*     */   public int dec_beautiful;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12605513;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SUnDisplayCourtYardFurnitureRes() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SUnDisplayCourtYardFurnitureRes(long _furnitureuuid_, int _furnitureid_, int _dec_beautiful_)
/*     */   {
/*  38 */     this.furnitureuuid = _furnitureuuid_;
/*  39 */     this.furnitureid = _furnitureid_;
/*  40 */     this.dec_beautiful = _dec_beautiful_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.furnitureuuid);
/*  49 */     _os_.marshal(this.furnitureid);
/*  50 */     _os_.marshal(this.dec_beautiful);
/*  51 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  55 */     this.furnitureuuid = _os_.unmarshal_long();
/*  56 */     this.furnitureid = _os_.unmarshal_int();
/*  57 */     this.dec_beautiful = _os_.unmarshal_int();
/*  58 */     if (!_validator_()) {
/*  59 */       throw new VerifyError("validator failed");
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  65 */     if (_o1_ == this) return true;
/*  66 */     if ((_o1_ instanceof SUnDisplayCourtYardFurnitureRes)) {
/*  67 */       SUnDisplayCourtYardFurnitureRes _o_ = (SUnDisplayCourtYardFurnitureRes)_o1_;
/*  68 */       if (this.furnitureuuid != _o_.furnitureuuid) return false;
/*  69 */       if (this.furnitureid != _o_.furnitureid) return false;
/*  70 */       if (this.dec_beautiful != _o_.dec_beautiful) return false;
/*  71 */       return true;
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  77 */     int _h_ = 0;
/*  78 */     _h_ += (int)this.furnitureuuid;
/*  79 */     _h_ += this.furnitureid;
/*  80 */     _h_ += this.dec_beautiful;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.furnitureuuid).append(",");
/*  88 */     _sb_.append(this.furnitureid).append(",");
/*  89 */     _sb_.append(this.dec_beautiful).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SUnDisplayCourtYardFurnitureRes _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = Long.signum(this.furnitureuuid - _o_.furnitureuuid);
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = this.furnitureid - _o_.furnitureid;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = this.dec_beautiful - _o_.dec_beautiful;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\SUnDisplayCourtYardFurnitureRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */