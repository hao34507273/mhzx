/*    */ package mzm.gsp.question;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class AllMoveSteps implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public ArrayList<MoveStep> steps;
/*    */   
/*    */   public AllMoveSteps()
/*    */   {
/* 12 */     this.steps = new ArrayList();
/*    */   }
/*    */   
/*    */   public AllMoveSteps(ArrayList<MoveStep> _steps_) {
/* 16 */     this.steps = _steps_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 20 */     for (MoveStep _v_ : this.steps)
/* 21 */       if (!_v_._validator_()) return false;
/* 22 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 26 */     _os_.compact_uint32(this.steps.size());
/* 27 */     for (MoveStep _v_ : this.steps) {
/* 28 */       _os_.marshal(_v_);
/*    */     }
/* 30 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 34 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 35 */       MoveStep _v_ = new MoveStep();
/* 36 */       _v_.unmarshal(_os_);
/* 37 */       this.steps.add(_v_);
/*    */     }
/* 39 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 43 */     if (_o1_ == this) return true;
/* 44 */     if ((_o1_ instanceof AllMoveSteps)) {
/* 45 */       AllMoveSteps _o_ = (AllMoveSteps)_o1_;
/* 46 */       if (!this.steps.equals(_o_.steps)) return false;
/* 47 */       return true;
/*    */     }
/* 49 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 53 */     int _h_ = 0;
/* 54 */     _h_ += this.steps.hashCode();
/* 55 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 59 */     StringBuilder _sb_ = new StringBuilder();
/* 60 */     _sb_.append("(");
/* 61 */     _sb_.append(this.steps).append(",");
/* 62 */     _sb_.append(")");
/* 63 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\AllMoveSteps.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */