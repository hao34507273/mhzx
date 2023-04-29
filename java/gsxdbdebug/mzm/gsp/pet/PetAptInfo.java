/*    */ package mzm.gsp.pet;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map.Entry;
/*    */ 
/*    */ public class PetAptInfo implements Marshal
/*    */ {
/*    */   public HashMap<Integer, Integer> aptmap;
/*    */   public HashMap<Integer, Integer> aptlimitmap;
/*    */   
/*    */   public PetAptInfo()
/*    */   {
/* 15 */     this.aptmap = new HashMap();
/* 16 */     this.aptlimitmap = new HashMap();
/*    */   }
/*    */   
/*    */   public PetAptInfo(HashMap<Integer, Integer> _aptmap_, HashMap<Integer, Integer> _aptlimitmap_) {
/* 20 */     this.aptmap = _aptmap_;
/* 21 */     this.aptlimitmap = _aptlimitmap_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 25 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 29 */     _os_.compact_uint32(this.aptmap.size());
/* 30 */     for (Map.Entry<Integer, Integer> _e_ : this.aptmap.entrySet()) {
/* 31 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 32 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*    */     }
/* 34 */     _os_.compact_uint32(this.aptlimitmap.size());
/* 35 */     for (Map.Entry<Integer, Integer> _e_ : this.aptlimitmap.entrySet()) {
/* 36 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 37 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*    */     }
/* 39 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 43 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 45 */       int _k_ = _os_.unmarshal_int();
/*    */       
/* 47 */       int _v_ = _os_.unmarshal_int();
/* 48 */       this.aptmap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*    */     }
/* 50 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 52 */       int _k_ = _os_.unmarshal_int();
/*    */       
/* 54 */       int _v_ = _os_.unmarshal_int();
/* 55 */       this.aptlimitmap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof PetAptInfo)) {
/* 63 */       PetAptInfo _o_ = (PetAptInfo)_o1_;
/* 64 */       if (!this.aptmap.equals(_o_.aptmap)) return false;
/* 65 */       if (!this.aptlimitmap.equals(_o_.aptlimitmap)) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.aptmap.hashCode();
/* 74 */     _h_ += this.aptlimitmap.hashCode();
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.aptmap).append(",");
/* 82 */     _sb_.append(this.aptlimitmap).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\PetAptInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */