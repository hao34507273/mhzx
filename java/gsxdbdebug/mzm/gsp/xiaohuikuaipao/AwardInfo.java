/*    */ package mzm.gsp.xiaohuikuaipao;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map.Entry;
/*    */ 
/*    */ public class AwardInfo implements Marshal
/*    */ {
/*    */   public HashMap<Integer, Integer> itemmap;
/*    */   
/*    */   public AwardInfo()
/*    */   {
/* 14 */     this.itemmap = new HashMap();
/*    */   }
/*    */   
/*    */   public AwardInfo(HashMap<Integer, Integer> _itemmap_) {
/* 18 */     this.itemmap = _itemmap_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 22 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 26 */     _os_.compact_uint32(this.itemmap.size());
/* 27 */     for (Map.Entry<Integer, Integer> _e_ : this.itemmap.entrySet()) {
/* 28 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 29 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*    */     }
/* 31 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 35 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 37 */       int _k_ = _os_.unmarshal_int();
/*    */       
/* 39 */       int _v_ = _os_.unmarshal_int();
/* 40 */       this.itemmap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*    */     }
/* 42 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 46 */     if (_o1_ == this) return true;
/* 47 */     if ((_o1_ instanceof AwardInfo)) {
/* 48 */       AwardInfo _o_ = (AwardInfo)_o1_;
/* 49 */       if (!this.itemmap.equals(_o_.itemmap)) return false;
/* 50 */       return true;
/*    */     }
/* 52 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 56 */     int _h_ = 0;
/* 57 */     _h_ += this.itemmap.hashCode();
/* 58 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 62 */     StringBuilder _sb_ = new StringBuilder();
/* 63 */     _sb_.append("(");
/* 64 */     _sb_.append(this.itemmap).append(",");
/* 65 */     _sb_.append(")");
/* 66 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\xiaohuikuaipao\AwardInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */