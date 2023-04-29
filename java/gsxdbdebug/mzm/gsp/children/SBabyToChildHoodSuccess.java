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
/*    */ public class SBabyToChildHoodSuccess
/*    */   extends __SBabyToChildHoodSuccess__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12609337;
/*    */   public long child_id;
/*    */   public ChildBean child_bean;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12609337;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SBabyToChildHoodSuccess()
/*    */   {
/* 34 */     this.child_bean = new ChildBean();
/*    */   }
/*    */   
/*    */   public SBabyToChildHoodSuccess(long _child_id_, ChildBean _child_bean_) {
/* 38 */     this.child_id = _child_id_;
/* 39 */     this.child_bean = _child_bean_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     if (!this.child_bean._validator_()) return false;
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.child_id);
/* 49 */     _os_.marshal(this.child_bean);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.child_id = _os_.unmarshal_long();
/* 55 */     this.child_bean.unmarshal(_os_);
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof SBabyToChildHoodSuccess)) {
/* 65 */       SBabyToChildHoodSuccess _o_ = (SBabyToChildHoodSuccess)_o1_;
/* 66 */       if (this.child_id != _o_.child_id) return false;
/* 67 */       if (!this.child_bean.equals(_o_.child_bean)) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += (int)this.child_id;
/* 76 */     _h_ += this.child_bean.hashCode();
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.child_id).append(",");
/* 84 */     _sb_.append(this.child_bean).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\SBabyToChildHoodSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */