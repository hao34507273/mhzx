/*    */ package mzm.gsp.children;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ public class StudyEffectInfo
/*    */   implements Marshal, Comparable<StudyEffectInfo>
/*    */ {
/*    */   public int course_type;
/*    */   public byte is_crit;
/*    */   
/*    */   public StudyEffectInfo() {}
/*    */   
/*    */   public StudyEffectInfo(int _course_type_, byte _is_crit_)
/*    */   {
/* 18 */     this.course_type = _course_type_;
/* 19 */     this.is_crit = _is_crit_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 23 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 27 */     _os_.marshal(this.course_type);
/* 28 */     _os_.marshal(this.is_crit);
/* 29 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 33 */     this.course_type = _os_.unmarshal_int();
/* 34 */     this.is_crit = _os_.unmarshal_byte();
/* 35 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 39 */     if (_o1_ == this) return true;
/* 40 */     if ((_o1_ instanceof StudyEffectInfo)) {
/* 41 */       StudyEffectInfo _o_ = (StudyEffectInfo)_o1_;
/* 42 */       if (this.course_type != _o_.course_type) return false;
/* 43 */       if (this.is_crit != _o_.is_crit) return false;
/* 44 */       return true;
/*    */     }
/* 46 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 50 */     int _h_ = 0;
/* 51 */     _h_ += this.course_type;
/* 52 */     _h_ += this.is_crit;
/* 53 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 57 */     StringBuilder _sb_ = new StringBuilder();
/* 58 */     _sb_.append("(");
/* 59 */     _sb_.append(this.course_type).append(",");
/* 60 */     _sb_.append(this.is_crit).append(",");
/* 61 */     _sb_.append(")");
/* 62 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(StudyEffectInfo _o_) {
/* 66 */     if (_o_ == this) return 0;
/* 67 */     int _c_ = 0;
/* 68 */     _c_ = this.course_type - _o_.course_type;
/* 69 */     if (0 != _c_) return _c_;
/* 70 */     _c_ = this.is_crit - _o_.is_crit;
/* 71 */     if (0 != _c_) return _c_;
/* 72 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\StudyEffectInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */