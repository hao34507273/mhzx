/*     */ package mzm.gsp;
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
/*     */ public class SLoginQueueInfo
/*     */   extends __SLoginQueueInfo__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12590084;
/*     */   public int waitnum;
/*     */   public int offlinenum;
/*     */   public int totalnum;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12590084;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SLoginQueueInfo() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SLoginQueueInfo(int _waitnum_, int _offlinenum_, int _totalnum_)
/*     */   {
/*  38 */     this.waitnum = _waitnum_;
/*  39 */     this.offlinenum = _offlinenum_;
/*  40 */     this.totalnum = _totalnum_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.waitnum);
/*  49 */     _os_.marshal(this.offlinenum);
/*  50 */     _os_.marshal(this.totalnum);
/*  51 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  55 */     this.waitnum = _os_.unmarshal_int();
/*  56 */     this.offlinenum = _os_.unmarshal_int();
/*  57 */     this.totalnum = _os_.unmarshal_int();
/*  58 */     if (!_validator_()) {
/*  59 */       throw new VerifyError("validator failed");
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  65 */     if (_o1_ == this) return true;
/*  66 */     if ((_o1_ instanceof SLoginQueueInfo)) {
/*  67 */       SLoginQueueInfo _o_ = (SLoginQueueInfo)_o1_;
/*  68 */       if (this.waitnum != _o_.waitnum) return false;
/*  69 */       if (this.offlinenum != _o_.offlinenum) return false;
/*  70 */       if (this.totalnum != _o_.totalnum) return false;
/*  71 */       return true;
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  77 */     int _h_ = 0;
/*  78 */     _h_ += this.waitnum;
/*  79 */     _h_ += this.offlinenum;
/*  80 */     _h_ += this.totalnum;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.waitnum).append(",");
/*  88 */     _sb_.append(this.offlinenum).append(",");
/*  89 */     _sb_.append(this.totalnum).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SLoginQueueInfo _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = this.waitnum - _o_.waitnum;
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = this.offlinenum - _o_.offlinenum;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = this.totalnum - _o_.totalnum;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\SLoginQueueInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */