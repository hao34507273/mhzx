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
/*     */ public class SQueryAuctionConcernNumRes
/*     */   extends __SQueryAuctionConcernNumRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12601450;
/*     */   public long marketid;
/*     */   public int itemorpet;
/*     */   public int concernnum;
/*     */   public int auctionnum;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  25 */     return 12601450;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SQueryAuctionConcernNumRes() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SQueryAuctionConcernNumRes(long _marketid_, int _itemorpet_, int _concernnum_, int _auctionnum_)
/*     */   {
/*  37 */     this.marketid = _marketid_;
/*  38 */     this.itemorpet = _itemorpet_;
/*  39 */     this.concernnum = _concernnum_;
/*  40 */     this.auctionnum = _auctionnum_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.marketid);
/*  49 */     _os_.marshal(this.itemorpet);
/*  50 */     _os_.marshal(this.concernnum);
/*  51 */     _os_.marshal(this.auctionnum);
/*  52 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  56 */     this.marketid = _os_.unmarshal_long();
/*  57 */     this.itemorpet = _os_.unmarshal_int();
/*  58 */     this.concernnum = _os_.unmarshal_int();
/*  59 */     this.auctionnum = _os_.unmarshal_int();
/*  60 */     if (!_validator_()) {
/*  61 */       throw new VerifyError("validator failed");
/*     */     }
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  67 */     if (_o1_ == this) return true;
/*  68 */     if ((_o1_ instanceof SQueryAuctionConcernNumRes)) {
/*  69 */       SQueryAuctionConcernNumRes _o_ = (SQueryAuctionConcernNumRes)_o1_;
/*  70 */       if (this.marketid != _o_.marketid) return false;
/*  71 */       if (this.itemorpet != _o_.itemorpet) return false;
/*  72 */       if (this.concernnum != _o_.concernnum) return false;
/*  73 */       if (this.auctionnum != _o_.auctionnum) return false;
/*  74 */       return true;
/*     */     }
/*  76 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  80 */     int _h_ = 0;
/*  81 */     _h_ += (int)this.marketid;
/*  82 */     _h_ += this.itemorpet;
/*  83 */     _h_ += this.concernnum;
/*  84 */     _h_ += this.auctionnum;
/*  85 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  89 */     StringBuilder _sb_ = new StringBuilder();
/*  90 */     _sb_.append("(");
/*  91 */     _sb_.append(this.marketid).append(",");
/*  92 */     _sb_.append(this.itemorpet).append(",");
/*  93 */     _sb_.append(this.concernnum).append(",");
/*  94 */     _sb_.append(this.auctionnum).append(",");
/*  95 */     _sb_.append(")");
/*  96 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SQueryAuctionConcernNumRes _o_) {
/* 100 */     if (_o_ == this) return 0;
/* 101 */     int _c_ = 0;
/* 102 */     _c_ = Long.signum(this.marketid - _o_.marketid);
/* 103 */     if (0 != _c_) return _c_;
/* 104 */     _c_ = this.itemorpet - _o_.itemorpet;
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = this.concernnum - _o_.concernnum;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = this.auctionnum - _o_.auctionnum;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\SQueryAuctionConcernNumRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */