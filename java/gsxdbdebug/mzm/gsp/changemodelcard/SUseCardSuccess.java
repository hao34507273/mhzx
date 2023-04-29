/*     */ package mzm.gsp.changemodelcard;
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
/*     */ public class SUseCardSuccess
/*     */   extends __SUseCardSuccess__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12624387;
/*     */   public long card_id;
/*     */   public int card_cfg_id;
/*     */   public int use_count;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12624387;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SUseCardSuccess() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SUseCardSuccess(long _card_id_, int _card_cfg_id_, int _use_count_)
/*     */   {
/*  38 */     this.card_id = _card_id_;
/*  39 */     this.card_cfg_id = _card_cfg_id_;
/*  40 */     this.use_count = _use_count_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.card_id);
/*  49 */     _os_.marshal(this.card_cfg_id);
/*  50 */     _os_.marshal(this.use_count);
/*  51 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  55 */     this.card_id = _os_.unmarshal_long();
/*  56 */     this.card_cfg_id = _os_.unmarshal_int();
/*  57 */     this.use_count = _os_.unmarshal_int();
/*  58 */     if (!_validator_()) {
/*  59 */       throw new VerifyError("validator failed");
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  65 */     if (_o1_ == this) return true;
/*  66 */     if ((_o1_ instanceof SUseCardSuccess)) {
/*  67 */       SUseCardSuccess _o_ = (SUseCardSuccess)_o1_;
/*  68 */       if (this.card_id != _o_.card_id) return false;
/*  69 */       if (this.card_cfg_id != _o_.card_cfg_id) return false;
/*  70 */       if (this.use_count != _o_.use_count) return false;
/*  71 */       return true;
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  77 */     int _h_ = 0;
/*  78 */     _h_ += (int)this.card_id;
/*  79 */     _h_ += this.card_cfg_id;
/*  80 */     _h_ += this.use_count;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.card_id).append(",");
/*  88 */     _sb_.append(this.card_cfg_id).append(",");
/*  89 */     _sb_.append(this.use_count).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SUseCardSuccess _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = Long.signum(this.card_id - _o_.card_id);
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = this.card_cfg_id - _o_.card_cfg_id;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = this.use_count - _o_.use_count;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\changemodelcard\SUseCardSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */