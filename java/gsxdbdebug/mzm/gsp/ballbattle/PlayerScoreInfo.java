/*    */ package mzm.gsp.ballbattle;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ public class PlayerScoreInfo
/*    */   implements Marshal, Comparable<PlayerScoreInfo>
/*    */ {
/*    */   public int score;
/*    */   public int kill;
/*    */   public int death;
/*    */   public int in_game_scene;
/*    */   public int update_time;
/*    */   
/*    */   public PlayerScoreInfo() {}
/*    */   
/*    */   public PlayerScoreInfo(int _score_, int _kill_, int _death_, int _in_game_scene_, int _update_time_)
/*    */   {
/* 21 */     this.score = _score_;
/* 22 */     this.kill = _kill_;
/* 23 */     this.death = _death_;
/* 24 */     this.in_game_scene = _in_game_scene_;
/* 25 */     this.update_time = _update_time_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 29 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 33 */     _os_.marshal(this.score);
/* 34 */     _os_.marshal(this.kill);
/* 35 */     _os_.marshal(this.death);
/* 36 */     _os_.marshal(this.in_game_scene);
/* 37 */     _os_.marshal(this.update_time);
/* 38 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 42 */     this.score = _os_.unmarshal_int();
/* 43 */     this.kill = _os_.unmarshal_int();
/* 44 */     this.death = _os_.unmarshal_int();
/* 45 */     this.in_game_scene = _os_.unmarshal_int();
/* 46 */     this.update_time = _os_.unmarshal_int();
/* 47 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 51 */     if (_o1_ == this) return true;
/* 52 */     if ((_o1_ instanceof PlayerScoreInfo)) {
/* 53 */       PlayerScoreInfo _o_ = (PlayerScoreInfo)_o1_;
/* 54 */       if (this.score != _o_.score) return false;
/* 55 */       if (this.kill != _o_.kill) return false;
/* 56 */       if (this.death != _o_.death) return false;
/* 57 */       if (this.in_game_scene != _o_.in_game_scene) return false;
/* 58 */       if (this.update_time != _o_.update_time) return false;
/* 59 */       return true;
/*    */     }
/* 61 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 65 */     int _h_ = 0;
/* 66 */     _h_ += this.score;
/* 67 */     _h_ += this.kill;
/* 68 */     _h_ += this.death;
/* 69 */     _h_ += this.in_game_scene;
/* 70 */     _h_ += this.update_time;
/* 71 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 75 */     StringBuilder _sb_ = new StringBuilder();
/* 76 */     _sb_.append("(");
/* 77 */     _sb_.append(this.score).append(",");
/* 78 */     _sb_.append(this.kill).append(",");
/* 79 */     _sb_.append(this.death).append(",");
/* 80 */     _sb_.append(this.in_game_scene).append(",");
/* 81 */     _sb_.append(this.update_time).append(",");
/* 82 */     _sb_.append(")");
/* 83 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(PlayerScoreInfo _o_) {
/* 87 */     if (_o_ == this) return 0;
/* 88 */     int _c_ = 0;
/* 89 */     _c_ = this.score - _o_.score;
/* 90 */     if (0 != _c_) return _c_;
/* 91 */     _c_ = this.kill - _o_.kill;
/* 92 */     if (0 != _c_) return _c_;
/* 93 */     _c_ = this.death - _o_.death;
/* 94 */     if (0 != _c_) return _c_;
/* 95 */     _c_ = this.in_game_scene - _o_.in_game_scene;
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     _c_ = this.update_time - _o_.update_time;
/* 98 */     if (0 != _c_) return _c_;
/* 99 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ballbattle\PlayerScoreInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */