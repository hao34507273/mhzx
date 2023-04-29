/*     */ package mzm.gsp.map;
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
/*     */ public class STransforPosEnterView
/*     */   extends __STransforPosEnterView__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12590884;
/*     */   public int instanceid;
/*     */   public Location pos;
/*     */   public int targetmapid;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12590884;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public STransforPosEnterView()
/*     */   {
/*  35 */     this.pos = new Location();
/*     */   }
/*     */   
/*     */   public STransforPosEnterView(int _instanceid_, Location _pos_, int _targetmapid_) {
/*  39 */     this.instanceid = _instanceid_;
/*  40 */     this.pos = _pos_;
/*  41 */     this.targetmapid = _targetmapid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  45 */     if (!this.pos._validator_()) return false;
/*  46 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  50 */     _os_.marshal(this.instanceid);
/*  51 */     _os_.marshal(this.pos);
/*  52 */     _os_.marshal(this.targetmapid);
/*  53 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  57 */     this.instanceid = _os_.unmarshal_int();
/*  58 */     this.pos.unmarshal(_os_);
/*  59 */     this.targetmapid = _os_.unmarshal_int();
/*  60 */     if (!_validator_()) {
/*  61 */       throw new VerifyError("validator failed");
/*     */     }
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  67 */     if (_o1_ == this) return true;
/*  68 */     if ((_o1_ instanceof STransforPosEnterView)) {
/*  69 */       STransforPosEnterView _o_ = (STransforPosEnterView)_o1_;
/*  70 */       if (this.instanceid != _o_.instanceid) return false;
/*  71 */       if (!this.pos.equals(_o_.pos)) return false;
/*  72 */       if (this.targetmapid != _o_.targetmapid) return false;
/*  73 */       return true;
/*     */     }
/*  75 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  79 */     int _h_ = 0;
/*  80 */     _h_ += this.instanceid;
/*  81 */     _h_ += this.pos.hashCode();
/*  82 */     _h_ += this.targetmapid;
/*  83 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  87 */     StringBuilder _sb_ = new StringBuilder();
/*  88 */     _sb_.append("(");
/*  89 */     _sb_.append(this.instanceid).append(",");
/*  90 */     _sb_.append(this.pos).append(",");
/*  91 */     _sb_.append(this.targetmapid).append(",");
/*  92 */     _sb_.append(")");
/*  93 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(STransforPosEnterView _o_) {
/*  97 */     if (_o_ == this) return 0;
/*  98 */     int _c_ = 0;
/*  99 */     _c_ = this.instanceid - _o_.instanceid;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = this.pos.compareTo(_o_.pos);
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     _c_ = this.targetmapid - _o_.targetmapid;
/* 104 */     if (0 != _c_) return _c_;
/* 105 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\STransforPosEnterView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */