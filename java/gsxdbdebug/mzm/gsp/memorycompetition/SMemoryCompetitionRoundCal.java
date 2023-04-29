/*     */ package mzm.gsp.memorycompetition;
/*     */ 
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
/*     */ 
/*     */ public class SMemoryCompetitionRoundCal
/*     */   extends __SMemoryCompetitionRoundCal__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12613135;
/*     */   public int activity_cfg_id;
/*     */   public HashMap<Long, Integer> answer_result_map;
/*     */   public int score;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12613135;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SMemoryCompetitionRoundCal()
/*     */   {
/*  35 */     this.answer_result_map = new HashMap();
/*     */   }
/*     */   
/*     */   public SMemoryCompetitionRoundCal(int _activity_cfg_id_, HashMap<Long, Integer> _answer_result_map_, int _score_) {
/*  39 */     this.activity_cfg_id = _activity_cfg_id_;
/*  40 */     this.answer_result_map = _answer_result_map_;
/*  41 */     this.score = _score_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  45 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  49 */     _os_.marshal(this.activity_cfg_id);
/*  50 */     _os_.compact_uint32(this.answer_result_map.size());
/*  51 */     for (Map.Entry<Long, Integer> _e_ : this.answer_result_map.entrySet()) {
/*  52 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  53 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  55 */     _os_.marshal(this.score);
/*  56 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  60 */     this.activity_cfg_id = _os_.unmarshal_int();
/*  61 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  63 */       long _k_ = _os_.unmarshal_long();
/*     */       
/*  65 */       int _v_ = _os_.unmarshal_int();
/*  66 */       this.answer_result_map.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*  68 */     this.score = _os_.unmarshal_int();
/*  69 */     if (!_validator_()) {
/*  70 */       throw new VerifyError("validator failed");
/*     */     }
/*  72 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  76 */     if (_o1_ == this) return true;
/*  77 */     if ((_o1_ instanceof SMemoryCompetitionRoundCal)) {
/*  78 */       SMemoryCompetitionRoundCal _o_ = (SMemoryCompetitionRoundCal)_o1_;
/*  79 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/*  80 */       if (!this.answer_result_map.equals(_o_.answer_result_map)) return false;
/*  81 */       if (this.score != _o_.score) return false;
/*  82 */       return true;
/*     */     }
/*  84 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  88 */     int _h_ = 0;
/*  89 */     _h_ += this.activity_cfg_id;
/*  90 */     _h_ += this.answer_result_map.hashCode();
/*  91 */     _h_ += this.score;
/*  92 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  96 */     StringBuilder _sb_ = new StringBuilder();
/*  97 */     _sb_.append("(");
/*  98 */     _sb_.append(this.activity_cfg_id).append(",");
/*  99 */     _sb_.append(this.answer_result_map).append(",");
/* 100 */     _sb_.append(this.score).append(",");
/* 101 */     _sb_.append(")");
/* 102 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\memorycompetition\SMemoryCompetitionRoundCal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */