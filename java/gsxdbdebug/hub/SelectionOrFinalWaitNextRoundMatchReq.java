/*     */ package hub;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class SelectionOrFinalWaitNextRoundMatchReq
/*     */   implements Marshal, Comparable<SelectionOrFinalWaitNextRoundMatchReq>
/*     */ {
/*     */   public long matcher_server_contextid;
/*     */   public long game_server_contextid;
/*     */   public int fight_type;
/*     */   public int fight_stage;
/*     */   public int fight_index_id;
/*     */   
/*     */   public SelectionOrFinalWaitNextRoundMatchReq()
/*     */   {
/*  18 */     this.matcher_server_contextid = 0L;
/*  19 */     this.game_server_contextid = 0L;
/*     */   }
/*     */   
/*     */   public SelectionOrFinalWaitNextRoundMatchReq(long _matcher_server_contextid_, long _game_server_contextid_, int _fight_type_, int _fight_stage_, int _fight_index_id_) {
/*  23 */     this.matcher_server_contextid = _matcher_server_contextid_;
/*  24 */     this.game_server_contextid = _game_server_contextid_;
/*  25 */     this.fight_type = _fight_type_;
/*  26 */     this.fight_stage = _fight_stage_;
/*  27 */     this.fight_index_id = _fight_index_id_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  31 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  35 */     _os_.marshal(this.matcher_server_contextid);
/*  36 */     _os_.marshal(this.game_server_contextid);
/*  37 */     _os_.marshal(this.fight_type);
/*  38 */     _os_.marshal(this.fight_stage);
/*  39 */     _os_.marshal(this.fight_index_id);
/*  40 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  44 */     this.matcher_server_contextid = _os_.unmarshal_long();
/*  45 */     this.game_server_contextid = _os_.unmarshal_long();
/*  46 */     this.fight_type = _os_.unmarshal_int();
/*  47 */     this.fight_stage = _os_.unmarshal_int();
/*  48 */     this.fight_index_id = _os_.unmarshal_int();
/*  49 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  53 */     if (_o1_ == this) return true;
/*  54 */     if ((_o1_ instanceof SelectionOrFinalWaitNextRoundMatchReq)) {
/*  55 */       SelectionOrFinalWaitNextRoundMatchReq _o_ = (SelectionOrFinalWaitNextRoundMatchReq)_o1_;
/*  56 */       if (this.matcher_server_contextid != _o_.matcher_server_contextid) return false;
/*  57 */       if (this.game_server_contextid != _o_.game_server_contextid) return false;
/*  58 */       if (this.fight_type != _o_.fight_type) return false;
/*  59 */       if (this.fight_stage != _o_.fight_stage) return false;
/*  60 */       if (this.fight_index_id != _o_.fight_index_id) return false;
/*  61 */       return true;
/*     */     }
/*  63 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  67 */     int _h_ = 0;
/*  68 */     _h_ += (int)this.matcher_server_contextid;
/*  69 */     _h_ += (int)this.game_server_contextid;
/*  70 */     _h_ += this.fight_type;
/*  71 */     _h_ += this.fight_stage;
/*  72 */     _h_ += this.fight_index_id;
/*  73 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  77 */     StringBuilder _sb_ = new StringBuilder();
/*  78 */     _sb_.append("(");
/*  79 */     _sb_.append(this.matcher_server_contextid).append(",");
/*  80 */     _sb_.append(this.game_server_contextid).append(",");
/*  81 */     _sb_.append(this.fight_type).append(",");
/*  82 */     _sb_.append(this.fight_stage).append(",");
/*  83 */     _sb_.append(this.fight_index_id).append(",");
/*  84 */     _sb_.append(")");
/*  85 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SelectionOrFinalWaitNextRoundMatchReq _o_) {
/*  89 */     if (_o_ == this) return 0;
/*  90 */     int _c_ = 0;
/*  91 */     _c_ = Long.signum(this.matcher_server_contextid - _o_.matcher_server_contextid);
/*  92 */     if (0 != _c_) return _c_;
/*  93 */     _c_ = Long.signum(this.game_server_contextid - _o_.game_server_contextid);
/*  94 */     if (0 != _c_) return _c_;
/*  95 */     _c_ = this.fight_type - _o_.fight_type;
/*  96 */     if (0 != _c_) return _c_;
/*  97 */     _c_ = this.fight_stage - _o_.fight_stage;
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = this.fight_index_id - _o_.fight_index_id;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\SelectionOrFinalWaitNextRoundMatchReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */