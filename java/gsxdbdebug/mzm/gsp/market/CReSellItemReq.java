/*     */ package mzm.gsp.market;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.market.main.PReSellItemReq;
/*     */ 
/*     */ public class CReSellItemReq extends __CReSellItemReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12601351;
/*     */   public long marketid;
/*     */   public int itemid;
/*     */   public int price;
/*     */   public int num;
/*     */   
/*     */   protected void process()
/*     */   {
/*  18 */     long roleId = Role.getRoleId(this);
/*  19 */     if (roleId < 0L) {
/*  20 */       return;
/*     */     }
/*  22 */     Role.addRoleProcedure(roleId, new PReSellItemReq(roleId, this.marketid, this.itemid, this.price, this.num));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  31 */     return 12601351;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CReSellItemReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CReSellItemReq(long _marketid_, int _itemid_, int _price_, int _num_)
/*     */   {
/*  43 */     this.marketid = _marketid_;
/*  44 */     this.itemid = _itemid_;
/*  45 */     this.price = _price_;
/*  46 */     this.num = _num_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  50 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  54 */     _os_.marshal(this.marketid);
/*  55 */     _os_.marshal(this.itemid);
/*  56 */     _os_.marshal(this.price);
/*  57 */     _os_.marshal(this.num);
/*  58 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  62 */     this.marketid = _os_.unmarshal_long();
/*  63 */     this.itemid = _os_.unmarshal_int();
/*  64 */     this.price = _os_.unmarshal_int();
/*  65 */     this.num = _os_.unmarshal_int();
/*  66 */     if (!_validator_()) {
/*  67 */       throw new VerifyError("validator failed");
/*     */     }
/*  69 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  73 */     if (_o1_ == this) return true;
/*  74 */     if ((_o1_ instanceof CReSellItemReq)) {
/*  75 */       CReSellItemReq _o_ = (CReSellItemReq)_o1_;
/*  76 */       if (this.marketid != _o_.marketid) return false;
/*  77 */       if (this.itemid != _o_.itemid) return false;
/*  78 */       if (this.price != _o_.price) return false;
/*  79 */       if (this.num != _o_.num) return false;
/*  80 */       return true;
/*     */     }
/*  82 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  86 */     int _h_ = 0;
/*  87 */     _h_ += (int)this.marketid;
/*  88 */     _h_ += this.itemid;
/*  89 */     _h_ += this.price;
/*  90 */     _h_ += this.num;
/*  91 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  95 */     StringBuilder _sb_ = new StringBuilder();
/*  96 */     _sb_.append("(");
/*  97 */     _sb_.append(this.marketid).append(",");
/*  98 */     _sb_.append(this.itemid).append(",");
/*  99 */     _sb_.append(this.price).append(",");
/* 100 */     _sb_.append(this.num).append(",");
/* 101 */     _sb_.append(")");
/* 102 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CReSellItemReq _o_) {
/* 106 */     if (_o_ == this) return 0;
/* 107 */     int _c_ = 0;
/* 108 */     _c_ = Long.signum(this.marketid - _o_.marketid);
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     _c_ = this.itemid - _o_.itemid;
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     _c_ = this.price - _o_.price;
/* 113 */     if (0 != _c_) return _c_;
/* 114 */     _c_ = this.num - _o_.num;
/* 115 */     if (0 != _c_) return _c_;
/* 116 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\CReSellItemReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */