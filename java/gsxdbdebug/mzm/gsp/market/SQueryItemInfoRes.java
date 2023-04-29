/*     */ package mzm.gsp.market;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.item.ItemInfo;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SQueryItemInfoRes
/*     */   extends __SQueryItemInfoRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12601355;
/*     */   public long marketid;
/*     */   public int itemid;
/*     */   public int price;
/*     */   public MarketItem marketitem;
/*     */   public ItemInfo iteminfo;
/*     */   public long sellerroleid;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  25 */     return 12601355;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SQueryItemInfoRes()
/*     */   {
/*  36 */     this.marketitem = new MarketItem();
/*  37 */     this.iteminfo = new ItemInfo();
/*     */   }
/*     */   
/*     */   public SQueryItemInfoRes(long _marketid_, int _itemid_, int _price_, MarketItem _marketitem_, ItemInfo _iteminfo_, long _sellerroleid_) {
/*  41 */     this.marketid = _marketid_;
/*  42 */     this.itemid = _itemid_;
/*  43 */     this.price = _price_;
/*  44 */     this.marketitem = _marketitem_;
/*  45 */     this.iteminfo = _iteminfo_;
/*  46 */     this.sellerroleid = _sellerroleid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  50 */     if (!this.marketitem._validator_()) return false;
/*  51 */     if (!this.iteminfo._validator_()) return false;
/*  52 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  56 */     _os_.marshal(this.marketid);
/*  57 */     _os_.marshal(this.itemid);
/*  58 */     _os_.marshal(this.price);
/*  59 */     _os_.marshal(this.marketitem);
/*  60 */     _os_.marshal(this.iteminfo);
/*  61 */     _os_.marshal(this.sellerroleid);
/*  62 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  66 */     this.marketid = _os_.unmarshal_long();
/*  67 */     this.itemid = _os_.unmarshal_int();
/*  68 */     this.price = _os_.unmarshal_int();
/*  69 */     this.marketitem.unmarshal(_os_);
/*  70 */     this.iteminfo.unmarshal(_os_);
/*  71 */     this.sellerroleid = _os_.unmarshal_long();
/*  72 */     if (!_validator_()) {
/*  73 */       throw new VerifyError("validator failed");
/*     */     }
/*  75 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  79 */     if (_o1_ == this) return true;
/*  80 */     if ((_o1_ instanceof SQueryItemInfoRes)) {
/*  81 */       SQueryItemInfoRes _o_ = (SQueryItemInfoRes)_o1_;
/*  82 */       if (this.marketid != _o_.marketid) return false;
/*  83 */       if (this.itemid != _o_.itemid) return false;
/*  84 */       if (this.price != _o_.price) return false;
/*  85 */       if (!this.marketitem.equals(_o_.marketitem)) return false;
/*  86 */       if (!this.iteminfo.equals(_o_.iteminfo)) return false;
/*  87 */       if (this.sellerroleid != _o_.sellerroleid) return false;
/*  88 */       return true;
/*     */     }
/*  90 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  94 */     int _h_ = 0;
/*  95 */     _h_ += (int)this.marketid;
/*  96 */     _h_ += this.itemid;
/*  97 */     _h_ += this.price;
/*  98 */     _h_ += this.marketitem.hashCode();
/*  99 */     _h_ += this.iteminfo.hashCode();
/* 100 */     _h_ += (int)this.sellerroleid;
/* 101 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 105 */     StringBuilder _sb_ = new StringBuilder();
/* 106 */     _sb_.append("(");
/* 107 */     _sb_.append(this.marketid).append(",");
/* 108 */     _sb_.append(this.itemid).append(",");
/* 109 */     _sb_.append(this.price).append(",");
/* 110 */     _sb_.append(this.marketitem).append(",");
/* 111 */     _sb_.append(this.iteminfo).append(",");
/* 112 */     _sb_.append(this.sellerroleid).append(",");
/* 113 */     _sb_.append(")");
/* 114 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\SQueryItemInfoRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */