/*    */ package mzm.gsp.personal;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ public class ConditionInfo
/*    */   implements Marshal, Comparable<ConditionInfo>
/*    */ {
/*    */   public int gender;
/*    */   public int minlevel;
/*    */   public int maxlevel;
/*    */   public int location;
/*    */   
/*    */   public ConditionInfo() {}
/*    */   
/*    */   public ConditionInfo(int _gender_, int _minlevel_, int _maxlevel_, int _location_)
/*    */   {
/* 20 */     this.gender = _gender_;
/* 21 */     this.minlevel = _minlevel_;
/* 22 */     this.maxlevel = _maxlevel_;
/* 23 */     this.location = _location_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 27 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 31 */     _os_.marshal(this.gender);
/* 32 */     _os_.marshal(this.minlevel);
/* 33 */     _os_.marshal(this.maxlevel);
/* 34 */     _os_.marshal(this.location);
/* 35 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 39 */     this.gender = _os_.unmarshal_int();
/* 40 */     this.minlevel = _os_.unmarshal_int();
/* 41 */     this.maxlevel = _os_.unmarshal_int();
/* 42 */     this.location = _os_.unmarshal_int();
/* 43 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 47 */     if (_o1_ == this) return true;
/* 48 */     if ((_o1_ instanceof ConditionInfo)) {
/* 49 */       ConditionInfo _o_ = (ConditionInfo)_o1_;
/* 50 */       if (this.gender != _o_.gender) return false;
/* 51 */       if (this.minlevel != _o_.minlevel) return false;
/* 52 */       if (this.maxlevel != _o_.maxlevel) return false;
/* 53 */       if (this.location != _o_.location) return false;
/* 54 */       return true;
/*    */     }
/* 56 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 60 */     int _h_ = 0;
/* 61 */     _h_ += this.gender;
/* 62 */     _h_ += this.minlevel;
/* 63 */     _h_ += this.maxlevel;
/* 64 */     _h_ += this.location;
/* 65 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 69 */     StringBuilder _sb_ = new StringBuilder();
/* 70 */     _sb_.append("(");
/* 71 */     _sb_.append(this.gender).append(",");
/* 72 */     _sb_.append(this.minlevel).append(",");
/* 73 */     _sb_.append(this.maxlevel).append(",");
/* 74 */     _sb_.append(this.location).append(",");
/* 75 */     _sb_.append(")");
/* 76 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(ConditionInfo _o_) {
/* 80 */     if (_o_ == this) return 0;
/* 81 */     int _c_ = 0;
/* 82 */     _c_ = this.gender - _o_.gender;
/* 83 */     if (0 != _c_) return _c_;
/* 84 */     _c_ = this.minlevel - _o_.minlevel;
/* 85 */     if (0 != _c_) return _c_;
/* 86 */     _c_ = this.maxlevel - _o_.maxlevel;
/* 87 */     if (0 != _c_) return _c_;
/* 88 */     _c_ = this.location - _o_.location;
/* 89 */     if (0 != _c_) return _c_;
/* 90 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\personal\ConditionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */