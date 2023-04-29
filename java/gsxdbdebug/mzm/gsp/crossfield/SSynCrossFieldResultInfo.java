/*     */ package mzm.gsp.crossfield;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class SSynCrossFieldResultInfo extends __SSynCrossFieldResultInfo__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12619527;
/*     */   public int season;
/*     */   public byte is_active_leave;
/*     */   public byte result;
/*     */   public byte is_mvp;
/*     */   public long original_point;
/*     */   public long current_point;
/*     */   public int current_week_point;
/*     */   public long last_get_point_time;
/*     */   public int original_star_num;
/*     */   public int current_star_num;
/*     */   public int original_win_point;
/*     */   public int current_win_point;
/*     */   public int original_straight_win_num;
/*     */   public int current_straight_win_num;
/*     */   public int star_num_timestamp;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType() {
/*  27 */     return 12619527;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSynCrossFieldResultInfo() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSynCrossFieldResultInfo(int _season_, byte _is_active_leave_, byte _result_, byte _is_mvp_, long _original_point_, long _current_point_, int _current_week_point_, long _last_get_point_time_, int _original_star_num_, int _current_star_num_, int _original_win_point_, int _current_win_point_, int _original_straight_win_num_, int _current_straight_win_num_, int _star_num_timestamp_)
/*     */   {
/*  50 */     this.season = _season_;
/*  51 */     this.is_active_leave = _is_active_leave_;
/*  52 */     this.result = _result_;
/*  53 */     this.is_mvp = _is_mvp_;
/*  54 */     this.original_point = _original_point_;
/*  55 */     this.current_point = _current_point_;
/*  56 */     this.current_week_point = _current_week_point_;
/*  57 */     this.last_get_point_time = _last_get_point_time_;
/*  58 */     this.original_star_num = _original_star_num_;
/*  59 */     this.current_star_num = _current_star_num_;
/*  60 */     this.original_win_point = _original_win_point_;
/*  61 */     this.current_win_point = _current_win_point_;
/*  62 */     this.original_straight_win_num = _original_straight_win_num_;
/*  63 */     this.current_straight_win_num = _current_straight_win_num_;
/*  64 */     this.star_num_timestamp = _star_num_timestamp_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  68 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  72 */     _os_.marshal(this.season);
/*  73 */     _os_.marshal(this.is_active_leave);
/*  74 */     _os_.marshal(this.result);
/*  75 */     _os_.marshal(this.is_mvp);
/*  76 */     _os_.marshal(this.original_point);
/*  77 */     _os_.marshal(this.current_point);
/*  78 */     _os_.marshal(this.current_week_point);
/*  79 */     _os_.marshal(this.last_get_point_time);
/*  80 */     _os_.marshal(this.original_star_num);
/*  81 */     _os_.marshal(this.current_star_num);
/*  82 */     _os_.marshal(this.original_win_point);
/*  83 */     _os_.marshal(this.current_win_point);
/*  84 */     _os_.marshal(this.original_straight_win_num);
/*  85 */     _os_.marshal(this.current_straight_win_num);
/*  86 */     _os_.marshal(this.star_num_timestamp);
/*  87 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  91 */     this.season = _os_.unmarshal_int();
/*  92 */     this.is_active_leave = _os_.unmarshal_byte();
/*  93 */     this.result = _os_.unmarshal_byte();
/*  94 */     this.is_mvp = _os_.unmarshal_byte();
/*  95 */     this.original_point = _os_.unmarshal_long();
/*  96 */     this.current_point = _os_.unmarshal_long();
/*  97 */     this.current_week_point = _os_.unmarshal_int();
/*  98 */     this.last_get_point_time = _os_.unmarshal_long();
/*  99 */     this.original_star_num = _os_.unmarshal_int();
/* 100 */     this.current_star_num = _os_.unmarshal_int();
/* 101 */     this.original_win_point = _os_.unmarshal_int();
/* 102 */     this.current_win_point = _os_.unmarshal_int();
/* 103 */     this.original_straight_win_num = _os_.unmarshal_int();
/* 104 */     this.current_straight_win_num = _os_.unmarshal_int();
/* 105 */     this.star_num_timestamp = _os_.unmarshal_int();
/* 106 */     if (!_validator_()) {
/* 107 */       throw new VerifyError("validator failed");
/*     */     }
/* 109 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/* 113 */     if (_o1_ == this) return true;
/* 114 */     if ((_o1_ instanceof SSynCrossFieldResultInfo)) {
/* 115 */       SSynCrossFieldResultInfo _o_ = (SSynCrossFieldResultInfo)_o1_;
/* 116 */       if (this.season != _o_.season) return false;
/* 117 */       if (this.is_active_leave != _o_.is_active_leave) return false;
/* 118 */       if (this.result != _o_.result) return false;
/* 119 */       if (this.is_mvp != _o_.is_mvp) return false;
/* 120 */       if (this.original_point != _o_.original_point) return false;
/* 121 */       if (this.current_point != _o_.current_point) return false;
/* 122 */       if (this.current_week_point != _o_.current_week_point) return false;
/* 123 */       if (this.last_get_point_time != _o_.last_get_point_time) return false;
/* 124 */       if (this.original_star_num != _o_.original_star_num) return false;
/* 125 */       if (this.current_star_num != _o_.current_star_num) return false;
/* 126 */       if (this.original_win_point != _o_.original_win_point) return false;
/* 127 */       if (this.current_win_point != _o_.current_win_point) return false;
/* 128 */       if (this.original_straight_win_num != _o_.original_straight_win_num) return false;
/* 129 */       if (this.current_straight_win_num != _o_.current_straight_win_num) return false;
/* 130 */       if (this.star_num_timestamp != _o_.star_num_timestamp) return false;
/* 131 */       return true;
/*     */     }
/* 133 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 137 */     int _h_ = 0;
/* 138 */     _h_ += this.season;
/* 139 */     _h_ += this.is_active_leave;
/* 140 */     _h_ += this.result;
/* 141 */     _h_ += this.is_mvp;
/* 142 */     _h_ += (int)this.original_point;
/* 143 */     _h_ += (int)this.current_point;
/* 144 */     _h_ += this.current_week_point;
/* 145 */     _h_ += (int)this.last_get_point_time;
/* 146 */     _h_ += this.original_star_num;
/* 147 */     _h_ += this.current_star_num;
/* 148 */     _h_ += this.original_win_point;
/* 149 */     _h_ += this.current_win_point;
/* 150 */     _h_ += this.original_straight_win_num;
/* 151 */     _h_ += this.current_straight_win_num;
/* 152 */     _h_ += this.star_num_timestamp;
/* 153 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 157 */     StringBuilder _sb_ = new StringBuilder();
/* 158 */     _sb_.append("(");
/* 159 */     _sb_.append(this.season).append(",");
/* 160 */     _sb_.append(this.is_active_leave).append(",");
/* 161 */     _sb_.append(this.result).append(",");
/* 162 */     _sb_.append(this.is_mvp).append(",");
/* 163 */     _sb_.append(this.original_point).append(",");
/* 164 */     _sb_.append(this.current_point).append(",");
/* 165 */     _sb_.append(this.current_week_point).append(",");
/* 166 */     _sb_.append(this.last_get_point_time).append(",");
/* 167 */     _sb_.append(this.original_star_num).append(",");
/* 168 */     _sb_.append(this.current_star_num).append(",");
/* 169 */     _sb_.append(this.original_win_point).append(",");
/* 170 */     _sb_.append(this.current_win_point).append(",");
/* 171 */     _sb_.append(this.original_straight_win_num).append(",");
/* 172 */     _sb_.append(this.current_straight_win_num).append(",");
/* 173 */     _sb_.append(this.star_num_timestamp).append(",");
/* 174 */     _sb_.append(")");
/* 175 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SSynCrossFieldResultInfo _o_) {
/* 179 */     if (_o_ == this) return 0;
/* 180 */     int _c_ = 0;
/* 181 */     _c_ = this.season - _o_.season;
/* 182 */     if (0 != _c_) return _c_;
/* 183 */     _c_ = this.is_active_leave - _o_.is_active_leave;
/* 184 */     if (0 != _c_) return _c_;
/* 185 */     _c_ = this.result - _o_.result;
/* 186 */     if (0 != _c_) return _c_;
/* 187 */     _c_ = this.is_mvp - _o_.is_mvp;
/* 188 */     if (0 != _c_) return _c_;
/* 189 */     _c_ = Long.signum(this.original_point - _o_.original_point);
/* 190 */     if (0 != _c_) return _c_;
/* 191 */     _c_ = Long.signum(this.current_point - _o_.current_point);
/* 192 */     if (0 != _c_) return _c_;
/* 193 */     _c_ = this.current_week_point - _o_.current_week_point;
/* 194 */     if (0 != _c_) return _c_;
/* 195 */     _c_ = Long.signum(this.last_get_point_time - _o_.last_get_point_time);
/* 196 */     if (0 != _c_) return _c_;
/* 197 */     _c_ = this.original_star_num - _o_.original_star_num;
/* 198 */     if (0 != _c_) return _c_;
/* 199 */     _c_ = this.current_star_num - _o_.current_star_num;
/* 200 */     if (0 != _c_) return _c_;
/* 201 */     _c_ = this.original_win_point - _o_.original_win_point;
/* 202 */     if (0 != _c_) return _c_;
/* 203 */     _c_ = this.current_win_point - _o_.current_win_point;
/* 204 */     if (0 != _c_) return _c_;
/* 205 */     _c_ = this.original_straight_win_num - _o_.original_straight_win_num;
/* 206 */     if (0 != _c_) return _c_;
/* 207 */     _c_ = this.current_straight_win_num - _o_.current_straight_win_num;
/* 208 */     if (0 != _c_) return _c_;
/* 209 */     _c_ = this.star_num_timestamp - _o_.star_num_timestamp;
/* 210 */     if (0 != _c_) return _c_;
/* 211 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossfield\SSynCrossFieldResultInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */