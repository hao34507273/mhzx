/*     */ package mzm.gsp.backgameactivity;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SSynBackGameActivityInfo
/*     */   extends __SSynBackGameActivityInfo__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12620558;
/*     */   public int activity_id;
/*     */   public long current_time;
/*     */   public long join_time;
/*     */   public int join_level;
/*     */   public BackGameActivitySignInfo sign_info;
/*     */   public BackGameActivityExpAwardInfo exp_award_info;
/*     */   public BackGameActivityTaskInfo task_info;
/*     */   public BackGameActivityAwardInfo award_info;
/*     */   public BackGameActivityGiftInfo gift_info;
/*     */   public RechargeInfo rechargeinfo;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12620558;
/*     */   }
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
/*     */ 
/*     */   public SSynBackGameActivityInfo()
/*     */   {
/*  42 */     this.sign_info = new BackGameActivitySignInfo();
/*  43 */     this.exp_award_info = new BackGameActivityExpAwardInfo();
/*  44 */     this.task_info = new BackGameActivityTaskInfo();
/*  45 */     this.award_info = new BackGameActivityAwardInfo();
/*  46 */     this.gift_info = new BackGameActivityGiftInfo();
/*  47 */     this.rechargeinfo = new RechargeInfo();
/*     */   }
/*     */   
/*     */   public SSynBackGameActivityInfo(int _activity_id_, long _current_time_, long _join_time_, int _join_level_, BackGameActivitySignInfo _sign_info_, BackGameActivityExpAwardInfo _exp_award_info_, BackGameActivityTaskInfo _task_info_, BackGameActivityAwardInfo _award_info_, BackGameActivityGiftInfo _gift_info_, RechargeInfo _rechargeinfo_) {
/*  51 */     this.activity_id = _activity_id_;
/*  52 */     this.current_time = _current_time_;
/*  53 */     this.join_time = _join_time_;
/*  54 */     this.join_level = _join_level_;
/*  55 */     this.sign_info = _sign_info_;
/*  56 */     this.exp_award_info = _exp_award_info_;
/*  57 */     this.task_info = _task_info_;
/*  58 */     this.award_info = _award_info_;
/*  59 */     this.gift_info = _gift_info_;
/*  60 */     this.rechargeinfo = _rechargeinfo_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  64 */     if (!this.sign_info._validator_()) return false;
/*  65 */     if (!this.exp_award_info._validator_()) return false;
/*  66 */     if (!this.task_info._validator_()) return false;
/*  67 */     if (!this.award_info._validator_()) return false;
/*  68 */     if (!this.gift_info._validator_()) return false;
/*  69 */     if (!this.rechargeinfo._validator_()) return false;
/*  70 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  74 */     _os_.marshal(this.activity_id);
/*  75 */     _os_.marshal(this.current_time);
/*  76 */     _os_.marshal(this.join_time);
/*  77 */     _os_.marshal(this.join_level);
/*  78 */     _os_.marshal(this.sign_info);
/*  79 */     _os_.marshal(this.exp_award_info);
/*  80 */     _os_.marshal(this.task_info);
/*  81 */     _os_.marshal(this.award_info);
/*  82 */     _os_.marshal(this.gift_info);
/*  83 */     _os_.marshal(this.rechargeinfo);
/*  84 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  88 */     this.activity_id = _os_.unmarshal_int();
/*  89 */     this.current_time = _os_.unmarshal_long();
/*  90 */     this.join_time = _os_.unmarshal_long();
/*  91 */     this.join_level = _os_.unmarshal_int();
/*  92 */     this.sign_info.unmarshal(_os_);
/*  93 */     this.exp_award_info.unmarshal(_os_);
/*  94 */     this.task_info.unmarshal(_os_);
/*  95 */     this.award_info.unmarshal(_os_);
/*  96 */     this.gift_info.unmarshal(_os_);
/*  97 */     this.rechargeinfo.unmarshal(_os_);
/*  98 */     if (!_validator_()) {
/*  99 */       throw new VerifyError("validator failed");
/*     */     }
/* 101 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/* 105 */     if (_o1_ == this) return true;
/* 106 */     if ((_o1_ instanceof SSynBackGameActivityInfo)) {
/* 107 */       SSynBackGameActivityInfo _o_ = (SSynBackGameActivityInfo)_o1_;
/* 108 */       if (this.activity_id != _o_.activity_id) return false;
/* 109 */       if (this.current_time != _o_.current_time) return false;
/* 110 */       if (this.join_time != _o_.join_time) return false;
/* 111 */       if (this.join_level != _o_.join_level) return false;
/* 112 */       if (!this.sign_info.equals(_o_.sign_info)) return false;
/* 113 */       if (!this.exp_award_info.equals(_o_.exp_award_info)) return false;
/* 114 */       if (!this.task_info.equals(_o_.task_info)) return false;
/* 115 */       if (!this.award_info.equals(_o_.award_info)) return false;
/* 116 */       if (!this.gift_info.equals(_o_.gift_info)) return false;
/* 117 */       if (!this.rechargeinfo.equals(_o_.rechargeinfo)) return false;
/* 118 */       return true;
/*     */     }
/* 120 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 124 */     int _h_ = 0;
/* 125 */     _h_ += this.activity_id;
/* 126 */     _h_ += (int)this.current_time;
/* 127 */     _h_ += (int)this.join_time;
/* 128 */     _h_ += this.join_level;
/* 129 */     _h_ += this.sign_info.hashCode();
/* 130 */     _h_ += this.exp_award_info.hashCode();
/* 131 */     _h_ += this.task_info.hashCode();
/* 132 */     _h_ += this.award_info.hashCode();
/* 133 */     _h_ += this.gift_info.hashCode();
/* 134 */     _h_ += this.rechargeinfo.hashCode();
/* 135 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 139 */     StringBuilder _sb_ = new StringBuilder();
/* 140 */     _sb_.append("(");
/* 141 */     _sb_.append(this.activity_id).append(",");
/* 142 */     _sb_.append(this.current_time).append(",");
/* 143 */     _sb_.append(this.join_time).append(",");
/* 144 */     _sb_.append(this.join_level).append(",");
/* 145 */     _sb_.append(this.sign_info).append(",");
/* 146 */     _sb_.append(this.exp_award_info).append(",");
/* 147 */     _sb_.append(this.task_info).append(",");
/* 148 */     _sb_.append(this.award_info).append(",");
/* 149 */     _sb_.append(this.gift_info).append(",");
/* 150 */     _sb_.append(this.rechargeinfo).append(",");
/* 151 */     _sb_.append(")");
/* 152 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\backgameactivity\SSynBackGameActivityInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */