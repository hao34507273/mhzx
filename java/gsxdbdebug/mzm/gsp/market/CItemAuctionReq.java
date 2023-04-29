/*     */ package mzm.gsp.market;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.market.auction.PItemAuction;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CItemAuctionReq
/*     */   extends __CItemAuctionReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12601425;
/*     */   public long marketid;
/*     */   public int itemid;
/*     */   public int price;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleId = Role.getRoleId(this);
/*  21 */     if (roleId < 0L) {
/*  22 */       return;
/*     */     }
/*  24 */     Role.addRoleProcedure(roleId, new PItemAuction(roleId, this.marketid, this.itemid, this.price));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  32 */     return 12601425;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CItemAuctionReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CItemAuctionReq(long _marketid_, int _itemid_, int _price_)
/*     */   {
/*  43 */     this.marketid = _marketid_;
/*  44 */     this.itemid = _itemid_;
/*  45 */     this.price = _price_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  49 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  53 */     _os_.marshal(this.marketid);
/*  54 */     _os_.marshal(this.itemid);
/*  55 */     _os_.marshal(this.price);
/*  56 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  60 */     this.marketid = _os_.unmarshal_long();
/*  61 */     this.itemid = _os_.unmarshal_int();
/*  62 */     this.price = _os_.unmarshal_int();
/*  63 */     if (!_validator_()) {
/*  64 */       throw new VerifyError("validator failed");
/*     */     }
/*  66 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  70 */     if (_o1_ == this) return true;
/*  71 */     if ((_o1_ instanceof CItemAuctionReq)) {
/*  72 */       CItemAuctionReq _o_ = (CItemAuctionReq)_o1_;
/*  73 */       if (this.marketid != _o_.marketid) return false;
/*  74 */       if (this.itemid != _o_.itemid) return false;
/*  75 */       if (this.price != _o_.price) return false;
/*  76 */       return true;
/*     */     }
/*  78 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  82 */     int _h_ = 0;
/*  83 */     _h_ += (int)this.marketid;
/*  84 */     _h_ += this.itemid;
/*  85 */     _h_ += this.price;
/*  86 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  90 */     StringBuilder _sb_ = new StringBuilder();
/*  91 */     _sb_.append("(");
/*  92 */     _sb_.append(this.marketid).append(",");
/*  93 */     _sb_.append(this.itemid).append(",");
/*  94 */     _sb_.append(this.price).append(",");
/*  95 */     _sb_.append(")");
/*  96 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CItemAuctionReq _o_) {
/* 100 */     if (_o_ == this) return 0;
/* 101 */     int _c_ = 0;
/* 102 */     _c_ = Long.signum(this.marketid - _o_.marketid);
/* 103 */     if (0 != _c_) return _c_;
/* 104 */     _c_ = this.itemid - _o_.itemid;
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = this.price - _o_.price;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\CItemAuctionReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */