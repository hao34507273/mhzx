/*    */ package mzm.gsp.backgameactivity;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BackGameActivityAwardInfo
/*    */   implements Marshal, Comparable<BackGameActivityAwardInfo>
/*    */ {
/*    */   public static final int AVAILABLE = 0;
/*    */   public static final int NOT_AVAILABLE = 1;
/*    */   public int back_game_award_available;
/*    */   public int back_game_award_tier_cfg_id;
/*    */   
/*    */   public BackGameActivityAwardInfo() {}
/*    */   
/*    */   public BackGameActivityAwardInfo(int _back_game_award_available_, int _back_game_award_tier_cfg_id_)
/*    */   {
/* 21 */     this.back_game_award_available = _back_game_award_available_;
/* 22 */     this.back_game_award_tier_cfg_id = _back_game_award_tier_cfg_id_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 26 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 30 */     _os_.marshal(this.back_game_award_available);
/* 31 */     _os_.marshal(this.back_game_award_tier_cfg_id);
/* 32 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 36 */     this.back_game_award_available = _os_.unmarshal_int();
/* 37 */     this.back_game_award_tier_cfg_id = _os_.unmarshal_int();
/* 38 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 42 */     if (_o1_ == this) return true;
/* 43 */     if ((_o1_ instanceof BackGameActivityAwardInfo)) {
/* 44 */       BackGameActivityAwardInfo _o_ = (BackGameActivityAwardInfo)_o1_;
/* 45 */       if (this.back_game_award_available != _o_.back_game_award_available) return false;
/* 46 */       if (this.back_game_award_tier_cfg_id != _o_.back_game_award_tier_cfg_id) return false;
/* 47 */       return true;
/*    */     }
/* 49 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 53 */     int _h_ = 0;
/* 54 */     _h_ += this.back_game_award_available;
/* 55 */     _h_ += this.back_game_award_tier_cfg_id;
/* 56 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 60 */     StringBuilder _sb_ = new StringBuilder();
/* 61 */     _sb_.append("(");
/* 62 */     _sb_.append(this.back_game_award_available).append(",");
/* 63 */     _sb_.append(this.back_game_award_tier_cfg_id).append(",");
/* 64 */     _sb_.append(")");
/* 65 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(BackGameActivityAwardInfo _o_) {
/* 69 */     if (_o_ == this) return 0;
/* 70 */     int _c_ = 0;
/* 71 */     _c_ = this.back_game_award_available - _o_.back_game_award_available;
/* 72 */     if (0 != _c_) return _c_;
/* 73 */     _c_ = this.back_game_award_tier_cfg_id - _o_.back_game_award_tier_cfg_id;
/* 74 */     if (0 != _c_) return _c_;
/* 75 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\backgameactivity\BackGameActivityAwardInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */