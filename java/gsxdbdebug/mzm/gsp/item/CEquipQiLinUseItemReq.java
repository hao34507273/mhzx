/*     */ package mzm.gsp.item;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.item.main.PEquipQiLinUseItemReq;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CEquipQiLinUseItemReq
/*     */   extends __CEquipQiLinUseItemReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12584852;
/*     */   public int bagid;
/*     */   public int key;
/*     */   public int itemid;
/*     */   public int itemnum;
/*     */   
/*     */   protected void process()
/*     */   {
/*  21 */     long roleid = Role.getRoleId(this);
/*  22 */     Role.addRoleProcedure(roleid, new PEquipQiLinUseItemReq(roleid, this.bagid, this.key, this.itemid, this.itemnum));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  30 */     return 12584852;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CEquipQiLinUseItemReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CEquipQiLinUseItemReq(int _bagid_, int _key_, int _itemid_, int _itemnum_)
/*     */   {
/*  42 */     this.bagid = _bagid_;
/*  43 */     this.key = _key_;
/*  44 */     this.itemid = _itemid_;
/*  45 */     this.itemnum = _itemnum_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  49 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  53 */     _os_.marshal(this.bagid);
/*  54 */     _os_.marshal(this.key);
/*  55 */     _os_.marshal(this.itemid);
/*  56 */     _os_.marshal(this.itemnum);
/*  57 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  61 */     this.bagid = _os_.unmarshal_int();
/*  62 */     this.key = _os_.unmarshal_int();
/*  63 */     this.itemid = _os_.unmarshal_int();
/*  64 */     this.itemnum = _os_.unmarshal_int();
/*  65 */     if (!_validator_()) {
/*  66 */       throw new VerifyError("validator failed");
/*     */     }
/*  68 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  72 */     if (_o1_ == this) return true;
/*  73 */     if ((_o1_ instanceof CEquipQiLinUseItemReq)) {
/*  74 */       CEquipQiLinUseItemReq _o_ = (CEquipQiLinUseItemReq)_o1_;
/*  75 */       if (this.bagid != _o_.bagid) return false;
/*  76 */       if (this.key != _o_.key) return false;
/*  77 */       if (this.itemid != _o_.itemid) return false;
/*  78 */       if (this.itemnum != _o_.itemnum) return false;
/*  79 */       return true;
/*     */     }
/*  81 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  85 */     int _h_ = 0;
/*  86 */     _h_ += this.bagid;
/*  87 */     _h_ += this.key;
/*  88 */     _h_ += this.itemid;
/*  89 */     _h_ += this.itemnum;
/*  90 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  94 */     StringBuilder _sb_ = new StringBuilder();
/*  95 */     _sb_.append("(");
/*  96 */     _sb_.append(this.bagid).append(",");
/*  97 */     _sb_.append(this.key).append(",");
/*  98 */     _sb_.append(this.itemid).append(",");
/*  99 */     _sb_.append(this.itemnum).append(",");
/* 100 */     _sb_.append(")");
/* 101 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CEquipQiLinUseItemReq _o_) {
/* 105 */     if (_o_ == this) return 0;
/* 106 */     int _c_ = 0;
/* 107 */     _c_ = this.bagid - _o_.bagid;
/* 108 */     if (0 != _c_) return _c_;
/* 109 */     _c_ = this.key - _o_.key;
/* 110 */     if (0 != _c_) return _c_;
/* 111 */     _c_ = this.itemid - _o_.itemid;
/* 112 */     if (0 != _c_) return _c_;
/* 113 */     _c_ = this.itemnum - _o_.itemnum;
/* 114 */     if (0 != _c_) return _c_;
/* 115 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\CEquipQiLinUseItemReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */