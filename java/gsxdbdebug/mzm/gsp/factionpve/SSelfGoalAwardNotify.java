/*    */ package mzm.gsp.factionpve;
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
/*    */ public class SSelfGoalAwardNotify
/*    */   extends __SSelfGoalAwardNotify__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12613652;
/*    */   public int goal_times;
/*    */   public AwardBean award;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12613652;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SSelfGoalAwardNotify()
/*    */   {
/* 34 */     this.goal_times = 0;
/* 35 */     this.award = new AwardBean();
/*    */   }
/*    */   
/*    */   public SSelfGoalAwardNotify(int _goal_times_, AwardBean _award_) {
/* 39 */     this.goal_times = _goal_times_;
/* 40 */     this.award = _award_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 44 */     if (!this.award._validator_()) return false;
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.goal_times);
/* 50 */     _os_.marshal(this.award);
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 55 */     this.goal_times = _os_.unmarshal_int();
/* 56 */     this.award.unmarshal(_os_);
/* 57 */     if (!_validator_()) {
/* 58 */       throw new VerifyError("validator failed");
/*    */     }
/* 60 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 64 */     if (_o1_ == this) return true;
/* 65 */     if ((_o1_ instanceof SSelfGoalAwardNotify)) {
/* 66 */       SSelfGoalAwardNotify _o_ = (SSelfGoalAwardNotify)_o1_;
/* 67 */       if (this.goal_times != _o_.goal_times) return false;
/* 68 */       if (!this.award.equals(_o_.award)) return false;
/* 69 */       return true;
/*    */     }
/* 71 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 75 */     int _h_ = 0;
/* 76 */     _h_ += this.goal_times;
/* 77 */     _h_ += this.award.hashCode();
/* 78 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 82 */     StringBuilder _sb_ = new StringBuilder();
/* 83 */     _sb_.append("(");
/* 84 */     _sb_.append(this.goal_times).append(",");
/* 85 */     _sb_.append(this.award).append(",");
/* 86 */     _sb_.append(")");
/* 87 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\factionpve\SSelfGoalAwardNotify.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */