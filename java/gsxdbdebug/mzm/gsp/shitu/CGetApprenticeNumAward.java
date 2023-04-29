/*    */ package mzm.gsp.shitu;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.shitu.main.PCGetApprenticeNumAward;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CGetApprenticeNumAward
/*    */   extends __CGetApprenticeNumAward__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12601622;
/*    */   public int award_score_cfg_id;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleId = Role.getRoleId(this);
/* 21 */     if (roleId < 0L)
/*    */     {
/* 23 */       return;
/*    */     }
/* 25 */     Role.addRoleProcedure(roleId, new PCGetApprenticeNumAward(roleId, this.award_score_cfg_id));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 33 */     return 12601622;
/*    */   }
/*    */   
/*    */ 
/*    */   public CGetApprenticeNumAward() {}
/*    */   
/*    */ 
/*    */   public CGetApprenticeNumAward(int _award_score_cfg_id_)
/*    */   {
/* 42 */     this.award_score_cfg_id = _award_score_cfg_id_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.award_score_cfg_id);
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 55 */     this.award_score_cfg_id = _os_.unmarshal_int();
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof CGetApprenticeNumAward)) {
/* 65 */       CGetApprenticeNumAward _o_ = (CGetApprenticeNumAward)_o1_;
/* 66 */       if (this.award_score_cfg_id != _o_.award_score_cfg_id) return false;
/* 67 */       return true;
/*    */     }
/* 69 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 73 */     int _h_ = 0;
/* 74 */     _h_ += this.award_score_cfg_id;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.award_score_cfg_id).append(",");
/* 82 */     _sb_.append(")");
/* 83 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CGetApprenticeNumAward _o_) {
/* 87 */     if (_o_ == this) return 0;
/* 88 */     int _c_ = 0;
/* 89 */     _c_ = this.award_score_cfg_id - _o_.award_score_cfg_id;
/* 90 */     if (0 != _c_) return _c_;
/* 91 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\CGetApprenticeNumAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */