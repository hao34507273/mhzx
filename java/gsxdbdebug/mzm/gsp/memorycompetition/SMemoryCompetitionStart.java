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
/*     */ public class SMemoryCompetitionStart
/*     */   extends __SMemoryCompetitionStart__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12613136;
/*     */   public int activity_cfg_id;
/*     */   public int memory_competition_cfg_id;
/*     */   public HashMap<Integer, Integer> mapping_date;
/*     */   public int left_seconds;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12613136;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SMemoryCompetitionStart()
/*     */   {
/*  36 */     this.mapping_date = new HashMap();
/*     */   }
/*     */   
/*     */   public SMemoryCompetitionStart(int _activity_cfg_id_, int _memory_competition_cfg_id_, HashMap<Integer, Integer> _mapping_date_, int _left_seconds_) {
/*  40 */     this.activity_cfg_id = _activity_cfg_id_;
/*  41 */     this.memory_competition_cfg_id = _memory_competition_cfg_id_;
/*  42 */     this.mapping_date = _mapping_date_;
/*  43 */     this.left_seconds = _left_seconds_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  47 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  51 */     _os_.marshal(this.activity_cfg_id);
/*  52 */     _os_.marshal(this.memory_competition_cfg_id);
/*  53 */     _os_.compact_uint32(this.mapping_date.size());
/*  54 */     for (Map.Entry<Integer, Integer> _e_ : this.mapping_date.entrySet()) {
/*  55 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  56 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  58 */     _os_.marshal(this.left_seconds);
/*  59 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  63 */     this.activity_cfg_id = _os_.unmarshal_int();
/*  64 */     this.memory_competition_cfg_id = _os_.unmarshal_int();
/*  65 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  67 */       int _k_ = _os_.unmarshal_int();
/*     */       
/*  69 */       int _v_ = _os_.unmarshal_int();
/*  70 */       this.mapping_date.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*  72 */     this.left_seconds = _os_.unmarshal_int();
/*  73 */     if (!_validator_()) {
/*  74 */       throw new VerifyError("validator failed");
/*     */     }
/*  76 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  80 */     if (_o1_ == this) return true;
/*  81 */     if ((_o1_ instanceof SMemoryCompetitionStart)) {
/*  82 */       SMemoryCompetitionStart _o_ = (SMemoryCompetitionStart)_o1_;
/*  83 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/*  84 */       if (this.memory_competition_cfg_id != _o_.memory_competition_cfg_id) return false;
/*  85 */       if (!this.mapping_date.equals(_o_.mapping_date)) return false;
/*  86 */       if (this.left_seconds != _o_.left_seconds) return false;
/*  87 */       return true;
/*     */     }
/*  89 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  93 */     int _h_ = 0;
/*  94 */     _h_ += this.activity_cfg_id;
/*  95 */     _h_ += this.memory_competition_cfg_id;
/*  96 */     _h_ += this.mapping_date.hashCode();
/*  97 */     _h_ += this.left_seconds;
/*  98 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 102 */     StringBuilder _sb_ = new StringBuilder();
/* 103 */     _sb_.append("(");
/* 104 */     _sb_.append(this.activity_cfg_id).append(",");
/* 105 */     _sb_.append(this.memory_competition_cfg_id).append(",");
/* 106 */     _sb_.append(this.mapping_date).append(",");
/* 107 */     _sb_.append(this.left_seconds).append(",");
/* 108 */     _sb_.append(")");
/* 109 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\memorycompetition\SMemoryCompetitionStart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */