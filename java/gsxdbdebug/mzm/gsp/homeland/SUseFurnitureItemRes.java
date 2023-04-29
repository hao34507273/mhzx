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
/*     */ public class SUseFurnitureItemRes
/*     */   extends __SUseFurnitureItemRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12605465;
/*     */   public long furnitureuuid;
/*     */   public int furnitureid;
/*     */   public int area;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  25 */     return 12605465;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SUseFurnitureItemRes() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SUseFurnitureItemRes(long _furnitureuuid_, int _furnitureid_, int _area_)
/*     */   {
/*  36 */     this.furnitureuuid = _furnitureuuid_;
/*  37 */     this.furnitureid = _furnitureid_;
/*  38 */     this.area = _area_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  42 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  46 */     _os_.marshal(this.furnitureuuid);
/*  47 */     _os_.marshal(this.furnitureid);
/*  48 */     _os_.marshal(this.area);
/*  49 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  53 */     this.furnitureuuid = _os_.unmarshal_long();
/*  54 */     this.furnitureid = _os_.unmarshal_int();
/*  55 */     this.area = _os_.unmarshal_int();
/*  56 */     if (!_validator_()) {
/*  57 */       throw new VerifyError("validator failed");
/*     */     }
/*  59 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  63 */     if (_o1_ == this) return true;
/*  64 */     if ((_o1_ instanceof SUseFurnitureItemRes)) {
/*  65 */       SUseFurnitureItemRes _o_ = (SUseFurnitureItemRes)_o1_;
/*  66 */       if (this.furnitureuuid != _o_.furnitureuuid) return false;
/*  67 */       if (this.furnitureid != _o_.furnitureid) return false;
/*  68 */       if (this.area != _o_.area) return false;
/*  69 */       return true;
/*     */     }
/*  71 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  75 */     int _h_ = 0;
/*  76 */     _h_ += (int)this.furnitureuuid;
/*  77 */     _h_ += this.furnitureid;
/*  78 */     _h_ += this.area;
/*  79 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  83 */     StringBuilder _sb_ = new StringBuilder();
/*  84 */     _sb_.append("(");
/*  85 */     _sb_.append(this.furnitureuuid).append(",");
/*  86 */     _sb_.append(this.furnitureid).append(",");
/*  87 */     _sb_.append(this.area).append(",");
/*  88 */     _sb_.append(")");
/*  89 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SUseFurnitureItemRes _o_) {
/*  93 */     if (_o_ == this) return 0;
/*  94 */     int _c_ = 0;
/*  95 */     _c_ = Long.signum(this.furnitureuuid - _o_.furnitureuuid);
/*  96 */     if (0 != _c_) return _c_;
/*  97 */     _c_ = this.furnitureid - _o_.furnitureid;
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = this.area - _o_.area;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\SUseFurnitureItemRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */