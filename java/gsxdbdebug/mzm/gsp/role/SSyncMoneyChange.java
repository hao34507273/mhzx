/*    */ package mzm.gsp.role;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map.Entry;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SSyncMoneyChange
/*    */   extends __SSyncMoneyChange__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12585995;
/*    */   public static final int MONEY_TYPE_GOLD = 0;
/*    */   public static final int MONEY_TYPE_SILVER = 1;
/*    */   public static final int MONEY_TYPE_GOLD_INGOT = 2;
/*    */   public HashMap<Integer, Long> changemoneymap;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12585995;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SSyncMoneyChange()
/*    */   {
/* 37 */     this.changemoneymap = new HashMap();
/*    */   }
/*    */   
/*    */   public SSyncMoneyChange(HashMap<Integer, Long> _changemoneymap_) {
/* 41 */     this.changemoneymap = _changemoneymap_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.compact_uint32(this.changemoneymap.size());
/* 50 */     for (Map.Entry<Integer, Long> _e_ : this.changemoneymap.entrySet()) {
/* 51 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 52 */       _os_.marshal(((Long)_e_.getValue()).longValue());
/*    */     }
/* 54 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 58 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 60 */       int _k_ = _os_.unmarshal_int();
/*    */       
/* 62 */       long _v_ = _os_.unmarshal_long();
/* 63 */       this.changemoneymap.put(Integer.valueOf(_k_), Long.valueOf(_v_));
/*    */     }
/* 65 */     if (!_validator_()) {
/* 66 */       throw new VerifyError("validator failed");
/*    */     }
/* 68 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 72 */     if (_o1_ == this) return true;
/* 73 */     if ((_o1_ instanceof SSyncMoneyChange)) {
/* 74 */       SSyncMoneyChange _o_ = (SSyncMoneyChange)_o1_;
/* 75 */       if (!this.changemoneymap.equals(_o_.changemoneymap)) return false;
/* 76 */       return true;
/*    */     }
/* 78 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 82 */     int _h_ = 0;
/* 83 */     _h_ += this.changemoneymap.hashCode();
/* 84 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 88 */     StringBuilder _sb_ = new StringBuilder();
/* 89 */     _sb_.append("(");
/* 90 */     _sb_.append(this.changemoneymap).append(",");
/* 91 */     _sb_.append(")");
/* 92 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\SSyncMoneyChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */