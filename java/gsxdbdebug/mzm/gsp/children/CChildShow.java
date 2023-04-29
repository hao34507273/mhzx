/*     */ package mzm.gsp.children;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.children.main.PCChildShow;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CChildShow
/*     */   extends __CChildShow__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12609321;
/*     */   public long child_id;
/*     */   public int child_period;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleId = Role.getRoleId(this);
/*  21 */     if (roleId < 0L)
/*     */     {
/*  23 */       return;
/*     */     }
/*  25 */     Role.addRoleProcedure(roleId, new PCChildShow(roleId, this.child_id, this.child_period));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  33 */     return 12609321;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CChildShow() {}
/*     */   
/*     */ 
/*     */   public CChildShow(long _child_id_, int _child_period_)
/*     */   {
/*  43 */     this.child_id = _child_id_;
/*  44 */     this.child_period = _child_period_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.child_id);
/*  53 */     _os_.marshal(this.child_period);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.child_id = _os_.unmarshal_long();
/*  59 */     this.child_period = _os_.unmarshal_int();
/*  60 */     if (!_validator_()) {
/*  61 */       throw new VerifyError("validator failed");
/*     */     }
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  67 */     if (_o1_ == this) return true;
/*  68 */     if ((_o1_ instanceof CChildShow)) {
/*  69 */       CChildShow _o_ = (CChildShow)_o1_;
/*  70 */       if (this.child_id != _o_.child_id) return false;
/*  71 */       if (this.child_period != _o_.child_period) return false;
/*  72 */       return true;
/*     */     }
/*  74 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  78 */     int _h_ = 0;
/*  79 */     _h_ += (int)this.child_id;
/*  80 */     _h_ += this.child_period;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.child_id).append(",");
/*  88 */     _sb_.append(this.child_period).append(",");
/*  89 */     _sb_.append(")");
/*  90 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CChildShow _o_) {
/*  94 */     if (_o_ == this) return 0;
/*  95 */     int _c_ = 0;
/*  96 */     _c_ = Long.signum(this.child_id - _o_.child_id);
/*  97 */     if (0 != _c_) return _c_;
/*  98 */     _c_ = this.child_period - _o_.child_period;
/*  99 */     if (0 != _c_) return _c_;
/* 100 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\CChildShow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */