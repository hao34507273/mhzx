/*    */ package mzm.gsp.paraselene;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.paraselene.main.PJoinParaselene;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CJoinParaselene
/*    */   extends __CJoinParaselene__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12598273;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleId = Role.getRoleId(this);
/* 21 */     Role.addRoleProcedure(roleId, new PJoinParaselene(roleId));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 30 */     return 12598273;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public final boolean _validator_()
/*    */   {
/* 38 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 42 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 46 */     if (!_validator_()) {
/* 47 */       throw new VerifyError("validator failed");
/*    */     }
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 53 */     if (_o1_ == this) return true;
/* 54 */     if ((_o1_ instanceof CJoinParaselene)) {
/* 55 */       return true;
/*    */     }
/* 57 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 61 */     int _h_ = 0;
/* 62 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 66 */     StringBuilder _sb_ = new StringBuilder();
/* 67 */     _sb_.append("(");
/* 68 */     _sb_.append(")");
/* 69 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CJoinParaselene _o_) {
/* 73 */     if (_o_ == this) return 0;
/* 74 */     int _c_ = 0;
/* 75 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\paraselene\CJoinParaselene.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */