/*    */ package mzm.gsp.firework;
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
/*    */ public class SGetFireworkAward
/*    */   extends __SGetFireworkAward__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12625153;
/*    */   public int activityid;
/*    */   public AwardBean awardbean;
/*    */   public int hitcount;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12625153;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SGetFireworkAward()
/*    */   {
/* 35 */     this.awardbean = new AwardBean();
/*    */   }
/*    */   
/*    */   public SGetFireworkAward(int _activityid_, AwardBean _awardbean_, int _hitcount_) {
/* 39 */     this.activityid = _activityid_;
/* 40 */     this.awardbean = _awardbean_;
/* 41 */     this.hitcount = _hitcount_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     if (!this.awardbean._validator_()) return false;
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.activityid);
/* 51 */     _os_.marshal(this.awardbean);
/* 52 */     _os_.marshal(this.hitcount);
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     this.activityid = _os_.unmarshal_int();
/* 58 */     this.awardbean.unmarshal(_os_);
/* 59 */     this.hitcount = _os_.unmarshal_int();
/* 60 */     if (!_validator_()) {
/* 61 */       throw new VerifyError("validator failed");
/*    */     }
/* 63 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 67 */     if (_o1_ == this) return true;
/* 68 */     if ((_o1_ instanceof SGetFireworkAward)) {
/* 69 */       SGetFireworkAward _o_ = (SGetFireworkAward)_o1_;
/* 70 */       if (this.activityid != _o_.activityid) return false;
/* 71 */       if (!this.awardbean.equals(_o_.awardbean)) return false;
/* 72 */       if (this.hitcount != _o_.hitcount) return false;
/* 73 */       return true;
/*    */     }
/* 75 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 79 */     int _h_ = 0;
/* 80 */     _h_ += this.activityid;
/* 81 */     _h_ += this.awardbean.hashCode();
/* 82 */     _h_ += this.hitcount;
/* 83 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 87 */     StringBuilder _sb_ = new StringBuilder();
/* 88 */     _sb_.append("(");
/* 89 */     _sb_.append(this.activityid).append(",");
/* 90 */     _sb_.append(this.awardbean).append(",");
/* 91 */     _sb_.append(this.hitcount).append(",");
/* 92 */     _sb_.append(")");
/* 93 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\firework\SGetFireworkAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */