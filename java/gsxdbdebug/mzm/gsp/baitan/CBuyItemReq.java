/*     */ package mzm.gsp.baitan;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.baitan.main.PBuyItemReq;
/*     */ 
/*     */ public class CBuyItemReq
/*     */   extends __CBuyItemReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12584961;
/*     */   public int index;
/*     */   public int itemid;
/*     */   public int num;
/*     */   public int price;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     long roleId = Role.getRoleId(this);
/*  20 */     if (roleId < 0L) {
/*  21 */       return;
/*     */     }
/*  23 */     Role.addRoleProcedure(roleId, new PBuyItemReq(roleId, this.itemid, this.price, this.index));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  31 */     return 12584961;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CBuyItemReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CBuyItemReq(int _index_, int _itemid_, int _num_, int _price_)
/*     */   {
/*  43 */     this.index = _index_;
/*  44 */     this.itemid = _itemid_;
/*  45 */     this.num = _num_;
/*  46 */     this.price = _price_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  50 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  54 */     _os_.marshal(this.index);
/*  55 */     _os_.marshal(this.itemid);
/*  56 */     _os_.marshal(this.num);
/*  57 */     _os_.marshal(this.price);
/*  58 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  62 */     this.index = _os_.unmarshal_int();
/*  63 */     this.itemid = _os_.unmarshal_int();
/*  64 */     this.num = _os_.unmarshal_int();
/*  65 */     this.price = _os_.unmarshal_int();
/*  66 */     if (!_validator_()) {
/*  67 */       throw new VerifyError("validator failed");
/*     */     }
/*  69 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  73 */     if (_o1_ == this) return true;
/*  74 */     if ((_o1_ instanceof CBuyItemReq)) {
/*  75 */       CBuyItemReq _o_ = (CBuyItemReq)_o1_;
/*  76 */       if (this.index != _o_.index) return false;
/*  77 */       if (this.itemid != _o_.itemid) return false;
/*  78 */       if (this.num != _o_.num) return false;
/*  79 */       if (this.price != _o_.price) return false;
/*  80 */       return true;
/*     */     }
/*  82 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  86 */     int _h_ = 0;
/*  87 */     _h_ += this.index;
/*  88 */     _h_ += this.itemid;
/*  89 */     _h_ += this.num;
/*  90 */     _h_ += this.price;
/*  91 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  95 */     StringBuilder _sb_ = new StringBuilder();
/*  96 */     _sb_.append("(");
/*  97 */     _sb_.append(this.index).append(",");
/*  98 */     _sb_.append(this.itemid).append(",");
/*  99 */     _sb_.append(this.num).append(",");
/* 100 */     _sb_.append(this.price).append(",");
/* 101 */     _sb_.append(")");
/* 102 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CBuyItemReq _o_) {
/* 106 */     if (_o_ == this) return 0;
/* 107 */     int _c_ = 0;
/* 108 */     _c_ = this.index - _o_.index;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     _c_ = this.itemid - _o_.itemid;
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     _c_ = this.num - _o_.num;
/* 113 */     if (0 != _c_) return _c_;
/* 114 */     _c_ = this.price - _o_.price;
/* 115 */     if (0 != _c_) return _c_;
/* 116 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\baitan\CBuyItemReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */