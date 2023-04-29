/*    */ package mzm.gsp.teamplatform;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.role.RoleInfo;
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
/*    */ public class SRoleMatchSuc
/*    */   extends __SRoleMatchSuc__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12593668;
/*    */   public RoleInfo teamleaderinfo;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12593668;
/*    */   }
/*    */   
/*    */ 
/*    */   public SRoleMatchSuc()
/*    */   {
/* 33 */     this.teamleaderinfo = new RoleInfo();
/*    */   }
/*    */   
/*    */   public SRoleMatchSuc(RoleInfo _teamleaderinfo_) {
/* 37 */     this.teamleaderinfo = _teamleaderinfo_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     if (!this.teamleaderinfo._validator_()) return false;
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.teamleaderinfo);
/* 47 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 51 */     this.teamleaderinfo.unmarshal(_os_);
/* 52 */     if (!_validator_()) {
/* 53 */       throw new VerifyError("validator failed");
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 59 */     if (_o1_ == this) return true;
/* 60 */     if ((_o1_ instanceof SRoleMatchSuc)) {
/* 61 */       SRoleMatchSuc _o_ = (SRoleMatchSuc)_o1_;
/* 62 */       if (!this.teamleaderinfo.equals(_o_.teamleaderinfo)) return false;
/* 63 */       return true;
/*    */     }
/* 65 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 69 */     int _h_ = 0;
/* 70 */     _h_ += this.teamleaderinfo.hashCode();
/* 71 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 75 */     StringBuilder _sb_ = new StringBuilder();
/* 76 */     _sb_.append("(");
/* 77 */     _sb_.append(this.teamleaderinfo).append(",");
/* 78 */     _sb_.append(")");
/* 79 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\teamplatform\SRoleMatchSuc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */