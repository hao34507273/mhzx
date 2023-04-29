/*     */ package mzm.gsp.fashiondress;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.fashiondress.main.PCExtendFashionDressTime;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CExtendFashionDressTime
/*     */   extends __CExtendFashionDressTime__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12603150;
/*     */   public int fashiondresscfgid;
/*     */   public int use_item_num;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleId = Role.getRoleId(this);
/*  21 */     if (roleId < 0L)
/*     */     {
/*  23 */       return;
/*     */     }
/*  25 */     Role.addRoleProcedure(roleId, new PCExtendFashionDressTime(roleId, this.fashiondresscfgid, this.use_item_num));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  33 */     return 12603150;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CExtendFashionDressTime() {}
/*     */   
/*     */ 
/*     */   public CExtendFashionDressTime(int _fashiondresscfgid_, int _use_item_num_)
/*     */   {
/*  43 */     this.fashiondresscfgid = _fashiondresscfgid_;
/*  44 */     this.use_item_num = _use_item_num_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.fashiondresscfgid);
/*  53 */     _os_.marshal(this.use_item_num);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.fashiondresscfgid = _os_.unmarshal_int();
/*  59 */     this.use_item_num = _os_.unmarshal_int();
/*  60 */     if (!_validator_()) {
/*  61 */       throw new VerifyError("validator failed");
/*     */     }
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  67 */     if (_o1_ == this) return true;
/*  68 */     if ((_o1_ instanceof CExtendFashionDressTime)) {
/*  69 */       CExtendFashionDressTime _o_ = (CExtendFashionDressTime)_o1_;
/*  70 */       if (this.fashiondresscfgid != _o_.fashiondresscfgid) return false;
/*  71 */       if (this.use_item_num != _o_.use_item_num) return false;
/*  72 */       return true;
/*     */     }
/*  74 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  78 */     int _h_ = 0;
/*  79 */     _h_ += this.fashiondresscfgid;
/*  80 */     _h_ += this.use_item_num;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.fashiondresscfgid).append(",");
/*  88 */     _sb_.append(this.use_item_num).append(",");
/*  89 */     _sb_.append(")");
/*  90 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CExtendFashionDressTime _o_) {
/*  94 */     if (_o_ == this) return 0;
/*  95 */     int _c_ = 0;
/*  96 */     _c_ = this.fashiondresscfgid - _o_.fashiondresscfgid;
/*  97 */     if (0 != _c_) return _c_;
/*  98 */     _c_ = this.use_item_num - _o_.use_item_num;
/*  99 */     if (0 != _c_) return _c_;
/* 100 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fashiondress\CExtendFashionDressTime.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */