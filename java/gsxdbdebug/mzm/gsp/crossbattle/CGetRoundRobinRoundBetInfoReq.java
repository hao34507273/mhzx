/*     */ package mzm.gsp.crossbattle;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.crossbattle.bet.PCGetRoundRobinRoundBetInfo;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattleOwnCfg;
/*     */ import mzm.gsp.crossbattle.main.CrossBattleOneByOneManager;
/*     */ 
/*     */ public class CGetRoundRobinRoundBetInfoReq
/*     */   extends __CGetRoundRobinRoundBetInfoReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12617034;
/*     */   public int activity_cfg_id;
/*     */   public int round_index;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleid = Role.getRoleId(this);
/*  21 */     if ((roleid < 0L) || (!SCrossBattleOwnCfg.getAll().containsKey(Integer.valueOf(this.activity_cfg_id))))
/*     */     {
/*  23 */       return;
/*     */     }
/*  25 */     CrossBattleOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(this.activity_cfg_id), new PCGetRoundRobinRoundBetInfo(roleid, this.activity_cfg_id, this.round_index));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  34 */     return 12617034;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CGetRoundRobinRoundBetInfoReq() {}
/*     */   
/*     */ 
/*     */   public CGetRoundRobinRoundBetInfoReq(int _activity_cfg_id_, int _round_index_)
/*     */   {
/*  44 */     this.activity_cfg_id = _activity_cfg_id_;
/*  45 */     this.round_index = _round_index_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  49 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  53 */     _os_.marshal(this.activity_cfg_id);
/*  54 */     _os_.marshal(this.round_index);
/*  55 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  59 */     this.activity_cfg_id = _os_.unmarshal_int();
/*  60 */     this.round_index = _os_.unmarshal_int();
/*  61 */     if (!_validator_()) {
/*  62 */       throw new VerifyError("validator failed");
/*     */     }
/*  64 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  68 */     if (_o1_ == this) return true;
/*  69 */     if ((_o1_ instanceof CGetRoundRobinRoundBetInfoReq)) {
/*  70 */       CGetRoundRobinRoundBetInfoReq _o_ = (CGetRoundRobinRoundBetInfoReq)_o1_;
/*  71 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/*  72 */       if (this.round_index != _o_.round_index) return false;
/*  73 */       return true;
/*     */     }
/*  75 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  79 */     int _h_ = 0;
/*  80 */     _h_ += this.activity_cfg_id;
/*  81 */     _h_ += this.round_index;
/*  82 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  86 */     StringBuilder _sb_ = new StringBuilder();
/*  87 */     _sb_.append("(");
/*  88 */     _sb_.append(this.activity_cfg_id).append(",");
/*  89 */     _sb_.append(this.round_index).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CGetRoundRobinRoundBetInfoReq _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = this.activity_cfg_id - _o_.activity_cfg_id;
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = this.round_index - _o_.round_index;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\CGetRoundRobinRoundBetInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */