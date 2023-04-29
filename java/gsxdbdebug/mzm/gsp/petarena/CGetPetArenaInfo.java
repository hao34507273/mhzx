/*    */ package mzm.gsp.petarena;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.petarena.main.PCGetPetArenaInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CGetPetArenaInfo
/*    */   extends __CGetPetArenaInfo__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12628237;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleId = Role.getRoleId(this);
/* 21 */     if (roleId < 1L)
/*    */     {
/* 23 */       return;
/*    */     }
/* 25 */     Role.addRoleProcedure(roleId, new PCGetPetArenaInfo(roleId));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 33 */     return 12628237;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public final boolean _validator_()
/*    */   {
/* 41 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 45 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 49 */     if (!_validator_()) {
/* 50 */       throw new VerifyError("validator failed");
/*    */     }
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 56 */     if (_o1_ == this) return true;
/* 57 */     if ((_o1_ instanceof CGetPetArenaInfo)) {
/* 58 */       return true;
/*    */     }
/* 60 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 64 */     int _h_ = 0;
/* 65 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 69 */     StringBuilder _sb_ = new StringBuilder();
/* 70 */     _sb_.append("(");
/* 71 */     _sb_.append(")");
/* 72 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CGetPetArenaInfo _o_) {
/* 76 */     if (_o_ == this) return 0;
/* 77 */     int _c_ = 0;
/* 78 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petarena\CGetPetArenaInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */