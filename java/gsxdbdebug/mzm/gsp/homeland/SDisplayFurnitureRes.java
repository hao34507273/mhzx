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
/*     */ public class SDisplayFurnitureRes
/*     */   extends __SDisplayFurnitureRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12605483;
/*     */   public long furnitureuuid;
/*     */   public DisplayFurnitureInfo furnitureinfo;
/*     */   public int tomaxtype;
/*     */   public int addfengshui;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12605483;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SDisplayFurnitureRes()
/*     */   {
/*  36 */     this.furnitureinfo = new DisplayFurnitureInfo();
/*     */   }
/*     */   
/*     */   public SDisplayFurnitureRes(long _furnitureuuid_, DisplayFurnitureInfo _furnitureinfo_, int _tomaxtype_, int _addfengshui_) {
/*  40 */     this.furnitureuuid = _furnitureuuid_;
/*  41 */     this.furnitureinfo = _furnitureinfo_;
/*  42 */     this.tomaxtype = _tomaxtype_;
/*  43 */     this.addfengshui = _addfengshui_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  47 */     if (!this.furnitureinfo._validator_()) return false;
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.furnitureuuid);
/*  53 */     _os_.marshal(this.furnitureinfo);
/*  54 */     _os_.marshal(this.tomaxtype);
/*  55 */     _os_.marshal(this.addfengshui);
/*  56 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  60 */     this.furnitureuuid = _os_.unmarshal_long();
/*  61 */     this.furnitureinfo.unmarshal(_os_);
/*  62 */     this.tomaxtype = _os_.unmarshal_int();
/*  63 */     this.addfengshui = _os_.unmarshal_int();
/*  64 */     if (!_validator_()) {
/*  65 */       throw new VerifyError("validator failed");
/*     */     }
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  71 */     if (_o1_ == this) return true;
/*  72 */     if ((_o1_ instanceof SDisplayFurnitureRes)) {
/*  73 */       SDisplayFurnitureRes _o_ = (SDisplayFurnitureRes)_o1_;
/*  74 */       if (this.furnitureuuid != _o_.furnitureuuid) return false;
/*  75 */       if (!this.furnitureinfo.equals(_o_.furnitureinfo)) return false;
/*  76 */       if (this.tomaxtype != _o_.tomaxtype) return false;
/*  77 */       if (this.addfengshui != _o_.addfengshui) return false;
/*  78 */       return true;
/*     */     }
/*  80 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  84 */     int _h_ = 0;
/*  85 */     _h_ += (int)this.furnitureuuid;
/*  86 */     _h_ += this.furnitureinfo.hashCode();
/*  87 */     _h_ += this.tomaxtype;
/*  88 */     _h_ += this.addfengshui;
/*  89 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  93 */     StringBuilder _sb_ = new StringBuilder();
/*  94 */     _sb_.append("(");
/*  95 */     _sb_.append(this.furnitureuuid).append(",");
/*  96 */     _sb_.append(this.furnitureinfo).append(",");
/*  97 */     _sb_.append(this.tomaxtype).append(",");
/*  98 */     _sb_.append(this.addfengshui).append(",");
/*  99 */     _sb_.append(")");
/* 100 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SDisplayFurnitureRes _o_) {
/* 104 */     if (_o_ == this) return 0;
/* 105 */     int _c_ = 0;
/* 106 */     _c_ = Long.signum(this.furnitureuuid - _o_.furnitureuuid);
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = this.furnitureinfo.compareTo(_o_.furnitureinfo);
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     _c_ = this.tomaxtype - _o_.tomaxtype;
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     _c_ = this.addfengshui - _o_.addfengshui;
/* 113 */     if (0 != _c_) return _c_;
/* 114 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\SDisplayFurnitureRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */