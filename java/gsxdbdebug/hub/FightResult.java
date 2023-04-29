/*    */ package hub;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class FightResult implements Marshal, Comparable<FightResult>
/*    */ {
/*    */   public int rounds;
/*    */   public long fightid;
/*    */   public long starttime;
/*    */   public int intervalmilltime;
/*    */   public long contextid;
/*    */   
/*    */   public FightResult() {}
/*    */   
/*    */   public FightResult(int _rounds_, long _fightid_, long _starttime_, int _intervalmilltime_, long _contextid_)
/*    */   {
/* 19 */     this.rounds = _rounds_;
/* 20 */     this.fightid = _fightid_;
/* 21 */     this.starttime = _starttime_;
/* 22 */     this.intervalmilltime = _intervalmilltime_;
/* 23 */     this.contextid = _contextid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 27 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 31 */     _os_.marshal(this.rounds);
/* 32 */     _os_.marshal(this.fightid);
/* 33 */     _os_.marshal(this.starttime);
/* 34 */     _os_.marshal(this.intervalmilltime);
/* 35 */     _os_.marshal(this.contextid);
/* 36 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 40 */     this.rounds = _os_.unmarshal_int();
/* 41 */     this.fightid = _os_.unmarshal_long();
/* 42 */     this.starttime = _os_.unmarshal_long();
/* 43 */     this.intervalmilltime = _os_.unmarshal_int();
/* 44 */     this.contextid = _os_.unmarshal_long();
/* 45 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 49 */     if (_o1_ == this) return true;
/* 50 */     if ((_o1_ instanceof FightResult)) {
/* 51 */       FightResult _o_ = (FightResult)_o1_;
/* 52 */       if (this.rounds != _o_.rounds) return false;
/* 53 */       if (this.fightid != _o_.fightid) return false;
/* 54 */       if (this.starttime != _o_.starttime) return false;
/* 55 */       if (this.intervalmilltime != _o_.intervalmilltime) return false;
/* 56 */       if (this.contextid != _o_.contextid) return false;
/* 57 */       return true;
/*    */     }
/* 59 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 63 */     int _h_ = 0;
/* 64 */     _h_ += this.rounds;
/* 65 */     _h_ += (int)this.fightid;
/* 66 */     _h_ += (int)this.starttime;
/* 67 */     _h_ += this.intervalmilltime;
/* 68 */     _h_ += (int)this.contextid;
/* 69 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 73 */     StringBuilder _sb_ = new StringBuilder();
/* 74 */     _sb_.append("(");
/* 75 */     _sb_.append(this.rounds).append(",");
/* 76 */     _sb_.append(this.fightid).append(",");
/* 77 */     _sb_.append(this.starttime).append(",");
/* 78 */     _sb_.append(this.intervalmilltime).append(",");
/* 79 */     _sb_.append(this.contextid).append(",");
/* 80 */     _sb_.append(")");
/* 81 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(FightResult _o_) {
/* 85 */     if (_o_ == this) return 0;
/* 86 */     int _c_ = 0;
/* 87 */     _c_ = this.rounds - _o_.rounds;
/* 88 */     if (0 != _c_) return _c_;
/* 89 */     _c_ = Long.signum(this.fightid - _o_.fightid);
/* 90 */     if (0 != _c_) return _c_;
/* 91 */     _c_ = Long.signum(this.starttime - _o_.starttime);
/* 92 */     if (0 != _c_) return _c_;
/* 93 */     _c_ = this.intervalmilltime - _o_.intervalmilltime;
/* 94 */     if (0 != _c_) return _c_;
/* 95 */     _c_ = Long.signum(this.contextid - _o_.contextid);
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\FightResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */