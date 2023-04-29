/*     */ package mzm.gsp.crossbattle;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.crossbattle.bet.PCBetInRoundRobin;
/*     */ import mzm.gsp.crossbattle.main.CrossBattleOneByOneManager;
/*     */ 
/*     */ public class CBetInRoundRobinReq extends __CBetInRoundRobinReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12617039;
/*     */   public int activity_cfg_id;
/*     */   public int round_index;
/*     */   public long target_corps_id;
/*     */   public int sortid;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleid = Role.getRoleId(this);
/*  21 */     if ((roleid < 0L) || (!mzm.gsp.crossbattle.confbean.SCrossBattleOwnCfg.getAll().containsKey(Integer.valueOf(this.activity_cfg_id))))
/*     */     {
/*  23 */       return;
/*     */     }
/*  25 */     CrossBattleOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(this.activity_cfg_id), new PCBetInRoundRobin(roleid, this.activity_cfg_id, this.round_index, this.target_corps_id, this.sortid));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  34 */     return 12617039;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CBetInRoundRobinReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CBetInRoundRobinReq(int _activity_cfg_id_, int _round_index_, long _target_corps_id_, int _sortid_)
/*     */   {
/*  46 */     this.activity_cfg_id = _activity_cfg_id_;
/*  47 */     this.round_index = _round_index_;
/*  48 */     this.target_corps_id = _target_corps_id_;
/*  49 */     this.sortid = _sortid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  53 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  57 */     _os_.marshal(this.activity_cfg_id);
/*  58 */     _os_.marshal(this.round_index);
/*  59 */     _os_.marshal(this.target_corps_id);
/*  60 */     _os_.marshal(this.sortid);
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  65 */     this.activity_cfg_id = _os_.unmarshal_int();
/*  66 */     this.round_index = _os_.unmarshal_int();
/*  67 */     this.target_corps_id = _os_.unmarshal_long();
/*  68 */     this.sortid = _os_.unmarshal_int();
/*  69 */     if (!_validator_()) {
/*  70 */       throw new VerifyError("validator failed");
/*     */     }
/*  72 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  76 */     if (_o1_ == this) return true;
/*  77 */     if ((_o1_ instanceof CBetInRoundRobinReq)) {
/*  78 */       CBetInRoundRobinReq _o_ = (CBetInRoundRobinReq)_o1_;
/*  79 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/*  80 */       if (this.round_index != _o_.round_index) return false;
/*  81 */       if (this.target_corps_id != _o_.target_corps_id) return false;
/*  82 */       if (this.sortid != _o_.sortid) return false;
/*  83 */       return true;
/*     */     }
/*  85 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  89 */     int _h_ = 0;
/*  90 */     _h_ += this.activity_cfg_id;
/*  91 */     _h_ += this.round_index;
/*  92 */     _h_ += (int)this.target_corps_id;
/*  93 */     _h_ += this.sortid;
/*  94 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  98 */     StringBuilder _sb_ = new StringBuilder();
/*  99 */     _sb_.append("(");
/* 100 */     _sb_.append(this.activity_cfg_id).append(",");
/* 101 */     _sb_.append(this.round_index).append(",");
/* 102 */     _sb_.append(this.target_corps_id).append(",");
/* 103 */     _sb_.append(this.sortid).append(",");
/* 104 */     _sb_.append(")");
/* 105 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CBetInRoundRobinReq _o_) {
/* 109 */     if (_o_ == this) return 0;
/* 110 */     int _c_ = 0;
/* 111 */     _c_ = this.activity_cfg_id - _o_.activity_cfg_id;
/* 112 */     if (0 != _c_) return _c_;
/* 113 */     _c_ = this.round_index - _o_.round_index;
/* 114 */     if (0 != _c_) return _c_;
/* 115 */     _c_ = Long.signum(this.target_corps_id - _o_.target_corps_id);
/* 116 */     if (0 != _c_) return _c_;
/* 117 */     _c_ = this.sortid - _o_.sortid;
/* 118 */     if (0 != _c_) return _c_;
/* 119 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\CBetInRoundRobinReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */