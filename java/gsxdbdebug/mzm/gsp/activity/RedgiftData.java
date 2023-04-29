/*    */ package mzm.gsp.activity;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map.Entry;
/*    */ 
/*    */ public class RedgiftData implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public static final int MONEY_TYPE_YUANBAO = 0;
/*    */   public static final int MONEY_TYPE_GOLD = 1;
/*    */   public static final int MONEY_TYPE_SILVER = 2;
/*    */   public HashMap<Integer, Integer> awardmoney;
/*    */   
/*    */   public RedgiftData()
/*    */   {
/* 16 */     this.awardmoney = new HashMap();
/*    */   }
/*    */   
/*    */   public RedgiftData(HashMap<Integer, Integer> _awardmoney_) {
/* 20 */     this.awardmoney = _awardmoney_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 24 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 28 */     _os_.compact_uint32(this.awardmoney.size());
/* 29 */     for (Map.Entry<Integer, Integer> _e_ : this.awardmoney.entrySet()) {
/* 30 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 31 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*    */     }
/* 33 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 37 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 39 */       int _k_ = _os_.unmarshal_int();
/*    */       
/* 41 */       int _v_ = _os_.unmarshal_int();
/* 42 */       this.awardmoney.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*    */     }
/* 44 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 48 */     if (_o1_ == this) return true;
/* 49 */     if ((_o1_ instanceof RedgiftData)) {
/* 50 */       RedgiftData _o_ = (RedgiftData)_o1_;
/* 51 */       if (!this.awardmoney.equals(_o_.awardmoney)) return false;
/* 52 */       return true;
/*    */     }
/* 54 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 58 */     int _h_ = 0;
/* 59 */     _h_ += this.awardmoney.hashCode();
/* 60 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 64 */     StringBuilder _sb_ = new StringBuilder();
/* 65 */     _sb_.append("(");
/* 66 */     _sb_.append(this.awardmoney).append(",");
/* 67 */     _sb_.append(")");
/* 68 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\RedgiftData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */