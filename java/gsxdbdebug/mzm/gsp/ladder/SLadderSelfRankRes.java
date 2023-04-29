/*     */ package mzm.gsp.ladder;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SLadderSelfRankRes
/*     */   extends __SLadderSelfRankRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12607274;
/*     */   public int ranktype;
/*     */   public int rank;
/*     */   public int stage;
/*     */   public int score;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12607274;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SLadderSelfRankRes() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SLadderSelfRankRes(int _ranktype_, int _rank_, int _stage_, int _score_)
/*     */   {
/*  39 */     this.ranktype = _ranktype_;
/*  40 */     this.rank = _rank_;
/*  41 */     this.stage = _stage_;
/*  42 */     this.score = _score_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  50 */     _os_.marshal(this.ranktype);
/*  51 */     _os_.marshal(this.rank);
/*  52 */     _os_.marshal(this.stage);
/*  53 */     _os_.marshal(this.score);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.ranktype = _os_.unmarshal_int();
/*  59 */     this.rank = _os_.unmarshal_int();
/*  60 */     this.stage = _os_.unmarshal_int();
/*  61 */     this.score = _os_.unmarshal_int();
/*  62 */     if (!_validator_()) {
/*  63 */       throw new VerifyError("validator failed");
/*     */     }
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  69 */     if (_o1_ == this) return true;
/*  70 */     if ((_o1_ instanceof SLadderSelfRankRes)) {
/*  71 */       SLadderSelfRankRes _o_ = (SLadderSelfRankRes)_o1_;
/*  72 */       if (this.ranktype != _o_.ranktype) return false;
/*  73 */       if (this.rank != _o_.rank) return false;
/*  74 */       if (this.stage != _o_.stage) return false;
/*  75 */       if (this.score != _o_.score) return false;
/*  76 */       return true;
/*     */     }
/*  78 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  82 */     int _h_ = 0;
/*  83 */     _h_ += this.ranktype;
/*  84 */     _h_ += this.rank;
/*  85 */     _h_ += this.stage;
/*  86 */     _h_ += this.score;
/*  87 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  91 */     StringBuilder _sb_ = new StringBuilder();
/*  92 */     _sb_.append("(");
/*  93 */     _sb_.append(this.ranktype).append(",");
/*  94 */     _sb_.append(this.rank).append(",");
/*  95 */     _sb_.append(this.stage).append(",");
/*  96 */     _sb_.append(this.score).append(",");
/*  97 */     _sb_.append(")");
/*  98 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SLadderSelfRankRes _o_) {
/* 102 */     if (_o_ == this) return 0;
/* 103 */     int _c_ = 0;
/* 104 */     _c_ = this.ranktype - _o_.ranktype;
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = this.rank - _o_.rank;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = this.stage - _o_.stage;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     _c_ = this.score - _o_.score;
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ladder\SLadderSelfRankRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */