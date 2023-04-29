/*    */ package mzm.gsp.children;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map.Entry;
/*    */ 
/*    */ public class ChildHoodInfo implements Marshal
/*    */ {
/*    */   public int interest;
/*    */   public HashMap<Integer, CourseInfo> courses;
/*    */   public CourseStudyInfo cur_course;
/*    */   public int daily_num;
/*    */   
/*    */   public ChildHoodInfo()
/*    */   {
/* 17 */     this.courses = new HashMap();
/* 18 */     this.cur_course = new CourseStudyInfo();
/*    */   }
/*    */   
/*    */   public ChildHoodInfo(int _interest_, HashMap<Integer, CourseInfo> _courses_, CourseStudyInfo _cur_course_, int _daily_num_) {
/* 22 */     this.interest = _interest_;
/* 23 */     this.courses = _courses_;
/* 24 */     this.cur_course = _cur_course_;
/* 25 */     this.daily_num = _daily_num_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 29 */     for (Map.Entry<Integer, CourseInfo> _e_ : this.courses.entrySet()) {
/* 30 */       if (!((CourseInfo)_e_.getValue())._validator_()) return false;
/*    */     }
/* 32 */     if (!this.cur_course._validator_()) return false;
/* 33 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 37 */     _os_.marshal(this.interest);
/* 38 */     _os_.compact_uint32(this.courses.size());
/* 39 */     for (Map.Entry<Integer, CourseInfo> _e_ : this.courses.entrySet()) {
/* 40 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 41 */       _os_.marshal((Marshal)_e_.getValue());
/*    */     }
/* 43 */     _os_.marshal(this.cur_course);
/* 44 */     _os_.marshal(this.daily_num);
/* 45 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 49 */     this.interest = _os_.unmarshal_int();
/* 50 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 52 */       int _k_ = _os_.unmarshal_int();
/* 53 */       CourseInfo _v_ = new CourseInfo();
/* 54 */       _v_.unmarshal(_os_);
/* 55 */       this.courses.put(Integer.valueOf(_k_), _v_);
/*    */     }
/* 57 */     this.cur_course.unmarshal(_os_);
/* 58 */     this.daily_num = _os_.unmarshal_int();
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof ChildHoodInfo)) {
/* 65 */       ChildHoodInfo _o_ = (ChildHoodInfo)_o1_;
/* 66 */       if (this.interest != _o_.interest) return false;
/* 67 */       if (!this.courses.equals(_o_.courses)) return false;
/* 68 */       if (!this.cur_course.equals(_o_.cur_course)) return false;
/* 69 */       if (this.daily_num != _o_.daily_num) return false;
/* 70 */       return true;
/*    */     }
/* 72 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 76 */     int _h_ = 0;
/* 77 */     _h_ += this.interest;
/* 78 */     _h_ += this.courses.hashCode();
/* 79 */     _h_ += this.cur_course.hashCode();
/* 80 */     _h_ += this.daily_num;
/* 81 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 85 */     StringBuilder _sb_ = new StringBuilder();
/* 86 */     _sb_.append("(");
/* 87 */     _sb_.append(this.interest).append(",");
/* 88 */     _sb_.append(this.courses).append(",");
/* 89 */     _sb_.append(this.cur_course).append(",");
/* 90 */     _sb_.append(this.daily_num).append(",");
/* 91 */     _sb_.append(")");
/* 92 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\ChildHoodInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */