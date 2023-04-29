/*    */ package mzm.gsp.activitypointexchange;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map.Entry;
/*    */ 
/*    */ public class ExchangeCountInfo implements Marshal
/*    */ {
/*    */   public HashMap<Integer, Integer> cfgid2available;
/*    */   public long exchangecountresettimestamp;
/*    */   
/*    */   public ExchangeCountInfo()
/*    */   {
/* 15 */     this.cfgid2available = new HashMap();
/*    */   }
/*    */   
/*    */   public ExchangeCountInfo(HashMap<Integer, Integer> _cfgid2available_, long _exchangecountresettimestamp_) {
/* 19 */     this.cfgid2available = _cfgid2available_;
/* 20 */     this.exchangecountresettimestamp = _exchangecountresettimestamp_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 24 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 28 */     _os_.compact_uint32(this.cfgid2available.size());
/* 29 */     for (Map.Entry<Integer, Integer> _e_ : this.cfgid2available.entrySet()) {
/* 30 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 31 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*    */     }
/* 33 */     _os_.marshal(this.exchangecountresettimestamp);
/* 34 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 38 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 40 */       int _k_ = _os_.unmarshal_int();
/*    */       
/* 42 */       int _v_ = _os_.unmarshal_int();
/* 43 */       this.cfgid2available.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*    */     }
/* 45 */     this.exchangecountresettimestamp = _os_.unmarshal_long();
/* 46 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 50 */     if (_o1_ == this) return true;
/* 51 */     if ((_o1_ instanceof ExchangeCountInfo)) {
/* 52 */       ExchangeCountInfo _o_ = (ExchangeCountInfo)_o1_;
/* 53 */       if (!this.cfgid2available.equals(_o_.cfgid2available)) return false;
/* 54 */       if (this.exchangecountresettimestamp != _o_.exchangecountresettimestamp) return false;
/* 55 */       return true;
/*    */     }
/* 57 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 61 */     int _h_ = 0;
/* 62 */     _h_ += this.cfgid2available.hashCode();
/* 63 */     _h_ += (int)this.exchangecountresettimestamp;
/* 64 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 68 */     StringBuilder _sb_ = new StringBuilder();
/* 69 */     _sb_.append("(");
/* 70 */     _sb_.append(this.cfgid2available).append(",");
/* 71 */     _sb_.append(this.exchangecountresettimestamp).append(",");
/* 72 */     _sb_.append(")");
/* 73 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activitypointexchange\ExchangeCountInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */