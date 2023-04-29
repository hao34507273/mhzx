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
/*     */ public class SGetSelectionStageBetInfoSuccess
/*     */   extends __SGetSelectionStageBetInfoSuccess__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12617043;
/*     */   public int activity_cfg_id;
/*     */   public int fight_zone_id;
/*     */   public int selection_stage;
/*     */   public HashMap<Long, CorpsInfo> corps_infos;
/*     */   public KnockOutStageFightInfo fight_infos;
/*     */   public ArrayList<KnockoutFightBetInfo> fight_bet_infos;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12617043;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SGetSelectionStageBetInfoSuccess()
/*     */   {
/*  38 */     this.corps_infos = new HashMap();
/*  39 */     this.fight_infos = new KnockOutStageFightInfo();
/*  40 */     this.fight_bet_infos = new ArrayList();
/*     */   }
/*     */   
/*     */   public SGetSelectionStageBetInfoSuccess(int _activity_cfg_id_, int _fight_zone_id_, int _selection_stage_, HashMap<Long, CorpsInfo> _corps_infos_, KnockOutStageFightInfo _fight_infos_, ArrayList<KnockoutFightBetInfo> _fight_bet_infos_) {
/*  44 */     this.activity_cfg_id = _activity_cfg_id_;
/*  45 */     this.fight_zone_id = _fight_zone_id_;
/*  46 */     this.selection_stage = _selection_stage_;
/*  47 */     this.corps_infos = _corps_infos_;
/*  48 */     this.fight_infos = _fight_infos_;
/*  49 */     this.fight_bet_infos = _fight_bet_infos_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  53 */     for (Map.Entry<Long, CorpsInfo> _e_ : this.corps_infos.entrySet()) {
/*  54 */       if (!((CorpsInfo)_e_.getValue())._validator_()) return false;
/*     */     }
/*  56 */     if (!this.fight_infos._validator_()) return false;
/*  57 */     for (KnockoutFightBetInfo _v_ : this.fight_bet_infos)
/*  58 */       if (!_v_._validator_()) return false;
/*  59 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  63 */     _os_.marshal(this.activity_cfg_id);
/*  64 */     _os_.marshal(this.fight_zone_id);
/*  65 */     _os_.marshal(this.selection_stage);
/*  66 */     _os_.compact_uint32(this.corps_infos.size());
/*  67 */     for (Map.Entry<Long, CorpsInfo> _e_ : this.corps_infos.entrySet()) {
/*  68 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  69 */       _os_.marshal((Marshal)_e_.getValue());
/*     */     }
/*  71 */     _os_.marshal(this.fight_infos);
/*  72 */     _os_.compact_uint32(this.fight_bet_infos.size());
/*  73 */     for (KnockoutFightBetInfo _v_ : this.fight_bet_infos) {
/*  74 */       _os_.marshal(_v_);
/*     */     }
/*  76 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  80 */     this.activity_cfg_id = _os_.unmarshal_int();
/*  81 */     this.fight_zone_id = _os_.unmarshal_int();
/*  82 */     this.selection_stage = _os_.unmarshal_int();
/*  83 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  85 */       long _k_ = _os_.unmarshal_long();
/*  86 */       CorpsInfo _v_ = new CorpsInfo();
/*  87 */       _v_.unmarshal(_os_);
/*  88 */       this.corps_infos.put(Long.valueOf(_k_), _v_);
/*     */     }
/*  90 */     this.fight_infos.unmarshal(_os_);
/*  91 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  92 */       KnockoutFightBetInfo _v_ = new KnockoutFightBetInfo();
/*  93 */       _v_.unmarshal(_os_);
/*  94 */       this.fight_bet_infos.add(_v_);
/*     */     }
/*  96 */     if (!_validator_()) {
/*  97 */       throw new VerifyError("validator failed");
/*     */     }
/*  99 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/* 103 */     if (_o1_ == this) return true;
/* 104 */     if ((_o1_ instanceof SGetSelectionStageBetInfoSuccess)) {
/* 105 */       SGetSelectionStageBetInfoSuccess _o_ = (SGetSelectionStageBetInfoSuccess)_o1_;
/* 106 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/* 107 */       if (this.fight_zone_id != _o_.fight_zone_id) return false;
/* 108 */       if (this.selection_stage != _o_.selection_stage) return false;
/* 109 */       if (!this.corps_infos.equals(_o_.corps_infos)) return false;
/* 110 */       if (!this.fight_infos.equals(_o_.fight_infos)) return false;
/* 111 */       if (!this.fight_bet_infos.equals(_o_.fight_bet_infos)) return false;
/* 112 */       return true;
/*     */     }
/* 114 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 118 */     int _h_ = 0;
/* 119 */     _h_ += this.activity_cfg_id;
/* 120 */     _h_ += this.fight_zone_id;
/* 121 */     _h_ += this.selection_stage;
/* 122 */     _h_ += this.corps_infos.hashCode();
/* 123 */     _h_ += this.fight_infos.hashCode();
/* 124 */     _h_ += this.fight_bet_infos.hashCode();
/* 125 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 129 */     StringBuilder _sb_ = new StringBuilder();
/* 130 */     _sb_.append("(");
/* 131 */     _sb_.append(this.activity_cfg_id).append(",");
/* 132 */     _sb_.append(this.fight_zone_id).append(",");
/* 133 */     _sb_.append(this.selection_stage).append(",");
/* 134 */     _sb_.append(this.corps_infos).append(",");
/* 135 */     _sb_.append(this.fight_infos).append(",");
/* 136 */     _sb_.append(this.fight_bet_infos).append(",");
/* 137 */     _sb_.append(")");
/* 138 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\SGetSelectionStageBetInfoSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */