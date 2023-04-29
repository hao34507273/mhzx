/*    */ package mzm.gsp.children;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map.Entry;
/*    */ 
/*    */ public class BabyPeriodInfo implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public static final int BREED_TYPE_PLAYER = 0;
/*    */   public static final int BREED_TYPE_AUTO = 1;
/*    */   public HashMap<Integer, Integer> baby_property_info_map;
/*    */   public int health_score;
/*    */   public int remain_operator;
/*    */   public long remain_seconds;
/*    */   public int breed_type;
/*    */   
/*    */   public BabyPeriodInfo()
/*    */   {
/* 19 */     this.baby_property_info_map = new HashMap();
/* 20 */     this.breed_type = 0;
/*    */   }
/*    */   
/*    */   public BabyPeriodInfo(HashMap<Integer, Integer> _baby_property_info_map_, int _health_score_, int _remain_operator_, long _remain_seconds_, int _breed_type_) {
/* 24 */     this.baby_property_info_map = _baby_property_info_map_;
/* 25 */     this.health_score = _health_score_;
/* 26 */     this.remain_operator = _remain_operator_;
/* 27 */     this.remain_seconds = _remain_seconds_;
/* 28 */     this.breed_type = _breed_type_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 32 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 36 */     _os_.compact_uint32(this.baby_property_info_map.size());
/* 37 */     for (Map.Entry<Integer, Integer> _e_ : this.baby_property_info_map.entrySet()) {
/* 38 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 39 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*    */     }
/* 41 */     _os_.marshal(this.health_score);
/* 42 */     _os_.marshal(this.remain_operator);
/* 43 */     _os_.marshal(this.remain_seconds);
/* 44 */     _os_.marshal(this.breed_type);
/* 45 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 49 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 51 */       int _k_ = _os_.unmarshal_int();
/*    */       
/* 53 */       int _v_ = _os_.unmarshal_int();
/* 54 */       this.baby_property_info_map.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*    */     }
/* 56 */     this.health_score = _os_.unmarshal_int();
/* 57 */     this.remain_operator = _os_.unmarshal_int();
/* 58 */     this.remain_seconds = _os_.unmarshal_long();
/* 59 */     this.breed_type = _os_.unmarshal_int();
/* 60 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 64 */     if (_o1_ == this) return true;
/* 65 */     if ((_o1_ instanceof BabyPeriodInfo)) {
/* 66 */       BabyPeriodInfo _o_ = (BabyPeriodInfo)_o1_;
/* 67 */       if (!this.baby_property_info_map.equals(_o_.baby_property_info_map)) return false;
/* 68 */       if (this.health_score != _o_.health_score) return false;
/* 69 */       if (this.remain_operator != _o_.remain_operator) return false;
/* 70 */       if (this.remain_seconds != _o_.remain_seconds) return false;
/* 71 */       if (this.breed_type != _o_.breed_type) return false;
/* 72 */       return true;
/*    */     }
/* 74 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 78 */     int _h_ = 0;
/* 79 */     _h_ += this.baby_property_info_map.hashCode();
/* 80 */     _h_ += this.health_score;
/* 81 */     _h_ += this.remain_operator;
/* 82 */     _h_ += (int)this.remain_seconds;
/* 83 */     _h_ += this.breed_type;
/* 84 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 88 */     StringBuilder _sb_ = new StringBuilder();
/* 89 */     _sb_.append("(");
/* 90 */     _sb_.append(this.baby_property_info_map).append(",");
/* 91 */     _sb_.append(this.health_score).append(",");
/* 92 */     _sb_.append(this.remain_operator).append(",");
/* 93 */     _sb_.append(this.remain_seconds).append(",");
/* 94 */     _sb_.append(this.breed_type).append(",");
/* 95 */     _sb_.append(")");
/* 96 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\BabyPeriodInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */