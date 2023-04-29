/*     */ package mzm.gsp.shanghui;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.shanghui.main.PBuyItemSelecter;
/*     */ 
/*     */ 
/*     */ public class CBuyItemReq
/*     */   extends __CBuyItemReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12592644;
/*     */   public long curgold;
/*     */   public int itemid;
/*     */   public int itemnum;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     long roleId = Role.getRoleId(this);
/*  20 */     if (roleId < 0L) {
/*  21 */       return;
/*     */     }
/*  23 */     Role.addRoleProcedure(roleId, new PBuyItemSelecter(roleId, this.itemid, this.itemnum, this.curgold));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  31 */     return 12592644;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CBuyItemReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CBuyItemReq(long _curgold_, int _itemid_, int _itemnum_)
/*     */   {
/*  42 */     this.curgold = _curgold_;
/*  43 */     this.itemid = _itemid_;
/*  44 */     this.itemnum = _itemnum_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.curgold);
/*  53 */     _os_.marshal(this.itemid);
/*  54 */     _os_.marshal(this.itemnum);
/*  55 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  59 */     this.curgold = _os_.unmarshal_long();
/*  60 */     this.itemid = _os_.unmarshal_int();
/*  61 */     this.itemnum = _os_.unmarshal_int();
/*  62 */     if (!_validator_()) {
/*  63 */       throw new VerifyError("validator failed");
/*     */     }
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  69 */     if (_o1_ == this) return true;
/*  70 */     if ((_o1_ instanceof CBuyItemReq)) {
/*  71 */       CBuyItemReq _o_ = (CBuyItemReq)_o1_;
/*  72 */       if (this.curgold != _o_.curgold) return false;
/*  73 */       if (this.itemid != _o_.itemid) return false;
/*  74 */       if (this.itemnum != _o_.itemnum) return false;
/*  75 */       return true;
/*     */     }
/*  77 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  81 */     int _h_ = 0;
/*  82 */     _h_ += (int)this.curgold;
/*  83 */     _h_ += this.itemid;
/*  84 */     _h_ += this.itemnum;
/*  85 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  89 */     StringBuilder _sb_ = new StringBuilder();
/*  90 */     _sb_.append("(");
/*  91 */     _sb_.append(this.curgold).append(",");
/*  92 */     _sb_.append(this.itemid).append(",");
/*  93 */     _sb_.append(this.itemnum).append(",");
/*  94 */     _sb_.append(")");
/*  95 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CBuyItemReq _o_) {
/*  99 */     if (_o_ == this) return 0;
/* 100 */     int _c_ = 0;
/* 101 */     _c_ = Long.signum(this.curgold - _o_.curgold);
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     _c_ = this.itemid - _o_.itemid;
/* 104 */     if (0 != _c_) return _c_;
/* 105 */     _c_ = this.itemnum - _o_.itemnum;
/* 106 */     if (0 != _c_) return _c_;
/* 107 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shanghui\CBuyItemReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */