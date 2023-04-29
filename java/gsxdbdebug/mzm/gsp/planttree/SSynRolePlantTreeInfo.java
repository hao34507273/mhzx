/*     */ package mzm.gsp.planttree;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashSet;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SSynRolePlantTreeInfo
/*     */   extends __SSynRolePlantTreeInfo__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12611587;
/*     */   public int activity_cfg_id;
/*     */   public HashSet<Integer> award_section_ids;
/*     */   public int has_get_activity_complete_award;
/*     */   public int add_point_times;
/*     */   public int remove_special_state_award_times;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12611587;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSynRolePlantTreeInfo()
/*     */   {
/*  37 */     this.award_section_ids = new HashSet();
/*  38 */     this.has_get_activity_complete_award = 0;
/*  39 */     this.add_point_times = 0;
/*  40 */     this.remove_special_state_award_times = 0;
/*     */   }
/*     */   
/*     */   public SSynRolePlantTreeInfo(int _activity_cfg_id_, HashSet<Integer> _award_section_ids_, int _has_get_activity_complete_award_, int _add_point_times_, int _remove_special_state_award_times_) {
/*  44 */     this.activity_cfg_id = _activity_cfg_id_;
/*  45 */     this.award_section_ids = _award_section_ids_;
/*  46 */     this.has_get_activity_complete_award = _has_get_activity_complete_award_;
/*  47 */     this.add_point_times = _add_point_times_;
/*  48 */     this.remove_special_state_award_times = _remove_special_state_award_times_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  52 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  56 */     _os_.marshal(this.activity_cfg_id);
/*  57 */     _os_.compact_uint32(this.award_section_ids.size());
/*  58 */     for (Integer _v_ : this.award_section_ids) {
/*  59 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  61 */     _os_.marshal(this.has_get_activity_complete_award);
/*  62 */     _os_.marshal(this.add_point_times);
/*  63 */     _os_.marshal(this.remove_special_state_award_times);
/*  64 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  68 */     this.activity_cfg_id = _os_.unmarshal_int();
/*  69 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  71 */       int _v_ = _os_.unmarshal_int();
/*  72 */       this.award_section_ids.add(Integer.valueOf(_v_));
/*     */     }
/*  74 */     this.has_get_activity_complete_award = _os_.unmarshal_int();
/*  75 */     this.add_point_times = _os_.unmarshal_int();
/*  76 */     this.remove_special_state_award_times = _os_.unmarshal_int();
/*  77 */     if (!_validator_()) {
/*  78 */       throw new VerifyError("validator failed");
/*     */     }
/*  80 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  84 */     if (_o1_ == this) return true;
/*  85 */     if ((_o1_ instanceof SSynRolePlantTreeInfo)) {
/*  86 */       SSynRolePlantTreeInfo _o_ = (SSynRolePlantTreeInfo)_o1_;
/*  87 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/*  88 */       if (!this.award_section_ids.equals(_o_.award_section_ids)) return false;
/*  89 */       if (this.has_get_activity_complete_award != _o_.has_get_activity_complete_award) return false;
/*  90 */       if (this.add_point_times != _o_.add_point_times) return false;
/*  91 */       if (this.remove_special_state_award_times != _o_.remove_special_state_award_times) return false;
/*  92 */       return true;
/*     */     }
/*  94 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  98 */     int _h_ = 0;
/*  99 */     _h_ += this.activity_cfg_id;
/* 100 */     _h_ += this.award_section_ids.hashCode();
/* 101 */     _h_ += this.has_get_activity_complete_award;
/* 102 */     _h_ += this.add_point_times;
/* 103 */     _h_ += this.remove_special_state_award_times;
/* 104 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 108 */     StringBuilder _sb_ = new StringBuilder();
/* 109 */     _sb_.append("(");
/* 110 */     _sb_.append(this.activity_cfg_id).append(",");
/* 111 */     _sb_.append(this.award_section_ids).append(",");
/* 112 */     _sb_.append(this.has_get_activity_complete_award).append(",");
/* 113 */     _sb_.append(this.add_point_times).append(",");
/* 114 */     _sb_.append(this.remove_special_state_award_times).append(",");
/* 115 */     _sb_.append(")");
/* 116 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\planttree\SSynRolePlantTreeInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */