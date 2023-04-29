/*     */ package mzm.gsp.signaward;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map.Entry;
/*     */ 
/*     */ public class SSignInRes extends __SSignInRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12593414;
/*     */   public int signday;
/*     */   public int signcount;
/*     */   public int fillincount;
/*     */   public int issignedtoday;
/*     */   public int currentdate;
/*     */   public HashMap<Integer, Integer> item2num;
/*     */   public int current_precious_cell_num;
/*     */   public int current_precious_cell_buff_id;
/*     */   public int is_first_box_aleardy_get;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  25 */     return 12593414;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSignInRes()
/*     */   {
/*  39 */     this.item2num = new HashMap();
/*     */   }
/*     */   
/*     */   public SSignInRes(int _signday_, int _signcount_, int _fillincount_, int _issignedtoday_, int _currentdate_, HashMap<Integer, Integer> _item2num_, int _current_precious_cell_num_, int _current_precious_cell_buff_id_, int _is_first_box_aleardy_get_) {
/*  43 */     this.signday = _signday_;
/*  44 */     this.signcount = _signcount_;
/*  45 */     this.fillincount = _fillincount_;
/*  46 */     this.issignedtoday = _issignedtoday_;
/*  47 */     this.currentdate = _currentdate_;
/*  48 */     this.item2num = _item2num_;
/*  49 */     this.current_precious_cell_num = _current_precious_cell_num_;
/*  50 */     this.current_precious_cell_buff_id = _current_precious_cell_buff_id_;
/*  51 */     this.is_first_box_aleardy_get = _is_first_box_aleardy_get_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  55 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  59 */     _os_.marshal(this.signday);
/*  60 */     _os_.marshal(this.signcount);
/*  61 */     _os_.marshal(this.fillincount);
/*  62 */     _os_.marshal(this.issignedtoday);
/*  63 */     _os_.marshal(this.currentdate);
/*  64 */     _os_.compact_uint32(this.item2num.size());
/*  65 */     for (Map.Entry<Integer, Integer> _e_ : this.item2num.entrySet()) {
/*  66 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  67 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  69 */     _os_.marshal(this.current_precious_cell_num);
/*  70 */     _os_.marshal(this.current_precious_cell_buff_id);
/*  71 */     _os_.marshal(this.is_first_box_aleardy_get);
/*  72 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  76 */     this.signday = _os_.unmarshal_int();
/*  77 */     this.signcount = _os_.unmarshal_int();
/*  78 */     this.fillincount = _os_.unmarshal_int();
/*  79 */     this.issignedtoday = _os_.unmarshal_int();
/*  80 */     this.currentdate = _os_.unmarshal_int();
/*  81 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  83 */       int _k_ = _os_.unmarshal_int();
/*     */       
/*  85 */       int _v_ = _os_.unmarshal_int();
/*  86 */       this.item2num.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*  88 */     this.current_precious_cell_num = _os_.unmarshal_int();
/*  89 */     this.current_precious_cell_buff_id = _os_.unmarshal_int();
/*  90 */     this.is_first_box_aleardy_get = _os_.unmarshal_int();
/*  91 */     if (!_validator_()) {
/*  92 */       throw new VerifyError("validator failed");
/*     */     }
/*  94 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  98 */     if (_o1_ == this) return true;
/*  99 */     if ((_o1_ instanceof SSignInRes)) {
/* 100 */       SSignInRes _o_ = (SSignInRes)_o1_;
/* 101 */       if (this.signday != _o_.signday) return false;
/* 102 */       if (this.signcount != _o_.signcount) return false;
/* 103 */       if (this.fillincount != _o_.fillincount) return false;
/* 104 */       if (this.issignedtoday != _o_.issignedtoday) return false;
/* 105 */       if (this.currentdate != _o_.currentdate) return false;
/* 106 */       if (!this.item2num.equals(_o_.item2num)) return false;
/* 107 */       if (this.current_precious_cell_num != _o_.current_precious_cell_num) return false;
/* 108 */       if (this.current_precious_cell_buff_id != _o_.current_precious_cell_buff_id) return false;
/* 109 */       if (this.is_first_box_aleardy_get != _o_.is_first_box_aleardy_get) return false;
/* 110 */       return true;
/*     */     }
/* 112 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 116 */     int _h_ = 0;
/* 117 */     _h_ += this.signday;
/* 118 */     _h_ += this.signcount;
/* 119 */     _h_ += this.fillincount;
/* 120 */     _h_ += this.issignedtoday;
/* 121 */     _h_ += this.currentdate;
/* 122 */     _h_ += this.item2num.hashCode();
/* 123 */     _h_ += this.current_precious_cell_num;
/* 124 */     _h_ += this.current_precious_cell_buff_id;
/* 125 */     _h_ += this.is_first_box_aleardy_get;
/* 126 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 130 */     StringBuilder _sb_ = new StringBuilder();
/* 131 */     _sb_.append("(");
/* 132 */     _sb_.append(this.signday).append(",");
/* 133 */     _sb_.append(this.signcount).append(",");
/* 134 */     _sb_.append(this.fillincount).append(",");
/* 135 */     _sb_.append(this.issignedtoday).append(",");
/* 136 */     _sb_.append(this.currentdate).append(",");
/* 137 */     _sb_.append(this.item2num).append(",");
/* 138 */     _sb_.append(this.current_precious_cell_num).append(",");
/* 139 */     _sb_.append(this.current_precious_cell_buff_id).append(",");
/* 140 */     _sb_.append(this.is_first_box_aleardy_get).append(",");
/* 141 */     _sb_.append(")");
/* 142 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\signaward\SSignInRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */