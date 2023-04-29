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
/*    */ public class SSyncVisibleMonsterReward
/*    */   extends __SSyncVisibleMonsterReward__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12587543;
/*    */   public static final int ACTIVITY_SHENGXIAO = 0;
/*    */   public static final int ACTIVITY_YAOSHOUTUXI = 1;
/*    */   public static final int ACTIVITY_GANGROBBER = 2;
/*    */   public AwardBean awardbean;
/*    */   public int activitytype;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12587543;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SSyncVisibleMonsterReward()
/*    */   {
/* 38 */     this.awardbean = new AwardBean();
/*    */   }
/*    */   
/*    */   public SSyncVisibleMonsterReward(AwardBean _awardbean_, int _activitytype_) {
/* 42 */     this.awardbean = _awardbean_;
/* 43 */     this.activitytype = _activitytype_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     if (!this.awardbean._validator_()) return false;
/* 48 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 52 */     _os_.marshal(this.awardbean);
/* 53 */     _os_.marshal(this.activitytype);
/* 54 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 58 */     this.awardbean.unmarshal(_os_);
/* 59 */     this.activitytype = _os_.unmarshal_int();
/* 60 */     if (!_validator_()) {
/* 61 */       throw new VerifyError("validator failed");
/*    */     }
/* 63 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 67 */     if (_o1_ == this) return true;
/* 68 */     if ((_o1_ instanceof SSyncVisibleMonsterReward)) {
/* 69 */       SSyncVisibleMonsterReward _o_ = (SSyncVisibleMonsterReward)_o1_;
/* 70 */       if (!this.awardbean.equals(_o_.awardbean)) return false;
/* 71 */       if (this.activitytype != _o_.activitytype) return false;
/* 72 */       return true;
/*    */     }
/* 74 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 78 */     int _h_ = 0;
/* 79 */     _h_ += this.awardbean.hashCode();
/* 80 */     _h_ += this.activitytype;
/* 81 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 85 */     StringBuilder _sb_ = new StringBuilder();
/* 86 */     _sb_.append("(");
/* 87 */     _sb_.append(this.awardbean).append(",");
/* 88 */     _sb_.append(this.activitytype).append(",");
/* 89 */     _sb_.append(")");
/* 90 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\SSyncVisibleMonsterReward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */