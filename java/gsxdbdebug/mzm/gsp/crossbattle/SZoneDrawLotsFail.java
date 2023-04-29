/*     */ package mzm.gsp.crossbattle;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SZoneDrawLotsFail
/*     */   extends __SZoneDrawLotsFail__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12617001;
/*     */   public static final int ERROR_STAGE = -1;
/*     */   public static final int ERROR_NOT_TEAM_LEADER = -2;
/*     */   public static final int ERROR_DRAW_LOTS = -3;
/*     */   public static final int ERROR_SYSTEM = -4;
/*     */   public static final int ERROR_NOT_PROMOTION = -5;
/*     */   public int retcode;
/*     */   public int activity_cfgid;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12617001;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SZoneDrawLotsFail() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SZoneDrawLotsFail(int _retcode_, int _activity_cfgid_)
/*     */   {
/*  43 */     this.retcode = _retcode_;
/*  44 */     this.activity_cfgid = _activity_cfgid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.retcode);
/*  53 */     _os_.marshal(this.activity_cfgid);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.retcode = _os_.unmarshal_int();
/*  59 */     this.activity_cfgid = _os_.unmarshal_int();
/*  60 */     if (!_validator_()) {
/*  61 */       throw new VerifyError("validator failed");
/*     */     }
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  67 */     if (_o1_ == this) return true;
/*  68 */     if ((_o1_ instanceof SZoneDrawLotsFail)) {
/*  69 */       SZoneDrawLotsFail _o_ = (SZoneDrawLotsFail)_o1_;
/*  70 */       if (this.retcode != _o_.retcode) return false;
/*  71 */       if (this.activity_cfgid != _o_.activity_cfgid) return false;
/*  72 */       return true;
/*     */     }
/*  74 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  78 */     int _h_ = 0;
/*  79 */     _h_ += this.retcode;
/*  80 */     _h_ += this.activity_cfgid;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.retcode).append(",");
/*  88 */     _sb_.append(this.activity_cfgid).append(",");
/*  89 */     _sb_.append(")");
/*  90 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SZoneDrawLotsFail _o_) {
/*  94 */     if (_o_ == this) return 0;
/*  95 */     int _c_ = 0;
/*  96 */     _c_ = this.retcode - _o_.retcode;
/*  97 */     if (0 != _c_) return _c_;
/*  98 */     _c_ = this.activity_cfgid - _o_.activity_cfgid;
/*  99 */     if (0 != _c_) return _c_;
/* 100 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\SZoneDrawLotsFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */