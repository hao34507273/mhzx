/*     */ package mzm.gsp.crossbattle;
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
/*     */ public class SGetRoleCrossBattleBetRankSuccess
/*     */   extends __SGetRoleCrossBattleBetRankSuccess__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12617094;
/*     */   public int rank_type;
/*     */   public int activity_cfg_id;
/*     */   public int rank;
/*     */   public long profit;
/*     */   public int timestamp;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12617094;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SGetRoleCrossBattleBetRankSuccess() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SGetRoleCrossBattleBetRankSuccess(int _rank_type_, int _activity_cfg_id_, int _rank_, long _profit_, int _timestamp_)
/*     */   {
/*  40 */     this.rank_type = _rank_type_;
/*  41 */     this.activity_cfg_id = _activity_cfg_id_;
/*  42 */     this.rank = _rank_;
/*  43 */     this.profit = _profit_;
/*  44 */     this.timestamp = _timestamp_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.rank_type);
/*  53 */     _os_.marshal(this.activity_cfg_id);
/*  54 */     _os_.marshal(this.rank);
/*  55 */     _os_.marshal(this.profit);
/*  56 */     _os_.marshal(this.timestamp);
/*  57 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  61 */     this.rank_type = _os_.unmarshal_int();
/*  62 */     this.activity_cfg_id = _os_.unmarshal_int();
/*  63 */     this.rank = _os_.unmarshal_int();
/*  64 */     this.profit = _os_.unmarshal_long();
/*  65 */     this.timestamp = _os_.unmarshal_int();
/*  66 */     if (!_validator_()) {
/*  67 */       throw new VerifyError("validator failed");
/*     */     }
/*  69 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  73 */     if (_o1_ == this) return true;
/*  74 */     if ((_o1_ instanceof SGetRoleCrossBattleBetRankSuccess)) {
/*  75 */       SGetRoleCrossBattleBetRankSuccess _o_ = (SGetRoleCrossBattleBetRankSuccess)_o1_;
/*  76 */       if (this.rank_type != _o_.rank_type) return false;
/*  77 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/*  78 */       if (this.rank != _o_.rank) return false;
/*  79 */       if (this.profit != _o_.profit) return false;
/*  80 */       if (this.timestamp != _o_.timestamp) return false;
/*  81 */       return true;
/*     */     }
/*  83 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  87 */     int _h_ = 0;
/*  88 */     _h_ += this.rank_type;
/*  89 */     _h_ += this.activity_cfg_id;
/*  90 */     _h_ += this.rank;
/*  91 */     _h_ += (int)this.profit;
/*  92 */     _h_ += this.timestamp;
/*  93 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  97 */     StringBuilder _sb_ = new StringBuilder();
/*  98 */     _sb_.append("(");
/*  99 */     _sb_.append(this.rank_type).append(",");
/* 100 */     _sb_.append(this.activity_cfg_id).append(",");
/* 101 */     _sb_.append(this.rank).append(",");
/* 102 */     _sb_.append(this.profit).append(",");
/* 103 */     _sb_.append(this.timestamp).append(",");
/* 104 */     _sb_.append(")");
/* 105 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SGetRoleCrossBattleBetRankSuccess _o_) {
/* 109 */     if (_o_ == this) return 0;
/* 110 */     int _c_ = 0;
/* 111 */     _c_ = this.rank_type - _o_.rank_type;
/* 112 */     if (0 != _c_) return _c_;
/* 113 */     _c_ = this.activity_cfg_id - _o_.activity_cfg_id;
/* 114 */     if (0 != _c_) return _c_;
/* 115 */     _c_ = this.rank - _o_.rank;
/* 116 */     if (0 != _c_) return _c_;
/* 117 */     _c_ = Long.signum(this.profit - _o_.profit);
/* 118 */     if (0 != _c_) return _c_;
/* 119 */     _c_ = this.timestamp - _o_.timestamp;
/* 120 */     if (0 != _c_) return _c_;
/* 121 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\SGetRoleCrossBattleBetRankSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */