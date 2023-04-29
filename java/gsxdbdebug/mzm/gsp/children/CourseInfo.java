/*    */ package mzm.gsp.children;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ public class CourseInfo
/*    */   implements Marshal, Comparable<CourseInfo>
/*    */ {
/*    */   public int num;
/*    */   public int crit_num;
/*    */   
/*    */   public CourseInfo() {}
/*    */   
/*    */   public CourseInfo(int _num_, int _crit_num_)
/*    */   {
/* 18 */     this.num = _num_;
/* 19 */     this.crit_num = _crit_num_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 23 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 27 */     _os_.marshal(this.num);
/* 28 */     _os_.marshal(this.crit_num);
/* 29 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 33 */     this.num = _os_.unmarshal_int();
/* 34 */     this.crit_num = _os_.unmarshal_int();
/* 35 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 39 */     if (_o1_ == this) return true;
/* 40 */     if ((_o1_ instanceof CourseInfo)) {
/* 41 */       CourseInfo _o_ = (CourseInfo)_o1_;
/* 42 */       if (this.num != _o_.num) return false;
/* 43 */       if (this.crit_num != _o_.crit_num) return false;
/* 44 */       return true;
/*    */     }
/* 46 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 50 */     int _h_ = 0;
/* 51 */     _h_ += this.num;
/* 52 */     _h_ += this.crit_num;
/* 53 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 57 */     StringBuilder _sb_ = new StringBuilder();
/* 58 */     _sb_.append("(");
/* 59 */     _sb_.append(this.num).append(",");
/* 60 */     _sb_.append(this.crit_num).append(",");
/* 61 */     _sb_.append(")");
/* 62 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CourseInfo _o_) {
/* 66 */     if (_o_ == this) return 0;
/* 67 */     int _c_ = 0;
/* 68 */     _c_ = this.num - _o_.num;
/* 69 */     if (0 != _c_) return _c_;
/* 70 */     _c_ = this.crit_num - _o_.crit_num;
/* 71 */     if (0 != _c_) return _c_;
/* 72 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\CourseInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */