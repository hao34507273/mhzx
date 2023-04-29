/*     */ package mzm.gsp.activity;
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
/*     */ public class SSyncCommonVisibleMonsterFightTip
/*     */   extends __SSyncCommonVisibleMonsterFightTip__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12587609;
/*     */   public int activity_cfg_id;
/*     */   public int monster_category_id;
/*     */   public int today_kill_times;
/*     */   public int today_max_kill_times;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12587609;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSyncCommonVisibleMonsterFightTip() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SSyncCommonVisibleMonsterFightTip(int _activity_cfg_id_, int _monster_category_id_, int _today_kill_times_, int _today_max_kill_times_)
/*     */   {
/*  39 */     this.activity_cfg_id = _activity_cfg_id_;
/*  40 */     this.monster_category_id = _monster_category_id_;
/*  41 */     this.today_kill_times = _today_kill_times_;
/*  42 */     this.today_max_kill_times = _today_max_kill_times_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  50 */     _os_.marshal(this.activity_cfg_id);
/*  51 */     _os_.marshal(this.monster_category_id);
/*  52 */     _os_.marshal(this.today_kill_times);
/*  53 */     _os_.marshal(this.today_max_kill_times);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.activity_cfg_id = _os_.unmarshal_int();
/*  59 */     this.monster_category_id = _os_.unmarshal_int();
/*  60 */     this.today_kill_times = _os_.unmarshal_int();
/*  61 */     this.today_max_kill_times = _os_.unmarshal_int();
/*  62 */     if (!_validator_()) {
/*  63 */       throw new VerifyError("validator failed");
/*     */     }
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  69 */     if (_o1_ == this) return true;
/*  70 */     if ((_o1_ instanceof SSyncCommonVisibleMonsterFightTip)) {
/*  71 */       SSyncCommonVisibleMonsterFightTip _o_ = (SSyncCommonVisibleMonsterFightTip)_o1_;
/*  72 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/*  73 */       if (this.monster_category_id != _o_.monster_category_id) return false;
/*  74 */       if (this.today_kill_times != _o_.today_kill_times) return false;
/*  75 */       if (this.today_max_kill_times != _o_.today_max_kill_times) return false;
/*  76 */       return true;
/*     */     }
/*  78 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  82 */     int _h_ = 0;
/*  83 */     _h_ += this.activity_cfg_id;
/*  84 */     _h_ += this.monster_category_id;
/*  85 */     _h_ += this.today_kill_times;
/*  86 */     _h_ += this.today_max_kill_times;
/*  87 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  91 */     StringBuilder _sb_ = new StringBuilder();
/*  92 */     _sb_.append("(");
/*  93 */     _sb_.append(this.activity_cfg_id).append(",");
/*  94 */     _sb_.append(this.monster_category_id).append(",");
/*  95 */     _sb_.append(this.today_kill_times).append(",");
/*  96 */     _sb_.append(this.today_max_kill_times).append(",");
/*  97 */     _sb_.append(")");
/*  98 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SSyncCommonVisibleMonsterFightTip _o_) {
/* 102 */     if (_o_ == this) return 0;
/* 103 */     int _c_ = 0;
/* 104 */     _c_ = this.activity_cfg_id - _o_.activity_cfg_id;
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = this.monster_category_id - _o_.monster_category_id;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = this.today_kill_times - _o_.today_kill_times;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     _c_ = this.today_max_kill_times - _o_.today_max_kill_times;
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\SSyncCommonVisibleMonsterFightTip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */