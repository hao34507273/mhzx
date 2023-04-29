/*     */ package mzm.gsp.market;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.market.main.PSellItemReq;
/*     */ 
/*     */ public class CSellItemReq extends __CSellItemReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12601353;
/*     */   public int itemkey;
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
/*  22 */     Role.addRoleProcedure(roleId, new PSellItemReq(roleId, this.itemkey, this.itemid, this.price, this.num));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  30 */     return 12601353;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CSellItemReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CSellItemReq(int _itemkey_, int _itemid_, int _price_, int _num_)
/*     */   {
/*  42 */     this.itemkey = _itemkey_;
/*  43 */     this.itemid = _itemid_;
/*  44 */     this.price = _price_;
/*  45 */     this.num = _num_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  49 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  53 */     _os_.marshal(this.itemkey);
/*  54 */     _os_.marshal(this.itemid);
/*  55 */     _os_.marshal(this.price);
/*  56 */     _os_.marshal(this.num);
/*  57 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  61 */     this.itemkey = _os_.unmarshal_int();
/*  62 */     this.itemid = _os_.unmarshal_int();
/*  63 */     this.price = _os_.unmarshal_int();
/*  64 */     this.num = _os_.unmarshal_int();
/*  65 */     if (!_validator_()) {
/*  66 */       throw new VerifyError("validator failed");
/*     */     }
/*  68 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  72 */     if (_o1_ == this) return true;
/*  73 */     if ((_o1_ instanceof CSellItemReq)) {
/*  74 */       CSellItemReq _o_ = (CSellItemReq)_o1_;
/*  75 */       if (this.itemkey != _o_.itemkey) return false;
/*  76 */       if (this.itemid != _o_.itemid) return false;
/*  77 */       if (this.price != _o_.price) return false;
/*  78 */       if (this.num != _o_.num) return false;
/*  79 */       return true;
/*     */     }
/*  81 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  85 */     int _h_ = 0;
/*  86 */     _h_ += this.itemkey;
/*  87 */     _h_ += this.itemid;
/*  88 */     _h_ += this.price;
/*  89 */     _h_ += this.num;
/*  90 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  94 */     StringBuilder _sb_ = new StringBuilder();
/*  95 */     _sb_.append("(");
/*  96 */     _sb_.append(this.itemkey).append(",");
/*  97 */     _sb_.append(this.itemid).append(",");
/*  98 */     _sb_.append(this.price).append(",");
/*  99 */     _sb_.append(this.num).append(",");
/* 100 */     _sb_.append(")");
/* 101 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CSellItemReq _o_) {
/* 105 */     if (_o_ == this) return 0;
/* 106 */     int _c_ = 0;
/* 107 */     _c_ = this.itemkey - _o_.itemkey;
/* 108 */     if (0 != _c_) return _c_;
/* 109 */     _c_ = this.itemid - _o_.itemid;
/* 110 */     if (0 != _c_) return _c_;
/* 111 */     _c_ = this.price - _o_.price;
/* 112 */     if (0 != _c_) return _c_;
/* 113 */     _c_ = this.num - _o_.num;
/* 114 */     if (0 != _c_) return _c_;
/* 115 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\CSellItemReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */