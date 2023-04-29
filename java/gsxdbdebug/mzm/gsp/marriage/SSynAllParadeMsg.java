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
/*    */ public class SSynAllParadeMsg
/*    */   extends __SSynAllParadeMsg__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12599861;
/*    */   public ParadeRoleInfo role1info;
/*    */   public ParadeRoleInfo role2info;
/*    */   public int paradecfgid;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12599861;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SSynAllParadeMsg()
/*    */   {
/* 35 */     this.role1info = new ParadeRoleInfo();
/* 36 */     this.role2info = new ParadeRoleInfo();
/*    */   }
/*    */   
/*    */   public SSynAllParadeMsg(ParadeRoleInfo _role1info_, ParadeRoleInfo _role2info_, int _paradecfgid_) {
/* 40 */     this.role1info = _role1info_;
/* 41 */     this.role2info = _role2info_;
/* 42 */     this.paradecfgid = _paradecfgid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 46 */     if (!this.role1info._validator_()) return false;
/* 47 */     if (!this.role2info._validator_()) return false;
/* 48 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 52 */     _os_.marshal(this.role1info);
/* 53 */     _os_.marshal(this.role2info);
/* 54 */     _os_.marshal(this.paradecfgid);
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 59 */     this.role1info.unmarshal(_os_);
/* 60 */     this.role2info.unmarshal(_os_);
/* 61 */     this.paradecfgid = _os_.unmarshal_int();
/* 62 */     if (!_validator_()) {
/* 63 */       throw new VerifyError("validator failed");
/*    */     }
/* 65 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 69 */     if (_o1_ == this) return true;
/* 70 */     if ((_o1_ instanceof SSynAllParadeMsg)) {
/* 71 */       SSynAllParadeMsg _o_ = (SSynAllParadeMsg)_o1_;
/* 72 */       if (!this.role1info.equals(_o_.role1info)) return false;
/* 73 */       if (!this.role2info.equals(_o_.role2info)) return false;
/* 74 */       if (this.paradecfgid != _o_.paradecfgid) return false;
/* 75 */       return true;
/*    */     }
/* 77 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 81 */     int _h_ = 0;
/* 82 */     _h_ += this.role1info.hashCode();
/* 83 */     _h_ += this.role2info.hashCode();
/* 84 */     _h_ += this.paradecfgid;
/* 85 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 89 */     StringBuilder _sb_ = new StringBuilder();
/* 90 */     _sb_.append("(");
/* 91 */     _sb_.append(this.role1info).append(",");
/* 92 */     _sb_.append(this.role2info).append(",");
/* 93 */     _sb_.append(this.paradecfgid).append(",");
/* 94 */     _sb_.append(")");
/* 95 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\marriage\SSynAllParadeMsg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */