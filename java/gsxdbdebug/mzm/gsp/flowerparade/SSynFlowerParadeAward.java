/*    */ package mzm.gsp.flowerparade;
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
/*    */ public class SSynFlowerParadeAward
/*    */   extends __SSynFlowerParadeAward__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12625679;
/*    */   public static final int TYPE_FOLLOW = 1;
/*    */   public static final int TYPE_DANCE = 2;
/*    */   public int awardtype;
/*    */   public AwardBean award;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12625679;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SSynFlowerParadeAward()
/*    */   {
/* 37 */     this.award = new AwardBean();
/*    */   }
/*    */   
/*    */   public SSynFlowerParadeAward(int _awardtype_, AwardBean _award_) {
/* 41 */     this.awardtype = _awardtype_;
/* 42 */     this.award = _award_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 46 */     if (!this.award._validator_()) return false;
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.awardtype);
/* 52 */     _os_.marshal(this.award);
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     this.awardtype = _os_.unmarshal_int();
/* 58 */     this.award.unmarshal(_os_);
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof SSynFlowerParadeAward)) {
/* 68 */       SSynFlowerParadeAward _o_ = (SSynFlowerParadeAward)_o1_;
/* 69 */       if (this.awardtype != _o_.awardtype) return false;
/* 70 */       if (!this.award.equals(_o_.award)) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += this.awardtype;
/* 79 */     _h_ += this.award.hashCode();
/* 80 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 84 */     StringBuilder _sb_ = new StringBuilder();
/* 85 */     _sb_.append("(");
/* 86 */     _sb_.append(this.awardtype).append(",");
/* 87 */     _sb_.append(this.award).append(",");
/* 88 */     _sb_.append(")");
/* 89 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\flowerparade\SSynFlowerParadeAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */