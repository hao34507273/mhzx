/*     */ package mzm.gsp.crossbattle;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.crossbattle.bet.PCBetInKnockout;
/*     */ import mzm.gsp.crossbattle.main.CrossBattleOneByOneManager;
/*     */ 
/*     */ public class CBetInFinalReq extends __CBetInFinalReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12617072;
/*     */   public int activity_cfg_id;
/*     */   public int stage;
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
/*  25 */     CrossBattleOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(this.activity_cfg_id), new PCBetInKnockout(roleid, this.activity_cfg_id, 2, 1, this.stage, this.fight_index, this.target_corps_id, this.sortid));
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
/*  37 */     return 12617072;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CBetInFinalReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CBetInFinalReq(int _activity_cfg_id_, int _stage_, int _fight_index_, long _target_corps_id_, int _sortid_)
/*     */   {
/*  50 */     this.activity_cfg_id = _activity_cfg_id_;
/*  51 */     this.stage = _stage_;
/*  52 */     this.fight_index = _fight_index_;
/*  53 */     this.target_corps_id = _target_corps_id_;
/*  54 */     this.sortid = _sortid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  58 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  62 */     _os_.marshal(this.activity_cfg_id);
/*  63 */     _os_.marshal(this.stage);
/*  64 */     _os_.marshal(this.fight_index);
/*  65 */     _os_.marshal(this.target_corps_id);
/*  66 */     _os_.marshal(this.sortid);
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  71 */     this.activity_cfg_id = _os_.unmarshal_int();
/*  72 */     this.stage = _os_.unmarshal_int();
/*  73 */     this.fight_index = _os_.unmarshal_int();
/*  74 */     this.target_corps_id = _os_.unmarshal_long();
/*  75 */     this.sortid = _os_.unmarshal_int();
/*  76 */     if (!_validator_()) {
/*  77 */       throw new VerifyError("validator failed");
/*     */     }
/*  79 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  83 */     if (_o1_ == this) return true;
/*  84 */     if ((_o1_ instanceof CBetInFinalReq)) {
/*  85 */       CBetInFinalReq _o_ = (CBetInFinalReq)_o1_;
/*  86 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/*  87 */       if (this.stage != _o_.stage) return false;
/*  88 */       if (this.fight_index != _o_.fight_index) return false;
/*  89 */       if (this.target_corps_id != _o_.target_corps_id) return false;
/*  90 */       if (this.sortid != _o_.sortid) return false;
/*  91 */       return true;
/*     */     }
/*  93 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  97 */     int _h_ = 0;
/*  98 */     _h_ += this.activity_cfg_id;
/*  99 */     _h_ += this.stage;
/* 100 */     _h_ += this.fight_index;
/* 101 */     _h_ += (int)this.target_corps_id;
/* 102 */     _h_ += this.sortid;
/* 103 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 107 */     StringBuilder _sb_ = new StringBuilder();
/* 108 */     _sb_.append("(");
/* 109 */     _sb_.append(this.activity_cfg_id).append(",");
/* 110 */     _sb_.append(this.stage).append(",");
/* 111 */     _sb_.append(this.fight_index).append(",");
/* 112 */     _sb_.append(this.target_corps_id).append(",");
/* 113 */     _sb_.append(this.sortid).append(",");
/* 114 */     _sb_.append(")");
/* 115 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CBetInFinalReq _o_) {
/* 119 */     if (_o_ == this) return 0;
/* 120 */     int _c_ = 0;
/* 121 */     _c_ = this.activity_cfg_id - _o_.activity_cfg_id;
/* 122 */     if (0 != _c_) return _c_;
/* 123 */     _c_ = this.stage - _o_.stage;
/* 124 */     if (0 != _c_) return _c_;
/* 125 */     _c_ = this.fight_index - _o_.fight_index;
/* 126 */     if (0 != _c_) return _c_;
/* 127 */     _c_ = Long.signum(this.target_corps_id - _o_.target_corps_id);
/* 128 */     if (0 != _c_) return _c_;
/* 129 */     _c_ = this.sortid - _o_.sortid;
/* 130 */     if (0 != _c_) return _c_;
/* 131 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\CBetInFinalReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */