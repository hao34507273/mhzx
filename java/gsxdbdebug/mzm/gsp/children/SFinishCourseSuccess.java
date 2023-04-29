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
/*    */ public class SFinishCourseSuccess
/*    */   extends __SFinishCourseSuccess__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12609302;
/*    */   public long childid;
/*    */   public StudyEffectInfo study_effect_info;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12609302;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SFinishCourseSuccess()
/*    */   {
/* 34 */     this.study_effect_info = new StudyEffectInfo();
/*    */   }
/*    */   
/*    */   public SFinishCourseSuccess(long _childid_, StudyEffectInfo _study_effect_info_) {
/* 38 */     this.childid = _childid_;
/* 39 */     this.study_effect_info = _study_effect_info_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     if (!this.study_effect_info._validator_()) return false;
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.childid);
/* 49 */     _os_.marshal(this.study_effect_info);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.childid = _os_.unmarshal_long();
/* 55 */     this.study_effect_info.unmarshal(_os_);
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof SFinishCourseSuccess)) {
/* 65 */       SFinishCourseSuccess _o_ = (SFinishCourseSuccess)_o1_;
/* 66 */       if (this.childid != _o_.childid) return false;
/* 67 */       if (!this.study_effect_info.equals(_o_.study_effect_info)) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += (int)this.childid;
/* 76 */     _h_ += this.study_effect_info.hashCode();
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.childid).append(",");
/* 84 */     _sb_.append(this.study_effect_info).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SFinishCourseSuccess _o_) {
/* 90 */     if (_o_ == this) return 0;
/* 91 */     int _c_ = 0;
/* 92 */     _c_ = Long.signum(this.childid - _o_.childid);
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     _c_ = this.study_effect_info.compareTo(_o_.study_effect_info);
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\SFinishCourseSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */