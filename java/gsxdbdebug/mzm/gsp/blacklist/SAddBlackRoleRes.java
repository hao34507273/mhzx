/*    */ package mzm.gsp.blacklist;
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
/*    */ 
/*    */ public class SAddBlackRoleRes
/*    */   extends __SAddBlackRoleRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12588548;
/*    */   public BlackRole black_role;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12588548;
/*    */   }
/*    */   
/*    */ 
/*    */   public SAddBlackRoleRes()
/*    */   {
/* 33 */     this.black_role = new BlackRole();
/*    */   }
/*    */   
/*    */   public SAddBlackRoleRes(BlackRole _black_role_) {
/* 37 */     this.black_role = _black_role_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     if (!this.black_role._validator_()) return false;
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.black_role);
/* 47 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 51 */     this.black_role.unmarshal(_os_);
/* 52 */     if (!_validator_()) {
/* 53 */       throw new VerifyError("validator failed");
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 59 */     if (_o1_ == this) return true;
/* 60 */     if ((_o1_ instanceof SAddBlackRoleRes)) {
/* 61 */       SAddBlackRoleRes _o_ = (SAddBlackRoleRes)_o1_;
/* 62 */       if (!this.black_role.equals(_o_.black_role)) return false;
/* 63 */       return true;
/*    */     }
/* 65 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 69 */     int _h_ = 0;
/* 70 */     _h_ += this.black_role.hashCode();
/* 71 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 75 */     StringBuilder _sb_ = new StringBuilder();
/* 76 */     _sb_.append("(");
/* 77 */     _sb_.append(this.black_role).append(",");
/* 78 */     _sb_.append(")");
/* 79 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\blacklist\SAddBlackRoleRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */