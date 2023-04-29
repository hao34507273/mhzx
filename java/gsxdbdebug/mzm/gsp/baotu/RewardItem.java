/*    */ package mzm.gsp.baotu;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map.Entry;
/*    */ 
/*    */ public class RewardItem implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public static final int PARAM_ITEM_ID = 0;
/*    */   public static final int PARAM_ITEM_NUM = 1;
/*    */   public static final int PARAM_EXP = 2;
/*    */   public static final int PARAM_MONEY = 3;
/*    */   public static final int PARAM_MAP_ID = 4;
/*    */   public static final int PARAM_OCNTROLLER_ID = 5;
/*    */   public static final int TYPE_ITEM = 0;
/*    */   public static final int TYPE_ROLE_EXP = 1;
/*    */   public static final int TYPE_PET_EXP = 2;
/*    */   public static final int TYPE_XIULIAN_EXP = 3;
/*    */   public static final int TYPE_SILVER = 4;
/*    */   public static final int TYPE_GOLD = 5;
/*    */   public static final int TYPE_BANGGONG = 6;
/*    */   public static final int TYPE_CONTROLLER = 7;
/*    */   public static final int TYPE_YUANBAO = 8;
/*    */   public int rewardtype;
/*    */   public HashMap<Integer, Integer> parammap;
/*    */   
/*    */   public RewardItem()
/*    */   {
/* 29 */     this.parammap = new HashMap();
/*    */   }
/*    */   
/*    */   public RewardItem(int _rewardtype_, HashMap<Integer, Integer> _parammap_) {
/* 33 */     this.rewardtype = _rewardtype_;
/* 34 */     this.parammap = _parammap_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 38 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 42 */     _os_.marshal(this.rewardtype);
/* 43 */     _os_.compact_uint32(this.parammap.size());
/* 44 */     for (Map.Entry<Integer, Integer> _e_ : this.parammap.entrySet()) {
/* 45 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 46 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*    */     }
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 52 */     this.rewardtype = _os_.unmarshal_int();
/* 53 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 55 */       int _k_ = _os_.unmarshal_int();
/*    */       
/* 57 */       int _v_ = _os_.unmarshal_int();
/* 58 */       this.parammap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*    */     }
/* 60 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 64 */     if (_o1_ == this) return true;
/* 65 */     if ((_o1_ instanceof RewardItem)) {
/* 66 */       RewardItem _o_ = (RewardItem)_o1_;
/* 67 */       if (this.rewardtype != _o_.rewardtype) return false;
/* 68 */       if (!this.parammap.equals(_o_.parammap)) return false;
/* 69 */       return true;
/*    */     }
/* 71 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 75 */     int _h_ = 0;
/* 76 */     _h_ += this.rewardtype;
/* 77 */     _h_ += this.parammap.hashCode();
/* 78 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 82 */     StringBuilder _sb_ = new StringBuilder();
/* 83 */     _sb_.append("(");
/* 84 */     _sb_.append(this.rewardtype).append(",");
/* 85 */     _sb_.append(this.parammap).append(",");
/* 86 */     _sb_.append(")");
/* 87 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\baotu\RewardItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */