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
/*     */ public class SAddFurnitureRes
/*     */   extends __SAddFurnitureRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12605503;
/*     */   public int furnitureid;
/*     */   public long furnitureuuid;
/*     */   public int area;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12605503;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SAddFurnitureRes() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SAddFurnitureRes(int _furnitureid_, long _furnitureuuid_, int _area_)
/*     */   {
/*  38 */     this.furnitureid = _furnitureid_;
/*  39 */     this.furnitureuuid = _furnitureuuid_;
/*  40 */     this.area = _area_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.furnitureid);
/*  49 */     _os_.marshal(this.furnitureuuid);
/*  50 */     _os_.marshal(this.area);
/*  51 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  55 */     this.furnitureid = _os_.unmarshal_int();
/*  56 */     this.furnitureuuid = _os_.unmarshal_long();
/*  57 */     this.area = _os_.unmarshal_int();
/*  58 */     if (!_validator_()) {
/*  59 */       throw new VerifyError("validator failed");
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  65 */     if (_o1_ == this) return true;
/*  66 */     if ((_o1_ instanceof SAddFurnitureRes)) {
/*  67 */       SAddFurnitureRes _o_ = (SAddFurnitureRes)_o1_;
/*  68 */       if (this.furnitureid != _o_.furnitureid) return false;
/*  69 */       if (this.furnitureuuid != _o_.furnitureuuid) return false;
/*  70 */       if (this.area != _o_.area) return false;
/*  71 */       return true;
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  77 */     int _h_ = 0;
/*  78 */     _h_ += this.furnitureid;
/*  79 */     _h_ += (int)this.furnitureuuid;
/*  80 */     _h_ += this.area;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.furnitureid).append(",");
/*  88 */     _sb_.append(this.furnitureuuid).append(",");
/*  89 */     _sb_.append(this.area).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SAddFurnitureRes _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = this.furnitureid - _o_.furnitureid;
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = Long.signum(this.furnitureuuid - _o_.furnitureuuid);
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = this.area - _o_.area;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\SAddFurnitureRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */