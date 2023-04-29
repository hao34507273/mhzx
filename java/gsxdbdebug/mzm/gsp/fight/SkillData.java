/*    */ package mzm.gsp.fight;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ public class SkillData
/*    */   implements Marshal, Comparable<SkillData>
/*    */ {
/*    */   public int skillusecount;
/*    */   public int skilluseround;
/*    */   
/*    */   public SkillData() {}
/*    */   
/*    */   public SkillData(int _skillusecount_, int _skilluseround_)
/*    */   {
/* 18 */     this.skillusecount = _skillusecount_;
/* 19 */     this.skilluseround = _skilluseround_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 23 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 27 */     _os_.marshal(this.skillusecount);
/* 28 */     _os_.marshal(this.skilluseround);
/* 29 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 33 */     this.skillusecount = _os_.unmarshal_int();
/* 34 */     this.skilluseround = _os_.unmarshal_int();
/* 35 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 39 */     if (_o1_ == this) return true;
/* 40 */     if ((_o1_ instanceof SkillData)) {
/* 41 */       SkillData _o_ = (SkillData)_o1_;
/* 42 */       if (this.skillusecount != _o_.skillusecount) return false;
/* 43 */       if (this.skilluseround != _o_.skilluseround) return false;
/* 44 */       return true;
/*    */     }
/* 46 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 50 */     int _h_ = 0;
/* 51 */     _h_ += this.skillusecount;
/* 52 */     _h_ += this.skilluseround;
/* 53 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 57 */     StringBuilder _sb_ = new StringBuilder();
/* 58 */     _sb_.append("(");
/* 59 */     _sb_.append(this.skillusecount).append(",");
/* 60 */     _sb_.append(this.skilluseround).append(",");
/* 61 */     _sb_.append(")");
/* 62 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SkillData _o_) {
/* 66 */     if (_o_ == this) return 0;
/* 67 */     int _c_ = 0;
/* 68 */     _c_ = this.skillusecount - _o_.skillusecount;
/* 69 */     if (0 != _c_) return _c_;
/* 70 */     _c_ = this.skilluseround - _o_.skilluseround;
/* 71 */     if (0 != _c_) return _c_;
/* 72 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\SkillData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */