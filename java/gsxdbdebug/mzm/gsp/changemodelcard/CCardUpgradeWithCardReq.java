/*     */ package mzm.gsp.changemodelcard;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.changemodelcard.main.PCCardUpgradeWithCardReq;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CCardUpgradeWithCardReq
/*     */   extends __CCardUpgradeWithCardReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12624404;
/*     */   public long main_card_id;
/*     */   public long cost_card_id;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleId = Role.getRoleId(this);
/*  21 */     if (roleId <= 0L)
/*     */     {
/*  23 */       return;
/*     */     }
/*  25 */     Role.addRoleProcedure(roleId, new PCCardUpgradeWithCardReq(roleId, this.main_card_id, this.cost_card_id));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  33 */     return 12624404;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CCardUpgradeWithCardReq() {}
/*     */   
/*     */ 
/*     */   public CCardUpgradeWithCardReq(long _main_card_id_, long _cost_card_id_)
/*     */   {
/*  43 */     this.main_card_id = _main_card_id_;
/*  44 */     this.cost_card_id = _cost_card_id_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.main_card_id);
/*  53 */     _os_.marshal(this.cost_card_id);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.main_card_id = _os_.unmarshal_long();
/*  59 */     this.cost_card_id = _os_.unmarshal_long();
/*  60 */     if (!_validator_()) {
/*  61 */       throw new VerifyError("validator failed");
/*     */     }
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  67 */     if (_o1_ == this) return true;
/*  68 */     if ((_o1_ instanceof CCardUpgradeWithCardReq)) {
/*  69 */       CCardUpgradeWithCardReq _o_ = (CCardUpgradeWithCardReq)_o1_;
/*  70 */       if (this.main_card_id != _o_.main_card_id) return false;
/*  71 */       if (this.cost_card_id != _o_.cost_card_id) return false;
/*  72 */       return true;
/*     */     }
/*  74 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  78 */     int _h_ = 0;
/*  79 */     _h_ += (int)this.main_card_id;
/*  80 */     _h_ += (int)this.cost_card_id;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.main_card_id).append(",");
/*  88 */     _sb_.append(this.cost_card_id).append(",");
/*  89 */     _sb_.append(")");
/*  90 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CCardUpgradeWithCardReq _o_) {
/*  94 */     if (_o_ == this) return 0;
/*  95 */     int _c_ = 0;
/*  96 */     _c_ = Long.signum(this.main_card_id - _o_.main_card_id);
/*  97 */     if (0 != _c_) return _c_;
/*  98 */     _c_ = Long.signum(this.cost_card_id - _o_.cost_card_id);
/*  99 */     if (0 != _c_) return _c_;
/* 100 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\changemodelcard\CCardUpgradeWithCardReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */