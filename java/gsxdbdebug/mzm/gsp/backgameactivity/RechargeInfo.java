/*    */ package mzm.gsp.backgameactivity;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map.Entry;
/*    */ 
/*    */ public class RechargeInfo implements Marshal
/*    */ {
/*    */   public long accumulaterechargecount;
/*    */   public HashMap<Integer, Integer> manekitokencfgid2count;
/*    */   
/*    */   public RechargeInfo()
/*    */   {
/* 15 */     this.manekitokencfgid2count = new HashMap();
/*    */   }
/*    */   
/*    */   public RechargeInfo(long _accumulaterechargecount_, HashMap<Integer, Integer> _manekitokencfgid2count_) {
/* 19 */     this.accumulaterechargecount = _accumulaterechargecount_;
/* 20 */     this.manekitokencfgid2count = _manekitokencfgid2count_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 24 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 28 */     _os_.marshal(this.accumulaterechargecount);
/* 29 */     _os_.compact_uint32(this.manekitokencfgid2count.size());
/* 30 */     for (Map.Entry<Integer, Integer> _e_ : this.manekitokencfgid2count.entrySet()) {
/* 31 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 32 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*    */     }
/* 34 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 38 */     this.accumulaterechargecount = _os_.unmarshal_long();
/* 39 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 41 */       int _k_ = _os_.unmarshal_int();
/*    */       
/* 43 */       int _v_ = _os_.unmarshal_int();
/* 44 */       this.manekitokencfgid2count.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*    */     }
/* 46 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 50 */     if (_o1_ == this) return true;
/* 51 */     if ((_o1_ instanceof RechargeInfo)) {
/* 52 */       RechargeInfo _o_ = (RechargeInfo)_o1_;
/* 53 */       if (this.accumulaterechargecount != _o_.accumulaterechargecount) return false;
/* 54 */       if (!this.manekitokencfgid2count.equals(_o_.manekitokencfgid2count)) return false;
/* 55 */       return true;
/*    */     }
/* 57 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 61 */     int _h_ = 0;
/* 62 */     _h_ += (int)this.accumulaterechargecount;
/* 63 */     _h_ += this.manekitokencfgid2count.hashCode();
/* 64 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 68 */     StringBuilder _sb_ = new StringBuilder();
/* 69 */     _sb_.append("(");
/* 70 */     _sb_.append(this.accumulaterechargecount).append(",");
/* 71 */     _sb_.append(this.manekitokencfgid2count).append(",");
/* 72 */     _sb_.append(")");
/* 73 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\backgameactivity\RechargeInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */