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
/*     */ public class SGetCrossBattleVoteRankSuccess
/*     */   extends __SGetCrossBattleVoteRankSuccess__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12616974;
/*     */   public int activity_cfg_id;
/*     */   public int rank_type;
/*     */   public CrossBattleVoteRankData myrank;
/*     */   public ArrayList<CrossBattleVoteRankData> ranklist;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12616974;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SGetCrossBattleVoteRankSuccess()
/*     */   {
/*  36 */     this.rank_type = 0;
/*  37 */     this.myrank = new CrossBattleVoteRankData();
/*  38 */     this.ranklist = new ArrayList();
/*     */   }
/*     */   
/*     */   public SGetCrossBattleVoteRankSuccess(int _activity_cfg_id_, int _rank_type_, CrossBattleVoteRankData _myrank_, ArrayList<CrossBattleVoteRankData> _ranklist_) {
/*  42 */     this.activity_cfg_id = _activity_cfg_id_;
/*  43 */     this.rank_type = _rank_type_;
/*  44 */     this.myrank = _myrank_;
/*  45 */     this.ranklist = _ranklist_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  49 */     if (!this.myrank._validator_()) return false;
/*  50 */     for (CrossBattleVoteRankData _v_ : this.ranklist)
/*  51 */       if (!_v_._validator_()) return false;
/*  52 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  56 */     _os_.marshal(this.activity_cfg_id);
/*  57 */     _os_.marshal(this.rank_type);
/*  58 */     _os_.marshal(this.myrank);
/*  59 */     _os_.compact_uint32(this.ranklist.size());
/*  60 */     for (CrossBattleVoteRankData _v_ : this.ranklist) {
/*  61 */       _os_.marshal(_v_);
/*     */     }
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  67 */     this.activity_cfg_id = _os_.unmarshal_int();
/*  68 */     this.rank_type = _os_.unmarshal_int();
/*  69 */     this.myrank.unmarshal(_os_);
/*  70 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  71 */       CrossBattleVoteRankData _v_ = new CrossBattleVoteRankData();
/*  72 */       _v_.unmarshal(_os_);
/*  73 */       this.ranklist.add(_v_);
/*     */     }
/*  75 */     if (!_validator_()) {
/*  76 */       throw new VerifyError("validator failed");
/*     */     }
/*  78 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  82 */     if (_o1_ == this) return true;
/*  83 */     if ((_o1_ instanceof SGetCrossBattleVoteRankSuccess)) {
/*  84 */       SGetCrossBattleVoteRankSuccess _o_ = (SGetCrossBattleVoteRankSuccess)_o1_;
/*  85 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/*  86 */       if (this.rank_type != _o_.rank_type) return false;
/*  87 */       if (!this.myrank.equals(_o_.myrank)) return false;
/*  88 */       if (!this.ranklist.equals(_o_.ranklist)) return false;
/*  89 */       return true;
/*     */     }
/*  91 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  95 */     int _h_ = 0;
/*  96 */     _h_ += this.activity_cfg_id;
/*  97 */     _h_ += this.rank_type;
/*  98 */     _h_ += this.myrank.hashCode();
/*  99 */     _h_ += this.ranklist.hashCode();
/* 100 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 104 */     StringBuilder _sb_ = new StringBuilder();
/* 105 */     _sb_.append("(");
/* 106 */     _sb_.append(this.activity_cfg_id).append(",");
/* 107 */     _sb_.append(this.rank_type).append(",");
/* 108 */     _sb_.append(this.myrank).append(",");
/* 109 */     _sb_.append(this.ranklist).append(",");
/* 110 */     _sb_.append(")");
/* 111 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\SGetCrossBattleVoteRankSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */