/*    */ package mzm.gsp.qmhw;
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
/*    */ public class SSynQMHWFightAward
/*    */   extends __SSynQMHWFightAward__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12601863;
/*    */   public AwardBean awardbean;
/*    */   public int score;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12601863;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SSynQMHWFightAward()
/*    */   {
/* 34 */     this.awardbean = new AwardBean();
/*    */   }
/*    */   
/*    */   public SSynQMHWFightAward(AwardBean _awardbean_, int _score_) {
/* 38 */     this.awardbean = _awardbean_;
/* 39 */     this.score = _score_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     if (!this.awardbean._validator_()) return false;
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.awardbean);
/* 49 */     _os_.marshal(this.score);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.awardbean.unmarshal(_os_);
/* 55 */     this.score = _os_.unmarshal_int();
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof SSynQMHWFightAward)) {
/* 65 */       SSynQMHWFightAward _o_ = (SSynQMHWFightAward)_o1_;
/* 66 */       if (!this.awardbean.equals(_o_.awardbean)) return false;
/* 67 */       if (this.score != _o_.score) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += this.awardbean.hashCode();
/* 76 */     _h_ += this.score;
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.awardbean).append(",");
/* 84 */     _sb_.append(this.score).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qmhw\SSynQMHWFightAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */