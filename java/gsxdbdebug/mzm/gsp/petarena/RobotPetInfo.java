/*    */ package mzm.gsp.petarena;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class RobotPetInfo implements Marshal, Comparable<RobotPetInfo>
/*    */ {
/*    */   public int monster_cfgid;
/*    */   public int model_ratio;
/*    */   public int level;
/*    */   public int grade;
/*    */   public int score;
/*    */   
/*    */   public RobotPetInfo() {}
/*    */   
/*    */   public RobotPetInfo(int _monster_cfgid_, int _model_ratio_, int _level_, int _grade_, int _score_)
/*    */   {
/* 19 */     this.monster_cfgid = _monster_cfgid_;
/* 20 */     this.model_ratio = _model_ratio_;
/* 21 */     this.level = _level_;
/* 22 */     this.grade = _grade_;
/* 23 */     this.score = _score_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 27 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 31 */     _os_.marshal(this.monster_cfgid);
/* 32 */     _os_.marshal(this.model_ratio);
/* 33 */     _os_.marshal(this.level);
/* 34 */     _os_.marshal(this.grade);
/* 35 */     _os_.marshal(this.score);
/* 36 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 40 */     this.monster_cfgid = _os_.unmarshal_int();
/* 41 */     this.model_ratio = _os_.unmarshal_int();
/* 42 */     this.level = _os_.unmarshal_int();
/* 43 */     this.grade = _os_.unmarshal_int();
/* 44 */     this.score = _os_.unmarshal_int();
/* 45 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 49 */     if (_o1_ == this) return true;
/* 50 */     if ((_o1_ instanceof RobotPetInfo)) {
/* 51 */       RobotPetInfo _o_ = (RobotPetInfo)_o1_;
/* 52 */       if (this.monster_cfgid != _o_.monster_cfgid) return false;
/* 53 */       if (this.model_ratio != _o_.model_ratio) return false;
/* 54 */       if (this.level != _o_.level) return false;
/* 55 */       if (this.grade != _o_.grade) return false;
/* 56 */       if (this.score != _o_.score) return false;
/* 57 */       return true;
/*    */     }
/* 59 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 63 */     int _h_ = 0;
/* 64 */     _h_ += this.monster_cfgid;
/* 65 */     _h_ += this.model_ratio;
/* 66 */     _h_ += this.level;
/* 67 */     _h_ += this.grade;
/* 68 */     _h_ += this.score;
/* 69 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 73 */     StringBuilder _sb_ = new StringBuilder();
/* 74 */     _sb_.append("(");
/* 75 */     _sb_.append(this.monster_cfgid).append(",");
/* 76 */     _sb_.append(this.model_ratio).append(",");
/* 77 */     _sb_.append(this.level).append(",");
/* 78 */     _sb_.append(this.grade).append(",");
/* 79 */     _sb_.append(this.score).append(",");
/* 80 */     _sb_.append(")");
/* 81 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(RobotPetInfo _o_) {
/* 85 */     if (_o_ == this) return 0;
/* 86 */     int _c_ = 0;
/* 87 */     _c_ = this.monster_cfgid - _o_.monster_cfgid;
/* 88 */     if (0 != _c_) return _c_;
/* 89 */     _c_ = this.model_ratio - _o_.model_ratio;
/* 90 */     if (0 != _c_) return _c_;
/* 91 */     _c_ = this.level - _o_.level;
/* 92 */     if (0 != _c_) return _c_;
/* 93 */     _c_ = this.grade - _o_.grade;
/* 94 */     if (0 != _c_) return _c_;
/* 95 */     _c_ = this.score - _o_.score;
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petarena\RobotPetInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */