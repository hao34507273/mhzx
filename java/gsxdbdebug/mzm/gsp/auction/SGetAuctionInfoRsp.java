/*    */ package mzm.gsp.auction;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SGetAuctionInfoRsp
/*    */   extends __SGetAuctionInfoRsp__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12627208;
/*    */   public int activityid;
/*    */   public int turnindex;
/*    */   public ArrayList<ItemInfo> iteminfolist;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12627208;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SGetAuctionInfoRsp()
/*    */   {
/* 33 */     this.iteminfolist = new ArrayList();
/*    */   }
/*    */   
/*    */   public SGetAuctionInfoRsp(int _activityid_, int _turnindex_, ArrayList<ItemInfo> _iteminfolist_) {
/* 37 */     this.activityid = _activityid_;
/* 38 */     this.turnindex = _turnindex_;
/* 39 */     this.iteminfolist = _iteminfolist_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     for (ItemInfo _v_ : this.iteminfolist)
/* 44 */       if (!_v_._validator_()) return false;
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.activityid);
/* 50 */     _os_.marshal(this.turnindex);
/* 51 */     _os_.compact_uint32(this.iteminfolist.size());
/* 52 */     for (ItemInfo _v_ : this.iteminfolist) {
/* 53 */       _os_.marshal(_v_);
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 59 */     this.activityid = _os_.unmarshal_int();
/* 60 */     this.turnindex = _os_.unmarshal_int();
/* 61 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 62 */       ItemInfo _v_ = new ItemInfo();
/* 63 */       _v_.unmarshal(_os_);
/* 64 */       this.iteminfolist.add(_v_);
/*    */     }
/* 66 */     if (!_validator_()) {
/* 67 */       throw new VerifyError("validator failed");
/*    */     }
/* 69 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 73 */     if (_o1_ == this) return true;
/* 74 */     if ((_o1_ instanceof SGetAuctionInfoRsp)) {
/* 75 */       SGetAuctionInfoRsp _o_ = (SGetAuctionInfoRsp)_o1_;
/* 76 */       if (this.activityid != _o_.activityid) return false;
/* 77 */       if (this.turnindex != _o_.turnindex) return false;
/* 78 */       if (!this.iteminfolist.equals(_o_.iteminfolist)) return false;
/* 79 */       return true;
/*    */     }
/* 81 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 85 */     int _h_ = 0;
/* 86 */     _h_ += this.activityid;
/* 87 */     _h_ += this.turnindex;
/* 88 */     _h_ += this.iteminfolist.hashCode();
/* 89 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 93 */     StringBuilder _sb_ = new StringBuilder();
/* 94 */     _sb_.append("(");
/* 95 */     _sb_.append(this.activityid).append(",");
/* 96 */     _sb_.append(this.turnindex).append(",");
/* 97 */     _sb_.append(this.iteminfolist).append(",");
/* 98 */     _sb_.append(")");
/* 99 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\auction\SGetAuctionInfoRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */