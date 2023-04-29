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
/*     */ public class SDisplayCourtYardFurnitureRes
/*     */   extends __SDisplayCourtYardFurnitureRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12605514;
/*     */   public long furnitureuuid;
/*     */   public DisplayFurnitureInfo furnitureinfo;
/*     */   public int to_max_type;
/*     */   public int add_beautiful_value;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12605514;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SDisplayCourtYardFurnitureRes()
/*     */   {
/*  36 */     this.furnitureinfo = new DisplayFurnitureInfo();
/*     */   }
/*     */   
/*     */   public SDisplayCourtYardFurnitureRes(long _furnitureuuid_, DisplayFurnitureInfo _furnitureinfo_, int _to_max_type_, int _add_beautiful_value_) {
/*  40 */     this.furnitureuuid = _furnitureuuid_;
/*  41 */     this.furnitureinfo = _furnitureinfo_;
/*  42 */     this.to_max_type = _to_max_type_;
/*  43 */     this.add_beautiful_value = _add_beautiful_value_;
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
/*  54 */     _os_.marshal(this.to_max_type);
/*  55 */     _os_.marshal(this.add_beautiful_value);
/*  56 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  60 */     this.furnitureuuid = _os_.unmarshal_long();
/*  61 */     this.furnitureinfo.unmarshal(_os_);
/*  62 */     this.to_max_type = _os_.unmarshal_int();
/*  63 */     this.add_beautiful_value = _os_.unmarshal_int();
/*  64 */     if (!_validator_()) {
/*  65 */       throw new VerifyError("validator failed");
/*     */     }
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  71 */     if (_o1_ == this) return true;
/*  72 */     if ((_o1_ instanceof SDisplayCourtYardFurnitureRes)) {
/*  73 */       SDisplayCourtYardFurnitureRes _o_ = (SDisplayCourtYardFurnitureRes)_o1_;
/*  74 */       if (this.furnitureuuid != _o_.furnitureuuid) return false;
/*  75 */       if (!this.furnitureinfo.equals(_o_.furnitureinfo)) return false;
/*  76 */       if (this.to_max_type != _o_.to_max_type) return false;
/*  77 */       if (this.add_beautiful_value != _o_.add_beautiful_value) return false;
/*  78 */       return true;
/*     */     }
/*  80 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  84 */     int _h_ = 0;
/*  85 */     _h_ += (int)this.furnitureuuid;
/*  86 */     _h_ += this.furnitureinfo.hashCode();
/*  87 */     _h_ += this.to_max_type;
/*  88 */     _h_ += this.add_beautiful_value;
/*  89 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  93 */     StringBuilder _sb_ = new StringBuilder();
/*  94 */     _sb_.append("(");
/*  95 */     _sb_.append(this.furnitureuuid).append(",");
/*  96 */     _sb_.append(this.furnitureinfo).append(",");
/*  97 */     _sb_.append(this.to_max_type).append(",");
/*  98 */     _sb_.append(this.add_beautiful_value).append(",");
/*  99 */     _sb_.append(")");
/* 100 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SDisplayCourtYardFurnitureRes _o_) {
/* 104 */     if (_o_ == this) return 0;
/* 105 */     int _c_ = 0;
/* 106 */     _c_ = Long.signum(this.furnitureuuid - _o_.furnitureuuid);
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = this.furnitureinfo.compareTo(_o_.furnitureinfo);
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     _c_ = this.to_max_type - _o_.to_max_type;
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     _c_ = this.add_beautiful_value - _o_.add_beautiful_value;
/* 113 */     if (0 != _c_) return _c_;
/* 114 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\SDisplayCourtYardFurnitureRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */