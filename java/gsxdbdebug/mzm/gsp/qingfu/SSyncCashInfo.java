/*    */ package mzm.gsp.qingfu;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map.Entry;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SSyncCashInfo
/*    */   extends __SSyncCashInfo__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12588805;
/*    */   public static final int SAVE_AMT = 1;
/*    */   public static final int TOTAL_CASH = 2;
/*    */   public static final int TOTAL_COST = 3;
/*    */   public static final int TOTAL_COST_BIND = 4;
/*    */   public static final int TOTAL_PRESENT = 5;
/*    */   public static final int TOTAL_PRESENT_BIND = 6;
/*    */   public HashMap<Integer, Long> infos;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12588805;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SSyncCashInfo()
/*    */   {
/* 40 */     this.infos = new HashMap();
/*    */   }
/*    */   
/*    */   public SSyncCashInfo(HashMap<Integer, Long> _infos_) {
/* 44 */     this.infos = _infos_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 48 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 52 */     _os_.compact_uint32(this.infos.size());
/* 53 */     for (Map.Entry<Integer, Long> _e_ : this.infos.entrySet()) {
/* 54 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 55 */       _os_.marshal(((Long)_e_.getValue()).longValue());
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 61 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 63 */       int _k_ = _os_.unmarshal_int();
/*    */       
/* 65 */       long _v_ = _os_.unmarshal_long();
/* 66 */       this.infos.put(Integer.valueOf(_k_), Long.valueOf(_v_));
/*    */     }
/* 68 */     if (!_validator_()) {
/* 69 */       throw new VerifyError("validator failed");
/*    */     }
/* 71 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 75 */     if (_o1_ == this) return true;
/* 76 */     if ((_o1_ instanceof SSyncCashInfo)) {
/* 77 */       SSyncCashInfo _o_ = (SSyncCashInfo)_o1_;
/* 78 */       if (!this.infos.equals(_o_.infos)) return false;
/* 79 */       return true;
/*    */     }
/* 81 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 85 */     int _h_ = 0;
/* 86 */     _h_ += this.infos.hashCode();
/* 87 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 91 */     StringBuilder _sb_ = new StringBuilder();
/* 92 */     _sb_.append("(");
/* 93 */     _sb_.append(this.infos).append(",");
/* 94 */     _sb_.append(")");
/* 95 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\SSyncCashInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */