/*    */ package mzm.gsp.auction;
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
/*    */ public class SSynAuctionItemInfo
/*    */   extends __SSynAuctionItemInfo__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12627205;
/*    */   public int activityid;
/*    */   public int turnindex;
/*    */   public ItemInfo iteminfo;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12627205;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SSynAuctionItemInfo()
/*    */   {
/* 35 */     this.iteminfo = new ItemInfo();
/*    */   }
/*    */   
/*    */   public SSynAuctionItemInfo(int _activityid_, int _turnindex_, ItemInfo _iteminfo_) {
/* 39 */     this.activityid = _activityid_;
/* 40 */     this.turnindex = _turnindex_;
/* 41 */     this.iteminfo = _iteminfo_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     if (!this.iteminfo._validator_()) return false;
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.activityid);
/* 51 */     _os_.marshal(this.turnindex);
/* 52 */     _os_.marshal(this.iteminfo);
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     this.activityid = _os_.unmarshal_int();
/* 58 */     this.turnindex = _os_.unmarshal_int();
/* 59 */     this.iteminfo.unmarshal(_os_);
/* 60 */     if (!_validator_()) {
/* 61 */       throw new VerifyError("validator failed");
/*    */     }
/* 63 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 67 */     if (_o1_ == this) return true;
/* 68 */     if ((_o1_ instanceof SSynAuctionItemInfo)) {
/* 69 */       SSynAuctionItemInfo _o_ = (SSynAuctionItemInfo)_o1_;
/* 70 */       if (this.activityid != _o_.activityid) return false;
/* 71 */       if (this.turnindex != _o_.turnindex) return false;
/* 72 */       if (!this.iteminfo.equals(_o_.iteminfo)) return false;
/* 73 */       return true;
/*    */     }
/* 75 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 79 */     int _h_ = 0;
/* 80 */     _h_ += this.activityid;
/* 81 */     _h_ += this.turnindex;
/* 82 */     _h_ += this.iteminfo.hashCode();
/* 83 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 87 */     StringBuilder _sb_ = new StringBuilder();
/* 88 */     _sb_.append("(");
/* 89 */     _sb_.append(this.activityid).append(",");
/* 90 */     _sb_.append(this.turnindex).append(",");
/* 91 */     _sb_.append(this.iteminfo).append(",");
/* 92 */     _sb_.append(")");
/* 93 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\auction\SSynAuctionItemInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */