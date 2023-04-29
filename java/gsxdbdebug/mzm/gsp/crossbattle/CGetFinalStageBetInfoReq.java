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
/*     */ public class CGetFinalStageBetInfoReq
/*     */   extends __CGetFinalStageBetInfoReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12617077;
/*     */   public int activity_cfg_id;
/*     */   public int stage;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleid = Role.getRoleId(this);
/*  21 */     if ((roleid < 0L) || (!SCrossBattleKnockoutBetCfg.getAll().containsKey(Integer.valueOf(this.activity_cfg_id))))
/*     */     {
/*  23 */       return;
/*     */     }
/*  25 */     CrossBattleOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(this.activity_cfg_id), new PCGetKnockoutStageBetInfo(roleid, this.activity_cfg_id, 2, 1, this.stage));
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
/*  37 */     return 12617077;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CGetFinalStageBetInfoReq() {}
/*     */   
/*     */ 
/*     */   public CGetFinalStageBetInfoReq(int _activity_cfg_id_, int _stage_)
/*     */   {
/*  47 */     this.activity_cfg_id = _activity_cfg_id_;
/*  48 */     this.stage = _stage_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  52 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  56 */     _os_.marshal(this.activity_cfg_id);
/*  57 */     _os_.marshal(this.stage);
/*  58 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  62 */     this.activity_cfg_id = _os_.unmarshal_int();
/*  63 */     this.stage = _os_.unmarshal_int();
/*  64 */     if (!_validator_()) {
/*  65 */       throw new VerifyError("validator failed");
/*     */     }
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  71 */     if (_o1_ == this) return true;
/*  72 */     if ((_o1_ instanceof CGetFinalStageBetInfoReq)) {
/*  73 */       CGetFinalStageBetInfoReq _o_ = (CGetFinalStageBetInfoReq)_o1_;
/*  74 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/*  75 */       if (this.stage != _o_.stage) return false;
/*  76 */       return true;
/*     */     }
/*  78 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  82 */     int _h_ = 0;
/*  83 */     _h_ += this.activity_cfg_id;
/*  84 */     _h_ += this.stage;
/*  85 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  89 */     StringBuilder _sb_ = new StringBuilder();
/*  90 */     _sb_.append("(");
/*  91 */     _sb_.append(this.activity_cfg_id).append(",");
/*  92 */     _sb_.append(this.stage).append(",");
/*  93 */     _sb_.append(")");
/*  94 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CGetFinalStageBetInfoReq _o_) {
/*  98 */     if (_o_ == this) return 0;
/*  99 */     int _c_ = 0;
/* 100 */     _c_ = this.activity_cfg_id - _o_.activity_cfg_id;
/* 101 */     if (0 != _c_) return _c_;
/* 102 */     _c_ = this.stage - _o_.stage;
/* 103 */     if (0 != _c_) return _c_;
/* 104 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\CGetFinalStageBetInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */