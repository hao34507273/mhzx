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
/*    */ public class SQueryMarketItemWithLevelRes
/*    */   extends __SQueryMarketItemWithLevelRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12601397;
/*    */   public int pricesort;
/*    */   public int level;
/*    */   public int puborsell;
/*    */   public PageItemInfo pageresult;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12601397;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SQueryMarketItemWithLevelRes()
/*    */   {
/* 34 */     this.pageresult = new PageItemInfo();
/*    */   }
/*    */   
/*    */   public SQueryMarketItemWithLevelRes(int _pricesort_, int _level_, int _puborsell_, PageItemInfo _pageresult_) {
/* 38 */     this.pricesort = _pricesort_;
/* 39 */     this.level = _level_;
/* 40 */     this.puborsell = _puborsell_;
/* 41 */     this.pageresult = _pageresult_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     if (!this.pageresult._validator_()) return false;
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.pricesort);
/* 51 */     _os_.marshal(this.level);
/* 52 */     _os_.marshal(this.puborsell);
/* 53 */     _os_.marshal(this.pageresult);
/* 54 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 58 */     this.pricesort = _os_.unmarshal_int();
/* 59 */     this.level = _os_.unmarshal_int();
/* 60 */     this.puborsell = _os_.unmarshal_int();
/* 61 */     this.pageresult.unmarshal(_os_);
/* 62 */     if (!_validator_()) {
/* 63 */       throw new VerifyError("validator failed");
/*    */     }
/* 65 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 69 */     if (_o1_ == this) return true;
/* 70 */     if ((_o1_ instanceof SQueryMarketItemWithLevelRes)) {
/* 71 */       SQueryMarketItemWithLevelRes _o_ = (SQueryMarketItemWithLevelRes)_o1_;
/* 72 */       if (this.pricesort != _o_.pricesort) return false;
/* 73 */       if (this.level != _o_.level) return false;
/* 74 */       if (this.puborsell != _o_.puborsell) return false;
/* 75 */       if (!this.pageresult.equals(_o_.pageresult)) return false;
/* 76 */       return true;
/*    */     }
/* 78 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 82 */     int _h_ = 0;
/* 83 */     _h_ += this.pricesort;
/* 84 */     _h_ += this.level;
/* 85 */     _h_ += this.puborsell;
/* 86 */     _h_ += this.pageresult.hashCode();
/* 87 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 91 */     StringBuilder _sb_ = new StringBuilder();
/* 92 */     _sb_.append("(");
/* 93 */     _sb_.append(this.pricesort).append(",");
/* 94 */     _sb_.append(this.level).append(",");
/* 95 */     _sb_.append(this.puborsell).append(",");
/* 96 */     _sb_.append(this.pageresult).append(",");
/* 97 */     _sb_.append(")");
/* 98 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\SQueryMarketItemWithLevelRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */