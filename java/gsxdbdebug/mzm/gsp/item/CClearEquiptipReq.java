/*    */ package mzm.gsp.item;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.item.main.PClearEquipState;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CClearEquiptipReq
/*    */   extends __CClearEquiptipReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12584837;
/*    */   public int statemask;
/*    */   
/*    */   protected void process()
/*    */   {
/* 18 */     long roleid = Role.getRoleId(this);
/* 19 */     Role.addRoleProcedure(roleid, new PClearEquipState(roleid, this.statemask));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 28 */     return 12584837;
/*    */   }
/*    */   
/*    */ 
/*    */   public CClearEquiptipReq() {}
/*    */   
/*    */ 
/*    */   public CClearEquiptipReq(int _statemask_)
/*    */   {
/* 37 */     this.statemask = _statemask_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 45 */     _os_.marshal(this.statemask);
/* 46 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 50 */     this.statemask = _os_.unmarshal_int();
/* 51 */     if (!_validator_()) {
/* 52 */       throw new VerifyError("validator failed");
/*    */     }
/* 54 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 58 */     if (_o1_ == this) return true;
/* 59 */     if ((_o1_ instanceof CClearEquiptipReq)) {
/* 60 */       CClearEquiptipReq _o_ = (CClearEquiptipReq)_o1_;
/* 61 */       if (this.statemask != _o_.statemask) return false;
/* 62 */       return true;
/*    */     }
/* 64 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 68 */     int _h_ = 0;
/* 69 */     _h_ += this.statemask;
/* 70 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 74 */     StringBuilder _sb_ = new StringBuilder();
/* 75 */     _sb_.append("(");
/* 76 */     _sb_.append(this.statemask).append(",");
/* 77 */     _sb_.append(")");
/* 78 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CClearEquiptipReq _o_) {
/* 82 */     if (_o_ == this) return 0;
/* 83 */     int _c_ = 0;
/* 84 */     _c_ = this.statemask - _o_.statemask;
/* 85 */     if (0 != _c_) return _c_;
/* 86 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\CClearEquiptipReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */