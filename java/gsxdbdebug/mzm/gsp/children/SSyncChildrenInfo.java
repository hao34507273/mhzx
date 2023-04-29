/*     */ package mzm.gsp.children;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map.Entry;
/*     */ 
/*     */ public class SSyncChildrenInfo extends __SSyncChildrenInfo__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12609285;
/*     */   public static final int NO_CHILD_SHOW = -1;
/*     */   public static final int LOGIN = 0;
/*     */   public static final int DIVORCE = 1;
/*     */   public static final int MARRIAGE = 2;
/*     */   public HashMap<Long, ChildBean> child_info_map;
/*     */   public long show_child_id;
/*     */   public int show_child_period;
/*     */   public ArrayList<Long> bag_child_id_list;
/*     */   public int sync_type;
/*     */   public HashMap<Long, Long> discard_child_map;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12609285;
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
/*     */ 
/*     */ 
/*     */   public SSyncChildrenInfo()
/*     */   {
/*  43 */     this.child_info_map = new HashMap();
/*  44 */     this.bag_child_id_list = new ArrayList();
/*  45 */     this.discard_child_map = new HashMap();
/*     */   }
/*     */   
/*     */   public SSyncChildrenInfo(HashMap<Long, ChildBean> _child_info_map_, long _show_child_id_, int _show_child_period_, ArrayList<Long> _bag_child_id_list_, int _sync_type_, HashMap<Long, Long> _discard_child_map_) {
/*  49 */     this.child_info_map = _child_info_map_;
/*  50 */     this.show_child_id = _show_child_id_;
/*  51 */     this.show_child_period = _show_child_period_;
/*  52 */     this.bag_child_id_list = _bag_child_id_list_;
/*  53 */     this.sync_type = _sync_type_;
/*  54 */     this.discard_child_map = _discard_child_map_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  58 */     for (Map.Entry<Long, ChildBean> _e_ : this.child_info_map.entrySet()) {
/*  59 */       if (!((ChildBean)_e_.getValue())._validator_()) return false;
/*     */     }
/*  61 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  65 */     _os_.compact_uint32(this.child_info_map.size());
/*  66 */     for (Map.Entry<Long, ChildBean> _e_ : this.child_info_map.entrySet()) {
/*  67 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  68 */       _os_.marshal((Marshal)_e_.getValue());
/*     */     }
/*  70 */     _os_.marshal(this.show_child_id);
/*  71 */     _os_.marshal(this.show_child_period);
/*  72 */     _os_.compact_uint32(this.bag_child_id_list.size());
/*  73 */     for (Long _v_ : this.bag_child_id_list) {
/*  74 */       _os_.marshal(_v_.longValue());
/*     */     }
/*  76 */     _os_.marshal(this.sync_type);
/*  77 */     _os_.compact_uint32(this.discard_child_map.size());
/*  78 */     for (Map.Entry<Long, Long> _e_ : this.discard_child_map.entrySet()) {
/*  79 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  80 */       _os_.marshal(((Long)_e_.getValue()).longValue());
/*     */     }
/*  82 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  86 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  88 */       long _k_ = _os_.unmarshal_long();
/*  89 */       ChildBean _v_ = new ChildBean();
/*  90 */       _v_.unmarshal(_os_);
/*  91 */       this.child_info_map.put(Long.valueOf(_k_), _v_);
/*     */     }
/*  93 */     this.show_child_id = _os_.unmarshal_long();
/*  94 */     this.show_child_period = _os_.unmarshal_int();
/*  95 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  97 */       long _v_ = _os_.unmarshal_long();
/*  98 */       this.bag_child_id_list.add(Long.valueOf(_v_));
/*     */     }
/* 100 */     this.sync_type = _os_.unmarshal_int();
/* 101 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/* 103 */       long _k_ = _os_.unmarshal_long();
/*     */       
/* 105 */       long _v_ = _os_.unmarshal_long();
/* 106 */       this.discard_child_map.put(Long.valueOf(_k_), Long.valueOf(_v_));
/*     */     }
/* 108 */     if (!_validator_()) {
/* 109 */       throw new VerifyError("validator failed");
/*     */     }
/* 111 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/* 115 */     if (_o1_ == this) return true;
/* 116 */     if ((_o1_ instanceof SSyncChildrenInfo)) {
/* 117 */       SSyncChildrenInfo _o_ = (SSyncChildrenInfo)_o1_;
/* 118 */       if (!this.child_info_map.equals(_o_.child_info_map)) return false;
/* 119 */       if (this.show_child_id != _o_.show_child_id) return false;
/* 120 */       if (this.show_child_period != _o_.show_child_period) return false;
/* 121 */       if (!this.bag_child_id_list.equals(_o_.bag_child_id_list)) return false;
/* 122 */       if (this.sync_type != _o_.sync_type) return false;
/* 123 */       if (!this.discard_child_map.equals(_o_.discard_child_map)) return false;
/* 124 */       return true;
/*     */     }
/* 126 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 130 */     int _h_ = 0;
/* 131 */     _h_ += this.child_info_map.hashCode();
/* 132 */     _h_ += (int)this.show_child_id;
/* 133 */     _h_ += this.show_child_period;
/* 134 */     _h_ += this.bag_child_id_list.hashCode();
/* 135 */     _h_ += this.sync_type;
/* 136 */     _h_ += this.discard_child_map.hashCode();
/* 137 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 141 */     StringBuilder _sb_ = new StringBuilder();
/* 142 */     _sb_.append("(");
/* 143 */     _sb_.append(this.child_info_map).append(",");
/* 144 */     _sb_.append(this.show_child_id).append(",");
/* 145 */     _sb_.append(this.show_child_period).append(",");
/* 146 */     _sb_.append(this.bag_child_id_list).append(",");
/* 147 */     _sb_.append(this.sync_type).append(",");
/* 148 */     _sb_.append(this.discard_child_map).append(",");
/* 149 */     _sb_.append(")");
/* 150 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\SSyncChildrenInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */