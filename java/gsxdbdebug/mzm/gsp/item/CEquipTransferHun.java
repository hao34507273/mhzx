/*     */ package mzm.gsp.item;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.item.main.PEquipTransferHun;
/*     */ 
/*     */ public class CEquipTransferHun
/*     */   extends __CEquipTransferHun__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12584716;
/*     */   public int srceequipkey;
/*     */   public int desequipbagid;
/*     */   public int desequipkey;
/*     */   
/*     */   protected void process()
/*     */   {
/*  18 */     long roleid = Role.getRoleId(this);
/*  19 */     Role.addRoleProcedure(roleid, new PEquipTransferHun(roleid, this));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  27 */     return 12584716;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CEquipTransferHun() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CEquipTransferHun(int _srceequipkey_, int _desequipbagid_, int _desequipkey_)
/*     */   {
/*  38 */     this.srceequipkey = _srceequipkey_;
/*  39 */     this.desequipbagid = _desequipbagid_;
/*  40 */     this.desequipkey = _desequipkey_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.srceequipkey);
/*  49 */     _os_.marshal(this.desequipbagid);
/*  50 */     _os_.marshal(this.desequipkey);
/*  51 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  55 */     this.srceequipkey = _os_.unmarshal_int();
/*  56 */     this.desequipbagid = _os_.unmarshal_int();
/*  57 */     this.desequipkey = _os_.unmarshal_int();
/*  58 */     if (!_validator_()) {
/*  59 */       throw new VerifyError("validator failed");
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  65 */     if (_o1_ == this) return true;
/*  66 */     if ((_o1_ instanceof CEquipTransferHun)) {
/*  67 */       CEquipTransferHun _o_ = (CEquipTransferHun)_o1_;
/*  68 */       if (this.srceequipkey != _o_.srceequipkey) return false;
/*  69 */       if (this.desequipbagid != _o_.desequipbagid) return false;
/*  70 */       if (this.desequipkey != _o_.desequipkey) return false;
/*  71 */       return true;
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  77 */     int _h_ = 0;
/*  78 */     _h_ += this.srceequipkey;
/*  79 */     _h_ += this.desequipbagid;
/*  80 */     _h_ += this.desequipkey;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.srceequipkey).append(",");
/*  88 */     _sb_.append(this.desequipbagid).append(",");
/*  89 */     _sb_.append(this.desequipkey).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CEquipTransferHun _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = this.srceequipkey - _o_.srceequipkey;
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = this.desequipbagid - _o_.desequipbagid;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = this.desequipkey - _o_.desequipkey;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\CEquipTransferHun.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */