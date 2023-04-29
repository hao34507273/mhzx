/*    */ package mzm.gsp.personal;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.personal.main.PCEditPersonalInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CEditPersonalInfo
/*    */   extends __CEditPersonalInfo__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12603655;
/*    */   public EditPersonalInfo personalinfo;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleId = Role.getRoleId(this);
/* 21 */     if (roleId < 1L) {
/* 22 */       return;
/*    */     }
/* 24 */     Role.addRoleProcedure(roleId, new PCEditPersonalInfo(roleId, this.personalinfo));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 32 */     return 12603655;
/*    */   }
/*    */   
/*    */ 
/*    */   public CEditPersonalInfo()
/*    */   {
/* 38 */     this.personalinfo = new EditPersonalInfo();
/*    */   }
/*    */   
/*    */   public CEditPersonalInfo(EditPersonalInfo _personalinfo_) {
/* 42 */     this.personalinfo = _personalinfo_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 46 */     if (!this.personalinfo._validator_()) return false;
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.personalinfo);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.personalinfo.unmarshal(_os_);
/* 57 */     if (!_validator_()) {
/* 58 */       throw new VerifyError("validator failed");
/*    */     }
/* 60 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 64 */     if (_o1_ == this) return true;
/* 65 */     if ((_o1_ instanceof CEditPersonalInfo)) {
/* 66 */       CEditPersonalInfo _o_ = (CEditPersonalInfo)_o1_;
/* 67 */       if (!this.personalinfo.equals(_o_.personalinfo)) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += this.personalinfo.hashCode();
/* 76 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 80 */     StringBuilder _sb_ = new StringBuilder();
/* 81 */     _sb_.append("(");
/* 82 */     _sb_.append(this.personalinfo).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\personal\CEditPersonalInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */