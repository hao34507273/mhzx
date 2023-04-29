/*    */ package mzm.gsp.activity;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.award.AwardBean;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SShimenWeekPerfectAward
/*    */   extends __SShimenWeekPerfectAward__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12587540;
/*    */   public AwardBean awardbean;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12587540;
/*    */   }
/*    */   
/*    */ 
/*    */   public SShimenWeekPerfectAward()
/*    */   {
/* 31 */     this.awardbean = new AwardBean();
/*    */   }
/*    */   
/*    */   public SShimenWeekPerfectAward(AwardBean _awardbean_) {
/* 35 */     this.awardbean = _awardbean_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 39 */     if (!this.awardbean._validator_()) return false;
/* 40 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 44 */     _os_.marshal(this.awardbean);
/* 45 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 49 */     this.awardbean.unmarshal(_os_);
/* 50 */     if (!_validator_()) {
/* 51 */       throw new VerifyError("validator failed");
/*    */     }
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 57 */     if (_o1_ == this) return true;
/* 58 */     if ((_o1_ instanceof SShimenWeekPerfectAward)) {
/* 59 */       SShimenWeekPerfectAward _o_ = (SShimenWeekPerfectAward)_o1_;
/* 60 */       if (!this.awardbean.equals(_o_.awardbean)) return false;
/* 61 */       return true;
/*    */     }
/* 63 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 67 */     int _h_ = 0;
/* 68 */     _h_ += this.awardbean.hashCode();
/* 69 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 73 */     StringBuilder _sb_ = new StringBuilder();
/* 74 */     _sb_.append("(");
/* 75 */     _sb_.append(this.awardbean).append(",");
/* 76 */     _sb_.append(")");
/* 77 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\SShimenWeekPerfectAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */