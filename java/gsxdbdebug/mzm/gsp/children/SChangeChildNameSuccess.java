/*    */ package mzm.gsp.children;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
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
/*    */ public class SChangeChildNameSuccess
/*    */   extends __SChangeChildNameSuccess__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12609332;
/*    */   public long child_id;
/*    */   public Octets child_new_name;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12609332;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SChangeChildNameSuccess()
/*    */   {
/* 34 */     this.child_new_name = new Octets();
/*    */   }
/*    */   
/*    */   public SChangeChildNameSuccess(long _child_id_, Octets _child_new_name_) {
/* 38 */     this.child_id = _child_id_;
/* 39 */     this.child_new_name = _child_new_name_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.marshal(this.child_id);
/* 48 */     _os_.marshal(this.child_new_name);
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 53 */     this.child_id = _os_.unmarshal_long();
/* 54 */     this.child_new_name = _os_.unmarshal_Octets();
/* 55 */     if (!_validator_()) {
/* 56 */       throw new VerifyError("validator failed");
/*    */     }
/* 58 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 62 */     if (_o1_ == this) return true;
/* 63 */     if ((_o1_ instanceof SChangeChildNameSuccess)) {
/* 64 */       SChangeChildNameSuccess _o_ = (SChangeChildNameSuccess)_o1_;
/* 65 */       if (this.child_id != _o_.child_id) return false;
/* 66 */       if (!this.child_new_name.equals(_o_.child_new_name)) return false;
/* 67 */       return true;
/*    */     }
/* 69 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 73 */     int _h_ = 0;
/* 74 */     _h_ += (int)this.child_id;
/* 75 */     _h_ += this.child_new_name.hashCode();
/* 76 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 80 */     StringBuilder _sb_ = new StringBuilder();
/* 81 */     _sb_.append("(");
/* 82 */     _sb_.append(this.child_id).append(",");
/* 83 */     _sb_.append("B").append(this.child_new_name.size()).append(",");
/* 84 */     _sb_.append(")");
/* 85 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\SChangeChildNameSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */