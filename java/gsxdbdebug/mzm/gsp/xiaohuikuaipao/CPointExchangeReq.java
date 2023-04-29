/*     */ package mzm.gsp.xiaohuikuaipao;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.xiaohuikuaipao.main.PCPointExchangeReq;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CPointExchangeReq
/*     */   extends __CPointExchangeReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12622850;
/*     */   public int pointexchangecfgid;
/*     */   public int count;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     long roleId = Role.getRoleId(this);
/*  20 */     if (roleId <= 0L)
/*     */     {
/*  22 */       return;
/*     */     }
/*  24 */     Role.addRoleProcedure(roleId, new PCPointExchangeReq(roleId, this.pointexchangecfgid, this.count));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  33 */     return 12622850;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CPointExchangeReq() {}
/*     */   
/*     */ 
/*     */   public CPointExchangeReq(int _pointexchangecfgid_, int _count_)
/*     */   {
/*  43 */     this.pointexchangecfgid = _pointexchangecfgid_;
/*  44 */     this.count = _count_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.pointexchangecfgid);
/*  53 */     _os_.marshal(this.count);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.pointexchangecfgid = _os_.unmarshal_int();
/*  59 */     this.count = _os_.unmarshal_int();
/*  60 */     if (!_validator_()) {
/*  61 */       throw new VerifyError("validator failed");
/*     */     }
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  67 */     if (_o1_ == this) return true;
/*  68 */     if ((_o1_ instanceof CPointExchangeReq)) {
/*  69 */       CPointExchangeReq _o_ = (CPointExchangeReq)_o1_;
/*  70 */       if (this.pointexchangecfgid != _o_.pointexchangecfgid) return false;
/*  71 */       if (this.count != _o_.count) return false;
/*  72 */       return true;
/*     */     }
/*  74 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  78 */     int _h_ = 0;
/*  79 */     _h_ += this.pointexchangecfgid;
/*  80 */     _h_ += this.count;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.pointexchangecfgid).append(",");
/*  88 */     _sb_.append(this.count).append(",");
/*  89 */     _sb_.append(")");
/*  90 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CPointExchangeReq _o_) {
/*  94 */     if (_o_ == this) return 0;
/*  95 */     int _c_ = 0;
/*  96 */     _c_ = this.pointexchangecfgid - _o_.pointexchangecfgid;
/*  97 */     if (0 != _c_) return _c_;
/*  98 */     _c_ = this.count - _o_.count;
/*  99 */     if (0 != _c_) return _c_;
/* 100 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\xiaohuikuaipao\CPointExchangeReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */