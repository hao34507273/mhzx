/*    */ package hub;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class RoamSelectionOrFinalContextReq
/*    */   implements Marshal
/*    */ {
/*    */   public int fight_type;
/*    */   public int fight_stage;
/*    */   public int fight_index_id;
/*    */   public SelectionFinalTeamInfo selection_final_team_info;
/*    */   public SelectionFinalTeamInfo opponent_cross_battle_team_info;
/*    */   
/*    */   public RoamSelectionOrFinalContextReq()
/*    */   {
/* 18 */     this.selection_final_team_info = new SelectionFinalTeamInfo();
/* 19 */     this.opponent_cross_battle_team_info = new SelectionFinalTeamInfo();
/*    */   }
/*    */   
/*    */   public RoamSelectionOrFinalContextReq(int _fight_type_, int _fight_stage_, int _fight_index_id_, SelectionFinalTeamInfo _selection_final_team_info_, SelectionFinalTeamInfo _opponent_cross_battle_team_info_) {
/* 23 */     this.fight_type = _fight_type_;
/* 24 */     this.fight_stage = _fight_stage_;
/* 25 */     this.fight_index_id = _fight_index_id_;
/* 26 */     this.selection_final_team_info = _selection_final_team_info_;
/* 27 */     this.opponent_cross_battle_team_info = _opponent_cross_battle_team_info_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 31 */     if (!this.selection_final_team_info._validator_()) return false;
/* 32 */     if (!this.opponent_cross_battle_team_info._validator_()) return false;
/* 33 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 37 */     _os_.marshal(this.fight_type);
/* 38 */     _os_.marshal(this.fight_stage);
/* 39 */     _os_.marshal(this.fight_index_id);
/* 40 */     _os_.marshal(this.selection_final_team_info);
/* 41 */     _os_.marshal(this.opponent_cross_battle_team_info);
/* 42 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 46 */     this.fight_type = _os_.unmarshal_int();
/* 47 */     this.fight_stage = _os_.unmarshal_int();
/* 48 */     this.fight_index_id = _os_.unmarshal_int();
/* 49 */     this.selection_final_team_info.unmarshal(_os_);
/* 50 */     this.opponent_cross_battle_team_info.unmarshal(_os_);
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 55 */     if (_o1_ == this) return true;
/* 56 */     if ((_o1_ instanceof RoamSelectionOrFinalContextReq)) {
/* 57 */       RoamSelectionOrFinalContextReq _o_ = (RoamSelectionOrFinalContextReq)_o1_;
/* 58 */       if (this.fight_type != _o_.fight_type) return false;
/* 59 */       if (this.fight_stage != _o_.fight_stage) return false;
/* 60 */       if (this.fight_index_id != _o_.fight_index_id) return false;
/* 61 */       if (!this.selection_final_team_info.equals(_o_.selection_final_team_info)) return false;
/* 62 */       if (!this.opponent_cross_battle_team_info.equals(_o_.opponent_cross_battle_team_info)) return false;
/* 63 */       return true;
/*    */     }
/* 65 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 69 */     int _h_ = 0;
/* 70 */     _h_ += this.fight_type;
/* 71 */     _h_ += this.fight_stage;
/* 72 */     _h_ += this.fight_index_id;
/* 73 */     _h_ += this.selection_final_team_info.hashCode();
/* 74 */     _h_ += this.opponent_cross_battle_team_info.hashCode();
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.fight_type).append(",");
/* 82 */     _sb_.append(this.fight_stage).append(",");
/* 83 */     _sb_.append(this.fight_index_id).append(",");
/* 84 */     _sb_.append(this.selection_final_team_info).append(",");
/* 85 */     _sb_.append(this.opponent_cross_battle_team_info).append(",");
/* 86 */     _sb_.append(")");
/* 87 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\RoamSelectionOrFinalContextReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */