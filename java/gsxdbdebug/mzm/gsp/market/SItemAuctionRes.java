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
/*     */ public class SItemAuctionRes
/*     */   extends __SItemAuctionRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12601421;
/*     */   public long marketid;
/*     */   public int itemid;
/*     */   public int price;
/*     */   public long endtime;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  25 */     return 12601421;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SItemAuctionRes() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SItemAuctionRes(long _marketid_, int _itemid_, int _price_, long _endtime_)
/*     */   {
/*  37 */     this.marketid = _marketid_;
/*  38 */     this.itemid = _itemid_;
/*  39 */     this.price = _price_;
/*  40 */     this.endtime = _endtime_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.marketid);
/*  49 */     _os_.marshal(this.itemid);
/*  50 */     _os_.marshal(this.price);
/*  51 */     _os_.marshal(this.endtime);
/*  52 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  56 */     this.marketid = _os_.unmarshal_long();
/*  57 */     this.itemid = _os_.unmarshal_int();
/*  58 */     this.price = _os_.unmarshal_int();
/*  59 */     this.endtime = _os_.unmarshal_long();
/*  60 */     if (!_validator_()) {
/*  61 */       throw new VerifyError("validator failed");
/*     */     }
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  67 */     if (_o1_ == this) return true;
/*  68 */     if ((_o1_ instanceof SItemAuctionRes)) {
/*  69 */       SItemAuctionRes _o_ = (SItemAuctionRes)_o1_;
/*  70 */       if (this.marketid != _o_.marketid) return false;
/*  71 */       if (this.itemid != _o_.itemid) return false;
/*  72 */       if (this.price != _o_.price) return false;
/*  73 */       if (this.endtime != _o_.endtime) return false;
/*  74 */       return true;
/*     */     }
/*  76 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  80 */     int _h_ = 0;
/*  81 */     _h_ += (int)this.marketid;
/*  82 */     _h_ += this.itemid;
/*  83 */     _h_ += this.price;
/*  84 */     _h_ += (int)this.endtime;
/*  85 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  89 */     StringBuilder _sb_ = new StringBuilder();
/*  90 */     _sb_.append("(");
/*  91 */     _sb_.append(this.marketid).append(",");
/*  92 */     _sb_.append(this.itemid).append(",");
/*  93 */     _sb_.append(this.price).append(",");
/*  94 */     _sb_.append(this.endtime).append(",");
/*  95 */     _sb_.append(")");
/*  96 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SItemAuctionRes _o_) {
/* 100 */     if (_o_ == this) return 0;
/* 101 */     int _c_ = 0;
/* 102 */     _c_ = Long.signum(this.marketid - _o_.marketid);
/* 103 */     if (0 != _c_) return _c_;
/* 104 */     _c_ = this.itemid - _o_.itemid;
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = this.price - _o_.price;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = Long.signum(this.endtime - _o_.endtime);
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\SItemAuctionRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */