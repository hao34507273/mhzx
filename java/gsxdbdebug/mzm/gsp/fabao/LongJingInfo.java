/*    */ package mzm.gsp.fabao;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashMap;
/*    */ import mzm.gsp.item.ItemInfo;
/*    */ 
/*    */ public class LongJingInfo implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public static final int LONG_JING_POS_1 = 1;
/*    */   public static final int LONG_JING_POS_2 = 2;
/*    */   public static final int LONG_JING_POS_3 = 3;
/*    */   public HashMap<Integer, ItemInfo> longjingitems;
/*    */   
/*    */   public LongJingInfo()
/*    */   {
/* 16 */     this.longjingitems = new HashMap();
/*    */   }
/*    */   
/*    */   public LongJingInfo(HashMap<Integer, ItemInfo> _longjingitems_) {
/* 20 */     this.longjingitems = _longjingitems_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 24 */     for (java.util.Map.Entry<Integer, ItemInfo> _e_ : this.longjingitems.entrySet()) {
/* 25 */       if (!((ItemInfo)_e_.getValue())._validator_()) return false;
/*    */     }
/* 27 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 31 */     _os_.compact_uint32(this.longjingitems.size());
/* 32 */     for (java.util.Map.Entry<Integer, ItemInfo> _e_ : this.longjingitems.entrySet()) {
/* 33 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 34 */       _os_.marshal((com.goldhuman.Common.Marshal.Marshal)_e_.getValue());
/*    */     }
/* 36 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 40 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 42 */       int _k_ = _os_.unmarshal_int();
/* 43 */       ItemInfo _v_ = new ItemInfo();
/* 44 */       _v_.unmarshal(_os_);
/* 45 */       this.longjingitems.put(Integer.valueOf(_k_), _v_);
/*    */     }
/* 47 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 51 */     if (_o1_ == this) return true;
/* 52 */     if ((_o1_ instanceof LongJingInfo)) {
/* 53 */       LongJingInfo _o_ = (LongJingInfo)_o1_;
/* 54 */       if (!this.longjingitems.equals(_o_.longjingitems)) return false;
/* 55 */       return true;
/*    */     }
/* 57 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 61 */     int _h_ = 0;
/* 62 */     _h_ += this.longjingitems.hashCode();
/* 63 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 67 */     StringBuilder _sb_ = new StringBuilder();
/* 68 */     _sb_.append("(");
/* 69 */     _sb_.append(this.longjingitems).append(",");
/* 70 */     _sb_.append(")");
/* 71 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabao\LongJingInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */