/*    */ package mzm.gsp.question;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map.Entry;
/*    */ 
/*    */ public class RewardItem implements Marshal
/*    */ {
/*    */   public static final int PARAM_ITEM_ID = 0;
/*    */   public static final int PARAM_ITEM_NUM = 1;
/*    */   public static final int PARAM_EXP = 2;
/*    */   public static final int PARAM_MONEY = 3;
/*    */   public static final int PARAM_CONTROLLER_ID = 4;
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
/* 30 */     this.parammap = new HashMap();
/*    */   }
/*    */   
/*    */   public RewardItem(int _rewardtype_, HashMap<Integer, Integer> _parammap_) {
/* 34 */     this.rewardtype = _rewardtype_;
/* 35 */     this.parammap = _parammap_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 39 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 43 */     _os_.marshal(this.rewardtype);
/* 44 */     _os_.compact_uint32(this.parammap.size());
/* 45 */     for (Map.Entry<Integer, Integer> _e_ : this.parammap.entrySet()) {
/* 46 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 47 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*    */     }
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 53 */     this.rewardtype = _os_.unmarshal_int();
/* 54 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 56 */       int _k_ = _os_.unmarshal_int();
/*    */       
/* 58 */       int _v_ = _os_.unmarshal_int();
/* 59 */       this.parammap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*    */     }
/* 61 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 65 */     if (_o1_ == this) return true;
/* 66 */     if ((_o1_ instanceof RewardItem)) {
/* 67 */       RewardItem _o_ = (RewardItem)_o1_;
/* 68 */       if (this.rewardtype != _o_.rewardtype) return false;
/* 69 */       if (!this.parammap.equals(_o_.parammap)) return false;
/* 70 */       return true;
/*    */     }
/* 72 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 76 */     int _h_ = 0;
/* 77 */     _h_ += this.rewardtype;
/* 78 */     _h_ += this.parammap.hashCode();
/* 79 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 83 */     StringBuilder _sb_ = new StringBuilder();
/* 84 */     _sb_.append("(");
/* 85 */     _sb_.append(this.rewardtype).append(",");
/* 86 */     _sb_.append(this.parammap).append(",");
/* 87 */     _sb_.append(")");
/* 88 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\RewardItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */