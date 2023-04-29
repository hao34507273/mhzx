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
/*    */ public class SQueryShopingListRes
/*    */   extends __SQueryShopingListRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12584992;
/*    */   public long lastfreshtime;
/*    */   public PageInfo pageresult;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12584992;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SQueryShopingListRes()
/*    */   {
/* 32 */     this.pageresult = new PageInfo();
/*    */   }
/*    */   
/*    */   public SQueryShopingListRes(long _lastfreshtime_, PageInfo _pageresult_) {
/* 36 */     this.lastfreshtime = _lastfreshtime_;
/* 37 */     this.pageresult = _pageresult_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     if (!this.pageresult._validator_()) return false;
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.lastfreshtime);
/* 47 */     _os_.marshal(this.pageresult);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.lastfreshtime = _os_.unmarshal_long();
/* 53 */     this.pageresult.unmarshal(_os_);
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SQueryShopingListRes)) {
/* 63 */       SQueryShopingListRes _o_ = (SQueryShopingListRes)_o1_;
/* 64 */       if (this.lastfreshtime != _o_.lastfreshtime) return false;
/* 65 */       if (!this.pageresult.equals(_o_.pageresult)) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += (int)this.lastfreshtime;
/* 74 */     _h_ += this.pageresult.hashCode();
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.lastfreshtime).append(",");
/* 82 */     _sb_.append(this.pageresult).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\baitan\SQueryShopingListRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */