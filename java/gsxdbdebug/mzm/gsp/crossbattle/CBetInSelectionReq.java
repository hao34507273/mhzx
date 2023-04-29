/*     */ package mzm.gsp.crossbattle;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.crossbattle.bet.PCBetInKnockout;
/*     */ import mzm.gsp.crossbattle.main.CrossBattleOneByOneManager;
/*     */ 
/*     */ public class CBetInSelectionReq extends __CBetInSelectionReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12617044;
/*     */   public int activity_cfg_id;
/*     */   public int fight_zone_id;
/*     */   public int selection_stage;
/*     */   public int fight_index;
/*     */   public long target_corps_id;
/*     */   public int sortid;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleid = Role.getRoleId(this);
/*  21 */     if ((roleid < 0L) || (!mzm.gsp.crossbattle.confbean.SCrossBattleKnockoutBetCfg.getAll().containsKey(Integer.valueOf(this.activity_cfg_id))))
/*     */     {
/*  23 */       return;
/*     */     }
/*  25 */     CrossBattleOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(this.activity_cfg_id), new PCBetInKnockout(roleid, this.activity_cfg_id, 1, this.fight_zone_id, this.selection_stage, this.fight_index, this.target_corps_id, this.sortid));
/*     */   }
/*     */   
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
/*  38 */     return 12617044;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public CBetInSelectionReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CBetInSelectionReq(int _activity_cfg_id_, int _fight_zone_id_, int _selection_stage_, int _fight_index_, long _target_corps_id_, int _sortid_)
/*     */   {
/*  52 */     this.activity_cfg_id = _activity_cfg_id_;
/*  53 */     this.fight_zone_id = _fight_zone_id_;
/*  54 */     this.selection_stage = _selection_stage_;
/*  55 */     this.fight_index = _fight_index_;
/*  56 */     this.target_corps_id = _target_corps_id_;
/*  57 */     this.sortid = _sortid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  61 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  65 */     _os_.marshal(this.activity_cfg_id);
/*  66 */     _os_.marshal(this.fight_zone_id);
/*  67 */     _os_.marshal(this.selection_stage);
/*  68 */     _os_.marshal(this.fight_index);
/*  69 */     _os_.marshal(this.target_corps_id);
/*  70 */     _os_.marshal(this.sortid);
/*  71 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  75 */     this.activity_cfg_id = _os_.unmarshal_int();
/*  76 */     this.fight_zone_id = _os_.unmarshal_int();
/*  77 */     this.selection_stage = _os_.unmarshal_int();
/*  78 */     this.fight_index = _os_.unmarshal_int();
/*  79 */     this.target_corps_id = _os_.unmarshal_long();
/*  80 */     this.sortid = _os_.unmarshal_int();
/*  81 */     if (!_validator_()) {
/*  82 */       throw new VerifyError("validator failed");
/*     */     }
/*  84 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  88 */     if (_o1_ == this) return true;
/*  89 */     if ((_o1_ instanceof CBetInSelectionReq)) {
/*  90 */       CBetInSelectionReq _o_ = (CBetInSelectionReq)_o1_;
/*  91 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/*  92 */       if (this.fight_zone_id != _o_.fight_zone_id) return false;
/*  93 */       if (this.selection_stage != _o_.selection_stage) return false;
/*  94 */       if (this.fight_index != _o_.fight_index) return false;
/*  95 */       if (this.target_corps_id != _o_.target_corps_id) return false;
/*  96 */       if (this.sortid != _o_.sortid) return false;
/*  97 */       return true;
/*     */     }
/*  99 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 103 */     int _h_ = 0;
/* 104 */     _h_ += this.activity_cfg_id;
/* 105 */     _h_ += this.fight_zone_id;
/* 106 */     _h_ += this.selection_stage;
/* 107 */     _h_ += this.fight_index;
/* 108 */     _h_ += (int)this.target_corps_id;
/* 109 */     _h_ += this.sortid;
/* 110 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 114 */     StringBuilder _sb_ = new StringBuilder();
/* 115 */     _sb_.append("(");
/* 116 */     _sb_.append(this.activity_cfg_id).append(",");
/* 117 */     _sb_.append(this.fight_zone_id).append(",");
/* 118 */     _sb_.append(this.selection_stage).append(",");
/* 119 */     _sb_.append(this.fight_index).append(",");
/* 120 */     _sb_.append(this.target_corps_id).append(",");
/* 121 */     _sb_.append(this.sortid).append(",");
/* 122 */     _sb_.append(")");
/* 123 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CBetInSelectionReq _o_) {
/* 127 */     if (_o_ == this) return 0;
/* 128 */     int _c_ = 0;
/* 129 */     _c_ = this.activity_cfg_id - _o_.activity_cfg_id;
/* 130 */     if (0 != _c_) return _c_;
/* 131 */     _c_ = this.fight_zone_id - _o_.fight_zone_id;
/* 132 */     if (0 != _c_) return _c_;
/* 133 */     _c_ = this.selection_stage - _o_.selection_stage;
/* 134 */     if (0 != _c_) return _c_;
/* 135 */     _c_ = this.fight_index - _o_.fight_index;
/* 136 */     if (0 != _c_) return _c_;
/* 137 */     _c_ = Long.signum(this.target_corps_id - _o_.target_corps_id);
/* 138 */     if (0 != _c_) return _c_;
/* 139 */     _c_ = this.sortid - _o_.sortid;
/* 140 */     if (0 != _c_) return _c_;
/* 141 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\CBetInSelectionReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */