/*    */ package mzm.gsp.pet;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class STriggerMinimumGuarantee
/*    */   extends __STriggerMinimumGuarantee__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12590665;
/*    */   public int guarantee_skill_num;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12590665;
/*    */   }
/*    */   
/*    */ 
/*    */   public STriggerMinimumGuarantee() {}
/*    */   
/*    */ 
/*    */   public STriggerMinimumGuarantee(int _guarantee_skill_num_)
/*    */   {
/* 36 */     this.guarantee_skill_num = _guarantee_skill_num_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 40 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 44 */     _os_.marshal(this.guarantee_skill_num);
/* 45 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 49 */     this.guarantee_skill_num = _os_.unmarshal_int();
/* 50 */     if (!_validator_()) {
/* 51 */       throw new VerifyError("validator failed");
/*    */     }
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 57 */     if (_o1_ == this) return true;
/* 58 */     if ((_o1_ instanceof STriggerMinimumGuarantee)) {
/* 59 */       STriggerMinimumGuarantee _o_ = (STriggerMinimumGuarantee)_o1_;
/* 60 */       if (this.guarantee_skill_num != _o_.guarantee_skill_num) return false;
/* 61 */       return true;
/*    */     }
/* 63 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 67 */     int _h_ = 0;
/* 68 */     _h_ += this.guarantee_skill_num;
/* 69 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 73 */     StringBuilder _sb_ = new StringBuilder();
/* 74 */     _sb_.append("(");
/* 75 */     _sb_.append(this.guarantee_skill_num).append(",");
/* 76 */     _sb_.append(")");
/* 77 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(STriggerMinimumGuarantee _o_) {
/* 81 */     if (_o_ == this) return 0;
/* 82 */     int _c_ = 0;
/* 83 */     _c_ = this.guarantee_skill_num - _o_.guarantee_skill_num;
/* 84 */     if (0 != _c_) return _c_;
/* 85 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\STriggerMinimumGuarantee.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */