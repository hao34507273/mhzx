/*     */ package mzm.gsp.pet;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ 
/*     */ public class CUseItemReq extends __CUseItemReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12590640;
/*     */   public static final int ADD_EXP_ACTION = 0;
/*     */   public static final int ADD_LIFE_ACTION = 1;
/*     */   public static final int ADD_GROW_ACTION = 2;
/*     */   public long petid;
/*     */   public int itemkey;
/*     */   public int actiontype;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     long roleId = Role.getRoleId(this);
/*  20 */     if (roleId < 0L) {
/*  21 */       return;
/*     */     }
/*  23 */     Role.addRoleProcedure(roleId, new mzm.gsp.pet.main.PUsePetItemReq(roleId, this.petid, this.itemkey, this.actiontype));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  31 */     return 12590640;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public CUseItemReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public CUseItemReq(long _petid_, int _itemkey_, int _actiontype_)
/*     */   {
/*  46 */     this.petid = _petid_;
/*  47 */     this.itemkey = _itemkey_;
/*  48 */     this.actiontype = _actiontype_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  52 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  56 */     _os_.marshal(this.petid);
/*  57 */     _os_.marshal(this.itemkey);
/*  58 */     _os_.marshal(this.actiontype);
/*  59 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  63 */     this.petid = _os_.unmarshal_long();
/*  64 */     this.itemkey = _os_.unmarshal_int();
/*  65 */     this.actiontype = _os_.unmarshal_int();
/*  66 */     if (!_validator_()) {
/*  67 */       throw new VerifyError("validator failed");
/*     */     }
/*  69 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  73 */     if (_o1_ == this) return true;
/*  74 */     if ((_o1_ instanceof CUseItemReq)) {
/*  75 */       CUseItemReq _o_ = (CUseItemReq)_o1_;
/*  76 */       if (this.petid != _o_.petid) return false;
/*  77 */       if (this.itemkey != _o_.itemkey) return false;
/*  78 */       if (this.actiontype != _o_.actiontype) return false;
/*  79 */       return true;
/*     */     }
/*  81 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  85 */     int _h_ = 0;
/*  86 */     _h_ += (int)this.petid;
/*  87 */     _h_ += this.itemkey;
/*  88 */     _h_ += this.actiontype;
/*  89 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  93 */     StringBuilder _sb_ = new StringBuilder();
/*  94 */     _sb_.append("(");
/*  95 */     _sb_.append(this.petid).append(",");
/*  96 */     _sb_.append(this.itemkey).append(",");
/*  97 */     _sb_.append(this.actiontype).append(",");
/*  98 */     _sb_.append(")");
/*  99 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CUseItemReq _o_) {
/* 103 */     if (_o_ == this) return 0;
/* 104 */     int _c_ = 0;
/* 105 */     _c_ = Long.signum(this.petid - _o_.petid);
/* 106 */     if (0 != _c_) return _c_;
/* 107 */     _c_ = this.itemkey - _o_.itemkey;
/* 108 */     if (0 != _c_) return _c_;
/* 109 */     _c_ = this.actiontype - _o_.actiontype;
/* 110 */     if (0 != _c_) return _c_;
/* 111 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\CUseItemReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */