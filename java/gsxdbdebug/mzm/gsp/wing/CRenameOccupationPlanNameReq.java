/*    */ package mzm.gsp.wing;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.wing.main2.PCRenameOccupationPlanNameReq;
/*    */ 
/*    */ 
/*    */ public class CRenameOccupationPlanNameReq
/*    */   extends __CRenameOccupationPlanNameReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12596550;
/*    */   public int occupationid;
/*    */   public Octets newname;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     if (roleId <= 0L)
/*    */     {
/* 22 */       return;
/*    */     }
/* 24 */     Role.addRoleProcedure(roleId, new PCRenameOccupationPlanNameReq(roleId, this.occupationid, this.newname));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 32 */     return 12596550;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CRenameOccupationPlanNameReq()
/*    */   {
/* 39 */     this.newname = new Octets();
/*    */   }
/*    */   
/*    */   public CRenameOccupationPlanNameReq(int _occupationid_, Octets _newname_) {
/* 43 */     this.occupationid = _occupationid_;
/* 44 */     this.newname = _newname_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 48 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 52 */     _os_.marshal(this.occupationid);
/* 53 */     _os_.marshal(this.newname);
/* 54 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 58 */     this.occupationid = _os_.unmarshal_int();
/* 59 */     this.newname = _os_.unmarshal_Octets();
/* 60 */     if (!_validator_()) {
/* 61 */       throw new VerifyError("validator failed");
/*    */     }
/* 63 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 67 */     if (_o1_ == this) return true;
/* 68 */     if ((_o1_ instanceof CRenameOccupationPlanNameReq)) {
/* 69 */       CRenameOccupationPlanNameReq _o_ = (CRenameOccupationPlanNameReq)_o1_;
/* 70 */       if (this.occupationid != _o_.occupationid) return false;
/* 71 */       if (!this.newname.equals(_o_.newname)) return false;
/* 72 */       return true;
/*    */     }
/* 74 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 78 */     int _h_ = 0;
/* 79 */     _h_ += this.occupationid;
/* 80 */     _h_ += this.newname.hashCode();
/* 81 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 85 */     StringBuilder _sb_ = new StringBuilder();
/* 86 */     _sb_.append("(");
/* 87 */     _sb_.append(this.occupationid).append(",");
/* 88 */     _sb_.append("B").append(this.newname.size()).append(",");
/* 89 */     _sb_.append(")");
/* 90 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\CRenameOccupationPlanNameReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */