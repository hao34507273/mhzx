/*    */ package mzm.gsp.crossbattle;
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
/*    */ public class SNotifyKnockOutCorpsQualification
/*    */   extends __SNotifyKnockOutCorpsQualification__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12617082;
/*    */   public int fight_type;
/*    */   public int is_has_qualification;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12617082;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SNotifyKnockOutCorpsQualification() {}
/*    */   
/*    */ 
/*    */   public SNotifyKnockOutCorpsQualification(int _fight_type_, int _is_has_qualification_)
/*    */   {
/* 35 */     this.fight_type = _fight_type_;
/* 36 */     this.is_has_qualification = _is_has_qualification_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 40 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 44 */     _os_.marshal(this.fight_type);
/* 45 */     _os_.marshal(this.is_has_qualification);
/* 46 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 50 */     this.fight_type = _os_.unmarshal_int();
/* 51 */     this.is_has_qualification = _os_.unmarshal_int();
/* 52 */     if (!_validator_()) {
/* 53 */       throw new VerifyError("validator failed");
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 59 */     if (_o1_ == this) return true;
/* 60 */     if ((_o1_ instanceof SNotifyKnockOutCorpsQualification)) {
/* 61 */       SNotifyKnockOutCorpsQualification _o_ = (SNotifyKnockOutCorpsQualification)_o1_;
/* 62 */       if (this.fight_type != _o_.fight_type) return false;
/* 63 */       if (this.is_has_qualification != _o_.is_has_qualification) return false;
/* 64 */       return true;
/*    */     }
/* 66 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 70 */     int _h_ = 0;
/* 71 */     _h_ += this.fight_type;
/* 72 */     _h_ += this.is_has_qualification;
/* 73 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 77 */     StringBuilder _sb_ = new StringBuilder();
/* 78 */     _sb_.append("(");
/* 79 */     _sb_.append(this.fight_type).append(",");
/* 80 */     _sb_.append(this.is_has_qualification).append(",");
/* 81 */     _sb_.append(")");
/* 82 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SNotifyKnockOutCorpsQualification _o_) {
/* 86 */     if (_o_ == this) return 0;
/* 87 */     int _c_ = 0;
/* 88 */     _c_ = this.fight_type - _o_.fight_type;
/* 89 */     if (0 != _c_) return _c_;
/* 90 */     _c_ = this.is_has_qualification - _o_.is_has_qualification;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\SNotifyKnockOutCorpsQualification.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */