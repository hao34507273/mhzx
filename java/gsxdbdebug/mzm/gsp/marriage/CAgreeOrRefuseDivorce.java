/*    */ package mzm.gsp.marriage;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.marriage.main.PCAgreeOrRefuseDivorce;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CAgreeOrRefuseDivorce
/*    */   extends __CAgreeOrRefuseDivorce__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12599820;
/*    */   public int operator;
/*    */   public long sessionid;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleid = Role.getRoleId(this);
/* 20 */     Role.addRoleProcedure(roleid, new PCAgreeOrRefuseDivorce(roleid, this.sessionid, this.operator));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 29 */     return 12599820;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CAgreeOrRefuseDivorce() {}
/*    */   
/*    */ 
/*    */   public CAgreeOrRefuseDivorce(int _operator_, long _sessionid_)
/*    */   {
/* 39 */     this.operator = _operator_;
/* 40 */     this.sessionid = _sessionid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.operator);
/* 49 */     _os_.marshal(this.sessionid);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.operator = _os_.unmarshal_int();
/* 55 */     this.sessionid = _os_.unmarshal_long();
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof CAgreeOrRefuseDivorce)) {
/* 65 */       CAgreeOrRefuseDivorce _o_ = (CAgreeOrRefuseDivorce)_o1_;
/* 66 */       if (this.operator != _o_.operator) return false;
/* 67 */       if (this.sessionid != _o_.sessionid) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += this.operator;
/* 76 */     _h_ += (int)this.sessionid;
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.operator).append(",");
/* 84 */     _sb_.append(this.sessionid).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CAgreeOrRefuseDivorce _o_) {
/* 90 */     if (_o_ == this) return 0;
/* 91 */     int _c_ = 0;
/* 92 */     _c_ = this.operator - _o_.operator;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     _c_ = Long.signum(this.sessionid - _o_.sessionid);
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\marriage\CAgreeOrRefuseDivorce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */