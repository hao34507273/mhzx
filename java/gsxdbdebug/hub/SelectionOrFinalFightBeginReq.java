/*     */ package hub;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class SelectionOrFinalFightBeginReq
/*     */   implements Marshal, Comparable<SelectionOrFinalFightBeginReq>
/*     */ {
/*     */   public long matcher_server_contextid;
/*     */   public long game_server_contextid;
/*     */   public long corps_id;
/*     */   public int fight_type;
/*     */   public int fight_stage;
/*     */   public int fight_index_id;
/*     */   public long fight_record_id;
/*     */   
/*     */   public SelectionOrFinalFightBeginReq()
/*     */   {
/*  20 */     this.matcher_server_contextid = 0L;
/*  21 */     this.game_server_contextid = 0L;
/*     */   }
/*     */   
/*     */   public SelectionOrFinalFightBeginReq(long _matcher_server_contextid_, long _game_server_contextid_, long _corps_id_, int _fight_type_, int _fight_stage_, int _fight_index_id_, long _fight_record_id_) {
/*  25 */     this.matcher_server_contextid = _matcher_server_contextid_;
/*  26 */     this.game_server_contextid = _game_server_contextid_;
/*  27 */     this.corps_id = _corps_id_;
/*  28 */     this.fight_type = _fight_type_;
/*  29 */     this.fight_stage = _fight_stage_;
/*  30 */     this.fight_index_id = _fight_index_id_;
/*  31 */     this.fight_record_id = _fight_record_id_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  35 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  39 */     _os_.marshal(this.matcher_server_contextid);
/*  40 */     _os_.marshal(this.game_server_contextid);
/*  41 */     _os_.marshal(this.corps_id);
/*  42 */     _os_.marshal(this.fight_type);
/*  43 */     _os_.marshal(this.fight_stage);
/*  44 */     _os_.marshal(this.fight_index_id);
/*  45 */     _os_.marshal(this.fight_record_id);
/*  46 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  50 */     this.matcher_server_contextid = _os_.unmarshal_long();
/*  51 */     this.game_server_contextid = _os_.unmarshal_long();
/*  52 */     this.corps_id = _os_.unmarshal_long();
/*  53 */     this.fight_type = _os_.unmarshal_int();
/*  54 */     this.fight_stage = _os_.unmarshal_int();
/*  55 */     this.fight_index_id = _os_.unmarshal_int();
/*  56 */     this.fight_record_id = _os_.unmarshal_long();
/*  57 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  61 */     if (_o1_ == this) return true;
/*  62 */     if ((_o1_ instanceof SelectionOrFinalFightBeginReq)) {
/*  63 */       SelectionOrFinalFightBeginReq _o_ = (SelectionOrFinalFightBeginReq)_o1_;
/*  64 */       if (this.matcher_server_contextid != _o_.matcher_server_contextid) return false;
/*  65 */       if (this.game_server_contextid != _o_.game_server_contextid) return false;
/*  66 */       if (this.corps_id != _o_.corps_id) return false;
/*  67 */       if (this.fight_type != _o_.fight_type) return false;
/*  68 */       if (this.fight_stage != _o_.fight_stage) return false;
/*  69 */       if (this.fight_index_id != _o_.fight_index_id) return false;
/*  70 */       if (this.fight_record_id != _o_.fight_record_id) return false;
/*  71 */       return true;
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  77 */     int _h_ = 0;
/*  78 */     _h_ += (int)this.matcher_server_contextid;
/*  79 */     _h_ += (int)this.game_server_contextid;
/*  80 */     _h_ += (int)this.corps_id;
/*  81 */     _h_ += this.fight_type;
/*  82 */     _h_ += this.fight_stage;
/*  83 */     _h_ += this.fight_index_id;
/*  84 */     _h_ += (int)this.fight_record_id;
/*  85 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  89 */     StringBuilder _sb_ = new StringBuilder();
/*  90 */     _sb_.append("(");
/*  91 */     _sb_.append(this.matcher_server_contextid).append(",");
/*  92 */     _sb_.append(this.game_server_contextid).append(",");
/*  93 */     _sb_.append(this.corps_id).append(",");
/*  94 */     _sb_.append(this.fight_type).append(",");
/*  95 */     _sb_.append(this.fight_stage).append(",");
/*  96 */     _sb_.append(this.fight_index_id).append(",");
/*  97 */     _sb_.append(this.fight_record_id).append(",");
/*  98 */     _sb_.append(")");
/*  99 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SelectionOrFinalFightBeginReq _o_) {
/* 103 */     if (_o_ == this) return 0;
/* 104 */     int _c_ = 0;
/* 105 */     _c_ = Long.signum(this.matcher_server_contextid - _o_.matcher_server_contextid);
/* 106 */     if (0 != _c_) return _c_;
/* 107 */     _c_ = Long.signum(this.game_server_contextid - _o_.game_server_contextid);
/* 108 */     if (0 != _c_) return _c_;
/* 109 */     _c_ = Long.signum(this.corps_id - _o_.corps_id);
/* 110 */     if (0 != _c_) return _c_;
/* 111 */     _c_ = this.fight_type - _o_.fight_type;
/* 112 */     if (0 != _c_) return _c_;
/* 113 */     _c_ = this.fight_stage - _o_.fight_stage;
/* 114 */     if (0 != _c_) return _c_;
/* 115 */     _c_ = this.fight_index_id - _o_.fight_index_id;
/* 116 */     if (0 != _c_) return _c_;
/* 117 */     _c_ = Long.signum(this.fight_record_id - _o_.fight_record_id);
/* 118 */     if (0 != _c_) return _c_;
/* 119 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\SelectionOrFinalFightBeginReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */