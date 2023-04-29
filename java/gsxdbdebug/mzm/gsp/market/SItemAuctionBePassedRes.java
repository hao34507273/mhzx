/*     */ package mzm.gsp.market;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SItemAuctionBePassedRes
/*     */   extends __SItemAuctionBePassedRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12601445;
/*     */   public long marketid;
/*     */   public int itemid;
/*     */   public int myprice;
/*     */   public int newprice;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12601445;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SItemAuctionBePassedRes() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SItemAuctionBePassedRes(long _marketid_, int _itemid_, int _myprice_, int _newprice_)
/*     */   {
/*  39 */     this.marketid = _marketid_;
/*  40 */     this.itemid = _itemid_;
/*  41 */     this.myprice = _myprice_;
/*  42 */     this.newprice = _newprice_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  50 */     _os_.marshal(this.marketid);
/*  51 */     _os_.marshal(this.itemid);
/*  52 */     _os_.marshal(this.myprice);
/*  53 */     _os_.marshal(this.newprice);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.marketid = _os_.unmarshal_long();
/*  59 */     this.itemid = _os_.unmarshal_int();
/*  60 */     this.myprice = _os_.unmarshal_int();
/*  61 */     this.newprice = _os_.unmarshal_int();
/*  62 */     if (!_validator_()) {
/*  63 */       throw new VerifyError("validator failed");
/*     */     }
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  69 */     if (_o1_ == this) return true;
/*  70 */     if ((_o1_ instanceof SItemAuctionBePassedRes)) {
/*  71 */       SItemAuctionBePassedRes _o_ = (SItemAuctionBePassedRes)_o1_;
/*  72 */       if (this.marketid != _o_.marketid) return false;
/*  73 */       if (this.itemid != _o_.itemid) return false;
/*  74 */       if (this.myprice != _o_.myprice) return false;
/*  75 */       if (this.newprice != _o_.newprice) return false;
/*  76 */       return true;
/*     */     }
/*  78 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  82 */     int _h_ = 0;
/*  83 */     _h_ += (int)this.marketid;
/*  84 */     _h_ += this.itemid;
/*  85 */     _h_ += this.myprice;
/*  86 */     _h_ += this.newprice;
/*  87 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  91 */     StringBuilder _sb_ = new StringBuilder();
/*  92 */     _sb_.append("(");
/*  93 */     _sb_.append(this.marketid).append(",");
/*  94 */     _sb_.append(this.itemid).append(",");
/*  95 */     _sb_.append(this.myprice).append(",");
/*  96 */     _sb_.append(this.newprice).append(",");
/*  97 */     _sb_.append(")");
/*  98 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SItemAuctionBePassedRes _o_) {
/* 102 */     if (_o_ == this) return 0;
/* 103 */     int _c_ = 0;
/* 104 */     _c_ = Long.signum(this.marketid - _o_.marketid);
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = this.itemid - _o_.itemid;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = this.myprice - _o_.myprice;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     _c_ = this.newprice - _o_.newprice;
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\SItemAuctionBePassedRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */