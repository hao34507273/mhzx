/*     */ package mzm.gsp.crossbattle;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.crossbattle.main.CrossBattleOneByOneManager;
/*     */ import mzm.gsp.crossbattle.own.PCWatchRoundRobinFight;
/*     */ 
/*     */ public class CWatchRoundRobinFightReq extends __CWatchRoundRobinFightReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12617029;
/*     */   public int activity_cfg_id;
/*     */   public int round_index;
/*     */   public long corps_a_id;
/*     */   public long corps_b_id;
/*     */   public long watch_corps_id;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleid = Role.getRoleId(this);
/*  21 */     if ((roleid < 0L) || (!mzm.gsp.crossbattle.confbean.SCrossBattleOwnCfg.getAll().containsKey(Integer.valueOf(this.activity_cfg_id))))
/*     */     {
/*  23 */       return;
/*     */     }
/*  25 */     CrossBattleOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(this.activity_cfg_id), new PCWatchRoundRobinFight(roleid, this.activity_cfg_id, this.round_index, this.corps_a_id, this.corps_b_id, this.watch_corps_id));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  36 */     return 12617029;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CWatchRoundRobinFightReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CWatchRoundRobinFightReq(int _activity_cfg_id_, int _round_index_, long _corps_a_id_, long _corps_b_id_, long _watch_corps_id_)
/*     */   {
/*  49 */     this.activity_cfg_id = _activity_cfg_id_;
/*  50 */     this.round_index = _round_index_;
/*  51 */     this.corps_a_id = _corps_a_id_;
/*  52 */     this.corps_b_id = _corps_b_id_;
/*  53 */     this.watch_corps_id = _watch_corps_id_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  57 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  61 */     _os_.marshal(this.activity_cfg_id);
/*  62 */     _os_.marshal(this.round_index);
/*  63 */     _os_.marshal(this.corps_a_id);
/*  64 */     _os_.marshal(this.corps_b_id);
/*  65 */     _os_.marshal(this.watch_corps_id);
/*  66 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  70 */     this.activity_cfg_id = _os_.unmarshal_int();
/*  71 */     this.round_index = _os_.unmarshal_int();
/*  72 */     this.corps_a_id = _os_.unmarshal_long();
/*  73 */     this.corps_b_id = _os_.unmarshal_long();
/*  74 */     this.watch_corps_id = _os_.unmarshal_long();
/*  75 */     if (!_validator_()) {
/*  76 */       throw new VerifyError("validator failed");
/*     */     }
/*  78 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  82 */     if (_o1_ == this) return true;
/*  83 */     if ((_o1_ instanceof CWatchRoundRobinFightReq)) {
/*  84 */       CWatchRoundRobinFightReq _o_ = (CWatchRoundRobinFightReq)_o1_;
/*  85 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/*  86 */       if (this.round_index != _o_.round_index) return false;
/*  87 */       if (this.corps_a_id != _o_.corps_a_id) return false;
/*  88 */       if (this.corps_b_id != _o_.corps_b_id) return false;
/*  89 */       if (this.watch_corps_id != _o_.watch_corps_id) return false;
/*  90 */       return true;
/*     */     }
/*  92 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  96 */     int _h_ = 0;
/*  97 */     _h_ += this.activity_cfg_id;
/*  98 */     _h_ += this.round_index;
/*  99 */     _h_ += (int)this.corps_a_id;
/* 100 */     _h_ += (int)this.corps_b_id;
/* 101 */     _h_ += (int)this.watch_corps_id;
/* 102 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 106 */     StringBuilder _sb_ = new StringBuilder();
/* 107 */     _sb_.append("(");
/* 108 */     _sb_.append(this.activity_cfg_id).append(",");
/* 109 */     _sb_.append(this.round_index).append(",");
/* 110 */     _sb_.append(this.corps_a_id).append(",");
/* 111 */     _sb_.append(this.corps_b_id).append(",");
/* 112 */     _sb_.append(this.watch_corps_id).append(",");
/* 113 */     _sb_.append(")");
/* 114 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CWatchRoundRobinFightReq _o_) {
/* 118 */     if (_o_ == this) return 0;
/* 119 */     int _c_ = 0;
/* 120 */     _c_ = this.activity_cfg_id - _o_.activity_cfg_id;
/* 121 */     if (0 != _c_) return _c_;
/* 122 */     _c_ = this.round_index - _o_.round_index;
/* 123 */     if (0 != _c_) return _c_;
/* 124 */     _c_ = Long.signum(this.corps_a_id - _o_.corps_a_id);
/* 125 */     if (0 != _c_) return _c_;
/* 126 */     _c_ = Long.signum(this.corps_b_id - _o_.corps_b_id);
/* 127 */     if (0 != _c_) return _c_;
/* 128 */     _c_ = Long.signum(this.watch_corps_id - _o_.watch_corps_id);
/* 129 */     if (0 != _c_) return _c_;
/* 130 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\CWatchRoundRobinFightReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */