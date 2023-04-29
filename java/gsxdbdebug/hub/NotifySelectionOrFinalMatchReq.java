/*     */ package hub;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ public class NotifySelectionOrFinalMatchReq
/*     */   implements Marshal
/*     */ {
/*     */   public static final int RESULT_SUCCEED = 0;
/*     */   public static final int RESULT_FAIL = 1;
/*     */   public int result;
/*     */   public long matcher_server_contextid;
/*     */   public long game_server_contextid;
/*     */   public int fight_type;
/*     */   public int fight_stage;
/*     */   public int roam_zoneid;
/*     */   public long roam_room_instanceid;
/*     */   public SelectionFinalTeamInfo opponent_team_info;
/*     */   
/*     */   public NotifySelectionOrFinalMatchReq()
/*     */   {
/*  24 */     this.result = 1;
/*  25 */     this.matcher_server_contextid = 0L;
/*  26 */     this.game_server_contextid = 0L;
/*  27 */     this.roam_zoneid = 0;
/*  28 */     this.roam_room_instanceid = 0L;
/*  29 */     this.opponent_team_info = new SelectionFinalTeamInfo();
/*     */   }
/*     */   
/*     */   public NotifySelectionOrFinalMatchReq(int _result_, long _matcher_server_contextid_, long _game_server_contextid_, int _fight_type_, int _fight_stage_, int _roam_zoneid_, long _roam_room_instanceid_, SelectionFinalTeamInfo _opponent_team_info_) {
/*  33 */     this.result = _result_;
/*  34 */     this.matcher_server_contextid = _matcher_server_contextid_;
/*  35 */     this.game_server_contextid = _game_server_contextid_;
/*  36 */     this.fight_type = _fight_type_;
/*  37 */     this.fight_stage = _fight_stage_;
/*  38 */     this.roam_zoneid = _roam_zoneid_;
/*  39 */     this.roam_room_instanceid = _roam_room_instanceid_;
/*  40 */     this.opponent_team_info = _opponent_team_info_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     if (!this.opponent_team_info._validator_()) return false;
/*  45 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  49 */     _os_.marshal(this.result);
/*  50 */     _os_.marshal(this.matcher_server_contextid);
/*  51 */     _os_.marshal(this.game_server_contextid);
/*  52 */     _os_.marshal(this.fight_type);
/*  53 */     _os_.marshal(this.fight_stage);
/*  54 */     _os_.marshal(this.roam_zoneid);
/*  55 */     _os_.marshal(this.roam_room_instanceid);
/*  56 */     _os_.marshal(this.opponent_team_info);
/*  57 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  61 */     this.result = _os_.unmarshal_int();
/*  62 */     this.matcher_server_contextid = _os_.unmarshal_long();
/*  63 */     this.game_server_contextid = _os_.unmarshal_long();
/*  64 */     this.fight_type = _os_.unmarshal_int();
/*  65 */     this.fight_stage = _os_.unmarshal_int();
/*  66 */     this.roam_zoneid = _os_.unmarshal_int();
/*  67 */     this.roam_room_instanceid = _os_.unmarshal_long();
/*  68 */     this.opponent_team_info.unmarshal(_os_);
/*  69 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  73 */     if (_o1_ == this) return true;
/*  74 */     if ((_o1_ instanceof NotifySelectionOrFinalMatchReq)) {
/*  75 */       NotifySelectionOrFinalMatchReq _o_ = (NotifySelectionOrFinalMatchReq)_o1_;
/*  76 */       if (this.result != _o_.result) return false;
/*  77 */       if (this.matcher_server_contextid != _o_.matcher_server_contextid) return false;
/*  78 */       if (this.game_server_contextid != _o_.game_server_contextid) return false;
/*  79 */       if (this.fight_type != _o_.fight_type) return false;
/*  80 */       if (this.fight_stage != _o_.fight_stage) return false;
/*  81 */       if (this.roam_zoneid != _o_.roam_zoneid) return false;
/*  82 */       if (this.roam_room_instanceid != _o_.roam_room_instanceid) return false;
/*  83 */       if (!this.opponent_team_info.equals(_o_.opponent_team_info)) return false;
/*  84 */       return true;
/*     */     }
/*  86 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  90 */     int _h_ = 0;
/*  91 */     _h_ += this.result;
/*  92 */     _h_ += (int)this.matcher_server_contextid;
/*  93 */     _h_ += (int)this.game_server_contextid;
/*  94 */     _h_ += this.fight_type;
/*  95 */     _h_ += this.fight_stage;
/*  96 */     _h_ += this.roam_zoneid;
/*  97 */     _h_ += (int)this.roam_room_instanceid;
/*  98 */     _h_ += this.opponent_team_info.hashCode();
/*  99 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 103 */     StringBuilder _sb_ = new StringBuilder();
/* 104 */     _sb_.append("(");
/* 105 */     _sb_.append(this.result).append(",");
/* 106 */     _sb_.append(this.matcher_server_contextid).append(",");
/* 107 */     _sb_.append(this.game_server_contextid).append(",");
/* 108 */     _sb_.append(this.fight_type).append(",");
/* 109 */     _sb_.append(this.fight_stage).append(",");
/* 110 */     _sb_.append(this.roam_zoneid).append(",");
/* 111 */     _sb_.append(this.roam_room_instanceid).append(",");
/* 112 */     _sb_.append(this.opponent_team_info).append(",");
/* 113 */     _sb_.append(")");
/* 114 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\NotifySelectionOrFinalMatchReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */