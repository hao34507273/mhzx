/*     */ package mzm.gsp.wing;
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
/*     */ public class SChangeWingViewRes
/*     */   extends __SChangeWingViewRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12596493;
/*     */   public int index;
/*     */   public ModelId2DyeId modelid2dyeid;
/*     */   public int isshowwing;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  25 */     return 12596493;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SChangeWingViewRes()
/*     */   {
/*  33 */     this.modelid2dyeid = new ModelId2DyeId();
/*     */   }
/*     */   
/*     */   public SChangeWingViewRes(int _index_, ModelId2DyeId _modelid2dyeid_, int _isshowwing_) {
/*  37 */     this.index = _index_;
/*  38 */     this.modelid2dyeid = _modelid2dyeid_;
/*  39 */     this.isshowwing = _isshowwing_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  43 */     if (!this.modelid2dyeid._validator_()) return false;
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.index);
/*  49 */     _os_.marshal(this.modelid2dyeid);
/*  50 */     _os_.marshal(this.isshowwing);
/*  51 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  55 */     this.index = _os_.unmarshal_int();
/*  56 */     this.modelid2dyeid.unmarshal(_os_);
/*  57 */     this.isshowwing = _os_.unmarshal_int();
/*  58 */     if (!_validator_()) {
/*  59 */       throw new VerifyError("validator failed");
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  65 */     if (_o1_ == this) return true;
/*  66 */     if ((_o1_ instanceof SChangeWingViewRes)) {
/*  67 */       SChangeWingViewRes _o_ = (SChangeWingViewRes)_o1_;
/*  68 */       if (this.index != _o_.index) return false;
/*  69 */       if (!this.modelid2dyeid.equals(_o_.modelid2dyeid)) return false;
/*  70 */       if (this.isshowwing != _o_.isshowwing) return false;
/*  71 */       return true;
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  77 */     int _h_ = 0;
/*  78 */     _h_ += this.index;
/*  79 */     _h_ += this.modelid2dyeid.hashCode();
/*  80 */     _h_ += this.isshowwing;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.index).append(",");
/*  88 */     _sb_.append(this.modelid2dyeid).append(",");
/*  89 */     _sb_.append(this.isshowwing).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SChangeWingViewRes _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = this.index - _o_.index;
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = this.modelid2dyeid.compareTo(_o_.modelid2dyeid);
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = this.isshowwing - _o_.isshowwing;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\SChangeWingViewRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */