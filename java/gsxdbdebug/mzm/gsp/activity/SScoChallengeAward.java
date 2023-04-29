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
/*    */ public class SScoChallengeAward
/*    */   extends __SScoChallengeAward__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12587537;
/*    */   public int circle;
/*    */   public AwardBean awardbean;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12587537;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SScoChallengeAward()
/*    */   {
/* 32 */     this.awardbean = new AwardBean();
/*    */   }
/*    */   
/*    */   public SScoChallengeAward(int _circle_, AwardBean _awardbean_) {
/* 36 */     this.circle = _circle_;
/* 37 */     this.awardbean = _awardbean_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     if (!this.awardbean._validator_()) return false;
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.circle);
/* 47 */     _os_.marshal(this.awardbean);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.circle = _os_.unmarshal_int();
/* 53 */     this.awardbean.unmarshal(_os_);
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SScoChallengeAward)) {
/* 63 */       SScoChallengeAward _o_ = (SScoChallengeAward)_o1_;
/* 64 */       if (this.circle != _o_.circle) return false;
/* 65 */       if (!this.awardbean.equals(_o_.awardbean)) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.circle;
/* 74 */     _h_ += this.awardbean.hashCode();
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.circle).append(",");
/* 82 */     _sb_.append(this.awardbean).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\SScoChallengeAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */