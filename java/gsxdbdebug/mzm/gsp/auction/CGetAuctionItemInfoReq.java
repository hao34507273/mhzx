/*     */ package mzm.gsp.auction;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.auction.main.AuctionOneByOneManager;
/*     */ import mzm.gsp.auction.main.PCGetAuctionItemInfoReq;
/*     */ 
/*     */ 
/*     */ public class CGetAuctionItemInfoReq
/*     */   extends __CGetAuctionItemInfoReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12627202;
/*     */   public int activityid;
/*     */   public int turnindex;
/*     */   public int itemcfgid;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleId = Role.getRoleId(this);
/*  21 */     if (roleId <= 0L)
/*     */     {
/*  23 */       return;
/*     */     }
/*  25 */     AuctionOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(this.activityid), new PCGetAuctionItemInfoReq(roleId, this.activityid, this.turnindex, this.itemcfgid));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  34 */     return 12627202;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CGetAuctionItemInfoReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CGetAuctionItemInfoReq(int _activityid_, int _turnindex_, int _itemcfgid_)
/*     */   {
/*  45 */     this.activityid = _activityid_;
/*  46 */     this.turnindex = _turnindex_;
/*  47 */     this.itemcfgid = _itemcfgid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  51 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  55 */     _os_.marshal(this.activityid);
/*  56 */     _os_.marshal(this.turnindex);
/*  57 */     _os_.marshal(this.itemcfgid);
/*  58 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  62 */     this.activityid = _os_.unmarshal_int();
/*  63 */     this.turnindex = _os_.unmarshal_int();
/*  64 */     this.itemcfgid = _os_.unmarshal_int();
/*  65 */     if (!_validator_()) {
/*  66 */       throw new VerifyError("validator failed");
/*     */     }
/*  68 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  72 */     if (_o1_ == this) return true;
/*  73 */     if ((_o1_ instanceof CGetAuctionItemInfoReq)) {
/*  74 */       CGetAuctionItemInfoReq _o_ = (CGetAuctionItemInfoReq)_o1_;
/*  75 */       if (this.activityid != _o_.activityid) return false;
/*  76 */       if (this.turnindex != _o_.turnindex) return false;
/*  77 */       if (this.itemcfgid != _o_.itemcfgid) return false;
/*  78 */       return true;
/*     */     }
/*  80 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  84 */     int _h_ = 0;
/*  85 */     _h_ += this.activityid;
/*  86 */     _h_ += this.turnindex;
/*  87 */     _h_ += this.itemcfgid;
/*  88 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  92 */     StringBuilder _sb_ = new StringBuilder();
/*  93 */     _sb_.append("(");
/*  94 */     _sb_.append(this.activityid).append(",");
/*  95 */     _sb_.append(this.turnindex).append(",");
/*  96 */     _sb_.append(this.itemcfgid).append(",");
/*  97 */     _sb_.append(")");
/*  98 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CGetAuctionItemInfoReq _o_) {
/* 102 */     if (_o_ == this) return 0;
/* 103 */     int _c_ = 0;
/* 104 */     _c_ = this.activityid - _o_.activityid;
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = this.turnindex - _o_.turnindex;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = this.itemcfgid - _o_.itemcfgid;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\auction\CGetAuctionItemInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */