/*     */ package mzm.gsp.item;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.item.main.PEquipSkillRefreshReq;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CEquipSkillRefreshReq
/*     */   extends __CEquipSkillRefreshReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12584859;
/*     */   public int bagid;
/*     */   public int key;
/*     */   public int itemid;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleid = Role.getRoleId(this);
/*  21 */     Role.addRoleProcedure(roleid, new PEquipSkillRefreshReq(roleid, this.bagid, this.key, this.itemid));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  29 */     return 12584859;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CEquipSkillRefreshReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CEquipSkillRefreshReq(int _bagid_, int _key_, int _itemid_)
/*     */   {
/*  40 */     this.bagid = _bagid_;
/*  41 */     this.key = _key_;
/*  42 */     this.itemid = _itemid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  50 */     _os_.marshal(this.bagid);
/*  51 */     _os_.marshal(this.key);
/*  52 */     _os_.marshal(this.itemid);
/*  53 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  57 */     this.bagid = _os_.unmarshal_int();
/*  58 */     this.key = _os_.unmarshal_int();
/*  59 */     this.itemid = _os_.unmarshal_int();
/*  60 */     if (!_validator_()) {
/*  61 */       throw new VerifyError("validator failed");
/*     */     }
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  67 */     if (_o1_ == this) return true;
/*  68 */     if ((_o1_ instanceof CEquipSkillRefreshReq)) {
/*  69 */       CEquipSkillRefreshReq _o_ = (CEquipSkillRefreshReq)_o1_;
/*  70 */       if (this.bagid != _o_.bagid) return false;
/*  71 */       if (this.key != _o_.key) return false;
/*  72 */       if (this.itemid != _o_.itemid) return false;
/*  73 */       return true;
/*     */     }
/*  75 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  79 */     int _h_ = 0;
/*  80 */     _h_ += this.bagid;
/*  81 */     _h_ += this.key;
/*  82 */     _h_ += this.itemid;
/*  83 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  87 */     StringBuilder _sb_ = new StringBuilder();
/*  88 */     _sb_.append("(");
/*  89 */     _sb_.append(this.bagid).append(",");
/*  90 */     _sb_.append(this.key).append(",");
/*  91 */     _sb_.append(this.itemid).append(",");
/*  92 */     _sb_.append(")");
/*  93 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CEquipSkillRefreshReq _o_) {
/*  97 */     if (_o_ == this) return 0;
/*  98 */     int _c_ = 0;
/*  99 */     _c_ = this.bagid - _o_.bagid;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = this.key - _o_.key;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     _c_ = this.itemid - _o_.itemid;
/* 104 */     if (0 != _c_) return _c_;
/* 105 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\CEquipSkillRefreshReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */