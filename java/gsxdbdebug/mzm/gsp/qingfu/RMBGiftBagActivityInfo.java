/*    */ package mzm.gsp.qingfu;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashMap;
/*    */ 
/*    */ public class RMBGiftBagActivityInfo implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public int opendays;
/*    */   public HashMap<Integer, RMBGiftBagTierInfo> tiers;
/*    */   
/*    */   public RMBGiftBagActivityInfo()
/*    */   {
/* 13 */     this.tiers = new HashMap();
/*    */   }
/*    */   
/*    */   public RMBGiftBagActivityInfo(int _opendays_, HashMap<Integer, RMBGiftBagTierInfo> _tiers_) {
/* 17 */     this.opendays = _opendays_;
/* 18 */     this.tiers = _tiers_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 22 */     for (java.util.Map.Entry<Integer, RMBGiftBagTierInfo> _e_ : this.tiers.entrySet()) {
/* 23 */       if (!((RMBGiftBagTierInfo)_e_.getValue())._validator_()) return false;
/*    */     }
/* 25 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 29 */     _os_.marshal(this.opendays);
/* 30 */     _os_.compact_uint32(this.tiers.size());
/* 31 */     for (java.util.Map.Entry<Integer, RMBGiftBagTierInfo> _e_ : this.tiers.entrySet()) {
/* 32 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 33 */       _os_.marshal((com.goldhuman.Common.Marshal.Marshal)_e_.getValue());
/*    */     }
/* 35 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 39 */     this.opendays = _os_.unmarshal_int();
/* 40 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 42 */       int _k_ = _os_.unmarshal_int();
/* 43 */       RMBGiftBagTierInfo _v_ = new RMBGiftBagTierInfo();
/* 44 */       _v_.unmarshal(_os_);
/* 45 */       this.tiers.put(Integer.valueOf(_k_), _v_);
/*    */     }
/* 47 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 51 */     if (_o1_ == this) return true;
/* 52 */     if ((_o1_ instanceof RMBGiftBagActivityInfo)) {
/* 53 */       RMBGiftBagActivityInfo _o_ = (RMBGiftBagActivityInfo)_o1_;
/* 54 */       if (this.opendays != _o_.opendays) return false;
/* 55 */       if (!this.tiers.equals(_o_.tiers)) return false;
/* 56 */       return true;
/*    */     }
/* 58 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 62 */     int _h_ = 0;
/* 63 */     _h_ += this.opendays;
/* 64 */     _h_ += this.tiers.hashCode();
/* 65 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 69 */     StringBuilder _sb_ = new StringBuilder();
/* 70 */     _sb_.append("(");
/* 71 */     _sb_.append(this.opendays).append(",");
/* 72 */     _sb_.append(this.tiers).append(",");
/* 73 */     _sb_.append(")");
/* 74 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\RMBGiftBagActivityInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */