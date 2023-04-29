/*    */ package mzm.gsp.pk;
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
/*    */ public class SQueryRoleNameRes
/*    */   extends __SQueryRoleNameRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12619803;
/*    */   public Octets role_name;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12619803;
/*    */   }
/*    */   
/*    */ 
/*    */   public SQueryRoleNameRes()
/*    */   {
/* 31 */     this.role_name = new Octets();
/*    */   }
/*    */   
/*    */   public SQueryRoleNameRes(Octets _role_name_) {
/* 35 */     this.role_name = _role_name_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 39 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 43 */     _os_.marshal(this.role_name);
/* 44 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 48 */     this.role_name = _os_.unmarshal_Octets();
/* 49 */     if (!_validator_()) {
/* 50 */       throw new VerifyError("validator failed");
/*    */     }
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 56 */     if (_o1_ == this) return true;
/* 57 */     if ((_o1_ instanceof SQueryRoleNameRes)) {
/* 58 */       SQueryRoleNameRes _o_ = (SQueryRoleNameRes)_o1_;
/* 59 */       if (!this.role_name.equals(_o_.role_name)) return false;
/* 60 */       return true;
/*    */     }
/* 62 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 66 */     int _h_ = 0;
/* 67 */     _h_ += this.role_name.hashCode();
/* 68 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 72 */     StringBuilder _sb_ = new StringBuilder();
/* 73 */     _sb_.append("(");
/* 74 */     _sb_.append("B").append(this.role_name.size()).append(",");
/* 75 */     _sb_.append(")");
/* 76 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pk\SQueryRoleNameRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */