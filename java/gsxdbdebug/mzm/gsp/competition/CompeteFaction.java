/*    */ package mzm.gsp.competition;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class CompeteFaction implements Marshal, Comparable<CompeteFaction>
/*    */ {
/*    */   public long factionid;
/*    */   public int pk_score;
/*    */   public int player_score;
/*    */   public int player_number;
/*    */   public int mercenary_score;
/*    */   
/*    */   public CompeteFaction() {}
/*    */   
/*    */   public CompeteFaction(long _factionid_, int _pk_score_, int _player_score_, int _player_number_, int _mercenary_score_)
/*    */   {
/* 19 */     this.factionid = _factionid_;
/* 20 */     this.pk_score = _pk_score_;
/* 21 */     this.player_score = _player_score_;
/* 22 */     this.player_number = _player_number_;
/* 23 */     this.mercenary_score = _mercenary_score_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 27 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 31 */     _os_.marshal(this.factionid);
/* 32 */     _os_.marshal(this.pk_score);
/* 33 */     _os_.marshal(this.player_score);
/* 34 */     _os_.marshal(this.player_number);
/* 35 */     _os_.marshal(this.mercenary_score);
/* 36 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 40 */     this.factionid = _os_.unmarshal_long();
/* 41 */     this.pk_score = _os_.unmarshal_int();
/* 42 */     this.player_score = _os_.unmarshal_int();
/* 43 */     this.player_number = _os_.unmarshal_int();
/* 44 */     this.mercenary_score = _os_.unmarshal_int();
/* 45 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 49 */     if (_o1_ == this) return true;
/* 50 */     if ((_o1_ instanceof CompeteFaction)) {
/* 51 */       CompeteFaction _o_ = (CompeteFaction)_o1_;
/* 52 */       if (this.factionid != _o_.factionid) return false;
/* 53 */       if (this.pk_score != _o_.pk_score) return false;
/* 54 */       if (this.player_score != _o_.player_score) return false;
/* 55 */       if (this.player_number != _o_.player_number) return false;
/* 56 */       if (this.mercenary_score != _o_.mercenary_score) return false;
/* 57 */       return true;
/*    */     }
/* 59 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 63 */     int _h_ = 0;
/* 64 */     _h_ += (int)this.factionid;
/* 65 */     _h_ += this.pk_score;
/* 66 */     _h_ += this.player_score;
/* 67 */     _h_ += this.player_number;
/* 68 */     _h_ += this.mercenary_score;
/* 69 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 73 */     StringBuilder _sb_ = new StringBuilder();
/* 74 */     _sb_.append("(");
/* 75 */     _sb_.append(this.factionid).append(",");
/* 76 */     _sb_.append(this.pk_score).append(",");
/* 77 */     _sb_.append(this.player_score).append(",");
/* 78 */     _sb_.append(this.player_number).append(",");
/* 79 */     _sb_.append(this.mercenary_score).append(",");
/* 80 */     _sb_.append(")");
/* 81 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CompeteFaction _o_) {
/* 85 */     if (_o_ == this) return 0;
/* 86 */     int _c_ = 0;
/* 87 */     _c_ = Long.signum(this.factionid - _o_.factionid);
/* 88 */     if (0 != _c_) return _c_;
/* 89 */     _c_ = this.pk_score - _o_.pk_score;
/* 90 */     if (0 != _c_) return _c_;
/* 91 */     _c_ = this.player_score - _o_.player_score;
/* 92 */     if (0 != _c_) return _c_;
/* 93 */     _c_ = this.player_number - _o_.player_number;
/* 94 */     if (0 != _c_) return _c_;
/* 95 */     _c_ = this.mercenary_score - _o_.mercenary_score;
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\competition\CompeteFaction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */