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
/*    */ public class SBrocastRobMarriageParadeEnd
/*    */   extends __SBrocastRobMarriageParadeEnd__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12599856;
/*    */   public static final int YES = 1;
/*    */   public static final int NO = 2;
/*    */   public ParadeRoleInfo role1info;
/*    */   public ParadeRoleInfo role2info;
/*    */   public int result;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12599856;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SBrocastRobMarriageParadeEnd()
/*    */   {
/* 38 */     this.role1info = new ParadeRoleInfo();
/* 39 */     this.role2info = new ParadeRoleInfo();
/*    */   }
/*    */   
/*    */   public SBrocastRobMarriageParadeEnd(ParadeRoleInfo _role1info_, ParadeRoleInfo _role2info_, int _result_) {
/* 43 */     this.role1info = _role1info_;
/* 44 */     this.role2info = _role2info_;
/* 45 */     this.result = _result_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 49 */     if (!this.role1info._validator_()) return false;
/* 50 */     if (!this.role2info._validator_()) return false;
/* 51 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 55 */     _os_.marshal(this.role1info);
/* 56 */     _os_.marshal(this.role2info);
/* 57 */     _os_.marshal(this.result);
/* 58 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 62 */     this.role1info.unmarshal(_os_);
/* 63 */     this.role2info.unmarshal(_os_);
/* 64 */     this.result = _os_.unmarshal_int();
/* 65 */     if (!_validator_()) {
/* 66 */       throw new VerifyError("validator failed");
/*    */     }
/* 68 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 72 */     if (_o1_ == this) return true;
/* 73 */     if ((_o1_ instanceof SBrocastRobMarriageParadeEnd)) {
/* 74 */       SBrocastRobMarriageParadeEnd _o_ = (SBrocastRobMarriageParadeEnd)_o1_;
/* 75 */       if (!this.role1info.equals(_o_.role1info)) return false;
/* 76 */       if (!this.role2info.equals(_o_.role2info)) return false;
/* 77 */       if (this.result != _o_.result) return false;
/* 78 */       return true;
/*    */     }
/* 80 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 84 */     int _h_ = 0;
/* 85 */     _h_ += this.role1info.hashCode();
/* 86 */     _h_ += this.role2info.hashCode();
/* 87 */     _h_ += this.result;
/* 88 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 92 */     StringBuilder _sb_ = new StringBuilder();
/* 93 */     _sb_.append("(");
/* 94 */     _sb_.append(this.role1info).append(",");
/* 95 */     _sb_.append(this.role2info).append(",");
/* 96 */     _sb_.append(this.result).append(",");
/* 97 */     _sb_.append(")");
/* 98 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\marriage\SBrocastRobMarriageParadeEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */