/*    */ package mzm.gsp.pet;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SPetSoulExchangeRes
/*    */   extends __SPetSoulExchangeRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12590666;
/*    */   public long petid1;
/*    */   public long petid2;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12590666;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SPetSoulExchangeRes() {}
/*    */   
/*    */ 
/*    */   public SPetSoulExchangeRes(long _petid1_, long _petid2_)
/*    */   {
/* 35 */     this.petid1 = _petid1_;
/* 36 */     this.petid2 = _petid2_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 40 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 44 */     _os_.marshal(this.petid1);
/* 45 */     _os_.marshal(this.petid2);
/* 46 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 50 */     this.petid1 = _os_.unmarshal_long();
/* 51 */     this.petid2 = _os_.unmarshal_long();
/* 52 */     if (!_validator_()) {
/* 53 */       throw new VerifyError("validator failed");
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 59 */     if (_o1_ == this) return true;
/* 60 */     if ((_o1_ instanceof SPetSoulExchangeRes)) {
/* 61 */       SPetSoulExchangeRes _o_ = (SPetSoulExchangeRes)_o1_;
/* 62 */       if (this.petid1 != _o_.petid1) return false;
/* 63 */       if (this.petid2 != _o_.petid2) return false;
/* 64 */       return true;
/*    */     }
/* 66 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 70 */     int _h_ = 0;
/* 71 */     _h_ += (int)this.petid1;
/* 72 */     _h_ += (int)this.petid2;
/* 73 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 77 */     StringBuilder _sb_ = new StringBuilder();
/* 78 */     _sb_.append("(");
/* 79 */     _sb_.append(this.petid1).append(",");
/* 80 */     _sb_.append(this.petid2).append(",");
/* 81 */     _sb_.append(")");
/* 82 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SPetSoulExchangeRes _o_) {
/* 86 */     if (_o_ == this) return 0;
/* 87 */     int _c_ = 0;
/* 88 */     _c_ = Long.signum(this.petid1 - _o_.petid1);
/* 89 */     if (0 != _c_) return _c_;
/* 90 */     _c_ = Long.signum(this.petid2 - _o_.petid2);
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\SPetSoulExchangeRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */