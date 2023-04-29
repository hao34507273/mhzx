/*    */ package mzm.gsp.gang;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.gang.main.PDesignDutyNameReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CDesignDutyNameReq
/*    */   extends __CDesignDutyNameReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12589885;
/*    */   public int designcaseid;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/*    */     
/* 21 */     Role.addRoleProcedure(roleId, new PDesignDutyNameReq(roleId, this.designcaseid));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 31 */     return 12589885;
/*    */   }
/*    */   
/*    */ 
/*    */   public CDesignDutyNameReq() {}
/*    */   
/*    */ 
/*    */   public CDesignDutyNameReq(int _designcaseid_)
/*    */   {
/* 40 */     this.designcaseid = _designcaseid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.designcaseid);
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 53 */     this.designcaseid = _os_.unmarshal_int();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof CDesignDutyNameReq)) {
/* 63 */       CDesignDutyNameReq _o_ = (CDesignDutyNameReq)_o1_;
/* 64 */       if (this.designcaseid != _o_.designcaseid) return false;
/* 65 */       return true;
/*    */     }
/* 67 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 71 */     int _h_ = 0;
/* 72 */     _h_ += this.designcaseid;
/* 73 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 77 */     StringBuilder _sb_ = new StringBuilder();
/* 78 */     _sb_.append("(");
/* 79 */     _sb_.append(this.designcaseid).append(",");
/* 80 */     _sb_.append(")");
/* 81 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CDesignDutyNameReq _o_) {
/* 85 */     if (_o_ == this) return 0;
/* 86 */     int _c_ = 0;
/* 87 */     _c_ = this.designcaseid - _o_.designcaseid;
/* 88 */     if (0 != _c_) return _c_;
/* 89 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\CDesignDutyNameReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */