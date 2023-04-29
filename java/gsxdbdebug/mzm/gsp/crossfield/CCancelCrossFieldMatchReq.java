/*    */ package mzm.gsp.crossfield;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.crossfield.main.PCancelCrossFieldMatch;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CCancelCrossFieldMatchReq
/*    */   extends __CCancelCrossFieldMatchReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12619528;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleid = Role.getRoleId(this);
/* 21 */     if (roleid < 0L)
/* 22 */       return;
/* 23 */     Role.addRoleProcedure(roleid, new PCancelCrossFieldMatch(roleid));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 31 */     return 12619528;
/*    */   }
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
/* 55 */     if ((_o1_ instanceof CCancelCrossFieldMatchReq)) {
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
/*    */   public int compareTo(CCancelCrossFieldMatchReq _o_) {
/* 74 */     if (_o_ == this) return 0;
/* 75 */     int _c_ = 0;
/* 76 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossfield\CCancelCrossFieldMatchReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */