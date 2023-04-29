/*    */ package mzm.gsp.marriage;
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
/*    */ public class SBrocastEndParade
/*    */   extends __SBrocastEndParade__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12599842;
/*    */   public ParadeRoleInfo role1info;
/*    */   public ParadeRoleInfo role2info;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12599842;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SBrocastEndParade()
/*    */   {
/* 34 */     this.role1info = new ParadeRoleInfo();
/* 35 */     this.role2info = new ParadeRoleInfo();
/*    */   }
/*    */   
/*    */   public SBrocastEndParade(ParadeRoleInfo _role1info_, ParadeRoleInfo _role2info_) {
/* 39 */     this.role1info = _role1info_;
/* 40 */     this.role2info = _role2info_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 44 */     if (!this.role1info._validator_()) return false;
/* 45 */     if (!this.role2info._validator_()) return false;
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.role1info);
/* 51 */     _os_.marshal(this.role2info);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.role1info.unmarshal(_os_);
/* 57 */     this.role2info.unmarshal(_os_);
/* 58 */     if (!_validator_()) {
/* 59 */       throw new VerifyError("validator failed");
/*    */     }
/* 61 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 65 */     if (_o1_ == this) return true;
/* 66 */     if ((_o1_ instanceof SBrocastEndParade)) {
/* 67 */       SBrocastEndParade _o_ = (SBrocastEndParade)_o1_;
/* 68 */       if (!this.role1info.equals(_o_.role1info)) return false;
/* 69 */       if (!this.role2info.equals(_o_.role2info)) return false;
/* 70 */       return true;
/*    */     }
/* 72 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 76 */     int _h_ = 0;
/* 77 */     _h_ += this.role1info.hashCode();
/* 78 */     _h_ += this.role2info.hashCode();
/* 79 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 83 */     StringBuilder _sb_ = new StringBuilder();
/* 84 */     _sb_.append("(");
/* 85 */     _sb_.append(this.role1info).append(",");
/* 86 */     _sb_.append(this.role2info).append(",");
/* 87 */     _sb_.append(")");
/* 88 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\marriage\SBrocastEndParade.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */