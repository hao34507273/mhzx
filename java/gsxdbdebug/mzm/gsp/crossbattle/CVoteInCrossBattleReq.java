/*     */ package mzm.gsp.crossbattle;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattleOwnCfg;
/*     */ import mzm.gsp.crossbattle.main.CrossBattleOneByOneManager;
/*     */ import mzm.gsp.crossbattle.own.PCVoteInCrossBattle;
/*     */ 
/*     */ public class CVoteInCrossBattleReq
/*     */   extends __CVoteInCrossBattleReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12616986;
/*     */   public int activity_cfg_id;
/*     */   public long target_corps_id;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleid = Role.getRoleId(this);
/*  21 */     if ((roleid < 0L) || (!SCrossBattleOwnCfg.getAll().containsKey(Integer.valueOf(this.activity_cfg_id))))
/*     */     {
/*  23 */       return;
/*     */     }
/*  25 */     CrossBattleOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(this.activity_cfg_id), new PCVoteInCrossBattle(roleid, this.activity_cfg_id, this.target_corps_id));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  34 */     return 12616986;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CVoteInCrossBattleReq() {}
/*     */   
/*     */ 
/*     */   public CVoteInCrossBattleReq(int _activity_cfg_id_, long _target_corps_id_)
/*     */   {
/*  44 */     this.activity_cfg_id = _activity_cfg_id_;
/*  45 */     this.target_corps_id = _target_corps_id_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  49 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  53 */     _os_.marshal(this.activity_cfg_id);
/*  54 */     _os_.marshal(this.target_corps_id);
/*  55 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  59 */     this.activity_cfg_id = _os_.unmarshal_int();
/*  60 */     this.target_corps_id = _os_.unmarshal_long();
/*  61 */     if (!_validator_()) {
/*  62 */       throw new VerifyError("validator failed");
/*     */     }
/*  64 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  68 */     if (_o1_ == this) return true;
/*  69 */     if ((_o1_ instanceof CVoteInCrossBattleReq)) {
/*  70 */       CVoteInCrossBattleReq _o_ = (CVoteInCrossBattleReq)_o1_;
/*  71 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/*  72 */       if (this.target_corps_id != _o_.target_corps_id) return false;
/*  73 */       return true;
/*     */     }
/*  75 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  79 */     int _h_ = 0;
/*  80 */     _h_ += this.activity_cfg_id;
/*  81 */     _h_ += (int)this.target_corps_id;
/*  82 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  86 */     StringBuilder _sb_ = new StringBuilder();
/*  87 */     _sb_.append("(");
/*  88 */     _sb_.append(this.activity_cfg_id).append(",");
/*  89 */     _sb_.append(this.target_corps_id).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CVoteInCrossBattleReq _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = this.activity_cfg_id - _o_.activity_cfg_id;
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = Long.signum(this.target_corps_id - _o_.target_corps_id);
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\CVoteInCrossBattleReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */