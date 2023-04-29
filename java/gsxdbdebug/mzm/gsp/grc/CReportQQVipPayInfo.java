/*     */ package mzm.gsp.grc;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.grc.main.PCReportQQVipPayInfo;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CReportQQVipPayInfo
/*     */   extends __CReportQQVipPayInfo__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12600344;
/*     */   public int vip_flag;
/*     */   public byte is_new;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     long roleId = Role.getRoleId(this);
/*  20 */     if (roleId < 0L)
/*     */     {
/*  22 */       return;
/*     */     }
/*  24 */     Role.addRoleProcedure(roleId, new PCReportQQVipPayInfo(roleId, this.vip_flag, this.is_new));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  32 */     return 12600344;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CReportQQVipPayInfo()
/*     */   {
/*  39 */     this.vip_flag = 1;
/*     */   }
/*     */   
/*     */   public CReportQQVipPayInfo(int _vip_flag_, byte _is_new_) {
/*  43 */     this.vip_flag = _vip_flag_;
/*  44 */     this.is_new = _is_new_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.vip_flag);
/*  53 */     _os_.marshal(this.is_new);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.vip_flag = _os_.unmarshal_int();
/*  59 */     this.is_new = _os_.unmarshal_byte();
/*  60 */     if (!_validator_()) {
/*  61 */       throw new VerifyError("validator failed");
/*     */     }
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  67 */     if (_o1_ == this) return true;
/*  68 */     if ((_o1_ instanceof CReportQQVipPayInfo)) {
/*  69 */       CReportQQVipPayInfo _o_ = (CReportQQVipPayInfo)_o1_;
/*  70 */       if (this.vip_flag != _o_.vip_flag) return false;
/*  71 */       if (this.is_new != _o_.is_new) return false;
/*  72 */       return true;
/*     */     }
/*  74 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  78 */     int _h_ = 0;
/*  79 */     _h_ += this.vip_flag;
/*  80 */     _h_ += this.is_new;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.vip_flag).append(",");
/*  88 */     _sb_.append(this.is_new).append(",");
/*  89 */     _sb_.append(")");
/*  90 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CReportQQVipPayInfo _o_) {
/*  94 */     if (_o_ == this) return 0;
/*  95 */     int _c_ = 0;
/*  96 */     _c_ = this.vip_flag - _o_.vip_flag;
/*  97 */     if (0 != _c_) return _c_;
/*  98 */     _c_ = this.is_new - _o_.is_new;
/*  99 */     if (0 != _c_) return _c_;
/* 100 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\CReportQQVipPayInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */