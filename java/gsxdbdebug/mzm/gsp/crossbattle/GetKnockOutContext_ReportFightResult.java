/*     */ package mzm.gsp.crossbattle;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ 
/*     */ public class GetKnockOutContext_ReportFightResult implements Marshal
/*     */ {
/*     */   public long corps_id;
/*     */   public Octets corps_name;
/*     */   public long opponent_corps_id;
/*     */   public Octets opponent_corps_name;
/*     */   public int fight_stage;
/*     */   public int fight_index_id;
/*     */   public int corps_fight_result;
/*     */   public int repeat_times;
/*     */   
/*     */   public GetKnockOutContext_ReportFightResult()
/*     */   {
/*  21 */     this.corps_name = new Octets();
/*  22 */     this.opponent_corps_name = new Octets();
/*     */   }
/*     */   
/*     */   public GetKnockOutContext_ReportFightResult(long _corps_id_, Octets _corps_name_, long _opponent_corps_id_, Octets _opponent_corps_name_, int _fight_stage_, int _fight_index_id_, int _corps_fight_result_, int _repeat_times_) {
/*  26 */     this.corps_id = _corps_id_;
/*  27 */     this.corps_name = _corps_name_;
/*  28 */     this.opponent_corps_id = _opponent_corps_id_;
/*  29 */     this.opponent_corps_name = _opponent_corps_name_;
/*  30 */     this.fight_stage = _fight_stage_;
/*  31 */     this.fight_index_id = _fight_index_id_;
/*  32 */     this.corps_fight_result = _corps_fight_result_;
/*  33 */     this.repeat_times = _repeat_times_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  37 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  41 */     _os_.marshal(this.corps_id);
/*  42 */     _os_.marshal(this.corps_name);
/*  43 */     _os_.marshal(this.opponent_corps_id);
/*  44 */     _os_.marshal(this.opponent_corps_name);
/*  45 */     _os_.marshal(this.fight_stage);
/*  46 */     _os_.marshal(this.fight_index_id);
/*  47 */     _os_.marshal(this.corps_fight_result);
/*  48 */     _os_.marshal(this.repeat_times);
/*  49 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  53 */     this.corps_id = _os_.unmarshal_long();
/*  54 */     this.corps_name = _os_.unmarshal_Octets();
/*  55 */     this.opponent_corps_id = _os_.unmarshal_long();
/*  56 */     this.opponent_corps_name = _os_.unmarshal_Octets();
/*  57 */     this.fight_stage = _os_.unmarshal_int();
/*  58 */     this.fight_index_id = _os_.unmarshal_int();
/*  59 */     this.corps_fight_result = _os_.unmarshal_int();
/*  60 */     this.repeat_times = _os_.unmarshal_int();
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  65 */     if (_o1_ == this) return true;
/*  66 */     if ((_o1_ instanceof GetKnockOutContext_ReportFightResult)) {
/*  67 */       GetKnockOutContext_ReportFightResult _o_ = (GetKnockOutContext_ReportFightResult)_o1_;
/*  68 */       if (this.corps_id != _o_.corps_id) return false;
/*  69 */       if (!this.corps_name.equals(_o_.corps_name)) return false;
/*  70 */       if (this.opponent_corps_id != _o_.opponent_corps_id) return false;
/*  71 */       if (!this.opponent_corps_name.equals(_o_.opponent_corps_name)) return false;
/*  72 */       if (this.fight_stage != _o_.fight_stage) return false;
/*  73 */       if (this.fight_index_id != _o_.fight_index_id) return false;
/*  74 */       if (this.corps_fight_result != _o_.corps_fight_result) return false;
/*  75 */       if (this.repeat_times != _o_.repeat_times) return false;
/*  76 */       return true;
/*     */     }
/*  78 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  82 */     int _h_ = 0;
/*  83 */     _h_ += (int)this.corps_id;
/*  84 */     _h_ += this.corps_name.hashCode();
/*  85 */     _h_ += (int)this.opponent_corps_id;
/*  86 */     _h_ += this.opponent_corps_name.hashCode();
/*  87 */     _h_ += this.fight_stage;
/*  88 */     _h_ += this.fight_index_id;
/*  89 */     _h_ += this.corps_fight_result;
/*  90 */     _h_ += this.repeat_times;
/*  91 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  95 */     StringBuilder _sb_ = new StringBuilder();
/*  96 */     _sb_.append("(");
/*  97 */     _sb_.append(this.corps_id).append(",");
/*  98 */     _sb_.append("B").append(this.corps_name.size()).append(",");
/*  99 */     _sb_.append(this.opponent_corps_id).append(",");
/* 100 */     _sb_.append("B").append(this.opponent_corps_name.size()).append(",");
/* 101 */     _sb_.append(this.fight_stage).append(",");
/* 102 */     _sb_.append(this.fight_index_id).append(",");
/* 103 */     _sb_.append(this.corps_fight_result).append(",");
/* 104 */     _sb_.append(this.repeat_times).append(",");
/* 105 */     _sb_.append(")");
/* 106 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\GetKnockOutContext_ReportFightResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */