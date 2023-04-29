/*    */ package mzm.gsp.activity;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.visiblemonsterfight.main.PYaoShouTuXiNPCStartFight;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CYaoShouTuXiNPCStartFight
/*    */   extends __CYaoShouTuXiNPCStartFight__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12587561;
/*    */   public static final int NPC_FUNC_ID = 150200038;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     if (roleId < 0L) return;
/* 21 */     Role.addRoleProcedure(roleId, new PYaoShouTuXiNPCStartFight(roleId));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 29 */     return 12587561;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public final boolean _validator_()
/*    */   {
/* 39 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 43 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 47 */     if (!_validator_()) {
/* 48 */       throw new VerifyError("validator failed");
/*    */     }
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 54 */     if (_o1_ == this) return true;
/* 55 */     if ((_o1_ instanceof CYaoShouTuXiNPCStartFight)) {
/* 56 */       return true;
/*    */     }
/* 58 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 62 */     int _h_ = 0;
/* 63 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 67 */     StringBuilder _sb_ = new StringBuilder();
/* 68 */     _sb_.append("(");
/* 69 */     _sb_.append(")");
/* 70 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CYaoShouTuXiNPCStartFight _o_) {
/* 74 */     if (_o_ == this) return 0;
/* 75 */     int _c_ = 0;
/* 76 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\CYaoShouTuXiNPCStartFight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */