/*    */ package mzm.gsp.corps;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.corps.main.PCResetDeclarationReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CResetDeclarationReq
/*    */   extends __CResetDeclarationReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12617497;
/*    */   public Octets declaration;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     if (roleId < 0L) {
/* 21 */       return;
/*    */     }
/* 23 */     Role.addRoleProcedure(roleId, new PCResetDeclarationReq(roleId, this.declaration));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 31 */     return 12617497;
/*    */   }
/*    */   
/*    */ 
/*    */   public CResetDeclarationReq()
/*    */   {
/* 37 */     this.declaration = new Octets();
/*    */   }
/*    */   
/*    */   public CResetDeclarationReq(Octets _declaration_) {
/* 41 */     this.declaration = _declaration_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.declaration);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.declaration = _os_.unmarshal_Octets();
/* 55 */     if (!_validator_()) {
/* 56 */       throw new VerifyError("validator failed");
/*    */     }
/* 58 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 62 */     if (_o1_ == this) return true;
/* 63 */     if ((_o1_ instanceof CResetDeclarationReq)) {
/* 64 */       CResetDeclarationReq _o_ = (CResetDeclarationReq)_o1_;
/* 65 */       if (!this.declaration.equals(_o_.declaration)) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.declaration.hashCode();
/* 74 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 78 */     StringBuilder _sb_ = new StringBuilder();
/* 79 */     _sb_.append("(");
/* 80 */     _sb_.append("B").append(this.declaration.size()).append(",");
/* 81 */     _sb_.append(")");
/* 82 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\CResetDeclarationReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */