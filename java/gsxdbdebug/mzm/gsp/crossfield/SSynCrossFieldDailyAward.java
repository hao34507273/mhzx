/*    */ package mzm.gsp.crossfield;
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
/*    */ public class SSynCrossFieldDailyAward
/*    */   extends __SSynCrossFieldDailyAward__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12619539;
/*    */   public AwardBean award_info;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12619539;
/*    */   }
/*    */   
/*    */ 
/*    */   public SSynCrossFieldDailyAward()
/*    */   {
/* 33 */     this.award_info = new AwardBean();
/*    */   }
/*    */   
/*    */   public SSynCrossFieldDailyAward(AwardBean _award_info_) {
/* 37 */     this.award_info = _award_info_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     if (!this.award_info._validator_()) return false;
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.award_info);
/* 47 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 51 */     this.award_info.unmarshal(_os_);
/* 52 */     if (!_validator_()) {
/* 53 */       throw new VerifyError("validator failed");
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 59 */     if (_o1_ == this) return true;
/* 60 */     if ((_o1_ instanceof SSynCrossFieldDailyAward)) {
/* 61 */       SSynCrossFieldDailyAward _o_ = (SSynCrossFieldDailyAward)_o1_;
/* 62 */       if (!this.award_info.equals(_o_.award_info)) return false;
/* 63 */       return true;
/*    */     }
/* 65 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 69 */     int _h_ = 0;
/* 70 */     _h_ += this.award_info.hashCode();
/* 71 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 75 */     StringBuilder _sb_ = new StringBuilder();
/* 76 */     _sb_.append("(");
/* 77 */     _sb_.append(this.award_info).append(",");
/* 78 */     _sb_.append(")");
/* 79 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossfield\SSynCrossFieldDailyAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */