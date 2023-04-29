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
/*     */ public class SGetPointRaceRankSuccess
/*     */   extends __SGetPointRaceRankSuccess__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12617024;
/*     */   public byte rank_type;
/*     */   public int from;
/*     */   public int to;
/*     */   public ArrayList<PointRaceRankData> point_race_ranks;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12617024;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SGetPointRaceRankSuccess()
/*     */   {
/*  36 */     this.point_race_ranks = new ArrayList();
/*     */   }
/*     */   
/*     */   public SGetPointRaceRankSuccess(byte _rank_type_, int _from_, int _to_, ArrayList<PointRaceRankData> _point_race_ranks_) {
/*  40 */     this.rank_type = _rank_type_;
/*  41 */     this.from = _from_;
/*  42 */     this.to = _to_;
/*  43 */     this.point_race_ranks = _point_race_ranks_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  47 */     for (PointRaceRankData _v_ : this.point_race_ranks)
/*  48 */       if (!_v_._validator_()) return false;
/*  49 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  53 */     _os_.marshal(this.rank_type);
/*  54 */     _os_.marshal(this.from);
/*  55 */     _os_.marshal(this.to);
/*  56 */     _os_.compact_uint32(this.point_race_ranks.size());
/*  57 */     for (PointRaceRankData _v_ : this.point_race_ranks) {
/*  58 */       _os_.marshal(_v_);
/*     */     }
/*  60 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  64 */     this.rank_type = _os_.unmarshal_byte();
/*  65 */     this.from = _os_.unmarshal_int();
/*  66 */     this.to = _os_.unmarshal_int();
/*  67 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  68 */       PointRaceRankData _v_ = new PointRaceRankData();
/*  69 */       _v_.unmarshal(_os_);
/*  70 */       this.point_race_ranks.add(_v_);
/*     */     }
/*  72 */     if (!_validator_()) {
/*  73 */       throw new VerifyError("validator failed");
/*     */     }
/*  75 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  79 */     if (_o1_ == this) return true;
/*  80 */     if ((_o1_ instanceof SGetPointRaceRankSuccess)) {
/*  81 */       SGetPointRaceRankSuccess _o_ = (SGetPointRaceRankSuccess)_o1_;
/*  82 */       if (this.rank_type != _o_.rank_type) return false;
/*  83 */       if (this.from != _o_.from) return false;
/*  84 */       if (this.to != _o_.to) return false;
/*  85 */       if (!this.point_race_ranks.equals(_o_.point_race_ranks)) return false;
/*  86 */       return true;
/*     */     }
/*  88 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  92 */     int _h_ = 0;
/*  93 */     _h_ += this.rank_type;
/*  94 */     _h_ += this.from;
/*  95 */     _h_ += this.to;
/*  96 */     _h_ += this.point_race_ranks.hashCode();
/*  97 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 101 */     StringBuilder _sb_ = new StringBuilder();
/* 102 */     _sb_.append("(");
/* 103 */     _sb_.append(this.rank_type).append(",");
/* 104 */     _sb_.append(this.from).append(",");
/* 105 */     _sb_.append(this.to).append(",");
/* 106 */     _sb_.append(this.point_race_ranks).append(",");
/* 107 */     _sb_.append(")");
/* 108 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\SGetPointRaceRankSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */