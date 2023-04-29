/*     */ package mzm.gsp.crosscompete;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class SWinLoseBrd extends __SWinLoseBrd__ {
/*     */   public static final int PROTOCOL_TYPE = 12616728;
/*     */   public static final int RESULT__GIVE_UP = 1;
/*     */   public static final int RESULT__EARLY = 2;
/*     */   public static final int RESULT__TIMEOUT = 3;
/*     */   public long winner_id;
/*     */   public String winner_name;
/*     */   public int winner_score;
/*     */   public int winner_participate_count;
/*     */   public int winner_left_count;
/*     */   public int winner_win_times;
/*     */   public long loser_id;
/*     */   public String loser_name;
/*     */   public int loser_score;
/*     */   public int loser_participate_count;
/*     */   public int loser_left_count;
/*     */   public int loser_win_times;
/*     */   public int result;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType() {
/*  27 */     return 12616728;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SWinLoseBrd()
/*     */   {
/*  49 */     this.winner_name = "";
/*  50 */     this.loser_name = "";
/*     */   }
/*     */   
/*     */   public SWinLoseBrd(long _winner_id_, String _winner_name_, int _winner_score_, int _winner_participate_count_, int _winner_left_count_, int _winner_win_times_, long _loser_id_, String _loser_name_, int _loser_score_, int _loser_participate_count_, int _loser_left_count_, int _loser_win_times_, int _result_) {
/*  54 */     this.winner_id = _winner_id_;
/*  55 */     this.winner_name = _winner_name_;
/*  56 */     this.winner_score = _winner_score_;
/*  57 */     this.winner_participate_count = _winner_participate_count_;
/*  58 */     this.winner_left_count = _winner_left_count_;
/*  59 */     this.winner_win_times = _winner_win_times_;
/*  60 */     this.loser_id = _loser_id_;
/*  61 */     this.loser_name = _loser_name_;
/*  62 */     this.loser_score = _loser_score_;
/*  63 */     this.loser_participate_count = _loser_participate_count_;
/*  64 */     this.loser_left_count = _loser_left_count_;
/*  65 */     this.loser_win_times = _loser_win_times_;
/*  66 */     this.result = _result_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  70 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  74 */     _os_.marshal(this.winner_id);
/*  75 */     _os_.marshal(this.winner_name, "UTF-16LE");
/*  76 */     _os_.marshal(this.winner_score);
/*  77 */     _os_.marshal(this.winner_participate_count);
/*  78 */     _os_.marshal(this.winner_left_count);
/*  79 */     _os_.marshal(this.winner_win_times);
/*  80 */     _os_.marshal(this.loser_id);
/*  81 */     _os_.marshal(this.loser_name, "UTF-16LE");
/*  82 */     _os_.marshal(this.loser_score);
/*  83 */     _os_.marshal(this.loser_participate_count);
/*  84 */     _os_.marshal(this.loser_left_count);
/*  85 */     _os_.marshal(this.loser_win_times);
/*  86 */     _os_.marshal(this.result);
/*  87 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  91 */     this.winner_id = _os_.unmarshal_long();
/*  92 */     this.winner_name = _os_.unmarshal_String("UTF-16LE");
/*  93 */     this.winner_score = _os_.unmarshal_int();
/*  94 */     this.winner_participate_count = _os_.unmarshal_int();
/*  95 */     this.winner_left_count = _os_.unmarshal_int();
/*  96 */     this.winner_win_times = _os_.unmarshal_int();
/*  97 */     this.loser_id = _os_.unmarshal_long();
/*  98 */     this.loser_name = _os_.unmarshal_String("UTF-16LE");
/*  99 */     this.loser_score = _os_.unmarshal_int();
/* 100 */     this.loser_participate_count = _os_.unmarshal_int();
/* 101 */     this.loser_left_count = _os_.unmarshal_int();
/* 102 */     this.loser_win_times = _os_.unmarshal_int();
/* 103 */     this.result = _os_.unmarshal_int();
/* 104 */     if (!_validator_()) {
/* 105 */       throw new VerifyError("validator failed");
/*     */     }
/* 107 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/* 111 */     if (_o1_ == this) return true;
/* 112 */     if ((_o1_ instanceof SWinLoseBrd)) {
/* 113 */       SWinLoseBrd _o_ = (SWinLoseBrd)_o1_;
/* 114 */       if (this.winner_id != _o_.winner_id) return false;
/* 115 */       if (!this.winner_name.equals(_o_.winner_name)) return false;
/* 116 */       if (this.winner_score != _o_.winner_score) return false;
/* 117 */       if (this.winner_participate_count != _o_.winner_participate_count) return false;
/* 118 */       if (this.winner_left_count != _o_.winner_left_count) return false;
/* 119 */       if (this.winner_win_times != _o_.winner_win_times) return false;
/* 120 */       if (this.loser_id != _o_.loser_id) return false;
/* 121 */       if (!this.loser_name.equals(_o_.loser_name)) return false;
/* 122 */       if (this.loser_score != _o_.loser_score) return false;
/* 123 */       if (this.loser_participate_count != _o_.loser_participate_count) return false;
/* 124 */       if (this.loser_left_count != _o_.loser_left_count) return false;
/* 125 */       if (this.loser_win_times != _o_.loser_win_times) return false;
/* 126 */       if (this.result != _o_.result) return false;
/* 127 */       return true;
/*     */     }
/* 129 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 133 */     int _h_ = 0;
/* 134 */     _h_ += (int)this.winner_id;
/* 135 */     _h_ += this.winner_name.hashCode();
/* 136 */     _h_ += this.winner_score;
/* 137 */     _h_ += this.winner_participate_count;
/* 138 */     _h_ += this.winner_left_count;
/* 139 */     _h_ += this.winner_win_times;
/* 140 */     _h_ += (int)this.loser_id;
/* 141 */     _h_ += this.loser_name.hashCode();
/* 142 */     _h_ += this.loser_score;
/* 143 */     _h_ += this.loser_participate_count;
/* 144 */     _h_ += this.loser_left_count;
/* 145 */     _h_ += this.loser_win_times;
/* 146 */     _h_ += this.result;
/* 147 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 151 */     StringBuilder _sb_ = new StringBuilder();
/* 152 */     _sb_.append("(");
/* 153 */     _sb_.append(this.winner_id).append(",");
/* 154 */     _sb_.append("T").append(this.winner_name.length()).append(",");
/* 155 */     _sb_.append(this.winner_score).append(",");
/* 156 */     _sb_.append(this.winner_participate_count).append(",");
/* 157 */     _sb_.append(this.winner_left_count).append(",");
/* 158 */     _sb_.append(this.winner_win_times).append(",");
/* 159 */     _sb_.append(this.loser_id).append(",");
/* 160 */     _sb_.append("T").append(this.loser_name.length()).append(",");
/* 161 */     _sb_.append(this.loser_score).append(",");
/* 162 */     _sb_.append(this.loser_participate_count).append(",");
/* 163 */     _sb_.append(this.loser_left_count).append(",");
/* 164 */     _sb_.append(this.loser_win_times).append(",");
/* 165 */     _sb_.append(this.result).append(",");
/* 166 */     _sb_.append(")");
/* 167 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\SWinLoseBrd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */