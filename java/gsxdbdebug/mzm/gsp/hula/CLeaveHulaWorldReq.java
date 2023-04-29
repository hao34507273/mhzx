/*    */ package mzm.gsp.hula;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.hula.main.PLeaveHulaWorld;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CLeaveHulaWorldReq
/*    */   extends __CLeaveHulaWorldReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12608780;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleId = Role.getRoleId(this);
/* 21 */     Role.addRoleProcedure(roleId, new PLeaveHulaWorld(roleId));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 29 */     return 12608780;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public final boolean _validator_()
/*    */   {
/* 37 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 41 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 45 */     if (!_validator_()) {
/* 46 */       throw new VerifyError("validator failed");
/*    */     }
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 52 */     if (_o1_ == this) return true;
/* 53 */     if ((_o1_ instanceof CLeaveHulaWorldReq)) {
/* 54 */       return true;
/*    */     }
/* 56 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 60 */     int _h_ = 0;
/* 61 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 65 */     StringBuilder _sb_ = new StringBuilder();
/* 66 */     _sb_.append("(");
/* 67 */     _sb_.append(")");
/* 68 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CLeaveHulaWorldReq _o_) {
/* 72 */     if (_o_ == this) return 0;
/* 73 */     int _c_ = 0;
/* 74 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\hula\CLeaveHulaWorldReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */