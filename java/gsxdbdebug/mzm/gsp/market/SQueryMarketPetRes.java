/*    */ package mzm.gsp.market;
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
/*    */ public class SQueryMarketPetRes
/*    */   extends __SQueryMarketPetRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12601349;
/*    */   public int pricesort;
/*    */   public PagePetInfo pageresult;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12601349;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SQueryMarketPetRes()
/*    */   {
/* 32 */     this.pageresult = new PagePetInfo();
/*    */   }
/*    */   
/*    */   public SQueryMarketPetRes(int _pricesort_, PagePetInfo _pageresult_) {
/* 36 */     this.pricesort = _pricesort_;
/* 37 */     this.pageresult = _pageresult_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     if (!this.pageresult._validator_()) return false;
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.pricesort);
/* 47 */     _os_.marshal(this.pageresult);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.pricesort = _os_.unmarshal_int();
/* 53 */     this.pageresult.unmarshal(_os_);
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SQueryMarketPetRes)) {
/* 63 */       SQueryMarketPetRes _o_ = (SQueryMarketPetRes)_o1_;
/* 64 */       if (this.pricesort != _o_.pricesort) return false;
/* 65 */       if (!this.pageresult.equals(_o_.pageresult)) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.pricesort;
/* 74 */     _h_ += this.pageresult.hashCode();
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.pricesort).append(",");
/* 82 */     _sb_.append(this.pageresult).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\SQueryMarketPetRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */