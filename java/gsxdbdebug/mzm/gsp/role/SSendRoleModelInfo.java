/*    */ package mzm.gsp.role;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.pubdata.ModelInfo;
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
/*    */ public class SSendRoleModelInfo
/*    */   extends __SSendRoleModelInfo__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12586028;
/*    */   public long targetroleid;
/*    */   public ModelInfo model;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12586028;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SSendRoleModelInfo()
/*    */   {
/* 34 */     this.model = new ModelInfo();
/*    */   }
/*    */   
/*    */   public SSendRoleModelInfo(long _targetroleid_, ModelInfo _model_) {
/* 38 */     this.targetroleid = _targetroleid_;
/* 39 */     this.model = _model_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     if (!this.model._validator_()) return false;
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.targetroleid);
/* 49 */     _os_.marshal(this.model);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.targetroleid = _os_.unmarshal_long();
/* 55 */     this.model.unmarshal(_os_);
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof SSendRoleModelInfo)) {
/* 65 */       SSendRoleModelInfo _o_ = (SSendRoleModelInfo)_o1_;
/* 66 */       if (this.targetroleid != _o_.targetroleid) return false;
/* 67 */       if (!this.model.equals(_o_.model)) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += (int)this.targetroleid;
/* 76 */     _h_ += this.model.hashCode();
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.targetroleid).append(",");
/* 84 */     _sb_.append(this.model).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\SSendRoleModelInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */