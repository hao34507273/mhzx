/*     */ package mzm.gsp.crossbattle;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.crossbattle.bet.PCGetKnockoutStageBetInfo;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattleKnockoutBetCfg;
/*     */ import mzm.gsp.crossbattle.main.CrossBattleOneByOneManager;
/*     */ 
/*     */ public class CGetSelectionStageBetInfoReq extends __CGetSelectionStageBetInfoReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12617045;
/*     */   public int activity_cfg_id;
/*     */   public int fight_zone_id;
/*     */   public int selection_stage;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleid = Role.getRoleId(this);
/*  21 */     if ((roleid < 0L) || (!SCrossBattleKnockoutBetCfg.getAll().containsKey(Integer.valueOf(this.activity_cfg_id))))
/*     */     {
/*  23 */       return;
/*     */     }
/*  25 */     CrossBattleOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(this.activity_cfg_id), new PCGetKnockoutStageBetInfo(roleid, this.activity_cfg_id, 1, this.fight_zone_id, this.selection_stage));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  37 */     return 12617045;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CGetSelectionStageBetInfoReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CGetSelectionStageBetInfoReq(int _activity_cfg_id_, int _fight_zone_id_, int _selection_stage_)
/*     */   {
/*  48 */     this.activity_cfg_id = _activity_cfg_id_;
/*  49 */     this.fight_zone_id = _fight_zone_id_;
/*  50 */     this.selection_stage = _selection_stage_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  54 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  58 */     _os_.marshal(this.activity_cfg_id);
/*  59 */     _os_.marshal(this.fight_zone_id);
/*  60 */     _os_.marshal(this.selection_stage);
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  65 */     this.activity_cfg_id = _os_.unmarshal_int();
/*  66 */     this.fight_zone_id = _os_.unmarshal_int();
/*  67 */     this.selection_stage = _os_.unmarshal_int();
/*  68 */     if (!_validator_()) {
/*  69 */       throw new VerifyError("validator failed");
/*     */     }
/*  71 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  75 */     if (_o1_ == this) return true;
/*  76 */     if ((_o1_ instanceof CGetSelectionStageBetInfoReq)) {
/*  77 */       CGetSelectionStageBetInfoReq _o_ = (CGetSelectionStageBetInfoReq)_o1_;
/*  78 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/*  79 */       if (this.fight_zone_id != _o_.fight_zone_id) return false;
/*  80 */       if (this.selection_stage != _o_.selection_stage) return false;
/*  81 */       return true;
/*     */     }
/*  83 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  87 */     int _h_ = 0;
/*  88 */     _h_ += this.activity_cfg_id;
/*  89 */     _h_ += this.fight_zone_id;
/*  90 */     _h_ += this.selection_stage;
/*  91 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  95 */     StringBuilder _sb_ = new StringBuilder();
/*  96 */     _sb_.append("(");
/*  97 */     _sb_.append(this.activity_cfg_id).append(",");
/*  98 */     _sb_.append(this.fight_zone_id).append(",");
/*  99 */     _sb_.append(this.selection_stage).append(",");
/* 100 */     _sb_.append(")");
/* 101 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CGetSelectionStageBetInfoReq _o_) {
/* 105 */     if (_o_ == this) return 0;
/* 106 */     int _c_ = 0;
/* 107 */     _c_ = this.activity_cfg_id - _o_.activity_cfg_id;
/* 108 */     if (0 != _c_) return _c_;
/* 109 */     _c_ = this.fight_zone_id - _o_.fight_zone_id;
/* 110 */     if (0 != _c_) return _c_;
/* 111 */     _c_ = this.selection_stage - _o_.selection_stage;
/* 112 */     if (0 != _c_) return _c_;
/* 113 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\CGetSelectionStageBetInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */