/*     */ package mzm.gsp.feisheng;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ public class SReportPlayFeiShengEffectFail
/*     */   extends __SReportPlayFeiShengEffectFail__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12614181;
/*     */   public static final int MODULE_CLOSE_OR_ROLE_FORBIDDEN = -1;
/*     */   public static final int ROLE_STATUS_ERROR = -2;
/*     */   public static final int PARAM_ERROR = -3;
/*     */   public static final int CHECK_NPC_SERVICE_ERROR = -4;
/*     */   public static final int SERVER_LEVEL_NOT_ENOUGH = -5;
/*     */   public static final int DB_ERROR = -6;
/*     */   public static final int CAN_NOT_JOIN_ACTIVITY = 1;
/*     */   public static final int ACTIVITY_NOT_COMPLETE = 2;
/*     */   public static final int ALREADY_REPORT = 3;
/*     */   public int activity_cfg_id;
/*     */   public int res;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12614181;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SReportPlayFeiShengEffectFail() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SReportPlayFeiShengEffectFail(int _activity_cfg_id_, int _res_)
/*     */   {
/*  47 */     this.activity_cfg_id = _activity_cfg_id_;
/*  48 */     this.res = _res_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  52 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  56 */     _os_.marshal(this.activity_cfg_id);
/*  57 */     _os_.marshal(this.res);
/*  58 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  62 */     this.activity_cfg_id = _os_.unmarshal_int();
/*  63 */     this.res = _os_.unmarshal_int();
/*  64 */     if (!_validator_()) {
/*  65 */       throw new VerifyError("validator failed");
/*     */     }
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  71 */     if (_o1_ == this) return true;
/*  72 */     if ((_o1_ instanceof SReportPlayFeiShengEffectFail)) {
/*  73 */       SReportPlayFeiShengEffectFail _o_ = (SReportPlayFeiShengEffectFail)_o1_;
/*  74 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/*  75 */       if (this.res != _o_.res) return false;
/*  76 */       return true;
/*     */     }
/*  78 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  82 */     int _h_ = 0;
/*  83 */     _h_ += this.activity_cfg_id;
/*  84 */     _h_ += this.res;
/*  85 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  89 */     StringBuilder _sb_ = new StringBuilder();
/*  90 */     _sb_.append("(");
/*  91 */     _sb_.append(this.activity_cfg_id).append(",");
/*  92 */     _sb_.append(this.res).append(",");
/*  93 */     _sb_.append(")");
/*  94 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SReportPlayFeiShengEffectFail _o_) {
/*  98 */     if (_o_ == this) return 0;
/*  99 */     int _c_ = 0;
/* 100 */     _c_ = this.activity_cfg_id - _o_.activity_cfg_id;
/* 101 */     if (0 != _c_) return _c_;
/* 102 */     _c_ = this.res - _o_.res;
/* 103 */     if (0 != _c_) return _c_;
/* 104 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\feisheng\SReportPlayFeiShengEffectFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */