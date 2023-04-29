/*     */ package mzm.gsp.signaward;
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
/*     */ public class SSignPreciousNotifyLuckyLottery
/*     */   extends __SSignPreciousNotifyLuckyLottery__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12593426;
/*     */   public int box_type;
/*     */   public int cost_yuan_bao;
/*     */   public int precious_box_cfg_id;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12593426;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SSignPreciousNotifyLuckyLottery() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SSignPreciousNotifyLuckyLottery(int _box_type_, int _cost_yuan_bao_, int _precious_box_cfg_id_)
/*     */   {
/*  38 */     this.box_type = _box_type_;
/*  39 */     this.cost_yuan_bao = _cost_yuan_bao_;
/*  40 */     this.precious_box_cfg_id = _precious_box_cfg_id_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.box_type);
/*  49 */     _os_.marshal(this.cost_yuan_bao);
/*  50 */     _os_.marshal(this.precious_box_cfg_id);
/*  51 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  55 */     this.box_type = _os_.unmarshal_int();
/*  56 */     this.cost_yuan_bao = _os_.unmarshal_int();
/*  57 */     this.precious_box_cfg_id = _os_.unmarshal_int();
/*  58 */     if (!_validator_()) {
/*  59 */       throw new VerifyError("validator failed");
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  65 */     if (_o1_ == this) return true;
/*  66 */     if ((_o1_ instanceof SSignPreciousNotifyLuckyLottery)) {
/*  67 */       SSignPreciousNotifyLuckyLottery _o_ = (SSignPreciousNotifyLuckyLottery)_o1_;
/*  68 */       if (this.box_type != _o_.box_type) return false;
/*  69 */       if (this.cost_yuan_bao != _o_.cost_yuan_bao) return false;
/*  70 */       if (this.precious_box_cfg_id != _o_.precious_box_cfg_id) return false;
/*  71 */       return true;
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  77 */     int _h_ = 0;
/*  78 */     _h_ += this.box_type;
/*  79 */     _h_ += this.cost_yuan_bao;
/*  80 */     _h_ += this.precious_box_cfg_id;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.box_type).append(",");
/*  88 */     _sb_.append(this.cost_yuan_bao).append(",");
/*  89 */     _sb_.append(this.precious_box_cfg_id).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SSignPreciousNotifyLuckyLottery _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = this.box_type - _o_.box_type;
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = this.cost_yuan_bao - _o_.cost_yuan_bao;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = this.precious_box_cfg_id - _o_.precious_box_cfg_id;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\signaward\SSignPreciousNotifyLuckyLottery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */