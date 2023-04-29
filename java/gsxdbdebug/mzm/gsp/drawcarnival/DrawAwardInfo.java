/*    */ package mzm.gsp.drawcarnival;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map.Entry;
/*    */ 
/*    */ public class DrawAwardInfo implements Marshal
/*    */ {
/*    */   public static final int YUAN_BAO_BIG_AWARD = 1;
/*    */   public static final int CHEST_AWARD = 2;
/*    */   public static final int OTHER_AWARD = 4;
/*    */   public int item_type;
/*    */   public int index;
/*    */   public HashMap<Integer, Integer> item_cfg_id2count;
/*    */   
/*    */   public DrawAwardInfo()
/*    */   {
/* 20 */     this.item_cfg_id2count = new HashMap();
/*    */   }
/*    */   
/*    */   public DrawAwardInfo(int _item_type_, int _index_, HashMap<Integer, Integer> _item_cfg_id2count_) {
/* 24 */     this.item_type = _item_type_;
/* 25 */     this.index = _index_;
/* 26 */     this.item_cfg_id2count = _item_cfg_id2count_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 30 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 34 */     _os_.marshal(this.item_type);
/* 35 */     _os_.marshal(this.index);
/* 36 */     _os_.compact_uint32(this.item_cfg_id2count.size());
/* 37 */     for (Map.Entry<Integer, Integer> _e_ : this.item_cfg_id2count.entrySet()) {
/* 38 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 39 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*    */     }
/* 41 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 45 */     this.item_type = _os_.unmarshal_int();
/* 46 */     this.index = _os_.unmarshal_int();
/* 47 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 49 */       int _k_ = _os_.unmarshal_int();
/*    */       
/* 51 */       int _v_ = _os_.unmarshal_int();
/* 52 */       this.item_cfg_id2count.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*    */     }
/* 54 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 58 */     if (_o1_ == this) return true;
/* 59 */     if ((_o1_ instanceof DrawAwardInfo)) {
/* 60 */       DrawAwardInfo _o_ = (DrawAwardInfo)_o1_;
/* 61 */       if (this.item_type != _o_.item_type) return false;
/* 62 */       if (this.index != _o_.index) return false;
/* 63 */       if (!this.item_cfg_id2count.equals(_o_.item_cfg_id2count)) return false;
/* 64 */       return true;
/*    */     }
/* 66 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 70 */     int _h_ = 0;
/* 71 */     _h_ += this.item_type;
/* 72 */     _h_ += this.index;
/* 73 */     _h_ += this.item_cfg_id2count.hashCode();
/* 74 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 78 */     StringBuilder _sb_ = new StringBuilder();
/* 79 */     _sb_.append("(");
/* 80 */     _sb_.append(this.item_type).append(",");
/* 81 */     _sb_.append(this.index).append(",");
/* 82 */     _sb_.append(this.item_cfg_id2count).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\drawcarnival\DrawAwardInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */