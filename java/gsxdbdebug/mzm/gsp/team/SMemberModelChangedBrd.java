/*    */ package mzm.gsp.team;
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
/*    */ public class SMemberModelChangedBrd
/*    */   extends __SMemberModelChangedBrd__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12588333;
/*    */   public long roleid;
/*    */   public ModelInfo model;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12588333;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SMemberModelChangedBrd()
/*    */   {
/* 34 */     this.model = new ModelInfo();
/*    */   }
/*    */   
/*    */   public SMemberModelChangedBrd(long _roleid_, ModelInfo _model_) {
/* 38 */     this.roleid = _roleid_;
/* 39 */     this.model = _model_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     if (!this.model._validator_()) return false;
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.roleid);
/* 49 */     _os_.marshal(this.model);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.roleid = _os_.unmarshal_long();
/* 55 */     this.model.unmarshal(_os_);
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof SMemberModelChangedBrd)) {
/* 65 */       SMemberModelChangedBrd _o_ = (SMemberModelChangedBrd)_o1_;
/* 66 */       if (this.roleid != _o_.roleid) return false;
/* 67 */       if (!this.model.equals(_o_.model)) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += (int)this.roleid;
/* 76 */     _h_ += this.model.hashCode();
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.roleid).append(",");
/* 84 */     _sb_.append(this.model).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\SMemberModelChangedBrd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */