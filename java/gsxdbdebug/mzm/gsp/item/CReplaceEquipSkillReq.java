/*     */ package mzm.gsp.item;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.item.main.PReplaceEquipSkillReq;
/*     */ 
/*     */ public class CReplaceEquipSkillReq
/*     */   extends __CReplaceEquipSkillReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12584856;
/*     */   public int bagid;
/*     */   public int key;
/*     */   public int itemid;
/*     */   
/*     */   protected void process()
/*     */   {
/*  18 */     long roleid = Role.getRoleId(this);
/*  19 */     Role.addRoleProcedure(roleid, new PReplaceEquipSkillReq(roleid, this.bagid, this.key, this.itemid));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  27 */     return 12584856;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CReplaceEquipSkillReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CReplaceEquipSkillReq(int _bagid_, int _key_, int _itemid_)
/*     */   {
/*  38 */     this.bagid = _bagid_;
/*  39 */     this.key = _key_;
/*  40 */     this.itemid = _itemid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.bagid);
/*  49 */     _os_.marshal(this.key);
/*  50 */     _os_.marshal(this.itemid);
/*  51 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  55 */     this.bagid = _os_.unmarshal_int();
/*  56 */     this.key = _os_.unmarshal_int();
/*  57 */     this.itemid = _os_.unmarshal_int();
/*  58 */     if (!_validator_()) {
/*  59 */       throw new VerifyError("validator failed");
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  65 */     if (_o1_ == this) return true;
/*  66 */     if ((_o1_ instanceof CReplaceEquipSkillReq)) {
/*  67 */       CReplaceEquipSkillReq _o_ = (CReplaceEquipSkillReq)_o1_;
/*  68 */       if (this.bagid != _o_.bagid) return false;
/*  69 */       if (this.key != _o_.key) return false;
/*  70 */       if (this.itemid != _o_.itemid) return false;
/*  71 */       return true;
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  77 */     int _h_ = 0;
/*  78 */     _h_ += this.bagid;
/*  79 */     _h_ += this.key;
/*  80 */     _h_ += this.itemid;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.bagid).append(",");
/*  88 */     _sb_.append(this.key).append(",");
/*  89 */     _sb_.append(this.itemid).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CReplaceEquipSkillReq _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = this.bagid - _o_.bagid;
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = this.key - _o_.key;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = this.itemid - _o_.itemid;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\CReplaceEquipSkillReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */