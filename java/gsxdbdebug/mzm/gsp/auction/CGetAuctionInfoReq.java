/*     */ package mzm.gsp.auction;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.auction.main.AuctionOneByOneManager;
/*     */ import mzm.gsp.auction.main.PCGetAuctionInfoReq;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CGetAuctionInfoReq
/*     */   extends __CGetAuctionInfoReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12627204;
/*     */   public int activityid;
/*     */   public int turnindex;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleId = Role.getRoleId(this);
/*  21 */     if (roleId <= 0L)
/*     */     {
/*  23 */       return;
/*     */     }
/*  25 */     AuctionOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(this.activityid), new PCGetAuctionInfoReq(roleId, this.activityid, this.turnindex));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  34 */     return 12627204;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CGetAuctionInfoReq() {}
/*     */   
/*     */ 
/*     */   public CGetAuctionInfoReq(int _activityid_, int _turnindex_)
/*     */   {
/*  44 */     this.activityid = _activityid_;
/*  45 */     this.turnindex = _turnindex_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  49 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  53 */     _os_.marshal(this.activityid);
/*  54 */     _os_.marshal(this.turnindex);
/*  55 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  59 */     this.activityid = _os_.unmarshal_int();
/*  60 */     this.turnindex = _os_.unmarshal_int();
/*  61 */     if (!_validator_()) {
/*  62 */       throw new VerifyError("validator failed");
/*     */     }
/*  64 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  68 */     if (_o1_ == this) return true;
/*  69 */     if ((_o1_ instanceof CGetAuctionInfoReq)) {
/*  70 */       CGetAuctionInfoReq _o_ = (CGetAuctionInfoReq)_o1_;
/*  71 */       if (this.activityid != _o_.activityid) return false;
/*  72 */       if (this.turnindex != _o_.turnindex) return false;
/*  73 */       return true;
/*     */     }
/*  75 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  79 */     int _h_ = 0;
/*  80 */     _h_ += this.activityid;
/*  81 */     _h_ += this.turnindex;
/*  82 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  86 */     StringBuilder _sb_ = new StringBuilder();
/*  87 */     _sb_.append("(");
/*  88 */     _sb_.append(this.activityid).append(",");
/*  89 */     _sb_.append(this.turnindex).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CGetAuctionInfoReq _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = this.activityid - _o_.activityid;
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = this.turnindex - _o_.turnindex;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\auction\CGetAuctionInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */