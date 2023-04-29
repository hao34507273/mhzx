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
/*     */ 
/*     */ public class SGetSelectionStageOwnServerFightSuccess
/*     */   extends __SGetSelectionStageOwnServerFightSuccess__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12617079;
/*     */   public int selection_stage;
/*     */   public HashMap<Long, CorpsInfo> selection_fight_corps_map;
/*     */   public KnockOutStageFightInfo selection_stage_fight_info;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12617079;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SGetSelectionStageOwnServerFightSuccess()
/*     */   {
/*  35 */     this.selection_fight_corps_map = new HashMap();
/*  36 */     this.selection_stage_fight_info = new KnockOutStageFightInfo();
/*     */   }
/*     */   
/*     */   public SGetSelectionStageOwnServerFightSuccess(int _selection_stage_, HashMap<Long, CorpsInfo> _selection_fight_corps_map_, KnockOutStageFightInfo _selection_stage_fight_info_) {
/*  40 */     this.selection_stage = _selection_stage_;
/*  41 */     this.selection_fight_corps_map = _selection_fight_corps_map_;
/*  42 */     this.selection_stage_fight_info = _selection_stage_fight_info_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     for (Map.Entry<Long, CorpsInfo> _e_ : this.selection_fight_corps_map.entrySet()) {
/*  47 */       if (!((CorpsInfo)_e_.getValue())._validator_()) return false;
/*     */     }
/*  49 */     if (!this.selection_stage_fight_info._validator_()) return false;
/*  50 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  54 */     _os_.marshal(this.selection_stage);
/*  55 */     _os_.compact_uint32(this.selection_fight_corps_map.size());
/*  56 */     for (Map.Entry<Long, CorpsInfo> _e_ : this.selection_fight_corps_map.entrySet()) {
/*  57 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  58 */       _os_.marshal((Marshal)_e_.getValue());
/*     */     }
/*  60 */     _os_.marshal(this.selection_stage_fight_info);
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  65 */     this.selection_stage = _os_.unmarshal_int();
/*  66 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  68 */       long _k_ = _os_.unmarshal_long();
/*  69 */       CorpsInfo _v_ = new CorpsInfo();
/*  70 */       _v_.unmarshal(_os_);
/*  71 */       this.selection_fight_corps_map.put(Long.valueOf(_k_), _v_);
/*     */     }
/*  73 */     this.selection_stage_fight_info.unmarshal(_os_);
/*  74 */     if (!_validator_()) {
/*  75 */       throw new VerifyError("validator failed");
/*     */     }
/*  77 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  81 */     if (_o1_ == this) return true;
/*  82 */     if ((_o1_ instanceof SGetSelectionStageOwnServerFightSuccess)) {
/*  83 */       SGetSelectionStageOwnServerFightSuccess _o_ = (SGetSelectionStageOwnServerFightSuccess)_o1_;
/*  84 */       if (this.selection_stage != _o_.selection_stage) return false;
/*  85 */       if (!this.selection_fight_corps_map.equals(_o_.selection_fight_corps_map)) return false;
/*  86 */       if (!this.selection_stage_fight_info.equals(_o_.selection_stage_fight_info)) return false;
/*  87 */       return true;
/*     */     }
/*  89 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  93 */     int _h_ = 0;
/*  94 */     _h_ += this.selection_stage;
/*  95 */     _h_ += this.selection_fight_corps_map.hashCode();
/*  96 */     _h_ += this.selection_stage_fight_info.hashCode();
/*  97 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 101 */     StringBuilder _sb_ = new StringBuilder();
/* 102 */     _sb_.append("(");
/* 103 */     _sb_.append(this.selection_stage).append(",");
/* 104 */     _sb_.append(this.selection_fight_corps_map).append(",");
/* 105 */     _sb_.append(this.selection_stage_fight_info).append(",");
/* 106 */     _sb_.append(")");
/* 107 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\SGetSelectionStageOwnServerFightSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */