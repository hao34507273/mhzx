/*     */ package mzm.gsp.backgame;
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
/*     */ public class SSyncBackGameInfo
/*     */   extends __SSyncBackGameInfo__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12604421;
/*     */   public int current_score_value;
/*     */   public int current_award_score_index_id;
/*     */   public int award_day;
/*     */   public int award_back_game_level;
/*     */   public long left_time;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12604421;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSyncBackGameInfo() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSyncBackGameInfo(int _current_score_value_, int _current_award_score_index_id_, int _award_day_, int _award_back_game_level_, long _left_time_)
/*     */   {
/*  40 */     this.current_score_value = _current_score_value_;
/*  41 */     this.current_award_score_index_id = _current_award_score_index_id_;
/*  42 */     this.award_day = _award_day_;
/*  43 */     this.award_back_game_level = _award_back_game_level_;
/*  44 */     this.left_time = _left_time_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.current_score_value);
/*  53 */     _os_.marshal(this.current_award_score_index_id);
/*  54 */     _os_.marshal(this.award_day);
/*  55 */     _os_.marshal(this.award_back_game_level);
/*  56 */     _os_.marshal(this.left_time);
/*  57 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  61 */     this.current_score_value = _os_.unmarshal_int();
/*  62 */     this.current_award_score_index_id = _os_.unmarshal_int();
/*  63 */     this.award_day = _os_.unmarshal_int();
/*  64 */     this.award_back_game_level = _os_.unmarshal_int();
/*  65 */     this.left_time = _os_.unmarshal_long();
/*  66 */     if (!_validator_()) {
/*  67 */       throw new VerifyError("validator failed");
/*     */     }
/*  69 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  73 */     if (_o1_ == this) return true;
/*  74 */     if ((_o1_ instanceof SSyncBackGameInfo)) {
/*  75 */       SSyncBackGameInfo _o_ = (SSyncBackGameInfo)_o1_;
/*  76 */       if (this.current_score_value != _o_.current_score_value) return false;
/*  77 */       if (this.current_award_score_index_id != _o_.current_award_score_index_id) return false;
/*  78 */       if (this.award_day != _o_.award_day) return false;
/*  79 */       if (this.award_back_game_level != _o_.award_back_game_level) return false;
/*  80 */       if (this.left_time != _o_.left_time) return false;
/*  81 */       return true;
/*     */     }
/*  83 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  87 */     int _h_ = 0;
/*  88 */     _h_ += this.current_score_value;
/*  89 */     _h_ += this.current_award_score_index_id;
/*  90 */     _h_ += this.award_day;
/*  91 */     _h_ += this.award_back_game_level;
/*  92 */     _h_ += (int)this.left_time;
/*  93 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  97 */     StringBuilder _sb_ = new StringBuilder();
/*  98 */     _sb_.append("(");
/*  99 */     _sb_.append(this.current_score_value).append(",");
/* 100 */     _sb_.append(this.current_award_score_index_id).append(",");
/* 101 */     _sb_.append(this.award_day).append(",");
/* 102 */     _sb_.append(this.award_back_game_level).append(",");
/* 103 */     _sb_.append(this.left_time).append(",");
/* 104 */     _sb_.append(")");
/* 105 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SSyncBackGameInfo _o_) {
/* 109 */     if (_o_ == this) return 0;
/* 110 */     int _c_ = 0;
/* 111 */     _c_ = this.current_score_value - _o_.current_score_value;
/* 112 */     if (0 != _c_) return _c_;
/* 113 */     _c_ = this.current_award_score_index_id - _o_.current_award_score_index_id;
/* 114 */     if (0 != _c_) return _c_;
/* 115 */     _c_ = this.award_day - _o_.award_day;
/* 116 */     if (0 != _c_) return _c_;
/* 117 */     _c_ = this.award_back_game_level - _o_.award_back_game_level;
/* 118 */     if (0 != _c_) return _c_;
/* 119 */     _c_ = Long.signum(this.left_time - _o_.left_time);
/* 120 */     if (0 != _c_) return _c_;
/* 121 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\backgame\SSyncBackGameInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */