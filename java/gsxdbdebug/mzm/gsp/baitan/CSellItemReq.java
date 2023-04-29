/*     */ package mzm.gsp.baitan;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.baitan.main.PSellItemReq;
/*     */ 
/*     */ public class CSellItemReq extends __CSellItemReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12584975;
/*     */   public int bagid;
/*     */   public int itemkey;
/*     */   public int itemid;
/*     */   public int price;
/*     */   public int num;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     long roleId = Role.getRoleId(this);
/*  20 */     if (roleId < 0L) {
/*  21 */       return;
/*     */     }
/*  23 */     Role.addRoleProcedure(roleId, new PSellItemReq(roleId, this.bagid, this.itemkey, this.itemid, this.price, this.num));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  31 */     return 12584975;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CSellItemReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CSellItemReq(int _bagid_, int _itemkey_, int _itemid_, int _price_, int _num_)
/*     */   {
/*  44 */     this.bagid = _bagid_;
/*  45 */     this.itemkey = _itemkey_;
/*  46 */     this.itemid = _itemid_;
/*  47 */     this.price = _price_;
/*  48 */     this.num = _num_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  52 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  56 */     _os_.marshal(this.bagid);
/*  57 */     _os_.marshal(this.itemkey);
/*  58 */     _os_.marshal(this.itemid);
/*  59 */     _os_.marshal(this.price);
/*  60 */     _os_.marshal(this.num);
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  65 */     this.bagid = _os_.unmarshal_int();
/*  66 */     this.itemkey = _os_.unmarshal_int();
/*  67 */     this.itemid = _os_.unmarshal_int();
/*  68 */     this.price = _os_.unmarshal_int();
/*  69 */     this.num = _os_.unmarshal_int();
/*  70 */     if (!_validator_()) {
/*  71 */       throw new VerifyError("validator failed");
/*     */     }
/*  73 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  77 */     if (_o1_ == this) return true;
/*  78 */     if ((_o1_ instanceof CSellItemReq)) {
/*  79 */       CSellItemReq _o_ = (CSellItemReq)_o1_;
/*  80 */       if (this.bagid != _o_.bagid) return false;
/*  81 */       if (this.itemkey != _o_.itemkey) return false;
/*  82 */       if (this.itemid != _o_.itemid) return false;
/*  83 */       if (this.price != _o_.price) return false;
/*  84 */       if (this.num != _o_.num) return false;
/*  85 */       return true;
/*     */     }
/*  87 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  91 */     int _h_ = 0;
/*  92 */     _h_ += this.bagid;
/*  93 */     _h_ += this.itemkey;
/*  94 */     _h_ += this.itemid;
/*  95 */     _h_ += this.price;
/*  96 */     _h_ += this.num;
/*  97 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 101 */     StringBuilder _sb_ = new StringBuilder();
/* 102 */     _sb_.append("(");
/* 103 */     _sb_.append(this.bagid).append(",");
/* 104 */     _sb_.append(this.itemkey).append(",");
/* 105 */     _sb_.append(this.itemid).append(",");
/* 106 */     _sb_.append(this.price).append(",");
/* 107 */     _sb_.append(this.num).append(",");
/* 108 */     _sb_.append(")");
/* 109 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CSellItemReq _o_) {
/* 113 */     if (_o_ == this) return 0;
/* 114 */     int _c_ = 0;
/* 115 */     _c_ = this.bagid - _o_.bagid;
/* 116 */     if (0 != _c_) return _c_;
/* 117 */     _c_ = this.itemkey - _o_.itemkey;
/* 118 */     if (0 != _c_) return _c_;
/* 119 */     _c_ = this.itemid - _o_.itemid;
/* 120 */     if (0 != _c_) return _c_;
/* 121 */     _c_ = this.price - _o_.price;
/* 122 */     if (0 != _c_) return _c_;
/* 123 */     _c_ = this.num - _o_.num;
/* 124 */     if (0 != _c_) return _c_;
/* 125 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\baitan\CSellItemReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */