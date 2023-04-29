/*     */ package mzm.gsp.crossbattle;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SSynVoteStageResultInCrossBattle
/*     */   extends __SSynVoteStageResultInCrossBattle__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12616985;
/*     */   public int activity_cfg_id;
/*     */   public ArrayList<CrossBattleVoteRankData> vote_stage_direct_promotion_corps_list;
/*     */   public ArrayList<CrossBattleVoteRankData> round_robin_point_rank_list;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12616985;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSynVoteStageResultInCrossBattle()
/*     */   {
/*  35 */     this.vote_stage_direct_promotion_corps_list = new ArrayList();
/*  36 */     this.round_robin_point_rank_list = new ArrayList();
/*     */   }
/*     */   
/*     */   public SSynVoteStageResultInCrossBattle(int _activity_cfg_id_, ArrayList<CrossBattleVoteRankData> _vote_stage_direct_promotion_corps_list_, ArrayList<CrossBattleVoteRankData> _round_robin_point_rank_list_) {
/*  40 */     this.activity_cfg_id = _activity_cfg_id_;
/*  41 */     this.vote_stage_direct_promotion_corps_list = _vote_stage_direct_promotion_corps_list_;
/*  42 */     this.round_robin_point_rank_list = _round_robin_point_rank_list_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     for (CrossBattleVoteRankData _v_ : this.vote_stage_direct_promotion_corps_list)
/*  47 */       if (!_v_._validator_()) return false;
/*  48 */     for (CrossBattleVoteRankData _v_ : this.round_robin_point_rank_list)
/*  49 */       if (!_v_._validator_()) return false;
/*  50 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  54 */     _os_.marshal(this.activity_cfg_id);
/*  55 */     _os_.compact_uint32(this.vote_stage_direct_promotion_corps_list.size());
/*  56 */     for (CrossBattleVoteRankData _v_ : this.vote_stage_direct_promotion_corps_list) {
/*  57 */       _os_.marshal(_v_);
/*     */     }
/*  59 */     _os_.compact_uint32(this.round_robin_point_rank_list.size());
/*  60 */     for (CrossBattleVoteRankData _v_ : this.round_robin_point_rank_list) {
/*  61 */       _os_.marshal(_v_);
/*     */     }
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  67 */     this.activity_cfg_id = _os_.unmarshal_int();
/*  68 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  69 */       CrossBattleVoteRankData _v_ = new CrossBattleVoteRankData();
/*  70 */       _v_.unmarshal(_os_);
/*  71 */       this.vote_stage_direct_promotion_corps_list.add(_v_);
/*     */     }
/*  73 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  74 */       CrossBattleVoteRankData _v_ = new CrossBattleVoteRankData();
/*  75 */       _v_.unmarshal(_os_);
/*  76 */       this.round_robin_point_rank_list.add(_v_);
/*     */     }
/*  78 */     if (!_validator_()) {
/*  79 */       throw new VerifyError("validator failed");
/*     */     }
/*  81 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  85 */     if (_o1_ == this) return true;
/*  86 */     if ((_o1_ instanceof SSynVoteStageResultInCrossBattle)) {
/*  87 */       SSynVoteStageResultInCrossBattle _o_ = (SSynVoteStageResultInCrossBattle)_o1_;
/*  88 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/*  89 */       if (!this.vote_stage_direct_promotion_corps_list.equals(_o_.vote_stage_direct_promotion_corps_list)) return false;
/*  90 */       if (!this.round_robin_point_rank_list.equals(_o_.round_robin_point_rank_list)) return false;
/*  91 */       return true;
/*     */     }
/*  93 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  97 */     int _h_ = 0;
/*  98 */     _h_ += this.activity_cfg_id;
/*  99 */     _h_ += this.vote_stage_direct_promotion_corps_list.hashCode();
/* 100 */     _h_ += this.round_robin_point_rank_list.hashCode();
/* 101 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 105 */     StringBuilder _sb_ = new StringBuilder();
/* 106 */     _sb_.append("(");
/* 107 */     _sb_.append(this.activity_cfg_id).append(",");
/* 108 */     _sb_.append(this.vote_stage_direct_promotion_corps_list).append(",");
/* 109 */     _sb_.append(this.round_robin_point_rank_list).append(",");
/* 110 */     _sb_.append(")");
/* 111 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\SSynVoteStageResultInCrossBattle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */