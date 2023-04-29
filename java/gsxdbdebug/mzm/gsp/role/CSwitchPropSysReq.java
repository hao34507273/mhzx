/*     */ package mzm.gsp.role;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.role.main.PSwitchPropSysReq;
/*     */ 
/*     */ public class CSwitchPropSysReq extends __CSwitchPropSysReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12586001;
/*     */   public static final int PROP_SYS_1 = 0;
/*     */   public static final int PROP_SYS_2 = 1;
/*     */   public static final int PROP_SYS_3 = 2;
/*     */   public int propsys;
/*     */   public long silvermoney;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     long roleId = Role.getRoleId(this);
/*  20 */     if (roleId < 0L) {
/*  21 */       return;
/*     */     }
/*  23 */     Role.addRoleProcedure(roleId, new PSwitchPropSysReq(this.propsys, roleId, this.silvermoney));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  31 */     return 12586001;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public CSwitchPropSysReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CSwitchPropSysReq(int _propsys_, long _silvermoney_)
/*     */   {
/*  45 */     this.propsys = _propsys_;
/*  46 */     this.silvermoney = _silvermoney_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  50 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  54 */     _os_.marshal(this.propsys);
/*  55 */     _os_.marshal(this.silvermoney);
/*  56 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  60 */     this.propsys = _os_.unmarshal_int();
/*  61 */     this.silvermoney = _os_.unmarshal_long();
/*  62 */     if (!_validator_()) {
/*  63 */       throw new VerifyError("validator failed");
/*     */     }
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  69 */     if (_o1_ == this) return true;
/*  70 */     if ((_o1_ instanceof CSwitchPropSysReq)) {
/*  71 */       CSwitchPropSysReq _o_ = (CSwitchPropSysReq)_o1_;
/*  72 */       if (this.propsys != _o_.propsys) return false;
/*  73 */       if (this.silvermoney != _o_.silvermoney) return false;
/*  74 */       return true;
/*     */     }
/*  76 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  80 */     int _h_ = 0;
/*  81 */     _h_ += this.propsys;
/*  82 */     _h_ += (int)this.silvermoney;
/*  83 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  87 */     StringBuilder _sb_ = new StringBuilder();
/*  88 */     _sb_.append("(");
/*  89 */     _sb_.append(this.propsys).append(",");
/*  90 */     _sb_.append(this.silvermoney).append(",");
/*  91 */     _sb_.append(")");
/*  92 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CSwitchPropSysReq _o_) {
/*  96 */     if (_o_ == this) return 0;
/*  97 */     int _c_ = 0;
/*  98 */     _c_ = this.propsys - _o_.propsys;
/*  99 */     if (0 != _c_) return _c_;
/* 100 */     _c_ = Long.signum(this.silvermoney - _o_.silvermoney);
/* 101 */     if (0 != _c_) return _c_;
/* 102 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\CSwitchPropSysReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */