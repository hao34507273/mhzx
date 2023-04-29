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
/*    */ public class SAddChild
/*    */   extends __SAddChild__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12609339;
/*    */   public long child_id;
/*    */   public ChildBean child_info;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12609339;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SAddChild()
/*    */   {
/* 34 */     this.child_info = new ChildBean();
/*    */   }
/*    */   
/*    */   public SAddChild(long _child_id_, ChildBean _child_info_) {
/* 38 */     this.child_id = _child_id_;
/* 39 */     this.child_info = _child_info_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     if (!this.child_info._validator_()) return false;
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.child_id);
/* 49 */     _os_.marshal(this.child_info);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.child_id = _os_.unmarshal_long();
/* 55 */     this.child_info.unmarshal(_os_);
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof SAddChild)) {
/* 65 */       SAddChild _o_ = (SAddChild)_o1_;
/* 66 */       if (this.child_id != _o_.child_id) return false;
/* 67 */       if (!this.child_info.equals(_o_.child_info)) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += (int)this.child_id;
/* 76 */     _h_ += this.child_info.hashCode();
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.child_id).append(",");
/* 84 */     _sb_.append(this.child_info).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\SAddChild.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */