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
/*     */ public class SSynCrossBattleRoundRobinIdipRestartInfo
/*     */   extends __SSynCrossBattleRoundRobinIdipRestartInfo__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12617028;
/*     */   public int activity_cfg_id;
/*     */   public int round_index;
/*     */   public int timestamp;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12617028;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SSynCrossBattleRoundRobinIdipRestartInfo() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SSynCrossBattleRoundRobinIdipRestartInfo(int _activity_cfg_id_, int _round_index_, int _timestamp_)
/*     */   {
/*  38 */     this.activity_cfg_id = _activity_cfg_id_;
/*  39 */     this.round_index = _round_index_;
/*  40 */     this.timestamp = _timestamp_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.activity_cfg_id);
/*  49 */     _os_.marshal(this.round_index);
/*  50 */     _os_.marshal(this.timestamp);
/*  51 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  55 */     this.activity_cfg_id = _os_.unmarshal_int();
/*  56 */     this.round_index = _os_.unmarshal_int();
/*  57 */     this.timestamp = _os_.unmarshal_int();
/*  58 */     if (!_validator_()) {
/*  59 */       throw new VerifyError("validator failed");
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  65 */     if (_o1_ == this) return true;
/*  66 */     if ((_o1_ instanceof SSynCrossBattleRoundRobinIdipRestartInfo)) {
/*  67 */       SSynCrossBattleRoundRobinIdipRestartInfo _o_ = (SSynCrossBattleRoundRobinIdipRestartInfo)_o1_;
/*  68 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/*  69 */       if (this.round_index != _o_.round_index) return false;
/*  70 */       if (this.timestamp != _o_.timestamp) return false;
/*  71 */       return true;
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  77 */     int _h_ = 0;
/*  78 */     _h_ += this.activity_cfg_id;
/*  79 */     _h_ += this.round_index;
/*  80 */     _h_ += this.timestamp;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.activity_cfg_id).append(",");
/*  88 */     _sb_.append(this.round_index).append(",");
/*  89 */     _sb_.append(this.timestamp).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SSynCrossBattleRoundRobinIdipRestartInfo _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = this.activity_cfg_id - _o_.activity_cfg_id;
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = this.round_index - _o_.round_index;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = this.timestamp - _o_.timestamp;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\SSynCrossBattleRoundRobinIdipRestartInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */