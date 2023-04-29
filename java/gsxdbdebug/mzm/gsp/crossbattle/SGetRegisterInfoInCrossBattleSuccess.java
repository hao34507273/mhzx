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
/*     */ 
/*     */ 
/*     */ public class SGetRegisterInfoInCrossBattleSuccess
/*     */   extends __SGetRegisterInfoInCrossBattleSuccess__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12616982;
/*     */   public int activity_cfg_id;
/*     */   public long corps_id;
/*     */   public byte register_info;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12616982;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SGetRegisterInfoInCrossBattleSuccess() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SGetRegisterInfoInCrossBattleSuccess(int _activity_cfg_id_, long _corps_id_, byte _register_info_)
/*     */   {
/*  38 */     this.activity_cfg_id = _activity_cfg_id_;
/*  39 */     this.corps_id = _corps_id_;
/*  40 */     this.register_info = _register_info_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.activity_cfg_id);
/*  49 */     _os_.marshal(this.corps_id);
/*  50 */     _os_.marshal(this.register_info);
/*  51 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  55 */     this.activity_cfg_id = _os_.unmarshal_int();
/*  56 */     this.corps_id = _os_.unmarshal_long();
/*  57 */     this.register_info = _os_.unmarshal_byte();
/*  58 */     if (!_validator_()) {
/*  59 */       throw new VerifyError("validator failed");
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  65 */     if (_o1_ == this) return true;
/*  66 */     if ((_o1_ instanceof SGetRegisterInfoInCrossBattleSuccess)) {
/*  67 */       SGetRegisterInfoInCrossBattleSuccess _o_ = (SGetRegisterInfoInCrossBattleSuccess)_o1_;
/*  68 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/*  69 */       if (this.corps_id != _o_.corps_id) return false;
/*  70 */       if (this.register_info != _o_.register_info) return false;
/*  71 */       return true;
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  77 */     int _h_ = 0;
/*  78 */     _h_ += this.activity_cfg_id;
/*  79 */     _h_ += (int)this.corps_id;
/*  80 */     _h_ += this.register_info;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.activity_cfg_id).append(",");
/*  88 */     _sb_.append(this.corps_id).append(",");
/*  89 */     _sb_.append(this.register_info).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SGetRegisterInfoInCrossBattleSuccess _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = this.activity_cfg_id - _o_.activity_cfg_id;
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = Long.signum(this.corps_id - _o_.corps_id);
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = this.register_info - _o_.register_info;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\SGetRegisterInfoInCrossBattleSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */