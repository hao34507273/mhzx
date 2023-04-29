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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CChangeWingView
/*     */   extends __CChangeWingView__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12596494;
/*     */   public int index;
/*     */   public int modelid;
/*     */   public int isshowwing;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  29 */     return 12596494;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CChangeWingView() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CChangeWingView(int _index_, int _modelid_, int _isshowwing_)
/*     */   {
/*  40 */     this.index = _index_;
/*  41 */     this.modelid = _modelid_;
/*  42 */     this.isshowwing = _isshowwing_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  50 */     _os_.marshal(this.index);
/*  51 */     _os_.marshal(this.modelid);
/*  52 */     _os_.marshal(this.isshowwing);
/*  53 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  57 */     this.index = _os_.unmarshal_int();
/*  58 */     this.modelid = _os_.unmarshal_int();
/*  59 */     this.isshowwing = _os_.unmarshal_int();
/*  60 */     if (!_validator_()) {
/*  61 */       throw new VerifyError("validator failed");
/*     */     }
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  67 */     if (_o1_ == this) return true;
/*  68 */     if ((_o1_ instanceof CChangeWingView)) {
/*  69 */       CChangeWingView _o_ = (CChangeWingView)_o1_;
/*  70 */       if (this.index != _o_.index) return false;
/*  71 */       if (this.modelid != _o_.modelid) return false;
/*  72 */       if (this.isshowwing != _o_.isshowwing) return false;
/*  73 */       return true;
/*     */     }
/*  75 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  79 */     int _h_ = 0;
/*  80 */     _h_ += this.index;
/*  81 */     _h_ += this.modelid;
/*  82 */     _h_ += this.isshowwing;
/*  83 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  87 */     StringBuilder _sb_ = new StringBuilder();
/*  88 */     _sb_.append("(");
/*  89 */     _sb_.append(this.index).append(",");
/*  90 */     _sb_.append(this.modelid).append(",");
/*  91 */     _sb_.append(this.isshowwing).append(",");
/*  92 */     _sb_.append(")");
/*  93 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CChangeWingView _o_) {
/*  97 */     if (_o_ == this) return 0;
/*  98 */     int _c_ = 0;
/*  99 */     _c_ = this.index - _o_.index;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = this.modelid - _o_.modelid;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     _c_ = this.isshowwing - _o_.isshowwing;
/* 104 */     if (0 != _c_) return _c_;
/* 105 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\CChangeWingView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */