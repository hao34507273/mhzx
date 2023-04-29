/*     */ package mzm.gsp.crossbattle;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.crossbattle.confbean.CrossBattleConsts;
/*     */ import mzm.gsp.crossbattle.knockout.PCGetCrossBattleKnockOutFightStageReq;
/*     */ import mzm.gsp.crossbattle.main.CrossBattleOneByOneManager;
/*     */ 
/*     */ public class CGetCrossBattleSelectionFightStageReq
/*     */   extends __CGetCrossBattleSelectionFightStageReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12617013;
/*     */   public int activity_cfg_id;
/*     */   public int fight_zone_id;
/*     */   public int selection_stage;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleId = Role.getRoleId(this);
/*  21 */     if (roleId < 0L)
/*     */     {
/*  23 */       return;
/*     */     }
/*  25 */     CrossBattleOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(CrossBattleConsts.getInstance().CURRENT_ACTIVITY_CFG_ID), new PCGetCrossBattleKnockOutFightStageReq(roleId, this.fight_zone_id, this.selection_stage, 1));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  34 */     return 12617013;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CGetCrossBattleSelectionFightStageReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CGetCrossBattleSelectionFightStageReq(int _activity_cfg_id_, int _fight_zone_id_, int _selection_stage_)
/*     */   {
/*  45 */     this.activity_cfg_id = _activity_cfg_id_;
/*  46 */     this.fight_zone_id = _fight_zone_id_;
/*  47 */     this.selection_stage = _selection_stage_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  51 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  55 */     _os_.marshal(this.activity_cfg_id);
/*  56 */     _os_.marshal(this.fight_zone_id);
/*  57 */     _os_.marshal(this.selection_stage);
/*  58 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  62 */     this.activity_cfg_id = _os_.unmarshal_int();
/*  63 */     this.fight_zone_id = _os_.unmarshal_int();
/*  64 */     this.selection_stage = _os_.unmarshal_int();
/*  65 */     if (!_validator_()) {
/*  66 */       throw new VerifyError("validator failed");
/*     */     }
/*  68 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  72 */     if (_o1_ == this) return true;
/*  73 */     if ((_o1_ instanceof CGetCrossBattleSelectionFightStageReq)) {
/*  74 */       CGetCrossBattleSelectionFightStageReq _o_ = (CGetCrossBattleSelectionFightStageReq)_o1_;
/*  75 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/*  76 */       if (this.fight_zone_id != _o_.fight_zone_id) return false;
/*  77 */       if (this.selection_stage != _o_.selection_stage) return false;
/*  78 */       return true;
/*     */     }
/*  80 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  84 */     int _h_ = 0;
/*  85 */     _h_ += this.activity_cfg_id;
/*  86 */     _h_ += this.fight_zone_id;
/*  87 */     _h_ += this.selection_stage;
/*  88 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  92 */     StringBuilder _sb_ = new StringBuilder();
/*  93 */     _sb_.append("(");
/*  94 */     _sb_.append(this.activity_cfg_id).append(",");
/*  95 */     _sb_.append(this.fight_zone_id).append(",");
/*  96 */     _sb_.append(this.selection_stage).append(",");
/*  97 */     _sb_.append(")");
/*  98 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CGetCrossBattleSelectionFightStageReq _o_) {
/* 102 */     if (_o_ == this) return 0;
/* 103 */     int _c_ = 0;
/* 104 */     _c_ = this.activity_cfg_id - _o_.activity_cfg_id;
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = this.fight_zone_id - _o_.fight_zone_id;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = this.selection_stage - _o_.selection_stage;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\CGetCrossBattleSelectionFightStageReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */