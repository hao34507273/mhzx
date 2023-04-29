/*     */ package mzm.gsp.baitan;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.baitan.main.PQueryItemInfo;
/*     */ 
/*     */ 
/*     */ public class CQueryItemReq
/*     */   extends __CQueryItemReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12584986;
/*     */   public int index;
/*     */   public int itemid;
/*     */   public int num;
/*     */   public int price;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleId = Role.getRoleId(this);
/*  21 */     if (roleId < 0L) {
/*  22 */       return;
/*     */     }
/*  24 */     Role.addRoleProcedure(roleId, new PQueryItemInfo(roleId, this.index, this.itemid, this.price));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  33 */     return 12584986;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CQueryItemReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CQueryItemReq(int _index_, int _itemid_, int _num_, int _price_)
/*     */   {
/*  45 */     this.index = _index_;
/*  46 */     this.itemid = _itemid_;
/*  47 */     this.num = _num_;
/*  48 */     this.price = _price_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  52 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  56 */     _os_.marshal(this.index);
/*  57 */     _os_.marshal(this.itemid);
/*  58 */     _os_.marshal(this.num);
/*  59 */     _os_.marshal(this.price);
/*  60 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  64 */     this.index = _os_.unmarshal_int();
/*  65 */     this.itemid = _os_.unmarshal_int();
/*  66 */     this.num = _os_.unmarshal_int();
/*  67 */     this.price = _os_.unmarshal_int();
/*  68 */     if (!_validator_()) {
/*  69 */       throw new VerifyError("validator failed");
/*     */     }
/*  71 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  75 */     if (_o1_ == this) return true;
/*  76 */     if ((_o1_ instanceof CQueryItemReq)) {
/*  77 */       CQueryItemReq _o_ = (CQueryItemReq)_o1_;
/*  78 */       if (this.index != _o_.index) return false;
/*  79 */       if (this.itemid != _o_.itemid) return false;
/*  80 */       if (this.num != _o_.num) return false;
/*  81 */       if (this.price != _o_.price) return false;
/*  82 */       return true;
/*     */     }
/*  84 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  88 */     int _h_ = 0;
/*  89 */     _h_ += this.index;
/*  90 */     _h_ += this.itemid;
/*  91 */     _h_ += this.num;
/*  92 */     _h_ += this.price;
/*  93 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  97 */     StringBuilder _sb_ = new StringBuilder();
/*  98 */     _sb_.append("(");
/*  99 */     _sb_.append(this.index).append(",");
/* 100 */     _sb_.append(this.itemid).append(",");
/* 101 */     _sb_.append(this.num).append(",");
/* 102 */     _sb_.append(this.price).append(",");
/* 103 */     _sb_.append(")");
/* 104 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CQueryItemReq _o_) {
/* 108 */     if (_o_ == this) return 0;
/* 109 */     int _c_ = 0;
/* 110 */     _c_ = this.index - _o_.index;
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     _c_ = this.itemid - _o_.itemid;
/* 113 */     if (0 != _c_) return _c_;
/* 114 */     _c_ = this.num - _o_.num;
/* 115 */     if (0 != _c_) return _c_;
/* 116 */     _c_ = this.price - _o_.price;
/* 117 */     if (0 != _c_) return _c_;
/* 118 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\baitan\CQueryItemReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */