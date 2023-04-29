/*    */ package mzm.gsp.children;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.children.childhood.PCLearnCourse;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CLearnCourse
/*    */   extends __CLearnCourse__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12609298;
/*    */   public long childid;
/*    */   public int course_type;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     if (roleId < 1L)
/*    */     {
/* 22 */       return;
/*    */     }
/* 24 */     Role.addRoleProcedure(roleId, new PCLearnCourse(roleId, this.childid, this.course_type));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 32 */     return 12609298;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CLearnCourse() {}
/*    */   
/*    */ 
/*    */   public CLearnCourse(long _childid_, int _course_type_)
/*    */   {
/* 42 */     this.childid = _childid_;
/* 43 */     this.course_type = _course_type_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.childid);
/* 52 */     _os_.marshal(this.course_type);
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     this.childid = _os_.unmarshal_long();
/* 58 */     this.course_type = _os_.unmarshal_int();
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof CLearnCourse)) {
/* 68 */       CLearnCourse _o_ = (CLearnCourse)_o1_;
/* 69 */       if (this.childid != _o_.childid) return false;
/* 70 */       if (this.course_type != _o_.course_type) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += (int)this.childid;
/* 79 */     _h_ += this.course_type;
/* 80 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 84 */     StringBuilder _sb_ = new StringBuilder();
/* 85 */     _sb_.append("(");
/* 86 */     _sb_.append(this.childid).append(",");
/* 87 */     _sb_.append(this.course_type).append(",");
/* 88 */     _sb_.append(")");
/* 89 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CLearnCourse _o_) {
/* 93 */     if (_o_ == this) return 0;
/* 94 */     int _c_ = 0;
/* 95 */     _c_ = Long.signum(this.childid - _o_.childid);
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     _c_ = this.course_type - _o_.course_type;
/* 98 */     if (0 != _c_) return _c_;
/* 99 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\CLearnCourse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */