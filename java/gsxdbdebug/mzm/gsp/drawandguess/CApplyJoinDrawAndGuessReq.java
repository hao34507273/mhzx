/*     */ package mzm.gsp.drawandguess;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.drawandguess.main.PCApplyJoinDrawAndGuessReq;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CApplyJoinDrawAndGuessReq
/*     */   extends __CApplyJoinDrawAndGuessReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12617249;
/*     */   public int activity_cfgid;
/*     */   public int npc_cfgid;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleId = Role.getRoleId(this);
/*  21 */     if (roleId < 1L)
/*     */     {
/*  23 */       return;
/*     */     }
/*  25 */     Role.addRoleProcedure(roleId, new PCApplyJoinDrawAndGuessReq(roleId, this.activity_cfgid, this.npc_cfgid));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  33 */     return 12617249;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CApplyJoinDrawAndGuessReq() {}
/*     */   
/*     */ 
/*     */   public CApplyJoinDrawAndGuessReq(int _activity_cfgid_, int _npc_cfgid_)
/*     */   {
/*  43 */     this.activity_cfgid = _activity_cfgid_;
/*  44 */     this.npc_cfgid = _npc_cfgid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.activity_cfgid);
/*  53 */     _os_.marshal(this.npc_cfgid);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.activity_cfgid = _os_.unmarshal_int();
/*  59 */     this.npc_cfgid = _os_.unmarshal_int();
/*  60 */     if (!_validator_()) {
/*  61 */       throw new VerifyError("validator failed");
/*     */     }
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  67 */     if (_o1_ == this) return true;
/*  68 */     if ((_o1_ instanceof CApplyJoinDrawAndGuessReq)) {
/*  69 */       CApplyJoinDrawAndGuessReq _o_ = (CApplyJoinDrawAndGuessReq)_o1_;
/*  70 */       if (this.activity_cfgid != _o_.activity_cfgid) return false;
/*  71 */       if (this.npc_cfgid != _o_.npc_cfgid) return false;
/*  72 */       return true;
/*     */     }
/*  74 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  78 */     int _h_ = 0;
/*  79 */     _h_ += this.activity_cfgid;
/*  80 */     _h_ += this.npc_cfgid;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.activity_cfgid).append(",");
/*  88 */     _sb_.append(this.npc_cfgid).append(",");
/*  89 */     _sb_.append(")");
/*  90 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CApplyJoinDrawAndGuessReq _o_) {
/*  94 */     if (_o_ == this) return 0;
/*  95 */     int _c_ = 0;
/*  96 */     _c_ = this.activity_cfgid - _o_.activity_cfgid;
/*  97 */     if (0 != _c_) return _c_;
/*  98 */     _c_ = this.npc_cfgid - _o_.npc_cfgid;
/*  99 */     if (0 != _c_) return _c_;
/* 100 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\drawandguess\CApplyJoinDrawAndGuessReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */