/*     */ package mzm.gsp.crossbattle;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.crossbattle.main.CrossBattleOneByOneManager;
/*     */ import mzm.gsp.crossbattle.own.PCWatchRoundRobinFightRecord;
/*     */ 
/*     */ public class CWatchRoundRobinFightRecordReq extends __CWatchRoundRobinFightRecordReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12617030;
/*     */   public int activity_cfg_id;
/*     */   public int round_index;
/*     */   public long corps_a_id;
/*     */   public long corps_b_id;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleid = Role.getRoleId(this);
/*  21 */     if ((roleid < 0L) || (!mzm.gsp.crossbattle.confbean.SCrossBattleOwnCfg.getAll().containsKey(Integer.valueOf(this.activity_cfg_id))))
/*     */     {
/*  23 */       return;
/*     */     }
/*  25 */     CrossBattleOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(this.activity_cfg_id), new PCWatchRoundRobinFightRecord(roleid, this.activity_cfg_id, this.round_index, this.corps_a_id, this.corps_b_id));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  35 */     return 12617030;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CWatchRoundRobinFightRecordReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CWatchRoundRobinFightRecordReq(int _activity_cfg_id_, int _round_index_, long _corps_a_id_, long _corps_b_id_)
/*     */   {
/*  47 */     this.activity_cfg_id = _activity_cfg_id_;
/*  48 */     this.round_index = _round_index_;
/*  49 */     this.corps_a_id = _corps_a_id_;
/*  50 */     this.corps_b_id = _corps_b_id_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  54 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  58 */     _os_.marshal(this.activity_cfg_id);
/*  59 */     _os_.marshal(this.round_index);
/*  60 */     _os_.marshal(this.corps_a_id);
/*  61 */     _os_.marshal(this.corps_b_id);
/*  62 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  66 */     this.activity_cfg_id = _os_.unmarshal_int();
/*  67 */     this.round_index = _os_.unmarshal_int();
/*  68 */     this.corps_a_id = _os_.unmarshal_long();
/*  69 */     this.corps_b_id = _os_.unmarshal_long();
/*  70 */     if (!_validator_()) {
/*  71 */       throw new VerifyError("validator failed");
/*     */     }
/*  73 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  77 */     if (_o1_ == this) return true;
/*  78 */     if ((_o1_ instanceof CWatchRoundRobinFightRecordReq)) {
/*  79 */       CWatchRoundRobinFightRecordReq _o_ = (CWatchRoundRobinFightRecordReq)_o1_;
/*  80 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/*  81 */       if (this.round_index != _o_.round_index) return false;
/*  82 */       if (this.corps_a_id != _o_.corps_a_id) return false;
/*  83 */       if (this.corps_b_id != _o_.corps_b_id) return false;
/*  84 */       return true;
/*     */     }
/*  86 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  90 */     int _h_ = 0;
/*  91 */     _h_ += this.activity_cfg_id;
/*  92 */     _h_ += this.round_index;
/*  93 */     _h_ += (int)this.corps_a_id;
/*  94 */     _h_ += (int)this.corps_b_id;
/*  95 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  99 */     StringBuilder _sb_ = new StringBuilder();
/* 100 */     _sb_.append("(");
/* 101 */     _sb_.append(this.activity_cfg_id).append(",");
/* 102 */     _sb_.append(this.round_index).append(",");
/* 103 */     _sb_.append(this.corps_a_id).append(",");
/* 104 */     _sb_.append(this.corps_b_id).append(",");
/* 105 */     _sb_.append(")");
/* 106 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CWatchRoundRobinFightRecordReq _o_) {
/* 110 */     if (_o_ == this) return 0;
/* 111 */     int _c_ = 0;
/* 112 */     _c_ = this.activity_cfg_id - _o_.activity_cfg_id;
/* 113 */     if (0 != _c_) return _c_;
/* 114 */     _c_ = this.round_index - _o_.round_index;
/* 115 */     if (0 != _c_) return _c_;
/* 116 */     _c_ = Long.signum(this.corps_a_id - _o_.corps_a_id);
/* 117 */     if (0 != _c_) return _c_;
/* 118 */     _c_ = Long.signum(this.corps_b_id - _o_.corps_b_id);
/* 119 */     if (0 != _c_) return _c_;
/* 120 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\CWatchRoundRobinFightRecordReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */