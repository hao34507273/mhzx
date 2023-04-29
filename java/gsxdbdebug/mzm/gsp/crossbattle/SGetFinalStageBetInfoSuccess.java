/*     */ package mzm.gsp.crossbattle;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map.Entry;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SGetFinalStageBetInfoSuccess
/*     */   extends __SGetFinalStageBetInfoSuccess__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12617071;
/*     */   public int activity_cfg_id;
/*     */   public int stage;
/*     */   public HashMap<Long, CorpsInfo> corps_infos;
/*     */   public KnockOutStageFightInfo fight_infos;
/*     */   public ArrayList<KnockoutFightBetInfo> fight_bet_infos;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12617071;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SGetFinalStageBetInfoSuccess()
/*     */   {
/*  37 */     this.corps_infos = new HashMap();
/*  38 */     this.fight_infos = new KnockOutStageFightInfo();
/*  39 */     this.fight_bet_infos = new ArrayList();
/*     */   }
/*     */   
/*     */   public SGetFinalStageBetInfoSuccess(int _activity_cfg_id_, int _stage_, HashMap<Long, CorpsInfo> _corps_infos_, KnockOutStageFightInfo _fight_infos_, ArrayList<KnockoutFightBetInfo> _fight_bet_infos_) {
/*  43 */     this.activity_cfg_id = _activity_cfg_id_;
/*  44 */     this.stage = _stage_;
/*  45 */     this.corps_infos = _corps_infos_;
/*  46 */     this.fight_infos = _fight_infos_;
/*  47 */     this.fight_bet_infos = _fight_bet_infos_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  51 */     for (Map.Entry<Long, CorpsInfo> _e_ : this.corps_infos.entrySet()) {
/*  52 */       if (!((CorpsInfo)_e_.getValue())._validator_()) return false;
/*     */     }
/*  54 */     if (!this.fight_infos._validator_()) return false;
/*  55 */     for (KnockoutFightBetInfo _v_ : this.fight_bet_infos)
/*  56 */       if (!_v_._validator_()) return false;
/*  57 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  61 */     _os_.marshal(this.activity_cfg_id);
/*  62 */     _os_.marshal(this.stage);
/*  63 */     _os_.compact_uint32(this.corps_infos.size());
/*  64 */     for (Map.Entry<Long, CorpsInfo> _e_ : this.corps_infos.entrySet()) {
/*  65 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  66 */       _os_.marshal((Marshal)_e_.getValue());
/*     */     }
/*  68 */     _os_.marshal(this.fight_infos);
/*  69 */     _os_.compact_uint32(this.fight_bet_infos.size());
/*  70 */     for (KnockoutFightBetInfo _v_ : this.fight_bet_infos) {
/*  71 */       _os_.marshal(_v_);
/*     */     }
/*  73 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  77 */     this.activity_cfg_id = _os_.unmarshal_int();
/*  78 */     this.stage = _os_.unmarshal_int();
/*  79 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  81 */       long _k_ = _os_.unmarshal_long();
/*  82 */       CorpsInfo _v_ = new CorpsInfo();
/*  83 */       _v_.unmarshal(_os_);
/*  84 */       this.corps_infos.put(Long.valueOf(_k_), _v_);
/*     */     }
/*  86 */     this.fight_infos.unmarshal(_os_);
/*  87 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  88 */       KnockoutFightBetInfo _v_ = new KnockoutFightBetInfo();
/*  89 */       _v_.unmarshal(_os_);
/*  90 */       this.fight_bet_infos.add(_v_);
/*     */     }
/*  92 */     if (!_validator_()) {
/*  93 */       throw new VerifyError("validator failed");
/*     */     }
/*  95 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  99 */     if (_o1_ == this) return true;
/* 100 */     if ((_o1_ instanceof SGetFinalStageBetInfoSuccess)) {
/* 101 */       SGetFinalStageBetInfoSuccess _o_ = (SGetFinalStageBetInfoSuccess)_o1_;
/* 102 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/* 103 */       if (this.stage != _o_.stage) return false;
/* 104 */       if (!this.corps_infos.equals(_o_.corps_infos)) return false;
/* 105 */       if (!this.fight_infos.equals(_o_.fight_infos)) return false;
/* 106 */       if (!this.fight_bet_infos.equals(_o_.fight_bet_infos)) return false;
/* 107 */       return true;
/*     */     }
/* 109 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 113 */     int _h_ = 0;
/* 114 */     _h_ += this.activity_cfg_id;
/* 115 */     _h_ += this.stage;
/* 116 */     _h_ += this.corps_infos.hashCode();
/* 117 */     _h_ += this.fight_infos.hashCode();
/* 118 */     _h_ += this.fight_bet_infos.hashCode();
/* 119 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 123 */     StringBuilder _sb_ = new StringBuilder();
/* 124 */     _sb_.append("(");
/* 125 */     _sb_.append(this.activity_cfg_id).append(",");
/* 126 */     _sb_.append(this.stage).append(",");
/* 127 */     _sb_.append(this.corps_infos).append(",");
/* 128 */     _sb_.append(this.fight_infos).append(",");
/* 129 */     _sb_.append(this.fight_bet_infos).append(",");
/* 130 */     _sb_.append(")");
/* 131 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\SGetFinalStageBetInfoSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */