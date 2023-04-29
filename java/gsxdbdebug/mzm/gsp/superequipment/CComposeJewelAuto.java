/*     */ package mzm.gsp.superequipment;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.superequipment.jewel.main.PCComposeJewelAuto;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CComposeJewelAuto
/*     */   extends __CComposeJewelAuto__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12618764;
/*     */   public int jewelcfgid;
/*     */   public byte isuseyuanbaomakeup;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     long roleId = Role.getRoleId(this);
/*  20 */     if (roleId <= 0L)
/*     */     {
/*  22 */       return;
/*     */     }
/*  24 */     Role.addRoleProcedure(roleId, new PCComposeJewelAuto(roleId, this.jewelcfgid, this.isuseyuanbaomakeup));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  33 */     return 12618764;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CComposeJewelAuto() {}
/*     */   
/*     */ 
/*     */   public CComposeJewelAuto(int _jewelcfgid_, byte _isuseyuanbaomakeup_)
/*     */   {
/*  43 */     this.jewelcfgid = _jewelcfgid_;
/*  44 */     this.isuseyuanbaomakeup = _isuseyuanbaomakeup_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.jewelcfgid);
/*  53 */     _os_.marshal(this.isuseyuanbaomakeup);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.jewelcfgid = _os_.unmarshal_int();
/*  59 */     this.isuseyuanbaomakeup = _os_.unmarshal_byte();
/*  60 */     if (!_validator_()) {
/*  61 */       throw new VerifyError("validator failed");
/*     */     }
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  67 */     if (_o1_ == this) return true;
/*  68 */     if ((_o1_ instanceof CComposeJewelAuto)) {
/*  69 */       CComposeJewelAuto _o_ = (CComposeJewelAuto)_o1_;
/*  70 */       if (this.jewelcfgid != _o_.jewelcfgid) return false;
/*  71 */       if (this.isuseyuanbaomakeup != _o_.isuseyuanbaomakeup) return false;
/*  72 */       return true;
/*     */     }
/*  74 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  78 */     int _h_ = 0;
/*  79 */     _h_ += this.jewelcfgid;
/*  80 */     _h_ += this.isuseyuanbaomakeup;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.jewelcfgid).append(",");
/*  88 */     _sb_.append(this.isuseyuanbaomakeup).append(",");
/*  89 */     _sb_.append(")");
/*  90 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CComposeJewelAuto _o_) {
/*  94 */     if (_o_ == this) return 0;
/*  95 */     int _c_ = 0;
/*  96 */     _c_ = this.jewelcfgid - _o_.jewelcfgid;
/*  97 */     if (0 != _c_) return _c_;
/*  98 */     _c_ = this.isuseyuanbaomakeup - _o_.isuseyuanbaomakeup;
/*  99 */     if (0 != _c_) return _c_;
/* 100 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\superequipment\CComposeJewelAuto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */