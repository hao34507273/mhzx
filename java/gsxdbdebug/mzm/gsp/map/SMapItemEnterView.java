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
/*     */ public class SMapItemEnterView
/*     */   extends __SMapItemEnterView__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12590862;
/*     */   public int instanceid;
/*     */   public int mapitemcfgid;
/*     */   public Location loc;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12590862;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SMapItemEnterView()
/*     */   {
/*  35 */     this.loc = new Location();
/*     */   }
/*     */   
/*     */   public SMapItemEnterView(int _instanceid_, int _mapitemcfgid_, Location _loc_) {
/*  39 */     this.instanceid = _instanceid_;
/*  40 */     this.mapitemcfgid = _mapitemcfgid_;
/*  41 */     this.loc = _loc_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  45 */     if (!this.loc._validator_()) return false;
/*  46 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  50 */     _os_.marshal(this.instanceid);
/*  51 */     _os_.marshal(this.mapitemcfgid);
/*  52 */     _os_.marshal(this.loc);
/*  53 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  57 */     this.instanceid = _os_.unmarshal_int();
/*  58 */     this.mapitemcfgid = _os_.unmarshal_int();
/*  59 */     this.loc.unmarshal(_os_);
/*  60 */     if (!_validator_()) {
/*  61 */       throw new VerifyError("validator failed");
/*     */     }
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  67 */     if (_o1_ == this) return true;
/*  68 */     if ((_o1_ instanceof SMapItemEnterView)) {
/*  69 */       SMapItemEnterView _o_ = (SMapItemEnterView)_o1_;
/*  70 */       if (this.instanceid != _o_.instanceid) return false;
/*  71 */       if (this.mapitemcfgid != _o_.mapitemcfgid) return false;
/*  72 */       if (!this.loc.equals(_o_.loc)) return false;
/*  73 */       return true;
/*     */     }
/*  75 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  79 */     int _h_ = 0;
/*  80 */     _h_ += this.instanceid;
/*  81 */     _h_ += this.mapitemcfgid;
/*  82 */     _h_ += this.loc.hashCode();
/*  83 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  87 */     StringBuilder _sb_ = new StringBuilder();
/*  88 */     _sb_.append("(");
/*  89 */     _sb_.append(this.instanceid).append(",");
/*  90 */     _sb_.append(this.mapitemcfgid).append(",");
/*  91 */     _sb_.append(this.loc).append(",");
/*  92 */     _sb_.append(")");
/*  93 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SMapItemEnterView _o_) {
/*  97 */     if (_o_ == this) return 0;
/*  98 */     int _c_ = 0;
/*  99 */     _c_ = this.instanceid - _o_.instanceid;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = this.mapitemcfgid - _o_.mapitemcfgid;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     _c_ = this.loc.compareTo(_o_.loc);
/* 104 */     if (0 != _c_) return _c_;
/* 105 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\SMapItemEnterView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */