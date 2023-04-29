/*    */ package mzm.gsp.cake;
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
/*    */ public class SGetCakeAward
/*    */   extends __SGetCakeAward__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12627724;
/*    */   public static final int ITEM_BELONG_TYPE__SELF = 1;
/*    */   public static final int ITEM_BELONG_TYPE__OTHER = 2;
/*    */   public int belongtype;
/*    */   public AwardBean awardbean;
/*    */   public int leftnum;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12627724;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SGetCakeAward()
/*    */   {
/* 38 */     this.awardbean = new AwardBean();
/*    */   }
/*    */   
/*    */   public SGetCakeAward(int _belongtype_, AwardBean _awardbean_, int _leftnum_) {
/* 42 */     this.belongtype = _belongtype_;
/* 43 */     this.awardbean = _awardbean_;
/* 44 */     this.leftnum = _leftnum_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 48 */     if (!this.awardbean._validator_()) return false;
/* 49 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 53 */     _os_.marshal(this.belongtype);
/* 54 */     _os_.marshal(this.awardbean);
/* 55 */     _os_.marshal(this.leftnum);
/* 56 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 60 */     this.belongtype = _os_.unmarshal_int();
/* 61 */     this.awardbean.unmarshal(_os_);
/* 62 */     this.leftnum = _os_.unmarshal_int();
/* 63 */     if (!_validator_()) {
/* 64 */       throw new VerifyError("validator failed");
/*    */     }
/* 66 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 70 */     if (_o1_ == this) return true;
/* 71 */     if ((_o1_ instanceof SGetCakeAward)) {
/* 72 */       SGetCakeAward _o_ = (SGetCakeAward)_o1_;
/* 73 */       if (this.belongtype != _o_.belongtype) return false;
/* 74 */       if (!this.awardbean.equals(_o_.awardbean)) return false;
/* 75 */       if (this.leftnum != _o_.leftnum) return false;
/* 76 */       return true;
/*    */     }
/* 78 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 82 */     int _h_ = 0;
/* 83 */     _h_ += this.belongtype;
/* 84 */     _h_ += this.awardbean.hashCode();
/* 85 */     _h_ += this.leftnum;
/* 86 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 90 */     StringBuilder _sb_ = new StringBuilder();
/* 91 */     _sb_.append("(");
/* 92 */     _sb_.append(this.belongtype).append(",");
/* 93 */     _sb_.append(this.awardbean).append(",");
/* 94 */     _sb_.append(this.leftnum).append(",");
/* 95 */     _sb_.append(")");
/* 96 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\cake\SGetCakeAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */