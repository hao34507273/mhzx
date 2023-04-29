/*    */ package mzm.gsp.auction;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.auction.main.AuctionOneByOneManager;
/*    */ import mzm.gsp.auction.main.PCGetBidRankReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CGetBidRankReq
/*    */   extends __CGetBidRankReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12627201;
/*    */   public int activityid;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleId = Role.getRoleId(this);
/* 21 */     if (roleId <= 0L)
/*    */     {
/* 23 */       return;
/*    */     }
/* 25 */     AuctionOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(this.activityid), new PCGetBidRankReq(roleId, this.activityid));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 34 */     return 12627201;
/*    */   }
/*    */   
/*    */ 
/*    */   public CGetBidRankReq() {}
/*    */   
/*    */ 
/*    */   public CGetBidRankReq(int _activityid_)
/*    */   {
/* 43 */     this.activityid = _activityid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.activityid);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.activityid = _os_.unmarshal_int();
/* 57 */     if (!_validator_()) {
/* 58 */       throw new VerifyError("validator failed");
/*    */     }
/* 60 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 64 */     if (_o1_ == this) return true;
/* 65 */     if ((_o1_ instanceof CGetBidRankReq)) {
/* 66 */       CGetBidRankReq _o_ = (CGetBidRankReq)_o1_;
/* 67 */       if (this.activityid != _o_.activityid) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += this.activityid;
/* 76 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 80 */     StringBuilder _sb_ = new StringBuilder();
/* 81 */     _sb_.append("(");
/* 82 */     _sb_.append(this.activityid).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CGetBidRankReq _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = this.activityid - _o_.activityid;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\auction\CGetBidRankReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */