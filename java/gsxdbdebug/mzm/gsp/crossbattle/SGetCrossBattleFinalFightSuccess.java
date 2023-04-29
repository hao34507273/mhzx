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
/*     */ public class SGetCrossBattleFinalFightSuccess
/*     */   extends __SGetCrossBattleFinalFightSuccess__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12617056;
/*     */   public HashMap<Long, CorpsInfo> final_fight_corps_map;
/*     */   public HashMap<Integer, KnockOutStageFightInfo> final_stage_fight_info_map;
/*     */   public int final_stage;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12617056;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SGetCrossBattleFinalFightSuccess()
/*     */   {
/*  35 */     this.final_fight_corps_map = new HashMap();
/*  36 */     this.final_stage_fight_info_map = new HashMap();
/*     */   }
/*     */   
/*     */   public SGetCrossBattleFinalFightSuccess(HashMap<Long, CorpsInfo> _final_fight_corps_map_, HashMap<Integer, KnockOutStageFightInfo> _final_stage_fight_info_map_, int _final_stage_) {
/*  40 */     this.final_fight_corps_map = _final_fight_corps_map_;
/*  41 */     this.final_stage_fight_info_map = _final_stage_fight_info_map_;
/*  42 */     this.final_stage = _final_stage_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     for (Map.Entry<Long, CorpsInfo> _e_ : this.final_fight_corps_map.entrySet()) {
/*  47 */       if (!((CorpsInfo)_e_.getValue())._validator_()) return false;
/*     */     }
/*  49 */     for (Map.Entry<Integer, KnockOutStageFightInfo> _e_ : this.final_stage_fight_info_map.entrySet()) {
/*  50 */       if (!((KnockOutStageFightInfo)_e_.getValue())._validator_()) return false;
/*     */     }
/*  52 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  56 */     _os_.compact_uint32(this.final_fight_corps_map.size());
/*  57 */     for (Map.Entry<Long, CorpsInfo> _e_ : this.final_fight_corps_map.entrySet()) {
/*  58 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  59 */       _os_.marshal((Marshal)_e_.getValue());
/*     */     }
/*  61 */     _os_.compact_uint32(this.final_stage_fight_info_map.size());
/*  62 */     for (Map.Entry<Integer, KnockOutStageFightInfo> _e_ : this.final_stage_fight_info_map.entrySet()) {
/*  63 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  64 */       _os_.marshal((Marshal)_e_.getValue());
/*     */     }
/*  66 */     _os_.marshal(this.final_stage);
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  71 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  73 */       long _k_ = _os_.unmarshal_long();
/*  74 */       CorpsInfo _v_ = new CorpsInfo();
/*  75 */       _v_.unmarshal(_os_);
/*  76 */       this.final_fight_corps_map.put(Long.valueOf(_k_), _v_);
/*     */     }
/*  78 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  80 */       int _k_ = _os_.unmarshal_int();
/*  81 */       KnockOutStageFightInfo _v_ = new KnockOutStageFightInfo();
/*  82 */       _v_.unmarshal(_os_);
/*  83 */       this.final_stage_fight_info_map.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*  85 */     this.final_stage = _os_.unmarshal_int();
/*  86 */     if (!_validator_()) {
/*  87 */       throw new VerifyError("validator failed");
/*     */     }
/*  89 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  93 */     if (_o1_ == this) return true;
/*  94 */     if ((_o1_ instanceof SGetCrossBattleFinalFightSuccess)) {
/*  95 */       SGetCrossBattleFinalFightSuccess _o_ = (SGetCrossBattleFinalFightSuccess)_o1_;
/*  96 */       if (!this.final_fight_corps_map.equals(_o_.final_fight_corps_map)) return false;
/*  97 */       if (!this.final_stage_fight_info_map.equals(_o_.final_stage_fight_info_map)) return false;
/*  98 */       if (this.final_stage != _o_.final_stage) return false;
/*  99 */       return true;
/*     */     }
/* 101 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 105 */     int _h_ = 0;
/* 106 */     _h_ += this.final_fight_corps_map.hashCode();
/* 107 */     _h_ += this.final_stage_fight_info_map.hashCode();
/* 108 */     _h_ += this.final_stage;
/* 109 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 113 */     StringBuilder _sb_ = new StringBuilder();
/* 114 */     _sb_.append("(");
/* 115 */     _sb_.append(this.final_fight_corps_map).append(",");
/* 116 */     _sb_.append(this.final_stage_fight_info_map).append(",");
/* 117 */     _sb_.append(this.final_stage).append(",");
/* 118 */     _sb_.append(")");
/* 119 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\SGetCrossBattleFinalFightSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */