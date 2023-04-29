/*     */ package mzm.gsp.crossbattle;
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
/*     */ public class SNotifyCrossBattleKnockOutRestart
/*     */   extends __SNotifyCrossBattleKnockOutRestart__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12617081;
/*     */   public int fight_type;
/*     */   public long prepare_world_begin_time;
/*     */   public long prepare_world_end_time;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  25 */     return 12617081;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SNotifyCrossBattleKnockOutRestart() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SNotifyCrossBattleKnockOutRestart(int _fight_type_, long _prepare_world_begin_time_, long _prepare_world_end_time_)
/*     */   {
/*  36 */     this.fight_type = _fight_type_;
/*  37 */     this.prepare_world_begin_time = _prepare_world_begin_time_;
/*  38 */     this.prepare_world_end_time = _prepare_world_end_time_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  42 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  46 */     _os_.marshal(this.fight_type);
/*  47 */     _os_.marshal(this.prepare_world_begin_time);
/*  48 */     _os_.marshal(this.prepare_world_end_time);
/*  49 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  53 */     this.fight_type = _os_.unmarshal_int();
/*  54 */     this.prepare_world_begin_time = _os_.unmarshal_long();
/*  55 */     this.prepare_world_end_time = _os_.unmarshal_long();
/*  56 */     if (!_validator_()) {
/*  57 */       throw new VerifyError("validator failed");
/*     */     }
/*  59 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  63 */     if (_o1_ == this) return true;
/*  64 */     if ((_o1_ instanceof SNotifyCrossBattleKnockOutRestart)) {
/*  65 */       SNotifyCrossBattleKnockOutRestart _o_ = (SNotifyCrossBattleKnockOutRestart)_o1_;
/*  66 */       if (this.fight_type != _o_.fight_type) return false;
/*  67 */       if (this.prepare_world_begin_time != _o_.prepare_world_begin_time) return false;
/*  68 */       if (this.prepare_world_end_time != _o_.prepare_world_end_time) return false;
/*  69 */       return true;
/*     */     }
/*  71 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  75 */     int _h_ = 0;
/*  76 */     _h_ += this.fight_type;
/*  77 */     _h_ += (int)this.prepare_world_begin_time;
/*  78 */     _h_ += (int)this.prepare_world_end_time;
/*  79 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  83 */     StringBuilder _sb_ = new StringBuilder();
/*  84 */     _sb_.append("(");
/*  85 */     _sb_.append(this.fight_type).append(",");
/*  86 */     _sb_.append(this.prepare_world_begin_time).append(",");
/*  87 */     _sb_.append(this.prepare_world_end_time).append(",");
/*  88 */     _sb_.append(")");
/*  89 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SNotifyCrossBattleKnockOutRestart _o_) {
/*  93 */     if (_o_ == this) return 0;
/*  94 */     int _c_ = 0;
/*  95 */     _c_ = this.fight_type - _o_.fight_type;
/*  96 */     if (0 != _c_) return _c_;
/*  97 */     _c_ = Long.signum(this.prepare_world_begin_time - _o_.prepare_world_begin_time);
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = Long.signum(this.prepare_world_end_time - _o_.prepare_world_end_time);
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\SNotifyCrossBattleKnockOutRestart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */