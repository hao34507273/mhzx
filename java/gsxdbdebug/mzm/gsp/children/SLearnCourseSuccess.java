/*    */ package mzm.gsp.children;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SLearnCourseSuccess
/*    */   extends __SLearnCourseSuccess__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12609299;
/*    */   public long childid;
/*    */   public CourseStudyInfo course_info;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12609299;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SLearnCourseSuccess()
/*    */   {
/* 34 */     this.course_info = new CourseStudyInfo();
/*    */   }
/*    */   
/*    */   public SLearnCourseSuccess(long _childid_, CourseStudyInfo _course_info_) {
/* 38 */     this.childid = _childid_;
/* 39 */     this.course_info = _course_info_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     if (!this.course_info._validator_()) return false;
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.childid);
/* 49 */     _os_.marshal(this.course_info);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.childid = _os_.unmarshal_long();
/* 55 */     this.course_info.unmarshal(_os_);
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof SLearnCourseSuccess)) {
/* 65 */       SLearnCourseSuccess _o_ = (SLearnCourseSuccess)_o1_;
/* 66 */       if (this.childid != _o_.childid) return false;
/* 67 */       if (!this.course_info.equals(_o_.course_info)) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += (int)this.childid;
/* 76 */     _h_ += this.course_info.hashCode();
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.childid).append(",");
/* 84 */     _sb_.append(this.course_info).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SLearnCourseSuccess _o_) {
/* 90 */     if (_o_ == this) return 0;
/* 91 */     int _c_ = 0;
/* 92 */     _c_ = Long.signum(this.childid - _o_.childid);
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     _c_ = this.course_info.compareTo(_o_.course_info);
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\SLearnCourseSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */