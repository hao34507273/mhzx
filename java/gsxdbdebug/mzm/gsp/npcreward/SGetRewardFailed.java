/*     */ package mzm.gsp.npcreward;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SGetRewardFailed
/*     */   extends __SGetRewardFailed__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12615937;
/*     */   public static final int ERROR_SYSTEM = -1;
/*     */   public static final int ERROR_USERID = -2;
/*     */   public static final int ERROR_CFG = -3;
/*     */   public static final int ERROR_BAG_FULL = -4;
/*     */   public static final int ERROR_MAX_NUM = -5;
/*     */   public static final int ERROR_CAN_NOT_JOIN_ACTIVITY = -6;
/*     */   public static final int ERROR_GOLD_TO_MAX = -7;
/*     */   public int activity_cfgid;
/*     */   public int retcode;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12615937;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SGetRewardFailed() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SGetRewardFailed(int _activity_cfgid_, int _retcode_)
/*     */   {
/*  45 */     this.activity_cfgid = _activity_cfgid_;
/*  46 */     this.retcode = _retcode_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  50 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  54 */     _os_.marshal(this.activity_cfgid);
/*  55 */     _os_.marshal(this.retcode);
/*  56 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  60 */     this.activity_cfgid = _os_.unmarshal_int();
/*  61 */     this.retcode = _os_.unmarshal_int();
/*  62 */     if (!_validator_()) {
/*  63 */       throw new VerifyError("validator failed");
/*     */     }
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  69 */     if (_o1_ == this) return true;
/*  70 */     if ((_o1_ instanceof SGetRewardFailed)) {
/*  71 */       SGetRewardFailed _o_ = (SGetRewardFailed)_o1_;
/*  72 */       if (this.activity_cfgid != _o_.activity_cfgid) return false;
/*  73 */       if (this.retcode != _o_.retcode) return false;
/*  74 */       return true;
/*     */     }
/*  76 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  80 */     int _h_ = 0;
/*  81 */     _h_ += this.activity_cfgid;
/*  82 */     _h_ += this.retcode;
/*  83 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  87 */     StringBuilder _sb_ = new StringBuilder();
/*  88 */     _sb_.append("(");
/*  89 */     _sb_.append(this.activity_cfgid).append(",");
/*  90 */     _sb_.append(this.retcode).append(",");
/*  91 */     _sb_.append(")");
/*  92 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SGetRewardFailed _o_) {
/*  96 */     if (_o_ == this) return 0;
/*  97 */     int _c_ = 0;
/*  98 */     _c_ = this.activity_cfgid - _o_.activity_cfgid;
/*  99 */     if (0 != _c_) return _c_;
/* 100 */     _c_ = this.retcode - _o_.retcode;
/* 101 */     if (0 != _c_) return _c_;
/* 102 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\npcreward\SGetRewardFailed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */