/*     */ package mzm.gsp.crossfield;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SSynCrossFieldSeasonInfo
/*     */   extends __SSynCrossFieldSeasonInfo__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12619537;
/*     */   public int season;
/*     */   public int star_num;
/*     */   public int win_point;
/*     */   public int straight_win_num;
/*     */   public int star_num_timestamp;
/*     */   public int current_week_point;
/*     */   public long last_get_point_time;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12619537;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSynCrossFieldSeasonInfo() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSynCrossFieldSeasonInfo(int _season_, int _star_num_, int _win_point_, int _straight_win_num_, int _star_num_timestamp_, int _current_week_point_, long _last_get_point_time_)
/*     */   {
/*  42 */     this.season = _season_;
/*  43 */     this.star_num = _star_num_;
/*  44 */     this.win_point = _win_point_;
/*  45 */     this.straight_win_num = _straight_win_num_;
/*  46 */     this.star_num_timestamp = _star_num_timestamp_;
/*  47 */     this.current_week_point = _current_week_point_;
/*  48 */     this.last_get_point_time = _last_get_point_time_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  52 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  56 */     _os_.marshal(this.season);
/*  57 */     _os_.marshal(this.star_num);
/*  58 */     _os_.marshal(this.win_point);
/*  59 */     _os_.marshal(this.straight_win_num);
/*  60 */     _os_.marshal(this.star_num_timestamp);
/*  61 */     _os_.marshal(this.current_week_point);
/*  62 */     _os_.marshal(this.last_get_point_time);
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  67 */     this.season = _os_.unmarshal_int();
/*  68 */     this.star_num = _os_.unmarshal_int();
/*  69 */     this.win_point = _os_.unmarshal_int();
/*  70 */     this.straight_win_num = _os_.unmarshal_int();
/*  71 */     this.star_num_timestamp = _os_.unmarshal_int();
/*  72 */     this.current_week_point = _os_.unmarshal_int();
/*  73 */     this.last_get_point_time = _os_.unmarshal_long();
/*  74 */     if (!_validator_()) {
/*  75 */       throw new VerifyError("validator failed");
/*     */     }
/*  77 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  81 */     if (_o1_ == this) return true;
/*  82 */     if ((_o1_ instanceof SSynCrossFieldSeasonInfo)) {
/*  83 */       SSynCrossFieldSeasonInfo _o_ = (SSynCrossFieldSeasonInfo)_o1_;
/*  84 */       if (this.season != _o_.season) return false;
/*  85 */       if (this.star_num != _o_.star_num) return false;
/*  86 */       if (this.win_point != _o_.win_point) return false;
/*  87 */       if (this.straight_win_num != _o_.straight_win_num) return false;
/*  88 */       if (this.star_num_timestamp != _o_.star_num_timestamp) return false;
/*  89 */       if (this.current_week_point != _o_.current_week_point) return false;
/*  90 */       if (this.last_get_point_time != _o_.last_get_point_time) return false;
/*  91 */       return true;
/*     */     }
/*  93 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  97 */     int _h_ = 0;
/*  98 */     _h_ += this.season;
/*  99 */     _h_ += this.star_num;
/* 100 */     _h_ += this.win_point;
/* 101 */     _h_ += this.straight_win_num;
/* 102 */     _h_ += this.star_num_timestamp;
/* 103 */     _h_ += this.current_week_point;
/* 104 */     _h_ += (int)this.last_get_point_time;
/* 105 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 109 */     StringBuilder _sb_ = new StringBuilder();
/* 110 */     _sb_.append("(");
/* 111 */     _sb_.append(this.season).append(",");
/* 112 */     _sb_.append(this.star_num).append(",");
/* 113 */     _sb_.append(this.win_point).append(",");
/* 114 */     _sb_.append(this.straight_win_num).append(",");
/* 115 */     _sb_.append(this.star_num_timestamp).append(",");
/* 116 */     _sb_.append(this.current_week_point).append(",");
/* 117 */     _sb_.append(this.last_get_point_time).append(",");
/* 118 */     _sb_.append(")");
/* 119 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SSynCrossFieldSeasonInfo _o_) {
/* 123 */     if (_o_ == this) return 0;
/* 124 */     int _c_ = 0;
/* 125 */     _c_ = this.season - _o_.season;
/* 126 */     if (0 != _c_) return _c_;
/* 127 */     _c_ = this.star_num - _o_.star_num;
/* 128 */     if (0 != _c_) return _c_;
/* 129 */     _c_ = this.win_point - _o_.win_point;
/* 130 */     if (0 != _c_) return _c_;
/* 131 */     _c_ = this.straight_win_num - _o_.straight_win_num;
/* 132 */     if (0 != _c_) return _c_;
/* 133 */     _c_ = this.star_num_timestamp - _o_.star_num_timestamp;
/* 134 */     if (0 != _c_) return _c_;
/* 135 */     _c_ = this.current_week_point - _o_.current_week_point;
/* 136 */     if (0 != _c_) return _c_;
/* 137 */     _c_ = Long.signum(this.last_get_point_time - _o_.last_get_point_time);
/* 138 */     if (0 != _c_) return _c_;
/* 139 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossfield\SSynCrossFieldSeasonInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */