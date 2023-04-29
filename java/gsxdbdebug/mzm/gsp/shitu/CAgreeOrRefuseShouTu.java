/*    */ package mzm.gsp.shitu;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.shitu.main.PCAgreeOrRefuseShouTu;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CAgreeOrRefuseShouTu
/*    */   extends __CAgreeOrRefuseShouTu__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12601606;
/*    */   public int operator;
/*    */   public long sessionid;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleId = Role.getRoleId(this);
/* 21 */     if (roleId < 0L) {
/* 22 */       return;
/*    */     }
/* 24 */     Role.addRoleProcedure(roleId, new PCAgreeOrRefuseShouTu(this.operator, roleId, this.sessionid));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 32 */     return 12601606;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CAgreeOrRefuseShouTu() {}
/*    */   
/*    */ 
/*    */   public CAgreeOrRefuseShouTu(int _operator_, long _sessionid_)
/*    */   {
/* 42 */     this.operator = _operator_;
/* 43 */     this.sessionid = _sessionid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.operator);
/* 52 */     _os_.marshal(this.sessionid);
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     this.operator = _os_.unmarshal_int();
/* 58 */     this.sessionid = _os_.unmarshal_long();
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof CAgreeOrRefuseShouTu)) {
/* 68 */       CAgreeOrRefuseShouTu _o_ = (CAgreeOrRefuseShouTu)_o1_;
/* 69 */       if (this.operator != _o_.operator) return false;
/* 70 */       if (this.sessionid != _o_.sessionid) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += this.operator;
/* 79 */     _h_ += (int)this.sessionid;
/* 80 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 84 */     StringBuilder _sb_ = new StringBuilder();
/* 85 */     _sb_.append("(");
/* 86 */     _sb_.append(this.operator).append(",");
/* 87 */     _sb_.append(this.sessionid).append(",");
/* 88 */     _sb_.append(")");
/* 89 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CAgreeOrRefuseShouTu _o_) {
/* 93 */     if (_o_ == this) return 0;
/* 94 */     int _c_ = 0;
/* 95 */     _c_ = this.operator - _o_.operator;
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     _c_ = Long.signum(this.sessionid - _o_.sessionid);
/* 98 */     if (0 != _c_) return _c_;
/* 99 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\CAgreeOrRefuseShouTu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */