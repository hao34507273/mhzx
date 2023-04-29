/*     */ package mzm.gsp.qingfu;
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
/*     */ public class SGetRMBGiftBagActivityAwardFailed
/*     */   extends __SGetRMBGiftBagActivityAwardFailed__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12588832;
/*     */   public static final int ERROR_NOT_PURCHASE_RMB_GIFT_BAG = -1;
/*     */   public static final int ERROR_LEVEL_NOT_MEET = -2;
/*     */   public static final int ERROR_ALREADY_GET_AWARD = -3;
/*     */   public int activity_cfgid;
/*     */   public int tier;
/*     */   public int retcode;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12588832;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SGetRMBGiftBagActivityAwardFailed() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SGetRMBGiftBagActivityAwardFailed(int _activity_cfgid_, int _tier_, int _retcode_)
/*     */   {
/*  42 */     this.activity_cfgid = _activity_cfgid_;
/*  43 */     this.tier = _tier_;
/*  44 */     this.retcode = _retcode_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.activity_cfgid);
/*  53 */     _os_.marshal(this.tier);
/*  54 */     _os_.marshal(this.retcode);
/*  55 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  59 */     this.activity_cfgid = _os_.unmarshal_int();
/*  60 */     this.tier = _os_.unmarshal_int();
/*  61 */     this.retcode = _os_.unmarshal_int();
/*  62 */     if (!_validator_()) {
/*  63 */       throw new VerifyError("validator failed");
/*     */     }
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  69 */     if (_o1_ == this) return true;
/*  70 */     if ((_o1_ instanceof SGetRMBGiftBagActivityAwardFailed)) {
/*  71 */       SGetRMBGiftBagActivityAwardFailed _o_ = (SGetRMBGiftBagActivityAwardFailed)_o1_;
/*  72 */       if (this.activity_cfgid != _o_.activity_cfgid) return false;
/*  73 */       if (this.tier != _o_.tier) return false;
/*  74 */       if (this.retcode != _o_.retcode) return false;
/*  75 */       return true;
/*     */     }
/*  77 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  81 */     int _h_ = 0;
/*  82 */     _h_ += this.activity_cfgid;
/*  83 */     _h_ += this.tier;
/*  84 */     _h_ += this.retcode;
/*  85 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  89 */     StringBuilder _sb_ = new StringBuilder();
/*  90 */     _sb_.append("(");
/*  91 */     _sb_.append(this.activity_cfgid).append(",");
/*  92 */     _sb_.append(this.tier).append(",");
/*  93 */     _sb_.append(this.retcode).append(",");
/*  94 */     _sb_.append(")");
/*  95 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SGetRMBGiftBagActivityAwardFailed _o_) {
/*  99 */     if (_o_ == this) return 0;
/* 100 */     int _c_ = 0;
/* 101 */     _c_ = this.activity_cfgid - _o_.activity_cfgid;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     _c_ = this.tier - _o_.tier;
/* 104 */     if (0 != _c_) return _c_;
/* 105 */     _c_ = this.retcode - _o_.retcode;
/* 106 */     if (0 != _c_) return _c_;
/* 107 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\SGetRMBGiftBagActivityAwardFailed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */