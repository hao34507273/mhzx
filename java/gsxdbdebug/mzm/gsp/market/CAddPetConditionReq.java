/*    */ package mzm.gsp.market;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.market.search.PAddPetConditionReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CAddPetConditionReq
/*    */   extends __CAddPetConditionReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12601406;
/*    */   public PetCondition condition;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleId = Role.getRoleId(this);
/* 21 */     if (roleId < 0L) {
/* 22 */       return;
/*    */     }
/* 24 */     Role.addRoleProcedure(roleId, new PAddPetConditionReq(roleId, this.condition));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 32 */     return 12601406;
/*    */   }
/*    */   
/*    */ 
/*    */   public CAddPetConditionReq()
/*    */   {
/* 38 */     this.condition = new PetCondition();
/*    */   }
/*    */   
/*    */   public CAddPetConditionReq(PetCondition _condition_) {
/* 42 */     this.condition = _condition_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 46 */     if (!this.condition._validator_()) return false;
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.condition);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.condition.unmarshal(_os_);
/* 57 */     if (!_validator_()) {
/* 58 */       throw new VerifyError("validator failed");
/*    */     }
/* 60 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 64 */     if (_o1_ == this) return true;
/* 65 */     if ((_o1_ instanceof CAddPetConditionReq)) {
/* 66 */       CAddPetConditionReq _o_ = (CAddPetConditionReq)_o1_;
/* 67 */       if (!this.condition.equals(_o_.condition)) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += this.condition.hashCode();
/* 76 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 80 */     StringBuilder _sb_ = new StringBuilder();
/* 81 */     _sb_.append("(");
/* 82 */     _sb_.append(this.condition).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\CAddPetConditionReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */