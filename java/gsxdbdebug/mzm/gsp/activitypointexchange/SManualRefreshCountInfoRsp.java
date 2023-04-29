/*     */ package mzm.gsp.activitypointexchange;
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
/*     */ public class SManualRefreshCountInfoRsp
/*     */   extends __SManualRefreshCountInfoRsp__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12624908;
/*     */   public int activityid;
/*     */   public int activitypointexchangemallcfgid;
/*     */   public ManualRefreshCountInfo manualrefreshcountinfo;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  25 */     return 12624908;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SManualRefreshCountInfoRsp()
/*     */   {
/*  33 */     this.manualrefreshcountinfo = new ManualRefreshCountInfo();
/*     */   }
/*     */   
/*     */   public SManualRefreshCountInfoRsp(int _activityid_, int _activitypointexchangemallcfgid_, ManualRefreshCountInfo _manualrefreshcountinfo_) {
/*  37 */     this.activityid = _activityid_;
/*  38 */     this.activitypointexchangemallcfgid = _activitypointexchangemallcfgid_;
/*  39 */     this.manualrefreshcountinfo = _manualrefreshcountinfo_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  43 */     if (!this.manualrefreshcountinfo._validator_()) return false;
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.activityid);
/*  49 */     _os_.marshal(this.activitypointexchangemallcfgid);
/*  50 */     _os_.marshal(this.manualrefreshcountinfo);
/*  51 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  55 */     this.activityid = _os_.unmarshal_int();
/*  56 */     this.activitypointexchangemallcfgid = _os_.unmarshal_int();
/*  57 */     this.manualrefreshcountinfo.unmarshal(_os_);
/*  58 */     if (!_validator_()) {
/*  59 */       throw new VerifyError("validator failed");
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  65 */     if (_o1_ == this) return true;
/*  66 */     if ((_o1_ instanceof SManualRefreshCountInfoRsp)) {
/*  67 */       SManualRefreshCountInfoRsp _o_ = (SManualRefreshCountInfoRsp)_o1_;
/*  68 */       if (this.activityid != _o_.activityid) return false;
/*  69 */       if (this.activitypointexchangemallcfgid != _o_.activitypointexchangemallcfgid) return false;
/*  70 */       if (!this.manualrefreshcountinfo.equals(_o_.manualrefreshcountinfo)) return false;
/*  71 */       return true;
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  77 */     int _h_ = 0;
/*  78 */     _h_ += this.activityid;
/*  79 */     _h_ += this.activitypointexchangemallcfgid;
/*  80 */     _h_ += this.manualrefreshcountinfo.hashCode();
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.activityid).append(",");
/*  88 */     _sb_.append(this.activitypointexchangemallcfgid).append(",");
/*  89 */     _sb_.append(this.manualrefreshcountinfo).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SManualRefreshCountInfoRsp _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = this.activityid - _o_.activityid;
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = this.activitypointexchangemallcfgid - _o_.activitypointexchangemallcfgid;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = this.manualrefreshcountinfo.compareTo(_o_.manualrefreshcountinfo);
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activitypointexchange\SManualRefreshCountInfoRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */