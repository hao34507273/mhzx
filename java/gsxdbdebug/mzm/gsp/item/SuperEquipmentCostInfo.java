/*    */ package mzm.gsp.item;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashMap;
/*    */ 
/*    */ public class SuperEquipmentCostInfo implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public HashMap<Integer, Integer> stage_cost_map;
/*    */   public HashMap<Integer, Integer> level_cost_map;
/*    */   
/*    */   public SuperEquipmentCostInfo()
/*    */   {
/* 13 */     this.stage_cost_map = new HashMap();
/* 14 */     this.level_cost_map = new HashMap();
/*    */   }
/*    */   
/*    */   public SuperEquipmentCostInfo(HashMap<Integer, Integer> _stage_cost_map_, HashMap<Integer, Integer> _level_cost_map_) {
/* 18 */     this.stage_cost_map = _stage_cost_map_;
/* 19 */     this.level_cost_map = _level_cost_map_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 23 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 27 */     _os_.compact_uint32(this.stage_cost_map.size());
/* 28 */     for (java.util.Map.Entry<Integer, Integer> _e_ : this.stage_cost_map.entrySet()) {
/* 29 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 30 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*    */     }
/* 32 */     _os_.compact_uint32(this.level_cost_map.size());
/* 33 */     for (java.util.Map.Entry<Integer, Integer> _e_ : this.level_cost_map.entrySet()) {
/* 34 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 35 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*    */     }
/* 37 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 41 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 43 */       int _k_ = _os_.unmarshal_int();
/*    */       
/* 45 */       int _v_ = _os_.unmarshal_int();
/* 46 */       this.stage_cost_map.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*    */     }
/* 48 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 50 */       int _k_ = _os_.unmarshal_int();
/*    */       
/* 52 */       int _v_ = _os_.unmarshal_int();
/* 53 */       this.level_cost_map.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 59 */     if (_o1_ == this) return true;
/* 60 */     if ((_o1_ instanceof SuperEquipmentCostInfo)) {
/* 61 */       SuperEquipmentCostInfo _o_ = (SuperEquipmentCostInfo)_o1_;
/* 62 */       if (!this.stage_cost_map.equals(_o_.stage_cost_map)) return false;
/* 63 */       if (!this.level_cost_map.equals(_o_.level_cost_map)) return false;
/* 64 */       return true;
/*    */     }
/* 66 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 70 */     int _h_ = 0;
/* 71 */     _h_ += this.stage_cost_map.hashCode();
/* 72 */     _h_ += this.level_cost_map.hashCode();
/* 73 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 77 */     StringBuilder _sb_ = new StringBuilder();
/* 78 */     _sb_.append("(");
/* 79 */     _sb_.append(this.stage_cost_map).append(",");
/* 80 */     _sb_.append(this.level_cost_map).append(",");
/* 81 */     _sb_.append(")");
/* 82 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\SuperEquipmentCostInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */