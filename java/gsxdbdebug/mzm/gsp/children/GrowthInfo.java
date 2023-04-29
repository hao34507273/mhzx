/*    */ package mzm.gsp.children;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashMap;
/*    */ 
/*    */ public class GrowthInfo implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public int grow_type;
/*    */   public long growth_time;
/*    */   public HashMap<Integer, Integer> int_parameter_map;
/*    */   public HashMap<Integer, com.goldhuman.Common.Octets> string_parameter_map;
/*    */   
/*    */   public GrowthInfo()
/*    */   {
/* 15 */     this.int_parameter_map = new HashMap();
/* 16 */     this.string_parameter_map = new HashMap();
/*    */   }
/*    */   
/*    */   public GrowthInfo(int _grow_type_, long _growth_time_, HashMap<Integer, Integer> _int_parameter_map_, HashMap<Integer, com.goldhuman.Common.Octets> _string_parameter_map_) {
/* 20 */     this.grow_type = _grow_type_;
/* 21 */     this.growth_time = _growth_time_;
/* 22 */     this.int_parameter_map = _int_parameter_map_;
/* 23 */     this.string_parameter_map = _string_parameter_map_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 27 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 31 */     _os_.marshal(this.grow_type);
/* 32 */     _os_.marshal(this.growth_time);
/* 33 */     _os_.compact_uint32(this.int_parameter_map.size());
/* 34 */     for (java.util.Map.Entry<Integer, Integer> _e_ : this.int_parameter_map.entrySet()) {
/* 35 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 36 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*    */     }
/* 38 */     _os_.compact_uint32(this.string_parameter_map.size());
/* 39 */     for (java.util.Map.Entry<Integer, com.goldhuman.Common.Octets> _e_ : this.string_parameter_map.entrySet()) {
/* 40 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 41 */       _os_.marshal((com.goldhuman.Common.Octets)_e_.getValue());
/*    */     }
/* 43 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 47 */     this.grow_type = _os_.unmarshal_int();
/* 48 */     this.growth_time = _os_.unmarshal_long();
/* 49 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 51 */       int _k_ = _os_.unmarshal_int();
/*    */       
/* 53 */       int _v_ = _os_.unmarshal_int();
/* 54 */       this.int_parameter_map.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*    */     }
/* 56 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 58 */       int _k_ = _os_.unmarshal_int();
/*    */       
/* 60 */       com.goldhuman.Common.Octets _v_ = _os_.unmarshal_Octets();
/* 61 */       this.string_parameter_map.put(Integer.valueOf(_k_), _v_);
/*    */     }
/* 63 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 67 */     if (_o1_ == this) return true;
/* 68 */     if ((_o1_ instanceof GrowthInfo)) {
/* 69 */       GrowthInfo _o_ = (GrowthInfo)_o1_;
/* 70 */       if (this.grow_type != _o_.grow_type) return false;
/* 71 */       if (this.growth_time != _o_.growth_time) return false;
/* 72 */       if (!this.int_parameter_map.equals(_o_.int_parameter_map)) return false;
/* 73 */       if (!this.string_parameter_map.equals(_o_.string_parameter_map)) return false;
/* 74 */       return true;
/*    */     }
/* 76 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 80 */     int _h_ = 0;
/* 81 */     _h_ += this.grow_type;
/* 82 */     _h_ += (int)this.growth_time;
/* 83 */     _h_ += this.int_parameter_map.hashCode();
/* 84 */     _h_ += this.string_parameter_map.hashCode();
/* 85 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 89 */     StringBuilder _sb_ = new StringBuilder();
/* 90 */     _sb_.append("(");
/* 91 */     _sb_.append(this.grow_type).append(",");
/* 92 */     _sb_.append(this.growth_time).append(",");
/* 93 */     _sb_.append(this.int_parameter_map).append(",");
/* 94 */     _sb_.append(this.string_parameter_map).append(",");
/* 95 */     _sb_.append(")");
/* 96 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\GrowthInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */