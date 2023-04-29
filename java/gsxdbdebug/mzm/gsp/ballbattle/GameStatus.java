/*     */ package mzm.gsp.ballbattle;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map.Entry;
/*     */ 
/*     */ public class GameStatus implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*     */   public int start_time;
/*     */   public int stop_time;
/*     */   public int circle_reduce_count;
/*     */   public int next_circle_reduce_time;
/*     */   public HashMap<Long, Octets> player_names;
/*     */   public HashMap<Long, PlayerScoreInfo> player_score_infos;
/*     */   
/*     */   public GameStatus()
/*     */   {
/*  19 */     this.player_names = new HashMap();
/*  20 */     this.player_score_infos = new HashMap();
/*     */   }
/*     */   
/*     */   public GameStatus(int _start_time_, int _stop_time_, int _circle_reduce_count_, int _next_circle_reduce_time_, HashMap<Long, Octets> _player_names_, HashMap<Long, PlayerScoreInfo> _player_score_infos_) {
/*  24 */     this.start_time = _start_time_;
/*  25 */     this.stop_time = _stop_time_;
/*  26 */     this.circle_reduce_count = _circle_reduce_count_;
/*  27 */     this.next_circle_reduce_time = _next_circle_reduce_time_;
/*  28 */     this.player_names = _player_names_;
/*  29 */     this.player_score_infos = _player_score_infos_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  33 */     for (Map.Entry<Long, PlayerScoreInfo> _e_ : this.player_score_infos.entrySet()) {
/*  34 */       if (!((PlayerScoreInfo)_e_.getValue())._validator_()) return false;
/*     */     }
/*  36 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  40 */     _os_.marshal(this.start_time);
/*  41 */     _os_.marshal(this.stop_time);
/*  42 */     _os_.marshal(this.circle_reduce_count);
/*  43 */     _os_.marshal(this.next_circle_reduce_time);
/*  44 */     _os_.compact_uint32(this.player_names.size());
/*  45 */     for (Map.Entry<Long, Octets> _e_ : this.player_names.entrySet()) {
/*  46 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  47 */       _os_.marshal((Octets)_e_.getValue());
/*     */     }
/*  49 */     _os_.compact_uint32(this.player_score_infos.size());
/*  50 */     for (Map.Entry<Long, PlayerScoreInfo> _e_ : this.player_score_infos.entrySet()) {
/*  51 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  52 */       _os_.marshal((com.goldhuman.Common.Marshal.Marshal)_e_.getValue());
/*     */     }
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  58 */     this.start_time = _os_.unmarshal_int();
/*  59 */     this.stop_time = _os_.unmarshal_int();
/*  60 */     this.circle_reduce_count = _os_.unmarshal_int();
/*  61 */     this.next_circle_reduce_time = _os_.unmarshal_int();
/*  62 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  64 */       long _k_ = _os_.unmarshal_long();
/*     */       
/*  66 */       Octets _v_ = _os_.unmarshal_Octets();
/*  67 */       this.player_names.put(Long.valueOf(_k_), _v_);
/*     */     }
/*  69 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  71 */       long _k_ = _os_.unmarshal_long();
/*  72 */       PlayerScoreInfo _v_ = new PlayerScoreInfo();
/*  73 */       _v_.unmarshal(_os_);
/*  74 */       this.player_score_infos.put(Long.valueOf(_k_), _v_);
/*     */     }
/*  76 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  80 */     if (_o1_ == this) return true;
/*  81 */     if ((_o1_ instanceof GameStatus)) {
/*  82 */       GameStatus _o_ = (GameStatus)_o1_;
/*  83 */       if (this.start_time != _o_.start_time) return false;
/*  84 */       if (this.stop_time != _o_.stop_time) return false;
/*  85 */       if (this.circle_reduce_count != _o_.circle_reduce_count) return false;
/*  86 */       if (this.next_circle_reduce_time != _o_.next_circle_reduce_time) return false;
/*  87 */       if (!this.player_names.equals(_o_.player_names)) return false;
/*  88 */       if (!this.player_score_infos.equals(_o_.player_score_infos)) return false;
/*  89 */       return true;
/*     */     }
/*  91 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  95 */     int _h_ = 0;
/*  96 */     _h_ += this.start_time;
/*  97 */     _h_ += this.stop_time;
/*  98 */     _h_ += this.circle_reduce_count;
/*  99 */     _h_ += this.next_circle_reduce_time;
/* 100 */     _h_ += this.player_names.hashCode();
/* 101 */     _h_ += this.player_score_infos.hashCode();
/* 102 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 106 */     StringBuilder _sb_ = new StringBuilder();
/* 107 */     _sb_.append("(");
/* 108 */     _sb_.append(this.start_time).append(",");
/* 109 */     _sb_.append(this.stop_time).append(",");
/* 110 */     _sb_.append(this.circle_reduce_count).append(",");
/* 111 */     _sb_.append(this.next_circle_reduce_time).append(",");
/* 112 */     _sb_.append(this.player_names).append(",");
/* 113 */     _sb_.append(this.player_score_infos).append(",");
/* 114 */     _sb_.append(")");
/* 115 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ballbattle\GameStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */