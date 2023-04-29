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
/*    */ public class SItemAuctionSuccessRes
/*    */   extends __SItemAuctionSuccessRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12601448;
/*    */   public long marketid;
/*    */   public int itemid;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12601448;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SItemAuctionSuccessRes() {}
/*    */   
/*    */ 
/*    */   public SItemAuctionSuccessRes(long _marketid_, int _itemid_)
/*    */   {
/* 35 */     this.marketid = _marketid_;
/* 36 */     this.itemid = _itemid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 40 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 44 */     _os_.marshal(this.marketid);
/* 45 */     _os_.marshal(this.itemid);
/* 46 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 50 */     this.marketid = _os_.unmarshal_long();
/* 51 */     this.itemid = _os_.unmarshal_int();
/* 52 */     if (!_validator_()) {
/* 53 */       throw new VerifyError("validator failed");
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 59 */     if (_o1_ == this) return true;
/* 60 */     if ((_o1_ instanceof SItemAuctionSuccessRes)) {
/* 61 */       SItemAuctionSuccessRes _o_ = (SItemAuctionSuccessRes)_o1_;
/* 62 */       if (this.marketid != _o_.marketid) return false;
/* 63 */       if (this.itemid != _o_.itemid) return false;
/* 64 */       return true;
/*    */     }
/* 66 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 70 */     int _h_ = 0;
/* 71 */     _h_ += (int)this.marketid;
/* 72 */     _h_ += this.itemid;
/* 73 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 77 */     StringBuilder _sb_ = new StringBuilder();
/* 78 */     _sb_.append("(");
/* 79 */     _sb_.append(this.marketid).append(",");
/* 80 */     _sb_.append(this.itemid).append(",");
/* 81 */     _sb_.append(")");
/* 82 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SItemAuctionSuccessRes _o_) {
/* 86 */     if (_o_ == this) return 0;
/* 87 */     int _c_ = 0;
/* 88 */     _c_ = Long.signum(this.marketid - _o_.marketid);
/* 89 */     if (0 != _c_) return _c_;
/* 90 */     _c_ = this.itemid - _o_.itemid;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\SItemAuctionSuccessRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */