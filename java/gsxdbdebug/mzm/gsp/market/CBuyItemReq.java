/*     */ package mzm.gsp.market;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.market.main.PBuyItemReq;
/*     */ 
/*     */ 
/*     */ public class CBuyItemReq
/*     */   extends __CBuyItemReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12601358;
/*     */   public long marketid;
/*     */   public int itemid;
/*     */   public int price;
/*     */   public int buynum;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleId = Role.getRoleId(this);
/*  21 */     if (roleId < 0L) {
/*  22 */       return;
/*     */     }
/*  24 */     Role.addRoleProcedure(roleId, new PBuyItemReq(roleId, this.marketid, this.itemid, this.price, this.buynum));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  33 */     return 12601358;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CBuyItemReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CBuyItemReq(long _marketid_, int _itemid_, int _price_, int _buynum_)
/*     */   {
/*  45 */     this.marketid = _marketid_;
/*  46 */     this.itemid = _itemid_;
/*  47 */     this.price = _price_;
/*  48 */     this.buynum = _buynum_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  52 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  56 */     _os_.marshal(this.marketid);
/*  57 */     _os_.marshal(this.itemid);
/*  58 */     _os_.marshal(this.price);
/*  59 */     _os_.marshal(this.buynum);
/*  60 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  64 */     this.marketid = _os_.unmarshal_long();
/*  65 */     this.itemid = _os_.unmarshal_int();
/*  66 */     this.price = _os_.unmarshal_int();
/*  67 */     this.buynum = _os_.unmarshal_int();
/*  68 */     if (!_validator_()) {
/*  69 */       throw new VerifyError("validator failed");
/*     */     }
/*  71 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  75 */     if (_o1_ == this) return true;
/*  76 */     if ((_o1_ instanceof CBuyItemReq)) {
/*  77 */       CBuyItemReq _o_ = (CBuyItemReq)_o1_;
/*  78 */       if (this.marketid != _o_.marketid) return false;
/*  79 */       if (this.itemid != _o_.itemid) return false;
/*  80 */       if (this.price != _o_.price) return false;
/*  81 */       if (this.buynum != _o_.buynum) return false;
/*  82 */       return true;
/*     */     }
/*  84 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  88 */     int _h_ = 0;
/*  89 */     _h_ += (int)this.marketid;
/*  90 */     _h_ += this.itemid;
/*  91 */     _h_ += this.price;
/*  92 */     _h_ += this.buynum;
/*  93 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  97 */     StringBuilder _sb_ = new StringBuilder();
/*  98 */     _sb_.append("(");
/*  99 */     _sb_.append(this.marketid).append(",");
/* 100 */     _sb_.append(this.itemid).append(",");
/* 101 */     _sb_.append(this.price).append(",");
/* 102 */     _sb_.append(this.buynum).append(",");
/* 103 */     _sb_.append(")");
/* 104 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CBuyItemReq _o_) {
/* 108 */     if (_o_ == this) return 0;
/* 109 */     int _c_ = 0;
/* 110 */     _c_ = Long.signum(this.marketid - _o_.marketid);
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     _c_ = this.itemid - _o_.itemid;
/* 113 */     if (0 != _c_) return _c_;
/* 114 */     _c_ = this.price - _o_.price;
/* 115 */     if (0 != _c_) return _c_;
/* 116 */     _c_ = this.buynum - _o_.buynum;
/* 117 */     if (0 != _c_) return _c_;
/* 118 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\CBuyItemReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */