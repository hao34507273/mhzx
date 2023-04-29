/*    */ package mzm.gsp.auction;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ public class ItemInfo implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public int itemcfgid;
/*    */   public int biddercount;
/*    */   public long maxbidprice;
/*    */   public Octets biddername;
/*    */   public long bidderroleid;
/*    */   public long bidendtimestamp;
/*    */   
/*    */   public ItemInfo()
/*    */   {
/* 17 */     this.biddername = new Octets();
/*    */   }
/*    */   
/*    */   public ItemInfo(int _itemcfgid_, int _biddercount_, long _maxbidprice_, Octets _biddername_, long _bidderroleid_, long _bidendtimestamp_) {
/* 21 */     this.itemcfgid = _itemcfgid_;
/* 22 */     this.biddercount = _biddercount_;
/* 23 */     this.maxbidprice = _maxbidprice_;
/* 24 */     this.biddername = _biddername_;
/* 25 */     this.bidderroleid = _bidderroleid_;
/* 26 */     this.bidendtimestamp = _bidendtimestamp_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 30 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 34 */     _os_.marshal(this.itemcfgid);
/* 35 */     _os_.marshal(this.biddercount);
/* 36 */     _os_.marshal(this.maxbidprice);
/* 37 */     _os_.marshal(this.biddername);
/* 38 */     _os_.marshal(this.bidderroleid);
/* 39 */     _os_.marshal(this.bidendtimestamp);
/* 40 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 44 */     this.itemcfgid = _os_.unmarshal_int();
/* 45 */     this.biddercount = _os_.unmarshal_int();
/* 46 */     this.maxbidprice = _os_.unmarshal_long();
/* 47 */     this.biddername = _os_.unmarshal_Octets();
/* 48 */     this.bidderroleid = _os_.unmarshal_long();
/* 49 */     this.bidendtimestamp = _os_.unmarshal_long();
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 54 */     if (_o1_ == this) return true;
/* 55 */     if ((_o1_ instanceof ItemInfo)) {
/* 56 */       ItemInfo _o_ = (ItemInfo)_o1_;
/* 57 */       if (this.itemcfgid != _o_.itemcfgid) return false;
/* 58 */       if (this.biddercount != _o_.biddercount) return false;
/* 59 */       if (this.maxbidprice != _o_.maxbidprice) return false;
/* 60 */       if (!this.biddername.equals(_o_.biddername)) return false;
/* 61 */       if (this.bidderroleid != _o_.bidderroleid) return false;
/* 62 */       if (this.bidendtimestamp != _o_.bidendtimestamp) return false;
/* 63 */       return true;
/*    */     }
/* 65 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 69 */     int _h_ = 0;
/* 70 */     _h_ += this.itemcfgid;
/* 71 */     _h_ += this.biddercount;
/* 72 */     _h_ += (int)this.maxbidprice;
/* 73 */     _h_ += this.biddername.hashCode();
/* 74 */     _h_ += (int)this.bidderroleid;
/* 75 */     _h_ += (int)this.bidendtimestamp;
/* 76 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 80 */     StringBuilder _sb_ = new StringBuilder();
/* 81 */     _sb_.append("(");
/* 82 */     _sb_.append(this.itemcfgid).append(",");
/* 83 */     _sb_.append(this.biddercount).append(",");
/* 84 */     _sb_.append(this.maxbidprice).append(",");
/* 85 */     _sb_.append("B").append(this.biddername.size()).append(",");
/* 86 */     _sb_.append(this.bidderroleid).append(",");
/* 87 */     _sb_.append(this.bidendtimestamp).append(",");
/* 88 */     _sb_.append(")");
/* 89 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\auction\ItemInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */