/*    */ package mzm.gsp.exchange;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashMap;
/*    */ 
/*    */ public class ExchangeActivityInfo implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public HashMap<Integer, Integer> exchange_award_infos;
/*    */   
/*    */   public ExchangeActivityInfo()
/*    */   {
/* 12 */     this.exchange_award_infos = new HashMap();
/*    */   }
/*    */   
/*    */   public ExchangeActivityInfo(HashMap<Integer, Integer> _exchange_award_infos_) {
/* 16 */     this.exchange_award_infos = _exchange_award_infos_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 20 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 24 */     _os_.compact_uint32(this.exchange_award_infos.size());
/* 25 */     for (java.util.Map.Entry<Integer, Integer> _e_ : this.exchange_award_infos.entrySet()) {
/* 26 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 27 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*    */     }
/* 29 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 33 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 35 */       int _k_ = _os_.unmarshal_int();
/*    */       
/* 37 */       int _v_ = _os_.unmarshal_int();
/* 38 */       this.exchange_award_infos.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*    */     }
/* 40 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 44 */     if (_o1_ == this) return true;
/* 45 */     if ((_o1_ instanceof ExchangeActivityInfo)) {
/* 46 */       ExchangeActivityInfo _o_ = (ExchangeActivityInfo)_o1_;
/* 47 */       if (!this.exchange_award_infos.equals(_o_.exchange_award_infos)) return false;
/* 48 */       return true;
/*    */     }
/* 50 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 54 */     int _h_ = 0;
/* 55 */     _h_ += this.exchange_award_infos.hashCode();
/* 56 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 60 */     StringBuilder _sb_ = new StringBuilder();
/* 61 */     _sb_.append("(");
/* 62 */     _sb_.append(this.exchange_award_infos).append(",");
/* 63 */     _sb_.append(")");
/* 64 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\exchange\ExchangeActivityInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */