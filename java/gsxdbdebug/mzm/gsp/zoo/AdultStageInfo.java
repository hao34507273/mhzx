/*    */ package mzm.gsp.zoo;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ public class AdultStageInfo
/*    */   implements Marshal, Comparable<AdultStageInfo>
/*    */ {
/*    */   public int animal_cfgid;
/*    */   public int last_mate_time;
/*    */   public int award_cfgid;
/*    */   public int birth_time;
/*    */   
/*    */   public AdultStageInfo() {}
/*    */   
/*    */   public AdultStageInfo(int _animal_cfgid_, int _last_mate_time_, int _award_cfgid_, int _birth_time_)
/*    */   {
/* 20 */     this.animal_cfgid = _animal_cfgid_;
/* 21 */     this.last_mate_time = _last_mate_time_;
/* 22 */     this.award_cfgid = _award_cfgid_;
/* 23 */     this.birth_time = _birth_time_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 27 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 31 */     _os_.marshal(this.animal_cfgid);
/* 32 */     _os_.marshal(this.last_mate_time);
/* 33 */     _os_.marshal(this.award_cfgid);
/* 34 */     _os_.marshal(this.birth_time);
/* 35 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 39 */     this.animal_cfgid = _os_.unmarshal_int();
/* 40 */     this.last_mate_time = _os_.unmarshal_int();
/* 41 */     this.award_cfgid = _os_.unmarshal_int();
/* 42 */     this.birth_time = _os_.unmarshal_int();
/* 43 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 47 */     if (_o1_ == this) return true;
/* 48 */     if ((_o1_ instanceof AdultStageInfo)) {
/* 49 */       AdultStageInfo _o_ = (AdultStageInfo)_o1_;
/* 50 */       if (this.animal_cfgid != _o_.animal_cfgid) return false;
/* 51 */       if (this.last_mate_time != _o_.last_mate_time) return false;
/* 52 */       if (this.award_cfgid != _o_.award_cfgid) return false;
/* 53 */       if (this.birth_time != _o_.birth_time) return false;
/* 54 */       return true;
/*    */     }
/* 56 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 60 */     int _h_ = 0;
/* 61 */     _h_ += this.animal_cfgid;
/* 62 */     _h_ += this.last_mate_time;
/* 63 */     _h_ += this.award_cfgid;
/* 64 */     _h_ += this.birth_time;
/* 65 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 69 */     StringBuilder _sb_ = new StringBuilder();
/* 70 */     _sb_.append("(");
/* 71 */     _sb_.append(this.animal_cfgid).append(",");
/* 72 */     _sb_.append(this.last_mate_time).append(",");
/* 73 */     _sb_.append(this.award_cfgid).append(",");
/* 74 */     _sb_.append(this.birth_time).append(",");
/* 75 */     _sb_.append(")");
/* 76 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(AdultStageInfo _o_) {
/* 80 */     if (_o_ == this) return 0;
/* 81 */     int _c_ = 0;
/* 82 */     _c_ = this.animal_cfgid - _o_.animal_cfgid;
/* 83 */     if (0 != _c_) return _c_;
/* 84 */     _c_ = this.last_mate_time - _o_.last_mate_time;
/* 85 */     if (0 != _c_) return _c_;
/* 86 */     _c_ = this.award_cfgid - _o_.award_cfgid;
/* 87 */     if (0 != _c_) return _c_;
/* 88 */     _c_ = this.birth_time - _o_.birth_time;
/* 89 */     if (0 != _c_) return _c_;
/* 90 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\zoo\AdultStageInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */