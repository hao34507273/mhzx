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
/*    */ 
/*    */ 
/*    */ public class SFinishGangTaskeNotice
/*    */   extends __SFinishGangTaskeNotice__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12587579;
/*    */   public AwardBean targetawardbean;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12587579;
/*    */   }
/*    */   
/*    */ 
/*    */   public SFinishGangTaskeNotice()
/*    */   {
/* 33 */     this.targetawardbean = new AwardBean();
/*    */   }
/*    */   
/*    */   public SFinishGangTaskeNotice(AwardBean _targetawardbean_) {
/* 37 */     this.targetawardbean = _targetawardbean_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     if (!this.targetawardbean._validator_()) return false;
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.targetawardbean);
/* 47 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 51 */     this.targetawardbean.unmarshal(_os_);
/* 52 */     if (!_validator_()) {
/* 53 */       throw new VerifyError("validator failed");
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 59 */     if (_o1_ == this) return true;
/* 60 */     if ((_o1_ instanceof SFinishGangTaskeNotice)) {
/* 61 */       SFinishGangTaskeNotice _o_ = (SFinishGangTaskeNotice)_o1_;
/* 62 */       if (!this.targetawardbean.equals(_o_.targetawardbean)) return false;
/* 63 */       return true;
/*    */     }
/* 65 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 69 */     int _h_ = 0;
/* 70 */     _h_ += this.targetawardbean.hashCode();
/* 71 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 75 */     StringBuilder _sb_ = new StringBuilder();
/* 76 */     _sb_.append("(");
/* 77 */     _sb_.append(this.targetawardbean).append(",");
/* 78 */     _sb_.append(")");
/* 79 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\SFinishGangTaskeNotice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */