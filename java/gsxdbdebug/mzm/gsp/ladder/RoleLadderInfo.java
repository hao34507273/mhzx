/*    */ package mzm.gsp.ladder;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class RoleLadderInfo implements Marshal, Comparable<RoleLadderInfo>
/*    */ {
/*    */   public long roleid;
/*    */   public int stage;
/*    */   public int score;
/*    */   public int wincount;
/*    */   public int losecount;
/*    */   
/*    */   public RoleLadderInfo() {}
/*    */   
/*    */   public RoleLadderInfo(long _roleid_, int _stage_, int _score_, int _wincount_, int _losecount_)
/*    */   {
/* 19 */     this.roleid = _roleid_;
/* 20 */     this.stage = _stage_;
/* 21 */     this.score = _score_;
/* 22 */     this.wincount = _wincount_;
/* 23 */     this.losecount = _losecount_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 27 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 31 */     _os_.marshal(this.roleid);
/* 32 */     _os_.marshal(this.stage);
/* 33 */     _os_.marshal(this.score);
/* 34 */     _os_.marshal(this.wincount);
/* 35 */     _os_.marshal(this.losecount);
/* 36 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 40 */     this.roleid = _os_.unmarshal_long();
/* 41 */     this.stage = _os_.unmarshal_int();
/* 42 */     this.score = _os_.unmarshal_int();
/* 43 */     this.wincount = _os_.unmarshal_int();
/* 44 */     this.losecount = _os_.unmarshal_int();
/* 45 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 49 */     if (_o1_ == this) return true;
/* 50 */     if ((_o1_ instanceof RoleLadderInfo)) {
/* 51 */       RoleLadderInfo _o_ = (RoleLadderInfo)_o1_;
/* 52 */       if (this.roleid != _o_.roleid) return false;
/* 53 */       if (this.stage != _o_.stage) return false;
/* 54 */       if (this.score != _o_.score) return false;
/* 55 */       if (this.wincount != _o_.wincount) return false;
/* 56 */       if (this.losecount != _o_.losecount) return false;
/* 57 */       return true;
/*    */     }
/* 59 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 63 */     int _h_ = 0;
/* 64 */     _h_ += (int)this.roleid;
/* 65 */     _h_ += this.stage;
/* 66 */     _h_ += this.score;
/* 67 */     _h_ += this.wincount;
/* 68 */     _h_ += this.losecount;
/* 69 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 73 */     StringBuilder _sb_ = new StringBuilder();
/* 74 */     _sb_.append("(");
/* 75 */     _sb_.append(this.roleid).append(",");
/* 76 */     _sb_.append(this.stage).append(",");
/* 77 */     _sb_.append(this.score).append(",");
/* 78 */     _sb_.append(this.wincount).append(",");
/* 79 */     _sb_.append(this.losecount).append(",");
/* 80 */     _sb_.append(")");
/* 81 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(RoleLadderInfo _o_) {
/* 85 */     if (_o_ == this) return 0;
/* 86 */     int _c_ = 0;
/* 87 */     _c_ = Long.signum(this.roleid - _o_.roleid);
/* 88 */     if (0 != _c_) return _c_;
/* 89 */     _c_ = this.stage - _o_.stage;
/* 90 */     if (0 != _c_) return _c_;
/* 91 */     _c_ = this.score - _o_.score;
/* 92 */     if (0 != _c_) return _c_;
/* 93 */     _c_ = this.wincount - _o_.wincount;
/* 94 */     if (0 != _c_) return _c_;
/* 95 */     _c_ = this.losecount - _o_.losecount;
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ladder\RoleLadderInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */