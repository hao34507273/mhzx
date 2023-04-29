/*    */ package mzm.gsp.qingyunzhi;
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
/*    */ public class SSynHelpAwardInfo
/*    */   extends __SSynHelpAwardInfo__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12590343;
/*    */   public int outposttype;
/*    */   public AwardBean awardbean;
/*    */   public int lefthelpcount;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12590343;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SSynHelpAwardInfo()
/*    */   {
/* 35 */     this.awardbean = new AwardBean();
/*    */   }
/*    */   
/*    */   public SSynHelpAwardInfo(int _outposttype_, AwardBean _awardbean_, int _lefthelpcount_) {
/* 39 */     this.outposttype = _outposttype_;
/* 40 */     this.awardbean = _awardbean_;
/* 41 */     this.lefthelpcount = _lefthelpcount_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     if (!this.awardbean._validator_()) return false;
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.outposttype);
/* 51 */     _os_.marshal(this.awardbean);
/* 52 */     _os_.marshal(this.lefthelpcount);
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     this.outposttype = _os_.unmarshal_int();
/* 58 */     this.awardbean.unmarshal(_os_);
/* 59 */     this.lefthelpcount = _os_.unmarshal_int();
/* 60 */     if (!_validator_()) {
/* 61 */       throw new VerifyError("validator failed");
/*    */     }
/* 63 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 67 */     if (_o1_ == this) return true;
/* 68 */     if ((_o1_ instanceof SSynHelpAwardInfo)) {
/* 69 */       SSynHelpAwardInfo _o_ = (SSynHelpAwardInfo)_o1_;
/* 70 */       if (this.outposttype != _o_.outposttype) return false;
/* 71 */       if (!this.awardbean.equals(_o_.awardbean)) return false;
/* 72 */       if (this.lefthelpcount != _o_.lefthelpcount) return false;
/* 73 */       return true;
/*    */     }
/* 75 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 79 */     int _h_ = 0;
/* 80 */     _h_ += this.outposttype;
/* 81 */     _h_ += this.awardbean.hashCode();
/* 82 */     _h_ += this.lefthelpcount;
/* 83 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 87 */     StringBuilder _sb_ = new StringBuilder();
/* 88 */     _sb_.append("(");
/* 89 */     _sb_.append(this.outposttype).append(",");
/* 90 */     _sb_.append(this.awardbean).append(",");
/* 91 */     _sb_.append(this.lefthelpcount).append(",");
/* 92 */     _sb_.append(")");
/* 93 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingyunzhi\SSynHelpAwardInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */