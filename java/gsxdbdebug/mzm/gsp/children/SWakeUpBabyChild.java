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
/*    */ public class SWakeUpBabyChild
/*    */   extends __SWakeUpBabyChild__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12609315;
/*    */   public long child_id;
/*    */   public int now_tired_value;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12609315;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SWakeUpBabyChild() {}
/*    */   
/*    */ 
/*    */   public SWakeUpBabyChild(long _child_id_, int _now_tired_value_)
/*    */   {
/* 37 */     this.child_id = _child_id_;
/* 38 */     this.now_tired_value = _now_tired_value_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.child_id);
/* 47 */     _os_.marshal(this.now_tired_value);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.child_id = _os_.unmarshal_long();
/* 53 */     this.now_tired_value = _os_.unmarshal_int();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SWakeUpBabyChild)) {
/* 63 */       SWakeUpBabyChild _o_ = (SWakeUpBabyChild)_o1_;
/* 64 */       if (this.child_id != _o_.child_id) return false;
/* 65 */       if (this.now_tired_value != _o_.now_tired_value) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += (int)this.child_id;
/* 74 */     _h_ += this.now_tired_value;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.child_id).append(",");
/* 82 */     _sb_.append(this.now_tired_value).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SWakeUpBabyChild _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = Long.signum(this.child_id - _o_.child_id);
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = this.now_tired_value - _o_.now_tired_value;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\SWakeUpBabyChild.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */