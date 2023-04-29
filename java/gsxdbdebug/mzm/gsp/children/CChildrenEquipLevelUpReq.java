/*     */ package mzm.gsp.children;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.children.main.PCChildrenEquipLevelUpReq;
/*     */ 
/*     */ 
/*     */ public class CChildrenEquipLevelUpReq
/*     */   extends __CChildrenEquipLevelUpReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12609415;
/*     */   public long childrenid;
/*     */   public int pos;
/*     */   public int item_cfg_id;
/*     */   public int is_use_all;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleid = Role.getRoleId(this);
/*  21 */     Role.addRoleProcedure(roleid, new PCChildrenEquipLevelUpReq(roleid, this.childrenid, this.pos, this.item_cfg_id, this.is_use_all));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  29 */     return 12609415;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CChildrenEquipLevelUpReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CChildrenEquipLevelUpReq(long _childrenid_, int _pos_, int _item_cfg_id_, int _is_use_all_)
/*     */   {
/*  41 */     this.childrenid = _childrenid_;
/*  42 */     this.pos = _pos_;
/*  43 */     this.item_cfg_id = _item_cfg_id_;
/*  44 */     this.is_use_all = _is_use_all_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.childrenid);
/*  53 */     _os_.marshal(this.pos);
/*  54 */     _os_.marshal(this.item_cfg_id);
/*  55 */     _os_.marshal(this.is_use_all);
/*  56 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  60 */     this.childrenid = _os_.unmarshal_long();
/*  61 */     this.pos = _os_.unmarshal_int();
/*  62 */     this.item_cfg_id = _os_.unmarshal_int();
/*  63 */     this.is_use_all = _os_.unmarshal_int();
/*  64 */     if (!_validator_()) {
/*  65 */       throw new VerifyError("validator failed");
/*     */     }
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  71 */     if (_o1_ == this) return true;
/*  72 */     if ((_o1_ instanceof CChildrenEquipLevelUpReq)) {
/*  73 */       CChildrenEquipLevelUpReq _o_ = (CChildrenEquipLevelUpReq)_o1_;
/*  74 */       if (this.childrenid != _o_.childrenid) return false;
/*  75 */       if (this.pos != _o_.pos) return false;
/*  76 */       if (this.item_cfg_id != _o_.item_cfg_id) return false;
/*  77 */       if (this.is_use_all != _o_.is_use_all) return false;
/*  78 */       return true;
/*     */     }
/*  80 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  84 */     int _h_ = 0;
/*  85 */     _h_ += (int)this.childrenid;
/*  86 */     _h_ += this.pos;
/*  87 */     _h_ += this.item_cfg_id;
/*  88 */     _h_ += this.is_use_all;
/*  89 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  93 */     StringBuilder _sb_ = new StringBuilder();
/*  94 */     _sb_.append("(");
/*  95 */     _sb_.append(this.childrenid).append(",");
/*  96 */     _sb_.append(this.pos).append(",");
/*  97 */     _sb_.append(this.item_cfg_id).append(",");
/*  98 */     _sb_.append(this.is_use_all).append(",");
/*  99 */     _sb_.append(")");
/* 100 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CChildrenEquipLevelUpReq _o_) {
/* 104 */     if (_o_ == this) return 0;
/* 105 */     int _c_ = 0;
/* 106 */     _c_ = Long.signum(this.childrenid - _o_.childrenid);
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = this.pos - _o_.pos;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     _c_ = this.item_cfg_id - _o_.item_cfg_id;
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     _c_ = this.is_use_all - _o_.is_use_all;
/* 113 */     if (0 != _c_) return _c_;
/* 114 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\CChildrenEquipLevelUpReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */