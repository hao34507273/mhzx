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
/*     */ public class SGetLevelGrowthFundActivityAwardFailed
/*     */   extends __SGetLevelGrowthFundActivityAwardFailed__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12588815;
/*     */   public static final int ERROR_NOT_PURCHASE_FUND = -1;
/*     */   public static final int ERROR_LEVEL_NOT_MEET = -2;
/*     */   public static final int ERROR_ALREADY_GET_AWARD = -3;
/*     */   public int activity_id;
/*     */   public int sortid;
/*     */   public int retcode;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12588815;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SGetLevelGrowthFundActivityAwardFailed() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SGetLevelGrowthFundActivityAwardFailed(int _activity_id_, int _sortid_, int _retcode_)
/*     */   {
/*  42 */     this.activity_id = _activity_id_;
/*  43 */     this.sortid = _sortid_;
/*  44 */     this.retcode = _retcode_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.activity_id);
/*  53 */     _os_.marshal(this.sortid);
/*  54 */     _os_.marshal(this.retcode);
/*  55 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  59 */     this.activity_id = _os_.unmarshal_int();
/*  60 */     this.sortid = _os_.unmarshal_int();
/*  61 */     this.retcode = _os_.unmarshal_int();
/*  62 */     if (!_validator_()) {
/*  63 */       throw new VerifyError("validator failed");
/*     */     }
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  69 */     if (_o1_ == this) return true;
/*  70 */     if ((_o1_ instanceof SGetLevelGrowthFundActivityAwardFailed)) {
/*  71 */       SGetLevelGrowthFundActivityAwardFailed _o_ = (SGetLevelGrowthFundActivityAwardFailed)_o1_;
/*  72 */       if (this.activity_id != _o_.activity_id) return false;
/*  73 */       if (this.sortid != _o_.sortid) return false;
/*  74 */       if (this.retcode != _o_.retcode) return false;
/*  75 */       return true;
/*     */     }
/*  77 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  81 */     int _h_ = 0;
/*  82 */     _h_ += this.activity_id;
/*  83 */     _h_ += this.sortid;
/*  84 */     _h_ += this.retcode;
/*  85 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  89 */     StringBuilder _sb_ = new StringBuilder();
/*  90 */     _sb_.append("(");
/*  91 */     _sb_.append(this.activity_id).append(",");
/*  92 */     _sb_.append(this.sortid).append(",");
/*  93 */     _sb_.append(this.retcode).append(",");
/*  94 */     _sb_.append(")");
/*  95 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SGetLevelGrowthFundActivityAwardFailed _o_) {
/*  99 */     if (_o_ == this) return 0;
/* 100 */     int _c_ = 0;
/* 101 */     _c_ = this.activity_id - _o_.activity_id;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     _c_ = this.sortid - _o_.sortid;
/* 104 */     if (0 != _c_) return _c_;
/* 105 */     _c_ = this.retcode - _o_.retcode;
/* 106 */     if (0 != _c_) return _c_;
/* 107 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\SGetLevelGrowthFundActivityAwardFailed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */