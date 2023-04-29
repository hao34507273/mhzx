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
/*     */ 
/*     */ 
/*     */ public class SUnregisterInCrossBattleSuccess
/*     */   extends __SUnregisterInCrossBattleSuccess__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12616973;
/*     */   public static final int REASON_ACTIVE = 0;
/*     */   public static final int REASON_CORPS_MEMBER_NUM_DISSATISFIED = 1;
/*     */   public int activity_cfg_id;
/*     */   public long corps_id;
/*     */   public int reason;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12616973;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SUnregisterInCrossBattleSuccess() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SUnregisterInCrossBattleSuccess(int _activity_cfg_id_, long _corps_id_, int _reason_)
/*     */   {
/*  41 */     this.activity_cfg_id = _activity_cfg_id_;
/*  42 */     this.corps_id = _corps_id_;
/*  43 */     this.reason = _reason_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  47 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  51 */     _os_.marshal(this.activity_cfg_id);
/*  52 */     _os_.marshal(this.corps_id);
/*  53 */     _os_.marshal(this.reason);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.activity_cfg_id = _os_.unmarshal_int();
/*  59 */     this.corps_id = _os_.unmarshal_long();
/*  60 */     this.reason = _os_.unmarshal_int();
/*  61 */     if (!_validator_()) {
/*  62 */       throw new VerifyError("validator failed");
/*     */     }
/*  64 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  68 */     if (_o1_ == this) return true;
/*  69 */     if ((_o1_ instanceof SUnregisterInCrossBattleSuccess)) {
/*  70 */       SUnregisterInCrossBattleSuccess _o_ = (SUnregisterInCrossBattleSuccess)_o1_;
/*  71 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/*  72 */       if (this.corps_id != _o_.corps_id) return false;
/*  73 */       if (this.reason != _o_.reason) return false;
/*  74 */       return true;
/*     */     }
/*  76 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  80 */     int _h_ = 0;
/*  81 */     _h_ += this.activity_cfg_id;
/*  82 */     _h_ += (int)this.corps_id;
/*  83 */     _h_ += this.reason;
/*  84 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  88 */     StringBuilder _sb_ = new StringBuilder();
/*  89 */     _sb_.append("(");
/*  90 */     _sb_.append(this.activity_cfg_id).append(",");
/*  91 */     _sb_.append(this.corps_id).append(",");
/*  92 */     _sb_.append(this.reason).append(",");
/*  93 */     _sb_.append(")");
/*  94 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SUnregisterInCrossBattleSuccess _o_) {
/*  98 */     if (_o_ == this) return 0;
/*  99 */     int _c_ = 0;
/* 100 */     _c_ = this.activity_cfg_id - _o_.activity_cfg_id;
/* 101 */     if (0 != _c_) return _c_;
/* 102 */     _c_ = Long.signum(this.corps_id - _o_.corps_id);
/* 103 */     if (0 != _c_) return _c_;
/* 104 */     _c_ = this.reason - _o_.reason;
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\SUnregisterInCrossBattleSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */