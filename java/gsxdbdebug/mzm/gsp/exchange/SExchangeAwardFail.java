/*     */ package mzm.gsp.exchange;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SExchangeAwardFail
/*     */   extends __SExchangeAwardFail__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12604165;
/*     */   public static final int EXCHANGE_TIME_TO_LIMIT = 0;
/*     */   public static final int NEED_ITEM_NOT_ENOUGH = 1;
/*     */   public static final int AWARD_FAIL = 2;
/*     */   public int activity_cfg_id;
/*     */   public int sort_id;
/*     */   public int res;
/*     */   public int exchange_times;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12604165;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SExchangeAwardFail() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SExchangeAwardFail(int _activity_cfg_id_, int _sort_id_, int _res_, int _exchange_times_)
/*     */   {
/*  43 */     this.activity_cfg_id = _activity_cfg_id_;
/*  44 */     this.sort_id = _sort_id_;
/*  45 */     this.res = _res_;
/*  46 */     this.exchange_times = _exchange_times_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  50 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  54 */     _os_.marshal(this.activity_cfg_id);
/*  55 */     _os_.marshal(this.sort_id);
/*  56 */     _os_.marshal(this.res);
/*  57 */     _os_.marshal(this.exchange_times);
/*  58 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  62 */     this.activity_cfg_id = _os_.unmarshal_int();
/*  63 */     this.sort_id = _os_.unmarshal_int();
/*  64 */     this.res = _os_.unmarshal_int();
/*  65 */     this.exchange_times = _os_.unmarshal_int();
/*  66 */     if (!_validator_()) {
/*  67 */       throw new VerifyError("validator failed");
/*     */     }
/*  69 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  73 */     if (_o1_ == this) return true;
/*  74 */     if ((_o1_ instanceof SExchangeAwardFail)) {
/*  75 */       SExchangeAwardFail _o_ = (SExchangeAwardFail)_o1_;
/*  76 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/*  77 */       if (this.sort_id != _o_.sort_id) return false;
/*  78 */       if (this.res != _o_.res) return false;
/*  79 */       if (this.exchange_times != _o_.exchange_times) return false;
/*  80 */       return true;
/*     */     }
/*  82 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  86 */     int _h_ = 0;
/*  87 */     _h_ += this.activity_cfg_id;
/*  88 */     _h_ += this.sort_id;
/*  89 */     _h_ += this.res;
/*  90 */     _h_ += this.exchange_times;
/*  91 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  95 */     StringBuilder _sb_ = new StringBuilder();
/*  96 */     _sb_.append("(");
/*  97 */     _sb_.append(this.activity_cfg_id).append(",");
/*  98 */     _sb_.append(this.sort_id).append(",");
/*  99 */     _sb_.append(this.res).append(",");
/* 100 */     _sb_.append(this.exchange_times).append(",");
/* 101 */     _sb_.append(")");
/* 102 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SExchangeAwardFail _o_) {
/* 106 */     if (_o_ == this) return 0;
/* 107 */     int _c_ = 0;
/* 108 */     _c_ = this.activity_cfg_id - _o_.activity_cfg_id;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     _c_ = this.sort_id - _o_.sort_id;
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     _c_ = this.res - _o_.res;
/* 113 */     if (0 != _c_) return _c_;
/* 114 */     _c_ = this.exchange_times - _o_.exchange_times;
/* 115 */     if (0 != _c_) return _c_;
/* 116 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\exchange\SExchangeAwardFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */