/*     */ package mzm.gsp.mounts;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.mounts.main.PCMountsSetBattleState;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CMountsSetBattleState
/*     */   extends __CMountsSetBattleState__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12606212;
/*     */   public int cell_id;
/*     */   public int battle_mounts_state;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleId = Role.getRoleId(this);
/*  21 */     if (roleId < 0L)
/*     */     {
/*  23 */       return;
/*     */     }
/*  25 */     Role.addRoleProcedure(roleId, new PCMountsSetBattleState(roleId, this.cell_id, this.battle_mounts_state));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  33 */     return 12606212;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CMountsSetBattleState() {}
/*     */   
/*     */ 
/*     */   public CMountsSetBattleState(int _cell_id_, int _battle_mounts_state_)
/*     */   {
/*  43 */     this.cell_id = _cell_id_;
/*  44 */     this.battle_mounts_state = _battle_mounts_state_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.cell_id);
/*  53 */     _os_.marshal(this.battle_mounts_state);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.cell_id = _os_.unmarshal_int();
/*  59 */     this.battle_mounts_state = _os_.unmarshal_int();
/*  60 */     if (!_validator_()) {
/*  61 */       throw new VerifyError("validator failed");
/*     */     }
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  67 */     if (_o1_ == this) return true;
/*  68 */     if ((_o1_ instanceof CMountsSetBattleState)) {
/*  69 */       CMountsSetBattleState _o_ = (CMountsSetBattleState)_o1_;
/*  70 */       if (this.cell_id != _o_.cell_id) return false;
/*  71 */       if (this.battle_mounts_state != _o_.battle_mounts_state) return false;
/*  72 */       return true;
/*     */     }
/*  74 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  78 */     int _h_ = 0;
/*  79 */     _h_ += this.cell_id;
/*  80 */     _h_ += this.battle_mounts_state;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.cell_id).append(",");
/*  88 */     _sb_.append(this.battle_mounts_state).append(",");
/*  89 */     _sb_.append(")");
/*  90 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CMountsSetBattleState _o_) {
/*  94 */     if (_o_ == this) return 0;
/*  95 */     int _c_ = 0;
/*  96 */     _c_ = this.cell_id - _o_.cell_id;
/*  97 */     if (0 != _c_) return _c_;
/*  98 */     _c_ = this.battle_mounts_state - _o_.battle_mounts_state;
/*  99 */     if (0 != _c_) return _c_;
/* 100 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mounts\CMountsSetBattleState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */