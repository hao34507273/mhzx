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
/*    */ 
/*    */ public class SChildhoodToAdultSuccess
/*    */   extends __SChildhoodToAdultSuccess__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12609346;
/*    */   public ChildBean child_info;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12609346;
/*    */   }
/*    */   
/*    */ 
/*    */   public SChildhoodToAdultSuccess()
/*    */   {
/* 33 */     this.child_info = new ChildBean();
/*    */   }
/*    */   
/*    */   public SChildhoodToAdultSuccess(ChildBean _child_info_) {
/* 37 */     this.child_info = _child_info_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     if (!this.child_info._validator_()) return false;
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.child_info);
/* 47 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 51 */     this.child_info.unmarshal(_os_);
/* 52 */     if (!_validator_()) {
/* 53 */       throw new VerifyError("validator failed");
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 59 */     if (_o1_ == this) return true;
/* 60 */     if ((_o1_ instanceof SChildhoodToAdultSuccess)) {
/* 61 */       SChildhoodToAdultSuccess _o_ = (SChildhoodToAdultSuccess)_o1_;
/* 62 */       if (!this.child_info.equals(_o_.child_info)) return false;
/* 63 */       return true;
/*    */     }
/* 65 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 69 */     int _h_ = 0;
/* 70 */     _h_ += this.child_info.hashCode();
/* 71 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 75 */     StringBuilder _sb_ = new StringBuilder();
/* 76 */     _sb_.append("(");
/* 77 */     _sb_.append(this.child_info).append(",");
/* 78 */     _sb_.append(")");
/* 79 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\SChildhoodToAdultSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */