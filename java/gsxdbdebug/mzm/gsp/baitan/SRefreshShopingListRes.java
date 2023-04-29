/*    */ package mzm.gsp.baitan;
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
/*    */ 
/*    */ public class SRefreshShopingListRes
/*    */   extends __SRefreshShopingListRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12584995;
/*    */   public long lastfreshtime;
/*    */   public int costgold;
/*    */   public PageInfo pageresult;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12584995;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SRefreshShopingListRes()
/*    */   {
/* 35 */     this.pageresult = new PageInfo();
/*    */   }
/*    */   
/*    */   public SRefreshShopingListRes(long _lastfreshtime_, int _costgold_, PageInfo _pageresult_) {
/* 39 */     this.lastfreshtime = _lastfreshtime_;
/* 40 */     this.costgold = _costgold_;
/* 41 */     this.pageresult = _pageresult_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     if (!this.pageresult._validator_()) return false;
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.lastfreshtime);
/* 51 */     _os_.marshal(this.costgold);
/* 52 */     _os_.marshal(this.pageresult);
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     this.lastfreshtime = _os_.unmarshal_long();
/* 58 */     this.costgold = _os_.unmarshal_int();
/* 59 */     this.pageresult.unmarshal(_os_);
/* 60 */     if (!_validator_()) {
/* 61 */       throw new VerifyError("validator failed");
/*    */     }
/* 63 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 67 */     if (_o1_ == this) return true;
/* 68 */     if ((_o1_ instanceof SRefreshShopingListRes)) {
/* 69 */       SRefreshShopingListRes _o_ = (SRefreshShopingListRes)_o1_;
/* 70 */       if (this.lastfreshtime != _o_.lastfreshtime) return false;
/* 71 */       if (this.costgold != _o_.costgold) return false;
/* 72 */       if (!this.pageresult.equals(_o_.pageresult)) return false;
/* 73 */       return true;
/*    */     }
/* 75 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 79 */     int _h_ = 0;
/* 80 */     _h_ += (int)this.lastfreshtime;
/* 81 */     _h_ += this.costgold;
/* 82 */     _h_ += this.pageresult.hashCode();
/* 83 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 87 */     StringBuilder _sb_ = new StringBuilder();
/* 88 */     _sb_.append("(");
/* 89 */     _sb_.append(this.lastfreshtime).append(",");
/* 90 */     _sb_.append(this.costgold).append(",");
/* 91 */     _sb_.append(this.pageresult).append(",");
/* 92 */     _sb_.append(")");
/* 93 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\baitan\SRefreshShopingListRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */