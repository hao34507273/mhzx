/*     */ package mzm.gsp.foolsday;
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
/*     */ 
/*     */ public class SSynFoolsDayInfo
/*     */   extends __SSynFoolsDayInfo__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12612872;
/*     */   public int make_chest_num;
/*     */   public ArrayList<Integer> alternative_buff_cfg_ids;
/*     */   public int refresh_time;
/*     */   public int point;
/*     */   public int has_get_title_award;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12612872;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSynFoolsDayInfo()
/*     */   {
/*  37 */     this.alternative_buff_cfg_ids = new ArrayList();
/*     */   }
/*     */   
/*     */   public SSynFoolsDayInfo(int _make_chest_num_, ArrayList<Integer> _alternative_buff_cfg_ids_, int _refresh_time_, int _point_, int _has_get_title_award_) {
/*  41 */     this.make_chest_num = _make_chest_num_;
/*  42 */     this.alternative_buff_cfg_ids = _alternative_buff_cfg_ids_;
/*  43 */     this.refresh_time = _refresh_time_;
/*  44 */     this.point = _point_;
/*  45 */     this.has_get_title_award = _has_get_title_award_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  49 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  53 */     _os_.marshal(this.make_chest_num);
/*  54 */     _os_.compact_uint32(this.alternative_buff_cfg_ids.size());
/*  55 */     for (Integer _v_ : this.alternative_buff_cfg_ids) {
/*  56 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  58 */     _os_.marshal(this.refresh_time);
/*  59 */     _os_.marshal(this.point);
/*  60 */     _os_.marshal(this.has_get_title_award);
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  65 */     this.make_chest_num = _os_.unmarshal_int();
/*  66 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  68 */       int _v_ = _os_.unmarshal_int();
/*  69 */       this.alternative_buff_cfg_ids.add(Integer.valueOf(_v_));
/*     */     }
/*  71 */     this.refresh_time = _os_.unmarshal_int();
/*  72 */     this.point = _os_.unmarshal_int();
/*  73 */     this.has_get_title_award = _os_.unmarshal_int();
/*  74 */     if (!_validator_()) {
/*  75 */       throw new VerifyError("validator failed");
/*     */     }
/*  77 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  81 */     if (_o1_ == this) return true;
/*  82 */     if ((_o1_ instanceof SSynFoolsDayInfo)) {
/*  83 */       SSynFoolsDayInfo _o_ = (SSynFoolsDayInfo)_o1_;
/*  84 */       if (this.make_chest_num != _o_.make_chest_num) return false;
/*  85 */       if (!this.alternative_buff_cfg_ids.equals(_o_.alternative_buff_cfg_ids)) return false;
/*  86 */       if (this.refresh_time != _o_.refresh_time) return false;
/*  87 */       if (this.point != _o_.point) return false;
/*  88 */       if (this.has_get_title_award != _o_.has_get_title_award) return false;
/*  89 */       return true;
/*     */     }
/*  91 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  95 */     int _h_ = 0;
/*  96 */     _h_ += this.make_chest_num;
/*  97 */     _h_ += this.alternative_buff_cfg_ids.hashCode();
/*  98 */     _h_ += this.refresh_time;
/*  99 */     _h_ += this.point;
/* 100 */     _h_ += this.has_get_title_award;
/* 101 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 105 */     StringBuilder _sb_ = new StringBuilder();
/* 106 */     _sb_.append("(");
/* 107 */     _sb_.append(this.make_chest_num).append(",");
/* 108 */     _sb_.append(this.alternative_buff_cfg_ids).append(",");
/* 109 */     _sb_.append(this.refresh_time).append(",");
/* 110 */     _sb_.append(this.point).append(",");
/* 111 */     _sb_.append(this.has_get_title_award).append(",");
/* 112 */     _sb_.append(")");
/* 113 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\foolsday\SSynFoolsDayInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */