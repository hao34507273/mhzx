/*     */ package mzm.gsp.crossbattle;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class PointRaceData implements Marshal, Comparable<PointRaceData>
/*     */ {
/*     */   public int cur_win;
/*     */   public int cur_lose;
/*     */   public int cur_point;
/*     */   public int cur_rank;
/*     */   public int wins;
/*     */   public int loses;
/*     */   public int points;
/*     */   public int rank;
/*     */   public int victories;
/*     */   
/*     */   public PointRaceData() {}
/*     */   
/*     */   public PointRaceData(int _cur_win_, int _cur_lose_, int _cur_point_, int _cur_rank_, int _wins_, int _loses_, int _points_, int _rank_, int _victories_)
/*     */   {
/*  23 */     this.cur_win = _cur_win_;
/*  24 */     this.cur_lose = _cur_lose_;
/*  25 */     this.cur_point = _cur_point_;
/*  26 */     this.cur_rank = _cur_rank_;
/*  27 */     this.wins = _wins_;
/*  28 */     this.loses = _loses_;
/*  29 */     this.points = _points_;
/*  30 */     this.rank = _rank_;
/*  31 */     this.victories = _victories_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  35 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  39 */     _os_.marshal(this.cur_win);
/*  40 */     _os_.marshal(this.cur_lose);
/*  41 */     _os_.marshal(this.cur_point);
/*  42 */     _os_.marshal(this.cur_rank);
/*  43 */     _os_.marshal(this.wins);
/*  44 */     _os_.marshal(this.loses);
/*  45 */     _os_.marshal(this.points);
/*  46 */     _os_.marshal(this.rank);
/*  47 */     _os_.marshal(this.victories);
/*  48 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  52 */     this.cur_win = _os_.unmarshal_int();
/*  53 */     this.cur_lose = _os_.unmarshal_int();
/*  54 */     this.cur_point = _os_.unmarshal_int();
/*  55 */     this.cur_rank = _os_.unmarshal_int();
/*  56 */     this.wins = _os_.unmarshal_int();
/*  57 */     this.loses = _os_.unmarshal_int();
/*  58 */     this.points = _os_.unmarshal_int();
/*  59 */     this.rank = _os_.unmarshal_int();
/*  60 */     this.victories = _os_.unmarshal_int();
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  65 */     if (_o1_ == this) return true;
/*  66 */     if ((_o1_ instanceof PointRaceData)) {
/*  67 */       PointRaceData _o_ = (PointRaceData)_o1_;
/*  68 */       if (this.cur_win != _o_.cur_win) return false;
/*  69 */       if (this.cur_lose != _o_.cur_lose) return false;
/*  70 */       if (this.cur_point != _o_.cur_point) return false;
/*  71 */       if (this.cur_rank != _o_.cur_rank) return false;
/*  72 */       if (this.wins != _o_.wins) return false;
/*  73 */       if (this.loses != _o_.loses) return false;
/*  74 */       if (this.points != _o_.points) return false;
/*  75 */       if (this.rank != _o_.rank) return false;
/*  76 */       if (this.victories != _o_.victories) return false;
/*  77 */       return true;
/*     */     }
/*  79 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  83 */     int _h_ = 0;
/*  84 */     _h_ += this.cur_win;
/*  85 */     _h_ += this.cur_lose;
/*  86 */     _h_ += this.cur_point;
/*  87 */     _h_ += this.cur_rank;
/*  88 */     _h_ += this.wins;
/*  89 */     _h_ += this.loses;
/*  90 */     _h_ += this.points;
/*  91 */     _h_ += this.rank;
/*  92 */     _h_ += this.victories;
/*  93 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  97 */     StringBuilder _sb_ = new StringBuilder();
/*  98 */     _sb_.append("(");
/*  99 */     _sb_.append(this.cur_win).append(",");
/* 100 */     _sb_.append(this.cur_lose).append(",");
/* 101 */     _sb_.append(this.cur_point).append(",");
/* 102 */     _sb_.append(this.cur_rank).append(",");
/* 103 */     _sb_.append(this.wins).append(",");
/* 104 */     _sb_.append(this.loses).append(",");
/* 105 */     _sb_.append(this.points).append(",");
/* 106 */     _sb_.append(this.rank).append(",");
/* 107 */     _sb_.append(this.victories).append(",");
/* 108 */     _sb_.append(")");
/* 109 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(PointRaceData _o_) {
/* 113 */     if (_o_ == this) return 0;
/* 114 */     int _c_ = 0;
/* 115 */     _c_ = this.cur_win - _o_.cur_win;
/* 116 */     if (0 != _c_) return _c_;
/* 117 */     _c_ = this.cur_lose - _o_.cur_lose;
/* 118 */     if (0 != _c_) return _c_;
/* 119 */     _c_ = this.cur_point - _o_.cur_point;
/* 120 */     if (0 != _c_) return _c_;
/* 121 */     _c_ = this.cur_rank - _o_.cur_rank;
/* 122 */     if (0 != _c_) return _c_;
/* 123 */     _c_ = this.wins - _o_.wins;
/* 124 */     if (0 != _c_) return _c_;
/* 125 */     _c_ = this.loses - _o_.loses;
/* 126 */     if (0 != _c_) return _c_;
/* 127 */     _c_ = this.points - _o_.points;
/* 128 */     if (0 != _c_) return _c_;
/* 129 */     _c_ = this.rank - _o_.rank;
/* 130 */     if (0 != _c_) return _c_;
/* 131 */     _c_ = this.victories - _o_.victories;
/* 132 */     if (0 != _c_) return _c_;
/* 133 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\PointRaceData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */