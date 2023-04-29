/*     */ package mzm.gsp.mall;
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
/*     */ public class SItemNumChangeInfo
/*     */   extends __SItemNumChangeInfo__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12585477;
/*     */   public int malltype;
/*     */   public int itemid;
/*     */   public int count;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  25 */     return 12585477;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SItemNumChangeInfo() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SItemNumChangeInfo(int _malltype_, int _itemid_, int _count_)
/*     */   {
/*  36 */     this.malltype = _malltype_;
/*  37 */     this.itemid = _itemid_;
/*  38 */     this.count = _count_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  42 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  46 */     _os_.marshal(this.malltype);
/*  47 */     _os_.marshal(this.itemid);
/*  48 */     _os_.marshal(this.count);
/*  49 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  53 */     this.malltype = _os_.unmarshal_int();
/*  54 */     this.itemid = _os_.unmarshal_int();
/*  55 */     this.count = _os_.unmarshal_int();
/*  56 */     if (!_validator_()) {
/*  57 */       throw new VerifyError("validator failed");
/*     */     }
/*  59 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  63 */     if (_o1_ == this) return true;
/*  64 */     if ((_o1_ instanceof SItemNumChangeInfo)) {
/*  65 */       SItemNumChangeInfo _o_ = (SItemNumChangeInfo)_o1_;
/*  66 */       if (this.malltype != _o_.malltype) return false;
/*  67 */       if (this.itemid != _o_.itemid) return false;
/*  68 */       if (this.count != _o_.count) return false;
/*  69 */       return true;
/*     */     }
/*  71 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  75 */     int _h_ = 0;
/*  76 */     _h_ += this.malltype;
/*  77 */     _h_ += this.itemid;
/*  78 */     _h_ += this.count;
/*  79 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  83 */     StringBuilder _sb_ = new StringBuilder();
/*  84 */     _sb_.append("(");
/*  85 */     _sb_.append(this.malltype).append(",");
/*  86 */     _sb_.append(this.itemid).append(",");
/*  87 */     _sb_.append(this.count).append(",");
/*  88 */     _sb_.append(")");
/*  89 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SItemNumChangeInfo _o_) {
/*  93 */     if (_o_ == this) return 0;
/*  94 */     int _c_ = 0;
/*  95 */     _c_ = this.malltype - _o_.malltype;
/*  96 */     if (0 != _c_) return _c_;
/*  97 */     _c_ = this.itemid - _o_.itemid;
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = this.count - _o_.count;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mall\SItemNumChangeInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */