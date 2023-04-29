/*     */ package mzm.gsp.mysteryshop;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.mysteryshop.main.PRefreshMysteryShop;
/*     */ 
/*     */ 
/*     */ public class CReqRefreshMysteryShop
/*     */   extends __CReqRefreshMysteryShop__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12614405;
/*     */   public int shoptype;
/*     */   public int client_cost_type;
/*     */   public long client_cost_num;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     long roleId = Role.getRoleId(this);
/*  20 */     if (roleId <= 0L)
/*     */     {
/*  22 */       return;
/*     */     }
/*  24 */     Role.addRoleProcedure(roleId, new PRefreshMysteryShop(roleId, this.shoptype, this.client_cost_type, this.client_cost_num));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  32 */     return 12614405;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CReqRefreshMysteryShop() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CReqRefreshMysteryShop(int _shoptype_, int _client_cost_type_, long _client_cost_num_)
/*     */   {
/*  43 */     this.shoptype = _shoptype_;
/*  44 */     this.client_cost_type = _client_cost_type_;
/*  45 */     this.client_cost_num = _client_cost_num_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  49 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  53 */     _os_.marshal(this.shoptype);
/*  54 */     _os_.marshal(this.client_cost_type);
/*  55 */     _os_.marshal(this.client_cost_num);
/*  56 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  60 */     this.shoptype = _os_.unmarshal_int();
/*  61 */     this.client_cost_type = _os_.unmarshal_int();
/*  62 */     this.client_cost_num = _os_.unmarshal_long();
/*  63 */     if (!_validator_()) {
/*  64 */       throw new VerifyError("validator failed");
/*     */     }
/*  66 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  70 */     if (_o1_ == this) return true;
/*  71 */     if ((_o1_ instanceof CReqRefreshMysteryShop)) {
/*  72 */       CReqRefreshMysteryShop _o_ = (CReqRefreshMysteryShop)_o1_;
/*  73 */       if (this.shoptype != _o_.shoptype) return false;
/*  74 */       if (this.client_cost_type != _o_.client_cost_type) return false;
/*  75 */       if (this.client_cost_num != _o_.client_cost_num) return false;
/*  76 */       return true;
/*     */     }
/*  78 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  82 */     int _h_ = 0;
/*  83 */     _h_ += this.shoptype;
/*  84 */     _h_ += this.client_cost_type;
/*  85 */     _h_ += (int)this.client_cost_num;
/*  86 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  90 */     StringBuilder _sb_ = new StringBuilder();
/*  91 */     _sb_.append("(");
/*  92 */     _sb_.append(this.shoptype).append(",");
/*  93 */     _sb_.append(this.client_cost_type).append(",");
/*  94 */     _sb_.append(this.client_cost_num).append(",");
/*  95 */     _sb_.append(")");
/*  96 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CReqRefreshMysteryShop _o_) {
/* 100 */     if (_o_ == this) return 0;
/* 101 */     int _c_ = 0;
/* 102 */     _c_ = this.shoptype - _o_.shoptype;
/* 103 */     if (0 != _c_) return _c_;
/* 104 */     _c_ = this.client_cost_type - _o_.client_cost_type;
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = Long.signum(this.client_cost_num - _o_.client_cost_num);
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mysteryshop\CReqRefreshMysteryShop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */