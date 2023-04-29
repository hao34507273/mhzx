/*     */ package mzm.gsp.planttree;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SSynPlantTreeDetailInfo
/*     */   extends __SSynPlantTreeDetailInfo__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12611601;
/*     */   public long owner_id;
/*     */   public int activity_cfg_id;
/*     */   public int current_section_id;
/*     */   public int current_section_point;
/*     */   public int special_state_index;
/*     */   public ArrayList<PlantTreeLog> logs;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12611601;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSynPlantTreeDetailInfo()
/*     */   {
/*  38 */     this.logs = new ArrayList();
/*     */   }
/*     */   
/*     */   public SSynPlantTreeDetailInfo(long _owner_id_, int _activity_cfg_id_, int _current_section_id_, int _current_section_point_, int _special_state_index_, ArrayList<PlantTreeLog> _logs_) {
/*  42 */     this.owner_id = _owner_id_;
/*  43 */     this.activity_cfg_id = _activity_cfg_id_;
/*  44 */     this.current_section_id = _current_section_id_;
/*  45 */     this.current_section_point = _current_section_point_;
/*  46 */     this.special_state_index = _special_state_index_;
/*  47 */     this.logs = _logs_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  51 */     for (PlantTreeLog _v_ : this.logs)
/*  52 */       if (!_v_._validator_()) return false;
/*  53 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  57 */     _os_.marshal(this.owner_id);
/*  58 */     _os_.marshal(this.activity_cfg_id);
/*  59 */     _os_.marshal(this.current_section_id);
/*  60 */     _os_.marshal(this.current_section_point);
/*  61 */     _os_.marshal(this.special_state_index);
/*  62 */     _os_.compact_uint32(this.logs.size());
/*  63 */     for (PlantTreeLog _v_ : this.logs) {
/*  64 */       _os_.marshal(_v_);
/*     */     }
/*  66 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  70 */     this.owner_id = _os_.unmarshal_long();
/*  71 */     this.activity_cfg_id = _os_.unmarshal_int();
/*  72 */     this.current_section_id = _os_.unmarshal_int();
/*  73 */     this.current_section_point = _os_.unmarshal_int();
/*  74 */     this.special_state_index = _os_.unmarshal_int();
/*  75 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  76 */       PlantTreeLog _v_ = new PlantTreeLog();
/*  77 */       _v_.unmarshal(_os_);
/*  78 */       this.logs.add(_v_);
/*     */     }
/*  80 */     if (!_validator_()) {
/*  81 */       throw new VerifyError("validator failed");
/*     */     }
/*  83 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  87 */     if (_o1_ == this) return true;
/*  88 */     if ((_o1_ instanceof SSynPlantTreeDetailInfo)) {
/*  89 */       SSynPlantTreeDetailInfo _o_ = (SSynPlantTreeDetailInfo)_o1_;
/*  90 */       if (this.owner_id != _o_.owner_id) return false;
/*  91 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/*  92 */       if (this.current_section_id != _o_.current_section_id) return false;
/*  93 */       if (this.current_section_point != _o_.current_section_point) return false;
/*  94 */       if (this.special_state_index != _o_.special_state_index) return false;
/*  95 */       if (!this.logs.equals(_o_.logs)) return false;
/*  96 */       return true;
/*     */     }
/*  98 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 102 */     int _h_ = 0;
/* 103 */     _h_ += (int)this.owner_id;
/* 104 */     _h_ += this.activity_cfg_id;
/* 105 */     _h_ += this.current_section_id;
/* 106 */     _h_ += this.current_section_point;
/* 107 */     _h_ += this.special_state_index;
/* 108 */     _h_ += this.logs.hashCode();
/* 109 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 113 */     StringBuilder _sb_ = new StringBuilder();
/* 114 */     _sb_.append("(");
/* 115 */     _sb_.append(this.owner_id).append(",");
/* 116 */     _sb_.append(this.activity_cfg_id).append(",");
/* 117 */     _sb_.append(this.current_section_id).append(",");
/* 118 */     _sb_.append(this.current_section_point).append(",");
/* 119 */     _sb_.append(this.special_state_index).append(",");
/* 120 */     _sb_.append(this.logs).append(",");
/* 121 */     _sb_.append(")");
/* 122 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\planttree\SSynPlantTreeDetailInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */