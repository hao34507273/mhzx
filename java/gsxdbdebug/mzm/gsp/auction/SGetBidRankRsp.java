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
/*    */ 
/*    */ public class SGetBidRankRsp
/*    */   extends __SGetBidRankRsp__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12627209;
/*    */   public int activityid;
/*    */   public ArrayList<ItemInfo> iteminfolist;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12627209;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SGetBidRankRsp()
/*    */   {
/* 32 */     this.iteminfolist = new ArrayList();
/*    */   }
/*    */   
/*    */   public SGetBidRankRsp(int _activityid_, ArrayList<ItemInfo> _iteminfolist_) {
/* 36 */     this.activityid = _activityid_;
/* 37 */     this.iteminfolist = _iteminfolist_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     for (ItemInfo _v_ : this.iteminfolist)
/* 42 */       if (!_v_._validator_()) return false;
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.marshal(this.activityid);
/* 48 */     _os_.compact_uint32(this.iteminfolist.size());
/* 49 */     for (ItemInfo _v_ : this.iteminfolist) {
/* 50 */       _os_.marshal(_v_);
/*    */     }
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.activityid = _os_.unmarshal_int();
/* 57 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 58 */       ItemInfo _v_ = new ItemInfo();
/* 59 */       _v_.unmarshal(_os_);
/* 60 */       this.iteminfolist.add(_v_);
/*    */     }
/* 62 */     if (!_validator_()) {
/* 63 */       throw new VerifyError("validator failed");
/*    */     }
/* 65 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 69 */     if (_o1_ == this) return true;
/* 70 */     if ((_o1_ instanceof SGetBidRankRsp)) {
/* 71 */       SGetBidRankRsp _o_ = (SGetBidRankRsp)_o1_;
/* 72 */       if (this.activityid != _o_.activityid) return false;
/* 73 */       if (!this.iteminfolist.equals(_o_.iteminfolist)) return false;
/* 74 */       return true;
/*    */     }
/* 76 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 80 */     int _h_ = 0;
/* 81 */     _h_ += this.activityid;
/* 82 */     _h_ += this.iteminfolist.hashCode();
/* 83 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 87 */     StringBuilder _sb_ = new StringBuilder();
/* 88 */     _sb_.append("(");
/* 89 */     _sb_.append(this.activityid).append(",");
/* 90 */     _sb_.append(this.iteminfolist).append(",");
/* 91 */     _sb_.append(")");
/* 92 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\auction\SGetBidRankRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */