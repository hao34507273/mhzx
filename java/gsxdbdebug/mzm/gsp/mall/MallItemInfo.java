/*    */ package mzm.gsp.mall;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashMap;
/*    */ 
/*    */ public class MallItemInfo implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public int malltype;
/*    */   public HashMap<Integer, Integer> itemid2count;
/*    */   
/*    */   public MallItemInfo()
/*    */   {
/* 13 */     this.itemid2count = new HashMap();
/*    */   }
/*    */   
/*    */   public MallItemInfo(int _malltype_, HashMap<Integer, Integer> _itemid2count_) {
/* 17 */     this.malltype = _malltype_;
/* 18 */     this.itemid2count = _itemid2count_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 22 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 26 */     _os_.marshal(this.malltype);
/* 27 */     _os_.compact_uint32(this.itemid2count.size());
/* 28 */     for (java.util.Map.Entry<Integer, Integer> _e_ : this.itemid2count.entrySet()) {
/* 29 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 30 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*    */     }
/* 32 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 36 */     this.malltype = _os_.unmarshal_int();
/* 37 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 39 */       int _k_ = _os_.unmarshal_int();
/*    */       
/* 41 */       int _v_ = _os_.unmarshal_int();
/* 42 */       this.itemid2count.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*    */     }
/* 44 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 48 */     if (_o1_ == this) return true;
/* 49 */     if ((_o1_ instanceof MallItemInfo)) {
/* 50 */       MallItemInfo _o_ = (MallItemInfo)_o1_;
/* 51 */       if (this.malltype != _o_.malltype) return false;
/* 52 */       if (!this.itemid2count.equals(_o_.itemid2count)) return false;
/* 53 */       return true;
/*    */     }
/* 55 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 59 */     int _h_ = 0;
/* 60 */     _h_ += this.malltype;
/* 61 */     _h_ += this.itemid2count.hashCode();
/* 62 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 66 */     StringBuilder _sb_ = new StringBuilder();
/* 67 */     _sb_.append("(");
/* 68 */     _sb_.append(this.malltype).append(",");
/* 69 */     _sb_.append(this.itemid2count).append(",");
/* 70 */     _sb_.append(")");
/* 71 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mall\MallItemInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */