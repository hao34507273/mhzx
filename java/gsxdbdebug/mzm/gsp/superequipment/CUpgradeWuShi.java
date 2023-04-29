/*     */ package mzm.gsp.superequipment;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.superequipment.wushi.main.PCUpgradeWuShi;
/*     */ 
/*     */ public class CUpgradeWuShi extends __CUpgradeWuShi__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12618779;
/*     */   public static final int consume_all = 1;
/*     */   public static final int consume_one = 2;
/*     */   public int itemcfgid;
/*     */   public int wushicfgid;
/*     */   public int consumetype;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     long roleId = Role.getRoleId(this);
/*  20 */     if (roleId <= 0L)
/*     */     {
/*  22 */       return;
/*     */     }
/*  24 */     Role.addRoleProcedure(roleId, new PCUpgradeWuShi(roleId, this.itemcfgid, this.wushicfgid, this.consumetype));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  34 */     return 12618779;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public CUpgradeWuShi() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CUpgradeWuShi(int _itemcfgid_, int _wushicfgid_, int _consumetype_)
/*     */   {
/*  48 */     this.itemcfgid = _itemcfgid_;
/*  49 */     this.wushicfgid = _wushicfgid_;
/*  50 */     this.consumetype = _consumetype_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  54 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  58 */     _os_.marshal(this.itemcfgid);
/*  59 */     _os_.marshal(this.wushicfgid);
/*  60 */     _os_.marshal(this.consumetype);
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  65 */     this.itemcfgid = _os_.unmarshal_int();
/*  66 */     this.wushicfgid = _os_.unmarshal_int();
/*  67 */     this.consumetype = _os_.unmarshal_int();
/*  68 */     if (!_validator_()) {
/*  69 */       throw new VerifyError("validator failed");
/*     */     }
/*  71 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  75 */     if (_o1_ == this) return true;
/*  76 */     if ((_o1_ instanceof CUpgradeWuShi)) {
/*  77 */       CUpgradeWuShi _o_ = (CUpgradeWuShi)_o1_;
/*  78 */       if (this.itemcfgid != _o_.itemcfgid) return false;
/*  79 */       if (this.wushicfgid != _o_.wushicfgid) return false;
/*  80 */       if (this.consumetype != _o_.consumetype) return false;
/*  81 */       return true;
/*     */     }
/*  83 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  87 */     int _h_ = 0;
/*  88 */     _h_ += this.itemcfgid;
/*  89 */     _h_ += this.wushicfgid;
/*  90 */     _h_ += this.consumetype;
/*  91 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  95 */     StringBuilder _sb_ = new StringBuilder();
/*  96 */     _sb_.append("(");
/*  97 */     _sb_.append(this.itemcfgid).append(",");
/*  98 */     _sb_.append(this.wushicfgid).append(",");
/*  99 */     _sb_.append(this.consumetype).append(",");
/* 100 */     _sb_.append(")");
/* 101 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CUpgradeWuShi _o_) {
/* 105 */     if (_o_ == this) return 0;
/* 106 */     int _c_ = 0;
/* 107 */     _c_ = this.itemcfgid - _o_.itemcfgid;
/* 108 */     if (0 != _c_) return _c_;
/* 109 */     _c_ = this.wushicfgid - _o_.wushicfgid;
/* 110 */     if (0 != _c_) return _c_;
/* 111 */     _c_ = this.consumetype - _o_.consumetype;
/* 112 */     if (0 != _c_) return _c_;
/* 113 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\superequipment\CUpgradeWuShi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */