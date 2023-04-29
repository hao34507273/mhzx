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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SExchangeAwardSuccess
/*     */   extends __SExchangeAwardSuccess__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12604164;
/*     */   public int activity_cfg_id;
/*     */   public int sort_id;
/*     */   public int already_exchange_times;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12604164;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SExchangeAwardSuccess() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SExchangeAwardSuccess(int _activity_cfg_id_, int _sort_id_, int _already_exchange_times_)
/*     */   {
/*  38 */     this.activity_cfg_id = _activity_cfg_id_;
/*  39 */     this.sort_id = _sort_id_;
/*  40 */     this.already_exchange_times = _already_exchange_times_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.activity_cfg_id);
/*  49 */     _os_.marshal(this.sort_id);
/*  50 */     _os_.marshal(this.already_exchange_times);
/*  51 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  55 */     this.activity_cfg_id = _os_.unmarshal_int();
/*  56 */     this.sort_id = _os_.unmarshal_int();
/*  57 */     this.already_exchange_times = _os_.unmarshal_int();
/*  58 */     if (!_validator_()) {
/*  59 */       throw new VerifyError("validator failed");
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  65 */     if (_o1_ == this) return true;
/*  66 */     if ((_o1_ instanceof SExchangeAwardSuccess)) {
/*  67 */       SExchangeAwardSuccess _o_ = (SExchangeAwardSuccess)_o1_;
/*  68 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/*  69 */       if (this.sort_id != _o_.sort_id) return false;
/*  70 */       if (this.already_exchange_times != _o_.already_exchange_times) return false;
/*  71 */       return true;
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  77 */     int _h_ = 0;
/*  78 */     _h_ += this.activity_cfg_id;
/*  79 */     _h_ += this.sort_id;
/*  80 */     _h_ += this.already_exchange_times;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.activity_cfg_id).append(",");
/*  88 */     _sb_.append(this.sort_id).append(",");
/*  89 */     _sb_.append(this.already_exchange_times).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SExchangeAwardSuccess _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = this.activity_cfg_id - _o_.activity_cfg_id;
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = this.sort_id - _o_.sort_id;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = this.already_exchange_times - _o_.already_exchange_times;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\exchange\SExchangeAwardSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */