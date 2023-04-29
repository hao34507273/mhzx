/*     */ package mzm.gsp.crossbattle;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map.Entry;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SGetCrossBattleSelectionFightStageSuccess
/*     */   extends __SGetCrossBattleSelectionFightStageSuccess__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12617012;
/*     */   public int fight_zone_id;
/*     */   public int selection_stage;
/*     */   public HashMap<Long, CorpsInfo> selection_fight_corps_map;
/*     */   public KnockOutStageFightInfo selection_stage_fight_info;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12617012;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SGetCrossBattleSelectionFightStageSuccess()
/*     */   {
/*  36 */     this.selection_fight_corps_map = new HashMap();
/*  37 */     this.selection_stage_fight_info = new KnockOutStageFightInfo();
/*     */   }
/*     */   
/*     */   public SGetCrossBattleSelectionFightStageSuccess(int _fight_zone_id_, int _selection_stage_, HashMap<Long, CorpsInfo> _selection_fight_corps_map_, KnockOutStageFightInfo _selection_stage_fight_info_) {
/*  41 */     this.fight_zone_id = _fight_zone_id_;
/*  42 */     this.selection_stage = _selection_stage_;
/*  43 */     this.selection_fight_corps_map = _selection_fight_corps_map_;
/*  44 */     this.selection_stage_fight_info = _selection_stage_fight_info_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     for (Map.Entry<Long, CorpsInfo> _e_ : this.selection_fight_corps_map.entrySet()) {
/*  49 */       if (!((CorpsInfo)_e_.getValue())._validator_()) return false;
/*     */     }
/*  51 */     if (!this.selection_stage_fight_info._validator_()) return false;
/*  52 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  56 */     _os_.marshal(this.fight_zone_id);
/*  57 */     _os_.marshal(this.selection_stage);
/*  58 */     _os_.compact_uint32(this.selection_fight_corps_map.size());
/*  59 */     for (Map.Entry<Long, CorpsInfo> _e_ : this.selection_fight_corps_map.entrySet()) {
/*  60 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  61 */       _os_.marshal((Marshal)_e_.getValue());
/*     */     }
/*  63 */     _os_.marshal(this.selection_stage_fight_info);
/*  64 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  68 */     this.fight_zone_id = _os_.unmarshal_int();
/*  69 */     this.selection_stage = _os_.unmarshal_int();
/*  70 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  72 */       long _k_ = _os_.unmarshal_long();
/*  73 */       CorpsInfo _v_ = new CorpsInfo();
/*  74 */       _v_.unmarshal(_os_);
/*  75 */       this.selection_fight_corps_map.put(Long.valueOf(_k_), _v_);
/*     */     }
/*  77 */     this.selection_stage_fight_info.unmarshal(_os_);
/*  78 */     if (!_validator_()) {
/*  79 */       throw new VerifyError("validator failed");
/*     */     }
/*  81 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  85 */     if (_o1_ == this) return true;
/*  86 */     if ((_o1_ instanceof SGetCrossBattleSelectionFightStageSuccess)) {
/*  87 */       SGetCrossBattleSelectionFightStageSuccess _o_ = (SGetCrossBattleSelectionFightStageSuccess)_o1_;
/*  88 */       if (this.fight_zone_id != _o_.fight_zone_id) return false;
/*  89 */       if (this.selection_stage != _o_.selection_stage) return false;
/*  90 */       if (!this.selection_fight_corps_map.equals(_o_.selection_fight_corps_map)) return false;
/*  91 */       if (!this.selection_stage_fight_info.equals(_o_.selection_stage_fight_info)) return false;
/*  92 */       return true;
/*     */     }
/*  94 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  98 */     int _h_ = 0;
/*  99 */     _h_ += this.fight_zone_id;
/* 100 */     _h_ += this.selection_stage;
/* 101 */     _h_ += this.selection_fight_corps_map.hashCode();
/* 102 */     _h_ += this.selection_stage_fight_info.hashCode();
/* 103 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 107 */     StringBuilder _sb_ = new StringBuilder();
/* 108 */     _sb_.append("(");
/* 109 */     _sb_.append(this.fight_zone_id).append(",");
/* 110 */     _sb_.append(this.selection_stage).append(",");
/* 111 */     _sb_.append(this.selection_fight_corps_map).append(",");
/* 112 */     _sb_.append(this.selection_stage_fight_info).append(",");
/* 113 */     _sb_.append(")");
/* 114 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\SGetCrossBattleSelectionFightStageSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */