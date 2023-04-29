/*    */ package mzm.gsp.crosscompete;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ public class CompeteFaction
/*    */   implements Marshal, Comparable<CompeteFaction>
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
/* 21 */     this.factionid = _factionid_;
/* 22 */     this.pk_score = _pk_score_;
/* 23 */     this.player_score = _player_score_;
/* 24 */     this.player_number = _player_number_;
/* 25 */     this.mercenary_score = _mercenary_score_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 29 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 33 */     _os_.marshal(this.factionid);
/* 34 */     _os_.marshal(this.pk_score);
/* 35 */     _os_.marshal(this.player_score);
/* 36 */     _os_.marshal(this.player_number);
/* 37 */     _os_.marshal(this.mercenary_score);
/* 38 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 42 */     this.factionid = _os_.unmarshal_long();
/* 43 */     this.pk_score = _os_.unmarshal_int();
/* 44 */     this.player_score = _os_.unmarshal_int();
/* 45 */     this.player_number = _os_.unmarshal_int();
/* 46 */     this.mercenary_score = _os_.unmarshal_int();
/* 47 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 51 */     if (_o1_ == this) return true;
/* 52 */     if ((_o1_ instanceof CompeteFaction)) {
/* 53 */       CompeteFaction _o_ = (CompeteFaction)_o1_;
/* 54 */       if (this.factionid != _o_.factionid) return false;
/* 55 */       if (this.pk_score != _o_.pk_score) return false;
/* 56 */       if (this.player_score != _o_.player_score) return false;
/* 57 */       if (this.player_number != _o_.player_number) return false;
/* 58 */       if (this.mercenary_score != _o_.mercenary_score) return false;
/* 59 */       return true;
/*    */     }
/* 61 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 65 */     int _h_ = 0;
/* 66 */     _h_ += (int)this.factionid;
/* 67 */     _h_ += this.pk_score;
/* 68 */     _h_ += this.player_score;
/* 69 */     _h_ += this.player_number;
/* 70 */     _h_ += this.mercenary_score;
/* 71 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 75 */     StringBuilder _sb_ = new StringBuilder();
/* 76 */     _sb_.append("(");
/* 77 */     _sb_.append(this.factionid).append(",");
/* 78 */     _sb_.append(this.pk_score).append(",");
/* 79 */     _sb_.append(this.player_score).append(",");
/* 80 */     _sb_.append(this.player_number).append(",");
/* 81 */     _sb_.append(this.mercenary_score).append(",");
/* 82 */     _sb_.append(")");
/* 83 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CompeteFaction _o_) {
/* 87 */     if (_o_ == this) return 0;
/* 88 */     int _c_ = 0;
/* 89 */     _c_ = Long.signum(this.factionid - _o_.factionid);
/* 90 */     if (0 != _c_) return _c_;
/* 91 */     _c_ = this.pk_score - _o_.pk_score;
/* 92 */     if (0 != _c_) return _c_;
/* 93 */     _c_ = this.player_score - _o_.player_score;
/* 94 */     if (0 != _c_) return _c_;
/* 95 */     _c_ = this.player_number - _o_.player_number;
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     _c_ = this.mercenary_score - _o_.mercenary_score;
/* 98 */     if (0 != _c_) return _c_;
/* 99 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\CompeteFaction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */