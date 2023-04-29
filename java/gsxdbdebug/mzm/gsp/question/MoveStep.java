/*    */ package mzm.gsp.question;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ public class MoveStep
/*    */   implements Marshal, Comparable<MoveStep>
/*    */ {
/*    */   public int resourceno;
/*    */   public int targetpos;
/*    */   
/*    */   public MoveStep() {}
/*    */   
/*    */   public MoveStep(int _resourceno_, int _targetpos_)
/*    */   {
/* 18 */     this.resourceno = _resourceno_;
/* 19 */     this.targetpos = _targetpos_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 23 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 27 */     _os_.marshal(this.resourceno);
/* 28 */     _os_.marshal(this.targetpos);
/* 29 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 33 */     this.resourceno = _os_.unmarshal_int();
/* 34 */     this.targetpos = _os_.unmarshal_int();
/* 35 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 39 */     if (_o1_ == this) return true;
/* 40 */     if ((_o1_ instanceof MoveStep)) {
/* 41 */       MoveStep _o_ = (MoveStep)_o1_;
/* 42 */       if (this.resourceno != _o_.resourceno) return false;
/* 43 */       if (this.targetpos != _o_.targetpos) return false;
/* 44 */       return true;
/*    */     }
/* 46 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 50 */     int _h_ = 0;
/* 51 */     _h_ += this.resourceno;
/* 52 */     _h_ += this.targetpos;
/* 53 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 57 */     StringBuilder _sb_ = new StringBuilder();
/* 58 */     _sb_.append("(");
/* 59 */     _sb_.append(this.resourceno).append(",");
/* 60 */     _sb_.append(this.targetpos).append(",");
/* 61 */     _sb_.append(")");
/* 62 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(MoveStep _o_) {
/* 66 */     if (_o_ == this) return 0;
/* 67 */     int _c_ = 0;
/* 68 */     _c_ = this.resourceno - _o_.resourceno;
/* 69 */     if (0 != _c_) return _c_;
/* 70 */     _c_ = this.targetpos - _o_.targetpos;
/* 71 */     if (0 != _c_) return _c_;
/* 72 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\MoveStep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */