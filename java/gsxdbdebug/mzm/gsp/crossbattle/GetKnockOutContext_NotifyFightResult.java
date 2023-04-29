/*     */ package mzm.gsp.crossbattle;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ public class GetKnockOutContext_NotifyFightResult
/*     */   implements Marshal, Comparable<GetKnockOutContext_NotifyFightResult>
/*     */ {
/*     */   public long role_id;
/*     */   public long corps_id;
/*     */   public long opponent_corps_id;
/*     */   public int knock_out_type;
/*     */   public int fight_stage;
/*     */   public int fight_index_id;
/*     */   public int win_or_lose;
/*     */   public int repeat_times;
/*     */   
/*     */   public GetKnockOutContext_NotifyFightResult() {}
/*     */   
/*     */   public GetKnockOutContext_NotifyFightResult(long _role_id_, long _corps_id_, long _opponent_corps_id_, int _knock_out_type_, int _fight_stage_, int _fight_index_id_, int _win_or_lose_, int _repeat_times_)
/*     */   {
/*  24 */     this.role_id = _role_id_;
/*  25 */     this.corps_id = _corps_id_;
/*  26 */     this.opponent_corps_id = _opponent_corps_id_;
/*  27 */     this.knock_out_type = _knock_out_type_;
/*  28 */     this.fight_stage = _fight_stage_;
/*  29 */     this.fight_index_id = _fight_index_id_;
/*  30 */     this.win_or_lose = _win_or_lose_;
/*  31 */     this.repeat_times = _repeat_times_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  35 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  39 */     _os_.marshal(this.role_id);
/*  40 */     _os_.marshal(this.corps_id);
/*  41 */     _os_.marshal(this.opponent_corps_id);
/*  42 */     _os_.marshal(this.knock_out_type);
/*  43 */     _os_.marshal(this.fight_stage);
/*  44 */     _os_.marshal(this.fight_index_id);
/*  45 */     _os_.marshal(this.win_or_lose);
/*  46 */     _os_.marshal(this.repeat_times);
/*  47 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  51 */     this.role_id = _os_.unmarshal_long();
/*  52 */     this.corps_id = _os_.unmarshal_long();
/*  53 */     this.opponent_corps_id = _os_.unmarshal_long();
/*  54 */     this.knock_out_type = _os_.unmarshal_int();
/*  55 */     this.fight_stage = _os_.unmarshal_int();
/*  56 */     this.fight_index_id = _os_.unmarshal_int();
/*  57 */     this.win_or_lose = _os_.unmarshal_int();
/*  58 */     this.repeat_times = _os_.unmarshal_int();
/*  59 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  63 */     if (_o1_ == this) return true;
/*  64 */     if ((_o1_ instanceof GetKnockOutContext_NotifyFightResult)) {
/*  65 */       GetKnockOutContext_NotifyFightResult _o_ = (GetKnockOutContext_NotifyFightResult)_o1_;
/*  66 */       if (this.role_id != _o_.role_id) return false;
/*  67 */       if (this.corps_id != _o_.corps_id) return false;
/*  68 */       if (this.opponent_corps_id != _o_.opponent_corps_id) return false;
/*  69 */       if (this.knock_out_type != _o_.knock_out_type) return false;
/*  70 */       if (this.fight_stage != _o_.fight_stage) return false;
/*  71 */       if (this.fight_index_id != _o_.fight_index_id) return false;
/*  72 */       if (this.win_or_lose != _o_.win_or_lose) return false;
/*  73 */       if (this.repeat_times != _o_.repeat_times) return false;
/*  74 */       return true;
/*     */     }
/*  76 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  80 */     int _h_ = 0;
/*  81 */     _h_ += (int)this.role_id;
/*  82 */     _h_ += (int)this.corps_id;
/*  83 */     _h_ += (int)this.opponent_corps_id;
/*  84 */     _h_ += this.knock_out_type;
/*  85 */     _h_ += this.fight_stage;
/*  86 */     _h_ += this.fight_index_id;
/*  87 */     _h_ += this.win_or_lose;
/*  88 */     _h_ += this.repeat_times;
/*  89 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  93 */     StringBuilder _sb_ = new StringBuilder();
/*  94 */     _sb_.append("(");
/*  95 */     _sb_.append(this.role_id).append(",");
/*  96 */     _sb_.append(this.corps_id).append(",");
/*  97 */     _sb_.append(this.opponent_corps_id).append(",");
/*  98 */     _sb_.append(this.knock_out_type).append(",");
/*  99 */     _sb_.append(this.fight_stage).append(",");
/* 100 */     _sb_.append(this.fight_index_id).append(",");
/* 101 */     _sb_.append(this.win_or_lose).append(",");
/* 102 */     _sb_.append(this.repeat_times).append(",");
/* 103 */     _sb_.append(")");
/* 104 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(GetKnockOutContext_NotifyFightResult _o_) {
/* 108 */     if (_o_ == this) return 0;
/* 109 */     int _c_ = 0;
/* 110 */     _c_ = Long.signum(this.role_id - _o_.role_id);
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     _c_ = Long.signum(this.corps_id - _o_.corps_id);
/* 113 */     if (0 != _c_) return _c_;
/* 114 */     _c_ = Long.signum(this.opponent_corps_id - _o_.opponent_corps_id);
/* 115 */     if (0 != _c_) return _c_;
/* 116 */     _c_ = this.knock_out_type - _o_.knock_out_type;
/* 117 */     if (0 != _c_) return _c_;
/* 118 */     _c_ = this.fight_stage - _o_.fight_stage;
/* 119 */     if (0 != _c_) return _c_;
/* 120 */     _c_ = this.fight_index_id - _o_.fight_index_id;
/* 121 */     if (0 != _c_) return _c_;
/* 122 */     _c_ = this.win_or_lose - _o_.win_or_lose;
/* 123 */     if (0 != _c_) return _c_;
/* 124 */     _c_ = this.repeat_times - _o_.repeat_times;
/* 125 */     if (0 != _c_) return _c_;
/* 126 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\GetKnockOutContext_NotifyFightResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */