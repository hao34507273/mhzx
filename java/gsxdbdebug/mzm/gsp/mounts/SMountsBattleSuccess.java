/*     */ package mzm.gsp.mounts;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SMountsBattleSuccess
/*     */   extends __SMountsBattleSuccess__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12606223;
/*     */   public int cell_id;
/*     */   public long mounts_id;
/*     */   public int battle_mounts_state;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12606223;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SMountsBattleSuccess() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SMountsBattleSuccess(int _cell_id_, long _mounts_id_, int _battle_mounts_state_)
/*     */   {
/*  38 */     this.cell_id = _cell_id_;
/*  39 */     this.mounts_id = _mounts_id_;
/*  40 */     this.battle_mounts_state = _battle_mounts_state_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.cell_id);
/*  49 */     _os_.marshal(this.mounts_id);
/*  50 */     _os_.marshal(this.battle_mounts_state);
/*  51 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  55 */     this.cell_id = _os_.unmarshal_int();
/*  56 */     this.mounts_id = _os_.unmarshal_long();
/*  57 */     this.battle_mounts_state = _os_.unmarshal_int();
/*  58 */     if (!_validator_()) {
/*  59 */       throw new VerifyError("validator failed");
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  65 */     if (_o1_ == this) return true;
/*  66 */     if ((_o1_ instanceof SMountsBattleSuccess)) {
/*  67 */       SMountsBattleSuccess _o_ = (SMountsBattleSuccess)_o1_;
/*  68 */       if (this.cell_id != _o_.cell_id) return false;
/*  69 */       if (this.mounts_id != _o_.mounts_id) return false;
/*  70 */       if (this.battle_mounts_state != _o_.battle_mounts_state) return false;
/*  71 */       return true;
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  77 */     int _h_ = 0;
/*  78 */     _h_ += this.cell_id;
/*  79 */     _h_ += (int)this.mounts_id;
/*  80 */     _h_ += this.battle_mounts_state;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.cell_id).append(",");
/*  88 */     _sb_.append(this.mounts_id).append(",");
/*  89 */     _sb_.append(this.battle_mounts_state).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SMountsBattleSuccess _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = this.cell_id - _o_.cell_id;
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = Long.signum(this.mounts_id - _o_.mounts_id);
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = this.battle_mounts_state - _o_.battle_mounts_state;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mounts\SMountsBattleSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */