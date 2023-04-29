/*    */ package mzm.gsp.wanted;
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
/*    */ public class SQueryWantedRoleStatusError
/*    */   extends __SQueryWantedRoleStatusError__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12620303;
/*    */   public static final int ROLE_OFFLINE = 1;
/*    */   public static final int ROLE_CAN_NOT_BE_WANTED = 2;
/*    */   public int errorcode;
/*    */   public long roleid;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12620303;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SQueryWantedRoleStatusError() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SQueryWantedRoleStatusError(int _errorcode_, long _roleid_)
/*    */   {
/* 38 */     this.errorcode = _errorcode_;
/* 39 */     this.roleid = _roleid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.marshal(this.errorcode);
/* 48 */     _os_.marshal(this.roleid);
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 53 */     this.errorcode = _os_.unmarshal_int();
/* 54 */     this.roleid = _os_.unmarshal_long();
/* 55 */     if (!_validator_()) {
/* 56 */       throw new VerifyError("validator failed");
/*    */     }
/* 58 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 62 */     if (_o1_ == this) return true;
/* 63 */     if ((_o1_ instanceof SQueryWantedRoleStatusError)) {
/* 64 */       SQueryWantedRoleStatusError _o_ = (SQueryWantedRoleStatusError)_o1_;
/* 65 */       if (this.errorcode != _o_.errorcode) return false;
/* 66 */       if (this.roleid != _o_.roleid) return false;
/* 67 */       return true;
/*    */     }
/* 69 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 73 */     int _h_ = 0;
/* 74 */     _h_ += this.errorcode;
/* 75 */     _h_ += (int)this.roleid;
/* 76 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 80 */     StringBuilder _sb_ = new StringBuilder();
/* 81 */     _sb_.append("(");
/* 82 */     _sb_.append(this.errorcode).append(",");
/* 83 */     _sb_.append(this.roleid).append(",");
/* 84 */     _sb_.append(")");
/* 85 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SQueryWantedRoleStatusError _o_) {
/* 89 */     if (_o_ == this) return 0;
/* 90 */     int _c_ = 0;
/* 91 */     _c_ = this.errorcode - _o_.errorcode;
/* 92 */     if (0 != _c_) return _c_;
/* 93 */     _c_ = Long.signum(this.roleid - _o_.roleid);
/* 94 */     if (0 != _c_) return _c_;
/* 95 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wanted\SQueryWantedRoleStatusError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */