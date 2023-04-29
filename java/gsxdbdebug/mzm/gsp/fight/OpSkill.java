/*    */ package mzm.gsp.fight;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ public class OpSkill
/*    */   implements Marshal, Comparable<OpSkill>
/*    */ {
/*    */   public int skill;
/*    */   public int main_target;
/*    */   
/*    */   public OpSkill() {}
/*    */   
/*    */   public OpSkill(int _skill_, int _main_target_)
/*    */   {
/* 18 */     this.skill = _skill_;
/* 19 */     this.main_target = _main_target_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 23 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 27 */     _os_.marshal(this.skill);
/* 28 */     _os_.marshal(this.main_target);
/* 29 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 33 */     this.skill = _os_.unmarshal_int();
/* 34 */     this.main_target = _os_.unmarshal_int();
/* 35 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 39 */     if (_o1_ == this) return true;
/* 40 */     if ((_o1_ instanceof OpSkill)) {
/* 41 */       OpSkill _o_ = (OpSkill)_o1_;
/* 42 */       if (this.skill != _o_.skill) return false;
/* 43 */       if (this.main_target != _o_.main_target) return false;
/* 44 */       return true;
/*    */     }
/* 46 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 50 */     int _h_ = 0;
/* 51 */     _h_ += this.skill;
/* 52 */     _h_ += this.main_target;
/* 53 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 57 */     StringBuilder _sb_ = new StringBuilder();
/* 58 */     _sb_.append("(");
/* 59 */     _sb_.append(this.skill).append(",");
/* 60 */     _sb_.append(this.main_target).append(",");
/* 61 */     _sb_.append(")");
/* 62 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(OpSkill _o_) {
/* 66 */     if (_o_ == this) return 0;
/* 67 */     int _c_ = 0;
/* 68 */     _c_ = this.skill - _o_.skill;
/* 69 */     if (0 != _c_) return _c_;
/* 70 */     _c_ = this.main_target - _o_.main_target;
/* 71 */     if (0 != _c_) return _c_;
/* 72 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\OpSkill.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */