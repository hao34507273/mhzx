/*    */ package mzm.gsp.ballbattle;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ public class ActivityStatus
/*    */   implements Marshal, Comparable<ActivityStatus>
/*    */ {
/*    */   public int round;
/*    */   public int role_number;
/*    */   public int is_preparing;
/*    */   public int stage_end_time;
/*    */   
/*    */   public ActivityStatus() {}
/*    */   
/*    */   public ActivityStatus(int _round_, int _role_number_, int _is_preparing_, int _stage_end_time_)
/*    */   {
/* 20 */     this.round = _round_;
/* 21 */     this.role_number = _role_number_;
/* 22 */     this.is_preparing = _is_preparing_;
/* 23 */     this.stage_end_time = _stage_end_time_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 27 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 31 */     _os_.marshal(this.round);
/* 32 */     _os_.marshal(this.role_number);
/* 33 */     _os_.marshal(this.is_preparing);
/* 34 */     _os_.marshal(this.stage_end_time);
/* 35 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 39 */     this.round = _os_.unmarshal_int();
/* 40 */     this.role_number = _os_.unmarshal_int();
/* 41 */     this.is_preparing = _os_.unmarshal_int();
/* 42 */     this.stage_end_time = _os_.unmarshal_int();
/* 43 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 47 */     if (_o1_ == this) return true;
/* 48 */     if ((_o1_ instanceof ActivityStatus)) {
/* 49 */       ActivityStatus _o_ = (ActivityStatus)_o1_;
/* 50 */       if (this.round != _o_.round) return false;
/* 51 */       if (this.role_number != _o_.role_number) return false;
/* 52 */       if (this.is_preparing != _o_.is_preparing) return false;
/* 53 */       if (this.stage_end_time != _o_.stage_end_time) return false;
/* 54 */       return true;
/*    */     }
/* 56 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 60 */     int _h_ = 0;
/* 61 */     _h_ += this.round;
/* 62 */     _h_ += this.role_number;
/* 63 */     _h_ += this.is_preparing;
/* 64 */     _h_ += this.stage_end_time;
/* 65 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 69 */     StringBuilder _sb_ = new StringBuilder();
/* 70 */     _sb_.append("(");
/* 71 */     _sb_.append(this.round).append(",");
/* 72 */     _sb_.append(this.role_number).append(",");
/* 73 */     _sb_.append(this.is_preparing).append(",");
/* 74 */     _sb_.append(this.stage_end_time).append(",");
/* 75 */     _sb_.append(")");
/* 76 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(ActivityStatus _o_) {
/* 80 */     if (_o_ == this) return 0;
/* 81 */     int _c_ = 0;
/* 82 */     _c_ = this.round - _o_.round;
/* 83 */     if (0 != _c_) return _c_;
/* 84 */     _c_ = this.role_number - _o_.role_number;
/* 85 */     if (0 != _c_) return _c_;
/* 86 */     _c_ = this.is_preparing - _o_.is_preparing;
/* 87 */     if (0 != _c_) return _c_;
/* 88 */     _c_ = this.stage_end_time - _o_.stage_end_time;
/* 89 */     if (0 != _c_) return _c_;
/* 90 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ballbattle\ActivityStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */