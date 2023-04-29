/*     */ package mzm.gsp.crossbattle;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.crossbattle.confbean.CrossBattleConsts;
/*     */ import mzm.gsp.crossbattle.knockout.PCGetCrossBattleFinalHistoryCorpsReq;
/*     */ import mzm.gsp.crossbattle.main.CrossBattleOneByOneManager;
/*     */ 
/*     */ public class CGetCrossBattleFinalHistoryCorpsReq
/*     */   extends __CGetCrossBattleFinalHistoryCorpsReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12617087;
/*     */   public int session;
/*     */   public int rank;
/*     */   public long corps_id;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleId = Role.getRoleId(this);
/*  21 */     if (roleId < 0L)
/*     */     {
/*  23 */       return;
/*     */     }
/*  25 */     CrossBattleOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(CrossBattleConsts.getInstance().CURRENT_ACTIVITY_CFG_ID), new PCGetCrossBattleFinalHistoryCorpsReq(roleId, this.session, this.rank, this.corps_id));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  34 */     return 12617087;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CGetCrossBattleFinalHistoryCorpsReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CGetCrossBattleFinalHistoryCorpsReq(int _session_, int _rank_, long _corps_id_)
/*     */   {
/*  45 */     this.session = _session_;
/*  46 */     this.rank = _rank_;
/*  47 */     this.corps_id = _corps_id_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  51 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  55 */     _os_.marshal(this.session);
/*  56 */     _os_.marshal(this.rank);
/*  57 */     _os_.marshal(this.corps_id);
/*  58 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  62 */     this.session = _os_.unmarshal_int();
/*  63 */     this.rank = _os_.unmarshal_int();
/*  64 */     this.corps_id = _os_.unmarshal_long();
/*  65 */     if (!_validator_()) {
/*  66 */       throw new VerifyError("validator failed");
/*     */     }
/*  68 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  72 */     if (_o1_ == this) return true;
/*  73 */     if ((_o1_ instanceof CGetCrossBattleFinalHistoryCorpsReq)) {
/*  74 */       CGetCrossBattleFinalHistoryCorpsReq _o_ = (CGetCrossBattleFinalHistoryCorpsReq)_o1_;
/*  75 */       if (this.session != _o_.session) return false;
/*  76 */       if (this.rank != _o_.rank) return false;
/*  77 */       if (this.corps_id != _o_.corps_id) return false;
/*  78 */       return true;
/*     */     }
/*  80 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  84 */     int _h_ = 0;
/*  85 */     _h_ += this.session;
/*  86 */     _h_ += this.rank;
/*  87 */     _h_ += (int)this.corps_id;
/*  88 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  92 */     StringBuilder _sb_ = new StringBuilder();
/*  93 */     _sb_.append("(");
/*  94 */     _sb_.append(this.session).append(",");
/*  95 */     _sb_.append(this.rank).append(",");
/*  96 */     _sb_.append(this.corps_id).append(",");
/*  97 */     _sb_.append(")");
/*  98 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CGetCrossBattleFinalHistoryCorpsReq _o_) {
/* 102 */     if (_o_ == this) return 0;
/* 103 */     int _c_ = 0;
/* 104 */     _c_ = this.session - _o_.session;
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = this.rank - _o_.rank;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = Long.signum(this.corps_id - _o_.corps_id);
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\CGetCrossBattleFinalHistoryCorpsReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */