/*     */ package mzm.gsp.lifeskillactivity;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class SCreateLifeSkillItemFailed extends __SCreateLifeSkillItemFailed__ {
/*     */   public static final int PROTOCOL_TYPE = 12626691;
/*     */   public static final int ERROR_SYSTEM = -1;
/*     */   public static final int ERROR_USERID = -2;
/*     */   public static final int ERROR_CFG = -3;
/*     */   public static final int ERROR_BAG_FULL = -4;
/*     */   public static final int ERROR_CAN_NOT_JOIN_ACTIVITY = -5;
/*     */   public static final int ERROR_MAX_NUM = -6;
/*     */   public static final int ERROR_NOT_NEAR_NPC = -7;
/*     */   public static final int ERROR_NPC_SERVICE = -8;
/*     */   public static final int ERROR_SERVER_LEVEL_LESS = -9;
/*     */   public static final int ERROR_NOT_IN_GANG = -10;
/*     */   public static final int ERROR_LIVELY_LOW_RATE_LESS = -11;
/*     */   public static final int ERROR_YAODIAN_LEVEL_LESS = -12;
/*     */   public static final int ERROR_LIFE_SKILL_LEVEL = -13;
/*     */   public static final int ERROR_VIGOR_NOT_ENOUGH = -14;
/*     */   public static final int ERROR_PAY_NOT_ENOUGH = -15;
/*     */   public int activity_cfgid;
/*     */   public int retcode;
/*     */   
/*     */   protected void process() {}
/*     */   
/*  27 */   public int getType() { return 12626691; }
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
/*     */   public SCreateLifeSkillItemFailed() {}
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
/*     */   public SCreateLifeSkillItemFailed(int _activity_cfgid_, int _retcode_)
/*     */   {
/*  53 */     this.activity_cfgid = _activity_cfgid_;
/*  54 */     this.retcode = _retcode_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  58 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  62 */     _os_.marshal(this.activity_cfgid);
/*  63 */     _os_.marshal(this.retcode);
/*  64 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  68 */     this.activity_cfgid = _os_.unmarshal_int();
/*  69 */     this.retcode = _os_.unmarshal_int();
/*  70 */     if (!_validator_()) {
/*  71 */       throw new VerifyError("validator failed");
/*     */     }
/*  73 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  77 */     if (_o1_ == this) return true;
/*  78 */     if ((_o1_ instanceof SCreateLifeSkillItemFailed)) {
/*  79 */       SCreateLifeSkillItemFailed _o_ = (SCreateLifeSkillItemFailed)_o1_;
/*  80 */       if (this.activity_cfgid != _o_.activity_cfgid) return false;
/*  81 */       if (this.retcode != _o_.retcode) return false;
/*  82 */       return true;
/*     */     }
/*  84 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  88 */     int _h_ = 0;
/*  89 */     _h_ += this.activity_cfgid;
/*  90 */     _h_ += this.retcode;
/*  91 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  95 */     StringBuilder _sb_ = new StringBuilder();
/*  96 */     _sb_.append("(");
/*  97 */     _sb_.append(this.activity_cfgid).append(",");
/*  98 */     _sb_.append(this.retcode).append(",");
/*  99 */     _sb_.append(")");
/* 100 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SCreateLifeSkillItemFailed _o_) {
/* 104 */     if (_o_ == this) return 0;
/* 105 */     int _c_ = 0;
/* 106 */     _c_ = this.activity_cfgid - _o_.activity_cfgid;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = this.retcode - _o_.retcode;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\lifeskillactivity\SCreateLifeSkillItemFailed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */