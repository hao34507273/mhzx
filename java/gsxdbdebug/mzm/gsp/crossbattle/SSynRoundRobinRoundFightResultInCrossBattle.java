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
/*     */ public class SSynRoundRobinRoundFightResultInCrossBattle
/*     */   extends __SSynRoundRobinRoundFightResultInCrossBattle__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12617014;
/*     */   public int activity_cfg_id;
/*     */   public int index;
/*     */   public int stage;
/*     */   public RoundRobinFightInfo fight_info;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12617014;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSynRoundRobinRoundFightResultInCrossBattle()
/*     */   {
/*  36 */     this.fight_info = new RoundRobinFightInfo();
/*     */   }
/*     */   
/*     */   public SSynRoundRobinRoundFightResultInCrossBattle(int _activity_cfg_id_, int _index_, int _stage_, RoundRobinFightInfo _fight_info_) {
/*  40 */     this.activity_cfg_id = _activity_cfg_id_;
/*  41 */     this.index = _index_;
/*  42 */     this.stage = _stage_;
/*  43 */     this.fight_info = _fight_info_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  47 */     if (!this.fight_info._validator_()) return false;
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.activity_cfg_id);
/*  53 */     _os_.marshal(this.index);
/*  54 */     _os_.marshal(this.stage);
/*  55 */     _os_.marshal(this.fight_info);
/*  56 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  60 */     this.activity_cfg_id = _os_.unmarshal_int();
/*  61 */     this.index = _os_.unmarshal_int();
/*  62 */     this.stage = _os_.unmarshal_int();
/*  63 */     this.fight_info.unmarshal(_os_);
/*  64 */     if (!_validator_()) {
/*  65 */       throw new VerifyError("validator failed");
/*     */     }
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  71 */     if (_o1_ == this) return true;
/*  72 */     if ((_o1_ instanceof SSynRoundRobinRoundFightResultInCrossBattle)) {
/*  73 */       SSynRoundRobinRoundFightResultInCrossBattle _o_ = (SSynRoundRobinRoundFightResultInCrossBattle)_o1_;
/*  74 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/*  75 */       if (this.index != _o_.index) return false;
/*  76 */       if (this.stage != _o_.stage) return false;
/*  77 */       if (!this.fight_info.equals(_o_.fight_info)) return false;
/*  78 */       return true;
/*     */     }
/*  80 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  84 */     int _h_ = 0;
/*  85 */     _h_ += this.activity_cfg_id;
/*  86 */     _h_ += this.index;
/*  87 */     _h_ += this.stage;
/*  88 */     _h_ += this.fight_info.hashCode();
/*  89 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  93 */     StringBuilder _sb_ = new StringBuilder();
/*  94 */     _sb_.append("(");
/*  95 */     _sb_.append(this.activity_cfg_id).append(",");
/*  96 */     _sb_.append(this.index).append(",");
/*  97 */     _sb_.append(this.stage).append(",");
/*  98 */     _sb_.append(this.fight_info).append(",");
/*  99 */     _sb_.append(")");
/* 100 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\SSynRoundRobinRoundFightResultInCrossBattle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */