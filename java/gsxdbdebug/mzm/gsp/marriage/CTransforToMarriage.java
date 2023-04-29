/*    */ package mzm.gsp.marriage;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.marriage.main.PCTransforToMarrage;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CTransforToMarriage
/*    */   extends __CTransforToMarriage__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12599819;
/*    */   public long roleid;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long operRoleid = Role.getRoleId(this);
/* 20 */     Role.addRoleProcedure(operRoleid, new PCTransforToMarrage(operRoleid, this.roleid));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 28 */     return 12599819;
/*    */   }
/*    */   
/*    */ 
/*    */   public CTransforToMarriage() {}
/*    */   
/*    */ 
/*    */   public CTransforToMarriage(long _roleid_)
/*    */   {
/* 37 */     this.roleid = _roleid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 45 */     _os_.marshal(this.roleid);
/* 46 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 50 */     this.roleid = _os_.unmarshal_long();
/* 51 */     if (!_validator_()) {
/* 52 */       throw new VerifyError("validator failed");
/*    */     }
/* 54 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 58 */     if (_o1_ == this) return true;
/* 59 */     if ((_o1_ instanceof CTransforToMarriage)) {
/* 60 */       CTransforToMarriage _o_ = (CTransforToMarriage)_o1_;
/* 61 */       if (this.roleid != _o_.roleid) return false;
/* 62 */       return true;
/*    */     }
/* 64 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 68 */     int _h_ = 0;
/* 69 */     _h_ += (int)this.roleid;
/* 70 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 74 */     StringBuilder _sb_ = new StringBuilder();
/* 75 */     _sb_.append("(");
/* 76 */     _sb_.append(this.roleid).append(",");
/* 77 */     _sb_.append(")");
/* 78 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CTransforToMarriage _o_) {
/* 82 */     if (_o_ == this) return 0;
/* 83 */     int _c_ = 0;
/* 84 */     _c_ = Long.signum(this.roleid - _o_.roleid);
/* 85 */     if (0 != _c_) return _c_;
/* 86 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\marriage\CTransforToMarriage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */