/*     */ package mzm.gsp.crossbattle;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class SPointRaceReadyFail extends __SPointRaceReadyFail__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12617011;
/*     */   public static final int ERROR_CORPS_NOT_PROMOTION = -1;
/*     */   public static final int ERROR_POINT_RACE_TIME = -2;
/*     */   public static final int ERROR_NOT_IN_TEAM = -3;
/*     */   public static final int ERROR_TEAM_MEMBER_NOT_ENOUGH = -4;
/*     */   public static final int ERROR_TEAM_NOT_MATCH_CORPS = -5;
/*     */   public static final int ERROR_CORPS_ZONE = -6;
/*     */   public static final int ERROR_UN_KNOW = -7;
/*     */   public static final int ERROR_GEN_TOKEN = -8;
/*     */   public static final int ERROR_DATA_TRANSFOR = -9;
/*     */   public static final int ERROR_PENDING = -10;
/*     */   public int retcode;
/*     */   public int activity_cfgid;
/*     */   public int index;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12617011;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SPointRaceReadyFail() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SPointRaceReadyFail(int _retcode_, int _activity_cfgid_, int _index_)
/*     */   {
/*  49 */     this.retcode = _retcode_;
/*  50 */     this.activity_cfgid = _activity_cfgid_;
/*  51 */     this.index = _index_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  55 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  59 */     _os_.marshal(this.retcode);
/*  60 */     _os_.marshal(this.activity_cfgid);
/*  61 */     _os_.marshal(this.index);
/*  62 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  66 */     this.retcode = _os_.unmarshal_int();
/*  67 */     this.activity_cfgid = _os_.unmarshal_int();
/*  68 */     this.index = _os_.unmarshal_int();
/*  69 */     if (!_validator_()) {
/*  70 */       throw new VerifyError("validator failed");
/*     */     }
/*  72 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  76 */     if (_o1_ == this) return true;
/*  77 */     if ((_o1_ instanceof SPointRaceReadyFail)) {
/*  78 */       SPointRaceReadyFail _o_ = (SPointRaceReadyFail)_o1_;
/*  79 */       if (this.retcode != _o_.retcode) return false;
/*  80 */       if (this.activity_cfgid != _o_.activity_cfgid) return false;
/*  81 */       if (this.index != _o_.index) return false;
/*  82 */       return true;
/*     */     }
/*  84 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  88 */     int _h_ = 0;
/*  89 */     _h_ += this.retcode;
/*  90 */     _h_ += this.activity_cfgid;
/*  91 */     _h_ += this.index;
/*  92 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  96 */     StringBuilder _sb_ = new StringBuilder();
/*  97 */     _sb_.append("(");
/*  98 */     _sb_.append(this.retcode).append(",");
/*  99 */     _sb_.append(this.activity_cfgid).append(",");
/* 100 */     _sb_.append(this.index).append(",");
/* 101 */     _sb_.append(")");
/* 102 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SPointRaceReadyFail _o_) {
/* 106 */     if (_o_ == this) return 0;
/* 107 */     int _c_ = 0;
/* 108 */     _c_ = this.retcode - _o_.retcode;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     _c_ = this.activity_cfgid - _o_.activity_cfgid;
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     _c_ = this.index - _o_.index;
/* 113 */     if (0 != _c_) return _c_;
/* 114 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\SPointRaceReadyFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */