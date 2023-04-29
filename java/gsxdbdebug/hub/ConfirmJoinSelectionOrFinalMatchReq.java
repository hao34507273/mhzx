/*    */ package hub;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class ConfirmJoinSelectionOrFinalMatchReq
/*    */   implements Marshal, Comparable<ConfirmJoinSelectionOrFinalMatchReq>
/*    */ {
/*    */   public long matcher_server_contextid;
/*    */   public long game_server_contextid;
/*    */   public int fight_type;
/*    */   public int fight_stage;
/*    */   
/*    */   public ConfirmJoinSelectionOrFinalMatchReq()
/*    */   {
/* 17 */     this.matcher_server_contextid = 0L;
/* 18 */     this.game_server_contextid = 0L;
/*    */   }
/*    */   
/*    */   public ConfirmJoinSelectionOrFinalMatchReq(long _matcher_server_contextid_, long _game_server_contextid_, int _fight_type_, int _fight_stage_) {
/* 22 */     this.matcher_server_contextid = _matcher_server_contextid_;
/* 23 */     this.game_server_contextid = _game_server_contextid_;
/* 24 */     this.fight_type = _fight_type_;
/* 25 */     this.fight_stage = _fight_stage_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 29 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 33 */     _os_.marshal(this.matcher_server_contextid);
/* 34 */     _os_.marshal(this.game_server_contextid);
/* 35 */     _os_.marshal(this.fight_type);
/* 36 */     _os_.marshal(this.fight_stage);
/* 37 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 41 */     this.matcher_server_contextid = _os_.unmarshal_long();
/* 42 */     this.game_server_contextid = _os_.unmarshal_long();
/* 43 */     this.fight_type = _os_.unmarshal_int();
/* 44 */     this.fight_stage = _os_.unmarshal_int();
/* 45 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 49 */     if (_o1_ == this) return true;
/* 50 */     if ((_o1_ instanceof ConfirmJoinSelectionOrFinalMatchReq)) {
/* 51 */       ConfirmJoinSelectionOrFinalMatchReq _o_ = (ConfirmJoinSelectionOrFinalMatchReq)_o1_;
/* 52 */       if (this.matcher_server_contextid != _o_.matcher_server_contextid) return false;
/* 53 */       if (this.game_server_contextid != _o_.game_server_contextid) return false;
/* 54 */       if (this.fight_type != _o_.fight_type) return false;
/* 55 */       if (this.fight_stage != _o_.fight_stage) return false;
/* 56 */       return true;
/*    */     }
/* 58 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 62 */     int _h_ = 0;
/* 63 */     _h_ += (int)this.matcher_server_contextid;
/* 64 */     _h_ += (int)this.game_server_contextid;
/* 65 */     _h_ += this.fight_type;
/* 66 */     _h_ += this.fight_stage;
/* 67 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 71 */     StringBuilder _sb_ = new StringBuilder();
/* 72 */     _sb_.append("(");
/* 73 */     _sb_.append(this.matcher_server_contextid).append(",");
/* 74 */     _sb_.append(this.game_server_contextid).append(",");
/* 75 */     _sb_.append(this.fight_type).append(",");
/* 76 */     _sb_.append(this.fight_stage).append(",");
/* 77 */     _sb_.append(")");
/* 78 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(ConfirmJoinSelectionOrFinalMatchReq _o_) {
/* 82 */     if (_o_ == this) return 0;
/* 83 */     int _c_ = 0;
/* 84 */     _c_ = Long.signum(this.matcher_server_contextid - _o_.matcher_server_contextid);
/* 85 */     if (0 != _c_) return _c_;
/* 86 */     _c_ = Long.signum(this.game_server_contextid - _o_.game_server_contextid);
/* 87 */     if (0 != _c_) return _c_;
/* 88 */     _c_ = this.fight_type - _o_.fight_type;
/* 89 */     if (0 != _c_) return _c_;
/* 90 */     _c_ = this.fight_stage - _o_.fight_stage;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\ConfirmJoinSelectionOrFinalMatchReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */