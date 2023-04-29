/*     */ package mzm.gsp.shanghui;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.shanghui.main.PCGetSellItemReq;
/*     */ 
/*     */ 
/*     */ public class CGetSellItemPriceReq
/*     */   extends __CGetSellItemPriceReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12592649;
/*     */   public int bagid;
/*     */   public int itemkey;
/*     */   public int itemid;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     long roleId = Role.getRoleId(this);
/*  20 */     if (roleId < 0L) {
/*  21 */       return;
/*     */     }
/*  23 */     Role.addRoleProcedure(roleId, new PCGetSellItemReq(roleId, this.bagid, this.itemid, this.itemkey));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  31 */     return 12592649;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CGetSellItemPriceReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CGetSellItemPriceReq(int _bagid_, int _itemkey_, int _itemid_)
/*     */   {
/*  42 */     this.bagid = _bagid_;
/*  43 */     this.itemkey = _itemkey_;
/*  44 */     this.itemid = _itemid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.bagid);
/*  53 */     _os_.marshal(this.itemkey);
/*  54 */     _os_.marshal(this.itemid);
/*  55 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  59 */     this.bagid = _os_.unmarshal_int();
/*  60 */     this.itemkey = _os_.unmarshal_int();
/*  61 */     this.itemid = _os_.unmarshal_int();
/*  62 */     if (!_validator_()) {
/*  63 */       throw new VerifyError("validator failed");
/*     */     }
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  69 */     if (_o1_ == this) return true;
/*  70 */     if ((_o1_ instanceof CGetSellItemPriceReq)) {
/*  71 */       CGetSellItemPriceReq _o_ = (CGetSellItemPriceReq)_o1_;
/*  72 */       if (this.bagid != _o_.bagid) return false;
/*  73 */       if (this.itemkey != _o_.itemkey) return false;
/*  74 */       if (this.itemid != _o_.itemid) return false;
/*  75 */       return true;
/*     */     }
/*  77 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  81 */     int _h_ = 0;
/*  82 */     _h_ += this.bagid;
/*  83 */     _h_ += this.itemkey;
/*  84 */     _h_ += this.itemid;
/*  85 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  89 */     StringBuilder _sb_ = new StringBuilder();
/*  90 */     _sb_.append("(");
/*  91 */     _sb_.append(this.bagid).append(",");
/*  92 */     _sb_.append(this.itemkey).append(",");
/*  93 */     _sb_.append(this.itemid).append(",");
/*  94 */     _sb_.append(")");
/*  95 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CGetSellItemPriceReq _o_) {
/*  99 */     if (_o_ == this) return 0;
/* 100 */     int _c_ = 0;
/* 101 */     _c_ = this.bagid - _o_.bagid;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     _c_ = this.itemkey - _o_.itemkey;
/* 104 */     if (0 != _c_) return _c_;
/* 105 */     _c_ = this.itemid - _o_.itemid;
/* 106 */     if (0 != _c_) return _c_;
/* 107 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shanghui\CGetSellItemPriceReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */