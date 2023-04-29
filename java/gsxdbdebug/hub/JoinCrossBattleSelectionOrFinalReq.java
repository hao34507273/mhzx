/*    */ package hub;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class JoinCrossBattleSelectionOrFinalReq
/*    */   implements Marshal
/*    */ {
/*    */   public long game_server_contextid;
/*    */   public int fight_type;
/*    */   public int fight_stage;
/*    */   public int fight_index_id;
/*    */   public SelectionFinalTeamInfo cross_battle_team_info;
/*    */   
/*    */   public JoinCrossBattleSelectionOrFinalReq()
/*    */   {
/* 18 */     this.game_server_contextid = 0L;
/* 19 */     this.cross_battle_team_info = new SelectionFinalTeamInfo();
/*    */   }
/*    */   
/*    */   public JoinCrossBattleSelectionOrFinalReq(long _game_server_contextid_, int _fight_type_, int _fight_stage_, int _fight_index_id_, SelectionFinalTeamInfo _cross_battle_team_info_) {
/* 23 */     this.game_server_contextid = _game_server_contextid_;
/* 24 */     this.fight_type = _fight_type_;
/* 25 */     this.fight_stage = _fight_stage_;
/* 26 */     this.fight_index_id = _fight_index_id_;
/* 27 */     this.cross_battle_team_info = _cross_battle_team_info_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 31 */     if (!this.cross_battle_team_info._validator_()) return false;
/* 32 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 36 */     _os_.marshal(this.game_server_contextid);
/* 37 */     _os_.marshal(this.fight_type);
/* 38 */     _os_.marshal(this.fight_stage);
/* 39 */     _os_.marshal(this.fight_index_id);
/* 40 */     _os_.marshal(this.cross_battle_team_info);
/* 41 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 45 */     this.game_server_contextid = _os_.unmarshal_long();
/* 46 */     this.fight_type = _os_.unmarshal_int();
/* 47 */     this.fight_stage = _os_.unmarshal_int();
/* 48 */     this.fight_index_id = _os_.unmarshal_int();
/* 49 */     this.cross_battle_team_info.unmarshal(_os_);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 54 */     if (_o1_ == this) return true;
/* 55 */     if ((_o1_ instanceof JoinCrossBattleSelectionOrFinalReq)) {
/* 56 */       JoinCrossBattleSelectionOrFinalReq _o_ = (JoinCrossBattleSelectionOrFinalReq)_o1_;
/* 57 */       if (this.game_server_contextid != _o_.game_server_contextid) return false;
/* 58 */       if (this.fight_type != _o_.fight_type) return false;
/* 59 */       if (this.fight_stage != _o_.fight_stage) return false;
/* 60 */       if (this.fight_index_id != _o_.fight_index_id) return false;
/* 61 */       if (!this.cross_battle_team_info.equals(_o_.cross_battle_team_info)) return false;
/* 62 */       return true;
/*    */     }
/* 64 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 68 */     int _h_ = 0;
/* 69 */     _h_ += (int)this.game_server_contextid;
/* 70 */     _h_ += this.fight_type;
/* 71 */     _h_ += this.fight_stage;
/* 72 */     _h_ += this.fight_index_id;
/* 73 */     _h_ += this.cross_battle_team_info.hashCode();
/* 74 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 78 */     StringBuilder _sb_ = new StringBuilder();
/* 79 */     _sb_.append("(");
/* 80 */     _sb_.append(this.game_server_contextid).append(",");
/* 81 */     _sb_.append(this.fight_type).append(",");
/* 82 */     _sb_.append(this.fight_stage).append(",");
/* 83 */     _sb_.append(this.fight_index_id).append(",");
/* 84 */     _sb_.append(this.cross_battle_team_info).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\JoinCrossBattleSelectionOrFinalReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */