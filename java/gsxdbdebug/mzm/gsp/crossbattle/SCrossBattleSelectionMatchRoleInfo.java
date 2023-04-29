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
/*     */ public class SCrossBattleSelectionMatchRoleInfo
/*     */   extends __SCrossBattleSelectionMatchRoleInfo__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12617003;
/*     */   public int fight_type;
/*     */   public int fight_stage;
/*     */   public CrossBattleSelectionMatchInfo matchteamainfos;
/*     */   public CrossBattleSelectionMatchInfo matchteambinfos;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12617003;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SCrossBattleSelectionMatchRoleInfo()
/*     */   {
/*  36 */     this.matchteamainfos = new CrossBattleSelectionMatchInfo();
/*  37 */     this.matchteambinfos = new CrossBattleSelectionMatchInfo();
/*     */   }
/*     */   
/*     */   public SCrossBattleSelectionMatchRoleInfo(int _fight_type_, int _fight_stage_, CrossBattleSelectionMatchInfo _matchteamainfos_, CrossBattleSelectionMatchInfo _matchteambinfos_) {
/*  41 */     this.fight_type = _fight_type_;
/*  42 */     this.fight_stage = _fight_stage_;
/*  43 */     this.matchteamainfos = _matchteamainfos_;
/*  44 */     this.matchteambinfos = _matchteambinfos_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     if (!this.matchteamainfos._validator_()) return false;
/*  49 */     if (!this.matchteambinfos._validator_()) return false;
/*  50 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  54 */     _os_.marshal(this.fight_type);
/*  55 */     _os_.marshal(this.fight_stage);
/*  56 */     _os_.marshal(this.matchteamainfos);
/*  57 */     _os_.marshal(this.matchteambinfos);
/*  58 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  62 */     this.fight_type = _os_.unmarshal_int();
/*  63 */     this.fight_stage = _os_.unmarshal_int();
/*  64 */     this.matchteamainfos.unmarshal(_os_);
/*  65 */     this.matchteambinfos.unmarshal(_os_);
/*  66 */     if (!_validator_()) {
/*  67 */       throw new VerifyError("validator failed");
/*     */     }
/*  69 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  73 */     if (_o1_ == this) return true;
/*  74 */     if ((_o1_ instanceof SCrossBattleSelectionMatchRoleInfo)) {
/*  75 */       SCrossBattleSelectionMatchRoleInfo _o_ = (SCrossBattleSelectionMatchRoleInfo)_o1_;
/*  76 */       if (this.fight_type != _o_.fight_type) return false;
/*  77 */       if (this.fight_stage != _o_.fight_stage) return false;
/*  78 */       if (!this.matchteamainfos.equals(_o_.matchteamainfos)) return false;
/*  79 */       if (!this.matchteambinfos.equals(_o_.matchteambinfos)) return false;
/*  80 */       return true;
/*     */     }
/*  82 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  86 */     int _h_ = 0;
/*  87 */     _h_ += this.fight_type;
/*  88 */     _h_ += this.fight_stage;
/*  89 */     _h_ += this.matchteamainfos.hashCode();
/*  90 */     _h_ += this.matchteambinfos.hashCode();
/*  91 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  95 */     StringBuilder _sb_ = new StringBuilder();
/*  96 */     _sb_.append("(");
/*  97 */     _sb_.append(this.fight_type).append(",");
/*  98 */     _sb_.append(this.fight_stage).append(",");
/*  99 */     _sb_.append(this.matchteamainfos).append(",");
/* 100 */     _sb_.append(this.matchteambinfos).append(",");
/* 101 */     _sb_.append(")");
/* 102 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\SCrossBattleSelectionMatchRoleInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */