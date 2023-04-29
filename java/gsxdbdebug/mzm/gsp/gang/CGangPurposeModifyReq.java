/*    */ package mzm.gsp.gang;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.gang.main.PGangPurposeModifyReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CGangPurposeModifyReq
/*    */   extends __CGangPurposeModifyReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12589869;
/*    */   public String purpose;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/*    */     
/* 21 */     Role.addRoleProcedure(roleId, new PGangPurposeModifyReq(roleId, this.purpose));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 30 */     return 12589869;
/*    */   }
/*    */   
/*    */ 
/*    */   public CGangPurposeModifyReq()
/*    */   {
/* 36 */     this.purpose = "";
/*    */   }
/*    */   
/*    */   public CGangPurposeModifyReq(String _purpose_) {
/* 40 */     this.purpose = _purpose_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.purpose, "UTF-16LE");
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 53 */     this.purpose = _os_.unmarshal_String("UTF-16LE");
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof CGangPurposeModifyReq)) {
/* 63 */       CGangPurposeModifyReq _o_ = (CGangPurposeModifyReq)_o1_;
/* 64 */       if (!this.purpose.equals(_o_.purpose)) return false;
/* 65 */       return true;
/*    */     }
/* 67 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 71 */     int _h_ = 0;
/* 72 */     _h_ += this.purpose.hashCode();
/* 73 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 77 */     StringBuilder _sb_ = new StringBuilder();
/* 78 */     _sb_.append("(");
/* 79 */     _sb_.append("T").append(this.purpose.length()).append(",");
/* 80 */     _sb_.append(")");
/* 81 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\CGangPurposeModifyReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */