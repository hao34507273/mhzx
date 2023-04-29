/*     */ package mzm.gsp.crossbattle;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.crossbattle.confbean.CrossBattleConsts;
/*     */ import mzm.gsp.crossbattle.knockout.PCGetKnockOutStageOwnServerFightReq;
/*     */ import mzm.gsp.crossbattle.main.CrossBattleOneByOneManager;
/*     */ 
/*     */ 
/*     */ public class CGetSelectionStageOwnServerFightReq
/*     */   extends __CGetSelectionStageOwnServerFightReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12617080;
/*     */   public int activity_cfg_id;
/*     */   public int selection_stage;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleId = Role.getRoleId(this);
/*  21 */     if (roleId < 0L)
/*     */     {
/*  23 */       return;
/*     */     }
/*  25 */     CrossBattleOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(CrossBattleConsts.getInstance().CURRENT_ACTIVITY_CFG_ID), new PCGetKnockOutStageOwnServerFightReq(roleId, this.activity_cfg_id, this.selection_stage, 1));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  34 */     return 12617080;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CGetSelectionStageOwnServerFightReq() {}
/*     */   
/*     */ 
/*     */   public CGetSelectionStageOwnServerFightReq(int _activity_cfg_id_, int _selection_stage_)
/*     */   {
/*  44 */     this.activity_cfg_id = _activity_cfg_id_;
/*  45 */     this.selection_stage = _selection_stage_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  49 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  53 */     _os_.marshal(this.activity_cfg_id);
/*  54 */     _os_.marshal(this.selection_stage);
/*  55 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  59 */     this.activity_cfg_id = _os_.unmarshal_int();
/*  60 */     this.selection_stage = _os_.unmarshal_int();
/*  61 */     if (!_validator_()) {
/*  62 */       throw new VerifyError("validator failed");
/*     */     }
/*  64 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  68 */     if (_o1_ == this) return true;
/*  69 */     if ((_o1_ instanceof CGetSelectionStageOwnServerFightReq)) {
/*  70 */       CGetSelectionStageOwnServerFightReq _o_ = (CGetSelectionStageOwnServerFightReq)_o1_;
/*  71 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/*  72 */       if (this.selection_stage != _o_.selection_stage) return false;
/*  73 */       return true;
/*     */     }
/*  75 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  79 */     int _h_ = 0;
/*  80 */     _h_ += this.activity_cfg_id;
/*  81 */     _h_ += this.selection_stage;
/*  82 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  86 */     StringBuilder _sb_ = new StringBuilder();
/*  87 */     _sb_.append("(");
/*  88 */     _sb_.append(this.activity_cfg_id).append(",");
/*  89 */     _sb_.append(this.selection_stage).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CGetSelectionStageOwnServerFightReq _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = this.activity_cfg_id - _o_.activity_cfg_id;
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = this.selection_stage - _o_.selection_stage;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\CGetSelectionStageOwnServerFightReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */